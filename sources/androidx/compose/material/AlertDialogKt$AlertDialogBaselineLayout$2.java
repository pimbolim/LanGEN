package androidx.compose.material;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogBaselineLayout$2 implements MeasurePolicy {
    public static final AlertDialogKt$AlertDialogBaselineLayout$2 INSTANCE = new AlertDialogKt$AlertDialogBaselineLayout$2();

    AlertDialogKt$AlertDialogBaselineLayout$2() {
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0138  */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.layout.MeasureResult m825measure3p2s80s(androidx.compose.ui.layout.MeasureScope r12, java.util.List<? extends androidx.compose.ui.layout.Measurable> r13, long r14) {
        /*
            r11 = this;
            java.lang.String r0 = "$this$Layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r0 = r13.iterator()
        L_0x0010:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r0.next()
            r3 = r1
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            java.lang.Object r3 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r3)
            java.lang.String r4 = "title"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0010
            goto L_0x002d
        L_0x002c:
            r1 = r2
        L_0x002d:
            androidx.compose.ui.layout.Measurable r1 = (androidx.compose.ui.layout.Measurable) r1
            if (r1 != 0) goto L_0x0033
            r0 = r2
            goto L_0x0043
        L_0x0033:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 11
            r10 = 0
            r3 = r14
            long r3 = androidx.compose.ui.unit.Constraints.m3794copyZbe2FdA$default(r3, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.layout.Placeable r0 = r1.m3151measureBRTryo0(r3)
        L_0x0043:
            java.util.Iterator r13 = r13.iterator()
        L_0x0047:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r13.next()
            r3 = r1
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            java.lang.Object r3 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r3)
            java.lang.String r4 = "text"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0047
            goto L_0x0063
        L_0x0062:
            r1 = r2
        L_0x0063:
            androidx.compose.ui.layout.Measurable r1 = (androidx.compose.ui.layout.Measurable) r1
            if (r1 != 0) goto L_0x0069
            r13 = r2
            goto L_0x0079
        L_0x0069:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 11
            r10 = 0
            r3 = r14
            long r13 = androidx.compose.ui.unit.Constraints.m3794copyZbe2FdA$default(r3, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.layout.Placeable r13 = r1.m3151measureBRTryo0(r13)
        L_0x0079:
            r14 = 0
            if (r0 != 0) goto L_0x007e
            r15 = 0
            goto L_0x0082
        L_0x007e:
            int r15 = r0.getWidth()
        L_0x0082:
            if (r13 != 0) goto L_0x0086
            r1 = 0
            goto L_0x0092
        L_0x0086:
            int r1 = r13.getWidth()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r1.intValue()
        L_0x0092:
            int r4 = java.lang.Math.max(r15, r1)
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L_0x009c
        L_0x009a:
            r1 = 0
            goto L_0x00bf
        L_0x009c:
            androidx.compose.ui.layout.HorizontalAlignmentLine r1 = androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()
            androidx.compose.ui.layout.AlignmentLine r1 = (androidx.compose.ui.layout.AlignmentLine) r1
            int r1 = r0.get(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            if (r1 != r15) goto L_0x00b4
            r1 = r2
            goto L_0x00b8
        L_0x00b4:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x00b8:
            if (r1 != 0) goto L_0x00bb
            goto L_0x009a
        L_0x00bb:
            int r1 = r1.intValue()
        L_0x00bf:
            if (r0 != 0) goto L_0x00c3
        L_0x00c1:
            r3 = 0
            goto L_0x00e6
        L_0x00c3:
            androidx.compose.ui.layout.HorizontalAlignmentLine r3 = androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline()
            androidx.compose.ui.layout.AlignmentLine r3 = (androidx.compose.ui.layout.AlignmentLine) r3
            int r3 = r0.get(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r3 != r15) goto L_0x00db
            r3 = r2
            goto L_0x00df
        L_0x00db:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x00df:
            if (r3 != 0) goto L_0x00e2
            goto L_0x00c1
        L_0x00e2:
            int r3 = r3.intValue()
        L_0x00e6:
            long r5 = androidx.compose.material.AlertDialogKt.TitleBaselineDistanceFromTop
            int r5 = r12.m3821roundToPxR2X_6o(r5)
            int r5 = r5 - r1
            if (r13 != 0) goto L_0x00f3
        L_0x00f1:
            r15 = 0
            goto L_0x010b
        L_0x00f3:
            androidx.compose.ui.layout.HorizontalAlignmentLine r1 = androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()
            androidx.compose.ui.layout.AlignmentLine r1 = (androidx.compose.ui.layout.AlignmentLine) r1
            int r1 = r13.get(r1)
            if (r1 != r15) goto L_0x0100
            goto L_0x0104
        L_0x0100:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
        L_0x0104:
            if (r2 != 0) goto L_0x0107
            goto L_0x00f1
        L_0x0107:
            int r15 = r2.intValue()
        L_0x010b:
            if (r0 != 0) goto L_0x0116
            long r1 = androidx.compose.material.AlertDialogKt.TextBaselineDistanceFromTop
            int r1 = r12.m3821roundToPxR2X_6o(r1)
            goto L_0x011e
        L_0x0116:
            long r1 = androidx.compose.material.AlertDialogKt.TextBaselineDistanceFromTitle
            int r1 = r12.m3821roundToPxR2X_6o(r1)
        L_0x011e:
            if (r0 != 0) goto L_0x0122
            r2 = 0
            goto L_0x0127
        L_0x0122:
            int r2 = r0.getHeight()
            int r2 = r2 + r5
        L_0x0127:
            if (r0 != 0) goto L_0x012c
            int r6 = r1 - r15
            goto L_0x0135
        L_0x012c:
            if (r3 != 0) goto L_0x0131
            int r6 = r2 - r15
            goto L_0x0134
        L_0x0131:
            int r6 = r5 + r3
            int r6 = r6 - r15
        L_0x0134:
            int r6 = r6 + r1
        L_0x0135:
            if (r13 != 0) goto L_0x0138
            goto L_0x0151
        L_0x0138:
            if (r3 != 0) goto L_0x0141
            int r14 = r13.getHeight()
            int r14 = r14 + r1
            int r14 = r14 - r15
            goto L_0x0151
        L_0x0141:
            int r7 = r13.getHeight()
            int r7 = r7 + r1
            int r7 = r7 - r15
            if (r0 != 0) goto L_0x014a
            goto L_0x014e
        L_0x014a:
            int r14 = r0.getHeight()
        L_0x014e:
            int r14 = r14 - r3
            int r7 = r7 - r14
            r14 = r7
        L_0x0151:
            int r14 = r14 + r2
            r15 = 0
            androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1 r1 = new androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1
            r1.<init>(r0, r5, r13, r6)
            r7 = r1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8 = 4
            r9 = 0
            r3 = r12
            r5 = r14
            r6 = r15
            androidx.compose.ui.layout.MeasureResult r12 = androidx.compose.ui.layout.MeasureScope.DefaultImpls.layout$default(r3, r4, r5, r6, r7, r8, r9)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2.m825measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }
}
