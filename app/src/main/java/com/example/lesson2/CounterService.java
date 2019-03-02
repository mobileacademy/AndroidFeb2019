package com.example.lesson2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

public class CounterService extends Service {

    public CounterService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("counterService", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("counterService", "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("counterService", "onStartCommand");

        // on main thread

        if (intent != null) {
            String action = intent.getAction();

            if (action != null && action.equals(MainActivity.COUNT_ACTION)) {

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        count();
                    }
                };

                new Thread(runnable).start();


            } else if (action != null && action.equals(MainActivity.LIST_PACKAGES_ACTION)) {
                // get all apps installed on device
            }

        }



        return START_NOT_STICKY;
    }

    private void count() {
        int i = 0;
        while (i< 10) {
            i++;
            Log.d("counterService", "second: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        EventBus.getDefault().post(new CountingDoneEvent(true));
    }
}
