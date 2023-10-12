package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000À\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0011\n\u0002\b/\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\"\b\u0000\u0018\u00002\u00020\u0001:\u0004±\u0002²\u0002B\u0001\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012Y\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\t\u0010\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0001\u001a\u00020\u0014H\u0002JK\u0010\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u0001\"\u0005\b\u0001\u0010\u00012\b\u0010\u0001\u001a\u0003H\u00012\"\u0010\u0001\u001a\u001d\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u0001\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0003\b\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0005H\u0016J5\u0010\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u0007\u0010\u0001\u001a\u00020 2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u0001H\bø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u0014\u0010\u0001\u001a\u00020 2\t\u0010\u0001\u001a\u0004\u0018\u00010=H\u0017J\u0012\u0010\u0001\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020 H\u0017J\u0013\u0010\u0001\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0013\u0010\u0001\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0013\u0010\u0001\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0013\u0010\u0001\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0012\u0010\u0001\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020$H\u0017J\u0013\u0010\u0001\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0013\u0010\u0001\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\t\u0010\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0001\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u0014H\u0016JG\u0010\u0001\u001a\u00020\u00142\u001d\u0010\u0001\u001a\u0018\u0012\u0004\u0012\u000205\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020=\u0018\u00010\u00010\u00012\u0014\u0010 \u0001\u001a\u000f\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0003\b¡\u0001H\u0000¢\u0006\u0006\b¢\u0001\u0010£\u0001J$\u0010¤\u0001\u001a\u00020$2\u0007\u0010¥\u0001\u001a\u00020$2\u0007\u0010¦\u0001\u001a\u00020$2\u0007\u0010§\u0001\u001a\u00020$H\u0002J'\u0010¨\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u000e\u0010©\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010bH\u0017¢\u0006\u0003\u0010ª\u0001J!\u0010«\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u00012\u000f\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u0001H\u0016J)\u0010­\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0c0aj\u0002`dH\u0002J\t\u0010®\u0001\u001a\u00020\u0014H\u0016J\u000f\u0010¯\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\b°\u0001JF\u0010±\u0001\u001a\u00020\u00142\u001d\u0010\u0001\u001a\u0018\u0012\u0004\u0012\u000205\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020=\u0018\u00010\u00010\u00012\u0016\u0010 \u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0001¢\u0006\u0003\b¡\u0001H\u0002¢\u0006\u0003\u0010£\u0001J\u001b\u0010²\u0001\u001a\u00020\u00142\u0007\u0010¥\u0001\u001a\u00020$2\u0007\u0010³\u0001\u001a\u00020$H\u0002J\t\u0010´\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010µ\u0001\u001a\u00020\u00142\u0007\u0010¶\u0001\u001a\u00020 H\u0002J\t\u0010·\u0001\u001a\u00020\u0014H\u0017J\t\u0010¸\u0001\u001a\u00020\u0014H\u0002J\t\u0010¹\u0001\u001a\u00020\u0014H\u0017J\t\u0010º\u0001\u001a\u00020\u0014H\u0016J\t\u0010»\u0001\u001a\u00020\u0014H\u0017J\t\u0010¼\u0001\u001a\u00020\u0014H\u0017J\f\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0017J\t\u0010¿\u0001\u001a\u00020\u0014H\u0016J\t\u0010À\u0001\u001a\u00020\u0014H\u0002J\t\u0010Á\u0001\u001a\u00020\u0014H\u0002J\u001d\u0010Â\u0001\u001a\u00020\u00142\u0007\u0010¶\u0001\u001a\u00020 2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010fH\u0002J\u001a\u0010Ä\u0001\u001a\u00020\u00142\u0007\u0010Å\u0001\u001a\u00020$2\u0006\u0010N\u001a\u00020 H\u0002J\t\u0010Æ\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010Ç\u0001\u001a\u00020$2\u0007\u0010È\u0001\u001a\u00020$H\u0002J\u001f\u0010É\u0001\u001a\u00020=2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010=2\t\u0010Ë\u0001\u001a\u0004\u0018\u00010=H\u0017J\u000b\u0010Ì\u0001\u001a\u0004\u0018\u00010=H\u0001J-\u0010Í\u0001\u001a\u00020$2\u0007\u0010Î\u0001\u001a\u00020$2\u0007\u0010¥\u0001\u001a\u00020$2\u0007\u0010¦\u0001\u001a\u00020$2\u0007\u0010Ï\u0001\u001a\u00020$H\u0002J\u001f\u0010Ð\u0001\u001a\u00020\u00142\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140\u0001H\u0000¢\u0006\u0003\bÑ\u0001J\t\u0010Ò\u0001\u001a\u00020\u0014H\u0002J!\u0010Ò\u0001\u001a\u00020\u00142\u0010\u0010Ó\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010=0Ô\u0001H\u0002¢\u0006\u0003\u0010Õ\u0001J\t\u0010Ö\u0001\u001a\u00020\u0014H\u0002J\u0014\u0010×\u0001\u001a\u00020\u00142\t\b\u0002\u0010Ø\u0001\u001a\u00020 H\u0002J\t\u0010Ù\u0001\u001a\u00020\u0014H\u0002J.\u0010Ú\u0001\u001a\u00020 2\u001d\u0010\u0001\u001a\u0018\u0012\u0004\u0012\u000205\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020=\u0018\u00010\u00010\u0001H\u0000¢\u0006\u0003\bÛ\u0001J\t\u0010Ü\u0001\u001a\u00020\u0014H\u0002J_\u0010Ý\u0001\u001a\u00020\u00142T\u0010Þ\u0001\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J_\u0010ß\u0001\u001a\u00020\u00142T\u0010Þ\u0001\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010à\u0001\u001a\u00020\u0014H\u0002J\u0014\u0010á\u0001\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010=H\u0002J\t\u0010â\u0001\u001a\u00020\u0014H\u0002J\t\u0010ã\u0001\u001a\u00020\u0014H\u0002J_\u0010ä\u0001\u001a\u00020\u00142T\u0010Þ\u0001\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\u0012\u0010å\u0001\u001a\u00020\u00142\u0007\u0010æ\u0001\u001a\u00020HH\u0002J_\u0010ç\u0001\u001a\u00020\u00142T\u0010Þ\u0001\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J$\u0010è\u0001\u001a\u00020\u00142\u0007\u0010é\u0001\u001a\u00020$2\u0007\u0010ê\u0001\u001a\u00020$2\u0007\u0010ë\u0001\u001a\u00020$H\u0002J\u0012\u0010ì\u0001\u001a\u00020\u00142\u0007\u0010í\u0001\u001a\u00020$H\u0002J\u001a\u0010î\u0001\u001a\u00020\u00142\u0006\u0010^\u001a\u00020$2\u0007\u0010ë\u0001\u001a\u00020$H\u0002J\u0019\u0010ï\u0001\u001a\u00020\u00142\u000e\u0010ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140\u0001H\u0016J\t\u0010ñ\u0001\u001a\u00020\u0014H\u0002J_\u0010ò\u0001\u001a\u00020\u00142T\u0010Þ\u0001\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002Jj\u0010ó\u0001\u001a\u00020\u00142\t\b\u0002\u0010Ø\u0001\u001a\u00020 2T\u0010Þ\u0001\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010ô\u0001\u001a\u00020\u0014H\u0002J$\u0010õ\u0001\u001a\u00020\u00142\u0007\u0010ö\u0001\u001a\u00020$2\u0007\u0010÷\u0001\u001a\u00020$2\u0007\u0010ø\u0001\u001a\u00020$H\u0002J\u0012\u0010ù\u0001\u001a\u00020\u00142\u0007\u0010ú\u0001\u001a\u00020sH\u0016J\t\u0010û\u0001\u001a\u00020\u0014H\u0002J\u000b\u0010ü\u0001\u001a\u0004\u0018\u00010=H\u0016JP\u0010ý\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u000e\u0010©\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010b2'\u0010ú\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0c0aj\u0002`dH\u0002¢\u0006\u0003\u0010þ\u0001J\t\u0010ÿ\u0001\u001a\u00020\u0014H\u0017J\t\u0010\u0002\u001a\u00020\u0014H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0017J\u0013\u0010\u0002\u001a\u00020\u00142\b\u0010\u0002\u001a\u00030\u0002H\u0017J\t\u0010\u0002\u001a\u00020\u0014H\u0017J\u001c\u0010\u0002\u001a\u00020\u00142\u0007\u0010©\u0001\u001a\u00020$2\b\u0010\u0002\u001a\u00030\u0002H\u0017J1\u0010\u0002\u001a\u00020\u00142\u0007\u0010©\u0001\u001a\u00020$2\t\u0010\u0002\u001a\u0004\u0018\u00010=2\u0007\u0010¶\u0001\u001a\u00020 2\t\u0010\u0002\u001a\u0004\u0018\u00010=H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0017J\u0012\u0010\u0002\u001a\u00020\u00142\u0007\u0010©\u0001\u001a\u00020$H\u0002J\u001d\u0010\u0002\u001a\u00020\u00142\u0007\u0010©\u0001\u001a\u00020$2\t\u0010\u0002\u001a\u0004\u0018\u00010=H\u0002J\u001d\u0010\u0002\u001a\u00020\u00142\u0007\u0010©\u0001\u001a\u00020$2\t\u0010\u0002\u001a\u0004\u0018\u00010=H\u0017J\t\u0010\u0002\u001a\u00020\u0014H\u0016J&\u0010\u0002\u001a\u00020\u00142\u0015\u0010\u0002\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030\u00020Ô\u0001H\u0017¢\u0006\u0003\u0010\u0002J\u001d\u0010\u0002\u001a\u00020\u00142\u0007\u0010¶\u0001\u001a\u00020 2\t\u0010\u0002\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010\u0002\u001a\u00020\u00142\u0007\u0010©\u0001\u001a\u00020$H\u0017J\u0012\u0010\u0002\u001a\u00020\u00012\u0007\u0010©\u0001\u001a\u00020$H\u0017J\u001d\u0010\u0002\u001a\u00020\u00142\u0007\u0010©\u0001\u001a\u00020$2\t\u0010\u0002\u001a\u0004\u0018\u00010=H\u0016J\t\u0010\u0002\u001a\u00020\u0014H\u0016J\t\u0010\u0002\u001a\u00020\u0014H\u0002J#\u0010\u0002\u001a\u00020 2\u0007\u0010ú\u0001\u001a\u0002052\t\u0010\u0002\u001a\u0004\u0018\u00010=H\u0000¢\u0006\u0003\b\u0002J\u0014\u0010\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010=H\u0001J(\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020$2\t\u0010\u0002\u001a\u0004\u0018\u00010=2\t\u0010\u0002\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010\u0002\u001a\u00020\u00142\u0007\u0010 \u0002\u001a\u00020$H\u0002J(\u0010¡\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020$2\t\u0010\u0002\u001a\u0004\u0018\u00010=2\t\u0010\u0002\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010¢\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020$H\u0002J\u001b\u0010£\u0002\u001a\u00020\u00142\u0007\u0010¥\u0001\u001a\u00020$2\u0007\u0010ë\u0001\u001a\u00020$H\u0002J\u001b\u0010¤\u0002\u001a\u00020\u00142\u0007\u0010¥\u0001\u001a\u00020$2\u0007\u0010¥\u0002\u001a\u00020$H\u0002J{\u0010¦\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0c0aj\u0002`d2'\u0010§\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0c0aj\u0002`d2'\u0010¨\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0c0aj\u0002`dH\u0002J\u0014\u0010©\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010=H\u0016J\u0014\u0010ª\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010=H\u0001J\u0012\u0010«\u0002\u001a\u00020$2\u0007\u0010¥\u0001\u001a\u00020$H\u0002J\t\u0010¬\u0002\u001a\u00020\u0014H\u0016J\t\u0010­\u0002\u001a\u00020\u0014H\u0002J\t\u0010®\u0002\u001a\u00020\u0014H\u0002J\u0016\u0010¯\u0002\u001a\u00020$*\u00020q2\u0007\u0010¥\u0001\u001a\u00020$H\u0002J\u0018\u0010°\u0002\u001a\u0004\u0018\u00010=*\u00020q2\u0007\u0010È\u0001\u001a\u00020$H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8@X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8@X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&Ra\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R&\u00100\u001a\u00020$2\u0006\u0010/\u001a\u00020$8\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b1\u00102\u001a\u0004\b3\u0010&R\u0016\u00104\u001a\u0004\u0018\u0001058@X\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u00020 8VX\u0004¢\u0006\f\u0012\u0004\b9\u00102\u001a\u0004\b:\u0010\"R\u0016\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020?X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010B\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bC\u0010\"R\u0014\u0010D\u001a\u00020 8@X\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\"R\u000e\u0010F\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u000e¢\u0006\u0002\n\u0000Ra\u0010I\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LRa\u0010M\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150<X\u0004¢\u0006\u0002\n\u0000R&\u0010N\u001a\u00020 2\u0006\u0010/\u001a\u00020 8\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\bO\u00102\u001a\u0004\bP\u0010\"R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u0002050<X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010T\u001a\u00020 2\u0006\u0010/\u001a\u00020 @BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\"R\u001e\u0010V\u001a\u00020 2\u0006\u0010/\u001a\u00020 @BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\"R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u000e¢\u0006\u0002\n\u0000R.\u0010Z\u001a\"\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0018\u00010[j\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0018\u0001`\\X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020?X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R.\u0010`\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0c0aj\u0002`dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000Rj\u0010m\u001a^\u0012\u0004\u0012\u00020$\u0012$\u0012\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0c0aj\u0002`d0[j.\u0012\u0004\u0012\u00020$\u0012$\u0012\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0c0aj\u0002`d`\\X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020qX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010r\u001a\u0004\u0018\u00010s8VX\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u000e\u0010v\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010x\u001a\u00020 8VX\u0004¢\u0006\f\u0012\u0004\by\u00102\u001a\u0004\bz\u0010\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u0004\u0018\u00010=*\u00020q8BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006³\u0002"}, d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Ljava/util/List;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "childrenComposing", "collectParameterInformation", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "()V", "getCompoundKeyHash", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "downNodes", "Landroidx/compose/runtime/Stack;", "", "entersStack", "Landroidx/compose/runtime/IntStack;", "groupNodeCount", "groupNodeCountStack", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "hasProvider", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "insertUpFixups", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "invalidations", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nodeExpected", "nodeIndex", "nodeIndexStack", "parentProvider", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "pendingUps", "previousCount", "previousMoveFrom", "previousMoveTo", "previousRemove", "providerUpdates", "providersInvalid", "providersInvalidStack", "reader", "Landroidx/compose/runtime/SlotReader;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "startedGroup", "startedGroups", "writer", "writersReaderDelta", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "addRecomposeScope", "apply", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "cleanUpCompose", "clearUpdatedNodeCounts", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", "key", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createNode", "factory", "currentCompositionLocalScope", "disableReusing", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endRoot", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "insertedGroupVirtualIndex", "index", "joinKey", "left", "right", "nextSlot", "nodeIndexOf", "groupLocation", "recomposeIndex", "prepareCompose", "prepareCompose$runtime_release", "realizeDowns", "nodes", "", "([Ljava/lang/Object;)V", "realizeMovement", "realizeOperationLocation", "forParent", "realizeUps", "recompose", "recompose$runtime_release", "recomposeToGroupEnd", "record", "change", "recordApplierOperation", "recordDelete", "recordDown", "recordEndGroup", "recordEndRoot", "recordFixup", "recordInsert", "anchor", "recordInsertUpFixup", "recordMoveNode", "from", "to", "count", "recordReaderMoving", "location", "recordRemoveNode", "recordSideEffect", "effect", "recordSlotEditing", "recordSlotEditingOperation", "recordSlotTableOperation", "recordUp", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "registerInsertUpFixup", "rememberedValue", "resolveCompositionLocal", "(Landroidx/compose/runtime/CompositionLocal;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)Ljava/lang/Object;", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "start", "objectKey", "data", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProviders", "values", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Composer.kt */
public final class ComposerImpl implements Composer {
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    /* access modifiers changed from: private */
    public int childrenComposing;
    private boolean collectParameterInformation;
    private final ControlledComposition composition;
    private int compoundKeyHash;
    private Stack<Object> downNodes;
    private final IntStack entersStack = new IntStack();
    private int groupNodeCount;
    private IntStack groupNodeCountStack = new IntStack();
    private boolean hasProvider;
    private Anchor insertAnchor;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertFixups;
    private final SlotTable insertTable;
    private final Stack<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertUpFixups;
    private boolean inserting;
    private final Stack<RecomposeScopeImpl> invalidateStack = new Stack<>();
    private final List<Invalidation> invalidations = new ArrayList();
    private boolean isComposing;
    private boolean isDisposed;
    private int[] nodeCountOverrides;
    private HashMap<Integer, Integer> nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private IntStack nodeIndexStack = new IntStack();
    /* access modifiers changed from: private */
    public final CompositionContext parentContext;
    private PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> parentProvider = ExtensionsKt.persistentHashMapOf();
    private Pending pending;
    private final Stack<Pending> pendingStack = new Stack<>();
    private int pendingUps;
    private int previousCount;
    private int previousMoveFrom;
    private int previousMoveTo;
    private int previousRemove;
    private final HashMap<Integer, PersistentMap<CompositionLocal<Object>, State<Object>>> providerUpdates = new HashMap<>();
    private boolean providersInvalid;
    private final IntStack providersInvalidStack = new IntStack();
    private SlotReader reader;
    private boolean reusing;
    private int reusingGroup = -1;
    /* access modifiers changed from: private */
    public final SlotTable slotTable;
    private Snapshot snapshot = SnapshotKt.currentSnapshot();
    private boolean startedGroup;
    private final IntStack startedGroups;
    private SlotWriter writer;
    private int writersReaderDelta;

    @InternalComposeApi
    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    private final int insertedGroupVirtualIndex(int i) {
        return -2 - i;
    }

    /* JADX INFO: finally extract failed */
    public ComposerImpl(Applier<?> applier2, CompositionContext compositionContext, SlotTable slotTable2, Set<RememberObserver> set, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list, ControlledComposition controlledComposition) {
        Intrinsics.checkNotNullParameter(applier2, "applier");
        Intrinsics.checkNotNullParameter(compositionContext, "parentContext");
        Intrinsics.checkNotNullParameter(slotTable2, "slotTable");
        Intrinsics.checkNotNullParameter(set, "abandonSet");
        Intrinsics.checkNotNullParameter(list, "changes");
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        this.applier = applier2;
        this.parentContext = compositionContext;
        this.slotTable = slotTable2;
        this.abandonSet = set;
        this.changes = list;
        this.composition = controlledComposition;
        SlotReader openReader = slotTable2.openReader();
        openReader.close();
        this.reader = openReader;
        SlotTable slotTable3 = new SlotTable();
        this.insertTable = slotTable3;
        SlotWriter openWriter = slotTable3.openWriter();
        openWriter.close();
        this.writer = openWriter;
        SlotReader openReader2 = slotTable3.openReader();
        try {
            Anchor anchor = openReader2.anchor(0);
            openReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new ArrayList();
            this.downNodes = new Stack<>();
            this.startedGroups = new IntStack();
            this.insertUpFixups = new Stack<>();
            this.previousRemove = -1;
            this.previousMoveFrom = -1;
            this.previousMoveTo = -1;
        } catch (Throwable th) {
            openReader2.close();
            throw th;
        }
    }

    public Applier<?> getApplier() {
        return this.applier;
    }

    public ControlledComposition getComposition() {
        return this.composition;
    }

    public final boolean isComposing$runtime_release() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime_release() {
        return this.isDisposed;
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return !this.changes.isEmpty();
    }

    public final SlotTable getInsertTable$runtime_release() {
        return this.insertTable;
    }

    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext$runtime_release();
    }

    @ComposeCompilerApi
    public void startReplaceableGroup(int i) {
        start(i, (Object) null, false, (Object) null);
    }

    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @ComposeCompilerApi
    public void startDefaults() {
        start(-127, (Object) null, false, (Object) null);
    }

    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getUsed()) {
            currentRecomposeScope$runtime_release.setDefaultsInScope(true);
        }
    }

    public boolean getDefaultsInvalid() {
        if (!this.providersInvalid) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            return currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getDefaultsInvalid();
        }
    }

    @ComposeCompilerApi
    public void startMovableGroup(int i, Object obj) {
        start(i, obj, false, (Object) null);
    }

    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    private final void startRoot() {
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed((Object) this.parentProvider);
        if (!this.collectParameterInformation) {
            this.collectParameterInformation = this.parentContext.getCollectingParameterInformation$runtime_release();
        }
        Set set = (Set) resolveCompositionLocal(InspectionTablesKt.getLocalInspectionTables(), this.parentProvider);
        if (set != null) {
            set.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(set);
        }
        startGroup(this.parentContext.getCompoundHashKey$runtime_release());
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        recordEndRoot();
        finalizeCompose();
        this.reader.close();
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.nodeIndexStack.clear();
        this.groupNodeCountStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.reader.close();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.isComposing = false;
    }

    public boolean getInserting() {
        return this.inserting;
    }

    public boolean getSkipping() {
        if (!getInserting() && !this.reusing && !this.providersInvalid) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            if (currentRecomposeScope$runtime_release != null && !currentRecomposeScope$runtime_release.getRequiresRecompose()) {
                return true;
            }
        }
        return false;
    }

    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    public void collectParameterInformation() {
        this.collectParameterInformation = true;
    }

    private final void startGroup(int i) {
        start(i, (Object) null, false, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void startGroup(int i, Object obj) {
        start(i, obj, false, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void endGroup() {
        end(false);
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    public void startNode() {
        int i = 126;
        if (getInserting() || (!this.reusing ? this.reader.getGroupKey() != 126 : this.reader.getGroupKey() != 125)) {
            i = 125;
        }
        start(i, (Object) null, true, (Object) null);
        this.nodeExpected = true;
    }

    public void startReusableNode() {
        start(125, (Object) null, true, (Object) null);
        this.nodeExpected = true;
    }

    public <T> void createNode(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        validateNodeExpected();
        if (getInserting()) {
            int peek = this.nodeIndexStack.peek();
            SlotWriter slotWriter = this.writer;
            Anchor anchor = slotWriter.anchor(slotWriter.getParent());
            this.groupNodeCount++;
            recordFixup(new ComposerImpl$createNode$2(function0, anchor, peek));
            recordInsertUpFixup(new ComposerImpl$createNode$3(anchor, peek));
            return;
        }
        ComposerKt.composeRuntimeError("createNode() can only be called when inserting".toString());
        throw new KotlinNothingValueException();
    }

    public void useNode() {
        validateNodeExpected();
        if (!getInserting()) {
            recordDown(getNode(this.reader));
        } else {
            ComposerKt.composeRuntimeError("useNode() called while inserting".toString());
            throw new KotlinNothingValueException();
        }
    }

    public void endNode() {
        end(true);
    }

    public void startReusableGroup(int i, Object obj) {
        if (this.reader.getGroupKey() == i && !Intrinsics.areEqual(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        start(i, (Object) null, false, obj);
    }

    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public void disableReusing() {
        this.reusing = false;
    }

    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    public <V, T> void apply(V v, Function2<? super T, ? super V, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        Function3 composerImpl$apply$operation$1 = new ComposerImpl$apply$operation$1(function2, v);
        if (getInserting()) {
            recordFixup(composerImpl$apply$operation$1);
        } else {
            recordApplierOperation(composerImpl$apply$operation$1);
        }
    }

    @ComposeCompilerApi
    public Object joinKey(Object obj, Object obj2) {
        Object access$getKey = ComposerKt.getKey(this.reader.getGroupObjectKey(), obj, obj2);
        return access$getKey == null ? new JoinedKey(obj, obj2) : access$getKey;
    }

    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        return this.reusing ? Composer.Companion.getEmpty() : this.reader.next();
    }

    @ComposeCompilerApi
    public boolean changed(Object obj) {
        if (Intrinsics.areEqual(nextSlot(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(char c) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Character) && c == ((Character) nextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(c));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(byte b) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Byte) && b == ((Number) nextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(b));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(short s) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Short) && s == ((Number) nextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(s));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(boolean z) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Boolean) && z == ((Boolean) nextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(float f) {
        Object nextSlot = nextSlot();
        if (nextSlot instanceof Float) {
            if (f == ((Number) nextSlot).floatValue()) {
                return false;
            }
        }
        updateValue(Float.valueOf(f));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(long j) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Long) && j == ((Number) nextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(double d) {
        Object nextSlot = nextSlot();
        if (nextSlot instanceof Double) {
            if (d == ((Number) nextSlot).doubleValue()) {
                return false;
            }
        }
        updateValue(Double.valueOf(d));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(int i) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Integer) && i == ((Number) nextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(i));
        return true;
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean z, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        T nextSlot = nextSlot();
        if (nextSlot != Composer.Companion.getEmpty() && !z) {
            return nextSlot;
        }
        T invoke = function0.invoke();
        updateValue(invoke);
        return invoke;
    }

    public final void updateValue(Object obj) {
        if (getInserting()) {
            this.writer.update(obj);
            if (obj instanceof RememberObserver) {
                record(new ComposerImpl$updateValue$1(obj));
                this.abandonSet.add(obj);
                return;
            }
            return;
        }
        int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
        if (obj instanceof RememberObserver) {
            this.abandonSet.add(obj);
        }
        recordSlotTableOperation(true, new ComposerImpl$updateValue$2(obj, groupSlotIndex));
    }

    public final void updateCachedValue(Object obj) {
        updateValue(obj);
    }

    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    public void recordSideEffect(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "effect");
        record(new ComposerImpl$recordSideEffect$1(function0));
    }

    private final PersistentMap<CompositionLocal<Object>, State<Object>> currentCompositionLocalScope() {
        if (getInserting() && this.hasProvider) {
            int parent = this.writer.getParent();
            while (parent > 0) {
                if (this.writer.groupKey(parent) != 202 || !Intrinsics.areEqual(this.writer.groupObjectKey(parent), ComposerKt.getCompositionLocalMap())) {
                    parent = this.writer.parent(parent);
                } else {
                    Object groupAux = this.writer.groupAux(parent);
                    Objects.requireNonNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
                    return (PersistentMap) groupAux;
                }
            }
        }
        if (this.slotTable.getGroupsSize() > 0) {
            int parent2 = this.reader.getParent();
            while (parent2 > 0) {
                if (this.reader.groupKey(parent2) != 202 || !Intrinsics.areEqual(this.reader.groupObjectKey(parent2), ComposerKt.getCompositionLocalMap())) {
                    parent2 = this.reader.parent(parent2);
                } else {
                    PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap = this.providerUpdates.get(Integer.valueOf(parent2));
                    if (persistentMap != null) {
                        return persistentMap;
                    }
                    Object groupAux2 = this.reader.groupAux(parent2);
                    Objects.requireNonNull(groupAux2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
                    return (PersistentMap) groupAux2;
                }
            }
        }
        return this.parentProvider;
    }

    @InternalComposeApi
    public void startProviders(ProvidedValue<?>[] providedValueArr) {
        PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap;
        boolean z;
        Intrinsics.checkNotNullParameter(providedValueArr, "values");
        PersistentMap<CompositionLocal<Object>, State<Object>> currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        startGroup(203, ComposerKt.getProviderValues());
        PersistentMap persistentMap2 = (PersistentMap) ComposerKt.invokeComposableForResult(this, new ComposerImpl$startProviders$currentProviders$1(providedValueArr, currentCompositionLocalScope));
        endGroup();
        if (getInserting()) {
            persistentMap = updateProviderMapGroup(currentCompositionLocalScope, persistentMap2);
            this.hasProvider = true;
        } else {
            Object groupGet = this.reader.groupGet(0);
            Objects.requireNonNull(groupGet, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap3 = (PersistentMap) groupGet;
            Object groupGet2 = this.reader.groupGet(1);
            Objects.requireNonNull(groupGet2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            PersistentMap persistentMap4 = (PersistentMap) groupGet2;
            if (!getSkipping() || !Intrinsics.areEqual((Object) persistentMap4, (Object) persistentMap2)) {
                persistentMap = updateProviderMapGroup(currentCompositionLocalScope, persistentMap2);
                z = !Intrinsics.areEqual((Object) persistentMap, (Object) persistentMap3);
                if (z && !getInserting()) {
                    this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMap);
                }
                this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
                this.providersInvalid = z;
                start(202, ComposerKt.getCompositionLocalMap(), false, persistentMap);
            }
            skipGroup();
            persistentMap = persistentMap3;
        }
        z = false;
        this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMap);
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z;
        start(202, ComposerKt.getCompositionLocalMap(), false, persistentMap);
    }

    @InternalComposeApi
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
    }

    @InternalComposeApi
    public <T> T consume(CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNullParameter(compositionLocal, "key");
        return resolveCompositionLocal(compositionLocal, currentCompositionLocalScope());
    }

    public CompositionContext buildContext() {
        startGroup(ComposerKt.referenceKey, ComposerKt.getReference());
        Object nextSlot = nextSlot();
        CompositionContextHolder compositionContextHolder = nextSlot instanceof CompositionContextHolder ? (CompositionContextHolder) nextSlot : null;
        if (compositionContextHolder == null) {
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(this, getCompoundKeyHash(), this.collectParameterInformation));
            updateValue(compositionContextHolder);
        }
        compositionContextHolder.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return compositionContextHolder.getRef();
    }

    private final <T> T resolveCompositionLocal(CompositionLocal<T> compositionLocal, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        if (ComposerKt.contains(persistentMap, compositionLocal)) {
            return ComposerKt.getValueOf(persistentMap, compositionLocal);
        }
        return compositionLocal.getDefaultValueHolder$runtime_release().getValue();
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.size();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack<RecomposeScopeImpl> stack = this.invalidateStack;
        if (this.childrenComposing != 0 || !stack.isNotEmpty()) {
            return null;
        }
        return stack.peek();
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter openWriter = this.insertTable.openWriter();
            this.writer = openWriter;
            openWriter.skipToGroupEnd();
            this.hasProvider = false;
        }
    }

    private final void startReaderGroup(boolean z, Object obj) {
        if (z) {
            this.reader.startNode();
            return;
        }
        if (!(obj == null || this.reader.getGroupAux() == obj)) {
            recordSlotTableOperation$default(this, false, new ComposerImpl$startReaderGroup$1(obj), 1, (Object) null);
        }
        this.reader.startGroup();
    }

    private final void start(int i, Object obj, boolean z, Object obj2) {
        int i2;
        validateNodeNotExpected();
        updateCompoundKeyWhenWeEnterGroup(i, obj, obj2);
        Pending pending2 = null;
        if (getInserting()) {
            this.reader.beginEmpty();
            int currentGroup = this.writer.getCurrentGroup();
            if (z) {
                this.writer.startNode(Composer.Companion.getEmpty());
            } else if (obj2 != null) {
                SlotWriter slotWriter = this.writer;
                if (obj == null) {
                    obj = Composer.Companion.getEmpty();
                }
                slotWriter.startData(i, obj, obj2);
            } else {
                SlotWriter slotWriter2 = this.writer;
                if (obj == null) {
                    obj = Composer.Companion.getEmpty();
                }
                slotWriter2.startGroup(i, obj);
            }
            Pending pending3 = this.pending;
            if (pending3 != null) {
                KeyInfo keyInfo = new KeyInfo(i, -1, insertedGroupVirtualIndex(currentGroup), -1, 0);
                pending3.registerInsert(keyInfo, this.nodeIndex - pending3.getStartIndex());
                pending3.recordUsed(keyInfo);
            }
            enterGroup(z, (Pending) null);
            return;
        }
        if (this.pending == null) {
            if (this.reader.getGroupKey() != i || !Intrinsics.areEqual(obj, this.reader.getGroupObjectKey())) {
                this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
            } else {
                startReaderGroup(z, obj2);
            }
        }
        Pending pending4 = this.pending;
        if (pending4 != null) {
            KeyInfo next = pending4.getNext(i, obj);
            if (next != null) {
                pending4.recordUsed(next);
                int location = next.getLocation();
                this.nodeIndex = pending4.nodePositionOf(next) + pending4.getStartIndex();
                int slotPositionOf = pending4.slotPositionOf(next);
                int groupIndex = slotPositionOf - pending4.getGroupIndex();
                pending4.registerMoveSlot(slotPositionOf, pending4.getGroupIndex());
                recordReaderMoving(location);
                this.reader.reposition(location);
                if (groupIndex > 0) {
                    recordSlotEditingOperation(new ComposerImpl$start$2(groupIndex));
                }
                startReaderGroup(z, obj2);
            } else {
                this.reader.beginEmpty();
                this.inserting = true;
                ensureWriter();
                this.writer.beginInsert();
                int currentGroup2 = this.writer.getCurrentGroup();
                if (z) {
                    this.writer.startNode(Composer.Companion.getEmpty());
                } else if (obj2 != null) {
                    SlotWriter slotWriter3 = this.writer;
                    if (obj == null) {
                        obj = Composer.Companion.getEmpty();
                    }
                    slotWriter3.startData(i, obj, obj2);
                } else {
                    SlotWriter slotWriter4 = this.writer;
                    if (obj == null) {
                        obj = Composer.Companion.getEmpty();
                    }
                    slotWriter4.startGroup(i, obj);
                }
                this.insertAnchor = this.writer.anchor(currentGroup2);
                KeyInfo keyInfo2 = new KeyInfo(i, -1, insertedGroupVirtualIndex(currentGroup2), -1, 0);
                pending4.registerInsert(keyInfo2, this.nodeIndex - pending4.getStartIndex());
                pending4.recordUsed(keyInfo2);
                List arrayList = new ArrayList();
                if (z) {
                    i2 = 0;
                } else {
                    i2 = this.nodeIndex;
                }
                pending2 = new Pending(arrayList, i2);
            }
        }
        enterGroup(z, pending2);
    }

    private final void enterGroup(boolean z, Pending pending2) {
        this.pendingStack.push(this.pending);
        this.pending = pending2;
        this.nodeIndexStack.push(this.nodeIndex);
        if (z) {
            this.nodeIndex = 0;
        }
        this.groupNodeCountStack.push(this.groupNodeCount);
        this.groupNodeCount = 0;
    }

    private final void exitGroup(int i, boolean z) {
        Pending pop = this.pendingStack.pop();
        if (pop != null && !z) {
            pop.setGroupIndex(pop.getGroupIndex() + 1);
        }
        this.pending = pop;
        this.nodeIndex = this.nodeIndexStack.pop() + i;
        this.groupNodeCount = this.groupNodeCountStack.pop() + i;
    }

    private final void end(boolean z) {
        List<KeyInfo> list;
        if (getInserting()) {
            int parent = this.writer.getParent();
            updateCompoundKeyWhenWeExitGroup(this.writer.groupKey(parent), this.writer.groupObjectKey(parent), this.writer.groupAux(parent));
        } else {
            int parent2 = this.reader.getParent();
            updateCompoundKeyWhenWeExitGroup(this.reader.groupKey(parent2), this.reader.groupObjectKey(parent2), this.reader.groupAux(parent2));
        }
        int i = this.groupNodeCount;
        Pending pending2 = this.pending;
        int i2 = 0;
        if (pending2 != null && pending2.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = pending2.getKeyInfos();
            List<KeyInfo> used = pending2.getUsed();
            Set<T> fastToSet = ListUtilsKt.fastToSet(used);
            Set linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < size2) {
                KeyInfo keyInfo = keyInfos.get(i3);
                if (!fastToSet.contains(keyInfo)) {
                    recordRemoveNode(pending2.nodePositionOf(keyInfo) + pending2.getStartIndex(), keyInfo.getNodes());
                    pending2.updateNodeCount(keyInfo.getLocation(), i2);
                    recordReaderMoving(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    ComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), keyInfo.getLocation() + this.reader.groupSize(keyInfo.getLocation()));
                } else if (!linkedHashSet.contains(keyInfo)) {
                    if (i4 < size) {
                        KeyInfo keyInfo2 = used.get(i4);
                        if (keyInfo2 != keyInfo) {
                            int nodePositionOf = pending2.nodePositionOf(keyInfo2);
                            linkedHashSet.add(keyInfo2);
                            if (nodePositionOf != i5) {
                                int updatedNodeCountOf = pending2.updatedNodeCountOf(keyInfo2);
                                list = used;
                                recordMoveNode(pending2.getStartIndex() + nodePositionOf, i5 + pending2.getStartIndex(), updatedNodeCountOf);
                                pending2.registerMoveNode(nodePositionOf, i5, updatedNodeCountOf);
                            } else {
                                list = used;
                            }
                        } else {
                            list = used;
                            i3++;
                        }
                        i4++;
                        i5 += pending2.updatedNodeCountOf(keyInfo2);
                        used = list;
                    }
                    i2 = 0;
                }
                i3++;
                i2 = 0;
            }
            realizeMovement();
            if (keyInfos.size() > 0) {
                recordReaderMoving(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int i6 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            recordRemoveNode(i6, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        boolean inserting2 = getInserting();
        if (inserting2) {
            if (z) {
                registerInsertUpFixup();
                i = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int insertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close();
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(insertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(insertedGroupVirtualIndex, i);
                }
            }
        } else {
            if (z) {
                recordUp();
            }
            recordEndGroup();
            int parent4 = this.reader.getParent();
            if (i != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i);
            }
            if (z) {
                i = 1;
            }
            this.reader.endGroup();
            realizeMovement();
        }
        exitGroup(i, inserting2);
    }

    private final void recomposeToGroupEnd() {
        boolean z = this.isComposing;
        this.isComposing = true;
        int parent = this.reader.getParent();
        int groupSize = this.reader.groupSize(parent) + parent;
        int i = this.nodeIndex;
        int compoundKeyHash2 = getCompoundKeyHash();
        int i2 = this.groupNodeCount;
        Invalidation access$firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        boolean z2 = false;
        int i3 = parent;
        while (access$firstInRange != null) {
            int location = access$firstInRange.getLocation();
            Invalidation unused = ComposerKt.removeLocation(this.invalidations, location);
            if (access$firstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i3, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i);
                this.compoundKeyHash = compoundKeyOf(this.reader.parent(currentGroup), parent, compoundKeyHash2);
                access$firstInRange.getScope().compose(this);
                this.reader.restoreParent(parent);
                i3 = currentGroup;
                z2 = true;
            } else {
                this.invalidateStack.push(access$firstInRange.getScope());
                access$firstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            access$firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        }
        if (z2) {
            recordUpsAndDowns(i3, parent, parent);
            this.reader.skipToGroupEnd();
            int updatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i + updatedNodeCount;
            this.groupNodeCount = i2 + updatedNodeCount;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = compoundKeyHash2;
        this.isComposing = z;
    }

    private final void updateNodeCountOverrides(int i, int i2) {
        int updatedNodeCount = updatedNodeCount(i);
        if (updatedNodeCount != i2) {
            int i3 = i2 - updatedNodeCount;
            int size = this.pendingStack.getSize() - 1;
            while (i != -1) {
                int updatedNodeCount2 = updatedNodeCount(i) + i3;
                updateNodeCount(i, updatedNodeCount2);
                if (size >= 0) {
                    int i4 = size;
                    while (true) {
                        int i5 = i4 - 1;
                        Pending peek = this.pendingStack.peek(i4);
                        if (peek != null && peek.updateNodeCount(i, updatedNodeCount2)) {
                            size = i4 - 1;
                            break;
                        } else if (i5 < 0) {
                            break;
                        } else {
                            i4 = i5;
                        }
                    }
                }
                if (i < 0) {
                    i = this.reader.getParent();
                } else if (!this.reader.isNode(i)) {
                    i = this.reader.parent(i);
                } else {
                    return;
                }
            }
        }
    }

    private final int nodeIndexOf(int i, int i2, int i3, int i4) {
        int i5;
        int parent = this.reader.parent(i2);
        while (i5 != i3 && !this.reader.isNode(i5)) {
            parent = this.reader.parent(i5);
        }
        if (this.reader.isNode(i5)) {
            i4 = 0;
        }
        if (i5 == i2) {
            return i4;
        }
        int updatedNodeCount = (updatedNodeCount(i5) - this.reader.nodeCount(i2)) + i4;
        loop1:
        while (i4 < updatedNodeCount && i5 != i) {
            i5++;
            while (true) {
                if (i5 >= i) {
                    break loop1;
                }
                int groupSize = this.reader.groupSize(i5) + i5;
                if (i >= groupSize) {
                    i4 += updatedNodeCount(i5);
                    i5 = groupSize;
                }
            }
        }
        return i4;
    }

    private final int updatedNodeCount(int i) {
        int i2;
        Integer num;
        if (i < 0) {
            HashMap<Integer, Integer> hashMap = this.nodeCountVirtualOverrides;
            if (hashMap == null || (num = hashMap.get(Integer.valueOf(i))) == null) {
                return 0;
            }
            return num.intValue();
        }
        int[] iArr = this.nodeCountOverrides;
        if (iArr == null || (i2 = iArr[i]) < 0) {
            return this.reader.nodeCount(i);
        }
        return i2;
    }

    private final void updateNodeCount(int i, int i2) {
        if (updatedNodeCount(i) == i2) {
            return;
        }
        if (i < 0) {
            HashMap<Integer, Integer> hashMap = this.nodeCountVirtualOverrides;
            if (hashMap == null) {
                HashMap<Integer, Integer> hashMap2 = new HashMap<>();
                this.nodeCountVirtualOverrides = hashMap2;
                hashMap = hashMap2;
            }
            hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
            return;
        }
        int[] iArr = this.nodeCountOverrides;
        if (iArr == null) {
            ComposerImpl composerImpl = this;
            int[] iArr2 = new int[composerImpl.reader.getSize()];
            ArraysKt.fill$default(iArr2, -1, 0, 0, 6, (Object) null);
            composerImpl.nodeCountOverrides = iArr2;
            iArr = iArr2;
        }
        iArr[i] = i2;
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final void recordUpsAndDowns(int i, int i2, int i3) {
        SlotReader slotReader = this.reader;
        int access$nearestCommonRootOf = ComposerKt.nearestCommonRootOf(slotReader, i, i2, i3);
        while (i > 0 && i != access$nearestCommonRootOf) {
            if (slotReader.isNode(i)) {
                recordUp();
            }
            i = slotReader.parent(i);
        }
        doRecordDownsFor(i2, access$nearestCommonRootOf);
    }

    private final void doRecordDownsFor(int i, int i2) {
        if (i > 0 && i != i2) {
            doRecordDownsFor(this.reader.parent(i), i2);
            if (this.reader.isNode(i)) {
                recordDown(nodeAt(this.reader, i));
            }
        }
    }

    private final int compoundKeyOf(int i, int i2, int i3) {
        return i == i2 ? i3 : Integer.rotateLeft(compoundKeyOf(this.reader.parent(i), i2, i3), 3) ^ groupCompoundKeyPart(this.reader, i);
    }

    private final int groupCompoundKeyPart(SlotReader slotReader, int i) {
        Object groupAux;
        if (slotReader.hasObjectKey(i)) {
            Object groupObjectKey = slotReader.groupObjectKey(i);
            if (groupObjectKey == null) {
                return 0;
            }
            return groupObjectKey instanceof Enum ? ((Enum) groupObjectKey).ordinal() : groupObjectKey.hashCode();
        }
        int groupKey = slotReader.groupKey(i);
        if (groupKey == 207 && (groupAux = slotReader.groupAux(i)) != null && !Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
            groupKey = groupAux.hashCode();
        }
        return groupKey;
    }

    public final boolean tryImminentInvalidation$runtime_release(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = anchor.toIndexFor(this.slotTable);
        if (!this.isComposing || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, indexFor, recomposeScopeImpl, obj);
        return true;
    }

    @ComposeCompilerApi
    public void skipCurrentGroup() {
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        Object groupObjectKey = slotReader.getGroupObjectKey();
        Object groupAux = slotReader.getGroupAux();
        updateCompoundKeyWhenWeEnterGroup(groupKey, groupObjectKey, groupAux);
        startReaderGroup(slotReader.isNode(), (Object) null);
        recomposeToGroupEnd();
        slotReader.endGroup();
        updateCompoundKeyWhenWeExitGroup(groupKey, groupObjectKey, groupAux);
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (this.groupNodeCount == 0) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            if (currentRecomposeScope$runtime_release != null) {
                currentRecomposeScope$runtime_release.scopeSkipped();
            }
            if (this.invalidations.isEmpty()) {
                skipReaderToGroupEnd();
            } else {
                recomposeToGroupEnd();
            }
        } else {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling skipAndEndGroup".toString());
            throw new KotlinNothingValueException();
        }
    }

    @ComposeCompilerApi
    public Composer startRestartGroup(int i) {
        start(i, (Object) null, false, (Object) null);
        addRecomposeScope();
        return this;
    }

    private final void addRecomposeScope() {
        if (getInserting()) {
            RecomposeScopeImpl recomposeScopeImpl = new RecomposeScopeImpl((CompositionImpl) getComposition());
            this.invalidateStack.push(recomposeScopeImpl);
            updateValue(recomposeScopeImpl);
            recomposeScopeImpl.start(this.snapshot.getId());
            return;
        }
        Invalidation access$removeLocation = ComposerKt.removeLocation(this.invalidations, this.reader.getParent());
        Object next = this.reader.next();
        Objects.requireNonNull(next, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) next;
        recomposeScopeImpl2.setRequiresRecompose(access$removeLocation != null);
        this.invalidateStack.push(recomposeScopeImpl2);
        recomposeScopeImpl2.start(this.snapshot.getId());
    }

    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        Anchor anchor;
        Function1<Composition, Unit> end;
        RecomposeScopeImpl pop = this.invalidateStack.isNotEmpty() ? this.invalidateStack.pop() : null;
        if (pop != null) {
            pop.setRequiresRecompose(false);
        }
        if (!(pop == null || (end = pop.end(this.snapshot.getId())) == null)) {
            record(new ComposerImpl$endRestartGroup$1$1(end, this));
        }
        if (pop == null || pop.getSkipped$runtime_release() || (!pop.getUsed() && !this.collectParameterInformation)) {
            pop = null;
        } else {
            if (pop.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                pop.setAnchor(anchor);
            }
            pop.setDefaultsInvalid(false);
        }
        end(false);
        return pop;
    }

    @ComposeCompilerApi
    public void sourceInformation(String str) {
        Intrinsics.checkNotNullParameter(str, "sourceInformation");
        if (getInserting()) {
            this.writer.insertAux(str);
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "sourceInformation");
        start(i, (Object) null, false, str);
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        end(false);
    }

    public final void composeContent$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(identityArrayMap, "invalidationsRequested");
        Intrinsics.checkNotNullParameter(function2, "content");
        if (this.changes.isEmpty()) {
            doCompose(identityArrayMap, function2);
        } else {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void prepareCompose$runtime_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!this.isComposing) {
            this.isComposing = true;
            try {
                function0.invoke();
            } finally {
                this.isComposing = false;
            }
        } else {
            ComposerKt.composeRuntimeError("Preparing a composition while composing is not supported".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean recompose$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap) {
        Intrinsics.checkNotNullParameter(identityArrayMap, "invalidationsRequested");
        if (!this.changes.isEmpty()) {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        } else if (!identityArrayMap.isNotEmpty() && !(!this.invalidations.isEmpty())) {
            return false;
        } else {
            doCompose(identityArrayMap, (Function2<? super Composer, ? super Integer, Unit>) null);
            return !this.changes.isEmpty();
        }
    }

    private final void doCompose(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (!this.isComposing) {
            Object beginSection = Trace.INSTANCE.beginSection("Compose:recompose");
            try {
                this.snapshot = SnapshotKt.currentSnapshot();
                int size$runtime_release = identityArrayMap.getSize$runtime_release();
                int i = 0;
                while (i < size$runtime_release) {
                    int i2 = i + 1;
                    Object obj = identityArrayMap.getKeys$runtime_release()[i];
                    if (obj != null) {
                        IdentityArraySet identityArraySet = (IdentityArraySet) identityArrayMap.getValues$runtime_release()[i];
                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                        Anchor anchor = recomposeScopeImpl.getAnchor();
                        Integer valueOf = anchor == null ? null : Integer.valueOf(anchor.getLocation$runtime_release());
                        if (valueOf == null) {
                            Trace.INSTANCE.endSection(beginSection);
                            return;
                        } else {
                            this.invalidations.add(new Invalidation(recomposeScopeImpl, valueOf.intValue(), identityArraySet));
                            i = i2;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                    }
                }
                List<Invalidation> list = this.invalidations;
                if (list.size() > 1) {
                    CollectionsKt.sortWith(list, new ComposerImpl$doCompose$lambda25$$inlined$sortBy$1());
                }
                this.nodeIndex = 0;
                this.isComposing = true;
                startRoot();
                SnapshotStateKt.observeDerivedStateRecalculations(new ComposerImpl$doCompose$2$3(this), new ComposerImpl$doCompose$2$4(this), new ComposerImpl$doCompose$2$5(function2, this));
                endRoot();
                this.isComposing = false;
                this.invalidations.clear();
                this.providerUpdates.clear();
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(beginSection);
                throw th;
            }
        } else {
            ComposerKt.composeRuntimeError("Reentrant composition is not supported".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    private final Object nodeAt(SlotReader slotReader, int i) {
        return slotReader.node(i);
    }

    private final void validateNodeExpected() {
        if (this.nodeExpected) {
            this.nodeExpected = false;
        } else {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void validateNodeNotExpected() {
        if (!(!this.nodeExpected)) {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void record(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        this.changes.add(function3);
    }

    private final void recordApplierOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        realizeUps();
        realizeDowns();
        record(function3);
    }

    private final void recordSlotEditingOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        realizeOperationLocation$default(this, false, 1, (Object) null);
        recordSlotEditing();
        record(function3);
    }

    static /* synthetic */ void recordSlotTableOperation$default(ComposerImpl composerImpl, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerImpl.recordSlotTableOperation(z, function3);
    }

    private final void recordSlotTableOperation(boolean z, Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        realizeOperationLocation(z);
        record(function3);
    }

    private final void realizeUps() {
        int i = this.pendingUps;
        if (i > 0) {
            this.pendingUps = 0;
            record(new ComposerImpl$realizeUps$1(i));
        }
    }

    private final void realizeDowns(Object[] objArr) {
        record(new ComposerImpl$realizeDowns$1(objArr));
    }

    private final void realizeDowns() {
        if (this.downNodes.isNotEmpty()) {
            realizeDowns(this.downNodes.toArray());
            this.downNodes.clear();
        }
    }

    private final void recordDown(Object obj) {
        this.downNodes.push(obj);
    }

    private final void recordUp() {
        if (this.downNodes.isNotEmpty()) {
            this.downNodes.pop();
        } else {
            this.pendingUps++;
        }
    }

    static /* synthetic */ void realizeOperationLocation$default(ComposerImpl composerImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerImpl.realizeOperationLocation(z);
    }

    private final void realizeOperationLocation(boolean z) {
        int parent = z ? this.reader.getParent() : this.reader.getCurrentGroup();
        int i = parent - this.writersReaderDelta;
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Tried to seek backward".toString());
        } else if (i > 0) {
            record(new ComposerImpl$realizeOperationLocation$2(i));
            this.writersReaderDelta = parent;
        }
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            recordSlotEditingOperation(new ComposerImpl$recordInsert$1(this.insertTable, anchor));
            return;
        }
        List mutableList = CollectionsKt.toMutableList(this.insertFixups);
        this.insertFixups.clear();
        realizeUps();
        realizeDowns();
        recordSlotEditingOperation(new ComposerImpl$recordInsert$2(this.insertTable, anchor, mutableList));
    }

    private final void recordFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        this.insertFixups.add(function3);
    }

    private final void recordInsertUpFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        this.insertUpFixups.push(function3);
    }

    private final void registerInsertUpFixup() {
        this.insertFixups.add(this.insertUpFixups.pop());
    }

    private final void recordDelete() {
        recordSlotEditingOperation(ComposerKt.removeCurrentGroupInstance);
        this.writersReaderDelta += this.reader.getGroupSize();
    }

    private final void recordReaderMoving(int i) {
        this.writersReaderDelta = i - (this.reader.getCurrentGroup() - this.writersReaderDelta);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r6.reader;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void recordSlotEditing() {
        /*
            r6 = this;
            androidx.compose.runtime.SlotTable r0 = r6.slotTable
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x003a
            androidx.compose.runtime.SlotReader r0 = r6.reader
            int r1 = r0.getParent()
            androidx.compose.runtime.IntStack r2 = r6.startedGroups
            r3 = -1
            int r2 = r2.peekOr(r3)
            if (r2 == r1) goto L_0x003a
            boolean r2 = r6.startedGroup
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x0027
            kotlin.jvm.functions.Function3 r2 = androidx.compose.runtime.ComposerKt.startRootGroup
            recordSlotTableOperation$default(r6, r4, r2, r5, r3)
            r6.startedGroup = r5
        L_0x0027:
            androidx.compose.runtime.Anchor r0 = r0.anchor(r1)
            androidx.compose.runtime.IntStack r2 = r6.startedGroups
            r2.push(r1)
            androidx.compose.runtime.ComposerImpl$recordSlotEditing$1 r1 = new androidx.compose.runtime.ComposerImpl$recordSlotEditing$1
            r1.<init>(r0)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            recordSlotTableOperation$default(r6, r4, r1, r5, r3)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.recordSlotEditing():void");
    }

    private final void recordEndGroup() {
        int parent = this.reader.getParent();
        if (!(this.startedGroups.peekOr(-1) <= parent)) {
            ComposerKt.composeRuntimeError("Missed recording an endGroup".toString());
            throw new KotlinNothingValueException();
        } else if (this.startedGroups.peekOr(-1) == parent) {
            this.startedGroups.pop();
            recordSlotTableOperation$default(this, false, ComposerKt.endGroupInstance, 1, (Object) null);
        }
    }

    private final void recordEndRoot() {
        if (this.startedGroup) {
            recordSlotTableOperation$default(this, false, ComposerKt.endGroupInstance, 1, (Object) null);
            this.startedGroup = false;
        }
    }

    private final void finalizeCompose() {
        realizeUps();
        if (!this.pendingStack.isEmpty()) {
            ComposerKt.composeRuntimeError("Start/end imbalance".toString());
            throw new KotlinNothingValueException();
        } else if (this.startedGroups.isEmpty()) {
            cleanUpCompose();
        } else {
            ComposerKt.composeRuntimeError("Missed recording an endGroup()".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.writersReaderDelta = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.startedGroup = false;
        this.startedGroups.clear();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    private final void recordRemoveNode(int i, int i2) {
        if (i2 > 0) {
            if (!(i >= 0)) {
                ComposerKt.composeRuntimeError(Intrinsics.stringPlus("Invalid remove index ", Integer.valueOf(i)).toString());
                throw new KotlinNothingValueException();
            } else if (this.previousRemove == i) {
                this.previousCount += i2;
            } else {
                realizeMovement();
                this.previousRemove = i;
                this.previousCount = i2;
            }
        }
    }

    private final void recordMoveNode(int i, int i2, int i3) {
        if (i3 > 0) {
            int i4 = this.previousCount;
            if (i4 > 0 && this.previousMoveFrom == i - i4 && this.previousMoveTo == i2 - i4) {
                this.previousCount = i4 + i3;
                return;
            }
            realizeMovement();
            this.previousMoveFrom = i;
            this.previousMoveTo = i2;
            this.previousCount = i3;
        }
    }

    private final void realizeMovement() {
        int i = this.previousCount;
        this.previousCount = 0;
        if (i > 0) {
            int i2 = this.previousRemove;
            if (i2 >= 0) {
                this.previousRemove = -1;
                recordApplierOperation(new ComposerImpl$realizeMovement$1(i2, i));
                return;
            }
            int i3 = this.previousMoveFrom;
            this.previousMoveFrom = -1;
            int i4 = this.previousMoveTo;
            this.previousMoveTo = -1;
            recordApplierOperation(new ComposerImpl$realizeMovement$2(i3, i4, i));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Composer.kt */
    private static final class CompositionContextHolder implements RememberObserver {
        private final CompositionContextImpl ref;

        public void onRemembered() {
        }

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            Intrinsics.checkNotNullParameter(compositionContextImpl, "ref");
            this.ref = compositionContextImpl;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        public void onAbandoned() {
            this.ref.dispose();
        }

        public void onForgotten() {
            this.ref.dispose();
        }
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020+0/¢\u0006\u0002\b0H\u0010¢\u0006\u0004\b1\u00102J\u0006\u00103\u001a\u00020+J\r\u00104\u001a\u00020+H\u0010¢\u0006\u0002\b5J-\u0010\u0015\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u0013H\u0010¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\b8J\u0015\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020;H\u0010¢\u0006\u0002\b<J\u001b\u0010=\u001a\u00020+2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\"0\nH\u0010¢\u0006\u0002\b?J\u0015\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020BH\u0010¢\u0006\u0002\bCJ\u0015\u0010D\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\bEJ\r\u0010F\u001a\u00020+H\u0010¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020+2\u0006\u0010A\u001a\u00020BH\u0010¢\u0006\u0002\bIJ\u0015\u0010J\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\bKJ.\u0010L\u001a\u00020+2&\u0010:\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rRk\u0010\u0014\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u00132&\u0010\u000e\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u00138B@BX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8PX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\n\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001e8PX\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010 ¨\u0006M"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "(Landroidx/compose/runtime/ComposerImpl;IZ)V", "getCollectingParameterInformation$runtime_release", "()Z", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Composer.kt */
    private final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final Set<ComposerImpl> composers = new LinkedHashSet();
        private final MutableState compositionLocalScope$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExtensionsKt.persistentHashMapOf(), (SnapshotMutationPolicy) null, 2, (Object) null);
        private final int compoundHashKey;
        private Set<Set<CompositionData>> inspectionTables;
        final /* synthetic */ ComposerImpl this$0;

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }

        public CompositionContextImpl(ComposerImpl composerImpl, int i, boolean z) {
            Intrinsics.checkNotNullParameter(composerImpl, "this$0");
            this.this$0 = composerImpl;
            this.compoundHashKey = i;
            this.collectingParameterInformation = z;
        }

        public int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        public boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        public final void setInspectionTables(Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        public final void dispose() {
            if (!this.composers.isEmpty()) {
                Set<Set<CompositionData>> set = this.inspectionTables;
                if (set != null) {
                    for (ComposerImpl next : getComposers()) {
                        for (Set<CompositionData> remove : set) {
                            remove.remove(next.slotTable);
                        }
                    }
                }
                this.composers.clear();
            }
        }

        public void registerComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        public void unregisterComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (Set remove : set) {
                    remove.remove(((ComposerImpl) composer).slotTable);
                }
            }
            this.composers.remove(composer);
        }

        public void registerComposition$runtime_release(ControlledComposition controlledComposition) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            this.this$0.parentContext.registerComposition$runtime_release(controlledComposition);
        }

        public void unregisterComposition$runtime_release(ControlledComposition controlledComposition) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            this.this$0.parentContext.unregisterComposition$runtime_release(controlledComposition);
        }

        public CoroutineContext getEffectCoroutineContext$runtime_release() {
            return this.this$0.parentContext.getEffectCoroutineContext$runtime_release();
        }

        public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(this.this$0.getComposition());
        }

        public void composeInitial$runtime_release(ControlledComposition controlledComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            Intrinsics.checkNotNullParameter(function2, "content");
            this.this$0.parentContext.composeInitial$runtime_release(controlledComposition, function2);
        }

        public void invalidate$runtime_release(ControlledComposition controlledComposition) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            this.this$0.parentContext.invalidate$runtime_release(this.this$0.getComposition());
            this.this$0.parentContext.invalidate$runtime_release(controlledComposition);
        }

        public void invalidateScope$runtime_release(RecomposeScopeImpl recomposeScopeImpl) {
            Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
            this.this$0.parentContext.invalidateScope$runtime_release(recomposeScopeImpl);
        }

        private final PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope() {
            return (PersistentMap) this.compositionLocalScope$delegate.getValue();
        }

        private final void setCompositionLocalScope(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
            this.compositionLocalScope$delegate.setValue(persistentMap);
        }

        public PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        public final void updateCompositionLocalScope(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, "scope");
            setCompositionLocalScope(persistentMap);
        }

        public void recordInspectionTable$runtime_release(Set<CompositionData> set) {
            Intrinsics.checkNotNullParameter(set, "table");
            Set<Set<CompositionData>> set2 = this.inspectionTables;
            if (set2 == null) {
                set2 = new HashSet<>();
                setInspectionTables(set2);
            }
            set2.add(set);
        }

        public void startComposing$runtime_release() {
            ComposerImpl composerImpl = this.this$0;
            composerImpl.childrenComposing = composerImpl.childrenComposing + 1;
        }

        public void doneComposing$runtime_release() {
            ComposerImpl composerImpl = this.this$0;
            composerImpl.childrenComposing = composerImpl.childrenComposing - 1;
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int i, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null || i != 207 || Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                updateCompoundKeyWhenWeEnterGroupKeyHash(i);
            } else {
                updateCompoundKeyWhenWeEnterGroupKeyHash(obj2.hashCode());
            }
        } else if (obj instanceof Enum) {
            updateCompoundKeyWhenWeEnterGroupKeyHash(((Enum) obj).ordinal());
        } else {
            updateCompoundKeyWhenWeEnterGroupKeyHash(obj.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int i) {
        this.compoundKeyHash = i ^ Integer.rotateLeft(getCompoundKeyHash(), 3);
    }

    private final void updateCompoundKeyWhenWeExitGroup(int i, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null || i != 207 || Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                updateCompoundKeyWhenWeExitGroupKeyHash(i);
            } else {
                updateCompoundKeyWhenWeExitGroupKeyHash(obj2.hashCode());
            }
        } else if (obj instanceof Enum) {
            updateCompoundKeyWhenWeExitGroupKeyHash(((Enum) obj).ordinal());
        } else {
            updateCompoundKeyWhenWeExitGroupKeyHash(obj.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int i) {
        this.compoundKeyHash = Integer.rotateRight(i ^ getCompoundKeyHash(), 3);
    }

    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    public Object rememberedValue() {
        return nextSlot();
    }

    public void updateRememberedValue(Object obj) {
        updateValue(obj);
    }

    public void recordUsed(RecomposeScope recomposeScope) {
        Intrinsics.checkNotNullParameter(recomposeScope, "scope");
        RecomposeScopeImpl recomposeScopeImpl = recomposeScope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) recomposeScope : null;
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
        }
    }

    public final void dispose$runtime_release() {
        Object beginSection = Trace.INSTANCE.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            this.invalidateStack.clear();
            this.invalidations.clear();
            this.changes.clear();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(beginSection);
        }
    }

    private final PersistentMap<CompositionLocal<Object>, State<Object>> updateProviderMapGroup(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap2) {
        PersistentMap.Builder<CompositionLocal<Object>, ? extends State<? extends Object>> builder = persistentMap.builder();
        builder.putAll(persistentMap2);
        PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> build = builder.build();
        startGroup(204, ComposerKt.getProviderMaps());
        changed((Object) build);
        changed((Object) persistentMap2);
        endGroup();
        return build;
    }
}
