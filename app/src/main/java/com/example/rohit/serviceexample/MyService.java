package com.example.rohit.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * service class to play default phone ringtone.
 */

public class MyService extends Service {
    //creating a mediaplayer object
      Ringtone ringtone;
    

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       
        // getting the ringtone using RingtoneManager
        Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
       
        ringtone = RingtoneManager.getRingtone(getApplicationContext(),  alert);
        ringtone.setStreamType(AudioManager.STREAM_RING);
        ringtone.play();

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        // stopping the service
        ringtone.stop();
    }
}
