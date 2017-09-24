package com.verson.design.mode.ProducerConsumer.improve;

/**
 * Created by Verson on 2016/7/11.
 */
public class Consumer implements Runnable {
    private WareHouse wareHouse;
    private int quantity;
    public Consumer(WareHouse wareHouse,int quantity){
        this.wareHouse = wareHouse;
        this.quantity = quantity;
    }

    public void run() {
        wareHouse.consume(quantity);
    }
}
