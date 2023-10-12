package androidx.compose.material;

import androidx.compose.animation.core.KeyframesSpec;
import com.drew.metadata.iptc.IptcDirectory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$startAngle$2 extends Lambda implements Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit> {
    public static final ProgressIndicatorKt$CircularProgressIndicator$startAngle$2 INSTANCE = new ProgressIndicatorKt$CircularProgressIndicator$startAngle$2();

    ProgressIndicatorKt$CircularProgressIndicator$startAngle$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) (KeyframesSpec.KeyframesSpecConfig) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
        Intrinsics.checkNotNullParameter(keyframesSpecConfig, "$this$keyframes");
        keyframesSpecConfig.setDurationMillis(1332);
        keyframesSpecConfig.with(keyframesSpecConfig.at(Float.valueOf(0.0f), IptcDirectory.TAG_AUDIO_OUTCUE), ProgressIndicatorKt.CircularEasing);
        keyframesSpecConfig.at(Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
    }
}
