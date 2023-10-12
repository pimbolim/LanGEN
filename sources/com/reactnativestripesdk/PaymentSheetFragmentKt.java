package com.reactnativestripesdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"getBase64FromBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "getBitmapFromVectorDrawable", "context", "Landroid/content/Context;", "drawableId", "", "stripe_stripe-react-native_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: PaymentSheetFragment.kt */
public final class PaymentSheetFragmentKt {
    public static final Bitmap getBitmapFromVectorDrawable(Context context, int i) {
        Intrinsics.checkNotNull(context);
        Drawable drawable = AppCompatResources.getDrawable(context, i);
        if (drawable == null) {
            return null;
        }
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "wrap(drawable).mutate()");
        Bitmap createBitmap = Bitmap.createBitmap(mutate.getIntrinsicWidth(), mutate.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(-1);
        Canvas canvas = new Canvas(createBitmap);
        mutate.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        mutate.draw(canvas);
        return createBitmap;
    }

    public static final String getBase64FromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "stream.toByteArray()");
        return Base64.encodeToString(byteArray, 0);
    }
}
