import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class textFileReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String inputFileURL = "https://raw.githubusercontent.com/Mith2211/Ecommerce_app/refs/heads/main/Ecommerce_App/ExcelFiles/BookFile.txt";

		URL url = new URL(inputFileURL);

		InputStreamReader FileReader = new InputStreamReader(url.openStream());

		BufferedReader reader = new BufferedReader(FileReader);

		int totaltBooks = 0;
		int totalPages = 0;
		String line;
		reader.readLine();

		while ((line = reader.readLine()) != null) {
			String[] bookDetails = line.split(",");

			if (bookDetails.length == 3) {
				totaltBooks++;
				int pages = Integer.parseInt(bookDetails[2].trim());
				totalPages = totalPages + pages;

			}
		}

		reader.close();
		System.out.println("Total Books = "+totaltBooks);
		System.out.println("Total Pages = "+totalPages);
	}

}
