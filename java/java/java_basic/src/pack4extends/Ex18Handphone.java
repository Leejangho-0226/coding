package pack4extends;

public class Ex18Handphone extends Ex18Jepum{
	@Override
	void volumeControl() {
		System.out.println("핸드폰 제품의 볼륨 변경");
		
	}
	
	@Override
	public void volumeShow() {
		// 부모의 일반 메소드는 오버라이딩은 선택적이다.
		volume = 10;
		System.out.println("볼륨 크기 : " + volume);
	}

}
