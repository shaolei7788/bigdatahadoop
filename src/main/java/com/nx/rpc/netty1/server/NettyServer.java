package com.nx.rpc.netty1.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 服务端实现
 **/
public class NettyServer {

    // 主机名称，端口号
    private String hostname;
    private int port;

    public NettyServer(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * 对外公开的方法
     */
    public void serverStart() {
        serverStart0(hostname, port);
    }

    /**
     * 启动服务的私有方法实现。
     * @param hostname 主机名称
     * @param port     端口号
     */
    private void serverStart0(String hostname, int port) {
        // 处理 ACCEPT 事件的线程工作组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);

        // 处理 READ/WRITER 时间的线程工作组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors());

        ServerBootstrap server = new ServerBootstrap();

        server.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new StringEncoder())
                                .addLast(new StringDecoder())
                                .addLast(new NettyServerHandler());     // 此处添加业务处理Handler
                    }
                });
        try {
            // 启动服务
            ChannelFuture channelFuture = server.bind(hostname, port).sync();
            System.out.println("NettyServer is started ..... ");
            // 关闭服务
            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
