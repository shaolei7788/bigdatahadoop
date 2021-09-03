package com.nx.rpc.netty1.client;

import com.nx.rpc.netty1.service.DateTimeService;
import com.nx.rpc.netty1.util.Constants;

/**
 * NettyRPC 的 client 启动类
 **/
public class NettyClientBootstrap {

    public static void main(String[] args) {
        // 启动服务端
        NettyClient client = new NettyClient(Constants.REMOTE_HOST, Constants.PORT);

        // 获取一个服务端 服务对象的代理对象
        Class serviceClass = DateTimeService.class;
        DateTimeService dateTimeServiceProxy = (DateTimeService)client.getProxy(serviceClass);
        // 调用服务
        String result = dateTimeServiceProxy.hello("huangbo");
        // 输出结果
        System.out.println("Client Received Result From Server: [" + result + "]");
    }
}
