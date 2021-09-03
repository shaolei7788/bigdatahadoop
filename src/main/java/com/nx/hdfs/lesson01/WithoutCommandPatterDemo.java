package com.nx.hdfs.lesson01;

public class WithoutCommandPatterDemo {
    public static void main(String[] args) {
        // Uitls utils= new Uitls();
        int sytle=1;
        if( 1 == sytle){
            Utils.read();
        }
        if( 2 == sytle){
            Utils.write();
        }


    }


    public static class Utils{
        public static void read(){
            System.out.println("读请求");
        }
        public static void write(){
            System.out.println("写请求");
        }

    }
}
