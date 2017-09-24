package com.verson.design.mode.singleton.holder;

/**
 * Created by verson on 2017/5/25.
 */
public class Singleton {

    private Singleton() {}

    private static class Holder {
        public static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.instance;
    }

}
