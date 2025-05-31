package pack4extends;

public class Ex22Main {
	public static void main(String[] args) {
		Ex22InterRadio interRadio = new Ex22InterRadio();
		interRadio.volUp(5);
		interRadio.volDown(3);
		interRadio.showRadio();
		
		System.out.println();
		Ex22InterTv interTv = new Ex22InterTv();
		interTv.volResume();
		interTv.volUp(8);
		interTv.volDown(3);
		interTv.volOff();
	
	}

}
