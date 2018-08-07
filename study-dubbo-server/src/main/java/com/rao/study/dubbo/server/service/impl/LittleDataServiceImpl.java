package com.rao.study.dubbo.server.service.impl;

import com.rao.study.dubbo.api.service.LittleDataService;

public class LittleDataServiceImpl implements LittleDataService {
    public String sendLittleData() {
        return "传输小数据";
    }
}
