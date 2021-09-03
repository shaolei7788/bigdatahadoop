package com.nx.hadoop.lesson01;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class DFSClient {
    public static void main(String[] args) throws IOException {
        ClientProtocol namenode = RPC.getProxy(ClientProtocol.class,
                ClientProtocol.versionID,
                new InetSocketAddress("localhost",9999),
                new Configuration());

        System.out.println("客户端");
        namenode.makeDir("/user/opt/soft");

        namenode.regisger("localhost",8888);
    }
}
