package com.stripe.android.link;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.os.BundleKt;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.link.LinkActivityResult;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.view.ActivityStarter;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/link/LinkActivityContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/link/LinkActivityContract$Args;", "Lcom/stripe/android/link/LinkActivityResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "Companion", "Result", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkActivityContract.kt */
public final class LinkActivityContract extends ActivityResultContract<Args, LinkActivityResult> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_ARGS = "com.stripe.android.link.LinkActivityContract.extra_args";
    public static final String EXTRA_RESULT = "com.stripe.android.link.LinkActivityContract.extra_result";

    public Intent createIntent(Context context, Args args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, GraphQLConstants.Keys.INPUT);
        Intent putExtra = new Intent(context, LinkActivity.class).putExtra(EXTRA_ARGS, args);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, LinkActi…tExtra(EXTRA_ARGS, input)");
        return putExtra;
    }

    public LinkActivityResult parseResult(int i, Intent intent) {
        Result result;
        LinkActivityResult linkActivityResult = null;
        if (!(intent == null || (result = (Result) intent.getParcelableExtra(EXTRA_RESULT)) == null)) {
            linkActivityResult = result.getLinkResult();
        }
        return linkActivityResult == null ? LinkActivityResult.Canceled.INSTANCE : linkActivityResult;
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 '2\u00020\u0001:\u0002'(B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0002\b\u0018J5\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006)"}, d2 = {"Lcom/stripe/android/link/LinkActivityContract$Args;", "Lcom/stripe/android/view/ActivityStarter$Args;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "merchantName", "", "customerEmail", "injectionParams", "Lcom/stripe/android/link/LinkActivityContract$Args$InjectionParams;", "(Lcom/stripe/android/model/StripeIntent;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/link/LinkActivityContract$Args$InjectionParams;)V", "getCustomerEmail$link_release", "()Ljava/lang/String;", "getInjectionParams$link_release", "()Lcom/stripe/android/link/LinkActivityContract$Args$InjectionParams;", "getMerchantName$link_release", "getStripeIntent$link_release", "()Lcom/stripe/android/model/StripeIntent;", "component1", "component1$link_release", "component2", "component2$link_release", "component3", "component3$link_release", "component4", "component4$link_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "InjectionParams", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkActivityContract.kt */
    public static final class Args implements ActivityStarter.Args {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String customerEmail;
        private final InjectionParams injectionParams;
        private final String merchantName;
        private final StripeIntent stripeIntent;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkActivityContract.kt */
        public static final class Creator implements Parcelable.Creator<Args> {
            public final Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Args((StripeIntent) parcel.readParcelable(Args.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : InjectionParams.CREATOR.createFromParcel(parcel));
            }

            public final Args[] newArray(int i) {
                return new Args[i];
            }
        }

        public static /* synthetic */ Args copy$default(Args args, StripeIntent stripeIntent2, String str, String str2, InjectionParams injectionParams2, int i, Object obj) {
            if ((i & 1) != 0) {
                stripeIntent2 = args.stripeIntent;
            }
            if ((i & 2) != 0) {
                str = args.merchantName;
            }
            if ((i & 4) != 0) {
                str2 = args.customerEmail;
            }
            if ((i & 8) != 0) {
                injectionParams2 = args.injectionParams;
            }
            return args.copy(stripeIntent2, str, str2, injectionParams2);
        }

        public final StripeIntent component1$link_release() {
            return this.stripeIntent;
        }

        public final String component2$link_release() {
            return this.merchantName;
        }

        public final String component3$link_release() {
            return this.customerEmail;
        }

        public final InjectionParams component4$link_release() {
            return this.injectionParams;
        }

        public final Args copy(StripeIntent stripeIntent2, String str, String str2, InjectionParams injectionParams2) {
            Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
            Intrinsics.checkNotNullParameter(str, "merchantName");
            return new Args(stripeIntent2, str, str2, injectionParams2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Args)) {
                return false;
            }
            Args args = (Args) obj;
            return Intrinsics.areEqual((Object) this.stripeIntent, (Object) args.stripeIntent) && Intrinsics.areEqual((Object) this.merchantName, (Object) args.merchantName) && Intrinsics.areEqual((Object) this.customerEmail, (Object) args.customerEmail) && Intrinsics.areEqual((Object) this.injectionParams, (Object) args.injectionParams);
        }

        public int hashCode() {
            int hashCode = ((this.stripeIntent.hashCode() * 31) + this.merchantName.hashCode()) * 31;
            String str = this.customerEmail;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            InjectionParams injectionParams2 = this.injectionParams;
            if (injectionParams2 != null) {
                i = injectionParams2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Args(stripeIntent=" + this.stripeIntent + ", merchantName=" + this.merchantName + ", customerEmail=" + this.customerEmail + ", injectionParams=" + this.injectionParams + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.stripeIntent, i);
            parcel.writeString(this.merchantName);
            parcel.writeString(this.customerEmail);
            InjectionParams injectionParams2 = this.injectionParams;
            if (injectionParams2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            injectionParams2.writeToParcel(parcel, i);
        }

        public Args(StripeIntent stripeIntent2, String str, String str2, InjectionParams injectionParams2) {
            Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
            Intrinsics.checkNotNullParameter(str, "merchantName");
            this.stripeIntent = stripeIntent2;
            this.merchantName = str;
            this.customerEmail = str2;
            this.injectionParams = injectionParams2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Args(StripeIntent stripeIntent2, String str, String str2, InjectionParams injectionParams2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(stripeIntent2, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : injectionParams2);
        }

        public final StripeIntent getStripeIntent$link_release() {
            return this.stripeIntent;
        }

        public final String getMerchantName$link_release() {
            return this.merchantName;
        }

        public final String getCustomerEmail$link_release() {
            return this.customerEmail;
        }

        public final InjectionParams getInjectionParams$link_release() {
            return this.injectionParams;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/link/LinkActivityContract$Args$Companion;", "", "()V", "fromIntent", "Lcom/stripe/android/link/LinkActivityContract$Args;", "intent", "Landroid/content/Intent;", "fromIntent$link_release", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkActivityContract.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Args fromIntent$link_release(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                return (Args) intent.getParcelableExtra(LinkActivityContract.EXTRA_ARGS);
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006%"}, d2 = {"Lcom/stripe/android/link/LinkActivityContract$Args$InjectionParams;", "Landroid/os/Parcelable;", "injectorKey", "", "productUsage", "", "enableLogging", "", "publishableKey", "stripeAccountId", "(Ljava/lang/String;Ljava/util/Set;ZLjava/lang/String;Ljava/lang/String;)V", "getEnableLogging", "()Z", "getInjectorKey", "()Ljava/lang/String;", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "getStripeAccountId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkActivityContract.kt */
        public static final class InjectionParams implements Parcelable {
            public static final Parcelable.Creator<InjectionParams> CREATOR = new Creator();
            private final boolean enableLogging;
            private final String injectorKey;
            private final Set<String> productUsage;
            private final String publishableKey;
            private final String stripeAccountId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: LinkActivityContract.kt */
            public static final class Creator implements Parcelable.Creator<InjectionParams> {
                public final InjectionParams createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new InjectionParams(readString, linkedHashSet, parcel.readInt() != 0, parcel.readString(), parcel.readString());
                }

                public final InjectionParams[] newArray(int i) {
                    return new InjectionParams[i];
                }
            }

            public static /* synthetic */ InjectionParams copy$default(InjectionParams injectionParams, String str, Set<String> set, boolean z, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = injectionParams.injectorKey;
                }
                if ((i & 2) != 0) {
                    set = injectionParams.productUsage;
                }
                Set<String> set2 = set;
                if ((i & 4) != 0) {
                    z = injectionParams.enableLogging;
                }
                boolean z2 = z;
                if ((i & 8) != 0) {
                    str2 = injectionParams.publishableKey;
                }
                String str4 = str2;
                if ((i & 16) != 0) {
                    str3 = injectionParams.stripeAccountId;
                }
                return injectionParams.copy(str, set2, z2, str4, str3);
            }

            public final String component1() {
                return this.injectorKey;
            }

            public final Set<String> component2() {
                return this.productUsage;
            }

            public final boolean component3() {
                return this.enableLogging;
            }

            public final String component4() {
                return this.publishableKey;
            }

            public final String component5() {
                return this.stripeAccountId;
            }

            public final InjectionParams copy(@InjectorKey String str, Set<String> set, boolean z, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "injectorKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                Intrinsics.checkNotNullParameter(str2, "publishableKey");
                return new InjectionParams(str, set, z, str2, str3);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InjectionParams)) {
                    return false;
                }
                InjectionParams injectionParams = (InjectionParams) obj;
                return Intrinsics.areEqual((Object) this.injectorKey, (Object) injectionParams.injectorKey) && Intrinsics.areEqual((Object) this.productUsage, (Object) injectionParams.productUsage) && this.enableLogging == injectionParams.enableLogging && Intrinsics.areEqual((Object) this.publishableKey, (Object) injectionParams.publishableKey) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) injectionParams.stripeAccountId);
            }

            public int hashCode() {
                int hashCode = ((this.injectorKey.hashCode() * 31) + this.productUsage.hashCode()) * 31;
                boolean z = this.enableLogging;
                if (z) {
                    z = true;
                }
                int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.publishableKey.hashCode()) * 31;
                String str = this.stripeAccountId;
                return hashCode2 + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "InjectionParams(injectorKey=" + this.injectorKey + ", productUsage=" + this.productUsage + ", enableLogging=" + this.enableLogging + ", publishableKey=" + this.publishableKey + ", stripeAccountId=" + this.stripeAccountId + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.injectorKey);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
                parcel.writeInt(this.enableLogging ? 1 : 0);
                parcel.writeString(this.publishableKey);
                parcel.writeString(this.stripeAccountId);
            }

            public InjectionParams(@InjectorKey String str, Set<String> set, boolean z, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "injectorKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                Intrinsics.checkNotNullParameter(str2, "publishableKey");
                this.injectorKey = str;
                this.productUsage = set;
                this.enableLogging = z;
                this.publishableKey = str2;
                this.stripeAccountId = str3;
            }

            public final String getInjectorKey() {
                return this.injectorKey;
            }

            public final Set<String> getProductUsage() {
                return this.productUsage;
            }

            public final boolean getEnableLogging() {
                return this.enableLogging;
            }

            public final String getPublishableKey() {
                return this.publishableKey;
            }

            public final String getStripeAccountId() {
                return this.stripeAccountId;
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/link/LinkActivityContract$Result;", "Lcom/stripe/android/view/ActivityStarter$Result;", "linkResult", "Lcom/stripe/android/link/LinkActivityResult;", "(Lcom/stripe/android/link/LinkActivityResult;)V", "getLinkResult", "()Lcom/stripe/android/link/LinkActivityResult;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkActivityContract.kt */
    public static final class Result implements ActivityStarter.Result {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Result> CREATOR = new Creator();
        private final LinkActivityResult linkResult;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkActivityContract.kt */
        public static final class Creator implements Parcelable.Creator<Result> {
            public final Result createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Result((LinkActivityResult) parcel.readParcelable(Result.class.getClassLoader()));
            }

            public final Result[] newArray(int i) {
                return new Result[i];
            }
        }

        public static /* synthetic */ Result copy$default(Result result, LinkActivityResult linkActivityResult, int i, Object obj) {
            if ((i & 1) != 0) {
                linkActivityResult = result.linkResult;
            }
            return result.copy(linkActivityResult);
        }

        public final LinkActivityResult component1() {
            return this.linkResult;
        }

        public final Result copy(LinkActivityResult linkActivityResult) {
            Intrinsics.checkNotNullParameter(linkActivityResult, "linkResult");
            return new Result(linkActivityResult);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Result) && Intrinsics.areEqual((Object) this.linkResult, (Object) ((Result) obj).linkResult);
        }

        public int hashCode() {
            return this.linkResult.hashCode();
        }

        public String toString() {
            return "Result(linkResult=" + this.linkResult + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.linkResult, i);
        }

        public Result(LinkActivityResult linkActivityResult) {
            Intrinsics.checkNotNullParameter(linkActivityResult, "linkResult");
            this.linkResult = linkActivityResult;
        }

        public final LinkActivityResult getLinkResult() {
            return this.linkResult;
        }

        public Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to(LinkActivityContract.EXTRA_RESULT, this));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/link/LinkActivityContract$Companion;", "", "()V", "EXTRA_ARGS", "", "EXTRA_RESULT", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkActivityContract.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
