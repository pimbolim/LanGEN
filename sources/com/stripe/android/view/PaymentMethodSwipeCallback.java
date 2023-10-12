package com.stripe.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.stripe.android.R;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.view.PaymentMethodsAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 *2\u00020\u0001:\u0002*+B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J@\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0016J \u0010\"\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0016J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\fH\u0016J(\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/stripe/android/view/PaymentMethodSwipeCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "context", "Landroid/content/Context;", "adapter", "Lcom/stripe/android/view/PaymentMethodsAdapter;", "listener", "Lcom/stripe/android/view/PaymentMethodSwipeCallback$Listener;", "(Landroid/content/Context;Lcom/stripe/android/view/PaymentMethodsAdapter;Lcom/stripe/android/view/PaymentMethodSwipeCallback$Listener;)V", "background", "Landroid/graphics/drawable/ColorDrawable;", "iconStartOffset", "", "itemViewStartPadding", "swipeStartColor", "swipeThresholdColor", "trashIcon", "Landroid/graphics/drawable/Drawable;", "getSwipeDirs", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getSwipeThreshold", "", "onChildDraw", "", "canvas", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "", "onMove", "target", "onSwiped", "direction", "updateSwipedPaymentMethod", "itemView", "Landroid/view/View;", "transitionFraction", "Companion", "Listener", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodSwipeCallback.kt */
public final class PaymentMethodSwipeCallback extends ItemTouchHelper.SimpleCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float END_TRANSITION_THRESHOLD = 0.5f;
    private static final float START_TRANSITION_THRESHOLD = 0.25f;
    private final PaymentMethodsAdapter adapter;
    private final ColorDrawable background;
    private final int iconStartOffset;
    private final int itemViewStartPadding;
    private final Listener listener;
    private final int swipeStartColor;
    private final int swipeThresholdColor;
    private final Drawable trashIcon;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/view/PaymentMethodSwipeCallback$Listener;", "", "onSwiped", "", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodSwipeCallback.kt */
    public interface Listener {
        void onSwiped(PaymentMethod paymentMethod);
    }

    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return 0.5f;
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(viewHolder2, "target");
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentMethodSwipeCallback(Context context, PaymentMethodsAdapter paymentMethodsAdapter, Listener listener2) {
        super(0, 8);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentMethodsAdapter, "adapter");
        Intrinsics.checkNotNullParameter(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.adapter = paymentMethodsAdapter;
        this.listener = listener2;
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.stripe_ic_trash);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(context, R.drawable.stripe_ic_trash)!!");
        this.trashIcon = drawable;
        int color = ContextCompat.getColor(context, R.color.stripe_swipe_start_payment_method);
        this.swipeStartColor = color;
        this.swipeThresholdColor = ContextCompat.getColor(context, R.color.stripe_swipe_threshold_payment_method);
        this.background = new ColorDrawable(color);
        this.itemViewStartPadding = drawable.getIntrinsicWidth() / 2;
        this.iconStartOffset = context.getResources().getDimensionPixelSize(R.dimen.stripe_list_row_start_padding);
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        this.listener.onSwiped(this.adapter.getPaymentMethodAtPosition$payments_core_release(viewHolder.getBindingAdapterPosition()));
    }

    public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof PaymentMethodsAdapter.ViewHolder.PaymentMethodViewHolder) {
            return super.getSwipeDirs(recyclerView, viewHolder);
        }
        return 0;
    }

    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
        if (viewHolder instanceof PaymentMethodsAdapter.ViewHolder.PaymentMethodViewHolder) {
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            float width = ((float) view.getWidth()) * START_TRANSITION_THRESHOLD;
            float width2 = ((float) view.getWidth()) * 0.5f;
            updateSwipedPaymentMethod(view, (int) f, f < width ? 0.0f : f >= width2 ? 1.0f : (f - width) / (width2 - width), canvas);
        }
    }

    private final void updateSwipedPaymentMethod(View view, int i, float f, Canvas canvas) {
        int i2;
        int top = view.getTop() + ((view.getHeight() - this.trashIcon.getIntrinsicHeight()) / 2);
        int intrinsicHeight = this.trashIcon.getIntrinsicHeight() + top;
        if (i > 0) {
            int left = view.getLeft() + this.iconStartOffset;
            int intrinsicWidth = this.trashIcon.getIntrinsicWidth() + left;
            if (i > intrinsicWidth) {
                this.trashIcon.setBounds(left, top, intrinsicWidth, intrinsicHeight);
            } else {
                this.trashIcon.setBounds(0, 0, 0, 0);
            }
            this.background.setBounds(view.getLeft(), view.getTop(), view.getLeft() + i + this.itemViewStartPadding, view.getBottom());
            ColorDrawable colorDrawable = this.background;
            if (f <= 0.0f) {
                i2 = this.swipeStartColor;
            } else if (f >= 1.0f) {
                i2 = this.swipeThresholdColor;
            } else {
                i2 = Companion.calculateTransitionColor$payments_core_release(f, this.swipeStartColor, this.swipeThresholdColor);
            }
            colorDrawable.setColor(i2);
        } else {
            this.trashIcon.setBounds(0, 0, 0, 0);
            this.background.setBounds(0, 0, 0, 0);
        }
        this.background.draw(canvas);
        this.trashIcon.draw(canvas);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/view/PaymentMethodSwipeCallback$Companion;", "", "()V", "END_TRANSITION_THRESHOLD", "", "START_TRANSITION_THRESHOLD", "calculateTransitionColor", "", "fraction", "startValue", "endValue", "calculateTransitionColor$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodSwipeCallback.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int calculateTransitionColor$payments_core_release(float f, int i, int i2) {
            int alpha = Color.alpha(i);
            int red = Color.red(i);
            int green = Color.green(i);
            int blue = Color.blue(i);
            return Color.argb((int) (((float) alpha) + (((float) (Color.alpha(i2) - alpha)) * f)), (int) (((float) red) + (((float) (Color.red(i2) - red)) * f)), (int) (((float) green) + (((float) (Color.green(i2) - green)) * f)), (int) (((float) blue) + (((float) (Color.blue(i2) - blue)) * f)));
        }
    }
}
