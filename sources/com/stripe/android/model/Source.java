package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ViewProps;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.parsers.SourceJsonParser;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\b\u0018\u0000 t2\u00020\u00012\u00020\u0002:\nstuvwxyz{|B\u0002\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u001d\b\u0002\u0010\u0018\u001a\u0017\u0012\u0004\u0012\u00020\u0004\u0012\u000b\u0012\t\u0018\u00010\u001a¢\u0006\u0002\b\u001b\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010)J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u001e\u0010U\u001a\u0017\u0012\u0004\u0012\u00020\u0004\u0012\u000b\u0012\t\u0018\u00010\u001a¢\u0006\u0002\b\u001b\u0018\u00010\u0019HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\t\u0010W\u001a\u00020\u0004HÆ\u0003J\t\u0010X\u001a\u00020\u0004HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010#HÂ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010%HÂ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010]\u001a\u0004\u0018\u00010'HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010e\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0002\u0010f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001d\b\u0002\u0010\u0018\u001a\u0017\u0012\u0004\u0012\u00020\u0004\u0012\u000b\u0012\t\u0018\u00010\u001a¢\u0006\u0002\b\u001b\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010gJ\t\u0010h\u001a\u00020iHÖ\u0001J\u0013\u0010j\u001a\u00020\u000f2\b\u0010k\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010l\u001a\u00020iHÖ\u0001J\t\u0010m\u001a\u00020\u0004HÖ\u0001J\u0019\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020iHÖ\u0001R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010,\u001a\u0004\b1\u0010+R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00107\u001a\u0004\b\u000e\u00106R\u0011\u00108\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR&\u0010\u0018\u001a\u0017\u0012\u0004\u0012\u00020\u0004\u0012\u000b\u0012\t\u0018\u00010\u001a¢\u0006\u0002\b\u001b\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010(\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010.R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010.R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010.R\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006}"}, d2 = {"Lcom/stripe/android/model/Source;", "Lcom/stripe/android/core/model/StripeModel;", "Lcom/stripe/android/model/StripePaymentSource;", "id", "", "amount", "", "clientSecret", "codeVerification", "Lcom/stripe/android/model/Source$CodeVerification;", "created", "currency", "flow", "Lcom/stripe/android/model/Source$Flow;", "isLiveMode", "", "owner", "Lcom/stripe/android/model/Source$Owner;", "receiver", "Lcom/stripe/android/model/Source$Receiver;", "redirect", "Lcom/stripe/android/model/Source$Redirect;", "status", "Lcom/stripe/android/model/Source$Status;", "sourceTypeData", "", "", "Lkotlinx/parcelize/RawValue;", "sourceTypeModel", "Lcom/stripe/android/model/SourceTypeModel;", "type", "typeRaw", "usage", "Lcom/stripe/android/model/Source$Usage;", "_weChat", "Lcom/stripe/android/model/WeChat;", "_klarna", "Lcom/stripe/android/model/Source$Klarna;", "sourceOrder", "Lcom/stripe/android/model/SourceOrder;", "statementDescriptor", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/stripe/android/model/Source$CodeVerification;Ljava/lang/Long;Ljava/lang/String;Lcom/stripe/android/model/Source$Flow;Ljava/lang/Boolean;Lcom/stripe/android/model/Source$Owner;Lcom/stripe/android/model/Source$Receiver;Lcom/stripe/android/model/Source$Redirect;Lcom/stripe/android/model/Source$Status;Ljava/util/Map;Lcom/stripe/android/model/SourceTypeModel;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/Source$Usage;Lcom/stripe/android/model/WeChat;Lcom/stripe/android/model/Source$Klarna;Lcom/stripe/android/model/SourceOrder;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getClientSecret", "()Ljava/lang/String;", "getCodeVerification", "()Lcom/stripe/android/model/Source$CodeVerification;", "getCreated", "getCurrency", "getFlow", "()Lcom/stripe/android/model/Source$Flow;", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "klarna", "getKlarna", "()Lcom/stripe/android/model/Source$Klarna;", "getOwner", "()Lcom/stripe/android/model/Source$Owner;", "getReceiver", "()Lcom/stripe/android/model/Source$Receiver;", "getRedirect", "()Lcom/stripe/android/model/Source$Redirect;", "getSourceOrder", "()Lcom/stripe/android/model/SourceOrder;", "getSourceTypeData", "()Ljava/util/Map;", "getSourceTypeModel", "()Lcom/stripe/android/model/SourceTypeModel;", "getStatementDescriptor", "getStatus", "()Lcom/stripe/android/model/Source$Status;", "getType", "getTypeRaw", "getUsage", "()Lcom/stripe/android/model/Source$Usage;", "weChat", "getWeChat", "()Lcom/stripe/android/model/WeChat;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/stripe/android/model/Source$CodeVerification;Ljava/lang/Long;Ljava/lang/String;Lcom/stripe/android/model/Source$Flow;Ljava/lang/Boolean;Lcom/stripe/android/model/Source$Owner;Lcom/stripe/android/model/Source$Receiver;Lcom/stripe/android/model/Source$Redirect;Lcom/stripe/android/model/Source$Status;Ljava/util/Map;Lcom/stripe/android/model/SourceTypeModel;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/Source$Usage;Lcom/stripe/android/model/WeChat;Lcom/stripe/android/model/Source$Klarna;Lcom/stripe/android/model/SourceOrder;Ljava/lang/String;)Lcom/stripe/android/model/Source;", "describeContents", "", "equals", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CodeVerification", "Companion", "Flow", "Klarna", "Owner", "Receiver", "Redirect", "SourceType", "Status", "Usage", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Source.kt */
public final class Source implements StripeModel, StripePaymentSource {
    public static final int $stable = 8;
    public static final Parcelable.Creator<Source> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EURO = "eur";
    public static final String USD = "usd";
    private final Klarna _klarna;
    private final WeChat _weChat;
    private final Long amount;
    private final String clientSecret;
    private final CodeVerification codeVerification;
    private final Long created;
    private final String currency;
    private final Flow flow;
    private final String id;
    private final Boolean isLiveMode;
    private final Owner owner;
    private final Receiver receiver;
    private final Redirect redirect;
    private final SourceOrder sourceOrder;
    private final Map<String, Object> sourceTypeData;
    private final SourceTypeModel sourceTypeModel;
    private final String statementDescriptor;
    private final Status status;
    private final String type;
    private final String typeRaw;
    private final Usage usage;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Source.kt */
    public static final class Creator implements Parcelable.Creator<Source> {
        public final Source createFromParcel(Parcel parcel) {
            Boolean bool;
            Status status;
            LinkedHashMap linkedHashMap;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString2 = parcel.readString();
            CodeVerification createFromParcel = parcel.readInt() == 0 ? null : CodeVerification.CREATOR.createFromParcel(parcel2);
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString3 = parcel.readString();
            Flow valueOf3 = parcel.readInt() == 0 ? null : Flow.valueOf(parcel.readString());
            int i = 0;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            Owner createFromParcel2 = parcel.readInt() == 0 ? null : Owner.CREATOR.createFromParcel(parcel2);
            Receiver createFromParcel3 = parcel.readInt() == 0 ? null : Receiver.CREATOR.createFromParcel(parcel2);
            Redirect createFromParcel4 = parcel.readInt() == 0 ? null : Redirect.CREATOR.createFromParcel(parcel2);
            Status valueOf4 = parcel.readInt() == 0 ? null : Status.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                status = valueOf4;
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (i != readInt) {
                    linkedHashMap.put(parcel.readString(), parcel2.readValue(Source.class.getClassLoader()));
                    i++;
                    readInt = readInt;
                    valueOf4 = valueOf4;
                }
                status = valueOf4;
            }
            return new Source(readString, valueOf, readString2, createFromParcel, valueOf2, readString3, valueOf3, bool, createFromParcel2, createFromParcel3, createFromParcel4, status, linkedHashMap, (SourceTypeModel) parcel2.readParcelable(Source.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Usage.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : WeChat.CREATOR.createFromParcel(parcel2), parcel.readInt() == 0 ? null : Klarna.CREATOR.createFromParcel(parcel2), parcel.readInt() == 0 ? null : SourceOrder.CREATOR.createFromParcel(parcel2), parcel.readString());
        }

        public final Source[] newArray(int i) {
            return new Source[i];
        }
    }

    @JvmStatic
    public static final String asSourceType(String str) {
        return Companion.asSourceType(str);
    }

    private final WeChat component18() {
        return this._weChat;
    }

    private final Klarna component19() {
        return this._klarna;
    }

    public static /* synthetic */ Source copy$default(Source source, String str, Long l, String str2, CodeVerification codeVerification2, Long l2, String str3, Flow flow2, Boolean bool, Owner owner2, Receiver receiver2, Redirect redirect2, Status status2, Map map, SourceTypeModel sourceTypeModel2, String str4, String str5, Usage usage2, WeChat weChat, Klarna klarna, SourceOrder sourceOrder2, String str6, int i, Object obj) {
        Source source2 = source;
        int i2 = i;
        return source.copy((i2 & 1) != 0 ? source.getId() : str, (i2 & 2) != 0 ? source2.amount : l, (i2 & 4) != 0 ? source2.clientSecret : str2, (i2 & 8) != 0 ? source2.codeVerification : codeVerification2, (i2 & 16) != 0 ? source2.created : l2, (i2 & 32) != 0 ? source2.currency : str3, (i2 & 64) != 0 ? source2.flow : flow2, (i2 & 128) != 0 ? source2.isLiveMode : bool, (i2 & 256) != 0 ? source2.owner : owner2, (i2 & 512) != 0 ? source2.receiver : receiver2, (i2 & 1024) != 0 ? source2.redirect : redirect2, (i2 & 2048) != 0 ? source2.status : status2, (i2 & 4096) != 0 ? source2.sourceTypeData : map, (i2 & 8192) != 0 ? source2.sourceTypeModel : sourceTypeModel2, (i2 & 16384) != 0 ? source2.type : str4, (i2 & 32768) != 0 ? source2.typeRaw : str5, (i2 & 65536) != 0 ? source2.usage : usage2, (i2 & 131072) != 0 ? source2._weChat : weChat, (i2 & 262144) != 0 ? source2._klarna : klarna, (i2 & 524288) != 0 ? source2.sourceOrder : sourceOrder2, (i2 & 1048576) != 0 ? source2.statementDescriptor : str6);
    }

    @JvmStatic
    public static final Source fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    public final String component1() {
        return getId();
    }

    public final Receiver component10() {
        return this.receiver;
    }

    public final Redirect component11() {
        return this.redirect;
    }

    public final Status component12() {
        return this.status;
    }

    public final Map<String, Object> component13() {
        return this.sourceTypeData;
    }

    public final SourceTypeModel component14() {
        return this.sourceTypeModel;
    }

    public final String component15() {
        return this.type;
    }

    public final String component16() {
        return this.typeRaw;
    }

    public final Usage component17() {
        return this.usage;
    }

    public final Long component2() {
        return this.amount;
    }

    public final SourceOrder component20() {
        return this.sourceOrder;
    }

    public final String component21() {
        return this.statementDescriptor;
    }

    public final String component3() {
        return this.clientSecret;
    }

    public final CodeVerification component4() {
        return this.codeVerification;
    }

    public final Long component5() {
        return this.created;
    }

    public final String component6() {
        return this.currency;
    }

    public final Flow component7() {
        return this.flow;
    }

    public final Boolean component8() {
        return this.isLiveMode;
    }

    public final Owner component9() {
        return this.owner;
    }

    public final Source copy(String str, Long l, String str2, CodeVerification codeVerification2, Long l2, String str3, Flow flow2, Boolean bool, Owner owner2, Receiver receiver2, Redirect redirect2, Status status2, Map<String, ? extends Object> map, SourceTypeModel sourceTypeModel2, String str4, String str5, Usage usage2, WeChat weChat, Klarna klarna, SourceOrder sourceOrder2, String str6) {
        String str7 = str;
        Intrinsics.checkNotNullParameter(str4, "type");
        Intrinsics.checkNotNullParameter(str5, "typeRaw");
        return new Source(str, l, str2, codeVerification2, l2, str3, flow2, bool, owner2, receiver2, redirect2, status2, map, sourceTypeModel2, str4, str5, usage2, weChat, klarna, sourceOrder2, str6);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Source)) {
            return false;
        }
        Source source = (Source) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) source.getId()) && Intrinsics.areEqual((Object) this.amount, (Object) source.amount) && Intrinsics.areEqual((Object) this.clientSecret, (Object) source.clientSecret) && Intrinsics.areEqual((Object) this.codeVerification, (Object) source.codeVerification) && Intrinsics.areEqual((Object) this.created, (Object) source.created) && Intrinsics.areEqual((Object) this.currency, (Object) source.currency) && this.flow == source.flow && Intrinsics.areEqual((Object) this.isLiveMode, (Object) source.isLiveMode) && Intrinsics.areEqual((Object) this.owner, (Object) source.owner) && Intrinsics.areEqual((Object) this.receiver, (Object) source.receiver) && Intrinsics.areEqual((Object) this.redirect, (Object) source.redirect) && this.status == source.status && Intrinsics.areEqual((Object) this.sourceTypeData, (Object) source.sourceTypeData) && Intrinsics.areEqual((Object) this.sourceTypeModel, (Object) source.sourceTypeModel) && Intrinsics.areEqual((Object) this.type, (Object) source.type) && Intrinsics.areEqual((Object) this.typeRaw, (Object) source.typeRaw) && this.usage == source.usage && Intrinsics.areEqual((Object) this._weChat, (Object) source._weChat) && Intrinsics.areEqual((Object) this._klarna, (Object) source._klarna) && Intrinsics.areEqual((Object) this.sourceOrder, (Object) source.sourceOrder) && Intrinsics.areEqual((Object) this.statementDescriptor, (Object) source.statementDescriptor);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (getId() == null ? 0 : getId().hashCode()) * 31;
        Long l = this.amount;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.clientSecret;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        CodeVerification codeVerification2 = this.codeVerification;
        int hashCode4 = (hashCode3 + (codeVerification2 == null ? 0 : codeVerification2.hashCode())) * 31;
        Long l2 = this.created;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.currency;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Flow flow2 = this.flow;
        int hashCode7 = (hashCode6 + (flow2 == null ? 0 : flow2.hashCode())) * 31;
        Boolean bool = this.isLiveMode;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Owner owner2 = this.owner;
        int hashCode9 = (hashCode8 + (owner2 == null ? 0 : owner2.hashCode())) * 31;
        Receiver receiver2 = this.receiver;
        int hashCode10 = (hashCode9 + (receiver2 == null ? 0 : receiver2.hashCode())) * 31;
        Redirect redirect2 = this.redirect;
        int hashCode11 = (hashCode10 + (redirect2 == null ? 0 : redirect2.hashCode())) * 31;
        Status status2 = this.status;
        int hashCode12 = (hashCode11 + (status2 == null ? 0 : status2.hashCode())) * 31;
        Map<String, Object> map = this.sourceTypeData;
        int hashCode13 = (hashCode12 + (map == null ? 0 : map.hashCode())) * 31;
        SourceTypeModel sourceTypeModel2 = this.sourceTypeModel;
        int hashCode14 = (((((hashCode13 + (sourceTypeModel2 == null ? 0 : sourceTypeModel2.hashCode())) * 31) + this.type.hashCode()) * 31) + this.typeRaw.hashCode()) * 31;
        Usage usage2 = this.usage;
        int hashCode15 = (hashCode14 + (usage2 == null ? 0 : usage2.hashCode())) * 31;
        WeChat weChat = this._weChat;
        int hashCode16 = (hashCode15 + (weChat == null ? 0 : weChat.hashCode())) * 31;
        Klarna klarna = this._klarna;
        int hashCode17 = (hashCode16 + (klarna == null ? 0 : klarna.hashCode())) * 31;
        SourceOrder sourceOrder2 = this.sourceOrder;
        int hashCode18 = (hashCode17 + (sourceOrder2 == null ? 0 : sourceOrder2.hashCode())) * 31;
        String str3 = this.statementDescriptor;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode18 + i;
    }

    public String toString() {
        return "Source(id=" + getId() + ", amount=" + this.amount + ", clientSecret=" + this.clientSecret + ", codeVerification=" + this.codeVerification + ", created=" + this.created + ", currency=" + this.currency + ", flow=" + this.flow + ", isLiveMode=" + this.isLiveMode + ", owner=" + this.owner + ", receiver=" + this.receiver + ", redirect=" + this.redirect + ", status=" + this.status + ", sourceTypeData=" + this.sourceTypeData + ", sourceTypeModel=" + this.sourceTypeModel + ", type=" + this.type + ", typeRaw=" + this.typeRaw + ", usage=" + this.usage + ", _weChat=" + this._weChat + ", _klarna=" + this._klarna + ", sourceOrder=" + this.sourceOrder + ", statementDescriptor=" + this.statementDescriptor + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        Long l = this.amount;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.clientSecret);
        CodeVerification codeVerification2 = this.codeVerification;
        if (codeVerification2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            codeVerification2.writeToParcel(parcel, i);
        }
        Long l2 = this.created;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        parcel.writeString(this.currency);
        Flow flow2 = this.flow;
        if (flow2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(flow2.name());
        }
        Boolean bool = this.isLiveMode;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Owner owner2 = this.owner;
        if (owner2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            owner2.writeToParcel(parcel, i);
        }
        Receiver receiver2 = this.receiver;
        if (receiver2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            receiver2.writeToParcel(parcel, i);
        }
        Redirect redirect2 = this.redirect;
        if (redirect2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            redirect2.writeToParcel(parcel, i);
        }
        Status status2 = this.status;
        if (status2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(status2.name());
        }
        Map<String, Object> map = this.sourceTypeData;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeValue(next.getValue());
            }
        }
        parcel.writeParcelable(this.sourceTypeModel, i);
        parcel.writeString(this.type);
        parcel.writeString(this.typeRaw);
        Usage usage2 = this.usage;
        if (usage2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(usage2.name());
        }
        WeChat weChat = this._weChat;
        if (weChat == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            weChat.writeToParcel(parcel, i);
        }
        Klarna klarna = this._klarna;
        if (klarna == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            klarna.writeToParcel(parcel, i);
        }
        SourceOrder sourceOrder2 = this.sourceOrder;
        if (sourceOrder2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sourceOrder2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.statementDescriptor);
    }

    public Source(String str, Long l, String str2, CodeVerification codeVerification2, Long l2, String str3, Flow flow2, Boolean bool, Owner owner2, Receiver receiver2, Redirect redirect2, Status status2, Map<String, ? extends Object> map, SourceTypeModel sourceTypeModel2, String str4, String str5, Usage usage2, WeChat weChat, Klarna klarna, SourceOrder sourceOrder2, String str6) {
        String str7 = str4;
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str7, "type");
        Intrinsics.checkNotNullParameter(str8, "typeRaw");
        this.id = str;
        this.amount = l;
        this.clientSecret = str2;
        this.codeVerification = codeVerification2;
        this.created = l2;
        this.currency = str3;
        this.flow = flow2;
        this.isLiveMode = bool;
        this.owner = owner2;
        this.receiver = receiver2;
        this.redirect = redirect2;
        this.status = status2;
        this.sourceTypeData = map;
        this.sourceTypeModel = sourceTypeModel2;
        this.type = str7;
        this.typeRaw = str8;
        this.usage = usage2;
        this._weChat = weChat;
        this._klarna = klarna;
        this.sourceOrder = sourceOrder2;
        this.statementDescriptor = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Source(java.lang.String r26, java.lang.Long r27, java.lang.String r28, com.stripe.android.model.Source.CodeVerification r29, java.lang.Long r30, java.lang.String r31, com.stripe.android.model.Source.Flow r32, java.lang.Boolean r33, com.stripe.android.model.Source.Owner r34, com.stripe.android.model.Source.Receiver r35, com.stripe.android.model.Source.Redirect r36, com.stripe.android.model.Source.Status r37, java.util.Map r38, com.stripe.android.model.SourceTypeModel r39, java.lang.String r40, java.lang.String r41, com.stripe.android.model.Source.Usage r42, com.stripe.android.model.WeChat r43, com.stripe.android.model.Source.Klarna r44, com.stripe.android.model.SourceOrder r45, java.lang.String r46, int r47, kotlin.jvm.internal.DefaultConstructorMarker r48) {
        /*
            r25 = this;
            r0 = r47
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r27
        L_0x000b:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0011
            r6 = r2
            goto L_0x0013
        L_0x0011:
            r6 = r28
        L_0x0013:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0019
            r7 = r2
            goto L_0x001b
        L_0x0019:
            r7 = r29
        L_0x001b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0021
            r8 = r2
            goto L_0x0023
        L_0x0021:
            r8 = r30
        L_0x0023:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0029
            r9 = r2
            goto L_0x002b
        L_0x0029:
            r9 = r31
        L_0x002b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0031
            r10 = r2
            goto L_0x0033
        L_0x0031:
            r10 = r32
        L_0x0033:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0039
            r11 = r2
            goto L_0x003b
        L_0x0039:
            r11 = r33
        L_0x003b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0041
            r12 = r2
            goto L_0x0043
        L_0x0041:
            r12 = r34
        L_0x0043:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0049
            r13 = r2
            goto L_0x004b
        L_0x0049:
            r13 = r35
        L_0x004b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0051
            r14 = r2
            goto L_0x0053
        L_0x0051:
            r14 = r36
        L_0x0053:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0059
            r15 = r2
            goto L_0x005b
        L_0x0059:
            r15 = r37
        L_0x005b:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0062
            r16 = r2
            goto L_0x0064
        L_0x0062:
            r16 = r38
        L_0x0064:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x006b
            r17 = r2
            goto L_0x006d
        L_0x006b:
            r17 = r39
        L_0x006d:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0075
            r20 = r2
            goto L_0x0077
        L_0x0075:
            r20 = r42
        L_0x0077:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x007f
            r21 = r2
            goto L_0x0081
        L_0x007f:
            r21 = r43
        L_0x0081:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0089
            r22 = r2
            goto L_0x008b
        L_0x0089:
            r22 = r44
        L_0x008b:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0093
            r23 = r2
            goto L_0x0095
        L_0x0093:
            r23 = r45
        L_0x0095:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x009d
            r24 = r2
            goto L_0x009f
        L_0x009d:
            r24 = r46
        L_0x009f:
            r3 = r25
            r4 = r26
            r18 = r40
            r19 = r41
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.Source.<init>(java.lang.String, java.lang.Long, java.lang.String, com.stripe.android.model.Source$CodeVerification, java.lang.Long, java.lang.String, com.stripe.android.model.Source$Flow, java.lang.Boolean, com.stripe.android.model.Source$Owner, com.stripe.android.model.Source$Receiver, com.stripe.android.model.Source$Redirect, com.stripe.android.model.Source$Status, java.util.Map, com.stripe.android.model.SourceTypeModel, java.lang.String, java.lang.String, com.stripe.android.model.Source$Usage, com.stripe.android.model.WeChat, com.stripe.android.model.Source$Klarna, com.stripe.android.model.SourceOrder, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public String getId() {
        return this.id;
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final CodeVerification getCodeVerification() {
        return this.codeVerification;
    }

    public final Long getCreated() {
        return this.created;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final Flow getFlow() {
        return this.flow;
    }

    public final Boolean isLiveMode() {
        return this.isLiveMode;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final Receiver getReceiver() {
        return this.receiver;
    }

    public final Redirect getRedirect() {
        return this.redirect;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Map<String, Object> getSourceTypeData() {
        return this.sourceTypeData;
    }

    public final SourceTypeModel getSourceTypeModel() {
        return this.sourceTypeModel;
    }

    public final String getType() {
        return this.type;
    }

    public final String getTypeRaw() {
        return this.typeRaw;
    }

    public final Usage getUsage() {
        return this.usage;
    }

    public final SourceOrder getSourceOrder() {
        return this.sourceOrder;
    }

    public final String getStatementDescriptor() {
        return this.statementDescriptor;
    }

    public final WeChat getWeChat() {
        if (Intrinsics.areEqual((Object) "wechat", (Object) this.type)) {
            WeChat weChat = this._weChat;
            if (weChat != null) {
                return weChat;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalStateException("Source type must be 'wechat'".toString());
    }

    public final Klarna getKlarna() {
        if (Intrinsics.areEqual((Object) "klarna", (Object) this.type)) {
            Klarna klarna = this._klarna;
            if (klarna != null) {
                return klarna;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalStateException("Source type must be 'klarna'".toString());
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/model/Source$SourceType;", "", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: Source.kt */
    public @interface SourceType {
        public static final String ALIPAY = "alipay";
        public static final String BANCONTACT = "bancontact";
        public static final String CARD = "card";
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String EPS = "eps";
        public static final String GIROPAY = "giropay";
        public static final String IDEAL = "ideal";
        public static final String KLARNA = "klarna";
        public static final String MULTIBANCO = "multibanco";
        public static final String P24 = "p24";
        public static final String SEPA_DEBIT = "sepa_debit";
        public static final String SOFORT = "sofort";
        public static final String THREE_D_SECURE = "three_d_secure";
        public static final String UNKNOWN = "unknown";
        public static final String WECHAT = "wechat";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/model/Source$SourceType$Companion;", "", "()V", "ALIPAY", "", "BANCONTACT", "CARD", "EPS", "GIROPAY", "IDEAL", "KLARNA", "MULTIBANCO", "P24", "SEPA_DEBIT", "SOFORT", "THREE_D_SECURE", "UNKNOWN", "WECHAT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String ALIPAY = "alipay";
            public static final String BANCONTACT = "bancontact";
            public static final String CARD = "card";
            public static final String EPS = "eps";
            public static final String GIROPAY = "giropay";
            public static final String IDEAL = "ideal";
            public static final String KLARNA = "klarna";
            public static final String MULTIBANCO = "multibanco";
            public static final String P24 = "p24";
            public static final String SEPA_DEBIT = "sepa_debit";
            public static final String SOFORT = "sofort";
            public static final String THREE_D_SECURE = "three_d_secure";
            public static final String UNKNOWN = "unknown";
            public static final String WECHAT = "wechat";

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/Source$Status;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "Canceled", "Chargeable", "Consumed", "Failed", "Pending", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Source.kt */
    public enum Status {
        Canceled("canceled"),
        Chargeable("chargeable"),
        Consumed("consumed"),
        Failed("failed"),
        Pending("pending");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String code;

        private Status(String str) {
            this.code = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            return this.code;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/Source$Status$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/Source$Status;", "code", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Status fromCode(String str) {
                Status[] values = Status.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Status status = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) status.code, (Object) str)) {
                        return status;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/Source$Usage;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "toString", "Reusable", "SingleUse", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Source.kt */
    public enum Usage {
        Reusable("reusable"),
        SingleUse("single_use");
        
        public static final Companion Companion = null;
        private final String code;

        private Usage(String str) {
            this.code = str;
        }

        public final String getCode$payments_core_release() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            return this.code;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/Source$Usage$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/Source$Usage;", "code", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Usage fromCode(String str) {
                Usage[] values = Usage.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Usage usage = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) usage.getCode$payments_core_release(), (Object) str)) {
                        return usage;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/stripe/android/model/Source$Flow;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "toString", "Redirect", "Receiver", "CodeVerification", "None", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Source.kt */
    public enum Flow {
        Redirect("redirect"),
        Receiver("receiver"),
        CodeVerification("code_verification"),
        None(ViewProps.NONE);
        
        public static final Companion Companion = null;
        private final String code;

        private Flow(String str) {
            this.code = str;
        }

        public final String getCode$payments_core_release() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            return this.code;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/Source$Flow$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/Source$Flow;", "code", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Flow fromCode(String str) {
                Flow[] values = Flow.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Flow flow = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) flow.getCode$payments_core_release(), (Object) str)) {
                        return flow;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/model/Source$Redirect;", "Lcom/stripe/android/core/model/StripeModel;", "returnUrl", "", "status", "Lcom/stripe/android/model/Source$Redirect$Status;", "url", "(Ljava/lang/String;Lcom/stripe/android/model/Source$Redirect$Status;Ljava/lang/String;)V", "getReturnUrl", "()Ljava/lang/String;", "getStatus", "()Lcom/stripe/android/model/Source$Redirect$Status;", "getUrl", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Status", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Source.kt */
    public static final class Redirect implements StripeModel {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Redirect> CREATOR = new Creator();
        private final String returnUrl;
        private final Status status;
        private final String url;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public static final class Creator implements Parcelable.Creator<Redirect> {
            public final Redirect createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Redirect(parcel.readString(), parcel.readInt() == 0 ? null : Status.valueOf(parcel.readString()), parcel.readString());
            }

            public final Redirect[] newArray(int i) {
                return new Redirect[i];
            }
        }

        public static /* synthetic */ Redirect copy$default(Redirect redirect, String str, Status status2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = redirect.returnUrl;
            }
            if ((i & 2) != 0) {
                status2 = redirect.status;
            }
            if ((i & 4) != 0) {
                str2 = redirect.url;
            }
            return redirect.copy(str, status2, str2);
        }

        public final String component1() {
            return this.returnUrl;
        }

        public final Status component2() {
            return this.status;
        }

        public final String component3() {
            return this.url;
        }

        public final Redirect copy(String str, Status status2, String str2) {
            return new Redirect(str, status2, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Redirect)) {
                return false;
            }
            Redirect redirect = (Redirect) obj;
            return Intrinsics.areEqual((Object) this.returnUrl, (Object) redirect.returnUrl) && this.status == redirect.status && Intrinsics.areEqual((Object) this.url, (Object) redirect.url);
        }

        public int hashCode() {
            String str = this.returnUrl;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Status status2 = this.status;
            int hashCode2 = (hashCode + (status2 == null ? 0 : status2.hashCode())) * 31;
            String str2 = this.url;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Redirect(returnUrl=" + this.returnUrl + ", status=" + this.status + ", url=" + this.url + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.returnUrl);
            Status status2 = this.status;
            if (status2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(status2.name());
            }
            parcel.writeString(this.url);
        }

        public Redirect(String str, Status status2, String str2) {
            this.returnUrl = str;
            this.status = status2;
            this.url = str2;
        }

        public final String getReturnUrl() {
            return this.returnUrl;
        }

        public final Status getStatus() {
            return this.status;
        }

        public final String getUrl() {
            return this.url;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/Source$Redirect$Status;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "Pending", "Succeeded", "NotRequired", "Failed", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public enum Status {
            Pending("pending"),
            Succeeded("succeeded"),
            NotRequired("not_required"),
            Failed("failed");
            
            public static final Companion Companion = null;
            /* access modifiers changed from: private */
            public final String code;

            private Status(String str) {
                this.code = str;
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }

            public String toString() {
                return this.code;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/Source$Redirect$Status$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/Source$Redirect$Status;", "code", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: Source.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Status fromCode(String str) {
                    Status[] values = Status.values();
                    int length = values.length;
                    int i = 0;
                    while (i < length) {
                        Status status = values[i];
                        i++;
                        if (Intrinsics.areEqual((Object) status.code, (Object) str)) {
                            return status;
                        }
                    }
                    return null;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/model/Source$CodeVerification;", "Lcom/stripe/android/core/model/StripeModel;", "attemptsRemaining", "", "status", "Lcom/stripe/android/model/Source$CodeVerification$Status;", "(ILcom/stripe/android/model/Source$CodeVerification$Status;)V", "getAttemptsRemaining", "()I", "getStatus", "()Lcom/stripe/android/model/Source$CodeVerification$Status;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Status", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Source.kt */
    public static final class CodeVerification implements StripeModel {
        public static final int $stable = 8;
        public static final Parcelable.Creator<CodeVerification> CREATOR = new Creator();
        private final int attemptsRemaining;
        private final Status status;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public static final class Creator implements Parcelable.Creator<CodeVerification> {
            public final CodeVerification createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CodeVerification(parcel.readInt(), parcel.readInt() == 0 ? null : Status.valueOf(parcel.readString()));
            }

            public final CodeVerification[] newArray(int i) {
                return new CodeVerification[i];
            }
        }

        public static /* synthetic */ CodeVerification copy$default(CodeVerification codeVerification, int i, Status status2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = codeVerification.attemptsRemaining;
            }
            if ((i2 & 2) != 0) {
                status2 = codeVerification.status;
            }
            return codeVerification.copy(i, status2);
        }

        public final int component1() {
            return this.attemptsRemaining;
        }

        public final Status component2() {
            return this.status;
        }

        public final CodeVerification copy(int i, Status status2) {
            return new CodeVerification(i, status2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CodeVerification)) {
                return false;
            }
            CodeVerification codeVerification = (CodeVerification) obj;
            return this.attemptsRemaining == codeVerification.attemptsRemaining && this.status == codeVerification.status;
        }

        public int hashCode() {
            int i = this.attemptsRemaining * 31;
            Status status2 = this.status;
            return i + (status2 == null ? 0 : status2.hashCode());
        }

        public String toString() {
            return "CodeVerification(attemptsRemaining=" + this.attemptsRemaining + ", status=" + this.status + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.attemptsRemaining);
            Status status2 = this.status;
            if (status2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(status2.name());
        }

        public CodeVerification(int i, Status status2) {
            this.attemptsRemaining = i;
            this.status = status2;
        }

        public final int getAttemptsRemaining() {
            return this.attemptsRemaining;
        }

        public final Status getStatus() {
            return this.status;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/Source$CodeVerification$Status;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "Pending", "Succeeded", "Failed", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public enum Status {
            Pending("pending"),
            Succeeded("succeeded"),
            Failed("failed");
            
            public static final Companion Companion = null;
            /* access modifiers changed from: private */
            public final String code;

            private Status(String str) {
                this.code = str;
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }

            public String toString() {
                return this.code;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/Source$CodeVerification$Status$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/Source$CodeVerification$Status;", "code", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: Source.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Status fromCode(String str) {
                    Status[] values = Status.values();
                    int length = values.length;
                    int i = 0;
                    while (i < length) {
                        Status status = values[i];
                        i++;
                        if (Intrinsics.areEqual((Object) status.code, (Object) str)) {
                            return status;
                        }
                    }
                    return null;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006!"}, d2 = {"Lcom/stripe/android/model/Source$Receiver;", "Lcom/stripe/android/core/model/StripeModel;", "address", "", "amountCharged", "", "amountReceived", "amountReturned", "(Ljava/lang/String;JJJ)V", "getAddress", "()Ljava/lang/String;", "getAmountCharged", "()J", "getAmountReceived", "getAmountReturned", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Source.kt */
    public static final class Receiver implements StripeModel {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Receiver> CREATOR = new Creator();
        private final String address;
        private final long amountCharged;
        private final long amountReceived;
        private final long amountReturned;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public static final class Creator implements Parcelable.Creator<Receiver> {
            public final Receiver createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Receiver(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong());
            }

            public final Receiver[] newArray(int i) {
                return new Receiver[i];
            }
        }

        public static /* synthetic */ Receiver copy$default(Receiver receiver, String str, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = receiver.address;
            }
            if ((i & 2) != 0) {
                j = receiver.amountCharged;
            }
            long j4 = j;
            if ((i & 4) != 0) {
                j2 = receiver.amountReceived;
            }
            long j5 = j2;
            if ((i & 8) != 0) {
                j3 = receiver.amountReturned;
            }
            return receiver.copy(str, j4, j5, j3);
        }

        public final String component1() {
            return this.address;
        }

        public final long component2() {
            return this.amountCharged;
        }

        public final long component3() {
            return this.amountReceived;
        }

        public final long component4() {
            return this.amountReturned;
        }

        public final Receiver copy(String str, long j, long j2, long j3) {
            return new Receiver(str, j, j2, j3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Receiver)) {
                return false;
            }
            Receiver receiver = (Receiver) obj;
            return Intrinsics.areEqual((Object) this.address, (Object) receiver.address) && this.amountCharged == receiver.amountCharged && this.amountReceived == receiver.amountReceived && this.amountReturned == receiver.amountReturned;
        }

        public int hashCode() {
            String str = this.address;
            return ((((((str == null ? 0 : str.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.amountCharged)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.amountReceived)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.amountReturned);
        }

        public String toString() {
            return "Receiver(address=" + this.address + ", amountCharged=" + this.amountCharged + ", amountReceived=" + this.amountReceived + ", amountReturned=" + this.amountReturned + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.address);
            parcel.writeLong(this.amountCharged);
            parcel.writeLong(this.amountReceived);
            parcel.writeLong(this.amountReturned);
        }

        public Receiver(String str, long j, long j2, long j3) {
            this.address = str;
            this.amountCharged = j;
            this.amountReceived = j2;
            this.amountReturned = j3;
        }

        public final String getAddress() {
            return this.address;
        }

        public final long getAmountCharged() {
            return this.amountCharged;
        }

        public final long getAmountReceived() {
            return this.amountReceived;
        }

        public final long getAmountReturned() {
            return this.amountReturned;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BW\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003Ji\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006-"}, d2 = {"Lcom/stripe/android/model/Source$Owner;", "Lcom/stripe/android/core/model/StripeModel;", "address", "Lcom/stripe/android/model/Address;", "email", "", "name", "phone", "verifiedAddress", "verifiedEmail", "verifiedName", "verifiedPhone", "(Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Lcom/stripe/android/model/Address;", "getEmail", "()Ljava/lang/String;", "getName", "getPhone", "getVerifiedAddress", "getVerifiedEmail", "getVerifiedName", "getVerifiedPhone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Source.kt */
    public static final class Owner implements StripeModel {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Owner> CREATOR = new Creator();
        private final Address address;
        private final String email;
        private final String name;
        private final String phone;
        private final Address verifiedAddress;
        private final String verifiedEmail;
        private final String verifiedName;
        private final String verifiedPhone;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public static final class Creator implements Parcelable.Creator<Owner> {
            public final Owner createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Address address = null;
                Address createFromParcel = parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                if (parcel.readInt() != 0) {
                    address = Address.CREATOR.createFromParcel(parcel);
                }
                return new Owner(createFromParcel, readString, readString2, readString3, address, parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final Owner[] newArray(int i) {
                return new Owner[i];
            }
        }

        public static /* synthetic */ Owner copy$default(Owner owner, Address address2, String str, String str2, String str3, Address address3, String str4, String str5, String str6, int i, Object obj) {
            Owner owner2 = owner;
            int i2 = i;
            return owner.copy((i2 & 1) != 0 ? owner2.address : address2, (i2 & 2) != 0 ? owner2.email : str, (i2 & 4) != 0 ? owner2.name : str2, (i2 & 8) != 0 ? owner2.phone : str3, (i2 & 16) != 0 ? owner2.verifiedAddress : address3, (i2 & 32) != 0 ? owner2.verifiedEmail : str4, (i2 & 64) != 0 ? owner2.verifiedName : str5, (i2 & 128) != 0 ? owner2.verifiedPhone : str6);
        }

        public final Address component1() {
            return this.address;
        }

        public final String component2() {
            return this.email;
        }

        public final String component3() {
            return this.name;
        }

        public final String component4() {
            return this.phone;
        }

        public final Address component5() {
            return this.verifiedAddress;
        }

        public final String component6() {
            return this.verifiedEmail;
        }

        public final String component7() {
            return this.verifiedName;
        }

        public final String component8() {
            return this.verifiedPhone;
        }

        public final Owner copy(Address address2, String str, String str2, String str3, Address address3, String str4, String str5, String str6) {
            return new Owner(address2, str, str2, str3, address3, str4, str5, str6);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Owner)) {
                return false;
            }
            Owner owner = (Owner) obj;
            return Intrinsics.areEqual((Object) this.address, (Object) owner.address) && Intrinsics.areEqual((Object) this.email, (Object) owner.email) && Intrinsics.areEqual((Object) this.name, (Object) owner.name) && Intrinsics.areEqual((Object) this.phone, (Object) owner.phone) && Intrinsics.areEqual((Object) this.verifiedAddress, (Object) owner.verifiedAddress) && Intrinsics.areEqual((Object) this.verifiedEmail, (Object) owner.verifiedEmail) && Intrinsics.areEqual((Object) this.verifiedName, (Object) owner.verifiedName) && Intrinsics.areEqual((Object) this.verifiedPhone, (Object) owner.verifiedPhone);
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
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Address address3 = this.verifiedAddress;
            int hashCode5 = (hashCode4 + (address3 == null ? 0 : address3.hashCode())) * 31;
            String str4 = this.verifiedEmail;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.verifiedName;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.verifiedPhone;
            if (str6 != null) {
                i = str6.hashCode();
            }
            return hashCode7 + i;
        }

        public String toString() {
            return "Owner(address=" + this.address + ", email=" + this.email + ", name=" + this.name + ", phone=" + this.phone + ", verifiedAddress=" + this.verifiedAddress + ", verifiedEmail=" + this.verifiedEmail + ", verifiedName=" + this.verifiedName + ", verifiedPhone=" + this.verifiedPhone + ')';
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
            Address address3 = this.verifiedAddress;
            if (address3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                address3.writeToParcel(parcel, i);
            }
            parcel.writeString(this.verifiedEmail);
            parcel.writeString(this.verifiedName);
            parcel.writeString(this.verifiedPhone);
        }

        public Owner(Address address2, String str, String str2, String str3, Address address3, String str4, String str5, String str6) {
            this.address = address2;
            this.email = str;
            this.name = str2;
            this.phone = str3;
            this.verifiedAddress = address3;
            this.verifiedEmail = str4;
            this.verifiedName = str5;
            this.verifiedPhone = str6;
        }

        public final Address getAddress() {
            return this.address;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPhone() {
            return this.phone;
        }

        public final Address getVerifiedAddress() {
            return this.verifiedAddress;
        }

        public final String getVerifiedEmail() {
            return this.verifiedEmail;
        }

        public final String getVerifiedName() {
            return this.verifiedName;
        }

        public final String getVerifiedPhone() {
            return this.verifiedPhone;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\"\n\u0002\b*\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jé\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0001J\t\u0010>\u001a\u00020?HÖ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020?HÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\u0019\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020?HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006K"}, d2 = {"Lcom/stripe/android/model/Source$Klarna;", "Lcom/stripe/android/core/model/StripeModel;", "firstName", "", "lastName", "purchaseCountry", "clientToken", "payNowAssetUrlsDescriptive", "payNowAssetUrlsStandard", "payNowName", "payNowRedirectUrl", "payLaterAssetUrlsDescriptive", "payLaterAssetUrlsStandard", "payLaterName", "payLaterRedirectUrl", "payOverTimeAssetUrlsDescriptive", "payOverTimeAssetUrlsStandard", "payOverTimeName", "payOverTimeRedirectUrl", "paymentMethodCategories", "", "customPaymentMethods", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;)V", "getClientToken", "()Ljava/lang/String;", "getCustomPaymentMethods", "()Ljava/util/Set;", "getFirstName", "getLastName", "getPayLaterAssetUrlsDescriptive", "getPayLaterAssetUrlsStandard", "getPayLaterName", "getPayLaterRedirectUrl", "getPayNowAssetUrlsDescriptive", "getPayNowAssetUrlsStandard", "getPayNowName", "getPayNowRedirectUrl", "getPayOverTimeAssetUrlsDescriptive", "getPayOverTimeAssetUrlsStandard", "getPayOverTimeName", "getPayOverTimeRedirectUrl", "getPaymentMethodCategories", "getPurchaseCountry", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Source.kt */
    public static final class Klarna implements StripeModel {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Klarna> CREATOR = new Creator();
        private final String clientToken;
        private final Set<String> customPaymentMethods;
        private final String firstName;
        private final String lastName;
        private final String payLaterAssetUrlsDescriptive;
        private final String payLaterAssetUrlsStandard;
        private final String payLaterName;
        private final String payLaterRedirectUrl;
        private final String payNowAssetUrlsDescriptive;
        private final String payNowAssetUrlsStandard;
        private final String payNowName;
        private final String payNowRedirectUrl;
        private final String payOverTimeAssetUrlsDescriptive;
        private final String payOverTimeAssetUrlsStandard;
        private final String payOverTimeName;
        private final String payOverTimeRedirectUrl;
        private final Set<String> paymentMethodCategories;
        private final String purchaseCountry;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Source.kt */
        public static final class Creator implements Parcelable.Creator<Klarna> {
            public final Klarna createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                String readString13 = parcel.readString();
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                int readInt = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                String str = readString14;
                int i = 0;
                while (i != readInt) {
                    linkedHashSet.add(parcel.readString());
                    i++;
                    readInt = readInt;
                }
                int readInt2 = parcel.readInt();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(readInt2);
                Set set = linkedHashSet;
                int i2 = 0;
                while (i2 != readInt2) {
                    linkedHashSet2.add(parcel.readString());
                    i2++;
                    readInt2 = readInt2;
                }
                return new Klarna(readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, str, readString15, readString16, set, linkedHashSet2);
            }

            public final Klarna[] newArray(int i) {
                return new Klarna[i];
            }
        }

        public static /* synthetic */ Klarna copy$default(Klarna klarna, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Set set, Set set2, int i, Object obj) {
            Klarna klarna2 = klarna;
            int i2 = i;
            return klarna.copy((i2 & 1) != 0 ? klarna2.firstName : str, (i2 & 2) != 0 ? klarna2.lastName : str2, (i2 & 4) != 0 ? klarna2.purchaseCountry : str3, (i2 & 8) != 0 ? klarna2.clientToken : str4, (i2 & 16) != 0 ? klarna2.payNowAssetUrlsDescriptive : str5, (i2 & 32) != 0 ? klarna2.payNowAssetUrlsStandard : str6, (i2 & 64) != 0 ? klarna2.payNowName : str7, (i2 & 128) != 0 ? klarna2.payNowRedirectUrl : str8, (i2 & 256) != 0 ? klarna2.payLaterAssetUrlsDescriptive : str9, (i2 & 512) != 0 ? klarna2.payLaterAssetUrlsStandard : str10, (i2 & 1024) != 0 ? klarna2.payLaterName : str11, (i2 & 2048) != 0 ? klarna2.payLaterRedirectUrl : str12, (i2 & 4096) != 0 ? klarna2.payOverTimeAssetUrlsDescriptive : str13, (i2 & 8192) != 0 ? klarna2.payOverTimeAssetUrlsStandard : str14, (i2 & 16384) != 0 ? klarna2.payOverTimeName : str15, (i2 & 32768) != 0 ? klarna2.payOverTimeRedirectUrl : str16, (i2 & 65536) != 0 ? klarna2.paymentMethodCategories : set, (i2 & 131072) != 0 ? klarna2.customPaymentMethods : set2);
        }

        public final String component1() {
            return this.firstName;
        }

        public final String component10() {
            return this.payLaterAssetUrlsStandard;
        }

        public final String component11() {
            return this.payLaterName;
        }

        public final String component12() {
            return this.payLaterRedirectUrl;
        }

        public final String component13() {
            return this.payOverTimeAssetUrlsDescriptive;
        }

        public final String component14() {
            return this.payOverTimeAssetUrlsStandard;
        }

        public final String component15() {
            return this.payOverTimeName;
        }

        public final String component16() {
            return this.payOverTimeRedirectUrl;
        }

        public final Set<String> component17() {
            return this.paymentMethodCategories;
        }

        public final Set<String> component18() {
            return this.customPaymentMethods;
        }

        public final String component2() {
            return this.lastName;
        }

        public final String component3() {
            return this.purchaseCountry;
        }

        public final String component4() {
            return this.clientToken;
        }

        public final String component5() {
            return this.payNowAssetUrlsDescriptive;
        }

        public final String component6() {
            return this.payNowAssetUrlsStandard;
        }

        public final String component7() {
            return this.payNowName;
        }

        public final String component8() {
            return this.payNowRedirectUrl;
        }

        public final String component9() {
            return this.payLaterAssetUrlsDescriptive;
        }

        public final Klarna copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Set<String> set, Set<String> set2) {
            String str17 = str;
            Intrinsics.checkNotNullParameter(set, "paymentMethodCategories");
            Intrinsics.checkNotNullParameter(set2, "customPaymentMethods");
            return new Klarna(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, set, set2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Klarna)) {
                return false;
            }
            Klarna klarna = (Klarna) obj;
            return Intrinsics.areEqual((Object) this.firstName, (Object) klarna.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) klarna.lastName) && Intrinsics.areEqual((Object) this.purchaseCountry, (Object) klarna.purchaseCountry) && Intrinsics.areEqual((Object) this.clientToken, (Object) klarna.clientToken) && Intrinsics.areEqual((Object) this.payNowAssetUrlsDescriptive, (Object) klarna.payNowAssetUrlsDescriptive) && Intrinsics.areEqual((Object) this.payNowAssetUrlsStandard, (Object) klarna.payNowAssetUrlsStandard) && Intrinsics.areEqual((Object) this.payNowName, (Object) klarna.payNowName) && Intrinsics.areEqual((Object) this.payNowRedirectUrl, (Object) klarna.payNowRedirectUrl) && Intrinsics.areEqual((Object) this.payLaterAssetUrlsDescriptive, (Object) klarna.payLaterAssetUrlsDescriptive) && Intrinsics.areEqual((Object) this.payLaterAssetUrlsStandard, (Object) klarna.payLaterAssetUrlsStandard) && Intrinsics.areEqual((Object) this.payLaterName, (Object) klarna.payLaterName) && Intrinsics.areEqual((Object) this.payLaterRedirectUrl, (Object) klarna.payLaterRedirectUrl) && Intrinsics.areEqual((Object) this.payOverTimeAssetUrlsDescriptive, (Object) klarna.payOverTimeAssetUrlsDescriptive) && Intrinsics.areEqual((Object) this.payOverTimeAssetUrlsStandard, (Object) klarna.payOverTimeAssetUrlsStandard) && Intrinsics.areEqual((Object) this.payOverTimeName, (Object) klarna.payOverTimeName) && Intrinsics.areEqual((Object) this.payOverTimeRedirectUrl, (Object) klarna.payOverTimeRedirectUrl) && Intrinsics.areEqual((Object) this.paymentMethodCategories, (Object) klarna.paymentMethodCategories) && Intrinsics.areEqual((Object) this.customPaymentMethods, (Object) klarna.customPaymentMethods);
        }

        public int hashCode() {
            String str = this.firstName;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.lastName;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.purchaseCountry;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.clientToken;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.payNowAssetUrlsDescriptive;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.payNowAssetUrlsStandard;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.payNowName;
            int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.payNowRedirectUrl;
            int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.payLaterAssetUrlsDescriptive;
            int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.payLaterAssetUrlsStandard;
            int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.payLaterName;
            int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.payLaterRedirectUrl;
            int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
            String str13 = this.payOverTimeAssetUrlsDescriptive;
            int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
            String str14 = this.payOverTimeAssetUrlsStandard;
            int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
            String str15 = this.payOverTimeName;
            int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
            String str16 = this.payOverTimeRedirectUrl;
            if (str16 != null) {
                i = str16.hashCode();
            }
            return ((((hashCode15 + i) * 31) + this.paymentMethodCategories.hashCode()) * 31) + this.customPaymentMethods.hashCode();
        }

        public String toString() {
            return "Klarna(firstName=" + this.firstName + ", lastName=" + this.lastName + ", purchaseCountry=" + this.purchaseCountry + ", clientToken=" + this.clientToken + ", payNowAssetUrlsDescriptive=" + this.payNowAssetUrlsDescriptive + ", payNowAssetUrlsStandard=" + this.payNowAssetUrlsStandard + ", payNowName=" + this.payNowName + ", payNowRedirectUrl=" + this.payNowRedirectUrl + ", payLaterAssetUrlsDescriptive=" + this.payLaterAssetUrlsDescriptive + ", payLaterAssetUrlsStandard=" + this.payLaterAssetUrlsStandard + ", payLaterName=" + this.payLaterName + ", payLaterRedirectUrl=" + this.payLaterRedirectUrl + ", payOverTimeAssetUrlsDescriptive=" + this.payOverTimeAssetUrlsDescriptive + ", payOverTimeAssetUrlsStandard=" + this.payOverTimeAssetUrlsStandard + ", payOverTimeName=" + this.payOverTimeName + ", payOverTimeRedirectUrl=" + this.payOverTimeRedirectUrl + ", paymentMethodCategories=" + this.paymentMethodCategories + ", customPaymentMethods=" + this.customPaymentMethods + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.firstName);
            parcel.writeString(this.lastName);
            parcel.writeString(this.purchaseCountry);
            parcel.writeString(this.clientToken);
            parcel.writeString(this.payNowAssetUrlsDescriptive);
            parcel.writeString(this.payNowAssetUrlsStandard);
            parcel.writeString(this.payNowName);
            parcel.writeString(this.payNowRedirectUrl);
            parcel.writeString(this.payLaterAssetUrlsDescriptive);
            parcel.writeString(this.payLaterAssetUrlsStandard);
            parcel.writeString(this.payLaterName);
            parcel.writeString(this.payLaterRedirectUrl);
            parcel.writeString(this.payOverTimeAssetUrlsDescriptive);
            parcel.writeString(this.payOverTimeAssetUrlsStandard);
            parcel.writeString(this.payOverTimeName);
            parcel.writeString(this.payOverTimeRedirectUrl);
            Set<String> set = this.paymentMethodCategories;
            parcel.writeInt(set.size());
            for (String writeString : set) {
                parcel.writeString(writeString);
            }
            Set<String> set2 = this.customPaymentMethods;
            parcel.writeInt(set2.size());
            for (String writeString2 : set2) {
                parcel.writeString(writeString2);
            }
        }

        public Klarna(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Set<String> set, Set<String> set2) {
            Set<String> set3 = set;
            Set<String> set4 = set2;
            Intrinsics.checkNotNullParameter(set3, "paymentMethodCategories");
            Intrinsics.checkNotNullParameter(set4, "customPaymentMethods");
            this.firstName = str;
            this.lastName = str2;
            this.purchaseCountry = str3;
            this.clientToken = str4;
            this.payNowAssetUrlsDescriptive = str5;
            this.payNowAssetUrlsStandard = str6;
            this.payNowName = str7;
            this.payNowRedirectUrl = str8;
            this.payLaterAssetUrlsDescriptive = str9;
            this.payLaterAssetUrlsStandard = str10;
            this.payLaterName = str11;
            this.payLaterRedirectUrl = str12;
            this.payOverTimeAssetUrlsDescriptive = str13;
            this.payOverTimeAssetUrlsStandard = str14;
            this.payOverTimeName = str15;
            this.payOverTimeRedirectUrl = str16;
            this.paymentMethodCategories = set3;
            this.customPaymentMethods = set4;
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public final String getPurchaseCountry() {
            return this.purchaseCountry;
        }

        public final String getClientToken() {
            return this.clientToken;
        }

        public final String getPayNowAssetUrlsDescriptive() {
            return this.payNowAssetUrlsDescriptive;
        }

        public final String getPayNowAssetUrlsStandard() {
            return this.payNowAssetUrlsStandard;
        }

        public final String getPayNowName() {
            return this.payNowName;
        }

        public final String getPayNowRedirectUrl() {
            return this.payNowRedirectUrl;
        }

        public final String getPayLaterAssetUrlsDescriptive() {
            return this.payLaterAssetUrlsDescriptive;
        }

        public final String getPayLaterAssetUrlsStandard() {
            return this.payLaterAssetUrlsStandard;
        }

        public final String getPayLaterName() {
            return this.payLaterName;
        }

        public final String getPayLaterRedirectUrl() {
            return this.payLaterRedirectUrl;
        }

        public final String getPayOverTimeAssetUrlsDescriptive() {
            return this.payOverTimeAssetUrlsDescriptive;
        }

        public final String getPayOverTimeAssetUrlsStandard() {
            return this.payOverTimeAssetUrlsStandard;
        }

        public final String getPayOverTimeName() {
            return this.payOverTimeName;
        }

        public final String getPayOverTimeRedirectUrl() {
            return this.payOverTimeRedirectUrl;
        }

        public final Set<String> getPaymentMethodCategories() {
            return this.paymentMethodCategories;
        }

        public final Set<String> getCustomPaymentMethods() {
            return this.customPaymentMethods;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/Source$Companion;", "", "()V", "EURO", "", "USD", "asSourceType", "sourceType", "fromJson", "Lcom/stripe/android/model/Source;", "jsonObject", "Lorg/json/JSONObject;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Source.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Source fromJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new SourceJsonParser().parse(jSONObject);
        }

        @JvmStatic
        public final String asSourceType(String str) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1920743119:
                        if (str.equals("bancontact")) {
                            return "bancontact";
                        }
                        break;
                    case -1414960566:
                        if (str.equals("alipay")) {
                            return "alipay";
                        }
                        break;
                    case -896955097:
                        if (str.equals("sofort")) {
                            return "sofort";
                        }
                        break;
                    case -825238221:
                        if (str.equals("three_d_secure")) {
                            return "three_d_secure";
                        }
                        break;
                    case -791770330:
                        if (str.equals("wechat")) {
                            return "wechat";
                        }
                        break;
                    case -284840886:
                        boolean equals = str.equals("unknown");
                        break;
                    case 100648:
                        if (str.equals("eps")) {
                            return "eps";
                        }
                        break;
                    case 109234:
                        if (str.equals("p24")) {
                            return "p24";
                        }
                        break;
                    case 3046160:
                        if (str.equals("card")) {
                            return "card";
                        }
                        break;
                    case 38358441:
                        if (str.equals("giropay")) {
                            return "giropay";
                        }
                        break;
                    case 100048981:
                        if (str.equals("ideal")) {
                            return "ideal";
                        }
                        break;
                    case 1251821346:
                        if (str.equals("multibanco")) {
                            return "multibanco";
                        }
                        break;
                    case 1636477296:
                        if (str.equals("sepa_debit")) {
                            return "sepa_debit";
                        }
                        break;
                }
            }
            return "unknown";
        }
    }
}
