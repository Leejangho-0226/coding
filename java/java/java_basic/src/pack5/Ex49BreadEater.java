package pack5;

public class Ex49BreadEater extends Thread{
	private Ex49BreadPlate breadPlate;
	
	
	public Ex49BreadEater(Ex49BreadPlate breadPlate) {
		this.breadPlate = breadPlate;
		
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 30; i++) { // 하루에 빵생산은 30회만
			breadPlate.eatBread();
			
		}
	}

}
