package org.example.singleton;

import lombok.ToString;

@ToString
public class SingletonLazyLoaded {
    private static SingletonLazyLoaded instance;

    private SingletonLazyLoaded() {
        String text = "Hello, I'm Singleton";
        System.out.println(text);
    }

    public static SingletonLazyLoaded getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyLoaded.class) {
                if (instance == null) {
                    instance = new SingletonLazyLoaded();
                }
            }
        }
        return instance;
    }
}
