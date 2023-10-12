package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00022\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u0001H\u0004H\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Y", "kotlin.jvm.PlatformType", "X", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: Transformations.kt */
public final class TransformationsKt$switchMap$1<I, O> implements Function {
    final /* synthetic */ Function1<X, LiveData<Y>> $transform;

    public TransformationsKt$switchMap$1(Function1<? super X, ? extends LiveData<Y>> function1) {
        this.$transform = function1;
    }

    public final LiveData<Y> apply(X x) {
        return this.$transform.invoke(x);
    }
}
