package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import com.drew.metadata.mov.QuickTimeAtomTypes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\b¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\t\u001a\\\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\b¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u000e\u001af\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\b¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0010\u001ap\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\b¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0012\u001aj\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\b¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001¨\u0006\u0019"}, d2 = {"composed", "Landroidx/compose/ui/Modifier;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "fullyQualifiedName", "", "key1", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "key2", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "key3", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "keys", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "materialize", "Landroidx/compose/runtime/Composer;", "modifier", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposedModifier.kt */
public final class ComposedModifierKt {
    public static /* synthetic */ Modifier composed$default(Modifier modifier, Function1<InspectorInfo, Unit> function1, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, function1, function3);
    }

    public static final Modifier composed(Modifier modifier, Function1<? super InspectorInfo, Unit> function1, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function3, "factory");
        return modifier.then(new ComposedModifier(function1, function3));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Function1<InspectorInfo, Unit> function1, Function3 function3, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, (Function1<? super InspectorInfo, Unit>) function1, (Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier>) function3);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier modifier, String str, Object obj, Function1<? super InspectorInfo, Unit> function1, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(str, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function3, "factory");
        return modifier.then(new KeyedComposedModifier1(str, obj, function1, function3));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, Function1<InspectorInfo, Unit> function1, Function3 function3, int i, Object obj3) {
        if ((i & 8) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, function1, function3);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier modifier, String str, Object obj, Object obj2, Function1<? super InspectorInfo, Unit> function1, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(str, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function3, "factory");
        return modifier.then(new KeyedComposedModifier2(str, obj, obj2, function1, function3));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, Object obj3, Function1<InspectorInfo, Unit> function1, Function3 function3, int i, Object obj4) {
        if ((i & 16) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, obj3, function1, function3);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier modifier, String str, Object obj, Object obj2, Object obj3, Function1<? super InspectorInfo, Unit> function1, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(str, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function3, "factory");
        return modifier.then(new KeyedComposedModifier3(str, obj, obj2, obj3, function1, function3));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object[] objArr, Function1<InspectorInfo, Unit> function1, Function3 function3, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, objArr, (Function1<? super InspectorInfo, Unit>) function1, (Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier>) function3);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier modifier, String str, Object[] objArr, Function1<? super InspectorInfo, Unit> function1, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(str, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(objArr, QuickTimeAtomTypes.ATOM_KEYS);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function3, "factory");
        return modifier.then(new KeyedComposedModifierN(str, objArr, function1, function3));
    }

    public static final Modifier materialize(Composer composer, Modifier modifier) {
        Intrinsics.checkNotNullParameter(composer, "<this>");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        if (modifier.all(ComposedModifierKt$materialize$1.INSTANCE)) {
            return modifier;
        }
        composer.startReplaceableGroup(1219399079);
        Modifier modifier2 = (Modifier) modifier.foldIn(Modifier.Companion, new ComposedModifierKt$materialize$result$1(composer));
        composer.endReplaceableGroup();
        return modifier2;
    }
}
