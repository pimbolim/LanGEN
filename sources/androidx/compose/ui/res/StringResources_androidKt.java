package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0017\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\n\u001a+\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0004\"\u00020\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"resources", "Landroid/content/res/Resources;", "(Landroidx/compose/runtime/Composer;I)Landroid/content/res/Resources;", "stringArrayResource", "", "", "id", "", "(ILandroidx/compose/runtime/Composer;I)[Ljava/lang/String;", "stringResource", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StringResources.android.kt */
public final class StringResources_androidKt {
    public static final String stringResource(int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 383449052, "C(stringResource)35@1191L11:StringResources.android.kt#ccshc7");
        String string = resources(composer, 0).getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id)");
        ComposerKt.sourceInformationMarkerEnd(composer);
        return string;
    }

    public static final String stringResource(int i, Object[] objArr, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(objArr, "formatArgs");
        ComposerKt.sourceInformationMarkerStart(composer, 383449392, "C(stringResource)P(1)49@1555L11:StringResources.android.kt#ccshc7");
        String string = resources(composer, 0).getString(i, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id, *formatArgs)");
        ComposerKt.sourceInformationMarkerEnd(composer);
        return string;
    }

    public static final String[] stringArrayResource(int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1290743174, "C(stringArrayResource)62@1861L11:StringResources.android.kt#ccshc7");
        String[] stringArray = resources(composer, 0).getStringArray(i);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(id)");
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stringArray;
    }

    private static final Resources resources(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 722335777, "C(resources)73@2131L7,74@2163L7:StringResources.android.kt#ccshc7");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Resources resources = ((Context) consume).getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "LocalContext.current.resources");
        ComposerKt.sourceInformationMarkerEnd(composer);
        return resources;
    }
}
