package com.rao.study.dubbo.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.rao.study.dubbo.api.service.DemoService;

public class ApiApplication {
    public static void main(String[] args) throws Exception{
        //设置当前应用配置,等价于<dubbo:application name="" >
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("study-dubbo-client");

        //配置注册中心 等价于<dubbo:register address="">
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("multicast://224.243.242.241:1287");

        //配置服务暴露的接口协议 等价于<dubbo:protocol port="">
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(20880);

        //创建消费者引用接口服务
        ReferenceConfig<DemoService> referenceConfig = new ReferenceConfig<DemoService>();//此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(DemoService.class);

        //每一个ReferenceConfig实例都是一个客户端接口服务实例
        DemoService demoService = referenceConfig.get();

        System.out.println(demoService.sayHello("你好"));

        System.in.read();
    }
}
