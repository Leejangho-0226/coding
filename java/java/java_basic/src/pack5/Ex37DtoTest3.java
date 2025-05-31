package pack5;

import java.util.ArrayList;
import java.util.StringTokenizer;

// 여러 개의 필두로 구성된 데이터가 문자열로 입력될 경우 필드별 문자 분리 후 레코드 처리
// 조건 : 문자열은 콤마(,) 등의 구분자로 구별되어 있다.
// 출력은 이름 총점 평균 
public class Ex37DtoTest3 {
	private ArrayList<Ex37HaksaengDto> list = new ArrayList<Ex37HaksaengDto>();
	
	public void stringSplitTest() {
		String ims = "kbs,mbc,sbs";
		StringTokenizer tokenizer = new StringTokenizer(ims, ",");
		String s1 = tokenizer.nextToken();
		String s2 = tokenizer.nextToken();
		String s3 = tokenizer.nextToken();
		System.out.println(s1 + " " + s2 + " " + s3);
	}
	
	public void insertData(String[] datas) {
		//System.out.println(datas.length);
		for(int i=0; i < datas.length; i++) {
			StringTokenizer tok = new StringTokenizer(datas[i], ",");
			String irum = tok.nextToken();
			int kor = Integer.parseInt(tok.nextToken());
			int eng = Integer.parseInt(tok.nextToken());
			int mat = Integer.parseInt(tok.nextToken());
			
			Ex37HaksaengDto dto = new Ex37HaksaengDto(irum, kor, eng, mat); // 생성자로 값 입력
			// dto.setName(irum); // setter로 값 입력
			list.add(dto);
			
		}
		
	}
	 
	public void showData() {
		//System.out.println(list.size());
		System.out.println("이름\t총점\t평균");
		
		for(int i = 0; i< list.size(); i++) {
			// Ex37HaksaengDto dto = new Ex37HaksaengDto();
			// dto = list.get(i);
			Ex37HaksaengDto dto = list.get(i);
			int tot = dto.getKor() + dto.getEng() + dto.getMat();
			double avg = tot / 3.0;
			System.out.println(dto.getName() + "\t" + tot + "\t" + avg);
		}
		
		
		System.out.println("\n향상된 for 사용");
		for(Ex37HaksaengDto dto:list) {
			int tot = dto.getKor() + dto.getEng() + dto.getMat();
			double avg = tot / 3.0;
			System.out.println(dto.getName() + "\t" + tot + "\t" + avg);
		}
	}

	public static void main(String[] args) {
		
		String [] datas = new String[3];
		datas[0] = "김밥,100,100,100";
		datas[1] = "공기밥,90,78,77";
		datas[2] = "주먹밥,70,70,88";
		
		
		Ex37DtoTest3 test3 = new Ex37DtoTest3();
		// 참고 : 문자열 분리 클래스 경험하기
		test3.stringSplitTest();
		System.out.println();
		test3.insertData(datas);
		test3.showData();

	}

}
