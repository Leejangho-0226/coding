	package pack4extends;
	
	public class Ex17polyBus extends Ex17polyCar{
		private int passenger = 10;
		
	
		public Ex17polyBus () {
			System.out.println("난 car의 자식인 Bus 생성자입니다");
		}
		
		@Override
		public void dispData() {
			System.out.println("버스 승객 수 : " + passenger);
			System.out.println("버스 속도는 : " + speed);
		}
		
		public void show() {
			System.out.println("버스 고유 메소드 show");
		}
		
	}
