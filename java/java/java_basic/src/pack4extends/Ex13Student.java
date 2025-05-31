package pack4extends;


//public class Ex13Student { // 아래와 동일.
public class Ex13Student extends Object{ // 모든 클래스는 Object를 상속받음.
	public String name;
	
	public Ex13Student() {
		name = "tom";
	}
	
	@Override
		public String toString() {
			System.out.println("원래 의미 싫어. 바꿀거야");
			return "이 클래스의 사용자는 " + name;
		}
	
	//------------------------------------------------------------
	public static void main(String[] args) { 
		Ex13Student student = new Ex13Student();
		System.out.println(student); // toString 생략.
		System.out.println(student.toString()); 
	}

}
