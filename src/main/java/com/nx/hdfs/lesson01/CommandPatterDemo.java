package com.nx.hdfs.lesson01;

/**
 *
 * 指令设计模式
 */
public class CommandPatterDemo {
    public static void main(String[] args) {
        if(true) {
            Context context = new Context(new ReadCommand());
            context.execute();
        }
    }




    public interface Command{
        void execute();
    }

    public static class ReadCommand implements  Command{
        public void execute() {
            System.out.println("读请求");
        }
    }

    public static  class WriteCommand implements  Command{
        public void execute() {
            System.out.println("写请求");
        }
    }


    public static class Context{
        private Command command;

        public Context(Command command) {
            this.command = command;
        }

        public void execute(){
            this.command.execute();
        }
    }
}
