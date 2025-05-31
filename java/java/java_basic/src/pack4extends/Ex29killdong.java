	package pack4extends;
	
	public class Ex29killdong {
		public Ex29Saram getSaram() {
			// return new Ex29Saram();
	
			return new Ex29Saram() { // 내부 무명(익명)클래스 조건:
				public String getIrum() {
					return "홍길동";
			
				}
		};
	}
}