package com.example.ottoexperiment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by rupam.ghosh on 08/01/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        BusProvider.getInstance().register(this);
        Intent intent = new Intent(this, AppService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        BusProvider.getInstance().unregister(this);
        unbindService(connection);
        super.onDestroy();
    }
}
