package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SangpumMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");

        MyInter inter = (MyInter) context.getBean("myImpl");

        inter.inputData();
        inter.showResult();
    }
}