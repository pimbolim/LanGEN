package com.stripe.android.link.injection;

import com.stripe.android.link.ui.signup.SignUpViewModel;
import dagger.BindsInstance;
import dagger.Subcomponent;
import javax.inject.Named;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/link/injection/SignUpViewModelSubcomponent;", "", "signUpViewModel", "Lcom/stripe/android/link/ui/signup/SignUpViewModel;", "getSignUpViewModel", "()Lcom/stripe/android/link/ui/signup/SignUpViewModel;", "Builder", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Subcomponent
/* compiled from: SignUpViewModelSubcomponent.kt */
public interface SignUpViewModelSubcomponent {

    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u00020\u00002\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/link/injection/SignUpViewModelSubcomponent$Builder;", "", "build", "Lcom/stripe/android/link/injection/SignUpViewModelSubcomponent;", "prefilledEmail", "", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SignUpViewModelSubcomponent.kt */
    public interface Builder {
        SignUpViewModelSubcomponent build();

        @BindsInstance
        Builder prefilledEmail(@Named("prefilled_email") String str);
    }

    SignUpViewModel getSignUpViewModel();
}
