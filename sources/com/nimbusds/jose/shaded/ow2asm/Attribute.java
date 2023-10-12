package com.nimbusds.jose.shaded.ow2asm;

public class Attribute {
    private byte[] content;
    Attribute nextAttribute;
    public final String type;

    /* access modifiers changed from: protected */
    public Label[] getLabels() {
        return new Label[0];
    }

    public boolean isCodeAttribute() {
        return false;
    }

    public boolean isUnknown() {
        return true;
    }

    protected Attribute(String str) {
        this.type = str;
    }

    /* access modifiers changed from: protected */
    public Attribute read(ClassReader classReader, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        Attribute attribute = new Attribute(this.type);
        attribute.content = new byte[i2];
        System.arraycopy(classReader.classFileBuffer, i, attribute.content, 0, i2);
        return attribute;
    }

    /* access modifiers changed from: protected */
    public ByteVector write(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        return new ByteVector(this.content);
    }

    /* access modifiers changed from: package-private */
    public final int getAttributeCount() {
        int i = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            i++;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final int computeAttributesSize(SymbolTable symbolTable) {
        return computeAttributesSize(symbolTable, (byte[]) null, 0, -1, -1);
    }

    /* access modifiers changed from: package-private */
    public final int computeAttributesSize(SymbolTable symbolTable, byte[] bArr, int i, int i2, int i3) {
        ClassWriter classWriter = symbolTable.classWriter;
        int i4 = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            symbolTable.addConstantUtf8(attribute.type);
            i4 += attribute.write(classWriter, bArr, i, i2, i3).length + 6;
        }
        return i4;
    }

    static int computeAttributesSize(SymbolTable symbolTable, int i, int i2) {
        int i3;
        if ((i & 4096) == 0 || symbolTable.getMajorVersion() >= 49) {
            i3 = 0;
        } else {
            symbolTable.addConstantUtf8("Synthetic");
            i3 = 6;
        }
        if (i2 != 0) {
            symbolTable.addConstantUtf8("Signature");
            i3 += 8;
        }
        if ((i & 131072) == 0) {
            return i3;
        }
        symbolTable.addConstantUtf8("Deprecated");
        return i3 + 6;
    }

    /* access modifiers changed from: package-private */
    public final void putAttributes(SymbolTable symbolTable, ByteVector byteVector) {
        putAttributes(symbolTable, (byte[]) null, 0, -1, -1, byteVector);
    }

    /* access modifiers changed from: package-private */
    public final void putAttributes(SymbolTable symbolTable, byte[] bArr, int i, int i2, int i3, ByteVector byteVector) {
        ClassWriter classWriter = symbolTable.classWriter;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            ByteVector write = attribute.write(classWriter, bArr, i, i2, i3);
            byteVector.putShort(symbolTable.addConstantUtf8(attribute.type)).putInt(write.length);
            byteVector.putByteArray(write.data, 0, write.length);
        }
    }

    static void putAttributes(SymbolTable symbolTable, int i, int i2, ByteVector byteVector) {
        if ((i & 4096) != 0 && symbolTable.getMajorVersion() < 49) {
            byteVector.putShort(symbolTable.addConstantUtf8("Synthetic")).putInt(0);
        }
        if (i2 != 0) {
            byteVector.putShort(symbolTable.addConstantUtf8("Signature")).putInt(2).putShort(i2);
        }
        if ((i & 131072) != 0) {
            byteVector.putShort(symbolTable.addConstantUtf8("Deprecated")).putInt(0);
        }
    }

    static final class Set {
        private static final int SIZE_INCREMENT = 6;
        private Attribute[] data = new Attribute[6];
        private int size;

        Set() {
        }

        /* access modifiers changed from: package-private */
        public void addAttributes(Attribute attribute) {
            while (attribute != null) {
                if (!contains(attribute)) {
                    add(attribute);
                }
                attribute = attribute.nextAttribute;
            }
        }

        /* access modifiers changed from: package-private */
        public Attribute[] toArray() {
            int i = this.size;
            Attribute[] attributeArr = new Attribute[i];
            System.arraycopy(this.data, 0, attributeArr, 0, i);
            return attributeArr;
        }

        private boolean contains(Attribute attribute) {
            for (int i = 0; i < this.size; i++) {
                if (this.data[i].type.equals(attribute.type)) {
                    return true;
                }
            }
            return false;
        }

        private void add(Attribute attribute) {
            int i = this.size;
            Attribute[] attributeArr = this.data;
            if (i >= attributeArr.length) {
                Attribute[] attributeArr2 = new Attribute[(attributeArr.length + 6)];
                System.arraycopy(attributeArr, 0, attributeArr2, 0, i);
                this.data = attributeArr2;
            }
            Attribute[] attributeArr3 = this.data;
            int i2 = this.size;
            this.size = i2 + 1;
            attributeArr3[i2] = attribute;
        }
    }
}
