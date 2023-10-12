package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/json/internal/ArrayAsSequence;", "", "source", "", "([C)V", "length", "", "getLength", "()I", "get", "", "index", "subSequence", "startIndex", "endIndex", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsonLexerJvm.kt */
final class ArrayAsSequence implements CharSequence {
    private final int length;
    private final char[] source;

    public ArrayAsSequence(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "source");
        this.source = cArr;
        this.length = cArr.length;
    }

    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final /* bridge */ int length() {
        return getLength();
    }

    public int getLength() {
        return this.length;
    }

    public char get(int i) {
        return this.source[i];
    }

    public CharSequence subSequence(int i, int i2) {
        return new String(this.source, i, i2 - i);
    }
}
