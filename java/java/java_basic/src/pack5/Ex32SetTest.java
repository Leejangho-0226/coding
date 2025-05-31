	package pack5;

import java.util.HashSet;
import java.util.Iterator;

// Collection : 객체를 담을 수 있는 기억장소
	// 많은 수의 데이터를 그 사용 목적에 적합한 자료구조로 묶어 하나로 그룹화한 객체를 말합니다
	// 자바에서는 이러한 컬렉션을 위한 인터페이스와 클래스들이 있다
	// 컬렉션의 종류는 ArrayList, LinkedList, Vector, Stack, HashSet, TreeSet, HashMap, TreeMap 
	// List : 이름과 같이 목록처럼 데이터를 순서에 따라 관리합니다. 중복 허용. 제일 많이 쓰임
	// Set : 중복이 허용되지 않는 데이터를 관리합니다. 
	// Map : 데이터를 Key와 Value로 짝을 이루어 관리하며, Key값은 중복을 허용하지 않습니다. 
	// Queue : 데이터 In / Out 순서를 FIFO 방식으로 관리합니다. (FIFO : First In First Out)
	// Stack : 데이터 In / Out 순서를 LIFO 방식으로 관리합니다. (LIFO : Last In First Out)
	
	public class Ex32SetTest { // 중복 불허, 순서없다.
		public static void main(String[] args) {
			// 컬렉션타입클래스<제네릭> : 제네릭은 컬렉션에 저장할 객체의 타입을 제한하는 역활
			// HashSet<Object> hlist = new HashSet<Object>(); 
			HashSet<String> hlist = new HashSet<String>(); // err : String은 add(1); , add(1.5);을 받지 못해서
			// hlist.add(1); // 1은 기본형 int인데 컬렉션에 넣으면 Integer 클래스(wrapper class)로 변환되어 저장됨
			// hlist.add(1.5); // 1.5은 기본형 double인데 컬렉션에 넣으면 Double 클래스(wrapper class)로 변환되어 저장됨
			hlist.add("첫번째"); // 추가할때
			hlist.add("세번째");
			hlist.add("두번째");
			hlist.add("첫번째");
			hlist.add("두번째");
			System.out.println("hlist 크기 : " + hlist.size());
			hlist.remove("두번째"); // 제거할때
			System.out.println("hlist 크기 : " + hlist.size());
			
			// Iterator 반복자는 객체 지향적 프로그래밍에서 배열이나 그와 유사한 자료구조의 내부요소를 순회하는 객체다
			// 출력방법1
			Iterator iter = hlist.iterator();
			while(iter.hasNext()){
				String str = (String)iter.next();
				System.out.println(str);
		}
			// 출력방법2
			System.out.println();
			Object obj[] = hlist.toArray(); // 컬렉션을 배열로 변환
			for(int i = 0; i < hlist.size(); i++) {
				System.out.println(obj[i]);
			}
			// 출력방법3
			System.out.println();
			for(String aa:hlist) {
				System.out.println(aa);
			}
	}
	
}
