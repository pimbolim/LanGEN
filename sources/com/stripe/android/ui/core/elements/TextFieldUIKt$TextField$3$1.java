package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.State;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
final class TextFieldUIKt$TextField$3$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ State<String> $contentDescription$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldUIKt$TextField$3$1(State<String> state) {
        super(1);
        this.$contentDescription$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, TextFieldUIKt.m4613TextField_6fMdlN4$lambda4(this.$contentDescription$delegate));
        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, new AnnotatedString("", (List) null, (List) null, 6, (DefaultConstructorMarker) null));
    }
}
