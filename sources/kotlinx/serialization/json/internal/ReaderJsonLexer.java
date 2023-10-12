package kotlinx.serialization.json.internal;

import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0014H\u0016J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0014H\u0002J\u0018\u0010(\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020\u001aH\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "i", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V", "reader", "Ljava/io/Reader;", "_source", "", "(Ljava/io/Reader;[C)V", "<set-?>", "", "source", "getSource", "()Ljava/lang/CharSequence;", "setSource", "(Ljava/lang/CharSequence;)V", "threshold", "", "appendRange", "", "fromIndex", "toIndex", "canConsumeValue", "", "consumeKeyString", "", "consumeNextToken", "", "ensureHaveChars", "indexOf", "char", "", "startPos", "prefetchOrEof", "position", "preload", "spaceLeft", "substring", "endPos", "tryConsumeComma", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsonLexerJvm.kt */
public final class ReaderJsonLexer extends AbstractJsonLexer {
    private char[] _source;
    private final Reader reader;
    private CharSequence source;
    private int threshold;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReaderJsonLexer(Reader reader2, char[] cArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reader2, (i & 2) != 0 ? new char[16384] : cArr);
    }

    public ReaderJsonLexer(Reader reader2, char[] cArr) {
        Intrinsics.checkNotNullParameter(reader2, "reader");
        Intrinsics.checkNotNullParameter(cArr, "_source");
        this.reader = reader2;
        this._source = cArr;
        this.threshold = 128;
        this.source = new ArrayAsSequence(cArr);
        preload(0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ReaderJsonLexer(java.io.InputStream r2, java.nio.charset.Charset r3) {
        /*
            r1 = this;
            java.lang.String r0 = "i"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r2, r3)
            java.io.Reader r0 = (java.io.Reader) r0
            boolean r2 = r0 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x0018
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x0020
        L_0x0018:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r3 = 262144(0x40000, float:3.67342E-40)
            r2.<init>(r0, r3)
            r0 = r2
        L_0x0020:
            java.io.Reader r0 = (java.io.Reader) r0
            r2 = 2
            r3 = 0
            r1.<init>((java.io.Reader) r0, (char[]) r3, (int) r2, (kotlin.jvm.internal.DefaultConstructorMarker) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.ReaderJsonLexer.<init>(java.io.InputStream, java.nio.charset.Charset):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReaderJsonLexer(InputStream inputStream, Charset charset, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputStream, (i & 2) != 0 ? Charsets.UTF_8 : charset);
    }

    /* access modifiers changed from: protected */
    public CharSequence getSource() {
        return this.source;
    }

    public void setSource(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.source = charSequence;
    }

    public boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= getSource().length() || skipWhitespaces == -1 || getSource().charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        int i = this.currentPosition;
        return true;
    }

    public boolean canConsumeValue() {
        ensureHaveChars();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof == -1) {
                this.currentPosition = prefetchOrEof;
                return false;
            }
            char charAt = getSource().charAt(prefetchOrEof);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i = prefetchOrEof + 1;
            } else {
                this.currentPosition = prefetchOrEof;
                return isValidValueStart(charAt);
            }
        }
    }

    private final void preload(int i) {
        char[] cArr = this._source;
        System.arraycopy(cArr, this.currentPosition, cArr, 0, i);
        int length = this._source.length;
        while (true) {
            if (i == length) {
                break;
            }
            int read = this.reader.read(cArr, i, length - i);
            if (read == -1) {
                char[] copyOf = Arrays.copyOf(this._source, i);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this._source = copyOf;
                setSource(new ArrayAsSequence(copyOf));
                this.threshold = -1;
                break;
            }
            i += read;
        }
        this.currentPosition = 0;
    }

    public int prefetchOrEof(int i) {
        if (i < getSource().length()) {
            return i;
        }
        this.currentPosition = i;
        ensureHaveChars();
        if (this.currentPosition != 0) {
            return -1;
        }
        return getSource().length() == 0 ? -1 : 0;
    }

    public byte consumeNextToken() {
        ensureHaveChars();
        CharSequence source2 = getSource();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof == -1) {
                this.currentPosition = prefetchOrEof;
                return 10;
            }
            int i2 = prefetchOrEof + 1;
            byte charToTokenClass = AbstractJsonLexerKt.charToTokenClass(source2.charAt(prefetchOrEof));
            if (charToTokenClass == 3) {
                i = i2;
            } else {
                this.currentPosition = i2;
                return charToTokenClass;
            }
        }
    }

    public void ensureHaveChars() {
        int length = this._source.length - this.currentPosition;
        if (length <= this.threshold) {
            preload(length);
        }
    }

    public String consumeKeyString() {
        consumeNextToken('\"');
        int i = this.currentPosition;
        int indexOf = indexOf('\"', i);
        if (indexOf == -1) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof != -1) {
                return consumeString(getSource(), this.currentPosition, prefetchOrEof);
            }
            fail$kotlinx_serialization_json((byte) 1);
            throw new KotlinNothingValueException();
        }
        int i2 = i;
        while (i2 < indexOf) {
            int i3 = i2 + 1;
            if (getSource().charAt(i2) == '\\') {
                return consumeString(getSource(), this.currentPosition, i2);
            }
            i2 = i3;
        }
        this.currentPosition = indexOf + 1;
        return substring(i, indexOf);
    }

    public int indexOf(char c, int i) {
        char[] cArr = this._source;
        int length = cArr.length;
        while (i < length) {
            int i2 = i + 1;
            if (cArr[i] == c) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    public String substring(int i, int i2) {
        return new String(this._source, i, i2 - i);
    }

    /* access modifiers changed from: protected */
    public void appendRange(int i, int i2) {
        getEscapedString().append(this._source, i, i2 - i);
    }
}
