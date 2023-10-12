package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import android.content.res.Resources;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

@Component(modules = {FormViewModelModule.class, CoroutineContextModule.class})
@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/FormViewModelComponent;", "", "inject", "", "factory", "Lcom/stripe/android/paymentsheet/forms/FormViewModel$Factory;", "Builder", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormViewModelComponent.kt */
public interface FormViewModelComponent {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/FormViewModelComponent$Builder;", "", "build", "Lcom/stripe/android/paymentsheet/injection/FormViewModelComponent;", "context", "Landroid/content/Context;", "resources", "Landroid/content/res/Resources;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: FormViewModelComponent.kt */
    public interface Builder {
        FormViewModelComponent build();

        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder resources(Resources resources);
    }

    void inject(FormViewModel.Factory factory);
}
