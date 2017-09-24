package com.verson.design.mode.ProducerConsumer.improve;

import java.util.concurrent.locks.*;

/**
 * Created by Verson on 2016/7/11.
 */
public class WareHouse {
    private int capacity;
    private int size;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public WareHouse(int capacity){
        if(capacity < 1)
            throw new IllegalArgumentException("Illegal Argument capacity:" + capacity);
        this.capacity = capacity;
    }

    public void produce(int quantity){
        if(quantity < 1)
            throw new IllegalArgumentException("Illegal Argument quantity:" + quantity);

        lock.lock();
        try{
            while(quantity > 0){
                while(size == capacity)
                    notFull.await();
                int nextc = capacity - size;
                if(quantity < nextc)
                    nextc = quantity;

                size += nextc;
                System.out.println("Thread:" + Thread.currentThread().getName() + " produce " + nextc + " goods,current warehouse size:" + size);

                quantity -= nextc;

                notEmpty.signalAll();
            }
        }catch(InterruptedException ie){
            System.out.println("Thread:" + Thread.currentThread().getName() + " catch exception:" + ie);
        }finally{
            lock.unlock();
        }
    }

    public void consume(int quantity){
        if(quantity < 1)
            throw new IllegalArgumentException("Illegal Argument quantity:" + quantity);

        lock.lock();
        try{
            while(quantity > 0){
                while(size == 0)
                    notEmpty.await();

                int nextc = size;
                if(quantity < size)
                    nextc = quantity;

                size -= nextc;
                System.out.println("Thread:" + Thread.currentThread().getName() + " consume " + nextc + " goods,current warehouse size:" + size);

                quantity -= nextc;

                notFull.signalAll();
            }
        }catch(InterruptedException ie){
            System.out.println("Thread:" + Thread.currentThread().getName() + " catch exception:" + ie);
        }finally{
            lock.unlock();
        }
    }
}
