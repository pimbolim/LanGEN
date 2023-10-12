package androidx.compose.ui.text.android;

import android.text.Layout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/android/TextAlignmentAdapter;", "", "()V", "ALIGN_LEFT_FRAMEWORK", "Landroid/text/Layout$Alignment;", "ALIGN_RIGHT_FRAMEWORK", "get", "value", "", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextLayout.kt */
public final class TextAlignmentAdapter {
    private static final Layout.Alignment ALIGN_LEFT_FRAMEWORK;
    private static final Layout.Alignment ALIGN_RIGHT_FRAMEWORK;
    public static final TextAlignmentAdapter INSTANCE = new TextAlignmentAdapter();

    private TextAlignmentAdapter() {
    }

    static {
        Layout.Alignment[] values = Layout.Alignment.values();
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        Layout.Alignment alignment2 = Layout.Alignment.ALIGN_NORMAL;
        int length = values.length;
        int i = 0;
        while (i < length) {
            Layout.Alignment alignment3 = values[i];
            i++;
            if (Intrinsics.areEqual((Object) alignment3.name(), (Object) "ALIGN_LEFT")) {
                alignment = alignment3;
            } else if (Intrinsics.areEqual((Object) alignment3.name(), (Object) "ALIGN_RIGHT")) {
                alignment2 = alignment3;
            }
        }
        ALIGN_LEFT_FRAMEWORK = alignment;
        ALIGN_RIGHT_FRAMEWORK = alignment2;
    }

    public final Layout.Alignment get(int i) {
        if (i == 0) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (i == 1) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (i == 2) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (i == 3) {
            return ALIGN_LEFT_FRAMEWORK;
        }
        if (i != 4) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        return ALIGN_RIGHT_FRAMEWORK;
    }
}
