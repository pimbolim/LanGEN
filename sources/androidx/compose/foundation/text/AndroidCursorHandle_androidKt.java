package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.HandleReferencePoint;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a:\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u0015\u001a\f\u0010\u0016\u001a\u00020\u000e*\u00020\u000eH\u0000\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"CursorHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getCursorHandleHeight", "()F", "F", "CursorHandleWidth", "getCursorHandleWidth", "Sqrt2", "", "CursorHandle", "", "handlePosition", "Landroidx/compose/ui/geometry/Offset;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CursorHandle-ULxng0E", "(JLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DefaultCursorHandle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "drawCursorHandle", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidCursorHandle.android.kt */
public final class AndroidCursorHandle_androidKt {
    private static final float CursorHandleHeight;
    private static final float CursorHandleWidth;
    private static final float Sqrt2 = 1.4142135f;

    public static final float getCursorHandleHeight() {
        return CursorHandleHeight;
    }

    public static final float getCursorHandleWidth() {
        return CursorHandleWidth;
    }

    /* renamed from: CursorHandle-ULxng0E  reason: not valid java name */
    public static final void m623CursorHandleULxng0E(long j, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-155753200);
        ComposerKt.sourceInformation(startRestartGroup, "C(CursorHandle)P(1:c#ui.geometry.Offset,2)43@1674L256:AndroidCursorHandle.android.kt#423gt5");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) modifier) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function2) ? 256 : 128;
        }
        if (((i2 & 731) ^ 146) != 0 || !startRestartGroup.getSkipping()) {
            AndroidSelectionHandles_androidKt.m739HandlePopupULxng0E(j, HandleReferencePoint.TopMiddle, ComposableLambdaKt.composableLambda(startRestartGroup, -819896208, true, new AndroidCursorHandle_androidKt$CursorHandle$1(function2, modifier, i2)), startRestartGroup, (i2 & 14) | 432);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidCursorHandle_androidKt$CursorHandle$2(j, modifier, function2, i));
        }
    }

    public static final void DefaultCursorHandle(Modifier modifier, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-1094866142);
        ComposerKt.sourceInformation(startRestartGroup, "C(DefaultCursorHandle)58@2028L79:AndroidCursorHandle.android.kt#423gt5");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (((i2 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            SpacerKt.Spacer(drawCursorHandle(SizeKt.m494sizeVpY3zN4(modifier, CursorHandleWidth, CursorHandleHeight)), startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidCursorHandle_androidKt$DefaultCursorHandle$1(modifier, i));
        }
    }

    public static final Modifier drawCursorHandle(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed$default(modifier, (Function1) null, AndroidCursorHandle_androidKt$drawCursorHandle$1.INSTANCE, 1, (Object) null);
    }

    static {
        float r0 = Dp.m3859constructorimpl((float) 25);
        CursorHandleHeight = r0;
        CursorHandleWidth = Dp.m3859constructorimpl(Dp.m3859constructorimpl(r0 * 2.0f) / 2.4142137f);
    }
}
