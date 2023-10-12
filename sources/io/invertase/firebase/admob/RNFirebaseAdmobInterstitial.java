package io.invertase.firebase.admob;

import android.app.Activity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import io.invertase.firebase.Utils;
import javax.annotation.Nullable;

class RNFirebaseAdmobInterstitial {
    private RNFirebaseAdMob adMob;
    private String adUnit;
    /* access modifiers changed from: private */
    public InterstitialAd interstitialAd;

    RNFirebaseAdmobInterstitial(String str, RNFirebaseAdMob rNFirebaseAdMob) {
        this.adUnit = str;
        this.adMob = rNFirebaseAdMob;
        Activity activity = rNFirebaseAdMob.getActivity();
        if (activity == null) {
            this.interstitialAd = new InterstitialAd(this.adMob.getContext());
        } else {
            this.interstitialAd = new InterstitialAd(activity);
        }
        this.interstitialAd.setAdUnitId(this.adUnit);
        this.interstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                RNFirebaseAdmobInterstitial.this.sendEvent("onAdLoaded", (WritableMap) null);
            }

            public void onAdOpened() {
                RNFirebaseAdmobInterstitial.this.sendEvent("onAdOpened", (WritableMap) null);
            }

            public void onAdLeftApplication() {
                RNFirebaseAdmobInterstitial.this.sendEvent("onAdLeftApplication", (WritableMap) null);
            }

            public void onAdClosed() {
                RNFirebaseAdmobInterstitial.this.sendEvent("onAdClosed", (WritableMap) null);
            }

            public void onAdFailedToLoad(int i) {
                RNFirebaseAdmobInterstitial.this.sendEvent("onAdFailedToLoad", RNFirebaseAdMobUtils.errorCodeToMap(i));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void loadAd(final AdRequest adRequest) {
        Activity activity = this.adMob.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    RNFirebaseAdmobInterstitial.this.interstitialAd.loadAd(adRequest);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void show() {
        Activity activity = this.adMob.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (RNFirebaseAdmobInterstitial.this.interstitialAd.isLoaded()) {
                        RNFirebaseAdmobInterstitial.this.interstitialAd.show();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void sendEvent(String str, @Nullable WritableMap writableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", str);
        createMap.putString("adUnit", this.adUnit);
        if (writableMap != null) {
            createMap.putMap("payload", writableMap);
        }
        Utils.sendEvent(this.adMob.getContext(), "interstitial_event", createMap);
    }
}
