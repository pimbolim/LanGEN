package com.stripe.android.view;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.autofill.HintConstants;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.cards.CardAccountRangeRepository;
import com.stripe.android.cards.CardAccountRangeService;
import com.stripe.android.cards.CardNumber;
import com.stripe.android.cards.DefaultCardAccountRangeRepositoryFactory;
import com.stripe.android.cards.DefaultStaticCardAccountRanges;
import com.stripe.android.cards.StaticCardAccountRanges;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.model.AccountRange;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import java.util.Set;
import java.util.concurrent.CancellationException;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001:\u0001]B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB7\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eBQ\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J/\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\b\b\u0002\u0010C\u001a\u00020\u0007H\u0000¢\u0006\u0002\bUJ\b\u0010V\u001a\u00020$H\u0014J\r\u0010W\u001a\u00020$H\u0000¢\u0006\u0002\bXJ\b\u0010Y\u001a\u00020$H\u0014J\u0017\u0010Z\u001a\u00020$2\b\b\u0002\u0010[\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\\R\u0014\u0010\u0018\u001a\u00020\r8TX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u001c8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R<\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R,\u0010+\u001a\u00020#2\u0006\u0010*\u001a\u00020#8\u0006@@X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\b\u0012\u0004\u0012\u00020$0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001e\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020:@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R&\u0010=\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020$0\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010'\"\u0004\b?\u0010)R\u0014\u0010@\u001a\u00020:8BX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010<R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\bD\u00108R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020F8BX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0016\u0010I\u001a\u0004\u0018\u00010J8@X\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006^"}, d2 = {"Lcom/stripe/android/view/CardNumberEditText;", "Lcom/stripe/android/view/StripeEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "workContext", "Lkotlin/coroutines/CoroutineContext;", "publishableKeySupplier", "Lkotlin/Function0;", "", "(Landroid/content/Context;Landroid/util/AttributeSet;ILkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;)V", "cardAccountRangeRepository", "Lcom/stripe/android/cards/CardAccountRangeRepository;", "staticCardAccountRanges", "Lcom/stripe/android/cards/StaticCardAccountRanges;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILkotlin/coroutines/CoroutineContext;Lcom/stripe/android/cards/CardAccountRangeRepository;Lcom/stripe/android/cards/StaticCardAccountRanges;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;)V", "accessibilityText", "getAccessibilityText", "()Ljava/lang/String;", "accountRangeService", "Lcom/stripe/android/cards/CardAccountRangeService;", "getAccountRangeService$annotations", "()V", "getAccountRangeService", "()Lcom/stripe/android/cards/CardAccountRangeService;", "callback", "Lkotlin/Function1;", "Lcom/stripe/android/model/CardBrand;", "", "brandChangeCallback", "getBrandChangeCallback$payments_core_release", "()Lkotlin/jvm/functions/Function1;", "setBrandChangeCallback$payments_core_release", "(Lkotlin/jvm/functions/Function1;)V", "value", "cardBrand", "getCardBrand$annotations", "getCardBrand", "()Lcom/stripe/android/model/CardBrand;", "setCardBrand$payments_core_release", "(Lcom/stripe/android/model/CardBrand;)V", "completionCallback", "getCompletionCallback$payments_core_release", "()Lkotlin/jvm/functions/Function0;", "setCompletionCallback$payments_core_release", "(Lkotlin/jvm/functions/Function0;)V", "formattedPanLength", "getFormattedPanLength", "()I", "<set-?>", "", "isCardNumberValid", "()Z", "isLoadingCallback", "isLoadingCallback$payments_core_release", "setLoadingCallback$payments_core_release", "isValid", "loadingJob", "Lkotlinx/coroutines/Job;", "panLength", "getPanLength$payments_core_release", "unvalidatedCardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "getUnvalidatedCardNumber", "()Lcom/stripe/android/cards/CardNumber$Unvalidated;", "validatedCardNumber", "Lcom/stripe/android/cards/CardNumber$Validated;", "getValidatedCardNumber$payments_core_release", "()Lcom/stripe/android/cards/CardNumber$Validated;", "getWorkContext", "()Lkotlin/coroutines/CoroutineContext;", "setWorkContext", "(Lkotlin/coroutines/CoroutineContext;)V", "calculateCursorPosition", "newFormattedLength", "start", "addedDigits", "calculateCursorPosition$payments_core_release", "onAttachedToWindow", "onCardMetadataLoadedTooSlow", "onCardMetadataLoadedTooSlow$payments_core_release", "onDetachedFromWindow", "updateLengthFilter", "maxLength", "updateLengthFilter$payments_core_release", "CardNumberTextWatcher", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardNumberEditText.kt */
public final class CardNumberEditText extends StripeEditText {
    public static final int $stable = 8;
    private final CardAccountRangeService accountRangeService;
    private final AnalyticsRequestExecutor analyticsRequestExecutor;
    private /* synthetic */ Function1<? super CardBrand, Unit> brandChangeCallback;
    /* access modifiers changed from: private */
    public final CardAccountRangeRepository cardAccountRangeRepository;
    private CardBrand cardBrand;
    private /* synthetic */ Function0<Unit> completionCallback;
    /* access modifiers changed from: private */
    public boolean isCardNumberValid;
    private /* synthetic */ Function1<? super Boolean, Unit> isLoadingCallback;
    private Job loadingJob;
    private final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    private final StaticCardAccountRanges staticCardAccountRanges;
    private CoroutineContext workContext;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardNumberEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardNumberEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getAccountRangeService$annotations() {
    }

    public static /* synthetic */ void getCardBrand$annotations() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardNumberEditText(Context context, AttributeSet attributeSet, int i, CoroutineContext coroutineContext, CardAccountRangeRepository cardAccountRangeRepository2, StaticCardAccountRanges staticCardAccountRanges2, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i, coroutineContext, cardAccountRangeRepository2, (i2 & 32) != 0 ? new DefaultStaticCardAccountRanges() : staticCardAccountRanges2, analyticsRequestExecutor2, paymentAnalyticsRequestFactory2);
    }

    public final CoroutineContext getWorkContext() {
        return this.workContext;
    }

    public final void setWorkContext(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<set-?>");
        this.workContext = coroutineContext;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardNumberEditText(Context context, AttributeSet attributeSet, int i, CoroutineContext coroutineContext, CardAccountRangeRepository cardAccountRangeRepository2, StaticCardAccountRanges staticCardAccountRanges2, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(cardAccountRangeRepository2, "cardAccountRangeRepository");
        Intrinsics.checkNotNullParameter(staticCardAccountRanges2, "staticCardAccountRanges");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        this.workContext = coroutineContext;
        this.cardAccountRangeRepository = cardAccountRangeRepository2;
        this.staticCardAccountRanges = staticCardAccountRanges2;
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory2;
        this.cardBrand = CardBrand.Unknown;
        this.brandChangeCallback = CardNumberEditText$brandChangeCallback$1.INSTANCE;
        this.completionCallback = CardNumberEditText$completionCallback$1.INSTANCE;
        this.accountRangeService = new CardAccountRangeService(cardAccountRangeRepository2, this.workContext, staticCardAccountRanges2, new CardNumberEditText$accountRangeService$1(this));
        this.isLoadingCallback = CardNumberEditText$isLoadingCallback$1.INSTANCE;
        setNumberOnlyInputType();
        setErrorMessage(getResources().getString(com.stripe.android.R.string.invalid_card_number));
        addTextChangedListener(new CardNumberTextWatcher(this));
        getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardNumberEditText.m4654_init_$lambda1(CardNumberEditText.this, view, z);
            }
        });
        if (Build.VERSION.SDK_INT >= 26) {
            setAutofillHints(new String[]{HintConstants.AUTOFILL_HINT_CREDIT_CARD_NUMBER});
        }
        updateLengthFilter$payments_core_release$default(this, 0, 1, (Object) null);
        setLayoutDirection(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardNumberEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardNumberEditText(final Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (CoroutineContext) Dispatchers.getIO(), (Function0<String>) new Function0<String>() {
            public final String invoke() {
                return PaymentConfiguration.Companion.getInstance(context).getPublishableKey();
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private CardNumberEditText(Context context, AttributeSet attributeSet, int i, CoroutineContext coroutineContext, Function0<String> function0) {
        this(context, attributeSet, i, coroutineContext, new DefaultCardAccountRangeRepositoryFactory(context).create(), new DefaultStaticCardAccountRanges(), new DefaultAnalyticsRequestExecutor(), new PaymentAnalyticsRequestFactory(context, new Provider() {
            public final Object get() {
                return CardNumberEditText.m4653_init_$lambda0(Function0.this);
            }
        }));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final String m4653_init_$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        return (String) function0.invoke();
    }

    public final CardBrand getCardBrand() {
        return this.cardBrand;
    }

    public final void setCardBrand$payments_core_release(CardBrand cardBrand2) {
        Intrinsics.checkNotNullParameter(cardBrand2, "value");
        CardBrand cardBrand3 = this.cardBrand;
        this.cardBrand = cardBrand2;
        if (cardBrand2 != cardBrand3) {
            this.brandChangeCallback.invoke(cardBrand2);
            updateLengthFilter$payments_core_release$default(this, 0, 1, (Object) null);
        }
    }

    public final Function1<CardBrand, Unit> getBrandChangeCallback$payments_core_release() {
        return this.brandChangeCallback;
    }

    public final void setBrandChangeCallback$payments_core_release(Function1<? super CardBrand, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.brandChangeCallback = function1;
        function1.invoke(this.cardBrand);
    }

    public final Function0<Unit> getCompletionCallback$payments_core_release() {
        return this.completionCallback;
    }

    public final void setCompletionCallback$payments_core_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.completionCallback = function0;
    }

    public final int getPanLength$payments_core_release() {
        AccountRange accountRange = this.accountRangeService.getAccountRange();
        Integer valueOf = accountRange == null ? null : Integer.valueOf(accountRange.getPanLength());
        if (valueOf != null) {
            return valueOf.intValue();
        }
        AccountRange first = this.accountRangeService.getStaticCardAccountRanges().first(getUnvalidatedCardNumber());
        if (first == null) {
            return 16;
        }
        return first.getPanLength();
    }

    private final int getFormattedPanLength() {
        return getPanLength$payments_core_release() + CardNumber.Companion.getSpacePositions(getPanLength$payments_core_release()).size();
    }

    public final boolean isCardNumberValid() {
        return this.isCardNumberValid;
    }

    public final CardNumber.Validated getValidatedCardNumber$payments_core_release() {
        return getUnvalidatedCardNumber().validate(getPanLength$payments_core_release());
    }

    /* access modifiers changed from: private */
    public final CardNumber.Unvalidated getUnvalidatedCardNumber() {
        return new CardNumber.Unvalidated(getFieldText$payments_core_release());
    }

    /* access modifiers changed from: private */
    public final boolean isValid() {
        return getValidatedCardNumber$payments_core_release() != null;
    }

    public final CardAccountRangeService getAccountRangeService() {
        return this.accountRangeService;
    }

    public final Function1<Boolean, Unit> isLoadingCallback$payments_core_release() {
        return this.isLoadingCallback;
    }

    public final void setLoadingCallback$payments_core_release(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.isLoadingCallback = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m4654_init_$lambda1(CardNumberEditText cardNumberEditText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardNumberEditText, "this$0");
        if (!z && cardNumberEditText.getUnvalidatedCardNumber().isPartialEntry(cardNumberEditText.getPanLength$payments_core_release())) {
            cardNumberEditText.setShouldShowError(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.loadingJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new CardNumberEditText$onAttachedToWindow$1(this, (Continuation<? super CardNumberEditText$onAttachedToWindow$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public String getAccessibilityText() {
        String string = getResources().getString(com.stripe.android.R.string.acc_label_card_number_node, new Object[]{getText()});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…l_card_number_node, text)");
        return string;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        Job job = this.loadingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loadingJob = null;
        this.accountRangeService.cancelAccountRangeRepositoryJob();
        super.onDetachedFromWindow();
    }

    public static /* synthetic */ void updateLengthFilter$payments_core_release$default(CardNumberEditText cardNumberEditText, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cardNumberEditText.getFormattedPanLength();
        }
        cardNumberEditText.updateLengthFilter$payments_core_release(i);
    }

    public final /* synthetic */ void updateLengthFilter$payments_core_release(int i) {
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    public static /* synthetic */ int calculateCursorPosition$payments_core_release$default(CardNumberEditText cardNumberEditText, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = cardNumberEditText.getPanLength$payments_core_release();
        }
        return cardNumberEditText.calculateCursorPosition$payments_core_release(i, i2, i3, i4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ int calculateCursorPosition$payments_core_release(int r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            com.stripe.android.cards.CardNumber$Companion r0 = com.stripe.android.cards.CardNumber.Companion
            java.util.Set r11 = r0.getSpacePositions(r11)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            boolean r0 = r11 instanceof java.util.Collection
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0019
            r3 = r11
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0019
            r4 = 0
            goto L_0x0041
        L_0x0019:
            java.util.Iterator r3 = r11.iterator()
            r4 = 0
        L_0x001e:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0041
            java.lang.Object r5 = r3.next()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r9 > r5) goto L_0x0036
            int r6 = r9 + r10
            if (r6 < r5) goto L_0x0036
            r5 = 1
            goto L_0x0037
        L_0x0036:
            r5 = 0
        L_0x0037:
            if (r5 == 0) goto L_0x001e
            int r4 = r4 + 1
            if (r4 >= 0) goto L_0x001e
            kotlin.collections.CollectionsKt.throwCountOverflow()
            goto L_0x001e
        L_0x0041:
            if (r0 == 0) goto L_0x004e
            r0 = r11
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x004e
        L_0x004c:
            r1 = 0
            goto L_0x006c
        L_0x004e:
            java.util.Iterator r11 = r11.iterator()
        L_0x0052:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x004c
            java.lang.Object r0 = r11.next()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r10 != 0) goto L_0x0069
            int r0 = r0 + r1
            if (r9 != r0) goto L_0x0069
            r0 = 1
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            if (r0 == 0) goto L_0x0052
        L_0x006c:
            int r9 = r9 + r10
            int r9 = r9 + r4
            if (r1 == 0) goto L_0x0074
            if (r9 <= 0) goto L_0x0074
            int r9 = r9 + -1
        L_0x0074:
            if (r9 > r8) goto L_0x0077
            r8 = r9
        L_0x0077:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.CardNumberEditText.calculateCursorPosition$payments_core_release(int, int, int, int):int");
    }

    public final /* synthetic */ void onCardMetadataLoadedTooSlow$payments_core_release() {
        this.analyticsRequestExecutor.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.CardMetadataLoadedTooSlow, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\f\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J*\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J(\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0004H\u0002J*\u0010\"\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\b¨\u0006$"}, d2 = {"Lcom/stripe/android/view/CardNumberEditText$CardNumberTextWatcher;", "Lcom/stripe/android/view/StripeTextWatcher;", "(Lcom/stripe/android/view/CardNumberEditText;)V", "beforeCardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "digitsAdded", "", "getDigitsAdded", "()Z", "formattedNumber", "", "isPastedPan", "latestChangeStart", "", "latestInsertionSize", "newCursorPosition", "Ljava/lang/Integer;", "shouldUpdateAfterChange", "getShouldUpdateAfterChange", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "isComplete", "wasCardNumberValid", "startPosition", "previousCount", "currentCount", "cardNumber", "onTextChanged", "before", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardNumberEditText.kt */
    private final class CardNumberTextWatcher extends StripeTextWatcher {
        private CardNumber.Unvalidated beforeCardNumber;
        private String formattedNumber;
        private boolean isPastedPan;
        private int latestChangeStart;
        private int latestInsertionSize;
        private Integer newCursorPosition;
        final /* synthetic */ CardNumberEditText this$0;

        public CardNumberTextWatcher(CardNumberEditText cardNumberEditText) {
            Intrinsics.checkNotNullParameter(cardNumberEditText, "this$0");
            this.this$0 = cardNumberEditText;
            this.beforeCardNumber = cardNumberEditText.getUnvalidatedCardNumber();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.isPastedPan = false;
            this.beforeCardNumber = this.this$0.getUnvalidatedCardNumber();
            this.latestChangeStart = i;
            this.latestInsertionSize = i3;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            String obj = charSequence == null ? null : charSequence.toString();
            if (obj == null) {
                obj = "";
            }
            CardNumber.Unvalidated unvalidated = new CardNumber.Unvalidated(obj);
            this.this$0.getAccountRangeService().onCardNumberChanged(unvalidated);
            boolean isPastedPan2 = isPastedPan(i, i2, i3, unvalidated);
            this.isPastedPan = isPastedPan2;
            if (isPastedPan2) {
                this.this$0.updateLengthFilter$payments_core_release(unvalidated.getFormatted(unvalidated.getLength()).length());
            }
            if (this.isPastedPan) {
                i4 = unvalidated.getLength();
            } else {
                i4 = this.this$0.getPanLength$payments_core_release();
            }
            CardNumberEditText cardNumberEditText = this.this$0;
            String formatted = unvalidated.getFormatted(i4);
            this.newCursorPosition = Integer.valueOf(cardNumberEditText.calculateCursorPosition$payments_core_release(formatted.length(), this.latestChangeStart, this.latestInsertionSize, i4));
            this.formattedNumber = formatted;
        }

        public void afterTextChanged(Editable editable) {
            if (getShouldUpdateAfterChange()) {
                this.this$0.setTextSilent$payments_core_release(this.formattedNumber);
                Integer num = this.newCursorPosition;
                if (num != null) {
                    CardNumberEditText cardNumberEditText = this.this$0;
                    cardNumberEditText.setSelection(RangesKt.coerceIn(num.intValue(), 0, cardNumberEditText.getFieldText$payments_core_release().length()));
                }
            }
            this.formattedNumber = null;
            this.newCursorPosition = null;
            if (this.this$0.getUnvalidatedCardNumber().getLength() == this.this$0.getPanLength$payments_core_release()) {
                boolean isCardNumberValid = this.this$0.isCardNumberValid();
                CardNumberEditText cardNumberEditText2 = this.this$0;
                cardNumberEditText2.isCardNumberValid = cardNumberEditText2.isValid();
                CardNumberEditText cardNumberEditText3 = this.this$0;
                cardNumberEditText3.setShouldShowError(!cardNumberEditText3.isValid());
                if (this.this$0.getAccountRangeService().getAccountRange() == null && this.this$0.getUnvalidatedCardNumber().isValidLuhn()) {
                    this.this$0.onCardMetadataLoadedTooSlow$payments_core_release();
                }
                if (isComplete(isCardNumberValid)) {
                    this.this$0.getCompletionCallback$payments_core_release().invoke();
                }
            } else if (!this.this$0.getUnvalidatedCardNumber().isPartialEntry(this.this$0.getPanLength$payments_core_release()) || this.this$0.getUnvalidatedCardNumber().isPossibleCardBrand()) {
                CardNumberEditText cardNumberEditText4 = this.this$0;
                cardNumberEditText4.isCardNumberValid = cardNumberEditText4.isValid();
                this.this$0.setShouldShowError(false);
            } else {
                CardNumberEditText cardNumberEditText5 = this.this$0;
                cardNumberEditText5.isCardNumberValid = cardNumberEditText5.isValid();
                this.this$0.setShouldShowError(true);
            }
        }

        private final boolean getShouldUpdateAfterChange() {
            return (getDigitsAdded() || !this.this$0.isLastKeyDelete()) && this.formattedNumber != null;
        }

        private final boolean getDigitsAdded() {
            return this.this$0.getUnvalidatedCardNumber().getLength() > this.beforeCardNumber.getLength();
        }

        private final boolean isComplete(boolean z) {
            return !z && (this.this$0.getUnvalidatedCardNumber().isMaxLength() || (this.this$0.isValid() && this.this$0.getAccountRangeService().getAccountRange() != null));
        }

        private final boolean isPastedPan(int i, int i2, int i3, CardNumber.Unvalidated unvalidated) {
            return i3 > i2 && i == 0 && unvalidated.getNormalized().length() >= 14;
        }
    }
}
