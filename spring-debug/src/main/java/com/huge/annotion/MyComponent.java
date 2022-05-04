package com.huge.annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author by hyb
 * @date 2022/5/4 16:06
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyComponent {

	String value() default "";
}
