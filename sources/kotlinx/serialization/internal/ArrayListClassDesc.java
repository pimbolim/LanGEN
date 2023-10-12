package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/serialization/internal/ArrayListClassDesc;", "Lkotlinx/serialization/internal/ListLikeDescriptor;", "elementDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "serialName", "", "getSerialName", "()Ljava/lang/String;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionDescriptors.kt */
public final class ArrayListClassDesc extends ListLikeDescriptor {
    public String getSerialName() {
        return CollectionDescriptorsKt.ARRAY_LIST_NAME;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArrayListClassDesc(SerialDescriptor serialDescriptor) {
        super(serialDescriptor, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(serialDescriptor, "elementDesc");
    }
}
