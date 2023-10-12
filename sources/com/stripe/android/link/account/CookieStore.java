package com.stripe.android.link.account;

import java.security.MessageDigest;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0017\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fJ\f\u0010\u0010\u001a\u00020\u0006*\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/link/account/CookieStore;", "", "store", "Lcom/stripe/android/link/account/EncryptedStore;", "(Lcom/stripe/android/link/account/EncryptedStore;)V", "getAuthSessionCookie", "", "isEmailLoggedOut", "", "email", "logout", "", "storeLoggedOutEmail", "updateAuthSessionCookie", "cookie", "(Ljava/lang/String;)Lkotlin/Unit;", "sha256", "Companion", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CookieStore.kt */
public final class CookieStore {
    public static final String AUTH_SESSION_COOKIE = "auth_session_cookie";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOGGED_OUT_EMAIL_HASH = "logged_out_email_hash";
    private final EncryptedStore store;

    @Inject
    public CookieStore(EncryptedStore encryptedStore) {
        Intrinsics.checkNotNullParameter(encryptedStore, "store");
        this.store = encryptedStore;
    }

    public final Unit updateAuthSessionCookie(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            this.store.delete(AUTH_SESSION_COOKIE);
        } else {
            this.store.write(AUTH_SESSION_COOKIE, str);
        }
        return Unit.INSTANCE;
    }

    public final String getAuthSessionCookie() {
        return this.store.read(AUTH_SESSION_COOKIE);
    }

    public final void logout(String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        storeLoggedOutEmail(str);
        this.store.delete(AUTH_SESSION_COOKIE);
    }

    public final boolean isEmailLoggedOut(String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        return Intrinsics.areEqual((Object) this.store.read(LOGGED_OUT_EMAIL_HASH), (Object) sha256(str));
    }

    private final void storeLoggedOutEmail(String str) {
        this.store.write(LOGGED_OUT_EMAIL_HASH, sha256(str));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/link/account/CookieStore$Companion;", "", "()V", "AUTH_SESSION_COOKIE", "", "LOGGED_OUT_EMAIL_HASH", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CookieStore.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final String sha256(String str) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "getInstance(\"SHA-256\").d…yteArray(Charsets.UTF_8))");
        return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) CookieStore$sha256$1.INSTANCE, 30, (Object) null);
    }
}
