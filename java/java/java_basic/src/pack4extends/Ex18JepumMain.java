package pack4extends;

public class Ex18JepumMain {

	public static void main(String[] args) {
		// 추상 클래스는 스스로 객체 생성 불가. 자식의 생성자에 의해 객체 생성됨
//		Ex18Jepum jepum = new Ex18Jepum();
		Ex18Jepum jepum = null;
		
		Ex18JepumTv tv = new Ex18JepumTv();
		tv.volumeControl();
		tv.volumeShow();
		
		System.out.println();
		Ex18Radio radio = new Ex18Radio();
		radio.volumeControl();
		radio.volumeShow();
		
		System.out.println();
		Ex18Handphone handPhone = new Ex18Handphone();
		handPhone.volumeControl();
		handPhone.volumeShow();
		
		System.out.println();
		jepum = handPhone;
		jepum.volumeControl();
		jepum = radio;
		jepum.volumeControl();
		jepum = handPhone;
		jepum.volumeControl();
		
		System.out.println();
		Ex18Jepum j[] = {tv, radio, handPhone};
		for(Ex18Jepum jep:j) {
			jep.volumeControl();
		}

	}

}
