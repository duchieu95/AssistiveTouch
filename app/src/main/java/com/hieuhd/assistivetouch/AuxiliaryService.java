package com.hieuhd.assistivetouch;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by HieuHD on 9/11/2017.
 */

public class AuxiliaryService  extends Service implements EasyTouchView.ServiceListener {
    private Intent mIntent;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        // ´´½¨serviceÊ±Ò»¸ö ÊµÀý»¯Ò»¸öTableShowView¶ÔÏó²¢ÇÒµ÷ÓÃËûµÄfun()·½·¨°ÑËü×¢²áµ½windowManagerÉÏ
        super.onCreate();
        new EasyTouchView(this, this).initTouchViewEvent();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mIntent = intent;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void OnCloseService(boolean isClose) {
        stopService(mIntent);
    }
}
