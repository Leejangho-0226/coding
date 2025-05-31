package pack2;

public class Ex2Student {

	public static void main(String[] args) {
		// 문제 1: 학생 정보 관리 클래스. 학생 정보를 관리하기 위한 Student 클래스를 작성하세요.
		// 클래스 이름은 Student입니다. 다음 필드를 포합합니다.
		// String name(학생 이름), int grade(학년),double score(평균 점수)
		// 생성자는 모든 필드를 초기화할 수 있어야 합니다.
		// 학생의 정보를 출력하는 printStudentinfo() 메서드를 작성하세요.
		// 출력 형식은 다음과 같습니다.
		// 이름 [name], 학년:[grade], 평균 점수:[score]
		// mian 메서드에서 학생 객체를 생성하고 printStudentlnfo() 메서드를 호출하세요.
		
		
		// main 메소드는 프로그램을 실행하기 위한 메소드. ExStudent 멤버는 아님.
		Student tom = new Student(" 이장호 ", 1 , 95.5);
		tom.printStudent();
		
		System.out.println();
		Student james = new Student(" 김동훈 ", 1 , 65.5);
		james.printStudent();
		
		
	}

}
