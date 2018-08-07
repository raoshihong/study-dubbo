package com.rao.study.dubbo.client;

import com.rao.study.dubbo.client.config.DubboClientConfig;
import com.rao.study.dubbo.client.service.TestAnnotationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplication {
    public static void main(String[] args)throws Exception{
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(DubboClientConfig.class);
        TestAnnotationService testDemoService = ctxt.getBean(TestAnnotationService.class);
        System.out.println(testDemoService.testSayBye("raoshihong"));
        System.out.println(testDemoService.testSayHello("raoshihong"));
    }
}
