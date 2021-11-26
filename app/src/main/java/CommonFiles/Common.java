package CommonFiles;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;

import androidx.core.app.ShareCompat;

import com.account.bio.ObjectSerializer;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface Common {
     ArrayList<String> DataArrayLIst = new ArrayList<>();

     //FUNCTION FOR CREATING PDF TEMPLATE OF USER FILLED DATA
     static File pdfTemplate(Context c,ArrayList<String> grabbedDataArray){
         try {
             ContextWrapper cw = new ContextWrapper(c);
             File myDir = new File(Environment.getExternalStorageDirectory(),"BioAppFiles");
             String out = System.currentTimeMillis() + ".pdf";
             if (!myDir.exists()) {
                 myDir.mkdirs();
                 Toast.makeText(cw, "created 1", Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(cw, "1", Toast.LENGTH_SHORT).show();
             }
             File filepath = new File (myDir, out);
             PdfWriter writer= null;
             try {
                 writer = new  PdfWriter(filepath);
                 PdfDocument pdf = new PdfDocument(writer);
                 Document doc = new Document(pdf);
                 float [] pointColumnWidths = {150F, 150F, 150F};
                 Table table = new Table(pointColumnWidths);
                 table.addCell("sdvf");
                 table.addCell("Raju");
                 table.addCell("Id");
                 table.addCell("1001");
                 table.addCell("Designation");
                 table.addCell("Programmer");
                 doc.add(table);

                 doc.add(new Paragraph("Name              :"+grabbedDataArray.get(0)+""+""+grabbedDataArray.get(1)+"\n"));
                 doc.add(new Paragraph("Religion          :"+grabbedDataArray.get(2)+"\n"));
                 doc.add(new Paragraph("Language          :"+grabbedDataArray.get(3)+"\n"));
                 doc.add(new Paragraph("BirthDate         :"+grabbedDataArray.get(4)+"\n"));
                 doc.add(new Paragraph("BirthPlace        :"+grabbedDataArray.get(5)+"\n"));
                 doc.add(new Paragraph("Height            :"+grabbedDataArray.get(6)+"\n"));
                 doc.add(new Paragraph("Occupation        :"+grabbedDataArray.get(7)+"\n"));
                 doc.add(new Paragraph("Education         :"+grabbedDataArray.get(8)+"\n" ));
                 doc.add(new Paragraph("Father Name       :"+grabbedDataArray.get(9)+"\n"));
                 doc.add(new Paragraph("Father Occupation :"+grabbedDataArray.get(10)+"\n"));
                 doc.add(new Paragraph("Contact No        :"+grabbedDataArray.get(11)+"\n"));
                 doc.add(new Paragraph("Mother Name       :"+grabbedDataArray.get(12)+"\n"));
                 doc.add(new Paragraph("Number Of Sister  :"+grabbedDataArray.get(13)+"\n"));
                 doc.add(new Paragraph("Full Adderss      :"+grabbedDataArray.get(14)+"\n"));
                 doc.close();
                 writer.close();
                 return filepath;
             } catch ( Exception e) {
                 e.printStackTrace();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return new File("");
    }

     //LOADING DATA FROM INTERNAL STORAGE
     static ArrayList<String> load_Internal_Storage(Context context, String id) throws IOException {
          SharedPreferences pref = context.getSharedPreferences("com.account.marrige", Context.MODE_PRIVATE);
          return (ArrayList<String>) ObjectSerializer.deserialize(pref.getString(id,ObjectSerializer.serialize(new ArrayList<String>())));
     }
     //UPLOAD USER SHARED DATA IMAGES
      class Upload_user_shared_daTa extends AsyncTask<Void,Void,Void> {
          @Override
          protected Void doInBackground(Void... voids) {
               return null;
          }
     }
}
