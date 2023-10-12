package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0002\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0004\b\u0000\u0010\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u0003H\u0002\u001aa\u0010\b\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\n\"\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ag\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\n\"\u0004\u0018\u00010\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"MaxSupportedRadix", "", "mutableStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/MutableState;", "T", "", "inner", "rememberSaveable", "inputs", "", "saver", "key", "", "init", "Lkotlin/Function0;", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "stateSaver", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "requireCanBeSaved", "", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "value", "runtime-saveable_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
public final class RememberSaveableKt {
    private static final int MaxSupportedRadix = 36;

    /* JADX WARNING: type inference failed for: r10v0, types: [kotlin.jvm.functions.Function0<? extends T>, java.lang.Object, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: rememberSaveable  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T m1251rememberSaveable(java.lang.Object[] r7, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r8, java.lang.String r9, kotlin.jvm.functions.Function0<? extends T> r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            java.lang.String r12 = "inputs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r12)
            java.lang.String r12 = "init"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r12)
            r12 = 1059366159(0x3f24a50f, float:0.6431436)
            r11.startReplaceableGroup(r12)
            java.lang.String r12 = "C(rememberSaveable)P(1,3,2)79@3447L7,81@3544L244,92@4051L34,97@4212L402:RememberSaveable.kt#r2ddri"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            r12 = r13 & 2
            if (r12 == 0) goto L_0x001d
            androidx.compose.runtime.saveable.Saver r8 = androidx.compose.runtime.saveable.SaverKt.autoSaver()
        L_0x001d:
            r12 = r13 & 4
            r13 = 0
            if (r12 == 0) goto L_0x0023
            r9 = r13
        L_0x0023:
            r12 = 1059366416(0x3f24a610, float:0.6431589)
            r11.startReplaceableGroup(r12)
            java.lang.String r12 = "*74@3281L23"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            r12 = r9
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r0 = 0
            if (r12 == 0) goto L_0x003d
            int r12 = r12.length()
            if (r12 != 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r12 = 0
            goto L_0x003e
        L_0x003d:
            r12 = 1
        L_0x003e:
            if (r12 != 0) goto L_0x0041
            goto L_0x0055
        L_0x0041:
            int r9 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r0)
            int r12 = MaxSupportedRadix
            int r12 = kotlin.text.CharsKt.checkRadix(r12)
            java.lang.String r9 = java.lang.Integer.toString(r9, r12)
            java.lang.String r12 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
        L_0x0055:
            r2 = r9
            r11.endReplaceableGroup()
            java.lang.String r9 = "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>"
            java.util.Objects.requireNonNull(r8, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.runtime.saveable.SaveableStateRegistryKt.getLocalSaveableStateRegistry()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r12 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r1 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r12, r1)
            java.lang.Object r9 = r11.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r1 = r9
            androidx.compose.runtime.saveable.SaveableStateRegistry r1 = (androidx.compose.runtime.saveable.SaveableStateRegistry) r1
            int r9 = r7.length
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r9)
            r9 = -3685570(0xffffffffffc7c33e, float:NaN)
            r11.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            int r9 = r7.length
            r12 = 0
        L_0x0088:
            if (r0 >= r9) goto L_0x0094
            r3 = r7[r0]
            int r0 = r0 + 1
            boolean r3 = r11.changed((java.lang.Object) r3)
            r12 = r12 | r3
            goto L_0x0088
        L_0x0094:
            java.lang.Object r7 = r11.rememberedValue()
            if (r12 != 0) goto L_0x00a2
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r7 != r9) goto L_0x00ba
        L_0x00a2:
            if (r1 != 0) goto L_0x00a6
        L_0x00a4:
            r7 = r13
            goto L_0x00b1
        L_0x00a6:
            java.lang.Object r7 = r1.consumeRestored(r2)
            if (r7 != 0) goto L_0x00ad
            goto L_0x00a4
        L_0x00ad:
            java.lang.Object r7 = r8.restore(r7)
        L_0x00b1:
            if (r7 != 0) goto L_0x00b7
            java.lang.Object r7 = r10.invoke()
        L_0x00b7:
            r11.updateRememberedValue(r7)
        L_0x00ba:
            r11.endReplaceableGroup()
            r9 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            java.lang.Object r9 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r9 != r10) goto L_0x00dc
            r9 = 2
            androidx.compose.runtime.MutableState r9 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r8, r13, r9, r13)
            r11.updateRememberedValue(r9)
        L_0x00dc:
            r11.endReplaceableGroup()
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            r9.setValue(r8)
            if (r1 == 0) goto L_0x00f4
            androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1 r8 = new androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1
            r8.<init>(r1, r2, r9, r7)
            r4 = r8
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r6 = 0
            r3 = r7
            r5 = r11
            androidx.compose.runtime.EffectsKt.DisposableEffect(r1, r2, r3, r4, r5, r6)
        L_0x00f4:
            r11.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.RememberSaveableKt.m1251rememberSaveable(java.lang.Object[], androidx.compose.runtime.saveable.Saver, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [androidx.compose.runtime.saveable.Saver, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> androidx.compose.runtime.MutableState<T> rememberSaveable(java.lang.Object[] r7, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r8, java.lang.String r9, kotlin.jvm.functions.Function0<? extends androidx.compose.runtime.MutableState<T>> r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            java.lang.String r0 = "inputs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "stateSaver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "init"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1059368946(0x3f24aff2, float:0.6433097)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "C(rememberSaveable)P(1,3,2)138@5914L106:RememberSaveable.kt#r2ddri"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r13 = r13 & 4
            if (r13 == 0) goto L_0x0020
            r9 = 0
        L_0x0020:
            r2 = r9
            int r9 = r7.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r7, r9)
            androidx.compose.runtime.saveable.Saver r1 = mutableStateSaver(r8)
            r7 = r12 & 896(0x380, float:1.256E-42)
            r7 = r7 | 8
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            r5 = r7 | r8
            r6 = 0
            r3 = r10
            r4 = r11
            java.lang.Object r7 = rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            r11.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable(java.lang.Object[], androidx.compose.runtime.saveable.Saver, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.MutableState");
    }

    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(Saver<T, ? extends Object> saver) {
        return SaverKt.Saver(new RememberSaveableKt$mutableStateSaver$1$1(saver), new RememberSaveableKt$mutableStateSaver$1$2(saver));
    }

    /* access modifiers changed from: private */
    public static final void requireCanBeSaved(SaveableStateRegistry saveableStateRegistry, Object obj) {
        String str;
        if (obj != null && !saveableStateRegistry.canBeSaved(obj)) {
            if (obj instanceof SnapshotMutableState) {
                SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
                if (snapshotMutableState.getPolicy() == SnapshotStateKt.neverEqualPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.structuralEqualityPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
                    str = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                } else {
                    str = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                }
            } else {
                str = obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
            }
            throw new IllegalArgumentException(str);
        }
    }
}
