package com.rao.study.dubbo.server.filter;

import com.alibaba.dubbo.rpc.*;

public class DemoFilter implements Filter {//过滤器一定要实现Filter接口，同时需要在META-INF/dubbo下添加过滤配置
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("调用过滤前");
        Result result = invoker.invoke(invocation);
        System.out.println("调用过滤后");
        return result;
    }
}
