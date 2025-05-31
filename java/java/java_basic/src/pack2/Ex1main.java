package pack2;

public class Ex1main {  // Ex1main은 main 메소드를 실행하기 위한 클래스임.
	public static void main(String[] args) {
		// main 응용 프로그램의 시작을 위해 정해진 메소드이다.

		// Ex1Car 설계도로 객체를 생성. 이런 과정을 '객체를 인스턴스(instance)한다' 라고 함.
		// 다시말해 클래스로부터 객채를 만드는 과정을 클래스의 인스턴스화라고하며, 어떤 클래스로부터 만들어진 객체를 그 클래스의 인스턴스라고 한다.
		// 객체는 모든 인스턴스를 대표하는 포괄적인 의미이다.
		// 클래스 --> 인스턴스화(과정) --> 객체

		// Ex1Car.class를 주기억장치로 읽은 후 car1이란 객체변수를 선언.
		// new 키워드로 인스턴스를 진행. 이 때 Ex1Car()이라는 생성자를 호출.
		Ex1Car car1 = new Ex1Car();
		
		// ExCar 멤버필드(전역변수) 호출----
		System.out.println(car1.wheel);  // 접근지정자가 default이므로 호출 가능
		//System.out.println(car1.airBag); // private 멤버이므로 호출이 불가
		System.out.println(car1.irum);   // String irum; 'new = 변수'를 지정안해서 null이라고 표현 
		
		System.out.println();
		// ExCar 멤버 호출----
		// car1.abc(); // private 메소드이므로 호출 불가
		car1.def();
		
		System.out.println();
		//car1.driving();
		String ss = car1.driving();
		ss = "와우" + ss;
		System.out.println(ss);  // 문자열을 받고 변수에 담아놓고 찍어서 사용할 경우 밑에와 차이점 (블로그)
		
		System.out.println(car1.driving()); // 문자열을 받고 바로 찍고 종료하는 경우
		
		System.out.println();
		car1.drivingGood(2); // public void drivingGood(int w) 값을 을 입력하지 않으면 오류가 난다 (블로그) 
		                     // (2):인수, (int w):parameter,  argument(전달인자)
		
		System.out.println("\n====================================");
		Ex1Car car2 = new Ex1Car();  // 새로운 객체 생성
		// car1과 car2 type이 같은 두 개의 객체 변수
		System.out.println(car2.wheel);
		car2.def();

	}

}
