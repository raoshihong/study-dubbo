package com.rao.study.dubbo.server.service.impl;

import com.rao.study.dubbo.api.service.DirectService;

public class DirectServiceImpl implements DirectService {
    public String testDirect() {
        return "测试直连";
    }
}
