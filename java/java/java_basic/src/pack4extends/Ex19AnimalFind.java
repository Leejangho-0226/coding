	package pack4extends;
	
	public class Ex19AnimalFind {
		public void find(Ex19Animal animal) {
			animal.print();
			
			if(animal instanceof Ex19Cow) {
				System.out.println("이름은 " + animal.name());
			}else if(animal instanceof Ex19Lion) {
				System.out.println("이름은 " + animal.name() + ", 뭐드심?" + animal.eat());
			}else {
				System.out.println("기타");
			}
		}
	
	}
