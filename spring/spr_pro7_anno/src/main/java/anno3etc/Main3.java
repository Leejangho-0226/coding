package anno3etc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {
	public static void main(String[] arg) {
		ApplicationContext context = new ClassPathXmlApplicationContext("anno3.xml");
		MyProcess myProcess = (MyProcess)context.getBean("my");
		myProcess.showDatas();
	}
}
