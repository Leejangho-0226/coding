package anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//@Component("senderProcess")
@Service // 객체를 만들고 이 클래스의 하는 일까지 설명, 비지니스 로직 , 업무처리 담당
//@Service("senderProcess")
public class SenderProcess {
	//@Autowired  // field injection 간단하기에 주로 사용, type에 의한 매핑(연결), 멤버필드에 @Autowired써주면 끝, 전제조건 : @Component로 만들어져 있어야함.
	//private Sender sender;
	
	@Autowired
	@Qualifier("sender2") // 여러 자식 객체 중 매핑할 객체변수 이름을 적으면 오류가 사라짐, @Qualifier 혼자 아무것도 못함
	private SenderInter senderInter;
	
	/*
	@Autowired // setter injection을 자동으로 처리, setter가 많아지면 코드가 난잡하다
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	@Autowired // Constructor injection을 자동으로 처리, 불변성의 장점이 있으나 생성자가 많아지면 난잡해짐
	public SenderProcess(Sender sender) {
		this.sender = sender;
	}
	*/
	
	public void displayData() {
		//sender.show();
		senderInter.show();
	}
}
