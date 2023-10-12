package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.DividerKt;
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
import com.stripe.android.ui.core.PaymentsTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"AddressElementUI", "", "enabled", "", "controller", "Lcom/stripe/android/ui/core/elements/AddressController;", "hiddenIdentifiers", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "lastTextFieldIdentifier", "(ZLcom/stripe/android/ui/core/elements/AddressController;Ljava/util/List;Lcom/stripe/android/ui/core/elements/IdentifierSpec;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddressElementUI.kt */
public final class AddressElementUIKt {
    public static final void AddressElementUI(boolean z, AddressController addressController, List<? extends IdentifierSpec> list, IdentifierSpec identifierSpec, Composer composer, int i) {
        List list2;
        Composer composer2;
        Object obj;
        Composer composer3;
        boolean z2;
        List<? extends IdentifierSpec> list3 = list;
        Intrinsics.checkNotNullParameter(addressController, "controller");
        Composer startRestartGroup = composer.startRestartGroup(-890764261);
        List<SectionFieldElement> r0 = m4550AddressElementUI$lambda0(SnapshotStateKt.collectAsState(addressController.getFieldsFlowable(), null, (CoroutineContext) null, startRestartGroup, 56, 2));
        Object obj2 = null;
        if (r0 == null) {
            list2 = null;
        } else {
            Collection arrayList = new ArrayList();
            for (Object next : r0) {
                SectionFieldElement sectionFieldElement = (SectionFieldElement) next;
                if (list3 != null && !list3.contains(sectionFieldElement.getIdentifier())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            list2 = (List) arrayList;
        }
        if (list2 == null) {
            composer2 = startRestartGroup;
        } else {
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
            int i2 = 0;
            for (Object next2 : list2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SectionFieldElementUIKt.SectionFieldElementUI(z, (SectionFieldElement) next2, (Modifier) null, list, identifierSpec, startRestartGroup, (i & 14) | 4096 | (57344 & (i << 3)), 4);
                if (i2 != CollectionsKt.getLastIndex(list2)) {
                    obj = obj2;
                    composer3 = startRestartGroup;
                    DividerKt.m954DivideroMI9zvI(PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, PaymentsTheme.INSTANCE.getShapes(startRestartGroup, 8).m4512getBorderStrokeWidthD9Ej5fM(), 0.0f, 2, obj2), PaymentsTheme.INSTANCE.getColors(startRestartGroup, 8).m4502getColorComponentDivider0d7_KjU(), PaymentsTheme.INSTANCE.getShapes(startRestartGroup, 8).m4512getBorderStrokeWidthD9Ej5fM(), 0.0f, startRestartGroup, 0, 8);
                } else {
                    obj = obj2;
                    composer3 = startRestartGroup;
                }
                startRestartGroup = composer3;
                obj2 = obj;
                i2 = i3;
            }
            composer2 = startRestartGroup;
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AddressElementUIKt$AddressElementUI$3(z, addressController, list, identifierSpec, i));
        }
    }

    /* renamed from: AddressElementUI$lambda-0  reason: not valid java name */
    private static final List<SectionFieldElement> m4550AddressElementUI$lambda0(State<? extends List<? extends SectionFieldElement>> state) {
        return (List) state.getValue();
    }
}
