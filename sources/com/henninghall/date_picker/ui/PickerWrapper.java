package com.henninghall.date_picker.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.henninghall.date_picker.R;

class PickerWrapper {
    private final LinearLayout view;

    PickerWrapper(View view2) {
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.pickerWrapper);
        this.view = linearLayout;
        linearLayout.setWillNotDraw(false);
    }

    /* access modifiers changed from: package-private */
    public void addPicker(View view2) {
        this.view.addView(view2);
    }

    /* access modifiers changed from: package-private */
    public void addPicker(View view2, int i) {
        this.view.addView(view2, i);
    }

    /* access modifiers changed from: package-private */
    public void removeAll() {
        this.view.removeAllViews();
    }
}
