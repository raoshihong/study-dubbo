package com.rao.study.dubbo.server;

import com.alibaba.dubbo.config.*;
import com.rao.study.dubbo.api.service.DemoService;
import com.rao.study.dubbo.server.service.impl.DemoServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ApiApplication {
    public static void main(String[] args)throws Exception{

        //设置当前应用配置,等价于<dubbo:application name="" >
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("study-dubbo-server");

        //配置注册中心 等价于<dubbo:register address="">
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("multicast://224.243.242.241:1287");

        //配置服务暴露的接口协议 等价于<dubbo:protocol port="">
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(20880);

        //创建服务,ServiceConfig是一个重类，他会将注册中心的连接和协议及服务应用的绑定保存起来，所以需要进行缓存
        ServiceConfig serviceConfig = new ServiceConfig();//此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        serviceConfig.setApplication(applicationConfig);//绑定应用
        List<RegistryConfig> registryConfigs = new ArrayList<RegistryConfig>();
        registryConfigs.add(registryConfig);//添加多个注册中心
        serviceConfig.setRegistries(registryConfigs);
        List<ProtocolConfig> protocolConfigs = new ArrayList<ProtocolConfig>();
        protocolConfigs.add(protocolConfig);
        serviceConfig.setProtocols(protocolConfigs);//绑定多协议

        //添加接口服务 (一个ServiceConfig实例只能暴露一个接口,但是可以暴露一个接口的多个方法)
        DemoService demoService = new DemoServiceImpl();
        serviceConfig.setInterface(DemoService.class);//等价于<dubbo:service interface="" ref="">
        serviceConfig.setRef(demoService);

        //暴露指定的方法
        List<MethodConfig> methodConfigs = new ArrayList<MethodConfig>();
        MethodConfig methodConfig = new MethodConfig();
        methodConfigs.add(methodConfig);
        methodConfig.setName("sayHello");
        methodConfig.setTimeout(10000);
        serviceConfig.setMethods(methodConfigs);

        //暴露及注册服务接口
        serviceConfig.export();

        System.in.read();
    }
}
