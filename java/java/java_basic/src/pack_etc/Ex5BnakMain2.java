package pack_etc;

import pack2.Ex5Bank; // 다른 패키지의 클래스를 읽으려면 import를 사용한다.
import pack2.*; // 비권장
import java.math.BigDecimal;
import java.lang.System; // java.lang 패키지의 import는 생략 가능.

public class Ex5BnakMain2 {

	public static void main(String[] args) {
		// Ex5Bank와 다른 패키지에서 Ex5Bank 클래스를 참조함
		Ex5Bank bank1 = new Ex5Bank();
		//System.out.println(bank1.money); // private 멤버 접근 불가
		//System.out.println(bank1.imsi);	 // default 수준 이므로 멤버 접근 가능, pack이 이동하면 사용 불가
		System.out.println(bank1.imsi2); // public 수준 이므로 멤버 접근 가능
		
		System.out.println(BigDecimal.ONE); // 전문가가 만든 클래스 참조시 import 필요

	}

}
