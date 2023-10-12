package io.card.payment.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;

public class ActivityHelper {
    public static void addActionBarIfSupported(Activity activity) {
        if (actionBarSupported()) {
            activity.requestWindowFeature(8);
        }
    }

    public static void setupActionBarIfSupported(Activity activity, TextView textView, String str, String str2, Drawable drawable) {
        if (str2 == null) {
            str2 = "";
        }
        activity.setTitle(str2 + str);
        if (actionBarSupported() && actionBarNonNull(activity)) {
            setupActionBar(activity, str, drawable);
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else if (textView != null) {
            textView.setText(str);
        }
    }

    private static boolean actionBarNonNull(Activity activity) {
        return activity.getActionBar() != null;
    }

    private static void setupActionBar(Activity activity, String str, Drawable drawable) {
        ActionBar actionBar = activity.getActionBar();
        actionBar.setBackgroundDrawable(Appearance.ACTIONBAR_BACKGROUND);
        actionBar.setTitle(str);
        TextView textView = (TextView) activity.findViewById(Resources.getSystem().getIdentifier("action_bar_title", MessageExtension.FIELD_ID, "android"));
        if (textView != null) {
            textView.setTextColor(-1);
        }
        actionBar.setDisplayHomeAsUpEnabled(false);
        if (drawable == null || Build.VERSION.SDK_INT < 14) {
            actionBar.setDisplayShowHomeEnabled(false);
        } else {
            setActionBarHomeIcon(actionBar, drawable);
        }
    }

    private static boolean actionBarSupported() {
        return Build.VERSION.SDK_INT >= 11;
    }

    private static void setActionBarHomeIcon(ActionBar actionBar, Drawable drawable) {
        actionBar.setIcon(drawable);
    }

    public static boolean holoSupported() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static void setActivityTheme(Activity activity, boolean z) {
        if (z && activity.getApplicationInfo().theme != 0) {
            activity.setTheme(activity.getApplicationInfo().theme);
        } else if (holoSupported()) {
            activity.setTheme(16973934);
        } else {
            activity.setTheme(16973836);
        }
    }

    public static void setFlagSecure(Activity activity) {
        if (Build.VERSION.SDK_INT >= 11) {
            activity.getWindow().addFlags(8192);
        }
    }
}
