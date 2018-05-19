package com.zhoutong.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {
	@Pointcut("execution(* com.zhoutong.advice.*.*(..))")
	private void pointcut(){};
	
	@Before(value="pointcut()")
	public void before(){
		System.out.println("before");
	}
	@After("pointcut()")
	public void after(){
		System.out.println("after");
	}
}