package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NestedScrollModifier.kt */
public final class NestedScrollModifierKt$nestedScroll$2$1$1 implements NestedScrollModifier {
    final /* synthetic */ NestedScrollConnection $connection;
    final /* synthetic */ NestedScrollDispatcher $resolvedDispatcher;
    final /* synthetic */ CoroutineScope $scope;
    private final NestedScrollConnection connection;
    private final NestedScrollDispatcher dispatcher;

    NestedScrollModifierKt$nestedScroll$2$1$1(NestedScrollDispatcher nestedScrollDispatcher, NestedScrollConnection nestedScrollConnection, CoroutineScope coroutineScope) {
        this.$resolvedDispatcher = nestedScrollDispatcher;
        this.$connection = nestedScrollConnection;
        this.$scope = coroutineScope;
        nestedScrollDispatcher.setOriginNestedScrollScope$ui_release(coroutineScope);
        this.dispatcher = nestedScrollDispatcher;
        this.connection = nestedScrollConnection;
    }

    public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return NestedScrollModifier.DefaultImpls.all(this, function1);
    }

    public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return NestedScrollModifier.DefaultImpls.any(this, function1);
    }

    public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return NestedScrollModifier.DefaultImpls.foldIn(this, r, function2);
    }

    public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return NestedScrollModifier.DefaultImpls.foldOut(this, r, function2);
    }

    public Modifier then(Modifier modifier) {
        return NestedScrollModifier.DefaultImpls.then(this, modifier);
    }

    public NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public NestedScrollConnection getConnection() {
        return this.connection;
    }
}
