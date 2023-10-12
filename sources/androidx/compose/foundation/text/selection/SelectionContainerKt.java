package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\t\u001aJ\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"DisableSelection", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionContainer", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectionContainer.kt */
public final class SelectionContainerKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SelectionContainer(androidx.compose.ui.Modifier r8, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r9, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -525719710(0xffffffffe0aa2762, float:-9.808701E19)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            java.lang.String r0 = "C(SelectionContainer)P(1)41@1678L45,45@1836L38,42@1728L180:SelectionContainer.kt#eksfi3"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r12 & 1
            r1 = 2
            if (r0 == 0) goto L_0x0019
            r2 = r11 | 6
            goto L_0x0029
        L_0x0019:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0028
            boolean r2 = r10.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            r2 = r2 | r11
            goto L_0x0029
        L_0x0028:
            r2 = r11
        L_0x0029:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0030
            r2 = r2 | 48
            goto L_0x0040
        L_0x0030:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0040
            boolean r3 = r10.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x003d
            r3 = 32
            goto L_0x003f
        L_0x003d:
            r3 = 16
        L_0x003f:
            r2 = r2 | r3
        L_0x0040:
            r3 = r2 & 91
            r3 = r3 ^ 18
            if (r3 != 0) goto L_0x0051
            boolean r3 = r10.getSkipping()
            if (r3 != 0) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            r10.skipToGroupEnd()
            goto L_0x00be
        L_0x0051:
            if (r0 == 0) goto L_0x0057
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
        L_0x0057:
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r0 != r3) goto L_0x0076
            r0 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r1, r0)
            r10.updateRememberedValue(r0)
        L_0x0076:
            r10.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.foundation.text.selection.Selection r3 = m770SelectionContainer$lambda1(r0)
            r1 = -3686930(0xffffffffffc7bdee, float:NaN)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = r10.changed((java.lang.Object) r0)
            java.lang.Object r4 = r10.rememberedValue()
            if (r1 != 0) goto L_0x009c
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r4 != r1) goto L_0x00a7
        L_0x009c:
            androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1 r1 = new androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1
            r1.<init>(r0)
            r4 = r1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r10.updateRememberedValue(r4)
        L_0x00a7:
            r10.endReplaceableGroup()
            r0 = r4
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = r2 & 14
            int r2 = r2 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r6 = r1 | r2
            r7 = 0
            r1 = r8
            r2 = r3
            r3 = r0
            r4 = r9
            r5 = r10
            SelectionContainer(r1, r2, r3, r4, r5, r6, r7)
        L_0x00be:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x00c5
            goto L_0x00cf
        L_0x00c5:
            androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2 r0 = new androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2
            r0.<init>(r8, r9, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: SelectionContainer$lambda-1  reason: not valid java name */
    private static final Selection m770SelectionContainer$lambda1(MutableState<Selection> mutableState) {
        return (Selection) mutableState.getValue();
    }

    public static final void DisableSelection(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(2052695570);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableSelection)60@2203L104:SelectionContainer.kt#eksfi3");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((2 ^ (i2 & 11)) != 0 || !startRestartGroup.getSkipping()) {
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null)}, function2, startRestartGroup, ((i2 << 3) & 112) | 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectionContainerKt$DisableSelection$1(function2, i));
        }
    }

    public static final void SelectionContainer(Modifier modifier, Selection selection, Function1<? super Selection, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        Modifier modifier3;
        Selection selection2 = selection;
        Function1<? super Selection, Unit> function12 = function1;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i4 = i;
        Intrinsics.checkNotNullParameter(function1, "onSelectionChange");
        Intrinsics.checkNotNullParameter(function22, "children");
        Composer startRestartGroup = composer.startRestartGroup(-525718728);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionContainer)P(1,3,2)83@2908L37,84@2964L44,86@3059L7,87@3120L7,88@3171L7,93@3306L1756,134@5068L106:SelectionContainer.kt#eksfi3");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i4 | 6;
            modifier2 = modifier;
        } else if ((i4 & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i4;
        } else {
            modifier2 = modifier;
            i3 = i4;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i4 & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) selection) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        } else if ((i4 & 896) == 0) {
            i3 |= startRestartGroup.changed((Object) function1) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i4 & 7168) == 0) {
            i3 |= startRestartGroup.changed((Object) function22) ? 2048 : 1024;
        }
        if (((i3 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            modifier3 = i5 != 0 ? Modifier.Companion : modifier2;
            startRestartGroup.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SelectionRegistrarImpl();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) rememberedValue;
            startRestartGroup.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SelectionManager(selectionRegistrarImpl);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            SelectionManager selectionManager = (SelectionManager) rememberedValue2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setHapticFeedBack((HapticFeedback) consume);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setClipboardManager((ClipboardManager) consume2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            selectionManager.setTextToolbar((TextToolbar) consume3);
            selectionManager.setOnSelectionChange(function1);
            selectionManager.setSelection(selection);
            selectionManager.setTouchMode(TouchMode_androidKt.isInTouchMode());
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SelectionRegistrarKt.getLocalSelectionRegistrar().provides(selectionRegistrarImpl)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819893315, true, new SelectionContainerKt$SelectionContainer$3(modifier3, selectionManager, function22, i3)), startRestartGroup, 56);
            EffectsKt.DisposableEffect((Object) selectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new SelectionContainerKt$SelectionContainer$4(selectionManager), startRestartGroup, 8);
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectionContainerKt$SelectionContainer$5(modifier3, selection, function1, function2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: SelectionContainer$lambda-2  reason: not valid java name */
    public static final void m771SelectionContainer$lambda2(MutableState<Selection> mutableState, Selection selection) {
        mutableState.setValue(selection);
    }
}
