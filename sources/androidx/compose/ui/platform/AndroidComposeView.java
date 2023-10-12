package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusManagerImpl;
import androidx.compose.ui.focus.FocusModifier;
import androidx.compose.ui.focus.FocusNodeUtilsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifier;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.semantics.SemanticsModifierCore;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¶\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0002\u0001\b\u0001\u0018\u0000 î\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004î\u0002ï\u0002B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010Ô\u0001\u001a\u00020-2\b\u0010¼\u0001\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030\u0001J\u0019\u0010\u001c\u001a\u00020-2\u000f\u0010×\u0001\u001a\n\u0012\u0005\u0012\u00030Ù\u00010Ø\u0001H\u0016J\t\u0010Ú\u0001\u001a\u00020EH\u0002J\u0013\u0010Û\u0001\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010Ü\u0001J!\u0010Ý\u0001\u001a\u00020]2\u0007\u0010Þ\u0001\u001a\u00020]H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bß\u0001\u0010à\u0001J!\u0010á\u0001\u001a\u00020]2\u0007\u0010â\u0001\u001a\u00020]H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bã\u0001\u0010à\u0001J\u0013\u0010ä\u0001\u001a\u00020E2\b\u0010å\u0001\u001a\u00030æ\u0001H\u0016J\u0013\u0010ç\u0001\u001a\u00020E2\b\u0010å\u0001\u001a\u00030æ\u0001H\u0016J\u0012\u0010è\u0001\u001a\u00020-2\u0007\u0010é\u0001\u001a\u00020\u0001H\u0002J\u000f\u0010ê\u0001\u001a\u00020-H\u0000¢\u0006\u0003\bë\u0001J\"\u0010ì\u0001\u001a\u0011\u0012\u0005\u0012\u00030æ\u0001\u0012\u0005\u0012\u00030æ\u00010í\u00012\b\u0010î\u0001\u001a\u00030æ\u0001H\u0002J/\u0010ï\u0001\u001a\u00020;2\u0014\u0010ð\u0001\u001a\u000f\u0012\u0005\u0012\u00030ñ\u0001\u0012\u0004\u0012\u00020-0+2\u000e\u0010ò\u0001\u001a\t\u0012\u0004\u0012\u00020-0\u0001H\u0016J\u0013\u0010ó\u0001\u001a\u00020-2\b\u0010ô\u0001\u001a\u00030õ\u0001H\u0014J\u0013\u0010ö\u0001\u001a\u00020E2\b\u0010÷\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010ø\u0001\u001a\u00020E2\b\u0010÷\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010ù\u0001\u001a\u00020E2\b\u0010÷\u0001\u001a\u00030ú\u0001H\u0016J\u0013\u0010û\u0001\u001a\u00020E2\b\u0010ü\u0001\u001a\u00030\u0001H\u0016J\u001b\u0010ý\u0001\u001a\u00020-2\b\u0010¼\u0001\u001a\u00030Õ\u00012\b\u0010ô\u0001\u001a\u00030õ\u0001J \u0010þ\u0001\u001a\u0005\u0018\u00010½\u00012\b\u0010ÿ\u0001\u001a\u00030æ\u00012\b\u0010\u0002\u001a\u00030½\u0001H\u0002J\u0014\u0010\u0002\u001a\u0005\u0018\u00010½\u00012\b\u0010ÿ\u0001\u001a\u00030æ\u0001J\u0013\u0010\u0002\u001a\u00020-2\b\u0010Ö\u0001\u001a\u00030\u0001H\u0016J%\u0010\u0002\u001a\u0005\u0018\u00010\u00022\b\u0010\u0002\u001a\u00030\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0002\u0010\u0002J&\u0010\u0002\u001a\u00030\u00022\b\u0010ü\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\b\u0002\u0010\u0002J\u001d\u0010\u0002\u001a\u00020E2\b\u0010÷\u0001\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0001H\u0002J\t\u0010\u0002\u001a\u00020-H\u0016J\u0013\u0010\u0002\u001a\u00020-2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00020-2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00020E2\b\u0010÷\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00020E2\b\u0010÷\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00020E2\b\u0010ü\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00020E2\b\u0010÷\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010Ü\u0001J!\u0010\u0002\u001a\u00020]2\u0007\u0010â\u0001\u001a\u00020]H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0002\u0010à\u0001J\u0012\u0010\u0002\u001a\u00020-2\u0007\u0010\u0002\u001a\u00020EH\u0016J!\u0010\u0002\u001a\u00020-2\u0007\u0010\u0002\u001a\u00020;2\u0007\u0010\u0002\u001a\u00020EH\u0000¢\u0006\u0003\b\u0002J\u0013\u0010 \u0002\u001a\u00020-2\b\u0010\u0002\u001a\u00030\u0001H\u0016J\t\u0010¡\u0002\u001a\u00020-H\u0014J\t\u0010¢\u0002\u001a\u00020EH\u0016J\u0012\u0010£\u0002\u001a\u00020-2\u0007\u0010¤\u0002\u001a\u00020,H\u0014J\u0016\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u00022\b\u0010§\u0002\u001a\u00030¨\u0002H\u0016J\u0013\u0010©\u0002\u001a\u00020-2\b\u0010\u0002\u001a\u00030\u0001H\u0016J\t\u0010ª\u0002\u001a\u00020-H\u0014J\u0013\u0010«\u0002\u001a\u00020-2\b\u0010ô\u0001\u001a\u00030õ\u0001H\u0014J(\u0010¬\u0002\u001a\u00020-2\u0007\u0010­\u0002\u001a\u00020E2\b\u0010å\u0001\u001a\u00030æ\u00012\n\u0010®\u0002\u001a\u0005\u0018\u00010¯\u0002H\u0014J:\u0010°\u0002\u001a\u00020-2\u0007\u0010±\u0002\u001a\u00020E2\b\u0010²\u0002\u001a\u00030æ\u00012\b\u0010³\u0002\u001a\u00030æ\u00012\b\u0010´\u0002\u001a\u00030æ\u00012\b\u0010µ\u0002\u001a\u00030æ\u0001H\u0014J\u0013\u0010¶\u0002\u001a\u00020-2\b\u0010Ö\u0001\u001a\u00030\u0001H\u0016J\u001d\u0010·\u0002\u001a\u00020-2\b\u0010¸\u0002\u001a\u00030æ\u00012\b\u0010¹\u0002\u001a\u00030æ\u0001H\u0014J\u001f\u0010º\u0002\u001a\u00020-2\n\u0010»\u0002\u001a\u0005\u0018\u00010¼\u00022\b\u0010½\u0002\u001a\u00030æ\u0001H\u0016J\u0013\u0010¾\u0002\u001a\u00020-2\b\u0010Ö\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010¿\u0002\u001a\u00020-2\b\u0010Ö\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010À\u0002\u001a\u00020-2\b\u0010Á\u0002\u001a\u00030Â\u0002H\u0016J\u0012\u0010Ã\u0002\u001a\u00020-2\u0007\u0010i\u001a\u00030æ\u0001H\u0016J\t\u0010Ä\u0002\u001a\u00020-H\u0016J\u0012\u0010Å\u0002\u001a\u00020-2\u0007\u0010Æ\u0002\u001a\u00020EH\u0016J\t\u0010Ç\u0002\u001a\u00020-H\u0002J\u0013\u0010Ç\u0002\u001a\u00020-2\b\u0010ü\u0001\u001a\u00030\u0001H\u0002J\t\u0010È\u0002\u001a\u00020-H\u0002J\u0018\u0010É\u0002\u001a\u00020E2\u0007\u0010\u0002\u001a\u00020;H\u0000¢\u0006\u0003\bÊ\u0002J\u0011\u0010Ë\u0002\u001a\u00020-2\b\u0010¼\u0001\u001a\u00030Õ\u0001J\u0007\u0010Ì\u0002\u001a\u00020-J\u0017\u0010Í\u0002\u001a\u00020-2\f\b\u0002\u0010Î\u0002\u001a\u0005\u0018\u00010\u0001H\u0002J!\u0010Ï\u0002\u001a\u00020]2\u0007\u0010Ð\u0002\u001a\u00020]H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÑ\u0002\u0010à\u0001J\"\u0010Ò\u0002\u001a\u00020E2\b\u0010\u0002\u001a\u00030\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÓ\u0002\u0010Ô\u0002J&\u0010Õ\u0002\u001a\u00030\u00022\b\u0010ü\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\bÖ\u0002\u0010\u0002J1\u0010×\u0002\u001a\u00020-2\b\u0010ü\u0001\u001a\u00030\u00012\b\u0010Ø\u0002\u001a\u00030æ\u00012\u0007\u0010Ù\u0002\u001a\u00020_2\t\b\u0002\u0010Ú\u0002\u001a\u00020EH\u0002J\u001c\u0010Û\u0002\u001a\u00020-2\u0013\u0010Ü\u0002\u001a\u000e\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020-0+J\t\u0010Ý\u0002\u001a\u00020EH\u0016J,\u0010Þ\u0002\u001a\u00020-2\b\u0010¼\u0001\u001a\u00030½\u00012\b\u0010ß\u0002\u001a\u00030¶\u0001H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bà\u0002\u0010á\u0002J\t\u0010â\u0002\u001a\u00020-H\u0002J'\u0010ã\u0002\u001a\u00020-*\u00030¶\u00012\b\u0010ä\u0002\u001a\u00030å\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bæ\u0002\u0010ç\u0002J1\u0010è\u0002\u001a\u00020-*\u00030¶\u00012\b\u0010é\u0002\u001a\u00030ê\u00022\b\u0010ë\u0002\u001a\u00030ê\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bì\u0002\u0010í\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00104\u001a\u0002032\u0006\u00102\u001a\u000203@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020=8VX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020AX\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010H\u001a\u00020IX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010JR\u0014\u0010K\u001a\u00020LX\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020E8VX\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u00020T8VX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\u00020E8VX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010QR\u000e\u0010Y\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\\\u001a\u00020]X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010JR$\u0010^\u001a\u00020_8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020;0gX\u0004¢\u0006\u0002\n\u0000R+\u0010i\u001a\u00020h2\u0006\u00102\u001a\u00020h8V@RX\u0002¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u000e\u0010p\u001a\u00020qX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010r\u001a\u00020_8VX\u0004¢\u0006\u0006\u001a\u0004\bs\u0010cR\u000e\u0010t\u001a\u00020uX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010w\u001a\u0004\u0018\u00010xX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u001c\u0010y\u001a\u0010\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020-\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010{\u001a\u00020|X\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u000f\u0010\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020_X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020-0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0005\n\u0003\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R%\u0010 \u0001\u001a\u00020EX\u000e¢\u0006\u0018\n\u0000\u0012\u0005\b¡\u0001\u0010a\u001a\u0005\b¢\u0001\u0010Q\"\u0006\b£\u0001\u0010¤\u0001R\u0018\u0010¥\u0001\u001a\u00030¦\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001R\u000f\u0010©\u0001\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u001f\u0010ª\u0001\u001a\u00030«\u0001X\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b¬\u0001\u0010a\u001a\u0006\b­\u0001\u0010®\u0001R\u0010\u0010¯\u0001\u001a\u00030°\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010±\u0001\u001a\u00030²\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001R\u001c\u0010µ\u0001\u001a\u00030¶\u0001X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010·\u0001R\u0010\u0010¸\u0001\u001a\u00030¹\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010º\u0001\u001a\u00030»\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010¼\u0001\u001a\u00030½\u00018VX\u0004¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0018\u0010À\u0001\u001a\u00030Á\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0012\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Æ\u0001\u001a\u00030¶\u0001X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010·\u0001R5\u0010Ç\u0001\u001a\u0004\u0018\u00010z2\b\u00102\u001a\u0004\u0018\u00010z8F@BX\u0002¢\u0006\u0017\n\u0005\bÌ\u0001\u0010o\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u000f\u0010Í\u0001\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010Î\u0001\u001a\u00030Ï\u00018VX\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u001a\u0010Ò\u0001\u001a\u00020]X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010JR\u001c\u0010Ó\u0001\u001a\u00030¶\u0001X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010·\u0001\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006ð\u0002"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_focusManager", "Landroidx/compose/ui/focus/FocusManagerImpl;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "desiredPointerIcon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/input/key/KeyInputModifier;", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "()V", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "Landroidx/compose/runtime/MutableState;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "Lkotlin/Function0;", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/SemanticsModifierCore;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService$annotations", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpCalculationMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "viewTreeOwners", "getViewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "setViewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "viewTreeOwners$delegate", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "clearInvalidObservations", "clearInvalidObservations$ui_release", "convertMeasureSpec", "Lkotlin/Pair;", "measureSpec", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "invalidateParentLayer", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "event", "dispatchHoverEvent", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "motionEvent", "drawAndroidView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "forceMeasureTheSubtree", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "keyboardVisibilityEventLoop", "localToScreen", "localToScreen-MK-Hz9U", "measureAndLayout", "sendPointerUpdate", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetach", "onDetachedFromWindow", "onDraw", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onProvideAutofillVirtualStructure", "structure", "Landroid/view/ViewStructure;", "flags", "onRequestMeasure", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onSemanticsChange", "onWindowFocusChanged", "hasWindowFocus", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "removeAndroidView", "requestClearInvalidObservations", "scheduleMeasureAndLayout", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "transformMatrixToWindow", "matrix", "transformMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "updatePositionCacheAndDispatch", "preConcat", "other", "Landroid/graphics/Matrix;", "preConcat-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "preTranslate", "x", "", "y", "preTranslate-3XD1CNM", "([FFF)V", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MaximumLayerCacheSize = 10;
    /* access modifiers changed from: private */
    public static Method getBooleanMethod;
    /* access modifiers changed from: private */
    public static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final FocusManagerImpl _focusManager;
    private final InputModeManagerImpl _inputModeManager;
    private final WindowInfoImpl _windowInfo;
    private final AndroidComposeViewAccessibilityDelegateCompat accessibilityDelegate;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboardManager clipboardManager;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private Density density;
    /* access modifiers changed from: private */
    public PointerIcon desiredPointerIcon;
    private final List<OwnedLayer> dirtyLayers;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isRenderNodeCompatible;
    private final KeyInputModifier keyInputModifier;
    private long lastDownPointerPosition = Offset.Companion.m1368getUnspecifiedF1C5BW0();
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;
    private final MutableState layoutDirection$delegate;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    /* access modifiers changed from: private */
    public MotionEvent previousMotionEvent;
    /* access modifiers changed from: private */
    public long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    /* access modifiers changed from: private */
    public final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final SemanticsModifierCore semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope = new LayoutNodeDrawScope((CanvasDrawScope) null, 1, (DefaultConstructorMarker) null);
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private boolean superclassInitComplete = true;
    private final TextInputService textInputService;
    private final TextInputServiceAndroid textInputServiceAndroid;
    private final TextToolbar textToolbar;
    private final float[] tmpCalculationMatrix;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;
    private final MutableState viewTreeOwners$delegate;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public static /* synthetic */ void getTextInputService$annotations() {
    }

    public void onAttach(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onDestroy(this, lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onPause(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStart(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStop(this, lifecycleOwner);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidComposeView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.density = AndroidDensity_androidKt.Density(context);
        SemanticsModifierCore semanticsModifierCore = new SemanticsModifierCore(SemanticsModifierCore.Companion.generateSemanticsId(), false, false, AndroidComposeView$semanticsModifier$1.INSTANCE);
        this.semanticsModifier = semanticsModifierCore;
        FocusManagerImpl focusManagerImpl = new FocusManagerImpl((FocusModifier) null, 1, (DefaultConstructorMarker) null);
        this._focusManager = focusManagerImpl;
        this._windowInfo = new WindowInfoImpl();
        KeyInputModifier keyInputModifier2 = new KeyInputModifier(new AndroidComposeView$keyInputModifier$1(this), (Function1<? super KeyEvent, Boolean>) null);
        this.keyInputModifier = keyInputModifier2;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 1, (DefaultConstructorMarker) null);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setModifier(Modifier.Companion.then(semanticsModifierCore).then(focusManagerImpl.getModifier()).then(keyInputModifier2));
        layoutNode.setDensity(getDensity());
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.accessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = AndroidComposeView$configurationChangeObserver$1.INSTANCE;
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        ViewConfiguration viewConfiguration2 = ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration2, "get(context)");
        this.viewConfiguration = new AndroidViewConfiguration(viewConfiguration2);
        this.globalPosition = IntOffset.Companion.m3987getZeronOccac();
        this.tmpPositionArray = new int[]{0, 0};
        this.viewToWindowMatrix = Matrix.m1767constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.windowToViewMatrix = Matrix.m1767constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.tmpCalculationMatrix = Matrix.m1767constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.lastMatrixRecalculationAnimationTime = -1;
        this.windowPosition = Offset.Companion.m1367getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this.viewTreeOwners$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AndroidComposeView.m3381globalLayoutListener$lambda1(AndroidComposeView.this);
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                AndroidComposeView.m3386scrollChangedListener$lambda2(AndroidComposeView.this);
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() {
            public final void onTouchModeChanged(boolean z) {
                AndroidComposeView.m3389touchModeChangeListener$lambda3(AndroidComposeView.this, z);
            }
        };
        View view = this;
        TextInputServiceAndroid textInputServiceAndroid2 = new TextInputServiceAndroid(view);
        this.textInputServiceAndroid = textInputServiceAndroid2;
        this.textInputService = AndroidComposeView_androidKt.getTextInputServiceFactory().invoke(textInputServiceAndroid2);
        this.fontLoader = new AndroidFontResourceLoader(context);
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        this.layoutDirection$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AndroidComposeView_androidKt.getLocaleLayoutDirection(configuration), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.hapticFeedBack = new PlatformHapticFeedback(view);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.Companion.m2251getTouchaOaMEAU() : InputMode.Companion.m2250getKeyboardaOaMEAU(), new AndroidComposeView$_inputModeManager$1(this), (DefaultConstructorMarker) null);
        this.textToolbar = new AndroidTextToolbar(view);
        this.layerCache = new WeakCache<>();
        this.resendMotionEventRunnable = new AndroidComposeView$resendMotionEventRunnable$1(this);
        this.sendHoverExitEvent = new Runnable() {
            public final void run() {
                AndroidComposeView.m3387sendHoverExitEvent$lambda5(AndroidComposeView.this);
            }
        };
        this.resendMotionEventOnLayout = new AndroidComposeView$resendMotionEventOnLayout$1(this);
        setWillNotDraw(false);
        setFocusable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(view, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        setTransitionGroup(true);
        ViewCompat.setAccessibilityDelegate(view, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.Companion.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        getRoot().attach$ui_release(this);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(view);
        }
        this.pointerIconService = new AndroidComposeView$pointerIconService$1(this);
    }

    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    public View getView() {
        return this;
    }

    public Density getDensity() {
        return this.density;
    }

    public FocusManager getFocusManager() {
        return this._focusManager;
    }

    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    public LayoutNode getRoot() {
        return this.root;
    }

    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.configurationChangeObserver = function1;
    }

    public Autofill getAutofill() {
        return this._autofill;
    }

    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(context);
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    private final void setViewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this.viewTreeOwners$delegate.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: globalLayoutListener$lambda-1  reason: not valid java name */
    public static final void m3381globalLayoutListener$lambda1(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        androidComposeView.updatePositionCacheAndDispatch();
    }

    /* access modifiers changed from: private */
    /* renamed from: scrollChangedListener$lambda-2  reason: not valid java name */
    public static final void m3386scrollChangedListener$lambda2(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        androidComposeView.updatePositionCacheAndDispatch();
    }

    /* access modifiers changed from: private */
    /* renamed from: touchModeChangeListener$lambda-3  reason: not valid java name */
    public static final void m3389touchModeChangeListener$lambda3(AndroidComposeView androidComposeView, boolean z) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        androidComposeView._inputModeManager.m2256setInputModeiuPiT84(z ? InputMode.Companion.m2251getTouchaOaMEAU() : InputMode.Companion.m2250getKeyboardaOaMEAU());
        androidComposeView._focusManager.fetchUpdatedFocusProperties();
    }

    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* access modifiers changed from: private */
    /* renamed from: sendHoverExitEvent$lambda-5  reason: not valid java name */
    public static final void m3387sendHoverExitEvent$lambda5(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        boolean z = false;
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() == 10) {
            z = true;
        }
        if (z) {
            androidComposeView.m3388sendMotionEvent8iAsVTc(motionEvent);
            return;
        }
        throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        setShowLayoutBounds(Companion.getIsShowingLayoutBounds());
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        Log.d(FocusNodeUtilsKt.FocusTag, "Owner FocusChanged(" + z + ')');
        FocusManagerImpl focusManagerImpl = this._focusManager;
        if (z) {
            focusManagerImpl.takeFocus();
        } else {
            focusManagerImpl.releaseFocus();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        this._windowInfo.setWindowFocused(z);
        super.onWindowFocusChanged(z);
    }

    /* renamed from: sendKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m3396sendKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        return this.keyInputModifier.m2862processKeyInputZmokQxo(keyEvent);
    }

    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (isFocused()) {
            return m3396sendKeyEventZmokQxo(KeyEvent.m2839constructorimpl(keyEvent));
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void onDetach(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        this.measureAndLayoutDelegate.onNodeDetached(layoutNode);
        requestClearInvalidObservations();
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    public final void clearInvalidObservations$ui_release() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (i < childCount) {
            int i2 = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).clearInvalidObservations$ui_release();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
            i = i2;
        }
    }

    public final void addAndroidView(AndroidViewHolder androidViewHolder, LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "view");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(androidViewHolder, layoutNode);
        View view = androidViewHolder;
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, androidViewHolder);
        ViewCompat.setImportantForAccessibility(view, 1);
        ViewCompat.setAccessibilityDelegate(view, new AndroidComposeView$addAndroidView$1(layoutNode, this, this));
    }

    public final void removeAndroidView(AndroidViewHolder androidViewHolder) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "view");
        View view = androidViewHolder;
        getAndroidViewsHandler$ui_release().removeView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().remove(getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(androidViewHolder));
        ViewCompat.setImportantForAccessibility(view, 0);
    }

    public final void drawAndroidView(AndroidViewHolder androidViewHolder, Canvas canvas) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getAndroidViewsHandler$ui_release().drawView(androidViewHolder, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode layoutNode) {
        if (!isLayoutRequested() && isAttachedToWindow()) {
            if (this.wasMeasuredWithMultipleConstraints && layoutNode != null) {
                while (layoutNode != null && layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                    layoutNode = layoutNode.getParent$ui_release();
                }
                if (layoutNode == getRoot()) {
                    requestLayout();
                    return;
                }
            }
            if (getWidth() == 0 || getHeight() == 0) {
                requestLayout();
            } else {
                invalidate();
            }
        }
    }

    public void measureAndLayout(boolean z) {
        if (this.measureAndLayoutDelegate.measureAndLayout(z ? this.resendMotionEventOnLayout : null)) {
            requestLayout();
        }
        MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, (Object) null);
    }

    public void forceMeasureTheSubtree(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode);
    }

    public void onRequestMeasure(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode)) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    public void onRequestRelayout(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (this.measureAndLayoutDelegate.requestRelayout(layoutNode)) {
            scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
        }
    }

    private final Pair<Integer, Integer> convertMeasureSpec(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return TuplesKt.to(0, Integer.valueOf(size));
        }
        if (mode == 0) {
            return TuplesKt.to(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return TuplesKt.to(Integer.valueOf(size), Integer.valueOf(size));
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, i3 - i, i4 - i2);
        }
    }

    private final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        boolean z = false;
        if (!(IntOffset.m3977getXimpl(this.globalPosition) == this.tmpPositionArray[0] && IntOffset.m3978getYimpl(this.globalPosition) == this.tmpPositionArray[1])) {
            int[] iArr = this.tmpPositionArray;
            this.globalPosition = IntOffsetKt.IntOffset(iArr[0], iArr[1]);
            z = true;
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public OwnedLayer createLayer(Function1<? super androidx.compose.ui.graphics.Canvas, Unit> function1, Function0<Unit> function0) {
        DrawChildContainer drawChildContainer;
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        OwnedLayer pop = this.layerCache.pop();
        if (pop != null) {
            pop.reuseLayer(function1, function0);
            return pop;
        }
        if (isHardwareAccelerated() && Build.VERSION.SDK_INT >= 23 && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, function1, function0);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            if (!ViewLayer.Companion.getHasRetrievedMethod()) {
                ViewLayer.Companion.updateDisplayList(new View(getContext()));
            }
            if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                drawChildContainer = new DrawChildContainer(context);
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                drawChildContainer = new ViewLayerContainer(context2);
            }
            this.viewLayersContainer = drawChildContainer;
            addView(drawChildContainer);
        }
        DrawChildContainer drawChildContainer2 = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer2);
        return new ViewLayer(this, drawChildContainer2, function1, function0);
    }

    public final boolean recycle$ui_release(OwnedLayer ownedLayer) {
        Intrinsics.checkNotNullParameter(ownedLayer, "layer");
        boolean z = this.viewLayersContainer == null || ViewLayer.Companion.getShouldUseDispatchDraw() || Build.VERSION.SDK_INT >= 23 || this.layerCache.getSize() < 10;
        if (z) {
            this.layerCache.push(ownedLayer);
        }
        return z;
    }

    public void onSemanticsChange() {
        this.accessibilityDelegate.onSemanticsChange$ui_release();
    }

    public void onLayoutChange(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.accessibilityDelegate.onLayoutChange$ui_release(layoutNode);
    }

    /* renamed from: getFocusDirection-P8AzH3I  reason: not valid java name */
    public FocusDirection m3393getFocusDirectionP8AzH3I(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        long r0 = KeyEvent_androidKt.m2855getKeyZmokQxo(keyEvent);
        if (Key.m2260equalsimpl0(r0, Key.Companion.m2783getTabEK5gGoQ())) {
            return FocusDirection.m1292boximpl(KeyEvent_androidKt.m2861isShiftPressedZmokQxo(keyEvent) ? FocusDirection.Companion.m1306getPreviousdhqQ8s() : FocusDirection.Companion.m1304getNextdhqQ8s());
        } else if (Key.m2260equalsimpl0(r0, Key.Companion.m2624getDirectionRightEK5gGoQ())) {
            return FocusDirection.m1292boximpl(FocusDirection.Companion.m1307getRightdhqQ8s());
        } else {
            if (Key.m2260equalsimpl0(r0, Key.Companion.m2623getDirectionLeftEK5gGoQ())) {
                return FocusDirection.m1292boximpl(FocusDirection.Companion.m1303getLeftdhqQ8s());
            }
            if (Key.m2260equalsimpl0(r0, Key.Companion.m2625getDirectionUpEK5gGoQ())) {
                return FocusDirection.m1292boximpl(FocusDirection.Companion.m1308getUpdhqQ8s());
            }
            if (Key.m2260equalsimpl0(r0, Key.Companion.m2620getDirectionDownEK5gGoQ())) {
                return FocusDirection.m1292boximpl(FocusDirection.Companion.m1301getDowndhqQ8s());
            }
            boolean z = true;
            if (Key.m2260equalsimpl0(r0, Key.Companion.m2619getDirectionCenterEK5gGoQ()) ? true : Key.m2260equalsimpl0(r0, Key.Companion.m2633getEnterEK5gGoQ()) ? true : Key.m2260equalsimpl0(r0, Key.Companion.m2725getNumPadEnterEK5gGoQ())) {
                return FocusDirection.m1292boximpl(FocusDirection.Companion.m1302getIndhqQ8s());
            }
            if (!Key.m2260equalsimpl0(r0, Key.Companion.m2562getBackEK5gGoQ())) {
                z = Key.m2260equalsimpl0(r0, Key.Companion.m2636getEscapeEK5gGoQ());
            }
            if (z) {
                return FocusDirection.m1292boximpl(FocusDirection.Companion.m1305getOutdhqQ8s());
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.DefaultImpls.measureAndLayout$default(this, false, 1, (Object) null);
        this.isDrawingContent = true;
        CanvasHolder canvasHolder2 = this.canvasHolder;
        Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
        canvasHolder2.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder2.getAndroidCanvas());
        canvasHolder2.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                this.dirtyLayers.get(i).updateDisplayList();
            }
        }
        if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
            int save = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer ownedLayer, boolean z) {
        Intrinsics.checkNotNullParameter(ownedLayer, "layer");
        if (!z) {
            if (!this.isDrawingContent && !this.dirtyLayers.remove(ownedLayer)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else if (!this.isDrawingContent) {
            this.dirtyLayers.add(ownedLayer);
        } else {
            List<OwnedLayer> list = this.postponedDirtyLayers;
            if (list == null) {
                list = new ArrayList<>();
                this.postponedDirtyLayers = list;
            }
            list.add(ownedLayer);
        }
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            function1.invoke(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = function1;
        }
    }

    public final Object boundsUpdatesEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop = this.accessibilityDelegate.boundsUpdatesEventLoop(continuation);
        return boundsUpdatesEventLoop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop : Unit.INSTANCE;
    }

    public final Object keyboardVisibilityEventLoop(Continuation<? super Unit> continuation) {
        Object keyboardVisibilityEventLoop = this.textInputServiceAndroid.keyboardVisibilityEventLoop(continuation);
        return keyboardVisibilityEventLoop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? keyboardVisibilityEventLoop : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestRemeasure(layoutNode);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                invalidateLayoutNodeMeasurement((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    private final void invalidateLayers(LayoutNode layoutNode) {
        layoutNode.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                invalidateLayers((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        View view = this;
        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(view);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(view);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || !(lifecycleOwner2 == null || savedStateRegistryOwner == null || (lifecycleOwner2 == viewTreeOwners.getLifecycleOwner() && savedStateRegistryOwner == viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner2 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            } else if (savedStateRegistryOwner != null) {
                if (!(viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
                    lifecycle.removeObserver(this);
                }
                lifecycleOwner2.getLifecycle().addObserver(this);
                ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner2, savedStateRegistryOwner);
                setViewTreeOwners(viewTreeOwners2);
                Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
                if (function1 != null) {
                    function1.invoke(viewTreeOwners2);
                }
                this.onViewTreeOwnersAvailable = null;
            } else {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
        }
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners3);
        viewTreeOwners3.getLifecycleOwner().getLifecycle().addObserver(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (!(viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
            lifecycle.removeObserver(this);
        }
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        AndroidAutofill androidAutofill;
        if (autofillSupported() && viewStructure != null && (androidAutofill = this._autofill) != null) {
            AndroidAutofill_androidKt.populateViewStructure(androidAutofill, viewStructure);
        }
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        AndroidAutofill androidAutofill;
        Intrinsics.checkNotNullParameter(sparseArray, "values");
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AndroidAutofill_androidKt.performAutofill(androidAutofill, sparseArray);
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (motionEvent.getActionMasked() == 8) {
            return ProcessResult.m3053getDispatchedToAPointerInputModifierimpl(m3382handleMotionEvent8iAsVTc(motionEvent));
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent)) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int r4 = m3382handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m3052getAnyMovementConsumedimpl(r4)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m3053getDispatchedToAPointerInputModifierimpl(r4);
    }

    /* renamed from: handleMotionEvent-8iAsVTc  reason: not valid java name */
    private final int m3382handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        boolean z;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            boolean z2 = true;
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            this.desiredPointerIcon = null;
            Trace.beginSection("AndroidOwner:onTouch");
            int actionMasked = motionEvent.getActionMasked();
            MotionEvent motionEvent2 = this.previousMotionEvent;
            if (motionEvent2 != null && motionEvent2.getToolType(0) == 3) {
                z = true;
            } else {
                z = false;
            }
            if (motionEvent2 != null && hasChangedDevices(motionEvent, motionEvent2)) {
                if (isDevicePressEvent(motionEvent2)) {
                    this.pointerInputEventProcessor.processCancel();
                } else if (motionEvent2.getActionMasked() != 10 && z) {
                    sendSimulatedEvent$default(this, motionEvent2, 10, motionEvent2.getEventTime(), false, 8, (Object) null);
                }
            }
            if (motionEvent.getToolType(0) != 3) {
                z2 = false;
            }
            if (!z && z2 && actionMasked != 3 && actionMasked != 9 && isInBounds(motionEvent)) {
                sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, (Object) null);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
            int r15 = m3388sendMotionEvent8iAsVTc(motionEvent);
            Trace.endSection();
            if (Build.VERSION.SDK_INT >= 24) {
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(this, this.desiredPointerIcon);
            }
            this.forceUseMatrixCache = false;
            return r15;
        } catch (Throwable th) {
            this.forceUseMatrixCache = false;
            throw th;
        }
    }

    private final boolean hasChangedDevices(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) {
            return false;
        }
        return true;
    }

    private final boolean isDevicePressEvent(MotionEvent motionEvent) {
        int actionMasked;
        if (motionEvent.getButtonState() != 0 || (actionMasked = motionEvent.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6) {
            return true;
        }
        return false;
    }

    /* renamed from: sendMotionEvent-8iAsVTc  reason: not valid java name */
    private final int m3388sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        PositionCalculator positionCalculator = this;
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, positionCalculator);
        if (convertToPointerInputEvent$ui_release != null) {
            List<PointerInputEventData> pointers = convertToPointerInputEvent$ui_release.getPointers();
            ListIterator<PointerInputEventData> listIterator = pointers.listIterator(pointers.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    pointerInputEventData = null;
                    break;
                }
                pointerInputEventData = listIterator.previous();
                if (pointerInputEventData.getDown()) {
                    break;
                }
            }
            PointerInputEventData pointerInputEventData2 = pointerInputEventData;
            if (pointerInputEventData2 != null) {
                this.lastDownPointerPosition = pointerInputEventData2.m2992getPositionF1C5BW0();
            }
            int r0 = this.pointerInputEventProcessor.m2997processBIzXfog(convertToPointerInputEvent$ui_release, positionCalculator, isInBounds(motionEvent));
            int actionMasked = motionEvent.getActionMasked();
            if ((actionMasked != 0 && actionMasked != 5) || ProcessResult.m3053getDispatchedToAPointerInputModifierimpl(r0)) {
                return r0;
            }
            this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
            return r0;
        }
        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false);
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, (i2 & 8) != 0 ? true : z);
    }

    /* access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int i, long j, boolean z) {
        int i2;
        long j2;
        MotionEvent motionEvent2 = motionEvent;
        int i3 = i;
        int actionMasked = motionEvent.getActionMasked();
        int i4 = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i4 = motionEvent.getActionIndex();
            }
        } else if (!(i3 == 9 || i3 == 10)) {
            i4 = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (i4 >= 0 ? 1 : 0);
        if (pointerCount != 0) {
            MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
            for (int i5 = 0; i5 < pointerCount; i5++) {
                pointerPropertiesArr[i5] = new MotionEvent.PointerProperties();
            }
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
            for (int i6 = 0; i6 < pointerCount; i6++) {
                pointerCoordsArr[i6] = new MotionEvent.PointerCoords();
            }
            int i7 = 0;
            while (i7 < pointerCount) {
                int i8 = i7 + 1;
                int i9 = ((i4 < 0 || i7 < i4) ? 0 : 1) + i7;
                motionEvent2.getPointerProperties(i9, pointerPropertiesArr[i7]);
                MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i7];
                motionEvent2.getPointerCoords(i9, pointerCoords);
                long r10 = m3394localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
                pointerCoords.x = Offset.m1353getXimpl(r10);
                pointerCoords.y = Offset.m1354getYimpl(r10);
                i7 = i8;
            }
            if (z) {
                i2 = 0;
            } else {
                i2 = motionEvent.getButtonState();
            }
            if (motionEvent.getDownTime() == motionEvent.getEventTime()) {
                j2 = j;
            } else {
                j2 = motionEvent.getDownTime();
            }
            MotionEvent obtain = MotionEvent.obtain(j2, j, i, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), i2, motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
            MotionEventAdapter motionEventAdapter2 = this.motionEventAdapter;
            Intrinsics.checkNotNullExpressionValue(obtain, "event");
            PositionCalculator positionCalculator = this;
            PointerInputEvent convertToPointerInputEvent$ui_release = motionEventAdapter2.convertToPointerInputEvent$ui_release(obtain, positionCalculator);
            Intrinsics.checkNotNull(convertToPointerInputEvent$ui_release);
            this.pointerInputEventProcessor.m2997processBIzXfog(convertToPointerInputEvent$ui_release, positionCalculator, true);
            obtain.recycle();
        }
    }

    public boolean canScrollHorizontally(int i) {
        return this.accessibilityDelegate.m3401canScroll0AR0LA0$ui_release(false, i, this.lastDownPointerPosition);
    }

    public boolean canScrollVertically(int i) {
        return this.accessibilityDelegate.m3401canScroll0AR0LA0$ui_release(true, i, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (0.0f <= x && x <= ((float) getWidth())) {
            if (0.0f <= y && y <= ((float) getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: localToScreen-MK-Hz9U  reason: not valid java name */
    public long m3394localToScreenMKHz9U(long j) {
        recalculateWindowPosition();
        long r4 = Matrix.m1773mapMKHz9U(this.viewToWindowMatrix, j);
        return OffsetKt.Offset(Offset.m1353getXimpl(r4) + Offset.m1353getXimpl(this.windowPosition), Offset.m1354getYimpl(r4) + Offset.m1354getYimpl(this.windowPosition));
    }

    /* renamed from: screenToLocal-MK-Hz9U  reason: not valid java name */
    public long m3395screenToLocalMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m1773mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m1353getXimpl(j) - Offset.m1353getXimpl(this.windowPosition), Offset.m1354getYimpl(j) - Offset.m1354getYimpl(this.windowPosition)));
    }

    private final void recalculateWindowPosition() {
        if (!this.forceUseMatrixCache) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
                this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
                recalculateWindowViewTransforms();
                ViewParent parent = getParent();
                View view = this;
                while (parent instanceof ViewGroup) {
                    view = (View) parent;
                    parent = ((ViewGroup) view).getParent();
                }
                view.getLocationOnScreen(this.tmpPositionArray);
                int[] iArr = this.tmpPositionArray;
                view.getLocationInWindow(iArr);
                int[] iArr2 = this.tmpPositionArray;
                this.windowPosition = OffsetKt.Offset(((float) iArr[0]) - ((float) iArr2[0]), ((float) iArr[1]) - ((float) iArr2[1]));
            }
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long r0 = Matrix.m1773mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m1353getXimpl(r0), motionEvent.getRawY() - Offset.m1354getYimpl(r0));
    }

    private final void recalculateWindowViewTransforms() {
        Matrix.m1776resetimpl(this.viewToWindowMatrix);
        m3390transformMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m3424invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    public boolean onCheckIsTextEditor() {
        return this.textInputServiceAndroid.isEditorFocused();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        Intrinsics.checkNotNullParameter(editorInfo, "outAttrs");
        return this.textInputServiceAndroid.createInputConnection(editorInfo);
    }

    /* renamed from: calculateLocalPosition-MK-Hz9U  reason: not valid java name */
    public long m3391calculateLocalPositionMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m1773mapMKHz9U(this.windowToViewMatrix, j);
    }

    /* renamed from: calculatePositionInWindow-MK-Hz9U  reason: not valid java name */
    public long m3392calculatePositionInWindowMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m1773mapMKHz9U(this.viewToWindowMatrix, j);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.density = AndroidDensity_androidKt.Density(context);
        this.configurationChangeObserver.invoke(configuration);
    }

    public void onRtlPropertiesChanged(int i) {
        if (this.superclassInitComplete) {
            LayoutDirection access$layoutDirectionFromInt = AndroidComposeView_androidKt.layoutDirectionFromInt(i);
            setLayoutDirection(access$layoutDirectionFromInt);
            this._focusManager.setLayoutDirection(access$layoutDirectionFromInt);
        }
    }

    private final boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(motionEvent)) {
            return false;
        }
        if (motionEvent.isFromSource(4098) && motionEvent.getToolType(0) == 1) {
            return this.accessibilityDelegate.dispatchHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(motionEvent)) {
                if (motionEvent.getToolType(0) != 3) {
                    MotionEvent motionEvent2 = this.previousMotionEvent;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                    this.hoverExitReceived = true;
                    post(this.sendHoverExitEvent);
                    return false;
                } else if (motionEvent.getButtonState() != 0) {
                    return false;
                }
            }
        } else if (!isPositionChanged(motionEvent)) {
            return false;
        }
        return ProcessResult.m3053getDispatchedToAPointerInputModifierimpl(m3382handleMotionEvent8iAsVTc(motionEvent));
    }

    private final boolean isBadMotionEvent(MotionEvent motionEvent) {
        return Float.isNaN(motionEvent.getX()) || Float.isNaN(motionEvent.getY()) || Float.isNaN(motionEvent.getRawX()) || Float.isNaN(motionEvent.getRawY());
    }

    private final boolean isPositionChanged(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        if (motionEvent.getPointerCount() != 1 || (motionEvent2 = this.previousMotionEvent) == null) {
            return true;
        }
        if (!(motionEvent.getRawX() == motionEvent2.getRawX())) {
            return true;
        }
        if (!(motionEvent.getRawY() == motionEvent2.getRawY())) {
            return true;
        }
        return false;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int i, View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        int i2 = 0;
        Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
        declaredMethod.setAccessible(true);
        if (Intrinsics.areEqual(declaredMethod.invoke(view, new Object[0]), (Object) Integer.valueOf(i))) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (i2 < childCount) {
            int i3 = i2 + 1;
            View childAt = viewGroup.getChildAt(i2);
            Intrinsics.checkNotNullExpressionValue(childAt, "currentView.getChildAt(i)");
            View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i, childAt);
            if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                return findViewByAccessibilityIdRootedAtCurrentView;
            }
            i2 = i3;
        }
        return null;
    }

    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int i) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return findViewByAccessibilityIdRootedAtCurrentView(i, this);
            }
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(this, new Object[]{Integer.valueOf(i)});
            if (invoke instanceof View) {
                return (View) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle.State state = null;
        if (!(viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
            state = lifecycle.getCurrentState();
        }
        return state == Lifecycle.State.RESUMED;
    }

    /* renamed from: transformMatrixToWindow-EL8BTi8  reason: not valid java name */
    private final void m3390transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m3390transformMatrixToWindowEL8BTi8((View) parent, fArr);
            m3385preTranslate3XD1CNM(fArr, -((float) view.getScrollX()), -((float) view.getScrollY()));
            m3385preTranslate3XD1CNM(fArr, (float) view.getLeft(), (float) view.getTop());
        } else {
            view.getLocationInWindow(this.tmpPositionArray);
            m3385preTranslate3XD1CNM(fArr, -((float) view.getScrollX()), -((float) view.getScrollY()));
            int[] iArr = this.tmpPositionArray;
            m3385preTranslate3XD1CNM(fArr, (float) iArr[0], (float) iArr[1]);
        }
        android.graphics.Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            Intrinsics.checkNotNullExpressionValue(matrix, "viewMatrix");
            m3384preConcattUYjHk(fArr, matrix);
        }
    }

    /* renamed from: preConcat-tU-YjHk  reason: not valid java name */
    private final void m3384preConcattUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        AndroidMatrixConversions_androidKt.m1466setFromtUYjHk(this.tmpCalculationMatrix, matrix);
        AndroidComposeView_androidKt.m3405preTransformJiSxe2E(fArr, this.tmpCalculationMatrix);
    }

    /* renamed from: preTranslate-3XD1CNM  reason: not valid java name */
    private final void m3385preTranslate3XD1CNM(float[] fArr, float f, float f2) {
        Matrix.m1776resetimpl(this.tmpCalculationMatrix);
        Matrix.m1787translateimpl$default(this.tmpCalculationMatrix, f, f2, 0.0f, 4, (Object) null);
        AndroidComposeView_androidKt.m3405preTransformJiSxe2E(fArr, this.tmpCalculationMatrix);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "MaximumLayerCacheSize", "", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidComposeView.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            Object obj;
            Method method;
            try {
                Boolean bool = null;
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class access$getSystemPropertiesClass$cp = AndroidComposeView.systemPropertiesClass;
                    if (access$getSystemPropertiesClass$cp == null) {
                        method = null;
                    } else {
                        method = access$getSystemPropertiesClass$cp.getDeclaredMethod("getBoolean", new Class[]{String.class, Boolean.TYPE});
                    }
                    AndroidComposeView.getBooleanMethod = method;
                }
                Method access$getGetBooleanMethod$cp = AndroidComposeView.getBooleanMethod;
                if (access$getGetBooleanMethod$cp == null) {
                    obj = null;
                } else {
                    obj = access$getGetBooleanMethod$cp.invoke((Object) null, new Object[]{"debug.layout", false});
                }
                if (obj instanceof Boolean) {
                    bool = (Boolean) obj;
                }
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidComposeView.android.kt */
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner2, SavedStateRegistryOwner savedStateRegistryOwner2) {
            Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner2, "savedStateRegistryOwner");
            this.lifecycleOwner = lifecycleOwner2;
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            Pair<Integer, Integer> convertMeasureSpec = convertMeasureSpec(i);
            int intValue = convertMeasureSpec.component1().intValue();
            int intValue2 = convertMeasureSpec.component2().intValue();
            Pair<Integer, Integer> convertMeasureSpec2 = convertMeasureSpec(i2);
            long Constraints = ConstraintsKt.Constraints(intValue, intValue2, convertMeasureSpec2.component1().intValue(), convertMeasureSpec2.component2().intValue());
            Constraints constraints = this.onMeasureConstraints;
            boolean z = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m3791boximpl(Constraints);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    z = Constraints.m3796equalsimpl0(constraints.m3809unboximpl(), Constraints);
                }
                if (!z) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m3356updateRootConstraintsBRTryo0(Constraints);
            this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), BasicMeasure.EXACTLY));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
