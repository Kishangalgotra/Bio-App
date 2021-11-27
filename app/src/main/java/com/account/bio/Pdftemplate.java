package com.account.bio;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Objects;

import CommonFiles.Common;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Pdftemplate extends Fragment {

    ArrayList<String> grabbedDataArray = new ArrayList<>();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button downloadPdf;
    private String stringFile = Environment.getExternalStorageDirectory().getPath() + File.separator + "Test.pdf";
    private String mParam1;
    private String mParam2;
    ImageView bird;
    Button SaveImg;
    OutputStream outputStream;
    private static int REQUEST_CODE = 100;
    ProgressDialog progressDialog;

    public Pdftemplate() {
    }

    public static Pdftemplate newInstance(String param1, String param2) {
        Pdftemplate fragment = new Pdftemplate();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pdf_template, container, false);
        try {
            Button sharePdf = v.findViewById(R.id.sharePdf);
            downloadPdf = v.findViewById(R.id.downloadpdf);
            Log.i("Step ::","1");
            downloadPdf.setOnClickListener(v1 -> getActivity().onBackPressed());
            String grabbeddataString=getArguments().getString("UserData");
            Log.i("Step ::","2"+grabbeddataString);
            assert grabbeddataString != null;
            Log.i("Passed Data::",grabbeddataString);
            grabbedDataArray = new Gson().fromJson(grabbeddataString,ArrayList.class);
            Log.i("ArrayList", grabbedDataArray.toArray().toString());
            File path = new File("");//= Common.pdfTemplate(getContext(),grabbedDataArray);

            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Creating Pdf...");

            if(ActivityCompat.checkSelfPermission(getContext()
            , Manifest.permission.WRITE_EXTERNAL_STORAGE )== PackageManager.PERMISSION_GRANTED){
                progressDialog.show();
                path = Common.pdfTemplate(getContext(),grabbedDataArray);
                PDFView pdfView = v.findViewById(R.id.pdfview);
                pdfView.fromFile(new File(path.getAbsolutePath())).load();
                pdfView.fitToWidth();
                pdfView.computeScroll();
                pdfView.documentFitsView();
                progressDialog.cancel();
            }
            File finalPath = path;
            sharePdf.setOnClickListener(v12 -> {
                try {
                    File filepath2 = new File(finalPath.getAbsoluteFile().getPath());
                    Uri uri = Uri.fromFile(filepath2);
                    Intent intent = ShareCompat.IntentBuilder.from((Activity) getContext())
                            .setType("application/*")
                            .setStream(uri)
                            .setChooserTitle("Choose bar")
                            .createChooserIntent()
                            .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            ActivityCompat.requestPermissions(Objects.requireNonNull(getActivity()), new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        } catch (JsonSyntaxException e ) {
            e.printStackTrace();
        } catch( Exception e){
            e.printStackTrace();
        }
        return v;
    }

    private void askPermission() {
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        if (requestCode == REQUEST_CODE)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                saveImage();
            }else {
                Toast.makeText(getActivity(),"Please provide the required permissions",Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void saveImage() {
        File dir = new File(Environment.getExternalStorageDirectory(),"SaveImage");
        if (!dir.exists()){
            dir.mkdir();
        }
        BitmapDrawable drawable = (BitmapDrawable) bird.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        File file = new File(dir,System.currentTimeMillis()+".jpg");
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
        Toast.makeText(getActivity(),"Successfully Saved",Toast.LENGTH_SHORT).show();
        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //FOR SHARING FILE
    public void buttonShareFile(View view){
        File file = new File(stringFile);
        if (!file.exists()){
            return;
        }
        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.setType("application/pdf");
        intentShare.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://"+file));
        startActivity(Intent.createChooser(intentShare, "Share the file ..."));
    }

    //FOR SHARING TEXT
    public void buttonShareText(View view){
        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.setType("text/plain");
        intentShare.putExtra(Intent.EXTRA_SUBJECT,"My Subject Here ... ");
        intentShare.putExtra(Intent.EXTRA_TEXT,"My Text of the message goes here ... write anything what you want");
        startActivity(Intent.createChooser(intentShare, "Shared the text ..."));
    }
}