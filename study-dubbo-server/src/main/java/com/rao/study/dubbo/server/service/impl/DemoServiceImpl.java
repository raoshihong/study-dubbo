package com.rao.study.dubbo.server.service.impl;

import com.rao.study.dubbo.api.service.DemoService;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello "+name;
    }

    public String sayBye(String name) {
        return "bye " + name;
    }
}
