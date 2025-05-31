package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/*
		MessgeImpl m1 = new MessgeImpl("관우", "적토마");
		m1.sayHi();
		MessgeImpl m2 = new MessgeImpl("장비", "막내");
		m2.sayHi();
		System.out.println(m1 + " " + m2);
		*/
	
		// ApplicationContext context = new ClassPathXmlApplicationContext("classpath:init.xml");
		//GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:init.xml");
		 GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:pack/controller/init.xml");
		// singleton 확인
		MessageImpl messgeImpl = (MessageImpl)context.getBean("msgImpl");
		messgeImpl.sayHi();
		MessageImpl messgeImpl2 = (MessageImpl)context.getBean("msgImpl");
		messgeImpl2.sayHi();
		System.out.println(messgeImpl + " " + messgeImpl2);
		
		System.out.println();
		// 다양성
		MessageInter inter = (MessageInter)context.getBean("msgImpl");
		inter.sayHi();
		
		MessageInter inter2 = context.getBean("msgImpl", MessageInter.class);
		inter2.sayHi();
		
		context.close();

	}

}
