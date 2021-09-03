package com.nx.rpc.netty1.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NettyRpc 的 客户端实现
 **/
public class NettyClient {

    // 主机名称，端口号
    private String hostname;
    private int port;

    public NettyClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
        // 初始化 NettyClient 对象的时候，就启动 NettyClient
        clientStart();
    }

    /**
     * 初始化一个线程池，用来处理服务端返回的结果数据
     */
    private static int cpu_cores = Runtime.getRuntime().availableProcessors();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(cpu_cores);

    private NettyClientHandler clientHandler;

    /**
     * 客户端的启动方法
     */
    public void clientStart() {
        clientStart0(hostname, port);
    }

    private void clientStart0(String hostname, int port) {

        // 服务工作组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        // 客户端服务启动类
        Bootstrap client = new Bootstrap();

        clientHandler = new NettyClientHandler();

        // 绑定服务参数
        client.group(workerGroup).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new StringEncoder())
                                .addLast(new StringDecoder())
                                .addLast(clientHandler);   // 客户端业务处理Handler
                    }
                });
        try {
            // 客户端启动
            client.connect(hostname, port).sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * NettyClient 端提供一个 代理方法，获取服务类的一个代理类
     *
     * @param serviceClass
     */
    public Object getProxy(final Class<?> serviceClass) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{serviceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("客户端发送的请求参数是：" + args[0].toString());
                clientHandler.setRequestParam(args[0].toString());
                return threadPool.submit(clientHandler).get();
            }
        });
    }
}
