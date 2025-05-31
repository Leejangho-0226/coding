package pack4extends;

public class Ex24FlyerMain {

	public static void main(String[] args) {
		// 인터페이스의 추상 메소드는 모두 오버라이딩 해야 함.
		System.out.println(Ex24Flyer.FAST);
//		Ex24Flyer.FAST = 150; // final 이라서 err
		
		Ex24FlyerBird bird = new Ex24FlyerBird();
		bird.fly();
		
		Ex24FlyAirplane airplane = new Ex24FlyAirplane();
		airplane.fly();

	}

}
