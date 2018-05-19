package com.zhoutong.advice;

import org.springframework.stereotype.Service;

@Service("done")
public class Done {
	public void doSomething(){
		System.out.println("dosomething!!");
	}
}