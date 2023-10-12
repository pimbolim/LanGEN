package com.stripe.android.stripe3ds2.init;

import android.os.Build;
import com.stripe.android.stripe3ds2.utils.Supplier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0017B\u0015\b\u0010\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u001d\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\bJ\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8@X\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8@X\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8@X\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/DeviceParamNotAvailableFactoryImpl;", "Lcom/stripe/android/stripe3ds2/init/DeviceParamNotAvailableFactory;", "hardwareIdSupplier", "Lcom/stripe/android/stripe3ds2/utils/Supplier;", "Lcom/stripe/android/stripe3ds2/init/HardwareId;", "(Lcom/stripe/android/stripe3ds2/utils/Supplier;)V", "apiVersion", "", "(ILcom/stripe/android/stripe3ds2/utils/Supplier;)V", "marketOrRegionRestrictionParams", "", "", "getMarketOrRegionRestrictionParams$3ds2sdk_release$annotations", "()V", "getMarketOrRegionRestrictionParams$3ds2sdk_release", "()Ljava/util/Map;", "permissionParams", "getPermissionParams$3ds2sdk_release$annotations", "getPermissionParams$3ds2sdk_release", "platformVersionParams", "getPlatformVersionParams$3ds2sdk_release$annotations", "getPlatformVersionParams$3ds2sdk_release", "create", "Reason", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceParamNotAvailableFactoryImpl.kt */
public final class DeviceParamNotAvailableFactoryImpl implements DeviceParamNotAvailableFactory {
    private final int apiVersion;
    private final Supplier<HardwareId> hardwareIdSupplier;

    public static /* synthetic */ void getMarketOrRegionRestrictionParams$3ds2sdk_release$annotations() {
    }

    public static /* synthetic */ void getPermissionParams$3ds2sdk_release$annotations() {
    }

    public static /* synthetic */ void getPlatformVersionParams$3ds2sdk_release$annotations() {
    }

    public DeviceParamNotAvailableFactoryImpl(int i, Supplier<HardwareId> supplier) {
        Intrinsics.checkNotNullParameter(supplier, "hardwareIdSupplier");
        this.apiVersion = i;
        this.hardwareIdSupplier = supplier;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeviceParamNotAvailableFactoryImpl(Supplier<HardwareId> supplier) {
        this(Build.VERSION.SDK_INT, supplier);
        Intrinsics.checkNotNullParameter(supplier, "hardwareIdSupplier");
    }

    public Map<String, String> create() {
        return MapsKt.plus(MapsKt.plus(getMarketOrRegionRestrictionParams$3ds2sdk_release(), getPlatformVersionParams$3ds2sdk_release()), getPermissionParams$3ds2sdk_release());
    }

    public final Map<String, String> getMarketOrRegionRestrictionParams$3ds2sdk_release() {
        HashMap hashMap = new HashMap();
        int i = 0;
        List listOf = CollectionsKt.listOf(DeviceParam.PARAM_PLATFORM, DeviceParam.PARAM_DEVICE_MODEL, DeviceParam.PARAM_OS_NAME, DeviceParam.PARAM_OS_VERSION, DeviceParam.PARAM_LOCALE, DeviceParam.PARAM_TIME_ZONE, DeviceParam.PARAM_HARDWARE_ID, DeviceParam.PARAM_SCREEN_RESOLUTION);
        DeviceParam[] values = DeviceParam.values();
        int length = values.length;
        while (i < length) {
            DeviceParam deviceParam = values[i];
            i++;
            if (!listOf.contains(deviceParam)) {
                hashMap.put(deviceParam.toString(), Reason.MARKET_OR_REGION_RESTRICTION.toString());
            }
        }
        return hashMap;
    }

    public final Map<String, String> getPlatformVersionParams$3ds2sdk_release() {
        HashMap hashMap = new HashMap();
        if (this.apiVersion < 26) {
            Map map = hashMap;
            map.put(DeviceParam.PARAM_TELE_IMEI_SV.toString(), Reason.PLATFORM_VERSION.toString());
            map.put(DeviceParam.PARAM_BUILD_SERIAL.toString(), Reason.PLATFORM_VERSION.toString());
            map.put(DeviceParam.PARAM_SECURE_INSTALL_NON_MARKET_APPS.toString(), Reason.PLATFORM_VERSION.toString());
        }
        if (this.apiVersion < 23) {
            Map map2 = hashMap;
            map2.put(DeviceParam.PARAM_TELE_PHONE_COUNT.toString(), Reason.PLATFORM_VERSION.toString());
            map2.put(DeviceParam.PARAM_TELE_IS_HEARING_AID_COMPATIBILITY_SUPPORTED.toString(), Reason.PLATFORM_VERSION.toString());
            map2.put(DeviceParam.PARAM_TELE_IS_TTY_MODE_SUPPORTED.toString(), Reason.PLATFORM_VERSION.toString());
            map2.put(DeviceParam.PARAM_TELE_IS_WORLD_PHONE.toString(), Reason.PLATFORM_VERSION.toString());
            map2.put(DeviceParam.PARAM_BUILD_VERSION_PREVIEW_SDK_INT.toString(), Reason.PLATFORM_VERSION.toString());
            map2.put(DeviceParam.PARAM_BUILD_VERSION_SDK_INT.toString(), Reason.PLATFORM_VERSION.toString());
            map2.put(DeviceParam.PARAM_BUILD_VERSION_SECURITY_PATCH.toString(), Reason.PLATFORM_VERSION.toString());
            map2.put(DeviceParam.PARAM_SYSTEM_DTMF_TONE_TYPE_WHEN_DIALING.toString(), Reason.PLATFORM_VERSION.toString());
            map2.put(DeviceParam.PARAM_SYSTEM_VIBRATE_WHEN_RINGING.toString(), Reason.PLATFORM_VERSION.toString());
        }
        if (this.apiVersion > 23) {
            hashMap.put(DeviceParam.PARAM_SECURE_SYS_PROP_SETTING_VERSION.toString(), Reason.PLATFORM_VERSION.toString());
        }
        if (this.apiVersion < 22) {
            hashMap.put(DeviceParam.PARAM_TELE_IS_VOICE_CAPABLE.toString(), Reason.PLATFORM_VERSION.toString());
        }
        return hashMap;
    }

    public final Map<String, String> getPermissionParams$3ds2sdk_release() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(DeviceParam.PARAM_WIFI_MAC.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_WIFI_BSSID.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_WIFI_SSID.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_WIFI_NETWORK_ID.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_WIFI_IS_5GHZ_BAND_SUPPORTED.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_WIFI_IS_DEVICE_TO_AP_RTT_SUPPORTED.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_WIFI_IS_ENHANCED_POWER_REPORTING_SUPPORTED.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_WIFI_IS_P2P_SUPPORTED.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_WIFI_IS_PREFERRED_NETWORK_OFFLOAD_SUPPORTED.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_WIFI_IS_SCAN_ALWAYS_AVAILABLE.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_WIFI_IS_TDLS_SUPPORTED.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_LATITUDE.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_LONGITUDE.toString(), Reason.PERMISSION.toString());
        if (!this.hardwareIdSupplier.get().isPresent()) {
            hashMap.put(DeviceParam.PARAM_HARDWARE_ID.toString(), Reason.PLATFORM_VERSION.toString());
        }
        hashMap.put(DeviceParam.PARAM_DEVICE_NAME.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_BLUETOOTH_ADDRESS.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_BLUETOOTH_BONDED_DEVICE.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_BLUETOOTH_IS_ENABLED.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_TELE_DEVICE_ID.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_TELE_SUBSCRIBER_ID.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_TELE_IMEI_SV.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_TELE_GROUP_IDENTIFIER_L1.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_TELE_SIM_SERIAL_NUMBER.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_TELE_VOICE_MAIL_ALPHA_TAG.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_TELE_VOICE_MAIL_NUMBER.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_TELE_IS_TTY_MODE_SUPPORTED.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_TELE_IS_WORLD_PHONE.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_BUILD_SERIAL.toString(), Reason.PERMISSION.toString());
        hashMap.put(DeviceParam.PARAM_SECURE_INSTALL_NON_MARKET_APPS.toString(), Reason.PERMISSION.toString());
        return hashMap;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/DeviceParamNotAvailableFactoryImpl$Reason;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "MARKET_OR_REGION_RESTRICTION", "PLATFORM_VERSION", "PERMISSION", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DeviceParamNotAvailableFactoryImpl.kt */
    public enum Reason {
        MARKET_OR_REGION_RESTRICTION("RE01"),
        PLATFORM_VERSION("RE02"),
        PERMISSION("RE03");
        
        private final String code;

        private Reason(String str) {
            this.code = str;
        }

        public String toString() {
            return this.code;
        }
    }
}
