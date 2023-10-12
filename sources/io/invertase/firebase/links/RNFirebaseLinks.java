package io.invertase.firebase.links;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.appinvite.FirebaseAppInvite;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import io.invertase.firebase.Utils;
import javax.annotation.Nonnull;
import org.bouncycastle.i18n.MessageBundle;

public class RNFirebaseLinks extends ReactContextBaseJavaModule implements ActivityEventListener, LifecycleEventListener {
    /* access modifiers changed from: private */
    public static final String TAG = "io.invertase.firebase.links.RNFirebaseLinks";
    /* access modifiers changed from: private */
    public String mInitialLink = null;
    /* access modifiers changed from: private */
    public boolean mInitialLinkInitialized = false;

    public String getName() {
        return "RNFirebaseLinks";
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public RNFirebaseLinks(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        getReactApplicationContext().addActivityEventListener(this);
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    @ReactMethod
    public void createDynamicLink(ReadableMap readableMap, Promise promise) {
        try {
            String uri = getDynamicLinkBuilder(readableMap).buildDynamicLink().getUri().toString();
            String str = TAG;
            Log.d(str, "created dynamic link: " + uri);
            promise.resolve(uri);
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "create dynamic link failure " + e.getMessage());
            promise.reject("links/failure", e.getMessage(), (Throwable) e);
        }
    }

    @ReactMethod
    public void createShortDynamicLink(ReadableMap readableMap, String str, final Promise promise) {
        Task task;
        try {
            DynamicLink.Builder dynamicLinkBuilder = getDynamicLinkBuilder(readableMap);
            if ("SHORT".equals(str)) {
                task = dynamicLinkBuilder.buildShortDynamicLink(2);
            } else if ("UNGUESSABLE".equals(str)) {
                task = dynamicLinkBuilder.buildShortDynamicLink(1);
            } else {
                task = dynamicLinkBuilder.buildShortDynamicLink();
            }
            task.addOnCompleteListener(new OnCompleteListener<ShortDynamicLink>() {
                public void onComplete(@Nonnull Task<ShortDynamicLink> task) {
                    if (task.isSuccessful()) {
                        String uri = task.getResult().getShortLink().toString();
                        String access$000 = RNFirebaseLinks.TAG;
                        Log.d(access$000, "created short dynamic link: " + uri);
                        promise.resolve(uri);
                        return;
                    }
                    String access$0002 = RNFirebaseLinks.TAG;
                    Log.e(access$0002, "create short dynamic link failure " + task.getException().getMessage());
                    promise.reject("links/failure", task.getException().getMessage(), (Throwable) task.getException());
                }
            });
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "create short dynamic link failure " + e.getMessage());
            promise.reject("links/failure", e.getMessage(), (Throwable) e);
        }
    }

    @ReactMethod
    public void getInitialLink(final Promise promise) {
        if (this.mInitialLinkInitialized) {
            promise.resolve(this.mInitialLink);
        } else if (getCurrentActivity() != null) {
            FirebaseDynamicLinks.getInstance().getDynamicLink(getCurrentActivity().getIntent()).addOnSuccessListener(new OnSuccessListener<PendingDynamicLinkData>() {
                public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                    if (pendingDynamicLinkData != null && !RNFirebaseLinks.this.isInvitation(pendingDynamicLinkData)) {
                        String unused = RNFirebaseLinks.this.mInitialLink = pendingDynamicLinkData.getLink().toString();
                    }
                    String access$000 = RNFirebaseLinks.TAG;
                    Log.d(access$000, "getInitialLink: link is: " + RNFirebaseLinks.this.mInitialLink);
                    boolean unused2 = RNFirebaseLinks.this.mInitialLinkInitialized = true;
                    promise.resolve(RNFirebaseLinks.this.mInitialLink);
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(@Nonnull Exception exc) {
                    Log.e(RNFirebaseLinks.TAG, "getInitialLink: failed to resolve link", exc);
                    promise.reject("link/initial-link-error", exc.getMessage(), (Throwable) exc);
                }
            });
        } else {
            Log.d(TAG, "getInitialLink: activity is null");
            promise.resolve((Object) null);
        }
    }

    public void onNewIntent(Intent intent) {
        FirebaseDynamicLinks.getInstance().getDynamicLink(intent).addOnSuccessListener(new OnSuccessListener<PendingDynamicLinkData>() {
            public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                if (pendingDynamicLinkData != null && !RNFirebaseLinks.this.isInvitation(pendingDynamicLinkData)) {
                    Utils.sendEvent(RNFirebaseLinks.this.getReactApplicationContext(), "links_link_received", pendingDynamicLinkData.getLink().toString());
                }
            }
        });
    }

    public void onHostDestroy() {
        this.mInitialLink = null;
        this.mInitialLinkInitialized = false;
    }

    /* access modifiers changed from: private */
    public boolean isInvitation(PendingDynamicLinkData pendingDynamicLinkData) {
        FirebaseAppInvite invitation = FirebaseAppInvite.getInvitation(pendingDynamicLinkData);
        return (invitation == null || invitation.getInvitationId() == null || invitation.getInvitationId().isEmpty()) ? false : true;
    }

    private DynamicLink.Builder getDynamicLinkBuilder(ReadableMap readableMap) {
        DynamicLink.Builder createDynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink();
        try {
            createDynamicLink.setLink(Uri.parse(readableMap.getString("link")));
            createDynamicLink.setDomainUriPrefix(readableMap.getString("domainURIPrefix"));
            setAnalyticsParameters(readableMap.getMap("analytics"), createDynamicLink);
            setAndroidParameters(readableMap.getMap("android"), createDynamicLink);
            setIosParameters(readableMap.getMap("ios"), createDynamicLink);
            setITunesParameters(readableMap.getMap("itunes"), createDynamicLink);
            setNavigationParameters(readableMap.getMap(NotificationCompat.CATEGORY_NAVIGATION), createDynamicLink);
            setSocialParameters(readableMap.getMap(NotificationCompat.CATEGORY_SOCIAL), createDynamicLink);
            return createDynamicLink;
        } catch (Exception e) {
            String str = TAG;
            Log.e(str, "error while building parameters " + e.getMessage());
            throw e;
        }
    }

    private void setAnalyticsParameters(ReadableMap readableMap, DynamicLink.Builder builder) {
        DynamicLink.GoogleAnalyticsParameters.Builder builder2 = new DynamicLink.GoogleAnalyticsParameters.Builder();
        if (readableMap.hasKey(FirebaseAnalytics.Param.CAMPAIGN)) {
            builder2.setCampaign(readableMap.getString(FirebaseAnalytics.Param.CAMPAIGN));
        }
        if (readableMap.hasKey("content")) {
            builder2.setContent(readableMap.getString("content"));
        }
        if (readableMap.hasKey("medium")) {
            builder2.setMedium(readableMap.getString("medium"));
        }
        if (readableMap.hasKey("source")) {
            builder2.setSource(readableMap.getString("source"));
        }
        if (readableMap.hasKey(FirebaseAnalytics.Param.TERM)) {
            builder2.setTerm(readableMap.getString(FirebaseAnalytics.Param.TERM));
        }
        builder.setGoogleAnalyticsParameters(builder2.build());
    }

    private void setAndroidParameters(ReadableMap readableMap, DynamicLink.Builder builder) {
        if (readableMap.hasKey("packageName")) {
            DynamicLink.AndroidParameters.Builder builder2 = new DynamicLink.AndroidParameters.Builder(readableMap.getString("packageName"));
            if (readableMap.hasKey("fallbackUrl")) {
                builder2.setFallbackUrl(Uri.parse(readableMap.getString("fallbackUrl")));
            }
            if (readableMap.hasKey("minimumVersion")) {
                builder2.setMinimumVersion(Integer.parseInt(readableMap.getString("minimumVersion")));
            }
            builder.setAndroidParameters(builder2.build());
        }
    }

    private void setIosParameters(ReadableMap readableMap, DynamicLink.Builder builder) {
        if (readableMap.hasKey("bundleId")) {
            DynamicLink.IosParameters.Builder builder2 = new DynamicLink.IosParameters.Builder(readableMap.getString("bundleId"));
            if (readableMap.hasKey("appStoreId")) {
                builder2.setAppStoreId(readableMap.getString("appStoreId"));
            }
            if (readableMap.hasKey("customScheme")) {
                builder2.setCustomScheme(readableMap.getString("customScheme"));
            }
            if (readableMap.hasKey("fallbackUrl")) {
                builder2.setFallbackUrl(Uri.parse(readableMap.getString("fallbackUrl")));
            }
            if (readableMap.hasKey("iPadBundleId")) {
                builder2.setIpadBundleId(readableMap.getString("iPadBundleId"));
            }
            if (readableMap.hasKey("iPadFallbackUrl")) {
                builder2.setIpadFallbackUrl(Uri.parse(readableMap.getString("iPadFallbackUrl")));
            }
            if (readableMap.hasKey("minimumVersion")) {
                builder2.setMinimumVersion(readableMap.getString("minimumVersion"));
            }
            builder.setIosParameters(builder2.build());
        }
    }

    private void setITunesParameters(ReadableMap readableMap, DynamicLink.Builder builder) {
        DynamicLink.ItunesConnectAnalyticsParameters.Builder builder2 = new DynamicLink.ItunesConnectAnalyticsParameters.Builder();
        if (readableMap.hasKey("affiliateToken")) {
            builder2.setAffiliateToken(readableMap.getString("affiliateToken"));
        }
        if (readableMap.hasKey("campaignToken")) {
            builder2.setCampaignToken(readableMap.getString("campaignToken"));
        }
        if (readableMap.hasKey("providerToken")) {
            builder2.setProviderToken(readableMap.getString("providerToken"));
        }
        builder.setItunesConnectAnalyticsParameters(builder2.build());
    }

    private void setNavigationParameters(ReadableMap readableMap, DynamicLink.Builder builder) {
        DynamicLink.NavigationInfoParameters.Builder builder2 = new DynamicLink.NavigationInfoParameters.Builder();
        if (readableMap.hasKey("forcedRedirectEnabled")) {
            builder2.setForcedRedirectEnabled(readableMap.getBoolean("forcedRedirectEnabled"));
        }
        builder.setNavigationInfoParameters(builder2.build());
    }

    private void setSocialParameters(ReadableMap readableMap, DynamicLink.Builder builder) {
        DynamicLink.SocialMetaTagParameters.Builder builder2 = new DynamicLink.SocialMetaTagParameters.Builder();
        if (readableMap.hasKey("descriptionText")) {
            builder2.setDescription(readableMap.getString("descriptionText"));
        }
        if (readableMap.hasKey("imageUrl")) {
            builder2.setImageUrl(Uri.parse(readableMap.getString("imageUrl")));
        }
        if (readableMap.hasKey(MessageBundle.TITLE_ENTRY)) {
            builder2.setTitle(readableMap.getString(MessageBundle.TITLE_ENTRY));
        }
        builder.setSocialMetaTagParameters(builder2.build());
    }
}
