package com.stripe.android.stripe3ds2.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.stripe.android.stripe3ds2.transaction.SdkTransactionId;
import com.stripe.android.stripe3ds2.transaction.TransactionStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 v2\u00020\u0001:\u0003uvwBÍ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010&J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Y\u001a\u00020 HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010b\u001a\u00020\nHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÙ\u0002\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\n2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010g\u001a\u00020hHÖ\u0001J\u0013\u0010i\u001a\u00020\n2\b\u0010j\u001a\u0004\u0018\u00010kHÖ\u0003J\t\u0010l\u001a\u00020hHÖ\u0001J\u0006\u0010m\u001a\u00020nJ\t\u0010o\u001a\u00020\u0003HÖ\u0001J\u0019\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020hHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u00103R\u0014\u00104\u001a\u00020\n8AX\u0004¢\u0006\u0006\u001a\u0004\b5\u00103R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010(R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010(R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b=\u00107R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010(R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bB\u00103R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010(R\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010(R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010(R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010(R\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010(¨\u0006x"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData;", "Landroid/os/Parcelable;", "serverTransId", "", "acsTransId", "acsHtml", "acsHtmlRefresh", "uiType", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "isChallengeCompleted", "", "challengeInfoHeader", "challengeInfoLabel", "challengeInfoText", "challengeAdditionalInfoText", "shouldShowChallengeInfoTextIndicator", "challengeSelectOptions", "", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$ChallengeSelectOption;", "expandInfoLabel", "expandInfoText", "issuerImage", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$Image;", "messageExtensions", "Lcom/stripe/android/stripe3ds2/transactions/MessageExtension;", "messageVersion", "oobAppUrl", "oobAppLabel", "oobContinueLabel", "paymentSystemImage", "resendInformationLabel", "sdkTransId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "submitAuthenticationLabel", "whitelistingInfoText", "whyInfoLabel", "whyInfoText", "transStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/UiType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$Image;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$Image;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAcsHtml", "()Ljava/lang/String;", "getAcsHtmlRefresh", "getAcsTransId", "getChallengeAdditionalInfoText", "getChallengeInfoHeader", "getChallengeInfoLabel", "getChallengeInfoText", "getChallengeSelectOptions", "()Ljava/util/List;", "getExpandInfoLabel", "getExpandInfoText", "()Z", "isValidForUi", "isValidForUi$3ds2sdk_release", "getIssuerImage", "()Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$Image;", "getMessageExtensions", "getMessageVersion", "getOobAppLabel", "getOobAppUrl", "getOobContinueLabel", "getPaymentSystemImage", "getResendInformationLabel", "getSdkTransId", "()Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "getServerTransId", "getShouldShowChallengeInfoTextIndicator", "getSubmitAuthenticationLabel", "getTransStatus", "getUiType", "()Lcom/stripe/android/stripe3ds2/transactions/UiType;", "getWhitelistingInfoText", "getWhyInfoLabel", "getWhyInfoText", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ChallengeSelectOption", "Companion", "Image", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeResponseData.kt */
public final class ChallengeResponseData implements Parcelable {
    public static final Parcelable.Creator<ChallengeResponseData> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIELD_ACS_COUNTER_ACS_TO_SDK = "acsCounterAtoS";
    private static final String FIELD_ACS_HTML = "acsHTML";
    private static final String FIELD_ACS_HTML_REFRESH = "acsHTMLRefresh";
    private static final String FIELD_ACS_TRANS_ID = "acsTransID";
    private static final String FIELD_ACS_UI_TYPE = "acsUiType";
    private static final String FIELD_CHALLENGE_ADDITIONAL_INFO_TEXT = "challengeAddInfo";
    private static final String FIELD_CHALLENGE_COMPLETION_INDICATOR = "challengeCompletionInd";
    private static final String FIELD_CHALLENGE_INFO_HEADER = "challengeInfoHeader";
    private static final String FIELD_CHALLENGE_INFO_LABEL = "challengeInfoLabel";
    private static final String FIELD_CHALLENGE_INFO_TEXT = "challengeInfoText";
    private static final String FIELD_CHALLENGE_INFO_TEXT_INDICATOR = "challengeInfoTextIndicator";
    private static final String FIELD_CHALLENGE_SELECT_INFO = "challengeSelectInfo";
    private static final String FIELD_EXPAND_INFO_LABEL = "expandInfoLabel";
    private static final String FIELD_EXPAND_INFO_TEXT = "expandInfoText";
    private static final String FIELD_ISSUER_IMAGE = "issuerImage";
    private static final String FIELD_MESSAGE_EXTENSION = "messageExtension";
    private static final String FIELD_MESSAGE_TYPE = "messageType";
    private static final String FIELD_MESSAGE_VERSION = "messageVersion";
    private static final String FIELD_OOB_APP_LABEL = "oobAppLabel";
    private static final String FIELD_OOB_APP_URL = "oobAppURL";
    private static final String FIELD_OOB_CONTINUE_LABEL = "oobContinueLabel";
    private static final String FIELD_PAYMENT_SYSTEM_IMAGE = "psImage";
    private static final String FIELD_RESEND_INFORMATION_LABEL = "resendInformationLabel";
    private static final String FIELD_SDK_TRANS_ID = "sdkTransID";
    private static final String FIELD_SERVER_TRANS_ID = "threeDSServerTransID";
    private static final String FIELD_SUBMIT_AUTHENTICATION_LABEL = "submitAuthenticationLabel";
    private static final String FIELD_TRANS_STATUS = "transStatus";
    private static final String FIELD_WHITELISTING_INFO_TEXT = "whitelistingInfoText";
    private static final String FIELD_WHY_INFO_LABEL = "whyInfoLabel";
    private static final String FIELD_WHY_INFO_TEXT = "whyInfoText";
    /* access modifiers changed from: private */
    public static final Set<String> FINAL_CRES_FIELDS = SetsKt.setOf("threeDSServerTransID", "acsCounterAtoS", "acsTransID", FIELD_CHALLENGE_COMPLETION_INDICATOR, FIELD_MESSAGE_EXTENSION, "messageType", "messageVersion", "sdkTransID", FIELD_TRANS_STATUS);
    public static final String MESSAGE_TYPE = "CRes";
    private static final String NO_VALUE = "N";
    /* access modifiers changed from: private */
    public static final List<String> YES_NO_VALUES = CollectionsKt.listOf(YES_VALUE, "N");
    private static final String YES_VALUE = "Y";
    private final String acsHtml;
    private final String acsHtmlRefresh;
    private final String acsTransId;
    private final String challengeAdditionalInfoText;
    private final String challengeInfoHeader;
    private final String challengeInfoLabel;
    private final String challengeInfoText;
    private final List<ChallengeSelectOption> challengeSelectOptions;
    private final String expandInfoLabel;
    private final String expandInfoText;
    private final boolean isChallengeCompleted;
    private final Image issuerImage;
    private final List<MessageExtension> messageExtensions;
    private final String messageVersion;
    private final String oobAppLabel;
    private final String oobAppUrl;
    private final String oobContinueLabel;
    private final Image paymentSystemImage;
    private final String resendInformationLabel;
    private final SdkTransactionId sdkTransId;
    private final String serverTransId;
    private final boolean shouldShowChallengeInfoTextIndicator;
    private final String submitAuthenticationLabel;
    private final String transStatus;
    private final UiType uiType;
    private final String whitelistingInfoText;
    private final String whyInfoLabel;
    private final String whyInfoText;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResponseData.kt */
    public static final class Creator implements Parcelable.Creator<ChallengeResponseData> {
        public final ChallengeResponseData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            UiType valueOf = parcel.readInt() == 0 ? null : UiType.valueOf(parcel.readString());
            boolean z = parcel.readInt() != 0;
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(ChallengeSelectOption.CREATOR.createFromParcel(parcel2));
                }
            }
            List list = arrayList;
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            Image createFromParcel = parcel.readInt() == 0 ? null : Image.CREATOR.createFromParcel(parcel2);
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                int i2 = 0;
                while (i2 != readInt2) {
                    arrayList2.add(MessageExtension.CREATOR.createFromParcel(parcel2));
                    i2++;
                    readInt2 = readInt2;
                }
            }
            return new ChallengeResponseData(readString, readString2, readString3, readString4, valueOf, z, readString5, readString6, readString7, readString8, z2, list, readString9, readString10, createFromParcel, arrayList2, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Image.CREATOR.createFromParcel(parcel2), parcel.readString(), SdkTransactionId.CREATOR.createFromParcel(parcel2), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final ChallengeResponseData[] newArray(int i) {
            return new ChallengeResponseData[i];
        }
    }

    public static /* synthetic */ ChallengeResponseData copy$default(ChallengeResponseData challengeResponseData, String str, String str2, String str3, String str4, UiType uiType2, boolean z, String str5, String str6, String str7, String str8, boolean z2, List list, String str9, String str10, Image image, List list2, String str11, String str12, String str13, String str14, Image image2, String str15, SdkTransactionId sdkTransactionId, String str16, String str17, String str18, String str19, String str20, int i, Object obj) {
        ChallengeResponseData challengeResponseData2 = challengeResponseData;
        int i2 = i;
        return challengeResponseData.copy((i2 & 1) != 0 ? challengeResponseData2.serverTransId : str, (i2 & 2) != 0 ? challengeResponseData2.acsTransId : str2, (i2 & 4) != 0 ? challengeResponseData2.acsHtml : str3, (i2 & 8) != 0 ? challengeResponseData2.acsHtmlRefresh : str4, (i2 & 16) != 0 ? challengeResponseData2.uiType : uiType2, (i2 & 32) != 0 ? challengeResponseData2.isChallengeCompleted : z, (i2 & 64) != 0 ? challengeResponseData2.challengeInfoHeader : str5, (i2 & 128) != 0 ? challengeResponseData2.challengeInfoLabel : str6, (i2 & 256) != 0 ? challengeResponseData2.challengeInfoText : str7, (i2 & 512) != 0 ? challengeResponseData2.challengeAdditionalInfoText : str8, (i2 & 1024) != 0 ? challengeResponseData2.shouldShowChallengeInfoTextIndicator : z2, (i2 & 2048) != 0 ? challengeResponseData2.challengeSelectOptions : list, (i2 & 4096) != 0 ? challengeResponseData2.expandInfoLabel : str9, (i2 & 8192) != 0 ? challengeResponseData2.expandInfoText : str10, (i2 & 16384) != 0 ? challengeResponseData2.issuerImage : image, (i2 & 32768) != 0 ? challengeResponseData2.messageExtensions : list2, (i2 & 65536) != 0 ? challengeResponseData2.messageVersion : str11, (i2 & 131072) != 0 ? challengeResponseData2.oobAppUrl : str12, (i2 & 262144) != 0 ? challengeResponseData2.oobAppLabel : str13, (i2 & 524288) != 0 ? challengeResponseData2.oobContinueLabel : str14, (i2 & 1048576) != 0 ? challengeResponseData2.paymentSystemImage : image2, (i2 & 2097152) != 0 ? challengeResponseData2.resendInformationLabel : str15, (i2 & 4194304) != 0 ? challengeResponseData2.sdkTransId : sdkTransactionId, (i2 & 8388608) != 0 ? challengeResponseData2.submitAuthenticationLabel : str16, (i2 & 16777216) != 0 ? challengeResponseData2.whitelistingInfoText : str17, (i2 & 33554432) != 0 ? challengeResponseData2.whyInfoLabel : str18, (i2 & 67108864) != 0 ? challengeResponseData2.whyInfoText : str19, (i2 & 134217728) != 0 ? challengeResponseData2.transStatus : str20);
    }

    public final String component1() {
        return this.serverTransId;
    }

    public final String component10() {
        return this.challengeAdditionalInfoText;
    }

    public final boolean component11() {
        return this.shouldShowChallengeInfoTextIndicator;
    }

    public final List<ChallengeSelectOption> component12() {
        return this.challengeSelectOptions;
    }

    public final String component13() {
        return this.expandInfoLabel;
    }

    public final String component14() {
        return this.expandInfoText;
    }

    public final Image component15() {
        return this.issuerImage;
    }

    public final List<MessageExtension> component16() {
        return this.messageExtensions;
    }

    public final String component17() {
        return this.messageVersion;
    }

    public final String component18() {
        return this.oobAppUrl;
    }

    public final String component19() {
        return this.oobAppLabel;
    }

    public final String component2() {
        return this.acsTransId;
    }

    public final String component20() {
        return this.oobContinueLabel;
    }

    public final Image component21() {
        return this.paymentSystemImage;
    }

    public final String component22() {
        return this.resendInformationLabel;
    }

    public final SdkTransactionId component23() {
        return this.sdkTransId;
    }

    public final String component24() {
        return this.submitAuthenticationLabel;
    }

    public final String component25() {
        return this.whitelistingInfoText;
    }

    public final String component26() {
        return this.whyInfoLabel;
    }

    public final String component27() {
        return this.whyInfoText;
    }

    public final String component28() {
        return this.transStatus;
    }

    public final String component3() {
        return this.acsHtml;
    }

    public final String component4() {
        return this.acsHtmlRefresh;
    }

    public final UiType component5() {
        return this.uiType;
    }

    public final boolean component6() {
        return this.isChallengeCompleted;
    }

    public final String component7() {
        return this.challengeInfoHeader;
    }

    public final String component8() {
        return this.challengeInfoLabel;
    }

    public final String component9() {
        return this.challengeInfoText;
    }

    public final ChallengeResponseData copy(String str, String str2, String str3, String str4, UiType uiType2, boolean z, String str5, String str6, String str7, String str8, boolean z2, List<ChallengeSelectOption> list, String str9, String str10, Image image, List<MessageExtension> list2, String str11, String str12, String str13, String str14, Image image2, String str15, SdkTransactionId sdkTransactionId, String str16, String str17, String str18, String str19, String str20) {
        String str21 = str;
        Intrinsics.checkNotNullParameter(str21, "serverTransId");
        Intrinsics.checkNotNullParameter(str2, "acsTransId");
        Intrinsics.checkNotNullParameter(str11, "messageVersion");
        Intrinsics.checkNotNullParameter(sdkTransactionId, "sdkTransId");
        return new ChallengeResponseData(str21, str2, str3, str4, uiType2, z, str5, str6, str7, str8, z2, list, str9, str10, image, list2, str11, str12, str13, str14, image2, str15, sdkTransactionId, str16, str17, str18, str19, str20);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChallengeResponseData)) {
            return false;
        }
        ChallengeResponseData challengeResponseData = (ChallengeResponseData) obj;
        return Intrinsics.areEqual((Object) this.serverTransId, (Object) challengeResponseData.serverTransId) && Intrinsics.areEqual((Object) this.acsTransId, (Object) challengeResponseData.acsTransId) && Intrinsics.areEqual((Object) this.acsHtml, (Object) challengeResponseData.acsHtml) && Intrinsics.areEqual((Object) this.acsHtmlRefresh, (Object) challengeResponseData.acsHtmlRefresh) && this.uiType == challengeResponseData.uiType && this.isChallengeCompleted == challengeResponseData.isChallengeCompleted && Intrinsics.areEqual((Object) this.challengeInfoHeader, (Object) challengeResponseData.challengeInfoHeader) && Intrinsics.areEqual((Object) this.challengeInfoLabel, (Object) challengeResponseData.challengeInfoLabel) && Intrinsics.areEqual((Object) this.challengeInfoText, (Object) challengeResponseData.challengeInfoText) && Intrinsics.areEqual((Object) this.challengeAdditionalInfoText, (Object) challengeResponseData.challengeAdditionalInfoText) && this.shouldShowChallengeInfoTextIndicator == challengeResponseData.shouldShowChallengeInfoTextIndicator && Intrinsics.areEqual((Object) this.challengeSelectOptions, (Object) challengeResponseData.challengeSelectOptions) && Intrinsics.areEqual((Object) this.expandInfoLabel, (Object) challengeResponseData.expandInfoLabel) && Intrinsics.areEqual((Object) this.expandInfoText, (Object) challengeResponseData.expandInfoText) && Intrinsics.areEqual((Object) this.issuerImage, (Object) challengeResponseData.issuerImage) && Intrinsics.areEqual((Object) this.messageExtensions, (Object) challengeResponseData.messageExtensions) && Intrinsics.areEqual((Object) this.messageVersion, (Object) challengeResponseData.messageVersion) && Intrinsics.areEqual((Object) this.oobAppUrl, (Object) challengeResponseData.oobAppUrl) && Intrinsics.areEqual((Object) this.oobAppLabel, (Object) challengeResponseData.oobAppLabel) && Intrinsics.areEqual((Object) this.oobContinueLabel, (Object) challengeResponseData.oobContinueLabel) && Intrinsics.areEqual((Object) this.paymentSystemImage, (Object) challengeResponseData.paymentSystemImage) && Intrinsics.areEqual((Object) this.resendInformationLabel, (Object) challengeResponseData.resendInformationLabel) && Intrinsics.areEqual((Object) this.sdkTransId, (Object) challengeResponseData.sdkTransId) && Intrinsics.areEqual((Object) this.submitAuthenticationLabel, (Object) challengeResponseData.submitAuthenticationLabel) && Intrinsics.areEqual((Object) this.whitelistingInfoText, (Object) challengeResponseData.whitelistingInfoText) && Intrinsics.areEqual((Object) this.whyInfoLabel, (Object) challengeResponseData.whyInfoLabel) && Intrinsics.areEqual((Object) this.whyInfoText, (Object) challengeResponseData.whyInfoText) && Intrinsics.areEqual((Object) this.transStatus, (Object) challengeResponseData.transStatus);
    }

    public int hashCode() {
        int hashCode = ((this.serverTransId.hashCode() * 31) + this.acsTransId.hashCode()) * 31;
        String str = this.acsHtml;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.acsHtmlRefresh;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        UiType uiType2 = this.uiType;
        int hashCode4 = (hashCode3 + (uiType2 == null ? 0 : uiType2.hashCode())) * 31;
        boolean z = this.isChallengeCompleted;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode4 + (z ? 1 : 0)) * 31;
        String str3 = this.challengeInfoHeader;
        int hashCode5 = (i2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.challengeInfoLabel;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.challengeInfoText;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.challengeAdditionalInfoText;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        boolean z3 = this.shouldShowChallengeInfoTextIndicator;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (hashCode8 + (z2 ? 1 : 0)) * 31;
        List<ChallengeSelectOption> list = this.challengeSelectOptions;
        int hashCode9 = (i3 + (list == null ? 0 : list.hashCode())) * 31;
        String str7 = this.expandInfoLabel;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.expandInfoText;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Image image = this.issuerImage;
        int hashCode12 = (hashCode11 + (image == null ? 0 : image.hashCode())) * 31;
        List<MessageExtension> list2 = this.messageExtensions;
        int hashCode13 = (((hashCode12 + (list2 == null ? 0 : list2.hashCode())) * 31) + this.messageVersion.hashCode()) * 31;
        String str9 = this.oobAppUrl;
        int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.oobAppLabel;
        int hashCode15 = (hashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.oobContinueLabel;
        int hashCode16 = (hashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Image image2 = this.paymentSystemImage;
        int hashCode17 = (hashCode16 + (image2 == null ? 0 : image2.hashCode())) * 31;
        String str12 = this.resendInformationLabel;
        int hashCode18 = (((hashCode17 + (str12 == null ? 0 : str12.hashCode())) * 31) + this.sdkTransId.hashCode()) * 31;
        String str13 = this.submitAuthenticationLabel;
        int hashCode19 = (hashCode18 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.whitelistingInfoText;
        int hashCode20 = (hashCode19 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.whyInfoLabel;
        int hashCode21 = (hashCode20 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.whyInfoText;
        int hashCode22 = (hashCode21 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.transStatus;
        if (str17 != null) {
            i = str17.hashCode();
        }
        return hashCode22 + i;
    }

    public String toString() {
        return "ChallengeResponseData(serverTransId=" + this.serverTransId + ", acsTransId=" + this.acsTransId + ", acsHtml=" + this.acsHtml + ", acsHtmlRefresh=" + this.acsHtmlRefresh + ", uiType=" + this.uiType + ", isChallengeCompleted=" + this.isChallengeCompleted + ", challengeInfoHeader=" + this.challengeInfoHeader + ", challengeInfoLabel=" + this.challengeInfoLabel + ", challengeInfoText=" + this.challengeInfoText + ", challengeAdditionalInfoText=" + this.challengeAdditionalInfoText + ", shouldShowChallengeInfoTextIndicator=" + this.shouldShowChallengeInfoTextIndicator + ", challengeSelectOptions=" + this.challengeSelectOptions + ", expandInfoLabel=" + this.expandInfoLabel + ", expandInfoText=" + this.expandInfoText + ", issuerImage=" + this.issuerImage + ", messageExtensions=" + this.messageExtensions + ", messageVersion=" + this.messageVersion + ", oobAppUrl=" + this.oobAppUrl + ", oobAppLabel=" + this.oobAppLabel + ", oobContinueLabel=" + this.oobContinueLabel + ", paymentSystemImage=" + this.paymentSystemImage + ", resendInformationLabel=" + this.resendInformationLabel + ", sdkTransId=" + this.sdkTransId + ", submitAuthenticationLabel=" + this.submitAuthenticationLabel + ", whitelistingInfoText=" + this.whitelistingInfoText + ", whyInfoLabel=" + this.whyInfoLabel + ", whyInfoText=" + this.whyInfoText + ", transStatus=" + this.transStatus + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.serverTransId);
        parcel.writeString(this.acsTransId);
        parcel.writeString(this.acsHtml);
        parcel.writeString(this.acsHtmlRefresh);
        UiType uiType2 = this.uiType;
        if (uiType2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(uiType2.name());
        }
        parcel.writeInt(this.isChallengeCompleted ? 1 : 0);
        parcel.writeString(this.challengeInfoHeader);
        parcel.writeString(this.challengeInfoLabel);
        parcel.writeString(this.challengeInfoText);
        parcel.writeString(this.challengeAdditionalInfoText);
        parcel.writeInt(this.shouldShowChallengeInfoTextIndicator ? 1 : 0);
        List<ChallengeSelectOption> list = this.challengeSelectOptions;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (ChallengeSelectOption writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i);
            }
        }
        parcel.writeString(this.expandInfoLabel);
        parcel.writeString(this.expandInfoText);
        Image image = this.issuerImage;
        if (image == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            image.writeToParcel(parcel, i);
        }
        List<MessageExtension> list2 = this.messageExtensions;
        if (list2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            for (MessageExtension writeToParcel2 : list2) {
                writeToParcel2.writeToParcel(parcel, i);
            }
        }
        parcel.writeString(this.messageVersion);
        parcel.writeString(this.oobAppUrl);
        parcel.writeString(this.oobAppLabel);
        parcel.writeString(this.oobContinueLabel);
        Image image2 = this.paymentSystemImage;
        if (image2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            image2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.resendInformationLabel);
        this.sdkTransId.writeToParcel(parcel, i);
        parcel.writeString(this.submitAuthenticationLabel);
        parcel.writeString(this.whitelistingInfoText);
        parcel.writeString(this.whyInfoLabel);
        parcel.writeString(this.whyInfoText);
        parcel.writeString(this.transStatus);
    }

    public ChallengeResponseData(String str, String str2, String str3, String str4, UiType uiType2, boolean z, String str5, String str6, String str7, String str8, boolean z2, List<ChallengeSelectOption> list, String str9, String str10, Image image, List<MessageExtension> list2, String str11, String str12, String str13, String str14, Image image2, String str15, SdkTransactionId sdkTransactionId, String str16, String str17, String str18, String str19, String str20) {
        String str21 = str11;
        SdkTransactionId sdkTransactionId2 = sdkTransactionId;
        Intrinsics.checkNotNullParameter(str, "serverTransId");
        Intrinsics.checkNotNullParameter(str2, "acsTransId");
        Intrinsics.checkNotNullParameter(str21, "messageVersion");
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransId");
        this.serverTransId = str;
        this.acsTransId = str2;
        this.acsHtml = str3;
        this.acsHtmlRefresh = str4;
        this.uiType = uiType2;
        this.isChallengeCompleted = z;
        this.challengeInfoHeader = str5;
        this.challengeInfoLabel = str6;
        this.challengeInfoText = str7;
        this.challengeAdditionalInfoText = str8;
        this.shouldShowChallengeInfoTextIndicator = z2;
        this.challengeSelectOptions = list;
        this.expandInfoLabel = str9;
        this.expandInfoText = str10;
        this.issuerImage = image;
        this.messageExtensions = list2;
        this.messageVersion = str21;
        this.oobAppUrl = str12;
        this.oobAppLabel = str13;
        this.oobContinueLabel = str14;
        this.paymentSystemImage = image2;
        this.resendInformationLabel = str15;
        this.sdkTransId = sdkTransactionId2;
        this.submitAuthenticationLabel = str16;
        this.whitelistingInfoText = str17;
        this.whyInfoLabel = str18;
        this.whyInfoText = str19;
        this.transStatus = str20;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChallengeResponseData(java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, com.stripe.android.stripe3ds2.transactions.UiType r37, boolean r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, boolean r43, java.util.List r44, java.lang.String r45, java.lang.String r46, com.stripe.android.stripe3ds2.transactions.ChallengeResponseData.Image r47, java.util.List r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, com.stripe.android.stripe3ds2.transactions.ChallengeResponseData.Image r53, java.lang.String r54, com.stripe.android.stripe3ds2.transaction.SdkTransactionId r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, int r61, kotlin.jvm.internal.DefaultConstructorMarker r62) {
        /*
            r32 = this;
            r0 = r61
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r35
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0011
            r7 = r2
            goto L_0x0013
        L_0x0011:
            r7 = r36
        L_0x0013:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0019
            r8 = r2
            goto L_0x001b
        L_0x0019:
            r8 = r37
        L_0x001b:
            r1 = r0 & 32
            r3 = 0
            if (r1 == 0) goto L_0x0022
            r9 = 0
            goto L_0x0024
        L_0x0022:
            r9 = r38
        L_0x0024:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002a
            r10 = r2
            goto L_0x002c
        L_0x002a:
            r10 = r39
        L_0x002c:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0032
            r11 = r2
            goto L_0x0034
        L_0x0032:
            r11 = r40
        L_0x0034:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003a
            r12 = r2
            goto L_0x003c
        L_0x003a:
            r12 = r41
        L_0x003c:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0042
            r13 = r2
            goto L_0x0044
        L_0x0042:
            r13 = r42
        L_0x0044:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004a
            r14 = 0
            goto L_0x004c
        L_0x004a:
            r14 = r43
        L_0x004c:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0052
            r15 = r2
            goto L_0x0054
        L_0x0052:
            r15 = r44
        L_0x0054:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x005b
            r16 = r2
            goto L_0x005d
        L_0x005b:
            r16 = r45
        L_0x005d:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0064
            r17 = r2
            goto L_0x0066
        L_0x0064:
            r17 = r46
        L_0x0066:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x006d
            r18 = r2
            goto L_0x006f
        L_0x006d:
            r18 = r47
        L_0x006f:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0078
            r19 = r2
            goto L_0x007a
        L_0x0078:
            r19 = r48
        L_0x007a:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0082
            r21 = r2
            goto L_0x0084
        L_0x0082:
            r21 = r50
        L_0x0084:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008c
            r22 = r2
            goto L_0x008e
        L_0x008c:
            r22 = r51
        L_0x008e:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0096
            r23 = r2
            goto L_0x0098
        L_0x0096:
            r23 = r52
        L_0x0098:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a0
            r24 = r2
            goto L_0x00a2
        L_0x00a0:
            r24 = r53
        L_0x00a2:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00aa
            r25 = r2
            goto L_0x00ac
        L_0x00aa:
            r25 = r54
        L_0x00ac:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b4
            r27 = r2
            goto L_0x00b6
        L_0x00b4:
            r27 = r56
        L_0x00b6:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00be
            r28 = r2
            goto L_0x00c0
        L_0x00be:
            r28 = r57
        L_0x00c0:
            r1 = 33554432(0x2000000, float:9.403955E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c8
            r29 = r2
            goto L_0x00ca
        L_0x00c8:
            r29 = r58
        L_0x00ca:
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d2
            r30 = r2
            goto L_0x00d4
        L_0x00d2:
            r30 = r59
        L_0x00d4:
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00dc
            r31 = r2
            goto L_0x00de
        L_0x00dc:
            r31 = r60
        L_0x00de:
            r3 = r32
            r4 = r33
            r5 = r34
            r20 = r49
            r26 = r55
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transactions.ChallengeResponseData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.stripe3ds2.transactions.UiType, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.util.List, java.lang.String, java.lang.String, com.stripe.android.stripe3ds2.transactions.ChallengeResponseData$Image, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.stripe3ds2.transactions.ChallengeResponseData$Image, java.lang.String, com.stripe.android.stripe3ds2.transaction.SdkTransactionId, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getServerTransId() {
        return this.serverTransId;
    }

    public final String getAcsTransId() {
        return this.acsTransId;
    }

    public final String getAcsHtml() {
        return this.acsHtml;
    }

    public final String getAcsHtmlRefresh() {
        return this.acsHtmlRefresh;
    }

    public final UiType getUiType() {
        return this.uiType;
    }

    public final boolean isChallengeCompleted() {
        return this.isChallengeCompleted;
    }

    public final String getChallengeInfoHeader() {
        return this.challengeInfoHeader;
    }

    public final String getChallengeInfoLabel() {
        return this.challengeInfoLabel;
    }

    public final String getChallengeInfoText() {
        return this.challengeInfoText;
    }

    public final String getChallengeAdditionalInfoText() {
        return this.challengeAdditionalInfoText;
    }

    public final boolean getShouldShowChallengeInfoTextIndicator() {
        return this.shouldShowChallengeInfoTextIndicator;
    }

    public final List<ChallengeSelectOption> getChallengeSelectOptions() {
        return this.challengeSelectOptions;
    }

    public final String getExpandInfoLabel() {
        return this.expandInfoLabel;
    }

    public final String getExpandInfoText() {
        return this.expandInfoText;
    }

    public final Image getIssuerImage() {
        return this.issuerImage;
    }

    public final List<MessageExtension> getMessageExtensions() {
        return this.messageExtensions;
    }

    public final String getMessageVersion() {
        return this.messageVersion;
    }

    public final String getOobAppUrl() {
        return this.oobAppUrl;
    }

    public final String getOobAppLabel() {
        return this.oobAppLabel;
    }

    public final String getOobContinueLabel() {
        return this.oobContinueLabel;
    }

    public final Image getPaymentSystemImage() {
        return this.paymentSystemImage;
    }

    public final String getResendInformationLabel() {
        return this.resendInformationLabel;
    }

    public final SdkTransactionId getSdkTransId() {
        return this.sdkTransId;
    }

    public final String getSubmitAuthenticationLabel() {
        return this.submitAuthenticationLabel;
    }

    public final String getWhitelistingInfoText() {
        return this.whitelistingInfoText;
    }

    public final String getWhyInfoLabel() {
        return this.whyInfoLabel;
    }

    public final String getWhyInfoText() {
        return this.whyInfoText;
    }

    public final String getTransStatus() {
        return this.transStatus;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isValidForUi$3ds2sdk_release() {
        /*
            r7 = this;
            com.stripe.android.stripe3ds2.transactions.UiType r0 = r7.uiType
            r1 = 1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.stripe.android.stripe3ds2.transactions.UiType r2 = com.stripe.android.stripe3ds2.transactions.UiType.Html
            r3 = 0
            if (r0 != r2) goto L_0x001b
            java.lang.String r0 = r7.acsHtml
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0017
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x0018
        L_0x0017:
            r3 = 1
        L_0x0018:
            r0 = r3 ^ 1
            return r0
        L_0x001b:
            r0 = 8
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r2 = r7.challengeInfoHeader
            r0[r3] = r2
            java.lang.String r2 = r7.challengeInfoLabel
            r0[r1] = r2
            java.lang.String r2 = r7.challengeInfoText
            r4 = 2
            r0[r4] = r2
            java.lang.String r2 = r7.whyInfoLabel
            r5 = 3
            r0[r5] = r2
            r2 = 4
            java.lang.String r6 = r7.whyInfoText
            r0[r2] = r6
            r2 = 5
            java.lang.String r6 = r7.expandInfoLabel
            r0[r2] = r6
            r2 = 6
            java.lang.String r6 = r7.expandInfoText
            r0[r2] = r6
            r2 = 7
            java.lang.String r6 = r7.resendInformationLabel
            r0[r2] = r6
            java.util.Set r0 = kotlin.collections.SetsKt.setOf(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L_0x005a
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x005a
        L_0x0058:
            r0 = 1
            goto L_0x007b
        L_0x005a:
            java.util.Iterator r0 = r0.iterator()
        L_0x005e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0077
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r2 = 0
            goto L_0x0078
        L_0x0077:
            r2 = 1
        L_0x0078:
            if (r2 != 0) goto L_0x005e
            r0 = 0
        L_0x007b:
            if (r0 == 0) goto L_0x007e
            return r3
        L_0x007e:
            com.stripe.android.stripe3ds2.transactions.UiType r0 = r7.uiType
            com.stripe.android.stripe3ds2.transactions.UiType r2 = com.stripe.android.stripe3ds2.transactions.UiType.OutOfBand
            if (r0 != r2) goto L_0x00c9
            java.lang.String[] r0 = new java.lang.String[r5]
            java.lang.String r2 = r7.oobAppLabel
            r0[r3] = r2
            java.lang.String r2 = r7.oobAppUrl
            r0[r1] = r2
            java.lang.String r2 = r7.oobContinueLabel
            r0[r4] = r2
            java.util.Set r0 = kotlin.collections.SetsKt.setOf(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L_0x00a7
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x00a7
        L_0x00a5:
            r1 = 0
            goto L_0x00c8
        L_0x00a7:
            java.util.Iterator r0 = r0.iterator()
        L_0x00ab:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00a5
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x00c4
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r2 = 0
            goto L_0x00c5
        L_0x00c4:
            r2 = 1
        L_0x00c5:
            r2 = r2 ^ r1
            if (r2 == 0) goto L_0x00ab
        L_0x00c8:
            return r1
        L_0x00c9:
            com.stripe.android.stripe3ds2.transactions.UiType r0 = r7.uiType
            com.stripe.android.stripe3ds2.transactions.UiType r2 = com.stripe.android.stripe3ds2.transactions.UiType.SingleSelect
            if (r0 == r2) goto L_0x00d5
            com.stripe.android.stripe3ds2.transactions.UiType r0 = r7.uiType
            com.stripe.android.stripe3ds2.transactions.UiType r2 = com.stripe.android.stripe3ds2.transactions.UiType.MultiSelect
            if (r0 != r2) goto L_0x00e0
        L_0x00d5:
            java.util.List<com.stripe.android.stripe3ds2.transactions.ChallengeResponseData$ChallengeSelectOption> r0 = r7.challengeSelectOptions
            if (r0 == 0) goto L_0x00f0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00e0
            goto L_0x00f0
        L_0x00e0:
            java.lang.String r0 = r7.submitAuthenticationLabel
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00ec
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x00ed
        L_0x00ec:
            r3 = 1
        L_0x00ed:
            r0 = r3 ^ 1
            return r0
        L_0x00f0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transactions.ChallengeResponseData.isValidForUi$3ds2sdk_release():boolean");
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject put = new JSONObject().put("messageType", MESSAGE_TYPE).put("threeDSServerTransID", this.serverTransId).put("acsTransID", this.acsTransId).put(FIELD_ACS_HTML, this.acsHtml).put(FIELD_ACS_HTML_REFRESH, this.acsHtmlRefresh);
        UiType uiType2 = this.uiType;
        JSONObject jSONObject = null;
        JSONObject put2 = put.put(FIELD_ACS_UI_TYPE, uiType2 == null ? null : uiType2.getCode());
        boolean z = this.isChallengeCompleted;
        String str = YES_VALUE;
        JSONObject put3 = put2.put(FIELD_CHALLENGE_COMPLETION_INDICATOR, z ? str : "N").put(FIELD_CHALLENGE_INFO_HEADER, this.challengeInfoHeader).put(FIELD_CHALLENGE_INFO_LABEL, this.challengeInfoLabel).put(FIELD_CHALLENGE_INFO_TEXT, this.challengeInfoText).put(FIELD_CHALLENGE_ADDITIONAL_INFO_TEXT, this.challengeAdditionalInfoText).put(FIELD_CHALLENGE_SELECT_INFO, ChallengeSelectOption.Companion.toJsonArray$3ds2sdk_release(this.challengeSelectOptions)).put(FIELD_EXPAND_INFO_LABEL, this.expandInfoLabel).put(FIELD_EXPAND_INFO_TEXT, this.expandInfoText);
        Image image = this.issuerImage;
        JSONObject put4 = put3.put(FIELD_ISSUER_IMAGE, image == null ? null : image.toJson$3ds2sdk_release()).put(FIELD_MESSAGE_EXTENSION, MessageExtension.Companion.toJsonArray(this.messageExtensions)).put("messageVersion", this.messageVersion).put(FIELD_OOB_APP_URL, this.oobAppUrl).put(FIELD_OOB_APP_LABEL, this.oobAppLabel).put(FIELD_OOB_CONTINUE_LABEL, this.oobContinueLabel);
        Image image2 = this.paymentSystemImage;
        if (image2 != null) {
            jSONObject = image2.toJson$3ds2sdk_release();
        }
        JSONObject put5 = put4.put(FIELD_PAYMENT_SYSTEM_IMAGE, jSONObject).put(FIELD_RESEND_INFORMATION_LABEL, this.resendInformationLabel).put("sdkTransID", this.sdkTransId).put(FIELD_SUBMIT_AUTHENTICATION_LABEL, this.submitAuthenticationLabel).put(FIELD_WHITELISTING_INFO_TEXT, this.whitelistingInfoText).put(FIELD_WHY_INFO_LABEL, this.whyInfoLabel).put(FIELD_WHY_INFO_TEXT, this.whyInfoText).put(FIELD_TRANS_STATUS, this.transStatus);
        if (!isChallengeCompleted()) {
            if (!getShouldShowChallengeInfoTextIndicator()) {
                str = "N";
            }
            put5.put(FIELD_CHALLENGE_INFO_TEXT_INDICATOR, str);
        }
        Intrinsics.checkNotNullExpressionValue(put5, "JSONObject()\n           …          }\n            }");
        return put5;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0012J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0015J\t\u0010\u001c\u001a\u00020\u0015HÖ\u0001J\r\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006'"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$Image;", "Landroid/os/Parcelable;", "mediumUrl", "", "highUrl", "extraHighUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtraHighUrl$3ds2sdk_release", "()Ljava/lang/String;", "getHighUrl$3ds2sdk_release", "highestFidelityImageUrl", "getHighestFidelityImageUrl", "getMediumUrl$3ds2sdk_release", "component1", "component1$3ds2sdk_release", "component2", "component2$3ds2sdk_release", "component3", "component3$3ds2sdk_release", "copy", "describeContents", "", "equals", "", "other", "", "getUrlForDensity", "density", "hashCode", "toJson", "Lorg/json/JSONObject;", "toJson$3ds2sdk_release", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResponseData.kt */
    public static final class Image implements Parcelable {
        public static final Parcelable.Creator<Image> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String FIELD_EXTRA_HIGH = "extraHigh";
        private static final String FIELD_HIGH = "high";
        private static final String FIELD_MEDIUM = "medium";
        private final String extraHighUrl;
        private final String highUrl;
        private final String mediumUrl;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeResponseData.kt */
        public static final class Creator implements Parcelable.Creator<Image> {
            public final Image createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Image(parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final Image[] newArray(int i) {
                return new Image[i];
            }
        }

        public static /* synthetic */ Image copy$default(Image image, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = image.mediumUrl;
            }
            if ((i & 2) != 0) {
                str2 = image.highUrl;
            }
            if ((i & 4) != 0) {
                str3 = image.extraHighUrl;
            }
            return image.copy(str, str2, str3);
        }

        public final String component1$3ds2sdk_release() {
            return this.mediumUrl;
        }

        public final String component2$3ds2sdk_release() {
            return this.highUrl;
        }

        public final String component3$3ds2sdk_release() {
            return this.extraHighUrl;
        }

        public final Image copy(String str, String str2, String str3) {
            return new Image(str, str2, str3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Image)) {
                return false;
            }
            Image image = (Image) obj;
            return Intrinsics.areEqual((Object) this.mediumUrl, (Object) image.mediumUrl) && Intrinsics.areEqual((Object) this.highUrl, (Object) image.highUrl) && Intrinsics.areEqual((Object) this.extraHighUrl, (Object) image.extraHighUrl);
        }

        public int hashCode() {
            String str = this.mediumUrl;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.highUrl;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.extraHighUrl;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Image(mediumUrl=" + this.mediumUrl + ", highUrl=" + this.highUrl + ", extraHighUrl=" + this.extraHighUrl + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.mediumUrl);
            parcel.writeString(this.highUrl);
            parcel.writeString(this.extraHighUrl);
        }

        public Image(String str, String str2, String str3) {
            this.mediumUrl = str;
            this.highUrl = str2;
            this.extraHighUrl = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Image(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, str3);
        }

        public final String getMediumUrl$3ds2sdk_release() {
            return this.mediumUrl;
        }

        public final String getHighUrl$3ds2sdk_release() {
            return this.highUrl;
        }

        public final String getExtraHighUrl$3ds2sdk_release() {
            return this.extraHighUrl;
        }

        public final String getHighestFidelityImageUrl() {
            Object obj;
            Iterator it = CollectionsKt.listOf(this.extraHighUrl, this.highUrl, this.mediumUrl).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                CharSequence charSequence = (String) obj;
                if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                    break;
                }
            }
            return (String) obj;
        }

        public final JSONObject toJson$3ds2sdk_release() throws JSONException {
            JSONObject put = new JSONObject().put("medium", this.mediumUrl).put("high", this.highUrl).put(FIELD_EXTRA_HIGH, this.extraHighUrl);
            Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …EXTRA_HIGH, extraHighUrl)");
            return put;
        }

        public final String getUrlForDensity(int i) {
            String str;
            if (i <= 160) {
                str = this.mediumUrl;
            } else if (i >= 320) {
                str = this.extraHighUrl;
            } else {
                str = this.highUrl;
            }
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                str = null;
            }
            return str == null ? getHighestFidelityImageUrl() : str;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$Image$Companion;", "", "()V", "FIELD_EXTRA_HIGH", "", "FIELD_HIGH", "FIELD_MEDIUM", "fromJson", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$Image;", "imageJson", "Lorg/json/JSONObject;", "fromJson$3ds2sdk_release", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeResponseData.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Image fromJson$3ds2sdk_release(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return null;
                }
                return new Image(jSONObject.optString("medium"), jSONObject.optString("high"), jSONObject.optString(Image.FIELD_EXTRA_HIGH));
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$ChallengeSelectOption;", "Landroid/os/Parcelable;", "name", "", "text", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResponseData.kt */
    public static final class ChallengeSelectOption implements Parcelable {
        public static final Parcelable.Creator<ChallengeSelectOption> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String name;
        private final String text;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeResponseData.kt */
        public static final class Creator implements Parcelable.Creator<ChallengeSelectOption> {
            public final ChallengeSelectOption createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ChallengeSelectOption(parcel.readString(), parcel.readString());
            }

            public final ChallengeSelectOption[] newArray(int i) {
                return new ChallengeSelectOption[i];
            }
        }

        public static /* synthetic */ ChallengeSelectOption copy$default(ChallengeSelectOption challengeSelectOption, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = challengeSelectOption.name;
            }
            if ((i & 2) != 0) {
                str2 = challengeSelectOption.text;
            }
            return challengeSelectOption.copy(str, str2);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.text;
        }

        public final ChallengeSelectOption copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "text");
            return new ChallengeSelectOption(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChallengeSelectOption)) {
                return false;
            }
            ChallengeSelectOption challengeSelectOption = (ChallengeSelectOption) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) challengeSelectOption.name) && Intrinsics.areEqual((Object) this.text, (Object) challengeSelectOption.text);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.text.hashCode();
        }

        public String toString() {
            return "ChallengeSelectOption(name=" + this.name + ", text=" + this.text + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.name);
            parcel.writeString(this.text);
        }

        public ChallengeSelectOption(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "text");
            this.name = str;
            this.text = str2;
        }

        public final String getName() {
            return this.name;
        }

        public final String getText() {
            return this.text;
        }

        /* access modifiers changed from: private */
        public final JSONObject toJson() throws JSONException {
            JSONObject put = new JSONObject().put(this.name, this.text);
            Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n                .put(name, text)");
            return put;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\bJ\u001f\u0010\t\u001a\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$ChallengeSelectOption$Companion;", "", "()V", "fromJson", "", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$ChallengeSelectOption;", "challengeSelectOptionsJson", "Lorg/json/JSONArray;", "fromJson$3ds2sdk_release", "toJsonArray", "options", "toJsonArray$3ds2sdk_release", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeResponseData.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final List<ChallengeSelectOption> fromJson$3ds2sdk_release(JSONArray jSONArray) {
                if (jSONArray == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                int length = jSONArray.length();
                while (i < length) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String next = optJSONObject.keys().next();
                        String optString = optJSONObject.optString(next);
                        Intrinsics.checkNotNullExpressionValue(next, "name");
                        Intrinsics.checkNotNullExpressionValue(optString, "text");
                        arrayList.add(new ChallengeSelectOption(next, optString));
                    }
                    i = i2;
                }
                return arrayList;
            }

            public final JSONArray toJsonArray$3ds2sdk_release(List<ChallengeSelectOption> list) throws JSONException {
                if (list == null) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                for (ChallengeSelectOption access$toJson : list) {
                    jSONArray.put(access$toJson.toJson());
                }
                return jSONArray;
            }
        }
    }

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b/J\u0014\u00100\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0002J\u0015\u00102\u001a\u0002032\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b4J\u0017\u00105\u001a\u0004\u0018\u0001062\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b7J\u001f\u00108\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020,2\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\b;J\u001d\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010'2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b@J\u001f\u0010A\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020,2\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\bBJ\u001a\u0010C\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020\u0004H\u0002J\u0017\u0010F\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\bGJ\u001f\u0010H\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020,2\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\bIJ\u0015\u0010J\u001a\u00020K2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\bLJ\u001d\u0010M\u001a\u00020N2\u0006\u0010+\u001a\u00020,2\u0006\u0010E\u001a\u00020\u0004H\u0001¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020:2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\bQJ%\u0010R\u001a\u00020S2\u0006\u0010+\u001a\u00020,2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010T\u001a\u00020SH\u0001¢\u0006\u0002\bUR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$Companion;", "", "()V", "FIELD_ACS_COUNTER_ACS_TO_SDK", "", "FIELD_ACS_HTML", "FIELD_ACS_HTML_REFRESH", "FIELD_ACS_TRANS_ID", "FIELD_ACS_UI_TYPE", "FIELD_CHALLENGE_ADDITIONAL_INFO_TEXT", "FIELD_CHALLENGE_COMPLETION_INDICATOR", "FIELD_CHALLENGE_INFO_HEADER", "FIELD_CHALLENGE_INFO_LABEL", "FIELD_CHALLENGE_INFO_TEXT", "FIELD_CHALLENGE_INFO_TEXT_INDICATOR", "FIELD_CHALLENGE_SELECT_INFO", "FIELD_EXPAND_INFO_LABEL", "FIELD_EXPAND_INFO_TEXT", "FIELD_ISSUER_IMAGE", "FIELD_MESSAGE_EXTENSION", "FIELD_MESSAGE_TYPE", "FIELD_MESSAGE_VERSION", "FIELD_OOB_APP_LABEL", "FIELD_OOB_APP_URL", "FIELD_OOB_CONTINUE_LABEL", "FIELD_PAYMENT_SYSTEM_IMAGE", "FIELD_RESEND_INFORMATION_LABEL", "FIELD_SDK_TRANS_ID", "FIELD_SERVER_TRANS_ID", "FIELD_SUBMIT_AUTHENTICATION_LABEL", "FIELD_TRANS_STATUS", "FIELD_WHITELISTING_INFO_TEXT", "FIELD_WHY_INFO_LABEL", "FIELD_WHY_INFO_TEXT", "FINAL_CRES_FIELDS", "", "MESSAGE_TYPE", "NO_VALUE", "YES_NO_VALUES", "", "YES_VALUE", "checkFinalCresFields", "", "cresJson", "Lorg/json/JSONObject;", "checkFinalCresFields$3ds2sdk_release", "checkMessageType", "checkMessageType$3ds2sdk_release", "decodeHtml", "encodedHtml", "fromJson", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData;", "fromJson$3ds2sdk_release", "getChallengeSelectInfoArray", "Lorg/json/JSONArray;", "getChallengeSelectInfoArray$3ds2sdk_release", "getDecodedAcsHtml", "uiType", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "getDecodedAcsHtml$3ds2sdk_release", "getMessageExtensions", "Lcom/stripe/android/stripe3ds2/transactions/MessageExtension;", "getMessageExtensions$3ds2sdk_release", "getMessageVersion", "getMessageVersion$3ds2sdk_release", "getOobContinueLabel", "getOobContinueLabel$3ds2sdk_release", "getOrNull", "json", "fieldName", "getResendInformationLabel", "getResendInformationLabel$3ds2sdk_release", "getSubmitAuthenticationLabel", "getSubmitAuthenticationLabel$3ds2sdk_release", "getTransStatus", "Lcom/stripe/android/stripe3ds2/transaction/TransactionStatus;", "getTransStatus$3ds2sdk_release", "getTransactionId", "Ljava/util/UUID;", "getTransactionId$3ds2sdk_release", "getUiType", "getUiType$3ds2sdk_release", "getYesNoValue", "", "isRequired", "getYesNoValue$3ds2sdk_release", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResponseData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChallengeResponseData fromJson$3ds2sdk_release(JSONObject jSONObject) throws ChallengeResponseParseException {
            ChallengeResponseData challengeResponseData;
            JSONObject jSONObject2 = jSONObject;
            Intrinsics.checkNotNullParameter(jSONObject2, "cresJson");
            checkMessageType$3ds2sdk_release(jSONObject);
            boolean yesNoValue$3ds2sdk_release = getYesNoValue$3ds2sdk_release(jSONObject2, ChallengeResponseData.FIELD_CHALLENGE_COMPLETION_INDICATOR, true);
            SdkTransactionId sdkTransactionId = new SdkTransactionId(getTransactionId$3ds2sdk_release(jSONObject2, "sdkTransID"));
            String uuid = getTransactionId$3ds2sdk_release(jSONObject2, "threeDSServerTransID").toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "getTransactionId(cresJso…RVER_TRANS_ID).toString()");
            String uuid2 = getTransactionId$3ds2sdk_release(jSONObject2, "acsTransID").toString();
            Intrinsics.checkNotNullExpressionValue(uuid2, "getTransactionId(cresJso…_ACS_TRANS_ID).toString()");
            String messageVersion$3ds2sdk_release = getMessageVersion$3ds2sdk_release(jSONObject);
            List<MessageExtension> messageExtensions$3ds2sdk_release = getMessageExtensions$3ds2sdk_release(jSONObject);
            if (yesNoValue$3ds2sdk_release) {
                checkFinalCresFields$3ds2sdk_release(jSONObject);
                challengeResponseData = new ChallengeResponseData(uuid, uuid2, (String) null, (String) null, (UiType) null, yesNoValue$3ds2sdk_release, (String) null, (String) null, (String) null, (String) null, false, (List) null, (String) null, (String) null, (Image) null, messageExtensions$3ds2sdk_release, messageVersion$3ds2sdk_release, (String) null, (String) null, (String) null, (Image) null, (String) null, sdkTransactionId, (String) null, (String) null, (String) null, (String) null, getTransStatus$3ds2sdk_release(jSONObject).getCode(), 129925084, (DefaultConstructorMarker) null);
            } else {
                boolean yesNoValue$3ds2sdk_release2 = getYesNoValue$3ds2sdk_release(jSONObject2, ChallengeResponseData.FIELD_CHALLENGE_INFO_TEXT_INDICATOR, false);
                String resendInformationLabel$3ds2sdk_release = getResendInformationLabel$3ds2sdk_release(jSONObject);
                JSONArray challengeSelectInfoArray$3ds2sdk_release = getChallengeSelectInfoArray$3ds2sdk_release(jSONObject);
                UiType uiType$3ds2sdk_release = getUiType$3ds2sdk_release(jSONObject);
                String submitAuthenticationLabel$3ds2sdk_release = getSubmitAuthenticationLabel$3ds2sdk_release(jSONObject2, uiType$3ds2sdk_release);
                String decodedAcsHtml$3ds2sdk_release = getDecodedAcsHtml$3ds2sdk_release(jSONObject2, uiType$3ds2sdk_release);
                String oobContinueLabel$3ds2sdk_release = getOobContinueLabel$3ds2sdk_release(jSONObject2, uiType$3ds2sdk_release);
                challengeResponseData = new ChallengeResponseData(uuid, uuid2, decodedAcsHtml$3ds2sdk_release, decodeHtml(jSONObject2.optString(ChallengeResponseData.FIELD_ACS_HTML_REFRESH)), uiType$3ds2sdk_release, yesNoValue$3ds2sdk_release, jSONObject2.optString(ChallengeResponseData.FIELD_CHALLENGE_INFO_HEADER), jSONObject2.optString(ChallengeResponseData.FIELD_CHALLENGE_INFO_LABEL), jSONObject2.optString(ChallengeResponseData.FIELD_CHALLENGE_INFO_TEXT), jSONObject2.optString(ChallengeResponseData.FIELD_CHALLENGE_ADDITIONAL_INFO_TEXT), yesNoValue$3ds2sdk_release2, ChallengeSelectOption.Companion.fromJson$3ds2sdk_release(challengeSelectInfoArray$3ds2sdk_release), jSONObject2.optString(ChallengeResponseData.FIELD_EXPAND_INFO_LABEL), jSONObject2.optString(ChallengeResponseData.FIELD_EXPAND_INFO_TEXT), Image.Companion.fromJson$3ds2sdk_release(jSONObject2.optJSONObject(ChallengeResponseData.FIELD_ISSUER_IMAGE)), messageExtensions$3ds2sdk_release, messageVersion$3ds2sdk_release, jSONObject2.optString(ChallengeResponseData.FIELD_OOB_APP_URL), jSONObject2.optString(ChallengeResponseData.FIELD_OOB_APP_LABEL), oobContinueLabel$3ds2sdk_release, Image.Companion.fromJson$3ds2sdk_release(jSONObject2.optJSONObject(ChallengeResponseData.FIELD_PAYMENT_SYSTEM_IMAGE)), resendInformationLabel$3ds2sdk_release, sdkTransactionId, submitAuthenticationLabel$3ds2sdk_release, jSONObject2.optString(ChallengeResponseData.FIELD_WHITELISTING_INFO_TEXT), jSONObject2.optString(ChallengeResponseData.FIELD_WHY_INFO_LABEL), jSONObject2.optString(ChallengeResponseData.FIELD_WHY_INFO_TEXT), "");
            }
            if (challengeResponseData.isValidForUi$3ds2sdk_release()) {
                return challengeResponseData;
            }
            throw ChallengeResponseParseException.Companion.createRequiredDataElementMissing("UI fields missing");
        }

        public final void checkFinalCresFields$3ds2sdk_release(JSONObject jSONObject) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!ChallengeResponseData.FINAL_CRES_FIELDS.contains(next)) {
                    throw new ChallengeResponseParseException(ProtocolError.InvalidMessageReceived.getCode(), "Message is not final CRes", Intrinsics.stringPlus("Invalid data element for final CRes: ", next));
                }
            }
        }

        public final void checkMessageType$3ds2sdk_release(JSONObject jSONObject) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            if (!Intrinsics.areEqual((Object) ChallengeResponseData.MESSAGE_TYPE, (Object) jSONObject.optString("messageType"))) {
                throw new ChallengeResponseParseException(ProtocolError.InvalidMessageReceived.getCode(), "Message is not CRes", "Invalid Message Type");
            }
        }

        public final UiType getUiType$3ds2sdk_release(JSONObject jSONObject) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            String optString = jSONObject.optString(ChallengeResponseData.FIELD_ACS_UI_TYPE);
            CharSequence charSequence = optString;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                UiType fromCode$3ds2sdk_release = UiType.Companion.fromCode$3ds2sdk_release(optString);
                if (fromCode$3ds2sdk_release != null) {
                    return fromCode$3ds2sdk_release;
                }
                throw ChallengeResponseParseException.Companion.createInvalidDataElementFormat(ChallengeResponseData.FIELD_ACS_UI_TYPE);
            }
            throw ChallengeResponseParseException.Companion.createRequiredDataElementMissing(ChallengeResponseData.FIELD_ACS_UI_TYPE);
        }

        public final boolean getYesNoValue$3ds2sdk_release(JSONObject jSONObject, String str, boolean z) throws ChallengeResponseParseException {
            String str2;
            Throwable th;
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            Intrinsics.checkNotNullParameter(str, "fieldName");
            if (!z) {
                str2 = getOrNull(jSONObject, str);
            } else if (jSONObject.has(str)) {
                str2 = jSONObject.getString(str);
            } else {
                throw ChallengeResponseParseException.Companion.createRequiredDataElementMissing(str);
            }
            if (str2 == null || ChallengeResponseData.YES_NO_VALUES.contains(str2)) {
                return Intrinsics.areEqual((Object) ChallengeResponseData.YES_VALUE, (Object) str2);
            }
            if (!z || !StringsKt.isBlank(str2)) {
                th = ChallengeResponseParseException.Companion.createInvalidDataElementFormat(str);
            } else {
                th = ChallengeResponseParseException.Companion.createRequiredDataElementMissing(str);
            }
            throw th;
        }

        public final String getResendInformationLabel$3ds2sdk_release(JSONObject jSONObject) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            String orNull = getOrNull(jSONObject, ChallengeResponseData.FIELD_RESEND_INFORMATION_LABEL);
            if (orNull != null) {
                if (orNull.length() == 0) {
                    throw ChallengeResponseParseException.Companion.createInvalidDataElementFormat(ChallengeResponseData.FIELD_RESEND_INFORMATION_LABEL);
                }
            }
            return orNull;
        }

        public final JSONArray getChallengeSelectInfoArray$3ds2sdk_release(JSONObject jSONObject) throws ChallengeResponseParseException {
            Object obj;
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            if (!jSONObject.has(ChallengeResponseData.FIELD_CHALLENGE_SELECT_INFO)) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return null;
            }
            Companion companion = ChallengeResponseData.Companion;
            try {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m4709constructorimpl(jSONObject.getJSONArray(ChallengeResponseData.FIELD_CHALLENGE_SELECT_INFO));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m4712exceptionOrNullimpl(obj) == null) {
                return (JSONArray) obj;
            }
            throw ChallengeResponseParseException.Companion.createInvalidDataElementFormat(ChallengeResponseData.FIELD_CHALLENGE_SELECT_INFO);
        }

        public final String getMessageVersion$3ds2sdk_release(JSONObject jSONObject) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            String optString = jSONObject.optString("messageVersion");
            Intrinsics.checkNotNullExpressionValue(optString, "it");
            if (!(!StringsKt.isBlank(optString))) {
                optString = null;
            }
            if (optString != null) {
                return optString;
            }
            throw ChallengeResponseParseException.Companion.createRequiredDataElementMissing("messageVersion");
        }

        public final UUID getTransactionId$3ds2sdk_release(JSONObject jSONObject, String str) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            Intrinsics.checkNotNullParameter(str, "fieldName");
            String optString = jSONObject.optString(str);
            CharSequence charSequence = optString;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                try {
                    Result.Companion companion = Result.Companion;
                    Companion companion2 = this;
                    UUID fromString = UUID.fromString(optString);
                    Intrinsics.checkNotNullExpressionValue(fromString, "fromString(transId)");
                    return fromString;
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.Companion;
                    if (Result.m4712exceptionOrNullimpl(Result.m4709constructorimpl(ResultKt.createFailure(th))) == null) {
                        throw new KotlinNothingValueException();
                    }
                    throw ChallengeResponseParseException.Companion.createInvalidDataElementFormat(str);
                }
            } else {
                throw ChallengeResponseParseException.Companion.createRequiredDataElementMissing(str);
            }
        }

        public final TransactionStatus getTransStatus$3ds2sdk_release(JSONObject jSONObject) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            String optString = jSONObject.optString(ChallengeResponseData.FIELD_TRANS_STATUS);
            CharSequence charSequence = optString;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                TransactionStatus fromCode = TransactionStatus.Companion.fromCode(optString);
                if (fromCode != null) {
                    return fromCode;
                }
                throw ChallengeResponseParseException.Companion.createInvalidDataElementFormat(ChallengeResponseData.FIELD_TRANS_STATUS);
            }
            throw ChallengeResponseParseException.Companion.createRequiredDataElementMissing(ChallengeResponseData.FIELD_TRANS_STATUS);
        }

        public final String getSubmitAuthenticationLabel$3ds2sdk_release(JSONObject jSONObject, UiType uiType) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            Intrinsics.checkNotNullParameter(uiType, "uiType");
            String orNull = getOrNull(jSONObject, ChallengeResponseData.FIELD_SUBMIT_AUTHENTICATION_LABEL);
            CharSequence charSequence = orNull;
            if (!(charSequence == null || StringsKt.isBlank(charSequence)) || !uiType.getRequiresSubmitButton$3ds2sdk_release()) {
                return orNull;
            }
            throw ChallengeResponseParseException.Companion.createRequiredDataElementMissing(ChallengeResponseData.FIELD_SUBMIT_AUTHENTICATION_LABEL);
        }

        public final String getDecodedAcsHtml$3ds2sdk_release(JSONObject jSONObject, UiType uiType) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            Intrinsics.checkNotNullParameter(uiType, "uiType");
            String orNull = getOrNull(jSONObject, ChallengeResponseData.FIELD_ACS_HTML);
            CharSequence charSequence = orNull;
            if (!(charSequence == null || StringsKt.isBlank(charSequence)) || uiType != UiType.Html) {
                return decodeHtml(orNull);
            }
            throw ChallengeResponseParseException.Companion.createRequiredDataElementMissing(ChallengeResponseData.FIELD_ACS_HTML);
        }

        private final String decodeHtml(String str) {
            Object obj;
            String str2 = null;
            if (str == null) {
                return null;
            }
            Companion companion = ChallengeResponseData.Companion;
            try {
                Result.Companion companion2 = Result.Companion;
                byte[] decode = Base64.decode(str, 8);
                Intrinsics.checkNotNullExpressionValue(decode, "decode(encodedHtml, Base64.URL_SAFE)");
                obj = Result.m4709constructorimpl(new String(decode, Charsets.UTF_8));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            if (!Result.m4715isFailureimpl(obj)) {
                str2 = obj;
            }
            return str2;
        }

        public final String getOobContinueLabel$3ds2sdk_release(JSONObject jSONObject, UiType uiType) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            Intrinsics.checkNotNullParameter(uiType, "uiType");
            String optString = jSONObject.optString(ChallengeResponseData.FIELD_OOB_CONTINUE_LABEL);
            CharSequence charSequence = optString;
            if (!(charSequence == null || StringsKt.isBlank(charSequence)) || uiType != UiType.OutOfBand) {
                return optString;
            }
            throw ChallengeResponseParseException.Companion.createRequiredDataElementMissing(ChallengeResponseData.FIELD_OOB_CONTINUE_LABEL);
        }

        public final List<MessageExtension> getMessageExtensions$3ds2sdk_release(JSONObject jSONObject) throws ChallengeResponseParseException {
            Intrinsics.checkNotNullParameter(jSONObject, "cresJson");
            List<MessageExtension> fromJson = MessageExtension.Companion.fromJson(jSONObject.optJSONArray(ChallengeResponseData.FIELD_MESSAGE_EXTENSION));
            if (fromJson != null) {
                Collection arrayList = new ArrayList();
                Iterator it = fromJson.iterator();
                while (true) {
                    boolean z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    MessageExtension messageExtension = (MessageExtension) next;
                    if (!messageExtension.getCriticalityIndicator() || messageExtension.isProcessable()) {
                        z = false;
                    }
                    if (z) {
                        arrayList.add(next);
                    }
                }
                List list = (List) arrayList;
                if (!list.isEmpty()) {
                    throw new ChallengeResponseParseException(ProtocolError.UnrecognizedCriticalMessageExtensions, CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                }
            }
            return fromJson;
        }

        private final String getOrNull(JSONObject jSONObject, String str) {
            if (jSONObject.has(str)) {
                return jSONObject.getString(str);
            }
            return null;
        }
    }
}
