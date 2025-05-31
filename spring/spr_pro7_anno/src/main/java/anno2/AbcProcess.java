package anno2;

import javax.annotation.Resource;

import anno1.SenderProcess;
import org.springframework.stereotype.Service;

@Service
public class AbcProcess {

	@Resource(name = "abc1") // java jdk가 지원, name에 의해 매핑
	private Abc1 abc1;
	
	private Abc2 abc2;

	
	@Resource(name = "abc2")
	public void setAbc2(Abc2 abc2) {
		this.abc2 = abc2;
	}
	
	public void showData() {
		abc1.setIrum("이장호");
		abc2.setNai(30);
		
		System.out.println("이름은 " + abc1.getIrum() + ", 나이는 " + abc2.getNai());
	}
}
