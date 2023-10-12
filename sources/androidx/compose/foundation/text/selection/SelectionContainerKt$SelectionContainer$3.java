package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectionContainer.kt */
final class SelectionContainerKt$SelectionContainer$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $children;
    final /* synthetic */ SelectionManager $manager;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionContainerKt$SelectionContainer$3(Modifier modifier, SelectionManager selectionManager, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$modifier = modifier;
        this.$manager = selectionManager;
        this.$children = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C96@3518L1538:SelectionContainer.kt#eksfi3");
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier then = this.$modifier.then(this.$manager.getModifier());
            final Function2<Composer, Integer, Unit> function2 = this.$children;
            final int i2 = this.$$dirty;
            final SelectionManager selectionManager = this.$manager;
            SimpleLayoutKt.SimpleLayout(then, ComposableLambdaKt.composableLambda(composer, -819893383, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Selection selection;
                    Offset offset;
                    ResolvedTextDirection resolvedTextDirection;
                    Composer composer2 = composer;
                    ComposerKt.sourceInformation(composer2, "C97@3589L10,*101@3804L121,117@4445L521:SelectionContainer.kt#eksfi3");
                    if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        function2.invoke(composer2, Integer.valueOf((i2 >> 9) & 14));
                        if (TouchMode_androidKt.isInTouchMode() && selectionManager.getHasFocus() && (selection = selectionManager.getSelection()) != null) {
                            SelectionManager selectionManager = selectionManager;
                            int i2 = 0;
                            List listOf = CollectionsKt.listOf(true, false);
                            int size = listOf.size();
                            while (i2 < size) {
                                int i3 = i2 + 1;
                                boolean booleanValue = ((Boolean) listOf.get(i2)).booleanValue();
                                Boolean valueOf = Boolean.valueOf(booleanValue);
                                composer2.startReplaceableGroup(-3686930);
                                ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
                                boolean changed = composer2.changed((Object) valueOf);
                                Object rememberedValue = composer.rememberedValue();
                                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = selectionManager.handleDragObserver(booleanValue);
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer.endReplaceableGroup();
                                TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                                if (booleanValue) {
                                    offset = selectionManager.m784getStartHandlePosition_m7T9E();
                                } else {
                                    offset = selectionManager.m783getEndHandlePosition_m7T9E();
                                }
                                if (booleanValue) {
                                    resolvedTextDirection = selection.getStart().getDirection();
                                } else {
                                    resolvedTextDirection = selection.getEnd().getDirection();
                                }
                                if (offset != null) {
                                    AndroidSelectionHandles_androidKt.m740SelectionHandle8fL75g(offset.m1363unboximpl(), booleanValue, resolvedTextDirection, selection.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionContainerKt$SelectionContainer$3$1$1$1$1(textDragObserver, (Continuation<? super SelectionContainerKt$SelectionContainer$3$1$1$1$1>) null)), (Function2<? super Composer, ? super Integer, Unit>) null, composer, 196608);
                                }
                                i2 = i3;
                            }
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 48, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
