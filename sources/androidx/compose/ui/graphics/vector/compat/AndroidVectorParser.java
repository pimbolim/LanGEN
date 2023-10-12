package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0014J\u001e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0014J\u001e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J0\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020 2\u0006\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u0005J8\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020 2\u0006\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u00052\b\b\u0001\u0010\u001a\u001a\u00020\u0005J(\u0010&\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0014J(\u0010'\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u0018\u0010(\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\t\u0010)\u001a\u00020\u0005HÖ\u0001J,\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020 2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020 2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\t\u00100\u001a\u00020\"HÖ\u0001J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u00064"}, d2 = {"Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "", "xmlParser", "Lorg/xmlpull/v1/XmlPullParser;", "config", "", "(Lorg/xmlpull/v1/XmlPullParser;I)V", "getConfig", "()I", "setConfig", "(I)V", "getXmlParser", "()Lorg/xmlpull/v1/XmlPullParser;", "component1", "component2", "copy", "equals", "", "other", "getDimension", "", "typedArray", "Landroid/content/res/TypedArray;", "index", "defValue", "getFloat", "defaultValue", "getInt", "getNamedColorStateList", "Landroid/content/res/ColorStateList;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "attrName", "", "resId", "getNamedComplexColor", "Landroidx/core/content/res/ComplexColorCompat;", "getNamedFloat", "getNamedInt", "getString", "hashCode", "obtainAttributes", "res", "set", "Landroid/util/AttributeSet;", "attrs", "", "toString", "updateConfig", "", "resConfig", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XmlVectorParser.android.kt */
public final class AndroidVectorParser {
    private int config;
    private final XmlPullParser xmlParser;

    public static /* synthetic */ AndroidVectorParser copy$default(AndroidVectorParser androidVectorParser, XmlPullParser xmlPullParser, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            xmlPullParser = androidVectorParser.xmlParser;
        }
        if ((i2 & 2) != 0) {
            i = androidVectorParser.config;
        }
        return androidVectorParser.copy(xmlPullParser, i);
    }

    public final XmlPullParser component1() {
        return this.xmlParser;
    }

    public final int component2() {
        return this.config;
    }

    public final AndroidVectorParser copy(XmlPullParser xmlPullParser, int i) {
        Intrinsics.checkNotNullParameter(xmlPullParser, "xmlParser");
        return new AndroidVectorParser(xmlPullParser, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidVectorParser)) {
            return false;
        }
        AndroidVectorParser androidVectorParser = (AndroidVectorParser) obj;
        return Intrinsics.areEqual((Object) this.xmlParser, (Object) androidVectorParser.xmlParser) && this.config == androidVectorParser.config;
    }

    public int hashCode() {
        return (this.xmlParser.hashCode() * 31) + this.config;
    }

    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.xmlParser + ", config=" + this.config + ')';
    }

    public AndroidVectorParser(XmlPullParser xmlPullParser, int i) {
        Intrinsics.checkNotNullParameter(xmlPullParser, "xmlParser");
        this.xmlParser = xmlPullParser;
        this.config = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidVectorParser(XmlPullParser xmlPullParser, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(xmlPullParser, (i2 & 2) != 0 ? 0 : i);
    }

    public final XmlPullParser getXmlParser() {
        return this.xmlParser;
    }

    public final int getConfig() {
        return this.config;
    }

    public final void setConfig(int i) {
        this.config = i;
    }

    private final void updateConfig(int i) {
        this.config = i | this.config;
    }

    public final TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        Intrinsics.checkNotNullParameter(resources, UriUtil.LOCAL_RESOURCE_SCHEME);
        Intrinsics.checkNotNullParameter(attributeSet, "set");
        Intrinsics.checkNotNullParameter(iArr, "attrs");
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, iArr);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(\n      …          attrs\n        )");
        updateConfig(obtainAttributes.getChangingConfigurations());
        return obtainAttributes;
    }

    public final int getNamedInt(TypedArray typedArray, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(str, "attrName");
        int namedInt = TypedArrayUtils.getNamedInt(typedArray, getXmlParser(), str, i, i2);
        updateConfig(typedArray.getChangingConfigurations());
        return namedInt;
    }

    public final float getNamedFloat(TypedArray typedArray, String str, int i, float f) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(str, "attrName");
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, getXmlParser(), str, i, f);
        updateConfig(typedArray.getChangingConfigurations());
        return namedFloat;
    }

    public final float getFloat(TypedArray typedArray, int i, float f) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        float f2 = typedArray.getFloat(i, f);
        updateConfig(typedArray.getChangingConfigurations());
        return f2;
    }

    public final int getInt(TypedArray typedArray, int i, int i2) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        int i3 = typedArray.getInt(i, i2);
        updateConfig(typedArray.getChangingConfigurations());
        return i3;
    }

    public final String getString(TypedArray typedArray, int i) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        String string = typedArray.getString(i);
        updateConfig(typedArray.getChangingConfigurations());
        return string;
    }

    public final float getDimension(TypedArray typedArray, int i, float f) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        float dimension = typedArray.getDimension(i, f);
        updateConfig(typedArray.getChangingConfigurations());
        return dimension;
    }

    public final ComplexColorCompat getNamedComplexColor(TypedArray typedArray, Resources.Theme theme, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(str, "attrName");
        ComplexColorCompat namedComplexColor = TypedArrayUtils.getNamedComplexColor(typedArray, getXmlParser(), theme, str, i, i2);
        updateConfig(typedArray.getChangingConfigurations());
        Intrinsics.checkNotNullExpressionValue(namedComplexColor, "result");
        return namedComplexColor;
    }

    public final ColorStateList getNamedColorStateList(TypedArray typedArray, Resources.Theme theme, String str, int i) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(str, "attrName");
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, getXmlParser(), theme, str, i);
        updateConfig(typedArray.getChangingConfigurations());
        return namedColorStateList;
    }
}
