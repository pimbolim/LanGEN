package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.profileinstaller.ProfileInstaller;

public class ProfileInstallReceiver extends BroadcastReceiver {
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";

    public void onReceive(Context context, Intent intent) {
        if (intent != null && ACTION_INSTALL_PROFILE.equals(intent.getAction())) {
            ProfileInstaller.writeProfile(context, $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE, new ResultDiagnostics(), true);
        }
    }

    class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        ResultDiagnostics() {
        }

        public void onDiagnosticReceived(int i, Object obj) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(i, obj);
        }

        public void onResultReceived(int i, Object obj) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(i, obj);
            ProfileInstallReceiver.this.setResultCode(i);
        }
    }
}
