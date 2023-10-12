package com.stripe.android.payments.bankaccount.ui;

import com.stripe.android.core.Logger;
import com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession;
import com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* renamed from: com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel_Factory  reason: case insensitive filesystem */
public final class C0011CollectBankAccountViewModel_Factory implements Factory<CollectBankAccountViewModel> {
    private final Provider<MutableSharedFlow<CollectBankAccountViewEffect>> _viewEffectProvider;
    private final Provider<CollectBankAccountContract.Args> argsProvider;
    private final Provider<AttachLinkAccountSession> attachLinkAccountSessionProvider;
    private final Provider<CreateLinkAccountSession> createLinkAccountSessionProvider;
    private final Provider<Logger> loggerProvider;

    public C0011CollectBankAccountViewModel_Factory(Provider<CollectBankAccountContract.Args> provider, Provider<MutableSharedFlow<CollectBankAccountViewEffect>> provider2, Provider<CreateLinkAccountSession> provider3, Provider<AttachLinkAccountSession> provider4, Provider<Logger> provider5) {
        this.argsProvider = provider;
        this._viewEffectProvider = provider2;
        this.createLinkAccountSessionProvider = provider3;
        this.attachLinkAccountSessionProvider = provider4;
        this.loggerProvider = provider5;
    }

    public CollectBankAccountViewModel get() {
        return newInstance(this.argsProvider.get(), this._viewEffectProvider.get(), this.createLinkAccountSessionProvider.get(), this.attachLinkAccountSessionProvider.get(), this.loggerProvider.get());
    }

    public static C0011CollectBankAccountViewModel_Factory create(Provider<CollectBankAccountContract.Args> provider, Provider<MutableSharedFlow<CollectBankAccountViewEffect>> provider2, Provider<CreateLinkAccountSession> provider3, Provider<AttachLinkAccountSession> provider4, Provider<Logger> provider5) {
        return new C0011CollectBankAccountViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CollectBankAccountViewModel newInstance(CollectBankAccountContract.Args args, MutableSharedFlow<CollectBankAccountViewEffect> mutableSharedFlow, CreateLinkAccountSession createLinkAccountSession, AttachLinkAccountSession attachLinkAccountSession, Logger logger) {
        return new CollectBankAccountViewModel(args, mutableSharedFlow, createLinkAccountSession, attachLinkAccountSession, logger);
    }
}
