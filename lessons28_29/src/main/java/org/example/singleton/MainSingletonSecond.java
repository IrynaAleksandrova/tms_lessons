package org.example.singleton;

public class MainSingletonSecond {
    public static void main(String[] args) {

        SingletonLazyLoaded q = SingletonLazyLoaded.getInstance();
        SingletonLazyLoaded w = SingletonLazyLoaded.getInstance();
        SingletonLazyLoaded e = SingletonLazyLoaded.getInstance();

        System.out.println("String from q " + q);
        System.out.println("String from w " + w);
        System.out.println("String from e " + e);

    }
}
