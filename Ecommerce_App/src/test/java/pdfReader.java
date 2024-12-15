
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class pdfReader {
    public static void main(String[] args) {
        // Specify the path to the PDF file
        String filePath = "C:\\Users\\Mithilesh\\Downloads\\Ecommerce_App\\Ecommerce_App\\ExcelFiles\\Sep24_Payslip.pdf";

        // Open and read the PDF file
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            // Check if the PDF is encrypted
            if (!document.isEncrypted()) {
                // Extract text from the PDF
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String pdfContent = pdfStripper.getText(document);
                System.out.println("PDF Content:");
                System.out.println(pdfContent);
            } else {
                System.out.println("The PDF is encrypted and cannot be read.");
            }
        } catch (IOException e) {
            System.err.println("Error while reading the PDF file: " + e.getMessage());
        }
    }
}

