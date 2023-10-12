package com.stripe.android.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J$\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J,\u0010\r\u001a\u0004\u0018\u00010\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/utils/ClassUtils;", "", "()V", "findField", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "allowedFields", "", "", "findMethod", "Ljava/lang/reflect/Method;", "allowedMethods", "getInternalObject", "", "obj", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassUtils.kt */
public final class ClassUtils {
    public static final ClassUtils INSTANCE = new ClassUtils();

    private ClassUtils() {
    }

    @JvmStatic
    public static final Object getInternalObject(Class<?> cls, Set<String> set, Object obj) {
        Object obj2;
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(set, "allowedFields");
        Intrinsics.checkNotNullParameter(obj, "obj");
        Field findField = findField(cls, set);
        if (findField == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj2 = Result.m4709constructorimpl(findField.get(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m4715isFailureimpl(obj2)) {
            return null;
        }
        return obj2;
    }

    @JvmStatic
    public static final Field findField(Class<?> cls, Collection<String> collection) {
        Field field;
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(collection, "allowedFields");
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "fields");
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            field = declaredFields[i];
            i++;
            if (collection.contains(field.getName())) {
                break;
            }
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        return field;
    }

    @JvmStatic
    public static final Method findMethod(Class<?> cls, Collection<String> collection) {
        Method method;
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(collection, "allowedMethods");
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "clazz.declaredMethods");
        Object[] objArr = (Object[]) declaredMethods;
        int length = objArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                method = null;
                break;
            }
            method = objArr[i];
            i++;
            if (collection.contains(((Method) method).getName())) {
                break;
            }
        }
        return method;
    }
}
