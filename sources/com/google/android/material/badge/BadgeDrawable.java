package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int BADGE_NUMBER_NONE = -1;
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;
    private static final int DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
    private static final int DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    private WeakReference<View> anchorViewRef;
    private final Rect badgeBounds = new Rect();
    private float badgeCenterX;
    private float badgeCenterY;
    private float badgeRadius;
    private float badgeWidePadding;
    private float badgeWithTextRadius;
    private final WeakReference<Context> contextRef;
    private float cornerRadius;
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    private final SavedState savedState;
    private final MaterialShapeDrawable shapeDrawable = new MaterialShapeDrawable();
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return false;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        /* access modifiers changed from: private */
        public int additionalHorizontalOffset;
        /* access modifiers changed from: private */
        public int additionalVerticalOffset;
        /* access modifiers changed from: private */
        public int alpha = 255;
        /* access modifiers changed from: private */
        public int backgroundColor;
        /* access modifiers changed from: private */
        public int badgeGravity;
        /* access modifiers changed from: private */
        public int badgeTextColor;
        /* access modifiers changed from: private */
        public int contentDescriptionExceedsMaxBadgeNumberRes;
        /* access modifiers changed from: private */
        public CharSequence contentDescriptionNumberless;
        /* access modifiers changed from: private */
        public int contentDescriptionQuantityStrings;
        /* access modifiers changed from: private */
        public int horizontalOffsetWithText;
        /* access modifiers changed from: private */
        public int horizontalOffsetWithoutText;
        /* access modifiers changed from: private */
        public boolean isVisible;
        /* access modifiers changed from: private */
        public int maxCharacterCount;
        /* access modifiers changed from: private */
        public int number = -1;
        /* access modifiers changed from: private */
        public int verticalOffsetWithText;
        /* access modifiers changed from: private */
        public int verticalOffsetWithoutText;

        public int describeContents() {
            return 0;
        }

        public SavedState(Context context) {
            this.badgeTextColor = new TextAppearance(context, R.style.TextAppearance_MaterialComponents_Badge).getTextColor().getDefaultColor();
            this.contentDescriptionNumberless = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R.plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        protected SavedState(Parcel parcel) {
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffsetWithoutText = parcel.readInt();
            this.verticalOffsetWithoutText = parcel.readInt();
            this.horizontalOffsetWithText = parcel.readInt();
            this.verticalOffsetWithText = parcel.readInt();
            this.additionalHorizontalOffset = parcel.readInt();
            this.additionalVerticalOffset = parcel.readInt();
            this.isVisible = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffsetWithoutText);
            parcel.writeInt(this.verticalOffsetWithoutText);
            parcel.writeInt(this.horizontalOffsetWithText);
            parcel.writeInt(this.verticalOffsetWithText);
            parcel.writeInt(this.additionalHorizontalOffset);
            parcel.writeInt(this.additionalVerticalOffset);
            parcel.writeInt(this.isVisible ? 1 : 0);
        }
    }

    public SavedState getSavedState() {
        return this.savedState;
    }

    static BadgeDrawable createFromSavedState(Context context, SavedState savedState2) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.restoreFromSavedState(savedState2);
        return badgeDrawable;
    }

    public static BadgeDrawable create(Context context) {
        return createFromAttributes(context, (AttributeSet) null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    public static BadgeDrawable createFromResource(Context context, int i) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i, "badge");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = DEFAULT_STYLE;
        }
        return createFromAttributes(context, parseDrawableXml, DEFAULT_THEME_ATTR, styleAttribute);
    }

    private static BadgeDrawable createFromAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.loadDefaultStateFromAttributes(context, attributeSet, i, i2);
        return badgeDrawable;
    }

    public void setVisible(boolean z) {
        setVisible(z, false);
        boolean unused = this.savedState.isVisible = z;
        if (BadgeUtils.USE_COMPAT_PARENT && getCustomBadgeParent() != null && !z) {
            ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
        }
    }

    private void restoreFromSavedState(SavedState savedState2) {
        setMaxCharacterCount(savedState2.maxCharacterCount);
        if (savedState2.number != -1) {
            setNumber(savedState2.number);
        }
        setBackgroundColor(savedState2.backgroundColor);
        setBadgeTextColor(savedState2.badgeTextColor);
        setBadgeGravity(savedState2.badgeGravity);
        setHorizontalOffsetWithoutText(savedState2.horizontalOffsetWithoutText);
        setVerticalOffsetWithoutText(savedState2.verticalOffsetWithoutText);
        setHorizontalOffsetWithText(savedState2.horizontalOffsetWithText);
        setVerticalOffsetWithText(savedState2.verticalOffsetWithText);
        setAdditionalHorizontalOffset(savedState2.additionalHorizontalOffset);
        setAdditionalVerticalOffset(savedState2.additionalVerticalOffset);
        setVisible(savedState2.isVisible);
    }

    private void loadDefaultStateFromAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Badge, i, i2, new int[0]);
        setMaxCharacterCount(obtainStyledAttributes.getInt(R.styleable.Badge_maxCharacterCount, 4));
        if (obtainStyledAttributes.hasValue(R.styleable.Badge_number)) {
            setNumber(obtainStyledAttributes.getInt(R.styleable.Badge_number, 0));
        }
        setBackgroundColor(readColorFromAttributes(context, obtainStyledAttributes, R.styleable.Badge_backgroundColor));
        if (obtainStyledAttributes.hasValue(R.styleable.Badge_badgeTextColor)) {
            setBadgeTextColor(readColorFromAttributes(context, obtainStyledAttributes, R.styleable.Badge_badgeTextColor));
        }
        setBadgeGravity(obtainStyledAttributes.getInt(R.styleable.Badge_badgeGravity, TOP_END));
        setHorizontalOffsetWithoutText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        setVerticalOffsetWithoutText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        setHorizontalOffsetWithText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, getHorizontalOffsetWithoutText()));
        setVerticalOffsetWithText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, getVerticalOffsetWithoutText()));
        if (obtainStyledAttributes.hasValue(R.styleable.Badge_badgeRadius)) {
            this.badgeRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.Badge_badgeRadius, (int) this.badgeRadius);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Badge_badgeWidePadding)) {
            this.badgeWidePadding = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, (int) this.badgeWidePadding);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Badge_badgeWithTextRadius)) {
            this.badgeWithTextRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, (int) this.badgeWithTextRadius);
        }
        obtainStyledAttributes.recycle();
    }

    private static int readColorFromAttributes(Context context, TypedArray typedArray, int i) {
        return MaterialResources.getColorStateList(context, typedArray, i).getDefaultColor();
    }

    private BadgeDrawable(Context context) {
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        Resources resources = context.getResources();
        this.badgeRadius = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.badgeWidePadding = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        TextDrawableHelper textDrawableHelper2 = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper2;
        textDrawableHelper2.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.savedState = new SavedState(context);
        setTextAppearanceResource(R.style.TextAppearance_MaterialComponents_Badge);
    }

    @Deprecated
    public void updateBadgeCoordinates(View view, ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            updateBadgeCoordinates(view, (FrameLayout) viewGroup);
            return;
        }
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(View view) {
        updateBadgeCoordinates(view, (FrameLayout) null);
    }

    public void updateBadgeCoordinates(View view, FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference<>(view);
        if (!BadgeUtils.USE_COMPAT_PARENT || frameLayout != null) {
            this.customBadgeParentRef = new WeakReference<>(frameLayout);
        } else {
            tryWrapAnchorInCompatParent(view);
        }
        if (!BadgeUtils.USE_COMPAT_PARENT) {
            updateAnchorParentToNotClip(view);
        }
        updateCenterAndBounds();
        invalidateSelf();
    }

    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    private void tryWrapAnchorInCompatParent(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
            if (weakReference == null || weakReference.get() != viewGroup) {
                updateAnchorParentToNotClip(view);
                final FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.customBadgeParentRef = new WeakReference<>(frameLayout);
                frameLayout.post(new Runnable() {
                    public void run() {
                        BadgeDrawable.this.updateBadgeCoordinates(view, frameLayout);
                    }
                });
            }
        }
    }

    private static void updateAnchorParentToNotClip(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public void setBackgroundColor(int i) {
        int unused = this.savedState.backgroundColor = i;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        if (this.shapeDrawable.getFillColor() != valueOf) {
            this.shapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    public void setBadgeTextColor(int i) {
        int unused = this.savedState.badgeTextColor = i;
        if (this.textDrawableHelper.getTextPaint().getColor() != i) {
            this.textDrawableHelper.getTextPaint().setColor(i);
            invalidateSelf();
        }
    }

    public boolean hasNumber() {
        return this.savedState.number != -1;
    }

    public int getNumber() {
        if (!hasNumber()) {
            return 0;
        }
        return this.savedState.number;
    }

    public void setNumber(int i) {
        int max = Math.max(0, i);
        if (this.savedState.number != max) {
            int unused = this.savedState.number = max;
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void clearNumber() {
        int unused = this.savedState.number = -1;
        updateCenterAndBounds();
        invalidateSelf();
    }

    public int getMaxCharacterCount() {
        return this.savedState.maxCharacterCount;
    }

    public void setMaxCharacterCount(int i) {
        if (this.savedState.maxCharacterCount != i) {
            int unused = this.savedState.maxCharacterCount = i;
            updateMaxBadgeNumber();
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public int getBadgeGravity() {
        return this.savedState.badgeGravity;
    }

    public void setBadgeGravity(int i) {
        if (this.savedState.badgeGravity != i) {
            int unused = this.savedState.badgeGravity = i;
            WeakReference<View> weakReference = this.anchorViewRef;
            if (weakReference != null && weakReference.get() != null) {
                View view = (View) this.anchorViewRef.get();
                WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
                updateBadgeCoordinates(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
            }
        }
    }

    public int getAlpha() {
        return this.savedState.alpha;
    }

    public void setAlpha(int i) {
        int unused = this.savedState.alpha = i;
        this.textDrawableHelper.getTextPaint().setAlpha(i);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.shapeDrawable.draw(canvas);
            if (hasNumber()) {
                drawText(canvas);
            }
        }
    }

    public void onTextSizeChange() {
        invalidateSelf();
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        CharSequence unused = this.savedState.contentDescriptionNumberless = charSequence;
    }

    public void setContentDescriptionQuantityStringsResource(int i) {
        int unused = this.savedState.contentDescriptionQuantityStrings = i;
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(int i) {
        int unused = this.savedState.contentDescriptionExceedsMaxBadgeNumberRes = i;
    }

    public CharSequence getContentDescription() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!hasNumber()) {
            return this.savedState.contentDescriptionNumberless;
        }
        if (this.savedState.contentDescriptionQuantityStrings <= 0 || (context = (Context) this.contextRef.get()) == null) {
            return null;
        }
        if (getNumber() <= this.maxBadgeNumber) {
            return context.getResources().getQuantityString(this.savedState.contentDescriptionQuantityStrings, getNumber(), new Object[]{Integer.valueOf(getNumber())});
        }
        return context.getString(this.savedState.contentDescriptionExceedsMaxBadgeNumberRes, new Object[]{Integer.valueOf(this.maxBadgeNumber)});
    }

    public void setHorizontalOffset(int i) {
        setHorizontalOffsetWithoutText(i);
        setHorizontalOffsetWithText(i);
    }

    public int getHorizontalOffset() {
        return this.savedState.horizontalOffsetWithoutText;
    }

    public void setHorizontalOffsetWithoutText(int i) {
        int unused = this.savedState.horizontalOffsetWithoutText = i;
        updateCenterAndBounds();
    }

    public int getHorizontalOffsetWithoutText() {
        return this.savedState.horizontalOffsetWithoutText;
    }

    public void setHorizontalOffsetWithText(int i) {
        int unused = this.savedState.horizontalOffsetWithText = i;
        updateCenterAndBounds();
    }

    public int getHorizontalOffsetWithText() {
        return this.savedState.horizontalOffsetWithText;
    }

    /* access modifiers changed from: package-private */
    public void setAdditionalHorizontalOffset(int i) {
        int unused = this.savedState.additionalHorizontalOffset = i;
        updateCenterAndBounds();
    }

    /* access modifiers changed from: package-private */
    public int getAdditionalHorizontalOffset() {
        return this.savedState.additionalHorizontalOffset;
    }

    public void setVerticalOffset(int i) {
        setVerticalOffsetWithoutText(i);
        setVerticalOffsetWithText(i);
    }

    public int getVerticalOffset() {
        return this.savedState.verticalOffsetWithoutText;
    }

    public void setVerticalOffsetWithoutText(int i) {
        int unused = this.savedState.verticalOffsetWithoutText = i;
        updateCenterAndBounds();
    }

    public int getVerticalOffsetWithoutText() {
        return this.savedState.verticalOffsetWithoutText;
    }

    public void setVerticalOffsetWithText(int i) {
        int unused = this.savedState.verticalOffsetWithText = i;
        updateCenterAndBounds();
    }

    public int getVerticalOffsetWithText() {
        return this.savedState.verticalOffsetWithText;
    }

    /* access modifiers changed from: package-private */
    public void setAdditionalVerticalOffset(int i) {
        int unused = this.savedState.additionalVerticalOffset = i;
        updateCenterAndBounds();
    }

    /* access modifiers changed from: package-private */
    public int getAdditionalVerticalOffset() {
        return this.savedState.additionalVerticalOffset;
    }

    private void setTextAppearanceResource(int i) {
        Context context = (Context) this.contextRef.get();
        if (context != null) {
            setTextAppearance(new TextAppearance(context, i));
        }
    }

    private void setTextAppearance(TextAppearance textAppearance) {
        Context context;
        if (this.textDrawableHelper.getTextAppearance() != textAppearance && (context = (Context) this.contextRef.get()) != null) {
            this.textDrawableHelper.setTextAppearance(textAppearance, context);
            updateCenterAndBounds();
        }
    }

    private void updateCenterAndBounds() {
        Context context = (Context) this.contextRef.get();
        WeakReference<View> weakReference = this.anchorViewRef;
        ViewGroup viewGroup = null;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.badgeBounds);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            if (weakReference2 != null) {
                viewGroup = (FrameLayout) weakReference2.get();
            }
            if (viewGroup != null || BadgeUtils.USE_COMPAT_PARENT) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            calculateCenterAndBounds(context, rect2, view);
            BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
            this.shapeDrawable.setCornerSize(this.cornerRadius);
            if (!rect.equals(this.badgeBounds)) {
                this.shapeDrawable.setBounds(this.badgeBounds);
            }
        }
    }

    private int getTotalVerticalOffsetForState() {
        return (hasNumber() ? this.savedState.verticalOffsetWithText : this.savedState.verticalOffsetWithoutText) + this.savedState.additionalVerticalOffset;
    }

    private int getTotalHorizontalOffsetForState() {
        return (hasNumber() ? this.savedState.horizontalOffsetWithText : this.savedState.horizontalOffsetWithoutText) + this.savedState.additionalHorizontalOffset;
    }

    private void calculateCenterAndBounds(Context context, Rect rect, View view) {
        int totalVerticalOffsetForState = getTotalVerticalOffsetForState();
        int access$500 = this.savedState.badgeGravity;
        if (access$500 == 8388691 || access$500 == 8388693) {
            this.badgeCenterY = (float) (rect.bottom - totalVerticalOffsetForState);
        } else {
            this.badgeCenterY = (float) (rect.top + totalVerticalOffsetForState);
        }
        if (getNumber() <= 9) {
            float f = !hasNumber() ? this.badgeRadius : this.badgeWithTextRadius;
            this.cornerRadius = f;
            this.halfBadgeHeight = f;
            this.halfBadgeWidth = f;
        } else {
            float f2 = this.badgeWithTextRadius;
            this.cornerRadius = f2;
            this.halfBadgeHeight = f2;
            this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(hasNumber() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int totalHorizontalOffsetForState = getTotalHorizontalOffsetForState();
        int access$5002 = this.savedState.badgeGravity;
        if (access$5002 == 8388659 || access$5002 == 8388691) {
            this.badgeCenterX = ViewCompat.getLayoutDirection(view) == 0 ? (((float) rect.left) - this.halfBadgeWidth) + ((float) dimensionPixelSize) + ((float) totalHorizontalOffsetForState) : ((((float) rect.right) + this.halfBadgeWidth) - ((float) dimensionPixelSize)) - ((float) totalHorizontalOffsetForState);
        } else {
            this.badgeCenterX = ViewCompat.getLayoutDirection(view) == 0 ? ((((float) rect.right) + this.halfBadgeWidth) - ((float) dimensionPixelSize)) - ((float) totalHorizontalOffsetForState) : (((float) rect.left) - this.halfBadgeWidth) + ((float) dimensionPixelSize) + ((float) totalHorizontalOffsetForState);
        }
    }

    private void drawText(Canvas canvas) {
        Rect rect = new Rect();
        String badgeText = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(badgeText, 0, badgeText.length(), rect);
        canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + ((float) (rect.height() / 2)), this.textDrawableHelper.getTextPaint());
    }

    private String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance().format((long) getNumber());
        }
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return "";
        }
        return context.getString(R.string.mtrl_exceed_max_badge_number_suffix, new Object[]{Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
    }

    private void updateMaxBadgeNumber() {
        this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
    }
}
