package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SwitchManagerInterface;

public class SwitchManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SwitchManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public SwitchManagerDelegate(U u) {
        super(u);
    }

    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        boolean z = false;
        char c = 65535;
        switch (str.hashCode()) {
            case -1742453971:
                if (str.equals("thumbColor")) {
                    c = 0;
                    break;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    c = 1;
                    break;
                }
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    c = 2;
                    break;
                }
                break;
            case 1084662482:
                if (str.equals("trackColorForFalse")) {
                    c = 3;
                    break;
                }
                break;
            case 1296813577:
                if (str.equals("onTintColor")) {
                    c = 4;
                    break;
                }
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    c = 5;
                    break;
                }
                break;
            case 1912319986:
                if (str.equals("thumbTintColor")) {
                    c = 6;
                    break;
                }
                break;
            case 2113632767:
                if (str.equals("trackColorForTrue")) {
                    c = 7;
                    break;
                }
                break;
        }
        Integer num = null;
        switch (c) {
            case 0:
                SwitchManagerInterface switchManagerInterface = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface.setThumbColor(t, num);
                return;
            case 1:
                SwitchManagerInterface switchManagerInterface2 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                }
                switchManagerInterface2.setValue(t, z);
                return;
            case 2:
                SwitchManagerInterface switchManagerInterface3 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                }
                switchManagerInterface3.setDisabled(t, z);
                return;
            case 3:
                SwitchManagerInterface switchManagerInterface4 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface4.setTrackColorForFalse(t, num);
                return;
            case 4:
                SwitchManagerInterface switchManagerInterface5 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface5.setOnTintColor(t, num);
                return;
            case 5:
                SwitchManagerInterface switchManagerInterface6 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface6.setTintColor(t, num);
                return;
            case 6:
                SwitchManagerInterface switchManagerInterface7 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface7.setThumbTintColor(t, num);
                return;
            case 7:
                SwitchManagerInterface switchManagerInterface8 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface8.setTrackColorForTrue(t, num);
                return;
            default:
                super.setProperty(t, str, obj);
                return;
        }
    }
}
