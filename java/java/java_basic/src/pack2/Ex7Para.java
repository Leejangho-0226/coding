package pack2;

// 매개변수로 기본형 뿐만아니라 참조형도 가능.

class People{  // 일반적으로 따로이 파일을 작성해야 하지만 편의상 현재 클래스와 같은 곳에 적음
	String name;
	int age;
	
	public People(String name, int age) { // String name: 참조형, int age: 기본형
		this.name = name;
		this.age = age;
		
	}
}

class PeopleService {
	public PeopleService() {
		
		
	}
	
	public void changeName(People peole, String newName) {
		peole.name = newName;

	}
}


public class Ex7Para {
	
	
	
	public static void main(String[] args) {
		People people = new People("한국인", 22);
		System.out.println("변경 전 이름:" + people.name + " " + people);
		System.out.println("tom 변수 기억 주소 : " + people);
	
		
		PeopleService service = new PeopleService();
		service.changeName(people, "신나는"); // people 변수가 가진 주소를 전달
		System.out.println("변경 후 이름:" + people.name + " " + people);
		
		
		
	}

}
