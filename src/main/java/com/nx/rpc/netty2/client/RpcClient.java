package com.nx.rpc.netty2.client;

import com.nx.rpc.netty2.protocol.RpcRequest;
import com.nx.rpc.netty2.protocol.RpcResponse;

/**
 * TODO_MA 定义一个客户端的接口
 */
public interface RpcClient {

    // TODO_MA 发送请求
    RpcResponse send(RpcRequest request);

    // TODO_MA 链接服务器
    void connect(String hostname, int port);

    // TODO_MA 关闭客户端
    void close();
}