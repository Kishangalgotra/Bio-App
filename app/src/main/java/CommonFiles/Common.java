package CommonFiles;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import com.account.bio.ObjectSerializer;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;

/*import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;*/

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Common  {
     ArrayList<String> DataArrayLIst = new ArrayList<>();

     static File convertDoctopdf(Context c,ArrayList<String> grabbedDataArray){
         File filepath = null;

         return filepath;
     }

     static File htmlToPdf(Context c,ArrayList<String> grabbedDataArray){
         ContextWrapper cw = new ContextWrapper(c);
         String template =HtmlTemplates.rounhtmltemplate;
         String htmldf = "\n" +
                 "<html>\n" +
                 "  <head>\n" +
                 "  <style>\n" +
                 "   body {\n" +
                 "       background-color: #EBEBEB;\n" +
                 "    }\n" +
                 "\t\n" +
                 "    </style>\n" +
                 "\t<h2 class =\"header\">&Name&</h2>\n" +
                 "  </head>\n" +
                 "   <body >\n" +
                 "\t\t<p class=\"row\">Religion:&nbsp;&nbsp;&religion&</p>\n" +
                 "\t</div>\n" +
                 "  </body>\n" +
                 "</html>\n" +
                 "\n";
         String[] templatetags = HtmlTemplates.template1tags.split("#");
         int length =grabbedDataArray.size();
         int sd = templatetags.length;
         Log.i("Common pdf length","Hereasdaaaaaaaaaaaaaaaaaaa"+ length);
         Log.i("Common pdf sd","Hereasdaaaaaaaaaaaaaaaaaaa"+ sd);
         Log.i("Common pdf Grabbeddata","Hereasdaaaaa" + grabbedDataArray);
         Log.i("Common pdf templateTags","Hereasdaaaa" + Arrays.asList(templatetags));
         for(int i=0 ; i<length-1; i++) {
             template = template.replace(templatetags[i], grabbedDataArray.get(i));
             Log.i("Common pdf", "Hereasdaaaaaaaaaaaaaaaaaaa" + Integer.toString(i));
         }
         File filepath = null;
         try {
             File myDir = new File(Environment.getExternalStorageDirectory(), "BioAppFiles");
             String out = System.currentTimeMillis() + ".pdf";
             if (!myDir.exists()) {
                 myDir.mkdirs();
                 Toast.makeText(cw, "created 1", Toast.LENGTH_SHORT).show();
             } else {
                 Toast.makeText(cw, "1", Toast.LENGTH_SHORT).show();
             }
             filepath = new File(myDir, out);
             PdfWriter writer= null;
             writer = new PdfWriter(filepath);
            // PdfDocument pdf = new PdfDocument(writer);
             FileOutputStream outputStream = new FileOutputStream(filepath);
             Log.i("Common pdf", "template" + template);
             HtmlConverter.convertToPdf(template, writer);
             System.out.println("done");
             return filepath;
         }catch(Exception e) {
             e.printStackTrace();
         }
         return filepath;
     }

     //FUNCTION FOR CREATING PDF TEMPLATE OF USER FILLED DATA
     /*static File pdfTemplate(Context c,ArrayList<String> grabbedDataArray) throws DocumentException, FileNotFoundException {
         try {
             ContextWrapper cw = new ContextWrapper(c);
             File myDir = new File(Environment.getExternalStorageDirectory(), "BioAppFiles");
             String out = System.currentTimeMillis() + ".pdf";
             if (!myDir.exists()) {
                 myDir.mkdirs();
                 Toast.makeText(cw, "created 1", Toast.LENGTH_SHORT).show();
             } else {
                 Toast.makeText(cw, "1", Toast.LENGTH_SHORT).show();
             }
             File filepath = new File(myDir, out);
             String fg = filepath.getAbsolutePath();
             String dest = "C:/itextExamples/sample.pdf";
             // PdfWriter writer = new PdfWriter(dest);
             FileOutputStream outputStream = new FileOutputStream(filepath);
             Document document = new Document();
             PdfWriter pdf = PdfWriter.getInstance(document, outputStream);
             PdfPCell cell;
             Image imgReportLogo;

             BaseColor headColor = WebColors.getRGBColor("#DEDEDE");
             BaseColor tableHeadColor = WebColors.getRGBColor("#F5ABAB");
             //Open the document
             document.open();

             document.setPageSize(PageSize.A4);
             document.addCreationDate();
             document.addAuthor("AndroPDF");
             document.addCreator("http://chonchol.me");

             //Create Header table
             PdfPTable header = new PdfPTable(3);
             header.setWidthPercentage(100);
             float[] fl = new float[]{20, 45, 35};
             header.setWidths(fl);
             cell = new PdfPCell();
             cell.setBorder(Rectangle.NO_BORDER);

             //Set Logo in Header Cell
             Drawable logo = cw.getResources().getDrawable(android.R.mipmap.sym_def_app_icon);
             Bitmap bitmap = ((BitmapDrawable) logo).getBitmap();
             ByteArrayOutputStream stream = new ByteArrayOutputStream();
             bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
             byte[] bitmapLogo = stream.toByteArray();

                 imgReportLogo = Image.getInstance(bitmapLogo);
                 imgReportLogo.setAbsolutePosition(330f, 642f);

                 cell.addElement(imgReportLogo);
                 header.addCell(cell);

                 cell = new PdfPCell();
                 cell.setBorder(Rectangle.NO_BORDER);

                 // Heading
                 //BaseFont font = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);
                 Font titleFont = new Font(Font.FontFamily.COURIER, 22.0f, Font.BOLD, BaseColor.BLACK);

                 //Creating Chunk
                 Chunk titleChunk = new Chunk("Andro PDF", titleFont);
                 //Paragraph
                 Paragraph titleParagraph = new Paragraph(titleChunk);

                 cell.addElement(titleParagraph);
                 cell.addElement(new Paragraph("Simple PDF Report"));
                // cell.addElement(new Paragraph("Date: " + format.format(Calendar.getInstance().getTime())));
                 header.addCell(cell);

                 cell = new PdfPCell(new Paragraph(""));
                 cell.setBorder(Rectangle.NO_BORDER);
                 header.addCell(cell);

                 PdfPTable pTable = new PdfPTable(1);
                 pTable.setWidthPercentage(100);
                 cell = new PdfPCell();
                 cell.setColspan(1);
                 cell.addElement(header);
                 pTable.addCell(cell);

                 PdfPTable table = new PdfPTable(6);
                 float[] columnWidth = new float[]{6, 30, 30, 20, 20, 30};
                 table.setWidths(columnWidth);
                 cell = new PdfPCell();
                 cell.setBackgroundColor(headColor);
                 cell.setColspan(6);
                 cell.addElement(pTable);
                 table.addCell(cell);

                 cell = new PdfPCell(new Phrase(" "));
                 cell.setColspan(6);
                 table.addCell(cell);

                 cell = new PdfPCell();
                 cell.setColspan(6);
                 cell.setBackgroundColor(tableHeadColor);
                 cell = new PdfPCell(new Phrase("#"));
                 cell.setBackgroundColor(tableHeadColor);
                 table.addCell(cell);

                 cell = new PdfPCell(new Phrase("Header 1"));
                 cell.setBackgroundColor(tableHeadColor);
                 table.addCell(cell);

                 cell = new PdfPCell(new Phrase("Header 2"));
                 cell.setBackgroundColor(tableHeadColor);
                 table.addCell(cell);

                 cell = new PdfPCell(new Phrase("Header 3"));
                 cell.setBackgroundColor(tableHeadColor);
                 table.addCell(cell);

                 cell = new PdfPCell(new Phrase("Header 4"));
                 cell.setBackgroundColor(tableHeadColor);
                 table.addCell(cell);

                 cell = new PdfPCell(new Phrase("Header 5"));
                 cell.setBackgroundColor(tableHeadColor);
                 table.addCell(cell);

                 cell = new PdfPCell();
                 cell.setColspan(6);

                 for (int i = 1; i <= 10; i++) {
                     table.addCell(String.valueOf(i));
                     table.addCell("Header 1 row " + i);
                     table.addCell("Header 2 row " + i);
                     table.addCell("Header 3 row " + i);
                     table.addCell("Header 4 row " + i);
                     table.addCell("Header 5 row " + i);

                 }

                 PdfPTable ftable = new PdfPTable(6);
                 ftable.setWidthPercentage(100);
                 float[] columnWidtha = new float[]{30, 10, 30, 10, 30, 10};
                 ftable.setWidths(columnWidtha);

                 cell = new PdfPCell();
                 cell.setColspan(6);
                 cell.setBackgroundColor(tableHeadColor);
                 cell = new PdfPCell(new Phrase("Total Number"));
                 cell.setBorder(Rectangle.NO_BORDER);
                 cell.setBackgroundColor(tableHeadColor);
                 ftable.addCell(cell);

                 cell = new PdfPCell(new Phrase(""));
                 cell.setBorder(Rectangle.NO_BORDER);
                 cell.setBackgroundColor(tableHeadColor);
                 ftable.addCell(cell);

                 cell = new PdfPCell(new Phrase(""));
                 cell.setBorder(Rectangle.NO_BORDER);
                 cell.setBackgroundColor(tableHeadColor);
                 ftable.addCell(cell);

                 cell = new PdfPCell(new Phrase(""));
                 cell.setBorder(Rectangle.NO_BORDER);
                 cell.setBackgroundColor(tableHeadColor);
                 ftable.addCell(cell);

                 cell = new PdfPCell(new Phrase(""));
                 cell.setBorder(Rectangle.NO_BORDER);
                 cell.setBackgroundColor(tableHeadColor);
                 ftable.addCell(cell);

                 cell = new PdfPCell(new Phrase(""));
                 cell.setBorder(Rectangle.NO_BORDER);
                 cell.setBackgroundColor(tableHeadColor);
                 ftable.addCell(cell);

                 cell = new PdfPCell(new Paragraph("Footer"));
                 cell.setColspan(6);
                 cell.setBorder(Rectangle.NO_BORDER);
                 ftable.addCell(cell);

                 cell = new PdfPCell();
                 cell.setColspan(6);
                 cell.addElement(ftable);
                 table.addCell(cell);

                 document.add(table);
                 document.close();
             *//*PdfWriter writer= null;
             try {
                 writer = new  PdfWriter(filepath);
                 PdfDocument pdf = new PdfDocument(writer);
                 pdf.addEventHandler(PdfDocumentEvent.START_PAGE, new PageBackgroundsEvent());
                 Document doc = new Document(pdf);
                 Color myColor = new DeviceRgb(255, 100, 20);
                 Color bgColour2 = new DeviceRgb(255, 255, 255);
                 float [] pointColumnWidths = {150F, 150F, 150F};
                 Table table = new Table(pointColumnWidths);

                 Border border = new Border(bgColour2, 1) {
                     @Override
                     public void draw(PdfCanvas canvas, float x1, float y1, float x2, float y2, Side defaultSide, float borderWidthBefore, float borderWidthAfter) {

                     }

                     @Override
                     public void drawCellBorder(PdfCanvas canvas, float x1, float y1, float x2, float y2, Side defaultSide) {

                     }

                     @Override
                     public int getType() {
                         return 0;
                     }
                 };

                 Cell cell = new Cell();
                 cell.setBorder(border);

                 table.addCell("sdvf").setBorder(border).setStrokeColor(bgColour2);
                 table.addCell("Raju").setBorder(border);
                 table.addCell("Id").setBorder(border);
                 table.addCell("1001").setBorder(border);
                 table.addCell("Designation").setBorder(border);
                 table.addCell("Programmer").setBorder(border);
                 table.setBorder(border);
                 table.setStrokeColor(bgColour2);
                 doc.add(table);
                 //doc.setMarginMirroring(true);
                 doc.add(new Paragraph("Name              :"+grabbedDataArray.get(0)+""+""+grabbedDataArray.get(1)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("Religion          :"+grabbedDataArray.get(2)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("Language          :"+grabbedDataArray.get(3)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("BirthDate         :"+grabbedDataArray.get(4)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("BirthPlace        :"+grabbedDataArray.get(5)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("Height            :"+grabbedDataArray.get(6)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("Occupation        :"+grabbedDataArray.get(7)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("Education         :"+grabbedDataArray.get(8)+"\n" ).setFontColor(myColor));
                 doc.add(new Paragraph("Father Name       :"+grabbedDataArray.get(9)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("Father Occupation :"+grabbedDataArray.get(10)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("Contact No        :"+grabbedDataArray.get(11)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("Mother Name       :"+grabbedDataArray.get(12)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("Number Of Sister  :"+grabbedDataArray.get(13)+"\n").setFontColor(myColor));
                 doc.add(new Paragraph("Full Adderss      :"+grabbedDataArray.get(14)+"\n").setFontColor(myColor));
                 doc.setMargins(155, 155, 155, 155);

                 doc.close();
                 writer.close();*//*
                 return filepath;
             } catch (Exception e) {
                 e.printStackTrace();
             }
       *//*  } catch (Exception e) {
             e.printStackTrace();
         }*//*

         return new File("");
     }*/
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

    //Helper class so we can add colour to our pages when we call it from outer class
     // class PageBackgroundsEvent implements IEventHandler {
       /* @Override
        public void handleEvent(Event event) {
            PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
            PdfPage page = docEvent.getPage();

            PdfCanvas canvas = new PdfCanvas(page);
            Rectangle rect = page.getPageSize();
            //I used custom rgb for Color
            Color bgColour = new DeviceRgb(255, 204, 204);
            Color bgColour2 = new DeviceRgb(255, 255, 255);
            canvas  .saveState()
                    .setFillColor(bgColour2)
                    .setStrokeColor(bgColour)
                    .rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight())
                    .fillStroke()
                    .restoreState();
        }*/
   //}

     class Find_Replace_DOCX {

        public static void main(String args[]) throws IOException,
                org.apache.poi.openxml4j.exceptions.InvalidFormatException {
            try {

              //  *
                // * if uploaded doc then use HWPF else if uploaded Docx file use
                // *XWPFDocument

                XWPFDocument doc = new XWPFDocument(
                        OPCPackage.open("d:\\1\\rpt.docx"));
                for (XWPFParagraph p : doc.getParagraphs()) {
                    List<XWPFRun> runs = p.getRuns();
                    if (runs != null) {
                        for (XWPFRun r : runs) {
                            String text = r.getText(0);
                            if (text != null && text.contains("$$key$$")) {
                                text = text.replace("$$key$$", "ABCD");//your content
                                r.setText(text, 0);
                            }
                        }
                    }
                }

                for (XWPFTable tbl : doc.getTables()) {
                    for (XWPFTableRow row : tbl.getRows()) {
                        for (XWPFTableCell cell : row.getTableCells()) {
                            for (XWPFParagraph p : cell.getParagraphs()) {
                                for (XWPFRun r : p.getRuns()) {
                                    String text = r.getText(0);
                                    if (text != null && text.contains("$$key$$")) {
                                        text = text.replace("$$key$$", "abcd");
                                        r.setText(text, 0);
                                    }
                                }
                            }
                        }
                    }
                }

                doc.write(new FileOutputStream("d:\\1\\output.docx"));
            } finally {

            }

        }

    }
}
