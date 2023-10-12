package com.stripe.android.link.ui.verification;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.stripe.android.link.R;
import com.stripe.android.link.injection.NonFallbackInjector;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.theme.ThemeKt;
import com.stripe.android.link.ui.verification.VerificationViewModel;
import com.stripe.android.ui.core.elements.SectionUIKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0001¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012\u001a!\u0010\u0013\u001a\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"VerificationBody", "", "linkAccount", "Lcom/stripe/android/link/model/LinkAccount;", "injector", "Lcom/stripe/android/link/injection/NonFallbackInjector;", "(Lcom/stripe/android/link/model/LinkAccount;Lcom/stripe/android/link/injection/NonFallbackInjector;Landroidx/compose/runtime/Composer;I)V", "redactedPhoneNumber", "", "email", "onCodeEntered", "Lkotlin/Function1;", "onBack", "Lkotlin/Function0;", "onChangeEmailClick", "onResendCodeClick", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "VerificationBodyPreview", "(Landroidx/compose/runtime/Composer;I)V", "VerificationCodeInput", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "link_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VerificationScreen.kt */
public final class VerificationScreenKt {
    /* access modifiers changed from: private */
    public static final void VerificationBodyPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1310270243);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.DefaultLinkTheme(false, ComposableSingletons$VerificationScreenKt.INSTANCE.m4345getLambda1$link_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new VerificationScreenKt$VerificationBodyPreview$1(i));
        }
    }

    public static final void VerificationBody(LinkAccount linkAccount, NonFallbackInjector nonFallbackInjector, Composer composer, int i) {
        int i2;
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(linkAccount, "linkAccount");
        Intrinsics.checkNotNullParameter(nonFallbackInjector, "injector");
        Composer startRestartGroup = composer.startRestartGroup(1291875732);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) linkAccount) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) nonFallbackInjector) ? 32 : 16;
        }
        if (((i2 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            ViewModelProvider.Factory factory = new VerificationViewModel.Factory(linkAccount, nonFallbackInjector);
            startRestartGroup.startReplaceableGroup(1729797275);
            ComposerKt.sourceInformation(startRestartGroup, "C(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
            if (current != null) {
                if (current instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
                } else {
                    creationExtras = CreationExtras.Empty.INSTANCE;
                }
                ViewModel viewModel = ViewModelKt.viewModel(VerificationViewModel.class, current, (String) null, factory, creationExtras, startRestartGroup, 36936, 0);
                startRestartGroup.endReplaceableGroup();
                VerificationViewModel verificationViewModel = (VerificationViewModel) viewModel;
                VerificationBody(verificationViewModel.getLinkAccount().getRedactedPhoneNumber(), verificationViewModel.getLinkAccount().getEmail(), new VerificationScreenKt$VerificationBody$1(verificationViewModel), new VerificationScreenKt$VerificationBody$2(verificationViewModel), new VerificationScreenKt$VerificationBody$3(verificationViewModel), new VerificationScreenKt$VerificationBody$4(verificationViewModel), startRestartGroup, 0);
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new VerificationScreenKt$VerificationBody$5(linkAccount, nonFallbackInjector, i));
        }
    }

    public static final void VerificationBody(String str, String str2, Function1<? super String, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Composer composer, int i) {
        int i2;
        Composer composer2;
        String str3 = str;
        String str4 = str2;
        Function1<? super String, Unit> function12 = function1;
        Function0<Unit> function04 = function0;
        Function0<Unit> function05 = function02;
        Function0<Unit> function06 = function03;
        int i3 = i;
        Intrinsics.checkNotNullParameter(str3, "redactedPhoneNumber");
        Intrinsics.checkNotNullParameter(str4, "email");
        Intrinsics.checkNotNullParameter(function12, "onCodeEntered");
        Intrinsics.checkNotNullParameter(function04, "onBack");
        Intrinsics.checkNotNullParameter(function05, "onChangeEmailClick");
        Intrinsics.checkNotNullParameter(function06, "onResendCodeClick");
        Composer startRestartGroup = composer.startRestartGroup(1291876377);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) str3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) str4) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function12) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) function04) ? 2048 : 1024;
        }
        if ((57344 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) function05) ? 16384 : 8192;
        }
        if ((458752 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) function06) ? 131072 : 65536;
        }
        int i4 = i2;
        if (((374491 & i4) ^ 74898) != 0 || !startRestartGroup.getSkipping()) {
            int i5 = i4 >> 6;
            BackHandlerKt.BackHandler(false, function04, startRestartGroup, i5 & 112, 1);
            Modifier r6 = PaddingKt.m433paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m3859constructorimpl((float) 20), 1, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            startRestartGroup.startReplaceableGroup(-1113030915);
            ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r6);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r11 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r11, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r11, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r11, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r11, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(276693625);
            ComposerKt.sourceInformation(startRestartGroup, "C78@3948L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            float f = (float) 4;
            Composer composer3 = startRestartGroup;
            TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(R.string.verification_header, startRestartGroup, 0), PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m3859constructorimpl(f), 1, (Object) null), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m911getOnPrimary0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m3749boximpl(TextAlign.Companion.m3756getCentere0LSkKk()), 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getH2(), composer3, 48, 0, 32248);
            float f2 = (float) 30;
            TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(R.string.verification_message, new Object[]{str3}, startRestartGroup, 64), PaddingKt.m435paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m3859constructorimpl(f), 0.0f, Dp.m3859constructorimpl(f2), 5, (Object) null), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m912getOnSecondary0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m3749boximpl(TextAlign.Companion.m3756getCentere0LSkKk()), 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody1(), composer3, 48, 0, 32248);
            VerificationCodeInput(function12, startRestartGroup, i5 & 14);
            Modifier r4 = PaddingKt.m435paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m3859constructorimpl((float) 22), 0.0f, Dp.m3859constructorimpl(f2), 5, (Object) null);
            startRestartGroup.startReplaceableGroup(-1989997165);
            ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getTop(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r4);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r9 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r9, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r9, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r9, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r9, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-326682362);
            ComposerKt.sourceInformation(startRestartGroup, "C79@3942L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(R.string.verification_not_email, new Object[]{str4}, startRestartGroup, 64), (Modifier) null, MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m912getOnSecondary0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), startRestartGroup, 0, 0, 32762);
            TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(R.string.verification_change_email, startRestartGroup, 0), ClickableKt.m180clickableXHw0xAI$default(PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, Dp.m3859constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, (Object) null), false, (String) null, (Role) null, function02, 7, (Object) null), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m912getOnSecondary0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2().merge(new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getUnderline(), (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 258047, (DefaultConstructorMarker) null)), startRestartGroup, 0, 0, 32760);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            ButtonKt.TextButton(function03, BorderKt.m167borderxT4_qwU(Modifier.Companion, Dp.m3859constructorimpl((float) 1), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, startRestartGroup, 8).m4335getDisabledText0d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getMedium()), false, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, ButtonDefaults.INSTANCE.m876buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m907getBackground0d7_KjU(), 0, 0, 0, startRestartGroup, 32768, 14), (PaddingValues) null, ComposableSingletons$VerificationScreenKt.INSTANCE.m4346getLambda2$link_release(), composer2, ((i4 >> 15) & 14) | 805306368, 380);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new VerificationScreenKt$VerificationBody$7(str, str2, function1, function0, function02, function03, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void VerificationCodeInput(Function1<? super String, Unit> function1, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1850988458);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (((i2 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            startRestartGroup.startReplaceableGroup(-1113030915);
            ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxWidth$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r7 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r7, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r7, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r7, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r7, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(276693625);
            ComposerKt.sourceInformation(startRestartGroup, "C78@3948L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            SectionUIKt.SectionCard((Modifier) null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -819892134, true, new VerificationScreenKt$VerificationCodeInput$1$1(mutableState, function1, i2)), startRestartGroup, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 3);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new VerificationScreenKt$VerificationCodeInput$2(function1, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: VerificationCodeInput$lambda-3  reason: not valid java name */
    public static final String m4348VerificationCodeInput$lambda3(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: VerificationCodeInput$lambda-4  reason: not valid java name */
    public static final void m4349VerificationCodeInput$lambda4(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }
}
