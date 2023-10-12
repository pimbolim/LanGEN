package com.nimbusds.jose.shaded.ow2asm;

import com.nimbusds.jose.shaded.ow2asm.Attribute;
import org.apache.commons.lang3.ClassUtils;

public class ClassWriter extends ClassVisitor {
    public static final int COMPUTE_FRAMES = 2;
    public static final int COMPUTE_MAXS = 1;
    private int accessFlags;
    private int compute;
    private ByteVector debugExtension;
    private int enclosingClassIndex;
    private int enclosingMethodIndex;
    private Attribute firstAttribute;
    private FieldWriter firstField;
    private MethodWriter firstMethod;
    private RecordComponentWriter firstRecordComponent;
    private ByteVector innerClasses;
    private int interfaceCount;
    private int[] interfaces;
    private FieldWriter lastField;
    private MethodWriter lastMethod;
    private RecordComponentWriter lastRecordComponent;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private ModuleWriter moduleWriter;
    private int nestHostClassIndex;
    private ByteVector nestMemberClasses;
    private int numberOfInnerClasses;
    private int numberOfNestMemberClasses;
    private int numberOfPermittedSubclasses;
    private ByteVector permittedSubclasses;
    private int signatureIndex;
    private int sourceFileIndex;
    private int superClass;
    private final SymbolTable symbolTable;
    private int thisClass;
    private int version;

    public final void visitEnd() {
    }

    public ClassWriter(int i) {
        this((ClassReader) null, i);
    }

    public ClassWriter(ClassReader classReader, int i) {
        super(Opcodes.ASM9);
        this.symbolTable = classReader == null ? new SymbolTable(this) : new SymbolTable(this, classReader);
        if ((i & 2) != 0) {
            this.compute = 4;
        } else if ((i & 1) != 0) {
            this.compute = 1;
        } else {
            this.compute = 0;
        }
    }

    public final void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        int i3;
        this.version = i;
        this.accessFlags = i2;
        int i4 = i & 65535;
        this.thisClass = this.symbolTable.setMajorVersionAndClassName(i4, str);
        if (str2 != null) {
            this.signatureIndex = this.symbolTable.addConstantUtf8(str2);
        }
        if (str3 == null) {
            i3 = 0;
        } else {
            i3 = this.symbolTable.addConstantClass(str3).index;
        }
        this.superClass = i3;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.interfaceCount = length;
            this.interfaces = new int[length];
            for (int i5 = 0; i5 < this.interfaceCount; i5++) {
                this.interfaces[i5] = this.symbolTable.addConstantClass(strArr[i5]).index;
            }
        }
        if (this.compute == 1 && i4 >= 51) {
            this.compute = 2;
        }
    }

    public final void visitSource(String str, String str2) {
        if (str != null) {
            this.sourceFileIndex = this.symbolTable.addConstantUtf8(str);
        }
        if (str2 != null) {
            this.debugExtension = new ByteVector().encodeUtf8(str2, 0, Integer.MAX_VALUE);
        }
    }

    public final ModuleVisitor visitModule(String str, int i, String str2) {
        int i2;
        SymbolTable symbolTable2 = this.symbolTable;
        int i3 = symbolTable2.addConstantModule(str).index;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = this.symbolTable.addConstantUtf8(str2);
        }
        ModuleWriter moduleWriter2 = new ModuleWriter(symbolTable2, i3, i, i2);
        this.moduleWriter = moduleWriter2;
        return moduleWriter2;
    }

    public final void visitNestHost(String str) {
        this.nestHostClassIndex = this.symbolTable.addConstantClass(str).index;
    }

    public final void visitOuterClass(String str, String str2, String str3) {
        this.enclosingClassIndex = this.symbolTable.addConstantClass(str).index;
        if (str2 != null && str3 != null) {
            this.enclosingMethodIndex = this.symbolTable.addConstantNameAndType(str2, str3);
        }
    }

    public final AnnotationVisitor visitAnnotation(String str, boolean z) {
        if (z) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, str, this.lastRuntimeVisibleAnnotation);
            this.lastRuntimeVisibleAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, str, this.lastRuntimeInvisibleAnnotation);
        this.lastRuntimeInvisibleAnnotation = create2;
        return create2;
    }

    public final AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        if (z) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, i, typePath, str, this.lastRuntimeVisibleTypeAnnotation);
            this.lastRuntimeVisibleTypeAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, i, typePath, str, this.lastRuntimeInvisibleTypeAnnotation);
        this.lastRuntimeInvisibleTypeAnnotation = create2;
        return create2;
    }

    public final void visitAttribute(Attribute attribute) {
        attribute.nextAttribute = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    public final void visitNestMember(String str) {
        if (this.nestMemberClasses == null) {
            this.nestMemberClasses = new ByteVector();
        }
        this.numberOfNestMemberClasses++;
        this.nestMemberClasses.putShort(this.symbolTable.addConstantClass(str).index);
    }

    public final void visitPermittedSubclass(String str) {
        if (this.permittedSubclasses == null) {
            this.permittedSubclasses = new ByteVector();
        }
        this.numberOfPermittedSubclasses++;
        this.permittedSubclasses.putShort(this.symbolTable.addConstantClass(str).index);
    }

    public final void visitInnerClass(String str, String str2, String str3, int i) {
        if (this.innerClasses == null) {
            this.innerClasses = new ByteVector();
        }
        Symbol addConstantClass = this.symbolTable.addConstantClass(str);
        if (addConstantClass.info == 0) {
            this.numberOfInnerClasses++;
            this.innerClasses.putShort(addConstantClass.index);
            int i2 = 0;
            this.innerClasses.putShort(str2 == null ? 0 : this.symbolTable.addConstantClass(str2).index);
            ByteVector byteVector = this.innerClasses;
            if (str3 != null) {
                i2 = this.symbolTable.addConstantUtf8(str3);
            }
            byteVector.putShort(i2);
            this.innerClasses.putShort(i);
            addConstantClass.info = this.numberOfInnerClasses;
        }
    }

    public final RecordComponentVisitor visitRecordComponent(String str, String str2, String str3) {
        RecordComponentWriter recordComponentWriter = new RecordComponentWriter(this.symbolTable, str, str2, str3);
        if (this.firstRecordComponent == null) {
            this.firstRecordComponent = recordComponentWriter;
        } else {
            this.lastRecordComponent.delegate = recordComponentWriter;
        }
        this.lastRecordComponent = recordComponentWriter;
        return recordComponentWriter;
    }

    public final FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        FieldWriter fieldWriter = new FieldWriter(this.symbolTable, i, str, str2, str3, obj);
        if (this.firstField == null) {
            this.firstField = fieldWriter;
        } else {
            this.lastField.fv = fieldWriter;
        }
        this.lastField = fieldWriter;
        return fieldWriter;
    }

    public final MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        MethodWriter methodWriter = new MethodWriter(this.symbolTable, i, str, str2, str3, strArr, this.compute);
        if (this.firstMethod == null) {
            this.firstMethod = methodWriter;
        } else {
            this.lastMethod.mv = methodWriter;
        }
        this.lastMethod = methodWriter;
        return methodWriter;
    }

    public byte[] toByteArray() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = (this.interfaceCount * 2) + 24;
        int i7 = 0;
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.fv) {
            i7++;
            i6 += fieldWriter.computeFieldInfoSize();
        }
        int i8 = 0;
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = (MethodWriter) methodWriter.mv) {
            i8++;
            i6 += methodWriter.computeMethodInfoSize();
        }
        ByteVector byteVector = this.innerClasses;
        if (byteVector != null) {
            i6 += byteVector.length + 8;
            this.symbolTable.addConstantUtf8("InnerClasses");
            i = 1;
        } else {
            i = 0;
        }
        if (this.enclosingClassIndex != 0) {
            i++;
            i6 += 10;
            this.symbolTable.addConstantUtf8("EnclosingMethod");
        }
        if ((this.accessFlags & 4096) != 0 && (this.version & 65535) < 49) {
            i++;
            i6 += 6;
            this.symbolTable.addConstantUtf8("Synthetic");
        }
        if (this.signatureIndex != 0) {
            i++;
            i6 += 8;
            this.symbolTable.addConstantUtf8("Signature");
        }
        if (this.sourceFileIndex != 0) {
            i++;
            i6 += 8;
            this.symbolTable.addConstantUtf8("SourceFile");
        }
        ByteVector byteVector2 = this.debugExtension;
        if (byteVector2 != null) {
            i++;
            i6 += byteVector2.length + 6;
            this.symbolTable.addConstantUtf8("SourceDebugExtension");
        }
        if ((this.accessFlags & 131072) != 0) {
            i++;
            i6 += 6;
            this.symbolTable.addConstantUtf8("Deprecated");
        }
        AnnotationWriter annotationWriter = this.lastRuntimeVisibleAnnotation;
        if (annotationWriter != null) {
            i++;
            i6 += annotationWriter.computeAnnotationsSize("RuntimeVisibleAnnotations");
        }
        AnnotationWriter annotationWriter2 = this.lastRuntimeInvisibleAnnotation;
        if (annotationWriter2 != null) {
            i++;
            i6 += annotationWriter2.computeAnnotationsSize("RuntimeInvisibleAnnotations");
        }
        AnnotationWriter annotationWriter3 = this.lastRuntimeVisibleTypeAnnotation;
        if (annotationWriter3 != null) {
            i++;
            i6 += annotationWriter3.computeAnnotationsSize("RuntimeVisibleTypeAnnotations");
        }
        AnnotationWriter annotationWriter4 = this.lastRuntimeInvisibleTypeAnnotation;
        if (annotationWriter4 != null) {
            i++;
            i6 += annotationWriter4.computeAnnotationsSize("RuntimeInvisibleTypeAnnotations");
        }
        if (this.symbolTable.computeBootstrapMethodsSize() > 0) {
            i++;
            i6 += this.symbolTable.computeBootstrapMethodsSize();
        }
        ModuleWriter moduleWriter2 = this.moduleWriter;
        if (moduleWriter2 != null) {
            i += moduleWriter2.getAttributeCount();
            i6 += this.moduleWriter.computeAttributesSize();
        }
        if (this.nestHostClassIndex != 0) {
            i++;
            i6 += 8;
            this.symbolTable.addConstantUtf8("NestHost");
        }
        ByteVector byteVector3 = this.nestMemberClasses;
        if (byteVector3 != null) {
            i++;
            i6 += byteVector3.length + 8;
            this.symbolTable.addConstantUtf8("NestMembers");
        }
        ByteVector byteVector4 = this.permittedSubclasses;
        if (byteVector4 != null) {
            i++;
            i6 += byteVector4.length + 8;
            this.symbolTable.addConstantUtf8("PermittedSubclasses");
        }
        String str = "PermittedSubclasses";
        if ((this.accessFlags & 65536) == 0 && this.firstRecordComponent == null) {
            i3 = 0;
            i2 = 0;
        } else {
            i3 = 0;
            i2 = 0;
            for (RecordComponentWriter recordComponentWriter = this.firstRecordComponent; recordComponentWriter != null; recordComponentWriter = (RecordComponentWriter) recordComponentWriter.delegate) {
                i2++;
                i3 += recordComponentWriter.computeRecordComponentInfoSize();
            }
            i++;
            i6 += i3 + 8;
            this.symbolTable.addConstantUtf8("Record");
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            i6 += this.firstAttribute.computeAttributesSize(this.symbolTable);
            i += attribute.getAttributeCount();
        }
        int constantPoolLength = i6 + this.symbolTable.getConstantPoolLength();
        int constantPoolCount = this.symbolTable.getConstantPoolCount();
        String str2 = "Record";
        if (constantPoolCount <= 65535) {
            ByteVector byteVector5 = new ByteVector(constantPoolLength);
            byteVector5.putInt(-889275714).putInt(this.version);
            this.symbolTable.putConstantPool(byteVector5);
            byteVector5.putShort((~((this.version & 65535) < 49 ? 4096 : 0)) & this.accessFlags).putShort(this.thisClass).putShort(this.superClass);
            byteVector5.putShort(this.interfaceCount);
            for (int i9 = 0; i9 < this.interfaceCount; i9++) {
                byteVector5.putShort(this.interfaces[i9]);
            }
            byteVector5.putShort(i7);
            for (FieldWriter fieldWriter2 = this.firstField; fieldWriter2 != null; fieldWriter2 = (FieldWriter) fieldWriter2.fv) {
                fieldWriter2.putFieldInfo(byteVector5);
            }
            byteVector5.putShort(i8);
            boolean z = false;
            boolean z2 = false;
            for (MethodWriter methodWriter2 = this.firstMethod; methodWriter2 != null; methodWriter2 = (MethodWriter) methodWriter2.mv) {
                z |= methodWriter2.hasFrames();
                z2 |= methodWriter2.hasAsmInstructions();
                methodWriter2.putMethodInfo(byteVector5);
            }
            byteVector5.putShort(i);
            if (this.innerClasses != null) {
                byteVector5.putShort(this.symbolTable.addConstantUtf8("InnerClasses")).putInt(this.innerClasses.length + 2).putShort(this.numberOfInnerClasses).putByteArray(this.innerClasses.data, 0, this.innerClasses.length);
            }
            if (this.enclosingClassIndex != 0) {
                byteVector5.putShort(this.symbolTable.addConstantUtf8("EnclosingMethod")).putInt(4).putShort(this.enclosingClassIndex).putShort(this.enclosingMethodIndex);
            }
            if ((this.accessFlags & 4096) != 0 && (this.version & 65535) < 49) {
                byteVector5.putShort(this.symbolTable.addConstantUtf8("Synthetic")).putInt(0);
            }
            if (this.signatureIndex != 0) {
                i4 = 2;
                byteVector5.putShort(this.symbolTable.addConstantUtf8("Signature")).putInt(2).putShort(this.signatureIndex);
            } else {
                i4 = 2;
            }
            if (this.sourceFileIndex != 0) {
                byteVector5.putShort(this.symbolTable.addConstantUtf8("SourceFile")).putInt(i4).putShort(this.sourceFileIndex);
            }
            ByteVector byteVector6 = this.debugExtension;
            if (byteVector6 != null) {
                int i10 = byteVector6.length;
                i5 = 0;
                byteVector5.putShort(this.symbolTable.addConstantUtf8("SourceDebugExtension")).putInt(i10).putByteArray(this.debugExtension.data, 0, i10);
            } else {
                i5 = 0;
            }
            if ((this.accessFlags & 131072) != 0) {
                byteVector5.putShort(this.symbolTable.addConstantUtf8("Deprecated")).putInt(i5);
            }
            AnnotationWriter.putAnnotations(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, byteVector5);
            this.symbolTable.putBootstrapMethods(byteVector5);
            ModuleWriter moduleWriter3 = this.moduleWriter;
            if (moduleWriter3 != null) {
                moduleWriter3.putAttributes(byteVector5);
            }
            if (this.nestHostClassIndex != 0) {
                byteVector5.putShort(this.symbolTable.addConstantUtf8("NestHost")).putInt(2).putShort(this.nestHostClassIndex);
            }
            if (this.nestMemberClasses != null) {
                byteVector5.putShort(this.symbolTable.addConstantUtf8("NestMembers")).putInt(this.nestMemberClasses.length + 2).putShort(this.numberOfNestMemberClasses).putByteArray(this.nestMemberClasses.data, 0, this.nestMemberClasses.length);
            }
            if (this.permittedSubclasses != null) {
                byteVector5.putShort(this.symbolTable.addConstantUtf8(str)).putInt(this.permittedSubclasses.length + 2).putShort(this.numberOfPermittedSubclasses).putByteArray(this.permittedSubclasses.data, 0, this.permittedSubclasses.length);
            }
            if (!((this.accessFlags & 65536) == 0 && this.firstRecordComponent == null)) {
                byteVector5.putShort(this.symbolTable.addConstantUtf8(str2)).putInt(i3 + 2).putShort(i2);
                for (RecordComponentWriter recordComponentWriter2 = this.firstRecordComponent; recordComponentWriter2 != null; recordComponentWriter2 = (RecordComponentWriter) recordComponentWriter2.delegate) {
                    recordComponentWriter2.putRecordComponentInfo(byteVector5);
                }
            }
            Attribute attribute2 = this.firstAttribute;
            if (attribute2 != null) {
                attribute2.putAttributes(this.symbolTable, byteVector5);
            }
            if (z2) {
                return replaceAsmInstructions(byteVector5.data, z);
            }
            return byteVector5.data;
        }
        throw new ClassTooLargeException(this.symbolTable.getClassName(), constantPoolCount);
    }

    private byte[] replaceAsmInstructions(byte[] bArr, boolean z) {
        Attribute[] attributePrototypes = getAttributePrototypes();
        this.firstField = null;
        this.lastField = null;
        this.firstMethod = null;
        this.lastMethod = null;
        this.lastRuntimeVisibleAnnotation = null;
        this.lastRuntimeInvisibleAnnotation = null;
        this.lastRuntimeVisibleTypeAnnotation = null;
        this.lastRuntimeInvisibleTypeAnnotation = null;
        this.moduleWriter = null;
        int i = 0;
        this.nestHostClassIndex = 0;
        this.numberOfNestMemberClasses = 0;
        this.nestMemberClasses = null;
        this.numberOfPermittedSubclasses = 0;
        this.permittedSubclasses = null;
        this.firstRecordComponent = null;
        this.lastRecordComponent = null;
        this.firstAttribute = null;
        this.compute = z ? 3 : 0;
        ClassReader classReader = new ClassReader(bArr, 0, false);
        if (z) {
            i = 8;
        }
        classReader.accept(this, attributePrototypes, i | 256);
        return toByteArray();
    }

    private Attribute[] getAttributePrototypes() {
        Attribute.Set set = new Attribute.Set();
        set.addAttributes(this.firstAttribute);
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.fv) {
            fieldWriter.collectAttributePrototypes(set);
        }
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = (MethodWriter) methodWriter.mv) {
            methodWriter.collectAttributePrototypes(set);
        }
        for (RecordComponentWriter recordComponentWriter = this.firstRecordComponent; recordComponentWriter != null; recordComponentWriter = (RecordComponentWriter) recordComponentWriter.delegate) {
            recordComponentWriter.collectAttributePrototypes(set);
        }
        return set.toArray();
    }

    public int newConst(Object obj) {
        return this.symbolTable.addConstant(obj).index;
    }

    public int newUTF8(String str) {
        return this.symbolTable.addConstantUtf8(str);
    }

    public int newClass(String str) {
        return this.symbolTable.addConstantClass(str).index;
    }

    public int newMethodType(String str) {
        return this.symbolTable.addConstantMethodType(str).index;
    }

    public int newModule(String str) {
        return this.symbolTable.addConstantModule(str).index;
    }

    public int newPackage(String str) {
        return this.symbolTable.addConstantPackage(str).index;
    }

    @Deprecated
    public int newHandle(int i, String str, String str2, String str3) {
        return newHandle(i, str, str2, str3, i == 9);
    }

    public int newHandle(int i, String str, String str2, String str3, boolean z) {
        return this.symbolTable.addConstantMethodHandle(i, str, str2, str3, z).index;
    }

    public int newConstantDynamic(String str, String str2, Handle handle, Object... objArr) {
        return this.symbolTable.addConstantDynamic(str, str2, handle, objArr).index;
    }

    public int newInvokeDynamic(String str, String str2, Handle handle, Object... objArr) {
        return this.symbolTable.addConstantInvokeDynamic(str, str2, handle, objArr).index;
    }

    public int newField(String str, String str2, String str3) {
        return this.symbolTable.addConstantFieldref(str, str2, str3).index;
    }

    public int newMethod(String str, String str2, String str3, boolean z) {
        return this.symbolTable.addConstantMethodref(str, str2, str3, z).index;
    }

    public int newNameType(String str, String str2) {
        return this.symbolTable.addConstantNameAndType(str, str2);
    }

    /* access modifiers changed from: protected */
    public String getCommonSuperClass(String str, String str2) {
        ClassLoader classLoader = getClassLoader();
        try {
            Class cls = Class.forName(str.replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR), false, classLoader);
            try {
                Class<?> cls2 = Class.forName(str2.replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR), false, classLoader);
                if (cls.isAssignableFrom(cls2)) {
                    return str;
                }
                if (cls2.isAssignableFrom(cls)) {
                    return str2;
                }
                if (cls.isInterface() || cls2.isInterface()) {
                    return "java/lang/Object";
                }
                do {
                    cls = cls.getSuperclass();
                } while (!cls.isAssignableFrom(cls2));
                return cls.getName().replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/');
            } catch (ClassNotFoundException e) {
                throw new TypeNotPresentException(str2, e);
            }
        } catch (ClassNotFoundException e2) {
            throw new TypeNotPresentException(str, e2);
        }
    }

    /* access modifiers changed from: protected */
    public ClassLoader getClassLoader() {
        return getClass().getClassLoader();
    }
}
