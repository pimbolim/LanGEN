package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J!\u0010\u000f\u001a\u00020\f*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "isLenient", "", "stackDepth", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readDeepRecursive", "readObject", "readObjectImpl", "Lkotlinx/serialization/json/JsonObject;", "reader", "Lkotlin/Function0;", "readValue", "Lkotlinx/serialization/json/JsonPrimitive;", "isString", "Lkotlin/DeepRecursiveScope;", "", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsonTreeReader.kt */
public final class JsonTreeReader {
    private final boolean isLenient;
    /* access modifiers changed from: private */
    public final AbstractJsonLexer lexer;
    private int stackDepth;

    public JsonTreeReader(JsonConfiguration jsonConfiguration, AbstractJsonLexer abstractJsonLexer) {
        Intrinsics.checkNotNullParameter(jsonConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "lexer");
        this.lexer = abstractJsonLexer;
        this.isLenient = jsonConfiguration.isLenient();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readObject(kotlin.DeepRecursiveScope<kotlin.Unit, kotlinx.serialization.json.JsonElement> r19, kotlin.coroutines.Continuation<? super kotlinx.serialization.json.JsonElement> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            boolean r2 = r1 instanceof kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            if (r2 == 0) goto L_0x0018
            r2 = r1
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r2 = (kotlinx.serialization.json.internal.JsonTreeReader$readObject$2) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r2 = new kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 7
            r6 = 6
            r7 = 1
            r8 = 0
            r9 = 2
            r10 = 0
            r11 = 4
            if (r4 == 0) goto L_0x0051
            if (r4 != r7) goto L_0x0049
            java.lang.Object r4 = r2.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r12 = r2.L$2
            java.util.LinkedHashMap r12 = (java.util.LinkedHashMap) r12
            java.lang.Object r13 = r2.L$1
            kotlinx.serialization.json.internal.JsonTreeReader r13 = (kotlinx.serialization.json.internal.JsonTreeReader) r13
            java.lang.Object r14 = r2.L$0
            kotlin.DeepRecursiveScope r14 = (kotlin.DeepRecursiveScope) r14
            kotlin.ResultKt.throwOnFailure(r1)
            r16 = r3
            r3 = r2
            r2 = r16
            goto L_0x00aa
        L_0x0049:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            byte r1 = r1.consumeNextToken((byte) r6)
            kotlinx.serialization.json.internal.AbstractJsonLexer r4 = r0.lexer
            byte r4 = r4.peekNextToken()
            if (r4 == r11) goto L_0x00ee
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            r13 = r0
            r12 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r19
        L_0x006e:
            kotlinx.serialization.json.internal.AbstractJsonLexer r14 = r13.lexer
            boolean r14 = r14.canConsumeValue()
            if (r14 == 0) goto L_0x00cf
            boolean r2 = r13.isLenient
            if (r2 == 0) goto L_0x0081
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r13.lexer
            java.lang.String r2 = r2.consumeStringLenient()
            goto L_0x0087
        L_0x0081:
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r13.lexer
            java.lang.String r2 = r2.consumeString()
        L_0x0087:
            kotlinx.serialization.json.internal.AbstractJsonLexer r14 = r13.lexer
            r15 = 5
            r14.consumeNextToken((byte) r15)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            r3.L$0 = r1
            r3.L$1 = r13
            r3.L$2 = r12
            r3.L$3 = r2
            r3.label = r7
            java.lang.Object r14 = r1.callRecursive(r14, r3)
            if (r14 != r4) goto L_0x00a0
            return r4
        L_0x00a0:
            r16 = r14
            r14 = r1
            r1 = r16
            r17 = r4
            r4 = r2
            r2 = r17
        L_0x00aa:
            kotlinx.serialization.json.JsonElement r1 = (kotlinx.serialization.json.JsonElement) r1
            r15 = r12
            java.util.Map r15 = (java.util.Map) r15
            r15.put(r4, r1)
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r13.lexer
            byte r1 = r1.consumeNextToken()
            if (r1 != r11) goto L_0x00be
            r4 = r2
            r2 = r1
            r1 = r14
            goto L_0x006e
        L_0x00be:
            if (r1 != r5) goto L_0x00c2
            r2 = r1
            goto L_0x00cf
        L_0x00c2:
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r13.lexer
            java.lang.String r2 = "Expected end of the object or comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r1, r2, r10, r9, r8)
            kotlin.KotlinNothingValueException r1 = new kotlin.KotlinNothingValueException
            r1.<init>()
            throw r1
        L_0x00cf:
            if (r2 != r6) goto L_0x00d7
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r13.lexer
            r1.consumeNextToken((byte) r5)
            goto L_0x00d9
        L_0x00d7:
            if (r2 == r11) goto L_0x00e1
        L_0x00d9:
            kotlinx.serialization.json.JsonObject r1 = new kotlinx.serialization.json.JsonObject
            java.util.Map r12 = (java.util.Map) r12
            r1.<init>(r12)
            return r1
        L_0x00e1:
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r13.lexer
            java.lang.String r2 = "Unexpected trailing comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r1, r2, r10, r9, r8)
            kotlin.KotlinNothingValueException r1 = new kotlin.KotlinNothingValueException
            r1.<init>()
            throw r1
        L_0x00ee:
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            java.lang.String r2 = "Unexpected leading comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r1, r2, r10, r9, r8)
            kotlin.KotlinNothingValueException r1 = new kotlin.KotlinNothingValueException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.readObject(kotlin.DeepRecursiveScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final JsonObject readObjectImpl(Function0<? extends JsonElement> function0) {
        byte consumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() != 4) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!this.lexer.canConsumeValue()) {
                    break;
                }
                String consumeStringLenient = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
                this.lexer.consumeNextToken((byte) 5);
                linkedHashMap.put(consumeStringLenient, (JsonElement) function0.invoke());
                consumeNextToken = this.lexer.consumeNextToken();
                if (consumeNextToken != 4) {
                    if (consumeNextToken != 7) {
                        AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, 2, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (consumeNextToken == 6) {
                this.lexer.consumeNextToken((byte) 7);
            } else if (consumeNextToken == 4) {
                AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
            return new JsonObject(linkedHashMap);
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: private */
    public final JsonElement readArray() {
        byte consumeNextToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() != 4) {
            ArrayList arrayList = new ArrayList();
            while (this.lexer.canConsumeValue()) {
                arrayList.add(read());
                consumeNextToken = this.lexer.consumeNextToken();
                if (consumeNextToken != 4) {
                    AbstractJsonLexer abstractJsonLexer = this.lexer;
                    boolean z = consumeNextToken == 9;
                    int access$getCurrentPosition$p = abstractJsonLexer.currentPosition;
                    if (!z) {
                        abstractJsonLexer.fail("Expected end of the array or comma", access$getCurrentPosition$p);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (consumeNextToken == 8) {
                this.lexer.consumeNextToken((byte) 9);
            } else if (consumeNextToken == 4) {
                AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
            return new JsonArray(arrayList);
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: private */
    public final JsonPrimitive readValue(boolean z) {
        String str;
        if (this.isLenient || !z) {
            str = this.lexer.consumeStringLenient();
        } else {
            str = this.lexer.consumeString();
        }
        if (z || !Intrinsics.areEqual((Object) str, (Object) AbstractJsonLexerKt.NULL)) {
            return new JsonLiteral(str, z);
        }
        return JsonNull.INSTANCE;
    }

    public final JsonElement read() {
        JsonElement jsonElement;
        byte peekNextToken = this.lexer.peekNextToken();
        if (peekNextToken == 1) {
            return readValue(true);
        }
        if (peekNextToken == 0) {
            return readValue(false);
        }
        if (peekNextToken == 6) {
            int i = this.stackDepth + 1;
            this.stackDepth = i;
            if (i == 200) {
                jsonElement = readDeepRecursive();
            } else {
                jsonElement = readObject();
            }
            this.stackDepth--;
            return jsonElement;
        } else if (peekNextToken == 8) {
            return readArray();
        } else {
            AbstractJsonLexer.fail$default(this.lexer, Intrinsics.stringPlus("Cannot begin reading element, unexpected token: ", Byte.valueOf(peekNextToken)), 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final JsonElement readDeepRecursive() {
        return (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, (Continuation<? super JsonTreeReader$readDeepRecursive$1>) null)), Unit.INSTANCE);
    }

    private final JsonElement readObject() {
        byte consumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() != 4) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!this.lexer.canConsumeValue()) {
                    break;
                }
                String consumeStringLenient = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
                this.lexer.consumeNextToken((byte) 5);
                linkedHashMap.put(consumeStringLenient, read());
                consumeNextToken = this.lexer.consumeNextToken();
                if (consumeNextToken != 4) {
                    if (consumeNextToken != 7) {
                        AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, 2, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (consumeNextToken == 6) {
                this.lexer.consumeNextToken((byte) 7);
            } else if (consumeNextToken == 4) {
                AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
            return new JsonObject(linkedHashMap);
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }
}
