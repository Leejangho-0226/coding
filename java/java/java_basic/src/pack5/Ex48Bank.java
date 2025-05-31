package pack5;

public class Ex48Bank {
	private int money = 10000; // Thread가 공유할 자원

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// public void saveMoney(int mon) { // 입금
	synchronized public void saveMoney(int mon) { // synchronized를 통해서 Lock을 걸어버림 ==> 다른 스레드가 참여못함
		// synchronized가 적용된 메소드 내의 멤버필드는 스레드에서 공유가 가능
		// 어떤 스레드가 멤버필드 money를 사용하는동안 Lock이 걸림.
		// saveMoney 메소드 수행이 끝나면 자동으로 Lock이 풀림.
		int m = this.getMoney();
		try { // 스케쥴러가 다른일 못하게 막아둔것
			Thread.sleep(2000); // 입금 지연시간 2초
		}catch (Exception e) {

		}
		this.setMoney(m + mon);
	}

	// public void minusMoney(int mon) { // 출금
	synchronized public void minusMoney(int mon) {
		int m = this.getMoney();
		try {
			Thread.sleep(3000); // 출금 지연시간 3초
		}catch (Exception e) {

		}
		this.setMoney(m - mon);


	}
}
