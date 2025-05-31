package pack4extends;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex28FrameInnerClass extends Frame{
	int x, y;

	public Ex28FrameInnerClass() {
		setTitle("내부 클래스 사용");
		setSize(400, 300);
		setLocation(200, 200);
		setVisible(true);

		//Wevent wevent = new Wevent();
		//addWindowListener(Wevent);
		addWindowListener(new Wevent());
		addMouseListener(new Mevent());
	}

	class Wevent extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) { // 내부 클래스
			System.exit(0);
		}
	}

	class Mevent extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			//setBackground(new Color(255, 255, 0)); // 클릭시 색깔 출력
			// int r = (int)(Math.random() * 255);
			// int g = (int)(Math.random() * 255);
			// int b = (int)(Math.random() * 255);
			// setBackground(new Color(r, g, b)); // 클릭할때 마다 색깔 바뀌며 출력
			// System.out.println(e.getX() + " " + e.getY()); // 클릭시 좌표 출력 ,get은 가격을 받는거니까
			// setTitle(e.getX() + " " + e.getY()); // setter기능을 통해 프레임 안에다가 출력
			
			x=e.getX();
			y=e.getY();
			
			paint(getGraphics()); // paintAll(getGraphics());을 찍으면 그자리에만 출력 됨

		}
	}


	@Override
	public void paint(Graphics g) { // Frame은 paint()를 처음 실행 시 한 번 호출
		g.drawString("홍길동", x, y);  // Frame에 Graphics g: 문자열 그리는 이벤트

	}

	public static void main(String[] args) {
		new Ex28FrameInnerClass();

	}

}
