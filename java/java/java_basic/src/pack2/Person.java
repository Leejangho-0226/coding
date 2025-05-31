package pack2;

public class Person {
	String irum;
	int nai;
	
	public Person() {
		
	}
	
	public void printAge(String irum,int nai) {
		System.out.println("이름은 " + irum + " 나이는 " + nai);
	}

	public void printAge(String irum) {
		System.out.println("이름은 " + irum + " 나이는 알 수 없어요 ");
	}
	
	public void printAge() {
		System.out.println("이름과 나이는 알 수 없어요 ");
	}

	
	public static void main(String[] args) {
		Person per1 = new Person();
		per1.printAge(null, 0);
		per1.printAge(null);
		per1.printAge();
		
	}
}

