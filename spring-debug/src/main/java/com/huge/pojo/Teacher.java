package com.huge.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author by hyb
 * @date 2022/3/13 18:13
 */
@Component
public class Teacher implements BeanPostProcessor, BeanNameAware, BeanFactoryAware, ApplicationContextAware,  InitializingBean {

	@Autowired
	private School school;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("set bean factory");
	}

	@Override
	public void setBeanName(String name) {
		beanName = name;
		System.out.println("set bean name");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("set applicationContext");
	}


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization");
		return null;
	}


	public Teacher() {

	}

	private String name;

	private int age;

	private String beanName;

	public String getBeanName() {
		return beanName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
