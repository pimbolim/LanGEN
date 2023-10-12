package com.stripe.android.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.R;
import com.stripe.android.cards.CardNumber;
import com.stripe.android.databinding.CardMultilineWidgetBinding;
import com.stripe.android.model.Address;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.ExpirationDate;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.view.CardInputListener;
import com.stripe.android.view.PostalCodeEditText;
import com.stripe.android.view.StripeEditText;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000ù\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b%*\u00017\b\u0007\u0018\u0000 Ó\u00012\u00020\u00012\u00020\u0002:\u0006Ñ\u0001Ò\u0001Ó\u0001B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0001\u001a\u00030\u00012\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020\u0012H\u0007J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010a\u001a\u00020\nH\u0016J\t\u0010 \u0001\u001a\u00020\nH\u0002J\n\u0010¡\u0001\u001a\u00030\u0001H\u0014J\u0013\u0010¢\u0001\u001a\u00030\u00012\u0007\u0010£\u0001\u001a\u00020\nH\u0016J\u0015\u0010¤\u0001\u001a\u00030\u00012\t\u0010¥\u0001\u001a\u0004\u0018\u00010kH\u0007J\u0013\u0010¦\u0001\u001a\u00030\u00012\u0007\u0010§\u0001\u001a\u00020:H\u0016J\u0015\u0010¨\u0001\u001a\u00030\u00012\t\u0010©\u0001\u001a\u0004\u0018\u00010 H\u0016J\u0015\u0010ª\u0001\u001a\u00030\u00012\t\u0010«\u0001\u001a\u0004\u0018\u00010:H\u0016J\u0013\u0010¬\u0001\u001a\u00030\u00012\u0007\u0010©\u0001\u001a\u00020%H\u0007J\u0016\u0010­\u0001\u001a\u00030\u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0016J\u0015\u0010°\u0001\u001a\u00030\u00012\t\u0010±\u0001\u001a\u0004\u0018\u000105H\u0016J\u0015\u0010²\u0001\u001a\u00030\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010:H\u0016J\u0013\u0010´\u0001\u001a\u00030\u00012\u0007\u0010©\u0001\u001a\u00020%H\u0007J\u001a\u0010µ\u0001\u001a\u00030\u00012\t\u0010¶\u0001\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010TJ\u0013\u0010·\u0001\u001a\u00030\u00012\t\u0010¸\u0001\u001a\u0004\u0018\u00010:J\u0016\u0010¹\u0001\u001a\u00030\u00012\n\u0010º\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0016J\u0015\u0010»\u0001\u001a\u00030\u00012\t\u0010¼\u0001\u001a\u0004\u0018\u00010:H\u0007J\u0013\u0010½\u0001\u001a\u00030\u00012\u0007\u0010¾\u0001\u001a\u00020\nH\u0016J\u0013\u0010¿\u0001\u001a\u00030\u00012\u0007\u0010©\u0001\u001a\u00020%H\u0007J\u001c\u0010À\u0001\u001a\u00030\u00012\u000b\b\u0001\u0010¶\u0001\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010TJ \u0010Á\u0001\u001a\u00030\u00012\t\b\u0001\u0010Â\u0001\u001a\u00020\b2\t\b\u0001\u0010Ã\u0001\u001a\u00020\bH\u0016J\u0016\u0010Ä\u0001\u001a\u00030\u00012\n\u0010Å\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0016J\u0015\u0010Æ\u0001\u001a\u00030\u00012\t\u0010©\u0001\u001a\u0004\u0018\u00010%H\u0007J\u0016\u0010Ç\u0001\u001a\u00030\u00012\n\u0010È\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0016J\u0010\u0010É\u0001\u001a\u00030\u00012\u0006\u0010\t\u001a\u00020\nJ\n\u0010Ê\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ë\u0001\u001a\u00030\u0001H\u0002J\u001e\u0010Ì\u0001\u001a\u00030\u00012\u0007\u0010Í\u0001\u001a\u00020\u000e2\t\b\u0001\u0010Î\u0001\u001a\u00020\bH\u0002J\u0007\u0010Ï\u0001\u001a\u00020\nJ\u0007\u0010Ð\u0001\u001a\u00020\nR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178@@@X\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\u00020\"8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R+\u0010&\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020%8@@@X\u0002¢\u0006\u0012\n\u0004\b+\u0010\u001e\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020-8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u000207X\u0004¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\u00020=8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R+\u0010@\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020%8@@@X\u0002¢\u0006\u0012\n\u0004\bC\u0010\u001e\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R\u0016\u0010D\u001a\u00020E8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0016\u0010H\u001a\u0004\u0018\u00010I8BX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR+\u0010L\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020%8@@@X\u0002¢\u0006\u0012\n\u0004\bO\u0010\u001e\u001a\u0004\bM\u0010(\"\u0004\bN\u0010*R/\u0010P\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b8@@@X\u0002¢\u0006\u0012\n\u0004\bU\u0010\u001e\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020W8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020E8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010GR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]8@X\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010b\u001a\u0004\u0018\u00010c8F¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0013\u0010f\u001a\u0004\u0018\u00010g8F¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0016\u0010j\u001a\u0004\u0018\u00010k8VX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0016\u0010n\u001a\u0004\u0018\u00010o8VX\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020s8\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010uR/\u0010v\u001a\u0004\u0018\u00010%2\b\u0010\u0016\u001a\u0004\u0018\u00010%8@@@X\u0002¢\u0006\u0012\n\u0004\by\u0010\u001e\u001a\u0004\bw\u0010(\"\u0004\bx\u0010*R\u001a\u0010z\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u0015\u0010\u001a\u00020EX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010GR\u0019\u0010\u0001\u001a\u00020\u00018\u0006X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R2\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n8\u0000@@X\u000e¢\u0006\u0018\n\u0000\u0012\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010|\"\u0005\b\u0001\u0010~R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020E0\u0001X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n8F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010\u001e\u001a\u0005\b\u0001\u0010|\"\u0005\b\u0001\u0010~R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006Ô\u0001"}, d2 = {"Lcom/stripe/android/view/CardMultilineWidget;", "Landroid/widget/LinearLayout;", "Lcom/stripe/android/view/CardWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "shouldShowPostalCode", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "allFields", "", "Lcom/stripe/android/view/StripeEditText;", "getAllFields", "()Ljava/util/Collection;", "brand", "Lcom/stripe/android/model/CardBrand;", "getBrand$payments_core_release", "()Lcom/stripe/android/model/CardBrand;", "cardBrand", "<set-?>", "Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", "cardBrandIconSupplier", "getCardBrandIconSupplier$payments_core_release", "()Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", "setCardBrandIconSupplier$payments_core_release", "(Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;)V", "cardBrandIconSupplier$delegate", "Lkotlin/properties/ReadWriteProperty;", "cardInputListener", "Lcom/stripe/android/view/CardInputListener;", "cardNumberEditText", "Lcom/stripe/android/view/CardNumberEditText;", "getCardNumberEditText", "()Lcom/stripe/android/view/CardNumberEditText;", "Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", "cardNumberErrorListener", "getCardNumberErrorListener$payments_core_release", "()Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", "setCardNumberErrorListener$payments_core_release", "(Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;)V", "cardNumberErrorListener$delegate", "cardNumberTextInputLayout", "Lcom/stripe/android/view/CardNumberTextInputLayout;", "getCardNumberTextInputLayout", "()Lcom/stripe/android/view/CardNumberTextInputLayout;", "cardParams", "Lcom/stripe/android/model/CardParams;", "getCardParams", "()Lcom/stripe/android/model/CardParams;", "cardValidCallback", "Lcom/stripe/android/view/CardValidCallback;", "cardValidTextWatcher", "com/stripe/android/view/CardMultilineWidget$cardValidTextWatcher$1", "Lcom/stripe/android/view/CardMultilineWidget$cardValidTextWatcher$1;", "customCvcLabel", "", "customCvcPlaceholderText", "cvcEditText", "Lcom/stripe/android/view/CvcEditText;", "getCvcEditText", "()Lcom/stripe/android/view/CvcEditText;", "cvcErrorListener", "getCvcErrorListener$payments_core_release", "setCvcErrorListener$payments_core_release", "cvcErrorListener$delegate", "cvcInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "getCvcInputLayout", "()Lcom/google/android/material/textfield/TextInputLayout;", "expirationDate", "Lcom/stripe/android/model/ExpirationDate$Validated;", "getExpirationDate", "()Lcom/stripe/android/model/ExpirationDate$Validated;", "expirationDateErrorListener", "getExpirationDateErrorListener$payments_core_release", "setExpirationDateErrorListener$payments_core_release", "expirationDateErrorListener$delegate", "expirationDatePlaceholderRes", "getExpirationDatePlaceholderRes$payments_core_release", "()Ljava/lang/Integer;", "setExpirationDatePlaceholderRes$payments_core_release", "(Ljava/lang/Integer;)V", "expirationDatePlaceholderRes$delegate", "expiryDateEditText", "Lcom/stripe/android/view/ExpiryDateEditText;", "getExpiryDateEditText", "()Lcom/stripe/android/view/ExpiryDateEditText;", "expiryTextInputLayout", "getExpiryTextInputLayout", "invalidFields", "", "Lcom/stripe/android/view/CardValidCallback$Fields;", "getInvalidFields$payments_core_release", "()Ljava/util/Set;", "isEnabled", "paymentMethodBillingDetails", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "getPaymentMethodBillingDetails", "()Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "paymentMethodBillingDetailsBuilder", "Lcom/stripe/android/model/PaymentMethod$BillingDetails$Builder;", "getPaymentMethodBillingDetailsBuilder", "()Lcom/stripe/android/model/PaymentMethod$BillingDetails$Builder;", "paymentMethodCard", "Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "getPaymentMethodCard", "()Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "getPaymentMethodCreateParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "postalCodeEditText", "Lcom/stripe/android/view/PostalCodeEditText;", "getPostalCodeEditText$payments_core_release", "()Lcom/stripe/android/view/PostalCodeEditText;", "postalCodeErrorListener", "getPostalCodeErrorListener$payments_core_release", "setPostalCodeErrorListener$payments_core_release", "postalCodeErrorListener$delegate", "postalCodeRequired", "getPostalCodeRequired", "()Z", "setPostalCodeRequired", "(Z)V", "postalInputLayout", "getPostalInputLayout$payments_core_release", "secondRowLayout", "getSecondRowLayout", "()Landroid/widget/LinearLayout;", "value", "shouldShowErrorIcon", "getShouldShowErrorIcon$payments_core_release$annotations", "()V", "getShouldShowErrorIcon$payments_core_release", "setShouldShowErrorIcon$payments_core_release", "showCvcIconInCvcField", "textInputLayouts", "", "usZipCodeRequired", "getUsZipCodeRequired", "setUsZipCodeRequired", "usZipCodeRequired$delegate", "validatedCardNumber", "Lcom/stripe/android/cards/CardNumber$Validated;", "getValidatedCardNumber$payments_core_release", "()Lcom/stripe/android/cards/CardNumber$Validated;", "viewBinding", "Lcom/stripe/android/databinding/CardMultilineWidgetBinding;", "adjustViewForPostalCodeAttribute", "", "checkAttributeSet", "clear", "flipToCvcIconIfNotFinished", "getBrand", "initDeleteEmptyListeners", "initFocusChangeListeners", "initTextInputLayoutErrorHandlers", "isPostalRequired", "onAttachedToWindow", "onWindowFocusChanged", "hasWindowFocus", "populate", "card", "setCardHint", "cardHint", "setCardInputListener", "listener", "setCardNumber", "cardNumber", "setCardNumberErrorListener", "setCardNumberTextWatcher", "cardNumberTextWatcher", "Landroid/text/TextWatcher;", "setCardValidCallback", "callback", "setCvcCode", "cvcCode", "setCvcErrorListener", "setCvcIcon", "resId", "setCvcLabel", "cvcLabel", "setCvcNumberTextWatcher", "cvcNumberTextWatcher", "setCvcPlaceholderText", "cvcPlaceholderText", "setEnabled", "enabled", "setExpirationDateErrorListener", "setExpirationDatePlaceholderRes", "setExpiryDate", "month", "year", "setExpiryDateTextWatcher", "expiryDateTextWatcher", "setPostalCodeErrorListener", "setPostalCodeTextWatcher", "postalCodeTextWatcher", "setShouldShowPostalCode", "updateBrandUi", "updateCvc", "updateEndIcon", "editText", "iconResourceId", "validateAllFields", "validateCardNumber", "CardBrandIcon", "CardBrandIconSupplier", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardMultilineWidget.kt */
public final class CardMultilineWidget extends LinearLayout implements CardWidget {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    @Deprecated
    private static final String CARD_MULTILINE_TOKEN = "CardMultilineView";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final CardBrandIconSupplier DEFAULT_CARD_BRAND_ICON_SUPPLIER = CardMultilineWidget$Companion$DEFAULT_CARD_BRAND_ICON_SUPPLIER$1.INSTANCE;
    /* access modifiers changed from: private */
    public CardBrand cardBrand;
    private final ReadWriteProperty cardBrandIconSupplier$delegate;
    /* access modifiers changed from: private */
    public CardInputListener cardInputListener;
    private final CardNumberEditText cardNumberEditText;
    private final ReadWriteProperty cardNumberErrorListener$delegate;
    private final CardNumberTextInputLayout cardNumberTextInputLayout;
    /* access modifiers changed from: private */
    public CardValidCallback cardValidCallback;
    private final CardMultilineWidget$cardValidTextWatcher$1 cardValidTextWatcher;
    private String customCvcLabel;
    private String customCvcPlaceholderText;
    private final CvcEditText cvcEditText;
    private final ReadWriteProperty cvcErrorListener$delegate;
    private final TextInputLayout cvcInputLayout;
    private final ReadWriteProperty expirationDateErrorListener$delegate;
    private final ReadWriteProperty expirationDatePlaceholderRes$delegate;
    private final ExpiryDateEditText expiryDateEditText;
    private final TextInputLayout expiryTextInputLayout;
    private boolean isEnabled;
    private final PostalCodeEditText postalCodeEditText;
    private final ReadWriteProperty postalCodeErrorListener$delegate;
    private boolean postalCodeRequired;
    private final TextInputLayout postalInputLayout;
    private final LinearLayout secondRowLayout;
    private boolean shouldShowErrorIcon;
    /* access modifiers changed from: private */
    public boolean shouldShowPostalCode;
    /* access modifiers changed from: private */
    public boolean showCvcIconInCvcField;
    private final List<TextInputLayout> textInputLayouts;
    private final ReadWriteProperty usZipCodeRequired$delegate;
    private final CardMultilineWidgetBinding viewBinding;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", "", "get", "Lcom/stripe/android/view/CardMultilineWidget$CardBrandIcon;", "cardBrand", "Lcom/stripe/android/model/CardBrand;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardMultilineWidget.kt */
    public interface CardBrandIconSupplier {
        CardBrandIcon get(CardBrand cardBrand);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardMultilineWidget(Context context) {
        this(context, (AttributeSet) null, 0, false, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardMultilineWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, false, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardMultilineWidget(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getShouldShowErrorIcon$payments_core_release$annotations() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardMultilineWidget(Context context, AttributeSet attributeSet, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? true : z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardMultilineWidget(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.shouldShowPostalCode = z;
        CardMultilineWidgetBinding inflate = CardMultilineWidgetBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI…text),\n        this\n    )");
        this.viewBinding = inflate;
        CardNumberEditText cardNumberEditText2 = inflate.etCardNumber;
        Intrinsics.checkNotNullExpressionValue(cardNumberEditText2, "viewBinding.etCardNumber");
        this.cardNumberEditText = cardNumberEditText2;
        ExpiryDateEditText expiryDateEditText2 = inflate.etExpiry;
        Intrinsics.checkNotNullExpressionValue(expiryDateEditText2, "viewBinding.etExpiry");
        this.expiryDateEditText = expiryDateEditText2;
        CvcEditText cvcEditText2 = inflate.etCvc;
        Intrinsics.checkNotNullExpressionValue(cvcEditText2, "viewBinding.etCvc");
        this.cvcEditText = cvcEditText2;
        PostalCodeEditText postalCodeEditText2 = inflate.etPostalCode;
        Intrinsics.checkNotNullExpressionValue(postalCodeEditText2, "viewBinding.etPostalCode");
        this.postalCodeEditText = postalCodeEditText2;
        LinearLayout linearLayout = inflate.secondRowLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.secondRowLayout");
        this.secondRowLayout = linearLayout;
        CardNumberTextInputLayout cardNumberTextInputLayout2 = inflate.tlCardNumber;
        Intrinsics.checkNotNullExpressionValue(cardNumberTextInputLayout2, "viewBinding.tlCardNumber");
        this.cardNumberTextInputLayout = cardNumberTextInputLayout2;
        TextInputLayout textInputLayout = inflate.tlExpiry;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "viewBinding.tlExpiry");
        this.expiryTextInputLayout = textInputLayout;
        TextInputLayout textInputLayout2 = inflate.tlCvc;
        Intrinsics.checkNotNullExpressionValue(textInputLayout2, "viewBinding.tlCvc");
        this.cvcInputLayout = textInputLayout2;
        TextInputLayout textInputLayout3 = inflate.tlPostalCode;
        Intrinsics.checkNotNullExpressionValue(textInputLayout3, "viewBinding.tlPostalCode");
        this.postalInputLayout = textInputLayout3;
        List<TextInputLayout> listOf = CollectionsKt.listOf(cardNumberTextInputLayout2, textInputLayout, textInputLayout2, textInputLayout3);
        this.textInputLayouts = listOf;
        this.cardValidTextWatcher = new CardMultilineWidget$cardValidTextWatcher$1(this);
        this.cardBrand = CardBrand.Unknown;
        Delegates delegates = Delegates.INSTANCE;
        this.usZipCodeRequired$delegate = new CardMultilineWidget$special$$inlined$observable$1(false, this);
        Delegates delegates2 = Delegates.INSTANCE;
        this.expirationDatePlaceholderRes$delegate = new CardMultilineWidget$special$$inlined$observable$2(Integer.valueOf(R.string.expiry_date_hint), this);
        Delegates delegates3 = Delegates.INSTANCE;
        this.cardBrandIconSupplier$delegate = new CardMultilineWidget$special$$inlined$observable$3(DEFAULT_CARD_BRAND_ICON_SUPPLIER, this);
        Delegates delegates4 = Delegates.INSTANCE;
        this.cardNumberErrorListener$delegate = new CardMultilineWidget$special$$inlined$observable$4(new ErrorListener(cardNumberTextInputLayout2), this);
        Delegates delegates5 = Delegates.INSTANCE;
        this.expirationDateErrorListener$delegate = new CardMultilineWidget$special$$inlined$observable$5(new ErrorListener(textInputLayout), this);
        Delegates delegates6 = Delegates.INSTANCE;
        this.cvcErrorListener$delegate = new CardMultilineWidget$special$$inlined$observable$6(new ErrorListener(textInputLayout2), this);
        Delegates delegates7 = Delegates.INSTANCE;
        this.postalCodeErrorListener$delegate = new CardMultilineWidget$special$$inlined$observable$7(new ErrorListener(textInputLayout3), this);
        setOrientation(1);
        Iterator it = listOf.iterator();
        while (true) {
            ColorStateList colorStateList = null;
            if (!it.hasNext()) {
                break;
            }
            TextInputLayout textInputLayout4 = (TextInputLayout) it.next();
            EditText editText = textInputLayout4.getEditText();
            if (editText != null) {
                colorStateList = editText.getHintTextColors();
            }
            textInputLayout4.setPlaceholderTextColor(colorStateList);
        }
        checkAttributeSet(attributeSet);
        initTextInputLayoutErrorHandlers();
        initFocusChangeListeners();
        initDeleteEmptyListeners();
        this.cardNumberEditText.setCompletionCallback$payments_core_release(new Function0<Unit>(this) {
            final /* synthetic */ CardMultilineWidget this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.getExpiryDateEditText().requestFocus();
                CardInputListener access$getCardInputListener$p = this.this$0.cardInputListener;
                if (access$getCardInputListener$p != null) {
                    access$getCardInputListener$p.onCardComplete();
                }
            }
        });
        this.cardNumberEditText.setBrandChangeCallback$payments_core_release(new Function1<CardBrand, Unit>(this) {
            final /* synthetic */ CardMultilineWidget this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CardBrand) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(CardBrand cardBrand) {
                Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
                this.this$0.cardBrand = cardBrand;
                this.this$0.updateBrandUi();
            }
        });
        this.expiryDateEditText.setCompletionCallback$payments_core_release(new Function0<Unit>(this) {
            final /* synthetic */ CardMultilineWidget this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.getCvcEditText().requestFocus();
                CardInputListener access$getCardInputListener$p = this.this$0.cardInputListener;
                if (access$getCardInputListener$p != null) {
                    access$getCardInputListener$p.onExpirationComplete();
                }
            }
        });
        this.cvcEditText.setAfterTextChangedListener(new StripeEditText.AfterTextChangedListener(this) {
            final /* synthetic */ CardMultilineWidget this$0;

            {
                this.this$0 = r1;
            }

            public final void onTextChanged(String str) {
                Intrinsics.checkNotNullParameter(str, "text");
                if (this.this$0.cardBrand.isMaxCvc(str)) {
                    this.this$0.updateBrandUi();
                    if (this.this$0.shouldShowPostalCode) {
                        this.this$0.getPostalCodeEditText$payments_core_release().requestFocus();
                    }
                    CardInputListener access$getCardInputListener$p = this.this$0.cardInputListener;
                    if (access$getCardInputListener$p != null) {
                        access$getCardInputListener$p.onCvcComplete();
                    }
                } else if (!this.this$0.showCvcIconInCvcField) {
                    this.this$0.flipToCvcIconIfNotFinished();
                }
                this.this$0.getCvcEditText().setShouldShowError(false);
            }
        });
        this.postalCodeEditText.setAfterTextChangedListener(new StripeEditText.AfterTextChangedListener(this) {
            final /* synthetic */ CardMultilineWidget this$0;

            {
                this.this$0 = r1;
            }

            public final void onTextChanged(String str) {
                CardInputListener access$getCardInputListener$p;
                Intrinsics.checkNotNullParameter(str, "it");
                if (this.this$0.isPostalRequired() && this.this$0.getPostalCodeEditText$payments_core_release().hasValidPostal$payments_core_release() && (access$getCardInputListener$p = this.this$0.cardInputListener) != null) {
                    access$getCardInputListener$p.onPostalCodeComplete();
                }
            }
        });
        adjustViewForPostalCodeAttribute(this.shouldShowPostalCode);
        CardNumberEditText.updateLengthFilter$payments_core_release$default(this.cardNumberEditText, 0, 1, (Object) null);
        this.cardBrand = CardBrand.Unknown;
        updateBrandUi();
        for (StripeEditText addTextChangedListener : getAllFields()) {
            addTextChangedListener.addTextChangedListener(new CardMultilineWidget$_init_$lambda18$$inlined$doAfterTextChanged$1(this));
        }
        this.cardNumberEditText.setLoadingCallback$payments_core_release(new Function1<Boolean, Unit>(this) {
            final /* synthetic */ CardMultilineWidget this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                this.this$0.getCardNumberTextInputLayout().setLoading$payments_core_release(z);
            }
        });
        this.postalCodeEditText.setConfig$payments_core_release(PostalCodeEditText.Config.Global);
        this.isEnabled = true;
    }

    public final CardNumberEditText getCardNumberEditText() {
        return this.cardNumberEditText;
    }

    public final ExpiryDateEditText getExpiryDateEditText() {
        return this.expiryDateEditText;
    }

    public final CvcEditText getCvcEditText() {
        return this.cvcEditText;
    }

    public final PostalCodeEditText getPostalCodeEditText$payments_core_release() {
        return this.postalCodeEditText;
    }

    public final LinearLayout getSecondRowLayout() {
        return this.secondRowLayout;
    }

    public final CardNumberTextInputLayout getCardNumberTextInputLayout() {
        return this.cardNumberTextInputLayout;
    }

    public final TextInputLayout getExpiryTextInputLayout() {
        return this.expiryTextInputLayout;
    }

    public final TextInputLayout getCvcInputLayout() {
        return this.cvcInputLayout;
    }

    public final TextInputLayout getPostalInputLayout$payments_core_release() {
        return this.postalInputLayout;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        if ((r6 == null || kotlin.text.StringsKt.isBlank(r6)) != false) goto L_0x0061;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set<com.stripe.android.view.CardValidCallback.Fields> getInvalidFields$payments_core_release() {
        /*
            r7 = this;
            r0 = 4
            com.stripe.android.view.CardValidCallback$Fields[] r0 = new com.stripe.android.view.CardValidCallback.Fields[r0]
            com.stripe.android.view.CardValidCallback$Fields r1 = com.stripe.android.view.CardValidCallback.Fields.Number
            com.stripe.android.cards.CardNumber$Validated r2 = r7.getValidatedCardNumber$payments_core_release()
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x000f
            r2 = 1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            r5 = 0
            if (r2 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = r5
        L_0x0015:
            r0[r4] = r1
            com.stripe.android.view.CardValidCallback$Fields r1 = com.stripe.android.view.CardValidCallback.Fields.Expiry
            com.stripe.android.model.ExpirationDate$Validated r2 = r7.getExpirationDate()
            if (r2 != 0) goto L_0x0021
            r2 = 1
            goto L_0x0022
        L_0x0021:
            r2 = 0
        L_0x0022:
            if (r2 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r1 = r5
        L_0x0026:
            r0[r3] = r1
            r1 = 2
            com.stripe.android.view.CardValidCallback$Fields r2 = com.stripe.android.view.CardValidCallback.Fields.Cvc
            com.stripe.android.view.CvcEditText r6 = r7.getCvcEditText()
            com.stripe.android.cards.Cvc$Validated r6 = r6.getCvc$payments_core_release()
            if (r6 != 0) goto L_0x0037
            r6 = 1
            goto L_0x0038
        L_0x0037:
            r6 = 0
        L_0x0038:
            if (r6 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r2 = r5
        L_0x003c:
            r0[r1] = r2
            r1 = 3
            com.stripe.android.view.CardValidCallback$Fields r2 = com.stripe.android.view.CardValidCallback.Fields.Postal
            boolean r6 = r7.isPostalRequired()
            if (r6 == 0) goto L_0x0060
            com.stripe.android.view.PostalCodeEditText r6 = r7.getPostalCodeEditText$payments_core_release()
            java.lang.String r6 = r6.getPostalCode$payments_core_release()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x005c
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r6 = 0
            goto L_0x005d
        L_0x005c:
            r6 = 1
        L_0x005d:
            if (r6 == 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r3 = 0
        L_0x0061:
            if (r3 == 0) goto L_0x0064
            r5 = r2
        L_0x0064:
            r0[r1] = r5
            java.util.List r0 = kotlin.collections.CollectionsKt.listOfNotNull((T[]) r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.CardMultilineWidget.getInvalidFields$payments_core_release():java.util.Set");
    }

    public final /* synthetic */ CardBrand getBrand$payments_core_release() {
        return this.cardBrand;
    }

    public final CardBrand getBrand() {
        return getBrand$payments_core_release();
    }

    public final boolean getPostalCodeRequired() {
        return this.postalCodeRequired;
    }

    public final void setPostalCodeRequired(boolean z) {
        this.postalCodeRequired = z;
    }

    static {
        Class<CardMultilineWidget> cls = CardMultilineWidget.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "usZipCodeRequired", "getUsZipCodeRequired()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "expirationDatePlaceholderRes", "getExpirationDatePlaceholderRes$payments_core_release()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "cardBrandIconSupplier", "getCardBrandIconSupplier$payments_core_release()Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "cardNumberErrorListener", "getCardNumberErrorListener$payments_core_release()Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "expirationDateErrorListener", "getExpirationDateErrorListener$payments_core_release()Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "cvcErrorListener", "getCvcErrorListener$payments_core_release()Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "postalCodeErrorListener", "getPostalCodeErrorListener$payments_core_release()Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", 0))};
    }

    public final boolean getUsZipCodeRequired() {
        return ((Boolean) this.usZipCodeRequired$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setUsZipCodeRequired(boolean z) {
        this.usZipCodeRequired$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final boolean isPostalRequired() {
        return (this.postalCodeRequired || getUsZipCodeRequired()) && this.shouldShowPostalCode;
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

    public PaymentMethodCreateParams getPaymentMethodCreateParams() {
        PaymentMethodCreateParams.Card paymentMethodCard = getPaymentMethodCard();
        if (paymentMethodCard == null) {
            return null;
        }
        return PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, paymentMethodCard, getPaymentMethodBillingDetails(), (Map) null, 4, (Object) null);
    }

    public final PaymentMethod.BillingDetails getPaymentMethodBillingDetails() {
        PaymentMethod.BillingDetails.Builder paymentMethodBillingDetailsBuilder = getPaymentMethodBillingDetailsBuilder();
        if (paymentMethodBillingDetailsBuilder == null) {
            return null;
        }
        return paymentMethodBillingDetailsBuilder.build();
    }

    public final PaymentMethod.BillingDetails.Builder getPaymentMethodBillingDetailsBuilder() {
        if (!this.shouldShowPostalCode || !validateAllFields()) {
            return null;
        }
        return new PaymentMethod.BillingDetails.Builder().setAddress(new Address.Builder().setPostalCode(this.postalCodeEditText.getPostalCode$payments_core_release()).build());
    }

    public CardParams getCardParams() {
        boolean z = true;
        String str = null;
        if (!validateAllFields()) {
            setShouldShowErrorIcon$payments_core_release(true);
            return null;
        }
        setShouldShowErrorIcon$payments_core_release(false);
        ExpirationDate.Validated validatedDate = this.expiryDateEditText.getValidatedDate();
        if (validatedDate != null) {
            Editable text = this.cvcEditText.getText();
            String obj = text == null ? null : text.toString();
            Editable text2 = this.postalCodeEditText.getText();
            String obj2 = text2 == null ? null : text2.toString();
            if (!this.shouldShowPostalCode) {
                obj2 = null;
            }
            CardBrand brand$payments_core_release = getBrand$payments_core_release();
            Set of = SetsKt.setOf(CARD_MULTILINE_TOKEN);
            CardNumber.Validated validatedCardNumber$payments_core_release = getValidatedCardNumber$payments_core_release();
            String value = validatedCardNumber$payments_core_release == null ? null : validatedCardNumber$payments_core_release.getValue();
            if (value == null) {
                value = "";
            }
            String str2 = value;
            int month = validatedDate.getMonth();
            int year = validatedDate.getYear();
            Address.Builder builder = new Address.Builder();
            CharSequence charSequence = obj2;
            if (charSequence != null && !StringsKt.isBlank(charSequence)) {
                z = false;
            }
            if (!z) {
                str = obj2;
            }
            return new CardParams(brand$payments_core_release, of, str2, month, year, obj, (String) null, builder.setPostalCode(str).build(), (String) null, (Map) null, LeicaMakernoteDirectory.TAG_IMAGE_ID_NUMBER, (DefaultConstructorMarker) null);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final CardNumber.Validated getValidatedCardNumber$payments_core_release() {
        return this.cardNumberEditText.getValidatedCardNumber$payments_core_release();
    }

    private final ExpirationDate.Validated getExpirationDate() {
        return this.expiryDateEditText.getValidatedDate();
    }

    private final Collection<StripeEditText> getAllFields() {
        return SetsKt.setOf(this.cardNumberEditText, this.expiryDateEditText, this.cvcEditText, this.postalCodeEditText);
    }

    public final boolean getShouldShowErrorIcon$payments_core_release() {
        return this.shouldShowErrorIcon;
    }

    public final void setShouldShowErrorIcon$payments_core_release(boolean z) {
        boolean z2 = this.shouldShowErrorIcon != z;
        this.shouldShowErrorIcon = z;
        if (z2) {
            updateBrandUi();
        }
    }

    public final Integer getExpirationDatePlaceholderRes$payments_core_release() {
        return (Integer) this.expirationDatePlaceholderRes$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setExpirationDatePlaceholderRes$payments_core_release(Integer num) {
        this.expirationDatePlaceholderRes$delegate.setValue(this, $$delegatedProperties[1], num);
    }

    public final void setExpirationDatePlaceholderRes(Integer num) {
        setExpirationDatePlaceholderRes$payments_core_release(num);
    }

    public final CardBrandIconSupplier getCardBrandIconSupplier$payments_core_release() {
        return (CardBrandIconSupplier) this.cardBrandIconSupplier$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setCardBrandIconSupplier$payments_core_release(CardBrandIconSupplier cardBrandIconSupplier) {
        Intrinsics.checkNotNullParameter(cardBrandIconSupplier, "<set-?>");
        this.cardBrandIconSupplier$delegate.setValue(this, $$delegatedProperties[2], cardBrandIconSupplier);
    }

    public final StripeEditText.ErrorMessageListener getCardNumberErrorListener$payments_core_release() {
        return (StripeEditText.ErrorMessageListener) this.cardNumberErrorListener$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setCardNumberErrorListener$payments_core_release(StripeEditText.ErrorMessageListener errorMessageListener) {
        Intrinsics.checkNotNullParameter(errorMessageListener, "<set-?>");
        this.cardNumberErrorListener$delegate.setValue(this, $$delegatedProperties[3], errorMessageListener);
    }

    public final void setCardNumberErrorListener(StripeEditText.ErrorMessageListener errorMessageListener) {
        Intrinsics.checkNotNullParameter(errorMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setCardNumberErrorListener$payments_core_release(errorMessageListener);
    }

    public final StripeEditText.ErrorMessageListener getExpirationDateErrorListener$payments_core_release() {
        return (StripeEditText.ErrorMessageListener) this.expirationDateErrorListener$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final void setExpirationDateErrorListener$payments_core_release(StripeEditText.ErrorMessageListener errorMessageListener) {
        Intrinsics.checkNotNullParameter(errorMessageListener, "<set-?>");
        this.expirationDateErrorListener$delegate.setValue(this, $$delegatedProperties[4], errorMessageListener);
    }

    public final void setExpirationDateErrorListener(StripeEditText.ErrorMessageListener errorMessageListener) {
        Intrinsics.checkNotNullParameter(errorMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setExpirationDateErrorListener$payments_core_release(errorMessageListener);
    }

    public final StripeEditText.ErrorMessageListener getCvcErrorListener$payments_core_release() {
        return (StripeEditText.ErrorMessageListener) this.cvcErrorListener$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void setCvcErrorListener$payments_core_release(StripeEditText.ErrorMessageListener errorMessageListener) {
        Intrinsics.checkNotNullParameter(errorMessageListener, "<set-?>");
        this.cvcErrorListener$delegate.setValue(this, $$delegatedProperties[5], errorMessageListener);
    }

    public final void setCvcErrorListener(StripeEditText.ErrorMessageListener errorMessageListener) {
        Intrinsics.checkNotNullParameter(errorMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setCvcErrorListener$payments_core_release(errorMessageListener);
    }

    public final StripeEditText.ErrorMessageListener getPostalCodeErrorListener$payments_core_release() {
        return (StripeEditText.ErrorMessageListener) this.postalCodeErrorListener$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final void setPostalCodeErrorListener$payments_core_release(StripeEditText.ErrorMessageListener errorMessageListener) {
        this.postalCodeErrorListener$delegate.setValue(this, $$delegatedProperties[6], errorMessageListener);
    }

    public final void setPostalCodeErrorListener(StripeEditText.ErrorMessageListener errorMessageListener) {
        setPostalCodeErrorListener$payments_core_release(errorMessageListener);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.cvcEditText.setHint((CharSequence) null);
    }

    public void clear() {
        this.cardNumberEditText.setText("");
        this.expiryDateEditText.setText("");
        this.cvcEditText.setText("");
        this.postalCodeEditText.setText("");
        this.cardNumberEditText.setShouldShowError(false);
        this.expiryDateEditText.setShouldShowError(false);
        this.cvcEditText.setShouldShowError(false);
        this.postalCodeEditText.setShouldShowError(false);
        this.cardBrand = CardBrand.Unknown;
        updateBrandUi();
    }

    public void setCardInputListener(CardInputListener cardInputListener2) {
        this.cardInputListener = cardInputListener2;
    }

    public void setCardValidCallback(CardValidCallback cardValidCallback2) {
        this.cardValidCallback = cardValidCallback2;
        for (StripeEditText removeTextChangedListener : getAllFields()) {
            removeTextChangedListener.removeTextChangedListener(this.cardValidTextWatcher);
        }
        if (cardValidCallback2 != null) {
            for (StripeEditText addTextChangedListener : getAllFields()) {
                addTextChangedListener.addTextChangedListener(this.cardValidTextWatcher);
            }
        }
        CardValidCallback cardValidCallback3 = this.cardValidCallback;
        if (cardValidCallback3 != null) {
            cardValidCallback3.onInputChanged(getInvalidFields$payments_core_release().isEmpty(), getInvalidFields$payments_core_release());
        }
    }

    public void setCardHint(String str) {
        Intrinsics.checkNotNullParameter(str, "cardHint");
        this.cardNumberTextInputLayout.setPlaceholderText(str);
    }

    public final void populate(PaymentMethodCreateParams.Card card) {
        Boolean bool;
        View findFocus;
        if (card != null) {
            View findFocus2 = findFocus();
            getCardNumberEditText().setText(card.getNumber$payments_core_release());
            getCvcEditText().setText(card.getCvc$payments_core_release());
            getExpiryDateEditText().setText$payments_core_release(card.getExpiryMonth$payments_core_release(), card.getExpiryYear$payments_core_release());
            if (findFocus2 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(findFocus2.requestFocus());
            }
            if (bool == null && (findFocus = findFocus()) != null) {
                findFocus.clearFocus();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean validateAllFields() {
        /*
            r8 = this;
            com.stripe.android.cards.CardNumber$Validated r0 = r8.getValidatedCardNumber$payments_core_release()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            com.stripe.android.model.ExpirationDate$Validated r3 = r8.getExpirationDate()
            if (r3 == 0) goto L_0x0013
            r3 = 1
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            com.stripe.android.view.CvcEditText r4 = r8.cvcEditText
            com.stripe.android.cards.Cvc$Validated r4 = r4.getCvc$payments_core_release()
            if (r4 == 0) goto L_0x001e
            r4 = 1
            goto L_0x001f
        L_0x001e:
            r4 = 0
        L_0x001f:
            com.stripe.android.view.CardNumberEditText r5 = r8.cardNumberEditText
            r6 = r0 ^ 1
            r5.setShouldShowError(r6)
            com.stripe.android.view.ExpiryDateEditText r5 = r8.expiryDateEditText
            r6 = r3 ^ 1
            r5.setShouldShowError(r6)
            com.stripe.android.view.CvcEditText r5 = r8.cvcEditText
            r6 = r4 ^ 1
            r5.setShouldShowError(r6)
            com.stripe.android.view.PostalCodeEditText r5 = r8.postalCodeEditText
            boolean r6 = r8.postalCodeRequired
            if (r6 != 0) goto L_0x0040
            boolean r6 = r8.getUsZipCodeRequired()
            if (r6 == 0) goto L_0x0058
        L_0x0040:
            com.stripe.android.view.PostalCodeEditText r6 = r8.postalCodeEditText
            java.lang.String r6 = r6.getPostalCode$payments_core_release()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0053
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r6 = 0
            goto L_0x0054
        L_0x0053:
            r6 = 1
        L_0x0054:
            if (r6 == 0) goto L_0x0058
            r6 = 1
            goto L_0x0059
        L_0x0058:
            r6 = 0
        L_0x0059:
            r5.setShouldShowError(r6)
            java.util.Collection r5 = r8.getAllFields()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0066:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x007a
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.stripe.android.view.StripeEditText r7 = (com.stripe.android.view.StripeEditText) r7
            boolean r7 = r7.getShouldShowError()
            if (r7 == 0) goto L_0x0066
            goto L_0x007b
        L_0x007a:
            r6 = 0
        L_0x007b:
            com.stripe.android.view.StripeEditText r6 = (com.stripe.android.view.StripeEditText) r6
            if (r6 != 0) goto L_0x0080
            goto L_0x0083
        L_0x0080:
            r6.requestFocus()
        L_0x0083:
            if (r0 == 0) goto L_0x0092
            if (r3 == 0) goto L_0x0092
            if (r4 == 0) goto L_0x0092
            com.stripe.android.view.PostalCodeEditText r0 = r8.postalCodeEditText
            boolean r0 = r0.getShouldShowError()
            if (r0 != 0) goto L_0x0092
            r1 = 1
        L_0x0092:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.CardMultilineWidget.validateAllFields():boolean");
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            updateBrandUi();
        }
    }

    public final void setCvcPlaceholderText(String str) {
        this.customCvcPlaceholderText = str;
        updateCvc();
    }

    public final void setCvcLabel(String str) {
        this.customCvcLabel = str;
        updateCvc();
    }

    public final /* synthetic */ void setCvcIcon(Integer num) {
        if (num != null) {
            updateEndIcon(this.cvcEditText, num.intValue());
        }
        this.showCvcIconInCvcField = num != null;
    }

    public final void setShouldShowPostalCode(boolean z) {
        this.shouldShowPostalCode = z;
        adjustViewForPostalCodeAttribute(z);
    }

    public void setCardNumber(String str) {
        this.cardNumberEditText.setText(str);
    }

    public void setExpiryDate(int i, int i2) {
        this.expiryDateEditText.setText(new ExpirationDate.Unvalidated(i, i2).getDisplayString());
    }

    public void setCvcCode(String str) {
        this.cvcEditText.setText(str);
    }

    public final boolean validateCardNumber() {
        boolean z = getValidatedCardNumber$payments_core_release() != null;
        this.cardNumberEditText.setShouldShowError(!z);
        return z;
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
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (TextInputLayout enabled : this.textInputLayouts) {
            enabled.setEnabled(z);
        }
        this.isEnabled = z;
    }

    private final void adjustViewForPostalCodeAttribute(boolean z) {
        int i;
        if (z) {
            i = R.string.expiry_label_short;
        } else {
            i = R.string.acc_label_expiry_date;
        }
        this.expiryTextInputLayout.setHint((CharSequence) getResources().getString(i));
        int i2 = z ? R.id.et_postal_code : -1;
        this.cvcEditText.setNextFocusForwardId(i2);
        this.cvcEditText.setNextFocusDownId(i2);
        int i3 = 0;
        int i4 = z ? 0 : 8;
        this.postalInputLayout.setVisibility(i4);
        this.cvcEditText.setImeOptions(i4 == 8 ? 6 : 5);
        View view = this.cvcInputLayout;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
        if (z) {
            i3 = getResources().getDimensionPixelSize(R.dimen.stripe_add_card_expiry_middle_margin);
        }
        layoutParams3.setMarginEnd(i3);
        view.setLayoutParams(layoutParams2);
    }

    private final void checkAttributeSet(AttributeSet attributeSet) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] iArr = R.styleable.CardElement;
        Intrinsics.checkNotNullExpressionValue(iArr, "CardElement");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.shouldShowPostalCode = obtainStyledAttributes.getBoolean(R.styleable.CardElement_shouldShowPostalCode, this.shouldShowPostalCode);
        setPostalCodeRequired(obtainStyledAttributes.getBoolean(R.styleable.CardElement_shouldRequirePostalCode, getPostalCodeRequired()));
        setUsZipCodeRequired(obtainStyledAttributes.getBoolean(R.styleable.CardElement_shouldRequireUsZipCode, getUsZipCodeRequired()));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: private */
    public final void flipToCvcIconIfNotFinished() {
        if (!this.cardBrand.isMaxCvc(this.cvcEditText.getFieldText$payments_core_release())) {
            if (this.shouldShowErrorIcon) {
                updateEndIcon(this.cardNumberEditText, this.cardBrand.getErrorIcon());
                return;
            }
            updateEndIcon(this.cardNumberEditText, this.cardBrand.getCvcIcon());
        }
    }

    private final void initDeleteEmptyListeners() {
        this.expiryDateEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(this.cardNumberEditText));
        this.cvcEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(this.expiryDateEditText));
        this.postalCodeEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(this.cvcEditText));
    }

    private final void initFocusChangeListeners() {
        this.cardNumberEditText.getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardMultilineWidget.m4646initFocusChangeListeners$lambda26(CardMultilineWidget.this, view, z);
            }
        });
        this.expiryDateEditText.getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardMultilineWidget.m4647initFocusChangeListeners$lambda27(CardMultilineWidget.this, view, z);
            }
        });
        this.cvcEditText.getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardMultilineWidget.m4648initFocusChangeListeners$lambda28(CardMultilineWidget.this, view, z);
            }
        });
        this.postalCodeEditText.getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardMultilineWidget.m4649initFocusChangeListeners$lambda29(CardMultilineWidget.this, view, z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: initFocusChangeListeners$lambda-26  reason: not valid java name */
    public static final void m4646initFocusChangeListeners$lambda26(CardMultilineWidget cardMultilineWidget, View view, boolean z) {
        CardInputListener cardInputListener2;
        Intrinsics.checkNotNullParameter(cardMultilineWidget, "this$0");
        if (z && (cardInputListener2 = cardMultilineWidget.cardInputListener) != null) {
            cardInputListener2.onFocusChange(CardInputListener.FocusField.CardNumber);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initFocusChangeListeners$lambda-27  reason: not valid java name */
    public static final void m4647initFocusChangeListeners$lambda27(CardMultilineWidget cardMultilineWidget, View view, boolean z) {
        CardInputListener cardInputListener2;
        Intrinsics.checkNotNullParameter(cardMultilineWidget, "this$0");
        if (z && (cardInputListener2 = cardMultilineWidget.cardInputListener) != null) {
            cardInputListener2.onFocusChange(CardInputListener.FocusField.ExpiryDate);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initFocusChangeListeners$lambda-28  reason: not valid java name */
    public static final void m4648initFocusChangeListeners$lambda28(CardMultilineWidget cardMultilineWidget, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardMultilineWidget, "this$0");
        if (z) {
            if (!cardMultilineWidget.showCvcIconInCvcField) {
                cardMultilineWidget.flipToCvcIconIfNotFinished();
            }
            CardInputListener cardInputListener2 = cardMultilineWidget.cardInputListener;
            if (cardInputListener2 != null) {
                cardInputListener2.onFocusChange(CardInputListener.FocusField.Cvc);
                return;
            }
            return;
        }
        cardMultilineWidget.updateBrandUi();
    }

    /* access modifiers changed from: private */
    /* renamed from: initFocusChangeListeners$lambda-29  reason: not valid java name */
    public static final void m4649initFocusChangeListeners$lambda29(CardMultilineWidget cardMultilineWidget, View view, boolean z) {
        CardInputListener cardInputListener2;
        Intrinsics.checkNotNullParameter(cardMultilineWidget, "this$0");
        if (cardMultilineWidget.shouldShowPostalCode && z && (cardInputListener2 = cardMultilineWidget.cardInputListener) != null) {
            cardInputListener2.onFocusChange(CardInputListener.FocusField.PostalCode);
        }
    }

    private final void initTextInputLayoutErrorHandlers() {
        this.cardNumberEditText.setErrorMessageListener(getCardNumberErrorListener$payments_core_release());
        this.expiryDateEditText.setErrorMessageListener(getExpirationDateErrorListener$payments_core_release());
        this.cvcEditText.setErrorMessageListener(getCvcErrorListener$payments_core_release());
        this.postalCodeEditText.setErrorMessageListener(getPostalCodeErrorListener$payments_core_release());
    }

    /* access modifiers changed from: private */
    public final void updateBrandUi() {
        updateCvc();
        if (this.shouldShowErrorIcon) {
            updateEndIcon(this.cardNumberEditText, this.cardBrand.getErrorIcon());
            return;
        }
        updateEndIcon(this.cardNumberEditText, getCardBrandIconSupplier$payments_core_release().get(this.cardBrand).getIconResourceId());
    }

    private final void updateCvc() {
        this.cvcEditText.updateBrand$payments_core_release(this.cardBrand, this.customCvcLabel, this.customCvcPlaceholderText, this.cvcInputLayout);
    }

    private final void updateEndIcon(StripeEditText stripeEditText, int i) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        if (drawable != null) {
            stripeEditText.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/view/CardMultilineWidget$CardBrandIcon;", "", "iconResourceId", "", "(I)V", "getIconResourceId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardMultilineWidget.kt */
    public static final class CardBrandIcon {
        private final int iconResourceId;

        public static /* synthetic */ CardBrandIcon copy$default(CardBrandIcon cardBrandIcon, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = cardBrandIcon.iconResourceId;
            }
            return cardBrandIcon.copy(i);
        }

        public final int component1() {
            return this.iconResourceId;
        }

        public final CardBrandIcon copy(int i) {
            return new CardBrandIcon(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CardBrandIcon) && this.iconResourceId == ((CardBrandIcon) obj).iconResourceId;
        }

        public int hashCode() {
            return this.iconResourceId;
        }

        public String toString() {
            return "CardBrandIcon(iconResourceId=" + this.iconResourceId + ')';
        }

        public CardBrandIcon(int i) {
            this.iconResourceId = i;
        }

        public final int getIconResourceId() {
            return this.iconResourceId;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/CardMultilineWidget$Companion;", "", "()V", "CARD_MULTILINE_TOKEN", "", "DEFAULT_CARD_BRAND_ICON_SUPPLIER", "Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardMultilineWidget.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
