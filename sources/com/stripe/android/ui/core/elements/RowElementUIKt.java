package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.constraintlayout.compose.ConstraintLayoutKt;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.Measurer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"RowElementUI", "", "enabled", "", "controller", "Lcom/stripe/android/ui/core/elements/RowController;", "hiddenIdentifiers", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "lastTextFieldIdentifier", "(ZLcom/stripe/android/ui/core/elements/RowController;Ljava/util/List;Lcom/stripe/android/ui/core/elements/IdentifierSpec;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RowElementUI.kt */
public final class RowElementUIKt {
    public static final void RowElementUI(boolean z, RowController rowController, List<? extends IdentifierSpec> list, IdentifierSpec identifierSpec, Composer composer, int i) {
        boolean z2;
        List<? extends IdentifierSpec> list2 = list;
        Intrinsics.checkNotNullParameter(rowController, "controller");
        Intrinsics.checkNotNullParameter(list2, "hiddenIdentifiers");
        Composer startRestartGroup = composer.startRestartGroup(540810060);
        List<SectionSingleFieldElement> fields = rowController.getFields();
        Iterable<SectionSingleFieldElement> iterable = fields;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (!list2.contains(((SectionSingleFieldElement) next).getIdentifier())) {
                arrayList.add(next);
            }
        }
        int size = ((List) arrayList).size();
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SectionSingleFieldElement identifier : iterable) {
            arrayList2.add(identifier.getIdentifier());
        }
        Iterable iterable2 = (List) arrayList2;
        if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
            Iterator it = iterable2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!list2.contains((IdentifierSpec) it.next())) {
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            startRestartGroup.startReplaceableGroup(-270267499);
            ComposerKt.sourceInformation(startRestartGroup, "C(ConstraintLayout)P(1,2)");
            Modifier modifier = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Measurer();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Measurer measurer = (Measurer) rememberedValue;
            startRestartGroup.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new ConstraintLayoutScope();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            ConstraintLayoutScope constraintLayoutScope = (ConstraintLayoutScope) rememberedValue2;
            startRestartGroup.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            Pair<MeasurePolicy, Function0<Unit>> rememberConstraintLayoutMeasurePolicy = ConstraintLayoutKt.rememberConstraintLayoutMeasurePolicy(257, constraintLayoutScope, (MutableState<Boolean>) (MutableState) rememberedValue3, measurer, startRestartGroup, 4544);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, new RowElementUIKt$RowElementUI$$inlined$ConstraintLayout$1(measurer), 1, (Object) null);
            ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
            RowElementUIKt$RowElementUI$$inlined$ConstraintLayout$2 rowElementUIKt$RowElementUI$$inlined$ConstraintLayout$2 = r0;
            RowElementUIKt$RowElementUI$$inlined$ConstraintLayout$2 rowElementUIKt$RowElementUI$$inlined$ConstraintLayout$22 = new RowElementUIKt$RowElementUI$$inlined$ConstraintLayout$2(constraintLayoutScope2, 0, rememberConstraintLayoutMeasurePolicy.component2(), fields, size, z, list, identifierSpec, i);
            LayoutKt.MultiMeasureLayout(semantics$default, ComposableLambdaKt.composableLambda(startRestartGroup, -819893854, true, rowElementUIKt$RowElementUI$$inlined$ConstraintLayout$2), rememberConstraintLayoutMeasurePolicy.component1(), startRestartGroup, 48, 0);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RowElementUIKt$RowElementUI$4(z, rowController, list, identifierSpec, i));
        }
    }
}
