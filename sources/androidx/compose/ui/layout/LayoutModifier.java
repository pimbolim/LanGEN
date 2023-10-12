package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016J)\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/Modifier$Element;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutModifier.kt */
public interface LayoutModifier extends Modifier.Element {
    int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    MeasureResult m3149measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LayoutModifier.kt */
    public static final class DefaultImpls {
        public static boolean all(LayoutModifier layoutModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(layoutModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.all(layoutModifier, function1);
        }

        public static boolean any(LayoutModifier layoutModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(layoutModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.any(layoutModifier, function1);
        }

        public static <R> R foldIn(LayoutModifier layoutModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(layoutModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldIn(layoutModifier, r, function2);
        }

        public static <R> R foldOut(LayoutModifier layoutModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(layoutModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldOut(layoutModifier, r, function2);
        }

        public static Modifier then(LayoutModifier layoutModifier, Modifier modifier) {
            Intrinsics.checkNotNullParameter(layoutModifier, "this");
            Intrinsics.checkNotNullParameter(modifier, "other");
            return Modifier.Element.DefaultImpls.then(layoutModifier, modifier);
        }

        public static int minIntrinsicWidth(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(layoutModifier, "this");
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return MeasuringIntrinsics.INSTANCE.minWidth$ui_release(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
        }

        public static int minIntrinsicHeight(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(layoutModifier, "this");
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return MeasuringIntrinsics.INSTANCE.minHeight$ui_release(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
        }

        public static int maxIntrinsicWidth(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(layoutModifier, "this");
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return MeasuringIntrinsics.INSTANCE.maxWidth$ui_release(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
        }

        public static int maxIntrinsicHeight(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(layoutModifier, "this");
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return MeasuringIntrinsics.INSTANCE.maxHeight$ui_release(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
        }
    }
}
