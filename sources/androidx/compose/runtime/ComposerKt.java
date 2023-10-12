package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.navigation.compose.ComposeNavigator;
import com.braintreepayments.api.internal.GraphQLConstants;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0010\u001a\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0000\u001ai\u0010>\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010@\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0?j\u0002`B2\u0012\u0010C\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030E0D2&\u0010F\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010@\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0?j\u0002`BH\u0003¢\u0006\u0002\u0010G\u001a(\u0010H\u001a\u0004\u0018\u00010\u00012\b\u0010I\u001a\u0004\u0018\u00010\u00012\b\u0010J\u001a\u0004\u0018\u00010\u00012\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u0002\u001a(\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020N2\u0011\u0010O\u001a\r\u0012\u0004\u0012\u00020\u00140P¢\u0006\u0002\bQH\u0000¢\u0006\u0002\u0010R\u001a.\u0010S\u001a\u0002HT\"\u0004\b\u0000\u0010T2\u0006\u0010M\u001a\u00020N2\u0011\u0010O\u001a\r\u0012\u0004\u0012\u0002HT0P¢\u0006\u0002\bQH\u0000¢\u0006\u0002\u0010U\u001aP\u0010V\u001a>\u0012\u0004\u0012\u0002HX\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HZ0Yj\b\u0012\u0004\u0012\u0002HZ`[0Wj\u001e\u0012\u0004\u0012\u0002HX\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HZ0Yj\b\u0012\u0004\u0012\u0002HZ`[`\\\"\u0004\b\u0000\u0010X\"\u0004\b\u0001\u0010ZH\u0002\u001a\u0010\u0010]\u001a\u00020\u00142\u0006\u0010I\u001a\u00020^H\u0000\u001a\"\u0010]\u001a\u00020\u00142\u0006\u0010I\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00010PH\bø\u0001\u0000\u001a\u0018\u0010`\u001a\u00020\u00142\u0006\u0010M\u001a\u00020N2\u0006\u0010`\u001a\u00020=H\u0007\u001a\u0010\u0010a\u001a\u00020\u00142\u0006\u0010M\u001a\u00020NH\u0007\u001a \u0010b\u001a\u00020\u00142\u0006\u0010M\u001a\u00020N2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010`\u001a\u00020=H\u0007\u001a\f\u0010d\u001a\u00020^*\u00020\u0007H\u0002\u001a\f\u0010e\u001a\u00020\u0007*\u00020^H\u0002\u001a1\u0010f\u001a\u0002HT\"\u0004\b\u0000\u0010T*\u00020N2\u0006\u0010g\u001a\u00020^2\f\u0010h\u001a\b\u0012\u0004\u0012\u0002HT0PH\bø\u0001\u0000¢\u0006\u0002\u0010i\u001a@\u0010j\u001a\u00020^\"\u0004\b\u0000\u0010T*\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010@\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0?j\u0002`B2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002HT0@H\u0000\u001a\u001c\u0010k\u001a\u00020\u0007*\u00020l2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0007H\u0002\u001a\u001a\u0010o\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u0007H\u0002\u001a$\u0010s\u001a\u0004\u0018\u00010q*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0007H\u0002\u001aE\u0010v\u001a\u0002HT\"\u0004\b\u0000\u0010T*\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010@\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0?j\u0002`B2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002HT0@H\u0000¢\u0006\u0002\u0010w\u001a,\u0010x\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010y\u001a\u00020z2\b\u0010{\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0001\u0010|\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010@\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0?j\u0002`B*\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010@\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0?j\u0002`B2.\u0010}\u001a*\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010@\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0\u0012\u0004\u0012\u00020\u00140~H\bø\u0001\u0000\u001a(\u0010\u0001\u001a\u00020\u0007*\u00020l2\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0002\u001a[\u0010\u0001\u001a\u0004\u0018\u0001HZ\"\u0004\b\u0000\u0010X\"\u0004\b\u0001\u0010Z*4\u0012\u0004\u0012\u0002HX\u0012\n\u0012\b\u0012\u0004\u0012\u0002HZ0Y0Wj\u001e\u0012\u0004\u0012\u0002HX\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HZ0Yj\b\u0012\u0004\u0012\u0002HZ`[`\\2\u0006\u0010c\u001a\u0002HXH\u0002¢\u0006\u0003\u0010\u0001\u001aa\u0010\u0001\u001a\u00020^\"\u0004\b\u0000\u0010X\"\u0004\b\u0001\u0010Z*4\u0012\u0004\u0012\u0002HX\u0012\n\u0012\b\u0012\u0004\u0012\u0002HZ0Y0Wj\u001e\u0012\u0004\u0012\u0002HX\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HZ0Yj\b\u0012\u0004\u0012\u0002HZ`[`\\2\u0006\u0010c\u001a\u0002HX2\u0006\u0010I\u001a\u0002HZH\u0002¢\u0006\u0003\u0010\u0001\u001ac\u0010\u0001\u001a\u0004\u0018\u00010\u0014\"\u0004\b\u0000\u0010X\"\u0004\b\u0001\u0010Z*4\u0012\u0004\u0012\u0002HX\u0012\n\u0012\b\u0012\u0004\u0012\u0002HZ0Y0Wj\u001e\u0012\u0004\u0012\u0002HX\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HZ0Yj\b\u0012\u0004\u0012\u0002HZ`[`\\2\u0006\u0010c\u001a\u0002HX2\u0006\u0010I\u001a\u0002HZH\u0002¢\u0006\u0003\u0010\u0001\u001a\u0015\u0010\u0001\u001a\u00020\u0014*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0000\u001a\u001d\u0010\u0001\u001a\u0004\u0018\u00010q*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u0007H\u0002\u001a#\u0010\u0001\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0007H\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"[\u0010\n\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000bj\u0002`\u0015X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0016\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0005\"\u0016\u0010\u0019\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0003\"\u000e\u0010\u001b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u001c\u0010\u001d\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u0005\"\u0016\u0010 \u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u0003\"\u001c\u0010\"\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\u0005\"\u0016\u0010%\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u0003\"\u001c\u0010'\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\u0005\"\u0016\u0010*\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b+\u0010\u0003\"\u001c\u0010,\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010\u0005\"\u0016\u0010/\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b0\u0010\u0003\"[\u00101\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000bj\u0002`\u0015X\u0004¢\u0006\u0002\n\u0000\"\u0016\u00102\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b3\u0010\u0003\"\u000e\u00104\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"[\u00105\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000bj\u0002`\u0015X\u0004¢\u0006\u0002\n\u0000\"\u0018\u00106\u001a\u00020\u0001*\u0002078BX\u0004¢\u0006\u0006\u001a\u0004\b8\u00109*\u0001\b\u0000\u0010\u0001\"K\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000b2K\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000b*E\b\u0000\u0010\u0001\"\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010@\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0?2\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010@\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0?\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"compositionLocalMap", "", "getCompositionLocalMap$annotations", "()V", "getCompositionLocalMap", "()Ljava/lang/Object;", "compositionLocalMapKey", "", "getCompositionLocalMapKey$annotations", "defaultsKey", "endGroupInstance", "Lkotlin/Function3;", "Landroidx/compose/runtime/Applier;", "Lkotlin/ParameterName;", "name", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "invocation", "getInvocation$annotations", "getInvocation", "invocationKey", "getInvocationKey$annotations", "nodeKey", "nodeKeyReplace", "provider", "getProvider$annotations", "getProvider", "providerKey", "getProviderKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "providerMapsKey", "getProviderMapsKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerValuesKey", "getProviderValuesKey$annotations", "reference", "getReference$annotations", "getReference", "referenceKey", "getReferenceKey$annotations", "removeCurrentGroupInstance", "reuseKey", "getReuseKey$annotations", "rootKey", "startRootGroup", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "composeRuntimeError", "", "message", "", "compositionLocalMapOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "parentScope", "([Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "getKey", "value", "left", "right", "invokeComposable", "composer", "Landroidx/compose/runtime/Composer;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)V", "invokeComposableForResult", "T", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "multiMap", "Ljava/util/HashMap;", "K", "Ljava/util/LinkedHashSet;", "V", "Lkotlin/collections/LinkedHashSet;", "Lkotlin/collections/HashMap;", "runtimeCheck", "", "lazyMessage", "sourceInformation", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "key", "asBool", "asInt", "cache", "invalid", "block", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contains", "distanceFrom", "Landroidx/compose/runtime/SlotReader;", "index", "root", "findLocation", "", "Landroidx/compose/runtime/Invalidation;", "location", "firstInRange", "start", "end", "getValueOf", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "insertIfMissing", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "mutate", "mutator", "Lkotlin/Function1;", "", "nearestCommonRootOf", "a", "b", "common", "pop", "(Ljava/util/HashMap;Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "remove", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Unit;", "removeCurrentGroup", "removeLocation", "removeRange", "Change", "CompositionLocalMap", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Composer.kt */
public final class ComposerKt {
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");
    public static final int compositionLocalMapKey = 202;
    private static final int defaultsKey = -127;
    /* access modifiers changed from: private */
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> endGroupInstance = ComposerKt$endGroupInstance$1.INSTANCE;
    private static final Object invocation = new OpaqueKey("provider");
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    private static final int nodeKeyReplace = 126;
    private static final Object provider = new OpaqueKey("provider");
    public static final int providerKey = 201;
    private static final Object providerMaps = new OpaqueKey("providers");
    public static final int providerMapsKey = 204;
    private static final Object providerValues = new OpaqueKey("providerValues");
    public static final int providerValuesKey = 203;
    private static final Object reference = new OpaqueKey("reference");
    public static final int referenceKey = 206;
    /* access modifiers changed from: private */
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> removeCurrentGroupInstance = ComposerKt$removeCurrentGroupInstance$1.INSTANCE;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;
    /* access modifiers changed from: private */
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> startRootGroup = ComposerKt$startRootGroup$1.INSTANCE;

    /* access modifiers changed from: private */
    public static final boolean asBool(int i) {
        return i != 0;
    }

    /* access modifiers changed from: private */
    public static final int asInt(boolean z) {
        return z ? 1 : 0;
    }

    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    public static /* synthetic */ void getInvocation$annotations() {
    }

    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    public static /* synthetic */ void getProvider$annotations() {
    }

    public static /* synthetic */ void getProviderKey$annotations() {
    }

    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    public static /* synthetic */ void getProviderValues$annotations() {
    }

    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    public static /* synthetic */ void getReference$annotations() {
    }

    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    public static /* synthetic */ void getReuseKey$annotations() {
    }

    public static final PersistentMap<CompositionLocal<Object>, State<Object>> mutate(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, Function1<? super Map<CompositionLocal<Object>, State<Object>>, Unit> function1) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(function1, "mutator");
        PersistentMap.Builder<CompositionLocal<Object>, ? extends State<? extends Object>> builder = persistentMap.builder();
        function1.invoke(builder);
        return builder.build();
    }

    public static final <T> boolean contains(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(compositionLocal, "key");
        return persistentMap.containsKey(compositionLocal);
    }

    public static final <T> T getValueOf(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(compositionLocal, "key");
        State state = (State) persistentMap.get(compositionLocal);
        if (state == null) {
            return null;
        }
        return state.getValue();
    }

    /* access modifiers changed from: private */
    public static final PersistentMap<CompositionLocal<Object>, State<Object>> compositionLocalMapOf(ProvidedValue<?>[] providedValueArr, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, Composer composer, int i) {
        composer.startReplaceableGroup(680852469);
        sourceInformation(composer, "C(compositionLocalMapOf)P(1)*312@11340L24:Composer.kt#9igjgp");
        PersistentMap.Builder builder = ExtensionsKt.persistentHashMapOf().builder();
        Map map = builder;
        int length = providedValueArr.length;
        int i2 = 0;
        while (i2 < length) {
            ProvidedValue<?> providedValue = providedValueArr[i2];
            i2++;
            if (providedValue.getCanOverride() || !contains(persistentMap, providedValue.getCompositionLocal())) {
                map.put(providedValue.getCompositionLocal(), providedValue.getCompositionLocal().provided$runtime_release(providedValue.getValue(), composer, 72));
            }
        }
        PersistentMap<CompositionLocal<Object>, State<Object>> build = builder.build();
        composer.endReplaceableGroup();
        return build;
    }

    @ComposeCompilerApi
    public static final <T> T cache(Composer composer, boolean z, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(composer, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        T rememberedValue = composer.rememberedValue();
        if (!z && rememberedValue != Composer.Companion.getEmpty()) {
            return rememberedValue;
        }
        T invoke = function0.invoke();
        composer.updateRememberedValue(invoke);
        return invoke;
    }

    @ComposeCompilerApi
    public static final void sourceInformation(Composer composer, String str) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(str, "sourceInformation");
        composer.sourceInformation(str);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(Composer composer, int i, String str) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(str, "sourceInformation");
        composer.sourceInformationMarkerStart(i, str);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        composer.sourceInformationMarkerEnd();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r1 = (androidx.compose.runtime.RecomposeScopeImpl) r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void removeCurrentGroup(androidx.compose.runtime.SlotWriter r4, androidx.compose.runtime.RememberManager r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "rememberManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.Iterator r0 = r4.groupSlots()
        L_0x000e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0037
            java.lang.Object r1 = r0.next()
            boolean r2 = r1 instanceof androidx.compose.runtime.RememberObserver
            if (r2 == 0) goto L_0x0022
            androidx.compose.runtime.RememberObserver r1 = (androidx.compose.runtime.RememberObserver) r1
            r5.forgetting(r1)
            goto L_0x000e
        L_0x0022:
            boolean r2 = r1 instanceof androidx.compose.runtime.RecomposeScopeImpl
            if (r2 == 0) goto L_0x000e
            androidx.compose.runtime.RecomposeScopeImpl r1 = (androidx.compose.runtime.RecomposeScopeImpl) r1
            androidx.compose.runtime.CompositionImpl r2 = r1.getComposition()
            if (r2 == 0) goto L_0x000e
            r3 = 1
            r2.setPendingInvalidScopes$runtime_release(r3)
            r2 = 0
            r1.setComposition(r2)
            goto L_0x000e
        L_0x0037:
            r4.removeGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerKt.removeCurrentGroup(androidx.compose.runtime.SlotWriter, androidx.compose.runtime.RememberManager):void");
    }

    /* access modifiers changed from: private */
    public static final <K, V> HashMap<K, LinkedHashSet<V>> multiMap() {
        return new HashMap<>();
    }

    /* access modifiers changed from: private */
    public static final <K, V> boolean put(HashMap<K, LinkedHashSet<V>> hashMap, K k, V v) {
        Map map = hashMap;
        Object obj = map.get(k);
        if (obj == null) {
            obj = new LinkedHashSet();
            map.put(k, obj);
        }
        return ((LinkedHashSet) obj).add(v);
    }

    private static final <K, V> Unit remove(HashMap<K, LinkedHashSet<V>> hashMap, K k, V v) {
        LinkedHashSet linkedHashSet = hashMap.get(k);
        if (linkedHashSet == null) {
            return null;
        }
        linkedHashSet.remove(v);
        if (linkedHashSet.isEmpty()) {
            hashMap.remove(k);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final <K, V> V pop(HashMap<K, LinkedHashSet<V>> hashMap, K k) {
        V firstOrNull;
        LinkedHashSet linkedHashSet = hashMap.get(k);
        if (linkedHashSet == null || (firstOrNull = CollectionsKt.firstOrNull(linkedHashSet)) == null) {
            return null;
        }
        remove(hashMap, k, firstOrNull);
        return firstOrNull;
    }

    /* access modifiers changed from: private */
    public static final Object getKey(Object obj, Object obj2, Object obj3) {
        JoinedKey joinedKey = obj instanceof JoinedKey ? (JoinedKey) obj : null;
        if (joinedKey == null) {
            return null;
        }
        if ((!Intrinsics.areEqual(joinedKey.getLeft(), obj2) || !Intrinsics.areEqual(joinedKey.getRight(), obj3)) && (obj = getKey(joinedKey.getLeft(), obj2, obj3)) == null) {
            obj = getKey(joinedKey.getRight(), obj2, obj3);
        }
        return obj;
    }

    private static final int findLocation(List<Invalidation> list, int i) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int compare = Intrinsics.compare(list.get(i3).getLocation(), i);
            if (compare < 0) {
                i2 = i3 + 1;
            } else if (compare <= 0) {
                return i3;
            } else {
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* access modifiers changed from: private */
    public static final void insertIfMissing(List<Invalidation> list, int i, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int findLocation = findLocation(list, i);
        IdentityArraySet identityArraySet = null;
        if (findLocation < 0) {
            int i2 = -(findLocation + 1);
            if (obj != null) {
                identityArraySet = new IdentityArraySet();
                identityArraySet.add(obj);
            }
            list.add(i2, new Invalidation(recomposeScopeImpl, i, identityArraySet));
        } else if (obj == null) {
            list.get(findLocation).setInstances((IdentityArraySet<Object>) null);
        } else {
            IdentityArraySet<Object> instances = list.get(findLocation).getInstances();
            if (instances != null) {
                instances.add(obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Invalidation firstInRange(List<Invalidation> list, int i, int i2) {
        int findLocation = findLocation(list, i);
        if (findLocation < 0) {
            findLocation = -(findLocation + 1);
        }
        if (findLocation >= list.size()) {
            return null;
        }
        Invalidation invalidation = list.get(findLocation);
        if (invalidation.getLocation() < i2) {
            return invalidation;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Invalidation removeLocation(List<Invalidation> list, int i) {
        int findLocation = findLocation(list, i);
        if (findLocation >= 0) {
            return list.remove(findLocation);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void removeRange(List<Invalidation> list, int i, int i2) {
        int findLocation = findLocation(list, i);
        if (findLocation < 0) {
            findLocation = -(findLocation + 1);
        }
        while (findLocation < list.size() && list.get(findLocation).getLocation() < i2) {
            list.remove(findLocation);
        }
    }

    public static final void invokeComposable(Composer composer, Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(function2, ComposeNavigator.NAME);
        ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(composer, 1);
    }

    public static final <T> T invokeComposableForResult(Composer composer, Function2<? super Composer, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(function2, ComposeNavigator.NAME);
        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(composer, 1);
    }

    private static final int distanceFrom(SlotReader slotReader, int i, int i2) {
        int i3 = 0;
        while (i > 0 && i != i2) {
            i = slotReader.parent(i);
            i3++;
        }
        return i3;
    }

    /* access modifiers changed from: private */
    public static final int nearestCommonRootOf(SlotReader slotReader, int i, int i2, int i3) {
        if (i == i2) {
            return i;
        }
        if (i == i3 || i2 == i3) {
            return i3;
        }
        if (slotReader.parent(i) == i2) {
            return i2;
        }
        if (slotReader.parent(i2) == i) {
            return i;
        }
        if (slotReader.parent(i) == slotReader.parent(i2)) {
            return slotReader.parent(i);
        }
        int distanceFrom = distanceFrom(slotReader, i, i3);
        int distanceFrom2 = distanceFrom(slotReader, i2, i3);
        int i4 = distanceFrom - distanceFrom2;
        int i5 = 0;
        int i6 = 0;
        while (i6 < i4) {
            i6++;
            i = slotReader.parent(i);
        }
        int i7 = distanceFrom2 - distanceFrom;
        while (i5 < i7) {
            i5++;
            i2 = slotReader.parent(i2);
        }
        while (i != i2) {
            i = slotReader.parent(i);
            i2 = slotReader.parent(i2);
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static final Object getJoinedKey(KeyInfo keyInfo) {
        return keyInfo.getObjectKey() != null ? new JoinedKey(Integer.valueOf(keyInfo.getKey()), keyInfo.getObjectKey()) : Integer.valueOf(keyInfo.getKey());
    }

    public static final Object getInvocation() {
        return invocation;
    }

    public static final Object getProvider() {
        return provider;
    }

    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    public static final Object getProviderValues() {
        return providerValues;
    }

    public static final Object getProviderMaps() {
        return providerMaps;
    }

    public static final Object getReference() {
        return reference;
    }

    public static final void runtimeCheck(boolean z, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (!z) {
            composeRuntimeError(function0.invoke().toString());
            throw new KotlinNothingValueException();
        }
    }

    public static final Void composeRuntimeError(String str) {
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.MESSAGE);
        throw new IllegalStateException(("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback").toString());
    }

    public static final void runtimeCheck(boolean z) {
        if (!z) {
            composeRuntimeError("Check failed".toString());
            throw new KotlinNothingValueException();
        }
    }
}
