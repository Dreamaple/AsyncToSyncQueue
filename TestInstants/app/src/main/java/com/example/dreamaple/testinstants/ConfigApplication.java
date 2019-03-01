package com.example.dreamaple.testinstants;

import android.app.Application;

public class ConfigApplication extends Application {
    private static ConfigApplication configApplication;

    private static int queueId = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        configApplication = this;
    }

    public static ConfigApplication getConfigApplication() {
        return configApplication;
    }

    public static long getQueueId() {
        return queueId++;
    }
}
