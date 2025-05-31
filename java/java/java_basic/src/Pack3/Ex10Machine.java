package Pack3;

import java.util.Scanner;

public class Ex10Machine {
	private int cupCount;
	private Ex10MachineCoinIn coinIn = new Ex10MachineCoinIn();
	
	public Ex10Machine() {
		// TODO Auto-generated constructor stub
	}
	
	public void showData() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("동전을 입력하세요 : ");
		coinIn.setCoin(scanner.nextInt());
		System.out.print("몇 잔을 원하세요 : ");
		cupCount = scanner.nextInt();
		System.out.println(coinIn.calc(cupCount));
	}
}






