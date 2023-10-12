package com.stripe.android.link.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.stripe.android.link.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimaryButton.kt */
final class PrimaryButtonKt$PrimaryButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Integer $icon;
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ String $label;
    final /* synthetic */ Function0<Unit> $onButtonClick;
    final /* synthetic */ PrimaryButtonState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrimaryButtonKt$PrimaryButton$1(Function0<Unit> function0, boolean z, int i, Integer num, PrimaryButtonState primaryButtonState, String str) {
        super(2);
        this.$onButtonClick = function0;
        this.$isEnabled = z;
        this.$$dirty = i;
        this.$icon = num;
        this.$state = primaryButtonState;
        this.$label = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            float f = (float) 16;
            Modifier r1 = PaddingKt.m433paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m3859constructorimpl(f), 1, (Object) null);
            Alignment centerEnd = Alignment.Companion.getCenterEnd();
            Function0<Unit> function0 = this.$onButtonClick;
            boolean z = this.$isEnabled;
            int i2 = this.$$dirty;
            Integer num = this.$icon;
            PrimaryButtonState primaryButtonState = this.$state;
            String str = this.$label;
            composer2.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(centerEnd, false, composer2, 6);
            composer2.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
            Function0<Unit> function02 = function0;
            boolean z2 = z;
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r1);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r8 = Updater.m1234constructorimpl(composer);
            Updater.m1241setimpl(r8, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r8, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r8, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r8, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            PrimaryButtonState primaryButtonState2 = primaryButtonState;
            Integer num2 = num;
            String str2 = "C:CompositionLocal.kt#9igjgp";
            float f2 = f;
            int i3 = i2;
            int i4 = i3;
            int i5 = 805306416 | ((i3 >> 9) & 14);
            PrimaryButtonState primaryButtonState3 = primaryButtonState2;
            ButtonKt.TextButton(function02, SizeKt.m478height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m3859constructorimpl((float) 56)), z2, (MutableInteractionSource) null, (ButtonElevation) null, MaterialTheme.INSTANCE.getShapes(composer2, 8).getMedium(), (BorderStroke) null, ButtonDefaults.INSTANCE.m876buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColors(composer2, 8).m914getPrimary0d7_KjU(), 0, MaterialTheme.INSTANCE.getColors(composer2, 8).m914getPrimary0d7_KjU(), 0, composer, 32768, 10), (PaddingValues) null, ComposableLambdaKt.composableLambda(composer2, -819892693, true, new PrimaryButtonKt$PrimaryButton$1$1$1(primaryButtonState2, str, i3)), composer, i5, 344);
            if (!(num2 == null || primaryButtonState3 == PrimaryButtonState.Processing)) {
                Painter painterResource = PainterResources_androidKt.painterResource(num2.intValue(), composer2, (i4 >> 6) & 14);
                Modifier r3 = PaddingKt.m433paddingVpY3zN4$default(SizeKt.m497width3ABfNKs(SizeKt.m478height3ABfNKs(Modifier.Companion, Dp.m3859constructorimpl(f2)), Dp.m3859constructorimpl(Dp.m3859constructorimpl((float) 13) + Dp.m3859constructorimpl((float) 40))), ThemeKt.getHorizontalPadding(), 0.0f, 2, (Object) null);
                long r4 = ThemeKt.getLinkColors(MaterialTheme.INSTANCE, composer2, 8).m4331getButtonLabel0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str2);
                Object consume4 = composer2.consume(ContentAlphaKt.getLocalContentAlpha());
                ComposerKt.sourceInformationMarkerEnd(composer);
                IconKt.m1013Iconww6aTOc(painterResource, (String) null, r3, Color.m1595copywmQWz5c$default(r4, ((Number) consume4).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null), composer, 440, 0);
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
}
