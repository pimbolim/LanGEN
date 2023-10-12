package io.invertase.firebase.admob;

import android.app.Activity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import io.invertase.firebase.Utils;
import javax.annotation.Nullable;

public class RNFirebaseAdMobRewardedVideo implements RewardedVideoAdListener {
    private RNFirebaseAdMob adMob;
    /* access modifiers changed from: private */
    public String adUnit;
    /* access modifiers changed from: private */
    public RewardedVideoAd rewardedVideo;

    RNFirebaseAdMobRewardedVideo(String str, RNFirebaseAdMob rNFirebaseAdMob) {
        this.adUnit = str;
        this.adMob = rNFirebaseAdMob;
        Activity activity = rNFirebaseAdMob.getActivity();
        if (activity == null) {
            this.rewardedVideo = MobileAds.getRewardedVideoAdInstance(this.adMob.getContext());
        } else {
            this.rewardedVideo = MobileAds.getRewardedVideoAdInstance(activity);
        }
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    RNFirebaseAdMobRewardedVideo.this.rewardedVideo.setRewardedVideoAdListener(this);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void loadAd(final AdRequest adRequest) {
        Activity activity = this.adMob.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    RNFirebaseAdMobRewardedVideo.this.rewardedVideo.loadAd(RNFirebaseAdMobRewardedVideo.this.adUnit, adRequest);
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
                    if (RNFirebaseAdMobRewardedVideo.this.rewardedVideo.isLoaded()) {
                        RNFirebaseAdMobRewardedVideo.this.rewardedVideo.show();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void setCustomData(final String str) {
        Activity activity = this.adMob.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    RNFirebaseAdMobRewardedVideo.this.rewardedVideo.setCustomData(str);
                }
            });
        }
    }

    public void onRewarded(RewardItem rewardItem) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(BaseSheetViewModel.SAVE_AMOUNT, rewardItem.getAmount());
        createMap.putString("type", rewardItem.getType());
        sendEvent("onRewarded", createMap);
    }

    public void onRewardedVideoAdLeftApplication() {
        sendEvent("onAdLeftApplication", (WritableMap) null);
    }

    public void onRewardedVideoAdClosed() {
        sendEvent("onAdClosed", (WritableMap) null);
    }

    public void onRewardedVideoCompleted() {
        sendEvent("onAdCompleted", (WritableMap) null);
    }

    public void onRewardedVideoAdFailedToLoad(int i) {
        sendEvent("onAdFailedToLoad", RNFirebaseAdMobUtils.errorCodeToMap(i));
    }

    public void onRewardedVideoAdLoaded() {
        sendEvent("onAdLoaded", (WritableMap) null);
    }

    public void onRewardedVideoAdOpened() {
        sendEvent("onAdOpened", (WritableMap) null);
    }

    public void onRewardedVideoStarted() {
        sendEvent("onRewardedVideoStarted", (WritableMap) null);
    }

    private void sendEvent(String str, @Nullable WritableMap writableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", str);
        createMap.putString("adUnit", this.adUnit);
        if (writableMap != null) {
            createMap.putMap("payload", writableMap);
        }
        Utils.sendEvent(this.adMob.getContext(), "rewarded_video_event", createMap);
    }
}
