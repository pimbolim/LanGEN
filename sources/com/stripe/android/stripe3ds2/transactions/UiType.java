package com.stripe.android.stripe3ds2.transactions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/UiType;", "", "code", "", "requiresSubmitButton", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getCode", "()Ljava/lang/String;", "getRequiresSubmitButton$3ds2sdk_release", "()Z", "Text", "SingleSelect", "MultiSelect", "OutOfBand", "Html", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UiType.kt */
public enum UiType {
    Text("01", true),
    SingleSelect("02", true),
    MultiSelect("03", true),
    OutOfBand("04", false),
    Html("05", false);
    
    public static final Companion Companion = null;
    private final String code;
    private final boolean requiresSubmitButton;

    private UiType(String str, boolean z) {
        this.code = str;
        this.requiresSubmitButton = z;
    }

    public final String getCode() {
        return this.code;
    }

    public final boolean getRequiresSubmitButton$3ds2sdk_release() {
        return this.requiresSubmitButton;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/UiType$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "code", "", "fromCode$3ds2sdk_release", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UiType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UiType fromCode$3ds2sdk_release(String str) {
            UiType[] values = UiType.values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                UiType uiType = values[i];
                i++;
                if (Intrinsics.areEqual((Object) str, (Object) uiType.getCode())) {
                    return uiType;
                }
            }
            return null;
        }
    }
}
