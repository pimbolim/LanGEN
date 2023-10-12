package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class Measurer$createDesignElements$2 extends Lambda implements Function1<String, Unit> {
    public static final Measurer$createDesignElements$2 INSTANCE = new Measurer$createDesignElements$2();

    Measurer$createDesignElements$2() {
        super(1);
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }
}
