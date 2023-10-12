package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import com.stripe.android.ui.core.PaymentsTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConstraintLayout.kt */
public final class RowElementUIKt$RowElementUI$$inlined$ConstraintLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$dirty$inlined;
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ List $fields$inlined;
    final /* synthetic */ List $hiddenIdentifiers$inlined;
    final /* synthetic */ IdentifierSpec $lastTextFieldIdentifier$inlined;
    final /* synthetic */ int $numVisibleFields$inlined;
    final /* synthetic */ Function0 $onHelpersChanged;
    final /* synthetic */ ConstraintLayoutScope $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RowElementUIKt$RowElementUI$$inlined$ConstraintLayout$2(ConstraintLayoutScope constraintLayoutScope, int i, Function0 function0, List list, int i2, boolean z, List list2, IdentifierSpec identifierSpec, int i3) {
        super(2);
        this.$scope = constraintLayoutScope;
        this.$onHelpersChanged = function0;
        this.$fields$inlined = list;
        this.$numVisibleFields$inlined = i2;
        this.$enabled$inlined = z;
        this.$hiddenIdentifiers$inlined = list2;
        this.$lastTextFieldIdentifier$inlined = identifierSpec;
        this.$$dirty$inlined = i3;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            int helpersHashCode = this.$scope.getHelpersHashCode();
            this.$scope.reset();
            ConstraintLayoutScope constraintLayoutScope = this.$scope;
            int i2 = ((this.$$changed >> 3) & 112) | 8;
            if ((i2 & 14) == 0) {
                i2 |= composer2.changed((Object) constraintLayoutScope) ? 4 : 2;
            }
            if (((i2 & 91) ^ 18) != 0 || !composer.getSkipping()) {
                Iterable<SectionSingleFieldElement> iterable = this.$fields$inlined;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (SectionSingleFieldElement sectionSingleFieldElement : iterable) {
                    arrayList.add(constraintLayoutScope.createRef());
                }
                List list = (List) arrayList;
                Iterable<SectionSingleFieldElement> iterable2 = this.$fields$inlined;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (SectionSingleFieldElement sectionSingleFieldElement2 : iterable2) {
                    arrayList2.add(constraintLayoutScope.createRef());
                }
                List list2 = (List) arrayList2;
                int i3 = 0;
                for (Object next : this.$fields$inlined) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    SectionSingleFieldElement sectionSingleFieldElement3 = (SectionSingleFieldElement) next;
                    Modifier fillMaxWidth = SizeKt.fillMaxWidth(constraintLayoutScope.constrainAs(Modifier.Companion, (ConstrainedLayoutReference) list.get(i3), new RowElementUIKt$RowElementUI$3$1$1(i3, list2)), 1.0f / ((float) this.$numVisibleFields$inlined));
                    List list3 = this.$hiddenIdentifiers$inlined;
                    IdentifierSpec identifierSpec = this.$lastTextFieldIdentifier$inlined;
                    int i5 = this.$$dirty$inlined;
                    int i6 = i3;
                    SectionFieldElementUIKt.SectionFieldElementUI(this.$enabled$inlined, sectionSingleFieldElement3, fillMaxWidth, list3, identifierSpec, composer, (i5 & 14) | 4096 | ((i5 << 3) & 57344), 0);
                    if (!this.$hiddenIdentifiers$inlined.contains(sectionSingleFieldElement3.getIdentifier()) && i6 != CollectionsKt.getLastIndex(this.$fields$inlined)) {
                        DividerKt.m954DivideroMI9zvI(SizeKt.m497width3ABfNKs(PaddingKt.m433paddingVpY3zN4$default(constraintLayoutScope.constrainAs(Modifier.Companion, (ConstrainedLayoutReference) list2.get(i6), new RowElementUIKt$RowElementUI$3$1$2(list, i6)), PaymentsTheme.INSTANCE.getShapes(composer2, 8).m4512getBorderStrokeWidthD9Ej5fM(), 0.0f, 2, (Object) null), PaymentsTheme.INSTANCE.getShapes(composer2, 8).m4512getBorderStrokeWidthD9Ej5fM()), PaymentsTheme.INSTANCE.getColors(composer2, 8).m4502getColorComponentDivider0d7_KjU(), 0.0f, 0.0f, composer, 0, 12);
                    }
                    i3 = i4;
                }
            } else {
                composer.skipToGroupEnd();
            }
            if (this.$scope.getHelpersHashCode() != helpersHashCode) {
                this.$onHelpersChanged.invoke();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
