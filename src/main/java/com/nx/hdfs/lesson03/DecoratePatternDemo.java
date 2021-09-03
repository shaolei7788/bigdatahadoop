package com.nx.hdfs.lesson03;

/**
 *
 * 装饰模式
 */
public class DecoratePatternDemo {
    public static void main(String[] args) {
        SuperPerson superPerson = new SuperPerson(new Person());
        superPerson.superEat();

    }

    public static class Person{
        public void eat(){
            System.out.println("吃饭");
        }
    }

    public static class SuperPerson{
        private Person person;

        public SuperPerson(Person person) {
            this.person = person;
        }

        public void superEat(){
            System.out.println("来根烟把");
            person.eat();
            System.out.println("甜点");

        }
    }
}
