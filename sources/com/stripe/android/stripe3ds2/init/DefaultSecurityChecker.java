package com.stripe.android.stripe3ds2.init;

import com.stripe.android.stripe3ds2.init.SecurityCheck;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\b\u0000\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/DefaultSecurityChecker;", "Lcom/stripe/android/stripe3ds2/init/SecurityChecker;", "securityChecks", "", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck;", "(Ljava/util/List;)V", "getWarnings", "Lcom/stripe/android/stripe3ds2/init/Warning;", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecurityChecker.kt */
public final class DefaultSecurityChecker implements SecurityChecker {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final List<SecurityCheck> DEFAULT_CHECKS = CollectionsKt.listOf(new SecurityCheck.RootedCheck(), new SecurityCheck.Tampered(), new SecurityCheck.Emulator(), new SecurityCheck.DebuggerAttached(false, 1, (DefaultConstructorMarker) null), new SecurityCheck.UnsupportedOS());
    private final List<SecurityCheck> securityChecks;

    public DefaultSecurityChecker() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public DefaultSecurityChecker(List<? extends SecurityCheck> list) {
        Intrinsics.checkNotNullParameter(list, "securityChecks");
        this.securityChecks = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultSecurityChecker(List<SecurityCheck> list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DEFAULT_CHECKS : list);
    }

    public List<Warning> getWarnings() {
        Collection arrayList = new ArrayList();
        for (Object next : this.securityChecks) {
            if (((SecurityCheck) next).check()) {
                arrayList.add(next);
            }
        }
        Iterable<SecurityCheck> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SecurityCheck warning : iterable) {
            arrayList2.add(warning.getWarning());
        }
        return (List) arrayList2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/DefaultSecurityChecker$Companion;", "", "()V", "DEFAULT_CHECKS", "", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck;", "getDEFAULT_CHECKS", "()Ljava/util/List;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SecurityChecker.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<SecurityCheck> getDEFAULT_CHECKS() {
            return DefaultSecurityChecker.DEFAULT_CHECKS;
        }
    }
}
