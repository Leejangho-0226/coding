package pack5;

import java.util.ArrayList;
import java.util.List;

// List: 데이터를 순서에 따라 관리. 중복 허용.
public class Ex34List {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("볼펜");
		list.add("연필");
		list.add("볼펜+");
		list.add("볼펜");
		list.add("마우스");
		System.out.println("list 크기:" + list.size() );
		list.remove("볼펜"); // 값으로 삭제
		System.out.println("list 크기:" + list.size() );
		list.remove(1);     // 순서로 삭제
		System.out.println("list 크기:" + list.size() );
		System.out.println("list의 0번째는 " + list.get(0) );
		
		System.out.println();
		for(int i=0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		for(String data:list) {
			System.out.println(data);
		}
	}

}
