package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.nimbusds.jose.HeaderParameterNames;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/constraintlayout/compose/MotionLayoutScope;", "", "measurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", "(Landroidx/constraintlayout/compose/MotionMeasurer;)V", "myMeasurer", "motionColor", "Landroidx/compose/ui/graphics/Color;", "id", "", "name", "motionColor-WaAFU9c", "(Ljava/lang/String;Ljava/lang/String;)J", "motionDistance", "Landroidx/compose/ui/unit/Dp;", "motionDistance-chRvn1I", "(Ljava/lang/String;Ljava/lang/String;)F", "motionFloat", "", "motionFontSize", "Landroidx/compose/ui/unit/TextUnit;", "motionFontSize-5XXgJZs", "motionInt", "", "motionProperties", "Landroidx/compose/runtime/MutableState;", "Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/MutableState;", "tag", "MotionProperties", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@LayoutScopeMarker
/* compiled from: MotionLayout.kt */
public final class MotionLayoutScope {
    public static final int $stable = 8;
    private MotionMeasurer myMeasurer;

    public MotionLayoutScope(MotionMeasurer motionMeasurer) {
        Intrinsics.checkNotNullParameter(motionMeasurer, "measurer");
        this.myMeasurer = motionMeasurer;
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0003J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u0010J\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "", "id", "", "tag", "measurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/constraintlayout/compose/MotionMeasurer;)V", "myId", "myMeasurer", "myTag", "", "color", "Landroidx/compose/ui/graphics/Color;", "name", "color-vNxB06k", "(Ljava/lang/String;)J", "distance", "Landroidx/compose/ui/unit/Dp;", "distance-u2uoSUM", "(Ljava/lang/String;)F", "float", "", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontSize-kPz2Gy4", "int", "", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: MotionLayout.kt */
    public static final class MotionProperties {
        public static final int $stable = 8;
        private String myId;
        private MotionMeasurer myMeasurer;
        private Void myTag;

        public MotionProperties(String str, String str2, MotionMeasurer motionMeasurer) {
            Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
            Intrinsics.checkNotNullParameter(motionMeasurer, "measurer");
            this.myId = str;
            this.myMeasurer = motionMeasurer;
        }

        public final String id() {
            return this.myId;
        }

        public final String tag() {
            return (String) this.myTag;
        }

        /* renamed from: color-vNxB06k  reason: not valid java name */
        public final long m4200colorvNxB06k(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return this.myMeasurer.m4209getCustomColorWaAFU9c(this.myId, str);
        }

        /* renamed from: float  reason: not valid java name */
        public final float m4202float(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return this.myMeasurer.getCustomFloat(this.myId, str);
        }

        /* renamed from: int  reason: not valid java name */
        public final int m4204int(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return (int) this.myMeasurer.getCustomFloat(this.myId, str);
        }

        /* renamed from: distance-u2uoSUM  reason: not valid java name */
        public final float m4201distanceu2uoSUM(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return Dp.m3859constructorimpl(this.myMeasurer.getCustomFloat(this.myId, str));
        }

        /* renamed from: fontSize-kPz2Gy4  reason: not valid java name */
        public final long m4203fontSizekPz2Gy4(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return TextUnitKt.getSp(this.myMeasurer.getCustomFloat(this.myId, str));
        }
    }

    public final MutableState<MotionProperties> motionProperties(String str, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        composer.startReplaceableGroup(-1035551634);
        ComposerKt.sourceInformation(composer, "C(motionProperties)");
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new MotionProperties(str, (String) null, this.myMeasurer), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState<MotionProperties> mutableState = (MutableState) rememberedValue;
        composer.endReplaceableGroup();
        return mutableState;
    }

    public final MotionProperties motionProperties(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, HeaderParameterNames.AUTHENTICATION_TAG);
        return new MotionProperties(str, str2, this.myMeasurer);
    }

    /* renamed from: motionColor-WaAFU9c  reason: not valid java name */
    public final long m4197motionColorWaAFU9c(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        return this.myMeasurer.m4209getCustomColorWaAFU9c(str, str2);
    }

    public final float motionFloat(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        return this.myMeasurer.getCustomFloat(str, str2);
    }

    public final int motionInt(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        return (int) this.myMeasurer.getCustomFloat(str, str2);
    }

    /* renamed from: motionDistance-chRvn1I  reason: not valid java name */
    public final float m4198motionDistancechRvn1I(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        return Dp.m3859constructorimpl(this.myMeasurer.getCustomFloat(str, str2));
    }

    /* renamed from: motionFontSize-5XXgJZs  reason: not valid java name */
    public final long m4199motionFontSize5XXgJZs(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        return TextUnitKt.getSp(this.myMeasurer.getCustomFloat(str, str2));
    }
}
