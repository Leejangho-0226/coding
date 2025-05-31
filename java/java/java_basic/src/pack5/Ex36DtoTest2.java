package pack5;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex36DtoTest2 {
	private ArrayList<Ex36Studto> list = new ArrayList<Ex36Studto>();


	private String name;
	private int kor, eng, add;

	public void insertData() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("이름");
			name = sc.next();
			System.out.println("국어");
			kor = sc.nextInt();
			System.out.println("영어");
			eng = sc.nextInt();

			Ex36Studto dto = new Ex36Studto();
			dto.setName(name);
			dto.setKor(kor);
			dto.setEng(eng);
			list.add(dto); // 각 학생 정보 컬렉션에 저장


			System.out.print("계속 할까요?(y/n)");	
			String b = sc.next();
			if(!b.equals("y")) break;

		}
	}

	public void showData() {
		int count = 0;  // 인원수 출력용
		
		for(int i=0; i < list.size(); i++) {
			//Ex36StudDto dto = new Ex36StudDto();
			//dto = list.get(i);
			Ex36Studto dto = list.get(i);
			int tot = dto.getKor() + dto.getEng();
			System.out.println(dto.getName() + " " + 
					dto.getKor() + " " + 
					dto.getEng() + " " + tot);
			
			count += 1;
		}
		System.out.println("응시 인원:" + count);
		System.out.println("응시 인원:" + list.size());
	}



	public static void main(String[] args) {
		Ex36DtoTest2 test2 = new Ex36DtoTest2();
		test2.insertData();
		test2.showData();


	}

}
