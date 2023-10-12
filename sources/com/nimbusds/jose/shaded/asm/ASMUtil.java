package com.nimbusds.jose.shaded.asm;

import com.nimbusds.jose.shaded.ow2asm.Label;
import com.nimbusds.jose.shaded.ow2asm.MethodVisitor;
import com.nimbusds.jose.shaded.ow2asm.Type;
import java.lang.reflect.Field;
import java.util.HashMap;

public class ASMUtil {
    public static void autoBoxing(MethodVisitor methodVisitor, Class<?> cls) {
        autoBoxing(methodVisitor, Type.getType(cls));
    }

    public static Accessor[] getAccessors(Class<?> cls, FieldFilter fieldFilter) {
        HashMap hashMap = new HashMap();
        if (fieldFilter == null) {
            fieldFilter = BasicFiledFilter.SINGLETON;
        }
        for (Class<? super Object> cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            for (Field field : cls2.getDeclaredFields()) {
                String name = field.getName();
                if (!hashMap.containsKey(name)) {
                    Accessor accessor = new Accessor(cls2, field, fieldFilter);
                    if (accessor.isUsable()) {
                        hashMap.put(name, accessor);
                    }
                }
            }
        }
        return (Accessor[]) hashMap.values().toArray(new Accessor[hashMap.size()]);
    }

    protected static void autoBoxing(MethodVisitor methodVisitor, Type type) {
        switch (type.getSort()) {
            case 1:
                methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
                return;
            case 2:
                methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;", false);
                return;
            case 3:
                methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;", false);
                return;
            case 4:
                methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;", false);
                return;
            case 5:
                methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
                return;
            case 6:
                methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;", false);
                return;
            case 7:
                methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
                return;
            case 8:
                methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false);
                return;
            default:
                return;
        }
    }

    protected static void autoUnBoxing1(MethodVisitor methodVisitor, Type type) {
        switch (type.getSort()) {
            case 1:
                methodVisitor.visitTypeInsn(192, "java/lang/Boolean");
                methodVisitor.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z", false);
                return;
            case 2:
                methodVisitor.visitTypeInsn(192, "java/lang/Character");
                methodVisitor.visitMethodInsn(182, "java/lang/Character", "charValue", "()C", false);
                return;
            case 3:
                methodVisitor.visitTypeInsn(192, "java/lang/Byte");
                methodVisitor.visitMethodInsn(182, "java/lang/Byte", "byteValue", "()B", false);
                return;
            case 4:
                methodVisitor.visitTypeInsn(192, "java/lang/Short");
                methodVisitor.visitMethodInsn(182, "java/lang/Short", "shortValue", "()S", false);
                return;
            case 5:
                methodVisitor.visitTypeInsn(192, "java/lang/Integer");
                methodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I", false);
                return;
            case 6:
                methodVisitor.visitTypeInsn(192, "java/lang/Float");
                methodVisitor.visitMethodInsn(182, "java/lang/Float", "floatValue", "()F", false);
                return;
            case 7:
                methodVisitor.visitTypeInsn(192, "java/lang/Long");
                methodVisitor.visitMethodInsn(182, "java/lang/Long", "longValue", "()J", false);
                return;
            case 8:
                methodVisitor.visitTypeInsn(192, "java/lang/Double");
                methodVisitor.visitMethodInsn(182, "java/lang/Double", "doubleValue", "()D", false);
                return;
            case 9:
                methodVisitor.visitTypeInsn(192, type.getInternalName());
                return;
            default:
                methodVisitor.visitTypeInsn(192, type.getInternalName());
                return;
        }
    }

    protected static void autoUnBoxing2(MethodVisitor methodVisitor, Type type) {
        switch (type.getSort()) {
            case 1:
                methodVisitor.visitTypeInsn(192, "java/lang/Boolean");
                methodVisitor.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z", false);
                return;
            case 2:
                methodVisitor.visitTypeInsn(192, "java/lang/Character");
                methodVisitor.visitMethodInsn(182, "java/lang/Character", "charValue", "()C", false);
                return;
            case 3:
                methodVisitor.visitTypeInsn(192, "java/lang/Number");
                methodVisitor.visitMethodInsn(182, "java/lang/Number", "byteValue", "()B", false);
                return;
            case 4:
                methodVisitor.visitTypeInsn(192, "java/lang/Number");
                methodVisitor.visitMethodInsn(182, "java/lang/Number", "shortValue", "()S", false);
                return;
            case 5:
                methodVisitor.visitTypeInsn(192, "java/lang/Number");
                methodVisitor.visitMethodInsn(182, "java/lang/Number", "intValue", "()I", false);
                return;
            case 6:
                methodVisitor.visitTypeInsn(192, "java/lang/Number");
                methodVisitor.visitMethodInsn(182, "java/lang/Number", "floatValue", "()F", false);
                return;
            case 7:
                methodVisitor.visitTypeInsn(192, "java/lang/Number");
                methodVisitor.visitMethodInsn(182, "java/lang/Number", "longValue", "()J", false);
                return;
            case 8:
                methodVisitor.visitTypeInsn(192, "java/lang/Number");
                methodVisitor.visitMethodInsn(182, "java/lang/Number", "doubleValue", "()D", false);
                return;
            case 9:
                methodVisitor.visitTypeInsn(192, type.getInternalName());
                return;
            default:
                methodVisitor.visitTypeInsn(192, type.getInternalName());
                return;
        }
    }

    public static Label[] newLabels(int i) {
        Label[] labelArr = new Label[i];
        for (int i2 = 0; i2 < i; i2++) {
            labelArr[i2] = new Label();
        }
        return labelArr;
    }

    public static String getSetterName(String str) {
        int length = str.length();
        char[] cArr = new char[(length + 3)];
        cArr[0] = 's';
        cArr[1] = 'e';
        cArr[2] = 't';
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[3] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static String getGetterName(String str) {
        int length = str.length();
        char[] cArr = new char[(length + 3)];
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[3] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static String getIsName(String str) {
        int length = str.length();
        char[] cArr = new char[(length + 2)];
        cArr[0] = 'i';
        cArr[1] = 's';
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[2] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 2] = str.charAt(i);
        }
        return new String(cArr);
    }
}
