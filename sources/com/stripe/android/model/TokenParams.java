package com.stripe.android.model;

import android.os.Parcelable;
import com.stripe.android.model.Token;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0003\u001a\u00020\u00048\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/model/TokenParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "tokenType", "Lcom/stripe/android/model/Token$Type;", "attribution", "", "", "(Lcom/stripe/android/model/Token$Type;Ljava/util/Set;)V", "getAttribution", "()Ljava/util/Set;", "getTokenType", "()Lcom/stripe/android/model/Token$Type;", "typeDataParams", "", "", "getTypeDataParams", "()Ljava/util/Map;", "toParamMap", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TokenParams.kt */
public abstract class TokenParams implements StripeParamsModel, Parcelable {
    private final Set<String> attribution;
    private final Token.Type tokenType;

    public abstract Map<String, Object> getTypeDataParams();

    public TokenParams(Token.Type type, Set<String> set) {
        Intrinsics.checkNotNullParameter(type, "tokenType");
        Intrinsics.checkNotNullParameter(set, "attribution");
        this.tokenType = type;
        this.attribution = set;
    }

    public final Token.Type getTokenType() {
        return this.tokenType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TokenParams(Token.Type type, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, (i & 2) != 0 ? SetsKt.emptySet() : set);
    }

    public final Set<String> getAttribution() {
        return this.attribution;
    }

    public Map<String, Object> toParamMap() {
        return MapsKt.mapOf(TuplesKt.to(this.tokenType.getCode(), getTypeDataParams()));
    }
}
