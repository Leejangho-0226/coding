package pack2Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/*
소켓(Socket)은 TCP/IP 기반 네트워크 통신에서 데이터 송수신의 마지막 접점을 말합니다. 
소켓통신은 이러한 소켓을 통해 서버-클라이언트간 데이터를 주고받는 양방향 연결 지향성 통신을 말합니다. 
소켓통신은 보통 지속적으로 연결을 유지하면서 실시간으로 데이터를 주고받아야 하는 경우에는 사용됩니다. 
소켓은 클라이언트 소켓과 서버 소켓으로 구분되며, 소켓간 통신을 위해서는 네트워크상에서 클라이언트와 서버에 
해당되는 컴퓨터를 식별하기 위한 IP주소와 해당 컴퓨터내에서 현재 통신에 사용되는 응용프로그램을 식별하기 위한 
포트번호가 사용됩니다. 
 
2. 서버와 클라이언트
소켓통신에서는 서버와 클라이언트가 존재하며, 서버(Server)는 데이터를 제공하는 쪽을 말하며, 
클라이언트(Client)는 데이터를 요청하여 제공받는 쪽을 말합니다. 
*/

public class NetServer1 {

	public static void main(String[] args) {
		// 단순 에코 서버
		ServerSocket serverSocket = null;   // 서버소켓 생성
		
		// 내 컴퓨터가 사용 중인  port number 확인
		/*
		for(int i=0; i < 65536; i++) {
			try {
				serverSocket = new ServerSocket(i);
				serverSocket.close();
			} catch (Exception e) {
				System.out.println(i + "번 포트번호는 사용 중");
			}
		}
		System.out.println("확인 완료");
		*/
		
		Socket socket = null;  // 클라이언트와 송수신을 위함
		try {
			serverSocket = new ServerSocket(8888);  // ip와 port number를 binding한 후 listening
			System.out.println("서버 서비스 시작 ...");
			
			// ServerSocket이 클라이언트 요청을 대기하다가 접속하면 클라이언트와 통신하기 위한 Socket 객체 생성
			socket = serverSocket.accept();  
			
			// 현재 웹서버는 실험용으로 클라이언트의 메세지를 받아 출력하고 종료하는 일회용 서비스
			BufferedReader reader = 
					new BufferedReader(
							new InputStreamReader(
									socket.getInputStream(), StandardCharsets.UTF_8));
			String data = reader.readLine();
			System.out.println("수신된 자료 : " + data);
			
			reader.close();
			socket.close();
			serverSocket.close();
		} catch (Exception e) {
			System.out.println("server err : " + e);
		}
	}
}