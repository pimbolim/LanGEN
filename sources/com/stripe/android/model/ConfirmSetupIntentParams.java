package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.MandateDataParams;
import com.stripe.android.model.PaymentMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 ;2\u00020\u0001:\u0001;BU\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b%J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b'J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\tHÂ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001J\u0013\u0010/\u001a\u00020\t2\b\u00100\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u00101\u001a\u00020.HÖ\u0001J\b\u00102\u001a\u00020\tH\u0016J\u0014\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\t\u00104\u001a\u00020\u0003HÖ\u0001J\u0010\u00105\u001a\u00020\u00002\u0006\u00102\u001a\u00020\tH\u0016J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020.HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000fR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/stripe/android/model/ConfirmSetupIntentParams;", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "clientSecret", "", "paymentMethodId", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "returnUrl", "useStripeSdk", "", "mandateId", "mandateData", "Lcom/stripe/android/model/MandateDataParams;", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/PaymentMethodCreateParams;Ljava/lang/String;ZLjava/lang/String;Lcom/stripe/android/model/MandateDataParams;)V", "getClientSecret", "()Ljava/lang/String;", "getMandateData", "()Lcom/stripe/android/model/MandateDataParams;", "setMandateData", "(Lcom/stripe/android/model/MandateDataParams;)V", "mandateDataParams", "", "", "getMandateDataParams", "()Ljava/util/Map;", "getMandateId", "setMandateId", "(Ljava/lang/String;)V", "getPaymentMethodCreateParams$payments_core_release", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "getPaymentMethodId$payments_core_release", "paymentMethodParamMap", "getPaymentMethodParamMap", "getReturnUrl", "setReturnUrl", "component1", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "hashCode", "shouldUseStripeSdk", "toParamMap", "toString", "withShouldUseStripeSdk", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfirmSetupIntentParams.kt */
public final class ConfirmSetupIntentParams implements ConfirmStripeIntentParams {
    public static final int $stable = 8;
    public static final Parcelable.Creator<ConfirmSetupIntentParams> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String clientSecret;
    private MandateDataParams mandateData;
    private String mandateId;
    private final PaymentMethodCreateParams paymentMethodCreateParams;
    private final String paymentMethodId;
    private String returnUrl;
    private final boolean useStripeSdk;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfirmSetupIntentParams.kt */
    public static final class Creator implements Parcelable.Creator<ConfirmSetupIntentParams> {
        public final ConfirmSetupIntentParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            MandateDataParams mandateDataParams = null;
            PaymentMethodCreateParams createFromParcel = parcel.readInt() == 0 ? null : PaymentMethodCreateParams.CREATOR.createFromParcel(parcel);
            String readString3 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                mandateDataParams = MandateDataParams.CREATOR.createFromParcel(parcel);
            }
            return new ConfirmSetupIntentParams(readString, readString2, createFromParcel, readString3, z, readString4, mandateDataParams);
        }

        public final ConfirmSetupIntentParams[] newArray(int i) {
            return new ConfirmSetupIntentParams[i];
        }
    }

    private final boolean component5() {
        return this.useStripeSdk;
    }

    public static /* synthetic */ ConfirmSetupIntentParams copy$default(ConfirmSetupIntentParams confirmSetupIntentParams, String str, String str2, PaymentMethodCreateParams paymentMethodCreateParams2, String str3, boolean z, String str4, MandateDataParams mandateDataParams, int i, Object obj) {
        if ((i & 1) != 0) {
            str = confirmSetupIntentParams.getClientSecret();
        }
        if ((i & 2) != 0) {
            str2 = confirmSetupIntentParams.paymentMethodId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            paymentMethodCreateParams2 = confirmSetupIntentParams.paymentMethodCreateParams;
        }
        PaymentMethodCreateParams paymentMethodCreateParams3 = paymentMethodCreateParams2;
        if ((i & 8) != 0) {
            str3 = confirmSetupIntentParams.getReturnUrl();
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            z = confirmSetupIntentParams.useStripeSdk;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str4 = confirmSetupIntentParams.mandateId;
        }
        String str7 = str4;
        if ((i & 64) != 0) {
            mandateDataParams = confirmSetupIntentParams.mandateData;
        }
        return confirmSetupIntentParams.copy(str, str5, paymentMethodCreateParams3, str6, z2, str7, mandateDataParams);
    }

    @JvmStatic
    public static final ConfirmSetupIntentParams create(PaymentMethodCreateParams paymentMethodCreateParams2, String str) {
        return Companion.create(paymentMethodCreateParams2, str);
    }

    @JvmStatic
    public static final ConfirmSetupIntentParams create(PaymentMethodCreateParams paymentMethodCreateParams2, String str, MandateDataParams mandateDataParams) {
        return Companion.create(paymentMethodCreateParams2, str, mandateDataParams);
    }

    @JvmStatic
    public static final ConfirmSetupIntentParams create(PaymentMethodCreateParams paymentMethodCreateParams2, String str, MandateDataParams mandateDataParams, String str2) {
        return Companion.create(paymentMethodCreateParams2, str, mandateDataParams, str2);
    }

    @JvmStatic
    public static final ConfirmSetupIntentParams create(String str, PaymentMethod.Type type) {
        return Companion.create(str, type);
    }

    @JvmStatic
    public static final ConfirmSetupIntentParams create(String str, String str2) {
        return Companion.create(str, str2);
    }

    @JvmStatic
    public static final ConfirmSetupIntentParams create(String str, String str2, MandateDataParams mandateDataParams) {
        return Companion.create(str, str2, mandateDataParams);
    }

    @JvmStatic
    public static final ConfirmSetupIntentParams create(String str, String str2, MandateDataParams mandateDataParams, String str3) {
        return Companion.create(str, str2, mandateDataParams, str3);
    }

    @JvmStatic
    public static final ConfirmSetupIntentParams createWithoutPaymentMethod(String str) {
        return Companion.createWithoutPaymentMethod(str);
    }

    public final String component1() {
        return getClientSecret();
    }

    public final String component2$payments_core_release() {
        return this.paymentMethodId;
    }

    public final PaymentMethodCreateParams component3$payments_core_release() {
        return this.paymentMethodCreateParams;
    }

    public final String component4() {
        return getReturnUrl();
    }

    public final String component6() {
        return this.mandateId;
    }

    public final MandateDataParams component7() {
        return this.mandateData;
    }

    public final ConfirmSetupIntentParams copy(String str, String str2, PaymentMethodCreateParams paymentMethodCreateParams2, String str3, boolean z, String str4, MandateDataParams mandateDataParams) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        return new ConfirmSetupIntentParams(str, str2, paymentMethodCreateParams2, str3, z, str4, mandateDataParams);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfirmSetupIntentParams)) {
            return false;
        }
        ConfirmSetupIntentParams confirmSetupIntentParams = (ConfirmSetupIntentParams) obj;
        return Intrinsics.areEqual((Object) getClientSecret(), (Object) confirmSetupIntentParams.getClientSecret()) && Intrinsics.areEqual((Object) this.paymentMethodId, (Object) confirmSetupIntentParams.paymentMethodId) && Intrinsics.areEqual((Object) this.paymentMethodCreateParams, (Object) confirmSetupIntentParams.paymentMethodCreateParams) && Intrinsics.areEqual((Object) getReturnUrl(), (Object) confirmSetupIntentParams.getReturnUrl()) && this.useStripeSdk == confirmSetupIntentParams.useStripeSdk && Intrinsics.areEqual((Object) this.mandateId, (Object) confirmSetupIntentParams.mandateId) && Intrinsics.areEqual((Object) this.mandateData, (Object) confirmSetupIntentParams.mandateData);
    }

    public int hashCode() {
        int hashCode = getClientSecret().hashCode() * 31;
        String str = this.paymentMethodId;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        PaymentMethodCreateParams paymentMethodCreateParams2 = this.paymentMethodCreateParams;
        int hashCode3 = (((hashCode2 + (paymentMethodCreateParams2 == null ? 0 : paymentMethodCreateParams2.hashCode())) * 31) + (getReturnUrl() == null ? 0 : getReturnUrl().hashCode())) * 31;
        boolean z = this.useStripeSdk;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        String str2 = this.mandateId;
        int hashCode4 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MandateDataParams mandateDataParams = this.mandateData;
        if (mandateDataParams != null) {
            i = mandateDataParams.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ConfirmSetupIntentParams(clientSecret=" + getClientSecret() + ", paymentMethodId=" + this.paymentMethodId + ", paymentMethodCreateParams=" + this.paymentMethodCreateParams + ", returnUrl=" + getReturnUrl() + ", useStripeSdk=" + this.useStripeSdk + ", mandateId=" + this.mandateId + ", mandateData=" + this.mandateData + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.clientSecret);
        parcel.writeString(this.paymentMethodId);
        PaymentMethodCreateParams paymentMethodCreateParams2 = this.paymentMethodCreateParams;
        if (paymentMethodCreateParams2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            paymentMethodCreateParams2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.returnUrl);
        parcel.writeInt(this.useStripeSdk ? 1 : 0);
        parcel.writeString(this.mandateId);
        MandateDataParams mandateDataParams = this.mandateData;
        if (mandateDataParams == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        mandateDataParams.writeToParcel(parcel, i);
    }

    public ConfirmSetupIntentParams(String str, String str2, PaymentMethodCreateParams paymentMethodCreateParams2, String str3, boolean z, String str4, MandateDataParams mandateDataParams) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        this.clientSecret = str;
        this.paymentMethodId = str2;
        this.paymentMethodCreateParams = paymentMethodCreateParams2;
        this.returnUrl = str3;
        this.useStripeSdk = z;
        this.mandateId = str4;
        this.mandateData = mandateDataParams;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ConfirmSetupIntentParams(java.lang.String r8, java.lang.String r9, com.stripe.android.model.PaymentMethodCreateParams r10, java.lang.String r11, boolean r12, java.lang.String r13, com.stripe.android.model.MandateDataParams r14, int r15, kotlin.jvm.internal.DefaultConstructorMarker r16) {
        /*
            r7 = this;
            r0 = r15 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r9
        L_0x0008:
            r2 = r15 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r10
        L_0x000f:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r11
        L_0x0016:
            r4 = r15 & 16
            if (r4 == 0) goto L_0x001c
            r4 = 0
            goto L_0x001d
        L_0x001c:
            r4 = r12
        L_0x001d:
            r5 = r15 & 32
            if (r5 == 0) goto L_0x0023
            r5 = r1
            goto L_0x0024
        L_0x0023:
            r5 = r13
        L_0x0024:
            r6 = r15 & 64
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = r14
        L_0x002a:
            r9 = r7
            r10 = r8
            r11 = r0
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.ConfirmSetupIntentParams.<init>(java.lang.String, java.lang.String, com.stripe.android.model.PaymentMethodCreateParams, java.lang.String, boolean, java.lang.String, com.stripe.android.model.MandateDataParams, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public /* synthetic */ String getClientSecret() {
        return this.clientSecret;
    }

    public final /* synthetic */ String getPaymentMethodId$payments_core_release() {
        return this.paymentMethodId;
    }

    public final /* synthetic */ PaymentMethodCreateParams getPaymentMethodCreateParams$payments_core_release() {
        return this.paymentMethodCreateParams;
    }

    public String getReturnUrl() {
        return this.returnUrl;
    }

    public void setReturnUrl(String str) {
        this.returnUrl = str;
    }

    public final String getMandateId() {
        return this.mandateId;
    }

    public final void setMandateId(String str) {
        this.mandateId = str;
    }

    public final MandateDataParams getMandateData() {
        return this.mandateData;
    }

    public final void setMandateData(MandateDataParams mandateDataParams) {
        this.mandateData = mandateDataParams;
    }

    public boolean shouldUseStripeSdk() {
        return this.useStripeSdk;
    }

    public ConfirmSetupIntentParams withShouldUseStripeSdk(boolean z) {
        return copy$default(this, (String) null, (String) null, (PaymentMethodCreateParams) null, (String) null, z, (String) null, (MandateDataParams) null, 111, (Object) null);
    }

    public Map<String, Object> toParamMap() {
        Map map;
        Map map2;
        Map mapOf = MapsKt.mapOf(TuplesKt.to("client_secret", getClientSecret()), TuplesKt.to("use_stripe_sdk", Boolean.valueOf(this.useStripeSdk)));
        String returnUrl2 = getReturnUrl();
        Map<K, V> map3 = null;
        if (returnUrl2 == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to("return_url", returnUrl2));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        Map plus = MapsKt.plus(mapOf, map);
        String str = this.mandateId;
        if (str == null) {
            map2 = null;
        } else {
            map2 = MapsKt.mapOf(TuplesKt.to("mandate", str));
        }
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        Map plus2 = MapsKt.plus(plus, map2);
        Map<String, Object> mandateDataParams = getMandateDataParams();
        if (mandateDataParams != null) {
            map3 = MapsKt.mapOf(TuplesKt.to("mandate_data", mandateDataParams));
        }
        if (map3 == null) {
            map3 = MapsKt.emptyMap();
        }
        return MapsKt.plus(MapsKt.plus(plus2, (Map) map3), (Map<K, V>) getPaymentMethodParamMap());
    }

    private final Map<String, Object> getPaymentMethodParamMap() {
        PaymentMethodCreateParams paymentMethodCreateParams2 = this.paymentMethodCreateParams;
        if (paymentMethodCreateParams2 != null) {
            return MapsKt.mapOf(TuplesKt.to("payment_method_data", paymentMethodCreateParams2.toParamMap()));
        }
        String str = this.paymentMethodId;
        if (str != null) {
            return MapsKt.mapOf(TuplesKt.to("payment_method", str));
        }
        return MapsKt.emptyMap();
    }

    private final Map<String, Object> getMandateDataParams() {
        PaymentMethod.Type type$payments_core_release;
        MandateDataParams mandateDataParams = this.mandateData;
        Map<String, Object> paramMap = mandateDataParams == null ? null : mandateDataParams.toParamMap();
        if (paramMap != null) {
            return paramMap;
        }
        PaymentMethodCreateParams paymentMethodCreateParams2 = this.paymentMethodCreateParams;
        boolean z = true;
        if (paymentMethodCreateParams2 == null || (type$payments_core_release = paymentMethodCreateParams2.getType$payments_core_release()) == null || !type$payments_core_release.requiresMandate) {
            z = false;
        }
        if (!z || this.mandateId != null) {
            return null;
        }
        return new MandateDataParams(MandateDataParams.Type.Online.Companion.getDEFAULT()).toParamMap();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/model/ConfirmSetupIntentParams$Companion;", "", "()V", "create", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "clientSecret", "", "mandateData", "Lcom/stripe/android/model/MandateDataParams;", "mandateId", "paymentMethodType", "Lcom/stripe/android/model/PaymentMethod$Type;", "paymentMethodId", "createWithoutPaymentMethod", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfirmSetupIntentParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ConfirmSetupIntentParams create(PaymentMethodCreateParams paymentMethodCreateParams, String str) {
            Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return create$default(this, paymentMethodCreateParams, str, (MandateDataParams) null, (String) null, 12, (Object) null);
        }

        @JvmStatic
        public final ConfirmSetupIntentParams create(PaymentMethodCreateParams paymentMethodCreateParams, String str, MandateDataParams mandateDataParams) {
            Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return create$default(this, paymentMethodCreateParams, str, mandateDataParams, (String) null, 8, (Object) null);
        }

        @JvmStatic
        public final ConfirmSetupIntentParams create(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            return create$default(this, str, str2, (MandateDataParams) null, (String) null, 12, (Object) null);
        }

        @JvmStatic
        public final ConfirmSetupIntentParams create(String str, String str2, MandateDataParams mandateDataParams) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            return create$default(this, str, str2, mandateDataParams, (String) null, 8, (Object) null);
        }

        private Companion() {
        }

        @JvmStatic
        public final ConfirmSetupIntentParams create(String str, PaymentMethod.Type type) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            Intrinsics.checkNotNullParameter(type, "paymentMethodType");
            MandateDataParams mandateDataParams = new MandateDataParams(MandateDataParams.Type.Online.Companion.getDEFAULT());
            if (!type.requiresMandate) {
                mandateDataParams = null;
            }
            return new ConfirmSetupIntentParams(str, (String) null, (PaymentMethodCreateParams) null, (String) null, false, (String) null, mandateDataParams, 62, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final ConfirmSetupIntentParams createWithoutPaymentMethod(String str) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return new ConfirmSetupIntentParams(str, (String) null, (PaymentMethodCreateParams) null, (String) null, false, (String) null, (MandateDataParams) null, 126, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ConfirmSetupIntentParams create$default(Companion companion, String str, String str2, MandateDataParams mandateDataParams, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                mandateDataParams = null;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            return companion.create(str, str2, mandateDataParams, str3);
        }

        @JvmStatic
        public final ConfirmSetupIntentParams create(String str, String str2, MandateDataParams mandateDataParams, String str3) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            return new ConfirmSetupIntentParams(str2, str, (PaymentMethodCreateParams) null, (String) null, false, str3, mandateDataParams, 28, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ConfirmSetupIntentParams create$default(Companion companion, PaymentMethodCreateParams paymentMethodCreateParams, String str, MandateDataParams mandateDataParams, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                mandateDataParams = null;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            return companion.create(paymentMethodCreateParams, str, mandateDataParams, str2);
        }

        @JvmStatic
        public final ConfirmSetupIntentParams create(PaymentMethodCreateParams paymentMethodCreateParams, String str, MandateDataParams mandateDataParams, String str2) {
            Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return new ConfirmSetupIntentParams(str, (String) null, paymentMethodCreateParams, (String) null, false, str2, mandateDataParams, 26, (DefaultConstructorMarker) null);
        }
    }
}
