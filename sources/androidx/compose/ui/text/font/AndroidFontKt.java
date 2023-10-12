package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.compose.ui.text.ExperimentalTextApi;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.common.util.UriUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u0012\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "assetManager", "Landroid/content/res/AssetManager;", "path", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-wCLgNak", "(Landroid/content/res/AssetManager;Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "Font-RetOiIg", "(Landroid/os/ParcelFileDescriptor;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "file", "Ljava/io/File;", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidFont.kt */
public final class AndroidFontKt {
    /* renamed from: Font-wCLgNak$default  reason: not valid java name */
    public static /* synthetic */ Font m3602FontwCLgNak$default(AssetManager assetManager, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 8) != 0) {
            i = FontStyle.Companion.m3617getNormal_LCdwA();
        }
        return m3601FontwCLgNak(assetManager, str, fontWeight, i);
    }

    @ExperimentalTextApi
    /* renamed from: Font-wCLgNak  reason: not valid java name */
    public static final Font m3601FontwCLgNak(AssetManager assetManager, String str, FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        return new AndroidAssetFont(assetManager, str, fontWeight, i, (DefaultConstructorMarker) null);
    }

    /* renamed from: Font-RetOiIg$default  reason: not valid java name */
    public static /* synthetic */ Font m3600FontRetOiIg$default(File file, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m3617getNormal_LCdwA();
        }
        return m3598FontRetOiIg(file, fontWeight, i);
    }

    @ExperimentalTextApi
    /* renamed from: Font-RetOiIg  reason: not valid java name */
    public static final Font m3598FontRetOiIg(File file, FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(file, UriUtil.LOCAL_FILE_SCHEME);
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        return new AndroidFileFont(file, fontWeight, i, (DefaultConstructorMarker) null);
    }

    /* renamed from: Font-RetOiIg$default  reason: not valid java name */
    public static /* synthetic */ Font m3599FontRetOiIg$default(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m3617getNormal_LCdwA();
        }
        return m3597FontRetOiIg(parcelFileDescriptor, fontWeight, i);
    }

    @ExperimentalTextApi
    /* renamed from: Font-RetOiIg  reason: not valid java name */
    public static final Font m3597FontRetOiIg(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "fileDescriptor");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        return new AndroidFileDescriptorFont(parcelFileDescriptor, fontWeight, i, (DefaultConstructorMarker) null);
    }
}
