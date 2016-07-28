package com.drartisan.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by summer on 16/3/29.
 */
public class Test {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-quartz.xml");
    }
}
