package com.stripe.android.link.ui.wallet;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.RadioButtonDefaults;
import androidx.compose.material.RadioButtonKt;
import androidx.compose.material.TabRowDefaults;
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
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.stripe.android.link.R;
import com.stripe.android.link.injection.NonFallbackInjector;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.theme.ThemeKt;
import com.stripe.android.link.ui.wallet.WalletViewModel;
import com.stripe.android.model.ConsumerPaymentDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a+\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010\u0010\u001a[\u0010\u0011\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010\u001a\u001a\u001d\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\u0010 \u001a[\u0010\u001b\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\"\u001a\u00020#2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00172\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010&\u001a\r\u0010'\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"CardDetails", "", "card", "Lcom/stripe/android/model/ConsumerPaymentDetails$Card;", "(Lcom/stripe/android/model/ConsumerPaymentDetails$Card;Landroidx/compose/runtime/Composer;I)V", "CardPaymentMethodItem", "cardDetails", "isSelected", "", "onClick", "Lkotlin/Function0;", "(Lcom/stripe/android/model/ConsumerPaymentDetails$Card;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CollapsedPaymentDetails", "selectedPaymentMethod", "Lcom/stripe/android/model/ConsumerPaymentDetails$PaymentDetails;", "enabled", "(Lcom/stripe/android/model/ConsumerPaymentDetails$PaymentDetails;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ExpandedPaymentDetails", "paymentDetails", "", "selectedIndex", "", "onIndexSelected", "Lkotlin/Function1;", "onAddNewPaymentMethodClick", "onCollapse", "(Ljava/util/List;IZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "WalletBody", "linkAccount", "Lcom/stripe/android/link/model/LinkAccount;", "injector", "Lcom/stripe/android/link/injection/NonFallbackInjector;", "(Lcom/stripe/android/link/model/LinkAccount;Lcom/stripe/android/link/injection/NonFallbackInjector;Landroidx/compose/runtime/Composer;I)V", "isProcessing", "payButtonLabel", "", "onPayButtonClick", "onPayAnotherWayClick", "(ZLjava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "WalletBodyPreview", "(Landroidx/compose/runtime/Composer;I)V", "link_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
public final class WalletScreenKt {
    /* access modifiers changed from: private */
    public static final void WalletBodyPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-762942078);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.DefaultLinkTheme(false, ComposableSingletons$WalletScreenKt.INSTANCE.m4353getLambda2$link_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new WalletScreenKt$WalletBodyPreview$1(i));
        }
    }

    public static final void WalletBody(LinkAccount linkAccount, NonFallbackInjector nonFallbackInjector, Composer composer, int i) {
        int i2;
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(linkAccount, "linkAccount");
        Intrinsics.checkNotNullParameter(nonFallbackInjector, "injector");
        Composer startRestartGroup = composer.startRestartGroup(-1813703598);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) linkAccount) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) nonFallbackInjector) ? 32 : 16;
        }
        if (((i2 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            ViewModelProvider.Factory factory = new WalletViewModel.Factory(linkAccount, nonFallbackInjector);
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
                ViewModel viewModel = ViewModelKt.viewModel(WalletViewModel.class, current, (String) null, factory, creationExtras, startRestartGroup, 36936, 0);
                startRestartGroup.endReplaceableGroup();
                WalletViewModel walletViewModel = (WalletViewModel) viewModel;
                State<List<ConsumerPaymentDetails.PaymentDetails>> collectAsState = SnapshotStateKt.collectAsState(walletViewModel.getPaymentDetails(), (CoroutineContext) null, startRestartGroup, 8, 1);
                Boolean r2 = m4356WalletBody$lambda1(LiveDataAdapterKt.observeAsState(walletViewModel.isProcessing(), false, startRestartGroup, 56));
                List<ConsumerPaymentDetails.PaymentDetails> r3 = m4355WalletBody$lambda0(collectAsState);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Resources resources = ((Context) consume).getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "LocalContext.current.resources");
                String payButtonLabel = walletViewModel.payButtonLabel(resources);
                Intrinsics.checkNotNullExpressionValue(r2, "isProcessing");
                WalletBody(r2.booleanValue(), r3, payButtonLabel, new WalletScreenKt$WalletBody$3(walletViewModel), new WalletScreenKt$WalletBody$1(walletViewModel), new WalletScreenKt$WalletBody$2(walletViewModel), startRestartGroup, 64);
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new WalletScreenKt$WalletBody$4(linkAccount, nonFallbackInjector, i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void WalletBody(boolean r28, java.util.List<? extends com.stripe.android.model.ConsumerPaymentDetails.PaymentDetails> r29, java.lang.String r30, kotlin.jvm.functions.Function0<kotlin.Unit> r31, kotlin.jvm.functions.Function1<? super com.stripe.android.model.ConsumerPaymentDetails.PaymentDetails, kotlin.Unit> r32, kotlin.jvm.functions.Function0<kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35) {
        /*
            r8 = r29
            r9 = r32
            java.lang.String r0 = "paymentDetails"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "payButtonLabel"
            r10 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "onAddNewPaymentMethodClick"
            r11 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "onPayButtonClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "onPayAnotherWayClick"
            r15 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -1813702835(0xffffffff93e5174d, float:-5.7830703E-27)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$isWalletExpanded$2 r2 = com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$isWalletExpanded$2.INSTANCE
            r4 = r2
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r2 = 0
            r3 = 0
            r6 = 3080(0xc08, float:4.316E-42)
            r7 = 6
            r5 = r14
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r12 = r1
            androidx.compose.runtime.MutableState r12 = (androidx.compose.runtime.MutableState) r12
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r13 = 0
            r7 = 1
            r6 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r13, r7, r6)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r1, r13, r7, r6)
            r2 = 32
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r2)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m433paddingVpY3zN4$default(r1, r13, r2, r7, r6)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getCenterHorizontally()
            boolean r3 = r29.isEmpty()
            if (r3 == 0) goto L_0x0070
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r3 = r3.getCenter()
            androidx.compose.foundation.layout.Arrangement$Vertical r3 = (androidx.compose.foundation.layout.Arrangement.Vertical) r3
            goto L_0x0076
        L_0x0070:
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r3 = r3.getTop()
        L_0x0076:
            r4 = -1113030915(0xffffffffbda87efd, float:-0.08227346)
            r14.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            r4 = 48
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r3, r2, r14, r4)
            r3 = 1376089394(0x52057532, float:1.43299215E11)
            r14.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r5)
            java.lang.Object r3 = r14.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r6 = r16
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r5)
            java.lang.Object r6 = r14.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r7 = r16
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r5)
            java.lang.Object r4 = r14.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r7 = r14.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x00e6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00e6:
            r14.startReusableNode()
            boolean r7 = r14.getInserting()
            if (r7 == 0) goto L_0x00f3
            r14.createNode(r5)
            goto L_0x00f6
        L_0x00f3:
            r14.useNode()
        L_0x00f6:
            r14.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1234constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r2, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r4, r2)
            r14.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r1.invoke(r2, r14, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r1)
            r1 = 276693625(0x107e0279, float:5.0094572E-29)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "C78@3948L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            boolean r1 = r29.isEmpty()
            if (r1 == 0) goto L_0x0164
            r0 = -494983455(0xffffffffe27f26e1, float:-1.1766803E21)
            r14.startReplaceableGroup(r0)
            r1 = 0
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 7
            r5 = r14
            androidx.compose.material.ProgressIndicatorKt.m1067CircularProgressIndicatoraMcp0Q(r1, r2, r4, r5, r6, r7)
            r14.endReplaceableGroup()
            r0 = r14
            goto L_0x02f4
        L_0x0164:
            r1 = -494983398(0xffffffffe27f271a, float:-1.1766843E21)
            r14.startReplaceableGroup(r1)
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r3 = 0
            com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$5$selectedIndex$2 r0 = new com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$5$selectedIndex$2
            r0.<init>(r8)
            r4 = r0
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r6 = 8
            r7 = 6
            r5 = r14
            r0 = 0
            r13 = 1
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r7 = r1
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            boolean r1 = m4357WalletBody$lambda2(r12)
            java.lang.String r2 = "C(remember)P(1):Composables.kt#9igjgp"
            r3 = -3686930(0xffffffffffc7bdee, float:NaN)
            if (r1 == 0) goto L_0x020e
            r1 = -494983151(0xffffffffe27f2811, float:-1.1767017E21)
            r14.startReplaceableGroup(r1)
            int r1 = m4359WalletBody$lambda9$lambda4(r7)
            r4 = r28 ^ 1
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            boolean r5 = r14.changed((java.lang.Object) r7)
            java.lang.Object r0 = r14.rememberedValue()
            if (r5 != 0) goto L_0x01b2
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r0 != r5) goto L_0x01bc
        L_0x01b2:
            com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$5$1$1 r0 = new com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$5$1$1
            r0.<init>(r7)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r14.updateRememberedValue(r0)
        L_0x01bc:
            r14.endReplaceableGroup()
            r5 = r0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            boolean r0 = r14.changed((java.lang.Object) r12)
            java.lang.Object r2 = r14.rememberedValue()
            if (r0 != 0) goto L_0x01da
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x01e5
        L_0x01da:
            com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$5$2$1 r0 = new com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$5$2$1
            r0.<init>(r12)
            r2 = r0
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r14.updateRememberedValue(r2)
        L_0x01e5:
            r14.endReplaceableGroup()
            r12 = r2
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r0 = 57344(0xe000, float:8.0356E-41)
            int r2 = r35 << 3
            r0 = r0 & r2
            r17 = r0 | 8
            r3 = 0
            r0 = r29
            r2 = r4
            r4 = r3
            r3 = r5
            r5 = r4
            r4 = r31
            r13 = r5
            r5 = r12
            r12 = 8
            r6 = r14
            r18 = r7
            r7 = r17
            ExpandedPaymentDetails(r0, r1, r2, r3, r4, r5, r6, r7)
            r14.endReplaceableGroup()
            r0 = 8
            goto L_0x0255
        L_0x020e:
            r13 = r0
            r18 = r7
            r0 = 8
            r1 = -494982634(0xffffffffe27f2a16, float:-1.1767381E21)
            r14.startReplaceableGroup(r1)
            int r1 = m4359WalletBody$lambda9$lambda4(r18)
            java.lang.Object r1 = r8.get(r1)
            com.stripe.android.model.ConsumerPaymentDetails$PaymentDetails r1 = (com.stripe.android.model.ConsumerPaymentDetails.PaymentDetails) r1
            r4 = r28 ^ 1
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            boolean r2 = r14.changed((java.lang.Object) r12)
            java.lang.Object r3 = r14.rememberedValue()
            if (r2 != 0) goto L_0x023d
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0248
        L_0x023d:
            com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$5$3$1 r2 = new com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$5$3$1
            r2.<init>(r12)
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r14.updateRememberedValue(r3)
        L_0x0248:
            r14.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            int r2 = com.stripe.android.model.ConsumerPaymentDetails.PaymentDetails.$stable
            CollapsedPaymentDetails(r1, r4, r3, r14, r2)
            r14.endReplaceableGroup()
        L_0x0255:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 20
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r2)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m478height3ABfNKs(r1, r2)
            r2 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r14, r2)
            if (r28 == 0) goto L_0x026d
            com.stripe.android.link.ui.PrimaryButtonState r1 = com.stripe.android.link.ui.PrimaryButtonState.Processing
            goto L_0x026f
        L_0x026d:
            com.stripe.android.link.ui.PrimaryButtonState r1 = com.stripe.android.link.ui.PrimaryButtonState.Enabled
        L_0x026f:
            r2 = r1
            int r1 = com.stripe.android.link.R.drawable.stripe_ic_lock
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$5$4 r1 = new com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$5$4
            r4 = r18
            r1.<init>(r9, r8, r4)
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            int r1 = r35 >> 6
            r6 = r1 & 14
            r7 = 0
            r1 = r30
            r5 = r14
            com.stripe.android.link.ui.PrimaryButtonKt.PrimaryButton(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 0
            r3 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r2, r3, r13)
            r2 = 56
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r2)
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.SizeKt.m478height3ABfNKs(r1, r2)
            r1 = r28 ^ 1
            r2 = 0
            r3 = 0
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r4 = r4.getShapes(r14, r0)
            androidx.compose.foundation.shape.CornerBasedShape r4 = r4.getMedium()
            androidx.compose.ui.graphics.Shape r4 = (androidx.compose.ui.graphics.Shape) r4
            r5 = 0
            androidx.compose.material.ButtonDefaults r16 = androidx.compose.material.ButtonDefaults.INSTANCE
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r0 = r6.getColors(r14, r0)
            long r17 = r0.m916getSecondary0d7_KjU()
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 32768(0x8000, float:4.5918E-41)
            r27 = 14
            r25 = r14
            androidx.compose.material.ButtonColors r19 = r16.m876buttonColorsro_MJ88(r17, r19, r21, r23, r25, r26, r27)
            r20 = 0
            com.stripe.android.link.ui.wallet.ComposableSingletons$WalletScreenKt r0 = com.stripe.android.link.ui.wallet.ComposableSingletons$WalletScreenKt.INSTANCE
            kotlin.jvm.functions.Function3 r21 = r0.m4354getLambda3$link_release()
            r0 = 805306416(0x30000030, float:4.6566395E-10)
            int r6 = r35 >> 15
            r6 = r6 & 14
            r23 = r6 | r0
            r24 = 344(0x158, float:4.82E-43)
            r12 = r33
            r0 = r14
            r14 = r1
            r15 = r2
            r16 = r3
            r17 = r4
            r18 = r5
            r22 = r0
            androidx.compose.material.ButtonKt.TextButton(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0.endReplaceableGroup()
        L_0x02f4:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x030a
            goto L_0x0323
        L_0x030a:
            com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$6 r13 = new com.stripe.android.link.ui.wallet.WalletScreenKt$WalletBody$6
            r0 = r13
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r6 = r33
            r7 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0323:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.ui.wallet.WalletScreenKt.WalletBody(boolean, java.util.List, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: WalletBody$lambda-2  reason: not valid java name */
    private static final boolean m4357WalletBody$lambda2(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: WalletBody$lambda-3  reason: not valid java name */
    public static final void m4358WalletBody$lambda3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    /* renamed from: WalletBody$lambda-9$lambda-4  reason: not valid java name */
    public static final int m4359WalletBody$lambda9$lambda4(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: WalletBody$lambda-9$lambda-5  reason: not valid java name */
    public static final void m4360WalletBody$lambda9$lambda5(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    public static final void CollapsedPaymentDetails(ConsumerPaymentDetails.PaymentDetails paymentDetails, boolean z, Function0<Unit> function0, Composer composer, int i) {
        int i2;
        Composer composer2;
        ConsumerPaymentDetails.PaymentDetails paymentDetails2 = paymentDetails;
        boolean z2 = z;
        Function0<Unit> function02 = function0;
        int i3 = i;
        Intrinsics.checkNotNullParameter(paymentDetails2, "selectedPaymentMethod");
        Intrinsics.checkNotNullParameter(function02, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1686903322);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) paymentDetails2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function02) ? 256 : 128;
        }
        if (((i2 & 731) ^ 146) != 0 || !startRestartGroup.getSkipping()) {
            Modifier r1 = ClickableKt.m180clickableXHw0xAI$default(BackgroundKt.m161backgroundbw27NRU(BorderKt.m167borderxT4_qwU(SizeKt.m478height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m3859constructorimpl((float) 64)), Dp.m3859constructorimpl((float) 1), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, startRestartGroup, 8).m4333getComponentBorder0d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getLarge()), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, startRestartGroup, 8).m4332getComponentBackground0d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getLarge()), z, (String) null, (Role) null, function0, 6, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            startRestartGroup.startReplaceableGroup(-1989997165);
            ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r1);
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
            Composer r5 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-326682362);
            ComposerKt.sourceInformation(startRestartGroup, "C79@3942L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            Composer composer3 = startRestartGroup;
            TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(R.string.wallet_pay_with, startRestartGroup, 0), PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, ThemeKt.getHorizontalPadding(), 0.0f, 2, (Object) null), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, startRestartGroup, 8).m4335getDisabledText0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 48, 0, 65528);
            Composer composer4 = composer3;
            composer4.startReplaceableGroup(634157694);
            if (paymentDetails2 instanceof ConsumerPaymentDetails.Card) {
                CardDetails((ConsumerPaymentDetails.Card) paymentDetails2, composer4, ConsumerPaymentDetails.Card.$stable);
            }
            composer4.endReplaceableGroup();
            SpacerKt.Spacer(RowScope.DefaultImpls.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null), composer4, 0);
            composer2 = composer4;
            IconKt.m1013Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_link_chevron, composer4, 0), StringResources_androidKt.stringResource(R.string.wallet_expand_accessibility, composer4, 0), SemanticsModifierKt.semantics$default(PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, ThemeKt.getHorizontalPadding(), 0.0f, 2, (Object) null), false, WalletScreenKt$CollapsedPaymentDetails$1$1.INSTANCE, 1, (Object) null), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, composer4, 8).m4335getDisabledText0d7_KjU(), composer2, 8, 0);
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
            endRestartGroup.updateScope(new WalletScreenKt$CollapsedPaymentDetails$2(paymentDetails2, z2, function02, i3));
        }
    }

    public static final void ExpandedPaymentDetails(List<? extends ConsumerPaymentDetails.PaymentDetails> list, int i, boolean z, Function1<? super Integer, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Composer composer, int i2) {
        List<? extends ConsumerPaymentDetails.PaymentDetails> list2 = list;
        Function1<? super Integer, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(list2, "paymentDetails");
        Intrinsics.checkNotNullParameter(function12, "onIndexSelected");
        Intrinsics.checkNotNullParameter(function0, "onAddNewPaymentMethodClick");
        Intrinsics.checkNotNullParameter(function02, "onCollapse");
        Composer startRestartGroup = composer.startRestartGroup(-2048892618);
        Modifier r2 = BackgroundKt.m161backgroundbw27NRU(BorderKt.m167borderxT4_qwU(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m3859constructorimpl((float) 1), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, startRestartGroup, 8).m4333getComponentBorder0d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getLarge()), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, startRestartGroup, 8).m4332getComponentBackground0d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getLarge());
        startRestartGroup.startReplaceableGroup(-1113030915);
        ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
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
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r2);
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
        String str = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh";
        Modifier r5 = ClickableKt.m180clickableXHw0xAI$default(PaddingKt.m435paddingqDBjuR0$default(SizeKt.m478height3ABfNKs(Modifier.Companion, Dp.m3859constructorimpl((float) 44)), ThemeKt.getHorizontalPadding(), Dp.m3859constructorimpl((float) 20), ThemeKt.getHorizontalPadding(), 0.0f, 8, (Object) null), z, (String) null, (Role) null, function02, 6, (Object) null);
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        startRestartGroup.startReplaceableGroup(-1989997165);
        ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(startRestartGroup, str);
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
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r5);
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
        materializerOf2.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, null);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-326682362);
        ComposerKt.sourceInformation(startRestartGroup, "C79@3942L9:Row.kt#2w3rfo");
        TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(R.string.wallet_expanded_title, startRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m911getOnPrimary0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getButton(), startRestartGroup, 0, 0, 32762);
        SpacerKt.Spacer(RowScope.DefaultImpls.weight$default(RowScopeInstance.INSTANCE, Modifier.Companion, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
        IconKt.m1013Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_link_chevron, startRestartGroup, 0), StringResources_androidKt.stringResource(R.string.wallet_expand_accessibility, startRestartGroup, 0), SemanticsModifierKt.semantics$default(RotateKt.rotate(Modifier.Companion, 180.0f), false, WalletScreenKt$ExpandedPaymentDetails$1$1$1.INSTANCE, 1, (Object) null), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m911getOnPrimary0d7_KjU(), startRestartGroup, 8, 0);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        LazyDslKt.LazyColumn(PaddingKt.m433paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ThemeKt.getHorizontalPadding(), 0.0f, 2, (Object) null), (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, new WalletScreenKt$ExpandedPaymentDetails$1$2(list2, i, function12, i2), startRestartGroup, 6, 126);
        String str2 = "C79@3942L9:Row.kt#2w3rfo";
        Modifier r52 = ClickableKt.m180clickableXHw0xAI$default(PaddingKt.m435paddingqDBjuR0$default(SizeKt.m478height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m3859constructorimpl((float) 60)), ThemeKt.getHorizontalPadding(), 0.0f, ThemeKt.getHorizontalPadding(), Dp.m3859constructorimpl((float) 4), 2, (Object) null), false, (String) null, (Role) null, function0, 7, (Object) null);
        Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
        startRestartGroup.startReplaceableGroup(-1989997165);
        ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(startRestartGroup, str);
        String str3 = "C:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, str3);
        Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density3 = (Density) consume7;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, str3);
        Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, str3);
        Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(r52);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor3);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r8 = Updater.m1234constructorimpl(startRestartGroup);
        Updater.m1241setimpl(r8, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r8, density3, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r8, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r8, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf3.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, null);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-326682362);
        ComposerKt.sourceInformation(startRestartGroup, str2);
        RowScope rowScope = RowScopeInstance.INSTANCE;
        IconKt.m1013Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_link_add, startRestartGroup, 0), (String) null, PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.m3859constructorimpl((float) 12), 0.0f, 11, (Object) null), Color.Companion.m1632getUnspecified0d7_KjU(), startRestartGroup, 3512, 0);
        TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(R.string.wallet_add_new_payment_method, startRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m911getOnPrimary0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getButton(), startRestartGroup, 0, 0, 32762);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new WalletScreenKt$ExpandedPaymentDetails$2(list, i, z, function1, function0, function02, i2));
        }
    }

    public static final void CardPaymentMethodItem(ConsumerPaymentDetails.Card card, boolean z, Function0<Unit> function0, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composer3;
        int i3;
        ConsumerPaymentDetails.Card card2 = card;
        boolean z2 = z;
        Function0<Unit> function02 = function0;
        int i4 = i;
        Intrinsics.checkNotNullParameter(card2, "cardDetails");
        Intrinsics.checkNotNullParameter(function02, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1309654292);
        if ((i4 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) card2) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        if ((i4 & 112) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function02) ? 256 : 128;
        }
        int i5 = i2;
        if (((i5 & 731) ^ 146) != 0 || !startRestartGroup.getSkipping()) {
            Modifier r1 = ClickableKt.m180clickableXHw0xAI$default(SizeKt.m478height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m3859constructorimpl((float) 56)), false, (String) null, (Role) null, function0, 7, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            startRestartGroup.startReplaceableGroup(-1989997165);
            ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r1);
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
            Composer r5 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-326682362);
            ComposerKt.sourceInformation(startRestartGroup, "C79@3942L9:Row.kt#2w3rfo");
            int i6 = i5;
            String str = "C:CompositionLocal.kt#9igjgp";
            String str2 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh";
            Composer composer4 = startRestartGroup;
            RadioButtonKt.RadioButton(z, (Function0<Unit>) null, PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.m3859constructorimpl((float) 6), 0.0f, 11, (Object) null), false, (MutableInteractionSource) null, RadioButtonDefaults.INSTANCE.m1095colorsRGew2ao(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m914getPrimary0d7_KjU(), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, startRestartGroup, 8).m4335getDisabledText0d7_KjU(), 0, startRestartGroup, 4096, 4), startRestartGroup, ((i6 >> 3) & 14) | 432, 24);
            CardDetails(card2, composer4, ConsumerPaymentDetails.Card.$stable | (i6 & 14));
            SpacerKt.Spacer(RowScope.DefaultImpls.weight$default(RowScopeInstance.INSTANCE, Modifier.Companion, 1.0f, false, 2, (Object) null), composer4, 0);
            composer4.startReplaceableGroup(1309655055);
            if (card.isDefault()) {
                i3 = 8;
                Modifier r12 = BackgroundKt.m161backgroundbw27NRU(SizeKt.m478height3ABfNKs(Modifier.Companion, Dp.m3859constructorimpl((float) 20)), MaterialTheme.INSTANCE.getColors(composer4, 8).m916getSecondary0d7_KjU(), MaterialTheme.INSTANCE.getShapes(composer4, 8).getSmall());
                Alignment center = Alignment.Companion.getCenter();
                composer4.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                composer4.startReplaceableGroup(1376089394);
                ComposerKt.sourceInformation(composer4, str2);
                String str3 = str;
                ComposerKt.sourceInformationMarkerStart(composer4, 103361330, str3);
                Object consume4 = composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer4);
                Density density2 = (Density) consume4;
                ComposerKt.sourceInformationMarkerStart(composer4, 103361330, str3);
                Object consume5 = composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer4);
                LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart(composer4, 103361330, str3);
                Object consume6 = composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r12);
                if (!(composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor2);
                } else {
                    composer4.useNode();
                }
                composer4.disableReusing();
                Composer r6 = Updater.m1234constructorimpl(composer4);
                Updater.m1241setimpl(r6, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1241setimpl(r6, density2, ComposeUiNode.Companion.getSetDensity());
                Updater.m1241setimpl(r6, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1241setimpl(r6, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                composer4.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer4)), composer4, 0);
                composer4.startReplaceableGroup(2058660585);
                composer4.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(composer4, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                composer3 = composer4;
                TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(R.string.wallet_default, composer4, 0), PaddingKt.m432paddingVpY3zN4(Modifier.Companion, Dp.m3859constructorimpl((float) 4), Dp.m3859constructorimpl((float) 2)), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, composer3, 8).m4335getDisabledText0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199728, 0, 65488);
                composer3.endReplaceableGroup();
                composer3.endReplaceableGroup();
                composer3.endNode();
                composer3.endReplaceableGroup();
                composer3.endReplaceableGroup();
            } else {
                composer3 = composer4;
                i3 = 8;
            }
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            composer3.endNode();
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            composer2 = composer3;
            TabRowDefaults.INSTANCE.m1152Divider9IZ8Weo((Modifier) null, Dp.m3859constructorimpl((float) 1), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, composer3, i3).m4334getComponentDivider0d7_KjU(), composer3, 4144, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new WalletScreenKt$CardPaymentMethodItem$2(card2, z2, function02, i4));
        }
    }

    public static final void CardDetails(ConsumerPaymentDetails.Card card, Composer composer, int i) {
        int i2;
        ConsumerPaymentDetails.Card card2 = card;
        int i3 = i;
        Intrinsics.checkNotNullParameter(card2, "card");
        Composer startRestartGroup = composer.startRestartGroup(1031479132);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) card2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if (((i2 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            startRestartGroup.startReplaceableGroup(-1989997165);
            ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
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
            Updater.m1241setimpl(r8, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r8, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r8, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r8, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-326682362);
            ComposerKt.sourceInformation(startRestartGroup, "C79@3942L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            IconKt.m1013Iconww6aTOc(PainterResources_androidKt.painterResource(card.getBrand().getIcon(), startRestartGroup, 0), card.getBrand().getDisplayName(), PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, Dp.m3859constructorimpl((float) 6), 0.0f, 2, (Object) null), Color.Companion.m1632getUnspecified0d7_KjU(), startRestartGroup, 3464, 0);
            Composer composer2 = startRestartGroup;
            TextKt.m1189TextfLXpl1I("•••• ", (Modifier) null, MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m911getOnPrimary0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 6, 0, 65530);
            TextKt.m1189TextfLXpl1I(card.getLast4(), (Modifier) null, MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m911getOnPrimary0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 65530);
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
            endRestartGroup.updateScope(new WalletScreenKt$CardDetails$2(card2, i3));
        }
    }

    /* renamed from: WalletBody$lambda-0  reason: not valid java name */
    private static final List<ConsumerPaymentDetails.PaymentDetails> m4355WalletBody$lambda0(State<? extends List<? extends ConsumerPaymentDetails.PaymentDetails>> state) {
        return (List) state.getValue();
    }

    /* renamed from: WalletBody$lambda-1  reason: not valid java name */
    private static final Boolean m4356WalletBody$lambda1(State<Boolean> state) {
        return state.getValue();
    }
}
