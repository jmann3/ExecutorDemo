package com.isobar.jmann.studiounittests.executor;

import android.util.Log;

import java.util.concurrent.*;

/**
 * Created by jmann on 1/4/15.
 */
public class CustomThreadPoolExecutor extends ThreadPoolExecutor {


    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, java.util.concurrent.BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);

        Log.i("CustomThreadPoolExecutor", "Perform beforeExecute() logic");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);

        if (t != null) {
            Log.i("CustomThreadPoolExecutor", "Perform afterExecute() logic");
        }
    }
}
