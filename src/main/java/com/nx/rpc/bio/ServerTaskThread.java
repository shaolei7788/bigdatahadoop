package com.nx.rpc.bio;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

class ServerTaskThread implements Runnable {

    private Socket s = null;

    public ServerTaskThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " 正在提供服务");

        // 输入流用来获取到 客户端的请求输入
        InputStream inputStream = null;
        // 输出流用来给客户端进行反馈输出的
        OutputStream outputStream = null;

        try {
            inputStream = s.getInputStream();
            outputStream = s.getOutputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter out = new PrintWriter(outputStream, true);

            // 模拟服务端在不停的对 客户端 提供服务
            while (true) {

                System.out.println("服务器正等待客户端的输入...");
                // 阻塞(客户端发送了请求过来之后，这句代码就返回)
                String readLine = in.readLine();
                if (readLine == null) {
                    break;
                }
                System.out.println("receive client order : " + readLine);

                if (readLine.equals("getNow")) {
                    String now = getNow();
                    out.println(now);
                } else if (readLine.equals("getServerName")) {
                    String name = getServerName();
                    out.println(name);
                } else {
                    System.out.println("客户端 断开链接");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getNow() {
        return new SimpleDateFormat("yy-MM-dd HH:MM:ss").format(new Date());
    }

    public static String getServerName() {
        return "bigata02.naixue.com";
    }
}