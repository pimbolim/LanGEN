package com.stripe.android.link.injection;

import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.ui.verification.VerificationViewModel;
import com.stripe.android.link.ui.wallet.WalletViewModel;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/link/injection/SignedInViewModelSubcomponent;", "", "verificationViewModel", "Lcom/stripe/android/link/ui/verification/VerificationViewModel;", "getVerificationViewModel", "()Lcom/stripe/android/link/ui/verification/VerificationViewModel;", "walletViewModel", "Lcom/stripe/android/link/ui/wallet/WalletViewModel;", "getWalletViewModel", "()Lcom/stripe/android/link/ui/wallet/WalletViewModel;", "Builder", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Subcomponent
/* compiled from: SignedInViewModelSubcomponent.kt */
public interface SignedInViewModelSubcomponent {

    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/link/injection/SignedInViewModelSubcomponent$Builder;", "", "build", "Lcom/stripe/android/link/injection/SignedInViewModelSubcomponent;", "linkAccount", "Lcom/stripe/android/link/model/LinkAccount;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SignedInViewModelSubcomponent.kt */
    public interface Builder {
        SignedInViewModelSubcomponent build();

        @BindsInstance
        Builder linkAccount(LinkAccount linkAccount);
    }

    VerificationViewModel getVerificationViewModel();

    WalletViewModel getWalletViewModel();
}
