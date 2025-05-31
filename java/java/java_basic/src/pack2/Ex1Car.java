	package pack2;
	
	// 클래스 형식 : [접근지정자] class 클래스명 , 첫글자는 대문자로 시작해야함
	public class Ex1Car { // Car 객체(Object)를 생산하기 위한 설계도 : 클래스
		// 새로운 타입(type, 형)을 만들기 위함
		// field(필드,속성)과 행위 method(행위)를 멤버로 가질 수 있다.
		// 동일한 field와 method를 수행하는 객체의 집합을 설계
	
		int wheel;   // 멤버 필드 형식은 [접근지정자] type 필드명 (public, protected, default, private 4가지 종류)  int wheel =0; 같은 의미
		private int airBag = 1; // 캡슐화 : 멤버 접근지정가 private경우 (더 큰 개념은 은닉화)
		private int speed; // private int speed = 0;
		public String irum; // 어디서든 자유롭게 호출 영역 밖도 가능
	
		public Ex1Car() {  // 특별한 메소드(클래스와 메소드명이 일치) ==> 생성자(constructor) 한번만 호출됨
			System.out.println("객체 생성시 생성자가 가장 먼저 수행 : 초기화 담담");
			wheel = 4;
			irum = "그랜져"; // 오류 났던거 블로그에 적기
	
		}
	
		private void abc() { // 멤버 메소드. 형식은 [접근지정자] 반환형 메소드명(매개변수...) { }
			System.out.println("abc 메소드 실행");
		}
	
		void def() { // 메소드 수행 후 반환값이 돌아갈 경우 void
			System.out.println("def 메소드 실행");
			System.out.println("바퀴수는 " + wheel);
			System.out.println("에어백 수는 " + airBag); // private 필드이나 현재 클래스 내에서 호출 가능 
			abc(); // private 필드이나 현재 클래스 내에서 호출 가능 
		}
	
		public String driving() { // 메소드 수행 후 String 타입의 반환값이 있는 경우는 문자열을 반환
			System.out.println("운전하기");
			return "현재 고속도로를 달리는 중"; // 메소드 수행 후 값을 반환할 경우 return문을 사용
		}
	
		public int drivingStop() { // 메소드 수행 후 int 타입의 반환값이 있는 경우는 int를 반환
			System.out.println("운전 멈추기");
			return speed; // return 정수
		}
	
		// 참고 : 변수에 값을 저장하는 방법은 두가지.
		// 1) 변수 = 값 ex : a = 5
		// 2) 매개변수를 이용. ex : 메소드명(타입 매개변수){...} 하고 메소드명(값)
		public void drivingGood(int w) { // 매개변수가 있는 매소드(parameter)가 있는 매소드
			wheel = w;
			System.out.println(wheel + "개의 바퀴를 가진 이용 수단 사용");
		}
	}
	
	// 클래스를 공부하는 이유
	// 1) 직접 객체를 생성 후 사용하기 위함
	// 2) 다른삶이 만든 클래스를 활용하기 위함
