package kotlinx.serialization.json.internal;

import com.henninghall.date_picker.props.ModeProp;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0002\u0010\u000bB/\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020!2\u0006\u0010\"\u001a\u00020/H\u0016J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001fH\u0016J\u0010\u00103\u001a\u00020!2\u0006\u0010\"\u001a\u00020+H\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020!2\u0006\u0010\"\u001a\u000208H\u0016J\b\u00109\u001a\u00020!H\u0016J?\u0010:\u001a\u00020!\"\b\b\u0000\u0010;*\u00020<2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H;0>2\b\u0010\"\u001a\u0004\u0018\u0001H;H\u0016¢\u0006\u0002\u0010?J)\u0010@\u001a\u00020!\"\u0004\b\u0000\u0010;2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H;0>2\u0006\u0010\"\u001a\u0002H;H\u0016¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020!2\u0006\u0010\"\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010E\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010F\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010G\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nX\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006H"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "output", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "modeReuseCache", "", "(Lkotlinx/serialization/json/internal/JsonStringBuilder;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "composer", "Lkotlinx/serialization/json/internal/Composer;", "(Lkotlinx/serialization/json/internal/Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "forceQuoting", "", "getJson", "()Lkotlinx/serialization/json/Json;", "[Lkotlinx/serialization/json/JsonEncoder;", "polymorphicDiscriminator", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "encodeBoolean", "", "value", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeElement", "index", "", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeInline", "Lkotlinx/serialization/encoding/Encoder;", "inlineDescriptor", "encodeInt", "encodeJsonElement", "element", "Lkotlinx/serialization/json/JsonElement;", "encodeLong", "", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableValue", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeShort", "", "encodeString", "encodeTypeInfo", "endStructure", "shouldEncodeElementDefault", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StreamingJsonEncoder.kt */
public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {
    private final Composer composer;
    private final JsonConfiguration configuration;
    private boolean forceQuoting;
    private final Json json;
    private final WriteMode mode;
    private final JsonEncoder[] modeReuseCache;
    private String polymorphicDiscriminator;
    private final SerializersModule serializersModule;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StreamingJsonEncoder.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WriteMode.values().length];
            iArr[WriteMode.LIST.ordinal()] = 1;
            iArr[WriteMode.MAP.ordinal()] = 2;
            iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Json getJson() {
        return this.json;
    }

    public StreamingJsonEncoder(Composer composer2, Json json2, WriteMode writeMode, JsonEncoder[] jsonEncoderArr) {
        Intrinsics.checkNotNullParameter(composer2, "composer");
        Intrinsics.checkNotNullParameter(json2, "json");
        Intrinsics.checkNotNullParameter(writeMode, ModeProp.name);
        this.composer = composer2;
        this.json = json2;
        this.mode = writeMode;
        this.modeReuseCache = jsonEncoderArr;
        this.serializersModule = getJson().getSerializersModule();
        this.configuration = getJson().getConfiguration();
        int ordinal = writeMode.ordinal();
        if (jsonEncoderArr == null) {
            return;
        }
        if (jsonEncoderArr[ordinal] != null || jsonEncoderArr[ordinal] != this) {
            jsonEncoderArr[ordinal] = this;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StreamingJsonEncoder(JsonStringBuilder jsonStringBuilder, Json json2, WriteMode writeMode, JsonEncoder[] jsonEncoderArr) {
        this(ComposersKt.Composer(jsonStringBuilder, json2), json2, writeMode, jsonEncoderArr);
        Intrinsics.checkNotNullParameter(jsonStringBuilder, "output");
        Intrinsics.checkNotNullParameter(json2, "json");
        Intrinsics.checkNotNullParameter(writeMode, ModeProp.name);
        Intrinsics.checkNotNullParameter(jsonEncoderArr, "modeReuseCache");
    }

    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public void encodeJsonElement(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        encodeSerializableValue(JsonElementSerializer.INSTANCE, jsonElement);
    }

    public boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        JsonEncoder jsonEncoder = this;
        if (!(serializationStrategy instanceof AbstractPolymorphicSerializer) || jsonEncoder.getJson().getConfiguration().getUseArrayPolymorphism()) {
            serializationStrategy.serialize(jsonEncoder, t);
            return;
        }
        AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializationStrategy;
        String classDiscriminator = PolymorphicKt.classDiscriminator(serializationStrategy.getDescriptor(), jsonEncoder.getJson());
        Encoder encoder = jsonEncoder;
        Objects.requireNonNull(t, "null cannot be cast to non-null type kotlin.Any");
        SerializationStrategy findPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(abstractPolymorphicSerializer, encoder, t);
        PolymorphicKt.validateIfSealed(abstractPolymorphicSerializer, findPolymorphicSerializer, classDiscriminator);
        PolymorphicKt.checkKind(findPolymorphicSerializer.getDescriptor().getKind());
        this.polymorphicDiscriminator = classDiscriminator;
        findPolymorphicSerializer.serialize(encoder, t);
    }

    private final void encodeTypeInfo(SerialDescriptor serialDescriptor) {
        this.composer.nextItem();
        String str = this.polymorphicDiscriminator;
        Intrinsics.checkNotNull(str);
        encodeString(str);
        this.composer.print((char) AbstractJsonLexerKt.COLON);
        this.composer.space();
        encodeString(serialDescriptor.getSerialName());
    }

    public CompositeEncoder beginStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        WriteMode switchMode = WriteModeKt.switchMode(getJson(), serialDescriptor);
        if (switchMode.begin != 0) {
            this.composer.print(switchMode.begin);
            this.composer.indent();
        }
        JsonEncoder jsonEncoder = null;
        if (this.polymorphicDiscriminator != null) {
            encodeTypeInfo(serialDescriptor);
            this.polymorphicDiscriminator = null;
        }
        if (this.mode == switchMode) {
            return this;
        }
        JsonEncoder[] jsonEncoderArr = this.modeReuseCache;
        if (jsonEncoderArr != null) {
            jsonEncoder = jsonEncoderArr[switchMode.ordinal()];
        }
        return jsonEncoder == null ? new StreamingJsonEncoder(this.composer, getJson(), switchMode, this.modeReuseCache) : jsonEncoder;
    }

    public void endStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (this.mode.end != 0) {
            this.composer.unIndent();
            this.composer.nextItem();
            this.composer.print(this.mode.end);
        }
    }

    public boolean encodeElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i2 != 1) {
            boolean z = false;
            if (i2 != 2) {
                if (i2 != 3) {
                    if (!this.composer.getWritingFirst()) {
                        this.composer.print((char) AbstractJsonLexerKt.COMMA);
                    }
                    this.composer.nextItem();
                    encodeString(serialDescriptor.getElementName(i));
                    this.composer.print((char) AbstractJsonLexerKt.COLON);
                    this.composer.space();
                } else {
                    if (i == 0) {
                        this.forceQuoting = true;
                    }
                    if (i == 1) {
                        this.composer.print((char) AbstractJsonLexerKt.COMMA);
                        this.composer.space();
                        this.forceQuoting = false;
                    }
                }
            } else if (!this.composer.getWritingFirst()) {
                if (i % 2 == 0) {
                    this.composer.print((char) AbstractJsonLexerKt.COMMA);
                    this.composer.nextItem();
                    z = true;
                } else {
                    this.composer.print((char) AbstractJsonLexerKt.COLON);
                    this.composer.space();
                }
                this.forceQuoting = z;
            } else {
                this.forceQuoting = true;
                this.composer.nextItem();
            }
        } else {
            if (!this.composer.getWritingFirst()) {
                this.composer.print((char) AbstractJsonLexerKt.COMMA);
            }
            this.composer.nextItem();
        }
        return true;
    }

    public <T> void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (t != null || this.configuration.getExplicitNulls()) {
            super.encodeNullableSerializableElement(serialDescriptor, i, serializationStrategy, t);
        }
    }

    public Encoder encodeInline(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            return new StreamingJsonEncoder((Composer) new ComposerForUnsignedNumbers(this.composer.sb), getJson(), this.mode, (JsonEncoder[]) null);
        }
        return super.encodeInline(serialDescriptor);
    }

    public void encodeNull() {
        this.composer.print(AbstractJsonLexerKt.NULL);
    }

    public void encodeBoolean(boolean z) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(z));
        } else {
            this.composer.print(z);
        }
    }

    public void encodeByte(byte b) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(b));
        } else {
            this.composer.print(b);
        }
    }

    public void encodeShort(short s) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(s));
        } else {
            this.composer.print(s);
        }
    }

    public void encodeInt(int i) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(i));
        } else {
            this.composer.print(i);
        }
    }

    public void encodeLong(long j) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(j));
        } else {
            this.composer.print(j);
        }
    }

    public void encodeFloat(float f) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(f));
        } else {
            this.composer.print(f);
        }
        if (!this.configuration.getAllowSpecialFloatingPointValues()) {
            if (!(!Float.isInfinite(f) && !Float.isNaN(f))) {
                throw JsonExceptionsKt.InvalidFloatingPointEncoded(Float.valueOf(f), this.composer.sb.toString());
            }
        }
    }

    public void encodeDouble(double d) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(d));
        } else {
            this.composer.print(d);
        }
        if (!this.configuration.getAllowSpecialFloatingPointValues()) {
            if (!(!Double.isInfinite(d) && !Double.isNaN(d))) {
                throw JsonExceptionsKt.InvalidFloatingPointEncoded(Double.valueOf(d), this.composer.sb.toString());
            }
        }
    }

    public void encodeChar(char c) {
        encodeString(String.valueOf(c));
    }

    public void encodeString(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.composer.printQuoted(str);
    }

    public void encodeEnum(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        encodeString(serialDescriptor.getElementName(i));
    }
}
