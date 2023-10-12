package com.reactnativestripesdk;

import android.widget.FrameLayout;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reactnativestripesdk/GooglePayButtonView;", "Landroid/widget/FrameLayout;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "buttonType", "", "initialize", "", "setType", "type", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GooglePayButtonView.kt */
public final class GooglePayButtonView extends FrameLayout {
    private String buttonType;
    private final ThemedReactContext context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GooglePayButtonView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        this.context = themedReactContext;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize() {
        /*
            r3 = this;
            java.lang.String r0 = r3.buttonType
            if (r0 == 0) goto L_0x003c
            int r1 = r0.hashCode()
            switch(r1) {
                case -1827522409: goto L_0x0030;
                case 110760: goto L_0x0024;
                case 590854370: goto L_0x0018;
                case 1312628413: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003c
        L_0x000c:
            java.lang.String r1 = "standard"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0015
            goto L_0x003c
        L_0x0015:
            int r0 = com.reactnativestripesdk.R.layout.googlepay_button_no_shadow
            goto L_0x003e
        L_0x0018:
            java.lang.String r1 = "standard_shadow"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0021
            goto L_0x003c
        L_0x0021:
            int r0 = com.reactnativestripesdk.R.layout.googlepay_button
            goto L_0x003e
        L_0x0024:
            java.lang.String r1 = "pay"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002d
            goto L_0x003c
        L_0x002d:
            int r0 = com.reactnativestripesdk.R.layout.pay_with_googlepay_button_no_shadow
            goto L_0x003e
        L_0x0030:
            java.lang.String r1 = "pay_shadow"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            int r0 = com.reactnativestripesdk.R.layout.pay_with_googlepay_button
            goto L_0x003e
        L_0x003c:
            int r0 = com.reactnativestripesdk.R.layout.googlepay_button
        L_0x003e:
            com.facebook.react.uimanager.ThemedReactContext r1 = r3.context
            android.content.Context r1 = (android.content.Context) r1
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            r2 = 0
            android.view.View r0 = r1.inflate(r0, r2)
            r3.addView(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativestripesdk.GooglePayButtonView.initialize():void");
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.buttonType = str;
    }
}
