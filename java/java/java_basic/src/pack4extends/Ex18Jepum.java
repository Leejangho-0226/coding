	package pack4extends;
	// 전자 제품 관련 부모 클래스 (추상)
	abstract public class Ex18Jepum { // 전자 제품이 공통으로 가져야할 멤버 선언 추상 메소드가 없어도 가능은 하나 스스로 new를 안함
		public int volume = 0;
	
		public Ex18Jepum() {
			System.out.println("Jepum 추상 클래스 생성자");
		}
	
		abstract void volumeControl(); // 추상메소드 { body가 없음 }
	
		public void volumeShow() {
			System.out.println("소리 크기 : " + volume);
		}
	
	}
