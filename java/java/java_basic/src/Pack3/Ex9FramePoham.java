package Pack3;

import java.awt.Frame;

public class Ex9FramePoham { // 인터넷 창만드는 연습
	String name = "신기해";
	private Frame frame; // 외부 클래스 사용
	
	public Ex9FramePoham( ) {
		frame = new Frame("포함 연습용"); // 클래스의 포함관계
		
		//frame.setSize(500, 300); // 너비와 높이 지정
		//frame.setLocation(200, 150);
		//frame.setVisible(true);
		
	}
	
	// 생성자는 초기화 및 전체 윤곽만 적고, 나머지(처리 로직)는 별도 메소드로 작성하는 것이 좋음
	public void frameVisible() { 
		frame.setSize(500, 300); // 너비와 높이 지정
		frame.setLocation(200, 150);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		//Ex9FramePoham framePoham = new Ex9FramePoham(); //창을 끝낼 방법이 없어서 버튼 눌러서 강제 종료해야함 whlie true문이랑 같음
		//new Ex9FramePoham(); // 객체변수가 굳이 필요하지 않음. 생성자에서 모든일이 처리되기 때문에
		
		//Ex9FramePoham framePoham = new Ex9FramePoham();
		//framePoham.frameVisible();
		
		//new Ex9FramePoham().frameVisible(); //위 두 줄을 한 줄로 표현
		
		

	}

}
