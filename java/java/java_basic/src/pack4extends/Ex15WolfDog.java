package pack4extends;

public class Ex15WolfDog extends Ex15Dog{
	private String where = "동물원";
	
	public Ex15WolfDog(String name) {
		super(name);
	}
	
	public void show() {
		System.out.println("WolfDog 어디 사니 ?" + where + "에 산다");
	}
	
	@Override
	public void print() {
		System.out.println(getName() + "는(은) " + where + "에서 사람들 시선을 느끼면서 산다");
	}
	
	public void displayPrint() {
		print();
		this.print();
		super.print();
	}

}
