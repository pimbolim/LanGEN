package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, d2 = {"kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$encodeTaggedInline$1", "Lkotlinx/serialization/encoding/AbstractEncoder;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeByte", "", "value", "", "encodeInt", "", "encodeLong", "", "encodeShort", "", "putUnquotedString", "s", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TreeJsonEncoder.kt */
public final class AbstractJsonTreeEncoder$encodeTaggedInline$1 extends AbstractEncoder {
    final /* synthetic */ String $tag;
    private final SerializersModule serializersModule;
    final /* synthetic */ AbstractJsonTreeEncoder this$0;

    AbstractJsonTreeEncoder$encodeTaggedInline$1(AbstractJsonTreeEncoder abstractJsonTreeEncoder, String str) {
        this.this$0 = abstractJsonTreeEncoder;
        this.$tag = str;
        this.serializersModule = abstractJsonTreeEncoder.getJson().getSerializersModule();
    }

    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public final void putUnquotedString(String str) {
        Intrinsics.checkNotNullParameter(str, "s");
        this.this$0.putElement(this.$tag, new JsonLiteral(str, false));
    }

    public void encodeInt(int i) {
        putUnquotedString(UInt.m4848toStringimpl(UInt.m4803constructorimpl(i)));
    }

    public void encodeLong(long j) {
        putUnquotedString(ULong.m4926toStringimpl(ULong.m4881constructorimpl(j)));
    }

    public void encodeByte(byte b) {
        putUnquotedString(UByte.m4770toStringimpl(UByte.m4727constructorimpl(b)));
    }

    public void encodeShort(short s) {
        putUnquotedString(UShort.m5030toStringimpl(UShort.m4987constructorimpl(s)));
    }
}
