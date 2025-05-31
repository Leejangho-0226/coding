package pack4extends;

public class Ex29main {

	public static void main(String[] args) {
		Ex29Saram saram = new Ex29Saram();
		System.out.println(saram.getIrum());
		
		System.out.println();
		Ex29killdong killdong = new Ex29killdong();
		Ex29Saram saram2 = killdong.getSaram();
		System.out.println(saram2.getIrum());
		

	}

}
