package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.braintreepayments.api.models.PostalAddressParser;
import com.facebook.react.uimanager.ViewProps;
import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.model.Address;
import com.stripe.android.model.KlarnaSourceParams;
import com.stripe.android.model.Source;
import com.stripe.android.model.SourceOrderParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b;\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0006lmnopqB¹\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b¢\u0006\u0002\u0010\u001cJ\t\u0010L\u001a\u00020\u0004HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0017HÂ\u0003J\t\u0010P\u001a\u00020\u0019HÂ\u0003J\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bHÀ\u0003¢\u0006\u0002\bRJ\u0010\u0010S\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\bTJ\u0010\u0010U\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010V\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0012HÆ\u0003JÂ\u0001\u0010\\\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bHÆ\u0001¢\u0006\u0002\u0010]J\t\u0010^\u001a\u00020_HÖ\u0001J\u0013\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010c\u001a\u00020_HÖ\u0001J\u001e\u0010d\u001a\u00020\u00002\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\u0015J\u0014\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020#0\u0015H\u0016J\t\u0010f\u001a\u00020\u0004HÖ\u0001J\u0019\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020_HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001f\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010#0\u00158F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u00102R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010)\"\u0004\b8\u0010+R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010)\"\u0004\b>\u0010+R\u0017\u0010?\u001a\u00020\u00048F¢\u0006\f\u0012\u0004\b@\u0010A\u001a\u0004\bB\u0010)R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010)R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/stripe/android/model/SourceParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "typeRaw", "", "typeData", "Lcom/stripe/android/model/SourceParams$TypeData;", "amount", "", "currency", "owner", "Lcom/stripe/android/model/SourceParams$OwnerParams;", "usage", "Lcom/stripe/android/model/Source$Usage;", "returnUrl", "flow", "Lcom/stripe/android/model/SourceParams$Flow;", "sourceOrder", "Lcom/stripe/android/model/SourceOrderParams;", "token", "metadata", "", "weChatParams", "Lcom/stripe/android/model/SourceParams$WeChatParams;", "apiParams", "Lcom/stripe/android/model/SourceParams$ApiParams;", "attribution", "", "(Ljava/lang/String;Lcom/stripe/android/model/SourceParams$TypeData;Ljava/lang/Long;Ljava/lang/String;Lcom/stripe/android/model/SourceParams$OwnerParams;Lcom/stripe/android/model/Source$Usage;Ljava/lang/String;Lcom/stripe/android/model/SourceParams$Flow;Lcom/stripe/android/model/SourceOrderParams;Ljava/lang/String;Ljava/util/Map;Lcom/stripe/android/model/SourceParams$WeChatParams;Lcom/stripe/android/model/SourceParams$ApiParams;Ljava/util/Set;)V", "getAmount", "()Ljava/lang/Long;", "setAmount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "apiParameterMap", "", "getApiParameterMap", "()Ljava/util/Map;", "getAttribution$payments_core_release", "()Ljava/util/Set;", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "getFlow", "()Lcom/stripe/android/model/SourceParams$Flow;", "setFlow", "(Lcom/stripe/android/model/SourceParams$Flow;)V", "getMetadata", "setMetadata", "(Ljava/util/Map;)V", "getOwner", "()Lcom/stripe/android/model/SourceParams$OwnerParams;", "setOwner", "(Lcom/stripe/android/model/SourceParams$OwnerParams;)V", "getReturnUrl", "setReturnUrl", "getSourceOrder", "()Lcom/stripe/android/model/SourceOrderParams;", "setSourceOrder", "(Lcom/stripe/android/model/SourceOrderParams;)V", "getToken", "setToken", "type", "getType$annotations", "()V", "getType", "getTypeData$payments_core_release", "()Lcom/stripe/android/model/SourceParams$TypeData;", "setTypeData$payments_core_release", "(Lcom/stripe/android/model/SourceParams$TypeData;)V", "getTypeRaw", "getUsage", "()Lcom/stripe/android/model/Source$Usage;", "setUsage", "(Lcom/stripe/android/model/Source$Usage;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component14$payments_core_release", "component2", "component2$payments_core_release", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/stripe/android/model/SourceParams$TypeData;Ljava/lang/Long;Ljava/lang/String;Lcom/stripe/android/model/SourceParams$OwnerParams;Lcom/stripe/android/model/Source$Usage;Ljava/lang/String;Lcom/stripe/android/model/SourceParams$Flow;Lcom/stripe/android/model/SourceOrderParams;Ljava/lang/String;Ljava/util/Map;Lcom/stripe/android/model/SourceParams$WeChatParams;Lcom/stripe/android/model/SourceParams$ApiParams;Ljava/util/Set;)Lcom/stripe/android/model/SourceParams;", "describeContents", "", "equals", "", "other", "hashCode", "setApiParameterMap", "toParamMap", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ApiParams", "Companion", "Flow", "OwnerParams", "TypeData", "WeChatParams", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SourceParams.kt */
public final class SourceParams implements StripeParamsModel, Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SourceParams> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAM_AMOUNT = "amount";
    private static final String PARAM_CLIENT_SECRET = "client_secret";
    private static final String PARAM_CURRENCY = "currency";
    private static final String PARAM_FLOW = "flow";
    private static final String PARAM_METADATA = "metadata";
    private static final String PARAM_OWNER = "owner";
    private static final String PARAM_REDIRECT = "redirect";
    private static final String PARAM_RETURN_URL = "return_url";
    private static final String PARAM_SOURCE_ORDER = "source_order";
    private static final String PARAM_TOKEN = "token";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_USAGE = "usage";
    private static final String PARAM_WECHAT = "wechat";
    private Long amount;
    private ApiParams apiParams;
    private final Set<String> attribution;
    private String currency;
    private Flow flow;
    private Map<String, String> metadata;
    private OwnerParams owner;
    private String returnUrl;
    private SourceOrderParams sourceOrder;
    private String token;
    private TypeData typeData;
    private final String typeRaw;
    private Source.Usage usage;
    private WeChatParams weChatParams;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceParams.kt */
    public static final class Creator implements Parcelable.Creator<SourceParams> {
        public final SourceParams createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            TypeData typeData = (TypeData) parcel2.readParcelable(SourceParams.class.getClassLoader());
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString2 = parcel.readString();
            OwnerParams createFromParcel = parcel.readInt() == 0 ? null : OwnerParams.CREATOR.createFromParcel(parcel2);
            Source.Usage valueOf2 = parcel.readInt() == 0 ? null : Source.Usage.valueOf(parcel.readString());
            String readString3 = parcel.readString();
            Flow valueOf3 = parcel.readInt() == 0 ? null : Flow.valueOf(parcel.readString());
            SourceOrderParams createFromParcel2 = parcel.readInt() == 0 ? null : SourceOrderParams.CREATOR.createFromParcel(parcel2);
            String readString4 = parcel.readString();
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            }
            Map map = linkedHashMap;
            WeChatParams createFromParcel3 = parcel.readInt() == 0 ? null : WeChatParams.CREATOR.createFromParcel(parcel2);
            ApiParams createFromParcel4 = ApiParams.CREATOR.createFromParcel(parcel2);
            int readInt2 = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(readInt2);
            int i2 = 0;
            while (i2 != readInt2) {
                linkedHashSet.add(parcel.readString());
                i2++;
                readInt2 = readInt2;
            }
            return new SourceParams(readString, typeData, valueOf, readString2, createFromParcel, valueOf2, readString3, valueOf3, createFromParcel2, readString4, map, createFromParcel3, createFromParcel4, linkedHashSet);
        }

        public final SourceParams[] newArray(int i) {
            return new SourceParams[i];
        }
    }

    private final WeChatParams component12() {
        return this.weChatParams;
    }

    private final ApiParams component13() {
        return this.apiParams;
    }

    public static /* synthetic */ SourceParams copy$default(SourceParams sourceParams, String str, TypeData typeData2, Long l, String str2, OwnerParams ownerParams, Source.Usage usage2, String str3, Flow flow2, SourceOrderParams sourceOrderParams, String str4, Map map, WeChatParams weChatParams2, ApiParams apiParams2, Set set, int i, Object obj) {
        SourceParams sourceParams2 = sourceParams;
        int i2 = i;
        return sourceParams.copy((i2 & 1) != 0 ? sourceParams2.typeRaw : str, (i2 & 2) != 0 ? sourceParams2.typeData : typeData2, (i2 & 4) != 0 ? sourceParams2.amount : l, (i2 & 8) != 0 ? sourceParams2.currency : str2, (i2 & 16) != 0 ? sourceParams2.owner : ownerParams, (i2 & 32) != 0 ? sourceParams2.usage : usage2, (i2 & 64) != 0 ? sourceParams2.returnUrl : str3, (i2 & 128) != 0 ? sourceParams2.flow : flow2, (i2 & 256) != 0 ? sourceParams2.sourceOrder : sourceOrderParams, (i2 & 512) != 0 ? sourceParams2.token : str4, (i2 & 1024) != 0 ? sourceParams2.metadata : map, (i2 & 2048) != 0 ? sourceParams2.weChatParams : weChatParams2, (i2 & 4096) != 0 ? sourceParams2.apiParams : apiParams2, (i2 & 8192) != 0 ? sourceParams2.attribution : set);
    }

    @JvmStatic
    public static final SourceParams createAlipayReusableParams(String str, String str2, String str3, String str4) {
        return Companion.createAlipayReusableParams(str, str2, str3, str4);
    }

    @JvmStatic
    public static final SourceParams createAlipaySingleUseParams(long j, String str, String str2, String str3, String str4) {
        return Companion.createAlipaySingleUseParams(j, str, str2, str3, str4);
    }

    @JvmStatic
    public static final SourceParams createBancontactParams(long j, String str, String str2, String str3, String str4) {
        return Companion.createBancontactParams(j, str, str2, str3, str4);
    }

    @JvmStatic
    public static final SourceParams createCardParams(CardParams cardParams) {
        return Companion.createCardParams(cardParams);
    }

    @JvmStatic
    public static final SourceParams createCardParamsFromGooglePay(JSONObject jSONObject) throws JSONException {
        return Companion.createCardParamsFromGooglePay(jSONObject);
    }

    @JvmStatic
    public static final SourceParams createCustomParams(String str) {
        return Companion.createCustomParams(str);
    }

    @JvmStatic
    public static final SourceParams createEPSParams(long j, String str, String str2, String str3) {
        return Companion.createEPSParams(j, str, str2, str3);
    }

    @JvmStatic
    public static final SourceParams createGiropayParams(long j, String str, String str2, String str3) {
        return Companion.createGiropayParams(j, str, str2, str3);
    }

    @JvmStatic
    public static final SourceParams createIdealParams(long j, String str, String str2, String str3, String str4) {
        return Companion.createIdealParams(j, str, str2, str3, str4);
    }

    @JvmStatic
    public static final SourceParams createKlarna(String str, String str2, KlarnaSourceParams klarnaSourceParams) {
        return Companion.createKlarna(str, str2, klarnaSourceParams);
    }

    @JvmStatic
    public static final SourceParams createMasterpassParams(String str, String str2) {
        return Companion.createMasterpassParams(str, str2);
    }

    @JvmStatic
    public static final SourceParams createMultibancoParams(long j, String str, String str2) {
        return Companion.createMultibancoParams(j, str, str2);
    }

    @JvmStatic
    public static final SourceParams createP24Params(long j, String str, String str2, String str3, String str4) {
        return Companion.createP24Params(j, str, str2, str3, str4);
    }

    @JvmStatic
    public static final Map<String, String> createRetrieveSourceParams(String str) {
        return Companion.createRetrieveSourceParams(str);
    }

    @JvmStatic
    public static final SourceParams createSepaDebitParams(String str, String str2, String str3, String str4, String str5, String str6) {
        return Companion.createSepaDebitParams(str, str2, str3, str4, str5, str6);
    }

    @JvmStatic
    public static final SourceParams createSepaDebitParams(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return Companion.createSepaDebitParams(str, str2, str3, str4, str5, str6, str7);
    }

    @JvmStatic
    public static final SourceParams createSofortParams(long j, String str, String str2, String str3) {
        return Companion.createSofortParams(j, str, str2, str3);
    }

    @JvmStatic
    public static final SourceParams createSourceFromTokenParams(String str) {
        return Companion.createSourceFromTokenParams(str);
    }

    @JvmStatic
    public static final SourceParams createThreeDSecureParams(long j, String str, String str2, String str3) {
        return Companion.createThreeDSecureParams(j, str, str2, str3);
    }

    @JvmStatic
    public static final SourceParams createVisaCheckoutParams(String str) {
        return Companion.createVisaCheckoutParams(str);
    }

    @JvmStatic
    public static final SourceParams createWeChatPayParams(long j, String str, String str2, String str3) {
        return Companion.createWeChatPayParams(j, str, str2, str3);
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public final String component1() {
        return this.typeRaw;
    }

    public final String component10() {
        return this.token;
    }

    public final Map<String, String> component11() {
        return this.metadata;
    }

    public final Set<String> component14$payments_core_release() {
        return this.attribution;
    }

    public final TypeData component2$payments_core_release() {
        return this.typeData;
    }

    public final Long component3() {
        return this.amount;
    }

    public final String component4() {
        return this.currency;
    }

    public final OwnerParams component5() {
        return this.owner;
    }

    public final Source.Usage component6() {
        return this.usage;
    }

    public final String component7() {
        return this.returnUrl;
    }

    public final Flow component8() {
        return this.flow;
    }

    public final SourceOrderParams component9() {
        return this.sourceOrder;
    }

    public final SourceParams copy(String str, TypeData typeData2, Long l, String str2, OwnerParams ownerParams, Source.Usage usage2, String str3, Flow flow2, SourceOrderParams sourceOrderParams, String str4, Map<String, String> map, WeChatParams weChatParams2, ApiParams apiParams2, Set<String> set) {
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, "typeRaw");
        ApiParams apiParams3 = apiParams2;
        Intrinsics.checkNotNullParameter(apiParams3, "apiParams");
        Set<String> set2 = set;
        Intrinsics.checkNotNullParameter(set2, "attribution");
        return new SourceParams(str5, typeData2, l, str2, ownerParams, usage2, str3, flow2, sourceOrderParams, str4, map, weChatParams2, apiParams3, set2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceParams)) {
            return false;
        }
        SourceParams sourceParams = (SourceParams) obj;
        return Intrinsics.areEqual((Object) this.typeRaw, (Object) sourceParams.typeRaw) && Intrinsics.areEqual((Object) this.typeData, (Object) sourceParams.typeData) && Intrinsics.areEqual((Object) this.amount, (Object) sourceParams.amount) && Intrinsics.areEqual((Object) this.currency, (Object) sourceParams.currency) && Intrinsics.areEqual((Object) this.owner, (Object) sourceParams.owner) && this.usage == sourceParams.usage && Intrinsics.areEqual((Object) this.returnUrl, (Object) sourceParams.returnUrl) && this.flow == sourceParams.flow && Intrinsics.areEqual((Object) this.sourceOrder, (Object) sourceParams.sourceOrder) && Intrinsics.areEqual((Object) this.token, (Object) sourceParams.token) && Intrinsics.areEqual((Object) this.metadata, (Object) sourceParams.metadata) && Intrinsics.areEqual((Object) this.weChatParams, (Object) sourceParams.weChatParams) && Intrinsics.areEqual((Object) this.apiParams, (Object) sourceParams.apiParams) && Intrinsics.areEqual((Object) this.attribution, (Object) sourceParams.attribution);
    }

    public int hashCode() {
        int hashCode = this.typeRaw.hashCode() * 31;
        TypeData typeData2 = this.typeData;
        int i = 0;
        int hashCode2 = (hashCode + (typeData2 == null ? 0 : typeData2.hashCode())) * 31;
        Long l = this.amount;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.currency;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        OwnerParams ownerParams = this.owner;
        int hashCode5 = (hashCode4 + (ownerParams == null ? 0 : ownerParams.hashCode())) * 31;
        Source.Usage usage2 = this.usage;
        int hashCode6 = (hashCode5 + (usage2 == null ? 0 : usage2.hashCode())) * 31;
        String str2 = this.returnUrl;
        int hashCode7 = (hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Flow flow2 = this.flow;
        int hashCode8 = (hashCode7 + (flow2 == null ? 0 : flow2.hashCode())) * 31;
        SourceOrderParams sourceOrderParams = this.sourceOrder;
        int hashCode9 = (hashCode8 + (sourceOrderParams == null ? 0 : sourceOrderParams.hashCode())) * 31;
        String str3 = this.token;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, String> map = this.metadata;
        int hashCode11 = (hashCode10 + (map == null ? 0 : map.hashCode())) * 31;
        WeChatParams weChatParams2 = this.weChatParams;
        if (weChatParams2 != null) {
            i = weChatParams2.hashCode();
        }
        return ((((hashCode11 + i) * 31) + this.apiParams.hashCode()) * 31) + this.attribution.hashCode();
    }

    public String toString() {
        return "SourceParams(typeRaw=" + this.typeRaw + ", typeData=" + this.typeData + ", amount=" + this.amount + ", currency=" + this.currency + ", owner=" + this.owner + ", usage=" + this.usage + ", returnUrl=" + this.returnUrl + ", flow=" + this.flow + ", sourceOrder=" + this.sourceOrder + ", token=" + this.token + ", metadata=" + this.metadata + ", weChatParams=" + this.weChatParams + ", apiParams=" + this.apiParams + ", attribution=" + this.attribution + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.typeRaw);
        parcel.writeParcelable(this.typeData, i);
        Long l = this.amount;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.currency);
        OwnerParams ownerParams = this.owner;
        if (ownerParams == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            ownerParams.writeToParcel(parcel, i);
        }
        Source.Usage usage2 = this.usage;
        if (usage2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(usage2.name());
        }
        parcel.writeString(this.returnUrl);
        Flow flow2 = this.flow;
        if (flow2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(flow2.name());
        }
        SourceOrderParams sourceOrderParams = this.sourceOrder;
        if (sourceOrderParams == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sourceOrderParams.writeToParcel(parcel, i);
        }
        parcel.writeString(this.token);
        Map<String, String> map = this.metadata;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }
        WeChatParams weChatParams2 = this.weChatParams;
        if (weChatParams2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            weChatParams2.writeToParcel(parcel, i);
        }
        this.apiParams.writeToParcel(parcel, i);
        Set<String> set = this.attribution;
        parcel.writeInt(set.size());
        for (String writeString : set) {
            parcel.writeString(writeString);
        }
    }

    public SourceParams(String str, TypeData typeData2, Long l, String str2, OwnerParams ownerParams, Source.Usage usage2, String str3, Flow flow2, SourceOrderParams sourceOrderParams, String str4, Map<String, String> map, WeChatParams weChatParams2, ApiParams apiParams2, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "typeRaw");
        Intrinsics.checkNotNullParameter(apiParams2, "apiParams");
        Intrinsics.checkNotNullParameter(set, "attribution");
        this.typeRaw = str;
        this.typeData = typeData2;
        this.amount = l;
        this.currency = str2;
        this.owner = ownerParams;
        this.usage = usage2;
        this.returnUrl = str3;
        this.flow = flow2;
        this.sourceOrder = sourceOrderParams;
        this.token = str4;
        this.metadata = map;
        this.weChatParams = weChatParams2;
        this.apiParams = apiParams2;
        this.attribution = set;
    }

    public final String getTypeRaw() {
        return this.typeRaw;
    }

    public final TypeData getTypeData$payments_core_release() {
        return this.typeData;
    }

    public final void setTypeData$payments_core_release(TypeData typeData2) {
        this.typeData = typeData2;
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final void setAmount(Long l) {
        this.amount = l;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final OwnerParams getOwner() {
        return this.owner;
    }

    public final void setOwner(OwnerParams ownerParams) {
        this.owner = ownerParams;
    }

    public final Source.Usage getUsage() {
        return this.usage;
    }

    public final void setUsage(Source.Usage usage2) {
        this.usage = usage2;
    }

    public final String getReturnUrl() {
        return this.returnUrl;
    }

    public final void setReturnUrl(String str) {
        this.returnUrl = str;
    }

    public final Flow getFlow() {
        return this.flow;
    }

    public final void setFlow(Flow flow2) {
        this.flow = flow2;
    }

    public final SourceOrderParams getSourceOrder() {
        return this.sourceOrder;
    }

    public final void setSourceOrder(SourceOrderParams sourceOrderParams) {
        this.sourceOrder = sourceOrderParams;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(Map<String, String> map) {
        this.metadata = map;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SourceParams(java.lang.String r16, com.stripe.android.model.SourceParams.TypeData r17, java.lang.Long r18, java.lang.String r19, com.stripe.android.model.SourceParams.OwnerParams r20, com.stripe.android.model.Source.Usage r21, java.lang.String r22, com.stripe.android.model.SourceParams.Flow r23, com.stripe.android.model.SourceOrderParams r24, java.lang.String r25, java.util.Map r26, com.stripe.android.model.SourceParams.WeChatParams r27, com.stripe.android.model.SourceParams.ApiParams r28, java.util.Set r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r25
        L_0x004b:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r26
        L_0x0053:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r27
        L_0x005b:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0066
            com.stripe.android.model.SourceParams$ApiParams r13 = new com.stripe.android.model.SourceParams$ApiParams
            r14 = 1
            r13.<init>(r2, r14, r2)
            goto L_0x0068
        L_0x0066:
            r13 = r28
        L_0x0068:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0071
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
            goto L_0x0073
        L_0x0071:
            r0 = r29
        L_0x0073:
            r17 = r15
            r18 = r16
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.SourceParams.<init>(java.lang.String, com.stripe.android.model.SourceParams$TypeData, java.lang.Long, java.lang.String, com.stripe.android.model.SourceParams$OwnerParams, com.stripe.android.model.Source$Usage, java.lang.String, com.stripe.android.model.SourceParams$Flow, com.stripe.android.model.SourceOrderParams, java.lang.String, java.util.Map, com.stripe.android.model.SourceParams$WeChatParams, com.stripe.android.model.SourceParams$ApiParams, java.util.Set, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Set<String> getAttribution$payments_core_release() {
        return this.attribution;
    }

    public final String getType() {
        return Source.Companion.asSourceType(this.typeRaw);
    }

    public final Map<String, Object> getApiParameterMap() {
        return this.apiParams.getValue();
    }

    public final SourceParams setApiParameterMap(Map<String, ? extends Object> map) {
        SourceParams sourceParams = this;
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        sourceParams.apiParams = new ApiParams(map);
        return sourceParams;
    }

    public Map<String, Object> toParamMap() {
        Map<K, V> map;
        Map map2;
        Map map3;
        Map map4;
        Map<K, V> map5;
        Map<K, V> map6;
        Map map7;
        Map<K, V> map8;
        Map map9;
        Map map10;
        Map mapOf = MapsKt.mapOf(TuplesKt.to("type", this.typeRaw));
        Map<String, Object> value = this.apiParams.getValue();
        Map<K, V> map11 = null;
        if (!(!value.isEmpty())) {
            value = null;
        }
        if (value == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to(getTypeRaw(), value));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        Map<K, V> plus = MapsKt.plus(mapOf, (Map) map);
        TypeData typeData2 = this.typeData;
        Map<String, Map<String, Object>> createParams = typeData2 == null ? null : typeData2.createParams();
        if (createParams == null) {
            createParams = MapsKt.emptyMap();
        }
        Map<String, Map<String, Object>> plus2 = MapsKt.plus(plus, (Map<K, V>) createParams);
        Long l = this.amount;
        if (l == null) {
            map2 = null;
        } else {
            map2 = MapsKt.mapOf(TuplesKt.to("amount", Long.valueOf(l.longValue())));
        }
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        Map<String, Map<String, Object>> plus3 = MapsKt.plus(plus2, (Map<String, Map<String, Object>>) map2);
        String str = this.currency;
        if (str == null) {
            map3 = null;
        } else {
            map3 = MapsKt.mapOf(TuplesKt.to("currency", str));
        }
        if (map3 == null) {
            map3 = MapsKt.emptyMap();
        }
        Map<String, Map<String, Object>> plus4 = MapsKt.plus(plus3, (Map<String, Map<String, Object>>) map3);
        Flow flow2 = this.flow;
        if (flow2 == null) {
            map4 = null;
        } else {
            map4 = MapsKt.mapOf(TuplesKt.to(PARAM_FLOW, flow2.getCode$payments_core_release()));
        }
        if (map4 == null) {
            map4 = MapsKt.emptyMap();
        }
        Map<String, Map<String, Object>> plus5 = MapsKt.plus(plus4, (Map<String, Map<String, Object>>) map4);
        SourceOrderParams sourceOrderParams = this.sourceOrder;
        if (sourceOrderParams == null) {
            map5 = null;
        } else {
            map5 = MapsKt.mapOf(TuplesKt.to(PARAM_SOURCE_ORDER, sourceOrderParams.toParamMap()));
        }
        if (map5 == null) {
            map5 = MapsKt.emptyMap();
        }
        Map<String, Map<String, Object>> plus6 = MapsKt.plus(plus5, (Map<String, Map<String, Object>>) map5);
        OwnerParams ownerParams = this.owner;
        if (ownerParams == null) {
            map6 = null;
        } else {
            map6 = MapsKt.mapOf(TuplesKt.to(PARAM_OWNER, ownerParams.toParamMap()));
        }
        if (map6 == null) {
            map6 = MapsKt.emptyMap();
        }
        Map<String, Map<String, Object>> plus7 = MapsKt.plus(plus6, (Map<String, Map<String, Object>>) map6);
        String str2 = this.returnUrl;
        if (str2 == null) {
            map7 = null;
        } else {
            map7 = MapsKt.mapOf(TuplesKt.to(PARAM_REDIRECT, MapsKt.mapOf(TuplesKt.to("return_url", str2))));
        }
        if (map7 == null) {
            map7 = MapsKt.emptyMap();
        }
        Map<String, Map<String, Object>> plus8 = MapsKt.plus(plus7, (Map<String, Map<String, Object>>) map7);
        Map<String, String> map12 = this.metadata;
        if (map12 == null) {
            map8 = null;
        } else {
            map8 = MapsKt.mapOf(TuplesKt.to("metadata", map12));
        }
        if (map8 == null) {
            map8 = MapsKt.emptyMap();
        }
        Map<String, Map<String, Object>> plus9 = MapsKt.plus(plus8, (Map<String, Map<String, Object>>) map8);
        String str3 = this.token;
        if (str3 == null) {
            map9 = null;
        } else {
            map9 = MapsKt.mapOf(TuplesKt.to(PARAM_TOKEN, str3));
        }
        if (map9 == null) {
            map9 = MapsKt.emptyMap();
        }
        Map<String, Map<String, Object>> plus10 = MapsKt.plus(plus9, (Map<String, Map<String, Object>>) map9);
        Source.Usage usage2 = this.usage;
        if (usage2 == null) {
            map10 = null;
        } else {
            map10 = MapsKt.mapOf(TuplesKt.to(PARAM_USAGE, usage2.getCode$payments_core_release()));
        }
        if (map10 == null) {
            map10 = MapsKt.emptyMap();
        }
        Map<String, Map<String, Object>> plus11 = MapsKt.plus(plus10, (Map<String, Map<String, Object>>) map10);
        WeChatParams weChatParams2 = this.weChatParams;
        if (weChatParams2 != null) {
            map11 = MapsKt.mapOf(TuplesKt.to("wechat", weChatParams2.toParamMap()));
        }
        if (map11 == null) {
            map11 = MapsKt.emptyMap();
        }
        return MapsKt.plus(plus11, (Map<String, Map<String, Object>>) map11);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÂ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÂ\u0003J!\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bHÖ\u0001R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/model/SourceParams$WeChatParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "appId", "", "statementDescriptor", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceParams.kt */
    public static final class WeChatParams implements StripeParamsModel, Parcelable {
        public static final Parcelable.Creator<WeChatParams> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String PARAM_APPID = "appid";
        private static final String PARAM_STATEMENT_DESCRIPTOR = "statement_descriptor";
        private final String appId;
        private final String statementDescriptor;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Creator implements Parcelable.Creator<WeChatParams> {
            public final WeChatParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new WeChatParams(parcel.readString(), parcel.readString());
            }

            public final WeChatParams[] newArray(int i) {
                return new WeChatParams[i];
            }
        }

        public WeChatParams() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        private final String component1() {
            return this.appId;
        }

        private final String component2() {
            return this.statementDescriptor;
        }

        public static /* synthetic */ WeChatParams copy$default(WeChatParams weChatParams, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = weChatParams.appId;
            }
            if ((i & 2) != 0) {
                str2 = weChatParams.statementDescriptor;
            }
            return weChatParams.copy(str, str2);
        }

        public final WeChatParams copy(String str, String str2) {
            return new WeChatParams(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WeChatParams)) {
                return false;
            }
            WeChatParams weChatParams = (WeChatParams) obj;
            return Intrinsics.areEqual((Object) this.appId, (Object) weChatParams.appId) && Intrinsics.areEqual((Object) this.statementDescriptor, (Object) weChatParams.statementDescriptor);
        }

        public int hashCode() {
            String str = this.appId;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.statementDescriptor;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "WeChatParams(appId=" + this.appId + ", statementDescriptor=" + this.statementDescriptor + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.appId);
            parcel.writeString(this.statementDescriptor);
        }

        public WeChatParams(String str, String str2) {
            this.appId = str;
            this.statementDescriptor = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ WeChatParams(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public Map<String, Object> toParamMap() {
            Map map;
            Map emptyMap = MapsKt.emptyMap();
            String str = this.appId;
            Map map2 = null;
            if (str == null) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to(PARAM_APPID, str));
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            Map plus = MapsKt.plus(emptyMap, map);
            String str2 = this.statementDescriptor;
            if (str2 != null) {
                map2 = MapsKt.mapOf(TuplesKt.to(PARAM_STATEMENT_DESCRIPTOR, str2));
            }
            if (map2 == null) {
                map2 = MapsKt.emptyMap();
            }
            return MapsKt.plus(plus, map2);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/SourceParams$WeChatParams$Companion;", "", "()V", "PARAM_APPID", "", "PARAM_STATEMENT_DESCRIPTOR", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B7\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u001dJ9\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020 HÖ\u0001J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020$0'H\u0016J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020 HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006/"}, d2 = {"Lcom/stripe/android/model/SourceParams$OwnerParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "address", "Lcom/stripe/android/model/Address;", "email", "", "name", "phone", "(Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress$payments_core_release", "()Lcom/stripe/android/model/Address;", "setAddress$payments_core_release", "(Lcom/stripe/android/model/Address;)V", "getEmail$payments_core_release", "()Ljava/lang/String;", "setEmail$payments_core_release", "(Ljava/lang/String;)V", "getName$payments_core_release", "setName$payments_core_release", "getPhone$payments_core_release", "setPhone$payments_core_release", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceParams.kt */
    public static final class OwnerParams implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<OwnerParams> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_ADDRESS = "address";
        @Deprecated
        private static final String PARAM_EMAIL = "email";
        @Deprecated
        private static final String PARAM_NAME = "name";
        @Deprecated
        private static final String PARAM_PHONE = "phone";
        private Address address;
        private String email;
        private String name;
        private String phone;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Creator implements Parcelable.Creator<OwnerParams> {
            public final OwnerParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new OwnerParams(parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final OwnerParams[] newArray(int i) {
                return new OwnerParams[i];
            }
        }

        public OwnerParams() {
            this((Address) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public OwnerParams(Address address2) {
            this(address2, (String) null, (String) null, (String) null, 14, (DefaultConstructorMarker) null);
        }

        public OwnerParams(Address address2, String str) {
            this(address2, str, (String) null, (String) null, 12, (DefaultConstructorMarker) null);
        }

        public OwnerParams(Address address2, String str, String str2) {
            this(address2, str, str2, (String) null, 8, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ OwnerParams copy$default(OwnerParams ownerParams, Address address2, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                address2 = ownerParams.address;
            }
            if ((i & 2) != 0) {
                str = ownerParams.email;
            }
            if ((i & 4) != 0) {
                str2 = ownerParams.name;
            }
            if ((i & 8) != 0) {
                str3 = ownerParams.phone;
            }
            return ownerParams.copy(address2, str, str2, str3);
        }

        public final Address component1$payments_core_release() {
            return this.address;
        }

        public final String component2$payments_core_release() {
            return this.email;
        }

        public final String component3$payments_core_release() {
            return this.name;
        }

        public final String component4$payments_core_release() {
            return this.phone;
        }

        public final OwnerParams copy(Address address2, String str, String str2, String str3) {
            return new OwnerParams(address2, str, str2, str3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OwnerParams)) {
                return false;
            }
            OwnerParams ownerParams = (OwnerParams) obj;
            return Intrinsics.areEqual((Object) this.address, (Object) ownerParams.address) && Intrinsics.areEqual((Object) this.email, (Object) ownerParams.email) && Intrinsics.areEqual((Object) this.name, (Object) ownerParams.name) && Intrinsics.areEqual((Object) this.phone, (Object) ownerParams.phone);
        }

        public int hashCode() {
            Address address2 = this.address;
            int i = 0;
            int hashCode = (address2 == null ? 0 : address2.hashCode()) * 31;
            String str = this.email;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.name;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.phone;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "OwnerParams(address=" + this.address + ", email=" + this.email + ", name=" + this.name + ", phone=" + this.phone + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Address address2 = this.address;
            if (address2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                address2.writeToParcel(parcel, i);
            }
            parcel.writeString(this.email);
            parcel.writeString(this.name);
            parcel.writeString(this.phone);
        }

        public OwnerParams(Address address2, String str, String str2, String str3) {
            this.address = address2;
            this.email = str;
            this.name = str2;
            this.phone = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OwnerParams(Address address2, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : address2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        public final Address getAddress$payments_core_release() {
            return this.address;
        }

        public final void setAddress$payments_core_release(Address address2) {
            this.address = address2;
        }

        public final String getEmail$payments_core_release() {
            return this.email;
        }

        public final void setEmail$payments_core_release(String str) {
            this.email = str;
        }

        public final String getName$payments_core_release() {
            return this.name;
        }

        public final void setName$payments_core_release(String str) {
            this.name = str;
        }

        public final String getPhone$payments_core_release() {
            return this.phone;
        }

        public final void setPhone$payments_core_release(String str) {
            this.phone = str;
        }

        public Map<String, Object> toParamMap() {
            Map<K, V> map;
            Map map2;
            Map map3;
            Map emptyMap = MapsKt.emptyMap();
            Address address2 = this.address;
            Map map4 = null;
            if (address2 == null) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to("address", address2.toParamMap()));
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            Map<K, V> plus = MapsKt.plus(emptyMap, (Map) map);
            String str = this.email;
            if (str == null) {
                map2 = null;
            } else {
                map2 = MapsKt.mapOf(TuplesKt.to("email", str));
            }
            if (map2 == null) {
                map2 = MapsKt.emptyMap();
            }
            Map<K, V> plus2 = MapsKt.plus(plus, (Map<K, V>) map2);
            String str2 = this.name;
            if (str2 == null) {
                map3 = null;
            } else {
                map3 = MapsKt.mapOf(TuplesKt.to("name", str2));
            }
            if (map3 == null) {
                map3 = MapsKt.emptyMap();
            }
            Map<K, V> plus3 = MapsKt.plus(plus2, (Map<K, V>) map3);
            String str3 = this.phone;
            if (str3 != null) {
                map4 = MapsKt.mapOf(TuplesKt.to("phone", str3));
            }
            if (map4 == null) {
                map4 = MapsKt.emptyMap();
            }
            return MapsKt.plus(plus3, (Map<K, V>) map4);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/SourceParams$OwnerParams$Companion;", "", "()V", "PARAM_ADDRESS", "", "PARAM_EMAIL", "PARAM_NAME", "PARAM_PHONE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/SourceParams$Flow;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "Redirect", "Receiver", "CodeVerification", "None", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceParams.kt */
    public enum Flow {
        Redirect(SourceParams.PARAM_REDIRECT),
        Receiver("receiver"),
        CodeVerification("code_verification"),
        None(ViewProps.NONE);
        
        private final String code;

        private Flow(String str) {
            this.code = str;
        }

        public final String getCode$payments_core_release() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J:\u0010\u0017\u001a\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J:\u0010\u001a\u001a\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0004H\u0007J.\u0010%\u001a\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007J.\u0010&\u001a\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007J<\u0010'\u001a\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010)\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+H\u0007J\u0018\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0007J\"\u0010/\u001a\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J4\u00100\u001a\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u001e\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004022\b\b\u0001\u00103\u001a\u00020\u0004H\u0007J<\u00104\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\b\b\u0001\u00109\u001a\u00020\u0004H\u0007JL\u00104\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u00106\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u00109\u001a\u0004\u0018\u00010\u0004H\u0007J0\u0010:\u001a\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u00109\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u0004H\u0007J*\u0010=\u001a\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0004H\u0007J\u0010\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u0004H\u0007J.\u0010A\u001a\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/stripe/android/model/SourceParams$Companion;", "", "()V", "PARAM_AMOUNT", "", "PARAM_CLIENT_SECRET", "PARAM_CURRENCY", "PARAM_FLOW", "PARAM_METADATA", "PARAM_OWNER", "PARAM_REDIRECT", "PARAM_RETURN_URL", "PARAM_SOURCE_ORDER", "PARAM_TOKEN", "PARAM_TYPE", "PARAM_USAGE", "PARAM_WECHAT", "createAlipayReusableParams", "Lcom/stripe/android/model/SourceParams;", "currency", "name", "email", "returnUrl", "createAlipaySingleUseParams", "amount", "", "createBancontactParams", "statementDescriptor", "preferredLanguage", "createCardParams", "cardParams", "Lcom/stripe/android/model/CardParams;", "createCardParamsFromGooglePay", "googlePayPaymentData", "Lorg/json/JSONObject;", "createCustomParams", "type", "createEPSParams", "createGiropayParams", "createIdealParams", "bank", "createKlarna", "klarnaParams", "Lcom/stripe/android/model/KlarnaSourceParams;", "createMasterpassParams", "transactionId", "cartId", "createMultibancoParams", "createP24Params", "createRetrieveSourceParams", "", "clientSecret", "createSepaDebitParams", "iban", "addressLine1", "city", "postalCode", "country", "createSofortParams", "createSourceFromTokenParams", "tokenId", "createThreeDSecureParams", "cardId", "createVisaCheckoutParams", "callId", "createWeChatPayParams", "weChatAppId", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceParams.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[KlarnaSourceParams.LineItem.Type.values().length];
                iArr[KlarnaSourceParams.LineItem.Type.Sku.ordinal()] = 1;
                iArr[KlarnaSourceParams.LineItem.Type.Tax.ordinal()] = 2;
                iArr[KlarnaSourceParams.LineItem.Type.Shipping.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SourceParams createP24Params(long j, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "currency");
            Intrinsics.checkNotNullParameter(str3, "email");
            Intrinsics.checkNotNullParameter(str4, "returnUrl");
            OwnerParams ownerParams = r8;
            OwnerParams ownerParams2 = new OwnerParams((Address) null, str3, str2, (String) null, 9, (DefaultConstructorMarker) null);
            return new SourceParams("p24", (TypeData) null, Long.valueOf(j), str, ownerParams, (Source.Usage) null, str4, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16290, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SourceParams createAlipayReusableParams$default(Companion companion, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.createAlipayReusableParams(str, str2, str3, str4);
        }

        @JvmStatic
        public final SourceParams createAlipayReusableParams(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "currency");
            Intrinsics.checkNotNullParameter(str4, "returnUrl");
            Source.Usage usage = Source.Usage.Reusable;
            OwnerParams ownerParams = r8;
            OwnerParams ownerParams2 = new OwnerParams((Address) null, str3, str2, (String) null, 9, (DefaultConstructorMarker) null);
            return new SourceParams("alipay", (TypeData) null, (Long) null, str, ownerParams, usage, str4, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16262, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SourceParams createAlipaySingleUseParams$default(Companion companion, long j, String str, String str2, String str3, String str4, int i, Object obj) {
            return companion.createAlipaySingleUseParams(j, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, str4);
        }

        @JvmStatic
        public final SourceParams createAlipaySingleUseParams(long j, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "currency");
            Intrinsics.checkNotNullParameter(str4, "returnUrl");
            OwnerParams ownerParams = r8;
            OwnerParams ownerParams2 = new OwnerParams((Address) null, str3, str2, (String) null, 9, (DefaultConstructorMarker) null);
            return new SourceParams("alipay", (TypeData) null, Long.valueOf(j), str, ownerParams, (Source.Usage) null, str4, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16290, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SourceParams createWeChatPayParams$default(Companion companion, long j, String str, String str2, String str3, int i, Object obj) {
            if ((i & 8) != 0) {
                str3 = null;
            }
            return companion.createWeChatPayParams(j, str, str2, str3);
        }

        @JvmStatic
        public final SourceParams createWeChatPayParams(long j, String str, String str2, String str3) {
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str, "currency");
            Intrinsics.checkNotNullParameter(str4, "weChatAppId");
            WeChatParams weChatParams = r1;
            WeChatParams weChatParams2 = new WeChatParams(str4, str3);
            return new SourceParams("wechat", (TypeData) null, Long.valueOf(j), str, (OwnerParams) null, (Source.Usage) null, (String) null, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, weChatParams, (ApiParams) null, (Set) null, 14322, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final SourceParams createKlarna(String str, String str2, KlarnaSourceParams klarnaSourceParams) {
            SourceOrderParams.Item.Type type;
            Intrinsics.checkNotNullParameter(str, "returnUrl");
            Intrinsics.checkNotNullParameter(str2, "currency");
            Intrinsics.checkNotNullParameter(klarnaSourceParams, "klarnaParams");
            int i = 0;
            for (KlarnaSourceParams.LineItem totalAmount : klarnaSourceParams.getLineItems()) {
                i += totalAmount.getTotalAmount();
            }
            Iterable<KlarnaSourceParams.LineItem> lineItems = klarnaSourceParams.getLineItems();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(lineItems, 10));
            for (KlarnaSourceParams.LineItem lineItem : lineItems) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[lineItem.getItemType().ordinal()];
                if (i2 == 1) {
                    type = SourceOrderParams.Item.Type.Sku;
                } else if (i2 == 2) {
                    type = SourceOrderParams.Item.Type.Tax;
                } else if (i2 == 3) {
                    type = SourceOrderParams.Item.Type.Shipping;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList.add(new SourceOrderParams.Item(type, Integer.valueOf(lineItem.getTotalAmount()), str2, lineItem.getItemDescription(), (String) null, lineItem.getQuantity(), 16, (DefaultConstructorMarker) null));
            }
            SourceOrderParams sourceOrderParams = r0;
            SourceOrderParams sourceOrderParams2 = new SourceOrderParams((List) arrayList, (SourceOrderParams.Shipping) null, 2, (DefaultConstructorMarker) null);
            Flow flow = Flow.Redirect;
            OwnerParams ownerParams = r13;
            OwnerParams ownerParams2 = new OwnerParams(klarnaSourceParams.getBillingAddress(), klarnaSourceParams.getBillingEmail(), (String) null, klarnaSourceParams.getBillingPhone(), 4, (DefaultConstructorMarker) null);
            ApiParams apiParams = r0;
            ApiParams apiParams2 = new ApiParams(klarnaSourceParams.toParamMap());
            return new SourceParams("klarna", (TypeData) null, Long.valueOf((long) i), str2, ownerParams, (Source.Usage) null, str, flow, sourceOrderParams, (String) null, (Map) null, (WeChatParams) null, apiParams, (Set) null, 11810, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SourceParams createBancontactParams$default(Companion companion, long j, String str, String str2, String str3, String str4, int i, Object obj) {
            return companion.createBancontactParams(j, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
        }

        @JvmStatic
        public final SourceParams createBancontactParams(long j, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "returnUrl");
            TypeData.Bancontact bancontact = new TypeData.Bancontact(str3, str4);
            OwnerParams ownerParams = r8;
            OwnerParams ownerParams2 = new OwnerParams((Address) null, (String) null, str, (String) null, 11, (DefaultConstructorMarker) null);
            return new SourceParams("bancontact", bancontact, Long.valueOf(j), Source.EURO, ownerParams, (Source.Usage) null, str2, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16288, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final SourceParams createCustomParams(String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            return new SourceParams(str, (TypeData) null, (Long) null, (String) null, (OwnerParams) null, (Source.Usage) null, (String) null, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16382, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final SourceParams createSourceFromTokenParams(String str) {
            Intrinsics.checkNotNullParameter(str, "tokenId");
            return new SourceParams("card", (TypeData) null, (Long) null, (String) null, (OwnerParams) null, (Source.Usage) null, (String) null, (Flow) null, (SourceOrderParams) null, str, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 15870, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final SourceParams createCardParams(CardParams cardParams) {
            Intrinsics.checkNotNullParameter(cardParams, "cardParams");
            TypeData.Card card = new TypeData.Card(cardParams.getNumber$payments_core_release(), Integer.valueOf(cardParams.getExpMonth$payments_core_release()), Integer.valueOf(cardParams.getExpYear$payments_core_release()), cardParams.getCvc$payments_core_release());
            Set<String> attribution = cardParams.getAttribution();
            OwnerParams ownerParams = r2;
            OwnerParams ownerParams2 = new OwnerParams(cardParams.getAddress(), (String) null, cardParams.getName(), (String) null, 10, (DefaultConstructorMarker) null);
            return new SourceParams("card", card, (Long) null, (String) null, ownerParams, (Source.Usage) null, (String) null, (Flow) null, (SourceOrderParams) null, (String) null, cardParams.getMetadata(), (WeChatParams) null, (ApiParams) null, attribution, 7148, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final SourceParams createCardParamsFromGooglePay(JSONObject jSONObject) throws JSONException {
            String str;
            Card card;
            TokenizationMethod tokenizationMethod;
            JSONObject jSONObject2 = jSONObject;
            Intrinsics.checkNotNullParameter(jSONObject2, "googlePayPaymentData");
            GooglePayResult fromJson = GooglePayResult.Companion.fromJson(jSONObject2);
            Token token = fromJson.getToken();
            String str2 = null;
            if (token == null) {
                str = null;
            } else {
                str = token.getId();
            }
            if (str == null) {
                str = "";
            }
            String str3 = str;
            if (!(token == null || (card = token.getCard()) == null || (tokenizationMethod = card.getTokenizationMethod()) == null)) {
                str2 = tokenizationMethod.toString();
            }
            Set ofNotNull = SetsKt.setOfNotNull(str2);
            OwnerParams ownerParams = r1;
            OwnerParams ownerParams2 = new OwnerParams(fromJson.getAddress(), fromJson.getEmail(), fromJson.getName(), fromJson.getPhoneNumber());
            return new SourceParams("card", (TypeData) null, (Long) null, (String) null, ownerParams, (Source.Usage) null, (String) null, (Flow) null, (SourceOrderParams) null, str3, (Map) null, (WeChatParams) null, (ApiParams) null, ofNotNull, 7662, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SourceParams createEPSParams$default(Companion companion, long j, String str, String str2, String str3, int i, Object obj) {
            if ((i & 8) != 0) {
                str3 = null;
            }
            return companion.createEPSParams(j, str, str2, str3);
        }

        @JvmStatic
        public final SourceParams createEPSParams(long j, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "returnUrl");
            TypeData.Eps eps = new TypeData.Eps(str3);
            OwnerParams ownerParams = r8;
            OwnerParams ownerParams2 = new OwnerParams((Address) null, (String) null, str, (String) null, 11, (DefaultConstructorMarker) null);
            return new SourceParams("eps", eps, Long.valueOf(j), Source.EURO, ownerParams, (Source.Usage) null, str2, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16288, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SourceParams createGiropayParams$default(Companion companion, long j, String str, String str2, String str3, int i, Object obj) {
            if ((i & 8) != 0) {
                str3 = null;
            }
            return companion.createGiropayParams(j, str, str2, str3);
        }

        @JvmStatic
        public final SourceParams createGiropayParams(long j, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "returnUrl");
            TypeData.Giropay giropay = new TypeData.Giropay(str3);
            OwnerParams ownerParams = r8;
            OwnerParams ownerParams2 = new OwnerParams((Address) null, (String) null, str, (String) null, 11, (DefaultConstructorMarker) null);
            return new SourceParams("giropay", giropay, Long.valueOf(j), Source.EURO, ownerParams, (Source.Usage) null, str2, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16288, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SourceParams createIdealParams$default(Companion companion, long j, String str, String str2, String str3, String str4, int i, Object obj) {
            return companion.createIdealParams(j, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
        }

        @JvmStatic
        public final SourceParams createIdealParams(long j, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str2, "returnUrl");
            TypeData.Ideal ideal = new TypeData.Ideal(str3, str4);
            OwnerParams ownerParams = r8;
            OwnerParams ownerParams2 = new OwnerParams((Address) null, (String) null, str, (String) null, 11, (DefaultConstructorMarker) null);
            return new SourceParams("ideal", ideal, Long.valueOf(j), Source.EURO, ownerParams, (Source.Usage) null, str2, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16288, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final SourceParams createMultibancoParams(long j, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "returnUrl");
            Intrinsics.checkNotNullParameter(str2, "email");
            OwnerParams ownerParams = r8;
            OwnerParams ownerParams2 = new OwnerParams((Address) null, str2, (String) null, (String) null, 13, (DefaultConstructorMarker) null);
            return new SourceParams("multibanco", (TypeData) null, Long.valueOf(j), Source.EURO, ownerParams, (Source.Usage) null, str, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16290, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final SourceParams createSepaDebitParams(String str, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "iban");
            Intrinsics.checkNotNullParameter(str4, PostalAddressParser.LOCALITY_KEY);
            Intrinsics.checkNotNullParameter(str5, "postalCode");
            Intrinsics.checkNotNullParameter(str6, "country");
            return createSepaDebitParams(str, str2, (String) null, str3, str4, str5, str6);
        }

        @JvmStatic
        public final SourceParams createSepaDebitParams(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            String str8 = str2;
            String str9 = str;
            Intrinsics.checkNotNullParameter(str9, "name");
            Intrinsics.checkNotNullParameter(str8, "iban");
            TypeData.SepaDebit sepaDebit = new TypeData.SepaDebit(str8);
            OwnerParams ownerParams = r2;
            OwnerParams ownerParams2 = new OwnerParams(new Address.Builder().setLine1(str4).setCity(str5).setPostalCode(str6).setCountry(str7).build(), str3, str9, (String) null, 8, (DefaultConstructorMarker) null);
            return new SourceParams("sepa_debit", sepaDebit, (Long) null, Source.EURO, ownerParams, (Source.Usage) null, (String) null, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16356, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SourceParams createSofortParams$default(Companion companion, long j, String str, String str2, String str3, int i, Object obj) {
            if ((i & 8) != 0) {
                str3 = null;
            }
            return companion.createSofortParams(j, str, str2, str3);
        }

        @JvmStatic
        public final SourceParams createSofortParams(long j, String str, String str2, String str3) {
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str, "returnUrl");
            Intrinsics.checkNotNullParameter(str4, "country");
            return new SourceParams("sofort", new TypeData.Sofort(str4, str3), Long.valueOf(j), Source.EURO, (OwnerParams) null, (Source.Usage) null, str, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16304, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final SourceParams createThreeDSecureParams(long j, String str, String str2, String str3) {
            String str4 = str3;
            Intrinsics.checkNotNullParameter(str, "currency");
            Intrinsics.checkNotNullParameter(str2, "returnUrl");
            Intrinsics.checkNotNullParameter(str4, "cardId");
            return new SourceParams("three_d_secure", new TypeData.ThreeDSecure(str4), Long.valueOf(j), str, (OwnerParams) null, (Source.Usage) null, str2, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16304, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final SourceParams createVisaCheckoutParams(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "callId");
            return new SourceParams("card", new TypeData.VisaCheckout(str2), (Long) null, (String) null, (OwnerParams) null, (Source.Usage) null, (String) null, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16380, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final SourceParams createMasterpassParams(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str3, "transactionId");
            Intrinsics.checkNotNullParameter(str4, "cartId");
            return new SourceParams("card", new TypeData.Masterpass(str3, str4), (Long) null, (String) null, (OwnerParams) null, (Source.Usage) null, (String) null, (Flow) null, (SourceOrderParams) null, (String) null, (Map) null, (WeChatParams) null, (ApiParams) null, (Set) null, 16380, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final Map<String, String> createRetrieveSourceParams(String str) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return MapsKt.mapOf(TuplesKt.to("client_secret", str));
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0010\u001a\u00020\fHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fHÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/SourceParams$ApiParams;", "Landroid/os/Parcelable;", "value", "", "", "", "(Ljava/util/Map;)V", "getValue", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceParams.kt */
    public static final class ApiParams implements Parcelable {
        public static final Parcelable.Creator<ApiParams> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Map<String, Object> value;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Creator implements Parcelable.Creator<ApiParams> {
            public final ApiParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return ApiParams.Companion.create(parcel);
            }

            public final ApiParams[] newArray(int i) {
                return new ApiParams[i];
            }
        }

        public ApiParams() {
            this((Map) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ApiParams copy$default(ApiParams apiParams, Map<String, Object> map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = apiParams.value;
            }
            return apiParams.copy(map);
        }

        public final Map<String, Object> component1() {
            return this.value;
        }

        public final ApiParams copy(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "value");
            return new ApiParams(map);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApiParams) && Intrinsics.areEqual((Object) this.value, (Object) ((ApiParams) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "ApiParams(value=" + this.value + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Companion.write(this, parcel, i);
        }

        public ApiParams(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "value");
            this.value = map;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ApiParams(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, Object> getValue() {
            return this.value;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/SourceParams$ApiParams$Companion;", "Lkotlinx/parcelize/Parceler;", "Lcom/stripe/android/model/SourceParams$ApiParams;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Companion implements Parceler<ApiParams> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public ApiParams[] newArray(int i) {
                return (ApiParams[]) Parceler.DefaultImpls.newArray(this, i);
            }

            public void write(ApiParams apiParams, Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(apiParams, "<this>");
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                JSONObject mapToJsonObject = StripeJsonUtils.INSTANCE.mapToJsonObject(apiParams.getValue());
                parcel.writeString(mapToJsonObject == null ? null : mapToJsonObject.toString());
            }

            public ApiParams create(Parcel parcel) {
                JSONObject jSONObject;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                StripeJsonUtils stripeJsonUtils = StripeJsonUtils.INSTANCE;
                String readString = parcel.readString();
                if (readString == null) {
                    jSONObject = null;
                } else {
                    jSONObject = new JSONObject(readString);
                }
                Map jsonObjectToMap = stripeJsonUtils.jsonObjectToMap(jSONObject);
                if (jsonObjectToMap == null) {
                    jsonObjectToMap = MapsKt.emptyMap();
                }
                return new ApiParams(jsonObjectToMap);
            }
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\n\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u000e0\u000eR&\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0001\n\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"¨\u0006#"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData;", "Landroid/os/Parcelable;", "()V", "params", "", "Lkotlin/Pair;", "", "", "getParams", "()Ljava/util/List;", "type", "getType", "()Ljava/lang/String;", "createParams", "", "Bancontact", "Card", "Eps", "Giropay", "Ideal", "Masterpass", "SepaDebit", "Sofort", "ThreeDSecure", "VisaCheckout", "Lcom/stripe/android/model/SourceParams$TypeData$Card;", "Lcom/stripe/android/model/SourceParams$TypeData$Eps;", "Lcom/stripe/android/model/SourceParams$TypeData$Giropay;", "Lcom/stripe/android/model/SourceParams$TypeData$Ideal;", "Lcom/stripe/android/model/SourceParams$TypeData$Masterpass;", "Lcom/stripe/android/model/SourceParams$TypeData$Sofort;", "Lcom/stripe/android/model/SourceParams$TypeData$SepaDebit;", "Lcom/stripe/android/model/SourceParams$TypeData$ThreeDSecure;", "Lcom/stripe/android/model/SourceParams$TypeData$VisaCheckout;", "Lcom/stripe/android/model/SourceParams$TypeData$Bancontact;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceParams.kt */
    public static abstract class TypeData implements Parcelable {
        public /* synthetic */ TypeData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract List<Pair<String, Object>> getParams();

        public abstract String getType();

        private TypeData() {
        }

        public final Map<String, Map<String, Object>> createParams() {
            Map<String, Map<String, Object>> map;
            Map<String, Map<String, Object>> emptyMap = MapsKt.emptyMap();
            Iterator it = getParams().iterator();
            while (true) {
                map = null;
                if (!it.hasNext()) {
                    break;
                }
                Pair pair = (Pair) it.next();
                String str = (String) pair.component1();
                Object component2 = pair.component2();
                if (component2 != null) {
                    map = MapsKt.mapOf(TuplesKt.to(str, component2));
                }
                if (map == null) {
                    map = MapsKt.emptyMap();
                }
                emptyMap = MapsKt.plus(emptyMap, map);
            }
            if (!(!emptyMap.isEmpty())) {
                emptyMap = null;
            }
            if (emptyMap != null) {
                map = MapsKt.mapOf(TuplesKt.to(getType(), emptyMap));
            }
            return map == null ? MapsKt.emptyMap() : map;
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR(\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\n¨\u0006*"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Card;", "Lcom/stripe/android/model/SourceParams$TypeData;", "number", "", "expMonth", "", "expYear", "cvc", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCvc", "()Ljava/lang/String;", "getExpMonth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExpYear", "getNumber", "params", "", "Lkotlin/Pair;", "", "getParams", "()Ljava/util/List;", "type", "getType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/stripe/android/model/SourceParams$TypeData$Card;", "describeContents", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Card extends TypeData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Card> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_CVC = "cvc";
            @Deprecated
            private static final String PARAM_EXP_MONTH = "exp_month";
            @Deprecated
            private static final String PARAM_EXP_YEAR = "exp_year";
            @Deprecated
            private static final String PARAM_NUMBER = "number";
            private final String cvc;
            private final Integer expMonth;
            private final Integer expYear;
            private final String number;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            public static final class Creator implements Parcelable.Creator<Card> {
                public final Card createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    Integer num = null;
                    Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                    if (parcel.readInt() != 0) {
                        num = Integer.valueOf(parcel.readInt());
                    }
                    return new Card(readString, valueOf, num, parcel.readString());
                }

                public final Card[] newArray(int i) {
                    return new Card[i];
                }
            }

            public static /* synthetic */ Card copy$default(Card card, String str, Integer num, Integer num2, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = card.number;
                }
                if ((i & 2) != 0) {
                    num = card.expMonth;
                }
                if ((i & 4) != 0) {
                    num2 = card.expYear;
                }
                if ((i & 8) != 0) {
                    str2 = card.cvc;
                }
                return card.copy(str, num, num2, str2);
            }

            public final String component1() {
                return this.number;
            }

            public final Integer component2() {
                return this.expMonth;
            }

            public final Integer component3() {
                return this.expYear;
            }

            public final String component4() {
                return this.cvc;
            }

            public final Card copy(String str, Integer num, Integer num2, String str2) {
                return new Card(str, num, num2, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Card)) {
                    return false;
                }
                Card card = (Card) obj;
                return Intrinsics.areEqual((Object) this.number, (Object) card.number) && Intrinsics.areEqual((Object) this.expMonth, (Object) card.expMonth) && Intrinsics.areEqual((Object) this.expYear, (Object) card.expYear) && Intrinsics.areEqual((Object) this.cvc, (Object) card.cvc);
            }

            public String getType() {
                return "card";
            }

            public int hashCode() {
                String str = this.number;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                Integer num = this.expMonth;
                int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
                Integer num2 = this.expYear;
                int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
                String str2 = this.cvc;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode3 + i;
            }

            public String toString() {
                return "Card(number=" + this.number + ", expMonth=" + this.expMonth + ", expYear=" + this.expYear + ", cvc=" + this.cvc + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.number);
                Integer num = this.expMonth;
                if (num == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(num.intValue());
                }
                Integer num2 = this.expYear;
                if (num2 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(num2.intValue());
                }
                parcel.writeString(this.cvc);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Card(String str, Integer num, Integer num2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, num, num2, (i & 8) != 0 ? null : str2);
            }

            public final String getNumber() {
                return this.number;
            }

            public final Integer getExpMonth() {
                return this.expMonth;
            }

            public final Integer getExpYear() {
                return this.expYear;
            }

            public final String getCvc() {
                return this.cvc;
            }

            public Card(String str, Integer num, Integer num2, String str2) {
                super((DefaultConstructorMarker) null);
                this.number = str;
                this.expMonth = num;
                this.expYear = num2;
                this.cvc = str2;
            }

            public List<Pair<String, Object>> getParams() {
                return CollectionsKt.listOf(TuplesKt.to(PARAM_NUMBER, this.number), TuplesKt.to(PARAM_EXP_MONTH, this.expMonth), TuplesKt.to(PARAM_EXP_YEAR, this.expYear), TuplesKt.to(PARAM_CVC, this.cvc));
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Card$Companion;", "", "()V", "PARAM_CVC", "", "PARAM_EXP_MONTH", "PARAM_EXP_YEAR", "PARAM_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R(\u0010\u0005\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Eps;", "Lcom/stripe/android/model/SourceParams$TypeData;", "statementDescriptor", "", "(Ljava/lang/String;)V", "params", "", "Lkotlin/Pair;", "getParams", "()Ljava/util/List;", "getStatementDescriptor", "()Ljava/lang/String;", "setStatementDescriptor", "type", "getType", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Eps extends TypeData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Eps> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_STATEMENT_DESCRIPTOR = "statement_descriptor";
            private String statementDescriptor;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            public static final class Creator implements Parcelable.Creator<Eps> {
                public final Eps createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Eps(parcel.readString());
                }

                public final Eps[] newArray(int i) {
                    return new Eps[i];
                }
            }

            public Eps() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Eps copy$default(Eps eps, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = eps.statementDescriptor;
                }
                return eps.copy(str);
            }

            public final String component1() {
                return this.statementDescriptor;
            }

            public final Eps copy(String str) {
                return new Eps(str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Eps) && Intrinsics.areEqual((Object) this.statementDescriptor, (Object) ((Eps) obj).statementDescriptor);
            }

            public String getType() {
                return "eps";
            }

            public int hashCode() {
                String str = this.statementDescriptor;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Eps(statementDescriptor=" + this.statementDescriptor + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.statementDescriptor);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Eps(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getStatementDescriptor() {
                return this.statementDescriptor;
            }

            public final void setStatementDescriptor(String str) {
                this.statementDescriptor = str;
            }

            public Eps(String str) {
                super((DefaultConstructorMarker) null);
                this.statementDescriptor = str;
            }

            public List<Pair<String, String>> getParams() {
                return CollectionsKt.listOf(TuplesKt.to(PARAM_STATEMENT_DESCRIPTOR, this.statementDescriptor));
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Eps$Companion;", "", "()V", "PARAM_STATEMENT_DESCRIPTOR", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R(\u0010\u0005\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Giropay;", "Lcom/stripe/android/model/SourceParams$TypeData;", "statementDescriptor", "", "(Ljava/lang/String;)V", "params", "", "Lkotlin/Pair;", "getParams", "()Ljava/util/List;", "getStatementDescriptor", "()Ljava/lang/String;", "setStatementDescriptor", "type", "getType", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Giropay extends TypeData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Giropay> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_STATEMENT_DESCRIPTOR = "statement_descriptor";
            private String statementDescriptor;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            public static final class Creator implements Parcelable.Creator<Giropay> {
                public final Giropay createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Giropay(parcel.readString());
                }

                public final Giropay[] newArray(int i) {
                    return new Giropay[i];
                }
            }

            public Giropay() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Giropay copy$default(Giropay giropay, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = giropay.statementDescriptor;
                }
                return giropay.copy(str);
            }

            public final String component1() {
                return this.statementDescriptor;
            }

            public final Giropay copy(String str) {
                return new Giropay(str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Giropay) && Intrinsics.areEqual((Object) this.statementDescriptor, (Object) ((Giropay) obj).statementDescriptor);
            }

            public String getType() {
                return "giropay";
            }

            public int hashCode() {
                String str = this.statementDescriptor;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Giropay(statementDescriptor=" + this.statementDescriptor + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.statementDescriptor);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Giropay(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getStatementDescriptor() {
                return this.statementDescriptor;
            }

            public final void setStatementDescriptor(String str) {
                this.statementDescriptor = str;
            }

            public Giropay(String str) {
                super((DefaultConstructorMarker) null);
                this.statementDescriptor = str;
            }

            public List<Pair<String, String>> getParams() {
                return CollectionsKt.listOf(TuplesKt.to(PARAM_STATEMENT_DESCRIPTOR, this.statementDescriptor));
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Giropay$Companion;", "", "()V", "PARAM_STATEMENT_DESCRIPTOR", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f0\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007¨\u0006$"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Ideal;", "Lcom/stripe/android/model/SourceParams$TypeData;", "statementDescriptor", "", "bank", "(Ljava/lang/String;Ljava/lang/String;)V", "getBank", "()Ljava/lang/String;", "setBank", "(Ljava/lang/String;)V", "params", "", "Lkotlin/Pair;", "getParams", "()Ljava/util/List;", "getStatementDescriptor", "setStatementDescriptor", "type", "getType", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Ideal extends TypeData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Ideal> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_BANK = "bank";
            @Deprecated
            private static final String PARAM_STATEMENT_DESCRIPTOR = "statement_descriptor";
            private String bank;
            private String statementDescriptor;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            public static final class Creator implements Parcelable.Creator<Ideal> {
                public final Ideal createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Ideal(parcel.readString(), parcel.readString());
                }

                public final Ideal[] newArray(int i) {
                    return new Ideal[i];
                }
            }

            public Ideal() {
                this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Ideal copy$default(Ideal ideal, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = ideal.statementDescriptor;
                }
                if ((i & 2) != 0) {
                    str2 = ideal.bank;
                }
                return ideal.copy(str, str2);
            }

            public final String component1() {
                return this.statementDescriptor;
            }

            public final String component2() {
                return this.bank;
            }

            public final Ideal copy(String str, String str2) {
                return new Ideal(str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Ideal)) {
                    return false;
                }
                Ideal ideal = (Ideal) obj;
                return Intrinsics.areEqual((Object) this.statementDescriptor, (Object) ideal.statementDescriptor) && Intrinsics.areEqual((Object) this.bank, (Object) ideal.bank);
            }

            public String getType() {
                return "ideal";
            }

            public int hashCode() {
                String str = this.statementDescriptor;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.bank;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                return "Ideal(statementDescriptor=" + this.statementDescriptor + ", bank=" + this.bank + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.statementDescriptor);
                parcel.writeString(this.bank);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Ideal(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            public final String getStatementDescriptor() {
                return this.statementDescriptor;
            }

            public final void setStatementDescriptor(String str) {
                this.statementDescriptor = str;
            }

            public final String getBank() {
                return this.bank;
            }

            public final void setBank(String str) {
                this.bank = str;
            }

            public Ideal(String str, String str2) {
                super((DefaultConstructorMarker) null);
                this.statementDescriptor = str;
                this.bank = str2;
            }

            public List<Pair<String, String>> getParams() {
                return CollectionsKt.listOf(TuplesKt.to(PARAM_STATEMENT_DESCRIPTOR, this.statementDescriptor), TuplesKt.to(PARAM_BANK, this.bank));
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Ideal$Companion;", "", "()V", "PARAM_BANK", "", "PARAM_STATEMENT_DESCRIPTOR", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR2\u0010\n\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r0\f0\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007¨\u0006%"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Masterpass;", "Lcom/stripe/android/model/SourceParams$TypeData;", "transactionId", "", "cartId", "(Ljava/lang/String;Ljava/lang/String;)V", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "params", "", "Lkotlin/Pair;", "", "getParams", "()Ljava/util/List;", "getTransactionId", "setTransactionId", "type", "getType", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Masterpass extends TypeData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Masterpass> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_CART_ID = "cart_id";
            @Deprecated
            private static final String PARAM_MASTERPASS = "masterpass";
            @Deprecated
            private static final String PARAM_TRANSACTION_ID = "transaction_id";
            private String cartId;
            private String transactionId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            public static final class Creator implements Parcelable.Creator<Masterpass> {
                public final Masterpass createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Masterpass(parcel.readString(), parcel.readString());
                }

                public final Masterpass[] newArray(int i) {
                    return new Masterpass[i];
                }
            }

            public static /* synthetic */ Masterpass copy$default(Masterpass masterpass, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = masterpass.transactionId;
                }
                if ((i & 2) != 0) {
                    str2 = masterpass.cartId;
                }
                return masterpass.copy(str, str2);
            }

            public final String component1() {
                return this.transactionId;
            }

            public final String component2() {
                return this.cartId;
            }

            public final Masterpass copy(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "transactionId");
                Intrinsics.checkNotNullParameter(str2, "cartId");
                return new Masterpass(str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Masterpass)) {
                    return false;
                }
                Masterpass masterpass = (Masterpass) obj;
                return Intrinsics.areEqual((Object) this.transactionId, (Object) masterpass.transactionId) && Intrinsics.areEqual((Object) this.cartId, (Object) masterpass.cartId);
            }

            public String getType() {
                return "card";
            }

            public int hashCode() {
                return (this.transactionId.hashCode() * 31) + this.cartId.hashCode();
            }

            public String toString() {
                return "Masterpass(transactionId=" + this.transactionId + ", cartId=" + this.cartId + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.transactionId);
                parcel.writeString(this.cartId);
            }

            public final String getTransactionId() {
                return this.transactionId;
            }

            public final void setTransactionId(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.transactionId = str;
            }

            public final String getCartId() {
                return this.cartId;
            }

            public final void setCartId(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.cartId = str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Masterpass(String str, String str2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "transactionId");
                Intrinsics.checkNotNullParameter(str2, "cartId");
                this.transactionId = str;
                this.cartId = str2;
            }

            public List<Pair<String, Map<String, String>>> getParams() {
                return CollectionsKt.listOf(TuplesKt.to(PARAM_MASTERPASS, MapsKt.mapOf(TuplesKt.to("transaction_id", this.transactionId), TuplesKt.to(PARAM_CART_ID, this.cartId))));
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Masterpass$Companion;", "", "()V", "PARAM_CART_ID", "", "PARAM_MASTERPASS", "PARAM_TRANSACTION_ID", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f0\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007¨\u0006$"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Sofort;", "Lcom/stripe/android/model/SourceParams$TypeData;", "country", "", "statementDescriptor", "(Ljava/lang/String;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "params", "", "Lkotlin/Pair;", "getParams", "()Ljava/util/List;", "getStatementDescriptor", "setStatementDescriptor", "type", "getType", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Sofort extends TypeData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Sofort> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_COUNTRY = "country";
            @Deprecated
            private static final String PARAM_STATEMENT_DESCRIPTOR = "statement_descriptor";
            private String country;
            private String statementDescriptor;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            public static final class Creator implements Parcelable.Creator<Sofort> {
                public final Sofort createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Sofort(parcel.readString(), parcel.readString());
                }

                public final Sofort[] newArray(int i) {
                    return new Sofort[i];
                }
            }

            public static /* synthetic */ Sofort copy$default(Sofort sofort, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = sofort.country;
                }
                if ((i & 2) != 0) {
                    str2 = sofort.statementDescriptor;
                }
                return sofort.copy(str, str2);
            }

            public final String component1() {
                return this.country;
            }

            public final String component2() {
                return this.statementDescriptor;
            }

            public final Sofort copy(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "country");
                return new Sofort(str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Sofort)) {
                    return false;
                }
                Sofort sofort = (Sofort) obj;
                return Intrinsics.areEqual((Object) this.country, (Object) sofort.country) && Intrinsics.areEqual((Object) this.statementDescriptor, (Object) sofort.statementDescriptor);
            }

            public String getType() {
                return "sofort";
            }

            public int hashCode() {
                int hashCode = this.country.hashCode() * 31;
                String str = this.statementDescriptor;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "Sofort(country=" + this.country + ", statementDescriptor=" + this.statementDescriptor + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.country);
                parcel.writeString(this.statementDescriptor);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Sofort(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : str2);
            }

            public final String getCountry() {
                return this.country;
            }

            public final void setCountry(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.country = str;
            }

            public final String getStatementDescriptor() {
                return this.statementDescriptor;
            }

            public final void setStatementDescriptor(String str) {
                this.statementDescriptor = str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Sofort(String str, String str2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "country");
                this.country = str;
                this.statementDescriptor = str2;
            }

            public List<Pair<String, String>> getParams() {
                return CollectionsKt.listOf(TuplesKt.to("country", this.country), TuplesKt.to(PARAM_STATEMENT_DESCRIPTOR, this.statementDescriptor));
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Sofort$Companion;", "", "()V", "PARAM_COUNTRY", "", "PARAM_STATEMENT_DESCRIPTOR", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R(\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$SepaDebit;", "Lcom/stripe/android/model/SourceParams$TypeData;", "iban", "", "(Ljava/lang/String;)V", "getIban", "()Ljava/lang/String;", "setIban", "params", "", "Lkotlin/Pair;", "getParams", "()Ljava/util/List;", "type", "getType", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class SepaDebit extends TypeData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<SepaDebit> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_IBAN = "iban";
            private String iban;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            public static final class Creator implements Parcelable.Creator<SepaDebit> {
                public final SepaDebit createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new SepaDebit(parcel.readString());
                }

                public final SepaDebit[] newArray(int i) {
                    return new SepaDebit[i];
                }
            }

            public static /* synthetic */ SepaDebit copy$default(SepaDebit sepaDebit, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = sepaDebit.iban;
                }
                return sepaDebit.copy(str);
            }

            public final String component1() {
                return this.iban;
            }

            public final SepaDebit copy(String str) {
                Intrinsics.checkNotNullParameter(str, PARAM_IBAN);
                return new SepaDebit(str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SepaDebit) && Intrinsics.areEqual((Object) this.iban, (Object) ((SepaDebit) obj).iban);
            }

            public String getType() {
                return "sepa_debit";
            }

            public int hashCode() {
                return this.iban.hashCode();
            }

            public String toString() {
                return "SepaDebit(iban=" + this.iban + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.iban);
            }

            public final String getIban() {
                return this.iban;
            }

            public final void setIban(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.iban = str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SepaDebit(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, PARAM_IBAN);
                this.iban = str;
            }

            public List<Pair<String, String>> getParams() {
                return CollectionsKt.listOf(TuplesKt.to(PARAM_IBAN, this.iban));
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$SepaDebit$Companion;", "", "()V", "PARAM_IBAN", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R(\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$ThreeDSecure;", "Lcom/stripe/android/model/SourceParams$TypeData;", "cardId", "", "(Ljava/lang/String;)V", "getCardId", "()Ljava/lang/String;", "setCardId", "params", "", "Lkotlin/Pair;", "getParams", "()Ljava/util/List;", "type", "getType", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class ThreeDSecure extends TypeData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<ThreeDSecure> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_CARD = "card";
            private String cardId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            public static final class Creator implements Parcelable.Creator<ThreeDSecure> {
                public final ThreeDSecure createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ThreeDSecure(parcel.readString());
                }

                public final ThreeDSecure[] newArray(int i) {
                    return new ThreeDSecure[i];
                }
            }

            public static /* synthetic */ ThreeDSecure copy$default(ThreeDSecure threeDSecure, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = threeDSecure.cardId;
                }
                return threeDSecure.copy(str);
            }

            public final String component1() {
                return this.cardId;
            }

            public final ThreeDSecure copy(String str) {
                Intrinsics.checkNotNullParameter(str, "cardId");
                return new ThreeDSecure(str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ThreeDSecure) && Intrinsics.areEqual((Object) this.cardId, (Object) ((ThreeDSecure) obj).cardId);
            }

            public String getType() {
                return "three_d_secure";
            }

            public int hashCode() {
                return this.cardId.hashCode();
            }

            public String toString() {
                return "ThreeDSecure(cardId=" + this.cardId + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.cardId);
            }

            public final String getCardId() {
                return this.cardId;
            }

            public final void setCardId(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.cardId = str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ThreeDSecure(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "cardId");
                this.cardId = str;
            }

            public List<Pair<String, String>> getParams() {
                return CollectionsKt.listOf(TuplesKt.to("card", this.cardId));
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$ThreeDSecure$Companion;", "", "()V", "PARAM_CARD", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R(\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$VisaCheckout;", "Lcom/stripe/android/model/SourceParams$TypeData;", "callId", "", "(Ljava/lang/String;)V", "getCallId", "()Ljava/lang/String;", "setCallId", "params", "", "Lkotlin/Pair;", "", "getParams", "()Ljava/util/List;", "type", "getType", "component1", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class VisaCheckout extends TypeData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<VisaCheckout> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_CALL_ID = "callid";
            @Deprecated
            private static final String PARAM_VISA_CHECKOUT = "visa_checkout";
            private String callId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            public static final class Creator implements Parcelable.Creator<VisaCheckout> {
                public final VisaCheckout createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new VisaCheckout(parcel.readString());
                }

                public final VisaCheckout[] newArray(int i) {
                    return new VisaCheckout[i];
                }
            }

            public static /* synthetic */ VisaCheckout copy$default(VisaCheckout visaCheckout, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = visaCheckout.callId;
                }
                return visaCheckout.copy(str);
            }

            public final String component1() {
                return this.callId;
            }

            public final VisaCheckout copy(String str) {
                Intrinsics.checkNotNullParameter(str, "callId");
                return new VisaCheckout(str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof VisaCheckout) && Intrinsics.areEqual((Object) this.callId, (Object) ((VisaCheckout) obj).callId);
            }

            public String getType() {
                return "card";
            }

            public int hashCode() {
                return this.callId.hashCode();
            }

            public String toString() {
                return "VisaCheckout(callId=" + this.callId + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.callId);
            }

            public final String getCallId() {
                return this.callId;
            }

            public final void setCallId(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.callId = str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public VisaCheckout(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "callId");
                this.callId = str;
            }

            public List<Pair<String, Object>> getParams() {
                return CollectionsKt.listOf(TuplesKt.to(PARAM_VISA_CHECKOUT, MapsKt.mapOf(TuplesKt.to(PARAM_CALL_ID, this.callId))));
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$VisaCheckout$Companion;", "", "()V", "PARAM_CALL_ID", "", "PARAM_VISA_CHECKOUT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R(\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b0\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006$"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Bancontact;", "Lcom/stripe/android/model/SourceParams$TypeData;", "statementDescriptor", "", "preferredLanguage", "(Ljava/lang/String;Ljava/lang/String;)V", "params", "", "Lkotlin/Pair;", "getParams", "()Ljava/util/List;", "getPreferredLanguage", "()Ljava/lang/String;", "setPreferredLanguage", "(Ljava/lang/String;)V", "getStatementDescriptor", "setStatementDescriptor", "type", "getType", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceParams.kt */
        public static final class Bancontact extends TypeData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Bancontact> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_PREFERRED_LANGUAGE = "preferred_language";
            @Deprecated
            private static final String PARAM_STATEMENT_DESCRIPTOR = "statement_descriptor";
            private String preferredLanguage;
            private String statementDescriptor;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            public static final class Creator implements Parcelable.Creator<Bancontact> {
                public final Bancontact createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Bancontact(parcel.readString(), parcel.readString());
                }

                public final Bancontact[] newArray(int i) {
                    return new Bancontact[i];
                }
            }

            public Bancontact() {
                this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Bancontact copy$default(Bancontact bancontact, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = bancontact.statementDescriptor;
                }
                if ((i & 2) != 0) {
                    str2 = bancontact.preferredLanguage;
                }
                return bancontact.copy(str, str2);
            }

            public final String component1() {
                return this.statementDescriptor;
            }

            public final String component2() {
                return this.preferredLanguage;
            }

            public final Bancontact copy(String str, String str2) {
                return new Bancontact(str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Bancontact)) {
                    return false;
                }
                Bancontact bancontact = (Bancontact) obj;
                return Intrinsics.areEqual((Object) this.statementDescriptor, (Object) bancontact.statementDescriptor) && Intrinsics.areEqual((Object) this.preferredLanguage, (Object) bancontact.preferredLanguage);
            }

            public String getType() {
                return "bancontact";
            }

            public int hashCode() {
                String str = this.statementDescriptor;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.preferredLanguage;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                return "Bancontact(statementDescriptor=" + this.statementDescriptor + ", preferredLanguage=" + this.preferredLanguage + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.statementDescriptor);
                parcel.writeString(this.preferredLanguage);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Bancontact(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            public final String getStatementDescriptor() {
                return this.statementDescriptor;
            }

            public final void setStatementDescriptor(String str) {
                this.statementDescriptor = str;
            }

            public final String getPreferredLanguage() {
                return this.preferredLanguage;
            }

            public final void setPreferredLanguage(String str) {
                this.preferredLanguage = str;
            }

            public Bancontact(String str, String str2) {
                super((DefaultConstructorMarker) null);
                this.statementDescriptor = str;
                this.preferredLanguage = str2;
            }

            public List<Pair<String, String>> getParams() {
                return CollectionsKt.listOf(TuplesKt.to(PARAM_STATEMENT_DESCRIPTOR, this.statementDescriptor), TuplesKt.to(PARAM_PREFERRED_LANGUAGE, this.preferredLanguage));
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/SourceParams$TypeData$Bancontact$Companion;", "", "()V", "PARAM_PREFERRED_LANGUAGE", "", "PARAM_STATEMENT_DESCRIPTOR", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }
    }
}
