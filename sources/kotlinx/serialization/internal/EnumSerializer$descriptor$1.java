package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Enums.kt */
final class EnumSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    final /* synthetic */ String $serialName;
    final /* synthetic */ EnumSerializer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnumSerializer$descriptor$1(EnumSerializer<T> enumSerializer, String str) {
        super(1);
        this.this$0 = enumSerializer;
        this.$serialName = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ClassSerialDescriptorBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        Enum[] access$getValues$p = this.this$0.values;
        String str = this.$serialName;
        int length = access$getValues$p.length;
        int i = 0;
        while (i < length) {
            Enum enumR = access$getValues$p[i];
            int i2 = i + 1;
            SerialDescriptor buildSerialDescriptor$default = SerialDescriptorsKt.buildSerialDescriptor$default(str + ClassUtils.PACKAGE_SEPARATOR_CHAR + enumR.name(), StructureKind.OBJECT.INSTANCE, new SerialDescriptor[0], (Function1) null, 8, (Object) null);
            ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, enumR.name(), buildSerialDescriptor$default, (List) null, false, 12, (Object) null);
            i = i2;
        }
    }
}
