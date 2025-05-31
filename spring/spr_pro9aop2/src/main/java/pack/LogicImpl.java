package pack;

import org.springframework.stereotype.Service;

@Service // 객체가 만들어짐 싱글톤으로
public class LogicImpl implements LogicInter{
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void startProcess() {
		System.out.println("검증이 되었으므로 핵심 로직 수행");
		
	}
}
