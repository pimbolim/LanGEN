package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.input.pointer.PointerInputFilter;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsWrapper;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.brentvatne.react.ReactVideoView;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000À\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\b\u0002\u0002\u0002\u0002B\u000f\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010©\u0001\u001a\u00020xH\u0002J\u0018\u0010ª\u0001\u001a\u00020x2\u0007\u0010\u0001\u001a\u00020wH\u0000¢\u0006\u0003\b«\u0001J\u001d\u0010¬\u0001\u001a\u0010\u0012\u0005\u0012\u00030®\u0001\u0012\u0004\u0012\u0002000­\u0001H\u0000¢\u0006\u0003\b¯\u0001J\t\u0010°\u0001\u001a\u00020xH\u0002J\u0014\u0010±\u0001\u001a\u00030²\u00012\b\b\u0002\u0010/\u001a\u000200H\u0002J\u000f\u0010³\u0001\u001a\u00020xH\u0000¢\u0006\u0003\b´\u0001J\u000f\u0010µ\u0001\u001a\u00020xH\u0000¢\u0006\u0003\b¶\u0001J\u0019\u0010·\u0001\u001a\u00020x2\b\u0010¸\u0001\u001a\u00030¹\u0001H\u0000¢\u0006\u0003\bº\u0001J\u001f\u0010»\u0001\u001a\u00020x2\u0013\u0010¼\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020x0vH\bJ\u001f\u0010½\u0001\u001a\u00020x2\u0013\u0010¼\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020x0vH\bJ\t\u0010¾\u0001\u001a\u00020xH\u0016J\u0010\u0010¿\u0001\u001a\t\u0012\u0005\u0012\u00030À\u00010!H\u0016J\u0016\u0010Á\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\fH\u0000¢\u0006\u0003\bÂ\u0001J\u0019\u0010Ã\u0001\u001a\u00020x2\b\u0010Ä\u0001\u001a\u00030Å\u0001H\u0000¢\u0006\u0003\bÆ\u0001J\t\u0010Ç\u0001\u001a\u00020\u0007H\u0002JI\u0010È\u0001\u001a\u00020x2\b\u0010É\u0001\u001a\u00030Ê\u00012\u000f\u0010Ë\u0001\u001a\n\u0012\u0005\u0012\u00030Í\u00010Ì\u00012\t\b\u0002\u0010Î\u0001\u001a\u00020\u00072\t\b\u0002\u0010Ï\u0001\u001a\u00020\u0007H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001JI\u0010Ò\u0001\u001a\u00020x2\b\u0010É\u0001\u001a\u00030Ê\u00012\u000f\u0010Ó\u0001\u001a\n\u0012\u0005\u0012\u00030Ô\u00010Ì\u00012\t\b\u0002\u0010Î\u0001\u001a\u00020\u00072\t\b\u0002\u0010Ï\u0001\u001a\u00020\u0007H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÕ\u0001\u0010Ñ\u0001J\"\u00109\u001a\u00020x2\u000e\u0010¼\u0001\u001a\t\u0012\u0004\u0012\u00020x0Ö\u0001H\bø\u0001\u0002¢\u0006\u0003\b×\u0001J!\u0010Ø\u0001\u001a\u00020x2\u0007\u0010Ù\u0001\u001a\u0002002\u0007\u0010Ú\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÛ\u0001J\u000f\u0010Ü\u0001\u001a\u00020xH\u0000¢\u0006\u0003\bÝ\u0001J\u000f\u0010Þ\u0001\u001a\u00020xH\u0000¢\u0006\u0003\bß\u0001J\t\u0010à\u0001\u001a\u00020xH\u0002J\u000f\u0010á\u0001\u001a\u00020xH\u0000¢\u0006\u0003\bâ\u0001J\t\u0010ã\u0001\u001a\u00020xH\u0002J\u0011\u0010ä\u0001\u001a\u00020x2\u0006\u0010k\u001a\u00020jH\u0002J\t\u0010å\u0001\u001a\u00020xH\u0002J\u0012\u0010æ\u0001\u001a\u0002002\u0007\u0010\u0001\u001a\u000200H\u0016J\u0011\u0010ç\u0001\u001a\u0002002\u0006\u00107\u001a\u000200H\u0016J#\u0010è\u0001\u001a\u00030é\u00012\b\u0010ê\u0001\u001a\u00030ë\u0001H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bì\u0001\u0010í\u0001J\u0012\u0010î\u0001\u001a\u0002002\u0007\u0010\u0001\u001a\u000200H\u0016J\u0011\u0010ï\u0001\u001a\u0002002\u0006\u00107\u001a\u000200H\u0016J*\u0010ð\u0001\u001a\u00020x2\u0007\u0010ñ\u0001\u001a\u0002002\u0007\u0010ò\u0001\u001a\u0002002\u0007\u0010ó\u0001\u001a\u000200H\u0000¢\u0006\u0003\bô\u0001J\u000f\u0010õ\u0001\u001a\u00020xH\u0000¢\u0006\u0003\bö\u0001J\t\u0010÷\u0001\u001a\u00020xH\u0002J\t\u0010ø\u0001\u001a\u00020xH\u0002J\u000f\u0010ù\u0001\u001a\u00020xH\u0000¢\u0006\u0003\bú\u0001J\t\u0010û\u0001\u001a\u00020xH\u0002J!\u0010ü\u0001\u001a\u00020x2\u0007\u0010ý\u0001\u001a\u0002002\u0007\u0010þ\u0001\u001a\u000200H\u0000¢\u0006\u0003\bÿ\u0001J\t\u0010\u0002\u001a\u00020xH\u0002J#\u0010\u0002\u001a\u00020\u00072\f\b\u0002\u0010ê\u0001\u001a\u0005\u0018\u00010ë\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0003\b\u0002J\u000f\u0010\u0002\u001a\u00020xH\u0000¢\u0006\u0003\b\u0002J!\u0010\u0002\u001a\u00020x2\u0007\u0010Ù\u0001\u001a\u0002002\u0007\u0010ó\u0001\u001a\u000200H\u0000¢\u0006\u0003\b\u0002J\u000f\u0010\u0002\u001a\u00020xH\u0000¢\u0006\u0003\b\u0002J\u000f\u0010\u0002\u001a\u00020xH\u0000¢\u0006\u0003\b\u0002J\u000f\u0010\u0002\u001a\u00020xH\u0000¢\u0006\u0003\b\u0002J\u0012\u0010\u0002\u001a\u00020x2\u0007\u0010\u0002\u001a\u00020\u0000H\u0002J\"\u0010\u0002\u001a\t\u0012\u0002\b\u0003\u0018\u00010¢\u00012\u0007\u0010k\u001a\u00030\u00022\u0007\u0010\u0002\u001a\u00020\u0014H\u0002J\t\u0010\u0002\u001a\u00020\u0007H\u0002J\n\u0010\u0002\u001a\u00030²\u0001H\u0016J\u001f\u0010\u0002\u001a\u00020x2\u000e\u0010¼\u0001\u001a\t\u0012\u0004\u0012\u00020x0Ö\u0001H\u0000¢\u0006\u0003\b\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\nX\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\f8@X\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00078\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00000!8@X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R$\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00000!8@X\u0004¢\u0006\u0006\u001a\u0004\b6\u0010#R\u0014\u00107\u001a\u0002008VX\u0004¢\u0006\u0006\u001a\u0004\b8\u00102R\u000e\u00109\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\u0004\u0018\u00010\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001e\"\u0004\b?\u0010\bR\u0014\u0010@\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010<R\u0014\u0010B\u001a\u00020CX\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u001eR\u001e\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u001eR\u0014\u0010I\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R$\u0010K\u001a\u00020J2\u0006\u0010(\u001a\u00020J@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020W8@X\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR$\u0010[\u001a\u00020Z2\u0006\u0010(\u001a\u00020Z@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020aX\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR*\u0010k\u001a\u00020j2\u0006\u0010(\u001a\u00020j@VX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bl\u0010\u000e\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u001e\"\u0004\bs\u0010\bR\u000e\u0010t\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R(\u0010u\u001a\u0010\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020x\u0018\u00010vX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R(\u0010}\u001a\u0010\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020x\u0018\u00010vX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010z\"\u0004\b\u0010|R\u0018\u0010\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\u00020\u00148@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010<R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R%\u0010\u0001\u001a\u0004\u0018\u00010w2\b\u0010G\u001a\u0004\u0018\u00010w@BX\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u0004\u0018\u00010\u00008@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u0002002\u0006\u0010G\u001a\u000200@BX\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u00102R\u000f\u0010\u0001\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\u0002008VX\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u00102R\u001a\u0010¡\u0001\u001a\r\u0012\t\u0012\u0007\u0012\u0002\b\u00030¢\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010£\u0001\u001a\u00030¤\u0001X\u000e¢\u0006\u0002\n\u0000R#\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\f8@X\u0004¢\u0006\u000e\u0012\u0005\b¦\u0001\u0010\u000e\u001a\u0005\b§\u0001\u0010\u0010R\u000f\u0010¨\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "isVirtual", "", "(Z)V", "ZComparator", "Ljava/util/Comparator;", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release$annotations", "()V", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_foldedChildren", "_foldedParent", "_innerLayerWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "_unfoldedChildren", "_zSortedChildren", "alignmentLines", "Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "getAlignmentLines$ui_release", "()Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "getCanMultiMeasure$ui_release", "()Z", "setCanMultiMeasure$ui_release", "children", "", "getChildren$ui_release", "()Ljava/util/List;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "", "getDepth$ui_release", "()I", "setDepth$ui_release", "(I)V", "foldedChildren", "getFoldedChildren$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerLayerWrapper", "getInnerLayerWrapper", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "innerLayerWrapperIsDirty", "getInnerLayerWrapperIsDirty$ui_release", "setInnerLayerWrapperIsDirty$ui_release", "innerLayoutNodeWrapper", "getInnerLayoutNodeWrapper$ui_release", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getIntrinsicsPolicy$ui_release", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "isAttached", "<set-?>", "isPlaced", "isValid", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "setLayoutState$ui_release", "(Landroidx/compose/ui/node/LayoutNode$LayoutState;)V", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope$ui_release", "()Landroidx/compose/ui/layout/MeasureScope;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier$annotations", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nextChildPlaceOrder", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "onPositionedCallbacks", "Landroidx/compose/ui/node/OnGloballyPositionedModifierWrapper;", "outerLayoutNodeWrapper", "getOuterLayoutNodeWrapper$ui_release", "outerMeasurablePlaceable", "Landroidx/compose/ui/node/OuterMeasurablePlaceable;", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "placeOrder", "getPlaceOrder$ui_release", "previousPlaceOrder", "relayoutWithoutParentInProgress", "unfoldedVirtualChildrenListDirty", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "wrapperCache", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "zIndex", "", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "alignmentLinesQueriedByModifier", "attach", "attach$ui_release", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "calculateAlignmentLines$ui_release", "copyWrappersToCache", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "draw$ui_release", "forEachDelegate", "block", "forEachDelegateIncludingInner", "forceRemeasure", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "getOrCreateOnPositionedCallbacks", "getOrCreateOnPositionedCallbacks$ui_release", "handleMeasureResult", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "handleMeasureResult$ui_release", "hasNewPositioningCallback", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsWrappers", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateUnfoldedVirtualChildren", "layoutChildren", "layoutChildren$ui_release", "markNodeAndSubtreeAsPlaced", "markReusedModifiers", "markSubtreeAsNotPlaced", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "move", "from", "to", "count", "move$ui_release", "onAlignmentsChanged", "onAlignmentsChanged$ui_release", "onBeforeLayoutChildren", "onDensityOrLayoutDirectionChanged", "onNodePlaced", "onNodePlaced$ui_release", "onZSortedChildrenInvalidated", "place", "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "reuseLayoutNodeWrapper", "Landroidx/compose/ui/Modifier$Element;", "wrapper", "shouldInvalidateParentLayer", "toString", "withNoSnapshotReadObservation", "withNoSnapshotReadObservation$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
public final class LayoutNode implements Measurable, Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Function0<LayoutNode> Constructor = LayoutNode$Companion$Constructor$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final ViewConfiguration DummyViewConfiguration = new LayoutNode$Companion$DummyViewConfiguration$1();
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new LayoutNode$Companion$ErrorMeasurePolicy$1();
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    private final Comparator<LayoutNode> ZComparator;
    private final MutableVector<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private LayoutNodeWrapper _innerLayerWrapper;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private final LayoutNodeAlignmentLines alignmentLines;
    private boolean canMultiMeasure;
    private Density density;
    private int depth;
    /* access modifiers changed from: private */
    public boolean ignoreRemeasureRequests;
    private boolean innerLayerWrapperIsDirty;
    private final LayoutNodeWrapper innerLayoutNodeWrapper;
    private final IntrinsicsPolicy intrinsicsPolicy;
    private boolean isPlaced;
    private final boolean isVirtual;
    private LayoutDirection layoutDirection;
    private LayoutState layoutState;
    private MeasurePolicy measurePolicy;
    private final MeasureScope measureScope;
    private UsageByParent measuredByParent;
    private Modifier modifier;
    private boolean needsOnPositionedDispatch;
    /* access modifiers changed from: private */
    public int nextChildPlaceOrder;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private MutableVector<OnGloballyPositionedModifierWrapper> onPositionedCallbacks;
    /* access modifiers changed from: private */
    public final OuterMeasurablePlaceable outerMeasurablePlaceable;
    private Owner owner;
    /* access modifiers changed from: private */
    public int placeOrder;
    /* access modifiers changed from: private */
    public int previousPlaceOrder;
    private boolean relayoutWithoutParentInProgress;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    /* access modifiers changed from: private */
    public MutableVector<DelegatingLayoutNodeWrapper<?>> wrapperCache;
    private float zIndex;
    private boolean zSortedChildrenInvalidated;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "NeedsRemeasure", "Measuring", "NeedsRelayout", "LayingOut", "Ready", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public enum LayoutState {
        NeedsRemeasure,
        Measuring,
        NeedsRelayout,
        LayingOut,
        Ready
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            iArr[LayoutState.NeedsRemeasure.ordinal()] = 1;
            iArr[LayoutState.NeedsRelayout.ordinal()] = 2;
            iArr[LayoutState.Ready.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutNode() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    public static /* synthetic */ void getModifier$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public static /* synthetic */ void get_children$ui_release$annotations() {
    }

    public LayoutNode(boolean z) {
        this.isVirtual = z;
        this._foldedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.layoutState = LayoutState.Ready;
        this.wrapperCache = new MutableVector<>(new DelegatingLayoutNodeWrapper[16], 0);
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
        this.measureScope = new LayoutNode$measureScope$1(this);
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.alignmentLines = new LayoutNodeAlignmentLines(this);
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.measuredByParent = UsageByParent.NotUsed;
        LayoutNodeWrapper innerPlaceable = new InnerPlaceable(this);
        this.innerLayoutNodeWrapper = innerPlaceable;
        this.outerMeasurablePlaceable = new OuterMeasurablePlaceable(this, innerPlaceable);
        this.innerLayerWrapperIsDirty = true;
        this.modifier = Modifier.Companion;
        this.ZComparator = $$Lambda$LayoutNode$FLJoMVOGaJnYAWiaTzDnF1xHw.INSTANCE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNode(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asMutableList();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            int i = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                MutableVector<LayoutNode> mutableVector2 = new MutableVector<>(new LayoutNode[16], 0);
                this._unfoldedChildren = mutableVector2;
                mutableVector = mutableVector2;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> mutableVector3 = this._foldedChildren;
            int size = mutableVector3.getSize();
            if (size > 0) {
                Object[] content = mutableVector3.getContent();
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    if (layoutNode.isVirtual) {
                        mutableVector.addAll(mutableVector.getSize(), layoutNode.get_children$ui_release());
                    } else {
                        mutableVector.add(layoutNode);
                    }
                    i++;
                } while (i < size);
            }
        }
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode parent$ui_release;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (this.isVirtual && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.unfoldedVirtualChildrenListDirty = true;
        }
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren;
        }
        recreateUnfoldedChildrenIfDirty();
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        boolean z = false;
        if (layoutNode != null && layoutNode.isVirtual) {
            z = true;
        }
        if (!z) {
            return layoutNode;
        }
        if (layoutNode == null) {
            return null;
        }
        return layoutNode.getParent$ui_release();
    }

    public final Owner getOwner$ui_release() {
        return this.owner;
    }

    public boolean isAttached() {
        return this.owner != null;
    }

    public final int getDepth$ui_release() {
        return this.depth;
    }

    public final void setDepth$ui_release(int i) {
        this.depth = i;
    }

    public final LayoutState getLayoutState$ui_release() {
        return this.layoutState;
    }

    public final void setLayoutState$ui_release(LayoutState layoutState2) {
        Intrinsics.checkNotNullParameter(layoutState2, "<set-?>");
        this.layoutState = layoutState2;
    }

    public final void insertAt$ui_release(int i, LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "instance");
        String str = null;
        if (!(layoutNode._foldedParent == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot insert ");
            sb.append(layoutNode);
            sb.append(" because it already has a parent. This tree: ");
            sb.append(debugTreeToString$default(this, 0, 1, (Object) null));
            sb.append(" Other tree: ");
            LayoutNode layoutNode2 = layoutNode._foldedParent;
            if (layoutNode2 != null) {
                str = debugTreeToString$default(layoutNode2, 0, 1, (Object) null);
            }
            sb.append(str);
            throw new IllegalStateException(sb.toString().toString());
        }
        if (layoutNode.owner == null) {
            layoutNode._foldedParent = this;
            this._foldedChildren.add(i, layoutNode);
            onZSortedChildrenInvalidated();
            if (layoutNode.isVirtual) {
                if (!this.isVirtual) {
                    this.virtualChildrenCount++;
                } else {
                    throw new IllegalArgumentException("Virtual LayoutNode can't be added into a virtual parent".toString());
                }
            }
            invalidateUnfoldedVirtualChildren();
            layoutNode.getOuterLayoutNodeWrapper$ui_release().setWrappedBy$ui_release(this.innerLayoutNodeWrapper);
            Owner owner2 = this.owner;
            if (owner2 != null) {
                layoutNode.attach$ui_release(owner2);
                return;
            }
            return;
        }
        throw new IllegalStateException(("Cannot insert " + layoutNode + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, (Object) null) + " Other tree: " + debugTreeToString$default(layoutNode, 0, 1, (Object) null)).toString());
    }

    /* access modifiers changed from: private */
    public final void onZSortedChildrenInvalidated() {
        if (this.isVirtual) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated();
                return;
            }
            return;
        }
        this.zSortedChildrenInvalidated = true;
    }

    public final void removeAt$ui_release(int i, int i2) {
        boolean z = false;
        if (i2 >= 0) {
            if (this.owner != null) {
                z = true;
            }
            int i3 = (i2 + i) - 1;
            if (i <= i3) {
                while (true) {
                    int i4 = i3 - 1;
                    LayoutNode removeAt = this._foldedChildren.removeAt(i3);
                    onZSortedChildrenInvalidated();
                    if (z) {
                        removeAt.detach$ui_release();
                    }
                    removeAt._foldedParent = null;
                    if (removeAt.isVirtual) {
                        this.virtualChildrenCount--;
                    }
                    invalidateUnfoldedVirtualChildren();
                    if (i3 != i) {
                        i3 = i4;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException(("count (" + i2 + ") must be greater than 0").toString());
        }
    }

    public final void removeAll$ui_release() {
        boolean z = this.owner != null;
        int size = this._foldedChildren.getSize() - 1;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                LayoutNode layoutNode = (LayoutNode) this._foldedChildren.getContent()[size];
                if (z) {
                    layoutNode.detach$ui_release();
                }
                layoutNode._foldedParent = null;
                if (i < 0) {
                    break;
                }
                size = i;
            }
        }
        this._foldedChildren.clear();
        onZSortedChildrenInvalidated();
        this.virtualChildrenCount = 0;
        invalidateUnfoldedVirtualChildren();
    }

    public final void move$ui_release(int i, int i2, int i3) {
        if (i != i2) {
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i4 + 1;
                this._foldedChildren.add(i > i2 ? i4 + i2 : (i2 + i3) - 2, this._foldedChildren.removeAt(i > i2 ? i + i4 : i));
                i4 = i5;
            }
            onZSortedChildrenInvalidated();
            invalidateUnfoldedVirtualChildren();
            requestRemeasure$ui_release();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void attach$ui_release(androidx.compose.ui.node.Owner r7) {
        /*
            r6 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            androidx.compose.ui.node.Owner r0 = r6.owner
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            r3 = 0
            if (r0 == 0) goto L_0x00d8
            androidx.compose.ui.node.LayoutNode r0 = r6._foldedParent
            if (r0 == 0) goto L_0x0024
            if (r0 != 0) goto L_0x0019
            r0 = r3
            goto L_0x001b
        L_0x0019:
            androidx.compose.ui.node.Owner r0 = r0.owner
        L_0x001b:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            if (r0 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = 1
        L_0x0025:
            if (r0 != 0) goto L_0x0073
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Attaching to a different owner("
            r0.append(r4)
            r0.append(r7)
            java.lang.String r7 = ") than the parent's owner("
            r0.append(r7)
            androidx.compose.ui.node.LayoutNode r7 = r6.getParent$ui_release()
            if (r7 != 0) goto L_0x0041
            r7 = r3
            goto L_0x0045
        L_0x0041:
            androidx.compose.ui.node.Owner r7 = r7.getOwner$ui_release()
        L_0x0045:
            r0.append(r7)
            java.lang.String r7 = "). This tree: "
            r0.append(r7)
            java.lang.String r7 = debugTreeToString$default(r6, r1, r2, r3)
            r0.append(r7)
            java.lang.String r7 = " Parent tree: "
            r0.append(r7)
            androidx.compose.ui.node.LayoutNode r7 = r6._foldedParent
            if (r7 != 0) goto L_0x005e
            goto L_0x0062
        L_0x005e:
            java.lang.String r3 = debugTreeToString$default(r7, r1, r2, r3)
        L_0x0062:
            r0.append(r3)
            java.lang.String r7 = r0.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        L_0x0073:
            androidx.compose.ui.node.LayoutNode r0 = r6.getParent$ui_release()
            if (r0 != 0) goto L_0x007b
            r6.isPlaced = r2
        L_0x007b:
            r6.owner = r7
            if (r0 != 0) goto L_0x0081
            r3 = -1
            goto L_0x0083
        L_0x0081:
            int r3 = r0.depth
        L_0x0083:
            int r3 = r3 + r2
            r6.depth = r3
            androidx.compose.ui.semantics.SemanticsWrapper r3 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterSemantics(r6)
            if (r3 == 0) goto L_0x008f
            r7.onSemanticsChange()
        L_0x008f:
            r7.onAttach(r6)
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.LayoutNode> r3 = r6._foldedChildren
            int r4 = r3.getSize()
            if (r4 <= 0) goto L_0x00a8
            java.lang.Object[] r3 = r3.getContent()
        L_0x009e:
            r5 = r3[r1]
            androidx.compose.ui.node.LayoutNode r5 = (androidx.compose.ui.node.LayoutNode) r5
            r5.attach$ui_release(r7)
            int r1 = r1 + r2
            if (r1 < r4) goto L_0x009e
        L_0x00a8:
            r6.requestRemeasure$ui_release()
            if (r0 != 0) goto L_0x00ae
            goto L_0x00b1
        L_0x00ae:
            r0.requestRemeasure$ui_release()
        L_0x00b1:
            androidx.compose.ui.node.LayoutNodeWrapper r0 = r6.innerLayoutNodeWrapper
            r0.attach()
            androidx.compose.ui.node.LayoutNodeWrapper r0 = r6.getOuterLayoutNodeWrapper$ui_release()
            androidx.compose.ui.node.LayoutNodeWrapper r1 = r6.getInnerLayoutNodeWrapper$ui_release()
        L_0x00be:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r2 != 0) goto L_0x00cf
            r0.attach()
            androidx.compose.ui.node.LayoutNodeWrapper r0 = r0.getWrapped$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            goto L_0x00be
        L_0x00cf:
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.node.Owner, kotlin.Unit> r0 = r6.onAttach
            if (r0 != 0) goto L_0x00d4
            goto L_0x00d7
        L_0x00d4:
            r0.invoke(r7)
        L_0x00d7:
            return
        L_0x00d8:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Cannot attach "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r0 = " as it already is attached.  Tree: "
            r7.append(r0)
            java.lang.String r0 = debugTreeToString$default(r6, r1, r2, r3)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.attach$ui_release(androidx.compose.ui.node.Owner):void");
    }

    public final void detach$ui_release() {
        Owner owner2 = this.owner;
        String str = null;
        if (owner2 == null) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                str = debugTreeToString$default(parent$ui_release, 0, 1, (Object) null);
            }
            throw new IllegalStateException(Intrinsics.stringPlus("Cannot detach node that is already detached!  Tree: ", str).toString());
        }
        LayoutNode parent$ui_release2 = getParent$ui_release();
        if (parent$ui_release2 != null) {
            parent$ui_release2.invalidateLayer$ui_release();
            parent$ui_release2.requestRemeasure$ui_release();
        }
        this.alignmentLines.reset$ui_release();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner2);
        }
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper innerLayoutNodeWrapper$ui_release = getInnerLayoutNodeWrapper$ui_release();
        while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release, (Object) innerLayoutNodeWrapper$ui_release)) {
            outerLayoutNodeWrapper$ui_release.detach();
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
            Intrinsics.checkNotNull(outerLayoutNodeWrapper$ui_release);
        }
        this.innerLayoutNodeWrapper.detach();
        if (SemanticsNodeKt.getOuterSemantics(this) != null) {
            owner2.onSemanticsChange();
        }
        owner2.onDetach(this);
        this.owner = null;
        this.depth = 0;
        MutableVector<LayoutNode> mutableVector = this._foldedChildren;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                ((LayoutNode) content[i]).detach$ui_release();
                i++;
            } while (i < size);
        }
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.isPlaced = false;
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
            mutableVector.addAll(mutableVector.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(this.ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    public boolean isValid() {
        return isAttached();
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, (String) null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    private final String debugTreeToString(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < i) {
            i2++;
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append(10);
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i3 = 0;
            do {
                sb.append(((LayoutNode) content[i3]).debugTreeToString(i + 1));
                i3++;
            } while (i3 < size);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "tree.toString()");
        if (i != 0) {
            return sb2;
        }
        String substring = sb2.substring(0, sb2.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        private final String error;

        public NoIntrinsicsMeasurePolicy(String str) {
            Intrinsics.checkNotNullParameter(str, ReactVideoView.EVENT_PROP_ERROR);
            this.error = str;
        }

        public Void minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        public Void minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        public Void maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        public Void maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    public void setMeasurePolicy(MeasurePolicy measurePolicy2) {
        Intrinsics.checkNotNullParameter(measurePolicy2, "value");
        if (!Intrinsics.areEqual((Object) this.measurePolicy, (Object) measurePolicy2)) {
            this.measurePolicy = measurePolicy2;
            this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
            requestRemeasure$ui_release();
        }
    }

    public final IntrinsicsPolicy getIntrinsicsPolicy$ui_release() {
        return this.intrinsicsPolicy;
    }

    public Density getDensity() {
        return this.density;
    }

    public void setDensity(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "value");
        if (!Intrinsics.areEqual((Object) this.density, (Object) density2)) {
            this.density = density2;
            onDensityOrLayoutDirectionChanged();
        }
    }

    public final MeasureScope getMeasureScope$ui_release() {
        return this.measureScope;
    }

    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public void setLayoutDirection(LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "value");
        if (this.layoutDirection != layoutDirection2) {
            this.layoutDirection = layoutDirection2;
            onDensityOrLayoutDirectionChanged();
        }
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public void setViewConfiguration(ViewConfiguration viewConfiguration2) {
        Intrinsics.checkNotNullParameter(viewConfiguration2, "<set-?>");
        this.viewConfiguration = viewConfiguration2;
    }

    private final void onDensityOrLayoutDirectionChanged() {
        requestRemeasure$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    public int getWidth() {
        return this.outerMeasurablePlaceable.getWidth();
    }

    public int getHeight() {
        return this.outerMeasurablePlaceable.getHeight();
    }

    public final LayoutNodeAlignmentLines getAlignmentLines$ui_release() {
        return this.alignmentLines;
    }

    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    public boolean isPlaced() {
        return this.isPlaced;
    }

    public final int getPlaceOrder$ui_release() {
        return this.placeOrder;
    }

    public final UsageByParent getMeasuredByParent$ui_release() {
        return this.measuredByParent;
    }

    public final void setMeasuredByParent$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.measuredByParent = usageByParent;
    }

    public final boolean getCanMultiMeasure$ui_release() {
        return this.canMultiMeasure;
    }

    public final void setCanMultiMeasure$ui_release(boolean z) {
        this.canMultiMeasure = z;
    }

    public final LayoutNodeWrapper getInnerLayoutNodeWrapper$ui_release() {
        return this.innerLayoutNodeWrapper;
    }

    public final LayoutNodeWrapper getOuterLayoutNodeWrapper$ui_release() {
        return this.outerMeasurablePlaceable.getOuterWrapper();
    }

    public final boolean getInnerLayerWrapperIsDirty$ui_release() {
        return this.innerLayerWrapperIsDirty;
    }

    public final void setInnerLayerWrapperIsDirty$ui_release(boolean z) {
        this.innerLayerWrapperIsDirty = z;
    }

    private final LayoutNodeWrapper getInnerLayerWrapper() {
        OwnedLayer ownedLayer;
        if (this.innerLayerWrapperIsDirty) {
            LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
            LayoutNodeWrapper wrappedBy$ui_release = getOuterLayoutNodeWrapper$ui_release().getWrappedBy$ui_release();
            this._innerLayerWrapper = null;
            while (true) {
                if (Intrinsics.areEqual((Object) layoutNodeWrapper, (Object) wrappedBy$ui_release)) {
                    break;
                }
                if (layoutNodeWrapper == null) {
                    ownedLayer = null;
                } else {
                    ownedLayer = layoutNodeWrapper.getLayer();
                }
                if (ownedLayer != null) {
                    this._innerLayerWrapper = layoutNodeWrapper;
                    break;
                } else if (layoutNodeWrapper == null) {
                    layoutNodeWrapper = null;
                } else {
                    layoutNodeWrapper = layoutNodeWrapper.getWrappedBy$ui_release();
                }
            }
        }
        LayoutNodeWrapper layoutNodeWrapper2 = this._innerLayerWrapper;
        if (layoutNodeWrapper2 == null || layoutNodeWrapper2.getLayer() != null) {
            return layoutNodeWrapper2;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void invalidateLayer$ui_release() {
        LayoutNodeWrapper innerLayerWrapper = getInnerLayerWrapper();
        if (innerLayerWrapper != null) {
            innerLayerWrapper.invalidateLayer();
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    public void setModifier(Modifier modifier2) {
        LayoutNode parent$ui_release;
        LayoutNode parent$ui_release2;
        Intrinsics.checkNotNullParameter(modifier2, "value");
        if (!Intrinsics.areEqual((Object) modifier2, (Object) this.modifier)) {
            if (Intrinsics.areEqual((Object) getModifier(), (Object) Modifier.Companion) || (!this.isVirtual)) {
                this.modifier = modifier2;
                boolean shouldInvalidateParentLayer = shouldInvalidateParentLayer();
                copyWrappersToCache();
                markReusedModifiers(modifier2);
                LayoutNodeWrapper outerWrapper = this.outerMeasurablePlaceable.getOuterWrapper();
                if (SemanticsNodeKt.getOuterSemantics(this) != null && isAttached()) {
                    Owner owner2 = this.owner;
                    Intrinsics.checkNotNull(owner2);
                    owner2.onSemanticsChange();
                }
                boolean hasNewPositioningCallback = hasNewPositioningCallback();
                MutableVector<OnGloballyPositionedModifierWrapper> mutableVector = this.onPositionedCallbacks;
                if (mutableVector != null) {
                    mutableVector.clear();
                }
                this.innerLayoutNodeWrapper.onInitialize();
                LayoutNodeWrapper layoutNodeWrapper = (LayoutNodeWrapper) getModifier().foldOut(this.innerLayoutNodeWrapper, new LayoutNode$modifier$outerWrapper$1(this));
                LayoutNode parent$ui_release3 = getParent$ui_release();
                layoutNodeWrapper.setWrappedBy$ui_release(parent$ui_release3 == null ? null : parent$ui_release3.innerLayoutNodeWrapper);
                this.outerMeasurablePlaceable.setOuterWrapper(layoutNodeWrapper);
                if (isAttached()) {
                    MutableVector<DelegatingLayoutNodeWrapper<?>> mutableVector2 = this.wrapperCache;
                    int size = mutableVector2.getSize();
                    if (size > 0) {
                        int i = 0;
                        Object[] content = mutableVector2.getContent();
                        do {
                            ((DelegatingLayoutNodeWrapper) content[i]).detach();
                            i++;
                        } while (i < size);
                    }
                    LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
                    LayoutNodeWrapper innerLayoutNodeWrapper$ui_release = getInnerLayoutNodeWrapper$ui_release();
                    while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release, (Object) innerLayoutNodeWrapper$ui_release)) {
                        if (!outerLayoutNodeWrapper$ui_release.isAttached()) {
                            outerLayoutNodeWrapper$ui_release.attach();
                        }
                        outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
                        Intrinsics.checkNotNull(outerLayoutNodeWrapper$ui_release);
                    }
                }
                this.wrapperCache.clear();
                LayoutNodeWrapper outerLayoutNodeWrapper$ui_release2 = getOuterLayoutNodeWrapper$ui_release();
                LayoutNodeWrapper innerLayoutNodeWrapper$ui_release2 = getInnerLayoutNodeWrapper$ui_release();
                while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release2, (Object) innerLayoutNodeWrapper$ui_release2)) {
                    outerLayoutNodeWrapper$ui_release2.onModifierChanged();
                    outerLayoutNodeWrapper$ui_release2 = outerLayoutNodeWrapper$ui_release2.getWrapped$ui_release();
                    Intrinsics.checkNotNull(outerLayoutNodeWrapper$ui_release2);
                }
                if (!Intrinsics.areEqual((Object) outerWrapper, (Object) this.innerLayoutNodeWrapper) || !Intrinsics.areEqual((Object) layoutNodeWrapper, (Object) this.innerLayoutNodeWrapper)) {
                    requestRemeasure$ui_release();
                } else if (this.layoutState == LayoutState.Ready && hasNewPositioningCallback) {
                    requestRemeasure$ui_release();
                }
                Object parentData = getParentData();
                this.outerMeasurablePlaceable.recalculateParentData();
                if (!Intrinsics.areEqual(parentData, getParentData()) && (parent$ui_release2 = getParent$ui_release()) != null) {
                    parent$ui_release2.requestRemeasure$ui_release();
                }
                if ((shouldInvalidateParentLayer || shouldInvalidateParentLayer()) && (parent$ui_release = getParent$ui_release()) != null) {
                    parent$ui_release.invalidateLayer$ui_release();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
        }
    }

    public LayoutCoordinates getCoordinates() {
        return this.innerLayoutNodeWrapper;
    }

    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    public final void setOnAttach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    public final void setOnDetach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    public final MutableVector<OnGloballyPositionedModifierWrapper> getOrCreateOnPositionedCallbacks$ui_release() {
        MutableVector<OnGloballyPositionedModifierWrapper> mutableVector = this.onPositionedCallbacks;
        if (mutableVector != null) {
            return mutableVector;
        }
        MutableVector<OnGloballyPositionedModifierWrapper> mutableVector2 = new MutableVector<>(new OnGloballyPositionedModifierWrapper[16], 0);
        this.onPositionedCallbacks = mutableVector2;
        return mutableVector2;
    }

    public final boolean getNeedsOnPositionedDispatch$ui_release() {
        return this.needsOnPositionedDispatch;
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z) {
        this.needsOnPositionedDispatch = z;
    }

    public final void place$ui_release(int i, int i2) {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int measuredWidth = this.outerMeasurablePlaceable.getMeasuredWidth();
        LayoutDirection layoutDirection2 = getLayoutDirection();
        int access$getParentWidth = Placeable.PlacementScope.Companion.getParentWidth();
        LayoutDirection access$getParentLayoutDirection = Placeable.PlacementScope.Companion.getParentLayoutDirection();
        Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = measuredWidth;
        Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection2;
        Placeable.PlacementScope.placeRelative$default(companion, this.outerMeasurablePlaceable, i, i2, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = access$getParentWidth;
        Placeable.PlacementScope.Companion companion5 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
    }

    /* JADX INFO: finally extract failed */
    public final void replace$ui_release() {
        try {
            this.relayoutWithoutParentInProgress = true;
            this.outerMeasurablePlaceable.replace();
            this.relayoutWithoutParentInProgress = false;
        } catch (Throwable th) {
            this.relayoutWithoutParentInProgress = false;
            throw th;
        }
    }

    public final void draw$ui_release(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getOuterLayoutNodeWrapper$ui_release().draw(canvas);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release$default  reason: not valid java name */
    public static /* synthetic */ void m3278hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        layoutNode.m3282hitTestM_7yMNQ$ui_release(j, hitTestResult, (i & 4) != 0 ? false : z, (i & 8) != 0 ? true : z2);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release  reason: not valid java name */
    public final void m3282hitTestM_7yMNQ$ui_release(long j, HitTestResult<PointerInputFilter> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        getOuterLayoutNodeWrapper$ui_release().m3345hitTestM_7yMNQ(getOuterLayoutNodeWrapper$ui_release().m3341fromParentPositionMKHz9U(j), hitTestResult, z, z2);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release$default  reason: not valid java name */
    public static /* synthetic */ void m3279hitTestSemanticsM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        layoutNode.m3283hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release  reason: not valid java name */
    public final void m3283hitTestSemanticsM_7yMNQ$ui_release(long j, HitTestResult<SemanticsWrapper> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitSemanticsWrappers");
        getOuterLayoutNodeWrapper$ui_release().m3346hitTestSemantics9KIMszo(getOuterLayoutNodeWrapper$ui_release().m3341fromParentPositionMKHz9U(j), hitTestResult, z2);
    }

    private final boolean hasNewPositioningCallback() {
        return ((Boolean) getModifier().foldOut(false, new LayoutNode$hasNewPositioningCallback$1(this.onPositionedCallbacks))).booleanValue();
    }

    public final void onNodePlaced$ui_release() {
        LayoutNode parent$ui_release = getParent$ui_release();
        float zIndex2 = this.innerLayoutNodeWrapper.getZIndex();
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper innerLayoutNodeWrapper$ui_release = getInnerLayoutNodeWrapper$ui_release();
        while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release, (Object) innerLayoutNodeWrapper$ui_release)) {
            zIndex2 += outerLayoutNodeWrapper$ui_release.getZIndex();
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
            Intrinsics.checkNotNull(outerLayoutNodeWrapper$ui_release);
        }
        boolean z = false;
        if (!(zIndex2 == this.zIndex)) {
            this.zIndex = zIndex2;
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated();
            }
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
        }
        if (!isPlaced()) {
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            markNodeAndSubtreeAsPlaced();
        }
        if (parent$ui_release == null) {
            this.placeOrder = 0;
        } else if (!this.relayoutWithoutParentInProgress && parent$ui_release.layoutState == LayoutState.LayingOut) {
            if (this.placeOrder == Integer.MAX_VALUE) {
                z = true;
            }
            if (z) {
                int i = parent$ui_release.nextChildPlaceOrder;
                this.placeOrder = i;
                parent$ui_release.nextChildPlaceOrder = i + 1;
            } else {
                throw new IllegalStateException("Place was called on a node which was placed already".toString());
            }
        }
        layoutChildren$ui_release();
    }

    public final void layoutChildren$ui_release() {
        this.alignmentLines.recalculateQueryOwner$ui_release();
        if (this.layoutState == LayoutState.NeedsRelayout) {
            onBeforeLayoutChildren();
        }
        if (this.layoutState == LayoutState.NeedsRelayout) {
            this.layoutState = LayoutState.LayingOut;
            LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(this, new LayoutNode$layoutChildren$1(this));
            this.layoutState = LayoutState.Ready;
        }
        if (this.alignmentLines.getUsedDuringParentLayout$ui_release()) {
            this.alignmentLines.setPreviousUsedDuringParentLayout$ui_release(true);
        }
        if (this.alignmentLines.getDirty$ui_release() && this.alignmentLines.getRequired$ui_release()) {
            this.alignmentLines.recalculate();
        }
    }

    private final void markNodeAndSubtreeAsPlaced() {
        this.isPlaced = true;
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper wrapped$ui_release = getInnerLayoutNodeWrapper$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release, (Object) wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null) {
            if (outerLayoutNodeWrapper$ui_release.getLastLayerDrawingWasSkipped$ui_release()) {
                outerLayoutNodeWrapper$ui_release.invalidateLayer();
            }
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
        }
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                LayoutNode layoutNode = (LayoutNode) content[i];
                if (layoutNode.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                    layoutNode.markNodeAndSubtreeAsPlaced();
                    rescheduleRemeasureOrRelayout(layoutNode);
                }
                i++;
            } while (i < size);
        }
    }

    private final void rescheduleRemeasureOrRelayout(LayoutNode layoutNode) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.layoutState.ordinal()];
        if (i == 1 || i == 2) {
            layoutNode.layoutState = LayoutState.Ready;
            if (i == 1) {
                layoutNode.requestRemeasure$ui_release();
            } else {
                layoutNode.requestRelayout$ui_release();
            }
        } else if (i != 3) {
            throw new IllegalStateException(Intrinsics.stringPlus("Unexpected state ", layoutNode.layoutState));
        }
    }

    /* access modifiers changed from: private */
    public final void markSubtreeAsNotPlaced() {
        if (isPlaced()) {
            int i = 0;
            this.isPlaced = false;
            MutableVector<LayoutNode> mutableVector = get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                do {
                    ((LayoutNode) content[i]).markSubtreeAsNotPlaced();
                    i++;
                } while (i < size);
            }
        }
    }

    private final void onBeforeLayoutChildren() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                LayoutNode layoutNode = (LayoutNode) content[i];
                if (layoutNode.getLayoutState$ui_release() == LayoutState.NeedsRemeasure && layoutNode.getMeasuredByParent$ui_release() == UsageByParent.InMeasureBlock && m3281remeasure_Sx5XlM$ui_release$default(layoutNode, (Constraints) null, 1, (Object) null)) {
                    requestRemeasure$ui_release();
                }
                i++;
            } while (i < size);
        }
    }

    public final void onAlignmentsChanged$ui_release() {
        if (!this.alignmentLines.getDirty$ui_release()) {
            this.alignmentLines.setDirty$ui_release(true);
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                if (this.alignmentLines.getUsedDuringParentMeasurement$ui_release()) {
                    parent$ui_release.requestRemeasure$ui_release();
                } else if (this.alignmentLines.getPreviousUsedDuringParentLayout$ui_release()) {
                    parent$ui_release.requestRelayout$ui_release();
                }
                if (this.alignmentLines.getUsedByModifierMeasurement$ui_release()) {
                    requestRemeasure$ui_release();
                }
                if (this.alignmentLines.getUsedByModifierLayout$ui_release()) {
                    parent$ui_release.requestRelayout$ui_release();
                }
                parent$ui_release.onAlignmentsChanged$ui_release();
            }
        }
    }

    public final Map<AlignmentLine, Integer> calculateAlignmentLines$ui_release() {
        if (!this.outerMeasurablePlaceable.getDuringAlignmentLinesQuery$ui_release()) {
            alignmentLinesQueriedByModifier();
        }
        layoutChildren$ui_release();
        return this.alignmentLines.getLastCalculation();
    }

    private final void alignmentLinesQueriedByModifier() {
        if (this.layoutState == LayoutState.Measuring) {
            this.alignmentLines.setUsedByModifierMeasurement$ui_release(true);
            if (this.alignmentLines.getDirty$ui_release()) {
                this.layoutState = LayoutState.NeedsRelayout;
                return;
            }
            return;
        }
        this.alignmentLines.setUsedByModifierLayout$ui_release(true);
    }

    public final void handleMeasureResult$ui_release(MeasureResult measureResult) {
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        this.innerLayoutNodeWrapper.setMeasureResult$ui_release(measureResult);
    }

    public final void requestRemeasure$ui_release() {
        Owner owner2 = this.owner;
        if (owner2 != null && !this.ignoreRemeasureRequests && !this.isVirtual) {
            owner2.onRequestMeasure(this);
        }
    }

    public final void ignoreRemeasureRequests$ui_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.ignoreRemeasureRequests = true;
        function0.invoke();
        this.ignoreRemeasureRequests = false;
    }

    public final void requestRelayout$ui_release() {
        Owner owner2;
        if (!this.isVirtual && (owner2 = this.owner) != null) {
            owner2.onRequestRelayout(this);
        }
    }

    public final void withNoSnapshotReadObservation$ui_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        LayoutNodeKt.requireOwner(this).getSnapshotObserver().withNoSnapshotReadObservation$ui_release(function0);
    }

    public final void dispatchOnPositionedCallbacks$ui_release() {
        MutableVector<OnGloballyPositionedModifierWrapper> mutableVector;
        int size;
        if (this.layoutState == LayoutState.Ready && isPlaced() && (mutableVector = this.onPositionedCallbacks) != null && (size = mutableVector.getSize()) > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                OnGloballyPositionedModifierWrapper onGloballyPositionedModifierWrapper = (OnGloballyPositionedModifierWrapper) content[i];
                ((OnGloballyPositionedModifier) onGloballyPositionedModifierWrapper.getModifier()).onGloballyPositioned(onGloballyPositionedModifierWrapper);
                i++;
            } while (i < size);
        }
    }

    /* access modifiers changed from: private */
    public final DelegatingLayoutNodeWrapper<?> reuseLayoutNodeWrapper(Modifier.Element element, LayoutNodeWrapper layoutNodeWrapper) {
        int i;
        if (this.wrapperCache.isEmpty()) {
            return null;
        }
        MutableVector<DelegatingLayoutNodeWrapper<?>> mutableVector = this.wrapperCache;
        int size = mutableVector.getSize();
        int i2 = -1;
        if (size > 0) {
            i = size - 1;
            Object[] content = mutableVector.getContent();
            while (true) {
                DelegatingLayoutNodeWrapper delegatingLayoutNodeWrapper = (DelegatingLayoutNodeWrapper) content[i];
                if (delegatingLayoutNodeWrapper.getToBeReusedForSameModifier() && delegatingLayoutNodeWrapper.getModifier() == element) {
                    break;
                }
                i--;
                if (i < 0) {
                    break;
                }
            }
        } else {
            i = -1;
        }
        if (i < 0) {
            MutableVector<DelegatingLayoutNodeWrapper<?>> mutableVector2 = this.wrapperCache;
            int size2 = mutableVector2.getSize();
            if (size2 > 0) {
                int i3 = size2 - 1;
                Object[] content2 = mutableVector2.getContent();
                while (true) {
                    DelegatingLayoutNodeWrapper delegatingLayoutNodeWrapper2 = (DelegatingLayoutNodeWrapper) content2[i3];
                    if (!(!delegatingLayoutNodeWrapper2.getToBeReusedForSameModifier() && Intrinsics.areEqual(JvmActuals_jvmKt.nativeClass(delegatingLayoutNodeWrapper2.getModifier()), JvmActuals_jvmKt.nativeClass(element)))) {
                        i3--;
                        if (i3 < 0) {
                            break;
                        }
                    } else {
                        i2 = i3;
                        break;
                    }
                }
            }
            i = i2;
        }
        if (i < 0) {
            return null;
        }
        int i4 = i - 1;
        DelegatingLayoutNodeWrapper<?> removeAt = this.wrapperCache.removeAt(i);
        removeAt.setWrapped(layoutNodeWrapper);
        removeAt.setModifierTo(element);
        removeAt.onInitialize();
        while (removeAt.isChained()) {
            DelegatingLayoutNodeWrapper<?> removeAt2 = this.wrapperCache.removeAt(i4);
            removeAt2.setModifierTo(element);
            removeAt2.onInitialize();
            i4--;
            removeAt = removeAt2;
        }
        return removeAt;
    }

    private final void markReusedModifiers(Modifier modifier2) {
        MutableVector<DelegatingLayoutNodeWrapper<?>> mutableVector = this.wrapperCache;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                ((DelegatingLayoutNodeWrapper) content[i]).setToBeReusedForSameModifier(false);
                i++;
            } while (i < size);
        }
        modifier2.foldIn(Unit.INSTANCE, new LayoutNode$markReusedModifiers$2(this));
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m3284measureBRTryo0(long j) {
        return this.outerMeasurablePlaceable.m3364measureBRTryo0(j);
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default  reason: not valid java name */
    public static /* synthetic */ boolean m3281remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.outerMeasurablePlaceable.m3363getLastConstraintsDWUhwKw();
        }
        return layoutNode.m3285remeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release  reason: not valid java name */
    public final boolean m3285remeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints != null) {
            return this.outerMeasurablePlaceable.m3366remeasureBRTryo0(constraints.m3809unboximpl());
        }
        return false;
    }

    public Object getParentData() {
        return this.outerMeasurablePlaceable.getParentData();
    }

    public int minIntrinsicWidth(int i) {
        return this.outerMeasurablePlaceable.minIntrinsicWidth(i);
    }

    public int maxIntrinsicWidth(int i) {
        return this.outerMeasurablePlaceable.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(int i) {
        return this.outerMeasurablePlaceable.minIntrinsicHeight(i);
    }

    public int maxIntrinsicHeight(int i) {
        return this.outerMeasurablePlaceable.maxIntrinsicHeight(i);
    }

    public void forceRemeasure() {
        requestRemeasure$ui_release();
        Owner owner2 = this.owner;
        if (owner2 != null) {
            Owner.DefaultImpls.measureAndLayout$default(owner2, false, 1, (Object) null);
        }
    }

    private final void forEachDelegate(Function1<? super LayoutNodeWrapper, Unit> function1) {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper innerLayoutNodeWrapper$ui_release = getInnerLayoutNodeWrapper$ui_release();
        while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release, (Object) innerLayoutNodeWrapper$ui_release)) {
            function1.invoke(outerLayoutNodeWrapper$ui_release);
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
            Intrinsics.checkNotNull(outerLayoutNodeWrapper$ui_release);
        }
    }

    private final void forEachDelegateIncludingInner(Function1<? super LayoutNodeWrapper, Unit> function1) {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper wrapped$ui_release = getInnerLayoutNodeWrapper$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release, (Object) wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null) {
            function1.invoke(outerLayoutNodeWrapper$ui_release);
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ZComparator$lambda-34  reason: not valid java name */
    public static final int m3277ZComparator$lambda34(LayoutNode layoutNode, LayoutNode layoutNode2) {
        float f = layoutNode.zIndex;
        float f2 = layoutNode2.zIndex;
        if (f == f2) {
            return Intrinsics.compare(layoutNode.placeOrder, layoutNode2.placeOrder);
        }
        return Float.compare(f, f2);
    }

    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }
    }

    public List<ModifierInfo> getModifierInfo() {
        MutableVector mutableVector = new MutableVector(new ModifierInfo[16], 0);
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper innerLayoutNodeWrapper$ui_release = getInnerLayoutNodeWrapper$ui_release();
        while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release, (Object) innerLayoutNodeWrapper$ui_release)) {
            OwnedLayer layer = outerLayoutNodeWrapper$ui_release.getLayer();
            LayoutCoordinates layoutCoordinates = outerLayoutNodeWrapper$ui_release;
            mutableVector.add(new ModifierInfo(((DelegatingLayoutNodeWrapper) outerLayoutNodeWrapper$ui_release).getModifier(), layoutCoordinates, layer));
            for (DrawEntity drawEntityHead = outerLayoutNodeWrapper$ui_release.getDrawEntityHead(); drawEntityHead != null; drawEntityHead = drawEntityHead.getNext()) {
                mutableVector.add(new ModifierInfo(drawEntityHead.getModifier(), layoutCoordinates, layer));
            }
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
            Intrinsics.checkNotNull(outerLayoutNodeWrapper$ui_release);
        }
        for (DrawEntity drawEntityHead2 = this.innerLayoutNodeWrapper.getDrawEntityHead(); drawEntityHead2 != null; drawEntityHead2 = drawEntityHead2.getNext()) {
            LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
            mutableVector.add(new ModifierInfo(drawEntityHead2.getModifier(), layoutNodeWrapper, layoutNodeWrapper.getLayer()));
        }
        return mutableVector.asMutableList();
    }

    public final void invalidateLayers$ui_release() {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper innerLayoutNodeWrapper$ui_release = getInnerLayoutNodeWrapper$ui_release();
        while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release, (Object) innerLayoutNodeWrapper$ui_release)) {
            OwnedLayer layer = outerLayoutNodeWrapper$ui_release.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
            Intrinsics.checkNotNull(outerLayoutNodeWrapper$ui_release);
        }
        OwnedLayer layer2 = this.innerLayoutNodeWrapper.getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    private final void copyWrappersToCache() {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper innerLayoutNodeWrapper$ui_release = getInnerLayoutNodeWrapper$ui_release();
        while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release, (Object) innerLayoutNodeWrapper$ui_release)) {
            this.wrapperCache.add((DelegatingLayoutNodeWrapper) outerLayoutNodeWrapper$ui_release);
            outerLayoutNodeWrapper$ui_release.setDrawEntityHead((DrawEntity) null);
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
            Intrinsics.checkNotNull(outerLayoutNodeWrapper$ui_release);
        }
        this.innerLayoutNodeWrapper.setDrawEntityHead((DrawEntity) null);
    }

    private final boolean shouldInvalidateParentLayer() {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper wrapped$ui_release = getInnerLayoutNodeWrapper$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) outerLayoutNodeWrapper$ui_release, (Object) wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null) {
            if (outerLayoutNodeWrapper$ui_release.getLayer() != null) {
                return false;
            }
            if (outerLayoutNodeWrapper$ui_release.getDrawEntityHead() != null) {
                return true;
            }
            outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release();
        }
        return true;
    }
}
