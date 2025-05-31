package pack3Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyStream2 {

	public static void main(String[] args) {
		// 숫자 리스트에서 짝수만 필터링하여 제곱한 결과 출력
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println("스트림 사용 전 방법");
		List<Integer> evenNum = new ArrayList<Integer>();
		for(Integer n:numbers) {
			if(n % 2 == 0) {
				evenNum.add(n * n);
			}
		}
		System.out.println("짝수의 제곱 : " + evenNum);
		
		System.out.println("\n스트림 사용 방법");
		List<Integer> evenNum2 = numbers.stream()
				.filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
		System.out.println("짝수의 제곱 : " + evenNum2);
	}

}
