package pack5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex33MapTest { // Map type의 컬렉션 : key와 value로 구성
	// key는 중복 불허, value는 중복 허용
	public static void main(String[] args) {
		HashMap<String, String> mlist = new HashMap<String, String>();
		
		mlist.put("0", "하나");
		mlist.put("1", "둘");
		mlist.put("2", "셋");
		mlist.put("3", "넷");
		//mlist.put("3", "넷"); // (덮어쓰기:셋이 넷으로 됨) "3"이 중복
		System.out.println("mlist 크기 : " + mlist.size());
		System.out.println(mlist.containsKey("2"));
		System.out.println(mlist.containsValue("kbs"));
		
		// 출력 방법1
		Set set = mlist.keySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			String k = (String)iter.next();
			System.out.println(k + " " + mlist.get(k));
		}
		
		System.out.println();
		// 출력방법2
		for(String k:mlist.keySet()) {
			String value = mlist.get(k);
			System.out.println(k + " " + mlist.get(k));
				
			}
		}
	}

