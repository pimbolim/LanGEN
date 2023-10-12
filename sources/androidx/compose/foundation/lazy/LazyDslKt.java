package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001al\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001al\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001c*\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001d2%\b\n\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001123\b\u0004\u0010#\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010$¢\u0006\u0002\b&¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u0010'\u001a\u0001\u0010\u001b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001c*\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0(2%\b\n\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001123\b\u0004\u0010#\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010$¢\u0006\u0002\b&¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u0010)\u001a¯\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001c*\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001d2:\b\n\u0010\u001e\u001a4\u0012\u0013\u0012\u00110+¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010$2H\b\u0004\u0010#\u001aB\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110+¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010-¢\u0006\u0002\b&¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u0010.\u001a¯\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001c*\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0(2:\b\n\u0010\u001e\u001a4\u0012\u0013\u0012\u00110+¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010$2H\b\u0004\u0010#\u001aB\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110+¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010-¢\u0006\u0002\b&¢\u0006\u0002\b\u0013H\bø\u0001\u0000¢\u0006\u0002\u0010/\u0002\u0007\n\u0005\b20\u0001¨\u00060"}, d2 = {"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyDsl.kt */
public final class LazyDslKt {
    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function4 function4, int i, Object obj) {
        Function1 function12 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int size = list.size();
        if (function1 != null) {
            function12 = new LazyDslKt$items$1(function1, list);
        }
        lazyListScope.items(size, function12, ComposableLambdaKt.composableLambdaInstance(-985537722, true, new LazyDslKt$items$2(function4, list)));
    }

    public static final <T> void items(LazyListScope lazyListScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$1(function1, list) : null, ComposableLambdaKt.composableLambdaInstance(-985537722, true, new LazyDslKt$items$2(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function5 function5, int i, Object obj) {
        Function1 function1 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int size = list.size();
        if (function2 != null) {
            function1 = new LazyDslKt$itemsIndexed$1(function2, list);
        }
        lazyListScope.items(size, function1, ComposableLambdaKt.composableLambdaInstance(-985537359, true, new LazyDslKt$itemsIndexed$2(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$1(function2, list) : null, ComposableLambdaKt.composableLambdaInstance(-985537359, true, new LazyDslKt$itemsIndexed$2(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function4 function4, int i, Object obj) {
        Function1 function12 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "items");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int length = objArr.length;
        if (function1 != null) {
            function12 = new LazyDslKt$items$3(function1, objArr);
        }
        lazyListScope.items(length, function12, ComposableLambdaKt.composableLambdaInstance(-985536307, true, new LazyDslKt$items$4(function4, objArr)));
    }

    public static final <T> void items(LazyListScope lazyListScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "items");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        lazyListScope.items(tArr.length, function1 != null ? new LazyDslKt$items$3(function1, tArr) : null, ComposableLambdaKt.composableLambdaInstance(-985536307, true, new LazyDslKt$items$4(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function5 function5, int i, Object obj) {
        Function1 function1 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "items");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int length = objArr.length;
        if (function2 != null) {
            function1 = new LazyDslKt$itemsIndexed$3(function2, objArr);
        }
        lazyListScope.items(length, function1, ComposableLambdaKt.composableLambdaInstance(-985535428, true, new LazyDslKt$itemsIndexed$4(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "items");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        lazyListScope.items(tArr.length, function2 != null ? new LazyDslKt$itemsIndexed$3(function2, tArr) : null, ComposableLambdaKt.composableLambdaInstance(-985535428, true, new LazyDslKt$itemsIndexed$4(function5, tArr)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyRow(androidx.compose.ui.Modifier r27, androidx.compose.foundation.lazy.LazyListState r28, androidx.compose.foundation.layout.PaddingValues r29, boolean r30, androidx.compose.foundation.layout.Arrangement.Horizontal r31, androidx.compose.ui.Alignment.Vertical r32, androidx.compose.foundation.gestures.FlingBehavior r33, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r15 = r34
            r14 = r36
            r13 = r37
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 1356349622(0x50d840b6, float:2.90249564E10)
            r1 = r35
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(LazyRow)P(4,6,1,5,3,7,2)191@9319L23,197@9670L15,200@9733L342:LazyDsl.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r13 & 1
            if (r0 == 0) goto L_0x0023
            r1 = r14 | 6
            r2 = r1
            r1 = r27
            goto L_0x0037
        L_0x0023:
            r1 = r14 & 14
            if (r1 != 0) goto L_0x0034
            r1 = r27
            boolean r2 = r12.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0031
            r2 = 4
            goto L_0x0032
        L_0x0031:
            r2 = 2
        L_0x0032:
            r2 = r2 | r14
            goto L_0x0037
        L_0x0034:
            r1 = r27
            r2 = r14
        L_0x0037:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0050
            r3 = r13 & 2
            if (r3 != 0) goto L_0x004a
            r3 = r28
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004c
            r4 = 32
            goto L_0x004e
        L_0x004a:
            r3 = r28
        L_0x004c:
            r4 = 16
        L_0x004e:
            r2 = r2 | r4
            goto L_0x0052
        L_0x0050:
            r3 = r28
        L_0x0052:
            r4 = r13 & 4
            if (r4 == 0) goto L_0x0059
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0059:
            r5 = r14 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006c
            r5 = r29
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0068
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r2 = r2 | r6
            goto L_0x006e
        L_0x006c:
            r5 = r29
        L_0x006e:
            r6 = r13 & 8
            if (r6 == 0) goto L_0x0075
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0075:
            r7 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0088
            r7 = r30
            boolean r8 = r12.changed((boolean) r7)
            if (r8 == 0) goto L_0x0084
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r2 = r2 | r8
            goto L_0x008a
        L_0x0088:
            r7 = r30
        L_0x008a:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r14
            if (r8 != 0) goto L_0x00a5
            r8 = r13 & 16
            if (r8 != 0) goto L_0x009f
            r8 = r31
            boolean r9 = r12.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00a1
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r8 = r31
        L_0x00a1:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r2 = r2 | r9
            goto L_0x00a7
        L_0x00a5:
            r8 = r31
        L_0x00a7:
            r9 = r13 & 32
            r10 = 458752(0x70000, float:6.42848E-40)
            if (r9 == 0) goto L_0x00b1
            r11 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r11
            goto L_0x00c5
        L_0x00b1:
            r11 = r14 & r10
            if (r11 != 0) goto L_0x00c5
            r11 = r32
            boolean r16 = r12.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x00c0
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r2 = r2 | r16
            goto L_0x00c7
        L_0x00c5:
            r11 = r32
        L_0x00c7:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00e1
            r16 = r13 & 64
            r10 = r33
            if (r16 != 0) goto L_0x00dc
            boolean r16 = r12.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00dc
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r2 = r2 | r16
            goto L_0x00e3
        L_0x00e1:
            r10 = r33
        L_0x00e3:
            r1 = r13 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00eb
            r1 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00e9:
            r2 = r2 | r1
            goto L_0x00fc
        L_0x00eb:
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r14
            if (r1 != 0) goto L_0x00fc
            boolean r1 = r12.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x00f9
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e9
        L_0x00f9:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00e9
        L_0x00fc:
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r2
            r16 = 4793490(0x492492, float:6.71711E-39)
            r1 = r1 ^ r16
            if (r1 != 0) goto L_0x011d
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x010e
            goto L_0x011d
        L_0x010e:
            r12.skipToGroupEnd()
            r1 = r27
            r2 = r3
            r3 = r5
            r4 = r7
            r5 = r8
            r7 = r10
            r6 = r11
            r26 = r12
            goto L_0x0210
        L_0x011d:
            r12.startDefaults()
            r1 = r14 & 1
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x0156
            boolean r1 = r12.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0131
            goto L_0x0156
        L_0x0131:
            r12.skipToGroupEnd()
            r0 = r13 & 2
            if (r0 == 0) goto L_0x013a
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x013a:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0140
            r2 = r2 & r17
        L_0x0140:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0146
            r2 = r2 & r16
        L_0x0146:
            r16 = r27
            r17 = r3
        L_0x014a:
            r18 = r5
            r19 = r7
            r20 = r8
            r22 = r10
        L_0x0152:
            r21 = r11
            goto L_0x01ba
        L_0x0156:
            if (r0 == 0) goto L_0x015d
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x015f
        L_0x015d:
            r0 = r27
        L_0x015f:
            r1 = r13 & 2
            r27 = r0
            r0 = 0
            if (r1 == 0) goto L_0x016e
            r1 = 3
            androidx.compose.foundation.lazy.LazyListState r1 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r0, r0, r12, r0, r1)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x016f
        L_0x016e:
            r1 = r3
        L_0x016f:
            if (r4 == 0) goto L_0x017b
            float r3 = (float) r0
            float r3 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r3)
            androidx.compose.foundation.layout.PaddingValues r3 = androidx.compose.foundation.layout.PaddingKt.m424PaddingValues0680j_4(r3)
            r5 = r3
        L_0x017b:
            if (r6 == 0) goto L_0x017e
            r7 = 0
        L_0x017e:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0192
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r7 != 0) goto L_0x018b
            androidx.compose.foundation.layout.Arrangement$Horizontal r0 = r0.getStart()
            goto L_0x018f
        L_0x018b:
            androidx.compose.foundation.layout.Arrangement$Horizontal r0 = r0.getEnd()
        L_0x018f:
            r2 = r2 & r17
            r8 = r0
        L_0x0192:
            if (r9 == 0) goto L_0x019b
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r0 = r0.getTop()
            r11 = r0
        L_0x019b:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x01b5
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r3 = 6
            androidx.compose.foundation.gestures.FlingBehavior r0 = r0.flingBehavior(r12, r3)
            r2 = r2 & r16
            r16 = r27
            r22 = r0
            r17 = r1
            r18 = r5
            r19 = r7
            r20 = r8
            goto L_0x0152
        L_0x01b5:
            r16 = r27
            r17 = r1
            goto L_0x014a
        L_0x01ba:
            r12.endDefaults()
            r4 = 0
            r6 = 0
            r7 = 0
            r0 = r2 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r2 >> 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            r1 = 234881024(0xe000000, float:1.5777218E-30)
            int r3 = r2 << 9
            r1 = r1 & r3
            r0 = r0 | r1
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            int r3 = r2 << 15
            r1 = r1 & r3
            r23 = r0 | r1
            int r0 = r2 >> 21
            r24 = r0 & 14
            r25 = 192(0xc0, float:2.69E-43)
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r5 = r22
            r8 = r21
            r9 = r20
            r10 = r34
            r11 = r12
            r26 = r12
            r12 = r23
            r13 = r24
            r14 = r25
            androidx.compose.foundation.lazy.list.LazyListKt.LazyList(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
        L_0x0210:
            androidx.compose.runtime.ScopeUpdateScope r11 = r26.endRestartGroup()
            if (r11 != 0) goto L_0x0217
            goto L_0x0228
        L_0x0217:
            androidx.compose.foundation.lazy.LazyDslKt$LazyRow$1 r12 = new androidx.compose.foundation.lazy.LazyDslKt$LazyRow$1
            r0 = r12
            r8 = r34
            r9 = r36
            r10 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x0228:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyRow(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.FlingBehavior, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyColumn(androidx.compose.ui.Modifier r27, androidx.compose.foundation.lazy.LazyListState r28, androidx.compose.foundation.layout.PaddingValues r29, boolean r30, androidx.compose.foundation.layout.Arrangement.Vertical r31, androidx.compose.ui.Alignment.Horizontal r32, androidx.compose.foundation.gestures.FlingBehavior r33, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r15 = r34
            r14 = r36
            r13 = r37
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -750326393(0xffffffffd346ed87, float:-8.5438857E11)
            r1 = r35
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(LazyColumn)P(4,6,1,5,7,3,2)241@11807L23,247@12161L15,250@12224L341:LazyDsl.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r13 & 1
            if (r0 == 0) goto L_0x0023
            r1 = r14 | 6
            r2 = r1
            r1 = r27
            goto L_0x0037
        L_0x0023:
            r1 = r14 & 14
            if (r1 != 0) goto L_0x0034
            r1 = r27
            boolean r2 = r12.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0031
            r2 = 4
            goto L_0x0032
        L_0x0031:
            r2 = 2
        L_0x0032:
            r2 = r2 | r14
            goto L_0x0037
        L_0x0034:
            r1 = r27
            r2 = r14
        L_0x0037:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0050
            r3 = r13 & 2
            if (r3 != 0) goto L_0x004a
            r3 = r28
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004c
            r4 = 32
            goto L_0x004e
        L_0x004a:
            r3 = r28
        L_0x004c:
            r4 = 16
        L_0x004e:
            r2 = r2 | r4
            goto L_0x0052
        L_0x0050:
            r3 = r28
        L_0x0052:
            r4 = r13 & 4
            if (r4 == 0) goto L_0x0059
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0059:
            r5 = r14 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006c
            r5 = r29
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0068
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r2 = r2 | r6
            goto L_0x006e
        L_0x006c:
            r5 = r29
        L_0x006e:
            r6 = r13 & 8
            if (r6 == 0) goto L_0x0075
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0075:
            r7 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0088
            r7 = r30
            boolean r8 = r12.changed((boolean) r7)
            if (r8 == 0) goto L_0x0084
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r2 = r2 | r8
            goto L_0x008a
        L_0x0088:
            r7 = r30
        L_0x008a:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r14
            if (r8 != 0) goto L_0x00a5
            r8 = r13 & 16
            if (r8 != 0) goto L_0x009f
            r8 = r31
            boolean r9 = r12.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00a1
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x009f:
            r8 = r31
        L_0x00a1:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r2 = r2 | r9
            goto L_0x00a7
        L_0x00a5:
            r8 = r31
        L_0x00a7:
            r9 = r13 & 32
            r10 = 458752(0x70000, float:6.42848E-40)
            if (r9 == 0) goto L_0x00b1
            r11 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r11
            goto L_0x00c5
        L_0x00b1:
            r11 = r14 & r10
            if (r11 != 0) goto L_0x00c5
            r11 = r32
            boolean r16 = r12.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x00c0
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r2 = r2 | r16
            goto L_0x00c7
        L_0x00c5:
            r11 = r32
        L_0x00c7:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r17 = r14 & r16
            if (r17 != 0) goto L_0x00e1
            r17 = r13 & 64
            r10 = r33
            if (r17 != 0) goto L_0x00dc
            boolean r17 = r12.changed((java.lang.Object) r10)
            if (r17 == 0) goto L_0x00dc
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r2 = r2 | r17
            goto L_0x00e3
        L_0x00e1:
            r10 = r33
        L_0x00e3:
            r1 = r13 & 128(0x80, float:1.794E-43)
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            if (r1 == 0) goto L_0x00ed
            r1 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00eb:
            r2 = r2 | r1
            goto L_0x00fd
        L_0x00ed:
            r1 = r14 & r17
            if (r1 != 0) goto L_0x00fd
            boolean r1 = r12.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x00fa
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00eb
        L_0x00fa:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00eb
        L_0x00fd:
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r2
            r18 = 4793490(0x492492, float:6.71711E-39)
            r1 = r1 ^ r18
            if (r1 != 0) goto L_0x011e
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x010f
            goto L_0x011e
        L_0x010f:
            r12.skipToGroupEnd()
            r1 = r27
            r2 = r3
            r3 = r5
            r4 = r7
            r5 = r8
            r7 = r10
            r6 = r11
            r26 = r12
            goto L_0x020d
        L_0x011e:
            r12.startDefaults()
            r1 = r14 & 1
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x0157
            boolean r1 = r12.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0132
            goto L_0x0157
        L_0x0132:
            r12.skipToGroupEnd()
            r0 = r13 & 2
            if (r0 == 0) goto L_0x013b
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x013b:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0141
            r2 = r2 & r19
        L_0x0141:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0147
            r2 = r2 & r18
        L_0x0147:
            r18 = r27
            r19 = r3
        L_0x014b:
            r20 = r5
            r21 = r7
            r22 = r8
            r24 = r10
        L_0x0153:
            r23 = r11
            goto L_0x01bb
        L_0x0157:
            if (r0 == 0) goto L_0x015e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0160
        L_0x015e:
            r0 = r27
        L_0x0160:
            r1 = r13 & 2
            r27 = r0
            r0 = 0
            if (r1 == 0) goto L_0x016f
            r1 = 3
            androidx.compose.foundation.lazy.LazyListState r1 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r0, r0, r12, r0, r1)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0170
        L_0x016f:
            r1 = r3
        L_0x0170:
            if (r4 == 0) goto L_0x017c
            float r3 = (float) r0
            float r3 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r3)
            androidx.compose.foundation.layout.PaddingValues r3 = androidx.compose.foundation.layout.PaddingKt.m424PaddingValues0680j_4(r3)
            r5 = r3
        L_0x017c:
            if (r6 == 0) goto L_0x017f
            r7 = 0
        L_0x017f:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0193
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r7 != 0) goto L_0x018c
            androidx.compose.foundation.layout.Arrangement$Vertical r0 = r0.getTop()
            goto L_0x0190
        L_0x018c:
            androidx.compose.foundation.layout.Arrangement$Vertical r0 = r0.getBottom()
        L_0x0190:
            r2 = r2 & r19
            r8 = r0
        L_0x0193:
            if (r9 == 0) goto L_0x019c
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r0 = r0.getStart()
            r11 = r0
        L_0x019c:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x01b6
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r3 = 6
            androidx.compose.foundation.gestures.FlingBehavior r0 = r0.flingBehavior(r12, r3)
            r2 = r2 & r18
            r18 = r27
            r24 = r0
            r19 = r1
            r20 = r5
            r21 = r7
            r22 = r8
            goto L_0x0153
        L_0x01b6:
            r18 = r27
            r19 = r1
            goto L_0x014b
        L_0x01bb:
            r12.endDefaults()
            r4 = 1
            r8 = 0
            r9 = 0
            r0 = r2 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r2 >> 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r2 << 3
            r1 = r1 & r16
            r0 = r0 | r1
            int r1 = r2 << 9
            r1 = r1 & r17
            r16 = r0 | r1
            int r0 = r2 >> 21
            r17 = r0 & 14
            r25 = 768(0x300, float:1.076E-42)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r5 = r24
            r6 = r23
            r7 = r22
            r10 = r34
            r11 = r12
            r26 = r12
            r12 = r16
            r13 = r17
            r14 = r25
            androidx.compose.foundation.lazy.list.LazyListKt.LazyList(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r7 = r24
        L_0x020d:
            androidx.compose.runtime.ScopeUpdateScope r11 = r26.endRestartGroup()
            if (r11 != 0) goto L_0x0214
            goto L_0x0225
        L_0x0214:
            androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1 r12 = new androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
            r0 = r12
            r8 = r34
            r9 = r36
            r10 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x0225:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
