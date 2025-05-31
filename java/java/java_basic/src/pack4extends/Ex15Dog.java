package pack4extends;

public class Ex15Dog {
	private String name = "name";
	
	
	public Ex15Dog(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String callName() {
		return "종류 : " + name + "과";
	}

	public void print() {
		System.out.println(name + "과 동물들은 지구 상에 산다");
	}
}
