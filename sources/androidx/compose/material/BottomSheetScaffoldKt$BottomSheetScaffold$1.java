package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ boolean $drawerGesturesEnabled;
    final /* synthetic */ long $drawerScrimColor;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$1(BottomSheetScaffoldState bottomSheetScaffoldState, boolean z, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, boolean z2, Shape shape, float f, long j, long j2, long j3, int i, float f2, CoroutineScope coroutineScope, int i2, int i3, long j4, long j5, int i4, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32, Shape shape2, long j6, long j7, float f3, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34) {
        super(3);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$sheetGesturesEnabled = z;
        this.$drawerContent = function3;
        this.$drawerGesturesEnabled = z2;
        this.$drawerShape = shape;
        this.$drawerElevation = f;
        this.$drawerBackgroundColor = j;
        this.$drawerContentColor = j2;
        this.$drawerScrimColor = j3;
        this.$$dirty1 = i;
        this.$sheetPeekHeight = f2;
        this.$scope = coroutineScope;
        this.$floatingActionButtonPosition = i2;
        this.$$dirty = i3;
        this.$backgroundColor = j4;
        this.$contentColor = j5;
        this.$$dirty2 = i4;
        this.$topBar = function2;
        this.$content = function32;
        this.$sheetShape = shape2;
        this.$sheetBackgroundColor = j6;
        this.$sheetContentColor = j7;
        this.$sheetElevation = f3;
        this.$sheetContent = function33;
        this.$floatingActionButton = function22;
        this.$snackbarHost = function34;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        int i2;
        BoxWithConstraintsScope boxWithConstraintsScope2 = boxWithConstraintsScope;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope2, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer2, "C*286@12153L7,287@12222L39:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = i | (composer2.changed((Object) boxWithConstraintsScope2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (((i2 & 91) ^ 18) != 0 || !composer.getSkipping()) {
            float r1 = (float) Constraints.m3802getMaxHeightimpl(boxWithConstraintsScope.m390getConstraintsmsEJaDk());
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            float r2 = ((Density) consume).m3828toPx0680j_4(this.$sheetPeekHeight);
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(r1), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            Function2 composableLambda = ComposableLambdaKt.composableLambda(composer2, -819899396, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1(this.$scaffoldState, this.$floatingActionButtonPosition, this.$$dirty, this.$backgroundColor, this.$contentColor, this.$$dirty2, this.$topBar, this.$content, this.$sheetPeekHeight, SemanticsModifierKt.semantics$default(SwipeableKt.m1130swipeablepPrIpRY$default(NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, this.$scaffoldState.getBottomSheetState().getNestedScrollConnection$material_release(), (NestedScrollDispatcher) null, 2, (Object) null), this.$scaffoldState.getBottomSheetState(), MapsKt.mapOf(TuplesKt.to(Float.valueOf(r1 - r2), BottomSheetValue.Collapsed), TuplesKt.to(Float.valueOf(r1 - m873invoke$lambda2(mutableState)), BottomSheetValue.Expanded)), Orientation.Vertical, this.$sheetGesturesEnabled, false, (MutableInteractionSource) null, (Function2) null, (ResistanceConfig) null, 0.0f, 368, (Object) null), false, new BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1(r2, this.$scaffoldState, mutableState, this.$scope), 1, (Object) null), mutableState, this.$sheetShape, this.$sheetBackgroundColor, this.$sheetContentColor, this.$sheetElevation, this.$$dirty1, this.$sheetContent, this.$floatingActionButton, this.$snackbarHost));
            if (this.$drawerContent == null) {
                composer2.startReplaceableGroup(-249545651);
                ComposerKt.sourceInformation(composer2, "364@15390L7");
                composableLambda.invoke(composer2, 6);
                composer.endReplaceableGroup();
                return;
            }
            composer2.startReplaceableGroup(-249545614);
            ComposerKt.sourceInformation(composer2, "366@15427L480");
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$drawerContent;
            DrawerState drawerState = this.$scaffoldState.getDrawerState();
            boolean z = this.$drawerGesturesEnabled;
            Shape shape = this.$drawerShape;
            float f = this.$drawerElevation;
            long j = this.$drawerBackgroundColor;
            long j2 = this.$drawerContentColor;
            long j3 = this.$drawerScrimColor;
            int i3 = this.$$dirty1;
            DrawerKt.m963ModalDrawerGs3lGvM(function3, (Modifier) null, drawerState, z, shape, f, j, j2, j3, composableLambda, composer, ((i3 >> 3) & 7168) | ((i3 >> 9) & 14) | 805306368 | ((i3 >> 3) & 57344) | ((i3 >> 3) & Opcodes.ASM7) | ((i3 >> 3) & 3670016) | ((i3 >> 3) & 29360128) | ((i3 >> 3) & 234881024), 2);
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final float m873invoke$lambda2(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final void m874invoke$lambda3(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }
}
