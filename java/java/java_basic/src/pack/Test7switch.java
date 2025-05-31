		package pack;
		
		public class Test7switch {
		
			public static void main(String[] args) {
				// Switch: 조건 판단문의 좀 더 정형화된 문법으로 값에 따라 여러방향으로 분기하는 경우 효과적
				// 길게 늘어진 if문에 비해 코드가 짧고 의미파악이 쉽다.
				int nai = 33;
				nai = nai / 10*10; // ex) 10~19 10대 몫만 취한다
				System.out.println(nai);
		
				switch(nai) { // break가 없으면 계속 흘러감
				case 20:
					System.out.println("20대"); // if
					break;
				case 30:
					System.out.println("20대");
					System.out.println("인생의 황금대");
					break;
				default:
					System.out.println("기타");
					break;
				}
		System.out.println("계속1");
		
		switch(nai) {
		case 10:
		case 20:
			System.out.println("젊음");
			break;
		case 30:
		case 40:
		case 50:
			System.out.println("황금기");
			break;
		default:
			System.out.println("그 외 기타");
			break;
			
		}
		System.out.println("계속2");
		System.out.println("계속2");
		//System.out.println((int)(Math.random() * 10));    // 난수 발생
		// sigan = (int)(Math.random() * 10);
		int sigan = (int)(Math.random() * 4) + 8;  // 8 ~ 11 사의 정
	
		switch (sigan) {
		case 8 : 
			System.out.println("출근 준비");
			break;
		case 9 : 
			System.out.println("출근 완료");
			break;
		case 10 : 
			System.out.println("팀 회의");
			break;
		default: 
			System.out.println("개인활동");
			break;
		}
		System.out.println("계속3");
		String jik = "과장";
		
		switch (jik) {
		case "사원" : 
			System.out.println("사원 업무");
			break;
		case "과장" : 
			System.out.println("과장 업무");
			break;
		default: 
			System.out.println("개인활동");
			break;
		}	
 }
		
}
