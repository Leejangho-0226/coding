package pack;

import java.util.Scanner;

public class Test6if {

	public static void main(String[] args) {
		// 조건 판단문 if
		System.out.println("뭔가를 수행 후 if문 만나기");
		int num = 7;

		if (num >= 5) {
			System.out.println("크구나"); // if문하고 상관 있음. 참 일때만 수행
			System.out.println("진짜로 크네");
		}

		System.out.println("계속1"); // if문하고 상관 없음.
		if(num >= 5) { // 조건이 true
			System.out.println("크구나");
			System.out.println("진짜로 크네");
		}else { // 조건이 false
			System.out.println("크지 않네");
		}

		System.out.println("계속2");
		int jumsu = 66; // final int jumsu = 40; 영원히일때, 기준점

		if(jumsu >= 70) {   // 다중 if 
			if(jumsu >= 90) {
				System.out.println("우수");
			}
			System.out.println("보통");
		}else { 
			if(jumsu >= 50) {
				System.out.println("저조");
			}else {
				System.out.println("매우 저조");
			}

		}

		System.out.println("계속3");
		int jumsu2 = 96; // 기준점 변경하면 결과가 달라짐
		String result = "";

		if(jumsu2 >= 90) {
			result = "수";
		}else if(jumsu2 >= 80) {
			result = "우";
		}else if(jumsu2 >= 70) {
			result = "미";
		}else if(jumsu2 >= 60) {
			result = "양";
		}else if(jumsu2 >= 50) { // if(jumsu2 < 50) 생략 권장
			result = "가";
		}
		System.out.println("평가 결과는 " +  result);

		System.out.println("계속4");
		// 어느 공원의 입장료가 8세 이하, 65세 이상인 경우 무료.
		// 9세 이상 20세 미안인 경우 3000원
		// 그 외는 5000원
		int age = 35;  // 기준점 변경하면 결과가 달라짐

		if(8 >= age || age >= 65) {
			System.out.println("무료");
		}
		if(9 <= age && age < 20) {
			System.out.println("3000원");
		}
		if(20 <= age && age < 65) {
			System.out.println("5000원");
		}

		int price = 0;
		if(9 <= age && age < 20) {
			price = 3000;
		}else if(20 <= age && age < 65) {
			price = 5000;
		}else {
			price = 0;
		}
		System.out.println("입장료는 " + price);

		System.out.println("야구장에 입장하기 : 로그인에 성공"); // ex)네이버 로그인 창
		String id = "kbs";
		String password = "ok1234";

		Scanner fact = new Scanner(System.in);
		System.out.print("id:");
		String inputId = fact.nextLine();
		System.out.print("pwd:");
		String inputpwd = fact.nextLine();
		
		//if(inputId == id && inputPwd == password) { // 기본형 비교
		if(inputId.equals(id) && inputpwd.equals(password)) {
		System.out.println("인증을 성공했으므로 야구를 즐기세요~");
		}else {
			System.out.println("누구셔");
		}







	}
}

