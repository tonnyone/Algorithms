package com.tonny.jdk8.action.lambda;

public class FunctionInterface {

    public static void process(Runnable r){
        r.run();
    }

    public static void f1(){

        Runnable r1 = () -> System.out.println("Hello World 1");
        Runnable r2 = new Runnable(){
            public void run(){
                System.out.println("Hello World 2");
            }
        };
        process(r1);
        process(r2);
        process(() -> System.out.println("Hello World 3"));
    }

    public static void main(String[] args) {
        f1();
    }
}
