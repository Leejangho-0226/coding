package pack4extends;

public class Ex16Car extends Ex16Vehicle{
	private int fuelCapacity;
	
	public Ex16Car(String brand, int speed, int fuelCapacity) {
		super(brand, speed);
		this.fuelCapacity = fuelCapacity;
		
	}
	
	@Override
	public void describe() {
		System.out.println("This is a car of brand" + brand + "with a fual capacity of" + fuelCapacity +" liters ");
 }
}