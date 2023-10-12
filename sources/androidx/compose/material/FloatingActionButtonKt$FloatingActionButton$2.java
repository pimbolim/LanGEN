package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
final class FloatingActionButtonKt$FloatingActionButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatingActionButtonKt$FloatingActionButton$2(long j, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$contentColor = j;
        this.$content = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C101@4655L392:FloatingActionButton.kt#jmzs0o");
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1598getAlphaimpl(this.$contentColor)))};
            final Function2<Composer, Integer, Unit> function2 = this.$content;
            final int i2 = this.$$dirty;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -819890951, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C102@4772L10,102@4741L296:FloatingActionButton.kt#jmzs0o");
                    if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer, 6).getButton();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final int i2 = i2;
                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer, -819891143, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                ComposerKt.sourceInformation(composer, "C103@4809L214:FloatingActionButton.kt#jmzs0o");
                                if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                                    Modifier r11 = SizeKt.m476defaultMinSizeVpY3zN4(Modifier.Companion, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                    Alignment center = Alignment.Companion.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    int i2 = i2;
                                    composer.startReplaceableGroup(-1990474327);
                                    ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r11);
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
                                    composer.startReplaceableGroup(638020740);
                                    ComposerKt.sourceInformation(composer, "C107@5012L9:FloatingActionButton.kt#jmzs0o");
                                    function2.invoke(composer, Integer.valueOf((i2 >> 21) & 14));
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
                        }), composer, 48);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
