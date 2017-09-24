package com.verson.design.mode.ProducerConsumer.trandition;

/**
 * Created by Verson on 2016/7/11.
 */
public class WareHouse {
    private int capacity;
    private int count;
    public WareHouse(int initialCapacity){
        if(initialCapacity < 1)
            throw new IllegalArgumentException("Illegal Capacity:" + initialCapacity);
        this.capacity = initialCapacity;
    }

    public void produce(int size){
        if(size < 1)
            throw new IllegalArgumentException("Illegal Produce Size:" + size);

        final Thread currentThread = Thread.currentThread();
        synchronized(this){
            while(true){
                try{
                    while(count == capacity)
                        wait();

                    int nextc = capacity - count;
                    if(size < nextc)
                        nextc = size;

                    size -= nextc;
                    count += nextc;
                    System.out.println(currentThread.getName() + " produce " + nextc + " products,current warehouse count:" + count);

                    notifyAll();

                    if(size <= 0)
                        break;

                }catch(InterruptedException ie){
                    notifyAll();
                    break;
                }
            }
        }
    }

    public void consume(int size){
        if(size < 1)
            throw new IllegalArgumentException("Illegal Size:" + size);

        final Thread currentThread = Thread.currentThread();
        synchronized(this){
            while(true){
                try{
                    while(count == 0)
                        wait();

                    int nextc = count;
                    if(size < nextc){
                        nextc = size;
                    }

                    size -= nextc;
                    count -= nextc;
                    System.out.println(currentThread.getName() + " consume " + nextc + " products,current warehouse count:" + count);

                    notifyAll();

                    if(size <= 0)
                        break;
                }catch(InterruptedException ie){
                    notifyAll();
                    break;
                }
            }
        }
    }
}
