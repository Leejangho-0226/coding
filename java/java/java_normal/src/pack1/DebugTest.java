	package pack1;
	
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JTextField;
	
	// Debugging : Runtime error, Logic error 잡기 - Syntax 에러 x
	
	public class DebugTest extends JFrame implements ActionListener{
		int cou = 0;
		int tot = 0;
		JButton btn = new JButton("클릭");
		JTextField txtA = new JTextField();
	
		public DebugTest() {
	
			add("North", txtA);
			add("Center", btn);
			btn.addActionListener(this);
	
			setBounds(200, 200, 300, 300);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		}
	
	
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
				for(int i = 0; i < 5; i++) {
					cou++;
					System.out.println("cou : " + cou); // 개발 도중 변수값 확인을 목적으로 console에 출력
					tot += cou;
				}
				System.out.println("tot : " + tot); 
			 */
	
	
	
			// 이클립스가 지원하는 디버깅 도구를 사용 : 확인하고자 하는 행에 중간점을 표시하고 디버깅
			for(int i = 0; i < 5; i++) {
				cou++;
				tot += cou;
			}
			System.out.println("tot : "  + tot);
	
			System.out.println("종료");
	
		}	
	
		public void aa() {
			System.out.println("aa 메소드 실행");
			for(int j = 0; j < 3; j++) {
				cou++;
				System.out.println("aa 메소드");
			}
	
		}
	
		public static void main(String[] args) {
			new DebugTest();
	
		}
	
	}
