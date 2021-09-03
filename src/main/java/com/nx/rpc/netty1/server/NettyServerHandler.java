package com.nx.rpc.netty1.server;

import com.nx.rpc.netty1.service.impl.DateTimeServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 *  服务处理类实现
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext context, Object msg) throws Exception {
        System.out.println("Server has received Message: [" + msg + "]");

        // 处理参数
        String name = msg.toString();

        // 先做一个最简单的服务实现
        String result = new DateTimeServiceImpl().hello(name);

        // 返回业务处理结果
        context.writeAndFlush(result);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) throws Exception {
        context.close();
    }
}
