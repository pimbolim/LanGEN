package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.mov.QuickTimeAtomTypes;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ab\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u0015\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001f\u001aq\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\"\u001a\u0001\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001e2$\b\b\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140$\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b!¢\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010%\u001ab\u0010&\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u0015\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001f\u001aq\u0010&\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\"\u001a\u0001\u0010&\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001e2$\b\b\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140$\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b!¢\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010%\u001a.\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\bø\u0001\u0001¢\u0006\u0002\u0010)\u001a\b\u0010*\u001a\u00020\u0013H\u0001\u001aB\u0010(\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150,\"\u0004\u0018\u00010\u00152\u0011\u0010-\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b!H\bø\u0001\u0001¢\u0006\u0002\u0010.\u001a*\u0010/\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0011\u00100\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b\u001dH\bø\u0001\u0001¢\u0006\u0002\u00101\u001a4\u0010/\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\u00102\u001a\u0004\u0018\u00010\u00152\u0011\u00100\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b\u001dH\bø\u0001\u0001¢\u0006\u0002\u00103\u001a>\u0010/\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\u00102\u001a\u0004\u0018\u00010\u00152\b\u00104\u001a\u0004\u0018\u00010\u00152\u0011\u00100\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b\u001dH\bø\u0001\u0001¢\u0006\u0002\u00105\u001aH\u0010/\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\u00102\u001a\u0004\u0018\u00010\u00152\b\u00104\u001a\u0004\u0018\u00010\u00152\b\u00106\u001a\u0004\u0018\u00010\u00152\u0011\u00100\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b\u001dH\bø\u0001\u0001¢\u0006\u0002\u00107\u001aB\u0010/\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150,\"\u0004\u0018\u00010\u00152\u0011\u00100\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b\u001dH\bø\u0001\u0001¢\u0006\u0002\u00108\u001a\r\u00109\u001a\u00020:H\u0007¢\u0006\u0002\u0010;\"\u0011\u0010\u0000\u001a\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0017\u0010\b\u001a\u00020\t8G¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006<"}, d2 = {"currentComposer", "Landroidx/compose/runtime/Composer;", "getCurrentComposer", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/Composer;", "currentCompositeKeyHash", "", "getCurrentCompositeKeyHash", "(Landroidx/compose/runtime/Composer;I)I", "currentCompositionLocalContext", "Landroidx/compose/runtime/CompositionLocalContext;", "getCurrentCompositionLocalContext$annotations", "()V", "getCurrentCompositionLocalContext", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionLocalContext;", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getCurrentRecomposeScope", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/RecomposeScope;", "ComposeNode", "", "T", "", "E", "Landroidx/compose/runtime/Applier;", "factory", "Lkotlin/Function0;", "update", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Landroidx/compose/runtime/DisallowComposableCalls;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "skippableUpdate", "Landroidx/compose/runtime/SkippableUpdater;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ReusableComposeNode", "ReusableContent", "key", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "invalidApplier", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "remember", "calculation", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key1", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "rememberCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionContext;", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Composables.kt */
public final class ComposablesKt {
    public static /* synthetic */ void getCurrentCompositionLocalContext$annotations() {
    }

    public static final <T> T remember(Object obj, Function0<? extends T> function0, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        composer.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed(obj);
        T rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = function0.invoke();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        return rememberedValue;
    }

    public static final <T> T remember(Object obj, Object obj2, Function0<? extends T> function0, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        composer.startReplaceableGroup(-3686552);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = composer.changed(obj) | composer.changed(obj2);
        T rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = function0.invoke();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        return rememberedValue;
    }

    public static final <T> T remember(Object obj, Object obj2, Object obj3, Function0<? extends T> function0, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        composer.startReplaceableGroup(-3686095);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        T rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = function0.invoke();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        return rememberedValue;
    }

    public static final <T> T remember(Object[] objArr, Function0<? extends T> function0, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(objArr, QuickTimeAtomTypes.ATOM_KEYS);
        Intrinsics.checkNotNullParameter(function0, "calculation");
        composer.startReplaceableGroup(-3685570);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        int length = objArr.length;
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            Object obj = objArr[i2];
            i2++;
            z |= composer.changed(obj);
        }
        T rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = function0.invoke();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        return rememberedValue;
    }

    public static final <T> T key(Object[] objArr, Function2<? super Composer, ? super Integer, ? extends T> function2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(objArr, QuickTimeAtomTypes.ATOM_KEYS);
        Intrinsics.checkNotNullParameter(function2, "block");
        composer.startReplaceableGroup(-1542330587);
        ComposerKt.sourceInformation(composer, "C(key)P(1)128@4598L7:Composables.kt#9igjgp");
        T invoke = function2.invoke(composer, Integer.valueOf((i >> 3) & 14));
        composer.endReplaceableGroup();
        return invoke;
    }

    public static final void ReusableContent(Object obj, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function2, "content");
        composer.startReplaceableGroup(-1530021272);
        ComposerKt.sourceInformation(composer, "C(ReusableContent)P(1)145@5253L9:Composables.kt#9igjgp");
        composer.startReusableGroup(ComposerKt.reuseKey, obj);
        function2.invoke(composer, Integer.valueOf((i >> 3) & 14));
        composer.endReusableGroup();
        composer.endReplaceableGroup();
    }

    public static final Composer getCurrentComposer(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 756186890, "C:Composables.kt#9igjgp");
        throw new NotImplementedError("Implemented as an intrinsic");
    }

    public static final RecomposeScope getCurrentRecomposeScope(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 142554597, "C:Composables.kt#9igjgp");
        RecomposeScope recomposeScope = composer.getRecomposeScope();
        if (recomposeScope != null) {
            composer.recordUsed(recomposeScope);
            ComposerKt.sourceInformationMarkerEnd(composer);
            return recomposeScope;
        }
        throw new IllegalStateException("no recompose scope found".toString());
    }

    public static final CompositionLocalContext getCurrentCompositionLocalContext(Composer composer, int i) {
        composer.startReplaceableGroup(550242516);
        ComposerKt.sourceInformation(composer, "C:Composables.kt#9igjgp");
        CompositionLocalContext compositionLocalContext = new CompositionLocalContext(composer.buildContext().getCompositionLocalScope$runtime_release());
        composer.endReplaceableGroup();
        return compositionLocalContext;
    }

    public static final int getCurrentCompositeKeyHash(Composer composer, int i) {
        return composer.getCompoundKeyHash();
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        composer.startReplaceableGroup(-2103250935);
        ComposerKt.sourceInformation(composer, "C(ComposeNode):Composables.kt#9igjgp");
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(new ComposablesKt$ComposeNode$1(function0));
        } else {
            composer.useNode();
        }
        function1.invoke(Updater.m1233boximpl(Updater.m1234constructorimpl(composer)));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        composer.startReplaceableGroup(1546164872);
        ComposerKt.sourceInformation(composer, "C(ReusableComposeNode):Composables.kt#9igjgp");
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new ComposablesKt$ReusableComposeNode$1(function0));
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        function1.invoke(Updater.m1233boximpl(Updater.m1234constructorimpl(composer)));
        composer.enableReusing();
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer.startReplaceableGroup(-2103248186);
        ComposerKt.sourceInformation(composer, "C(ComposeNode)P(1,2)305@11141L9:Composables.kt#9igjgp");
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(function0);
        } else {
            composer.useNode();
        }
        function1.invoke(Updater.m1233boximpl(Updater.m1234constructorimpl(composer)));
        function2.invoke(composer, Integer.valueOf((i >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer.startReplaceableGroup(1546167803);
        ComposerKt.sourceInformation(composer, "C(ReusableComposeNode)P(1,2)347@12680L9:Composables.kt#9igjgp");
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(function0);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        function1.invoke(Updater.m1233boximpl(Updater.m1234constructorimpl(composer)));
        composer.enableReusing();
        function2.invoke(composer, Integer.valueOf((i >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Function3<? super SkippableUpdater<T>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function3, "skippableUpdate");
        Intrinsics.checkNotNullParameter(function2, "content");
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(function0);
        } else {
            composer.useNode();
        }
        function1.invoke(Updater.m1233boximpl(Updater.m1234constructorimpl(composer)));
        function3.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer, Integer.valueOf((i >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Function3<? super SkippableUpdater<T>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function3, "skippableUpdate");
        Intrinsics.checkNotNullParameter(function2, "content");
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(function0);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        function1.invoke(Updater.m1233boximpl(Updater.m1234constructorimpl(composer)));
        composer.enableReusing();
        function3.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer, Integer.valueOf((i >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
    }

    public static final void invalidApplier() {
        throw new IllegalStateException("Invalid applier".toString());
    }

    public static final CompositionContext rememberCompositionContext(Composer composer, int i) {
        composer.startReplaceableGroup(-1359197906);
        ComposerKt.sourceInformation(composer, "C(rememberCompositionContext):Composables.kt#9igjgp");
        CompositionContext buildContext = composer.buildContext();
        composer.endReplaceableGroup();
        return buildContext;
    }

    public static final <T> T remember(Function0<? extends T> function0, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        T rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = function0.invoke();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        return rememberedValue;
    }
}
