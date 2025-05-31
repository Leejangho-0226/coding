package pack4extends;

public class Ex21VolumeMain {

	public static void main(String[] args) {
//		Ex21Volume myvolVolume = new Ex21Ex21Volume();
		Ex21Volume myVolume;
		
		Ex21Radio radio = new Ex21Radio();
		Ex21Tv tv = new Ex21Tv();
		
		radio.volumeup(6);
		radio.volumedown(3);
		
		tv.volumeup(7);
		tv.volumedown(2);
		
		System.out.println();
		myVolume = radio;
		myVolume.volumeup(2);
		myVolume = tv;
		myVolume.volumeup(2);
		
	}

}
