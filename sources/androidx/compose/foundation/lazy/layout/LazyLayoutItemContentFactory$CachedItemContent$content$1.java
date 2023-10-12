package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayoutItemContentFactory.kt */
final class LazyLayoutItemContentFactory$CachedItemContent$content$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LazyLayoutItemContentFactory this$0;
    final /* synthetic */ LazyLayoutItemContentFactory.CachedItemContent this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutItemContentFactory$CachedItemContent$content$1(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, LazyLayoutItemContentFactory.CachedItemContent cachedItemContent) {
        super(2);
        this.this$0 = lazyLayoutItemContentFactory;
        this.this$1 = cachedItemContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C105@4228L128:LazyLayoutItemContentFactory.kt#wow0x6");
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            LazyLayoutItemsProvider lazyLayoutItemsProvider = (LazyLayoutItemsProvider) this.this$0.itemsProvider.invoke();
            Integer num = lazyLayoutItemsProvider.getKeyToIndexMap().get(this.this$1.getKey());
            if (num == null) {
                num = null;
            } else {
                this.this$1.setLastKnownIndex(num.intValue());
            }
            if (num == null) {
                i2 = this.this$1.getLastKnownIndex();
            } else {
                i2 = num.intValue();
            }
            composer.startReplaceableGroup(494375263);
            ComposerKt.sourceInformation(composer, "102@4148L35");
            if (i2 < lazyLayoutItemsProvider.getItemsCount()) {
                Object key = lazyLayoutItemsProvider.getKey(i2);
                if (Intrinsics.areEqual(key, this.this$1.getKey())) {
                    this.this$0.saveableStateHolder.SaveableStateProvider(key, lazyLayoutItemsProvider.getContent(i2), composer, 520);
                }
            }
            composer.endReplaceableGroup();
            Object key2 = this.this$1.getKey();
            final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = this.this$0;
            final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this.this$1;
            EffectsKt.DisposableEffect(key2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    return new LazyLayoutItemContentFactory$CachedItemContent$content$1$1$invoke$$inlined$onDispose$1(lazyLayoutItemContentFactory, cachedItemContent);
                }
            }, composer, 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
