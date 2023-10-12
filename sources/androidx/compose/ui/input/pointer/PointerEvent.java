package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001f\u001a\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b \u0010\fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001e\u0010\"\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001c\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@@X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Ljava/util/List;)V", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "buttons", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getButtons-ry648PA", "()I", "I", "getChanges", "()Ljava/util/List;", "getInternalPointerEvent$ui_release", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent$ui_release", "()Landroid/view/MotionEvent;", "<set-?>", "Landroidx/compose/ui/input/pointer/PointerEventType;", "type", "getType-7fucELk", "setType-EhbLWgg$ui_release", "(I)V", "calculatePointerEventType", "calculatePointerEventType-7fucELk", "component1", "copy", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PointerEvent.android.kt */
public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;
    private final List<PointerInputChange> changes;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public PointerEvent(List<PointerInputChange> list, InternalPointerEvent internalPointerEvent2) {
        Intrinsics.checkNotNullParameter(list, "changes");
        this.changes = list;
        this.internalPointerEvent = internalPointerEvent2;
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        int i = 0;
        this.buttons = PointerButtons.m2916constructorimpl(motionEvent$ui_release == null ? 0 : motionEvent$ui_release.getButtonState());
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        this.keyboardModifiers = PointerKeyboardModifiers.m3028constructorimpl(motionEvent$ui_release2 != null ? motionEvent$ui_release2.getMetaState() : i);
        this.type = m2922calculatePointerEventType7fucELk();
    }

    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    public final InternalPointerEvent getInternalPointerEvent$ui_release() {
        return this.internalPointerEvent;
    }

    public final MotionEvent getMotionEvent$ui_release() {
        InternalPointerEvent internalPointerEvent2 = this.internalPointerEvent;
        if (internalPointerEvent2 == null) {
            return null;
        }
        return internalPointerEvent2.getMotionEvent();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PointerEvent(List<PointerInputChange> list) {
        this(list, (InternalPointerEvent) null);
        Intrinsics.checkNotNullParameter(list, "changes");
    }

    /* renamed from: getButtons-ry648PA  reason: not valid java name */
    public final int m2923getButtonsry648PA() {
        return this.buttons;
    }

    /* renamed from: getKeyboardModifiers-k7X9c1A  reason: not valid java name */
    public final int m2924getKeyboardModifiersk7X9c1A() {
        return this.keyboardModifiers;
    }

    /* renamed from: getType-7fucELk  reason: not valid java name */
    public final int m2925getType7fucELk() {
        return this.type;
    }

    /* renamed from: setType-EhbLWgg$ui_release  reason: not valid java name */
    public final void m2926setTypeEhbLWgg$ui_release(int i) {
        this.type = i;
    }

    /* renamed from: calculatePointerEventType-7fucELk  reason: not valid java name */
    private final int m2922calculatePointerEventType7fucELk() {
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        if (motionEvent$ui_release != null) {
            int actionMasked = motionEvent$ui_release.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        switch (actionMasked) {
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                return PointerEventType.Companion.m2942getScroll7fucELk();
                            case 9:
                                return PointerEventType.Companion.m2937getEnter7fucELk();
                            case 10:
                                return PointerEventType.Companion.m2938getExit7fucELk();
                            default:
                                return PointerEventType.Companion.m2943getUnknown7fucELk();
                        }
                    }
                    return PointerEventType.Companion.m2939getMove7fucELk();
                }
                return PointerEventType.Companion.m2941getRelease7fucELk();
            }
            return PointerEventType.Companion.m2940getPress7fucELk();
        }
        List<PointerInputChange> list = this.changes;
        int i = 0;
        int size = list.size();
        while (i < size) {
            int i2 = i + 1;
            PointerInputChange pointerInputChange = list.get(i);
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.Companion.m2941getRelease7fucELk();
            }
            if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.Companion.m2940getPress7fucELk();
            }
            i = i2;
        }
        return PointerEventType.Companion.m2939getMove7fucELk();
    }

    public final List<PointerInputChange> component1() {
        return this.changes;
    }

    public final PointerEvent copy(List<PointerInputChange> list, MotionEvent motionEvent) {
        List<PointerInputChange> list2 = list;
        MotionEvent motionEvent2 = motionEvent;
        Intrinsics.checkNotNullParameter(list2, "changes");
        if (motionEvent2 == null) {
            return new PointerEvent(list2, (InternalPointerEvent) null);
        } else if (Intrinsics.areEqual((Object) motionEvent2, (Object) getMotionEvent$ui_release())) {
            return new PointerEvent(list2, this.internalPointerEvent);
        } else {
            Map linkedHashMap = new LinkedHashMap();
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                PointerInputChange pointerInputChange = list2.get(i);
                linkedHashMap.put(PointerId.m2963boximpl(pointerInputChange.m2977getIdJ3iCeTQ()), pointerInputChange);
                i = i2;
            }
            ArrayList arrayList = new ArrayList(list.size());
            int size2 = list.size();
            int i3 = 0;
            while (i3 < size2) {
                int i4 = i3 + 1;
                Collection collection = arrayList;
                PointerInputChange pointerInputChange2 = list2.get(i3);
                long r11 = pointerInputChange2.m2977getIdJ3iCeTQ();
                long uptimeMillis = pointerInputChange2.getUptimeMillis();
                long r16 = pointerInputChange2.m2978getPositionF1C5BW0();
                long r18 = pointerInputChange2.m2978getPositionF1C5BW0();
                boolean pressed = pointerInputChange2.getPressed();
                int r21 = pointerInputChange2.m2981getTypeT8wyACA();
                InternalPointerEvent internalPointerEvent$ui_release = getInternalPointerEvent$ui_release();
                boolean z = true;
                int i5 = size2;
                if (internalPointerEvent$ui_release == null || !internalPointerEvent$ui_release.m2912issuesEnterExitEvent0FcD4WY(pointerInputChange2.m2977getIdJ3iCeTQ())) {
                    z = false;
                }
                PointerInputEventData pointerInputEventData = r10;
                PointerInputEventData pointerInputEventData2 = new PointerInputEventData(r11, uptimeMillis, r16, r18, pressed, r21, z, (List) null, 0, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, (DefaultConstructorMarker) null);
                collection.add(pointerInputEventData);
                i3 = i4;
                size2 = i5;
            }
            return new PointerEvent(list2, new InternalPointerEvent(linkedHashMap, new PointerInputEvent(motionEvent.getEventTime(), arrayList, motionEvent2)));
        }
    }
}
