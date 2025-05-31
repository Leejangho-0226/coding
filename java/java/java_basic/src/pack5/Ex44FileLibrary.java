package pack5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import com.opencsv.CSVReader;

public class Ex44FileLibrary {

	public static void main(String[] args) {
		// data.go.kr이 제공하는 전국 도서관 정보 자료 읽기
		// CSVReader 클래스 사용
		// try(객체를 이 괄호 적으면 수행 후 객체 자동 close됨){}
		try(FileReader fr = new FileReader("c:/work/전국도서관.csv");
			CSVReader reader = new CSVReader(fr)) {
			String [] nextLine;
			int count = 0;

			while((nextLine = reader.readNext())!= null && count <=5) {
				if(nextLine.length < 5) continue;
				String s1 = nextLine[0];
				String s2 = nextLine[1];
				String s3 = nextLine[2];
				String s4 = nextLine[3];
				String s5 = nextLine[4];
				System.out.println(s1 + " " + s2 + " " + s3 +  " " + s4 + " " + s5);
				count++;
			}
			System.out.println("건수 : " + count);

		}catch (Exception e) {
			System.out.println("err : " + e);

		}

	}

}
