package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusNodeUtilsKt;
import androidx.compose.ui.focus.FocusOrder;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollDelegatingWrapper;
import androidx.compose.ui.input.pointer.PointerInputFilter;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.semantics.SemanticsWrapper;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b \u0018\u0000 ë\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005:\u0002ë\u0001B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\fH\u0002J%\u0010k\u001a\u00020o2\u0006\u0010l\u001a\u00020\u00002\u0006\u0010p\u001a\u00020oH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bq\u0010rJ\b\u0010s\u001a\u00020\u0007H\u0016J\u0010\u0010t\u001a\u00020G2\u0006\u0010u\u001a\u00020FH&J\u001d\u0010v\u001a\u00020A2\u0006\u0010@\u001a\u00020AH\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bw\u0010xJ\b\u0010y\u001a\u00020\u0007H\u0016J%\u0010z\u001a\u00020#2\u0006\u0010{\u001a\u00020o2\u0006\u0010@\u001a\u00020AH\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b|\u0010}J\u000e\u0010~\u001a\u00020\u00072\u0006\u0010\u001a\u00020\u0006J\u001b\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0011\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u001a\u00020\u0006H\u0002J\u0018\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u0001J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H&J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H&J\u0015\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\fH&J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H&J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H&J\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0003\b\u0001J\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0003\b\u0001J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H&J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H&J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H&J\u0018\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00012\u0007\u0010\u0001\u001a\u00020\fJ\u001f\u0010\u0001\u001a\u00020o2\u0006\u0010N\u001a\u00020oH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0001\u0010xJ\u001a\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\fH\u0002J\u0012\u0010\u0001\u001a\u00020G2\u0006\u0010u\u001a\u00020FH\u0002J\u000b\u0010\u0001\u001a\u0004\u0018\u00010\u0003H\u0014JC\u0010\u0001\u001a\u00020\u00072\u0006\u0010{\u001a\u00020o2\u000f\u0010 \u0001\u001a\n\u0012\u0005\u0012\u00030¢\u00010¡\u00012\u0007\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\fH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001J:\u0010§\u0001\u001a\u00020\u00072\u0006\u0010{\u001a\u00020o2\u000f\u0010¨\u0001\u001a\n\u0012\u0005\u0012\u00030©\u00010¡\u00012\u0007\u0010¤\u0001\u001a\u00020\fH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bª\u0001\u0010«\u0001J\t\u0010¬\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010­\u0001\u001a\u00020\u00072\u0006\u0010\u001a\u00020\u0006H\u0002J \u0010®\u0001\u001a\u00020\f2\u0006\u0010{\u001a\u00020oH\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u0007\u0010±\u0001\u001a\u00020\fJ\u001b\u0010²\u0001\u001a\u00030³\u00012\u0007\u0010´\u0001\u001a\u00020\u00032\u0006\u0010n\u001a\u00020\fH\u0016J*\u0010µ\u0001\u001a\u00020o2\u0007\u0010´\u0001\u001a\u00020\u00032\u0007\u0010¶\u0001\u001a\u00020oH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b·\u0001\u0010¸\u0001J \u0010¹\u0001\u001a\u00020o2\u0007\u0010º\u0001\u001a\u00020oH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b»\u0001\u0010xJ \u0010¼\u0001\u001a\u00020o2\u0007\u0010º\u0001\u001a\u00020oH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b½\u0001\u0010xJ\u001f\u0010¾\u0001\u001a\u00020o2\u0006\u0010{\u001a\u00020oH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b¿\u0001\u0010xJ\t\u0010À\u0001\u001a\u00020\u0007H\u0016J\"\u0010Á\u0001\u001a\u00020\u00072\u0019\u0010-\u001a\u0015\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b,J\u001b\u0010Â\u0001\u001a\u00020\u00072\u0007\u0010Ã\u0001\u001a\u00020G2\u0007\u0010Ä\u0001\u001a\u00020GH\u0014J\t\u0010Å\u0001\u001a\u00020\u0007H\u0016J(\u0010Æ\u0001\u001a\u0003HÇ\u0001\"\u0005\b\u0000\u0010Ç\u00012\u000f\u0010È\u0001\u001a\n\u0012\u0005\u0012\u0003HÇ\u00010É\u0001H\u0016¢\u0006\u0003\u0010Ê\u0001J\t\u0010Ë\u0001\u001a\u00020\u0007H\u0016J\u0011\u0010Ì\u0001\u001a\u00020\u00072\u0006\u0010\u001a\u00020\u0006H\u0016J5\u0010Í\u0001\u001a\u00020\u00012\b\u0010Î\u0001\u001a\u00030Ï\u00012\r\u0010Ð\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\bø\u0001\u0000ø\u0001\u0003ø\u0001\u0001¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001JC\u0010Ó\u0001\u001a\u00020\u00072\u0006\u0010N\u001a\u00020M2\u0006\u0010f\u001a\u00020#2\u0019\u0010-\u001a\u0015\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b,H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u0013\u0010Ö\u0001\u001a\u00020\u00072\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0016J\u0013\u0010Ù\u0001\u001a\u00020\u00072\b\u0010Ú\u0001\u001a\u00030Û\u0001H\u0016J\u001c\u0010Ü\u0001\u001a\u00020\u00072\u0007\u0010m\u001a\u00030³\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Ý\u0001J+\u0010Þ\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\f2\t\b\u0002\u0010ß\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\bà\u0001J\t\u0010á\u0001\u001a\u00020\fH\u0016J\u001f\u0010â\u0001\u001a\u00020o2\u0006\u0010N\u001a\u00020oH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\bã\u0001\u0010xJ\t\u0010ä\u0001\u001a\u00020\u0007H\u0002J \u0010å\u0001\u001a\u00020o2\u0007\u0010æ\u0001\u001a\u00020oH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\bç\u0001\u0010xJ*\u0010è\u0001\u001a\u00020\u00072\u0006\u0010\u001a\u00020\u00062\u0013\u0010Ð\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0003J \u0010é\u0001\u001a\u00020\f2\u0006\u0010{\u001a\u00020oH\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bê\u0001\u0010°\u0001R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019R\u000e\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\"\u0010(\u001a\u0004\u0018\u00010'2\b\u0010$\u001a\u0004\u0018\u00010'@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*RD\u0010-\u001a\u0015\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b,2\u0019\u0010$\u001a\u0015\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b,@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R$\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000e8F@@X\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0012\u0010<\u001a\u00020=X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020A8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001c\u0010D\u001a\u0010\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020G\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010H\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0013\u0010K\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bL\u0010JR)\u0010N\u001a\u00020M2\u0006\u0010$\u001a\u00020M@BX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010P\u001a\u0004\bO\u0010CR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020F0R8VX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u00108DX\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020Y8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bZ\u0010CR\u0014\u0010[\u001a\u00020\\8BX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0016\u0010_\u001a\u0004\u0018\u00010\u00008PX\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u001c\u0010b\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010a\"\u0004\bd\u0010eR$\u0010f\u001a\u00020#2\u0006\u0010$\u001a\u00020#@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010j\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006ì\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeWrapper;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_isAttached", "", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "drawEntityHead", "Landroidx/compose/ui/node/DrawEntity;", "getDrawEntityHead", "()Landroidx/compose/ui/node/DrawEntity;", "setDrawEntityHead", "(Landroidx/compose/ui/node/DrawEntity;)V", "hasMeasureResult", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isShallowPlacing", "setShallowPlacing", "(Z)V", "isValid", "lastLayerAlpha", "", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "value", "measureResult", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "()J", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "(Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "zIndex", "getZIndex", "()F", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/LayoutNodeWrapper;J)J", "attach", "calculateAlignmentLine", "alignmentLine", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "detach", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "findLastFocusWrapper", "Landroidx/compose/ui/node/ModifiedFocusNode;", "findLastKeyInputWrapper", "Landroidx/compose/ui/node/ModifiedKeyInputNode;", "findNextFocusWrapper", "excludeDeactivated", "findNextKeyInputWrapper", "findNextNestedScrollWrapper", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDelegatingWrapper;", "findParentFocusNode", "findParentFocusNode$ui_release", "findParentKeyInputNode", "findParentKeyInputNode$ui_release", "findPreviousFocusWrapper", "findPreviousKeyInputWrapper", "findPreviousNestedScrollWrapper", "focusableChildren", "", "fromParentPosition", "fromParentPosition-MK-Hz9U", "fromParentRect", "bounds", "get", "getWrappedByCoordinates", "hitTest", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsWrappers", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "hitTestSemantics-9KIMszo", "(JLandroidx/compose/ui/node/HitTestResult;Z)V", "invalidateLayer", "invoke", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onInitialize", "onLayerBlockUpdated", "onMeasureResultChanged", "width", "height", "onModifierChanged", "onModifierLocalRead", "T", "modifierLocal", "Landroidx/compose/ui/modifier/ModifierLocal;", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "onPlaced", "performDraw", "performingMeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "populateFocusOrder", "focusOrder", "Landroidx/compose/ui/focus/FocusOrder;", "propagateFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "propagateRelocationRequest", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-MK-Hz9U", "updateLayerParameters", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutNodeWrapper.kt */
public abstract class LayoutNodeWrapper extends Placeable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    /* access modifiers changed from: private */
    public static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final Function1<LayoutNodeWrapper, Unit> onCommitAffectingLayer = LayoutNodeWrapper$Companion$onCommitAffectingLayer$1.INSTANCE;
    private static final Function1<LayoutNodeWrapper, Unit> onCommitAffectingLayerParams = LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1.INSTANCE;
    private boolean _isAttached;
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private DrawEntity drawEntityHead;
    private final Function0<Unit> invalidateParentLayer = new LayoutNodeWrapper$invalidateParentLayer$1(this);
    private boolean isClipping;
    private boolean isShallowPlacing;
    private float lastLayerAlpha = 0.8f;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity;
    private LayoutDirection layerLayoutDirection;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m3987getZeronOccac();
    private LayoutNodeWrapper wrappedBy;
    private float zIndex;

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    public abstract ModifiedFocusNode findLastFocusWrapper();

    public abstract ModifiedKeyInputNode findLastKeyInputWrapper();

    public abstract ModifiedFocusNode findNextFocusWrapper(boolean z);

    public abstract ModifiedKeyInputNode findNextKeyInputWrapper();

    public abstract NestedScrollDelegatingWrapper findNextNestedScrollWrapper();

    public abstract ModifiedFocusNode findPreviousFocusWrapper();

    public abstract ModifiedKeyInputNode findPreviousKeyInputWrapper();

    public abstract NestedScrollDelegatingWrapper findPreviousNestedScrollWrapper();

    public abstract MeasureScope getMeasureScope();

    public LayoutNodeWrapper getWrapped$ui_release() {
        return null;
    }

    /* renamed from: hitTest-M_7yMNQ  reason: not valid java name */
    public abstract void m3345hitTestM_7yMNQ(long j, HitTestResult<PointerInputFilter> hitTestResult, boolean z, boolean z2);

    /* renamed from: hitTestSemantics-9KIMszo  reason: not valid java name */
    public abstract void m3346hitTestSemantics9KIMszo(long j, HitTestResult<SemanticsWrapper> hitTestResult, boolean z);

    public void onPlaced() {
    }

    public Object propagateRelocationRequest(Rect rect, Continuation<? super Unit> continuation) {
        return propagateRelocationRequest$suspendImpl(this, rect, continuation);
    }

    public boolean shouldSharePointerInputWithSiblings() {
        return false;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Canvas) obj);
        return Unit.INSTANCE;
    }

    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    public LayoutNodeWrapper(LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
        this.layerDensity = layoutNode2.getDensity();
        this.layerLayoutDirection = layoutNode2.getLayoutDirection();
    }

    public final LayoutNodeWrapper getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(LayoutNodeWrapper layoutNodeWrapper) {
        this.wrappedBy = layoutNodeWrapper;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m3344getSizeYbymL2g() {
        return m3173getMeasuredSizeYbymL2g();
    }

    /* access modifiers changed from: protected */
    public final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        Boolean valueOf = layoutNodeWrapper == null ? null : Boolean.valueOf(layoutNodeWrapper.isTransparent());
        if (valueOf == null) {
            return false;
        }
        return valueOf.booleanValue();
    }

    public final boolean isAttached() {
        if (!this._isAttached || this.layoutNode.isAttached()) {
            return this._isAttached;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final MeasureResult getMeasureResult() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public final void setMeasureResult$ui_release(MeasureResult measureResult) {
        LayoutNode parent$ui_release;
        Intrinsics.checkNotNullParameter(measureResult, "value");
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (!(measureResult2 != null && measureResult.getWidth() == measureResult2.getWidth() && measureResult.getHeight() == measureResult2.getHeight())) {
                onMeasureResultChanged(measureResult.getWidth(), measureResult.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!measureResult.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual((Object) measureResult.getAlignmentLines(), (Object) this.oldAlignmentLines)) {
                LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
                if (Intrinsics.areEqual((Object) wrapped$ui_release == null ? null : wrapped$ui_release.layoutNode, (Object) this.layoutNode)) {
                    LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
                    if (parent$ui_release2 != null) {
                        parent$ui_release2.onAlignmentsChanged$ui_release();
                    }
                    if (this.layoutNode.getAlignmentLines$ui_release().getUsedDuringParentMeasurement$ui_release()) {
                        LayoutNode parent$ui_release3 = this.layoutNode.getParent$ui_release();
                        if (parent$ui_release3 != null) {
                            parent$ui_release3.requestRemeasure$ui_release();
                        }
                    } else if (this.layoutNode.getAlignmentLines$ui_release().getUsedDuringParentLayout$ui_release() && (parent$ui_release = this.layoutNode.getParent$ui_release()) != null) {
                        parent$ui_release.requestRelayout$ui_release();
                    }
                } else {
                    this.layoutNode.onAlignmentsChanged$ui_release();
                }
                this.layoutNode.getAlignmentLines$ui_release().setDirty$ui_release(true);
                Map<AlignmentLine, Integer> map2 = this.oldAlignmentLines;
                if (map2 == null) {
                    map2 = new LinkedHashMap<>();
                    this.oldAlignmentLines = map2;
                }
                map2.clear();
                map2.putAll(measureResult.getAlignmentLines());
            }
        }
    }

    private final boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        Map<AlignmentLine, Integer> alignmentLines;
        MeasureResult measureResult = this._measureResult;
        Set<AlignmentLine> set = null;
        if (!(measureResult == null || (alignmentLines = measureResult.getAlignmentLines()) == null)) {
            set = alignmentLines.keySet();
        }
        return set == null ? SetsKt.emptySet() : set;
    }

    /* access modifiers changed from: protected */
    public void onMeasureResultChanged(int i, int i2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.m3370resizeozmzZPI(IntSizeKt.IntSize(i, i2));
        } else {
            LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
            if (layoutNodeWrapper != null) {
                layoutNodeWrapper.invalidateLayer();
            }
        }
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(this.layoutNode);
        }
        m3176setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        DrawEntity drawEntity = this.drawEntityHead;
        if (drawEntity != null) {
            drawEntity.onMeasureResultChanged(i, i2);
        }
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public final long m3343getPositionnOccac() {
        return this.position;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* access modifiers changed from: protected */
    public final void setZIndex(float f) {
        this.zIndex = f;
    }

    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (isAttached()) {
            return this.layoutNode.getOuterLayoutNodeWrapper$ui_release().wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    public final LayoutCoordinates getParentCoordinates() {
        if (isAttached()) {
            LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
            if (layoutNodeWrapper == null) {
                return null;
            }
            return layoutNodeWrapper.getWrappedByCoordinates();
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* access modifiers changed from: protected */
    public LayoutCoordinates getWrappedByCoordinates() {
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        if (layoutNodeWrapper == null) {
            return null;
        }
        return layoutNodeWrapper.getWrappedByCoordinates();
    }

    public final boolean isShallowPlacing() {
        return this.isShallowPlacing;
    }

    public final void setShallowPlacing(boolean z) {
        this.isShallowPlacing = z;
    }

    /* access modifiers changed from: protected */
    public final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver();
    }

    public final DrawEntity getDrawEntityHead() {
        return this.drawEntityHead;
    }

    public final void setDrawEntityHead(DrawEntity drawEntity) {
        this.drawEntityHead = drawEntity;
    }

    /* access modifiers changed from: protected */
    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    public final Placeable m3351performingMeasureK40F9xA(long j, Function0<? extends Placeable> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        m3177setMeasurementConstraintsBRTryo0(j);
        Placeable placeable = (Placeable) function0.invoke();
        OwnedLayer layer2 = getLayer();
        if (layer2 != null) {
            layer2.m3370resizeozmzZPI(m3173getMeasuredSizeYbymL2g());
        }
        return placeable;
    }

    public final int get(AlignmentLine alignmentLine) {
        int calculateAlignmentLine;
        int i;
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        if (!getHasMeasureResult() || (calculateAlignmentLine = calculateAlignmentLine(alignmentLine)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (alignmentLine instanceof VerticalAlignmentLine) {
            i = IntOffset.m3977getXimpl(m3172getApparentToRealOffsetnOccac());
        } else {
            i = IntOffset.m3978getYimpl(m3172getApparentToRealOffsetnOccac());
        }
        return calculateAlignmentLine + i;
    }

    public void onInitialize() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m3352placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        onLayerBlockUpdated(function1);
        if (!IntOffset.m3976equalsimpl0(m3343getPositionnOccac(), j)) {
            this.position = j;
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m3369movegyyYBs(j);
            } else {
                LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
                if (layoutNodeWrapper != null) {
                    layoutNodeWrapper.invalidateLayer();
                }
            }
            LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
            if (!Intrinsics.areEqual((Object) wrapped$ui_release == null ? null : wrapped$ui_release.layoutNode, (Object) this.layoutNode)) {
                this.layoutNode.onAlignmentsChanged$ui_release();
            } else {
                LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
                if (parent$ui_release != null) {
                    parent$ui_release.onAlignmentsChanged$ui_release();
                }
            }
            Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(this.layoutNode);
            }
        }
        this.zIndex = f;
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        float r0 = (float) IntOffset.m3977getXimpl(m3343getPositionnOccac());
        float r1 = (float) IntOffset.m3978getYimpl(m3343getPositionnOccac());
        canvas.translate(r0, r1);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-r0, -r1);
    }

    /* access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        DrawEntity drawEntity = this.drawEntityHead;
        if (drawEntity == null) {
            performDraw(canvas);
        } else {
            drawEntity.draw(canvas);
        }
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            wrapped$ui_release.draw(canvas);
        }
    }

    public void invoke(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.layoutNode.isPlaced()) {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new LayoutNodeWrapper$invoke$1(this, canvas));
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.lastLayerDrawingWasSkipped = true;
    }

    public final void onLayerBlockUpdated(Function1<? super GraphicsLayerScope, Unit> function1) {
        Owner owner$ui_release;
        boolean z = (this.layerBlock == function1 && Intrinsics.areEqual((Object) this.layerDensity, (Object) this.layoutNode.getDensity()) && this.layerLayoutDirection == this.layoutNode.getLayoutDirection()) ? false : true;
        this.layerBlock = function1;
        this.layerDensity = this.layoutNode.getDensity();
        this.layerLayoutDirection = this.layoutNode.getLayoutDirection();
        if (!isAttached() || function1 == null) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                getLayoutNode$ui_release().setInnerLayerWrapperIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner$ui_release = getLayoutNode$ui_release().getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(getLayoutNode$ui_release());
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
        } else if (this.layer == null) {
            OwnedLayer createLayer = LayoutNodeKt.requireOwner(this.layoutNode).createLayer(this, this.invalidateParentLayer);
            createLayer.m3370resizeozmzZPI(m3173getMeasuredSizeYbymL2g());
            createLayer.m3369movegyyYBs(m3343getPositionnOccac());
            this.layer = createLayer;
            updateLayerParameters();
            this.layoutNode.setInnerLayerWrapperIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
        } else if (z) {
            updateLayerParameters();
        }
    }

    /* access modifiers changed from: private */
    public final void updateLayerParameters() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 != null) {
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
                reusableGraphicsLayerScope.reset();
                reusableGraphicsLayerScope.setGraphicsDensity$ui_release(this.layoutNode.getDensity());
                getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new LayoutNodeWrapper$updateLayerParameters$1(function1));
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = reusableGraphicsLayerScope;
                ownedLayer.m3371updateLayerPropertiesYPkPJjM(reusableGraphicsLayerScope.getScaleX(), reusableGraphicsLayerScope.getScaleY(), reusableGraphicsLayerScope.getAlpha(), reusableGraphicsLayerScope.getTranslationX(), reusableGraphicsLayerScope.getTranslationY(), reusableGraphicsLayerScope.getShadowElevation(), reusableGraphicsLayerScope.getRotationX(), reusableGraphicsLayerScope.getRotationY(), reusableGraphicsLayerScope.getRotationZ(), reusableGraphicsLayerScope.getCameraDistance(), reusableGraphicsLayerScope.m1865getTransformOriginSzJe1aQ(), reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope.getClip(), reusableGraphicsLayerScope2.getRenderEffect(), this.layoutNode.getLayoutDirection(), this.layoutNode.getDensity());
                this.isClipping = reusableGraphicsLayerScope2.getClip();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            if (!(this.layerBlock == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        this.lastLayerAlpha = graphicsLayerScope.getAlpha();
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(this.layoutNode);
        }
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    public boolean isValid() {
        return this.layer != null;
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc  reason: not valid java name */
    public final long m3342getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.m3829toSizeXkaWNTQ(getLayoutNode$ui_release().getViewConfiguration().m3453getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m3354windowToLocalMKHz9U(long j) {
        if (isAttached()) {
            LayoutCoordinates findRoot = LayoutCoordinatesKt.findRoot(this);
            return m3348localPositionOfR5De75A(findRoot, Offset.m1357minusMKHz9U(LayoutNodeKt.requireOwner(this.layoutNode).m3372calculateLocalPositionMKHz9U(j), LayoutCoordinatesKt.positionInRoot(findRoot)));
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m3350localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(this.layoutNode).m3373calculatePositionInWindowMKHz9U(m3349localToRootMKHz9U(j));
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m3348localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        LayoutNodeWrapper layoutNodeWrapper = (LayoutNodeWrapper) layoutCoordinates;
        LayoutNodeWrapper findCommonAncestor$ui_release = findCommonAncestor$ui_release(layoutNodeWrapper);
        while (layoutNodeWrapper != findCommonAncestor$ui_release) {
            j = layoutNodeWrapper.m3353toParentPositionMKHz9U(j);
            layoutNodeWrapper = layoutNodeWrapper.wrappedBy;
            Intrinsics.checkNotNull(layoutNodeWrapper);
        }
        return m3337ancestorToLocalR5De75A(findCommonAncestor$ui_release, j);
    }

    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        } else if (layoutCoordinates.isAttached()) {
            LayoutNodeWrapper layoutNodeWrapper = (LayoutNodeWrapper) layoutCoordinates;
            LayoutNodeWrapper findCommonAncestor$ui_release = findCommonAncestor$ui_release(layoutNodeWrapper);
            MutableRect rectCache = getRectCache();
            rectCache.setLeft(0.0f);
            rectCache.setTop(0.0f);
            rectCache.setRight((float) IntSize.m4019getWidthimpl(layoutCoordinates.m3140getSizeYbymL2g()));
            rectCache.setBottom((float) IntSize.m4018getHeightimpl(layoutCoordinates.m3140getSizeYbymL2g()));
            while (layoutNodeWrapper != findCommonAncestor$ui_release) {
                rectInParent$ui_release$default(layoutNodeWrapper, rectCache, z, false, 4, (Object) null);
                if (rectCache.isEmpty()) {
                    return Rect.Companion.getZero();
                }
                layoutNodeWrapper = layoutNodeWrapper.wrappedBy;
                Intrinsics.checkNotNull(layoutNodeWrapper);
            }
            ancestorToLocal(findCommonAncestor$ui_release, rectCache, z);
            return MutableRectKt.toRect(rectCache);
        } else {
            throw new IllegalStateException(("LayoutCoordinates " + layoutCoordinates + " is not attached!").toString());
        }
    }

    /* renamed from: ancestorToLocal-R5De75A  reason: not valid java name */
    private final long m3337ancestorToLocalR5De75A(LayoutNodeWrapper layoutNodeWrapper, long j) {
        if (layoutNodeWrapper == this) {
            return j;
        }
        LayoutNodeWrapper layoutNodeWrapper2 = this.wrappedBy;
        if (layoutNodeWrapper2 == null || Intrinsics.areEqual((Object) layoutNodeWrapper, (Object) layoutNodeWrapper2)) {
            return m3341fromParentPositionMKHz9U(j);
        }
        return m3341fromParentPositionMKHz9U(layoutNodeWrapper2.m3337ancestorToLocalR5De75A(layoutNodeWrapper, j));
    }

    private final void ancestorToLocal(LayoutNodeWrapper layoutNodeWrapper, MutableRect mutableRect, boolean z) {
        if (layoutNodeWrapper != this) {
            LayoutNodeWrapper layoutNodeWrapper2 = this.wrappedBy;
            if (layoutNodeWrapper2 != null) {
                layoutNodeWrapper2.ancestorToLocal(layoutNodeWrapper, mutableRect, z);
            }
            fromParentRect(mutableRect, z);
        }
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m3349localToRootMKHz9U(long j) {
        if (isAttached()) {
            for (LayoutNodeWrapper layoutNodeWrapper = this; layoutNodeWrapper != null; layoutNodeWrapper = layoutNodeWrapper.wrappedBy) {
                j = layoutNodeWrapper.m3353toParentPositionMKHz9U(j);
            }
            return j;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* access modifiers changed from: protected */
    public final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(function1, "block");
        float r0 = (float) IntOffset.m3977getXimpl(m3343getPositionnOccac());
        float r1 = (float) IntOffset.m3978getYimpl(m3343getPositionnOccac());
        canvas.translate(r0, r1);
        function1.invoke(canvas);
        canvas.translate(-r0, -r1);
    }

    /* renamed from: toParentPosition-MK-Hz9U  reason: not valid java name */
    public long m3353toParentPositionMKHz9U(long j) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.m3368mapOffset8S9VItk(j, false);
        }
        return IntOffsetKt.m3991plusNvtHpc(j, m3343getPositionnOccac());
    }

    /* renamed from: fromParentPosition-MK-Hz9U  reason: not valid java name */
    public long m3341fromParentPositionMKHz9U(long j) {
        long r3 = IntOffsetKt.m3989minusNvtHpc(j, m3343getPositionnOccac());
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null ? r3 : ownedLayer.m3368mapOffset8S9VItk(r3, true);
    }

    /* access modifiers changed from: protected */
    public final void drawBorder(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRect(new Rect(0.5f, 0.5f, ((float) IntSize.m4019getWidthimpl(m3173getMeasuredSizeYbymL2g())) - 0.5f, ((float) IntSize.m4018getHeightimpl(m3173getMeasuredSizeYbymL2g())) - 0.5f), paint);
    }

    public void attach() {
        this._isAttached = true;
        onLayerBlockUpdated(this.layerBlock);
    }

    public void detach() {
        this._isAttached = false;
        onLayerBlockUpdated(this.layerBlock);
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(LayoutNodeWrapper layoutNodeWrapper, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            layoutNodeWrapper.rectInParent$ui_release(mutableRect, z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
    }

    public final void rectInParent$ui_release(MutableRect mutableRect, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(mutableRect, "bounds");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long r8 = m3342getMinimumTouchTargetSizeNHjbRc();
                    float r1 = Size.m1422getWidthimpl(r8) / 2.0f;
                    float r82 = Size.m1419getHeightimpl(r8) / 2.0f;
                    mutableRect.intersect(-r1, -r82, ((float) IntSize.m4019getWidthimpl(m3344getSizeYbymL2g())) + r1, ((float) IntSize.m4018getHeightimpl(m3344getSizeYbymL2g())) + r82);
                } else if (z) {
                    mutableRect.intersect(0.0f, 0.0f, (float) IntSize.m4019getWidthimpl(m3344getSizeYbymL2g()), (float) IntSize.m4018getHeightimpl(m3344getSizeYbymL2g()));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        float r83 = (float) IntOffset.m3977getXimpl(m3343getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() + r83);
        mutableRect.setRight(mutableRect.getRight() + r83);
        float r84 = (float) IntOffset.m3978getYimpl(m3343getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() + r84);
        mutableRect.setBottom(mutableRect.getBottom() + r84);
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z) {
        float r0 = (float) IntOffset.m3977getXimpl(m3343getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - r0);
        mutableRect.setRight(mutableRect.getRight() - r0);
        float r02 = (float) IntOffset.m3978getYimpl(m3343getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - r02);
        mutableRect.setBottom(mutableRect.getBottom() - r02);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                mutableRect.intersect(0.0f, 0.0f, (float) IntSize.m4019getWidthimpl(m3344getSizeYbymL2g()), (float) IntSize.m4018getHeightimpl(m3344getSizeYbymL2g()));
                if (mutableRect.isEmpty()) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: withinLayerBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m3355withinLayerBoundsk4lQ0M(long j) {
        if (!OffsetKt.m1370isFinitek4lQ0M(j)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null || !this.isClipping || ownedLayer.m3367isInLayerk4lQ0M(j)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: isPointerInBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m3347isPointerInBoundsk4lQ0M(long j) {
        float r0 = Offset.m1353getXimpl(j);
        float r3 = Offset.m1354getYimpl(j);
        return r0 >= 0.0f && r3 >= 0.0f && r0 < ((float) getMeasuredWidth()) && r3 < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        if (layoutNodeWrapper != null) {
            layoutNodeWrapper.invalidateLayer();
        }
    }

    public void propagateFocusEvent(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        if (layoutNodeWrapper != null) {
            layoutNodeWrapper.propagateFocusEvent(focusState);
        }
    }

    public void populateFocusOrder(FocusOrder focusOrder) {
        Intrinsics.checkNotNullParameter(focusOrder, "focusOrder");
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        if (layoutNodeWrapper != null) {
            layoutNodeWrapper.populateFocusOrder(focusOrder);
        }
    }

    static /* synthetic */ Object propagateRelocationRequest$suspendImpl(LayoutNodeWrapper layoutNodeWrapper, Rect rect, Continuation continuation) {
        LayoutNodeWrapper wrappedBy$ui_release = layoutNodeWrapper.getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null) {
            return Unit.INSTANCE;
        }
        Object propagateRelocationRequest = wrappedBy$ui_release.propagateRelocationRequest(rect.m1390translatek4lQ0M(wrappedBy$ui_release.localBoundingBoxOf(layoutNodeWrapper, false).m1388getTopLeftF1C5BW0()), continuation);
        return propagateRelocationRequest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? propagateRelocationRequest : Unit.INSTANCE;
    }

    public final ModifiedFocusNode findParentFocusNode$ui_release() {
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        ModifiedFocusNode findPreviousFocusWrapper = layoutNodeWrapper == null ? null : layoutNodeWrapper.findPreviousFocusWrapper();
        if (findPreviousFocusWrapper != null) {
            return findPreviousFocusWrapper;
        }
        for (LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            ModifiedFocusNode findLastFocusWrapper = parent$ui_release.getOuterLayoutNodeWrapper$ui_release().findLastFocusWrapper();
            if (findLastFocusWrapper != null) {
                return findLastFocusWrapper;
            }
        }
        return null;
    }

    public final ModifiedKeyInputNode findParentKeyInputNode$ui_release() {
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        ModifiedKeyInputNode findPreviousKeyInputWrapper = layoutNodeWrapper == null ? null : layoutNodeWrapper.findPreviousKeyInputWrapper();
        if (findPreviousKeyInputWrapper != null) {
            return findPreviousKeyInputWrapper;
        }
        for (LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            ModifiedKeyInputNode findLastKeyInputWrapper = parent$ui_release.getOuterLayoutNodeWrapper$ui_release().findLastKeyInputWrapper();
            if (findLastKeyInputWrapper != null) {
                return findLastKeyInputWrapper;
            }
        }
        return null;
    }

    public void onModifierChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public <T> T onModifierLocalRead(ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "modifierLocal");
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        T onModifierLocalRead = layoutNodeWrapper == null ? null : layoutNodeWrapper.onModifierLocalRead(modifierLocal);
        return onModifierLocalRead == null ? modifierLocal.getDefaultFactory$ui_release().invoke() : onModifierLocalRead;
    }

    public final LayoutNodeWrapper findCommonAncestor$ui_release(LayoutNodeWrapper layoutNodeWrapper) {
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "other");
        LayoutNode layoutNode2 = layoutNodeWrapper.layoutNode;
        LayoutNode layoutNode3 = this.layoutNode;
        if (layoutNode2 == layoutNode3) {
            LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = layoutNode3.getOuterLayoutNodeWrapper$ui_release();
            LayoutNodeWrapper layoutNodeWrapper2 = this;
            while (layoutNodeWrapper2 != outerLayoutNodeWrapper$ui_release && layoutNodeWrapper2 != layoutNodeWrapper) {
                layoutNodeWrapper2 = layoutNodeWrapper2.wrappedBy;
                Intrinsics.checkNotNull(layoutNodeWrapper2);
            }
            return layoutNodeWrapper2 == layoutNodeWrapper ? layoutNodeWrapper : this;
        }
        while (layoutNode2.getDepth$ui_release() > layoutNode3.getDepth$ui_release()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode3.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
            layoutNode3 = layoutNode3.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode3);
        }
        while (layoutNode2 != layoutNode3) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            layoutNode3 = layoutNode3.getParent$ui_release();
            if (layoutNode2 != null) {
                if (layoutNode3 == null) {
                }
            }
            throw new IllegalArgumentException("layouts are not part of the same hierarchy");
        }
        if (layoutNode3 == this.layoutNode) {
            return this;
        }
        return layoutNode2 == layoutNodeWrapper.layoutNode ? layoutNodeWrapper : layoutNode2.getInnerLayoutNodeWrapper$ui_release();
    }

    public final List<ModifiedFocusNode> focusableChildren(boolean z) {
        LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
        ModifiedFocusNode findNextFocusWrapper = wrapped$ui_release == null ? null : wrapped$ui_release.findNextFocusWrapper(z);
        if (findNextFocusWrapper != null) {
            return CollectionsKt.listOf(findNextFocusWrapper);
        }
        List<ModifiedFocusNode> arrayList = new ArrayList<>();
        List<LayoutNode> children$ui_release = this.layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i = 0; i < size; i++) {
            FocusNodeUtilsKt.findFocusableChildren(children$ui_release.get(i), arrayList, z);
        }
        return arrayList;
    }

    /* renamed from: offsetFromEdge-MK-Hz9U  reason: not valid java name */
    private final long m3338offsetFromEdgeMKHz9U(long j) {
        float f;
        float f2;
        float r0 = Offset.m1353getXimpl(j);
        if (r0 < 0.0f) {
            f = -r0;
        } else {
            f = r0 - ((float) getMeasuredWidth());
        }
        float max = Math.max(0.0f, f);
        float r4 = Offset.m1354getYimpl(j);
        if (r4 < 0.0f) {
            f2 = -r4;
        } else {
            f2 = r4 - ((float) getMeasuredHeight());
        }
        return OffsetKt.Offset(max, Math.max(0.0f, f2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU  reason: not valid java name */
    public final long m3339calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        return SizeKt.Size(Math.max(0.0f, (Size.m1422getWidthimpl(j) - ((float) getMeasuredWidth())) / 2.0f), Math.max(0.0f, (Size.m1419getHeightimpl(j) - ((float) getMeasuredHeight())) / 2.0f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: distanceInMinimumTouchTarget-tz77jQw  reason: not valid java name */
    public final float m3340distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (((float) getMeasuredWidth()) >= Size.m1422getWidthimpl(j2) && ((float) getMeasuredHeight()) >= Size.m1419getHeightimpl(j2)) {
            return Float.POSITIVE_INFINITY;
        }
        long r6 = m3339calculateMinimumTouchTargetPaddingE7KxVPU(j2);
        float r0 = Size.m1422getWidthimpl(r6);
        float r62 = Size.m1419getHeightimpl(r6);
        long r4 = m3338offsetFromEdgeMKHz9U(j);
        if ((r0 > 0.0f || r62 > 0.0f) && Offset.m1353getXimpl(r4) <= r0 && Offset.m1354getYimpl(r4) <= r62) {
            return Math.max(Offset.m1353getXimpl(r4), Offset.m1354getYimpl(r4));
        }
        return Float.POSITIVE_INFINITY;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeWrapper$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "", "onCommitAffectingLayerParams", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LayoutNodeWrapper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
