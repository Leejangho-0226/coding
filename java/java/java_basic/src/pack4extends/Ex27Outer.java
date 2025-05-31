	package pack4extends;
	
	
	// 내부 클래스
	// 클래스의 멤버로 필드, 메소드 외에 클래스를 가질 수 있다. 이를 내부 클래스라고 한다.
	// 클래스 내에서 다른 클래스 객체를 사용해야 하는 경우가 있다. 이 때 구현하면 효과적.
	// 참고로 ★★★★★★ 한 개의 클래스는 한 개의 extends 문을 가질 수 있다는 점을 기억하자 ★★★★★★★★
	public class Ex27Outer {
		private int kor;
		private Inner inner;
		
		public Ex27Outer() {
			kor = 10;
			inner = new Inner(); // 내부 클래스도 객체 생성은 포함관계 처럼 해 준다.
		}
		
		public void aa() {
			System.out.println("외부 클래스 Outer의 aa 메소드");
			System.out.println("외부 클래스의 kor : " + kor);
			bb();
			inner.cc();
			System.out.println("내부 클래스의 eng : " + inner.eng);
		}
		
		
		private void bb() {
			System.out.println("외부 클래스 Outer의 bb 메소드");
		}
		
		// 내부 클래스 선언
		public class Inner { // 오로지 Ex27Outer 안에서만 쓰겠다고 선언하는 것임. 상속이 가능하므로
			private int eng;
			
			public Inner() {
				eng = 20;
			}
			
			public void cc() {
				System.out.println("내부 클래스 Inner의 cc 메소드");
				bb(); // 외부 클래스 Outer의 bb 메소드
				System.out.println("내부 eng:" + eng + ", 외부 kor:" + kor);
				
			}
			
			// 내부 클래스 안에 다시 내부 클래스 선언 가능 (비건장)
			
			public class InnerInner {
				
			}
			
		}
		
	
		public static void main(String[] args) { // Call Back 메소드
			Ex27Outer outer = new Ex27Outer();
			outer.aa();
			outer.bb();
			
			
//			Inner inner = new Inner(); // 내부 클래스는 독립적인 객체 생성(new) 불가
//			Ex27Outer.Inner inner = outer.new Inner(); // 이렇게는 가능하나 비권장
//			inner.cc();
			
			System.out.println();
	
		}
	
	}
