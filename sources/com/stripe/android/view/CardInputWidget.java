package com.stripe.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import com.braintreepayments.api.models.PostalAddressParser;
import com.google.android.material.textfield.TextInputLayout;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.stripe.android.R;
import com.stripe.android.cards.CardNumber;
import com.stripe.android.cards.Cvc;
import com.stripe.android.databinding.CardInputWidgetBinding;
import com.stripe.android.model.Address;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.ExpirationDate;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.view.CardInputListener;
import com.stripe.android.view.PostalCodeEditText;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010#\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001(\b\u0007\u0018\u0000 Ý\u00012\u00020\u00012\u00020\u0002:\u001cÙ\u0001Ú\u0001Û\u0001Ü\u0001Ý\u0001Þ\u0001ß\u0001à\u0001á\u0001â\u0001ã\u0001ä\u0001å\u0001æ\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u0018\u0010\u0001\u001a\u0002032\u0007\u0010\u0001\u001a\u00020\bH\u0001¢\u0006\u0003\b\u0001J\u001b\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u0002032\u0007\u0010\u0001\u001a\u00020\fH\u0002J\u001d\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\b2\u0006\u0010E\u001a\u00020\bH\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\t\u0010\u0001\u001a\u00020VH\u0016J\t\u0010 \u0001\u001a\u00020VH\u0002J\n\u0010¡\u0001\u001a\u00030\u0001H\u0014J\u0013\u0010¢\u0001\u001a\u00020V2\b\u0010£\u0001\u001a\u00030¤\u0001H\u0016J7\u0010¥\u0001\u001a\u00030\u00012\u0007\u0010¦\u0001\u001a\u00020V2\u0007\u0010§\u0001\u001a\u00020\b2\u0007\u0010¨\u0001\u001a\u00020\b2\u0007\u0010©\u0001\u001a\u00020\b2\u0007\u0010ª\u0001\u001a\u00020\bH\u0014J\u0014\u0010«\u0001\u001a\u00030\u00012\b\u0010¬\u0001\u001a\u00030­\u0001H\u0014J\n\u0010®\u0001\u001a\u00030­\u0001H\u0014J\n\u0010¯\u0001\u001a\u00030\u0001H\u0002J\n\u0010°\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010±\u0001\u001a\u00030\u00012\u0007\u0010²\u0001\u001a\u000203H\u0016J\u0015\u0010³\u0001\u001a\u00030\u00012\t\u0010´\u0001\u001a\u0004\u0018\u00010\u001aH\u0016J\u0015\u0010µ\u0001\u001a\u00030\u00012\t\u0010¶\u0001\u001a\u0004\u0018\u000103H\u0016J\u0016\u0010·\u0001\u001a\u00030\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\u0015\u0010º\u0001\u001a\u00030\u00012\t\u0010»\u0001\u001a\u0004\u0018\u00010&H\u0016J\u0015\u0010¼\u0001\u001a\u00030\u00012\t\u0010½\u0001\u001a\u0004\u0018\u000103H\u0016J\u0013\u0010¾\u0001\u001a\u00030\u00012\t\u0010¿\u0001\u001a\u0004\u0018\u000103J\u0016\u0010À\u0001\u001a\u00030\u00012\n\u0010Á\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\u0013\u0010Â\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020VH\u0016J \u0010Ã\u0001\u001a\u00030\u00012\t\b\u0001\u0010Ä\u0001\u001a\u00020\b2\t\b\u0001\u0010Å\u0001\u001a\u00020\bH\u0016J\u0016\u0010Æ\u0001\u001a\u00030\u00012\n\u0010Ç\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\u001b\u0010È\u0001\u001a\u00030\u00012\t\u0010É\u0001\u001a\u0004\u0018\u000103H\u0000¢\u0006\u0003\bÊ\u0001J\u0016\u0010Ë\u0001\u001a\u00030\u00012\n\u0010Ì\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\u001a\u0010Í\u0001\u001a\u00030\u00012\u000e\u0010Î\u0001\u001a\t\u0012\u0005\u0012\u00030Ï\u00010-H\u0002J\n\u0010Ð\u0001\u001a\u00030\u0001H\u0002J&\u0010Ñ\u0001\u001a\u00030\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0007\u0010Ô\u0001\u001a\u00020\b2\u0007\u0010Õ\u0001\u001a\u00020\bH\u0002J\n\u0010Ö\u0001\u001a\u00030\u0001H\u0002J,\u0010×\u0001\u001a\u00030\u00012\u0006\u0010U\u001a\u00020V2\b\b\u0002\u0010H\u001a\u00020\b2\b\b\u0002\u0010E\u001a\u00020\bH\u0001¢\u0006\u0003\bØ\u0001R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R \u0010,\u001a\b\u0012\u0004\u0012\u00020\f0-8@X\u0004¢\u0006\f\u0012\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\u0004\u0018\u0001058BX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u000209X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u0002038BX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020AX\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010GR \u0010J\u001a\b\u0012\u0004\u0012\u00020\b0KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u000e\u0010P\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u000e\u0010[\u001a\u00020VX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\\\u001a\u00020]X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010b\u001a\u0004\u0018\u00010c8VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0016\u0010f\u001a\u0004\u0018\u00010g8VX\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0014\u0010j\u001a\u0002038BX\u0004¢\u0006\u0006\u001a\u0004\bk\u0010?R\u0014\u0010l\u001a\u00020mX\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0014\u0010p\u001a\u00020qX\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR+\u0010u\u001a\u00020V2\u0006\u0010t\u001a\u00020V8F@FX\u0002¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bv\u0010X\"\u0004\bw\u0010ZR+\u0010z\u001a\u00020V2\u0006\u0010t\u001a\u00020V8F@FX\u0002¢\u0006\u0012\n\u0004\b}\u0010y\u001a\u0004\b{\u0010X\"\u0004\b|\u0010ZR\u0015\u0010~\u001a\u00020 X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0010\u0001R\u0018\u0010\u0001\u001a\u0004\u0018\u0001038BX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010?R&\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u00018\u0000X\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0001\u0010/\u001a\u0005\b\u0001\u0010TR1\u0010\u0001\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020V8\u0000@BX\u000e¢\u0006\u0017\n\u0000\u0012\u0005\b\u0001\u0010/\u001a\u0005\b\u0001\u0010X\"\u0005\b\u0001\u0010ZR/\u0010\u0001\u001a\u00020V2\u0006\u0010t\u001a\u00020V8F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010y\u001a\u0005\b\u0001\u0010X\"\u0005\b\u0001\u0010ZR\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006ç\u0001"}, d2 = {"Lcom/stripe/android/view/CardInputWidget;", "Landroid/widget/LinearLayout;", "Lcom/stripe/android/view/CardWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFields", "", "Lcom/stripe/android/view/StripeEditText;", "billingDetails", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "getBillingDetails", "()Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "brand", "Lcom/stripe/android/model/CardBrand;", "getBrand", "()Lcom/stripe/android/model/CardBrand;", "cardBrandView", "Lcom/stripe/android/view/CardBrandView;", "getCardBrandView$payments_core_release", "()Lcom/stripe/android/view/CardBrandView;", "cardInputListener", "Lcom/stripe/android/view/CardInputListener;", "cardNumberEditText", "Lcom/stripe/android/view/CardNumberEditText;", "getCardNumberEditText$payments_core_release", "()Lcom/stripe/android/view/CardNumberEditText;", "cardNumberTextInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "cardParams", "Lcom/stripe/android/model/CardParams;", "getCardParams", "()Lcom/stripe/android/model/CardParams;", "cardValidCallback", "Lcom/stripe/android/view/CardValidCallback;", "cardValidTextWatcher", "com/stripe/android/view/CardInputWidget$cardValidTextWatcher$1", "Lcom/stripe/android/view/CardInputWidget$cardValidTextWatcher$1;", "containerLayout", "Landroid/widget/FrameLayout;", "currentFields", "", "getCurrentFields$payments_core_release$annotations", "()V", "getCurrentFields$payments_core_release", "()Ljava/util/List;", "customCvcLabel", "", "cvc", "Lcom/stripe/android/cards/Cvc$Validated;", "getCvc", "()Lcom/stripe/android/cards/Cvc$Validated;", "cvcEditText", "Lcom/stripe/android/view/CvcEditText;", "getCvcEditText$payments_core_release", "()Lcom/stripe/android/view/CvcEditText;", "cvcNumberTextInputLayout", "cvcPlaceHolder", "getCvcPlaceHolder", "()Ljava/lang/String;", "expiryDateEditText", "Lcom/stripe/android/view/ExpiryDateEditText;", "getExpiryDateEditText$payments_core_release", "()Lcom/stripe/android/view/ExpiryDateEditText;", "expiryDateTextInputLayout", "frameStart", "getFrameStart", "()I", "frameWidth", "getFrameWidth", "frameWidthSupplier", "Lkotlin/Function0;", "getFrameWidthSupplier$payments_core_release", "()Lkotlin/jvm/functions/Function0;", "setFrameWidthSupplier$payments_core_release", "(Lkotlin/jvm/functions/Function0;)V", "hiddenCardText", "invalidFields", "Lcom/stripe/android/view/CardValidCallback$Fields;", "getInvalidFields", "()Ljava/util/Set;", "isShowingFullCard", "", "isShowingFullCard$payments_core_release", "()Z", "setShowingFullCard$payments_core_release", "(Z)V", "isViewInitialized", "layoutWidthCalculator", "Lcom/stripe/android/view/CardInputWidget$LayoutWidthCalculator;", "getLayoutWidthCalculator$payments_core_release", "()Lcom/stripe/android/view/CardInputWidget$LayoutWidthCalculator;", "setLayoutWidthCalculator$payments_core_release", "(Lcom/stripe/android/view/CardInputWidget$LayoutWidthCalculator;)V", "paymentMethodCard", "Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "getPaymentMethodCard", "()Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "getPaymentMethodCreateParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "peekCardText", "getPeekCardText", "placement", "Lcom/stripe/android/view/CardInputWidgetPlacement;", "getPlacement$payments_core_release", "()Lcom/stripe/android/view/CardInputWidgetPlacement;", "postalCodeEditText", "Lcom/stripe/android/view/PostalCodeEditText;", "getPostalCodeEditText$payments_core_release", "()Lcom/stripe/android/view/PostalCodeEditText;", "<set-?>", "postalCodeEnabled", "getPostalCodeEnabled", "setPostalCodeEnabled", "postalCodeEnabled$delegate", "Lkotlin/properties/ReadWriteProperty;", "postalCodeRequired", "getPostalCodeRequired", "setPostalCodeRequired", "postalCodeRequired$delegate", "postalCodeTextInputLayout", "getPostalCodeTextInputLayout$payments_core_release", "()Lcom/google/android/material/textfield/TextInputLayout;", "postalCodeValue", "getPostalCodeValue", "requiredFields", "", "getRequiredFields$payments_core_release$annotations", "getRequiredFields$payments_core_release", "value", "shouldShowErrorIcon", "getShouldShowErrorIcon$payments_core_release$annotations", "getShouldShowErrorIcon$payments_core_release", "setShouldShowErrorIcon", "usZipCodeRequired", "getUsZipCodeRequired", "setUsZipCodeRequired", "usZipCodeRequired$delegate", "viewBinding", "Lcom/stripe/android/databinding/CardInputWidgetBinding;", "applyCardElementAttributes", "", "clear", "createHiddenCardText", "panLength", "createHiddenCardText$payments_core_release", "getDesiredWidthInPixels", "text", "editText", "getFocusField", "Lcom/stripe/android/view/CardInputWidget$Field;", "touchX", "initView", "isEnabled", "isPostalRequired", "onFinishInflate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "l", "t", "r", "b", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "scrollEnd", "scrollStart", "setCardHint", "cardHint", "setCardInputListener", "listener", "setCardNumber", "cardNumber", "setCardNumberTextWatcher", "cardNumberTextWatcher", "Landroid/text/TextWatcher;", "setCardValidCallback", "callback", "setCvcCode", "cvcCode", "setCvcLabel", "cvcLabel", "setCvcNumberTextWatcher", "cvcNumberTextWatcher", "setEnabled", "setExpiryDate", "month", "year", "setExpiryDateTextWatcher", "expiryDateTextWatcher", "setPostalCode", "postalCode", "setPostalCode$payments_core_release", "setPostalCodeTextWatcher", "postalCodeTextWatcher", "startSlideAnimation", "animations", "Landroid/view/animation/Animation;", "updateCvc", "updateFieldLayout", "view", "Landroid/view/View;", "newWidth", "newMarginStart", "updatePostalRequired", "updateSpaceSizes", "updateSpaceSizes$payments_core_release", "AnimationEndListener", "CardFieldAnimation", "CardNumberSlideEndAnimation", "CardNumberSlideStartAnimation", "Companion", "CvcSlideEndAnimation", "CvcSlideStartAnimation", "DefaultLayoutWidthCalculator", "ExpiryDateSlideEndAnimation", "ExpiryDateSlideStartAnimation", "Field", "LayoutWidthCalculator", "PostalCodeSlideEndAnimation", "PostalCodeSlideStartAnimation", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardInputWidget.kt */
public final class CardInputWidget extends LinearLayout implements CardWidget {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    private static final String CVC_PLACEHOLDER_AMEX = "2345";
    private static final String CVC_PLACEHOLDER_COMMON = "CVC";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_READER_ID = R.id.stripe_default_reader_id;
    private static final String FULL_SIZING_CARD_TEXT = "4242 4242 4242 4242 424";
    private static final String FULL_SIZING_DATE_TEXT = "MM/MM";
    private static final String FULL_SIZING_POSTAL_CODE_TEXT = "1234567890";
    public static final String LOGGING_TOKEN = "CardInputView";
    private static final String STATE_CARD_VIEWED = "state_card_viewed";
    private static final String STATE_POSTAL_CODE_ENABLED = "state_postal_code_enabled";
    private static final String STATE_SUPER_STATE = "state_super_state";
    private final Set<StripeEditText> allFields;
    private final /* synthetic */ CardBrandView cardBrandView;
    /* access modifiers changed from: private */
    public CardInputListener cardInputListener;
    private final /* synthetic */ CardNumberEditText cardNumberEditText;
    private final TextInputLayout cardNumberTextInputLayout;
    /* access modifiers changed from: private */
    public CardValidCallback cardValidCallback;
    /* access modifiers changed from: private */
    public final CardInputWidget$cardValidTextWatcher$1 cardValidTextWatcher;
    /* access modifiers changed from: private */
    public final FrameLayout containerLayout;
    private String customCvcLabel;
    private final /* synthetic */ CvcEditText cvcEditText;
    private final TextInputLayout cvcNumberTextInputLayout;
    private final /* synthetic */ ExpiryDateEditText expiryDateEditText;
    private final TextInputLayout expiryDateTextInputLayout;
    private /* synthetic */ Function0<Integer> frameWidthSupplier;
    /* access modifiers changed from: private */
    public String hiddenCardText;
    private /* synthetic */ boolean isShowingFullCard;
    private boolean isViewInitialized;
    private /* synthetic */ LayoutWidthCalculator layoutWidthCalculator;
    private final CardInputWidgetPlacement placement;
    private final /* synthetic */ PostalCodeEditText postalCodeEditText;
    private final ReadWriteProperty postalCodeEnabled$delegate;
    private final ReadWriteProperty postalCodeRequired$delegate;
    private final TextInputLayout postalCodeTextInputLayout;
    private final /* synthetic */ Set<StripeEditText> requiredFields;
    private boolean shouldShowErrorIcon;
    private final ReadWriteProperty usZipCodeRequired$delegate;
    private final CardInputWidgetBinding viewBinding;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$AnimationEndListener;", "Landroid/view/animation/Animation$AnimationListener;", "()V", "onAnimationRepeat", "", "animation", "Landroid/view/animation/Animation;", "onAnimationStart", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    private static abstract class AnimationEndListener implements Animation.AnimationListener {
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$Field;", "", "(Ljava/lang/String;I)V", "Number", "Expiry", "Cvc", "PostalCode", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    public enum Field {
        Number,
        Expiry,
        Cvc,
        PostalCode
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$LayoutWidthCalculator;", "", "calculate", "", "text", "", "paint", "Landroid/text/TextPaint;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    public interface LayoutWidthCalculator {
        int calculate(String str, TextPaint textPaint);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Field.values().length];
            iArr[Field.Number.ordinal()] = 1;
            iArr[Field.Expiry.ordinal()] = 2;
            iArr[Field.Cvc.ordinal()] = 3;
            iArr[Field.PostalCode.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardInputWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardInputWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getCurrentFields$payments_core_release$annotations() {
    }

    public static /* synthetic */ void getRequiredFields$payments_core_release$annotations() {
    }

    public static /* synthetic */ void getShouldShowErrorIcon$payments_core_release$annotations() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardInputWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardInputWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        CardInputWidgetBinding inflate = CardInputWidgetBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI…text),\n        this\n    )");
        this.viewBinding = inflate;
        FrameLayout frameLayout = inflate.container;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "viewBinding.container");
        this.containerLayout = frameLayout;
        CardBrandView cardBrandView2 = inflate.cardBrandView;
        Intrinsics.checkNotNullExpressionValue(cardBrandView2, "viewBinding.cardBrandView");
        this.cardBrandView = cardBrandView2;
        TextInputLayout textInputLayout = inflate.cardNumberTextInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "viewBinding.cardNumberTextInputLayout");
        this.cardNumberTextInputLayout = textInputLayout;
        TextInputLayout textInputLayout2 = inflate.expiryDateTextInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout2, "viewBinding.expiryDateTextInputLayout");
        this.expiryDateTextInputLayout = textInputLayout2;
        TextInputLayout textInputLayout3 = inflate.cvcTextInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout3, "viewBinding.cvcTextInputLayout");
        this.cvcNumberTextInputLayout = textInputLayout3;
        TextInputLayout textInputLayout4 = inflate.postalCodeTextInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout4, "viewBinding.postalCodeTextInputLayout");
        this.postalCodeTextInputLayout = textInputLayout4;
        CardNumberEditText cardNumberEditText2 = inflate.cardNumberEditText;
        Intrinsics.checkNotNullExpressionValue(cardNumberEditText2, "viewBinding.cardNumberEditText");
        this.cardNumberEditText = cardNumberEditText2;
        ExpiryDateEditText expiryDateEditText2 = inflate.expiryDateEditText;
        Intrinsics.checkNotNullExpressionValue(expiryDateEditText2, "viewBinding.expiryDateEditText");
        this.expiryDateEditText = expiryDateEditText2;
        CvcEditText cvcEditText2 = inflate.cvcEditText;
        Intrinsics.checkNotNullExpressionValue(cvcEditText2, "viewBinding.cvcEditText");
        this.cvcEditText = cvcEditText2;
        PostalCodeEditText postalCodeEditText2 = inflate.postalCodeEditText;
        Intrinsics.checkNotNullExpressionValue(postalCodeEditText2, "viewBinding.postalCodeEditText");
        this.postalCodeEditText = postalCodeEditText2;
        this.cardValidTextWatcher = new CardInputWidget$cardValidTextWatcher$1(this);
        this.isShowingFullCard = true;
        this.layoutWidthCalculator = new DefaultLayoutWidthCalculator();
        this.placement = new CardInputWidgetPlacement(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65535, (DefaultConstructorMarker) null);
        Delegates delegates = Delegates.INSTANCE;
        this.postalCodeEnabled$delegate = new CardInputWidget$special$$inlined$observable$1(true, this);
        Delegates delegates2 = Delegates.INSTANCE;
        this.postalCodeRequired$delegate = new CardInputWidget$special$$inlined$observable$2(false, this);
        Delegates delegates3 = Delegates.INSTANCE;
        this.usZipCodeRequired$delegate = new CardInputWidget$special$$inlined$observable$3(false, this);
        if (getId() == -1) {
            setId(DEFAULT_READER_ID);
        }
        setOrientation(0);
        setMinimumWidth(getResources().getDimensionPixelSize(R.dimen.stripe_card_widget_min_width));
        this.frameWidthSupplier = new Function0<Integer>(this) {
            final /* synthetic */ CardInputWidget this$0;

            {
                this.this$0 = r1;
            }

            public final Integer invoke() {
                return Integer.valueOf(this.this$0.containerLayout.getWidth());
            }
        };
        Set<StripeEditText> mutableSetOf = SetsKt.mutableSetOf(cardNumberEditText2, cvcEditText2, expiryDateEditText2);
        this.requiredFields = mutableSetOf;
        this.allFields = SetsKt.plus(mutableSetOf, postalCodeEditText2);
        initView(attributeSet);
        this.hiddenCardText = createHiddenCardText$payments_core_release(cardNumberEditText2.getPanLength$payments_core_release());
    }

    public final CardBrandView getCardBrandView$payments_core_release() {
        return this.cardBrandView;
    }

    public final TextInputLayout getPostalCodeTextInputLayout$payments_core_release() {
        return this.postalCodeTextInputLayout;
    }

    public final CardNumberEditText getCardNumberEditText$payments_core_release() {
        return this.cardNumberEditText;
    }

    public final ExpiryDateEditText getExpiryDateEditText$payments_core_release() {
        return this.expiryDateEditText;
    }

    public final CvcEditText getCvcEditText$payments_core_release() {
        return this.cvcEditText;
    }

    public final PostalCodeEditText getPostalCodeEditText$payments_core_release() {
        return this.postalCodeEditText;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        if ((r6 == null || kotlin.text.StringsKt.isBlank(r6)) != false) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set<com.stripe.android.view.CardValidCallback.Fields> getInvalidFields() {
        /*
            r7 = this;
            r0 = 4
            com.stripe.android.view.CardValidCallback$Fields[] r0 = new com.stripe.android.view.CardValidCallback.Fields[r0]
            com.stripe.android.view.CardValidCallback$Fields r1 = com.stripe.android.view.CardValidCallback.Fields.Number
            com.stripe.android.view.CardNumberEditText r2 = r7.getCardNumberEditText$payments_core_release()
            com.stripe.android.cards.CardNumber$Validated r2 = r2.getValidatedCardNumber$payments_core_release()
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            r5 = 0
            if (r2 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r1 = r5
        L_0x0019:
            r0[r4] = r1
            com.stripe.android.view.CardValidCallback$Fields r1 = com.stripe.android.view.CardValidCallback.Fields.Expiry
            com.stripe.android.view.ExpiryDateEditText r2 = r7.getExpiryDateEditText$payments_core_release()
            com.stripe.android.model.ExpirationDate$Validated r2 = r2.getValidatedDate()
            if (r2 != 0) goto L_0x0029
            r2 = 1
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            if (r2 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r1 = r5
        L_0x002e:
            r0[r3] = r1
            r1 = 2
            com.stripe.android.view.CardValidCallback$Fields r2 = com.stripe.android.view.CardValidCallback.Fields.Cvc
            com.stripe.android.cards.Cvc$Validated r6 = r7.getCvc()
            if (r6 != 0) goto L_0x003b
            r6 = 1
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            if (r6 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r2 = r5
        L_0x0040:
            r0[r1] = r2
            r1 = 3
            com.stripe.android.view.CardValidCallback$Fields r2 = com.stripe.android.view.CardValidCallback.Fields.Postal
            boolean r6 = r7.isPostalRequired()
            if (r6 == 0) goto L_0x0064
            com.stripe.android.view.PostalCodeEditText r6 = r7.getPostalCodeEditText$payments_core_release()
            java.lang.String r6 = r6.getPostalCode$payments_core_release()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0060
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r6 = 0
            goto L_0x0061
        L_0x0060:
            r6 = 1
        L_0x0061:
            if (r6 == 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r3 = 0
        L_0x0065:
            if (r3 == 0) goto L_0x0068
            r5 = r2
        L_0x0068:
            r0[r1] = r5
            java.util.List r0 = kotlin.collections.CollectionsKt.listOfNotNull((T[]) r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.CardInputWidget.getInvalidFields():java.util.Set");
    }

    public final boolean getShouldShowErrorIcon$payments_core_release() {
        return this.shouldShowErrorIcon;
    }

    /* access modifiers changed from: private */
    public final void setShouldShowErrorIcon(boolean z) {
        this.cardBrandView.setShouldShowErrorIcon(z);
        this.shouldShowErrorIcon = z;
    }

    public final boolean isShowingFullCard$payments_core_release() {
        return this.isShowingFullCard;
    }

    public final void setShowingFullCard$payments_core_release(boolean z) {
        this.isShowingFullCard = z;
    }

    public final LayoutWidthCalculator getLayoutWidthCalculator$payments_core_release() {
        return this.layoutWidthCalculator;
    }

    public final void setLayoutWidthCalculator$payments_core_release(LayoutWidthCalculator layoutWidthCalculator2) {
        Intrinsics.checkNotNullParameter(layoutWidthCalculator2, "<set-?>");
        this.layoutWidthCalculator = layoutWidthCalculator2;
    }

    public final CardInputWidgetPlacement getPlacement$payments_core_release() {
        return this.placement;
    }

    private final String getPostalCodeValue() {
        if (getPostalCodeEnabled()) {
            return this.postalCodeEditText.getPostalCode$payments_core_release();
        }
        return null;
    }

    private final Cvc.Validated getCvc() {
        return this.cvcEditText.getCvc$payments_core_release();
    }

    /* access modifiers changed from: private */
    public final CardBrand getBrand() {
        return this.cardNumberEditText.getCardBrand();
    }

    public final Set<StripeEditText> getRequiredFields$payments_core_release() {
        return this.requiredFields;
    }

    public final /* synthetic */ List getCurrentFields$payments_core_release() {
        Set<StripeEditText> set = this.requiredFields;
        PostalCodeEditText postalCodeEditText2 = this.postalCodeEditText;
        if (!getPostalCodeEnabled()) {
            postalCodeEditText2 = null;
        }
        return CollectionsKt.filterNotNull(SetsKt.plus(set, postalCodeEditText2));
    }

    public PaymentMethodCreateParams.Card getPaymentMethodCard() {
        CardParams cardParams = getCardParams();
        if (cardParams == null) {
            return null;
        }
        String number$payments_core_release = cardParams.getNumber$payments_core_release();
        String cvc$payments_core_release = cardParams.getCvc$payments_core_release();
        int expMonth$payments_core_release = cardParams.getExpMonth$payments_core_release();
        int expYear$payments_core_release = cardParams.getExpYear$payments_core_release();
        Set<String> attribution = cardParams.getAttribution();
        return new PaymentMethodCreateParams.Card(number$payments_core_release, Integer.valueOf(expMonth$payments_core_release), Integer.valueOf(expYear$payments_core_release), cvc$payments_core_release, (String) null, attribution, 16, (DefaultConstructorMarker) null);
    }

    private final PaymentMethod.BillingDetails getBillingDetails() {
        String postalCodeValue = getPostalCodeValue();
        if (postalCodeValue == null) {
            return null;
        }
        return new PaymentMethod.BillingDetails(new Address((String) null, (String) null, (String) null, (String) null, postalCodeValue, (String) null, 47, (DefaultConstructorMarker) null), (String) null, (String) null, (String) null, 14, (DefaultConstructorMarker) null);
    }

    public PaymentMethodCreateParams getPaymentMethodCreateParams() {
        PaymentMethodCreateParams.Card paymentMethodCard = getPaymentMethodCard();
        if (paymentMethodCard == null) {
            return null;
        }
        return PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, paymentMethodCard, getBillingDetails(), (Map) null, 4, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.model.CardParams getCardParams() {
        /*
            r19 = this;
            r0 = r19
            com.stripe.android.view.CardNumberEditText r1 = r0.cardNumberEditText
            com.stripe.android.cards.CardNumber$Validated r1 = r1.getValidatedCardNumber$payments_core_release()
            com.stripe.android.view.ExpiryDateEditText r2 = r0.expiryDateEditText
            com.stripe.android.model.ExpirationDate$Validated r2 = r2.getValidatedDate()
            com.stripe.android.cards.Cvc$Validated r3 = r19.getCvc()
            com.stripe.android.view.CardNumberEditText r4 = r0.cardNumberEditText
            r5 = 1
            r6 = 0
            if (r1 != 0) goto L_0x001a
            r7 = 1
            goto L_0x001b
        L_0x001a:
            r7 = 0
        L_0x001b:
            r4.setShouldShowError(r7)
            com.stripe.android.view.ExpiryDateEditText r4 = r0.expiryDateEditText
            if (r2 != 0) goto L_0x0024
            r7 = 1
            goto L_0x0025
        L_0x0024:
            r7 = 0
        L_0x0025:
            r4.setShouldShowError(r7)
            com.stripe.android.view.CvcEditText r4 = r0.cvcEditText
            if (r3 != 0) goto L_0x002e
            r7 = 1
            goto L_0x002f
        L_0x002e:
            r7 = 0
        L_0x002f:
            r4.setShouldShowError(r7)
            com.stripe.android.view.PostalCodeEditText r4 = r0.postalCodeEditText
            boolean r7 = r19.getPostalCodeRequired()
            if (r7 != 0) goto L_0x0040
            boolean r7 = r19.getUsZipCodeRequired()
            if (r7 == 0) goto L_0x0058
        L_0x0040:
            com.stripe.android.view.PostalCodeEditText r7 = r0.postalCodeEditText
            java.lang.String r7 = r7.getPostalCode$payments_core_release()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0053
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r7 = 0
            goto L_0x0054
        L_0x0053:
            r7 = 1
        L_0x0054:
            if (r7 == 0) goto L_0x0058
            r7 = 1
            goto L_0x0059
        L_0x0058:
            r7 = 0
        L_0x0059:
            r4.setShouldShowError(r7)
            java.util.List r4 = r19.getCurrentFields$payments_core_release()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x006d:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x0084
            java.lang.Object r8 = r4.next()
            r9 = r8
            com.stripe.android.view.StripeEditText r9 = (com.stripe.android.view.StripeEditText) r9
            boolean r9 = r9.getShouldShowError()
            if (r9 == 0) goto L_0x006d
            r7.add(r8)
            goto L_0x006d
        L_0x0084:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
        L_0x008c:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x00a5
            java.lang.Object r7 = r4.next()
            com.stripe.android.view.StripeEditText r7 = (com.stripe.android.view.StripeEditText) r7
            java.lang.String r8 = r7.getErrorMessage$payments_core_release()
            if (r8 != 0) goto L_0x009f
            goto L_0x008c
        L_0x009f:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.announceForAccessibility(r8)
            goto L_0x008c
        L_0x00a5:
            r4 = 0
            if (r1 != 0) goto L_0x00ae
            com.stripe.android.view.CardNumberEditText r1 = r0.cardNumberEditText
            r1.requestFocus()
            goto L_0x00cb
        L_0x00ae:
            if (r2 != 0) goto L_0x00b6
            com.stripe.android.view.ExpiryDateEditText r1 = r0.expiryDateEditText
            r1.requestFocus()
            goto L_0x00cb
        L_0x00b6:
            if (r3 != 0) goto L_0x00be
            com.stripe.android.view.CvcEditText r1 = r0.cvcEditText
            r1.requestFocus()
            goto L_0x00cb
        L_0x00be:
            com.stripe.android.view.PostalCodeEditText r7 = r0.postalCodeEditText
            boolean r7 = r7.getShouldShowError()
            if (r7 == 0) goto L_0x00cf
            com.stripe.android.view.PostalCodeEditText r1 = r0.postalCodeEditText
            r1.requestFocus()
        L_0x00cb:
            r0.setShouldShowErrorIcon(r5)
            return r4
        L_0x00cf:
            r0.setShouldShowErrorIcon(r6)
            com.stripe.android.model.CardBrand r7 = r19.getBrand()
            java.lang.String r8 = "CardInputView"
            java.util.Set r8 = kotlin.collections.SetsKt.setOf(r8)
            java.lang.String r9 = r1.getValue()
            int r10 = r2.getMonth()
            int r11 = r2.getYear()
            java.lang.String r12 = r3.getValue$payments_core_release()
            r13 = 0
            com.stripe.android.model.Address$Builder r1 = new com.stripe.android.model.Address$Builder
            r1.<init>()
            java.lang.String r2 = r19.getPostalCodeValue()
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0103
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 == 0) goto L_0x0102
            goto L_0x0103
        L_0x0102:
            r5 = 0
        L_0x0103:
            if (r5 != 0) goto L_0x0106
            r4 = r2
        L_0x0106:
            com.stripe.android.model.Address$Builder r1 = r1.setPostalCode(r4)
            com.stripe.android.model.Address r14 = r1.build()
            r15 = 0
            r16 = 0
            r17 = 832(0x340, float:1.166E-42)
            r18 = 0
            com.stripe.android.model.CardParams r1 = new com.stripe.android.model.CardParams
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.CardInputWidget.getCardParams():com.stripe.android.model.CardParams");
    }

    private final int getFrameWidth() {
        return this.frameWidthSupplier.invoke().intValue();
    }

    public final Function0<Integer> getFrameWidthSupplier$payments_core_release() {
        return this.frameWidthSupplier;
    }

    public final void setFrameWidthSupplier$payments_core_release(Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.frameWidthSupplier = function0;
    }

    static {
        Class<CardInputWidget> cls = CardInputWidget.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "postalCodeEnabled", "getPostalCodeEnabled()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "postalCodeRequired", "getPostalCodeRequired()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "usZipCodeRequired", "getUsZipCodeRequired()Z", 0))};
    }

    public final boolean getPostalCodeEnabled() {
        return ((Boolean) this.postalCodeEnabled$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setPostalCodeEnabled(boolean z) {
        this.postalCodeEnabled$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final boolean getPostalCodeRequired() {
        return ((Boolean) this.postalCodeRequired$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final void setPostalCodeRequired(boolean z) {
        this.postalCodeRequired$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    public final boolean getUsZipCodeRequired() {
        return ((Boolean) this.usZipCodeRequired$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final void setUsZipCodeRequired(boolean z) {
        this.usZipCodeRequired$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final void updatePostalRequired() {
        if (isPostalRequired()) {
            this.requiredFields.add(this.postalCodeEditText);
        } else {
            this.requiredFields.remove(this.postalCodeEditText);
        }
    }

    private final boolean isPostalRequired() {
        return (getPostalCodeRequired() || getUsZipCodeRequired()) && getPostalCodeEnabled();
    }

    private final int getFrameStart() {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 0) {
            return this.containerLayout.getLeft();
        }
        return this.containerLayout.getRight();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.postalCodeEditText.setConfig$payments_core_release(PostalCodeEditText.Config.Global);
    }

    public void setCardValidCallback(CardValidCallback cardValidCallback2) {
        this.cardValidCallback = cardValidCallback2;
        for (StripeEditText removeTextChangedListener : this.requiredFields) {
            removeTextChangedListener.removeTextChangedListener(this.cardValidTextWatcher);
        }
        if (cardValidCallback2 != null) {
            for (StripeEditText addTextChangedListener : this.requiredFields) {
                addTextChangedListener.addTextChangedListener(this.cardValidTextWatcher);
            }
        }
        CardValidCallback cardValidCallback3 = this.cardValidCallback;
        if (cardValidCallback3 != null) {
            cardValidCallback3.onInputChanged(getInvalidFields().isEmpty(), getInvalidFields());
        }
    }

    public void setCardInputListener(CardInputListener cardInputListener2) {
        this.cardInputListener = cardInputListener2;
    }

    public void setCardNumber(String str) {
        this.cardNumberEditText.setText(str);
        this.isShowingFullCard = !this.cardNumberEditText.isCardNumberValid();
    }

    public void setCardHint(String str) {
        Intrinsics.checkNotNullParameter(str, "cardHint");
        this.cardNumberEditText.setHint(str);
    }

    public void setExpiryDate(int i, int i2) {
        this.expiryDateEditText.setText(new ExpirationDate.Unvalidated(i, i2).getDisplayString());
    }

    public void setCvcCode(String str) {
        this.cvcEditText.setText(str);
    }

    public final /* synthetic */ void setPostalCode$payments_core_release(String str) {
        this.postalCodeEditText.setText(str);
    }

    public void clear() {
        Iterable currentFields$payments_core_release = getCurrentFields$payments_core_release();
        boolean z = false;
        if (!(currentFields$payments_core_release instanceof Collection) || !((Collection) currentFields$payments_core_release).isEmpty()) {
            Iterator it = currentFields$payments_core_release.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((StripeEditText) it.next()).hasFocus()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z || hasFocus()) {
            this.cardNumberEditText.requestFocus();
        }
        for (StripeEditText text : getCurrentFields$payments_core_release()) {
            text.setText("");
        }
    }

    public void setEnabled(boolean z) {
        for (StripeEditText enabled : getCurrentFields$payments_core_release()) {
            enabled.setEnabled(z);
        }
    }

    public void setCardNumberTextWatcher(TextWatcher textWatcher) {
        this.cardNumberEditText.addTextChangedListener(textWatcher);
    }

    public void setExpiryDateTextWatcher(TextWatcher textWatcher) {
        this.expiryDateEditText.addTextChangedListener(textWatcher);
    }

    public void setCvcNumberTextWatcher(TextWatcher textWatcher) {
        this.cvcEditText.addTextChangedListener(textWatcher);
    }

    public void setPostalCodeTextWatcher(TextWatcher textWatcher) {
        this.postalCodeEditText.addTextChangedListener(textWatcher);
    }

    public boolean isEnabled() {
        Iterable<StripeEditText> iterable = this.requiredFields;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (StripeEditText isEnabled : iterable) {
            if (!isEnabled.isEnabled()) {
                return false;
            }
        }
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Boolean bool;
        StripeEditText stripeEditText;
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        Field focusField = getFocusField((int) motionEvent.getX(), getFrameStart());
        if (focusField == null) {
            bool = null;
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[focusField.ordinal()];
            if (i == 1) {
                stripeEditText = getCardNumberEditText$payments_core_release();
            } else if (i == 2) {
                stripeEditText = getExpiryDateEditText$payments_core_release();
            } else if (i == 3) {
                stripeEditText = getCvcEditText$payments_core_release();
            } else if (i == 4) {
                stripeEditText = getPostalCodeEditText$payments_core_release();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            stripeEditText.requestFocus();
            bool = true;
        }
        if (bool == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return BundleKt.bundleOf(TuplesKt.to(STATE_SUPER_STATE, super.onSaveInstanceState()), TuplesKt.to(STATE_CARD_VIEWED, Boolean.valueOf(this.isShowingFullCard)), TuplesKt.to(STATE_POSTAL_CODE_ENABLED, Boolean.valueOf(getPostalCodeEnabled())));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(parcelable, PostalAddressParser.REGION_KEY);
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setPostalCodeEnabled(bundle.getBoolean(STATE_POSTAL_CODE_ENABLED, true));
            boolean z = bundle.getBoolean(STATE_CARD_VIEWED, true);
            this.isShowingFullCard = z;
            updateSpaceSizes$payments_core_release$default(this, z, 0, 0, 6, (Object) null);
            this.placement.setTotalLengthInPixels$payments_core_release(getFrameWidth());
            int i5 = 0;
            if (this.isShowingFullCard) {
                i3 = this.placement.getDateStartMargin$payments_core_release(true);
                i = this.placement.getCvcStartMargin$payments_core_release(true);
                i2 = this.placement.getPostalCodeStartMargin$payments_core_release(true);
            } else {
                int hiddenCardWidth$payments_core_release = this.placement.getHiddenCardWidth$payments_core_release() * -1;
                int dateStartMargin$payments_core_release = this.placement.getDateStartMargin$payments_core_release(false);
                i = this.placement.getCvcStartMargin$payments_core_release(false);
                if (getPostalCodeEnabled()) {
                    i4 = this.placement.getPostalCodeStartMargin$payments_core_release(false);
                } else {
                    i4 = this.placement.getTotalLengthInPixels$payments_core_release();
                }
                int i6 = i4;
                i5 = hiddenCardWidth$payments_core_release;
                i3 = dateStartMargin$payments_core_release;
                i2 = i6;
            }
            updateFieldLayout(this.cardNumberTextInputLayout, this.placement.getCardWidth$payments_core_release(), i5);
            updateFieldLayout(this.expiryDateTextInputLayout, this.placement.getDateWidth$payments_core_release(), i3);
            updateFieldLayout(this.cvcNumberTextInputLayout, this.placement.getCvcWidth$payments_core_release(), i);
            updateFieldLayout(this.postalCodeTextInputLayout, this.placement.getPostalCodeWidth$payments_core_release(), i2);
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER_STATE));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private final Field getFocusField(int i, int i2) {
        return this.placement.getFocusField$payments_core_release(i, i2, this.isShowingFullCard, getPostalCodeEnabled());
    }

    public static /* synthetic */ void updateSpaceSizes$payments_core_release$default(CardInputWidget cardInputWidget, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = cardInputWidget.getFrameWidth();
        }
        if ((i3 & 4) != 0) {
            i2 = cardInputWidget.getFrameStart();
        }
        cardInputWidget.updateSpaceSizes$payments_core_release(z, i, i2);
    }

    public final void updateSpaceSizes$payments_core_release(boolean z, int i, int i2) {
        if (i != 0) {
            this.placement.setCardWidth$payments_core_release(getDesiredWidthInPixels(FULL_SIZING_CARD_TEXT, this.cardNumberEditText));
            this.placement.setDateWidth$payments_core_release(getDesiredWidthInPixels(FULL_SIZING_DATE_TEXT, this.expiryDateEditText));
            this.placement.setHiddenCardWidth$payments_core_release(getDesiredWidthInPixels(this.hiddenCardText, this.cardNumberEditText));
            this.placement.setCvcWidth$payments_core_release(getDesiredWidthInPixels(getCvcPlaceHolder(), this.cvcEditText));
            this.placement.setPostalCodeWidth$payments_core_release(getDesiredWidthInPixels(FULL_SIZING_POSTAL_CODE_TEXT, this.postalCodeEditText));
            this.placement.setPeekCardWidth$payments_core_release(getDesiredWidthInPixels(getPeekCardText(), this.cardNumberEditText));
            this.placement.updateSpacing$payments_core_release(z, getPostalCodeEnabled(), i2, i);
        }
    }

    private final int getDesiredWidthInPixels(String str, StripeEditText stripeEditText) {
        LayoutWidthCalculator layoutWidthCalculator2 = this.layoutWidthCalculator;
        TextPaint paint = stripeEditText.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "editText.paint");
        return layoutWidthCalculator2.calculate(str, paint);
    }

    private final void initView(AttributeSet attributeSet) {
        applyCardElementAttributes(attributeSet);
        ViewCompat.setAccessibilityDelegate(this.cardNumberEditText, new CardInputWidget$initView$1());
        this.isShowingFullCard = true;
        int defaultErrorColorInt = this.cardNumberEditText.getDefaultErrorColorInt();
        this.cardBrandView.setTintColorInt$payments_core_release(this.cardNumberEditText.getHintTextColors().getDefaultColor());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] iArr = R.styleable.CardInputView;
        Intrinsics.checkNotNullExpressionValue(iArr, LOGGING_TOKEN);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        getCardBrandView$payments_core_release().setTintColorInt$payments_core_release(obtainStyledAttributes.getColor(R.styleable.CardInputView_cardTint, getCardBrandView$payments_core_release().getTintColorInt$payments_core_release()));
        int color = obtainStyledAttributes.getColor(R.styleable.CardInputView_cardTextErrorColor, defaultErrorColorInt);
        String string = obtainStyledAttributes.getString(R.styleable.CardInputView_cardHintText);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.CardInputView_android_focusedByDefault, true);
        obtainStyledAttributes.recycle();
        if (string != null) {
            getCardNumberEditText$payments_core_release().setHint(string);
        }
        for (StripeEditText errorColor : getCurrentFields$payments_core_release()) {
            errorColor.setErrorColor(color);
        }
        this.cardNumberEditText.getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardInputWidget.m4642initView$lambda26(CardInputWidget.this, view, z);
            }
        });
        this.expiryDateEditText.getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardInputWidget.m4643initView$lambda27(CardInputWidget.this, view, z);
            }
        });
        this.postalCodeEditText.getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardInputWidget.m4644initView$lambda28(CardInputWidget.this, view, z);
            }
        });
        this.expiryDateEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(this.cardNumberEditText));
        this.cvcEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(this.expiryDateEditText));
        this.postalCodeEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(this.cvcEditText));
        this.cvcEditText.getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardInputWidget.m4645initView$lambda29(CardInputWidget.this, view, z);
            }
        });
        this.cvcEditText.setAfterTextChangedListener(new CardInputWidget$initView$9(this));
        this.postalCodeEditText.setAfterTextChangedListener(new CardInputWidget$initView$10(this));
        this.cardNumberEditText.setCompletionCallback$payments_core_release(new CardInputWidget$initView$11(this));
        this.cardNumberEditText.setBrandChangeCallback$payments_core_release(new CardInputWidget$initView$12(this));
        this.expiryDateEditText.setCompletionCallback$payments_core_release(new CardInputWidget$initView$13(this));
        this.cvcEditText.setCompletionCallback$payments_core_release(new CardInputWidget$initView$14(this));
        for (StripeEditText addTextChangedListener : this.allFields) {
            addTextChangedListener.addTextChangedListener(new CardInputWidget$initView$lambda31$$inlined$doAfterTextChanged$1(this));
        }
        if (z) {
            this.cardNumberEditText.requestFocus();
        }
        this.cardNumberEditText.setLoadingCallback$payments_core_release(new CardInputWidget$initView$16(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-26  reason: not valid java name */
    public static final void m4642initView$lambda26(CardInputWidget cardInputWidget, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardInputWidget, "this$0");
        if (z) {
            cardInputWidget.scrollStart();
            CardInputListener cardInputListener2 = cardInputWidget.cardInputListener;
            if (cardInputListener2 != null) {
                cardInputListener2.onFocusChange(CardInputListener.FocusField.CardNumber);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-27  reason: not valid java name */
    public static final void m4643initView$lambda27(CardInputWidget cardInputWidget, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardInputWidget, "this$0");
        if (z) {
            cardInputWidget.scrollEnd();
            CardInputListener cardInputListener2 = cardInputWidget.cardInputListener;
            if (cardInputListener2 != null) {
                cardInputListener2.onFocusChange(CardInputListener.FocusField.ExpiryDate);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-28  reason: not valid java name */
    public static final void m4644initView$lambda28(CardInputWidget cardInputWidget, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardInputWidget, "this$0");
        if (z) {
            cardInputWidget.scrollEnd();
            CardInputListener cardInputListener2 = cardInputWidget.cardInputListener;
            if (cardInputListener2 != null) {
                cardInputListener2.onFocusChange(CardInputListener.FocusField.PostalCode);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-29  reason: not valid java name */
    public static final void m4645initView$lambda29(CardInputWidget cardInputWidget, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardInputWidget, "this$0");
        cardInputWidget.cardBrandView.setShouldShowCvc(z);
        if (z) {
            cardInputWidget.scrollEnd();
            CardInputListener cardInputListener2 = cardInputWidget.cardInputListener;
            if (cardInputListener2 != null) {
                cardInputListener2.onFocusChange(CardInputListener.FocusField.Cvc);
            }
        }
    }

    public final void setCvcLabel(String str) {
        this.customCvcLabel = str;
        updateCvc();
    }

    /* access modifiers changed from: private */
    public final void updateCvc() {
        CvcEditText.updateBrand$payments_core_release$default(this.cvcEditText, this.cardBrandView.getBrand(), this.customCvcLabel, (String) null, (TextInputLayout) null, 12, (Object) null);
    }

    public final String createHiddenCardText$payments_core_release(int i) {
        String formatted = new CardNumber.Unvalidated(StringsKt.repeat("0", i)).getFormatted(i);
        return StringsKt.take(formatted, StringsKt.lastIndexOf$default((CharSequence) formatted, ' ', 0, false, 6, (Object) null) + 1);
    }

    private final void applyCardElementAttributes(AttributeSet attributeSet) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] iArr = R.styleable.CardElement;
        Intrinsics.checkNotNullExpressionValue(iArr, "CardElement");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        setPostalCodeEnabled(obtainStyledAttributes.getBoolean(R.styleable.CardElement_shouldShowPostalCode, getPostalCodeEnabled()));
        setPostalCodeRequired(obtainStyledAttributes.getBoolean(R.styleable.CardElement_shouldRequirePostalCode, getPostalCodeRequired()));
        setUsZipCodeRequired(obtainStyledAttributes.getBoolean(R.styleable.CardElement_shouldRequireUsZipCode, getUsZipCodeRequired()));
        obtainStyledAttributes.recycle();
    }

    private final void scrollStart() {
        PostalCodeSlideStartAnimation postalCodeSlideStartAnimation;
        if (!this.isShowingFullCard && this.isViewInitialized) {
            int dateStartMargin$payments_core_release = this.placement.getDateStartMargin$payments_core_release(false);
            int cvcStartMargin$payments_core_release = this.placement.getCvcStartMargin$payments_core_release(false);
            int postalCodeStartMargin$payments_core_release = this.placement.getPostalCodeStartMargin$payments_core_release(false);
            updateSpaceSizes$payments_core_release$default(this, true, 0, 0, 6, (Object) null);
            CardNumberSlideStartAnimation cardNumberSlideStartAnimation = new CardNumberSlideStartAnimation(this.cardNumberTextInputLayout);
            int dateStartMargin$payments_core_release2 = this.placement.getDateStartMargin$payments_core_release(true);
            ExpiryDateSlideStartAnimation expiryDateSlideStartAnimation = new ExpiryDateSlideStartAnimation(this.expiryDateTextInputLayout, dateStartMargin$payments_core_release, dateStartMargin$payments_core_release2);
            int i = (dateStartMargin$payments_core_release2 - dateStartMargin$payments_core_release) + cvcStartMargin$payments_core_release;
            CvcSlideStartAnimation cvcSlideStartAnimation = new CvcSlideStartAnimation(this.cvcNumberTextInputLayout, cvcStartMargin$payments_core_release, i, this.placement.getCvcWidth$payments_core_release());
            int i2 = (i - cvcStartMargin$payments_core_release) + postalCodeStartMargin$payments_core_release;
            if (getPostalCodeEnabled()) {
                postalCodeSlideStartAnimation = new PostalCodeSlideStartAnimation(this.postalCodeTextInputLayout, postalCodeStartMargin$payments_core_release, i2, this.placement.getPostalCodeWidth$payments_core_release());
            } else {
                postalCodeSlideStartAnimation = null;
            }
            startSlideAnimation(CollectionsKt.listOfNotNull((T[]) new CardFieldAnimation[]{cardNumberSlideStartAnimation, expiryDateSlideStartAnimation, cvcSlideStartAnimation, postalCodeSlideStartAnimation}));
            this.isShowingFullCard = true;
        }
    }

    /* access modifiers changed from: private */
    public final void scrollEnd() {
        PostalCodeSlideEndAnimation postalCodeSlideEndAnimation;
        if (this.isShowingFullCard && this.isViewInitialized) {
            int dateStartMargin$payments_core_release = this.placement.getDateStartMargin$payments_core_release(true);
            updateSpaceSizes$payments_core_release$default(this, false, 0, 0, 6, (Object) null);
            CardNumberSlideEndAnimation cardNumberSlideEndAnimation = new CardNumberSlideEndAnimation(this.cardNumberTextInputLayout, this.placement.getHiddenCardWidth$payments_core_release(), this.expiryDateEditText);
            int dateStartMargin$payments_core_release2 = this.placement.getDateStartMargin$payments_core_release(false);
            ExpiryDateSlideEndAnimation expiryDateSlideEndAnimation = new ExpiryDateSlideEndAnimation(this.expiryDateTextInputLayout, dateStartMargin$payments_core_release, dateStartMargin$payments_core_release2);
            int cvcStartMargin$payments_core_release = this.placement.getCvcStartMargin$payments_core_release(false);
            int i = (dateStartMargin$payments_core_release - dateStartMargin$payments_core_release2) + cvcStartMargin$payments_core_release;
            CvcSlideEndAnimation cvcSlideEndAnimation = new CvcSlideEndAnimation(this.cvcNumberTextInputLayout, i, cvcStartMargin$payments_core_release, this.placement.getCvcWidth$payments_core_release());
            int postalCodeStartMargin$payments_core_release = this.placement.getPostalCodeStartMargin$payments_core_release(false);
            int i2 = (i - cvcStartMargin$payments_core_release) + postalCodeStartMargin$payments_core_release;
            if (getPostalCodeEnabled()) {
                postalCodeSlideEndAnimation = new PostalCodeSlideEndAnimation(this.postalCodeTextInputLayout, i2, postalCodeStartMargin$payments_core_release, this.placement.getPostalCodeWidth$payments_core_release());
            } else {
                postalCodeSlideEndAnimation = null;
            }
            startSlideAnimation(CollectionsKt.listOfNotNull((T[]) new CardFieldAnimation[]{cardNumberSlideEndAnimation, expiryDateSlideEndAnimation, cvcSlideEndAnimation, postalCodeSlideEndAnimation}));
            this.isShowingFullCard = false;
        }
    }

    private final void startSlideAnimation(List<? extends Animation> list) {
        AnimationSet animationSet = new AnimationSet(true);
        for (Animation addAnimation : list) {
            animationSet.addAnimation(addAnimation);
        }
        this.containerLayout.startAnimation(animationSet);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        if (!this.isViewInitialized && getWidth() != 0) {
            this.isViewInitialized = true;
            this.placement.setTotalLengthInPixels$payments_core_release(getFrameWidth());
            updateSpaceSizes$payments_core_release$default(this, this.isShowingFullCard, 0, 0, 6, (Object) null);
            View view = this.cardNumberTextInputLayout;
            int cardWidth$payments_core_release = this.placement.getCardWidth$payments_core_release();
            if (this.isShowingFullCard) {
                i5 = 0;
            } else {
                i5 = this.placement.getHiddenCardWidth$payments_core_release() * -1;
            }
            updateFieldLayout(view, cardWidth$payments_core_release, i5);
            updateFieldLayout(this.expiryDateTextInputLayout, this.placement.getDateWidth$payments_core_release(), this.placement.getDateStartMargin$payments_core_release(this.isShowingFullCard));
            updateFieldLayout(this.cvcNumberTextInputLayout, this.placement.getCvcWidth$payments_core_release(), this.placement.getCvcStartMargin$payments_core_release(this.isShowingFullCard));
            updateFieldLayout(this.postalCodeTextInputLayout, this.placement.getPostalCodeWidth$payments_core_release(), this.placement.getPostalCodeStartMargin$payments_core_release(this.isShowingFullCard));
        }
    }

    private final String getCvcPlaceHolder() {
        return CardBrand.AmericanExpress == getBrand() ? CVC_PLACEHOLDER_AMEX : CVC_PLACEHOLDER_COMMON;
    }

    private final String getPeekCardText() {
        int panLength$payments_core_release = this.cardNumberEditText.getPanLength$payments_core_release();
        return StringsKt.repeat("0", panLength$payments_core_release != 14 ? panLength$payments_core_release != 15 ? panLength$payments_core_release != 19 ? 4 : 3 : 5 : 2);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\"\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$CardFieldAnimation;", "Landroid/view/animation/Animation;", "()V", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    private static abstract class CardFieldAnimation extends Animation {
        @Deprecated
        private static final long ANIMATION_LENGTH = 150;
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        public CardFieldAnimation() {
            setDuration(150);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$CardFieldAnimation$Companion;", "", "()V", "ANIMATION_LENGTH", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CardInputWidget.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$CardNumberSlideStartAnimation;", "Lcom/stripe/android/view/CardInputWidget$CardFieldAnimation;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    private static final class CardNumberSlideStartAnimation extends CardFieldAnimation {
        /* access modifiers changed from: private */
        public final View view;

        public CardNumberSlideStartAnimation(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            setAnimationListener(new AnimationEndListener(this) {
                final /* synthetic */ CardNumberSlideStartAnimation this$0;

                {
                    this.this$0 = r1;
                }

                public void onAnimationEnd(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.view.requestFocus();
                }
            });
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            Intrinsics.checkNotNullParameter(transformation, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT);
            super.applyTransformation(f, transformation);
            View view2 = this.view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams3.setMarginStart((int) (((float) layoutParams3.getMarginStart()) * (((float) 1) - f)));
            view2.setLayoutParams(layoutParams2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$ExpiryDateSlideStartAnimation;", "Lcom/stripe/android/view/CardInputWidget$CardFieldAnimation;", "view", "Landroid/view/View;", "startPosition", "", "destination", "(Landroid/view/View;II)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    private static final class ExpiryDateSlideStartAnimation extends CardFieldAnimation {
        private final int destination;
        private final int startPosition;
        private final View view;

        public ExpiryDateSlideStartAnimation(View view2, int i, int i2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            this.startPosition = i;
            this.destination = i2;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            Intrinsics.checkNotNullParameter(transformation, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT);
            super.applyTransformation(f, transformation);
            View view2 = this.view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            ((FrameLayout.LayoutParams) layoutParams2).setMarginStart((int) ((((float) this.destination) * f) + ((((float) 1) - f) * ((float) this.startPosition))));
            view2.setLayoutParams(layoutParams2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$CvcSlideStartAnimation;", "Lcom/stripe/android/view/CardInputWidget$CardFieldAnimation;", "view", "Landroid/view/View;", "startPosition", "", "destination", "newWidth", "(Landroid/view/View;III)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    private static final class CvcSlideStartAnimation extends CardFieldAnimation {
        private final int destination;
        private final int newWidth;
        private final int startPosition;
        private final View view;

        public CvcSlideStartAnimation(View view2, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            this.startPosition = i;
            this.destination = i2;
            this.newWidth = i3;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            Intrinsics.checkNotNullParameter(transformation, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT);
            super.applyTransformation(f, transformation);
            View view2 = this.view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams3.setMarginStart((int) ((((float) this.destination) * f) + ((((float) 1) - f) * ((float) this.startPosition))));
            layoutParams3.setMarginEnd(0);
            layoutParams3.width = this.newWidth;
            view2.setLayoutParams(layoutParams2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$PostalCodeSlideStartAnimation;", "Lcom/stripe/android/view/CardInputWidget$CardFieldAnimation;", "view", "Landroid/view/View;", "startPosition", "", "destination", "newWidth", "(Landroid/view/View;III)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    private static final class PostalCodeSlideStartAnimation extends CardFieldAnimation {
        private final int destination;
        private final int newWidth;
        private final int startPosition;
        private final View view;

        public PostalCodeSlideStartAnimation(View view2, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            this.startPosition = i;
            this.destination = i2;
            this.newWidth = i3;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            View view2 = this.view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams3.setMarginStart((int) ((((float) this.destination) * f) + ((((float) 1) - f) * ((float) this.startPosition))));
            layoutParams3.setMarginEnd(0);
            layoutParams3.width = this.newWidth;
            view2.setLayoutParams(layoutParams2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$CardNumberSlideEndAnimation;", "Lcom/stripe/android/view/CardInputWidget$CardFieldAnimation;", "view", "Landroid/view/View;", "hiddenCardWidth", "", "focusOnEndView", "(Landroid/view/View;ILandroid/view/View;)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    private static final class CardNumberSlideEndAnimation extends CardFieldAnimation {
        /* access modifiers changed from: private */
        public final View focusOnEndView;
        private final int hiddenCardWidth;
        private final View view;

        public CardNumberSlideEndAnimation(View view2, int i, View view3) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(view3, "focusOnEndView");
            this.view = view2;
            this.hiddenCardWidth = i;
            this.focusOnEndView = view3;
            setAnimationListener(new AnimationEndListener(this) {
                final /* synthetic */ CardNumberSlideEndAnimation this$0;

                {
                    this.this$0 = r1;
                }

                public void onAnimationEnd(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.focusOnEndView.requestFocus();
                }
            });
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            Intrinsics.checkNotNullParameter(transformation, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT);
            super.applyTransformation(f, transformation);
            View view2 = this.view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            ((FrameLayout.LayoutParams) layoutParams2).setMarginStart((int) (((float) this.hiddenCardWidth) * -1.0f * f));
            view2.setLayoutParams(layoutParams2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$ExpiryDateSlideEndAnimation;", "Lcom/stripe/android/view/CardInputWidget$CardFieldAnimation;", "view", "Landroid/view/View;", "startMargin", "", "destination", "(Landroid/view/View;II)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    private static final class ExpiryDateSlideEndAnimation extends CardFieldAnimation {
        private final int destination;
        private final int startMargin;
        private final View view;

        public ExpiryDateSlideEndAnimation(View view2, int i, int i2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            this.startMargin = i;
            this.destination = i2;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            Intrinsics.checkNotNullParameter(transformation, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT);
            super.applyTransformation(f, transformation);
            View view2 = this.view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            ((FrameLayout.LayoutParams) layoutParams2).setMarginStart((int) ((((float) this.destination) * f) + ((((float) 1) - f) * ((float) this.startMargin))));
            view2.setLayoutParams(layoutParams2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$CvcSlideEndAnimation;", "Lcom/stripe/android/view/CardInputWidget$CardFieldAnimation;", "view", "Landroid/view/View;", "startMargin", "", "destination", "newWidth", "(Landroid/view/View;III)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    private static final class CvcSlideEndAnimation extends CardFieldAnimation {
        private final int destination;
        private final int newWidth;
        private final int startMargin;
        private final View view;

        public CvcSlideEndAnimation(View view2, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            this.startMargin = i;
            this.destination = i2;
            this.newWidth = i3;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            Intrinsics.checkNotNullParameter(transformation, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT);
            super.applyTransformation(f, transformation);
            View view2 = this.view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams3.setMarginStart((int) ((((float) this.destination) * f) + ((((float) 1) - f) * ((float) this.startMargin))));
            layoutParams3.setMarginEnd(0);
            layoutParams3.width = this.newWidth;
            view2.setLayoutParams(layoutParams2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$PostalCodeSlideEndAnimation;", "Lcom/stripe/android/view/CardInputWidget$CardFieldAnimation;", "view", "Landroid/view/View;", "startMargin", "", "destination", "newWidth", "(Landroid/view/View;III)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    private static final class PostalCodeSlideEndAnimation extends CardFieldAnimation {
        private final int destination;
        private final int newWidth;
        private final int startMargin;
        private final View view;

        public PostalCodeSlideEndAnimation(View view2, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            this.startMargin = i;
            this.destination = i2;
            this.newWidth = i3;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            Intrinsics.checkNotNullParameter(transformation, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT);
            super.applyTransformation(f, transformation);
            View view2 = this.view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams3.setMarginStart((int) ((((float) this.destination) * f) + ((((float) 1) - f) * ((float) this.startMargin))));
            layoutParams3.setMarginEnd(0);
            layoutParams3.width = this.newWidth;
            view2.setLayoutParams(layoutParams2);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$DefaultLayoutWidthCalculator;", "Lcom/stripe/android/view/CardInputWidget$LayoutWidthCalculator;", "()V", "calculate", "", "text", "", "paint", "Landroid/text/TextPaint;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    public static final class DefaultLayoutWidthCalculator implements LayoutWidthCalculator {
        public int calculate(String str, TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(textPaint, "paint");
            return (int) Layout.getDesiredWidth(str, textPaint);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\b\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/view/CardInputWidget$Companion;", "", "()V", "CVC_PLACEHOLDER_AMEX", "", "CVC_PLACEHOLDER_COMMON", "DEFAULT_READER_ID", "", "FULL_SIZING_CARD_TEXT", "FULL_SIZING_DATE_TEXT", "FULL_SIZING_POSTAL_CODE_TEXT", "LOGGING_TOKEN", "STATE_CARD_VIEWED", "STATE_POSTAL_CODE_ENABLED", "STATE_SUPER_STATE", "shouldIconShowBrand", "", "brand", "Lcom/stripe/android/model/CardBrand;", "cvcHasFocus", "cvcText", "shouldIconShowBrand$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean shouldIconShowBrand$payments_core_release(CardBrand cardBrand, boolean z, String str) {
            Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
            return !z || cardBrand.isMaxCvc(str);
        }
    }

    private final void updateFieldLayout(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        layoutParams3.width = i;
        layoutParams3.setMarginStart(i2);
        view.setLayoutParams(layoutParams2);
    }
}
