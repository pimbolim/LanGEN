package com.stripe.android.payments.bankaccount.di;

import android.app.Application;
import android.content.Context;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract;
import dagger.Module;
import dagger.Provides;
import java.util.Set;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/payments/bankaccount/di/CollectBankAccountModule;", "", "()V", "providePublishableKey", "Lkotlin/Function0;", "", "args", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "providesAppContext", "Landroid/content/Context;", "application", "Landroid/app/Application;", "providesEnableLogging", "", "providesProductUsage", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: CollectBankAccountModule.kt */
public final class CollectBankAccountModule {
    public static final CollectBankAccountModule INSTANCE = new CollectBankAccountModule();

    @Provides
    @Named("enableLogging")
    public final boolean providesEnableLogging() {
        return false;
    }

    private CollectBankAccountModule() {
    }

    @Provides
    public final Context providesAppContext(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        return application;
    }

    @Provides
    @Named("publishableKey")
    public final Function0<String> providePublishableKey(CollectBankAccountContract.Args args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return new CollectBankAccountModule$providePublishableKey$1(args);
    }

    @Provides
    @Named("productUsage")
    public final Set<String> providesProductUsage() {
        return SetsKt.emptySet();
    }
}
