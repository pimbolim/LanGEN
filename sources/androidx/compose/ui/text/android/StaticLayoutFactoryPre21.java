package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactoryPre21;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "Companion", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StaticLayoutFactory.kt */
final class StaticLayoutFactoryPre21 implements StaticLayoutFactoryImpl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static boolean isInitialized;
    /* access modifiers changed from: private */
    public static Constructor<StaticLayout> staticLayoutConstructor;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactoryPre21$Companion;", "", "()V", "isInitialized", "", "staticLayoutConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/text/StaticLayout;", "getStaticLayoutConstructor", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StaticLayoutFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Constructor<StaticLayout> getStaticLayoutConstructor() {
            if (StaticLayoutFactoryPre21.isInitialized) {
                return StaticLayoutFactoryPre21.staticLayoutConstructor;
            }
            StaticLayoutFactoryPre21.isInitialized = true;
            Class<StaticLayout> cls = StaticLayout.class;
            try {
                StaticLayoutFactoryPre21.staticLayoutConstructor = cls.getConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, TextDirectionHeuristic.class, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE});
            } catch (NoSuchMethodException unused) {
                StaticLayoutFactoryPre21.staticLayoutConstructor = null;
                Log.e("StaticLayoutFactory", "unable to collect necessary constructor.");
            }
            return StaticLayoutFactoryPre21.staticLayoutConstructor;
        }
    }

    public StaticLayout create(StaticLayoutParams staticLayoutParams) {
        Intrinsics.checkNotNullParameter(staticLayoutParams, "params");
        Constructor access$getStaticLayoutConstructor = Companion.getStaticLayoutConstructor();
        StaticLayout staticLayout = null;
        if (access$getStaticLayoutConstructor != null) {
            try {
                staticLayout = (StaticLayout) access$getStaticLayoutConstructor.newInstance(new Object[]{staticLayoutParams.getText(), Integer.valueOf(staticLayoutParams.getStart()), Integer.valueOf(staticLayoutParams.getEnd()), staticLayoutParams.getPaint(), Integer.valueOf(staticLayoutParams.getWidth()), staticLayoutParams.getAlignment(), staticLayoutParams.getTextDir(), Float.valueOf(staticLayoutParams.getLineSpacingMultiplier()), Float.valueOf(staticLayoutParams.getLineSpacingExtra()), Boolean.valueOf(staticLayoutParams.getIncludePadding()), staticLayoutParams.getEllipsize(), Integer.valueOf(staticLayoutParams.getEllipsizedWidth()), Integer.valueOf(staticLayoutParams.getMaxLines())});
            } catch (IllegalAccessException unused) {
                staticLayoutConstructor = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
                staticLayout = null;
            } catch (InstantiationException unused2) {
                staticLayoutConstructor = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
                staticLayout = null;
            } catch (InvocationTargetException unused3) {
                staticLayoutConstructor = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
                staticLayout = null;
            }
        }
        return staticLayout != null ? staticLayout : new StaticLayout(staticLayoutParams.getText(), staticLayoutParams.getStart(), staticLayoutParams.getEnd(), staticLayoutParams.getPaint(), staticLayoutParams.getWidth(), staticLayoutParams.getAlignment(), staticLayoutParams.getLineSpacingMultiplier(), staticLayoutParams.getLineSpacingExtra(), staticLayoutParams.getIncludePadding(), staticLayoutParams.getEllipsize(), staticLayoutParams.getEllipsizedWidth());
    }
}
