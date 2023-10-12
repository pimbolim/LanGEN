package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u001a%\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\u0015\u001a%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001a-\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a-\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001a \u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0002\u00107\u001a+\u00108\u001a\u00020\u0006*\u00020\u00062\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060:H\bø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b;\u0010<\u001a\"\u0010=\u001a\u00020\u0006*\u00020\u00072\u0006\u0010>\u001a\u00020\u0006H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@\u001a\"\u0010=\u001a\u00020\u0006*\u00020\f2\u0006\u0010>\u001a\u00020\u0006H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010#\u001a\"\u0010=\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010>\u001a\u00020\u0006H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010A\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"!\u0010\u0005\u001a\u00020\u0006*\u00020\u00078FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"!\u0010\u0005\u001a\u00020\u0006*\u00020\f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\r\u001a\u0004\b\n\u0010\u000e\"!\u0010\u0005\u001a\u00020\u0006*\u00020\u000f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0010\u001a\u0004\b\n\u0010\u0011\"\"\u0010\u0012\u001a\u00020\u0013*\u00020\u00068Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"!\u0010\u0018\u001a\u00020\u0013*\u00020\u00068FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\"!\u0010\u001b\u001a\u00020\u0006*\u00020\u00078FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000b\"!\u0010\u001b\u001a\u00020\u0006*\u00020\f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000e\"!\u0010\u001b\u001a\u00020\u0006*\u00020\u000f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0011\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006B"}, d2 = {"UNIT_MASK", "", "UNIT_TYPE_EM", "UNIT_TYPE_SP", "UNIT_TYPE_UNSPECIFIED", "em", "Landroidx/compose/ui/unit/TextUnit;", "", "getEm$annotations", "(D)V", "getEm", "(D)J", "", "(F)V", "(F)J", "", "(I)V", "(I)J", "isSpecified", "", "isSpecified--R2X_6o$annotations", "(J)V", "isSpecified--R2X_6o", "(J)Z", "isUnspecified", "isUnspecified--R2X_6o$annotations", "isUnspecified--R2X_6o", "sp", "getSp$annotations", "getSp", "TextUnit", "value", "type", "Landroidx/compose/ui/unit/TextUnitType;", "TextUnit-anM5pPY", "(FJ)J", "checkArithmetic", "", "a", "checkArithmetic--R2X_6o", "b", "checkArithmetic-NB67dxo", "(JJ)V", "c", "checkArithmetic-vU-0ePk", "(JJJ)V", "lerp", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "pack", "unitType", "v", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-eAf_CNQ", "(JLkotlin/jvm/functions/Function0;)J", "times", "other", "times-mpE4wyQ", "(DJ)J", "(IJ)J", "ui-unit_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextUnit.kt */
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    public static /* synthetic */ void getEm$annotations(double d) {
    }

    public static /* synthetic */ void getEm$annotations(float f) {
    }

    public static /* synthetic */ void getEm$annotations(int i) {
    }

    public static /* synthetic */ void getSp$annotations(double d) {
    }

    public static /* synthetic */ void getSp$annotations(float f) {
    }

    public static /* synthetic */ void getSp$annotations(int i) {
    }

    /* renamed from: isSpecified--R2X_6o$annotations  reason: not valid java name */
    public static /* synthetic */ void m4057isSpecifiedR2X_6o$annotations(long j) {
    }

    /* renamed from: isUnspecified--R2X_6o$annotations  reason: not valid java name */
    public static /* synthetic */ void m4059isUnspecifiedR2X_6o$annotations(long j) {
    }

    @ExperimentalUnitApi
    /* renamed from: TextUnit-anM5pPY  reason: not valid java name */
    public static final long m4052TextUnitanM5pPY(float f, long j) {
        return pack(j, f);
    }

    /* renamed from: isSpecified--R2X_6o  reason: not valid java name */
    public static final boolean m4056isSpecifiedR2X_6o(long j) {
        return !m4058isUnspecifiedR2X_6o(j);
    }

    /* renamed from: isUnspecified--R2X_6o  reason: not valid java name */
    public static final boolean m4058isUnspecifiedR2X_6o(long j) {
        return TextUnit.m4038getRawTypeimpl(j) == 0;
    }

    public static final long getSp(float f) {
        return pack(UNIT_TYPE_SP, f);
    }

    public static final long getEm(float f) {
        return pack(UNIT_TYPE_EM, f);
    }

    public static final long getSp(double d) {
        return pack(UNIT_TYPE_SP, (float) d);
    }

    public static final long getEm(double d) {
        return pack(UNIT_TYPE_EM, (float) d);
    }

    public static final long getSp(int i) {
        return pack(UNIT_TYPE_SP, (float) i);
    }

    public static final long getEm(int i) {
        return pack(UNIT_TYPE_EM, (float) i);
    }

    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m4063timesmpE4wyQ(float f, long j) {
        m4053checkArithmeticR2X_6o(j);
        return pack(TextUnit.m4038getRawTypeimpl(j), f * TextUnit.m4040getValueimpl(j));
    }

    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m4062timesmpE4wyQ(double d, long j) {
        m4053checkArithmeticR2X_6o(j);
        return pack(TextUnit.m4038getRawTypeimpl(j), ((float) d) * TextUnit.m4040getValueimpl(j));
    }

    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m4064timesmpE4wyQ(int i, long j) {
        m4053checkArithmeticR2X_6o(j);
        return pack(TextUnit.m4038getRawTypeimpl(j), ((float) i) * TextUnit.m4040getValueimpl(j));
    }

    public static final long pack(long j, float f) {
        return TextUnit.m4032constructorimpl(j | (((long) Float.floatToIntBits(f)) & 4294967295L));
    }

    /* renamed from: checkArithmetic--R2X_6o  reason: not valid java name */
    public static final void m4053checkArithmeticR2X_6o(long j) {
        if (!(!m4058isUnspecifiedR2X_6o(j))) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
    }

    /* renamed from: checkArithmetic-NB67dxo  reason: not valid java name */
    public static final void m4054checkArithmeticNB67dxo(long j, long j2) {
        if (!(!m4058isUnspecifiedR2X_6o(j) && !m4058isUnspecifiedR2X_6o(j2))) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        } else if (!TextUnitType.m4068equalsimpl0(TextUnit.m4039getTypeUIouoOA(j), TextUnit.m4039getTypeUIouoOA(j2))) {
            throw new IllegalArgumentException(("Cannot perform operation for " + TextUnitType.m4070toStringimpl(TextUnit.m4039getTypeUIouoOA(j)) + " and " + TextUnitType.m4070toStringimpl(TextUnit.m4039getTypeUIouoOA(j2))).toString());
        }
    }

    /* renamed from: checkArithmetic-vU-0ePk  reason: not valid java name */
    public static final void m4055checkArithmeticvU0ePk(long j, long j2, long j3) {
        boolean z = true;
        if (!m4058isUnspecifiedR2X_6o(j) && !m4058isUnspecifiedR2X_6o(j2) && !m4058isUnspecifiedR2X_6o(j3)) {
            if (!TextUnitType.m4068equalsimpl0(TextUnit.m4039getTypeUIouoOA(j), TextUnit.m4039getTypeUIouoOA(j2)) || !TextUnitType.m4068equalsimpl0(TextUnit.m4039getTypeUIouoOA(j2), TextUnit.m4039getTypeUIouoOA(j3))) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(("Cannot perform operation for " + TextUnitType.m4070toStringimpl(TextUnit.m4039getTypeUIouoOA(j)) + " and " + TextUnitType.m4070toStringimpl(TextUnit.m4039getTypeUIouoOA(j2))).toString());
            }
            return;
        }
        throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
    }

    /* renamed from: lerp-C3pnCVY  reason: not valid java name */
    public static final long m4060lerpC3pnCVY(long j, long j2, float f) {
        m4054checkArithmeticNB67dxo(j, j2);
        return pack(TextUnit.m4038getRawTypeimpl(j), MathHelpersKt.lerp(TextUnit.m4040getValueimpl(j), TextUnit.m4040getValueimpl(j2), f));
    }

    /* renamed from: takeOrElse-eAf_CNQ  reason: not valid java name */
    public static final long m4061takeOrElseeAf_CNQ(long j, Function0<TextUnit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return m4058isUnspecifiedR2X_6o(j) ^ true ? j : function0.invoke().m4049unboximpl();
    }
}