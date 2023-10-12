package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_shoppingCart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ShoppingCart", "Landroidx/compose/material/icons/Icons$TwoTone;", "getShoppingCart", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShoppingCart.kt */
public final class ShoppingCartKt {
    private static ImageVector _shoppingCart;

    public static final ImageVector getShoppingCart(Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _shoppingCart;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = r1;
        ImageVector.Builder builder3 = new ImageVector.Builder("TwoTone.ShoppingCart", Dp.m3859constructorimpl(24.0f), Dp.m3859constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, 96, (DefaultConstructorMarker) null);
        int r21 = StrokeCap.Companion.m1916getButtKaPHkGw();
        int r22 = StrokeJoin.Companion.m1926getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(15.55f, 11.0f);
        pathBuilder.lineToRelative(2.76f, -5.0f);
        pathBuilder.horizontalLineTo(6.16f);
        pathBuilder.lineToRelative(2.37f, 5.0f);
        pathBuilder.close();
        ImageVector.Builder.m2190addPathoIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m1622getBlack0d7_KjU(), (DefaultConstructorMarker) null), 0.3f, (Brush) null, 0.3f, 1.0f, r21, r22, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int r38 = StrokeCap.Companion.m1916getButtKaPHkGw();
        int r39 = StrokeJoin.Companion.m1926getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(15.55f, 13.0f);
        PathBuilder pathBuilder3 = pathBuilder2;
        pathBuilder3.curveToRelative(0.75f, 0.0f, 1.41f, -0.41f, 1.75f, -1.03f);
        pathBuilder2.lineToRelative(3.58f, -6.49f);
        pathBuilder3.curveToRelative(0.37f, -0.66f, -0.11f, -1.48f, -0.87f, -1.48f);
        pathBuilder2.lineTo(5.21f, 4.0f);
        pathBuilder2.lineToRelative(-0.94f, -2.0f);
        pathBuilder2.lineTo(1.0f, 2.0f);
        pathBuilder2.verticalLineToRelative(2.0f);
        pathBuilder2.horizontalLineToRelative(2.0f);
        pathBuilder2.lineToRelative(3.6f, 7.59f);
        pathBuilder2.lineToRelative(-1.35f, 2.44f);
        pathBuilder2.curveTo(4.52f, 15.37f, 5.48f, 17.0f, 7.0f, 17.0f);
        pathBuilder2.horizontalLineToRelative(12.0f);
        pathBuilder2.verticalLineToRelative(-2.0f);
        pathBuilder2.lineTo(7.0f, 15.0f);
        pathBuilder2.lineToRelative(1.1f, -2.0f);
        pathBuilder2.horizontalLineToRelative(7.45f);
        pathBuilder2.close();
        pathBuilder2.moveTo(6.16f, 6.0f);
        pathBuilder2.horizontalLineToRelative(12.15f);
        pathBuilder2.lineToRelative(-2.76f, 5.0f);
        pathBuilder2.lineTo(8.53f, 11.0f);
        pathBuilder2.lineTo(6.16f, 6.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(7.0f, 18.0f);
        PathBuilder pathBuilder4 = pathBuilder2;
        pathBuilder4.curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f);
        pathBuilder2.reflectiveCurveTo(5.9f, 22.0f, 7.0f, 22.0f);
        pathBuilder2.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder2.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(17.0f, 18.0f);
        pathBuilder4.curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f);
        pathBuilder2.reflectiveCurveToRelative(0.89f, 2.0f, 1.99f, 2.0f);
        pathBuilder2.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder2.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilder2.close();
        ImageVector build = ImageVector.Builder.m2190addPathoIyEayM$default(builder, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m1622getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r38, r39, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _shoppingCart = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
