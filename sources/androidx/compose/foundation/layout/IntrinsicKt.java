package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"height", "Landroidx/compose/ui/Modifier;", "intrinsicSize", "Landroidx/compose/foundation/layout/IntrinsicSize;", "requiredHeight", "requiredWidth", "width", "foundation-layout_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Intrinsic.kt */
public final class IntrinsicKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Intrinsic.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IntrinsicSize.values().length];
            iArr[IntrinsicSize.Min.ordinal()] = 1;
            iArr[IntrinsicSize.Max.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Modifier width(Modifier modifier, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        int i = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i == 1) {
            return modifier.then(MinIntrinsicWidthModifier.INSTANCE);
        }
        if (i == 2) {
            return modifier.then(MaxIntrinsicWidthModifier.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Modifier height(Modifier modifier, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        int i = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i == 1) {
            return modifier.then(MinIntrinsicHeightModifier.INSTANCE);
        }
        if (i == 2) {
            return modifier.then(MaxIntrinsicHeightModifier.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Modifier requiredWidth(Modifier modifier, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        int i = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i == 1) {
            return modifier.then(RequiredMinIntrinsicWidthModifier.INSTANCE);
        }
        if (i == 2) {
            return modifier.then(RequiredMaxIntrinsicWidthModifier.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Modifier requiredHeight(Modifier modifier, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        int i = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i == 1) {
            return modifier.then(RequiredMinIntrinsicHeightModifier.INSTANCE);
        }
        if (i == 2) {
            return modifier.then(RequiredMaxIntrinsicHeightModifier.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
