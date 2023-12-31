package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import com.braintreepayments.api.models.PostalAddressParser;
import com.facebook.react.uimanager.ViewProps;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J<\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020J2\u001d\u0010d\u001a\u0019\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020E0e¢\u0006\u0002\bgH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bh\u0010iJ!\u0010j\u001a\u00020b2\u0017\u0010d\u001a\u0013\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020E0C¢\u0006\u0002\bgH\u0002J\u0015\u0010k\u001a\u00020E2\u0006\u0010l\u001a\u00020DH\u0000¢\u0006\u0002\bmJ\u000e\u0010n\u001a\u00020E2\u0006\u0010o\u001a\u00020pJ\u000e\u0010n\u001a\u00020E2\u0006\u0010o\u001a\u00020qJ\u0018\u0010r\u001a\u00020E2\u0006\u0010s\u001a\u00020'2\b\b\u0003\u0010t\u001a\u00020\u000bJ\u000e\u0010u\u001a\u00020E2\u0006\u0010s\u001a\u00020'J\u0018\u0010v\u001a\u00020E2\u0006\u0010s\u001a\u00020'2\b\b\u0003\u0010t\u001a\u00020\u000bJ+\u0010w\u001a\u00020E2\u0006\u0010s\u001a\u00020'2\u0006\u0010x\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020Jø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bz\u0010{J\u0006\u0010|\u001a\u00020EJ\u0006\u0010}\u001a\u00020EJ\u0006\u0010~\u001a\u00020EJ[\u0010\u001a\u00020E2\u0006\u0010H\u001a\u00020p2\u0006\u0010\u0015\u001a\u00020p2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\b\b\u0003\u0010t\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J£\u0001\u0010\u001a\u00020E2\u0006\u0010?\u001a\u00020q2\u0006\u0010H\u001a\u00020p2\u0006\u0010\u0019\u001a\u00020q2\u0006\u0010\u0015\u001a\u00020p2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0003\u0010\u0001\u001a\u00020\u000b2\t\b\u0003\u0010\u0001\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J[\u0010\u001a\u00020E2\u0006\u0010?\u001a\u00020q2\u0006\u0010\u0019\u001a\u00020q2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\t\b\u0002\u0010\u0001\u001a\u00020J2\b\b\u0003\u0010t\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0007\u0010\u0001\u001a\u00020EJ\u0007\u0010\u0001\u001a\u00020ER\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R&\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u001b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R$\u0010*\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R$\u0010-\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R$\u00100\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000e\"\u0004\b2\u0010\u0010R$\u00103\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R$\u00106\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010R$\u00109\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000e\"\u0004\b;\u0010\u0010R$\u0010<\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u0010R\u0011\u0010?\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0007R&\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020E0C0BX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010H\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0018R/\u0010K\u001a\u00020J2\u0006\u0010\n\u001a\u00020J@FX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010N\u001a\u0004\bL\u0010\u000e\"\u0004\bM\u0010\u0010R/\u0010O\u001a\u00020J2\u0006\u0010\n\u001a\u00020J@FX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010N\u001a\u0004\bP\u0010\u000e\"\u0004\bQ\u0010\u0010R/\u0010R\u001a\u00020J2\u0006\u0010\n\u001a\u00020J@FX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010N\u001a\u0004\bS\u0010\u000e\"\u0004\bT\u0010\u0010R$\u0010U\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000e\"\u0004\bW\u0010\u0010R$\u0010Y\u001a\u00020X2\u0006\u0010\n\u001a\u00020X@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010^\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u001b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u001e\"\u0004\b`\u0010 \u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainScope;", "", "id", "(Ljava/lang/Object;)V", "absoluteLeft", "Landroidx/constraintlayout/compose/VerticalAnchorable;", "getAbsoluteLeft", "()Landroidx/constraintlayout/compose/VerticalAnchorable;", "absoluteRight", "getAbsoluteRight", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "baseline", "Landroidx/constraintlayout/compose/BaselineAnchorable;", "getBaseline", "()Landroidx/constraintlayout/compose/BaselineAnchorable;", "bottom", "Landroidx/constraintlayout/compose/HorizontalAnchorable;", "getBottom", "()Landroidx/constraintlayout/compose/HorizontalAnchorable;", "end", "getEnd", "Landroidx/constraintlayout/compose/Dimension;", "height", "getHeight", "()Landroidx/constraintlayout/compose/Dimension;", "setHeight", "(Landroidx/constraintlayout/compose/Dimension;)V", "horizontalChainWeight", "getHorizontalChainWeight", "setHorizontalChainWeight", "getId$compose_release", "()Ljava/lang/Object;", "parent", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "getParent", "()Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "start", "getStart", "tasks", "", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/State;", "", "getTasks$compose_release", "()Ljava/util/List;", "top", "getTop", "Landroidx/compose/ui/unit/Dp;", "translationX", "getTranslationX-D9Ej5fM", "setTranslationX-0680j_4", "F", "translationY", "getTranslationY-D9Ej5fM", "setTranslationY-0680j_4", "translationZ", "getTranslationZ-D9Ej5fM", "setTranslationZ-0680j_4", "verticalChainWeight", "getVerticalChainWeight", "setVerticalChainWeight", "Landroidx/constraintlayout/compose/Visibility;", "visibility", "getVisibility", "()Landroidx/constraintlayout/compose/Visibility;", "setVisibility", "(Landroidx/constraintlayout/compose/Visibility;)V", "width", "getWidth", "setWidth", "addFloatTransformFromDp", "", "dpValue", "change", "Lkotlin/Function2;", "Landroidx/constraintlayout/core/state/ConstraintReference;", "Lkotlin/ExtensionFunctionType;", "addFloatTransformFromDp-D5KLDUw", "(FLkotlin/jvm/functions/Function2;)Z", "addTransform", "applyTo", "state", "applyTo$compose_release", "centerAround", "anchor", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "centerHorizontallyTo", "other", "bias", "centerTo", "centerVerticallyTo", "circular", "angle", "distance", "circular-wH6b6FI", "(Landroidx/constraintlayout/compose/ConstrainedLayoutReference;FF)V", "clearConstraints", "clearHorizontal", "clearVertical", "linkTo", "topMargin", "bottomMargin", "topGoneMargin", "bottomGoneMargin", "linkTo-8ZKsbrE", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FFFFF)V", "startMargin", "endMargin", "startGoneMargin", "endGoneMargin", "horizontalBias", "verticalBias", "linkTo-R7zmacU", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FFFFFFFFFF)V", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;FFFFF)V", "resetDimensions", "resetTransforms", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@LayoutScopeMarker
/* compiled from: ConstrainScope.kt */
public final class ConstrainScope {
    private final VerticalAnchorable absoluteLeft;
    private final VerticalAnchorable absoluteRight;
    private float alpha = 1.0f;
    private final BaselineAnchorable baseline;
    private final HorizontalAnchorable bottom;
    private final VerticalAnchorable end;
    private Dimension height = Dimension.Companion.getWrapContent();
    private float horizontalChainWeight;
    private final Object id;
    private final ConstrainedLayoutReference parent;
    private float pivotX;
    private float pivotY;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private final VerticalAnchorable start;
    private final List<Function1<State, Unit>> tasks;
    private final HorizontalAnchorable top;
    private float translationX;
    private float translationY;
    private float translationZ;
    private float verticalChainWeight;
    private Visibility visibility = Visibility.Companion.getVisible();
    private Dimension width = Dimension.Companion.getWrapContent();

    public ConstrainScope(Object obj) {
        Intrinsics.checkNotNullParameter(obj, MessageExtension.FIELD_ID);
        this.id = obj;
        List<Function1<State, Unit>> arrayList = new ArrayList<>();
        this.tasks = arrayList;
        Integer num = State.PARENT;
        Intrinsics.checkNotNullExpressionValue(num, "PARENT");
        this.parent = new ConstrainedLayoutReference(num);
        this.start = new ConstraintVerticalAnchorable(obj, -2, arrayList);
        this.absoluteLeft = new ConstraintVerticalAnchorable(obj, 0, arrayList);
        this.top = new ConstraintHorizontalAnchorable(obj, 0, arrayList);
        this.end = new ConstraintVerticalAnchorable(obj, -1, arrayList);
        this.absoluteRight = new ConstraintVerticalAnchorable(obj, 1, arrayList);
        this.bottom = new ConstraintHorizontalAnchorable(obj, 1, arrayList);
        this.baseline = new ConstraintBaselineAnchorable(obj, arrayList);
        float f = (float) 0;
        this.translationX = Dp.m3859constructorimpl(f);
        this.translationY = Dp.m3859constructorimpl(f);
        this.translationZ = Dp.m3859constructorimpl(f);
        this.pivotX = 0.5f;
        this.pivotY = 0.5f;
        this.horizontalChainWeight = Float.NaN;
        this.verticalChainWeight = Float.NaN;
    }

    public final Object getId$compose_release() {
        return this.id;
    }

    public final List<Function1<State, Unit>> getTasks$compose_release() {
        return this.tasks;
    }

    public final void applyTo$compose_release(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        for (Function1 invoke : this.tasks) {
            invoke.invoke(state);
        }
    }

    public final ConstrainedLayoutReference getParent() {
        return this.parent;
    }

    public final VerticalAnchorable getStart() {
        return this.start;
    }

    public final VerticalAnchorable getAbsoluteLeft() {
        return this.absoluteLeft;
    }

    public final HorizontalAnchorable getTop() {
        return this.top;
    }

    public final VerticalAnchorable getEnd() {
        return this.end;
    }

    public final VerticalAnchorable getAbsoluteRight() {
        return this.absoluteRight;
    }

    public final HorizontalAnchorable getBottom() {
        return this.bottom;
    }

    public final BaselineAnchorable getBaseline() {
        return this.baseline;
    }

    public final Dimension getWidth() {
        return this.width;
    }

    public final void setWidth(Dimension dimension) {
        Intrinsics.checkNotNullParameter(dimension, "value");
        this.width = dimension;
        this.tasks.add(new ConstrainScope$width$1(this, dimension));
    }

    public final Dimension getHeight() {
        return this.height;
    }

    public final void setHeight(Dimension dimension) {
        Intrinsics.checkNotNullParameter(dimension, "value");
        this.height = dimension;
        this.tasks.add(new ConstrainScope$height$1(this, dimension));
    }

    public final Visibility getVisibility() {
        return this.visibility;
    }

    public final void setVisibility(Visibility visibility2) {
        Intrinsics.checkNotNullParameter(visibility2, "value");
        this.visibility = visibility2;
        this.tasks.add(new ConstrainScope$visibility$1(this, visibility2));
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
        addTransform(new ConstrainScope$alpha$1(this, f));
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final void setScaleX(float f) {
        this.scaleX = f;
        addTransform(new ConstrainScope$scaleX$1(f));
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final void setScaleY(float f) {
        this.scaleY = f;
        addTransform(new ConstrainScope$scaleY$1(f));
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final void setRotationX(float f) {
        this.rotationX = f;
        addTransform(new ConstrainScope$rotationX$1(f));
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final void setRotationY(float f) {
        this.rotationY = f;
        addTransform(new ConstrainScope$rotationY$1(f));
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final void setRotationZ(float f) {
        this.rotationZ = f;
        addTransform(new ConstrainScope$rotationZ$1(f));
    }

    /* renamed from: getTranslationX-D9Ej5fM  reason: not valid java name */
    public final float m4124getTranslationXD9Ej5fM() {
        return this.translationX;
    }

    /* renamed from: setTranslationX-0680j_4  reason: not valid java name */
    public final void m4130setTranslationX0680j_4(float f) {
        this.translationX = f;
        m4119addFloatTransformFromDpD5KLDUw(f, ConstrainScope$translationX$1.INSTANCE);
    }

    /* renamed from: getTranslationY-D9Ej5fM  reason: not valid java name */
    public final float m4125getTranslationYD9Ej5fM() {
        return this.translationY;
    }

    /* renamed from: setTranslationY-0680j_4  reason: not valid java name */
    public final void m4131setTranslationY0680j_4(float f) {
        this.translationY = f;
        m4119addFloatTransformFromDpD5KLDUw(f, ConstrainScope$translationY$1.INSTANCE);
    }

    /* renamed from: getTranslationZ-D9Ej5fM  reason: not valid java name */
    public final float m4126getTranslationZD9Ej5fM() {
        return this.translationZ;
    }

    /* renamed from: setTranslationZ-0680j_4  reason: not valid java name */
    public final void m4132setTranslationZ0680j_4(float f) {
        this.translationZ = f;
        m4119addFloatTransformFromDpD5KLDUw(f, ConstrainScope$translationZ$1.INSTANCE);
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final void setPivotX(float f) {
        this.pivotX = f;
        addTransform(new ConstrainScope$pivotX$1(f));
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final void setPivotY(float f) {
        this.pivotY = f;
        addTransform(new ConstrainScope$pivotY$1(f));
    }

    public final float getHorizontalChainWeight() {
        return this.horizontalChainWeight;
    }

    public final void setHorizontalChainWeight(float f) {
        this.horizontalChainWeight = f;
        this.tasks.add(new ConstrainScope$horizontalChainWeight$1(this, f));
    }

    public final float getVerticalChainWeight() {
        return this.verticalChainWeight;
    }

    public final void setVerticalChainWeight(float f) {
        this.verticalChainWeight = f;
        this.tasks.add(new ConstrainScope$verticalChainWeight$1(this, f));
    }

    private final boolean addTransform(Function1<? super ConstraintReference, Unit> function1) {
        return this.tasks.add(new ConstrainScope$addTransform$1(function1, this));
    }

    /* renamed from: addFloatTransformFromDp-D5KLDUw  reason: not valid java name */
    private final boolean m4119addFloatTransformFromDpD5KLDUw(float f, Function2<? super ConstraintReference, ? super Float, Unit> function2) {
        return this.tasks.add(new ConstrainScope$addFloatTransformFromDp$1(function2, this, f));
    }

    /* renamed from: linkTo-8ZKsbrE  reason: not valid java name */
    public final void m4128linkTo8ZKsbrE(ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, float f, float f2, float f3, float f4, float f5) {
        Intrinsics.checkNotNullParameter(verticalAnchor, ViewProps.START);
        Intrinsics.checkNotNullParameter(verticalAnchor2, ViewProps.END);
        this.start.m4213linkToVpY3zN4(verticalAnchor, f, f3);
        this.end.m4213linkToVpY3zN4(verticalAnchor2, f2, f4);
        this.tasks.add(new ConstrainScope$linkTo$1(f5, this));
    }

    /* renamed from: linkTo-8ZKsbrE  reason: not valid java name */
    public final void m4127linkTo8ZKsbrE(ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5) {
        Intrinsics.checkNotNullParameter(horizontalAnchor, ViewProps.TOP);
        Intrinsics.checkNotNullParameter(horizontalAnchor2, ViewProps.BOTTOM);
        this.top.m4174linkToVpY3zN4(horizontalAnchor, f, f3);
        this.bottom.m4174linkToVpY3zN4(horizontalAnchor2, f2, f4);
        this.tasks.add(new ConstrainScope$linkTo$2(this, f5));
    }

    /* renamed from: linkTo-R7zmacU  reason: not valid java name */
    public final void m4129linkToR7zmacU(ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        Intrinsics.checkNotNullParameter(verticalAnchor, ViewProps.START);
        ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor3 = horizontalAnchor;
        Intrinsics.checkNotNullParameter(horizontalAnchor, ViewProps.TOP);
        Intrinsics.checkNotNullParameter(verticalAnchor2, ViewProps.END);
        ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor4 = horizontalAnchor2;
        Intrinsics.checkNotNullParameter(horizontalAnchor2, ViewProps.BOTTOM);
        m4128linkTo8ZKsbrE(verticalAnchor, verticalAnchor2, f, f3, f5, f7, f9);
        m4127linkTo8ZKsbrE(horizontalAnchor, horizontalAnchor2, f2, f4, f6, f8, f10);
    }

    public final void centerTo(ConstrainedLayoutReference constrainedLayoutReference) {
        Intrinsics.checkNotNullParameter(constrainedLayoutReference, "other");
        m4122linkToR7zmacU$default(this, constrainedLayoutReference.getStart(), constrainedLayoutReference.getTop(), constrainedLayoutReference.getEnd(), constrainedLayoutReference.getBottom(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16368, (Object) null);
    }

    public static /* synthetic */ void centerHorizontallyTo$default(ConstrainScope constrainScope, ConstrainedLayoutReference constrainedLayoutReference, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        constrainScope.centerHorizontallyTo(constrainedLayoutReference, f);
    }

    public final void centerHorizontallyTo(ConstrainedLayoutReference constrainedLayoutReference, float f) {
        Intrinsics.checkNotNullParameter(constrainedLayoutReference, "other");
        m4121linkTo8ZKsbrE$default(this, constrainedLayoutReference.getStart(), constrainedLayoutReference.getEnd(), 0.0f, 0.0f, 0.0f, 0.0f, f, 60, (Object) null);
    }

    public static /* synthetic */ void centerVerticallyTo$default(ConstrainScope constrainScope, ConstrainedLayoutReference constrainedLayoutReference, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        constrainScope.centerVerticallyTo(constrainedLayoutReference, f);
    }

    public final void centerVerticallyTo(ConstrainedLayoutReference constrainedLayoutReference, float f) {
        Intrinsics.checkNotNullParameter(constrainedLayoutReference, "other");
        m4120linkTo8ZKsbrE$default(this, constrainedLayoutReference.getTop(), constrainedLayoutReference.getBottom(), 0.0f, 0.0f, 0.0f, 0.0f, f, 60, (Object) null);
    }

    public final void centerAround(ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor) {
        Intrinsics.checkNotNullParameter(verticalAnchor, "anchor");
        m4121linkTo8ZKsbrE$default(this, verticalAnchor, verticalAnchor, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 124, (Object) null);
    }

    public final void centerAround(ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor) {
        Intrinsics.checkNotNullParameter(horizontalAnchor, "anchor");
        m4120linkTo8ZKsbrE$default(this, horizontalAnchor, horizontalAnchor, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 124, (Object) null);
    }

    /* renamed from: circular-wH6b6FI  reason: not valid java name */
    public final void m4123circularwH6b6FI(ConstrainedLayoutReference constrainedLayoutReference, float f, float f2) {
        Intrinsics.checkNotNullParameter(constrainedLayoutReference, "other");
        this.tasks.add(new ConstrainScope$circular$1(this, constrainedLayoutReference, f, f2));
    }

    public final void clearHorizontal() {
        this.tasks.add(new ConstrainScope$clearHorizontal$1(this));
    }

    public final void clearVertical() {
        this.tasks.add(new ConstrainScope$clearVertical$1(this));
    }

    public final void clearConstraints() {
        this.tasks.add(new ConstrainScope$clearConstraints$1(this));
    }

    public final void resetDimensions() {
        this.tasks.add(new ConstrainScope$resetDimensions$1(this));
    }

    public final void resetTransforms() {
        this.tasks.add(new ConstrainScope$resetTransforms$1(this));
    }

    /* renamed from: linkTo-8ZKsbrE$default  reason: not valid java name */
    public static /* synthetic */ void m4121linkTo8ZKsbrE$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        float f6;
        float r5 = (i & 4) != 0 ? Dp.m3859constructorimpl((float) 0) : f;
        float r6 = (i & 8) != 0 ? Dp.m3859constructorimpl((float) 0) : f2;
        float r7 = (i & 16) != 0 ? Dp.m3859constructorimpl((float) 0) : f3;
        if ((i & 32) != 0) {
            f6 = Dp.m3859constructorimpl((float) 0);
        } else {
            f6 = f4;
        }
        constrainScope.m4128linkTo8ZKsbrE(verticalAnchor, verticalAnchor2, r5, r6, r7, f6, (i & 64) != 0 ? 0.5f : f5);
    }

    /* renamed from: linkTo-8ZKsbrE$default  reason: not valid java name */
    public static /* synthetic */ void m4120linkTo8ZKsbrE$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        float f6;
        float r5 = (i & 4) != 0 ? Dp.m3859constructorimpl((float) 0) : f;
        float r6 = (i & 8) != 0 ? Dp.m3859constructorimpl((float) 0) : f2;
        float r7 = (i & 16) != 0 ? Dp.m3859constructorimpl((float) 0) : f3;
        if ((i & 32) != 0) {
            f6 = Dp.m3859constructorimpl((float) 0);
        } else {
            f6 = f4;
        }
        constrainScope.m4127linkTo8ZKsbrE(horizontalAnchor, horizontalAnchor2, r5, r6, r7, f6, (i & 64) != 0 ? 0.5f : f5);
    }

    /* renamed from: linkTo-R7zmacU$default  reason: not valid java name */
    public static /* synthetic */ void m4122linkToR7zmacU$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i, Object obj) {
        float f11;
        int i2 = i;
        float r8 = (i2 & 16) != 0 ? Dp.m3859constructorimpl((float) 0) : f;
        float r9 = (i2 & 32) != 0 ? Dp.m3859constructorimpl((float) 0) : f2;
        float r10 = (i2 & 64) != 0 ? Dp.m3859constructorimpl((float) 0) : f3;
        float r11 = (i2 & 128) != 0 ? Dp.m3859constructorimpl((float) 0) : f4;
        float r12 = (i2 & 256) != 0 ? Dp.m3859constructorimpl((float) 0) : f5;
        float r13 = (i2 & 512) != 0 ? Dp.m3859constructorimpl((float) 0) : f6;
        float r14 = (i2 & 1024) != 0 ? Dp.m3859constructorimpl((float) 0) : f7;
        if ((i2 & 2048) != 0) {
            f11 = Dp.m3859constructorimpl((float) 0);
        } else {
            f11 = f8;
        }
        constrainScope.m4129linkToR7zmacU(verticalAnchor, horizontalAnchor, verticalAnchor2, horizontalAnchor2, r8, r9, r10, r11, r12, r13, r14, f11, (i2 & 4096) != 0 ? 0.5f : f9, (i2 & 8192) != 0 ? 0.5f : f10);
    }
}
