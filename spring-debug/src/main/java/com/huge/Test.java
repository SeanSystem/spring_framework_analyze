package com.huge;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by hyb
 * @date 2022/3/13 17:44
 */
public class Test {

	public static void main(String[] args) {
		//AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		//applicationContext.refresh();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object school = context.getBean("school");
		Object teacher = context.getBean("teacher");
		System.out.println(teacher);
	}
}
