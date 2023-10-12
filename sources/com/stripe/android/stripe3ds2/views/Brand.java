package com.stripe.android.stripe3ds2.views;

import com.stripe.android.stripe3ds2.R;
import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0001\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB1\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/Brand;", "", "directoryServerName", "", "drawableResId", "", "nameResId", "shouldStretch", "", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/Integer;Z)V", "getDirectoryServerName$3ds2sdk_release", "()Ljava/lang/String;", "getDrawableResId$3ds2sdk_release", "()I", "getNameResId$3ds2sdk_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShouldStretch$3ds2sdk_release", "()Z", "Visa", "Mastercard", "Amex", "Discover", "CartesBancaires", "UnionPay", "Unknown", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Brand.kt */
public enum Brand {
    Visa("visa", R.drawable.stripe_3ds2_ic_visa, Integer.valueOf(R.string.stripe_3ds2_brand_visa), false, 8, (boolean) null),
    Mastercard("mastercard", R.drawable.stripe_3ds2_ic_mastercard, Integer.valueOf(R.string.stripe_3ds2_brand_mastercard), false, 8, (boolean) null),
    Amex("american_express", R.drawable.stripe_3ds2_ic_amex, Integer.valueOf(R.string.stripe_3ds2_brand_amex), false, 8, (boolean) null),
    Discover("discover", R.drawable.stripe_3ds2_ic_discover, Integer.valueOf(R.string.stripe_3ds2_brand_discover), false, 8, (boolean) null),
    CartesBancaires("cartes_bancaires", R.drawable.stripe_3ds2_ic_cartesbancaires, Integer.valueOf(R.string.stripe_3ds2_brand_cartesbancaires), true),
    UnionPay("unionpay", R.drawable.stripe_3ds2_ic_unionpay, Integer.valueOf(R.string.stripe_3ds2_brand_unionpay), false, 8, (boolean) null),
    Unknown("unknown", R.drawable.stripe_3ds2_ic_unknown, (String) null, false, 8, (boolean) null);
    
    public static final Companion Companion = null;
    private final String directoryServerName;
    private final int drawableResId;
    private final Integer nameResId;
    private final boolean shouldStretch;

    private Brand(String str, int i, Integer num, boolean z) {
        this.directoryServerName = str;
        this.drawableResId = i;
        this.nameResId = num;
        this.shouldStretch = z;
    }

    public final String getDirectoryServerName$3ds2sdk_release() {
        return this.directoryServerName;
    }

    public final int getDrawableResId$3ds2sdk_release() {
        return this.drawableResId;
    }

    public final Integer getNameResId$3ds2sdk_release() {
        return this.nameResId;
    }

    public final boolean getShouldStretch$3ds2sdk_release() {
        return this.shouldStretch;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/Brand$Companion;", "", "()V", "lookup", "Lcom/stripe/android/stripe3ds2/views/Brand;", "directoryServerName", "", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "lookup$3ds2sdk_release", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Brand.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Brand lookup$3ds2sdk_release(String str, ErrorReporter errorReporter) {
            Brand brand;
            Brand brand2;
            Intrinsics.checkNotNullParameter(str, "directoryServerName");
            Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
            Brand[] values = Brand.values();
            int length = values.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    brand = null;
                    break;
                }
                brand = values[i2];
                i2++;
                if (StringsKt.equals(brand.getDirectoryServerName$3ds2sdk_release(), StringsKt.trim((CharSequence) str).toString(), true)) {
                    break;
                }
            }
            if (brand != null) {
                Result.Companion companion = Result.Companion;
                brand2 = Result.m4709constructorimpl(brand);
            } else {
                Brand[] values2 = Brand.values();
                Collection arrayList = new ArrayList(values2.length);
                int length2 = values2.length;
                while (i < length2) {
                    Brand brand3 = values2[i];
                    i++;
                    arrayList.add(brand3.getDirectoryServerName$3ds2sdk_release());
                }
                Result.Companion companion2 = Result.Companion;
                brand2 = Result.m4709constructorimpl(ResultKt.createFailure(new SDKRuntimeException("Directory server name '" + str + "' is not supported. Must be one of " + ((List) arrayList) + ClassUtils.PACKAGE_SEPARATOR_CHAR, (Throwable) null, 2, (DefaultConstructorMarker) null)));
            }
            Throwable r0 = Result.m4712exceptionOrNullimpl(brand2);
            if (r0 != null) {
                errorReporter.reportError(r0);
            }
            Brand brand4 = Brand.Unknown;
            if (Result.m4715isFailureimpl(brand2)) {
                brand2 = brand4;
            }
            return (Brand) brand2;
        }
    }
}
