package com.stripe.android.ui.core.forms.resources;

import com.stripe.android.ui.core.address.AddressFieldElementRepository;
import com.stripe.android.ui.core.elements.BankRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0011\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/ui/core/forms/resources/StaticResourceRepository;", "Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;", "bankRepository", "Lcom/stripe/android/ui/core/elements/BankRepository;", "addressRepository", "Lcom/stripe/android/ui/core/address/AddressFieldElementRepository;", "(Lcom/stripe/android/ui/core/elements/BankRepository;Lcom/stripe/android/ui/core/address/AddressFieldElementRepository;)V", "getAddressRepository", "getBankRepository", "isLoaded", "", "waitUntilLoaded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StaticResourceRepository.kt */
public final class StaticResourceRepository implements ResourceRepository {
    public static final int $stable = 8;
    private final AddressFieldElementRepository addressRepository;
    private final BankRepository bankRepository;

    public boolean isLoaded() {
        return true;
    }

    public StaticResourceRepository(BankRepository bankRepository2, AddressFieldElementRepository addressFieldElementRepository) {
        Intrinsics.checkNotNullParameter(bankRepository2, "bankRepository");
        Intrinsics.checkNotNullParameter(addressFieldElementRepository, "addressRepository");
        this.bankRepository = bankRepository2;
        this.addressRepository = addressFieldElementRepository;
    }

    public Object waitUntilLoaded(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public BankRepository getBankRepository() {
        return this.bankRepository;
    }

    public AddressFieldElementRepository getAddressRepository() {
        return this.addressRepository;
    }
}
