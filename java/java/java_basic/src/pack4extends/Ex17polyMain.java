package pack4extends;

public class Ex17polyMain {
	public static void main(String[] args) {
		Ex17polyCar car1 = new Ex17polyCar();
		Ex17polyBus bus1 = new Ex17polyBus();
		Ex17polyTaxi taxi1 = new Ex17polyTaxi();
		
		System.out.println();
		car1.dispData();
		System.out.println(car1.getspeed());
		
		System.out.println("\n-------\n");
		System.out.println("버스에 대해...");
		bus1.dispData();
		System.out.println(bus1.getspeed());
		bus1.show();
		
		System.out.println("\n-------\n");
		System.out.println("택시에 대해...");
		taxi1.dispData();
		System.out.println(taxi1.getspeed());
		
		System.out.println("\n===========주소치환==============\n");
		Ex17polyCar car2 = new Ex17polyBus(); // 자식의 주소를 부모에게 치환 promotion
		car2.dispData();
//		car2.show(); // show는 bus(자식)의 고유의 메소드이므로 불가
		
		System.out.println();
		Ex17polyCar car3 = taxi1;  // 자식의 주소를 부모에게 치환 promotion
		car3.dispData();
		
		System.out.println("\n===========다형성==============\n");// 참조 변수
//		Ex17polyBus bus2 = new Ex17polyCar(); // 부모의 주소 자식에게 치환 불가능 >>> 캐스팅하면 가능
		Ex17polyBus bus2 = (Ex17polyBus)car2; // 부모타입이지만 자식의 주소를 가지므로 캐스팅
		bus2.dispData();
		bus2.show();
		
		System.out.println();
//		Ex17polyTaxi taxi = new Ex17polyCar(); // 불가능
		Ex17polyTaxi taxi2 = (Ex17polyTaxi)car3;
		taxi2.dispData();
		
//		Ex17polyTaxi taxi3 = (Ex17polyTaxi)car1; //java.lang.ClassCastException 처음부터 부모의 주소이기 때문에 casting해도 오류남.
		
		System.out.println("&&&&&&&&&&&&&&&&&");
		Ex17polyCar p[] = new Ex17polyCar[3]; // car 타입의 배열 선언
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		p[0].dispData();
		p[1].dispData();
		p[2].dispData();
		System.out.println();
		for(int i=0; i < p.length; i++) {
			p[i].dispData();
		}
		System.out.println();
		for(Ex17polyCar car:p) { // 오류
			car.dispData();
			
		}
		
	}

}
