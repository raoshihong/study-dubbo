package com.rao.study.dubbo.client.filter;

import com.alibaba.dubbo.rpc.*;

public class DirectServiceFilter implements Filter {//客户端进行拦截过滤,对应的配置文件必须是com.alibaba.dubbo.rpc.Filter纯文本,且在META-INF/dubbo下
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        System.out.println("过滤DirectService前"+invocation.getMethodName());
        Result result = invoker.invoke(invocation);
        System.out.println("过滤DirectService后"+invocation.getInvoker().getInterface().getName());
        return result;
    }
}
