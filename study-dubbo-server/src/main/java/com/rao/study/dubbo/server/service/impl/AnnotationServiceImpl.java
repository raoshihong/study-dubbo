package com.rao.study.dubbo.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.rao.study.dubbo.api.service.AnnotationService;

@Service  //使用dubbo的Service注解,会自动创建ServiceConfig对象,并绑定应用和注册中心
public class AnnotationServiceImpl implements AnnotationService {
    public String sayHello(String name) {
        return "你好 " +name;
    }

    public String sayBye(String name) {
        return "再见 "+ name;
    }
}
