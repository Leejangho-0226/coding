	package pack4extends;
	
	
	// parent, super, 부모, 원형 클래스...
	public class Ex17polyCar {  // 모든 자동차들이 공통으로 가져야할 멤버 (필드, 메소드)
		protected int speed = 100; // protected 자식을 만들거야 라는 의미를 가지는것
		
		
		public Ex17polyCar() {  // 생성자
			System.out.println("나는 자동차 원형 클래스야!");
		}
		
		public void dispData() {
			System.out.println("속도 : " + speed);
		}
		
		
		public int getspeed() {
			return speed;
		}
	
	}
