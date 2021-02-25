package org.techtown.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate 호출");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand 호출");
        if (intent == null) {
            return Service.START_STICKY;
        } else {
            processCommand(intent, flags, startId);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent, int flags, int startId) {
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.e("TAG", "command : " + command + ", name : " + name);

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.e(TAG, "Waiting " + i + "seconds.");
        }

        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);

        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        showIntent.putExtra("command", "show");
        showIntent.putExtra("name", name + "from service.");
        startActivity(showIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}