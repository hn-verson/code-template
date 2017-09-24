package com.verson.design.mode.ProducerConsumer.improve;

/**
 * Created by Verson on 2016/7/11.
 */
public class Producer implements Runnable {
    private WareHouse wareHouse;
    private int quantity;
    public Producer(WareHouse wareHouse,int quantity){
        this.wareHouse = wareHouse;
        this.quantity = quantity;
    }

    public void run() {
        wareHouse.produce(quantity);
    }
}
