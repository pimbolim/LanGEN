package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J5\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0004¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "Companion", "Element", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Modifier.kt */
public interface Modifier {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean all(Function1<? super Element, Boolean> function1);

    boolean any(Function1<? super Element, Boolean> function1);

    <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> function2);

    <R> R foldOut(R r, Function2<? super Element, ? super R, ? extends R> function2);

    Modifier then(Modifier modifier);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Modifier.kt */
    public static final class DefaultImpls {
        public static Modifier then(Modifier modifier, Modifier modifier2) {
            Intrinsics.checkNotNullParameter(modifier, "this");
            Intrinsics.checkNotNullParameter(modifier2, "other");
            return modifier2 == Modifier.Companion ? modifier : new CombinedModifier(modifier, modifier2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J5\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fJ5\u0010\r\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/Modifier;", "all", "", "predicate", "Lkotlin/Function1;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Modifier.kt */
    public interface Element extends Modifier {
        boolean all(Function1<? super Element, Boolean> function1);

        boolean any(Function1<? super Element, Boolean> function1);

        <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> function2);

        <R> R foldOut(R r, Function2<? super Element, ? super R, ? extends R> function2);

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Modifier.kt */
        public static final class DefaultImpls {
            public static Modifier then(Element element, Modifier modifier) {
                Intrinsics.checkNotNullParameter(element, "this");
                Intrinsics.checkNotNullParameter(modifier, "other");
                return DefaultImpls.then(element, modifier);
            }

            public static <R> R foldIn(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(element, "this");
                Intrinsics.checkNotNullParameter(function2, "operation");
                return function2.invoke(r, element);
            }

            public static <R> R foldOut(Element element, R r, Function2<? super Element, ? super R, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(element, "this");
                Intrinsics.checkNotNullParameter(function2, "operation");
                return function2.invoke(element, r);
            }

            public static boolean any(Element element, Function1<? super Element, Boolean> function1) {
                Intrinsics.checkNotNullParameter(element, "this");
                Intrinsics.checkNotNullParameter(function1, "predicate");
                return function1.invoke(element).booleanValue();
            }

            public static boolean all(Element element, Function1<? super Element, Boolean> function1) {
                Intrinsics.checkNotNullParameter(element, "this");
                Intrinsics.checkNotNullParameter(function1, "predicate");
                return function1.invoke(element).booleanValue();
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u001c\u0010\b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ5\u0010\u000f\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/Modifier$Companion;", "Landroidx/compose/ui/Modifier;", "()V", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "toString", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Modifier.kt */
    public static final class Companion implements Modifier {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public boolean all(Function1<? super Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return true;
        }

        public boolean any(Function1<? super Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return false;
        }

        public <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return r;
        }

        public <R> R foldOut(R r, Function2<? super Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return r;
        }

        public Modifier then(Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return modifier;
        }

        public String toString() {
            return "Modifier";
        }

        private Companion() {
        }
    }
}
