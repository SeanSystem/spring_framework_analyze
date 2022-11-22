package com.huge.pojo;

import com.huge.annotion.MyComponent;
import org.springframework.stereotype.Component;

/**
 * @author by hyb
 * @date 2022/5/3 17:07
 */
@Component
public class School {

	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
