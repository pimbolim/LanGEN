package org.bouncycastle.asn1;

import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERPrivate extends ASN1Private {
    public DERPrivate(int i, ASN1Encodable aSN1Encodable) throws IOException {
        this(true, i, aSN1Encodable);
    }

    public DERPrivate(int i, ASN1EncodableVector aSN1EncodableVector) {
        super(true, i, getEncodedVector(aSN1EncodableVector));
    }

    public DERPrivate(int i, byte[] bArr) {
        this(false, i, bArr);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DERPrivate(boolean z, int i, ASN1Encodable aSN1Encodable) throws IOException {
        super(z || aSN1Encodable.toASN1Primitive().isConstructed(), i, getEncoding(z, aSN1Encodable));
    }

    DERPrivate(boolean z, int i, byte[] bArr) {
        super(z, i, bArr);
    }

    private static byte[] getEncodedVector(ASN1EncodableVector aSN1EncodableVector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i != aSN1EncodableVector.size()) {
            try {
                byteArrayOutputStream.write(((ASN1Object) aSN1EncodableVector.get(i)).getEncoded(ASN1Encoding.DER));
                i++;
            } catch (IOException e) {
                throw new ASN1ParsingException("malformed object: " + e, e);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] getEncoding(boolean z, ASN1Encodable aSN1Encodable) throws IOException {
        byte[] encoded = aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        if (z) {
            return encoded;
        }
        int lengthOfHeader = getLengthOfHeader(encoded);
        int length = encoded.length - lengthOfHeader;
        byte[] bArr = new byte[length];
        System.arraycopy(encoded, lengthOfHeader, bArr, 0, length);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, this.isConstructed ? CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY : 192, this.tag, this.octets);
    }
}
