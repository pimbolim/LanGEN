package com.nimbusds.jose.shaded.asm;

import com.nimbusds.jose.shaded.ow2asm.ClassWriter;
import com.nimbusds.jose.shaded.ow2asm.Label;
import com.nimbusds.jose.shaded.ow2asm.MethodVisitor;
import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import com.nimbusds.jose.shaded.ow2asm.Type;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.apache.commons.lang3.ClassUtils;

public class BeansAccessBuilder {
    private static String METHOD_ACCESS_NAME = Type.getInternalName(BeansAccess.class);
    final String accessClassName;
    final String accessClassNameInternal;
    final Accessor[] accs;
    final String className;
    final String classNameInternal;
    final HashMap<Class<?>, Method> convMtds = new HashMap<>();
    Class<? extends Exception> exceptionClass = NoSuchFieldException.class;
    final DynamicClassLoader loader;
    final Class<?> type;

    private void dumpDebug(byte[] bArr, String str) {
    }

    public BeansAccessBuilder(Class<?> cls, Accessor[] accessorArr, DynamicClassLoader dynamicClassLoader) {
        this.type = cls;
        this.accs = accessorArr;
        this.loader = dynamicClassLoader;
        String name = cls.getName();
        this.className = name;
        if (name.startsWith("java.")) {
            this.accessClassName = "com.nimbusds.jose.shaded.asm." + name + "AccAccess";
        } else {
            this.accessClassName = name.concat("AccAccess");
        }
        this.accessClassNameInternal = this.accessClassName.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/');
        this.classNameInternal = name.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/');
    }

    public void addConversion(Iterable<Class<?>> iterable) {
        if (iterable != null) {
            for (Class<?> addConversion : iterable) {
                addConversion(addConversion);
            }
        }
    }

    public void addConversion(Class<?> cls) {
        if (cls != null) {
            for (Method method : cls.getMethods()) {
                if ((method.getModifiers() & 8) != 0) {
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0].equals(Object.class)) {
                        Class<?> returnType = method.getReturnType();
                        if (!returnType.equals(Void.TYPE)) {
                            this.convMtds.put(returnType, method);
                        }
                    }
                }
            }
        }
    }

    public Class<?> bulid() {
        int i;
        int i2;
        int i3 = 1;
        ClassWriter classWriter = new ClassWriter(1);
        boolean z = this.accs.length > 10;
        ClassWriter classWriter2 = classWriter;
        classWriter2.visit(50, 33, this.accessClassNameInternal, "Lnet/minidev/asm/BeansAccess<L" + this.classNameInternal + ";>;", METHOD_ACCESS_NAME, (String[]) null);
        MethodVisitor visitMethod = classWriter2.visitMethod(1, "<init>", "()V", (String) null, (String[]) null);
        visitMethod.visitCode();
        visitMethod.visitVarInsn(25, 0);
        visitMethod.visitMethodInsn(183, METHOD_ACCESS_NAME, "<init>", "()V", false);
        visitMethod.visitInsn(177);
        visitMethod.visitMaxs(1, 1);
        visitMethod.visitEnd();
        MethodVisitor visitMethod2 = classWriter.visitMethod(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", (String) null, (String[]) null);
        visitMethod2.visitCode();
        Accessor[] accessorArr = this.accs;
        if (accessorArr.length != 0) {
            if (accessorArr.length > 14) {
                visitMethod2.visitVarInsn(21, 2);
                Label[] newLabels = ASMUtil.newLabels(this.accs.length);
                Label label = new Label();
                visitMethod2.visitTableSwitchInsn(0, newLabels.length - 1, label, newLabels);
                Accessor[] accessorArr2 = this.accs;
                int length = accessorArr2.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    Accessor accessor = accessorArr2[i4];
                    int i6 = i5 + 1;
                    visitMethod2.visitLabel(newLabels[i5]);
                    if (!accessor.isWritable()) {
                        visitMethod2.visitInsn(177);
                    } else {
                        internalSetFiled(visitMethod2, accessor);
                    }
                    i4++;
                    i5 = i6;
                }
                visitMethod2.visitLabel(label);
            } else {
                Label[] newLabels2 = ASMUtil.newLabels(accessorArr.length);
                int i7 = 0;
                for (Accessor internalSetFiled : this.accs) {
                    ifNotEqJmp(visitMethod2, 2, i7, newLabels2[i7]);
                    internalSetFiled(visitMethod2, internalSetFiled);
                    visitMethod2.visitLabel(newLabels2[i7]);
                    visitMethod2.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
                    i7++;
                }
            }
        }
        Class<? extends Exception> cls = this.exceptionClass;
        if (cls != null) {
            throwExIntParam(visitMethod2, cls);
        } else {
            visitMethod2.visitInsn(177);
        }
        visitMethod2.visitMaxs(0, 0);
        visitMethod2.visitEnd();
        MethodVisitor visitMethod3 = classWriter.visitMethod(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", (String) null, (String[]) null);
        visitMethod3.visitCode();
        Accessor[] accessorArr3 = this.accs;
        int i8 = 192;
        if (accessorArr3.length == 0) {
            visitMethod3.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
        } else if (accessorArr3.length > 14) {
            visitMethod3.visitVarInsn(21, 2);
            Label[] newLabels3 = ASMUtil.newLabels(this.accs.length);
            Label label2 = new Label();
            visitMethod3.visitTableSwitchInsn(0, newLabels3.length - 1, label2, newLabels3);
            Accessor[] accessorArr4 = this.accs;
            int length2 = accessorArr4.length;
            int i9 = 0;
            int i10 = 0;
            while (i9 < length2) {
                Accessor accessor2 = accessorArr4[i9];
                int i11 = i10 + 1;
                visitMethod3.visitLabel(newLabels3[i10]);
                visitMethod3.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
                if (!accessor2.isReadable()) {
                    visitMethod3.visitInsn(i3);
                    visitMethod3.visitInsn(176);
                } else {
                    visitMethod3.visitVarInsn(25, i3);
                    visitMethod3.visitTypeInsn(i8, this.classNameInternal);
                    Type type2 = Type.getType(accessor2.getType());
                    if (accessor2.isPublic() || accessor2.getter == null) {
                        visitMethod3.visitFieldInsn(180, this.classNameInternal, accessor2.getName(), type2.getDescriptor());
                    } else {
                        visitMethod3.visitMethodInsn(182, this.classNameInternal, accessor2.getter.getName(), Type.getMethodDescriptor(accessor2.getter), false);
                    }
                    ASMUtil.autoBoxing(visitMethod3, type2);
                    visitMethod3.visitInsn(176);
                }
                i9++;
                i10 = i11;
                i8 = 192;
                i3 = 1;
            }
            visitMethod3.visitLabel(label2);
            visitMethod3.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
        } else {
            Label[] newLabels4 = ASMUtil.newLabels(accessorArr3.length);
            int i12 = 0;
            for (Accessor accessor3 : this.accs) {
                ifNotEqJmp(visitMethod3, 2, i12, newLabels4[i12]);
                visitMethod3.visitVarInsn(25, 1);
                visitMethod3.visitTypeInsn(192, this.classNameInternal);
                Type type3 = Type.getType(accessor3.getType());
                if (accessor3.isPublic() || accessor3.getter == null) {
                    visitMethod3.visitFieldInsn(180, this.classNameInternal, accessor3.getName(), type3.getDescriptor());
                } else if (accessor3.getter != null) {
                    visitMethod3.visitMethodInsn(182, this.classNameInternal, accessor3.getter.getName(), Type.getMethodDescriptor(accessor3.getter), false);
                } else {
                    throw new RuntimeException("no Getter for field " + accessor3.getName() + " in class " + this.className);
                }
                ASMUtil.autoBoxing(visitMethod3, type3);
                visitMethod3.visitInsn(176);
                visitMethod3.visitLabel(newLabels4[i12]);
                visitMethod3.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
                i12++;
            }
        }
        Class<? extends Exception> cls2 = this.exceptionClass;
        if (cls2 != null) {
            throwExIntParam(visitMethod3, cls2);
        } else {
            visitMethod3.visitInsn(1);
            visitMethod3.visitInsn(176);
        }
        visitMethod3.visitMaxs(0, 0);
        visitMethod3.visitEnd();
        int i13 = 153;
        if (!z) {
            i2 = 176;
            i = 192;
            MethodVisitor visitMethod4 = classWriter.visitMethod(1, "set", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V", (String) null, (String[]) null);
            visitMethod4.visitCode();
            Label[] newLabels5 = ASMUtil.newLabels(this.accs.length);
            int i14 = 0;
            for (Accessor accessor4 : this.accs) {
                visitMethod4.visitVarInsn(25, 2);
                visitMethod4.visitLdcInsn(accessor4.fieldName);
                MethodVisitor methodVisitor = visitMethod4;
                methodVisitor.visitMethodInsn(182, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
                visitMethod4.visitJumpInsn(153, newLabels5[i14]);
                internalSetFiled(visitMethod4, accessor4);
                visitMethod4.visitLabel(newLabels5[i14]);
                methodVisitor.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
                i14++;
            }
            Class<? extends Exception> cls3 = this.exceptionClass;
            if (cls3 != null) {
                throwExStrParam(visitMethod4, cls3);
            } else {
                visitMethod4.visitInsn(177);
            }
            visitMethod4.visitMaxs(0, 0);
            visitMethod4.visitEnd();
        } else {
            i2 = 176;
            i = 192;
        }
        if (!z) {
            MethodVisitor visitMethod5 = classWriter.visitMethod(1, "get", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", (String) null, (String[]) null);
            visitMethod5.visitCode();
            Label[] newLabels6 = ASMUtil.newLabels(this.accs.length);
            Accessor[] accessorArr5 = this.accs;
            int length3 = accessorArr5.length;
            int i15 = 0;
            int i16 = 0;
            while (i15 < length3) {
                Accessor accessor5 = accessorArr5[i15];
                visitMethod5.visitVarInsn(25, 2);
                visitMethod5.visitLdcInsn(accessor5.fieldName);
                visitMethod5.visitMethodInsn(182, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
                visitMethod5.visitJumpInsn(i13, newLabels6[i16]);
                visitMethod5.visitVarInsn(25, 1);
                visitMethod5.visitTypeInsn(i, this.classNameInternal);
                Type type4 = Type.getType(accessor5.getType());
                if (accessor5.isPublic() || accessor5.getter == null) {
                    visitMethod5.visitFieldInsn(180, this.classNameInternal, accessor5.getName(), type4.getDescriptor());
                } else {
                    visitMethod5.visitMethodInsn(182, this.classNameInternal, accessor5.getter.getName(), Type.getMethodDescriptor(accessor5.getter), false);
                }
                ASMUtil.autoBoxing(visitMethod5, type4);
                visitMethod5.visitInsn(i2);
                visitMethod5.visitLabel(newLabels6[i16]);
                visitMethod5.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
                i16++;
                i15++;
                i13 = 153;
            }
            Class<? extends Exception> cls4 = this.exceptionClass;
            if (cls4 != null) {
                throwExStrParam(visitMethod5, cls4);
            } else {
                visitMethod5.visitInsn(1);
                visitMethod5.visitInsn(i2);
            }
            visitMethod5.visitMaxs(0, 0);
            visitMethod5.visitEnd();
        }
        MethodVisitor visitMethod6 = classWriter.visitMethod(1, "newInstance", "()Ljava/lang/Object;", (String) null, (String[]) null);
        visitMethod6.visitCode();
        visitMethod6.visitTypeInsn(187, this.classNameInternal);
        visitMethod6.visitInsn(89);
        visitMethod6.visitMethodInsn(183, this.classNameInternal, "<init>", "()V", false);
        visitMethod6.visitInsn(i2);
        visitMethod6.visitMaxs(2, 1);
        visitMethod6.visitEnd();
        classWriter.visitEnd();
        return this.loader.defineClass(this.accessClassName, classWriter.toByteArray());
    }

    private void internalSetFiled(MethodVisitor methodVisitor, Accessor accessor) {
        MethodVisitor methodVisitor2 = methodVisitor;
        Accessor accessor2 = accessor;
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitTypeInsn(192, this.classNameInternal);
        methodVisitor2.visitVarInsn(25, 3);
        Type type2 = Type.getType(accessor.getType());
        Class<?> type3 = accessor.getType();
        String internalName = Type.getInternalName(type3);
        Method method = this.convMtds.get(type3);
        if (method != null) {
            methodVisitor.visitMethodInsn(184, Type.getInternalName(method.getDeclaringClass()), method.getName(), Type.getMethodDescriptor(method), false);
        } else if (accessor.isEnum()) {
            Label label = new Label();
            methodVisitor2.visitJumpInsn(Opcodes.IFNULL, label);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor.visitMethodInsn(182, "java/lang/Object", "toString", "()Ljava/lang/String;", false);
            MethodVisitor methodVisitor3 = methodVisitor;
            methodVisitor3.visitMethodInsn(184, internalName, "valueOf", "(Ljava/lang/String;)L" + internalName + ";", false);
            methodVisitor2.visitVarInsn(58, 3);
            methodVisitor2.visitLabel(label);
            methodVisitor3.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitTypeInsn(192, this.classNameInternal);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitTypeInsn(192, internalName);
        } else if (type3.equals(String.class)) {
            Label label2 = new Label();
            methodVisitor2.visitJumpInsn(Opcodes.IFNULL, label2);
            methodVisitor2.visitVarInsn(25, 3);
            MethodVisitor methodVisitor4 = methodVisitor;
            methodVisitor4.visitMethodInsn(182, "java/lang/Object", "toString", "()Ljava/lang/String;", false);
            methodVisitor2.visitVarInsn(58, 3);
            methodVisitor2.visitLabel(label2);
            methodVisitor4.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitTypeInsn(192, this.classNameInternal);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitTypeInsn(192, internalName);
        } else {
            methodVisitor2.visitTypeInsn(192, internalName);
        }
        if (accessor.isPublic() || accessor2.setter == null) {
            methodVisitor2.visitFieldInsn(181, this.classNameInternal, accessor.getName(), type2.getDescriptor());
        } else {
            methodVisitor.visitMethodInsn(182, this.classNameInternal, accessor2.setter.getName(), Type.getMethodDescriptor(accessor2.setter), false);
        }
        methodVisitor2.visitInsn(177);
    }

    private void throwExIntParam(MethodVisitor methodVisitor, Class<?> cls) {
        String internalName = Type.getInternalName(cls);
        methodVisitor.visitTypeInsn(187, internalName);
        methodVisitor.visitInsn(89);
        methodVisitor.visitLdcInsn("mapping " + this.className + " failed to map field:");
        methodVisitor.visitVarInsn(21, 2);
        MethodVisitor methodVisitor2 = methodVisitor;
        methodVisitor2.visitMethodInsn(184, "java/lang/Integer", "toString", "(I)Ljava/lang/String;", false);
        methodVisitor2.visitMethodInsn(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
        methodVisitor2.visitMethodInsn(183, internalName, "<init>", "(Ljava/lang/String;)V", false);
        methodVisitor.visitInsn(Opcodes.ATHROW);
    }

    private void throwExStrParam(MethodVisitor methodVisitor, Class<?> cls) {
        String internalName = Type.getInternalName(cls);
        methodVisitor.visitTypeInsn(187, internalName);
        methodVisitor.visitInsn(89);
        methodVisitor.visitLdcInsn("mapping " + this.className + " failed to map field:");
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitMethodInsn(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
        methodVisitor.visitMethodInsn(183, internalName, "<init>", "(Ljava/lang/String;)V", false);
        methodVisitor.visitInsn(Opcodes.ATHROW);
    }

    private void ifNotEqJmp(MethodVisitor methodVisitor, int i, int i2, Label label) {
        methodVisitor.visitVarInsn(21, i);
        if (i2 == 0) {
            methodVisitor.visitJumpInsn(154, label);
        } else if (i2 == 1) {
            methodVisitor.visitInsn(4);
            methodVisitor.visitJumpInsn(160, label);
        } else if (i2 == 2) {
            methodVisitor.visitInsn(5);
            methodVisitor.visitJumpInsn(160, label);
        } else if (i2 == 3) {
            methodVisitor.visitInsn(6);
            methodVisitor.visitJumpInsn(160, label);
        } else if (i2 == 4) {
            methodVisitor.visitInsn(7);
            methodVisitor.visitJumpInsn(160, label);
        } else if (i2 == 5) {
            methodVisitor.visitInsn(8);
            methodVisitor.visitJumpInsn(160, label);
        } else if (i2 >= 6) {
            methodVisitor.visitIntInsn(16, i2);
            methodVisitor.visitJumpInsn(160, label);
        } else {
            throw new RuntimeException("non supported negative values");
        }
    }
}
