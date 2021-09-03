package com.nx.hadoop.lesson01;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

/**
 * namenode:
 *  RPC
 *
 */

public class NameNodeRpcServer implements ClientProtocol {
    /**
     * 创建目录
     */
    public void makeDir(String path) {
        System.out.println("服务端："+path);
    }

    public void regisger(String hostname, int port) {
        System.out.println("zhuce"+hostname + " "+ port);

    }

    public static void main(String[] args) throws Exception {
            Server server = new RPC.Builder(new Configuration())
                    .setBindAddress("localhost")
                    .setPort(9999)
                    .setProtocol(ClientProtocol.class)
                    .setInstance(new NameNodeRpcServer())
                    .build();

        System.out.println("服务端启动");

        //启动服务端
        server.start();

    }
}
