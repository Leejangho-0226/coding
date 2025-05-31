	package pack4extends;
	
	public class Ex18JepumTv extends Ex18Jepum{ // 오버라이딩을 하면 추상클래스의 족쇄에서 벗어남 오버라이딩 없으면 new가 안됨 추상클래스 상태임
		public Ex18JepumTv() {
			// super();
			System.out.println("TV 생성자");
			
		}
		
		@Override
		void volumeControl() {
			// 메소드 오버라이딩을 강요당함 >> 추상을 쓰는이유 다형성을 하기위해
			System.out.println("TV 소리 조절");
			
		}
	
	}
