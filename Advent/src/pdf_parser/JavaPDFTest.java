package pdf_parser;

import java.io.IOException;

public class JavaPDFTest {

    public static void main(String[] args) throws IOException {

       PDFManager pdfManager = new PDFManager();
       pdfManager.setFilePath("C:\\Users\\Zachary R. Jones\\Desktop\\workspace\\Advent\\src\\pdf_parser\\Austin_menu_week9_25.pdf");
       System.out.println(pdfManager.ToText());       
    
}    
}