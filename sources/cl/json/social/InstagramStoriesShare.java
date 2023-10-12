package cl.json.social;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import cl.json.ShareFile;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.appstate.AppStateModule;

public class InstagramStoriesShare extends SingleShareIntent {
    private static final String PACKAGE = "com.instagram.android";
    private static final String PLAY_STORE_LINK = "https://play.google.com/store/apps/details?id=com.instagram.android";

    /* access modifiers changed from: protected */
    public String getDefaultWebLink() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getPackage() {
        return PACKAGE;
    }

    /* access modifiers changed from: protected */
    public String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }

    public InstagramStoriesShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        setIntent(new Intent("com.instagram.share.ADD_TO_STORY"));
    }

    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        shareStory(readableMap);
        openIntentChooser(readableMap);
    }

    private void shareStory(ReadableMap readableMap) {
        String str;
        if (hasValidKey("backgroundImage", readableMap) || hasValidKey("backgroundVideo", readableMap) || hasValidKey("stickerImage", readableMap)) {
            Activity currentActivity = this.reactContext.getCurrentActivity();
            boolean z = false;
            if (currentActivity == null) {
                TargetChosenReceiver.sendCallback(false, "Something went wrong");
                return;
            }
            this.intent.putExtra("bottom_background_color", "#906df4");
            this.intent.putExtra("top_background_color", "#837DF4");
            if (hasValidKey("attributionURL", readableMap)) {
                this.intent.putExtra("content_url", readableMap.getString("attributionURL"));
            }
            if (hasValidKey("backgroundTopColor", readableMap)) {
                this.intent.putExtra("top_background_color", readableMap.getString("backgroundTopColor"));
            }
            if (hasValidKey("backgroundBottomColor", readableMap)) {
                this.intent.putExtra("bottom_background_color", readableMap.getString("backgroundBottomColor"));
            }
            if (hasValidKey("backgroundImage", readableMap) || hasValidKey("backgroundVideo", readableMap)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            if (valueOf.booleanValue()) {
                if (hasValidKey("backgroundImage", readableMap)) {
                    str = readableMap.getString("backgroundImage");
                } else {
                    str = hasValidKey("backgroundVideo", readableMap) ? readableMap.getString("backgroundVideo") : "";
                }
                ShareFile shareFile = new ShareFile(str, AppStateModule.APP_STATE_BACKGROUND, this.reactContext);
                this.intent.setDataAndType(shareFile.getURI(), shareFile.getType());
                this.intent.setFlags(1);
            }
            if (hasValidKey("stickerImage", readableMap)) {
                ShareFile shareFile2 = new ShareFile(readableMap.getString("stickerImage"), "sticker", this.reactContext);
                if (!valueOf.booleanValue()) {
                    this.intent.setType("image/*");
                }
                this.intent.putExtra("interactive_asset_uri", shareFile2.getURI());
                currentActivity.grantUriPermission(PACKAGE, shareFile2.getURI(), 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid background or sticker assets provided.");
    }
}
