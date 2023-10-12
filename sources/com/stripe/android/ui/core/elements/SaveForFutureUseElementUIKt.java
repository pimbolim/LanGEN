package com.stripe.android.ui.core.elements;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.menu.CheckboxKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"SaveForFutureUseElementUI", "", "enabled", "", "element", "Lcom/stripe/android/ui/core/elements/SaveForFutureUseElement;", "(ZLcom/stripe/android/ui/core/elements/SaveForFutureUseElement;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SaveForFutureUseElementUI.kt */
public final class SaveForFutureUseElementUIKt {
    public static final void SaveForFutureUseElementUI(boolean z, SaveForFutureUseElement saveForFutureUseElement, Composer composer, int i) {
        int i2;
        boolean z2 = z;
        SaveForFutureUseElement saveForFutureUseElement2 = saveForFutureUseElement;
        int i3 = i;
        Intrinsics.checkNotNullParameter(saveForFutureUseElement2, "element");
        Composer startRestartGroup = composer.startRestartGroup(1516597413);
        ComposerKt.sourceInformation(startRestartGroup, "C(SaveForFutureUseElementUI)P(1)");
        SaveForFutureUseController controller = saveForFutureUseElement.getController();
        Composer composer2 = startRestartGroup;
        State<R> collectAsState = SnapshotStateKt.collectAsState(controller.getSaveForFutureUse(), true, (CoroutineContext) null, composer2, 56, 2);
        State<R> collectAsState2 = SnapshotStateKt.collectAsState(controller.getLabel(), null, (CoroutineContext) null, composer2, 56, 2);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Resources resources = ((Context) consume).getResources();
        if (m4589SaveForFutureUseElementUI$lambda0(collectAsState)) {
            i2 = R.string.selected;
        } else {
            i2 = R.string.not_selected;
        }
        String stringResource = StringResources_androidKt.stringResource(i2, startRestartGroup, 0);
        Modifier r4 = PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m3859constructorimpl((float) 2), 1, (Object) null);
        startRestartGroup.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed((Object) stringResource);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SaveForFutureUseElementUIKt$SaveForFutureUseElementUI$1$1(stringResource);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        Modifier r0 = SizeKt.m481requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(ToggleableKt.m583toggleableXHw0xAI(SemanticsModifierKt.semantics$default(r4, false, (Function1) rememberedValue, 1, (Object) null), m4589SaveForFutureUseElementUI$lambda0(collectAsState), z2, Role.m3470boximpl(Role.Companion.m3478getCheckboxo7Vup1c()), new SaveForFutureUseElementUIKt$SaveForFutureUseElementUI$2(controller, collectAsState)), 0.0f, 1, (Object) null), Dp.m3859constructorimpl((float) 48));
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        startRestartGroup.startReplaceableGroup(-1989997165);
        ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r0);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r5 = Updater.m1234constructorimpl(startRestartGroup);
        Updater.m1241setimpl(r5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-326682362);
        ComposerKt.sourceInformation(startRestartGroup, "C79@3942L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        CheckboxKt.Checkbox(m4589SaveForFutureUseElementUI$lambda0(collectAsState), (Function1<? super Boolean, Unit>) null, (Modifier) null, z, startRestartGroup, ((i3 << 9) & 7168) | 48, 4);
        Integer r02 = m4590SaveForFutureUseElementUI$lambda1(collectAsState2);
        if (r02 != null) {
            String string = resources.getString(r02.intValue(), new Object[]{saveForFutureUseElement.getMerchantName()});
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(it, element.merchantName)");
            H6TextKt.H6Text(string, rowScope.align(PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, Dp.m3859constructorimpl((float) 4), 0.0f, 0.0f, 0.0f, 14, (Object) null), Alignment.Companion.getCenterVertically()), startRestartGroup, 0, 0);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SaveForFutureUseElementUIKt$SaveForFutureUseElementUI$4(z2, saveForFutureUseElement2, i3));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: SaveForFutureUseElementUI$lambda-0  reason: not valid java name */
    public static final boolean m4589SaveForFutureUseElementUI$lambda0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* renamed from: SaveForFutureUseElementUI$lambda-1  reason: not valid java name */
    private static final Integer m4590SaveForFutureUseElementUI$lambda1(State<Integer> state) {
        return state.getValue();
    }
}
