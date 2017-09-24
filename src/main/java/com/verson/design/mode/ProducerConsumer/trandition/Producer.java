package com.verson.design.mode.ProducerConsumer.trandition;

/**
 * Created by Verson on 2016/7/11.
 */
public class Producer implements Runnable {
    private WareHouse warehouse;
    private int quantity;

    public Producer(WareHouse warehouse,int quantity){
        this.warehouse = warehouse;
        this.quantity = quantity;
    }

    public void run() {
        warehouse.consume(quantity);
    }
}
