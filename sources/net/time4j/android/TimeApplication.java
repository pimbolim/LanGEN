package net.time4j.android;

import android.app.Application;
import android.content.Context;

public abstract class TimeApplication extends Application {
    public void onCreate() {
        super.onCreate();
        ApplicationStarter.initialize((Context) this, false);
    }
}
