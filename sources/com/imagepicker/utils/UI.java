package com.imagepicker.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertDialog;
import com.braintreepayments.api.PayPalTwoFactorAuth;
import com.facebook.react.bridge.ReadableMap;
import com.imagepicker.ImagePickerModule;
import com.imagepicker.R;
import java.lang.ref.WeakReference;
import java.util.List;
import org.bouncycastle.i18n.MessageBundle;

public class UI {

    public interface OnAction {
        void onCancel(ImagePickerModule imagePickerModule);

        void onCustomButton(ImagePickerModule imagePickerModule, String str);

        void onTakePhoto(ImagePickerModule imagePickerModule);

        void onUseLibrary(ImagePickerModule imagePickerModule);
    }

    public static AlertDialog chooseDialog(ImagePickerModule imagePickerModule, ReadableMap readableMap, final OnAction onAction) {
        Activity activity = imagePickerModule.getActivity();
        if (activity == null) {
            return null;
        }
        final WeakReference weakReference = new WeakReference(imagePickerModule);
        ButtonsHelper newInstance = ButtonsHelper.newInstance(readableMap);
        List<String> titles = newInstance.getTitles();
        final List<String> actions = newInstance.getActions();
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, R.layout.list_item, titles);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, imagePickerModule.getDialogThemeId());
        if (ReadableMapUtils.hasAndNotEmptyString(readableMap, MessageBundle.TITLE_ENTRY)) {
            builder.setTitle((CharSequence) readableMap.getString(MessageBundle.TITLE_ENTRY));
        }
        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = (String) actions.get(i);
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case -1367724422:
                        if (str.equals(PayPalTwoFactorAuth.CANCEL_PATH)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 106642994:
                        if (str.equals("photo")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 166208699:
                        if (str.equals("library")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        onAction.onCancel((ImagePickerModule) weakReference.get());
                        return;
                    case 1:
                        onAction.onTakePhoto((ImagePickerModule) weakReference.get());
                        return;
                    case 2:
                        onAction.onUseLibrary((ImagePickerModule) weakReference.get());
                        return;
                    default:
                        onAction.onCustomButton((ImagePickerModule) weakReference.get(), str);
                        return;
                }
            }
        });
        builder.setNegativeButton((CharSequence) newInstance.btnCancel.title, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                OnAction.this.onCancel((ImagePickerModule) weakReference.get());
                dialogInterface.dismiss();
            }
        });
        AlertDialog create = builder.create();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                OnAction.this.onCancel((ImagePickerModule) weakReference.get());
                dialogInterface.dismiss();
            }
        });
        return create;
    }
}
