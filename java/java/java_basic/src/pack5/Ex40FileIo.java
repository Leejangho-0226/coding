package pack5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

// 1 바이트 단위로 데이터에 대한 파일 입출력 - 보통 클래스의 이름에 Stream이 포함됨.
// 문자, 그림, 미디어 등 다양한 종류의 데이터 처리가 가능
public class Ex40FileIo {
	public void writeFile(File file, ArrayList<String> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
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
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
			
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
		list.add("호호호");
		list.add("good");

		File file = new File("c:/work/iotest3.txt");

		Ex40FileIo fileIo = new Ex40FileIo();
		fileIo.writeFile(file, list);
		fileIo.readFile(file);

	}

}
