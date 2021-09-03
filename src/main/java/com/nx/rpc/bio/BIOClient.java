package com.nx.rpc.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 描述：同步阻塞，一对一服务的客服端程序
 */
public class BIOClient {

    private static final int PORT = 9090;
    private static final int COUNT = 10;

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String order1 = "getNow";
        out.println(order1);
        System.out.println("client send order : " + order1);
        String readLine1 = in.readLine();
        System.out.println("client receive result : " + readLine1);

        if (socket != null) {
            socket.close();
            socket = null;
        }
    }
}
