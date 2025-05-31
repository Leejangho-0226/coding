package pack5;

public class Ex49BreadMain {

	public static void main(String[] args) {
		// 스레드 동기화 중 협력관계 처리
		// 스레드 간 협력 작업 중 스레드를 비활성화(wait) 후 다시 활성화(notify()) 상태로 되돌리기 작업
		
		try { 
			Ex49BreadPlate breadPlate = new Ex49BreadPlate();
			
			Ex49BreadMaker maker = new Ex49BreadMaker(breadPlate);
			Ex49BreadEater eater = new Ex49BreadEater(breadPlate);
			maker.setPriority(9); // maker부터 먼저 수행 되도록 요청하는것 확률을 높임
			maker.start();
			eater.start();
			
			System.out.println("현재 실행 중인 스레드 수 : " + Thread.activeCount());
		}catch (Exception e) {
			
		}
		
	}

}
