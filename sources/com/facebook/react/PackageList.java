package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import cl.json.RNSharePackage;
import com.BV.LinearGradient.LinearGradientPackage;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilPackage;
import com.agontuk.RNFusedLocation.RNFusedLocationPackage;
import com.babisoft.ReactNativeLocalization.ReactNativeLocalizationPackage;
import com.brentvatne.react.ReactVideoPackage;
import com.cardio.RNCardIOPackage;
import com.dylanvann.fastimage.FastImageViewPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.henninghall.date_picker.DatePickerPackage;
import com.horcrux.svg.SvgPackage;
import com.imagepicker.ImagePickerPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.lugg.ReactNativeConfig.ReactNativeConfigPackage;
import com.masteratul.exceptionhandler.ReactNativeExceptionHandlerPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.geolocation.GeolocationPackage;
import com.reactnativecommunity.picker.RNCPickerPackage;
import com.reactnativecommunity.slider.ReactSliderPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativepagerview.PagerViewPackage;
import com.reactnativestripesdk.StripeSdkPackage;
import com.smarkets.paypal.RNPaypalPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.zoontek.rnpermissions.RNPermissionsPackage;
import io.invertase.firebase.RNFirebasePackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.devio.rn.splashscreen.SplashScreenReactPackage;
import org.reactnative.camera.RNCameraPackage;
import org.reactnative.maskedview.RNCMaskedViewPackage;
import org.wonday.orientation.OrientationPackage;
import org.wonday.pdf.RCTPdfView;

public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost2) {
        this(reactNativeHost2, (MainPackageConfig) null);
    }

    public PackageList(Application application2) {
        this(application2, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost2, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost2;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application2, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application2;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost2 = this.reactNativeHost;
        if (reactNativeHost2 == null) {
            return this.application;
        }
        return reactNativeHost2.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new ReactPackage[]{new MainReactPackage(this.mConfig), new AsyncStoragePackage(), new GeolocationPackage(), new RNCMaskedViewPackage(), new ReactSliderPackage(), new RNCPickerPackage(), new StripeSdkPackage(), new RNCardIOPackage(), new ReactNativeBlobUtilPackage(), new RNCameraPackage(), new ReactNativeConfigPackage(), new DatePickerPackage(), new RNDeviceInfo(), new ReactNativeExceptionHandlerPackage(), new FastImageViewPackage(), new RNFirebasePackage(), new RNFusedLocationPackage(), new RNGestureHandlerPackage(), new ImagePickerPackage(), new LinearGradientPackage(), new ReactNativeLocalizationPackage(), new OrientationPackage(), new PagerViewPackage(), new RNPaypalPackage(), new RCTPdfView(), new RNPermissionsPackage(), new ReanimatedPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RNSharePackage(), new SplashScreenReactPackage(), new SvgPackage(), new VectorIconsPackage(), new ReactVideoPackage(), new RNCWebViewPackage()}));
    }
}
