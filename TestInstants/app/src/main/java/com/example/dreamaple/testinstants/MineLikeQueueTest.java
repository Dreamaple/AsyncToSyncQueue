package com.example.dreamaple.testinstants;

import java.util.concurrent.LinkedBlockingQueue;

public class MineLikeQueueTest extends Thread {
    private LinkedBlockingQueue<UnitEngineering> unitEngineerings = new LinkedBlockingQueue<>();
    private static MineLikeQueueTest instance;
    private MineLikeQueueTest(){}
    private boolean isStop = true;
    public static MineLikeQueueTest getInstance(){
        if (instance == null) {
            instance = new MineLikeQueueTest();
        }
        return instance;
    }

    public boolean addingWorks(UnitEngineering unitEngineering) {
        return unitEngineerings.offer(unitEngineering);
    }

    public MineLikeQueueTest startWorkQueue() {
        if (isStop) {
            instance.start();
        }
        return instance;
    }

    @Override
    public synchronized void start() {
        super.start();
        isStop = false;
    }

    public void shutDown(){
        isStop = true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (isStop) {
                    break;
                }
                //todo 在这一步执行队列内部处理
                unitEngineerings.take().execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
