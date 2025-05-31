package pack2Network;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// jsoup은 실제 HTML 및 XML 작업을 단순화하는 Java 라이브러리
// DOM API 메서드, CSS 및 xpath 선택기를 사용하여 URL 가져오기, 데이터 구문 분석, 추출 및 조작을 위한 사용하기 쉬운 API를 제공합니다

public class WebScrap2 {

	public static void main(String[] args) {
		// https://ko.wikipedia.org/wiki/비욘세(이렇게 적으면 안보내짐)
		// https://ko.wikipedia.org/wiki/%EB%B9%84%EC%9A%98%EC%84%B8
		// URL 인코딩 (또는 퍼센트 인코딩)은
		// 특수 문자와 기타 예약된 문자들을 웹 주소 (URL)에서 안전하게 표현하기 위해 사용되는 방법입니다.
		// 이 방식은 일반적으로 웹 주소의 쿼리 문자열 부분에서 문자 인코딩을 위해 사용됩니다.
		// URL 인코딩은 다음과 같은 과정을 포함합니다:
		// 대상 문자열을 인코딩할 때, 각 문자를 해당 문자의 ASCII 코드 값으로 나타냅니다.
		// 특수 문자와 예약된 문자는 '%' 기호 뒤에 16진수 값으로 변환됩니다.
		try {
			// System.out.println(URLEncoder.encode("비욘세", "utf-8")); //
			// %EB%B9%84%EC%9A%98%EC%84%B8
			// 위키백과에서 비욘세를 검색해 해당 자료 읽기
			String url = "https://ko.wikipedia.org/wiki/" + URLEncoder.encode("비욘세", "utf-8");
			Document doc = Jsoup.connect(url).get();
			String text = doc.text(); // 웹 페이지의 모든 텍스트를 추출
			System.out.println(text);

			// 한글 데어터만 얻기
			printKorText(text);
		} catch (Exception e) {

		}
	}

	public static void printKorText(String text) {
		// 정규 표현식 사용
		// 프로그래밍에서 문자열을 다룰 때, 문자열의 일정한 패턴을 표현하는 일종의 형식 언어를 말한다
		Pattern pattern = Pattern.compile("[가-힣\\s]+"); // 정규 표현식 패턴 작성
		Matcher mattcher = pattern.matcher(text);
		while (mattcher.find()) {
			String line = mattcher.group().trim(); // 앞뒤 공백 제거
			if (!line.isEmpty()) { // 빈 줄이 아닌 경우만 출력
				System.out.println(line);
			}
		}

	}

}
