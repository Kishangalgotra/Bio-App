package com.account.bio;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.gson.Gson;


import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class pdf_template extends Fragment {

    ArrayList<String> grabbedDataArray = new ArrayList<>();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button next ;
    private String stringFile = Environment.getExternalStorageDirectory().getPath() + File.separator + "Test.pdf";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public pdf_template() {
        // Required empty public constructor
    }

    public static pdf_template newInstance(String param1, String param2) {
        pdf_template fragment = new pdf_template();
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
        Button download_pdf = v.findViewById(R.id.download_pdf);
        next = v.findViewById(R.id.fragment_pdf_template);
        Log.i("Step ::","1");
        next.setOnClickListener(v1 -> getActivity().onBackPressed());
        String grabbeddataString=getArguments().getString("UserData");
        Log.i("Step ::","2"+grabbeddataString);
        assert grabbeddataString != null;
        Log.i("Passed Data::",grabbeddataString);
        grabbedDataArray = new Gson().fromJson(grabbeddataString,ArrayList.class);
        Log.i("ArrayList", grabbedDataArray.toArray().toString());
        File path = Common.pdfTemplate(getContext(),grabbedDataArray);
        PDFView pdfView = v.findViewById(R.id.pdfview);
        pdfView.fromFile(new File(path.getAbsolutePath())).load();
        pdfView.fitToWidth();
        pdfView.computeScroll();
        pdfView.documentFitsView();
        download_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Common.Share(getContext(),path.getAbsolutePath());
            }
        });

        ActivityCompat.requestPermissions(Objects.requireNonNull(getActivity()), new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        return v;
    }

    //FOR SHRING FILE
    public void buttonShareFile(View view){
        File file = new File(stringFile);
        if (!file.exists()){
           // Toast.makeText(this, "File doesn't exists", Toast.LENGTH_LONG).show();
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