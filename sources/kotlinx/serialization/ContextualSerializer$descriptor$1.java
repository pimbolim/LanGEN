package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContextualSerializer.kt */
final class ContextualSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    final /* synthetic */ ContextualSerializer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextualSerializer$descriptor$1(ContextualSerializer<T> contextualSerializer) {
        super(1);
        this.this$0 = contextualSerializer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ClassSerialDescriptorBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        SerialDescriptor descriptor;
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        KSerializer access$getFallbackSerializer$p = this.this$0.fallbackSerializer;
        List<Annotation> list = null;
        if (!(access$getFallbackSerializer$p == null || (descriptor = access$getFallbackSerializer$p.getDescriptor()) == null)) {
            list = descriptor.getAnnotations();
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        classSerialDescriptorBuilder.setAnnotations(list);
    }
}
