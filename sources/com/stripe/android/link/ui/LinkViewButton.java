package com.stripe.android.link.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.platform.AbstractComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u001b\u001a\u00020\u0012H\u0017¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\nH\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/link/ui/LinkViewButton;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isEnabledState", "()Z", "setEnabledState", "(Z)V", "isEnabledState$delegate", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "onClick", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onClick$delegate", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "Content", "(Landroidx/compose/runtime/Composer;I)V", "setEnabled", "enabled", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkButton.kt */
public final class LinkViewButton extends AbstractComposeView {
    public static final int $stable = 8;
    private final MutableState isEnabledState$delegate;
    private final MutableState onClick$delegate;
    private boolean shouldCreateCompositionOnAttachedToWindow;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LinkViewButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LinkViewButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinkViewButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkViewButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.onClick$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LinkViewButton$onClick$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isEnabledState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isEnabled()), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final Function0<Unit> getOnClick() {
        return (Function0) this.onClick$delegate.getValue();
    }

    public final void setOnClick(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onClick$delegate.setValue(function0);
    }

    private final boolean isEnabledState() {
        return ((Boolean) this.isEnabledState$delegate.getValue()).booleanValue();
    }

    private final void setEnabledState(boolean z) {
        this.isEnabledState$delegate.setValue(Boolean.valueOf(z));
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setEnabledState(z);
    }

    public void Content(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1072543614);
        ComposerKt.sourceInformation(startRestartGroup, "C(Content)");
        LinkButtonKt.LinkButton(isEnabledState(), getOnClick(), startRestartGroup, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LinkViewButton$Content$1(this, i));
        }
    }
}
