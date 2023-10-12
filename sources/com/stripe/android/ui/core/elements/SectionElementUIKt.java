package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"SectionElementUI", "", "enabled", "", "element", "Lcom/stripe/android/ui/core/elements/SectionElement;", "hiddenIdentifiers", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "lastTextFieldIdentifier", "(ZLcom/stripe/android/ui/core/elements/SectionElement;Ljava/util/List;Lcom/stripe/android/ui/core/elements/IdentifierSpec;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionElementUI.kt */
public final class SectionElementUIKt {
    public static final void SectionElementUI(boolean z, SectionElement sectionElement, List<? extends IdentifierSpec> list, IdentifierSpec identifierSpec, Composer composer, int i) {
        List<? extends IdentifierSpec> list2 = list;
        Intrinsics.checkNotNullParameter(sectionElement, "element");
        Intrinsics.checkNotNullParameter(list2, "hiddenIdentifiers");
        Composer startRestartGroup = composer.startRestartGroup(1964617234);
        ComposerKt.sourceInformation(startRestartGroup, "C(SectionElementUI)P(1)");
        if (!list2.contains(sectionElement.getIdentifier())) {
            SectionController controller = sectionElement.getController();
            FieldError r1 = m4592SectionElementUI$lambda0(SnapshotStateKt.collectAsState(controller.getError(), null, (CoroutineContext) null, startRestartGroup, 56, 2));
            startRestartGroup.startReplaceableGroup(1964617604);
            String str = null;
            if (r1 != null) {
                Object[] formatArgs = r1.getFormatArgs();
                startRestartGroup.startReplaceableGroup(1964617637);
                if (formatArgs != null) {
                    str = StringResources_androidKt.stringResource(r1.getErrorMessage(), Arrays.copyOf(formatArgs, formatArgs.length), startRestartGroup, 64);
                }
                startRestartGroup.endReplaceableGroup();
                if (str == null) {
                    str = StringResources_androidKt.stringResource(r1.getErrorMessage(), startRestartGroup, 0);
                }
            }
            String str2 = str;
            startRestartGroup.endReplaceableGroup();
            SectionUIKt.Section(controller.getLabel(), str2, (Function2<? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.composableLambda(startRestartGroup, -819895554, true, new SectionElementUIKt$SectionElementUI$1(sectionElement, z, list, identifierSpec, i)), startRestartGroup, 3072, 4);
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SectionElementUIKt$SectionElementUI$2(z, sectionElement, list, identifierSpec, i));
        }
    }

    /* renamed from: SectionElementUI$lambda-0  reason: not valid java name */
    private static final FieldError m4592SectionElementUI$lambda0(State<FieldError> state) {
        return state.getValue();
    }
}
