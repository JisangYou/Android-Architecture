package com.example.jetpack;

import android.content.Context;

import javax.security.auth.callback.Callback;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLocationListener implements LifecycleObserver {
    private boolean enabled = false;
    private Lifecycle lifecycle;
    private Context context;

    public MyLocationListener(Context context, Lifecycle lifecycle, Callback callback) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {
        if (enabled) {

        }
    }

    public void enable() {
        enabled = true;
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {// 현재 상태를 쿼리
            // 위치 서비스가 연결되지 않았다면 연결한다.
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {
        //연결된 위치 서비스를 끊는다.
    }
}
