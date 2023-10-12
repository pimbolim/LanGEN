package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ MutableState<Float> $bottomSheetHeight$delegate;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Modifier $swipeable;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1(BottomSheetScaffoldState bottomSheetScaffoldState, int i, int i2, long j, long j2, int i3, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, float f, Modifier modifier, MutableState<Float> mutableState, Shape shape, long j3, long j4, float f2, int i4, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33) {
        super(2);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$floatingActionButtonPosition = i;
        this.$$dirty = i2;
        this.$backgroundColor = j;
        this.$contentColor = j2;
        this.$$dirty2 = i3;
        this.$topBar = function2;
        this.$content = function3;
        this.$sheetPeekHeight = f;
        this.$swipeable = modifier;
        this.$bottomSheetHeight$delegate = mutableState;
        this.$sheetShape = shape;
        this.$sheetBackgroundColor = j3;
        this.$sheetContentColor = j4;
        this.$sheetElevation = f2;
        this.$$dirty1 = i4;
        this.$sheetContent = function32;
        this.$floatingActionButton = function22;
        this.$snackbarHost = function33;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C322@13696L1634:BottomSheetScaffold.kt#jmzs0o");
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            final long j = this.$backgroundColor;
            final long j2 = this.$contentColor;
            final int i2 = this.$$dirty2;
            final Function2<Composer, Integer, Unit> function2 = this.$topBar;
            final int i3 = this.$$dirty;
            final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
            final float f = this.$sheetPeekHeight;
            final Modifier modifier = this.$swipeable;
            final float f2 = this.$sheetPeekHeight;
            final MutableState<Float> mutableState = this.$bottomSheetHeight$delegate;
            final Shape shape = this.$sheetShape;
            final long j3 = this.$sheetBackgroundColor;
            long j4 = this.$sheetContentColor;
            float f3 = this.$sheetElevation;
            int i4 = this.$$dirty;
            final int i5 = i4;
            final float f4 = f3;
            final long j5 = j4;
            final int i6 = this.$$dirty1;
            final Function3<ColumnScope, Composer, Integer, Unit> function32 = this.$sheetContent;
            final Function2<Composer, Integer, Unit> function22 = this.$floatingActionButton;
            final int i7 = this.$$dirty;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function33 = this.$snackbarHost;
            final BottomSheetScaffoldState bottomSheetScaffoldState = this.$scaffoldState;
            final int i8 = this.$$dirty;
            BottomSheetScaffoldKt.m869BottomSheetScaffoldStackSlNgfk0(ComposableLambdaKt.composableLambda(composer2, -819899585, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Composer composer2 = composer;
                    ComposerKt.sourceInformation(composer2, "C324@13767L360:BottomSheetScaffold.kt#jmzs0o");
                    if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        long j = j;
                        long j2 = j2;
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final int i2 = i3;
                        Function3<PaddingValues, Composer, Integer, Unit> function3 = function3;
                        AnonymousClass1 r2 = r12;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        final float f = f;
                        final int i3 = i2;
                        AnonymousClass1 r12 = new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                ComposerKt.sourceInformation(composer, "C328@13925L180:BottomSheetScaffold.kt#jmzs0o");
                                if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    int i2 = i2;
                                    Function3<PaddingValues, Composer, Integer, Unit> function3 = function32;
                                    float f = f;
                                    int i3 = i3;
                                    composer.startReplaceableGroup(-1113030915);
                                    ComposerKt.sourceInformation(composer, "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
                                    composer.startReplaceableGroup(1376089394);
                                    ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
                                    ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    Density density = (Density) consume;
                                    ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    LayoutDirection layoutDirection = (LayoutDirection) consume2;
                                    ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxSize$default);
                                    if (!(composer.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer.startReusableNode();
                                    if (composer.getInserting()) {
                                        composer.createNode(constructor);
                                    } else {
                                        composer.useNode();
                                    }
                                    composer.disableReusing();
                                    Composer r8 = Updater.m1234constructorimpl(composer);
                                    Updater.m1241setimpl(r8, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m1241setimpl(r8, density, ComposeUiNode.Companion.getSetDensity());
                                    Updater.m1241setimpl(r8, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                                    Updater.m1241setimpl(r8, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer, 0);
                                    composer.startReplaceableGroup(2058660585);
                                    composer.startReplaceableGroup(276693625);
                                    ComposerKt.sourceInformation(composer, "C78@3948L9:Column.kt#2w3rfo");
                                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                    composer.startReplaceableGroup(-1579943837);
                                    ComposerKt.sourceInformation(composer, "C330@14031L48:BottomSheetScaffold.kt#jmzs0o");
                                    composer.startReplaceableGroup(-1579943829);
                                    ComposerKt.sourceInformation(composer, "329@13994L8");
                                    if (function2 != null) {
                                        function2.invoke(composer, Integer.valueOf((i2 >> 9) & 14));
                                    }
                                    composer.endReplaceableGroup();
                                    function3.invoke(PaddingKt.m428PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f, 7, (Object) null), composer, Integer.valueOf((i3 >> 3) & 112));
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    composer.endNode();
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        };
                        int i4 = i2;
                        SurfaceKt.m1125SurfaceFjzlyU((Modifier) null, (Shape) null, j, j2, (BorderStroke) null, 0.0f, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, -819900219, true, r2), composer, 1572864 | ((i4 << 6) & 896) | ((i4 << 6) & 7168), 51);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda(composer2, -819899921, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Composer composer2 = composer;
                    ComposerKt.sourceInformation(composer2, "C339@14405L108,335@14199L614:BottomSheetScaffold.kt#jmzs0o");
                    if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        Modifier r1 = SizeKt.m483requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), f2, 0.0f, 2, (Object) null);
                        MutableState<Float> mutableState = mutableState;
                        composer2.startReplaceableGroup(-3686930);
                        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
                        boolean changed = composer2.changed((Object) mutableState);
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1$2$1$1(mutableState);
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceableGroup();
                        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(r1, (Function1) rememberedValue);
                        Shape shape = shape;
                        long j = j3;
                        long j2 = j5;
                        float f = f4;
                        final Function3<ColumnScope, Composer, Integer, Unit> function3 = function32;
                        final int i2 = i5;
                        int i3 = i5;
                        int i4 = i6;
                        SurfaceKt.m1125SurfaceFjzlyU(onGloballyPositioned, shape, j, j2, (BorderStroke) null, f, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, -819896533, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                ComposerKt.sourceInformation(composer, "C346@14759L30:BottomSheetScaffold.kt#jmzs0o");
                                if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                                    Function3<ColumnScope, Composer, Integer, Unit> function3 = function3;
                                    int i2 = (i2 << 9) & 7168;
                                    composer.startReplaceableGroup(-1113030915);
                                    ComposerKt.sourceInformation(composer, "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo");
                                    int i3 = i2 >> 3;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, (i3 & 112) | (i3 & 14));
                                    composer.startReplaceableGroup(1376089394);
                                    ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
                                    ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    Density density = (Density) consume;
                                    ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    LayoutDirection layoutDirection = (LayoutDirection) consume2;
                                    ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
                                    int i4 = ((((i2 << 3) & 112) << 9) & 7168) | 6;
                                    if (!(composer.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer.startReusableNode();
                                    if (composer.getInserting()) {
                                        composer.createNode(constructor);
                                    } else {
                                        composer.useNode();
                                    }
                                    composer.disableReusing();
                                    Composer r6 = Updater.m1234constructorimpl(composer);
                                    Updater.m1241setimpl(r6, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m1241setimpl(r6, density, ComposeUiNode.Companion.getSetDensity());
                                    Updater.m1241setimpl(r6, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                                    Updater.m1241setimpl(r6, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer, Integer.valueOf((i4 >> 3) & 112));
                                    composer.startReplaceableGroup(2058660585);
                                    composer.startReplaceableGroup(276693625);
                                    ComposerKt.sourceInformation(composer, "C78@3948L9:Column.kt#2w3rfo");
                                    if (((((i4 >> 9) & 14) & 11) ^ 2) != 0 || !composer.getSkipping()) {
                                        function3.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i2 >> 6) & 112) | 6));
                                    } else {
                                        composer.skipToGroupEnd();
                                    }
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    composer.endNode();
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 1572864 | ((i3 >> 21) & 112) | ((i4 << 6) & 896) | ((i4 << 6) & 7168) | ((i3 >> 12) & Opcodes.ASM7), 16);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda(composer2, -819897194, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C350@14894L82:BottomSheetScaffold.kt#jmzs0o");
                    if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        Function2<Composer, Integer, Unit> function2 = function22;
                        int i2 = i7;
                        composer.startReplaceableGroup(-1990474327);
                        ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                        composer.startReplaceableGroup(1376089394);
                        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
                        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        Density density = (Density) consume;
                        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        LayoutDirection layoutDirection = (LayoutDirection) consume2;
                        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor);
                        } else {
                            composer.useNode();
                        }
                        composer.disableReusing();
                        Composer r6 = Updater.m1234constructorimpl(composer);
                        Updater.m1241setimpl(r6, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m1241setimpl(r6, density, ComposeUiNode.Companion.getSetDensity());
                        Updater.m1241setimpl(r6, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                        Updater.m1241setimpl(r6, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer, 0);
                        composer.startReplaceableGroup(2058660585);
                        composer.startReplaceableGroup(-1253629305);
                        ComposerKt.sourceInformation(composer, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        composer.startReplaceableGroup(2068277740);
                        ComposerKt.sourceInformation(composer, "C351@14946L8:BottomSheetScaffold.kt#jmzs0o");
                        if (function2 != null) {
                            function2.invoke(composer, Integer.valueOf((i2 >> 15) & 14));
                        }
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda(composer2, -819897283, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C355@15049L97:BottomSheetScaffold.kt#jmzs0o");
                    if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        Function3<SnackbarHostState, Composer, Integer, Unit> function3 = function33;
                        BottomSheetScaffoldState bottomSheetScaffoldState = bottomSheetScaffoldState;
                        int i2 = i8;
                        composer.startReplaceableGroup(-1990474327);
                        ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                        composer.startReplaceableGroup(1376089394);
                        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
                        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        Density density = (Density) consume;
                        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        LayoutDirection layoutDirection = (LayoutDirection) consume2;
                        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor);
                        } else {
                            composer.useNode();
                        }
                        composer.disableReusing();
                        Composer r7 = Updater.m1234constructorimpl(composer);
                        Updater.m1241setimpl(r7, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m1241setimpl(r7, density, ComposeUiNode.Companion.getSetDensity());
                        Updater.m1241setimpl(r7, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                        Updater.m1241setimpl(r7, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer, 0);
                        composer.startReplaceableGroup(2058660585);
                        composer.startReplaceableGroup(-1253629305);
                        ComposerKt.sourceInformation(composer, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        composer.startReplaceableGroup(2068277895);
                        ComposerKt.sourceInformation(composer, "C356@15079L45:BottomSheetScaffold.kt#jmzs0o");
                        function3.invoke(bottomSheetScaffoldState.getSnackbarHostState(), composer, Integer.valueOf((i2 >> 9) & 112));
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), this.$scaffoldState.getBottomSheetState().getOffset(), this.$floatingActionButtonPosition, composer, (458752 & (this.$$dirty >> 3)) | 3510);
            return;
        }
        composer.skipToGroupEnd();
    }
}
