package com.account.bio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Fillbiodata extends AppCompatActivity  implements View.OnClickListener{
  String id ="1";
  EditText fist_name,last_name,religion,language,birthdate,birthplace,height,occupation,education,father_name,father_occupation,
           contact_no,mother_name,number_of_sister,full_adderss ;
  Button next;
  ImageView image;
  private Uri imageuri;
  int a = 0;
  private ProgressBar progressbar;
  private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        instantiate();
        fill_data_auto();
        next.setOnClickListener(this);
        image.setOnClickListener(this);
    }

    //Filling Data
    public  void fill_data_auto(){
        fist_name.setText("Kishan");
        last_name.setText("Kumar");
        religion.setText("Hindu");
        language.setText("Punjabi");
        birthdate.setText("16-11-2021");
        birthplace.setText("Ludhiana");
        height.setText("5.9feet");
        occupation.setText("Engineer");
        education.setText("Btech");
        father_name.setText("Somnath");
        father_occupation.setText("Businessman");
        contact_no.setText("9914916600");
        mother_name.setText("Shanta Rani");
        number_of_sister.setText("1");
        full_adderss.setText("new Moti Nagar");

    }
    //VALIDATING FIELDS DATA
    public boolean validate(){
       if(fist_name.getText().toString().isEmpty()){
            fist_name.setError("please Fill First Name");
            fist_name.requestFocus();
            return false;
        }
         if(last_name.getText().toString().isEmpty()){
            last_name.setError("please Fill Last Name");
            last_name.requestFocus();
            return false;
        }
         if(religion.getText().toString().isEmpty()){
            religion.setError("please Fill Religion");
            religion.requestFocus();
            return false;
        }
         if(language.getText().toString().isEmpty()){
            language.setError("please Fill Language");
            language.requestFocus();
            return false;
        }
        if(birthdate.getText().toString().isEmpty()){
            birthdate.setError("please Fill Birth Date");
            birthdate.requestFocus();
            return false;
        } if(birthplace.getText().toString().isEmpty()){
            birthplace.setError("please Fill Birth Place");
            birthplace.requestFocus();
            return false;
        } if(height.getText().toString().isEmpty()){
            height.setError("please Fill Height");
            height.requestFocus();
            return false;
        } if(occupation.getText().toString().isEmpty()){
            occupation.setError("please Fill Your Occupation");
            occupation.requestFocus();
            return false;
        } if(education.getText().toString().isEmpty()){
            education.setError("please Fill Education");
            education.requestFocus();
            return false;
        } if(father_name.getText().toString().isEmpty()){
            father_name.setError("please Fill Father Name");
            father_name.requestFocus();
            return false;
        } if(father_occupation.getText().toString().isEmpty()){
            father_occupation.setError("please Fill Father Occupation");
            father_occupation.requestFocus();
            return false;
        } if(contact_no.getText().toString().isEmpty()){
            contact_no.setError("please Fill Contact Details");
            contact_no.requestFocus();
            return false;
        } if(mother_name.getText().toString().isEmpty()){
            mother_name.setError("please Fill Mother Name");
            mother_name.requestFocus();
            return false;
        } if(number_of_sister.getText().toString().isEmpty()){
            number_of_sister.setError("please Fill this Field");
            number_of_sister.requestFocus();
            return false;
        } if(full_adderss.getText().toString().isEmpty()){
            full_adderss.setError("please Fill Address");
            full_adderss.requestFocus();
            return false;
        }
        return true;
    }
    //INSTANTIATE ALL THE COMPONENTS OF XML FILE HERE
    public void instantiate(){
        fist_name = findViewById(R.id.view_add_first_name);
        last_name = findViewById(R.id.view_add_last_name);
        religion = findViewById(R.id.view_add_religion);
        language = findViewById(R.id.view_add_lang);
        birthdate = findViewById(R.id.view_add_birthdate);
        birthplace = findViewById(R.id.view_add_birthplace);
        height = findViewById(R.id.view_add_height);
        occupation = findViewById(R.id.view_add_occupation);
        education = findViewById(R.id.view_add_education);
        father_name = findViewById(R.id.view_add_father_name);
        father_occupation = findViewById(R.id.view_add_father_occupation);
        contact_no = findViewById(R.id.view_add_contact);
        mother_name = findViewById(R.id.view_add_mother_name);
        number_of_sister = findViewById(R.id.view_add_no_of_sister);
        full_adderss = findViewById(R.id.view_add_full_address);
        next = findViewById(R.id.next_button);
        image = findViewById(R.id.add_image);
        progressbar = findViewById(R.id.progressBar_id);
        progressbar.setVisibility(View.INVISIBLE);
         // progressbar.getProgressDrawable().setColorFilter(
         //     Color.RED, android.graphics.PorterDuff.Mode.);
    }
    //CLICK EVENTS OF ALL BUTTON OF THIS ACTIVITY
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.add_image :
                openImage();
                break;

            case R.id.next_button :
                /*if(validate()){ // Validating All fields Data

                    //Execution Code for Filled Data
                    Intent intent = new Intent(getApplicationContext(),template.class);
                    startActivity(intent);
                }*/
                try {
                    final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.anim);
                    next.startAnimation(myAnim);
                    progressbar.setVisibility(View.VISIBLE);
                    next.setEnabled(false);
                    //a = progressbar.getProgress();
                    new Thread(() -> {
                             try {
                                  if( Add_to_Memory()){
                                        //Fragment temp =null;
                                      try {
                                          Adddatatotemplate temp = new Adddatatotemplate();
                                          FragmentManager fragmentManager =getSupportFragmentManager();
                                          fragmentManager.beginTransaction().add(R.id.add_data_layout,temp).commit();
                                          progressbar.setVisibility(View.INVISIBLE);
                                      } catch (Exception e) {
                                          e.printStackTrace();
                                      }
                                  }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            try {// Sleep for 50 ms to show progress you can change it as well.
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    }).start();
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    // FOR Opening Image Gallery
    public void openImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 2);
    }
    //RESULT PASSED BY ACTIVITY RESULT TO USER PROFILE
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            imageuri = data.getData();
            Log.i("onActivityResult", "1");
            image.setImageURI(imageuri);
            Log.i("onActivityResult", "2");
        } else {
            Log.i("onActivityResult", "cancelled");
        }
    }
    //ADDING DATA TO MEMORY
    public boolean Add_to_Memory() throws IOException {
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.account.marrige", Context.MODE_PRIVATE);
            ArrayList<String> data = new ArrayList<>();
            data.add(fist_name.getText().toString());
            data.add(last_name.getText().toString());
            data.add(religion.getText().toString());
            data.add(language.getText().toString());
            data.add(birthdate.getText().toString());
            data.add(birthplace.getText().toString());
            data.add(height.getText().toString());
            data.add(occupation.getText().toString());
            data.add(education.getText().toString());
            data.add(father_name.getText().toString());
            data.add(father_occupation.getText().toString());
            data.add(contact_no.getText().toString());
            data.add(mother_name.getText().toString());
            data.add(number_of_sister.getText().toString());
            data.add(full_adderss.getText().toString());
            Bitmap bitmap ;
            try{
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageuri);
                data.add(saveToInternalStorage(bitmap));
            }catch(Exception e){
                bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.passport_template);
                data.add(saveToInternalStorage(bitmap));
                Log.i("Exception",e.getMessage().toString());
            }
            try {
                sharedPreferences.edit().putString(id, ObjectSerializer.serialize(data)).apply(); //ObjectSerializer.serialize()'
                Log.i("1",ObjectSerializer.serialize(data));
                return true;
            }catch(Exception e){
                Log.i("message","Error");
                return false;
            }
    }
    // method for base64 to bitmap
    public static Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }
    // method for bitmap to base64
    public static String encodeTobase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }
    //FOR STORING IMAGES INTO INRERNAL STORAGE
    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        String out = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.pdf'").format(new Date());
        File mypath=new File(directory,out+"profile.jpg");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mypath.getAbsolutePath();
    }


}