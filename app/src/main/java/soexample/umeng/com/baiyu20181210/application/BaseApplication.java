package soexample.umeng.com.baiyu20181210.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import soexample.umeng.com.baiyu20181210.utils.ConnUtils;

/**
 * Created by Shinelon on 2018/12/10.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        boolean conn = ConnUtils.getConn(this);
    }
}
