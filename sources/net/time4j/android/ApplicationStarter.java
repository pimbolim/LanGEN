package net.time4j.android;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.compose.animation.core.AnimationKt;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.PlainTimestamp;
import net.time4j.SystemClock;
import net.time4j.android.spi.AndroidResourceLoader;
import net.time4j.base.ResourceLoader;
import net.time4j.format.DisplayMode;
import net.time4j.format.expert.ChronoFormatter;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

public class ApplicationStarter {
    private static final AtomicBoolean PREPARED = new AtomicBoolean(false);
    private static final AtomicBoolean REGISTERED = new AtomicBoolean(false);
    private static final int RELEASE_DAY = 27;
    private static final int RELEASE_MONTH = 3;
    private static final int RELEASE_YEAR = 2021;
    private static final String TIME4A = "TIME4A";
    private static final String VERSION = "v4.8-2021a";

    private ApplicationStarter() {
    }

    public static void initialize(Application application) {
        initialize((Context) application, false);
    }

    public static void initialize(Context context, boolean z) {
        StdPrefetch stdPrefetch = null;
        if (z) {
            stdPrefetch = new StdPrefetch();
        }
        initialize(context, (Runnable) stdPrefetch);
    }

    public static void initialize(Context context, Runnable runnable) {
        long nanoTime = System.nanoTime();
        prepareAssets(context, (AssetLocation) null);
        registerReceiver(context.getApplicationContext());
        PlainTimestamp at = PlainDate.of((int) RELEASE_YEAR, 3, 27).at(PlainTime.midnightAtStartOfDay());
        Log.i(TIME4A, "Starting Time4A (v4.8-2021a published on " + at.toDate() + ")");
        if (runnable != null) {
            Executors.defaultThreadFactory().newThread(runnable).start();
        }
        long nanoTime2 = (System.nanoTime() - nanoTime) / AnimationKt.MillisToNanos;
        Log.i(TIME4A, "Main-Thread consumed in ms: " + nanoTime2);
    }

    public static void prepareAssets(Context context, AssetLocation assetLocation) {
        if (!PREPARED.getAndSet(true)) {
            System.setProperty(ResourceLoader.EXTERNAL_RESOURCE_LOADER, "net.time4j.android.spi.AndroidResourceLoader");
            ((AndroidResourceLoader) ResourceLoader.getInstance()).init(context, assetLocation);
        }
    }

    public static void registerReceiver(Context context) {
        if (context != null && !REGISTERED.getAndSet(true)) {
            System.setProperty("net.time4j.allow.system.tz.override", "true");
            context.registerReceiver(new TimezoneChangedReceiver(), new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
        }
    }

    private static class TimezoneChangedReceiver extends BroadcastReceiver {
        private TimezoneChangedReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Timezone.Cache.refresh();
            Log.i(ApplicationStarter.TIME4A, "Event ACTION_TIMEZONE_CHANGED received, system timezone changed to: [" + Timezone.ofSystem().getID().canonical() + "]. Original tz-id reported by Android: [" + intent.getStringExtra("time-zone") + "]");
        }
    }

    private static class StdPrefetch implements Runnable {
        private StdPrefetch() {
        }

        public void run() {
            long nanoTime = System.nanoTime();
            TZID ofTotalSeconds = ZonalOffset.ofTotalSeconds(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000);
            Locale locale = Locale.getDefault();
            try {
                Moment currentMoment = SystemClock.currentMoment();
                ofTotalSeconds = Timezone.ofSystem().getID();
                Log.i(ApplicationStarter.TIME4A, "System time zone at start: [" + ofTotalSeconds.canonical() + "]");
                Log.i(ApplicationStarter.TIME4A, "System locale at start: [" + locale.toString() + "]");
                Log.i(ApplicationStarter.TIME4A, ChronoFormatter.ofMomentStyle(DisplayMode.FULL, DisplayMode.FULL, locale, ofTotalSeconds).format(currentMoment));
                long nanoTime2 = (System.nanoTime() - nanoTime) / AnimationKt.MillisToNanos;
                Log.i(ApplicationStarter.TIME4A, "Prefetch thread consumed (in ms): " + nanoTime2);
            } catch (Throwable th) {
                Log.e(ApplicationStarter.TIME4A, "Error on prefetch thread with: time zone=" + ofTotalSeconds.canonical() + ", locale=" + locale + "!", th);
                throw new IllegalStateException(th);
            }
        }
    }
}
