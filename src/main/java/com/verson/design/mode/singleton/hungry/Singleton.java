package com.verson.design.mode.singleton.hungry;

/**
 * Created by verson on 2017/5/25.
 */
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

}
