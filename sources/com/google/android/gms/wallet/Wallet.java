package com.google.android.gms.wallet;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.wallet.zzad;
import com.google.android.gms.internal.wallet.zzaf;
import com.google.android.gms.internal.wallet.zzv;
import com.google.android.gms.wallet.wobs.WalletObjects;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public final class Wallet {
    public static final Api<WalletOptions> API;
    public static final WalletObjects zza = new zzaf();
    @Deprecated
    public static final zzv zzb = new zzv();
    public static final zzad zzc = new zzad();
    private static final Api.ClientKey zzd;
    private static final Api.AbstractClientBuilder zze;

    /* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
    public static final class WalletOptions implements Api.ApiOptions.HasAccountOptions {
        public final int environment;
        public final int theme;
        public final Account zza;
        final boolean zzb;

        /* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
        public static final class Builder {
            /* access modifiers changed from: private */
            public int zza = 3;
            /* access modifiers changed from: private */
            public int zzb = 1;
            /* access modifiers changed from: private */
            public boolean zzc = true;

            public WalletOptions build() {
                return new WalletOptions(this);
            }

            public Builder setEnvironment(int i) {
                if (i != 0) {
                    if (i == 0) {
                        i = 0;
                    } else if (!(i == 2 || i == 1 || i == 23 || i == 3)) {
                        throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(i)}));
                    }
                }
                this.zza = i;
                return this;
            }

            public Builder setTheme(int i) {
                if (i == 0 || i == 1 || i == 2 || i == 3) {
                    this.zzb = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(i)}));
            }

            @Deprecated
            public Builder useGoogleWallet() {
                this.zzc = false;
                return this;
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zza;
            this.theme = builder.zzb;
            this.zzb = builder.zzc;
            this.zza = null;
        }

        public boolean equals(Object obj) {
            if (obj instanceof WalletOptions) {
                WalletOptions walletOptions = (WalletOptions) obj;
                if (Objects.equal(Integer.valueOf(this.environment), Integer.valueOf(walletOptions.environment)) && Objects.equal(Integer.valueOf(this.theme), Integer.valueOf(walletOptions.theme))) {
                    Account account = walletOptions.zza;
                    if (!Objects.equal((Object) null, (Object) null) || !Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(walletOptions.zzb))) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        public Account getAccount() {
            return null;
        }

        public int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.environment), Integer.valueOf(this.theme), null, Boolean.valueOf(this.zzb));
        }
    }

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzd = clientKey;
        zzap zzap = new zzap();
        zze = zzap;
        API = new Api<>("Wallet.API", zzap, clientKey);
    }

    private Wallet() {
    }

    public static PaymentsClient getPaymentsClient(Activity activity, WalletOptions walletOptions) {
        return new PaymentsClient(activity, walletOptions);
    }

    public static WalletObjectsClient getWalletObjectsClient(Activity activity, WalletOptions walletOptions) {
        return new WalletObjectsClient(activity, walletOptions);
    }

    public static PaymentsClient getPaymentsClient(Context context, WalletOptions walletOptions) {
        return new PaymentsClient(context, walletOptions);
    }
}
