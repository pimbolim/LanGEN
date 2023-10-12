package com.reactnativestripesdk;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.braintreepayments.api.models.BinData;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.henninghall.date_picker.props.TextColorProp;
import com.stripe.android.databinding.CardInputWidgetBinding;
import com.stripe.android.model.Address;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.view.CardInputListener;
import com.stripe.android.view.CardInputWidget;
import com.stripe.android.view.CardNumberEditText;
import com.stripe.android.view.CardValidCallback;
import com.stripe.android.view.CvcEditText;
import com.stripe.android.view.ExpiryDateEditText;
import com.stripe.android.view.PostalCodeEditText;
import com.stripe.android.view.StripeEditText;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fJ\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0006\u0010&\u001a\u00020$J\u0006\u0010'\u001a\u00020$J\u0006\u0010(\u001a\u00020$J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020$H\u0002J\u000e\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u001bJ\u000e\u0010-\u001a\u00020$2\u0006\u0010,\u001a\u00020.J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u001bJ\b\u00101\u001a\u00020$H\u0002J\u000e\u00102\u001a\u00020$2\u0006\u0010,\u001a\u00020.J\u000e\u00103\u001a\u00020$2\u0006\u00100\u001a\u00020\u001bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/reactnativestripesdk/CardFieldView;", "Landroid/widget/FrameLayout;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "cardAddress", "Lcom/stripe/android/model/Address;", "getCardAddress", "()Lcom/stripe/android/model/Address;", "setCardAddress", "(Lcom/stripe/android/model/Address;)V", "cardDetails", "", "", "", "getCardDetails", "()Ljava/util/Map;", "cardInputWidgetBinding", "Lcom/stripe/android/databinding/CardInputWidgetBinding;", "cardParams", "Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "getCardParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "setCardParams", "(Lcom/stripe/android/model/PaymentMethodCreateParams$Card;)V", "currentFocusedField", "dangerouslyGetFullCardDetails", "", "mCardWidget", "Lcom/stripe/android/view/CardInputWidget;", "mEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "mLayoutRunnable", "Ljava/lang/Runnable;", "getValue", "onChangeFocus", "", "onValidCardChange", "requestBlurFromJS", "requestClearFromJS", "requestFocusFromJS", "requestLayout", "sendCardDetailsEvent", "setAutofocus", "value", "setCardStyle", "Lcom/facebook/react/bridge/ReadableMap;", "setDangerouslyGetFullCardDetails", "isEnabled", "setListeners", "setPlaceHolders", "setPostalCodeEnabled", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardFieldView.kt */
public final class CardFieldView extends FrameLayout {
    private Address cardAddress;
    private final Map<String, Object> cardDetails = MapsKt.mutableMapOf(TuplesKt.to(AccountRangeJsonParser.FIELD_BRAND, ""), TuplesKt.to("last4", ""), TuplesKt.to("expiryMonth", null), TuplesKt.to("expiryYear", null), TuplesKt.to("postalCode", ""), TuplesKt.to("validNumber", BinData.UNKNOWN), TuplesKt.to("validCVC", BinData.UNKNOWN), TuplesKt.to("validExpiryDate", BinData.UNKNOWN));
    private final CardInputWidgetBinding cardInputWidgetBinding;
    private PaymentMethodCreateParams.Card cardParams;
    private String currentFocusedField;
    /* access modifiers changed from: private */
    public boolean dangerouslyGetFullCardDetails;
    private CardInputWidget mCardWidget;
    private EventDispatcher mEventDispatcher;
    private final Runnable mLayoutRunnable;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CardFieldView(com.facebook.react.uimanager.ThemedReactContext r8) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r2 = r8
            android.content.Context r2 = (android.content.Context) r2
            r7.<init>(r2)
            com.stripe.android.view.CardInputWidget r0 = new com.stripe.android.view.CardInputWidget
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            r7.mCardWidget = r0
            android.view.View r0 = (android.view.View) r0
            com.stripe.android.databinding.CardInputWidgetBinding r0 = com.stripe.android.databinding.CardInputWidgetBinding.bind(r0)
            java.lang.String r1 = "bind(mCardWidget)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r7.cardInputWidgetBinding = r0
            r1 = 8
            kotlin.Pair[] r1 = new kotlin.Pair[r1]
            java.lang.String r2 = "brand"
            java.lang.String r3 = ""
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            r1[r4] = r2
            java.lang.String r2 = "last4"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            r4 = 1
            r1[r4] = r2
            java.lang.String r2 = "expiryMonth"
            r5 = 0
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r6 = 2
            r1[r6] = r2
            java.lang.String r2 = "expiryYear"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r6 = 3
            r1[r6] = r2
            java.lang.String r2 = "postalCode"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            r3 = 4
            r1[r3] = r2
            java.lang.String r2 = "validNumber"
            java.lang.String r3 = "Unknown"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            r6 = 5
            r1[r6] = r2
            java.lang.String r2 = "validCVC"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            r6 = 6
            r1[r6] = r2
            java.lang.String r2 = "validExpiryDate"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            r3 = 7
            r1[r3] = r2
            java.util.Map r1 = kotlin.collections.MapsKt.mutableMapOf(r1)
            r7.cardDetails = r1
            java.lang.Class<com.facebook.react.uimanager.UIManagerModule> r1 = com.facebook.react.uimanager.UIManagerModule.class
            com.facebook.react.bridge.NativeModule r8 = r8.getNativeModule(r1)
            com.facebook.react.uimanager.UIManagerModule r8 = (com.facebook.react.uimanager.UIManagerModule) r8
            if (r8 != 0) goto L_0x0085
            goto L_0x0089
        L_0x0085:
            com.facebook.react.uimanager.events.EventDispatcher r5 = r8.getEventDispatcher()
        L_0x0089:
            r7.mEventDispatcher = r5
            android.widget.FrameLayout r8 = r0.container
            r8.setFocusable(r4)
            android.widget.FrameLayout r8 = r0.container
            r8.setFocusableInTouchMode(r4)
            android.widget.FrameLayout r8 = r0.container
            r8.requestFocus()
            com.stripe.android.view.CardInputWidget r8 = r7.mCardWidget
            android.view.View r8 = (android.view.View) r8
            r7.addView(r8)
            r7.setListeners()
            android.view.ViewTreeObserver r8 = r7.getViewTreeObserver()
            com.reactnativestripesdk.-$$Lambda$CardFieldView$8-vQ9VOqED30sskusAML1V0ptIg r0 = new com.reactnativestripesdk.-$$Lambda$CardFieldView$8-vQ9VOqED30sskusAML1V0ptIg
            r0.<init>()
            r8.addOnGlobalLayoutListener(r0)
            com.reactnativestripesdk.-$$Lambda$CardFieldView$QKF9bxKogjzkbSltsabzfxDGrMI r8 = new com.reactnativestripesdk.-$$Lambda$CardFieldView$QKF9bxKogjzkbSltsabzfxDGrMI
            r8.<init>()
            r7.mLayoutRunnable = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativestripesdk.CardFieldView.<init>(com.facebook.react.uimanager.ThemedReactContext):void");
    }

    public final Map<String, Object> getCardDetails() {
        return this.cardDetails;
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
    public static final void m4253_init_$lambda0(CardFieldView cardFieldView) {
        Intrinsics.checkNotNullParameter(cardFieldView, "this$0");
        cardFieldView.requestLayout();
    }

    public final void setAutofocus(boolean z) {
        if (z) {
            this.cardInputWidgetBinding.cardNumberEditText.requestFocus();
            CardNumberEditText cardNumberEditText = this.cardInputWidgetBinding.cardNumberEditText;
            Intrinsics.checkNotNullExpressionValue(cardNumberEditText, "cardInputWidgetBinding.cardNumberEditText");
            ExtensionsKt.showSoftKeyboard(cardNumberEditText);
        }
    }

    public final void requestFocusFromJS() {
        this.cardInputWidgetBinding.cardNumberEditText.requestFocus();
        CardNumberEditText cardNumberEditText = this.cardInputWidgetBinding.cardNumberEditText;
        Intrinsics.checkNotNullExpressionValue(cardNumberEditText, "cardInputWidgetBinding.cardNumberEditText");
        ExtensionsKt.showSoftKeyboard(cardNumberEditText);
    }

    public final void requestBlurFromJS() {
        CardNumberEditText cardNumberEditText = this.cardInputWidgetBinding.cardNumberEditText;
        Intrinsics.checkNotNullExpressionValue(cardNumberEditText, "cardInputWidgetBinding.cardNumberEditText");
        ExtensionsKt.hideSoftKeyboard(cardNumberEditText);
        this.cardInputWidgetBinding.cardNumberEditText.clearFocus();
        this.cardInputWidgetBinding.container.requestFocus();
    }

    public final void requestClearFromJS() {
        this.cardInputWidgetBinding.cardNumberEditText.setText("");
        this.cardInputWidgetBinding.cvcEditText.setText("");
        this.cardInputWidgetBinding.expiryDateEditText.setText("");
        if (this.mCardWidget.getPostalCodeEnabled()) {
            this.cardInputWidgetBinding.postalCodeEditText.setText("");
        }
    }

    private final void onChangeFocus() {
        EventDispatcher eventDispatcher = this.mEventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new CardFocusEvent(getId(), this.currentFocusedField));
        }
    }

    public final void setCardStyle(ReadableMap readableMap) {
        ReadableMap readableMap2 = readableMap;
        Intrinsics.checkNotNullParameter(readableMap2, "value");
        Integer intOrNull = MappersKt.getIntOrNull(readableMap2, ViewProps.BORDER_WIDTH);
        String valOr = MappersKt.getValOr(readableMap2, ViewProps.BACKGROUND_COLOR, (String) null);
        String valOr2 = MappersKt.getValOr(readableMap2, ViewProps.BORDER_COLOR, (String) null);
        Integer intOrNull2 = MappersKt.getIntOrNull(readableMap2, ViewProps.BORDER_RADIUS);
        int intValue = intOrNull2 == null ? 0 : intOrNull2.intValue();
        String valOr3 = MappersKt.getValOr(readableMap2, TextColorProp.name, (String) null);
        Integer intOrNull3 = MappersKt.getIntOrNull(readableMap2, ViewProps.FONT_SIZE);
        String valOr$default = MappersKt.getValOr$default(readableMap2, ViewProps.FONT_FAMILY, (String) null, 4, (Object) null);
        String valOr4 = MappersKt.getValOr(readableMap2, "placeholderColor", (String) null);
        String valOr5 = MappersKt.getValOr(readableMap2, "textErrorColor", (String) null);
        String valOr6 = MappersKt.getValOr(readableMap2, "cursorColor", (String) null);
        CardNumberEditText cardNumberEditText = this.cardInputWidgetBinding.cardNumberEditText;
        Intrinsics.checkNotNullExpressionValue(cardNumberEditText, "cardInputWidgetBinding.cardNumberEditText");
        CvcEditText cvcEditText = this.cardInputWidgetBinding.cvcEditText;
        Intrinsics.checkNotNullExpressionValue(cvcEditText, "cardInputWidgetBinding.cvcEditText");
        ExpiryDateEditText expiryDateEditText = this.cardInputWidgetBinding.expiryDateEditText;
        Intrinsics.checkNotNullExpressionValue(expiryDateEditText, "cardInputWidgetBinding.expiryDateEditText");
        PostalCodeEditText postalCodeEditText = this.cardInputWidgetBinding.postalCodeEditText;
        Intrinsics.checkNotNullExpressionValue(postalCodeEditText, "cardInputWidgetBinding.postalCodeEditText");
        Set<StripeEditText> of = SetsKt.setOf(cardNumberEditText, cvcEditText, expiryDateEditText, postalCodeEditText);
        if (valOr3 != null) {
            for (StripeEditText textColor : of) {
                textColor.setTextColor(Color.parseColor(valOr3));
            }
        }
        if (valOr5 != null) {
            for (StripeEditText errorColor : of) {
                errorColor.setErrorColor(Color.parseColor(valOr5));
            }
        }
        if (valOr4 != null) {
            for (StripeEditText hintTextColor : of) {
                hintTextColor.setHintTextColor(Color.parseColor(valOr4));
            }
        }
        if (intOrNull3 != null) {
            int intValue2 = intOrNull3.intValue();
            for (StripeEditText textSize : of) {
                textSize.setTextSize((float) intValue2);
            }
        }
        if (valOr$default != null) {
            for (StripeEditText typeface : of) {
                typeface.setTypeface(Typeface.create(valOr$default, 0));
            }
        }
        if (valOr6 != null && Build.VERSION.SDK_INT >= 29) {
            int parseColor = Color.parseColor(valOr6);
            for (StripeEditText stripeEditText : of) {
                Drawable textCursorDrawable = stripeEditText.getTextCursorDrawable();
                if (textCursorDrawable != null) {
                    textCursorDrawable.setTint(parseColor);
                }
                Drawable textSelectHandle = stripeEditText.getTextSelectHandle();
                if (textSelectHandle != null) {
                    textSelectHandle.setTint(parseColor);
                }
                Drawable textSelectHandleLeft = stripeEditText.getTextSelectHandleLeft();
                if (textSelectHandleLeft != null) {
                    textSelectHandleLeft.setTint(parseColor);
                }
                Drawable textSelectHandleRight = stripeEditText.getTextSelectHandleRight();
                if (textSelectHandleRight != null) {
                    textSelectHandleRight.setTint(parseColor);
                }
                stripeEditText.setHighlightColor(parseColor);
            }
        }
        this.mCardWidget.setPadding(40, 0, 40, 0);
        CardInputWidget cardInputWidget = this.mCardWidget;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel().toBuilder().setAllCorners(0, (float) (intValue * 2)).build());
        materialShapeDrawable.setStrokeWidth(0.0f);
        materialShapeDrawable.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#000000")));
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        if (intOrNull != null) {
            materialShapeDrawable.setStrokeWidth((float) (intOrNull.intValue() * 2));
        }
        if (valOr2 != null) {
            materialShapeDrawable.setStrokeColor(ColorStateList.valueOf(Color.parseColor(valOr2)));
        }
        if (valOr != null) {
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(Color.parseColor(valOr)));
        }
        Unit unit = Unit.INSTANCE;
        cardInputWidget.setBackground(materialShapeDrawable);
    }

    public final void setPlaceHolders(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "value");
        String valOr = MappersKt.getValOr(readableMap, "number", (String) null);
        String valOr2 = MappersKt.getValOr(readableMap, "expiration", (String) null);
        String valOr3 = MappersKt.getValOr(readableMap, "cvc", (String) null);
        String valOr4 = MappersKt.getValOr(readableMap, "postalCode", (String) null);
        if (valOr != null) {
            this.cardInputWidgetBinding.cardNumberEditText.setHint(valOr);
        }
        if (valOr2 != null) {
            this.cardInputWidgetBinding.expiryDateEditText.setHint(valOr2);
        }
        if (valOr3 != null) {
            this.mCardWidget.setCvcLabel(valOr3);
        }
        if (valOr4 != null) {
            this.cardInputWidgetBinding.postalCodeEditText.setHint(valOr4);
        }
    }

    public final void setDangerouslyGetFullCardDetails(boolean z) {
        this.dangerouslyGetFullCardDetails = z;
    }

    public final void setPostalCodeEnabled(boolean z) {
        this.mCardWidget.setPostalCodeEnabled(z);
    }

    public final Map<String, Object> getValue() {
        return this.cardDetails;
    }

    private final void onValidCardChange() {
        Unit unit;
        Unit unit2;
        PaymentMethodCreateParams.Card paymentMethodCard = this.mCardWidget.getPaymentMethodCard();
        if (paymentMethodCard == null) {
            unit = null;
        } else {
            setCardParams(paymentMethodCard);
            setCardAddress(new Address.Builder().setPostalCode((String) getCardDetails().get("postalCode")).build());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CardFieldView cardFieldView = this;
            cardFieldView.setCardParams((PaymentMethodCreateParams.Card) null);
            cardFieldView.setCardAddress((Address) null);
        }
        CardParams cardParams2 = this.mCardWidget.getCardParams();
        if (cardParams2 == null) {
            unit2 = null;
        } else {
            getCardDetails().put(AccountRangeJsonParser.FIELD_BRAND, MappersKt.mapCardBrand(cardParams2.getBrand()));
            getCardDetails().put("last4", cardParams2.getLast4());
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            CardFieldView cardFieldView2 = this;
            cardFieldView2.getCardDetails().put(AccountRangeJsonParser.FIELD_BRAND, (Object) null);
            cardFieldView2.getCardDetails().put("last4", (Object) null);
        }
        sendCardDetailsEvent();
    }

    /* access modifiers changed from: private */
    public final void sendCardDetailsEvent() {
        EventDispatcher eventDispatcher = this.mEventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new CardChangedEvent(getId(), this.cardDetails, this.mCardWidget.getPostalCodeEnabled(), this.cardParams != null, this.dangerouslyGetFullCardDetails));
        }
    }

    private final void setListeners() {
        this.cardInputWidgetBinding.cardNumberEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardFieldView.m4257setListeners$lambda19(CardFieldView.this, view, z);
            }
        });
        this.cardInputWidgetBinding.expiryDateEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardFieldView.m4258setListeners$lambda20(CardFieldView.this, view, z);
            }
        });
        this.cardInputWidgetBinding.cvcEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardFieldView.m4259setListeners$lambda21(CardFieldView.this, view, z);
            }
        });
        this.cardInputWidgetBinding.postalCodeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardFieldView.m4260setListeners$lambda22(CardFieldView.this, view, z);
            }
        });
        this.mCardWidget.setCardValidCallback(new CardValidCallback() {
            public final void onInputChanged(boolean z, Set set) {
                CardFieldView.m4261setListeners$lambda23(CardFieldView.this, z, set);
            }
        });
        this.mCardWidget.setCardInputListener(new CardFieldView$setListeners$6());
        this.mCardWidget.setExpiryDateTextWatcher(new CardFieldView$setListeners$7(this));
        this.mCardWidget.setPostalCodeTextWatcher(new CardFieldView$setListeners$8(this));
        this.mCardWidget.setCardNumberTextWatcher(new CardFieldView$setListeners$9(this));
        this.mCardWidget.setCvcNumberTextWatcher(new CardFieldView$setListeners$10(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-19  reason: not valid java name */
    public static final void m4257setListeners$lambda19(CardFieldView cardFieldView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardFieldView, "this$0");
        cardFieldView.currentFocusedField = z ? CardInputListener.FocusField.CardNumber.name() : null;
        cardFieldView.onChangeFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-20  reason: not valid java name */
    public static final void m4258setListeners$lambda20(CardFieldView cardFieldView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardFieldView, "this$0");
        cardFieldView.currentFocusedField = z ? CardInputListener.FocusField.ExpiryDate.name() : null;
        cardFieldView.onChangeFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-21  reason: not valid java name */
    public static final void m4259setListeners$lambda21(CardFieldView cardFieldView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardFieldView, "this$0");
        cardFieldView.currentFocusedField = z ? CardInputListener.FocusField.Cvc.name() : null;
        cardFieldView.onChangeFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-22  reason: not valid java name */
    public static final void m4260setListeners$lambda22(CardFieldView cardFieldView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardFieldView, "this$0");
        cardFieldView.currentFocusedField = z ? CardInputListener.FocusField.PostalCode.name() : null;
        cardFieldView.onChangeFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: setListeners$lambda-23  reason: not valid java name */
    public static final void m4261setListeners$lambda23(CardFieldView cardFieldView, boolean z, Set set) {
        String str;
        Intrinsics.checkNotNullParameter(cardFieldView, "this$0");
        Intrinsics.checkNotNullParameter(set, "invalidFields");
        String str2 = "Invalid";
        cardFieldView.getCardDetails().put("validNumber", set.contains(CardValidCallback.Fields.Number) ? str2 : "Valid");
        Map<String, Object> cardDetails2 = cardFieldView.getCardDetails();
        if (set.contains(CardValidCallback.Fields.Cvc)) {
            str = str2;
        } else {
            str = "Valid";
        }
        cardDetails2.put("validCVC", str);
        Map<String, Object> cardDetails3 = cardFieldView.getCardDetails();
        if (!set.contains(CardValidCallback.Fields.Expiry)) {
            str2 = "Valid";
        }
        cardDetails3.put("validExpiryDate", str2);
        if (z) {
            cardFieldView.onValidCardChange();
            return;
        }
        cardFieldView.setCardParams((PaymentMethodCreateParams.Card) null);
        cardFieldView.setCardAddress((Address) null);
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.mLayoutRunnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: mLayoutRunnable$lambda-24  reason: not valid java name */
    public static final void m4256mLayoutRunnable$lambda24(CardFieldView cardFieldView) {
        Intrinsics.checkNotNullParameter(cardFieldView, "this$0");
        cardFieldView.measure(View.MeasureSpec.makeMeasureSpec(cardFieldView.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(cardFieldView.getHeight(), BasicMeasure.EXACTLY));
        cardFieldView.layout(cardFieldView.getLeft(), cardFieldView.getTop(), cardFieldView.getRight(), cardFieldView.getBottom());
    }
}
