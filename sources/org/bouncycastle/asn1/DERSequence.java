package org.bouncycastle.asn1;

import java.io.IOException;

public class DERSequence extends ASN1Sequence {
    private int bodyLength = -1;

    public DERSequence() {
    }

    public DERSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public DERSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
    }

    DERSequence(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        super(aSN1EncodableArr, z);
    }

    public static DERSequence convert(ASN1Sequence aSN1Sequence) {
        return (DERSequence) aSN1Sequence.toDERObject();
    }

    private int getBodyLength() throws IOException {
        if (this.bodyLength < 0) {
            int i = 0;
            for (ASN1Encodable aSN1Primitive : this.elements) {
                i += aSN1Primitive.toASN1Primitive().toDERObject().encodedLength();
            }
            this.bodyLength = i;
        }
        return this.bodyLength;
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        if (z) {
            aSN1OutputStream.write(48);
        }
        DEROutputStream dERSubStream = aSN1OutputStream.getDERSubStream();
        int length = this.elements.length;
        int i = 0;
        if (this.bodyLength >= 0 || length > 16) {
            aSN1OutputStream.writeLength(getBodyLength());
            while (i < length) {
                this.elements[i].toASN1Primitive().toDERObject().encode(dERSubStream, true);
                i++;
            }
            return;
        }
        ASN1Primitive[] aSN1PrimitiveArr = new ASN1Primitive[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            ASN1Primitive dERObject = this.elements[i3].toASN1Primitive().toDERObject();
            aSN1PrimitiveArr[i3] = dERObject;
            i2 += dERObject.encodedLength();
        }
        this.bodyLength = i2;
        aSN1OutputStream.writeLength(i2);
        while (i < length) {
            aSN1PrimitiveArr[i].encode(dERSubStream, true);
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() throws IOException {
        int bodyLength2 = getBodyLength();
        return StreamUtil.calculateBodyLength(bodyLength2) + 1 + bodyLength2;
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDERObject() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDLObject() {
        return this;
    }
}
