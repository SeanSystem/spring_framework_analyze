package com.huge.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author by hyb
 * @date 2022/5/4 15:44
 */
@Component
public class People {

	private String name;

	@Resource
	@Lazy
	private Teacher teacher2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher2() {
		return teacher2;
	}

	public void setTeacher2(Teacher teacher2) {
		this.teacher2 = teacher2;
	}
}
