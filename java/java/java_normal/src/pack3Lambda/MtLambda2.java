	package pack3Lambda;
	
	interface MyInter{
		void aaa();
	}
	
	interface MyInterArg{
		void bbb(int a, int b); // 매개변수가 있는 메소드
	}
	
	interface MyInterArgReturn{
		int ccc(int a, int b); // 반환 값이 있는 메소드
	}
	
	
	
	public class MtLambda2 {
		public static void main(String[] args) {
			// 1) 인자가 없는 추상 메소드 처리 
			MyInter inter1 = new MyInter() {
				@Override
				public void aaa() {
					System.out.println("익명 클래스의 메소드 오버라이딩");
	
				}
			};
			inter1.aaa();
	
			// 람다식으로 표현
			MyInter inter2 = () -> System.out.println("익명 클래스의 메소드 오버라이딩"); // 실행문이 하나일때는 중괄호 써도 안써도 됨
			inter2.aaa();
			System.out.println();
	
			MyInter inter3 = () -> {
				System.out.println("익명 클래스의 메소드 오버라이딩");
				int imsi = 1;
				System.out.println("익명 클래스의 메소드 오버라이딩 : " + imsi);
			};
			inter3.aaa();
			
			System.out.println("=================================");
			// 2) 인자가 있는 추상 메소드 처리 
			MyInterArg interArg = new MyInterArg() {
				
				@Override
				public void bbb(int a, int b) {
					System.out.println("두 수의 합은 " + (a + b));
					
				}
			};
			interArg.bbb(5, 4);
			System.out.println();
			
			// 람다식으로 표현 : 매개 변수가 1개 일 때는 (a, b)를 ()를 a -> 도 가능하다 
			MyInterArg interArg2 = (a, b) -> System.out.println("람다 : 두 수의 합은" + (a + b));
			interArg2.bbb(5, 4);
			
			System.out.println("=================================");
			// 3) 반환 값이 있는 추상 메소드 처리 
			MyInterArgReturn argReturn = new MyInterArgReturn() {
				
				@Override
				public int ccc(int a, int b) {
					System.out.println("ccc 처리");
					return a + b;
				}
			};
			int result = argReturn.ccc(2, 3);
			System.out.println("두 수를 더한 결과 : " + result);
			
			// 람다식으로 표현
			MyInterArgReturn argReturn2 = (a, b) -> a + b;
			int result2 = argReturn2.ccc(2, 3);
			System.out.println("두 수를 더한 결과 : " + result2);
		}
	}
