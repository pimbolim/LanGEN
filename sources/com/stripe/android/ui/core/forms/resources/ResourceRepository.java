package com.stripe.android.ui.core.forms.resources;

import com.stripe.android.ui.core.address.AddressFieldElementRepository;
import com.stripe.android.ui.core.elements.BankRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0011\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;", "", "getAddressRepository", "Lcom/stripe/android/ui/core/address/AddressFieldElementRepository;", "getBankRepository", "Lcom/stripe/android/ui/core/elements/BankRepository;", "isLoaded", "", "waitUntilLoaded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ResourceRepository.kt */
public interface ResourceRepository {
    AddressFieldElementRepository getAddressRepository();

    BankRepository getBankRepository();

    boolean isLoaded();

    Object waitUntilLoaded(Continuation<? super Unit> continuation);
}
