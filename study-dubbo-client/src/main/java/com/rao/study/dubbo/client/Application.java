package com.rao.study.dubbo.client;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.rao.study.dubbo.api.service.*;
import com.rao.study.dubbo.client.check.Duplicate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Application {

    static {
        Duplicate.checkDuplicate(Filter.class);//检测类是否重复
    }

    public static void main(String[] args){
        ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-context.xml"});
        DemoService demoService = ctxt.getBean(DemoService.class);
        System.out.println(demoService.sayHello("raoshihong"));
        System.out.println(demoService.sayBye("raoshihong"));
        DirectService directService = ctxt.getBean(DirectService.class);
        System.out.println(directService.testDirect());


        //多协议测试
        LittleDataService littleDataService = ctxt.getBean(LittleDataService.class);
        System.out.println(littleDataService.sendLittleData());
        BigDataService bigDataService = ctxt.getBean(BigDataService.class);
        System.out.println(bigDataService.sendBigData());
        MutilProtocolService mutilProtocolService = ctxt.getBean(MutilProtocolService.class);
        System.out.println(mutilProtocolService.mutilProtocol());

        //分组服务
        GroupService feedbackGroupService = (GroupService) ctxt.getBean("feedbackGroupService");
        System.out.println(feedbackGroupService.testGroup());
        GroupService memberGroupService = (GroupService) ctxt.getBean("memberGroupService");
        System.out.println(memberGroupService.testGroup());

//        String url = "dubbo://172.30.49.184:20881/com.rao.study.dubbo.api.service.GroupService2?anyhost=true&application=study-dubbo-server&dubbo=2.6.1&generic=false&group=memberGroup&interface=com.rao.study.dubbo.api.service.GroupService&methods=testGroup&pid=10948&side=provider&timestamp=1533608994377";
//        DubboProtocol dubboProtocol = DubboProtocol.getDubboProtocol();
//        Map<String,String> params = new HashMap<String, String>();
//        params.put("application","study-dubbo-client");
//        params.put("category","providers,configurators,routers");
//        params.put("dubbo","2.6.1");
//        params.put("group","memberGroup");
//        params.put("interface","com.rao.study.dubbo.api.service.GroupService");
//        params.put("methods","testGroup");
//        params.put("pid","12720");
//        params.put("side","consumer");
//        params.put("timestamp","1533609396899");
//        URL url1 = new URL("consumer","172.30.49.184",20881,"com.rao.study.dubbo.api.service.GroupService2",params);
//
//        Invoker<GroupService> invoker = dubboProtocol.refer(GroupService.class,url1);

    }
}
