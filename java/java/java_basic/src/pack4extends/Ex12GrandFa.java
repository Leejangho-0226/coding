package pack4extends;

public class Ex12GrandFa {
	private int nai = 70;
	public String gabo = "상감청자";
	protected String gahun = "착하게 살자"; // 자식을 가질거라는 뜻, public과 마찬가지로 다른 pack에서도 이용가능
	
	public Ex12GrandFa() {
		System.out.println("할아버지 생성자");
	}

	public Ex12GrandFa(int nai) {
		this(); // 먼저 나와야함
		this.nai = nai;
	}
	
	public void say() {
		System.out.println("할아버지 말씀: 자바에 집중해라");
	}
	
	
	public void eat() {
		System.out.println("밥은 맛있게...");
	}
	
	public int getNai() {
		return nai;
	}
	
}
