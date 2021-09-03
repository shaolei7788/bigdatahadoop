package com.nx.rpc.netty1.server;

import com.nx.rpc.netty1.util.Constants;

/**
 * NettyRpc 的服务端启动类实现
 **/
public class NettyServerBootstrap {

    public static void main(String[] args) {

        // 初始化服务端
        NettyServer nettyServer = new NettyServer(Constants.REMOTE_HOST, Constants.PORT);

        // 启动服务端
        nettyServer.serverStart();
    }
}
