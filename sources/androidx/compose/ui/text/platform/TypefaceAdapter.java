package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import androidx.collection.LruCache;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.DefaultFontFamily;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.LoadedFontFamily;
import androidx.compose.ui.text.font.ResourceFont;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J?\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J5\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/platform/TypefaceAdapter;", "", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/font/FontMatcher;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "create", "Landroid/graphics/Typeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "create-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "create-xC2X5gM", "(ILandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontListFontFamily;I)Landroid/graphics/Typeface;", "genericFontFamily", "", "create-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "CacheKey", "Companion", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TypefaceAdapter.android.kt */
public class TypefaceAdapter {
    /* access modifiers changed from: private */
    public static final FontWeight ANDROID_BOLD = FontWeight.Companion.getW600();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final LruCache<CacheKey, Typeface> typefaceCache = new LruCache<>(16);
    private final FontMatcher fontMatcher;
    private final Font.ResourceLoader resourceLoader;

    public TypefaceAdapter(FontMatcher fontMatcher2, Font.ResourceLoader resourceLoader2) {
        Intrinsics.checkNotNullParameter(fontMatcher2, "fontMatcher");
        Intrinsics.checkNotNullParameter(resourceLoader2, "resourceLoader");
        this.fontMatcher = fontMatcher2;
        this.resourceLoader = resourceLoader2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypefaceAdapter(FontMatcher fontMatcher2, Font.ResourceLoader resourceLoader2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new FontMatcher() : fontMatcher2, resourceLoader2);
    }

    public final FontMatcher getFontMatcher() {
        return this.fontMatcher;
    }

    public final Font.ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B,\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0015\u001a\u00020\u0007HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u000eJ\u0019\u0010\u0017\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u000eJ@\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/ui/text/platform/TypefaceAdapter$CacheKey;", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontStyle-_-LCdwA", "()I", "I", "getFontSynthesis-GVVA2EU", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "component1", "component2", "component3", "component3-_-LCdwA", "component4", "component4-GVVA2EU", "copy", "copy-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/ui/text/platform/TypefaceAdapter$CacheKey;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TypefaceAdapter.android.kt */
    public static final class CacheKey {
        private final FontFamily fontFamily;
        private final int fontStyle;
        private final int fontSynthesis;
        private final FontWeight fontWeight;

        public /* synthetic */ CacheKey(FontFamily fontFamily2, FontWeight fontWeight2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(fontFamily2, fontWeight2, i, i2);
        }

        /* renamed from: copy-DPcqOEQ$default  reason: not valid java name */
        public static /* synthetic */ CacheKey m3717copyDPcqOEQ$default(CacheKey cacheKey, FontFamily fontFamily2, FontWeight fontWeight2, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                fontFamily2 = cacheKey.fontFamily;
            }
            if ((i3 & 2) != 0) {
                fontWeight2 = cacheKey.fontWeight;
            }
            if ((i3 & 4) != 0) {
                i = cacheKey.fontStyle;
            }
            if ((i3 & 8) != 0) {
                i2 = cacheKey.fontSynthesis;
            }
            return cacheKey.m3720copyDPcqOEQ(fontFamily2, fontWeight2, i, i2);
        }

        public final FontFamily component1() {
            return this.fontFamily;
        }

        public final FontWeight component2() {
            return this.fontWeight;
        }

        /* renamed from: component3-_-LCdwA  reason: not valid java name */
        public final int m3718component3_LCdwA() {
            return this.fontStyle;
        }

        /* renamed from: component4-GVVA2EU  reason: not valid java name */
        public final int m3719component4GVVA2EU() {
            return this.fontSynthesis;
        }

        /* renamed from: copy-DPcqOEQ  reason: not valid java name */
        public final CacheKey m3720copyDPcqOEQ(FontFamily fontFamily2, FontWeight fontWeight2, int i, int i2) {
            Intrinsics.checkNotNullParameter(fontWeight2, ViewProps.FONT_WEIGHT);
            return new CacheKey(fontFamily2, fontWeight2, i, i2, (DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) obj;
            return Intrinsics.areEqual((Object) this.fontFamily, (Object) cacheKey.fontFamily) && Intrinsics.areEqual((Object) this.fontWeight, (Object) cacheKey.fontWeight) && FontStyle.m3612equalsimpl0(this.fontStyle, cacheKey.fontStyle) && FontSynthesis.m3621equalsimpl0(this.fontSynthesis, cacheKey.fontSynthesis);
        }

        public int hashCode() {
            FontFamily fontFamily2 = this.fontFamily;
            return ((((((fontFamily2 == null ? 0 : fontFamily2.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + FontStyle.m3613hashCodeimpl(this.fontStyle)) * 31) + FontSynthesis.m3622hashCodeimpl(this.fontSynthesis);
        }

        public String toString() {
            return "CacheKey(fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", fontStyle=" + FontStyle.m3614toStringimpl(this.fontStyle) + ", fontSynthesis=" + FontSynthesis.m3625toStringimpl(this.fontSynthesis) + ')';
        }

        private CacheKey(FontFamily fontFamily2, FontWeight fontWeight2, int i, int i2) {
            this.fontFamily = fontFamily2;
            this.fontWeight = fontWeight2;
            this.fontStyle = i;
            this.fontSynthesis = i2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CacheKey(FontFamily fontFamily2, FontWeight fontWeight2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : fontFamily2, fontWeight2, i, i2, (DefaultConstructorMarker) null);
        }

        public final FontFamily getFontFamily() {
            return this.fontFamily;
        }

        public final FontWeight getFontWeight() {
            return this.fontWeight;
        }

        /* renamed from: getFontStyle-_-LCdwA  reason: not valid java name */
        public final int m3721getFontStyle_LCdwA() {
            return this.fontStyle;
        }

        /* renamed from: getFontSynthesis-GVVA2EU  reason: not valid java name */
        public final int m3722getFontSynthesisGVVA2EU() {
            return this.fontSynthesis;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J;\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/text/platform/TypefaceAdapter$Companion;", "", "()V", "ANDROID_BOLD", "Landroidx/compose/ui/text/font/FontWeight;", "typefaceCache", "Landroidx/collection/LruCache;", "Landroidx/compose/ui/text/platform/TypefaceAdapter$CacheKey;", "Landroid/graphics/Typeface;", "getTypefaceCache", "()Landroidx/collection/LruCache;", "getTypefaceStyle", "", "fontWeight", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "getTypefaceStyle-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)I", "isBold", "", "isItalic", "synthesize", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "synthesize-Wqqsr6A", "(Landroid/graphics/Typeface;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TypefaceAdapter.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int getTypefaceStyle(boolean z, boolean z2) {
            if (z2 && z) {
                return 3;
            }
            if (z) {
                return 1;
            }
            return z2 ? 2 : 0;
        }

        private Companion() {
        }

        public final LruCache<CacheKey, Typeface> getTypefaceCache() {
            return TypefaceAdapter.typefaceCache;
        }

        /* renamed from: synthesize-Wqqsr6A  reason: not valid java name */
        public final Typeface m3724synthesizeWqqsr6A(Typeface typeface, Font font, FontWeight fontWeight, int i, int i2) {
            int i3;
            boolean z;
            Intrinsics.checkNotNullParameter(typeface, "typeface");
            Intrinsics.checkNotNullParameter(font, "font");
            Intrinsics.checkNotNullParameter(fontWeight, ViewProps.FONT_WEIGHT);
            boolean z2 = true;
            boolean z3 = FontSynthesis.m3624isWeightOnimpl$ui_text_release(i2) && fontWeight.compareTo(TypefaceAdapter.ANDROID_BOLD) >= 0 && font.getWeight().compareTo(TypefaceAdapter.ANDROID_BOLD) < 0;
            boolean z4 = FontSynthesis.m3623isStyleOnimpl$ui_text_release(i2) && !FontStyle.m3612equalsimpl0(i, font.m3603getStyle_LCdwA());
            if (!z4 && !z3) {
                return typeface;
            }
            if (Build.VERSION.SDK_INT < 28) {
                if (!z4 || !FontStyle.m3612equalsimpl0(i, FontStyle.Companion.m3616getItalic_LCdwA())) {
                    z2 = false;
                }
                Typeface create = Typeface.create(typeface, getTypefaceStyle(z3, z2));
                Intrinsics.checkNotNullExpressionValue(create, "{\n                val ta…argetStyle)\n            }");
                return create;
            }
            if (z3) {
                i3 = fontWeight.getWeight();
            } else {
                i3 = font.getWeight().getWeight();
            }
            if (z4) {
                z = FontStyle.m3612equalsimpl0(i, FontStyle.Companion.m3616getItalic_LCdwA());
            } else {
                z = FontStyle.m3612equalsimpl0(font.m3603getStyle_LCdwA(), FontStyle.Companion.m3616getItalic_LCdwA());
            }
            return TypefaceAdapterHelperMethods.INSTANCE.create(typeface, i3, z);
        }

        /* renamed from: getTypefaceStyle-FO1MlWM  reason: not valid java name */
        public final int m3723getTypefaceStyleFO1MlWM(FontWeight fontWeight, int i) {
            Intrinsics.checkNotNullParameter(fontWeight, ViewProps.FONT_WEIGHT);
            return getTypefaceStyle(fontWeight.compareTo(TypefaceAdapter.ANDROID_BOLD) >= 0, FontStyle.m3612equalsimpl0(i, FontStyle.Companion.m3616getItalic_LCdwA()));
        }
    }

    /* renamed from: create-DPcqOEQ$default  reason: not valid java name */
    public static /* synthetic */ Typeface m3711createDPcqOEQ$default(TypefaceAdapter typefaceAdapter, FontFamily fontFamily, FontWeight fontWeight, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                fontFamily = null;
            }
            if ((i3 & 2) != 0) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            if ((i3 & 4) != 0) {
                i = FontStyle.Companion.m3617getNormal_LCdwA();
            }
            if ((i3 & 8) != 0) {
                i2 = FontSynthesis.Companion.m3627getAllGVVA2EU();
            }
            return typefaceAdapter.m3716createDPcqOEQ(fontFamily, fontWeight, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create-DPcqOEQ");
    }

    /* renamed from: create-DPcqOEQ  reason: not valid java name */
    public Typeface m3716createDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int i, int i2) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(fontWeight, ViewProps.FONT_WEIGHT);
        CacheKey cacheKey = new CacheKey(fontFamily, fontWeight, i, i2, (DefaultConstructorMarker) null);
        LruCache<CacheKey, Typeface> lruCache = typefaceCache;
        Typeface typeface2 = lruCache.get(cacheKey);
        if (typeface2 != null) {
            return typeface2;
        }
        if (fontFamily instanceof FontListFontFamily) {
            typeface = m3714createxC2X5gM(i, fontWeight, (FontListFontFamily) fontFamily, i2);
        } else if (fontFamily instanceof GenericFontFamily) {
            typeface = m3712createRetOiIg(((GenericFontFamily) fontFamily).getName(), fontWeight, i);
        } else {
            boolean z = true;
            if (!(fontFamily instanceof DefaultFontFamily) && fontFamily != null) {
                z = false;
            }
            if (z) {
                typeface = m3712createRetOiIg((String) null, fontWeight, i);
            } else if (fontFamily instanceof LoadedFontFamily) {
                typeface = ((AndroidTypeface) ((LoadedFontFamily) fontFamily).getTypeface()).m3709getNativeTypefacePYhJU0U(fontWeight, i, i2);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        lruCache.put(cacheKey, typeface);
        return typeface;
    }

    /* renamed from: create-RetOiIg$default  reason: not valid java name */
    static /* synthetic */ Typeface m3713createRetOiIg$default(TypefaceAdapter typefaceAdapter, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            if ((i2 & 2) != 0) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            if ((i2 & 4) != 0) {
                i = FontStyle.Companion.m3617getNormal_LCdwA();
            }
            return typefaceAdapter.m3712createRetOiIg(str, fontWeight, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create-RetOiIg");
    }

    /* renamed from: create-RetOiIg  reason: not valid java name */
    private final Typeface m3712createRetOiIg(String str, FontWeight fontWeight, int i) {
        Typeface typeface;
        Typeface typeface2;
        boolean z = true;
        if (FontStyle.m3612equalsimpl0(i, FontStyle.Companion.m3617getNormal_LCdwA()) && Intrinsics.areEqual((Object) fontWeight, (Object) FontWeight.Companion.getNormal())) {
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                Typeface typeface3 = Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(typeface3, "DEFAULT");
                return typeface3;
            }
        }
        if (Build.VERSION.SDK_INT < 28) {
            int r6 = Companion.m3723getTypefaceStyleFO1MlWM(fontWeight, i);
            CharSequence charSequence2 = str;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            if (z) {
                typeface2 = Typeface.defaultFromStyle(r6);
            } else {
                typeface2 = Typeface.create(str, r6);
            }
            Intrinsics.checkNotNullExpressionValue(typeface2, "{\n            val target…)\n            }\n        }");
            return typeface2;
        }
        if (str == null) {
            typeface = Typeface.DEFAULT;
        } else {
            typeface = Typeface.create(str, 0);
        }
        TypefaceAdapterHelperMethods typefaceAdapterHelperMethods = TypefaceAdapterHelperMethods.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(typeface, "familyTypeface");
        return typefaceAdapterHelperMethods.create(typeface, fontWeight.getWeight(), FontStyle.m3612equalsimpl0(i, FontStyle.Companion.m3616getItalic_LCdwA()));
    }

    /* renamed from: create-xC2X5gM$default  reason: not valid java name */
    static /* synthetic */ Typeface m3715createxC2X5gM$default(TypefaceAdapter typefaceAdapter, int i, FontWeight fontWeight, FontListFontFamily fontListFontFamily, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = FontStyle.Companion.m3617getNormal_LCdwA();
            }
            if ((i3 & 2) != 0) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            if ((i3 & 8) != 0) {
                i2 = FontSynthesis.Companion.m3627getAllGVVA2EU();
            }
            return typefaceAdapter.m3714createxC2X5gM(i, fontWeight, fontListFontFamily, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create-xC2X5gM");
    }

    /* renamed from: create-xC2X5gM  reason: not valid java name */
    private final Typeface m3714createxC2X5gM(int i, FontWeight fontWeight, FontListFontFamily fontListFontFamily, int i2) {
        Typeface typeface;
        Font r3 = this.fontMatcher.m3607matchFontRetOiIg(fontListFontFamily, fontWeight, i);
        try {
            if (r3 instanceof ResourceFont) {
                typeface = (Typeface) this.resourceLoader.load(r3);
            } else if (r3 instanceof AndroidFont) {
                typeface = ((AndroidFont) r3).getTypeface();
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Unknown font type: ", r3));
            }
            Typeface typeface2 = typeface;
            return (FontSynthesis.m3621equalsimpl0(i2, FontSynthesis.Companion.m3628getNoneGVVA2EU()) || (Intrinsics.areEqual((Object) fontWeight, (Object) r3.getWeight()) && FontStyle.m3612equalsimpl0(i, r3.m3603getStyle_LCdwA()))) ? typeface2 : Companion.m3724synthesizeWqqsr6A(typeface2, r3, fontWeight, i, i2);
        } catch (Exception e) {
            throw new IllegalStateException(Intrinsics.stringPlus("Cannot create Typeface from ", r3), e);
        }
    }
}
