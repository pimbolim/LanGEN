package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.IntSizeKt;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016J!\u0010\"\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\f\u0010&\u001a\u00020'*\u00020'H\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewResponder;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "reverseDirection", "", "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollableState;Z)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "parent", "value", "getValue", "()Landroidx/compose/foundation/gestures/BringIntoViewResponder;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeDestination", "source", "onGloballyPositioned", "coordinates", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "performBringIntoView", "destination", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toLocalRect", "reverseIfNeeded", "", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class BringIntoViewResponder implements ModifierLocalConsumer, ModifierLocalProvider<androidx.compose.foundation.relocation.BringIntoViewResponder>, androidx.compose.foundation.relocation.BringIntoViewResponder, OnGloballyPositionedModifier {
    private final ProvidableModifierLocal<androidx.compose.foundation.relocation.BringIntoViewResponder> key = androidx.compose.foundation.relocation.BringIntoViewResponder.Companion.getModifierLocalBringIntoViewResponder();
    /* access modifiers changed from: private */
    public LayoutCoordinates layoutCoordinates;
    private final Orientation orientation;
    /* access modifiers changed from: private */
    public androidx.compose.foundation.relocation.BringIntoViewResponder parent;
    private final boolean reverseDirection;
    private final ScrollableState scrollableState;
    private final BringIntoViewResponder value = this;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Scrollable.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BringIntoViewResponder(Orientation orientation2, ScrollableState scrollableState2, boolean z) {
        Intrinsics.checkNotNullParameter(orientation2, ReactVideoView.EVENT_PROP_ORIENTATION);
        Intrinsics.checkNotNullParameter(scrollableState2, "scrollableState");
        this.orientation = orientation2;
        this.scrollableState = scrollableState2;
        this.reverseDirection = z;
    }

    public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return ModifierLocalConsumer.DefaultImpls.all(this, function1);
    }

    public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return ModifierLocalConsumer.DefaultImpls.any(this, function1);
    }

    public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return ModifierLocalConsumer.DefaultImpls.foldIn(this, r, function2);
    }

    public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return ModifierLocalConsumer.DefaultImpls.foldOut(this, r, function2);
    }

    public Modifier then(Modifier modifier) {
        return ModifierLocalConsumer.DefaultImpls.then(this, modifier);
    }

    private final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * ((float) -1) : f;
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        this.parent = (androidx.compose.foundation.relocation.BringIntoViewResponder) modifierLocalReadScope.getCurrent(androidx.compose.foundation.relocation.BringIntoViewResponder.Companion.getModifierLocalBringIntoViewResponder());
    }

    public ProvidableModifierLocal<androidx.compose.foundation.relocation.BringIntoViewResponder> getKey() {
        return this.key;
    }

    public BringIntoViewResponder getValue() {
        return this.value;
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates2) {
        Intrinsics.checkNotNullParameter(layoutCoordinates2, "coordinates");
        this.layoutCoordinates = layoutCoordinates2;
    }

    public Object bringIntoView(Rect rect, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new BringIntoViewResponder$bringIntoView$2(this, rect, computeDestination(rect), (Continuation<? super BringIntoViewResponder$bringIntoView$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public Rect toLocalRect(Rect rect, LayoutCoordinates layoutCoordinates2) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(layoutCoordinates2, "layoutCoordinates");
        LayoutCoordinates layoutCoordinates3 = this.layoutCoordinates;
        if (layoutCoordinates3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutCoordinates");
            layoutCoordinates3 = null;
        }
        return rect.m1390translatek4lQ0M(layoutCoordinates3.localBoundingBoxOf(layoutCoordinates2, false).m1388getTopLeftF1C5BW0());
    }

    public final Rect computeDestination(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "source");
        LayoutCoordinates layoutCoordinates2 = this.layoutCoordinates;
        if (layoutCoordinates2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutCoordinates");
            layoutCoordinates2 = null;
        }
        long r0 = IntSizeKt.m4029toSizeozmzZPI(layoutCoordinates2.m3140getSizeYbymL2g());
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return rect.translate(0.0f, ScrollableKt.relocationDistance(rect.getTop(), rect.getBottom(), Size.m1419getHeightimpl(r0)));
        }
        if (i == 2) {
            return rect.translate(ScrollableKt.relocationDistance(rect.getLeft(), rect.getRight(), Size.m1422getWidthimpl(r0)), 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Object performBringIntoView(Rect rect, Rect rect2, Continuation<? super Unit> continuation) {
        float f;
        float f2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            f2 = rect.getTop();
            f = rect2.getTop();
        } else if (i == 2) {
            f2 = rect.getLeft();
            f = rect2.getLeft();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.scrollableState, reverseIfNeeded(f2 - f), (AnimationSpec) null, continuation, 2, (Object) null);
        return animateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
    }
}
