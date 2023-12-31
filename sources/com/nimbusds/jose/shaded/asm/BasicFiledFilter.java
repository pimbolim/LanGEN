package com.nimbusds.jose.shaded.asm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BasicFiledFilter implements FieldFilter {
    public static final BasicFiledFilter SINGLETON = new BasicFiledFilter();

    public boolean canRead(Field field) {
        return true;
    }

    public boolean canUse(Field field) {
        return true;
    }

    public boolean canUse(Field field, Method method) {
        return true;
    }

    public boolean canWrite(Field field) {
        return true;
    }
}
