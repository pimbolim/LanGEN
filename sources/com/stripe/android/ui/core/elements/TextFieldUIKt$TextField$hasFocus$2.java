package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
final class TextFieldUIKt$TextField$hasFocus$2 extends Lambda implements Function0<MutableState<Boolean>> {
    public static final TextFieldUIKt$TextField$hasFocus$2 INSTANCE = new TextFieldUIKt$TextField$hasFocus$2();

    TextFieldUIKt$TextField$hasFocus$2() {
        super(0);
    }

    public final MutableState<Boolean> invoke() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
