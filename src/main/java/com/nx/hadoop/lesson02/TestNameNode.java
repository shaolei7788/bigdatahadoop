package com.nx.hadoop.lesson02;

public class TestNameNode {
    public static void main(String[] args) {
        final FSEditLog fsEditLog = new FSEditLog();

        for (int i =0; i < 6; i++){
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        fsEditLog.logEdit("日志信息");
                    }
                }
            }).start();
        }
    }
}
