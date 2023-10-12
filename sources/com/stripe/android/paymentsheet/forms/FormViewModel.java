package com.stripe.android.paymentsheet.forms;

import android.content.Context;
import android.content.res.Resources;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.InjectableKtxKt;
import com.stripe.android.paymentsheet.injection.DaggerFormViewModelComponent;
import com.stripe.android.paymentsheet.injection.FormViewModelSubcomponent;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArguments;
import com.stripe.android.ui.core.elements.CardBillingAddressElement;
import com.stripe.android.ui.core.elements.FormElement;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.elements.SaveForFutureUseElement;
import com.stripe.android.ui.core.elements.SectionFieldSpec;
import com.stripe.android.ui.core.elements.SectionSpec;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u00014B'\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u00101\u001a\u0002022\u0006\u0010\u0019\u001a\u00020\u001bH\u0000¢\u0006\u0002\b3R\u001b\u0010\u000b\u001a\u000f\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00150\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001b0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012R\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\fX\u0004¢\u0006\u0002\n\u0000R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010\u001dR \u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00150,X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00150\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000\fX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/stripe/android/paymentsheet/forms/FormViewModel;", "Landroidx/lifecycle/ViewModel;", "layout", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "config", "Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;", "resourceRepository", "Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;", "transformSpecToElement", "Lcom/stripe/android/paymentsheet/forms/TransformSpecToElement;", "(Lcom/stripe/android/ui/core/elements/LayoutSpec;Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;Lcom/stripe/android/paymentsheet/forms/TransformSpecToElement;)V", "cardBillingElement", "Lkotlinx/coroutines/flow/Flow;", "Lcom/stripe/android/ui/core/elements/CardBillingAddressElement;", "Lkotlin/internal/NoInfer;", "completeFormValues", "Lcom/stripe/android/paymentsheet/forms/FormFieldValues;", "getCompleteFormValues", "()Lkotlinx/coroutines/flow/Flow;", "elements", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/stripe/android/ui/core/elements/FormElement;", "getElements$paymentsheet_release", "()Lkotlinx/coroutines/flow/StateFlow;", "enabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getEnabled$paymentsheet_release", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "hiddenIdentifiers", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getHiddenIdentifiers$paymentsheet_release", "lastTextFieldIdentifier", "getLastTextFieldIdentifier", "saveForFutureUse", "getSaveForFutureUse$paymentsheet_release", "saveForFutureUseElement", "Lcom/stripe/android/ui/core/elements/SaveForFutureUseElement;", "saveForFutureUseVisible", "getSaveForFutureUseVisible$paymentsheet_release$annotations", "()V", "getSaveForFutureUseVisible$paymentsheet_release", "sectionToFieldIdentifierMap", "", "showingMandate", "textFieldControllerIdsFlow", "userRequestedReuse", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "setEnabled", "", "setEnabled$paymentsheet_release", "Factory", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormViewModel.kt */
public final class FormViewModel extends ViewModel {
    private final Flow<CardBillingAddressElement> cardBillingElement;
    private final Flow<FormFieldValues> completeFormValues;
    private final StateFlow<List<FormElement>> elements;
    private final MutableStateFlow<Boolean> enabled;
    private final Flow<List<IdentifierSpec>> hiddenIdentifiers;
    private final Flow<IdentifierSpec> lastTextFieldIdentifier;
    /* access modifiers changed from: private */
    public final ResourceRepository resourceRepository;
    private final Flow<Boolean> saveForFutureUse;
    /* access modifiers changed from: private */
    public final Flow<SaveForFutureUseElement> saveForFutureUseElement;
    private final MutableStateFlow<Boolean> saveForFutureUseVisible;
    /* access modifiers changed from: private */
    public final Map<IdentifierSpec, List<IdentifierSpec>> sectionToFieldIdentifierMap;
    private final Flow<Boolean> showingMandate;
    private final Flow<List<IdentifierSpec>> textFieldControllerIdsFlow;
    /* access modifiers changed from: private */
    public final TransformSpecToElement transformSpecToElement;
    private final Flow<PaymentSelection.CustomerRequestedSave> userRequestedReuse;

    public static /* synthetic */ void getSaveForFutureUseVisible$paymentsheet_release$annotations() {
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001&B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ%\u0010\u001d\u001a\u0002H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0!H\u0016¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/stripe/android/paymentsheet/forms/FormViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/stripe/android/core/injection/Injectable;", "Lcom/stripe/android/paymentsheet/forms/FormViewModel$Factory$FallbackInitializeParam;", "config", "Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;", "resource", "Landroid/content/res/Resources;", "layout", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "contextSupplier", "Lkotlin/Function0;", "Landroid/content/Context;", "(Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;Landroid/content/res/Resources;Lcom/stripe/android/ui/core/elements/LayoutSpec;Lkotlin/jvm/functions/Function0;)V", "getConfig", "()Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;", "getLayout", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "setLayout", "(Lcom/stripe/android/ui/core/elements/LayoutSpec;)V", "getResource", "()Landroid/content/res/Resources;", "subComponentBuilderProvider", "Ljavax/inject/Provider;", "Lcom/stripe/android/paymentsheet/injection/FormViewModelSubcomponent$Builder;", "getSubComponentBuilderProvider", "()Ljavax/inject/Provider;", "setSubComponentBuilderProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "fallbackInitialize", "", "arg", "FallbackInitializeParam", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory, Injectable<FallbackInitializeParam> {
        private final FormFragmentArguments config;
        private final Function0<Context> contextSupplier;
        private LayoutSpec layout;
        private final Resources resource;
        @Inject
        public Provider<FormViewModelSubcomponent.Builder> subComponentBuilderProvider;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(FormFragmentArguments formFragmentArguments, Resources resources, LayoutSpec layoutSpec, Function0<? extends Context> function0) {
            Intrinsics.checkNotNullParameter(formFragmentArguments, "config");
            Intrinsics.checkNotNullParameter(resources, "resource");
            Intrinsics.checkNotNullParameter(layoutSpec, "layout");
            Intrinsics.checkNotNullParameter(function0, "contextSupplier");
            this.config = formFragmentArguments;
            this.resource = resources;
            this.layout = layoutSpec;
            this.contextSupplier = function0;
        }

        public final FormFragmentArguments getConfig() {
            return this.config;
        }

        public final Resources getResource() {
            return this.resource;
        }

        public final LayoutSpec getLayout() {
            return this.layout;
        }

        public final void setLayout(LayoutSpec layoutSpec) {
            Intrinsics.checkNotNullParameter(layoutSpec, "<set-?>");
            this.layout = layoutSpec;
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/paymentsheet/forms/FormViewModel$Factory$FallbackInitializeParam;", "", "resource", "Landroid/content/res/Resources;", "context", "Landroid/content/Context;", "(Landroid/content/res/Resources;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getResource", "()Landroid/content/res/Resources;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FormViewModel.kt */
        public static final class FallbackInitializeParam {
            private final Context context;
            private final Resources resource;

            public static /* synthetic */ FallbackInitializeParam copy$default(FallbackInitializeParam fallbackInitializeParam, Resources resources, Context context2, int i, Object obj) {
                if ((i & 1) != 0) {
                    resources = fallbackInitializeParam.resource;
                }
                if ((i & 2) != 0) {
                    context2 = fallbackInitializeParam.context;
                }
                return fallbackInitializeParam.copy(resources, context2);
            }

            public final Resources component1() {
                return this.resource;
            }

            public final Context component2() {
                return this.context;
            }

            public final FallbackInitializeParam copy(Resources resources, Context context2) {
                Intrinsics.checkNotNullParameter(resources, "resource");
                Intrinsics.checkNotNullParameter(context2, "context");
                return new FallbackInitializeParam(resources, context2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FallbackInitializeParam)) {
                    return false;
                }
                FallbackInitializeParam fallbackInitializeParam = (FallbackInitializeParam) obj;
                return Intrinsics.areEqual((Object) this.resource, (Object) fallbackInitializeParam.resource) && Intrinsics.areEqual((Object) this.context, (Object) fallbackInitializeParam.context);
            }

            public int hashCode() {
                return (this.resource.hashCode() * 31) + this.context.hashCode();
            }

            public String toString() {
                return "FallbackInitializeParam(resource=" + this.resource + ", context=" + this.context + ')';
            }

            public FallbackInitializeParam(Resources resources, Context context2) {
                Intrinsics.checkNotNullParameter(resources, "resource");
                Intrinsics.checkNotNullParameter(context2, "context");
                this.resource = resources;
                this.context = context2;
            }

            public final Resources getResource() {
                return this.resource;
            }

            public final Context getContext() {
                return this.context;
            }
        }

        public final Provider<FormViewModelSubcomponent.Builder> getSubComponentBuilderProvider() {
            Provider<FormViewModelSubcomponent.Builder> provider = this.subComponentBuilderProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentBuilderProvider");
            return null;
        }

        public final void setSubComponentBuilderProvider(Provider<FormViewModelSubcomponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentBuilderProvider = provider;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            InjectableKtxKt.injectWithFallback(this, this.config.getInjectorKey(), new FallbackInitializeParam(this.resource, this.contextSupplier.invoke()));
            return getSubComponentBuilderProvider().get().formFragmentArguments(this.config).layout(this.layout).build().getViewModel();
        }

        public void fallbackInitialize(FallbackInitializeParam fallbackInitializeParam) {
            Intrinsics.checkNotNullParameter(fallbackInitializeParam, "arg");
            DaggerFormViewModelComponent.builder().context(fallbackInitializeParam.getContext()).resources(fallbackInitializeParam.getResource()).build().inject(this);
        }
    }

    @Inject
    public FormViewModel(final LayoutSpec layoutSpec, FormFragmentArguments formFragmentArguments, ResourceRepository resourceRepository2, TransformSpecToElement transformSpecToElement2) {
        Intrinsics.checkNotNullParameter(layoutSpec, "layout");
        Intrinsics.checkNotNullParameter(formFragmentArguments, "config");
        Intrinsics.checkNotNullParameter(resourceRepository2, "resourceRepository");
        Intrinsics.checkNotNullParameter(transformSpecToElement2, "transformSpecToElement");
        this.resourceRepository = resourceRepository2;
        this.transformSpecToElement = transformSpecToElement2;
        if (resourceRepository2.isLoaded()) {
            this.elements = StateFlowKt.MutableStateFlow(transformSpecToElement2.transform$paymentsheet_release(layoutSpec.getItems()));
        } else {
            final MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            this.elements = MutableStateFlow;
        }
        this.enabled = StateFlowKt.MutableStateFlow(true);
        this.saveForFutureUseVisible = StateFlowKt.MutableStateFlow(Boolean.valueOf(formFragmentArguments.getShowCheckbox()));
        Flow<SaveForFutureUseElement> formViewModel$special$$inlined$map$1 = new FormViewModel$special$$inlined$map$1(this.elements);
        this.saveForFutureUseElement = formViewModel$special$$inlined$map$1;
        this.saveForFutureUse = FlowKt.flattenConcat(new FormViewModel$special$$inlined$map$2(formViewModel$special$$inlined$map$1));
        Collection arrayList = new ArrayList();
        for (Object next : layoutSpec.getItems()) {
            if (next instanceof SectionSpec) {
                arrayList.add(next);
            }
        }
        Iterable<SectionSpec> iterable = (List) arrayList;
        Map<IdentifierSpec, List<IdentifierSpec>> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (SectionSpec sectionSpec : iterable) {
            IdentifierSpec identifier = sectionSpec.getIdentifier();
            Iterable<SectionFieldSpec> fields = sectionSpec.getFields();
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(fields, 10));
            for (SectionFieldSpec identifier2 : fields) {
                arrayList2.add(identifier2.getIdentifier());
            }
            Pair pair = TuplesKt.to(identifier, (List) arrayList2);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        this.sectionToFieldIdentifierMap = linkedHashMap;
        Flow<CardBillingAddressElement> formViewModel$special$$inlined$map$3 = new FormViewModel$special$$inlined$map$3(this.elements);
        this.cardBillingElement = formViewModel$special$$inlined$map$3;
        Flow<List<IdentifierSpec>> combine = FlowKt.combine(this.saveForFutureUseVisible, FlowKt.flattenConcat(new FormViewModel$special$$inlined$map$4(this.saveForFutureUseElement)), FlowKt.flattenConcat(new FormViewModel$special$$inlined$map$5(formViewModel$special$$inlined$map$3)), new FormViewModel$hiddenIdentifiers$3(this, (Continuation<? super FormViewModel$hiddenIdentifiers$3>) null));
        this.hiddenIdentifiers = combine;
        Flow<Boolean> combine2 = FlowKt.combine(combine, new FormViewModel$special$$inlined$map$6(this.elements), new FormViewModel$showingMandate$2((Continuation<? super FormViewModel$showingMandate$2>) null));
        this.showingMandate = combine2;
        Flow<PaymentSelection.CustomerRequestedSave> flattenConcat = FlowKt.flattenConcat(new FormViewModel$special$$inlined$map$7(FlowKt.filterNotNull(this.elements), formFragmentArguments));
        this.userRequestedReuse = flattenConcat;
        this.completeFormValues = new CompleteFormFieldValueFilter(FlowKt.flattenConcat(new FormViewModel$special$$inlined$map$8(FlowKt.filterNotNull(this.elements))), combine, combine2, flattenConcat).filterFlow();
        Flow<List<IdentifierSpec>> flattenConcat2 = FlowKt.flattenConcat(new FormViewModel$special$$inlined$map$9(FlowKt.filterNotNull(this.elements)));
        this.textFieldControllerIdsFlow = flattenConcat2;
        this.lastTextFieldIdentifier = FlowKt.combine(combine, flattenConcat2, new FormViewModel$lastTextFieldIdentifier$1((Continuation<? super FormViewModel$lastTextFieldIdentifier$1>) null));
    }

    public final StateFlow<List<FormElement>> getElements$paymentsheet_release() {
        return this.elements;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.paymentsheet.forms.FormViewModel$1", f = "FormViewModel.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.paymentsheet.forms.FormViewModel$1  reason: invalid class name */
    /* compiled from: FormViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FormViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, MutableStateFlow, layoutSpec, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.resourceRepository.waitUntilLoaded(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutableStateFlow.setValue(this.this$0.transformSpecToElement.transform$paymentsheet_release(layoutSpec.getItems()));
            return Unit.INSTANCE;
        }
    }

    public final MutableStateFlow<Boolean> getEnabled$paymentsheet_release() {
        return this.enabled;
    }

    public final void setEnabled$paymentsheet_release(boolean z) {
        this.enabled.setValue(Boolean.valueOf(z));
    }

    public final MutableStateFlow<Boolean> getSaveForFutureUseVisible$paymentsheet_release() {
        return this.saveForFutureUseVisible;
    }

    public final Flow<Boolean> getSaveForFutureUse$paymentsheet_release() {
        return this.saveForFutureUse;
    }

    public final Flow<List<IdentifierSpec>> getHiddenIdentifiers$paymentsheet_release() {
        return this.hiddenIdentifiers;
    }

    public final Flow<FormFieldValues> getCompleteFormValues() {
        return this.completeFormValues;
    }

    public final Flow<IdentifierSpec> getLastTextFieldIdentifier() {
        return this.lastTextFieldIdentifier;
    }
}
