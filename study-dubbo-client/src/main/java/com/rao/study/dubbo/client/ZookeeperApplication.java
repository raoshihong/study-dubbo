package com.rao.study.dubbo.client;

import com.rao.study.dubbo.api.service.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZookeeperApplication {
    public static void main(String[] args){
        ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-context.xml"});
        DemoService demoService = ctxt.getBean(DemoService.class);
        System.out.println(demoService.sayHello("raoshihong"));
        System.out.println(demoService.sayBye("raoshihong"));
    }
}
