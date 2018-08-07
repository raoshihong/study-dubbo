package com.rao.study.dubbo.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args)throws Exception{
        ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-context.xml"});
        System.in.read();
    }

}
