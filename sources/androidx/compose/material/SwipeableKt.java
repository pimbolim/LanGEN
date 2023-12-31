package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.InspectableValueKt;
import com.braintreepayments.api.models.PostalAddressParser;
import com.brentvatne.react.ReactVideoView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002\u001aZ\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00182#\b\u0002\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u001aH\u0007¢\u0006\u0002\u0010\u001f\u001aI\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00152\u0006\u0010!\u001a\u0002H\u00022\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020#0\u001a2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018H\u0001¢\u0006\u0002\u0010$\u001a-\u0010%\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00020&2\u0006\u0010'\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010(\u001a¹\u0001\u0010)\u001a\u00020*\"\u0004\b\u0000\u0010\u0002*\u00020*2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00020&2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u001e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010028\b\u0002\u0010\u000e\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002030\u000f2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\b\b\u0002\u0010\u0011\u001a\u000206H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108\"*\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"PreUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "T", "Landroidx/compose/material/SwipeableState;", "getPreUpPostDownNestedScrollConnection$annotations", "(Landroidx/compose/material/SwipeableState;)V", "getPreUpPostDownNestedScrollConnection", "(Landroidx/compose/material/SwipeableState;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "computeTarget", "", "offset", "lastValue", "anchors", "", "thresholds", "Lkotlin/Function2;", "velocity", "velocityThreshold", "findBounds", "", "rememberSwipeableState", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "rememberSwipeableStateFor", "value", "onValueChange", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "getOffset", "", "state", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", "swipeable", "Landroidx/compose/ui/Modifier;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "from", "to", "Landroidx/compose/material/ThresholdConfig;", "resistance", "Landroidx/compose/material/ResistanceConfig;", "Landroidx/compose/ui/unit/Dp;", "swipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Swipeable.kt */
public final class SwipeableKt {
    @ExperimentalMaterialApi
    public static /* synthetic */ void getPreUpPostDownNestedScrollConnection$annotations(SwipeableState swipeableState) {
    }

    @ExperimentalMaterialApi
    public static final <T> SwipeableState<T> rememberSwipeableState(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "initialValue");
        composer.startReplaceableGroup(1095461734);
        ComposerKt.sourceInformation(composer, "C(rememberSwipeableState)P(2)472@19144L344:Swipeable.kt#jmzs0o");
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1 function12 = function1;
        if ((i2 & 4) != 0) {
            function12 = SwipeableKt$rememberSwipeableState$1.INSTANCE;
        }
        SwipeableState<T> swipeableState = (SwipeableState) RememberSaveableKt.rememberSaveable(new Object[0], SwipeableState.Companion.Saver(animationSpec2, function12), (String) null, new SwipeableKt$rememberSwipeableState$2(t, animationSpec2, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return swipeableState;
    }

    @ExperimentalMaterialApi
    public static final <T> SwipeableState<T> rememberSwipeableStateFor(T t, Function1<? super T, Unit> function1, AnimationSpec<Float> animationSpec, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        composer.startReplaceableGroup(1177155487);
        ComposerKt.sourceInformation(composer, "C(rememberSwipeableStateFor)P(2,1)501@20311L169,508@20511L34,509@20550L162,514@20717L259:Swipeable.kt#jmzs0o");
        if ((i2 & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SwipeableState(t, animationSpec, SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1.INSTANCE);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SwipeableState<T> swipeableState = (SwipeableState) rememberedValue;
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue2;
        int i3 = i & 8;
        EffectsKt.LaunchedEffect(t, mutableState.getValue(), new SwipeableKt$rememberSwipeableStateFor$1(t, swipeableState, (Continuation<? super SwipeableKt$rememberSwipeableStateFor$1>) null), composer, (i & 14) | i3);
        EffectsKt.DisposableEffect((Object) swipeableState.getCurrentValue(), (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new SwipeableKt$rememberSwipeableStateFor$2(t, swipeableState, function1, mutableState), composer, i3);
        composer.endReplaceableGroup();
        return swipeableState;
    }

    /* renamed from: swipeable-pPrIpRY$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1130swipeablepPrIpRY$default(Modifier modifier, SwipeableState swipeableState, Map map, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, Function2 function2, ResistanceConfig resistanceConfig, float f, int i, Object obj) {
        int i2 = i;
        return m1129swipeablepPrIpRY(modifier, swipeableState, map, orientation, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? null : mutableInteractionSource, (i2 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : function2, (i2 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map.keySet(), 0.0f, 0.0f, 6, (Object) null) : resistanceConfig, (i2 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1128getVelocityThresholdD9Ej5fM() : f);
    }

    /* access modifiers changed from: private */
    public static final List<Float> findBounds(float f, Set<Float> set) {
        Iterable iterable = set;
        Collection arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((double) ((Number) next).floatValue()) > ((double) f) + 0.001d) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        Float maxOrNull = CollectionsKt.maxOrNull((List) arrayList);
        Collection arrayList2 = new ArrayList();
        for (Object next2 : iterable) {
            if (((double) ((Number) next2).floatValue()) >= ((double) f) - 0.001d) {
                arrayList2.add(next2);
            }
        }
        Float minOrNull = CollectionsKt.minOrNull((List) arrayList2);
        if (maxOrNull == null) {
            return CollectionsKt.listOfNotNull(minOrNull);
        }
        if (minOrNull == null) {
            return CollectionsKt.listOf(maxOrNull);
        }
        if (Intrinsics.areEqual(maxOrNull, minOrNull)) {
            return CollectionsKt.listOf(maxOrNull);
        }
        return CollectionsKt.listOf(maxOrNull, minOrNull);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
        if (r3 < r6.invoke(java.lang.Float.valueOf(r0), java.lang.Float.valueOf(r5)).floatValue()) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (r3 > r6.invoke(java.lang.Float.valueOf(r5), java.lang.Float.valueOf(r0)).floatValue()) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final float computeTarget(float r3, float r4, java.util.Set<java.lang.Float> r5, kotlin.jvm.functions.Function2<? super java.lang.Float, ? super java.lang.Float, java.lang.Float> r6, float r7, float r8) {
        /*
            java.util.List r5 = findBounds(r3, r5)
            int r0 = r5.size()
            if (r0 == 0) goto L_0x006c
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0062
            java.lang.Object r0 = r5.get(r1)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Object r5 = r5.get(r2)
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 > 0) goto L_0x0042
            int r4 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x002b
            return r5
        L_0x002b:
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
            java.lang.Float r7 = java.lang.Float.valueOf(r5)
            java.lang.Object r4 = r6.invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x005e
            goto L_0x0060
        L_0x0042:
            float r4 = -r8
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x0048
            return r0
        L_0x0048:
            java.lang.Float r4 = java.lang.Float.valueOf(r5)
            java.lang.Float r7 = java.lang.Float.valueOf(r0)
            java.lang.Object r4 = r6.invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0060
        L_0x005e:
            r4 = r5
            goto L_0x006c
        L_0x0060:
            r4 = r0
            goto L_0x006c
        L_0x0062:
            java.lang.Object r3 = r5.get(r1)
            java.lang.Number r3 = (java.lang.Number) r3
            float r4 = r3.floatValue()
        L_0x006c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableKt.computeTarget(float, float, java.util.Set, kotlin.jvm.functions.Function2, float, float):float");
    }

    /* access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> map, T t) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Map.Entry) obj).getValue(), (Object) t)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return null;
        }
        return (Float) entry.getKey();
    }

    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(SwipeableState<T> swipeableState) {
        Intrinsics.checkNotNullParameter(swipeableState, "<this>");
        return new SwipeableKt$PreUpPostDownNestedScrollConnection$1(swipeableState);
    }

    @ExperimentalMaterialApi
    /* renamed from: swipeable-pPrIpRY  reason: not valid java name */
    public static final <T> Modifier m1129swipeablepPrIpRY(Modifier modifier, SwipeableState<T> swipeableState, Map<Float, ? extends T> map, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, Function2<? super T, ? super T, ? extends ThresholdConfig> function2, ResistanceConfig resistanceConfig, float f) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "$this$swipeable");
        Intrinsics.checkNotNullParameter(swipeableState, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(map, "anchors");
        Intrinsics.checkNotNullParameter(orientation, ReactVideoView.EVENT_PROP_ORIENTATION);
        Intrinsics.checkNotNullParameter(function2, "thresholds");
        return ComposedModifierKt.composed(modifier2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SwipeableKt$swipeablepPrIpRY$$inlined$debugInspectorInfo$1(swipeableState, map, orientation, z, z2, mutableInteractionSource, function2, resistanceConfig, f) : InspectableValueKt.getNoInspectorInfo(), new SwipeableKt$swipeable$3(map, swipeableState, orientation, z, mutableInteractionSource, z2, resistanceConfig, function2, f));
    }
}
