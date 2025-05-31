package pack;

import java.util.Scanner;

public class Test6ex {

	public static void main(String[] args) {
		// 키보드로 상품명(String sang), 수량(int su),단가(int dan)를 받아 아래와 같이 출력 
		//"상품명 마우스는 금액:5000원이고 세금은 500원"
		// 조건 금액(kum)은 수량 * 단가 세금은(sekum)은 금액이 5만원 이상이면 금액의 10%, 3만원 이상이면 금액의 5% 나머지는 3%를 적용

		Scanner sca = new Scanner(System.in);
		System.out.print("상품명:"); 
		String sang = sca.nextLine();
		System.out.print("수량:");
		int su = sca.nextInt();
		System.out.print("단가:");
		int dan = sca.nextInt();

		int kum = su*dan;
		double sekum = 0; // double sekum = 0.0;

		if(kum >= 50000) {
			sekum = kum*0.1;  // sekum = kum * 0.1;
		}else if(kum >= 30000) {
			sekum = kum*0.05; //sekum = kum  * 0.5;
		} else if(kum >=50000) {
			sekum = kum*0.03; //sekum = kum  * 0.3;
		}

		System.out.println("상품명 " + sang + "는 금액: " + 
				           kum + "원이고 세금은 " + sekum + "원입니다");
	}
}
