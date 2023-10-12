package io.invertase.firebase.functions;

import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.FirebaseFunctionsException;
import com.google.firebase.functions.HttpsCallableResult;
import io.invertase.firebase.Utils;
import javax.annotation.Nonnull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class RNFirebaseFunctions extends ReactContextBaseJavaModule {
    private static final String CODE_KEY = "code";
    private static final String DATA_KEY = "data";
    private static final String DETAILS_KEY = "details";
    private static final String ERROR_KEY = "__error";
    private static final String MSG_KEY = "message";
    private static final String TAG = "RNFirebaseFunctions";

    public String getName() {
        return TAG;
    }

    RNFirebaseFunctions(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Log.d(TAG, "New instance");
    }

    @ReactMethod
    public void useFunctionsEmulator(String str, String str2, String str3, Promise promise) {
        FirebaseFunctions.getInstance(FirebaseApp.getInstance(str), str2).useFunctionsEmulator(str3);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void httpsCallable(String str, String str2, final String str3, ReadableMap readableMap, final Promise promise) {
        Object obj = readableMap.toHashMap().get("data");
        StringBuilder sb = new StringBuilder();
        sb.append("function:call:input:");
        sb.append(str3);
        sb.append(":");
        sb.append(obj != null ? obj.toString() : AbstractJsonLexerKt.NULL);
        Log.d(TAG, sb.toString());
        FirebaseFunctions.getInstance(FirebaseApp.getInstance(str), str2).getHttpsCallable(str3).call(obj).addOnSuccessListener(new OnSuccessListener<HttpsCallableResult>() {
            public void onSuccess(HttpsCallableResult httpsCallableResult) {
                WritableMap createMap = Arguments.createMap();
                Object data = httpsCallableResult.getData();
                Log.d(RNFirebaseFunctions.TAG, "function:call:onSuccess:" + str3);
                StringBuilder sb = new StringBuilder();
                sb.append("function:call:onSuccess:result:type:");
                sb.append(str3);
                sb.append(":");
                String str = AbstractJsonLexerKt.NULL;
                sb.append(data != null ? data.getClass().getName() : str);
                Log.d(RNFirebaseFunctions.TAG, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("function:call:onSuccess:result:data:");
                sb2.append(str3);
                sb2.append(":");
                if (data != null) {
                    str = data.toString();
                }
                sb2.append(str);
                Log.d(RNFirebaseFunctions.TAG, sb2.toString());
                Utils.mapPutValue("data", data, createMap);
                promise.resolve(createMap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                String str;
                String str2;
                Object obj;
                Log.d(RNFirebaseFunctions.TAG, "function:call:onFailure:" + str3, exc);
                WritableMap createMap = Arguments.createMap();
                if (exc instanceof FirebaseFunctionsException) {
                    FirebaseFunctionsException firebaseFunctionsException = (FirebaseFunctionsException) exc;
                    obj = firebaseFunctionsException.getDetails();
                    str2 = firebaseFunctionsException.getCode().name();
                    str = firebaseFunctionsException.getMessage();
                } else {
                    str = exc.getMessage();
                    obj = null;
                    str2 = "UNKNOWN";
                }
                Utils.mapPutValue("code", str2, createMap);
                Utils.mapPutValue("message", str, createMap);
                Utils.mapPutValue(RNFirebaseFunctions.ERROR_KEY, true, createMap);
                Utils.mapPutValue("details", obj, createMap);
                promise.resolve(createMap);
            }
        });
    }
}
