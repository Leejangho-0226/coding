package pack4extends;

public class Ex16Vehicle {
	protected String brand;
	protected int speed;
	
	
	public Ex16Vehicle(String brand, int speed) {
		this.brand = brand;
		this.speed = speed;
	}
	
	public void describe() {
		System.out.println("This is a vehicle");
	}

}
