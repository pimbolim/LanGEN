package com.stripe.android.ui.core.forms;

import android.content.Context;
import com.stripe.android.ui.core.Amount;
import com.stripe.android.ui.core.address.AddressFieldElementRepository;
import com.stripe.android.ui.core.elements.AddressSpec;
import com.stripe.android.ui.core.elements.AffirmTextSpec;
import com.stripe.android.ui.core.elements.AfterpayClearpayTextSpec;
import com.stripe.android.ui.core.elements.AuBankAccountNumberSpec;
import com.stripe.android.ui.core.elements.AuBecsDebitMandateTextSpec;
import com.stripe.android.ui.core.elements.BankDropdownSpec;
import com.stripe.android.ui.core.elements.BankRepository;
import com.stripe.android.ui.core.elements.BsbSpec;
import com.stripe.android.ui.core.elements.CardBillingSpec;
import com.stripe.android.ui.core.elements.CardDetailsSpec;
import com.stripe.android.ui.core.elements.Controller;
import com.stripe.android.ui.core.elements.CountrySpec;
import com.stripe.android.ui.core.elements.EmailSpec;
import com.stripe.android.ui.core.elements.EmptyFormElement;
import com.stripe.android.ui.core.elements.EmptyFormSpec;
import com.stripe.android.ui.core.elements.FormElement;
import com.stripe.android.ui.core.elements.FormItemSpec;
import com.stripe.android.ui.core.elements.IbanSpec;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.KlarnaCountrySpec;
import com.stripe.android.ui.core.elements.MandateTextSpec;
import com.stripe.android.ui.core.elements.SaveForFutureUseSpec;
import com.stripe.android.ui.core.elements.SectionController;
import com.stripe.android.ui.core.elements.SectionElement;
import com.stripe.android.ui.core.elements.SectionFieldElement;
import com.stripe.android.ui.core.elements.SectionFieldSpec;
import com.stripe.android.ui.core.elements.SectionSpec;
import com.stripe.android.ui.core.elements.SimpleTextSpec;
import com.stripe.android.ui.core.elements.StaticTextSpec;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012JF\u0010\u0011\u001a\u00020\u0016*\u00020\u00172\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002JR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012*\b\u0012\u0004\u0012\u00020\u001e0\u00122\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/ui/core/forms/TransformSpecToElements;", "", "resourceRepository", "Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;", "initialValues", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "", "amount", "Lcom/stripe/android/ui/core/Amount;", "country", "saveForFutureUseInitialValue", "", "merchantName", "context", "Landroid/content/Context;", "(Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;Ljava/util/Map;Lcom/stripe/android/ui/core/Amount;Ljava/lang/String;ZLjava/lang/String;Landroid/content/Context;)V", "transform", "", "Lcom/stripe/android/ui/core/elements/FormElement;", "list", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "Lcom/stripe/android/ui/core/elements/SectionElement;", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "currencyCode", "bankRepository", "Lcom/stripe/android/ui/core/elements/BankRepository;", "addressRepository", "Lcom/stripe/android/ui/core/address/AddressFieldElementRepository;", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransformSpecToElements.kt */
public final class TransformSpecToElements {
    public static final int $stable = 8;
    private final Amount amount;
    private final Context context;
    private final String country;
    private final Map<IdentifierSpec, String> initialValues;
    private final String merchantName;
    private final ResourceRepository resourceRepository;
    private final boolean saveForFutureUseInitialValue;

    public TransformSpecToElements(ResourceRepository resourceRepository2, Map<IdentifierSpec, String> map, Amount amount2, String str, boolean z, String str2, Context context2) {
        Intrinsics.checkNotNullParameter(resourceRepository2, "resourceRepository");
        Intrinsics.checkNotNullParameter(map, "initialValues");
        Intrinsics.checkNotNullParameter(str2, "merchantName");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.resourceRepository = resourceRepository2;
        this.initialValues = map;
        this.amount = amount2;
        this.country = str;
        this.saveForFutureUseInitialValue = z;
        this.merchantName = str2;
        this.context = context2;
    }

    public final List<FormElement> transform(List<? extends FormItemSpec> list) {
        FormElement formElement;
        Intrinsics.checkNotNullParameter(list, "list");
        Iterable<FormItemSpec> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (FormItemSpec formItemSpec : iterable) {
            if (formItemSpec instanceof SaveForFutureUseSpec) {
                formElement = ((SaveForFutureUseSpec) formItemSpec).transform(this.saveForFutureUseInitialValue, this.merchantName);
            } else {
                String str = null;
                if (formItemSpec instanceof SectionSpec) {
                    SectionSpec sectionSpec = (SectionSpec) formItemSpec;
                    Map<IdentifierSpec, String> map = this.initialValues;
                    Amount amount2 = this.amount;
                    if (amount2 != null) {
                        str = amount2.getCurrencyCode();
                    }
                    formElement = transform(sectionSpec, map, str, this.country, this.resourceRepository.getBankRepository(), this.resourceRepository.getAddressRepository());
                } else if (formItemSpec instanceof StaticTextSpec) {
                    formElement = ((StaticTextSpec) formItemSpec).transform();
                } else if (formItemSpec instanceof MandateTextSpec) {
                    formElement = ((MandateTextSpec) formItemSpec).transform(this.merchantName);
                } else if (formItemSpec instanceof AfterpayClearpayTextSpec) {
                    AfterpayClearpayTextSpec afterpayClearpayTextSpec = (AfterpayClearpayTextSpec) formItemSpec;
                    Amount amount3 = this.amount;
                    if (amount3 != null) {
                        formElement = afterpayClearpayTextSpec.transform(amount3);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (formItemSpec instanceof AffirmTextSpec) {
                    formElement = ((AffirmTextSpec) formItemSpec).transform();
                } else if (formItemSpec instanceof EmptyFormSpec) {
                    formElement = new EmptyFormElement((IdentifierSpec) null, (Controller) null, 3, (DefaultConstructorMarker) null);
                } else if (formItemSpec instanceof AuBecsDebitMandateTextSpec) {
                    formElement = ((AuBecsDebitMandateTextSpec) formItemSpec).transform(this.merchantName);
                } else if (formItemSpec instanceof BsbSpec) {
                    formElement = ((BsbSpec) formItemSpec).transform();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            arrayList.add(formElement);
        }
        return (List) arrayList;
    }

    private final SectionElement transform(SectionSpec sectionSpec, Map<IdentifierSpec, String> map, String str, String str2, BankRepository bankRepository, AddressFieldElementRepository addressFieldElementRepository) {
        List<SectionFieldElement> transform = transform((List<? extends SectionFieldSpec>) sectionSpec.getFields(), map, str, str2, bankRepository, addressFieldElementRepository);
        IdentifierSpec identifier = sectionSpec.getIdentifier();
        Integer title = sectionSpec.getTitle();
        Iterable<SectionFieldElement> iterable = transform;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SectionFieldElement sectionFieldErrorController : iterable) {
            arrayList.add(sectionFieldErrorController.sectionFieldErrorController());
        }
        return new SectionElement(identifier, (List<? extends SectionFieldElement>) transform, new SectionController(title, (List) arrayList));
    }

    private final List<SectionFieldElement> transform(List<? extends SectionFieldSpec> list, Map<IdentifierSpec, String> map, String str, String str2, BankRepository bankRepository, AddressFieldElementRepository addressFieldElementRepository) {
        SectionFieldElement sectionFieldElement;
        Iterable<SectionFieldSpec> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SectionFieldSpec sectionFieldSpec : iterable) {
            if (sectionFieldSpec instanceof EmailSpec) {
                sectionFieldElement = ((EmailSpec) sectionFieldSpec).transform(map.get(IdentifierSpec.Email.INSTANCE));
            } else if (sectionFieldSpec instanceof IbanSpec) {
                sectionFieldElement = ((IbanSpec) sectionFieldSpec).transform();
            } else if (sectionFieldSpec instanceof BankDropdownSpec) {
                sectionFieldElement = ((BankDropdownSpec) sectionFieldSpec).transform(bankRepository);
            } else if (sectionFieldSpec instanceof SimpleTextSpec) {
                sectionFieldElement = ((SimpleTextSpec) sectionFieldSpec).transform(map);
            } else if (sectionFieldSpec instanceof AddressSpec) {
                sectionFieldElement = ((AddressSpec) sectionFieldSpec).transform(map, addressFieldElementRepository);
            } else if (sectionFieldSpec instanceof CountrySpec) {
                sectionFieldElement = ((CountrySpec) sectionFieldSpec).transform(map.get(IdentifierSpec.Country.INSTANCE));
            } else if (sectionFieldSpec instanceof KlarnaCountrySpec) {
                sectionFieldElement = ((KlarnaCountrySpec) sectionFieldSpec).transform(str, str2);
            } else if (sectionFieldSpec instanceof CardDetailsSpec) {
                sectionFieldElement = ((CardDetailsSpec) sectionFieldSpec).transform(this.context);
            } else if (sectionFieldSpec instanceof CardBillingSpec) {
                sectionFieldElement = ((CardBillingSpec) sectionFieldSpec).transform(addressFieldElementRepository);
            } else if (sectionFieldSpec instanceof AuBankAccountNumberSpec) {
                sectionFieldElement = ((AuBankAccountNumberSpec) sectionFieldSpec).transform();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(sectionFieldElement);
        }
        return (List) arrayList;
    }
}
