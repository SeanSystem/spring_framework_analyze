package com.huge.pojo;

import com.huge.annotion.MyComponent;

/**
 * @author by hyb
 * @date 2022/5/3 17:07
 */
@MyComponent
public class School {

	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
