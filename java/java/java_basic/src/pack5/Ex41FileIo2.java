package pack5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

// 2 바이트 단위로 데이터에 대한 파일 입출력 - 문자열 (처리용한글 자료가 있을때 효과적)

public class Ex41FileIo2 {
	public void writeFile(File file, ArrayList<String> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for	(String ss:list) {
			writer.write(ss, 0, ss.length());
			writer.newLine();// 다음 행으로 라인스킵
		}
			writer.close(); // 코드를 입력하지 않으면 계속 공백으로 돌아감 오류 났던것
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("writeFile err : " + e.getMessage());
		}




	}

	public void readFile(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			// String ss = "kor" + "eng"; <==== 자바는 문자열 더하기 비권장 : 메모리 낭비가 심함
			StringBuffer buffer = new StringBuffer(); // 문자열 더하기를 효율적으로 하기 위한 객체
			//StringBuilder builder = new StringBuilder();
			
			String oneLine;
			while((oneLine = reader.readLine()) != null) {
				buffer.append(oneLine + "\n");
			}
			reader.close();
			System.out.println(buffer.toString()); // 버퍼에 누적된 문자열 출력
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("readFile err : " + e.getMessage());
		}

	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("후후후");
		list.add("good");

		File file = new File("c:/work/iotest4.txt");

		Ex41FileIo2 fileIo = new Ex41FileIo2();
		fileIo.writeFile(file, list);
		fileIo.readFile(file);

	}

}
