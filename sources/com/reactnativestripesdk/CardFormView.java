package com.reactnativestripesdk;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.stripe.android.databinding.CardMultilineWidgetBinding;
import com.stripe.android.databinding.StripeCardFormViewBinding;
import com.stripe.android.model.Address;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.view.CardInputListener;
import com.stripe.android.view.CardNumberEditText;
import com.stripe.android.view.CardValidCallback;
import com.stripe.android.view.CvcEditText;
import com.stripe.android.view.ExpiryDateEditText;
import com.stripe.android.view.PostalCodeEditText;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020 J\b\u0010$\u001a\u00020 H\u0016J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0018J\u000e\u0010'\u001a\u00020 2\u0006\u0010&\u001a\u00020(J\u000e\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0018J\b\u0010+\u001a\u00020 H\u0002J\u000e\u0010,\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/reactnativestripesdk/CardFormView;", "Landroid/widget/FrameLayout;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "cardAddress", "Lcom/stripe/android/model/Address;", "getCardAddress", "()Lcom/stripe/android/model/Address;", "setCardAddress", "(Lcom/stripe/android/model/Address;)V", "cardForm", "Lcom/stripe/android/view/CardFormView;", "cardFormViewBinding", "Lcom/stripe/android/databinding/StripeCardFormViewBinding;", "cardParams", "Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "getCardParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "setCardParams", "(Lcom/stripe/android/model/PaymentMethodCreateParams$Card;)V", "currentFocusedField", "", "dangerouslyGetFullCardDetails", "", "mEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "mLayoutRunnable", "Ljava/lang/Runnable;", "multilineWidgetBinding", "Lcom/stripe/android/databinding/CardMultilineWidgetBinding;", "onChangeFocus", "", "requestBlurFromJS", "requestClearFromJS", "requestFocusFromJS", "requestLayout", "setAutofocus", "value", "setCardStyle", "Lcom/facebook/react/bridge/ReadableMap;", "setDangerouslyGetFullCardDetails", "isEnabled", "setListeners", "setPostalCodeEnabled", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardFormView.kt */
public final class CardFormView extends FrameLayout {
    private Address cardAddress;
    private com.stripe.android.view.CardFormView cardForm;
    private final StripeCardFormViewBinding cardFormViewBinding;
    private PaymentMethodCreateParams.Card cardParams;
    private String currentFocusedField;
    private boolean dangerouslyGetFullCardDetails;
    private EventDispatcher mEventDispatcher;
    private final Runnable mLayoutRunnable;
    private final CardMultilineWidgetBinding multilineWidgetBinding;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CardFormView(com.facebook.react.uimanager.ThemedReactContext r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = r5
            android.content.Context r0 = (android.content.Context) r0
            r4.<init>(r0)
            com.stripe.android.view.CardFormView r1 = new com.stripe.android.view.CardFormView
            int r2 = com.reactnativestripesdk.R.style.StripeCardFormView_Borderless
            r3 = 0
            r1.<init>(r0, r3, r2)
            r4.cardForm = r1
            java.lang.Class<com.facebook.react.uimanager.UIManagerModule> r0 = com.facebook.react.uimanager.UIManagerModule.class
            com.facebook.react.bridge.NativeModule r5 = r5.getNativeModule(r0)
            com.facebook.react.uimanager.UIManagerModule r5 = (com.facebook.react.uimanager.UIManagerModule) r5
            if (r5 != 0) goto L_0x0020
            goto L_0x0024
        L_0x0020:
            com.facebook.react.uimanager.events.EventDispatcher r3 = r5.getEventDispatcher()
        L_0x0024:
            r4.mEventDispatcher = r3
            com.stripe.android.view.CardFormView r5 = r4.cardForm
            android.view.View r5 = (android.view.View) r5
            com.stripe.android.databinding.StripeCardFormViewBinding r5 = com.stripe.android.databinding.StripeCardFormViewBinding.bind(r5)
            java.lang.String r0 = "bind(cardForm)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r4.cardFormViewBinding = r5
            com.stripe.android.view.CardMultilineWidget r0 = r5.cardMultilineWidget
            android.view.View r0 = (android.view.View) r0
            com.stripe.android.databinding.CardMultilineWidgetBinding r0 = com.stripe.android.databinding.CardMultilineWidgetBinding.bind(r0)
            java.lang.String r1 = "bind(cardFormViewBinding.cardMultilineWidget)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r4.multilineWidgetBinding = r0
            com.google.android.material.card.MaterialCardView r0 = r5.cardMultilineWidgetContainer
            r1 = 1
            r0.setFocusable(r1)
            com.google.android.material.card.MaterialCardView r5 = r5.cardMultilineWidgetContainer
            r5.setFocusableInTouchMode(r1)
            com.stripe.android.view.CardFormView r5 = r4.cardForm
            android.view.View r5 = (android.view.View) r5
            r4.addView(r5)
            r4.setListeners()
            android.view.ViewTreeObserver r5 = r4.getViewTreeObserver()
            com.reactnativestripesdk.-$$Lambda$CardFormView$Egy7FRVx_HEKlYb1Z1Rriz3-UII r0 = new com.reactnativestripesdk.-$$Lambda$CardFormView$Egy7FRVx_HEKlYb1Z1Rriz3-UII
            r0.<init>()
            r5.addOnGlobalLayoutListener(r0)
            com.reactnativestripesdk.-$$Lambda$CardFormView$uA0bfivos-7tcvKatG7v7KSSL9A r5 = new com.reactnativestripesdk.-$$Lambda$CardFormView$uA0bfivos-7tcvKatG7v7KSSL9A
            r5.<init>()
            r4.mLayoutRunnable = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativestripesdk.CardFormView.<init>(com.facebook.react.uimanager.ThemedReactContext):void");
    }

    public final PaymentMethodCreateParams.Card getCardParams() {
        return this.cardParams;
    }

    public final void setCardParams(PaymentMethodCreateParams.Card card) {
        this.cardParams = card;
    }

    public final Address getCardAddress() {
        return this.cardAddress;
    }

    public final void setCardAddress(Address address) {
        this.cardAddress = address;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m4262_init_$lambda0(CardFormView cardFormView) {
        Intrinsics.checkNotNullParameter(cardFormView, "this$0");
        cardFormView.requestLayout();
    }

    public final void setPostalCodeEnabled(boolean z) {
        StripeCardFormViewBinding bind = StripeCardFormViewBinding.bind(this.cardForm);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(cardForm)");
        int i = z ? 0 : 8;
        bind.cardMultilineWidget.setPostalCodeRequired(false);
        bind.postalCodeContainer.setVisibility(i);
    }

    public final void setAutofocus(boolean z) {
        if (z) {
            CardNumberEditText cardNumberEditText = this.multilineWidgetBinding.etCardNumber;
            Intrinsics.checkNotNullExpressionValue(cardNumberEditText, "multilineWidgetBinding.etCardNumber");
            cardNumberEditText.requestFocus();
            ExtensionsKt.showSoftKeyboard(cardNumberEditText);
        }
    }

    public final void requestFocusFromJS() {
        CardNumberEditText cardNumberEditText = this.multilineWidgetBinding.etCardNumber;
        Intrinsics.checkNotNullExpressionValue(cardNumberEditText, "multilineWidgetBinding.etCardNumber");
        cardNumberEditText.requestFocus();
        ExtensionsKt.showSoftKeyboard(cardNumberEditText);
    }

    public final void requestBlurFromJS() {
        CardNumberEditText cardNumberEditText = this.multilineWidgetBinding.etCardNumber;
        Intrinsics.checkNotNullExpressionValue(cardNumberEditText, "multilineWidgetBinding.etCardNumber");
        ExtensionsKt.hideSoftKeyboard(cardNumberEditText);
        cardNumberEditText.clearFocus();
    }

    public final void requestClearFromJS() {
        this.multilineWidgetBinding.etCardNumber.setText("");
        this.multilineWidgetBinding.etCvc.setText("");
        this.multilineWidgetBinding.etExpiry.setText("");
        this.cardFormViewBinding.postalCode.setText("");
    }

    private final void onChangeFocus() {
        EventDispatcher eventDispatcher = this.mEventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new CardFocusEvent(getId(), this.currentFocusedField));
        }
    }

    public final void setCardStyle(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "value");
        StripeCardFormViewBinding bind = StripeCardFormViewBinding.bind(this.cardForm);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(cardForm)");
        String valOr = MappersKt.getValOr(readableMap, ViewProps.BACKGROUND_COLOR, (String) null);
        MaterialCardView materialCardView = bind.cardMultilineWidgetContainer;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        if (valOr != null) {
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(Color.parseColor(valOr)));
        }
        Unit unit = Unit.INSTANCE;
        materialCardView.setBackground(materialShapeDrawable);
    }

    public final void setDangerouslyGetFullCardDetails(boolean z) {
        this.dangerouslyGetFullCardDetails = z;
    }

    private final void setListeners() {
        this.cardForm.setCardValidCallback(new CardValidCallback() {
            public final void onInputChanged(boolean z, Set set) {
                CardFormView.m4266setListeners$lambda5(CardFormView.this, z, set);
            }
        });
        CardNumberEditText cardNumberEditText = this.multilineWidgetBinding.etCardNumber;
        Intrinsics.checkNotNullExpressionValue(cardNumberEditText, "multilineWidgetBinding.etCardNumber");
        CvcEditText cvcEditText = this.multilineWidgetBinding.etCvc;
        Intrinsics.checkNotNullExpressionValue(cvcEditText, "multilineWidgetBinding.etCvc");
        ExpiryDateEditText expiryDateEditText = this.multilineWidgetBinding.etExpiry;
        Intrinsics.checkNotNullExpressionValue(expiryDateEditText, "multilineWidgetBinding.etExpiry");
        PostalCodeEditText postalCodeEditText = this.cardFormViewBinding.postalCode;
        Intrinsics.checkNotNullExpressionValue(postalCodeEditText, "cardFormViewBinding.postalCode");
        cardNumberEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardFormView.m4267setListeners$lambda6(CardFormView.this, view, z);
            }
        });
        cvcEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardFormView.m4268setListeners$lambda7(CardFormView.this, view, z);
            }
        });
        expiryDateEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardFormView.m4269setListeners$lambda8(CardFormView.this, view, z);
            }
        });
        postalCodeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardFormView.m4270setListeners$lambda9(CardFormView.this, view, z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-5  reason: not valid java name */
    public static final void m4266setListeners$lambda5(CardFormView cardFormView, boolean z, Set set) {
        String str;
        String country;
        Intrinsics.checkNotNullParameter(cardFormView, "this$0");
        Intrinsics.checkNotNullParameter(set, "$noName_1");
        String str2 = null;
        if (z) {
            CardParams cardParams2 = cardFormView.cardForm.getCardParams();
            if (cardParams2 != null) {
                Object obj = cardParams2.toParamMap().get("card");
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.util.HashMap<*, *>{ kotlin.collections.TypeAliasesKt.HashMap<*, *> }");
                Pair[] pairArr = new Pair[6];
                Map map = (HashMap) obj;
                Object obj2 = map.get("exp_month");
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                pairArr[0] = TuplesKt.to("expiryMonth", Integer.valueOf(((Integer) obj2).intValue()));
                Object obj3 = map.get("exp_year");
                Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                pairArr[1] = TuplesKt.to("expiryYear", Integer.valueOf(((Integer) obj3).intValue()));
                pairArr[2] = TuplesKt.to("last4", cardParams2.getLast4());
                pairArr[3] = TuplesKt.to(AccountRangeJsonParser.FIELD_BRAND, MappersKt.mapCardBrand(cardParams2.getBrand()));
                Address address = cardParams2.getAddress();
                String str3 = "";
                if (address == null || (str = address.getPostalCode()) == null) {
                    str = str3;
                }
                pairArr[4] = TuplesKt.to("postalCode", str);
                Address address2 = cardParams2.getAddress();
                if (!(address2 == null || (country = address2.getCountry()) == null)) {
                    str3 = country;
                }
                pairArr[5] = TuplesKt.to("country", str3);
                Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
                if (cardFormView.dangerouslyGetFullCardDetails) {
                    Object obj4 = map.get("number");
                    Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.String");
                    mutableMapOf.put("number", (String) obj4);
                }
                EventDispatcher eventDispatcher = cardFormView.mEventDispatcher;
                if (eventDispatcher != null) {
                    eventDispatcher.dispatchEvent(new CardFormCompleteEvent(cardFormView.getId(), mutableMapOf, z, cardFormView.dangerouslyGetFullCardDetails));
                }
                Address.Builder builder = new Address.Builder();
                Address address3 = cardParams2.getAddress();
                Address.Builder postalCode = builder.setPostalCode(address3 == null ? null : address3.getPostalCode());
                Address address4 = cardParams2.getAddress();
                if (address4 != null) {
                    str2 = address4.getCountry();
                }
                cardFormView.setCardAddress(postalCode.setCountry(str2).build());
                StripeCardFormViewBinding bind = StripeCardFormViewBinding.bind(cardFormView.cardForm);
                Intrinsics.checkNotNullExpressionValue(bind, "bind(cardForm)");
                PaymentMethodCreateParams.Card paymentMethodCard = bind.cardMultilineWidget.getPaymentMethodCard();
                if (paymentMethodCard != null) {
                    cardFormView.setCardParams(paymentMethodCard);
                    return;
                }
                return;
            }
            return;
        }
        cardFormView.setCardParams((PaymentMethodCreateParams.Card) null);
        cardFormView.setCardAddress((Address) null);
        EventDispatcher eventDispatcher2 = cardFormView.mEventDispatcher;
        if (eventDispatcher2 != null) {
            eventDispatcher2.dispatchEvent(new CardFormCompleteEvent(cardFormView.getId(), (Map<String, Object>) null, z, cardFormView.dangerouslyGetFullCardDetails));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-6  reason: not valid java name */
    public static final void m4267setListeners$lambda6(CardFormView cardFormView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardFormView, "this$0");
        cardFormView.currentFocusedField = z ? CardInputListener.FocusField.CardNumber.toString() : null;
        cardFormView.onChangeFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-7  reason: not valid java name */
    public static final void m4268setListeners$lambda7(CardFormView cardFormView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardFormView, "this$0");
        cardFormView.currentFocusedField = z ? CardInputListener.FocusField.Cvc.toString() : null;
        cardFormView.onChangeFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-8  reason: not valid java name */
    public static final void m4269setListeners$lambda8(CardFormView cardFormView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardFormView, "this$0");
        cardFormView.currentFocusedField = z ? CardInputListener.FocusField.ExpiryDate.toString() : null;
        cardFormView.onChangeFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-9  reason: not valid java name */
    public static final void m4270setListeners$lambda9(CardFormView cardFormView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardFormView, "this$0");
        cardFormView.currentFocusedField = z ? CardInputListener.FocusField.PostalCode.toString() : null;
        cardFormView.onChangeFocus();
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.mLayoutRunnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: mLayoutRunnable$lambda-10  reason: not valid java name */
    public static final void m4265mLayoutRunnable$lambda10(CardFormView cardFormView) {
        Intrinsics.checkNotNullParameter(cardFormView, "this$0");
        cardFormView.measure(View.MeasureSpec.makeMeasureSpec(cardFormView.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(cardFormView.getHeight(), BasicMeasure.EXACTLY));
        cardFormView.layout(cardFormView.getLeft(), cardFormView.getTop(), cardFormView.getRight(), cardFormView.getBottom());
    }
}
