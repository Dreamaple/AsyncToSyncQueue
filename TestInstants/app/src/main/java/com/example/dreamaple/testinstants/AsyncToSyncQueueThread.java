package com.example.dreamaple.testinstants;

import java.util.concurrent.LinkedBlockingQueue;

public class AsyncToSyncQueueThread extends Thread {
    private LinkedBlockingQueue<UnitEngineering> unitEngineerings = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<UnitEngineering> Temp = new LinkedBlockingQueue<>();
    private static AsyncToSyncQueueThread instance;

    private AsyncToSyncQueueThread() {
    }

    private boolean isStop = true;
    boolean flag = false;

    public static AsyncToSyncQueueThread getInstance() {
        if (instance == null) {
            instance = new AsyncToSyncQueueThread();
        }
        return instance;
    }

    public void addingWorks(UnitEngineering unitEngineering) {
        if (flag && Temp.size() == 0) {
            unitEngineerings.offer(unitEngineering);
        } else {
            Temp.offer(unitEngineering);
        }
        flag = false;
    }

    public void addQueueWithTemp() {
        flag = true;
        UnitEngineering poll = Temp.poll();
        if (poll != null) {
            unitEngineerings.offer(poll);
        }
    }

    public AsyncToSyncQueueThread startWorkQueue(UnitEngineering unitEngineering) {
        if (isStop) {
            instance.start();
            unitEngineerings.offer(unitEngineering);
        } else {
            if (Temp.size() == 0) {
                unitEngineerings.offer(unitEngineering);
            } else {
                Temp.offer(unitEngineering);
            }
        }
        return instance;
    }

    @Override
    public synchronized void start() {
        super.start();
        isStop = false;
    }

    public void shutDown() {
        isStop = true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (isStop) {
                    break;
                }
                unitEngineerings.take().execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
