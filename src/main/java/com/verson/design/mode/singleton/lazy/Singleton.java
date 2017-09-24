package com.verson.design.mode.singleton.lazy;

/**
 * Created by verson on 2017/5/24.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

}
