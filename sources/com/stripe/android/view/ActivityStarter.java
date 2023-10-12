package com.stripe.android.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.stripe.android.view.ActivityStarter.Args;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005:\u0002\u0016\u0017B1\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fB1\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000fB=\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0001¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/view/ActivityStarter;", "TargetActivityType", "Landroid/app/Activity;", "ArgsType", "Lcom/stripe/android/view/ActivityStarter$Args;", "", "activity", "targetClass", "Ljava/lang/Class;", "requestCode", "", "intentFlags", "(Landroid/app/Activity;Ljava/lang/Class;ILjava/lang/Integer;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Class;ILjava/lang/Integer;)V", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;Ljava/lang/Class;ILjava/lang/Integer;)V", "Ljava/lang/Integer;", "startForResult", "", "args", "(Lcom/stripe/android/view/ActivityStarter$Args;)V", "Args", "Result", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityStarter.kt */
public abstract class ActivityStarter<TargetActivityType extends Activity, ArgsType extends Args> {
    public static final int $stable = 8;
    private final Activity activity;
    private final Fragment fragment;
    private final Integer intentFlags;
    private final int requestCode;
    private final Class<TargetActivityType> targetClass;

    public ActivityStarter(Activity activity2, Fragment fragment2, Class<TargetActivityType> cls, int i, Integer num) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(cls, "targetClass");
        this.activity = activity2;
        this.fragment = fragment2;
        this.targetClass = cls;
        this.requestCode = i;
        this.intentFlags = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityStarter(Activity activity2, Fragment fragment2, Class cls, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity2, (i2 & 2) != 0 ? null : fragment2, cls, i, (i2 & 16) != 0 ? null : num);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityStarter(Activity activity2, Class cls, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity2, cls, i, (i2 & 8) != 0 ? null : num);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActivityStarter(Activity activity2, Class<TargetActivityType> cls, int i, Integer num) {
        this(activity2, (Fragment) null, cls, i, num);
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(cls, "targetClass");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityStarter(Fragment fragment2, Class cls, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment2, cls, i, (i2 & 8) != 0 ? null : num);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ActivityStarter(androidx.fragment.app.Fragment r9, java.lang.Class<TargetActivityType> r10, int r11, java.lang.Integer r12) {
        /*
            r8 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "targetClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.fragment.app.FragmentActivity r0 = r9.requireActivity()
            java.lang.String r1 = "fragment.requireActivity()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r3 = r0
            android.app.Activity r3 = (android.app.Activity) r3
            r2 = r8
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.ActivityStarter.<init>(androidx.fragment.app.Fragment, java.lang.Class, int, java.lang.Integer):void");
    }

    public final void startForResult(ArgsType argstype) {
        Intrinsics.checkNotNullParameter(argstype, "args");
        Intent putExtra = new Intent(this.activity, this.targetClass).putExtra("extra_activity_args", (Parcelable) argstype);
        Integer num = this.intentFlags;
        if (num != null) {
            putExtra.addFlags(num.intValue());
        }
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(activity, targetC…          }\n            }");
        Fragment fragment2 = this.fragment;
        if (fragment2 != null) {
            fragment2.startActivityForResult(putExtra, this.requestCode);
        } else {
            this.activity.startActivityForResult(putExtra, this.requestCode);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/view/ActivityStarter$Args;", "Landroid/os/Parcelable;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActivityStarter.kt */
    public interface Args extends Parcelable {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String EXTRA = "extra_activity_args";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/view/ActivityStarter$Args$Companion;", "", "()V", "EXTRA", "", "getEXTRA$annotations", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ActivityStarter.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String EXTRA = "extra_activity_args";

            public static /* synthetic */ void getEXTRA$annotations() {
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/view/ActivityStarter$Result;", "Landroid/os/Parcelable;", "toBundle", "Landroid/os/Bundle;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActivityStarter.kt */
    public interface Result extends Parcelable {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String EXTRA = "extra_activity_result";

        Bundle toBundle();

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/view/ActivityStarter$Result$Companion;", "", "()V", "EXTRA", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ActivityStarter.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String EXTRA = "extra_activity_result";

            private Companion() {
            }
        }
    }
}
