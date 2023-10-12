package com.stripe.android.stripe3ds2.utils;

import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0007J!\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stripe/android/stripe3ds2/utils/ObjectUtils;", "", "()V", "equals", "", "obj1", "obj2", "hash", "", "values", "", "([Ljava/lang/Object;)I", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ObjectUtils.kt */
public final class ObjectUtils {
    public static final ObjectUtils INSTANCE = new ObjectUtils();

    private ObjectUtils() {
    }

    @JvmStatic
    public static final boolean equals(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    @JvmStatic
    public static final int hash(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "values");
        return Objects.hash(Arrays.copyOf(objArr, objArr.length));
    }
}
