package pack5;

public class Ex48BankMain {
	
	public static Ex48Bank hanaBank = new Ex48Bank();
	
	public static void main(String[] args) {
		// Thread 동기화
		// 공유 자원에 Lock을 걸어 하나의 스레드가 공유자원을 사용 중인 경우 다른 스레드는 공유자원을 사용하지 못하고 대기상태에 빠트릴 수 있다
		// Synchronized를 이용(내부적으로 Lock을 건다.) ★Synchronized 잘 정리
		System.out.println("원금 : " + hanaBank.getMoney());
		
		Ex48Park park = new Ex48Park();
		park.start();
		
		Ex48ParkWife wife = new Ex48ParkWife();
		wife.start(); // 여기까지 하고 출력하면 지금 계좌를 공유하고 있지 않음
		
	}

}
