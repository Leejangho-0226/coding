package pack2Network;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.rmi.server.UID;

// 네트워크(Network) : 둘 이상의 컴퓨터를 연결하여 서로 통신할 수 있도록 하는 시스템
/*
 * Network 연결 방식

1. tcp : 연결이 지속되는 방식. 실시간 통신 가능. 신뢰도가 높으나 네트워크에 부하가 걸리기 쉽다.
         Socket, ServerSockt을 주로 사용.

2. www 기반의 URL은 Uniform Resource Locator의 약어가 URL이다. 자바의 URL클래스는 URL통신을 가능하게 한다.
     URL은 네트워크 상에서 해당 컴(자원)이 어디에 있는지를 알려주는 규약이다.
     http://www.daum.net:80/index.html 이라고 했을 때
      http : 프로토콜 식별자
      www.daum.net : 호스트 네임(도메인 네임) - ip address를 알아보기 쉽게 문자열로 표현
      80 : 웹서비스의 포트번호
      index.html : 찾고자 하는 파일네임


   URL 클래스의 생성자의 예 :
       new URL("http://www.daum.net:80/");
       new URL("http", "www.daum.net", "/index.html");
       new URL("http", "www.daum.net", 80, "/디렉토리/index.html");

3. udp : 비연결성 통신방식. 신뢰도는 낮으나 네트워크에 부하가 덜하다.
         DataGramSocket, DataGramPacket, MultiCastScoket을 주로 사용
 */

// URL을 사용해 특정 웹사이트의 문서 읽기(Scraping) 실습
public class WebScrap1 {
	public static void main(String[] args) {
		try {
			//URL url = new URL("https://www.naver.com");  // deprecated됨
			URI uri = URI.create("https://www.naver.com"); 
			URL url = uri.toURL();
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			PrintWriter pw = new PrintWriter(System.out, true);
			
			// 읽은 문서 파일로 저장
			PrintWriter fw = new PrintWriter(new FileOutputStream("c:/work/ok.html"));
			String line = "";
			while ((line = br.readLine()) != null){
				pw.println(line);
				fw.println(line);
				fw.flush();
				
			}
			
			br.close();
			is.close();
			pw.close();
			fw.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
			
			
		}

		
		
		
	}

}
