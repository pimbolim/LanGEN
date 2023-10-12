package com.imagepicker.permissions;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.imagepicker.ImagePickerModule;
import java.lang.ref.WeakReference;
import org.bouncycastle.i18n.MessageBundle;

public class PermissionUtils {

    public interface OnExplainingPermissionCallback {
        void onCancel(WeakReference<ImagePickerModule> weakReference, DialogInterface dialogInterface);

        void onReTry(WeakReference<ImagePickerModule> weakReference, DialogInterface dialogInterface);
    }

    public static AlertDialog explainingDialog(ImagePickerModule imagePickerModule, ReadableMap readableMap, final OnExplainingPermissionCallback onExplainingPermissionCallback) {
        if (imagePickerModule.getContext() == null || !readableMap.hasKey("permissionDenied")) {
            return null;
        }
        ReadableMap map = readableMap.getMap("permissionDenied");
        if (((ReadableNativeMap) map).toHashMap().size() == 0) {
            return null;
        }
        String string = map.getString(MessageBundle.TITLE_ENTRY);
        String string2 = map.getString("text");
        String string3 = map.getString("reTryTitle");
        String string4 = map.getString("okTitle");
        final WeakReference weakReference = new WeakReference(imagePickerModule);
        Activity activity = imagePickerModule.getActivity();
        if (activity == null) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, imagePickerModule.getDialogThemeId());
        builder.setTitle((CharSequence) string).setMessage((CharSequence) string2).setCancelable(false).setNegativeButton((CharSequence) string4, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                OnExplainingPermissionCallback.this.onCancel(weakReference, dialogInterface);
            }
        }).setPositiveButton((CharSequence) string3, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                OnExplainingPermissionCallback.this.onReTry(weakReference, dialogInterface);
            }
        });
        return builder.create();
    }
}
