package com.account.bio;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import CommonFiles.Common;

public class Adddatatotemplate extends Fragment {
    ImageView   imageView;
    TextView    BIO,name_,religion_,language_,birthdate_,birthplace_,height_,occupation_,education_,father_name_,father_occupation_,
                 contact_no_,mother_name_,number_of_sister_,full_adderss_ ;
    Button next;
    PDFView pdfview;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Adddatatotemplate() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Adddatatotemplate newInstance(String param1, String param2) {
        Adddatatotemplate fragment = new Adddatatotemplate();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.added_data_fragment, container, false);
        ArrayList<String> arrayList =null;
        BIO = v.findViewById(R.id.BIO_TEXT_);
        instantiate(v);
        try {
            arrayList = Common.load_Internal_Storage(Objects.requireNonNull(getContext()), "1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        fill_data(arrayList);
        Button next = v.findViewById(R.id.template_data_show_next);
        ArrayList<String> finalArrayList = arrayList;
        next.setOnClickListener(v1 -> {
         try {
             final Animation myAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.anim);
             next.startAnimation(myAnim);
             String str = new Gson().toJson(finalArrayList);
             Log.i("GSON ::",str);
             Bundle bundle = new Bundle();
             bundle.putString("UserData",str);

             Pdftemplate temp = new Pdftemplate();
             temp.setArguments(bundle);

             FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
             fragmentTransaction.replace(R.id.added_data_fragment, temp);

             fragmentTransaction.addToBackStack(null);
             fragmentTransaction.commit();
         }
         catch(Exception e){
             Log.i("Error",e.getMessage());
         }
     });
        return v;
    }

    public void instantiate(View v){
        name_ = v.findViewById(R.id.entered_name_);
        religion_ = v.findViewById(R.id.entered_religion_);
        language_ = v.findViewById(R.id.entered_lang_);
        birthdate_ = v.findViewById(R.id.entered_birthdate_);
        birthplace_ = v.findViewById(R.id.entered_birthplace_);
        height_ = v.findViewById(R.id.entered_height_);
        occupation_ = v.findViewById(R.id.entered_occupation_);
        education_ = v.findViewById(R.id.entered_education_);
        father_name_ = v.findViewById(R.id.entered_father_name_);
        father_occupation_ = v.findViewById(R.id.entered_father_occupation_);
        contact_no_ = v.findViewById(R.id.entered_contact_);
        mother_name_ = v.findViewById(R.id.entered_mother_name_);
        number_of_sister_ = v.findViewById(R.id.entered_no_of_sister_);
        full_adderss_ = v.findViewById(R.id.entered_full_address_);
        imageView = v.findViewById(R.id.template_image);
        next = v.findViewById(R.id.next_button);

    }
    private void fill_data(ArrayList<String> arrayList){
        //String name = arrayList.get(0) + arrayList.get(1);
        name_.setText(arrayList.get(0));
        religion_.setText(arrayList.get(1));
        language_.setText(arrayList.get(2));
        birthdate_.setText(arrayList.get(3));
        birthplace_.setText(arrayList.get(4));
        height_.setText(arrayList.get(5));
        occupation_.setText(arrayList.get(6));
        education_.setText(arrayList.get(7));
        father_name_.setText(arrayList.get(8));
        father_occupation_.setText(arrayList.get(9));
        contact_no_.setText(arrayList.get(10));
        mother_name_.setText(arrayList.get(11));
        number_of_sister_.setText(arrayList.get(12));
        full_adderss_.setText(arrayList.get(13));
        loadImageFromStorage(arrayList.get(14));
    }
    private void previewPdf(String pdfFile) {
        PackageManager packageManager = getContext().getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() > 0) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(new File(pdfFile));
            intent.setDataAndType(uri, "application/pdf");
            getContext().startActivity(intent);
        } else {
            Toast.makeText(getContext(), "Download a PDF Viewer to see the generated PDF", Toast.LENGTH_SHORT).show();
        }
    }
    private void loadImageFromStorage(String path) {
        try {
            File f   = new File(path);
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            imageView.setImageBitmap(b);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}