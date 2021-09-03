package com.nx.rpc.netty2.bootstrap;

import com.nx.rpc.netty2.common.NettyProperties;
import com.nx.rpc.netty2.common.ProxyFactory;
import com.nx.rpc.netty2.service.HelloService;

/**
 * 一个客户端测试案例
 **/
public class NettyRpcClientBootstrap {

    public static void main(String[] args) {

        /**
         * 解析参数，获取端口号。
         */
        String host = NettyProperties.REMOTE_HOST;
        int port = NettyProperties.PORT;
        if(args.length == 2){
            host = args[0];
            port = Integer.parseInt(args[1]);
        }

        /**
         * 请求服务，获取服务代理对象
         */
        HelloService helloServiceProxy = ProxyFactory.create(host, port, HelloService.class);

        // 发起请求，拿到结果
        String result = helloServiceProxy.hello("huangbo");

        System.out.println("从服务端接收到返回结果：" + result);
    }
 }
