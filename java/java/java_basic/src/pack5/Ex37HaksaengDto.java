	package pack5;
	
	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;
	
	// 롬복을 사용해 생성자, 겟터, 셋터 만들기
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public class Ex37HaksaengDto {
		private String name;
		private int kor, eng, mat;
		
	/*
		public Ex37HaksaengDto(String name, int kor, int eng, int mat); {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public int getKor() {
			return kor;
		}
	
		public void setKor(int kor) {
			this.kor = kor;
		}
	
		public int getEng() {
			return eng;
		}
	
		public void setEng(int eng) {
			this.eng = eng;
		}
	
		public int getMat() {
			return mat;
		}
	
		public void setMat(int mat) {
			this.mat = mat;
		}
	
	
	*/
	}
