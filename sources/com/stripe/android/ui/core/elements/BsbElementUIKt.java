package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"BsbElementUI", "", "enabled", "", "element", "Lcom/stripe/android/ui/core/elements/BsbElement;", "lastTextFieldIdentifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "(ZLcom/stripe/android/ui/core/elements/BsbElement;Lcom/stripe/android/ui/core/elements/IdentifierSpec;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BsbElementUI.kt */
public final class BsbElementUIKt {
    public static final void BsbElementUI(boolean z, BsbElement bsbElement, IdentifierSpec identifierSpec, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(bsbElement, "element");
        Composer startRestartGroup = composer.startRestartGroup(537894630);
        ComposerKt.sourceInformation(startRestartGroup, "C(BsbElementUI)P(1)");
        Composer composer2 = startRestartGroup;
        State<R> collectAsState = SnapshotStateKt.collectAsState(bsbElement.getTextElement$payments_ui_core_release().getController().getError(), null, (CoroutineContext) null, composer2, 56, 2);
        State<R> collectAsState2 = SnapshotStateKt.collectAsState(bsbElement.getBankName(), null, (CoroutineContext) null, composer2, 56, 2);
        FieldError r0 = m4555BsbElementUI$lambda0(collectAsState);
        startRestartGroup.startReplaceableGroup(537894913);
        String str = null;
        if (r0 != null) {
            Object[] formatArgs = r0.getFormatArgs();
            startRestartGroup.startReplaceableGroup(537894942);
            if (formatArgs != null) {
                str = StringResources_androidKt.stringResource(r0.getErrorMessage(), Arrays.copyOf(formatArgs, formatArgs.length), startRestartGroup, 64);
            }
            startRestartGroup.endReplaceableGroup();
            if (str == null) {
                str = StringResources_androidKt.stringResource(r0.getErrorMessage(), startRestartGroup, 0);
            }
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1113030915);
        ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
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
        Composer r7 = Updater.m1234constructorimpl(startRestartGroup);
        Updater.m1241setimpl(r7, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r7, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r7, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r7, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(276693625);
        ComposerKt.sourceInformation(startRestartGroup, "C78@3948L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        SectionUIKt.Section((Integer) null, str, ComposableLambdaKt.composableLambda(startRestartGroup, -819895484, true, new BsbElementUIKt$BsbElementUI$1$1(collectAsState2)), ComposableLambdaKt.composableLambda(startRestartGroup, -819895628, true, new BsbElementUIKt$BsbElementUI$1$2(bsbElement, identifierSpec, z, i)), startRestartGroup, 3462, 0);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BsbElementUIKt$BsbElementUI$2(z, bsbElement, identifierSpec, i));
        }
    }

    /* renamed from: BsbElementUI$lambda-0  reason: not valid java name */
    private static final FieldError m4555BsbElementUI$lambda0(State<FieldError> state) {
        return state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: BsbElementUI$lambda-1  reason: not valid java name */
    public static final String m4556BsbElementUI$lambda1(State<String> state) {
        return state.getValue();
    }
}
