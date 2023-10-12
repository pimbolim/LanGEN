package com.stripe.android.view;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.stripe.android.R;
import com.stripe.android.core.model.Country;
import com.stripe.android.core.model.CountryCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\rJ\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u000bH\u0016J\u001b\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0000¢\u0006\u0002\b*R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/stripe/android/view/CountryAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/stripe/android/core/model/Country;", "context", "Landroid/content/Context;", "unfilteredCountries", "", "itemLayoutId", "", "textViewFactory", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Landroid/widget/TextView;", "(Landroid/content/Context;Ljava/util/List;ILkotlin/jvm/functions/Function1;)V", "countryFilter", "Lcom/stripe/android/view/CountryAdapter$CountryFilter;", "firstItem", "getFirstItem$payments_core_release", "()Lcom/stripe/android/core/model/Country;", "suggestions", "getUnfilteredCountries$payments_core_release", "()Ljava/util/List;", "setUnfilteredCountries$payments_core_release", "(Ljava/util/List;)V", "getCount", "getFilter", "Landroid/widget/Filter;", "getItem", "i", "getItemId", "", "getPosition", "item", "getView", "Landroid/view/View;", "view", "viewGroup", "updateUnfilteredCountries", "", "allowedCountryCodes", "", "", "updateUnfilteredCountries$payments_core_release", "CountryFilter", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CountryAdapter.kt */
public final class CountryAdapter extends ArrayAdapter<Country> {
    private final CountryFilter countryFilter;
    /* access modifiers changed from: private */
    public List<Country> suggestions;
    private final Function1<ViewGroup, TextView> textViewFactory;
    private List<Country> unfilteredCountries;

    public final List<Country> getUnfilteredCountries$payments_core_release() {
        return this.unfilteredCountries;
    }

    public final void setUnfilteredCountries$payments_core_release(List<Country> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.unfilteredCountries = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CountryAdapter(Context context, List list, int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i2 & 4) != 0 ? R.layout.country_text_view : i, function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryAdapter(Context context, List<Country> list, int i, Function1<? super ViewGroup, ? extends TextView> function1) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "unfilteredCountries");
        Intrinsics.checkNotNullParameter(function1, "textViewFactory");
        this.unfilteredCountries = list;
        this.textViewFactory = function1;
        this.countryFilter = new CountryFilter(this.unfilteredCountries, this, context instanceof Activity ? (Activity) context : null);
        this.suggestions = this.unfilteredCountries;
    }

    public final /* synthetic */ Country getFirstItem$payments_core_release() {
        return getItem(0);
    }

    public int getCount() {
        return this.suggestions.size();
    }

    public Country getItem(int i) {
        return this.suggestions.get(i);
    }

    public int getPosition(Country country) {
        return CollectionsKt.indexOf(this.suggestions, country);
    }

    public long getItemId(int i) {
        return (long) getItem(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = this.textViewFactory.invoke(viewGroup);
        }
        textView.setText(getItem(i).getName());
        return textView;
    }

    public Filter getFilter() {
        return this.countryFilter;
    }

    public final boolean updateUnfilteredCountries$payments_core_release(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "allowedCountryCodes");
        if (set.isEmpty()) {
            return false;
        }
        Collection arrayList = new ArrayList();
        Iterator it = this.unfilteredCountries.iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                Object next = it.next();
                CountryCode component1 = ((Country) next).component1();
                Iterable iterable = set;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it2 = iterable.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (StringsKt.equals((String) it2.next(), component1.getValue(), true)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    arrayList.add(next);
                }
            } else {
                List<Country> list = (List) arrayList;
                this.unfilteredCountries = list;
                this.countryFilter.setUnfilteredCountries(list);
                this.suggestions = this.unfilteredCountries;
                notifyDataSetChanged();
                return true;
            }
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u001c\u0010\u001b\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0014R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/view/CountryAdapter$CountryFilter;", "Landroid/widget/Filter;", "unfilteredCountries", "", "Lcom/stripe/android/core/model/Country;", "adapter", "Lcom/stripe/android/view/CountryAdapter;", "activity", "Landroid/app/Activity;", "(Ljava/util/List;Lcom/stripe/android/view/CountryAdapter;Landroid/app/Activity;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "getUnfilteredCountries", "()Ljava/util/List;", "setUnfilteredCountries", "(Ljava/util/List;)V", "filteredSuggestedCountries", "constraint", "", "getSuggestedCountries", "hideKeyboard", "", "isMatch", "", "countries", "performFiltering", "Landroid/widget/Filter$FilterResults;", "publishResults", "filterResults", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CountryAdapter.kt */
    private static final class CountryFilter extends Filter {
        private final WeakReference<Activity> activityRef;
        private final CountryAdapter adapter;
        private List<Country> unfilteredCountries;

        public final List<Country> getUnfilteredCountries() {
            return this.unfilteredCountries;
        }

        public final void setUnfilteredCountries(List<Country> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.unfilteredCountries = list;
        }

        public CountryFilter(List<Country> list, CountryAdapter countryAdapter, Activity activity) {
            Intrinsics.checkNotNullParameter(list, "unfilteredCountries");
            Intrinsics.checkNotNullParameter(countryAdapter, "adapter");
            this.unfilteredCountries = list;
            this.adapter = countryAdapter;
            this.activityRef = new WeakReference<>(activity);
        }

        /* access modifiers changed from: protected */
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            List<Country> list;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null) {
                list = null;
            } else {
                list = filteredSuggestedCountries(charSequence);
            }
            if (list == null) {
                list = this.unfilteredCountries;
            }
            filterResults.values = list;
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            Object obj = filterResults == null ? null : filterResults.values;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.List<com.stripe.android.core.model.Country>");
            List list = (List) obj;
            Activity activity = (Activity) this.activityRef.get();
            if (activity != null) {
                Iterable iterable = list;
                boolean z = false;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual((Object) ((Country) it.next()).getName(), (Object) charSequence)) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z) {
                    hideKeyboard(activity);
                }
            }
            this.adapter.suggestions = list;
            this.adapter.notifyDataSetChanged();
        }

        private final List<Country> filteredSuggestedCountries(CharSequence charSequence) {
            List<Country> suggestedCountries = getSuggestedCountries(charSequence);
            return (suggestedCountries.isEmpty() || isMatch(suggestedCountries, charSequence)) ? this.unfilteredCountries : suggestedCountries;
        }

        private final List<Country> getSuggestedCountries(CharSequence charSequence) {
            Collection arrayList = new ArrayList();
            for (Object next : this.unfilteredCountries) {
                String lowerCase = ((Country) next).getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                String lowerCase2 = String.valueOf(charSequence).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (StringsKt.startsWith$default(lowerCase, lowerCase2, false, 2, (Object) null)) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }

        private final boolean isMatch(List<Country> list, CharSequence charSequence) {
            return list.size() == 1 && Intrinsics.areEqual((Object) list.get(0).getName(), (Object) String.valueOf(charSequence));
        }

        private final void hideKeyboard(Activity activity) {
            Object systemService = activity.getSystemService("input_method");
            IBinder iBinder = null;
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            boolean z = true;
            if (inputMethodManager == null || !inputMethodManager.isAcceptingText()) {
                z = false;
            }
            if (z) {
                View currentFocus = activity.getCurrentFocus();
                if (currentFocus != null) {
                    iBinder = currentFocus.getWindowToken();
                }
                inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            }
        }
    }
}
