package com.rao.study.dubbo.client.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rao.study.dubbo.api.service.AnnotationService;
import com.rao.study.dubbo.client.service.TestAnnotationService;
import org.springframework.stereotype.Service;

@Service
public class TestAnnotationServiceImpl implements TestAnnotationService {

    @Reference(timeout = 1000)   //使用dubbo中的这个注解,等价于<dubbo:reference> ,需要使用dubbo的DubboComponentScan才能解析
    private AnnotationService annotationService;

    public String testSayHello(String name) {
        return annotationService.sayHello(name);
    }

    public String testSayBye(String name) {
        return annotationService.sayBye(name);
    }
}
