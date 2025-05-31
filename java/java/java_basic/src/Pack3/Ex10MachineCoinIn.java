package Pack3;

public class Ex10MachineCoinIn {
	private int coin;
	private int jandon;
	
	public void setCoin(int coin) {
		this.coin = coin;
	}  
	
	public int getJandon() {
		return jandon;
	}
	
	public String calc(int cupCount) {
		String re = "";
		if(coin < 200) {
			re = "요금이 부족합니다";
		}else if(cupCount * 200 > coin) {
			re = "요금이 부족합니다";
		}else {
			jandon = coin - (200 * cupCount);
			re = "커피 " + cupCount + "잔과 잔돈 " + jandon + "원";
		}
		return re;
	}
}


