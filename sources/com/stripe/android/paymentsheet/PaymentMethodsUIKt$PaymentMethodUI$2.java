package com.stripe.android.paymentsheet;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.stripe.android.paymentsheet.ui.LpmSelectorTextKt;
import com.stripe.android.ui.core.PaymentsTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsUI.kt */
final class PaymentMethodsUIKt$PaymentMethodUI$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $iconRes;
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ boolean $tintOnSelected;
    final /* synthetic */ String $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsUIKt$PaymentMethodUI$2(boolean z, boolean z2, int i, int i2, String str, boolean z3) {
        super(2);
        this.$isSelected = z;
        this.$tintOnSelected = z2;
        this.$iconRes = i;
        this.$$dirty = i2;
        this.$title = str;
        this.$isEnabled = z3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        long j;
        Composer composer2 = composer;
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            boolean z = this.$isSelected;
            boolean z2 = this.$tintOnSelected;
            int i2 = this.$iconRes;
            int i3 = this.$$dirty;
            String str = this.$title;
            boolean z3 = this.$isEnabled;
            composer2.startReplaceableGroup(-1113030915);
            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            composer2.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
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
            Composer r9 = Updater.m1234constructorimpl(composer);
            Updater.m1241setimpl(r9, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r9, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r9, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r9, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(276693625);
            ComposerKt.sourceInformation(composer2, "C78@3948L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            if (z) {
                composer2.startReplaceableGroup(2067361184);
                j = PaymentsTheme.INSTANCE.getColors(composer2, 8).getMaterial().m914getPrimary0d7_KjU();
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(2067361230);
                j = PaymentsTheme.INSTANCE.getColors(composer2, 8).m4505getOnComponent0d7_KjU();
                composer.endReplaceableGroup();
            }
            long j2 = j;
            ColorFilter r7 = z2 ? ColorFilter.Companion.m1637tintxETnrds$default(ColorFilter.Companion, j2, 0, 2, (Object) null) : null;
            int i4 = i3 >> 3;
            ImageKt.Image(PainterResources_androidKt.painterResource(i2, composer2, i4 & 14), (String) null, PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, Dp.m3859constructorimpl(12.0f), Dp.m3859constructorimpl(12.0f), 0.0f, 0.0f, 12, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, r7, composer, 56, 56);
            Modifier modifier = Modifier.Companion;
            String str2 = str;
            long j3 = j2;
            LpmSelectorTextKt.m4444LpmSelectorText3IgeMak(str2, j3, PaddingKt.m435paddingqDBjuR0$default(modifier, Dp.m3859constructorimpl(12.0f), Dp.m3859constructorimpl((float) 6), 0.0f, 0.0f, 12, (Object) null), z3, composer, ((i3 >> 6) & 14) | (i4 & 7168));
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
