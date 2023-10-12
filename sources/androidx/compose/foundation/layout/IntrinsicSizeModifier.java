package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bb\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J)\u0010\u0015\u001a\u00020\u0016*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u001c\u0010\u001a\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicSizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "enforceIncoming", "", "getEnforceIncoming", "()Z", "calculateContentConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "calculateContentConstraints-l58MMJ0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Intrinsic.kt */
interface IntrinsicSizeModifier extends LayoutModifier {
    /* renamed from: calculateContentConstraints-l58MMJ0  reason: not valid java name */
    long m404calculateContentConstraintsl58MMJ0(MeasureScope measureScope, Measurable measurable, long j);

    boolean getEnforceIncoming();

    int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    MeasureResult m405measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Intrinsic.kt */
    public static final class DefaultImpls {
        public static boolean getEnforceIncoming(IntrinsicSizeModifier intrinsicSizeModifier) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            return true;
        }

        public static boolean all(IntrinsicSizeModifier intrinsicSizeModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return LayoutModifier.DefaultImpls.all(intrinsicSizeModifier, function1);
        }

        public static boolean any(IntrinsicSizeModifier intrinsicSizeModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return LayoutModifier.DefaultImpls.any(intrinsicSizeModifier, function1);
        }

        public static <R> R foldIn(IntrinsicSizeModifier intrinsicSizeModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return LayoutModifier.DefaultImpls.foldIn(intrinsicSizeModifier, r, function2);
        }

        public static <R> R foldOut(IntrinsicSizeModifier intrinsicSizeModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return LayoutModifier.DefaultImpls.foldOut(intrinsicSizeModifier, r, function2);
        }

        public static Modifier then(IntrinsicSizeModifier intrinsicSizeModifier, Modifier modifier) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            Intrinsics.checkNotNullParameter(modifier, "other");
            return LayoutModifier.DefaultImpls.then(intrinsicSizeModifier, modifier);
        }

        /* renamed from: measure-3p2s80s  reason: not valid java name */
        public static MeasureResult m406measure3p2s80s(IntrinsicSizeModifier intrinsicSizeModifier, MeasureScope measureScope, Measurable measurable, long j) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            Intrinsics.checkNotNullParameter(measureScope, "receiver");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            long r0 = intrinsicSizeModifier.m404calculateContentConstraintsl58MMJ0(measureScope, measurable, j);
            if (intrinsicSizeModifier.getEnforceIncoming()) {
                r0 = ConstraintsKt.m3815constrainN9IONVI(j, r0);
            }
            Placeable r7 = measurable.m3151measureBRTryo0(r0);
            return MeasureScope.DefaultImpls.layout$default(measureScope, r7.getWidth(), r7.getHeight(), (Map) null, new IntrinsicSizeModifier$measure$1(r7), 4, (Object) null);
        }

        public static int minIntrinsicWidth(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }

        public static int minIntrinsicHeight(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }

        public static int maxIntrinsicWidth(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }

        public static int maxIntrinsicHeight(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicSizeModifier, "this");
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
    }
}
