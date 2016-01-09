package com.example.ottoexperiment;

import android.app.Service;

/**
 * Created by rupam.ghosh on 09/01/16.
 */
public abstract class BaseService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        BusProvider.getInstance().unregister(this);
        super.onDestroy();
    }
}
