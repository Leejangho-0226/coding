package pack4extends;

public class Ex20Regular extends Ex20Employee{
	private int salary;
	
	public Ex20Regular(String irum, int nai, int salary) {
		super(irum,nai);
		this.salary = salary;
	}
		
	@Override
	public double pay() {
		return salary;
	}
	
	@Override
	public void print() {
		display();
		System.out.println(", 급여:" + pay());
		
		
	}
	

}
