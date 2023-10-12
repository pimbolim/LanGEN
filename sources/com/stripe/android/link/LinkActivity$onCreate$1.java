package com.stripe.android.link;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.theme.ThemeKt;
import com.stripe.android.link.ui.LinkAppBarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkActivity.kt */
final class LinkActivity$onCreate$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LinkActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkActivity$onCreate$1(LinkActivity linkActivity) {
        super(2);
        this.this$0 = linkActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            this.this$0.setNavController(NavHostControllerKt.rememberNavController(new Navigator[0], composer, 8));
            this.this$0.getViewModel().getNavigator().setNavigationController(this.this$0.getNavController());
            final LinkActivity linkActivity = this.this$0;
            ThemeKt.DefaultLinkTheme(false, ComposableLambdaKt.composableLambda(composer, -819892605, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        final LinkActivity linkActivity = linkActivity;
                        SurfaceKt.m1125SurfaceFjzlyU((Modifier) null, (Shape) null, 0, 0, (BorderStroke) null, 0.0f, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -819892567, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                                    String str = null;
                                    Modifier r15 = PaddingKt.m433paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m3859constructorimpl((float) 20), 0.0f, 2, (Object) null);
                                    LinkActivity linkActivity = linkActivity;
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r15);
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
                                    materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer, 0);
                                    composer.startReplaceableGroup(2058660585);
                                    composer.startReplaceableGroup(276693625);
                                    ComposerKt.sourceInformation(composer, "C78@3948L9:Column.kt#2w3rfo");
                                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                    State collectAsState = SnapshotStateKt.collectAsState(linkActivity.getViewModel().getLinkAccount(), null, (CoroutineContext) null, composer, 56, 2);
                                    LinkAccount r1 = m4306invoke$lambda1$lambda0(collectAsState);
                                    if (r1 != null) {
                                        str = r1.getEmail();
                                    }
                                    LinkAppBarKt.LinkAppBar(str, new LinkActivity$onCreate$1$1$1$1$1(linkActivity), composer, 0);
                                    NavHostKt.NavHost(linkActivity.getNavController(), linkActivity.getViewModel().getStartDestination(), (Modifier) null, (String) null, new LinkActivity$onCreate$1$1$1$1$2(linkActivity, collectAsState), composer, 8, 12);
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    composer.endNode();
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }

                            /* access modifiers changed from: private */
                            /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
                            public static final LinkAccount m4306invoke$lambda1$lambda0(State<LinkAccount> state) {
                                return state.getValue();
                            }
                        }), composer, 1572864, 63);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 48, 1);
            return;
        }
        composer.skipToGroupEnd();
    }
}
