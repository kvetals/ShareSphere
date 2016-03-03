package com.insart.traineeprogram.utils;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringUtils {
	public static GenericXmlApplicationContext getContext(){
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring.settings.xml");
        context.refresh();
        return context;
	}

}
