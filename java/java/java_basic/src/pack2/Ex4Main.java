package pack2;

public class Ex4Main {

	public static void main(String[] args) {
		System.out.println("메소드 오버로딩 연습");
		Ex4Animal tiger = new Ex4Animal();
		tiger.display();
		tiger.display(3);
		tiger.display("호랭이");
		tiger.display(5, "김동훈");
		tiger.display("이장호", 3);
		
		System.out.println("\n생성자 오버로딩 연습");
		Ex4Animal dog = new Ex4Animal();
		dog.display();
		
		System.out.println();
		Ex4Animal hen = new Ex4Animal(2);
		hen.display();
		
		System.out.println();
		Ex4Animal wolfdog = new Ex4Animal("늑대", 7);
		wolfdog.display();
		
	}

}
