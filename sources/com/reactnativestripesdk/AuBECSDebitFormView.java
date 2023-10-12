package com.reactnativestripesdk;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.henninghall.date_picker.props.TextColorProp;
import com.stripe.android.databinding.BecsDebitWidgetBinding;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.view.BecsDebitWidget;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\b\u0010\u0014\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reactnativestripesdk/AuBECSDebitFormView;", "Landroid/widget/FrameLayout;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "becsDebitWidget", "Lcom/stripe/android/view/BecsDebitWidget;", "formStyle", "Lcom/facebook/react/bridge/ReadableMap;", "mEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "onFormChanged", "", "params", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "setCompanyName", "name", "", "setFormStyle", "value", "setListeners", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AuBECSDebitFormView.kt */
public final class AuBECSDebitFormView extends FrameLayout {
    /* access modifiers changed from: private */
    public BecsDebitWidget becsDebitWidget;
    private final ThemedReactContext context;
    private ReadableMap formStyle;
    private EventDispatcher mEventDispatcher;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuBECSDebitFormView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        this.context = themedReactContext;
        UIManagerModule uIManagerModule = (UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class);
        this.mEventDispatcher = uIManagerModule == null ? null : uIManagerModule.getEventDispatcher();
    }

    public final void setCompanyName(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.String");
        this.becsDebitWidget = new BecsDebitWidget(this.context, (AttributeSet) null, 0, str, 6, (DefaultConstructorMarker) null);
        setFormStyle(this.formStyle);
        BecsDebitWidget becsDebitWidget2 = this.becsDebitWidget;
        if (becsDebitWidget2 != null) {
            addView(becsDebitWidget2);
            setListeners();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("becsDebitWidget");
        throw null;
    }

    public final void setFormStyle(ReadableMap readableMap) {
        this.formStyle = readableMap;
        BecsDebitWidget becsDebitWidget2 = this.becsDebitWidget;
        if (becsDebitWidget2 != null && readableMap != null) {
            if (becsDebitWidget2 != null) {
                BecsDebitWidgetBinding bind = BecsDebitWidgetBinding.bind(becsDebitWidget2);
                Intrinsics.checkNotNullExpressionValue(bind, "bind(becsDebitWidget)");
                String valOr = MappersKt.getValOr(readableMap, TextColorProp.name, (String) null);
                String valOr2 = MappersKt.getValOr(readableMap, "textErrorColor", (String) null);
                String valOr3 = MappersKt.getValOr(readableMap, "placeholderColor", (String) null);
                Integer intOrNull = MappersKt.getIntOrNull(readableMap, ViewProps.FONT_SIZE);
                Integer intOrNull2 = MappersKt.getIntOrNull(readableMap, ViewProps.BORDER_WIDTH);
                String valOr4 = MappersKt.getValOr(readableMap, ViewProps.BACKGROUND_COLOR, (String) null);
                String valOr5 = MappersKt.getValOr(readableMap, ViewProps.BORDER_COLOR, (String) null);
                Integer intOrNull3 = MappersKt.getIntOrNull(readableMap, ViewProps.BORDER_RADIUS);
                int intValue = intOrNull3 == null ? 0 : intOrNull3.intValue();
                if (valOr != null) {
                    bind.accountNumberEditText.setTextColor(Color.parseColor(valOr));
                    bind.bsbEditText.setTextColor(Color.parseColor(valOr));
                    bind.emailEditText.setTextColor(Color.parseColor(valOr));
                    bind.nameEditText.setTextColor(Color.parseColor(valOr));
                }
                if (valOr2 != null) {
                    bind.accountNumberEditText.setErrorColor(Color.parseColor(valOr2));
                    bind.bsbEditText.setErrorColor(Color.parseColor(valOr2));
                    bind.emailEditText.setErrorColor(Color.parseColor(valOr2));
                    bind.nameEditText.setErrorColor(Color.parseColor(valOr2));
                }
                if (valOr3 != null) {
                    bind.accountNumberEditText.setHintTextColor(Color.parseColor(valOr3));
                    bind.bsbEditText.setHintTextColor(Color.parseColor(valOr3));
                    bind.emailEditText.setHintTextColor(Color.parseColor(valOr3));
                    bind.nameEditText.setHintTextColor(Color.parseColor(valOr3));
                }
                if (intOrNull != null) {
                    float intValue2 = (float) intOrNull.intValue();
                    bind.accountNumberEditText.setTextSize(intValue2);
                    bind.bsbEditText.setTextSize(intValue2);
                    bind.emailEditText.setTextSize(intValue2);
                    bind.nameEditText.setTextSize(intValue2);
                }
                BecsDebitWidget becsDebitWidget3 = this.becsDebitWidget;
                if (becsDebitWidget3 != null) {
                    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel().toBuilder().setAllCorners(0, (float) (intValue * 2)).build());
                    materialShapeDrawable.setStrokeWidth(0.0f);
                    materialShapeDrawable.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#000000")));
                    materialShapeDrawable.setFillColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                    if (intOrNull2 != null) {
                        materialShapeDrawable.setStrokeWidth((float) (intOrNull2.intValue() * 2));
                    }
                    if (valOr5 != null) {
                        materialShapeDrawable.setStrokeColor(ColorStateList.valueOf(Color.parseColor(valOr5)));
                    }
                    if (valOr4 != null) {
                        materialShapeDrawable.setFillColor(ColorStateList.valueOf(Color.parseColor(valOr4)));
                    }
                    Unit unit = Unit.INSTANCE;
                    becsDebitWidget3.setBackground(materialShapeDrawable);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("becsDebitWidget");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("becsDebitWidget");
            throw null;
        }
    }

    public final void onFormChanged(PaymentMethodCreateParams paymentMethodCreateParams) {
        Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "params");
        Object obj = paymentMethodCreateParams.toParamMap().get("billing_details");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type java.util.HashMap<*, *>{ kotlin.collections.TypeAliasesKt.HashMap<*, *> }");
        Object obj2 = paymentMethodCreateParams.toParamMap().get("au_becs_debit");
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type java.util.HashMap<*, *>{ kotlin.collections.TypeAliasesKt.HashMap<*, *> }");
        Map map = (HashMap) obj2;
        Object obj3 = map.get("account_number");
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.String");
        Object obj4 = map.get("bsb_number");
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.String");
        Map map2 = (HashMap) obj;
        Object obj5 = map2.get("name");
        Objects.requireNonNull(obj5, "null cannot be cast to non-null type kotlin.String");
        Object obj6 = map2.get("email");
        Objects.requireNonNull(obj6, "null cannot be cast to non-null type kotlin.String");
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("accountNumber", (String) obj3), TuplesKt.to("bsbNumber", (String) obj4), TuplesKt.to("name", (String) obj5), TuplesKt.to("email", (String) obj6));
        EventDispatcher eventDispatcher = this.mEventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new FormCompleteEvent(getId(), mutableMapOf));
        }
    }

    private final void setListeners() {
        BecsDebitWidget becsDebitWidget2 = this.becsDebitWidget;
        if (becsDebitWidget2 != null) {
            becsDebitWidget2.setValidParamsCallback(new AuBECSDebitFormView$setListeners$1(this));
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("becsDebitWidget");
            throw null;
        }
    }
}
