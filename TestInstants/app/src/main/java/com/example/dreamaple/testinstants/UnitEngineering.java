package com.example.dreamaple.testinstants;

import java.io.Serializable;

import static com.example.dreamaple.testinstants.ConfigApplication.getQueueId;

public abstract class UnitEngineering implements Serializable {
    final static public int FORWARD = 1;
    final static public int REVERSE = -1;

    private long id = -1;

    private int flag;

    private boolean isNetwork = false;

    private int networkType = FORWARD;

    UnitEngineering( int flag, boolean isNetwork, int networkType) {
        this.id = getQueueId();
        this.flag = flag;
        this.isNetwork = isNetwork;
        this.networkType = networkType;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public boolean isNetwork() {
        return isNetwork;
    }

    public void setNetwork(boolean network) {
        isNetwork = network;
    }

    public int getNetworkType() {
        return networkType;
    }

    public void setNetworkType(int networkType) {
        this.networkType = networkType;
    }

    abstract void execute();
}
