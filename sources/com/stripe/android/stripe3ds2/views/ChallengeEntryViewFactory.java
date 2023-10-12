package com.stripe.android.stripe3ds2.views;

import android.content.Context;
import android.util.AttributeSet;
import com.stripe.android.stripe3ds2.init.ui.UiCustomization;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseData;
import com.stripe.android.stripe3ds2.transactions.UiType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeEntryViewFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createChallengeEntrySelectView", "Lcom/stripe/android/stripe3ds2/views/ChallengeZoneSelectView;", "challengeResponseData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData;", "uiCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/UiCustomization;", "createChallengeEntryTextView", "Lcom/stripe/android/stripe3ds2/views/ChallengeZoneTextView;", "createChallengeEntryWebView", "Lcom/stripe/android/stripe3ds2/views/ChallengeZoneWebView;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeEntryViewFactory.kt */
public final class ChallengeEntryViewFactory {
    private final Context context;

    public ChallengeEntryViewFactory(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final ChallengeZoneTextView createChallengeEntryTextView(ChallengeResponseData challengeResponseData, UiCustomization uiCustomization) {
        Intrinsics.checkNotNullParameter(challengeResponseData, "challengeResponseData");
        Intrinsics.checkNotNullParameter(uiCustomization, "uiCustomization");
        ChallengeZoneTextView challengeZoneTextView = new ChallengeZoneTextView(this.context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        challengeZoneTextView.setTextEntryLabel(challengeResponseData.getChallengeInfoLabel());
        challengeZoneTextView.setTextBoxCustomization(uiCustomization.getTextBoxCustomization());
        return challengeZoneTextView;
    }

    public final ChallengeZoneSelectView createChallengeEntrySelectView(ChallengeResponseData challengeResponseData, UiCustomization uiCustomization) {
        Intrinsics.checkNotNullParameter(challengeResponseData, "challengeResponseData");
        Intrinsics.checkNotNullParameter(uiCustomization, "uiCustomization");
        ChallengeZoneSelectView challengeZoneSelectView = new ChallengeZoneSelectView(this.context, (AttributeSet) null, 0, challengeResponseData.getUiType() == UiType.SingleSelect, 6, (DefaultConstructorMarker) null);
        challengeZoneSelectView.setTextEntryLabel(challengeResponseData.getChallengeInfoLabel(), uiCustomization.getLabelCustomization());
        challengeZoneSelectView.setChallengeSelectOptions(challengeResponseData.getChallengeSelectOptions(), uiCustomization.getButtonCustomization(UiCustomization.ButtonType.SELECT));
        return challengeZoneSelectView;
    }

    public final ChallengeZoneWebView createChallengeEntryWebView(ChallengeResponseData challengeResponseData) {
        Intrinsics.checkNotNullParameter(challengeResponseData, "challengeResponseData");
        ChallengeZoneWebView challengeZoneWebView = new ChallengeZoneWebView(this.context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        challengeZoneWebView.loadHtml(challengeResponseData.getAcsHtml());
        return challengeZoneWebView;
    }
}
