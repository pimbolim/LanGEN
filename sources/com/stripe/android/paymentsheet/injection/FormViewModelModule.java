package com.stripe.android.paymentsheet.injection;

import androidx.core.os.LocaleListCompat;
import com.stripe.android.ui.core.forms.resources.AsyncResourceRepository;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/FormViewModelModule;", "", "()V", "bindsResourceRepository", "Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;", "asyncResourceRepository", "Lcom/stripe/android/ui/core/forms/resources/AsyncResourceRepository;", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(subcomponents = {FormViewModelSubcomponent.class})
/* compiled from: FormViewModelModule.kt */
public abstract class FormViewModelModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Binds
    public abstract ResourceRepository bindsResourceRepository(AsyncResourceRepository asyncResourceRepository);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/FormViewModelModule$Companion;", "", "()V", "provideLocale", "Ljava/util/Locale;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormViewModelModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Singleton
        @Provides
        public final Locale provideLocale() {
            LocaleListCompat adjustedDefault = LocaleListCompat.getAdjustedDefault();
            if (adjustedDefault.isEmpty()) {
                adjustedDefault = null;
            }
            if (adjustedDefault == null) {
                return null;
            }
            return adjustedDefault.get(0);
        }
    }
}
