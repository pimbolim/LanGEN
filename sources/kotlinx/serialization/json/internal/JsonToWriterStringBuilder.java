package kotlinx.serialization.json.internal;

import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/json/internal/JsonToWriterStringBuilder;", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "os", "Ljava/io/OutputStream;", "charset", "Ljava/nio/charset/Charset;", "(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V", "writer", "Ljava/io/Writer;", "(Ljava/io/Writer;)V", "ensureTotalCapacity", "", "oldSize", "additional", "flush", "", "sz", "release", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsonToWriterStringBuilder.kt */
public final class JsonToWriterStringBuilder extends JsonStringBuilder {
    private final Writer writer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonToWriterStringBuilder(Writer writer2) {
        super(new char[16384]);
        Intrinsics.checkNotNullParameter(writer2, "writer");
        this.writer = writer2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JsonToWriterStringBuilder(java.io.OutputStream r2, java.nio.charset.Charset r3) {
        /*
            r1 = this;
            java.lang.String r0 = "os"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter
            r0.<init>(r2, r3)
            java.io.Writer r0 = (java.io.Writer) r0
            boolean r2 = r0 instanceof java.io.BufferedWriter
            if (r2 == 0) goto L_0x0018
            java.io.BufferedWriter r0 = (java.io.BufferedWriter) r0
            goto L_0x0020
        L_0x0018:
            java.io.BufferedWriter r2 = new java.io.BufferedWriter
            r3 = 262144(0x40000, float:3.67342E-40)
            r2.<init>(r0, r3)
            r0 = r2
        L_0x0020:
            java.io.Writer r0 = (java.io.Writer) r0
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonToWriterStringBuilder.<init>(java.io.OutputStream, java.nio.charset.Charset):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonToWriterStringBuilder(OutputStream outputStream, Charset charset, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(outputStream, (i & 2) != 0 ? Charsets.UTF_8 : charset);
    }

    /* access modifiers changed from: protected */
    public int ensureTotalCapacity(int i, int i2) {
        int i3 = i + i2;
        int length = this.array.length;
        if (length > i3) {
            return i;
        }
        flush(i);
        if (i2 > length) {
            this.array = new char[RangesKt.coerceAtLeast(i3, length * 2)];
        }
        return 0;
    }

    static /* synthetic */ void flush$default(JsonToWriterStringBuilder jsonToWriterStringBuilder, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = jsonToWriterStringBuilder.getSize();
        }
        jsonToWriterStringBuilder.flush(i);
    }

    private final void flush(int i) {
        this.writer.write(this.array, 0, i);
        setSize(0);
    }

    public void release() {
        flush$default(this, 0, 1, (Object) null);
        this.writer.flush();
    }
}
