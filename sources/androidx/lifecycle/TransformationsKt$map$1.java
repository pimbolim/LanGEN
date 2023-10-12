package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u0001H\u0003H\u0003H\n"}, d2 = {"<anonymous>", "Y", "kotlin.jvm.PlatformType", "X", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: Transformations.kt */
public final class TransformationsKt$map$1<I, O> implements Function {
    final /* synthetic */ Function1<X, Y> $transform;

    public TransformationsKt$map$1(Function1<? super X, ? extends Y> function1) {
        this.$transform = function1;
    }

    public final Y apply(X x) {
        return this.$transform.invoke(x);
    }
}
