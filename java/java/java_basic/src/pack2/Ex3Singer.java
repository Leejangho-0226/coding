package pack2;

public class Ex3Singer {
	
	private String name = "무명 가수"; // 멤버 필드
	private String titleSong = "트로트";
	
	public Ex3Singer(String name, String title) {// 생성자
		this.name = name;
		titleSong = title;
		
	}
	
	public void sing() { // 메서드
		String name = "아이유"; //지역변수
		System.out.println(this.name + "의 노래 제목은 " + titleSong); //무명가수의 노래 제목은 트로트
		//System.out.println(name + "의 노래 제목은 " + titleSong); // 아이유의 노래 제목은 트로트
	}
	
	public void setTitleSong(String titleSong) {
		this.titleSong = titleSong;
	}
	
	public static void main(String[] args) { // main 응용프로그램, setter
		Ex3Singer bts = new Ex3Singer("BTS", "다이너마이트");
		bts.sing();
		bts.setTitleSong("BTS 만만세");
		bts.sing();
		bts.setTitleSong("야호");
		bts.sing();
		
		System.out.println();
		Ex3Singer blackpink = new Ex3Singer("블랙핑크", "fire");
		blackpink.sing();

	}

}
