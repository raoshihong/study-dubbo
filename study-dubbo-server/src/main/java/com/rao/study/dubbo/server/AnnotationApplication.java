package com.rao.study.dubbo.server;

import com.rao.study.dubbo.server.config.DubboServerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplication {
    public static void main(String[] args)throws  Exception{
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(DubboServerConfig.class);
        ctxt.start();
        System.in.read();
    }
}
