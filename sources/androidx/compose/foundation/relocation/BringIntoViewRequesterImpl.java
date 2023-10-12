package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "()V", "bringIntoViewUsages", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/relocation/BringIntoViewData;", "getBringIntoViewUsages", "()Landroidx/compose/runtime/collection/MutableVector;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalFoundationApi
/* compiled from: BringIntoViewRequester.kt */
final class BringIntoViewRequesterImpl implements BringIntoViewRequester {
    private final MutableVector<BringIntoViewData> bringIntoViewUsages = new MutableVector<>(new BringIntoViewData[16], 0);

    public final MutableVector<BringIntoViewData> getBringIntoViewUsages() {
        return this.bringIntoViewUsages;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ad, code lost:
        if (r10 >= r2) goto L_0x00af;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object bringIntoView(androidx.compose.ui.geometry.Rect r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = (androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = new androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            int r10 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$1
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.geometry.Rect r5 = (androidx.compose.ui.geometry.Rect) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ab
        L_0x0037:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.runtime.collection.MutableVector r11 = r9.getBringIntoViewUsages()
            int r2 = r11.getSize()
            if (r2 <= 0) goto L_0x00af
            r4 = 0
            java.lang.Object[] r11 = r11.getContent()
            r4 = r11
            r11 = r10
            r10 = 0
        L_0x0054:
            r5 = r4[r10]
            androidx.compose.foundation.relocation.BringIntoViewData r5 = (androidx.compose.foundation.relocation.BringIntoViewData) r5
            androidx.compose.ui.layout.LayoutCoordinates r6 = r5.getLayoutCoordinates()
            if (r6 == 0) goto L_0x00ac
            boolean r7 = r6.isAttached()
            if (r7 != 0) goto L_0x0065
            goto L_0x00ac
        L_0x0065:
            if (r11 != 0) goto L_0x0074
            long r7 = r6.m3140getSizeYbymL2g()
            long r7 = androidx.compose.ui.unit.IntSizeKt.m4029toSizeozmzZPI(r7)
            androidx.compose.ui.geometry.Rect r7 = androidx.compose.ui.geometry.SizeKt.m1443toRectuvyYCjk(r7)
            goto L_0x0075
        L_0x0074:
            r7 = r11
        L_0x0075:
            androidx.compose.foundation.relocation.BringIntoViewResponder r8 = r5.getParent()
            androidx.compose.ui.geometry.Rect r6 = r8.toLocalRect(r7, r6)
            androidx.compose.foundation.relocation.BringIntoViewResponder r7 = r5.getParent()
            androidx.compose.foundation.relocation.BringIntoViewResponder$Companion r8 = androidx.compose.foundation.relocation.BringIntoViewResponder.Companion
            androidx.compose.foundation.relocation.BringIntoViewResponder r8 = r8.getRootBringIntoViewResponder()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0095
            androidx.compose.foundation.relocation.BringRectangleOnScreenRequester r5 = r5.getBringRectangleOnScreenRequester()
            r5.bringRectangleOnScreen(r6)
            goto L_0x00ac
        L_0x0095:
            androidx.compose.foundation.relocation.BringIntoViewResponder r5 = r5.getParent()
            r0.L$0 = r11
            r0.L$1 = r4
            r0.I$0 = r2
            r0.I$1 = r10
            r0.label = r3
            java.lang.Object r5 = r5.bringIntoView(r6, r0)
            if (r5 != r1) goto L_0x00aa
            return r1
        L_0x00aa:
            r5 = r11
        L_0x00ab:
            r11 = r5
        L_0x00ac:
            int r10 = r10 + r3
            if (r10 < r2) goto L_0x0054
        L_0x00af:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.bringIntoView(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
