	package pack4extends;
	
////	abstract public class Ex21Volume { // 부모는 하나, 일반메소드 사용 가능
////		abstract public void volumeup(int level);
////		abstract public void volumedown(int level);
//	}
	
	public interface Ex21Volume { // 인터페이스 : 추상 클래스의 다른형태 // 부모를 여러명 할 수 있다(다중 상속 가능)
		void volumeup(int level);
		void volumedown(int level);
		
//		public void print() { // 일반 메소드를 가질수 없다>>>> 추상 메소드만 가능
//			System.out.println("일반 메소드");
//		}
	}
