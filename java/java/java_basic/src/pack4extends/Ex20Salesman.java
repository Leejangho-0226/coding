package pack4extends;

public class Ex20Salesman extends Ex20Regular{
	private int sales;
	private double commissin;
	
	
	public Ex20Salesman(String irum, int nai, int salary, int sales, double commissin) {
		super(irum,nai, salary);
		this.sales = sales;
		this.commissin = commissin;
	}
	
	@Override
	public double pay() {
		return super.pay() + sales * commissin;
	}

	@Override
	public void print() {
		display();
		System.out.println(", 수령액:" + pay());
	}

}
