package com.verson.design.mode.singleton.dcl;

/**
 * Created by verson on 2017/5/25.
 */
public class Singleton {

    private static volatile Singleton instance;

    public int x;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance ==null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
