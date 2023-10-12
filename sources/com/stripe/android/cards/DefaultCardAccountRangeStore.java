package com.stripe.android.cards;

import android.content.Context;
import android.content.SharedPreferences;
import com.stripe.android.model.AccountRange;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/cards/DefaultCardAccountRangeStore;", "Lcom/stripe/android/cards/CardAccountRangeStore;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "accountRangeJsonParser", "Lcom/stripe/android/model/parsers/AccountRangeJsonParser;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "contains", "", "bin", "Lcom/stripe/android/cards/Bin;", "(Lcom/stripe/android/cards/Bin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPrefKey", "", "createPrefKey$payments_core_release", "get", "", "Lcom/stripe/android/model/AccountRange;", "save", "", "accountRanges", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultCardAccountRangeStore.kt */
public final class DefaultCardAccountRangeStore implements CardAccountRangeStore {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PREF_FILE = "InMemoryCardAccountRangeSource.Store";
    @Deprecated
    private static final String PREF_KEY_ACCOUNT_RANGES = "key_account_ranges";
    private final AccountRangeJsonParser accountRangeJsonParser = new AccountRangeJsonParser();
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy prefs$delegate = LazyKt.lazy(new DefaultCardAccountRangeStore$prefs$2(this));

    public DefaultCardAccountRangeStore(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final SharedPreferences getPrefs() {
        return (SharedPreferences) this.prefs$delegate.getValue();
    }

    public Object get(Bin bin, Continuation<? super List<AccountRange>> continuation) {
        Set<String> stringSet = getPrefs().getStringSet(createPrefKey$payments_core_release(bin), (Set) null);
        if (stringSet == null) {
            stringSet = SetsKt.emptySet();
        }
        Collection arrayList = new ArrayList();
        for (String jSONObject : stringSet) {
            AccountRange parse = this.accountRangeJsonParser.parse(new JSONObject(jSONObject));
            if (parse != null) {
                arrayList.add(parse);
            }
        }
        return (List) arrayList;
    }

    public void save(Bin bin, List<AccountRange> list) {
        Intrinsics.checkNotNullParameter(bin, "bin");
        Intrinsics.checkNotNullParameter(list, "accountRanges");
        Iterable<AccountRange> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (AccountRange serialize : iterable) {
            arrayList.add(this.accountRangeJsonParser.serialize(serialize).toString());
        }
        getPrefs().edit().putStringSet(createPrefKey$payments_core_release(bin), CollectionsKt.toSet((List) arrayList)).apply();
    }

    public Object contains(Bin bin, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(getPrefs().contains(createPrefKey$payments_core_release(bin)));
    }

    public final String createPrefKey$payments_core_release(Bin bin) {
        Intrinsics.checkNotNullParameter(bin, "bin");
        return Intrinsics.stringPlus("key_account_ranges:", bin);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/cards/DefaultCardAccountRangeStore$Companion;", "", "()V", "PREF_FILE", "", "PREF_KEY_ACCOUNT_RANGES", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultCardAccountRangeStore.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
