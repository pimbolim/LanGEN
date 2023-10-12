package com.nimbusds.jose.shaded.ow2asm;

import com.nimbusds.jose.shaded.ow2asm.Attribute;

final class FieldWriter extends FieldVisitor {
    private final int accessFlags;
    private int constantValueIndex;
    private final int descriptorIndex;
    private Attribute firstAttribute;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private final int nameIndex;
    private int signatureIndex;
    private final SymbolTable symbolTable;

    public void visitEnd() {
    }

    FieldWriter(SymbolTable symbolTable2, int i, String str, String str2, String str3, Object obj) {
        super(Opcodes.ASM9);
        this.symbolTable = symbolTable2;
        this.accessFlags = i;
        this.nameIndex = symbolTable2.addConstantUtf8(str);
        this.descriptorIndex = symbolTable2.addConstantUtf8(str2);
        if (str3 != null) {
            this.signatureIndex = symbolTable2.addConstantUtf8(str3);
        }
        if (obj != null) {
            this.constantValueIndex = symbolTable2.addConstant(obj).index;
        }
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        if (z) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, str, this.lastRuntimeVisibleAnnotation);
            this.lastRuntimeVisibleAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, str, this.lastRuntimeInvisibleAnnotation);
        this.lastRuntimeInvisibleAnnotation = create2;
        return create2;
    }

    public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        if (z) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, i, typePath, str, this.lastRuntimeVisibleTypeAnnotation);
            this.lastRuntimeVisibleTypeAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, i, typePath, str, this.lastRuntimeInvisibleTypeAnnotation);
        this.lastRuntimeInvisibleTypeAnnotation = create2;
        return create2;
    }

    public void visitAttribute(Attribute attribute) {
        attribute.nextAttribute = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    /* access modifiers changed from: package-private */
    public int computeFieldInfoSize() {
        int i;
        if (this.constantValueIndex != 0) {
            this.symbolTable.addConstantUtf8("ConstantValue");
            i = 16;
        } else {
            i = 8;
        }
        int computeAttributesSize = i + Attribute.computeAttributesSize(this.symbolTable, this.accessFlags, this.signatureIndex) + AnnotationWriter.computeAnnotationsSize(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
        Attribute attribute = this.firstAttribute;
        return attribute != null ? computeAttributesSize + attribute.computeAttributesSize(this.symbolTable) : computeAttributesSize;
    }

    /* access modifiers changed from: package-private */
    public void putFieldInfo(ByteVector byteVector) {
        int i = 0;
        boolean z = this.symbolTable.getMajorVersion() < 49;
        byteVector.putShort((~(z ? 4096 : 0)) & this.accessFlags).putShort(this.nameIndex).putShort(this.descriptorIndex);
        if (this.constantValueIndex != 0) {
            i = 1;
        }
        int i2 = this.accessFlags;
        if ((i2 & 4096) != 0 && z) {
            i++;
        }
        if (this.signatureIndex != 0) {
            i++;
        }
        if ((131072 & i2) != 0) {
            i++;
        }
        if (this.lastRuntimeVisibleAnnotation != null) {
            i++;
        }
        if (this.lastRuntimeInvisibleAnnotation != null) {
            i++;
        }
        if (this.lastRuntimeVisibleTypeAnnotation != null) {
            i++;
        }
        if (this.lastRuntimeInvisibleTypeAnnotation != null) {
            i++;
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            i += attribute.getAttributeCount();
        }
        byteVector.putShort(i);
        if (this.constantValueIndex != 0) {
            byteVector.putShort(this.symbolTable.addConstantUtf8("ConstantValue")).putInt(2).putShort(this.constantValueIndex);
        }
        Attribute.putAttributes(this.symbolTable, this.accessFlags, this.signatureIndex, byteVector);
        AnnotationWriter.putAnnotations(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, byteVector);
        Attribute attribute2 = this.firstAttribute;
        if (attribute2 != null) {
            attribute2.putAttributes(this.symbolTable, byteVector);
        }
    }

    /* access modifiers changed from: package-private */
    public final void collectAttributePrototypes(Attribute.Set set) {
        set.addAttributes(this.firstAttribute);
    }
}
