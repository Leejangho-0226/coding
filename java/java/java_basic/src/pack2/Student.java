	package pack2;
	
	public class Student {
		// 필드
		String name;
		int grade;
		double score;
	
		// 생성자
		public Student(String name, int grade, double score) { // 매개변수는 지역변수
	
			this.name = name;  // 생성자의 값을 주면 값이 고정 된다.
			this.grade = grade;
			this.score = score;
		}
		
		
		// 메서드
		public void printStudent() {
			System.out.println("이름 [" + name + "], 학년:[" + grade + "], 평균 점수:[" + score + "]");
			
		}
		
		// setter를 이용해서 값을 줄 수도 있다.
		public void setName(String name) {
			this.name = name;
		}
	
	}
	
	
	
