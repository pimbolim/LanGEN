package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001\u001aW\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000\u001aY\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"isPlatformMagnifierSupported", "", "sdkVersion", "", "magnifier", "Landroidx/compose/ui/Modifier;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "zoom", "", "style", "Landroidx/compose/foundation/MagnifierStyle;", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Magnifier.kt */
public final class MagnifierKt {
    public static final boolean isPlatformMagnifierSupported(int i) {
        return i >= 28;
    }

    public static /* synthetic */ Modifier magnifier$default(Modifier modifier, Function1 function1, Function1 function12, float f, MagnifierStyle magnifierStyle, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = MagnifierKt$magnifier$1.INSTANCE;
        }
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        if ((i & 8) != 0) {
            magnifierStyle = MagnifierStyle.Companion.getDefault();
        }
        return magnifier(modifier, function1, function12, f, magnifierStyle);
    }

    public static final Modifier magnifier(Modifier modifier, Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, float f, MagnifierStyle magnifierStyle, PlatformMagnifierFactory platformMagnifierFactory) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "sourceCenter");
        Intrinsics.checkNotNullParameter(function12, "magnifierCenter");
        Intrinsics.checkNotNullParameter(magnifierStyle, "style");
        Intrinsics.checkNotNullParameter(platformMagnifierFactory, "platformMagnifierFactory");
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new MagnifierKt$magnifier$4(function1, function12, f, platformMagnifierFactory, magnifierStyle), 1, (Object) null);
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i);
    }

    @ExperimentalFoundationApi
    public static final Modifier magnifier(Modifier modifier, Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, float f, MagnifierStyle magnifierStyle) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "sourceCenter");
        Intrinsics.checkNotNullParameter(function12, "magnifierCenter");
        Intrinsics.checkNotNullParameter(magnifierStyle, "style");
        Function1<InspectorInfo, Unit> magnifierKt$magnifier$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new MagnifierKt$magnifier$$inlined$debugInspectorInfo$1(function1, function12, f, magnifierStyle) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier3 = Modifier.Companion;
        if (isPlatformMagnifierSupported$default(0, 1, (Object) null)) {
            modifier2 = magnifier(modifier3, function1, function12, f, magnifierStyle, PlatformMagnifierFactory.Companion.getForCurrentPlatform());
        } else {
            modifier2 = Modifier.Companion;
        }
        return InspectableValueKt.inspectableWrapper(modifier, magnifierKt$magnifier$$inlined$debugInspectorInfo$1, modifier2);
    }
}
