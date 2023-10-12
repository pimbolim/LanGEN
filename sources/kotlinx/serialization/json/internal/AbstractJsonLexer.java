package kotlinx.serialization.json.internal;

import com.braintreepayments.api.internal.GraphQLConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0014J\b\u0010\u001d\u001a\u00020\u001eH&J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0004H\u0003J\u0006\u0010!\u001a\u00020\u001eJ\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\rH&J\b\u0010%\u001a\u00020&H&J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0016J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\rJ \u0010+\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0005J\u0006\u0010,\u001a\u00020\rJ\u0006\u0010-\u001a\u00020\rJ\u0018\u0010.\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010/\u001a\u00020\u001aH\u0016J\u0006\u00100\u001a\u00020\u001aJ\u0015\u00101\u001a\u0002022\u0006\u00103\u001a\u00020&H\u0000¢\u0006\u0002\b4J\u0018\u00101\u001a\u0002022\u0006\u00105\u001a\u00020\r2\b\b\u0002\u00106\u001a\u00020\u0004J\u000e\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\rJ\u0018\u00109\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0006\u0010<\u001a\u00020\u001eJ\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020(H\u0004J\u0006\u0010?\u001a\u00020&J\u0010\u0010@\u001a\u0004\u0018\u00010\r2\u0006\u0010A\u001a\u00020\u001eJ\u0010\u0010B\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0004H&J1\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u00020\u00042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0EH\bø\u0001\u0000¢\u0006\u0002\bFJ\u000e\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u001eJ\b\u0010I\u001a\u00020\u0004H\u0016J\u0018\u0010J\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004H\u0016J\b\u0010L\u001a\u00020\rH\u0002J\b\u0010M\u001a\u00020\rH\u0016J\b\u0010N\u001a\u00020\u001eH&J\u0006\u0010O\u001a\u00020\u001eJ\u0010\u0010P\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0004J\b\u0010Q\u001a\u00020\u001eH\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u0007\n\u0005\b20\u0001¨\u0006R"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "()V", "currentPosition", "", "escapedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "peekedString", "", "source", "", "getSource", "()Ljava/lang/CharSequence;", "appendEsc", "startPosition", "appendEscape", "lastPosition", "current", "appendHex", "startPos", "appendRange", "", "fromIndex", "toIndex", "canConsumeValue", "", "consumeBoolean", "start", "consumeBooleanLenient", "consumeBooleanLiteral", "literalSuffix", "consumeKeyString", "consumeNextToken", "", "expected", "", "consumeNumericLiteral", "", "consumeString", "consumeStringLenient", "consumeStringLenientNotNull", "decodedString", "ensureHaveChars", "expectEof", "fail", "", "expectedToken", "fail$kotlinx_serialization_json", "message", "position", "failOnUnknownKey", "key", "fromHexChar", "indexOf", "char", "isNotEof", "isValidValueStart", "c", "peekNextToken", "peekString", "isLenient", "prefetchOrEof", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_json", "skipElement", "allowLenientStrings", "skipWhitespaces", "substring", "endPos", "takePeeked", "toString", "tryConsumeComma", "tryConsumeNotNull", "unexpectedToken", "wasUnquotedString", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbstractJsonLexer.kt */
public abstract class AbstractJsonLexer {
    /* access modifiers changed from: protected */
    public int currentPosition;
    private StringBuilder escapedString = new StringBuilder();
    private String peekedString;

    public abstract boolean canConsumeValue();

    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public void ensureHaveChars() {
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence getSource();

    /* access modifiers changed from: protected */
    public final boolean isValidValueStart(char c) {
        boolean z = false;
        if (((c == '}' || c == ']') || c == ':') || c == ',') {
            z = true;
        }
        return !z;
    }

    public abstract int prefetchOrEof(int i);

    public abstract boolean tryConsumeComma();

    public final boolean isNotEof() {
        return peekNextToken() != 10;
    }

    public final void expectEof() {
        if (consumeNextToken() != 10) {
            fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    public final StringBuilder getEscapedString() {
        return this.escapedString;
    }

    /* access modifiers changed from: protected */
    public final void setEscapedString(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<set-?>");
        this.escapedString = sb;
    }

    public final byte consumeNextToken(byte b) {
        byte consumeNextToken = consumeNextToken();
        if (consumeNextToken == b) {
            return consumeNextToken;
        }
        fail$kotlinx_serialization_json(b);
        throw new KotlinNothingValueException();
    }

    public void consumeNextToken(char c) {
        ensureHaveChars();
        CharSequence source = getSource();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof == -1) {
                this.currentPosition = prefetchOrEof;
                unexpectedToken(c);
                return;
            }
            int i2 = prefetchOrEof + 1;
            char charAt = source.charAt(prefetchOrEof);
            if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                this.currentPosition = i2;
                if (charAt != c) {
                    unexpectedToken(c);
                } else {
                    return;
                }
            }
            i = i2;
        }
    }

    /* access modifiers changed from: protected */
    public final void unexpectedToken(char c) {
        int i = this.currentPosition - 1;
        this.currentPosition = i;
        if (i < 0 || c != '\"' || !Intrinsics.areEqual((Object) consumeStringLenient(), (Object) AbstractJsonLexerKt.NULL)) {
            fail$kotlinx_serialization_json(AbstractJsonLexerKt.charToTokenClass(c));
            throw new KotlinNothingValueException();
        } else {
            fail("Expected string literal but 'null' literal was found.\nUse 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.", this.currentPosition - 4);
            throw new KotlinNothingValueException();
        }
    }

    public final Void fail$kotlinx_serialization_json(byte b) {
        String str = b == 1 ? "quotation mark '\"'" : b == 4 ? "comma ','" : b == 5 ? "semicolon ':'" : b == 6 ? "start of the object '{'" : b == 7 ? "end of the object '}'" : b == 8 ? "start of the array '['" : b == 9 ? "end of the array ']'" : "valid token";
        String valueOf = (this.currentPosition == getSource().length() || this.currentPosition <= 0) ? "EOF" : String.valueOf(getSource().charAt(this.currentPosition - 1));
        fail("Expected " + str + ", but had '" + valueOf + "' instead", this.currentPosition - 1);
        throw new KotlinNothingValueException();
    }

    public final byte peekNextToken() {
        CharSequence source = getSource();
        int i = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof == -1) {
                this.currentPosition = prefetchOrEof;
                return 10;
            }
            char charAt = source.charAt(prefetchOrEof);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i = prefetchOrEof + 1;
            } else {
                this.currentPosition = prefetchOrEof;
                return AbstractJsonLexerKt.charToTokenClass(charAt);
            }
        }
    }

    public final boolean tryConsumeNotNull() {
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        int length = getSource().length() - prefetchOrEof;
        if (length < 4 || prefetchOrEof == -1) {
            return true;
        }
        int i = 0;
        while (i < 4) {
            int i2 = i + 1;
            if (AbstractJsonLexerKt.NULL.charAt(i) != getSource().charAt(i + prefetchOrEof)) {
                return true;
            }
            i = i2;
        }
        if (length > 4 && AbstractJsonLexerKt.charToTokenClass(getSource().charAt(prefetchOrEof + 4)) == 0) {
            return true;
        }
        this.currentPosition = prefetchOrEof + 4;
        return false;
    }

    public int skipWhitespaces() {
        int prefetchOrEof;
        char charAt;
        int i = this.currentPosition;
        while (true) {
            prefetchOrEof = prefetchOrEof(i);
            if (prefetchOrEof != -1 && ((charAt = getSource().charAt(prefetchOrEof)) == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                i = prefetchOrEof + 1;
            }
        }
        this.currentPosition = prefetchOrEof;
        return prefetchOrEof;
    }

    public final String peekString(boolean z) {
        String str;
        byte peekNextToken = peekNextToken();
        if (z) {
            if (peekNextToken != 1 && peekNextToken != 0) {
                return null;
            }
            str = consumeStringLenient();
        } else if (peekNextToken != 1) {
            return null;
        } else {
            str = consumeString();
        }
        this.peekedString = str;
        return str;
    }

    public int indexOf(char c, int i) {
        return StringsKt.indexOf$default(getSource(), c, i, false, 4, (Object) null);
    }

    public String substring(int i, int i2) {
        return getSource().subSequence(i, i2).toString();
    }

    public final String consumeString() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        return consumeKeyString();
    }

    /* access modifiers changed from: protected */
    public final String consumeString(CharSequence charSequence, int i, int i2) {
        String str;
        Intrinsics.checkNotNullParameter(charSequence, "source");
        char charAt = charSequence.charAt(i2);
        boolean z = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                i = prefetchOrEof(appendEscape(i, i2));
                if (i == -1) {
                    fail("EOF", i);
                    throw new KotlinNothingValueException();
                }
            } else {
                i2++;
                if (i2 >= charSequence.length()) {
                    appendRange(i, i2);
                    i = prefetchOrEof(i2);
                    if (i == -1) {
                        fail("EOF", i);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    charAt = charSequence.charAt(i2);
                }
            }
            i2 = i;
            z = true;
            charAt = charSequence.charAt(i2);
        }
        if (!z) {
            str = substring(i, i2);
        } else {
            str = decodedString(i, i2);
        }
        this.currentPosition = i2 + 1;
        return str;
    }

    private final int appendEscape(int i, int i2) {
        appendRange(i, i2);
        return appendEsc(i2 + 1);
    }

    private final String decodedString(int i, int i2) {
        appendRange(i, i2);
        String sb = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "escapedString.toString()");
        this.escapedString.setLength(0);
        return sb;
    }

    private final String takePeeked() {
        String str = this.peekedString;
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    public final String consumeStringLenientNotNull() {
        String consumeStringLenient = consumeStringLenient();
        if (!Intrinsics.areEqual((Object) consumeStringLenient, (Object) AbstractJsonLexerKt.NULL) || !wasUnquotedString()) {
            return consumeStringLenient;
        }
        fail$default(this, "Unexpected 'null' value instead of string literal", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final boolean wasUnquotedString() {
        return getSource().charAt(this.currentPosition - 1) != '\"';
    }

    public final String consumeStringLenient() {
        String str;
        if (this.peekedString != null) {
            return takePeeked();
        }
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= getSource().length() || skipWhitespaces == -1) {
            fail("EOF", skipWhitespaces);
            throw new KotlinNothingValueException();
        }
        byte charToTokenClass = AbstractJsonLexerKt.charToTokenClass(getSource().charAt(skipWhitespaces));
        if (charToTokenClass == 1) {
            return consumeString();
        }
        if (charToTokenClass == 0) {
            boolean z = false;
            while (AbstractJsonLexerKt.charToTokenClass(getSource().charAt(skipWhitespaces)) == 0) {
                skipWhitespaces++;
                if (skipWhitespaces >= getSource().length()) {
                    appendRange(this.currentPosition, skipWhitespaces);
                    int prefetchOrEof = prefetchOrEof(skipWhitespaces);
                    if (prefetchOrEof == -1) {
                        this.currentPosition = skipWhitespaces;
                        return decodedString(0, 0);
                    }
                    skipWhitespaces = prefetchOrEof;
                    z = true;
                }
            }
            if (!z) {
                str = substring(this.currentPosition, skipWhitespaces);
            } else {
                str = decodedString(this.currentPosition, skipWhitespaces);
            }
            this.currentPosition = skipWhitespaces;
            return str;
        }
        fail$default(this, Intrinsics.stringPlus("Expected beginning of the string, but got ", Character.valueOf(getSource().charAt(skipWhitespaces))), 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: protected */
    public void appendRange(int i, int i2) {
        this.escapedString.append(getSource(), i, i2);
    }

    private final int appendEsc(int i) {
        int prefetchOrEof = prefetchOrEof(i);
        if (prefetchOrEof != -1) {
            int i2 = prefetchOrEof + 1;
            char charAt = getSource().charAt(prefetchOrEof);
            if (charAt == 'u') {
                return appendHex(getSource(), i2);
            }
            char escapeToChar = AbstractJsonLexerKt.escapeToChar(charAt);
            if (escapeToChar != 0) {
                this.escapedString.append(escapeToChar);
                return i2;
            }
            fail$default(this, "Invalid escaped char '" + charAt + '\'', 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
        fail$default(this, "Expected escape sequence to continue, got EOF", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final int appendHex(CharSequence charSequence, int i) {
        int i2 = i + 4;
        if (i2 >= charSequence.length()) {
            this.currentPosition = i;
            ensureHaveChars();
            if (this.currentPosition + 4 < charSequence.length()) {
                return appendHex(charSequence, this.currentPosition);
            }
            fail$default(this, "Unexpected EOF during unicode escape", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
        this.escapedString.append((char) ((fromHexChar(charSequence, i) << 12) + (fromHexChar(charSequence, i + 1) << 8) + (fromHexChar(charSequence, i + 2) << 4) + fromHexChar(charSequence, i + 3)));
        return i2;
    }

    public static /* synthetic */ void require$kotlinx_serialization_json$default(AbstractJsonLexer abstractJsonLexer, boolean z, int i, Function0 function0, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = abstractJsonLexer.currentPosition;
            }
            Intrinsics.checkNotNullParameter(function0, GraphQLConstants.Keys.MESSAGE);
            if (!z) {
                abstractJsonLexer.fail((String) function0.invoke(), i);
                throw new KotlinNothingValueException();
            }
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: require");
    }

    public final void require$kotlinx_serialization_json(boolean z, int i, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, GraphQLConstants.Keys.MESSAGE);
        if (!z) {
            fail(function0.invoke(), i);
            throw new KotlinNothingValueException();
        }
    }

    private final int fromHexChar(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        boolean z = true;
        if ('0' <= charAt && charAt < ':') {
            return charAt - '0';
        }
        char c = 'a';
        if (!('a' <= charAt && charAt < 'g')) {
            c = 'A';
            if ('A' > charAt || charAt >= 'G') {
                z = false;
            }
            if (!z) {
                fail$default(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        return (charAt - c) + 10;
    }

    public final void skipElement(boolean z) {
        List arrayList = new ArrayList();
        byte peekNextToken = peekNextToken();
        if (peekNextToken == 8 || peekNextToken == 6) {
            while (true) {
                byte peekNextToken2 = peekNextToken();
                boolean z2 = true;
                if (peekNextToken2 != 1) {
                    if (!(peekNextToken2 == 8 || peekNextToken2 == 6)) {
                        z2 = false;
                    }
                    if (z2) {
                        arrayList.add(Byte.valueOf(peekNextToken2));
                    } else if (peekNextToken2 == 9) {
                        if (((Number) CollectionsKt.last(arrayList)).byteValue() == 8) {
                            CollectionsKt.removeLast(arrayList);
                        } else {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found ] instead of }", getSource());
                        }
                    } else if (peekNextToken2 == 7) {
                        if (((Number) CollectionsKt.last(arrayList)).byteValue() == 6) {
                            CollectionsKt.removeLast(arrayList);
                        } else {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found } instead of ]", getSource());
                        }
                    } else if (peekNextToken2 == 10) {
                        fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, 2, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                    consumeNextToken();
                    if (arrayList.size() == 0) {
                        return;
                    }
                } else if (z) {
                    consumeStringLenient();
                } else {
                    consumeKeyString();
                }
            }
        } else {
            consumeStringLenient();
        }
    }

    public String toString() {
        return "JsonReader(source='" + getSource() + "', currentPosition=" + this.currentPosition + ')';
    }

    public final void failOnUnknownKey(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) substring(0, this.currentPosition), str, 0, false, 6, (Object) null);
        fail("Encountered an unknown key '" + str + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.", lastIndexOf$default);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = abstractJsonLexer.currentPosition;
            }
            return abstractJsonLexer.fail(str, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public final Void fail(String str, int i) {
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.MESSAGE);
        throw JsonExceptionsKt.JsonDecodingException(i, str, getSource());
    }

    public final long consumeNumericLiteral() {
        boolean z;
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        Object obj = null;
        int i = 2;
        if (prefetchOrEof >= getSource().length() || prefetchOrEof == -1) {
            fail$default(this, "EOF", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(prefetchOrEof) == '\"') {
            prefetchOrEof++;
            if (prefetchOrEof != getSource().length()) {
                z = true;
            } else {
                fail$default(this, "EOF", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
        } else {
            z = false;
        }
        int i2 = prefetchOrEof;
        boolean z2 = true;
        boolean z3 = false;
        long j = 0;
        while (z2) {
            char charAt = getSource().charAt(i2);
            if (charAt == '-') {
                if (i2 == prefetchOrEof) {
                    i2++;
                    z3 = true;
                } else {
                    fail$default(this, "Unexpected symbol '-' in numeric literal", 0, i, obj);
                    throw new KotlinNothingValueException();
                }
            } else if (AbstractJsonLexerKt.charToTokenClass(charAt) != 0) {
                break;
            } else {
                i2++;
                z2 = i2 != getSource().length();
                int i3 = charAt - '0';
                if (i3 >= 0 && i3 < 10) {
                    j = (j * ((long) 10)) - ((long) i3);
                    if (j <= 0) {
                        obj = null;
                        i = 2;
                    } else {
                        fail$default(this, "Numeric value overflow", 0, 2, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    fail$default(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, 2, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (prefetchOrEof == i2 || (z3 && prefetchOrEof == i2 - 1)) {
            fail$default(this, "Expected numeric literal", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
        if (z) {
            if (!z2) {
                fail$default(this, "EOF", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            } else if (getSource().charAt(i2) == '\"') {
                i2++;
            } else {
                fail$default(this, "Expected closing quotation mark", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        this.currentPosition = i2;
        if (z3) {
            return j;
        }
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        fail$default(this, "Numeric value overflow", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final boolean consumeBoolean() {
        return consumeBoolean(skipWhitespaces());
    }

    public final boolean consumeBooleanLenient() {
        boolean z;
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces != getSource().length()) {
            if (getSource().charAt(skipWhitespaces) == '\"') {
                skipWhitespaces++;
                z = true;
            } else {
                z = false;
            }
            boolean consumeBoolean = consumeBoolean(skipWhitespaces);
            if (z) {
                if (this.currentPosition == getSource().length()) {
                    fail$default(this, "EOF", 0, 2, (Object) null);
                    throw new KotlinNothingValueException();
                } else if (getSource().charAt(this.currentPosition) == '\"') {
                    this.currentPosition++;
                } else {
                    fail$default(this, "Expected closing quotation mark", 0, 2, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            return consumeBoolean;
        }
        fail$default(this, "EOF", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final boolean consumeBoolean(int i) {
        int prefetchOrEof = prefetchOrEof(i);
        if (prefetchOrEof >= getSource().length() || prefetchOrEof == -1) {
            fail$default(this, "EOF", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
        int i2 = prefetchOrEof + 1;
        char charAt = getSource().charAt(prefetchOrEof) | ' ';
        if (charAt == 't') {
            consumeBooleanLiteral("rue", i2);
            return true;
        } else if (charAt == 'f') {
            consumeBooleanLiteral("alse", i2);
            return false;
        } else {
            fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final void consumeBooleanLiteral(String str, int i) {
        if (getSource().length() - i >= str.length()) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                if (str.charAt(i2) == (getSource().charAt(i2 + i) | ' ')) {
                    i2 = i3;
                } else {
                    fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, 2, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            this.currentPosition = i + str.length();
            return;
        }
        fail$default(this, "Unexpected end of boolean literal", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }
}
