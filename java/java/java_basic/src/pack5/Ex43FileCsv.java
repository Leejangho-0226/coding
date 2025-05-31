package pack5;
import java.io.FileReader;

import com.opencsv.CSVReader;

public class Ex43FileCsv {

	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReader(new FileReader("c:/work/전국도서관.csv"));
		String[] nextLine;
		while((nextLine = reader.readNext())!= null) {
			for(int i=0; i < nextLine.length; i++) {
				System.out.println(i + " " + nextLine[i]);
			}
			System.out.println();
		}
		System.out.println("-----------------");
		CSVReader reader2 = new CSVReader(new FileReader("c:/work/전국도서관.csv"));
		String[] nextLine2;
		while((nextLine2 = reader2.readNext())!= null) {
			for(int i=0; i < nextLine2.length; i++) {
				System.out.println(String.join(",", nextLine2));
			}
			System.out.println();
		
	}
		
		reader.close();
		reader2.close();

}
}