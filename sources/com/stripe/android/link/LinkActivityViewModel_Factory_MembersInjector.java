package com.stripe.android.link;

import com.stripe.android.link.LinkActivityViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LinkActivityViewModel_Factory_MembersInjector implements MembersInjector<LinkActivityViewModel.Factory> {
    private final Provider<LinkActivityViewModel> viewModelProvider;

    public LinkActivityViewModel_Factory_MembersInjector(Provider<LinkActivityViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<LinkActivityViewModel.Factory> create(Provider<LinkActivityViewModel> provider) {
        return new LinkActivityViewModel_Factory_MembersInjector(provider);
    }

    public void injectMembers(LinkActivityViewModel.Factory factory) {
        injectViewModel(factory, this.viewModelProvider.get());
    }

    public static void injectViewModel(LinkActivityViewModel.Factory factory, LinkActivityViewModel linkActivityViewModel) {
        factory.viewModel = linkActivityViewModel;
    }
}
