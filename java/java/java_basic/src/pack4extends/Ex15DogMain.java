	package pack4extends;
	
	public class Ex15DogMain {
		public static void main(String[] args) {
			Ex15Dog dog = new Ex15Dog("개");
			dog.print();
			System.out.println(dog.callName());
			
			
			System.out.println();
			Ex15HouseDog houseDog = new Ex15HouseDog("집 개");
			houseDog.print();
			System.out.println(houseDog.callName());
			houseDog.show();
			
			System.out.println();
			Ex15WolfDog wolfDog = new Ex15WolfDog("늑대");
			wolfDog.print();
			System.out.println(wolfDog.callName());
			wolfDog.show();
			
			
			System.out.println("---------------");
			Ex15WolfDog bushdog = wolfDog; // 주소를 치환 ( 타입이 같은 경우 치환 성공 )
			wolfDog.print();
			bushdog.print();
			
			// Promotion
			Ex15Dog dog2 = wolfDog; // 주소를 치환 ( 타입이 다른데도 불구하고 치환 성공 - 자식의 주소를 부모 객체변수에 주는 경우)
			dog2.print(); // 오버라이딩 된 메소드만 부모 객체변수명으로 호출 가능
			// dog2.show(); // err 오버라이딩을 하지 않았기 때문에. 자식이 가진 고유 메소드는 부모 객체변수명으로 호출 불가
			// Ex15WolfDog hidog = dog2; // err - Type mismatch: cannot convert from Ex15Dog to Ex15WolfDog
			Ex15WolfDog hidog = (Ex15WolfDog)dog2; // casting
			hidog.print();
			
			System.out.println("---------------------------");
			Ex15Dog copyte = new Ex15Dog("코요태"); // 부모 클래스
			copyte.print();
			System.out.println(copyte.callName());
			Ex15WolfDog wolfDog2 = new Ex15WolfDog("늑대2"); // Dog의 자식 클래스
			wolfDog2.print();
			wolfDog2.show();
			
			copyte = wolfDog2; // promotion : 자식 객체 주소를 부모 객체변수에 치환
			copyte.print(); // 오버라이딩된 메소드는 허용
//			copyte.show(); // 자식 고유 메소드는 호출 불가
			copyte.getName();
			Ex15WolfDog wolfDog3 = null;
//			wolfDog3.show();     //  java.lang.NullPointerException
			wolfDog3 = wolfDog2; // 타입이 같으므로 성공
//			wolfDog3 = houseDog; // 타입이 다르므로 실패
//			wolfDog3 = copyte;   // 타입이 다르므로 실패, ★★★★★★ 하지만 부모 타입인 copyte 변수는 자식의 주소를 기억 중
			wolfDog3 = (Ex15WolfDog)copyte; // 그러므로 ★★★★★★ casting을 통해 치환할 수 있다.
			wolfDog3.print();
			
	}
	
}
