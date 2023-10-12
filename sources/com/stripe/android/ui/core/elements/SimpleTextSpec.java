package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 02\u00020\u0001:\u00010B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0018\u001a\u00020\u0007HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u000eJ\u0019\u0010\u001a\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JH\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001J\u001e\u0010'\u001a\u00020(2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010&0*J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, d2 = {"Lcom/stripe/android/ui/core/elements/SimpleTextSpec;", "Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "label", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "showOptionalLabel", "", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;IIIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCapitalization-IUNYP9k", "()I", "I", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getKeyboardType-PjHm6EE", "getLabel", "getShowOptionalLabel", "()Z", "component1", "component2", "component3", "component3-IUNYP9k", "component4", "component4-PjHm6EE", "component5", "copy", "copy-25FCGzQ", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;IIIZ)Lcom/stripe/android/ui/core/elements/SimpleTextSpec;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "transform", "Lcom/stripe/android/ui/core/elements/SectionSingleFieldElement;", "initialValues", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleTextSpec.kt */
public final class SimpleTextSpec extends SectionFieldSpec {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SimpleTextSpec> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final SimpleTextSpec NAME = new SimpleTextSpec(IdentifierSpec.Name.INSTANCE, R.string.address_label_name, KeyboardCapitalization.Companion.m3667getWordsIUNYP9k(), KeyboardType.Companion.m3681getTextPjHm6EE(), false, 16, (DefaultConstructorMarker) null);
    private final int capitalization;
    private final IdentifierSpec identifier;
    private final int keyboardType;
    private final int label;
    private final boolean showOptionalLabel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SimpleTextSpec.kt */
    public static final class Creator implements Parcelable.Creator<SimpleTextSpec> {
        public final SimpleTextSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SimpleTextSpec((IdentifierSpec) parcel.readParcelable(SimpleTextSpec.class.getClassLoader()), parcel.readInt(), ((KeyboardCapitalization) parcel.readValue(SimpleTextSpec.class.getClassLoader())).m3663unboximpl(), ((KeyboardType) parcel.readValue(SimpleTextSpec.class.getClassLoader())).m3674unboximpl(), parcel.readInt() != 0, (DefaultConstructorMarker) null);
        }

        public final SimpleTextSpec[] newArray(int i) {
            return new SimpleTextSpec[i];
        }
    }

    public /* synthetic */ SimpleTextSpec(IdentifierSpec identifierSpec, int i, int i2, int i3, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec, i, i2, i3, z);
    }

    /* renamed from: copy-25FCGzQ$default  reason: not valid java name */
    public static /* synthetic */ SimpleTextSpec m4597copy25FCGzQ$default(SimpleTextSpec simpleTextSpec, IdentifierSpec identifierSpec, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            identifierSpec = simpleTextSpec.getIdentifier();
        }
        if ((i4 & 2) != 0) {
            i = simpleTextSpec.label;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = simpleTextSpec.capitalization;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = simpleTextSpec.keyboardType;
        }
        int i7 = i3;
        if ((i4 & 16) != 0) {
            z = simpleTextSpec.showOptionalLabel;
        }
        return simpleTextSpec.m4600copy25FCGzQ(identifierSpec, i5, i6, i7, z);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final int component2() {
        return this.label;
    }

    /* renamed from: component3-IUNYP9k  reason: not valid java name */
    public final int m4598component3IUNYP9k() {
        return this.capitalization;
    }

    /* renamed from: component4-PjHm6EE  reason: not valid java name */
    public final int m4599component4PjHm6EE() {
        return this.keyboardType;
    }

    public final boolean component5() {
        return this.showOptionalLabel;
    }

    /* renamed from: copy-25FCGzQ  reason: not valid java name */
    public final SimpleTextSpec m4600copy25FCGzQ(IdentifierSpec identifierSpec, int i, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new SimpleTextSpec(identifierSpec, i, i2, i3, z, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleTextSpec)) {
            return false;
        }
        SimpleTextSpec simpleTextSpec = (SimpleTextSpec) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) simpleTextSpec.getIdentifier()) && this.label == simpleTextSpec.label && KeyboardCapitalization.m3660equalsimpl0(this.capitalization, simpleTextSpec.capitalization) && KeyboardType.m3671equalsimpl0(this.keyboardType, simpleTextSpec.keyboardType) && this.showOptionalLabel == simpleTextSpec.showOptionalLabel;
    }

    public int hashCode() {
        int hashCode = ((((((getIdentifier().hashCode() * 31) + this.label) * 31) + KeyboardCapitalization.m3661hashCodeimpl(this.capitalization)) * 31) + KeyboardType.m3672hashCodeimpl(this.keyboardType)) * 31;
        boolean z = this.showOptionalLabel;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "SimpleTextSpec(identifier=" + getIdentifier() + ", label=" + this.label + ", capitalization=" + KeyboardCapitalization.m3662toStringimpl(this.capitalization) + ", keyboardType=" + KeyboardType.m3673toStringimpl(this.keyboardType) + ", showOptionalLabel=" + this.showOptionalLabel + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.identifier, i);
        parcel.writeInt(this.label);
        parcel.writeValue(KeyboardCapitalization.m3657boximpl(this.capitalization));
        parcel.writeValue(KeyboardType.m3668boximpl(this.keyboardType));
        parcel.writeInt(this.showOptionalLabel ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleTextSpec(IdentifierSpec identifierSpec, int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec, i, i2, i3, (i4 & 16) != 0 ? false : z, (DefaultConstructorMarker) null);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public final int getLabel() {
        return this.label;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public final int m4601getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public final int m4602getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public final boolean getShowOptionalLabel() {
        return this.showOptionalLabel;
    }

    private SimpleTextSpec(IdentifierSpec identifierSpec, int i, int i2, int i3, boolean z) {
        super(identifierSpec, (DefaultConstructorMarker) null);
        this.identifier = identifierSpec;
        this.label = i;
        this.capitalization = i2;
        this.keyboardType = i3;
        this.showOptionalLabel = z;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/ui/core/elements/SimpleTextSpec$Companion;", "", "()V", "NAME", "Lcom/stripe/android/ui/core/elements/SimpleTextSpec;", "getNAME", "()Lcom/stripe/android/ui/core/elements/SimpleTextSpec;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SimpleTextSpec.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SimpleTextSpec getNAME() {
            return SimpleTextSpec.NAME;
        }
    }

    public static /* synthetic */ SectionSingleFieldElement transform$default(SimpleTextSpec simpleTextSpec, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return simpleTextSpec.transform(map);
    }

    public final SectionSingleFieldElement transform(Map<IdentifierSpec, String> map) {
        Intrinsics.checkNotNullParameter(map, "initialValues");
        IdentifierSpec identifier2 = getIdentifier();
        SimpleTextFieldConfig simpleTextFieldConfig = new SimpleTextFieldConfig(this.label, m4601getCapitalizationIUNYP9k(), m4602getKeyboardTypePjHm6EE(), (DefaultConstructorMarker) null);
        return new SimpleTextElement(identifier2, new SimpleTextFieldController(simpleTextFieldConfig, this.showOptionalLabel, map.get(getIdentifier())));
    }
}
