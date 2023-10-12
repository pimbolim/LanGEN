package androidx.compose.ui.input.nestedscroll;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection", f = "NestedScrollDelegatingWrapper.kt", i = {0, 0, 0, 1}, l = {187, 188}, m = "onPostFling-RZ2iAVY", n = {"this", "consumed", "available", "selfConsumed"}, s = {"L$0", "J$0", "J$1", "J$0"})
/* compiled from: NestedScrollDelegatingWrapper.kt */
final class ParentWrapperNestedScrollConnection$onPostFling$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ParentWrapperNestedScrollConnection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ParentWrapperNestedScrollConnection$onPostFling$1(ParentWrapperNestedScrollConnection parentWrapperNestedScrollConnection, Continuation<? super ParentWrapperNestedScrollConnection$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = parentWrapperNestedScrollConnection;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m2891onPostFlingRZ2iAVY(0, 0, this);
    }
}
