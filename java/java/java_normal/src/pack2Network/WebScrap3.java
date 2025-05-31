package pack2Network;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebScrap3 implements Runnable{
	// Thread를 이용하여 복수의 문서 읽기 (Multi tasking)
	private String url;
	private String title;
	
	public WebScrap3(String url, String title) {
		this.url = url;
		this.title = title;
	}
	
	@Override
	public void run() {
		try {
			Document doc = Jsoup.connect(url).get();	
			String text = doc.text();  // 웹 페이지의 모든 텍스트를 추출
			
			System.out.println("-------------");
			System.out.println("문서 제목 : " + title);
			
			printKorText(text);
		} catch (Exception e) {
			System.out.println("run err : " + e);
		}
	}
	
	public void printKorText(String text) {
		// 정규 표현식 사용
		// 프로그래밍에서 문자열을 다룰 때, 문자열의 일정한 패턴을 표현하는 일종의 형식 언어를 말한다.
		Pattern pattern = Pattern.compile("[가-힣\\s]+");  // 정규 표현식 패턴 작성
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			String line = matcher.group().trim();  // 앞뒤 공백 제거
			if(!line.isEmpty() && line.length() > 1) {  // 빈 줄, 1글자 아닌 경우만 출력
				System.out.println(line);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		String[] titles = {"백설공주","인어공주"}; 
		
		String[] urls = {
			"https://ko.wikipedia.org/wiki/" + URLEncoder.encode(titles[0], "utf-8"),
			"https://ko.wikipedia.org/wiki/" + URLEncoder.encode(titles[1], "utf-8")
		};
		
		for(int i=0; i < urls.length; i++) {
			Thread thread = new Thread(new WebScrap3(urls[i],titles[i]));
			thread.start();
		}
	}

}