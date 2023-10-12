package com.stripe.android.ui.core.elements;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"SectionFieldElementUI", "", "enabled", "", "field", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "modifier", "Landroidx/compose/ui/Modifier;", "hiddenIdentifiers", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "lastTextFieldIdentifier", "(ZLcom/stripe/android/ui/core/elements/SectionFieldElement;Landroidx/compose/ui/Modifier;Ljava/util/List;Lcom/stripe/android/ui/core/elements/IdentifierSpec;Landroidx/compose/runtime/Composer;II)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionFieldElementUI.kt */
public final class SectionFieldElementUIKt {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SectionFieldElementUI(boolean r15, com.stripe.android.ui.core.elements.SectionFieldElement r16, androidx.compose.ui.Modifier r17, java.util.List<? extends com.stripe.android.ui.core.elements.IdentifierSpec> r18, com.stripe.android.ui.core.elements.IdentifierSpec r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r7 = r15
            r8 = r16
            r9 = r19
            r10 = r21
            r11 = r22
            java.lang.String r0 = "field"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -1950363178(0xffffffff8bbfd1d6, float:-7.388625E-32)
            r1 = r20
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x001e
            r0 = r10 | 6
            goto L_0x002e
        L_0x001e:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x002d
            boolean r0 = r12.changed((boolean) r15)
            if (r0 == 0) goto L_0x002a
            r0 = 4
            goto L_0x002b
        L_0x002a:
            r0 = 2
        L_0x002b:
            r0 = r0 | r10
            goto L_0x002e
        L_0x002d:
            r0 = r10
        L_0x002e:
            r1 = r11 & 2
            if (r1 == 0) goto L_0x0035
            r0 = r0 | 48
            goto L_0x0045
        L_0x0035:
            r1 = r10 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0045
            boolean r1 = r12.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x0042
            r1 = 32
            goto L_0x0044
        L_0x0042:
            r1 = 16
        L_0x0044:
            r0 = r0 | r1
        L_0x0045:
            r1 = r11 & 4
            if (r1 == 0) goto L_0x004c
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r2 = r10 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x005f
            r2 = r17
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x005b
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r3 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r0 = r0 | r3
            goto L_0x0061
        L_0x005f:
            r2 = r17
        L_0x0061:
            r3 = r11 & 8
            if (r3 == 0) goto L_0x0067
            r0 = r0 | 1024(0x400, float:1.435E-42)
        L_0x0067:
            r4 = r11 & 16
            if (r4 == 0) goto L_0x006e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0080
        L_0x006e:
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r10
            if (r4 != 0) goto L_0x0080
            boolean r4 = r12.changed((java.lang.Object) r9)
            if (r4 == 0) goto L_0x007d
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007f
        L_0x007d:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x007f:
            r0 = r0 | r4
        L_0x0080:
            int r4 = ~r11
            r4 = r4 & 8
            if (r4 != 0) goto L_0x009c
            r4 = 46811(0xb6db, float:6.5596E-41)
            r4 = r4 & r0
            r4 = r4 ^ 9362(0x2492, float:1.3119E-41)
            if (r4 != 0) goto L_0x009c
            boolean r4 = r12.getSkipping()
            if (r4 != 0) goto L_0x0094
            goto L_0x009c
        L_0x0094:
            r12.skipToGroupEnd()
            r4 = r18
            r3 = r2
            goto L_0x0194
        L_0x009c:
            if (r1 == 0) goto L_0x00a4
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r13 = r1
            goto L_0x00a5
        L_0x00a4:
            r13 = r2
        L_0x00a5:
            if (r3 == 0) goto L_0x00aa
            r1 = 0
            r14 = r1
            goto L_0x00ac
        L_0x00aa:
            r14 = r18
        L_0x00ac:
            r1 = 0
            if (r14 != 0) goto L_0x00b0
            goto L_0x00bb
        L_0x00b0:
            com.stripe.android.ui.core.elements.IdentifierSpec r2 = r16.getIdentifier()
            boolean r2 = r14.contains(r2)
            if (r2 != 0) goto L_0x00bb
            r1 = 1
        L_0x00bb:
            if (r1 == 0) goto L_0x0192
            com.stripe.android.ui.core.elements.SectionFieldErrorController r1 = r16.sectionFieldErrorController()
            boolean r2 = r1 instanceof com.stripe.android.ui.core.elements.TextFieldController
            if (r2 == 0) goto L_0x00fb
            r2 = -1950362785(0xffffffff8bbfd35f, float:-7.388856E-32)
            r12.startReplaceableGroup(r2)
            com.stripe.android.ui.core.elements.IdentifierSpec r2 = r16.getIdentifier()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x00dc
            androidx.compose.ui.text.input.ImeAction$Companion r2 = androidx.compose.ui.text.input.ImeAction.Companion
            int r2 = r2.m3643getDoneeUduSuo()
            goto L_0x00e2
        L_0x00dc:
            androidx.compose.ui.text.input.ImeAction$Companion r2 = androidx.compose.ui.text.input.ImeAction.Companion
            int r2 = r2.m3645getNexteUduSuo()
        L_0x00e2:
            com.stripe.android.ui.core.elements.TextFieldController r1 = (com.stripe.android.ui.core.elements.TextFieldController) r1
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            int r0 = r0 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r5 = r3 | r0
            r6 = 0
            r0 = r1
            r1 = r13
            r3 = r15
            r4 = r12
            com.stripe.android.ui.core.elements.TextFieldUIKt.m4607TextField6fMdlN4(r0, r1, r2, r3, r4, r5, r6)
            r12.endReplaceableGroup()
            goto L_0x0192
        L_0x00fb:
            boolean r2 = r1 instanceof com.stripe.android.ui.core.elements.DropdownFieldController
            if (r2 == 0) goto L_0x0115
            r2 = -1950362336(0xffffffff8bbfd520, float:-7.38912E-32)
            r12.startReplaceableGroup(r2)
            com.stripe.android.ui.core.elements.DropdownFieldController r1 = (com.stripe.android.ui.core.elements.DropdownFieldController) r1
            int r0 = r0 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 8
            com.stripe.android.ui.core.elements.DropdownFieldUIKt.DropDown(r1, r15, r12, r0)
            r12.endReplaceableGroup()
            goto L_0x0192
        L_0x0115:
            boolean r2 = r1 instanceof com.stripe.android.ui.core.elements.AddressController
            if (r2 == 0) goto L_0x0137
            r2 = -1950362180(0xffffffff8bbfd5bc, float:-7.3892116E-32)
            r12.startReplaceableGroup(r2)
            com.stripe.android.ui.core.elements.AddressController r1 = (com.stripe.android.ui.core.elements.AddressController) r1
            r2 = r0 & 14
            r2 = r2 | 576(0x240, float:8.07E-43)
            int r0 = r0 >> 3
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r5 = r2 | r0
            r0 = r15
            r2 = r14
            r3 = r19
            r4 = r12
            com.stripe.android.ui.core.elements.AddressElementUIKt.AddressElementUI(r0, r1, r2, r3, r4, r5)
            r12.endReplaceableGroup()
            goto L_0x0192
        L_0x0137:
            boolean r2 = r1 instanceof com.stripe.android.ui.core.elements.RowController
            if (r2 == 0) goto L_0x0159
            r2 = -1950361936(0xffffffff8bbfd6b0, float:-7.389355E-32)
            r12.startReplaceableGroup(r2)
            com.stripe.android.ui.core.elements.RowController r1 = (com.stripe.android.ui.core.elements.RowController) r1
            r2 = r0 & 14
            r2 = r2 | 576(0x240, float:8.07E-43)
            int r0 = r0 >> 3
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r5 = r2 | r0
            r0 = r15
            r2 = r14
            r3 = r19
            r4 = r12
            com.stripe.android.ui.core.elements.RowElementUIKt.RowElementUI(r0, r1, r2, r3, r4, r5)
            r12.endReplaceableGroup()
            goto L_0x0192
        L_0x0159:
            boolean r2 = r1 instanceof com.stripe.android.ui.core.elements.CardDetailsController
            if (r2 == 0) goto L_0x017b
            r2 = -1950361688(0xffffffff8bbfd7a8, float:-7.389501E-32)
            r12.startReplaceableGroup(r2)
            com.stripe.android.ui.core.elements.CardDetailsController r1 = (com.stripe.android.ui.core.elements.CardDetailsController) r1
            r2 = r0 & 14
            r2 = r2 | 576(0x240, float:8.07E-43)
            int r0 = r0 >> 3
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r5 = r2 | r0
            r0 = r15
            r2 = r14
            r3 = r19
            r4 = r12
            com.stripe.android.ui.core.elements.CardDetailsElementUIKt.CardDetailsElementUI(r0, r1, r2, r3, r4, r5)
            r12.endReplaceableGroup()
            goto L_0x0192
        L_0x017b:
            boolean r0 = r1 instanceof com.stripe.android.ui.core.elements.SaveForFutureUseController
            if (r0 == 0) goto L_0x0189
            r0 = -1950361427(0xffffffff8bbfd8ad, float:-7.389654E-32)
            r12.startReplaceableGroup(r0)
            r12.endReplaceableGroup()
            goto L_0x0192
        L_0x0189:
            r0 = -1950361415(0xffffffff8bbfd8b9, float:-7.389661E-32)
            r12.startReplaceableGroup(r0)
            r12.endReplaceableGroup()
        L_0x0192:
            r3 = r13
            r4 = r14
        L_0x0194:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 != 0) goto L_0x019b
            goto L_0x01af
        L_0x019b:
            com.stripe.android.ui.core.elements.SectionFieldElementUIKt$SectionFieldElementUI$1 r13 = new com.stripe.android.ui.core.elements.SectionFieldElementUIKt$SectionFieldElementUI$1
            r0 = r13
            r1 = r15
            r2 = r16
            r5 = r19
            r6 = r21
            r7 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x01af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.SectionFieldElementUIKt.SectionFieldElementUI(boolean, com.stripe.android.ui.core.elements.SectionFieldElement, androidx.compose.ui.Modifier, java.util.List, com.stripe.android.ui.core.elements.IdentifierSpec, androidx.compose.runtime.Composer, int, int):void");
    }
}
