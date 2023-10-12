package kotlinx.serialization.encoding;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\bø\u0001\u0000\u001ab\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r24\b\u0004\u0010\u0007\u001a.\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\nH\bø\u0001\u0000\u001a1\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"encodeCollection", "", "Lkotlinx/serialization/encoding/Encoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "collectionSize", "", "block", "Lkotlin/Function1;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "Lkotlin/ExtensionFunctionType;", "E", "collection", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "index", "encodeStructure", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Encoding.kt */
public final class EncodingKt {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void encodeStructure(kotlinx.serialization.encoding.Encoder r1, kotlinx.serialization.descriptors.SerialDescriptor r2, kotlin.jvm.functions.Function1<? super kotlinx.serialization.encoding.CompositeEncoder, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlinx.serialization.encoding.CompositeEncoder r1 = r1.beginStructure(r2)
            r0 = 1
            r3.invoke(r1)     // Catch:{ all -> 0x0021 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r1.endStructure(r2)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            return
        L_0x0021:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.encoding.EncodingKt.encodeStructure(kotlinx.serialization.encoding.Encoder, kotlinx.serialization.descriptors.SerialDescriptor, kotlin.jvm.functions.Function1):void");
    }

    public static final void encodeCollection(Encoder encoder, SerialDescriptor serialDescriptor, int i, Function1<? super CompositeEncoder, Unit> function1) {
        Intrinsics.checkNotNullParameter(encoder, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(function1, "block");
        CompositeEncoder beginCollection = encoder.beginCollection(serialDescriptor, i);
        function1.invoke(beginCollection);
        beginCollection.endStructure(serialDescriptor);
    }

    public static final <E> void encodeCollection(Encoder encoder, SerialDescriptor serialDescriptor, Collection<? extends E> collection, Function3<? super CompositeEncoder, ? super Integer, ? super E, Unit> function3) {
        Intrinsics.checkNotNullParameter(encoder, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(function3, "block");
        CompositeEncoder beginCollection = encoder.beginCollection(serialDescriptor, collection.size());
        int i = 0;
        for (Object next : collection) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            function3.invoke(beginCollection, Integer.valueOf(i), next);
            i = i2;
        }
        beginCollection.endStructure(serialDescriptor);
    }
}
