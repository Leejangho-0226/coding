package pack2Network;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class NetClient1 {
	public static void main(String[] args) {
		// 일회용 echo server에 접속 후 메세지 전송용
		try {
			// 서버 socket과 통신하기 socket 객체 생성 후 접속 (서버의 serverSocket.accept()를 만남)
			Socket socket = new Socket("192.168.0.50", 8888);
			
			PrintWriter writer = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			writer.println("안녕 난 장호라고 해" + "\n");   // 서버로 자료 전송
			writer.close();
			
			socket.close();
		} catch (Exception e) {
			System.out.println("client err : " + e);
		}
	}

}
