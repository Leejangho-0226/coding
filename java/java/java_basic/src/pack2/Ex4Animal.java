	package pack2;
	
	// method overloading : 클래스 내에 동일 이름의 메소드를 복수로 만듦
	public class Ex4Animal { // 동물이 가져야 할 속성(field)과 행위(medhod)를 클래스로 설계
		private int leg = 4; // 멤버필드는 두개 이상의 메소드를 사용할거라는 의사표현.
		private int age; 
		private String name;
		public final static int MOUTH = 1; // fianl은 대문자로만.
	
		public Ex4Animal() {
			// 내용이 없는 생성자는 안 적으면 컴파일러가 자동으로 만들어 줌. ( 생성사도 오버로딩 가능함 메소드 이기 때문)
			System.out.println("내용이 없는 생성자");
		}
		
		public Ex4Animal(int leg) { // 생성자 오버로딩
			System.out.println("정수 1개를 받는 생성자");
			this.leg = leg; // 매개 변수랑 이름이 같을 때 this 사용
		}
		
		public Ex4Animal(String name, int age) { // 생성자 오버로딩
			this.name = name;
			this.age = age;
			System.out.println("정수 2개를 받는 생성자");
		}
		
		
		
		// 메소드 오버로딩
		public void display() { // 메소드 오버로딩
			System.out.println("leg:" + leg + ", age:" + age + ", name: " + name);
		}
	
		// 오버로딩 성립 조건
		// 매개변수의 갯수, 순서, 타입이 다르면 됨.
		public void display(int age) { 
			// this.age = age;
			System.out.println("leg:" + leg + ", age:" + age + ", name: " + name);
		}
	
		public void display(String name) { 
			System.out.println("leg:" + leg + ", age:" + age + ", name: " + name);
		}
	
		public void display(int age,String name) { 
			System.out.println("leg:" + leg + ", age:" + age + ", name: " + name);
		}
	
		public void display(String name,int age) { 
			System.out.println("leg:" + leg + ", age:" + age + ", name: " + name);
		}
	
	
	
	
		// 성립 안되는 경우 : 위에서 int age가 있기 때문에 오버로딩이 안됨 ( int라는 타입이 같기 때문에)
	
		//public void display(int leg) { // 메소드 오버로딩x
		//System.out.println("leg:" + leg + ", age:" + age + ", name: " + name);
	
		//public void display(String name, int leg) { // 메소드 오버로딩x
		//System.out.println("leg:" + leg + ", age:" + age + ", name: " + name);
	
		//private int display(int leg) { // 메소드 오버로딩 x
		//System.out.println("leg:" + leg + ", age:" + age + ", name: " + name);
		//return 5;
}
	
