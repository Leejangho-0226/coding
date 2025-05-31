package pack4extends;

public class Ex16Bicycle extends Ex16Vehicle{
	private int gearCount;
	
	public Ex16Bicycle (String brand, int speed, int gearCount) {
		super(brand, speed);
		this.gearCount = gearCount;
	}
	
	@Override
	public void describe() {
		System.out.println("This is a bicycle of brand " + brand + "with" + gearCount + " gears");
	}

}
