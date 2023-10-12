package com.stripe.android.paymentsheet.forms;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.stripe.android.ui.core.elements.AffirmElementUIKt;
import com.stripe.android.ui.core.elements.AffirmHeaderElement;
import com.stripe.android.ui.core.elements.AfterpayClearpayElementUIKt;
import com.stripe.android.ui.core.elements.AfterpayClearpayHeaderElement;
import com.stripe.android.ui.core.elements.AuBecsDebitMandateElementUIKt;
import com.stripe.android.ui.core.elements.AuBecsDebitMandateTextElement;
import com.stripe.android.ui.core.elements.BsbElement;
import com.stripe.android.ui.core.elements.BsbElementUIKt;
import com.stripe.android.ui.core.elements.EmptyFormElement;
import com.stripe.android.ui.core.elements.FormElement;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.MandateTextElement;
import com.stripe.android.ui.core.elements.MandateTextUIKt;
import com.stripe.android.ui.core.elements.SaveForFutureUseElement;
import com.stripe.android.ui.core.elements.SaveForFutureUseElementUIKt;
import com.stripe.android.ui.core.elements.SectionElement;
import com.stripe.android.ui.core.elements.SectionElementUIKt;
import com.stripe.android.ui.core.elements.StaticTextElement;
import com.stripe.android.ui.core.elements.StaticTextElementUIKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001aU\u0010\u0005\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b0\u00072\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Form", "", "formViewModel", "Lcom/stripe/android/paymentsheet/forms/FormViewModel;", "(Lcom/stripe/android/paymentsheet/forms/FormViewModel;Landroidx/compose/runtime/Composer;I)V", "FormInternal", "hiddenIdentifiersFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "enabledFlow", "", "elementsFlow", "Lcom/stripe/android/ui/core/elements/FormElement;", "lastTextFieldIdentifierFlow", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Landroidx/compose/runtime/Composer;I)V", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormUI.kt */
public final class FormUIKt {
    public static final void Form(FormViewModel formViewModel, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(formViewModel, "formViewModel");
        Composer startRestartGroup = composer.startRestartGroup(912693978);
        FormInternal(formViewModel.getHiddenIdentifiers$paymentsheet_release(), formViewModel.getEnabled$paymentsheet_release(), formViewModel.getElements$paymentsheet_release(), formViewModel.getLastTextFieldIdentifier(), startRestartGroup, 4680);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FormUIKt$Form$1(formViewModel, i));
        }
    }

    public static final void FormInternal(Flow<? extends List<? extends IdentifierSpec>> flow, Flow<Boolean> flow2, Flow<? extends List<? extends FormElement>> flow3, Flow<? extends IdentifierSpec> flow4, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(flow, "hiddenIdentifiersFlow");
        Intrinsics.checkNotNullParameter(flow2, "enabledFlow");
        Intrinsics.checkNotNullParameter(flow3, "elementsFlow");
        Intrinsics.checkNotNullParameter(flow4, "lastTextFieldIdentifierFlow");
        Composer startRestartGroup = composer.startRestartGroup(1241588108);
        Composer composer2 = startRestartGroup;
        State<R> collectAsState = SnapshotStateKt.collectAsState(flow, CollectionsKt.emptyList(), (CoroutineContext) null, composer2, 8, 2);
        State<R> collectAsState2 = SnapshotStateKt.collectAsState(flow2, true, (CoroutineContext) null, composer2, 56, 2);
        State<R> collectAsState3 = SnapshotStateKt.collectAsState(flow3, null, (CoroutineContext) null, composer2, 56, 2);
        State<R> collectAsState4 = SnapshotStateKt.collectAsState(flow4, null, (CoroutineContext) null, composer2, 56, 2);
        Modifier fillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion, 1.0f);
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
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxWidth);
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
        Updater.m1241setimpl(r5, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(276693625);
        ComposerKt.sourceInformation(startRestartGroup, "C78@3948L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        List<FormElement> r1 = m4430FormInternal$lambda2(collectAsState3);
        startRestartGroup.startReplaceableGroup(365934815);
        if (r1 != null) {
            int i2 = 0;
            for (Object next : r1) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FormElement formElement = (FormElement) next;
                if (!m4428FormInternal$lambda0(collectAsState).contains(formElement.getIdentifier())) {
                    if (formElement instanceof SectionElement) {
                        startRestartGroup.startReplaceableGroup(-2027673746);
                        SectionElementUIKt.SectionElementUI(m4429FormInternal$lambda1(collectAsState2), (SectionElement) formElement, m4428FormInternal$lambda0(collectAsState), m4431FormInternal$lambda3(collectAsState4), startRestartGroup, (IdentifierSpec.$stable << 9) | (SectionElement.$stable << 3) | 512);
                        startRestartGroup.endReplaceableGroup();
                    } else if (formElement instanceof StaticTextElement) {
                        startRestartGroup.startReplaceableGroup(-2027673481);
                        StaticTextElementUIKt.StaticElementUI((StaticTextElement) formElement, startRestartGroup, StaticTextElement.$stable);
                        startRestartGroup.endReplaceableGroup();
                    } else if (formElement instanceof SaveForFutureUseElement) {
                        startRestartGroup.startReplaceableGroup(-2027673402);
                        SaveForFutureUseElementUIKt.SaveForFutureUseElementUI(m4429FormInternal$lambda1(collectAsState2), (SaveForFutureUseElement) formElement, startRestartGroup, SaveForFutureUseElement.$stable << 3);
                        startRestartGroup.endReplaceableGroup();
                    } else if (formElement instanceof AfterpayClearpayHeaderElement) {
                        startRestartGroup.startReplaceableGroup(-2027673298);
                        AfterpayClearpayElementUIKt.AfterpayClearpayElementUI(m4429FormInternal$lambda1(collectAsState2), (AfterpayClearpayHeaderElement) formElement, startRestartGroup, AfterpayClearpayHeaderElement.$stable << 3);
                        startRestartGroup.endReplaceableGroup();
                    } else if (formElement instanceof AuBecsDebitMandateTextElement) {
                        startRestartGroup.startReplaceableGroup(-2027673112);
                        AuBecsDebitMandateElementUIKt.AuBecsDebitMandateElementUI((AuBecsDebitMandateTextElement) formElement, startRestartGroup, AuBecsDebitMandateTextElement.$stable);
                        startRestartGroup.endReplaceableGroup();
                    } else {
                        if (formElement instanceof AffirmHeaderElement) {
                            startRestartGroup.startReplaceableGroup(-2027673025);
                            AffirmElementUIKt.AffirmElementUI(startRestartGroup, 0);
                            startRestartGroup.endReplaceableGroup();
                        } else if (formElement instanceof MandateTextElement) {
                            startRestartGroup.startReplaceableGroup(-2027672958);
                            MandateTextUIKt.MandateTextUI((MandateTextElement) formElement, startRestartGroup, MandateTextElement.$stable);
                            startRestartGroup.endReplaceableGroup();
                        } else if (formElement instanceof BsbElement) {
                            startRestartGroup.startReplaceableGroup(-2027672894);
                            BsbElementUIKt.BsbElementUI(m4429FormInternal$lambda1(collectAsState2), (BsbElement) formElement, m4431FormInternal$lambda3(collectAsState4), startRestartGroup, (BsbElement.$stable << 3) | (IdentifierSpec.$stable << 6));
                            startRestartGroup.endReplaceableGroup();
                        } else if (formElement instanceof EmptyFormElement) {
                            startRestartGroup.startReplaceableGroup(-2027672791);
                            startRestartGroup.endReplaceableGroup();
                        } else {
                            startRestartGroup.startReplaceableGroup(-2027672767);
                            startRestartGroup.endReplaceableGroup();
                        }
                        i2 = i3;
                    }
                }
                i2 = i3;
            }
        }
        startRestartGroup.endReplaceableGroup();
        Unit unit = Unit.INSTANCE;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FormUIKt$FormInternal$2(flow, flow2, flow3, flow4, i));
        }
    }

    /* renamed from: FormInternal$lambda-0  reason: not valid java name */
    private static final List<IdentifierSpec> m4428FormInternal$lambda0(State<? extends List<? extends IdentifierSpec>> state) {
        return (List) state.getValue();
    }

    /* renamed from: FormInternal$lambda-1  reason: not valid java name */
    private static final boolean m4429FormInternal$lambda1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* renamed from: FormInternal$lambda-2  reason: not valid java name */
    private static final List<FormElement> m4430FormInternal$lambda2(State<? extends List<? extends FormElement>> state) {
        return (List) state.getValue();
    }

    /* renamed from: FormInternal$lambda-3  reason: not valid java name */
    private static final IdentifierSpec m4431FormInternal$lambda3(State<? extends IdentifierSpec> state) {
        return (IdentifierSpec) state.getValue();
    }
}
