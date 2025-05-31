package pack5;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;

// Thread를 이용해 디지털 시계 실행
public class Ex47ThreadClock extends Frame implements Runnable, ActionListener{
	Label lblmessage;
	Thread thread;
	boolean b = false;

	public Ex47ThreadClock() {
		lblmessage = new Label("show datetime", Label.CENTER);// Label.CENTER 화면을 가운데로 조정해줌
		add("Center", lblmessage);
		
		Button button = new Button("click");
		add("South", button); // "South" 첫글자가 소문자면 오류 남
		button.addActionListener(this);

		setTitle("스레드 시계");
		setSize(300,300);
		setLocation(200,200);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				b = true; // 윈도우 종료시 run 메소드의 무한루프를 끝내기 위해서 적어줘야한다
				System.exit(0);
			}
		});
		thread = new Thread(this); // 사용자 정의 스레드 생성 
	}

	@Override
	public void run() {
		while(true) { // 무한루프 사용
			if(b == true) break; // ★★★★ frame 창 x를 눌러도 윈도우는 run()은 활성화되기 때문에 run()을 확실하게 끝내줘야함
			showSigan();
			
			// showSigan();을 1초에 한번씩 호출할 수 있도록 스레드 1초간 비활성화 후 다시 활성화 시키기
			try {
				Thread.sleep(1000); // 예외처리해야함
			}catch (Exception e) {
				
			}
			
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("버튼 클릭");
		// showSigan(); 내가 눌러야만 시간이 흘러감
		if(thread.isAlive()) return; // Thread가 활성화된 상태인 경우 메소드 탈출
		thread.start(); // run()을 호출함 
		
	}
	
	private void showSigan() {
		LocalDate date = LocalDate.now(); // Singleton 객체
		int y = date.getYear();
		int m = date.getMonthValue();
		int d = date.getDayOfMonth();
		
		LocalTime localTime = LocalTime.now();
		int h = localTime.getHour();
		int mi = localTime.getMinute();
		int s = localTime.getSecond();
		
		String imsi = y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s;
		lblmessage.setText(imsi);
		
	}




	public static void main(String[] args) {
		new Ex47ThreadClock();


	}

}
