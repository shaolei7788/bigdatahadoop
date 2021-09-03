package com.nx.rpc.netty1.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.concurrent.Callable;

/**
 * 客户端的处理类
 **/
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    // 上下文对象，因为将来要在 call 方法中使用
    private ChannelHandlerContext context;

    // 存放业务处理结果
    private String result;

    // 存放请求的一些参数
    private String requestParam;

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    @Override
    public synchronized Object call() throws Exception {
        System.out.println("NettyClientHandler call() Invoacated ... ");
        // 发送请求
        context.writeAndFlush(requestParam);
        // 发送完了请求之后，等待....
        wait();
        // 被唤醒之后，继续处理（返回结果即可）
        return result;
    }

    /**
     * @param ctx
     * @throws Exception
     * 当 该 NettyClientHandler 被初始化的时候，就会调用 该 channelActive 方法一次
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(" channelActive 被调用  ");
        // 向服务端发送请求。
        this.context = ctx;
    }

    /**
     * @param ctx
     * @param msg
     * @throws Exception
     * channelRead 用来处理服务端返回来的数据。
     */
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        System.out.println("Client received result: " + result);
        //唤醒线程
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
