package com.stripe.android.link.injection;

import androidx.core.os.LocaleListCompat;
import com.stripe.android.link.repositories.LinkApiRepository;
import com.stripe.android.link.repositories.LinkRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import javax.inject.Singleton;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/link/injection/LinkPaymentLauncherModule;", "", "bindLinkRepository", "Lcom/stripe/android/link/repositories/LinkRepository;", "linkApiRepository", "Lcom/stripe/android/link/repositories/LinkApiRepository;", "Companion", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(subcomponents = {SignedInViewModelSubcomponent.class, SignUpViewModelSubcomponent.class})
/* compiled from: LinkPaymentLauncherModule.kt */
public interface LinkPaymentLauncherModule {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Singleton
    @Binds
    LinkRepository bindLinkRepository(LinkApiRepository linkApiRepository);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/link/injection/LinkPaymentLauncherModule$Companion;", "", "()V", "provideLocale", "Ljava/util/Locale;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkPaymentLauncherModule.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

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
