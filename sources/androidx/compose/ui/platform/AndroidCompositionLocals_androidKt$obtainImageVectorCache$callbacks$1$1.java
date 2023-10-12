package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidCompositionLocals.android.kt */
public final class AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 implements ComponentCallbacks2 {
    final /* synthetic */ Ref.ObjectRef<Configuration> $currentConfiguration;
    final /* synthetic */ ImageVectorCache $imageVectorCache;

    AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1(Ref.ObjectRef<Configuration> objectRef, ImageVectorCache imageVectorCache) {
        this.$currentConfiguration = objectRef;
        this.$imageVectorCache = imageVectorCache;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Configuration configuration2 = (Configuration) this.$currentConfiguration.element;
        this.$imageVectorCache.prune(configuration2 == null ? -1 : configuration2.updateFrom(configuration));
        this.$currentConfiguration.element = configuration;
    }

    public void onLowMemory() {
        this.$imageVectorCache.clear();
    }

    public void onTrimMemory(int i) {
        this.$imageVectorCache.clear();
    }
}
