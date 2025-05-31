package pack4extends;

public class Ex19AnimalMain {

	public static void main(String[] args) {
//		Ex19Animal animal = new Ex19Animal();
		Ex19Cow cow = new Ex19Cow();
		System.out.println(cow.name() + " " + cow.action() + "에 " + cow.eat() + "먹음");
		cow.print();
		
		System.out.println();
		Ex19Lion lion = new Ex19Lion();
		System.out.println(lion.name() + " " + lion.action() + "에 " + lion.eat() + "먹음");
		lion.print();
		lion.eatOther();
		
		System.out.println();
		Ex19Animal animal;
		animal = cow;
		System.out.println(animal.name() + " " + animal.action() + "에 " + animal.eat() + "먹음");
		animal = lion;
		System.out.println(animal.name() + " " + animal.action() + "에 " + animal.eat() + "먹음");
		
		System.out.println();
		System.out.println(cow instanceof Ex19Cow); // instanceof : 타입 비교 연산자
		if(cow instanceof Ex19Cow) 
			System.out.println("맞아");
		else
			System.out.println("아니야");
		
		System.out.println(cow instanceof Ex19Animal);
		System.out.println(lion instanceof Ex19Animal);
		
		System.out.println("\n메소드 호출하며 매개변수에 주소 치환----------");
		Ex19AnimalFind animalFind = new Ex19AnimalFind();
		animalFind.find(cow);  // 주소를 치환한다는 점에서 animal = cow; 와 같은 의미
		System.out.println();
		animalFind.find(lion); // animal = lion;

	}

}
