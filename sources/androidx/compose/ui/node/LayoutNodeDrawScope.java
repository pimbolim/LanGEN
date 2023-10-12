package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005JR\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001e0$¢\u0006\u0002\b%H\bø\u0001\u0000ø\u0001\u0003ø\u0001\u0001¢\u0006\u0004\b&\u0010'Jt\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108Jt\u0010(\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\\\u0010=\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\\\u0010=\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u0010BJ\b\u0010C\u001a\u00020\u001eH\u0016JR\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020F2\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HJp\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020F2\b\b\u0002\u0010I\u001a\u00020J2\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020J2\b\b\u0002\u0010N\u001a\u00020L2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010PJz\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020F2\b\b\u0002\u0010I\u001a\u00020J2\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020J2\b\b\u0002\u0010N\u001a\u00020L2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010Q\u001a\u00020RH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bS\u0010TJn\u0010U\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\b\b\u0002\u0010X\u001a\u00020\u000b2\b\b\u0002\u0010Y\u001a\u00020Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\b\b\u0002\u00100\u001a\u00020\u000b2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b]\u0010^Jn\u0010U\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\b\b\u0002\u0010X\u001a\u00020\u000b2\b\b\u0002\u0010Y\u001a\u00020Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\b\b\u0002\u00100\u001a\u00020\u000b2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b_\u0010`J\\\u0010a\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bb\u0010cJ\\\u0010a\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bd\u0010eJP\u0010f\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020h2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bi\u0010jJP\u0010f\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020h2\u0006\u00109\u001a\u00020:2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bk\u0010lJt\u0010m\u001a\u00020\u001e2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00070o2\u0006\u0010p\u001a\u00020q2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010X\u001a\u00020\u000b2\b\b\u0002\u0010Y\u001a\u00020Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\b\b\u0002\u00100\u001a\u00020\u000b2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u0010sJt\u0010m\u001a\u00020\u001e2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00070o2\u0006\u0010p\u001a\u00020q2\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010X\u001a\u00020\u000b2\b\b\u0002\u0010Y\u001a\u00020Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\b\b\u0002\u00100\u001a\u00020\u000b2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bt\u0010uJ\\\u0010v\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bw\u0010cJ\\\u0010v\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bx\u0010eJf\u0010y\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010z\u001a\u00020{2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b|\u0010}Jf\u0010y\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010z\u001a\u00020{2\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00100\u001a\u00020\u000b2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b~\u0010J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u00030\u0001*\u00020\u000bH\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\"\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00030\u0001*\u00020\u001bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u000b*\u00030\u0001H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u000b*\u00030\u0001H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001J\u001e\u0010\u0001\u001a\u00020\u001b*\u00030\u0001H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u00030\u0001*\u00020\u000bH\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\"\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u00020\u00078VX\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0017X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u00020\u001b8VX\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001c\u0010\t\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawEntity", "Landroidx/compose/ui/node/DrawEntity;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "layoutNodeWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/node/DrawEntity;Lkotlin/jvm/functions/Function1;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawContent", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutNodeDrawScope.kt */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    /* access modifiers changed from: private */
    public final CanvasDrawScope canvasDrawScope;
    /* access modifiers changed from: private */
    public DrawEntity drawEntity;

    public LayoutNodeDrawScope() {
        this((CanvasDrawScope) null, 1, (DefaultConstructorMarker) null);
    }

    /* renamed from: drawArc-illE91I  reason: not valid java name */
    public void m3302drawArcillE91I(Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2008drawArcillE91I(brush, f, f2, z, j, j2, f3, drawStyle2, colorFilter, i);
    }

    /* renamed from: drawArc-yD3GUKo  reason: not valid java name */
    public void m3303drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2009drawArcyD3GUKo(j, f, f2, z, j2, j3, f3, drawStyle2, colorFilter, i);
    }

    /* renamed from: drawCircle-V9BoPsw  reason: not valid java name */
    public void m3304drawCircleV9BoPsw(Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2010drawCircleV9BoPsw(brush, f, j, f2, drawStyle2, colorFilter, i);
    }

    /* renamed from: drawCircle-VaOC9Bg  reason: not valid java name */
    public void m3305drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2011drawCircleVaOC9Bg(j, f, j2, f2, drawStyle2, colorFilter, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE  reason: not valid java name */
    public /* synthetic */ void m3306drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        ImageBitmap imageBitmap2 = imageBitmap;
        Intrinsics.checkNotNullParameter(imageBitmap2, "image");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2012drawImage9jGpkUE(imageBitmap2, j, j2, j3, j4, f, drawStyle2, colorFilter, i);
    }

    /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
    public void m3307drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
        ImageBitmap imageBitmap2 = imageBitmap;
        Intrinsics.checkNotNullParameter(imageBitmap2, "image");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2013drawImageAZ2fEMs(imageBitmap2, j, j2, j3, j4, f, drawStyle2, colorFilter, i, i2);
    }

    /* renamed from: drawImage-gbVJVH8  reason: not valid java name */
    public void m3308drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m2014drawImagegbVJVH8(imageBitmap, j, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawLine-1RTmtNc  reason: not valid java name */
    public void m3309drawLine1RTmtNc(Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.canvasDrawScope.m2015drawLine1RTmtNc(brush, j, j2, f, i, pathEffect, f2, colorFilter, i2);
    }

    /* renamed from: drawLine-NGM6Ib0  reason: not valid java name */
    public void m3310drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2) {
        this.canvasDrawScope.m2016drawLineNGM6Ib0(j, j2, j3, f, i, pathEffect, f2, colorFilter, i2);
    }

    /* renamed from: drawOval-AsUm42w  reason: not valid java name */
    public void m3311drawOvalAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2017drawOvalAsUm42w(brush, j, j2, f, drawStyle2, colorFilter, i);
    }

    /* renamed from: drawOval-n-J9OG0  reason: not valid java name */
    public void m3312drawOvalnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2018drawOvalnJ9OG0(j, j2, j3, f, drawStyle2, colorFilter, i);
    }

    /* renamed from: drawPath-GBMwjPU  reason: not valid java name */
    public void m3313drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m2019drawPathGBMwjPU(path, brush, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPath-LG529CI  reason: not valid java name */
    public void m3314drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m2020drawPathLG529CI(path, j, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawPoints-F8ZwMP8  reason: not valid java name */
    public void m3315drawPointsF8ZwMP8(List<Offset> list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        Intrinsics.checkNotNullParameter(list, "points");
        this.canvasDrawScope.m2021drawPointsF8ZwMP8(list, i, j, f, i2, pathEffect, f2, colorFilter, i3);
    }

    /* renamed from: drawPoints-Gsft0Ws  reason: not valid java name */
    public void m3316drawPointsGsft0Ws(List<Offset> list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3) {
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.canvasDrawScope.m2022drawPointsGsft0Ws(list, i, brush, f, i2, pathEffect, f2, colorFilter, i3);
    }

    /* renamed from: drawRect-AsUm42w  reason: not valid java name */
    public void m3317drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2023drawRectAsUm42w(brush, j, j2, f, drawStyle2, colorFilter, i);
    }

    /* renamed from: drawRect-n-J9OG0  reason: not valid java name */
    public void m3318drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2024drawRectnJ9OG0(j, j2, j3, f, drawStyle2, colorFilter, i);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ  reason: not valid java name */
    public void m3319drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2025drawRoundRectZuiqVtQ(brush, j, j2, j3, f, drawStyle2, colorFilter, i);
    }

    /* renamed from: drawRoundRect-u-Aw5IA  reason: not valid java name */
    public void m3320drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m2026drawRoundRectuAw5IA(j, j2, j3, j4, drawStyle2, f, colorFilter, i);
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    public long m3321getCenterF1C5BW0() {
        return this.canvasDrawScope.m2027getCenterF1C5BW0();
    }

    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m3322getSizeNHjbRc() {
        return this.canvasDrawScope.m2028getSizeNHjbRc();
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m3323roundToPxR2X_6o(long j) {
        return this.canvasDrawScope.m2029roundToPxR2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m3324roundToPx0680j_4(float f) {
        return this.canvasDrawScope.m2030roundToPx0680j_4(f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m3325toDpGaN1DYA(long j) {
        return this.canvasDrawScope.m2031toDpGaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m3326toDpu2uoSUM(float f) {
        return this.canvasDrawScope.m2032toDpu2uoSUM(f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m3327toDpu2uoSUM(int i) {
        return this.canvasDrawScope.m2033toDpu2uoSUM(i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m3328toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.m2034toDpSizekrfVVM(j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m3329toPxR2X_6o(long j) {
        return this.canvasDrawScope.m2035toPxR2X_6o(j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m3330toPx0680j_4(float f) {
        return this.canvasDrawScope.m2036toPx0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.canvasDrawScope.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m3331toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.m2037toSizeXkaWNTQ(j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m3332toSp0xMU5do(float f) {
        return this.canvasDrawScope.m2038toSp0xMU5do(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m3333toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.m2039toSpkPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m3334toSpkPz2Gy4(int i) {
        return this.canvasDrawScope.m2040toSpkPz2Gy4(i);
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope2) {
        Intrinsics.checkNotNullParameter(canvasDrawScope2, "canvasDrawScope");
        this.canvasDrawScope = canvasDrawScope2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope2);
    }

    public void drawContent() {
        Canvas canvas = getDrawContext().getCanvas();
        DrawEntity drawEntity2 = this.drawEntity;
        Intrinsics.checkNotNull(drawEntity2);
        DrawEntity next = drawEntity2.getNext();
        if (next != null) {
            next.draw(canvas);
        } else {
            drawEntity2.getLayoutNodeWrapper().performDraw(canvas);
        }
    }

    /* renamed from: draw-eZhPAX0$ui_release  reason: not valid java name */
    public final void m3301draweZhPAX0$ui_release(Canvas canvas, long j, LayoutNodeWrapper layoutNodeWrapper, DrawEntity drawEntity2, Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "layoutNodeWrapper");
        Intrinsics.checkNotNullParameter(drawEntity2, "drawEntity");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawEntity access$getDrawEntity$p = this.drawEntity;
        this.drawEntity = drawEntity2;
        CanvasDrawScope access$getCanvasDrawScope$p = this.canvasDrawScope;
        LayoutDirection layoutDirection = layoutNodeWrapper.getMeasureScope().getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = access$getCanvasDrawScope$p.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long r6 = drawParams.m2042component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = access$getCanvasDrawScope$p.getDrawParams();
        drawParams2.setDensity(layoutNodeWrapper.getMeasureScope());
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m2045setSizeuvyYCjk(j);
        canvas.save();
        function1.invoke(access$getCanvasDrawScope$p);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = access$getCanvasDrawScope$p.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m2045setSizeuvyYCjk(r6);
        this.drawEntity = access$getDrawEntity$p;
    }
}
