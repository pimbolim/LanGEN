package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/InspectableValue;", "", "inspectableElements", "Lkotlin/sequences/Sequence;", "Landroidx/compose/ui/platform/ValueElement;", "getInspectableElements", "()Lkotlin/sequences/Sequence;", "nameFallback", "", "getNameFallback", "()Ljava/lang/String;", "valueOverride", "getValueOverride", "()Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public interface InspectableValue {
    Sequence<ValueElement> getInspectableElements();

    String getNameFallback();

    Object getValueOverride();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InspectableValue.kt */
    public static final class DefaultImpls {
        public static String getNameFallback(InspectableValue inspectableValue) {
            Intrinsics.checkNotNullParameter(inspectableValue, "this");
            return null;
        }

        public static Object getValueOverride(InspectableValue inspectableValue) {
            Intrinsics.checkNotNullParameter(inspectableValue, "this");
            return null;
        }

        public static Sequence<ValueElement> getInspectableElements(InspectableValue inspectableValue) {
            Intrinsics.checkNotNullParameter(inspectableValue, "this");
            return SequencesKt.emptySequence();
        }
    }
}
