package com.stripe.android.link.ui.signup;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
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
import com.stripe.android.link.theme.ThemeKt;
import com.stripe.android.link.ui.signup.SignUpViewModel;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.SectionController;
import com.stripe.android.ui.core.elements.SectionElement;
import com.stripe.android.ui.core.elements.SectionElementUIKt;
import com.stripe.android.ui.core.elements.SectionFieldElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006\u001a!\u0010\u0007\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0001¢\u0006\u0002\u0010\u0010\u001a9\u0010\f\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"EmailCollectionSection", "", "emailElement", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "signUpState", "Lcom/stripe/android/link/ui/signup/SignUpState;", "(Lcom/stripe/android/ui/core/elements/SectionFieldElement;Lcom/stripe/android/link/ui/signup/SignUpState;Landroidx/compose/runtime/Composer;I)V", "PhoneCollectionSection", "onSignUpClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SignUpBody", "injector", "Lcom/stripe/android/link/injection/NonFallbackInjector;", "email", "(Lcom/stripe/android/link/injection/NonFallbackInjector;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "merchantName", "(Ljava/lang/String;Lcom/stripe/android/ui/core/elements/SectionFieldElement;Lcom/stripe/android/link/ui/signup/SignUpState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SignUpBodyPreview", "(Landroidx/compose/runtime/Composer;I)V", "link_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SignUpScreen.kt */
public final class SignUpScreenKt {
    /* access modifiers changed from: private */
    public static final void SignUpBodyPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1307137777);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.DefaultLinkTheme(false, ComposableSingletons$SignUpScreenKt.INSTANCE.m4338getLambda1$link_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SignUpScreenKt$SignUpBodyPreview$1(i));
        }
    }

    public static final void SignUpBody(NonFallbackInjector nonFallbackInjector, String str, Composer composer, int i) {
        int i2;
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(nonFallbackInjector, "injector");
        Composer startRestartGroup = composer.startRestartGroup(-1702343502);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) nonFallbackInjector) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) str) ? 32 : 16;
        }
        if (((i2 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            ViewModelProvider.Factory factory = new SignUpViewModel.Factory(nonFallbackInjector, str);
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
                ViewModel viewModel = ViewModelKt.viewModel(SignUpViewModel.class, current, (String) null, factory, creationExtras, startRestartGroup, 36936, 0);
                startRestartGroup.endReplaceableGroup();
                SignUpViewModel signUpViewModel = (SignUpViewModel) viewModel;
                SignUpBody(signUpViewModel.getMerchantName(), signUpViewModel.getEmailElement(), m4342SignUpBody$lambda0(SnapshotStateKt.collectAsState(signUpViewModel.getSignUpState(), SignUpState.InputtingEmail, (CoroutineContext) null, startRestartGroup, 56, 2)), new SignUpScreenKt$SignUpBody$1(signUpViewModel), startRestartGroup, 64);
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SignUpScreenKt$SignUpBody$2(nonFallbackInjector, str, i));
        }
    }

    public static final void SignUpBody(String str, SectionFieldElement sectionFieldElement, SignUpState signUpState, Function1<? super String, Unit> function1, Composer composer, int i) {
        String str2 = str;
        SectionFieldElement sectionFieldElement2 = sectionFieldElement;
        SignUpState signUpState2 = signUpState;
        Function1<? super String, Unit> function12 = function1;
        int i2 = i;
        Intrinsics.checkNotNullParameter(str2, "merchantName");
        Intrinsics.checkNotNullParameter(sectionFieldElement2, "emailElement");
        Intrinsics.checkNotNullParameter(signUpState2, "signUpState");
        Intrinsics.checkNotNullParameter(function12, "onSignUpClick");
        Composer startRestartGroup = composer.startRestartGroup(-1702342935);
        startRestartGroup.startReplaceableGroup(-1702342780);
        if (signUpState2 == SignUpState.VerifyingEmail) {
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FocusManager.DefaultImpls.clearFocus$default((FocusManager) consume, false, 1, (Object) null);
        }
        startRestartGroup.endReplaceableGroup();
        Modifier r6 = PaddingKt.m433paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m3859constructorimpl((float) 20), 1, (Object) null);
        Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
        startRestartGroup.startReplaceableGroup(-1113030915);
        ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
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
        Composer r8 = Updater.m1234constructorimpl(startRestartGroup);
        Updater.m1241setimpl(r8, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r8, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r8, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r8, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(276693625);
        ComposerKt.sourceInformation(startRestartGroup, "C78@3948L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        float f = (float) 4;
        Composer composer2 = startRestartGroup;
        TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(R.string.sign_up_header, startRestartGroup, 0), PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m3859constructorimpl(f), 1, (Object) null), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m911getOnPrimary0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m3749boximpl(TextAlign.Companion.m3756getCentere0LSkKk()), 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getH2(), composer2, 48, 0, 32248);
        TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(R.string.sign_up_message, new Object[]{str2}, startRestartGroup, 64), PaddingKt.m435paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m3859constructorimpl(f), 0.0f, Dp.m3859constructorimpl((float) 30), 5, (Object) null), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m912getOnSecondary0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m3749boximpl(TextAlign.Companion.m3756getCentere0LSkKk()), 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody1(), composer2, 48, 0, 32248);
        EmailCollectionSection(sectionFieldElement2, signUpState2, startRestartGroup, ((i2 >> 3) & 112) | 8);
        AnimatedVisibilityKt.AnimatedVisibility(columnScope, signUpState2 == SignUpState.InputtingPhone, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819890265, true, new SignUpScreenKt$SignUpBody$3$1(function12, i2)), startRestartGroup, 1572870, 30);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SignUpScreenKt$SignUpBody$4(str, sectionFieldElement, signUpState, function1, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void EmailCollectionSection(SectionFieldElement sectionFieldElement, SignUpState signUpState, Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1828856540);
        float f = (float) 0;
        Modifier r0 = PaddingKt.m431padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m3859constructorimpl(f));
        Alignment centerEnd = Alignment.Companion.getCenterEnd();
        startRestartGroup.startReplaceableGroup(-1990474327);
        ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(centerEnd, false, startRestartGroup, 6);
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
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r0);
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
        Composer r4 = Updater.m1234constructorimpl(startRestartGroup);
        Updater.m1241setimpl(r4, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r4, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r4, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r4, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1253629305);
        ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        SectionElementUIKt.SectionElementUI(signUpState != SignUpState.VerifyingEmail, new SectionElement((IdentifierSpec) new IdentifierSpec.Generic("email"), (List<? extends SectionFieldElement>) CollectionsKt.listOf(sectionFieldElement), new SectionController((Integer) null, CollectionsKt.listOf(sectionFieldElement.sectionFieldErrorController()))), CollectionsKt.emptyList(), sectionFieldElement.getIdentifier(), startRestartGroup, (SectionElement.$stable << 3) | (IdentifierSpec.$stable << 9));
        if (signUpState == SignUpState.VerifyingEmail) {
            float f2 = (float) 8;
            ProgressIndicatorKt.m1067CircularProgressIndicatoraMcp0Q(SemanticsModifierKt.semantics$default(PaddingKt.m434paddingqDBjuR0(SizeKt.m492size3ABfNKs(Modifier.Companion, Dp.m3859constructorimpl((float) 32)), Dp.m3859constructorimpl(f), Dp.m3859constructorimpl(f2), Dp.m3859constructorimpl((float) 16), Dp.m3859constructorimpl(f2)), false, SignUpScreenKt$EmailCollectionSection$1$1.INSTANCE, 1, (Object) null), 0, Dp.m3859constructorimpl((float) 2), startRestartGroup, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 2);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SignUpScreenKt$EmailCollectionSection$2(sectionFieldElement, signUpState, i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void PhoneCollectionSection(kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30) {
        /*
            r0 = r28
            r1 = r30
            r2 = -1822095031(0xffffffff93650949, float:-2.8908442E-27)
            r3 = r29
            androidx.compose.runtime.Composer r2 = r3.startRestartGroup(r2)
            r3 = r1 & 14
            r4 = 2
            if (r3 != 0) goto L_0x001d
            boolean r3 = r2.changed((java.lang.Object) r0)
            if (r3 == 0) goto L_0x001a
            r3 = 4
            goto L_0x001b
        L_0x001a:
            r3 = 2
        L_0x001b:
            r3 = r3 | r1
            goto L_0x001e
        L_0x001d:
            r3 = r1
        L_0x001e:
            r3 = r3 & 11
            r3 = r3 ^ r4
            if (r3 != 0) goto L_0x002f
            boolean r3 = r2.getSkipping()
            if (r3 != 0) goto L_0x002a
            goto L_0x002f
        L_0x002a:
            r2.skipToGroupEnd()
            goto L_0x022d
        L_0x002f:
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            java.lang.Object r3 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            r9 = 0
            if (r3 != r5) goto L_0x0050
            java.lang.String r3 = ""
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r9, r4, r9)
            r2.updateRememberedValue(r3)
        L_0x0050:
            r2.endReplaceableGroup()
            r15 = r3
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            androidx.compose.ui.platform.LocalSoftwareKeyboardController r3 = androidx.compose.ui.platform.LocalSoftwareKeyboardController.INSTANCE
            r14 = 8
            androidx.compose.ui.platform.SoftwareKeyboardController r12 = r3.getCurrent(r2, r14)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r10 = 0
            r11 = 1
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r3, r10, r11, r9)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r4 = r4.getCenterHorizontally()
            r5 = -1113030915(0xffffffffbda87efd, float:-0.08227346)
            r2.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r5 = r5.getTop()
            r6 = 48
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r5, r4, r2, r6)
            r5 = 1376089394(0x52057532, float:1.43299215E11)
            r2.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r6, r7)
            java.lang.Object r5 = r2.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r6, r7)
            java.lang.Object r8 = r2.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r6, r7)
            java.lang.Object r6 = r2.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r13 = r2.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x00e0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00e0:
            r2.startReusableNode()
            boolean r13 = r2.getInserting()
            if (r13 == 0) goto L_0x00ed
            r2.createNode(r7)
            goto L_0x00f0
        L_0x00ed:
            r2.useNode()
        L_0x00f0:
            r2.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m1234constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r7, r4, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r7, r5, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r7, r8, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r7, r6, r4)
            r2.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r4)
            r13 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r13)
            r3.invoke(r4, r2, r5)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r3)
            r3 = 276693625(0x107e0279, float:5.0094572E-29)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = "C78@3948L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            androidx.compose.foundation.layout.ColumnScopeInstance r3 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r3 = (androidx.compose.foundation.layout.ColumnScope) r3
            r3 = 0
            r4 = 0
            r5 = -819888449(0xffffffffcf217ebf, float:-2.70943821E9)
            com.stripe.android.link.ui.signup.SignUpScreenKt$PhoneCollectionSection$1$1 r6 = new com.stripe.android.link.ui.signup.SignUpScreenKt$PhoneCollectionSection$1$1
            r6.<init>(r15)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r5, r11, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r7 = 384(0x180, float:5.38E-43)
            r8 = 3
            r6 = r2
            com.stripe.android.ui.core.elements.SectionUIKt.SectionCard(r3, r4, r5, r6, r7, r8)
            int r3 = com.stripe.android.link.R.string.sign_up_terms
            java.lang.String r3 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r3, r2, r13)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r4, r10, r11, r9)
            r5 = 16
            float r5 = (float) r5
            float r6 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r5)
            float r7 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r5)
            float r5 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r5)
            r8 = 24
            float r8 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r8)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.PaddingKt.m434paddingqDBjuR0(r4, r6, r7, r5, r8)
            r5 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r16 = 0
            r27 = r12
            r12 = r16
            r16 = 0
            r5 = 8
            r14 = r16
            androidx.compose.ui.text.style.TextAlign$Companion r6 = androidx.compose.ui.text.style.TextAlign.Companion
            int r6 = r6.m3756getCentere0LSkKk()
            androidx.compose.ui.text.style.TextAlign r6 = androidx.compose.ui.text.style.TextAlign.m3749boximpl(r6)
            r29 = r15
            r15 = r6
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r5 = r6.getTypography(r2, r5)
            androidx.compose.ui.text.TextStyle r22 = r5.getCaption()
            r24 = 48
            r25 = 0
            r26 = 32252(0x7dfc, float:4.5195E-41)
            r23 = r2
            r5 = 0
            androidx.compose.material.TextKt.m1189TextfLXpl1I(r3, r4, r5, r7, r9, r10, r11, r12, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r3 = com.stripe.android.link.R.string.sign_up
            r4 = 0
            java.lang.String r3 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r3, r2, r4)
            java.lang.String r4 = m4340PhoneCollectionSection$lambda4(r29)
            int r4 = r4.length()
            r5 = 10
            if (r4 != r5) goto L_0x01d9
            com.stripe.android.link.ui.PrimaryButtonState r4 = com.stripe.android.link.ui.PrimaryButtonState.Enabled
            goto L_0x01db
        L_0x01d9:
            com.stripe.android.link.ui.PrimaryButtonState r4 = com.stripe.android.link.ui.PrimaryButtonState.Disabled
        L_0x01db:
            r5 = 0
            r6 = -3686095(0xffffffffffc7c131, float:NaN)
            r2.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r6)
            boolean r6 = r2.changed((java.lang.Object) r0)
            r7 = r29
            boolean r8 = r2.changed((java.lang.Object) r7)
            r6 = r6 | r8
            r8 = r27
            boolean r9 = r2.changed((java.lang.Object) r8)
            r6 = r6 | r9
            java.lang.Object r9 = r2.rememberedValue()
            if (r6 != 0) goto L_0x0207
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r9 != r6) goto L_0x0212
        L_0x0207:
            com.stripe.android.link.ui.signup.SignUpScreenKt$PhoneCollectionSection$1$2$1 r6 = new com.stripe.android.link.ui.signup.SignUpScreenKt$PhoneCollectionSection$1$2$1
            r6.<init>(r0, r8, r7)
            r9 = r6
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r2.updateRememberedValue(r9)
        L_0x0212:
            r2.endReplaceableGroup()
            r6 = r9
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r8 = 0
            r9 = 4
            r7 = r2
            com.stripe.android.link.ui.PrimaryButtonKt.PrimaryButton(r3, r4, r5, r6, r7, r8, r9)
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
        L_0x022d:
            androidx.compose.runtime.ScopeUpdateScope r2 = r2.endRestartGroup()
            if (r2 != 0) goto L_0x0234
            goto L_0x023e
        L_0x0234:
            com.stripe.android.link.ui.signup.SignUpScreenKt$PhoneCollectionSection$2 r3 = new com.stripe.android.link.ui.signup.SignUpScreenKt$PhoneCollectionSection$2
            r3.<init>(r0, r1)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r2.updateScope(r3)
        L_0x023e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.ui.signup.SignUpScreenKt.PhoneCollectionSection(kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: PhoneCollectionSection$lambda-4  reason: not valid java name */
    public static final String m4340PhoneCollectionSection$lambda4(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    /* renamed from: SignUpBody$lambda-0  reason: not valid java name */
    private static final SignUpState m4342SignUpBody$lambda0(State<? extends SignUpState> state) {
        return (SignUpState) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: PhoneCollectionSection$lambda-5  reason: not valid java name */
    public static final void m4341PhoneCollectionSection$lambda5(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }
}
