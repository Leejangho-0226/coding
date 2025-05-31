package pack4extends;

public class Ex24FlyerBird implements Ex24Flyer{
	
	@Override
	public void fly() {
		System.out.println("날개를 저의며 멀리 날아가는 새 한마리");
		
	}
	
	@Override
	public boolean isAnimal() {
		return true;
	}

}
