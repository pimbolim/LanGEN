package androidx.compose.ui.text.font;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u000eJ3\u0010\u0003\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0011\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/font/FontMatcher;", "", "()V", "matchFont", "Landroidx/compose/ui/text/font/Font;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "matchFont-RetOiIg", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "fontList", "", "(Ljava/lang/Iterable;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FontMatcher.kt */
public class FontMatcher {
    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public Font m3606matchFontRetOiIg(FontFamily fontFamily, FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontFamily, ViewProps.FONT_FAMILY);
        Intrinsics.checkNotNullParameter(fontWeight, ViewProps.FONT_WEIGHT);
        if (fontFamily instanceof FontListFontFamily) {
            return m3607matchFontRetOiIg((FontListFontFamily) fontFamily, fontWeight, i);
        }
        throw new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
    }

    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public Font m3607matchFontRetOiIg(FontListFontFamily fontListFontFamily, FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontListFontFamily, ViewProps.FONT_FAMILY);
        Intrinsics.checkNotNullParameter(fontWeight, ViewProps.FONT_WEIGHT);
        return m3608matchFontRetOiIg((Iterable<? extends Font>) fontListFontFamily.getFonts(), fontWeight, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: androidx.compose.ui.text.font.Font} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: androidx.compose.ui.text.font.Font} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: androidx.compose.ui.text.font.Font} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: androidx.compose.ui.text.font.Font} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: androidx.compose.ui.text.font.Font} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: androidx.compose.ui.text.font.Font} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: androidx.compose.ui.text.font.Font} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: androidx.compose.ui.text.font.Font} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.text.font.Font m3608matchFontRetOiIg(java.lang.Iterable<? extends androidx.compose.ui.text.font.Font> r12, androidx.compose.ui.text.font.FontWeight r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "fontList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "fontWeight"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r12.iterator()
        L_0x0015:
            boolean r2 = r1.hasNext()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003f
            java.lang.Object r2 = r1.next()
            r5 = r2
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            androidx.compose.ui.text.font.FontWeight r6 = r5.getWeight()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r13)
            if (r6 == 0) goto L_0x0039
            int r5 = r5.m3603getStyle_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m3612equalsimpl0(r5, r14)
            if (r5 == 0) goto L_0x0039
            r3 = 1
        L_0x0039:
            if (r3 == 0) goto L_0x0015
            r0.add(r2)
            goto L_0x0015
        L_0x003f:
            java.util.List r0 = (java.util.List) r0
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r4
            if (r1 == 0) goto L_0x0052
            java.lang.Object r12 = r0.get(r3)
            androidx.compose.ui.text.font.Font r12 = (androidx.compose.ui.text.font.Font) r12
            return r12
        L_0x0052:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r12.iterator()
        L_0x005f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x007a
            java.lang.Object r2 = r1.next()
            r5 = r2
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            int r5 = r5.m3603getStyle_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m3612equalsimpl0(r5, r14)
            if (r5 == 0) goto L_0x005f
            r0.add(r2)
            goto L_0x005f
        L_0x007a:
            java.util.List r0 = (java.util.List) r0
            r14 = r0
            java.util.Collection r14 = (java.util.Collection) r14
            boolean r14 = r14.isEmpty()
            r14 = r14 ^ r4
            if (r14 == 0) goto L_0x0089
            r12 = r0
            java.lang.Iterable r12 = (java.lang.Iterable) r12
        L_0x0089:
            androidx.compose.ui.text.font.FontWeight$Companion r14 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r14 = r14.getW400()
            int r14 = r13.compareTo((androidx.compose.ui.text.font.FontWeight) r14)
            r0 = 0
            if (r14 >= 0) goto L_0x0168
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r1 = r12.iterator()
        L_0x00a1:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00c1
            java.lang.Object r2 = r1.next()
            r5 = r2
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            androidx.compose.ui.text.font.FontWeight r5 = r5.getWeight()
            int r5 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r13)
            if (r5 > 0) goto L_0x00ba
            r5 = 1
            goto L_0x00bb
        L_0x00ba:
            r5 = 0
        L_0x00bb:
            if (r5 == 0) goto L_0x00a1
            r14.add(r2)
            goto L_0x00a1
        L_0x00c1:
            java.util.List r14 = (java.util.List) r14
            boolean r1 = r14.isEmpty()
            if (r1 == 0) goto L_0x00cb
            r1 = r0
            goto L_0x00fb
        L_0x00cb:
            java.lang.Object r1 = r14.get(r3)
            r2 = r1
            androidx.compose.ui.text.font.Font r2 = (androidx.compose.ui.text.font.Font) r2
            androidx.compose.ui.text.font.FontWeight r2 = r2.getWeight()
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r14)
            if (r4 > r5) goto L_0x00fb
            r6 = 1
        L_0x00df:
            int r7 = r6 + 1
            java.lang.Object r8 = r14.get(r6)
            r9 = r8
            androidx.compose.ui.text.font.Font r9 = (androidx.compose.ui.text.font.Font) r9
            androidx.compose.ui.text.font.FontWeight r9 = r9.getWeight()
            java.lang.Comparable r9 = (java.lang.Comparable) r9
            int r10 = r2.compareTo(r9)
            if (r10 >= 0) goto L_0x00f6
            r1 = r8
            r2 = r9
        L_0x00f6:
            if (r6 != r5) goto L_0x00f9
            goto L_0x00fb
        L_0x00f9:
            r6 = r7
            goto L_0x00df
        L_0x00fb:
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            if (r1 != 0) goto L_0x0396
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r12 = r12.iterator()
        L_0x010a:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x012a
            java.lang.Object r1 = r12.next()
            r2 = r1
            androidx.compose.ui.text.font.Font r2 = (androidx.compose.ui.text.font.Font) r2
            androidx.compose.ui.text.font.FontWeight r2 = r2.getWeight()
            int r2 = r2.compareTo((androidx.compose.ui.text.font.FontWeight) r13)
            if (r2 <= 0) goto L_0x0123
            r2 = 1
            goto L_0x0124
        L_0x0123:
            r2 = 0
        L_0x0124:
            if (r2 == 0) goto L_0x010a
            r14.add(r1)
            goto L_0x010a
        L_0x012a:
            java.util.List r14 = (java.util.List) r14
            boolean r12 = r14.isEmpty()
            if (r12 == 0) goto L_0x0133
            goto L_0x0163
        L_0x0133:
            java.lang.Object r12 = r14.get(r3)
            r13 = r12
            androidx.compose.ui.text.font.Font r13 = (androidx.compose.ui.text.font.Font) r13
            androidx.compose.ui.text.font.FontWeight r13 = r13.getWeight()
            java.lang.Comparable r13 = (java.lang.Comparable) r13
            int r0 = kotlin.collections.CollectionsKt.getLastIndex(r14)
            if (r4 > r0) goto L_0x0162
        L_0x0146:
            int r1 = r4 + 1
            java.lang.Object r2 = r14.get(r4)
            r3 = r2
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            androidx.compose.ui.text.font.FontWeight r3 = r3.getWeight()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r5 = r13.compareTo(r3)
            if (r5 <= 0) goto L_0x015d
            r12 = r2
            r13 = r3
        L_0x015d:
            if (r4 != r0) goto L_0x0160
            goto L_0x0162
        L_0x0160:
            r4 = r1
            goto L_0x0146
        L_0x0162:
            r0 = r12
        L_0x0163:
            r1 = r0
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            goto L_0x0396
        L_0x0168:
            androidx.compose.ui.text.font.FontWeight$Companion r14 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r14 = r14.getW500()
            int r14 = r13.compareTo((androidx.compose.ui.text.font.FontWeight) r14)
            if (r14 <= 0) goto L_0x0246
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r1 = r12.iterator()
        L_0x017f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x019f
            java.lang.Object r2 = r1.next()
            r5 = r2
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            androidx.compose.ui.text.font.FontWeight r5 = r5.getWeight()
            int r5 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r13)
            if (r5 < 0) goto L_0x0198
            r5 = 1
            goto L_0x0199
        L_0x0198:
            r5 = 0
        L_0x0199:
            if (r5 == 0) goto L_0x017f
            r14.add(r2)
            goto L_0x017f
        L_0x019f:
            java.util.List r14 = (java.util.List) r14
            boolean r1 = r14.isEmpty()
            if (r1 == 0) goto L_0x01a9
            r1 = r0
            goto L_0x01d9
        L_0x01a9:
            java.lang.Object r1 = r14.get(r3)
            r2 = r1
            androidx.compose.ui.text.font.Font r2 = (androidx.compose.ui.text.font.Font) r2
            androidx.compose.ui.text.font.FontWeight r2 = r2.getWeight()
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r14)
            if (r4 > r5) goto L_0x01d9
            r6 = 1
        L_0x01bd:
            int r7 = r6 + 1
            java.lang.Object r8 = r14.get(r6)
            r9 = r8
            androidx.compose.ui.text.font.Font r9 = (androidx.compose.ui.text.font.Font) r9
            androidx.compose.ui.text.font.FontWeight r9 = r9.getWeight()
            java.lang.Comparable r9 = (java.lang.Comparable) r9
            int r10 = r2.compareTo(r9)
            if (r10 <= 0) goto L_0x01d4
            r1 = r8
            r2 = r9
        L_0x01d4:
            if (r6 != r5) goto L_0x01d7
            goto L_0x01d9
        L_0x01d7:
            r6 = r7
            goto L_0x01bd
        L_0x01d9:
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            if (r1 != 0) goto L_0x0396
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r12 = r12.iterator()
        L_0x01e8:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0208
            java.lang.Object r1 = r12.next()
            r2 = r1
            androidx.compose.ui.text.font.Font r2 = (androidx.compose.ui.text.font.Font) r2
            androidx.compose.ui.text.font.FontWeight r2 = r2.getWeight()
            int r2 = r2.compareTo((androidx.compose.ui.text.font.FontWeight) r13)
            if (r2 >= 0) goto L_0x0201
            r2 = 1
            goto L_0x0202
        L_0x0201:
            r2 = 0
        L_0x0202:
            if (r2 == 0) goto L_0x01e8
            r14.add(r1)
            goto L_0x01e8
        L_0x0208:
            java.util.List r14 = (java.util.List) r14
            boolean r12 = r14.isEmpty()
            if (r12 == 0) goto L_0x0211
            goto L_0x0241
        L_0x0211:
            java.lang.Object r12 = r14.get(r3)
            r13 = r12
            androidx.compose.ui.text.font.Font r13 = (androidx.compose.ui.text.font.Font) r13
            androidx.compose.ui.text.font.FontWeight r13 = r13.getWeight()
            java.lang.Comparable r13 = (java.lang.Comparable) r13
            int r0 = kotlin.collections.CollectionsKt.getLastIndex(r14)
            if (r4 > r0) goto L_0x0240
        L_0x0224:
            int r1 = r4 + 1
            java.lang.Object r2 = r14.get(r4)
            r3 = r2
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            androidx.compose.ui.text.font.FontWeight r3 = r3.getWeight()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r5 = r13.compareTo(r3)
            if (r5 >= 0) goto L_0x023b
            r12 = r2
            r13 = r3
        L_0x023b:
            if (r4 != r0) goto L_0x023e
            goto L_0x0240
        L_0x023e:
            r4 = r1
            goto L_0x0224
        L_0x0240:
            r0 = r12
        L_0x0241:
            r1 = r0
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            goto L_0x0396
        L_0x0246:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r1 = r12.iterator()
        L_0x0251:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0281
            java.lang.Object r2 = r1.next()
            r5 = r2
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            androidx.compose.ui.text.font.FontWeight r6 = r5.getWeight()
            int r6 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r13)
            if (r6 < 0) goto L_0x027a
            androidx.compose.ui.text.font.FontWeight r5 = r5.getWeight()
            androidx.compose.ui.text.font.FontWeight$Companion r6 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r6 = r6.getW500()
            int r5 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r6)
            if (r5 > 0) goto L_0x027a
            r5 = 1
            goto L_0x027b
        L_0x027a:
            r5 = 0
        L_0x027b:
            if (r5 == 0) goto L_0x0251
            r14.add(r2)
            goto L_0x0251
        L_0x0281:
            java.util.List r14 = (java.util.List) r14
            boolean r1 = r14.isEmpty()
            if (r1 == 0) goto L_0x028b
            r1 = r0
            goto L_0x02bb
        L_0x028b:
            java.lang.Object r1 = r14.get(r3)
            r2 = r1
            androidx.compose.ui.text.font.Font r2 = (androidx.compose.ui.text.font.Font) r2
            androidx.compose.ui.text.font.FontWeight r2 = r2.getWeight()
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r14)
            if (r4 > r5) goto L_0x02bb
            r6 = 1
        L_0x029f:
            int r7 = r6 + 1
            java.lang.Object r8 = r14.get(r6)
            r9 = r8
            androidx.compose.ui.text.font.Font r9 = (androidx.compose.ui.text.font.Font) r9
            androidx.compose.ui.text.font.FontWeight r9 = r9.getWeight()
            java.lang.Comparable r9 = (java.lang.Comparable) r9
            int r10 = r2.compareTo(r9)
            if (r10 <= 0) goto L_0x02b6
            r1 = r8
            r2 = r9
        L_0x02b6:
            if (r6 != r5) goto L_0x02b9
            goto L_0x02bb
        L_0x02b9:
            r6 = r7
            goto L_0x029f
        L_0x02bb:
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            if (r1 != 0) goto L_0x0396
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r1 = r12.iterator()
        L_0x02ca:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x02ea
            java.lang.Object r2 = r1.next()
            r5 = r2
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            androidx.compose.ui.text.font.FontWeight r5 = r5.getWeight()
            int r5 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r13)
            if (r5 >= 0) goto L_0x02e3
            r5 = 1
            goto L_0x02e4
        L_0x02e3:
            r5 = 0
        L_0x02e4:
            if (r5 == 0) goto L_0x02ca
            r14.add(r2)
            goto L_0x02ca
        L_0x02ea:
            java.util.List r14 = (java.util.List) r14
            boolean r13 = r14.isEmpty()
            if (r13 == 0) goto L_0x02f4
            r13 = r0
            goto L_0x0324
        L_0x02f4:
            java.lang.Object r13 = r14.get(r3)
            r1 = r13
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            androidx.compose.ui.text.font.FontWeight r1 = r1.getWeight()
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            int r2 = kotlin.collections.CollectionsKt.getLastIndex(r14)
            if (r4 > r2) goto L_0x0324
            r5 = 1
        L_0x0308:
            int r6 = r5 + 1
            java.lang.Object r7 = r14.get(r5)
            r8 = r7
            androidx.compose.ui.text.font.Font r8 = (androidx.compose.ui.text.font.Font) r8
            androidx.compose.ui.text.font.FontWeight r8 = r8.getWeight()
            java.lang.Comparable r8 = (java.lang.Comparable) r8
            int r9 = r1.compareTo(r8)
            if (r9 >= 0) goto L_0x031f
            r13 = r7
            r1 = r8
        L_0x031f:
            if (r5 != r2) goto L_0x0322
            goto L_0x0324
        L_0x0322:
            r5 = r6
            goto L_0x0308
        L_0x0324:
            r1 = r13
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            if (r1 != 0) goto L_0x0396
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.Iterator r12 = r12.iterator()
        L_0x0334:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x035a
            java.lang.Object r14 = r12.next()
            r1 = r14
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            androidx.compose.ui.text.font.FontWeight r1 = r1.getWeight()
            androidx.compose.ui.text.font.FontWeight$Companion r2 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r2 = r2.getW500()
            int r1 = r1.compareTo((androidx.compose.ui.text.font.FontWeight) r2)
            if (r1 <= 0) goto L_0x0353
            r1 = 1
            goto L_0x0354
        L_0x0353:
            r1 = 0
        L_0x0354:
            if (r1 == 0) goto L_0x0334
            r13.add(r14)
            goto L_0x0334
        L_0x035a:
            java.util.List r13 = (java.util.List) r13
            boolean r12 = r13.isEmpty()
            if (r12 == 0) goto L_0x0363
            goto L_0x0393
        L_0x0363:
            java.lang.Object r12 = r13.get(r3)
            r14 = r12
            androidx.compose.ui.text.font.Font r14 = (androidx.compose.ui.text.font.Font) r14
            androidx.compose.ui.text.font.FontWeight r14 = r14.getWeight()
            java.lang.Comparable r14 = (java.lang.Comparable) r14
            int r0 = kotlin.collections.CollectionsKt.getLastIndex(r13)
            if (r4 > r0) goto L_0x0392
        L_0x0376:
            int r1 = r4 + 1
            java.lang.Object r2 = r13.get(r4)
            r3 = r2
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            androidx.compose.ui.text.font.FontWeight r3 = r3.getWeight()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r5 = r14.compareTo(r3)
            if (r5 <= 0) goto L_0x038d
            r12 = r2
            r14 = r3
        L_0x038d:
            if (r4 != r0) goto L_0x0390
            goto L_0x0392
        L_0x0390:
            r4 = r1
            goto L_0x0376
        L_0x0392:
            r0 = r12
        L_0x0393:
            r1 = r0
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
        L_0x0396:
            if (r1 == 0) goto L_0x0399
            return r1
        L_0x0399:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "Cannot match any font"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontMatcher.m3608matchFontRetOiIg(java.lang.Iterable, androidx.compose.ui.text.font.FontWeight, int):androidx.compose.ui.text.font.Font");
    }
}
