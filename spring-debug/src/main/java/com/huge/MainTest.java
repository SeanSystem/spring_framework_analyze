package com.huge;

import com.huge.annotion.ApplicationContext;

/**
 * @author by hyb
 * @date 2022/5/4 16:09
 */
public class MainTest {

	public static void main(String[] args) {
		String packagePath = "com.huge.pojo";
		ApplicationContext context = new ApplicationContext(packagePath);
		Object school = context.getBean("school");
		System.out.println(school);
	}
}
