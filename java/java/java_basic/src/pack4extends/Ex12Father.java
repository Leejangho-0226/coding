package pack4extends;

public class Ex12Father extends Ex12GrandFa{
	private int nai = 50;
	public String gabo = "고려청자";
	private int house = 1; // Father의 고유멤버
	
	
	
	public Ex12Father() {
		super(); // 부모 생성자 호출
		System.out.println("아버지 생성자");
	}
	
	
	 @Override // annotation (뭔가를 처리하는 기능)
	           // 메소드 오버라이딩: 부모와 똑같은 메소드를 자식에서 만듦. 내용은 되게 다르게 적기.
	public int getNai() {
		int imsi = 0; // 부모와 다른 코드를 적을 수 있다. 재정의
		return nai;
	}
	
	@Override
	public void say() {
		// public final void say()
		System.out.println("아버지 말씀: 풀스택 개발자로 고~");
		//String ss = "아버지 말씀: 풀스택 개발자로 고~";
		//System.out.println(ss); // 위와 출력했을 때 내용이 같음
	}
	
	public int getHouse() { // father의 고유 메소드 father만 가지고 있으니 오버라이딩 불가
		return house;
	}
	
	public void showDate() {
		String gabo = "맥북";
		System.out.println(gabo); // 지역
		System.out.println(this.gabo); // 현재 클래스
		System.out.println(super.gabo); // 부모 클래스
		
		say();
		this.say();
		super.say();
	}

}
