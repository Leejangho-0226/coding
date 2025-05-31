package pack4extends;

public final class Ex12Me extends Ex12Father{ // GrandFa 클래스로 한번에 못올라간다. me는 자식 클래스 생성 불가
	public Ex12Me() {
		System.out.println("내 생성자");
	}
	
	@Override
	public void say() {
		System.out.println("인생은 아름다워");
	}
	
	public final void Biking() { // me의 자식 클래스는 Biking() Override 불가
		System.out.println("자전거로 전국일주");
	
	}
	//public void Biking() { // me의 고유
		//System.out.println("자전거로 전국일주");

}

