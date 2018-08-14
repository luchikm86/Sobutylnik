package com.sobutylnik.hello;

public class HelloWorld {
    public static void main(String[] args) {
        Runnable helloPrinter = () -> System.out.println("Hello");
        helloPrinter.run();
    }
}
