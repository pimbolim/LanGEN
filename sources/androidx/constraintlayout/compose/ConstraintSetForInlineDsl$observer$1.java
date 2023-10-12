package androidx.constraintlayout.compose;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Function0;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class ConstraintSetForInlineDsl$observer$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
    final /* synthetic */ ConstraintSetForInlineDsl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintSetForInlineDsl$observer$1(ConstraintSetForInlineDsl constraintSetForInlineDsl) {
        super(1);
        this.this$0 = constraintSetForInlineDsl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function0<Unit>) (Function0) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "it");
        if (Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            function0.invoke();
            return;
        }
        Handler access$getHandler$p = this.this$0.handler;
        if (access$getHandler$p == null) {
            access$getHandler$p = new Handler(Looper.getMainLooper());
            this.this$0.handler = access$getHandler$p;
        }
        access$getHandler$p.post(new Runnable() {
            public final void run() {
                ConstraintSetForInlineDsl$observer$1.m4167invoke$lambda1(Function0.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m4167invoke$lambda1(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }
}
