package com.example.ottoexperiment;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

/**
 * Created by rupam.ghosh on 09/01/16.
 */
public class AppService extends BaseService {

    int clickCount;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Subscribe
    public void dataReceivedFromFragmentOne(FragmentOneButtonClickEvent event) {
        clickCount++;
        Toast.makeText(this, "Received in Service click count: " + clickCount, Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void dataReceivedFromFragmentTwo(FragmentTwoButtonClickEvent event) {
        clickCount++;
        Toast.makeText(this, "Received in Service click count: " + clickCount, Toast.LENGTH_SHORT).show();
    }
}
