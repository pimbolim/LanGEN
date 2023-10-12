package kotlinx.serialization.json.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0010\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/json/internal/JsonStringBuilder;", "", "()V", "array", "", "([C)V", "size", "", "getSize", "()I", "setSize", "(I)V", "append", "", "ch", "", "value", "", "string", "", "appendQuoted", "appendStringSlowPath", "firstEscapedChar", "currentSize", "ensureAdditionalCapacity", "expected", "ensureTotalCapacity", "oldSize", "additional", "release", "toString", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsonStringBuilder.kt */
public class JsonStringBuilder {
    protected char[] array;
    private int size;

    public JsonStringBuilder(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "array");
        this.array = cArr;
    }

    public JsonStringBuilder() {
        this(CharArrayPool.INSTANCE.take());
    }

    /* access modifiers changed from: protected */
    public final int getSize() {
        return this.size;
    }

    /* access modifiers changed from: protected */
    public final void setSize(int i) {
        this.size = i;
    }

    public final void append(long j) {
        append(String.valueOf(j));
    }

    public final void append(char c) {
        ensureAdditionalCapacity(1);
        char[] cArr = this.array;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = c;
    }

    public final void append(String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        int length = str.length();
        ensureAdditionalCapacity(length);
        str.getChars(0, str.length(), this.array, this.size);
        this.size += length;
    }

    public final void appendQuoted(String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        ensureAdditionalCapacity(str.length() + 2);
        char[] cArr = this.array;
        int i = this.size;
        int i2 = i + 1;
        cArr[i] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        int i3 = length + i2;
        int i4 = i2;
        while (i4 < i3) {
            int i5 = i4 + 1;
            char c = cArr[i4];
            if (c >= StringOpsKt.getESCAPE_MARKERS().length || StringOpsKt.getESCAPE_MARKERS()[c] == 0) {
                i4 = i5;
            } else {
                appendStringSlowPath(i4 - i2, i4, str);
                return;
            }
        }
        cArr[i3] = '\"';
        this.size = i3 + 1;
    }

    private final void appendStringSlowPath(int i, int i2, String str) {
        int i3;
        int length = str.length();
        while (i < length) {
            int i4 = i + 1;
            int ensureTotalCapacity = ensureTotalCapacity(i2, 2);
            char charAt = str.charAt(i);
            if (charAt < StringOpsKt.getESCAPE_MARKERS().length) {
                byte b = StringOpsKt.getESCAPE_MARKERS()[charAt];
                if (b == 0) {
                    i3 = ensureTotalCapacity + 1;
                    this.array[ensureTotalCapacity] = (char) charAt;
                } else {
                    if (b == 1) {
                        String str2 = StringOpsKt.getESCAPE_STRINGS()[charAt];
                        Intrinsics.checkNotNull(str2);
                        int ensureTotalCapacity2 = ensureTotalCapacity(ensureTotalCapacity, str2.length());
                        str2.getChars(0, str2.length(), this.array, ensureTotalCapacity2);
                        i2 = ensureTotalCapacity2 + str2.length();
                        this.size = i2;
                    } else {
                        char[] cArr = this.array;
                        cArr[ensureTotalCapacity] = AbstractJsonLexerKt.STRING_ESC;
                        cArr[ensureTotalCapacity + 1] = (char) b;
                        i2 = ensureTotalCapacity + 2;
                        this.size = i2;
                    }
                    i = i4;
                }
            } else {
                i3 = ensureTotalCapacity + 1;
                this.array[ensureTotalCapacity] = (char) charAt;
            }
            i = i4;
            i2 = i3;
        }
        int ensureTotalCapacity3 = ensureTotalCapacity(i2, 1);
        this.array[ensureTotalCapacity3] = '\"';
        this.size = ensureTotalCapacity3 + 1;
    }

    public String toString() {
        return new String(this.array, 0, this.size);
    }

    private final void ensureAdditionalCapacity(int i) {
        ensureTotalCapacity(this.size, i);
    }

    /* access modifiers changed from: protected */
    public int ensureTotalCapacity(int i, int i2) {
        int i3 = i2 + i;
        char[] cArr = this.array;
        if (cArr.length <= i3) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt.coerceAtLeast(i3, i * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.array = copyOf;
        }
        return i;
    }

    public void release() {
        CharArrayPool.INSTANCE.release(this.array);
    }
}
