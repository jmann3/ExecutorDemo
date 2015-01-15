package com.isobar.jmann.studiounittests.executor;

import android.os.Handler;
import android.util.Log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jmann on 1/4/15.
 */
public class BlockingQueue {

    CustomThreadPoolExecutor executor;
    public static final int BLOCKING_QUEUE_SIZE = 40;
    Integer threadCounter = 0;

    public BlockingQueue() {

        int maxThreads = Runtime.getRuntime().availableProcessors();
        Log.i("BlockingQueue", "maxThreads is " + maxThreads);

        executor = new CustomThreadPoolExecutor(maxThreads, maxThreads, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(BLOCKING_QUEUE_SIZE, true));

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(final Runnable r, final ThreadPoolExecutor executor) {
                Log.i("CustomThreadPoolExecutor", "DemoTask Rejected " + ((DemoRunnable)r).getName());

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("CustomThreadPoolExecutor", "Lets add another time : "
                                + ((DemoRunnable) r).getName());
                        executor.execute(r);
                    }
                }, 1000);
            }
        });

    }

    public void startExecutor() {
        while (true) {
            threadCounter++;

            // Add individual threads
            Log.i("BlockingQueue", "Adding DemoTask : " + threadCounter);
            executor.execute(new DemoRunnable(threadCounter.toString()));

            if (threadCounter == 100)
                break;
        }
    }

    public void stopExecutor() {

        executor.shutdown();

//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            public void run() {
//                executor.shutdown();
//                try {
//                    if (!executor.awaitTermination(1, TimeUnit.MINUTES)) { //optional *
//                        Log.i("BlockingQueue", "Executor did not terminate in the specified time."); //optional *
//                        List<Runnable> droppedTasks = executor.shutdownNow(); //optional **
//                        Log.i("BlockingQueue", "Executor was abruptly shut down. " + droppedTasks.size() + " tasks will not be executed."); //optional **
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}
