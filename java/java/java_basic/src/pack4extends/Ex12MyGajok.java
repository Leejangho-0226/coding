package pack4extends;

public class Ex12MyGajok {

	public static void main(String[] args) {
		Ex12GrandFa grandFa = new Ex12GrandFa();
		System.out.println("가보:" + grandFa.gabo);
		System.out.println("가훈:" + grandFa.gahun);
		grandFa.say();
		System.out.println("할아버지 나이:" + grandFa.getNai());
		
		System.out.println();
		Ex12GrandFa grandFa2 = new Ex12GrandFa(77);
		System.out.println("할아버지 나이:" + grandFa2.getNai());
		
		System.out.println("------------"); // father 클래스
		Ex12Father father = new Ex12Father();
		System.out.println("가보:" + father.gabo);
		System.out.println("가훈:" + father.gahun);
		father.say();
		System.out.println("아버지 나이:" + father.getNai());
		father.eat();
		System.out.println("집 : " + father.getHouse());
		father.showDate();
		
		System.out.println("------------;;;;;;;;;;"); // me 클래스
		Ex12Me me = new Ex12Me();
		System.out.println("가보:" + me.gabo);
		System.out.println("가훈:" + me.gahun);
		me.say();
		System.out.println("내 나이:" + me.getNai());
		me.eat();
		System.out.println("집 : " + me.getHouse());
		me.Biking();
				
		
	}

}
