	package pack2;
	
	public class Ex2main {
		public static void main(String[] args) {
			Ex2Programmer programmer1 = new Ex2Programmer();
			System.out.println("보유기술 : " + programmer1.spec);
			programmer1.displayData();
			
			programmer1.nickName ="웹 전문가";    // public 멤버필드이므로 외부에서 값을 수정
			programmer1.spec = "1종 보통 운전면허"; // default 멤버필드이므로 외부에서 값을 수정
			programmer1.displayData();
			
			// 캡슐화된 멤버를 해당 클래스 밖에서 제어하기 : getter
			//programmer1.age; // 에러 : 접근불가
			int nai = programmer1.getAge(); // public 메소드이므로 접근 가능
			System.out.println("Programmer1 객체의 age : " + nai);
			
			programmer1.setAge(31); // public 메소드 setter를 이용해 private 필드에 값을 전달
			System.out.println("programmer1 객체의 age : " + programmer1.getAge());
			programmer1.displayData();
			
			programmer1.setAgeEx(55, 555); // 참고
			
			System.out.println("static, final 관련 ----");
			System.out.println("motto : " + programmer1.motto);
			System.out.println("motto : " + Ex2Programmer.motto); // static 멤버는 클래스명.멤버 형태로 접근
			//programmer1.weight =  77.8; // 에러 : WEIGHT는 final이므로 수정 불가. 참조만 가능
			System.out.println("WEIGHT : " + programmer1.WEIGHT);
			System.out.println("PI : " + Ex2Programmer.PI);
			
			System.out.println("============================");
			Ex2Programmer programmer2 = new Ex2Programmer(); // 새로운 객체 생성
			programmer2.displayData();
			
			System.out.println("\n객체 변수가 창조하는 주소에 대해(참고)...");
			System.out.println(programmer1 + " " + programmer2);
			//pack2.Ex2Programmer@eed1f14 pack2.Ex2Programmer@7229724f
			System.out.println(programmer1.toString() + " " + programmer2.toString());
			System.out.println(programmer1.hashCode() + " " + programmer2.hashCode());
			
			System.out.println("--전문가가 만든 클래스 경험---------");
			System.out.println(Integer.MAX_VALUE);
			
		}
	}
