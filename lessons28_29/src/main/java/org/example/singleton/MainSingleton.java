package org.example.singleton;

public class MainSingleton {

    public static void main(String[] args) {

        SingletonLazyLoaded x = SingletonLazyLoaded.getInstance();
        SingletonLazyLoaded y = SingletonLazyLoaded.getInstance();
        SingletonLazyLoaded z = SingletonLazyLoaded.getInstance();

        System.out.println("String from x " + x);
        System.out.println("String from y " + y);
        System.out.println("String from z " + z);

    }

}
