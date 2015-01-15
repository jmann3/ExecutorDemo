package com.isobar.jmann.studiounittests.executor;

import android.util.Log;

/**
 * Created by jmann on 1/4/15.
 */
public class DemoRunnable implements Runnable {

    private String name = null;

    public DemoRunnable(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("DemoThread", "Executing : " + name);
    }
}
