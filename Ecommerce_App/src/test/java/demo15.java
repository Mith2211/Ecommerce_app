

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class demo15 {

    public static void main(String[] args) {
        // URL of the text file
        String fileUrl = "https://raw.githubusercontent.com/Mith2211/Ecommerce_app/refs/heads/main/Ecommerce_App/ExcelFiles/BookFile.txt"; // Replace with the actual URL

        int totalBooks = 0;
        int totalPages = 0;

        try {
            // Open the URL and create a BufferedReader to read the file
            URL url = new URL(fileUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            reader.readLine(); // this is to skip first header line in the text file 

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Assuming the format: BookID, BookName, PageCount (comma-separated)
                String[] bookDetails = line.split(",");

                if (bookDetails.length == 3) {
                    totalBooks++;
                    try {
                        // Add the page count to the totalPages
                        int pages = Integer.parseInt(bookDetails[2].trim());
                        totalPages += pages;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid page count for book: " + bookDetails[1]);
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }

            reader.close();

            // Output the results
            System.out.println("Total Number of Books: " + totalBooks);
            System.out.println("Total Number of Pages: " + totalPages);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
