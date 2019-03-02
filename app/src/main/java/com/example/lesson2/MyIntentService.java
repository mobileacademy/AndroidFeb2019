package com.example.lesson2;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        // on background thread
        if (intent != null) {
            final String action = intent.getAction();
            if (MainActivity.COUNT_ACTION.equals(action)) {

                // count
                count();
            } else if (MainActivity.LIST_PACKAGES_ACTION.equals(action)) {
               // list packages
            }
        }
    }

    private void count() {
        int i = 0;
        while (i< 10) {
            i++;
            Log.d("intentService", "second: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
