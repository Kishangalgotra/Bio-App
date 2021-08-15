package com.account.bio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class view_biodata_Fragment extends Fragment {

    String [] name    = {"Kishan","Karan","Pardeep","Monga"};
    String [] phone   = {"4231324231","2342341","534234534","756432245342"};
    String [] address = {"wejfjenwe","fwbefbh","fwefwe","fwefwe"};
    int image[]       = {R.drawable.face1,R.drawable.face2,R.drawable.face3,R.drawable.face4};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public view_biodata_Fragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static view_biodata_Fragment newInstance(String param1, String param2) {
        view_biodata_Fragment fragment = new view_biodata_Fragment();
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
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_view_biodata_, container, false);
        ListView listview = v.findViewById(R.id.view_bio_list_view);
        Viewmodel  viewmodelobject = new Viewmodel(v.getContext(), name, phone, address,image);
        listview.setAdapter(viewmodelobject);
        //on item click
        listview.setOnItemClickListener((parent, view, position, id) -> {

        });
        return v;
    }

    static class Viewmodel extends ArrayAdapter<String> {
        String[] name;
        String[] phone;
        String[] address;
        int[] rimage;
        Context context;

         Viewmodel(@NonNull Context context, String[] name, String[] phone, String[] address ,int[] image) {
            super(context, R.layout.view_data_model,R.id.view_biodata_name,name);
            this.context = context;
            this.name = name;
            this.address = address;
            this.phone  = phone;
            this.rimage = image;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
             LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             @SuppressLint("ViewHolder")
             View row = layoutInflater.inflate(R.layout.view_data_model,parent,false);
                ImageView imageView = row.findViewById(R.id.view_biodata_image);
                TextView textviewname = row.findViewById(R.id.view_biodata_name);
                TextView textviewphone = row.findViewById(R.id.view_biodata_phone);
                TextView textviewaddress = row.findViewById(R.id.view_biodata_address);
                imageView.setImageResource(rimage[position]);
                textviewname.setText(name[position]);
                textviewphone.setText(phone[position]);
                textviewaddress.setText(address[position]);
             return row;
        }

        class ViewHolder{
            TextView likes;
            TextView desc;
            ImageView img;
            ViewHolder(View v){
                likes = v.findViewById(R.id.view_biodata_name);
                desc  = v.findViewById(R.id.view_biodata_phone);
                img   = v.findViewById(R.id.view_biodata_address);
            }
        }
    }
}