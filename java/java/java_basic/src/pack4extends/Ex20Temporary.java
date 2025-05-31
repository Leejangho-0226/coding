package pack4extends;

public class Ex20Temporary extends Ex20Employee{
	
	private int ilsu;
	private int ildang;
	
	public Ex20Temporary(String irum, int nai, int ilsu, int ildang) {
		super(irum,nai);
		this.ilsu = ilsu;
		this.ildang =ildang;
	}
	
	@Override
	public double pay() {
		return ilsu * ildang;
	}
	@Override
	public void print() {
		display();
		System.out.println(", 월급:" + pay());
		
	}

}
