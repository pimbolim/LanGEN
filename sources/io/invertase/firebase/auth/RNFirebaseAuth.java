package io.invertase.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcel;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.braintreepayments.api.models.PostalAddressParser;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.TwitterAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.stripe.android.model.PaymentMethodOptionsParams;
import io.invertase.firebase.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;

class RNFirebaseAuth extends ReactContextBaseJavaModule {
    private static final String TAG = "RNFirebaseAuth";
    private static HashMap<String, FirebaseAuth.AuthStateListener> mAuthListeners = new HashMap<>();
    private static HashMap<String, FirebaseAuth.IdTokenListener> mIdTokenListeners = new HashMap<>();
    /* access modifiers changed from: private */
    public PhoneAuthCredential mCredential;
    /* access modifiers changed from: private */
    public PhoneAuthProvider.ForceResendingToken mForceResendingToken;
    private String mLastPhoneNumber;
    /* access modifiers changed from: private */
    public ReactContext mReactContext;
    /* access modifiers changed from: private */
    public String mVerificationId;

    public String getName() {
        return TAG;
    }

    RNFirebaseAuth(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
        Log.d(TAG, "instance-created");
    }

    public void initialize() {
        super.initialize();
        Log.d(TAG, "instance-initialized");
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        Log.d(TAG, "instance-destroyed");
        Iterator<Map.Entry<String, FirebaseAuth.AuthStateListener>> it = mAuthListeners.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            FirebaseAuth.getInstance(FirebaseApp.getInstance((String) next.getKey())).removeAuthStateListener((FirebaseAuth.AuthStateListener) next.getValue());
            it.remove();
        }
        Iterator<Map.Entry<String, FirebaseAuth.IdTokenListener>> it2 = mIdTokenListeners.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next2 = it2.next();
            FirebaseAuth.getInstance(FirebaseApp.getInstance((String) next2.getKey())).removeIdTokenListener((FirebaseAuth.IdTokenListener) next2.getValue());
            it2.remove();
        }
    }

    @ReactMethod
    public void addAuthStateListener(final String str) {
        Log.d(TAG, "addAuthStateListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (mAuthListeners.get(str) == null) {
            AnonymousClass1 r1 = new FirebaseAuth.AuthStateListener() {
                public void onAuthStateChanged(@Nonnull FirebaseAuth firebaseAuth) {
                    FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                    WritableMap createMap = Arguments.createMap();
                    if (currentUser != null) {
                        createMap.putString("appName", str);
                        createMap.putMap("user", RNFirebaseAuth.this.firebaseUserToMap(currentUser));
                        Utils.sendEvent(RNFirebaseAuth.this.mReactContext, "auth_state_changed", createMap);
                        return;
                    }
                    createMap.putString("appName", str);
                    Utils.sendEvent(RNFirebaseAuth.this.mReactContext, "auth_state_changed", createMap);
                }
            };
            instance.addAuthStateListener(r1);
            mAuthListeners.put(str, r1);
        }
    }

    @ReactMethod
    public void removeAuthStateListener(String str) {
        Log.d(TAG, "removeAuthStateListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseAuth.AuthStateListener authStateListener = mAuthListeners.get(str);
        if (authStateListener != null) {
            instance.removeAuthStateListener(authStateListener);
            mAuthListeners.remove(str);
        }
    }

    @ReactMethod
    public void addIdTokenListener(final String str) {
        Log.d(TAG, "addIdTokenListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (!mIdTokenListeners.containsKey(str)) {
            AnonymousClass2 r1 = new FirebaseAuth.IdTokenListener() {
                public void onIdTokenChanged(@Nonnull FirebaseAuth firebaseAuth) {
                    FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                    WritableMap createMap = Arguments.createMap();
                    if (currentUser != null) {
                        createMap.putBoolean("authenticated", true);
                        createMap.putString("appName", str);
                        createMap.putMap("user", RNFirebaseAuth.this.firebaseUserToMap(currentUser));
                        Utils.sendEvent(RNFirebaseAuth.this.mReactContext, "auth_id_token_changed", createMap);
                        return;
                    }
                    createMap.putString("appName", str);
                    createMap.putBoolean("authenticated", false);
                    Utils.sendEvent(RNFirebaseAuth.this.mReactContext, "auth_id_token_changed", createMap);
                }
            };
            instance.addIdTokenListener(r1);
            mIdTokenListeners.put(str, r1);
        }
    }

    @ReactMethod
    public void removeIdTokenListener(String str) {
        Log.d(TAG, "removeIdTokenListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseAuth.IdTokenListener idTokenListener = mIdTokenListeners.get(str);
        if (idTokenListener != null) {
            instance.removeIdTokenListener(idTokenListener);
            mIdTokenListeners.remove(str);
        }
    }

    @ReactMethod
    public void setAutoRetrievedSmsCodeForPhoneNumber(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "setAutoRetrievedSmsCodeForPhoneNumber");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getFirebaseAuthSettings().setAutoRetrievedSmsCodeForPhoneNumber(str2, str3);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void signOut(String str, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "signOut");
        if (instance == null || instance.getCurrentUser() == null) {
            promiseNoUser(promise, true);
            return;
        }
        instance.signOut();
        promiseNoUser(promise, false);
    }

    @ReactMethod
    private void signInAnonymously(String str, final Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "signInAnonymously");
        instance.signInAnonymously().addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            public void onSuccess(AuthResult authResult) {
                Log.d(RNFirebaseAuth.TAG, "signInAnonymously:onComplete:success");
                RNFirebaseAuth.this.promiseWithAuthResult(authResult, promise);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                Log.e(RNFirebaseAuth.TAG, "signInAnonymously:onComplete:failure", exc);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exc);
            }
        });
    }

    @ReactMethod
    private void createUserWithEmailAndPassword(String str, String str2, String str3, final Promise promise) {
        Log.d(TAG, "createUserWithEmailAndPassword");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).createUserWithEmailAndPassword(str2, str3).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            public void onSuccess(AuthResult authResult) {
                Log.d(RNFirebaseAuth.TAG, "createUserWithEmailAndPassword:onComplete:success");
                RNFirebaseAuth.this.promiseWithAuthResult(authResult, promise);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                Log.e(RNFirebaseAuth.TAG, "createUserWithEmailAndPassword:onComplete:failure", exc);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exc);
            }
        });
    }

    @ReactMethod
    private void signInWithEmailAndPassword(String str, String str2, String str3, final Promise promise) {
        Log.d(TAG, "signInWithEmailAndPassword");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithEmailAndPassword(str2, str3).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            public void onSuccess(AuthResult authResult) {
                Log.d(RNFirebaseAuth.TAG, "signInWithEmailAndPassword:onComplete:success");
                RNFirebaseAuth.this.promiseWithAuthResult(authResult, promise);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                Log.e(RNFirebaseAuth.TAG, "signInWithEmailAndPassword:onComplete:failure", exc);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exc);
            }
        });
    }

    @ReactMethod
    private void signInWithEmailLink(String str, String str2, String str3, final Promise promise) {
        Log.d(TAG, "signInWithEmailLink");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithEmailLink(str2, str3).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            public void onSuccess(AuthResult authResult) {
                Log.d(RNFirebaseAuth.TAG, "signInWithEmailLink:onComplete:success");
                RNFirebaseAuth.this.promiseWithAuthResult(authResult, promise);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                Log.e(RNFirebaseAuth.TAG, "signInWithEmailLink:onComplete:failure", exc);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exc);
            }
        });
    }

    @ReactMethod
    private void signInWithCustomToken(String str, String str2, final Promise promise) {
        Log.d(TAG, "signInWithCustomToken");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithCustomToken(str2).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            public void onSuccess(AuthResult authResult) {
                Log.d(RNFirebaseAuth.TAG, "signInWithCustomToken:onComplete:success");
                RNFirebaseAuth.this.promiseWithAuthResult(authResult, promise);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                Log.e(RNFirebaseAuth.TAG, "signInWithCustomToken:onComplete:failure", exc);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exc);
            }
        });
    }

    @ReactMethod
    public void sendPasswordResetEmail(String str, String str2, ReadableMap readableMap, final Promise promise) {
        Log.d(TAG, "sendPasswordResetEmail");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AnonymousClass13 r0 = new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "sendPasswordResetEmail:onComplete:success");
                    RNFirebaseAuth.this.promiseNoUser(promise, false);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "sendPasswordResetEmail:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        };
        if (readableMap == null) {
            instance.sendPasswordResetEmail(str2).addOnCompleteListener(r0);
        } else {
            instance.sendPasswordResetEmail(str2, buildActionCodeSettings(readableMap)).addOnCompleteListener(r0);
        }
    }

    @ReactMethod
    public void sendSignInLinkToEmail(String str, String str2, ReadableMap readableMap, final Promise promise) {
        Log.d(TAG, "sendSignInLinkToEmail");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        instance.sendSignInLinkToEmail(str2, buildActionCodeSettings(readableMap)).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "sendSignInLinkToEmail:onComplete:success");
                    RNFirebaseAuth.this.promiseNoUser(promise, false);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "sendSignInLinkToEmail:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    public void delete(String str, final Promise promise) {
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        Log.d(TAG, "delete");
        if (currentUser != null) {
            currentUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(@Nonnull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Log.d(RNFirebaseAuth.TAG, "delete:onComplete:success");
                        RNFirebaseAuth.this.promiseNoUser(promise, false);
                        return;
                    }
                    Exception exception = task.getException();
                    Log.e(RNFirebaseAuth.TAG, "delete:onComplete:failure", exception);
                    RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
                }
            });
            return;
        }
        Log.e(TAG, "delete:failure:noCurrentUser");
        promiseNoUser(promise, true);
    }

    @ReactMethod
    public void reload(String str, final Promise promise) {
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "reload");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "reload:failure:noCurrentUser");
            return;
        }
        currentUser.reload().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "reload:onComplete:success");
                    RNFirebaseAuth.this.promiseWithUser(instance.getCurrentUser(), promise);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "reload:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    public void sendEmailVerification(String str, ReadableMap readableMap, final Promise promise) {
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "sendEmailVerification");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "sendEmailVerification:failure:noCurrentUser");
            return;
        }
        AnonymousClass17 r1 = new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "sendEmailVerification:onComplete:success");
                    RNFirebaseAuth.this.promiseWithUser(instance.getCurrentUser(), promise);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "sendEmailVerification:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        };
        if (readableMap == null) {
            currentUser.sendEmailVerification().addOnCompleteListener(r1);
        } else {
            currentUser.sendEmailVerification(buildActionCodeSettings(readableMap)).addOnCompleteListener(r1);
        }
    }

    @ReactMethod
    public void updateEmail(String str, String str2, final Promise promise) {
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "updateEmail");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updateEmail:failure:noCurrentUser");
            return;
        }
        currentUser.updateEmail(str2).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "updateEmail:onComplete:success");
                    RNFirebaseAuth.this.promiseWithUser(instance.getCurrentUser(), promise);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "updateEmail:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    public void updatePassword(String str, String str2, final Promise promise) {
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "updatePassword");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updatePassword:failure:noCurrentUser");
            return;
        }
        currentUser.updatePassword(str2).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "updatePassword:onComplete:success");
                    RNFirebaseAuth.this.promiseWithUser(instance.getCurrentUser(), promise);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "updatePassword:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    private void updatePhoneNumber(String str, String str2, String str3, String str4, final Promise promise) {
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        if (!str2.equals("phone")) {
            promise.reject("auth/invalid-credential", "The supplied auth credential does not have a phone provider.");
        }
        PhoneAuthCredential phoneAuthCredential = getPhoneAuthCredential(str3, str4);
        if (phoneAuthCredential == null) {
            promise.reject("auth/invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
        } else if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updatePhoneNumber:failure:noCurrentUser");
        } else {
            Log.d(TAG, "updatePhoneNumber");
            currentUser.updatePhoneNumber(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(@Nonnull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Log.d(RNFirebaseAuth.TAG, "updatePhoneNumber:onComplete:success");
                        RNFirebaseAuth.this.promiseWithUser(instance.getCurrentUser(), promise);
                        return;
                    }
                    Exception exception = task.getException();
                    Log.e(RNFirebaseAuth.TAG, "updatePhoneNumber:onComplete:failure", exception);
                    RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
                }
            });
        }
    }

    @ReactMethod
    public void updateProfile(String str, ReadableMap readableMap, final Promise promise) {
        Uri uri;
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "updateProfile");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updateProfile:failure:noCurrentUser");
            return;
        }
        UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
        if (readableMap.hasKey("displayName")) {
            builder.setDisplayName(readableMap.getString("displayName"));
        }
        if (readableMap.hasKey("photoURL")) {
            String string = readableMap.getString("photoURL");
            if (string == null) {
                uri = null;
            } else {
                uri = Uri.parse(string);
            }
            builder.setPhotoUri(uri);
        }
        currentUser.updateProfile(builder.build()).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "updateProfile:onComplete:success");
                    RNFirebaseAuth.this.promiseWithUser(instance.getCurrentUser(), promise);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "updateProfile:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    private void signInWithCredential(String str, String str2, String str3, String str4, final Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            promise.reject("auth/invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        Log.d(TAG, "signInWithCredential");
        instance.signInWithCredential(credentialForProvider).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(@Nonnull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "signInWithCredential:onComplete:success");
                    RNFirebaseAuth.this.promiseWithAuthResult(task.getResult(), promise);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "signInWithCredential:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    public void signInWithPhoneNumber(String str, String str2, boolean z, final Promise promise) {
        Log.d(TAG, "signInWithPhoneNumber");
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Activity currentActivity = this.mReactContext.getCurrentActivity();
        if (!str2.equals(this.mLastPhoneNumber)) {
            this.mForceResendingToken = null;
            this.mLastPhoneNumber = str2;
        }
        this.mVerificationId = null;
        AnonymousClass23 r7 = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            /* access modifiers changed from: private */
            public boolean promiseResolved = false;

            public void onVerificationCompleted(final PhoneAuthCredential phoneAuthCredential) {
                instance.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    public void onComplete(@Nonnull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(RNFirebaseAuth.TAG, "signInWithPhoneNumber:autoVerified:signInWithCredential:onComplete:success");
                            if (!AnonymousClass23.this.promiseResolved) {
                                WritableMap createMap = Arguments.createMap();
                                Parcel obtain = Parcel.obtain();
                                phoneAuthCredential.writeToParcel(obtain, 0);
                                obtain.setDataPosition(16);
                                String readString = obtain.readString();
                                String unused = RNFirebaseAuth.this.mVerificationId = readString;
                                obtain.recycle();
                                createMap.putString("verificationId", readString);
                                promise.resolve(createMap);
                                return;
                            }
                            return;
                        }
                        Exception exception = task.getException();
                        Log.e(RNFirebaseAuth.TAG, "signInWithPhoneNumber:autoVerified:signInWithCredential:onComplete:failure", exception);
                        if (!AnonymousClass23.this.promiseResolved) {
                            RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
                        }
                    }
                });
            }

            public void onVerificationFailed(FirebaseException firebaseException) {
                Log.d(RNFirebaseAuth.TAG, "signInWithPhoneNumber:verification:failed");
                RNFirebaseAuth.this.promiseRejectAuthException(promise, firebaseException);
            }

            public void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                String unused = RNFirebaseAuth.this.mVerificationId = str;
                PhoneAuthProvider.ForceResendingToken unused2 = RNFirebaseAuth.this.mForceResendingToken = forceResendingToken;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("verificationId", str);
                promise.resolve(createMap);
                this.promiseResolved = true;
            }

            public void onCodeAutoRetrievalTimeOut(String str) {
                RNFirebaseAuth.super.onCodeAutoRetrievalTimeOut(str);
            }
        };
        if (currentActivity == null) {
            return;
        }
        if (!z || this.mForceResendingToken == null) {
            PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, 60, TimeUnit.SECONDS, currentActivity, r7);
            return;
        }
        PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, 60, TimeUnit.SECONDS, currentActivity, r7, this.mForceResendingToken);
    }

    @ReactMethod
    public void _confirmVerificationCode(String str, String str2, final Promise promise) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithCredential(PhoneAuthProvider.getCredential(this.mVerificationId, str2)).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(@Nonnull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "_confirmVerificationCode:signInWithCredential:onComplete:success");
                    RNFirebaseAuth.this.promiseWithUser(task.getResult().getUser(), promise);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "_confirmVerificationCode:signInWithCredential:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    public void verifyPhoneNumber(final String str, String str2, final String str3, int i, boolean z) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Activity currentActivity = this.mReactContext.getCurrentActivity();
        Log.d(TAG, "verifyPhoneNumber:" + str2);
        if (!str2.equals(this.mLastPhoneNumber)) {
            this.mForceResendingToken = null;
            this.mLastPhoneNumber = str2;
        }
        this.mCredential = null;
        AnonymousClass25 r8 = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                PhoneAuthCredential unused = RNFirebaseAuth.this.mCredential = phoneAuthCredential;
                Log.d(RNFirebaseAuth.TAG, "verifyPhoneNumber:verification:onVerificationCompleted");
                WritableMap createMap = Arguments.createMap();
                Parcel obtain = Parcel.obtain();
                phoneAuthCredential.writeToParcel(obtain, 0);
                obtain.setDataPosition(16);
                String readString = obtain.readString();
                obtain.setDataPosition(obtain.dataPosition() + 8);
                createMap.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, obtain.readString());
                createMap.putString("verificationId", readString);
                obtain.recycle();
                RNFirebaseAuth.this.sendPhoneStateEvent(str, str3, "onVerificationComplete", createMap);
            }

            public void onVerificationFailed(FirebaseException firebaseException) {
                Log.d(RNFirebaseAuth.TAG, "verifyPhoneNumber:verification:onVerificationFailed");
                WritableMap createMap = Arguments.createMap();
                createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, RNFirebaseAuth.this.getJSError(firebaseException));
                RNFirebaseAuth.this.sendPhoneStateEvent(str, str3, "onVerificationFailed", createMap);
            }

            public void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                Log.d(RNFirebaseAuth.TAG, "verifyPhoneNumber:verification:onCodeSent");
                PhoneAuthProvider.ForceResendingToken unused = RNFirebaseAuth.this.mForceResendingToken = forceResendingToken;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("verificationId", str);
                createMap.putString("verificationId", str);
                RNFirebaseAuth.this.sendPhoneStateEvent(str, str3, "onCodeSent", createMap);
            }

            public void onCodeAutoRetrievalTimeOut(String str) {
                RNFirebaseAuth.super.onCodeAutoRetrievalTimeOut(str);
                Log.d(RNFirebaseAuth.TAG, "verifyPhoneNumber:verification:onCodeAutoRetrievalTimeOut");
                WritableMap createMap = Arguments.createMap();
                createMap.putString("verificationId", str);
                RNFirebaseAuth.this.sendPhoneStateEvent(str, str3, "onCodeAutoRetrievalTimeout", createMap);
            }
        };
        if (currentActivity == null) {
            return;
        }
        if (!z || this.mForceResendingToken == null) {
            PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, (long) i, TimeUnit.SECONDS, currentActivity, r8);
            return;
        }
        PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, (long) i, TimeUnit.SECONDS, currentActivity, r8, this.mForceResendingToken);
    }

    @ReactMethod
    public void confirmPasswordReset(String str, String str2, String str3, final Promise promise) {
        Log.d(TAG, "confirmPasswordReset");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).confirmPasswordReset(str2, str3).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "confirmPasswordReset:onComplete:success");
                    RNFirebaseAuth.this.promiseNoUser(promise, false);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "confirmPasswordReset:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    public void applyActionCode(String str, String str2, final Promise promise) {
        Log.d(TAG, "applyActionCode");
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        instance.applyActionCode(str2).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "applyActionCode:onComplete:success");
                    RNFirebaseAuth.this.promiseWithUser(instance.getCurrentUser(), promise);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "applyActionCode:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    public void checkActionCode(String str, String str2, final Promise promise) {
        Log.d(TAG, "checkActionCode");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).checkActionCode(str2).addOnCompleteListener(new OnCompleteListener<ActionCodeResult>() {
            public void onComplete(@Nonnull Task<ActionCodeResult> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "checkActionCode:onComplete:success");
                    ActionCodeResult result = task.getResult();
                    WritableMap createMap = Arguments.createMap();
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putString("email", result.getData(0));
                    createMap2.putString("fromEmail", result.getData(1));
                    createMap.putMap("data", createMap2);
                    int operation = result.getOperation();
                    createMap.putString("operation", operation != 0 ? operation != 1 ? operation != 2 ? operation != 3 ? operation != 4 ? "UNKNOWN" : "EMAIL_SIGNIN" : "ERROR" : "RECOVER_EMAIL" : "VERIFY_EMAIL" : "PASSWORD_RESET");
                    promise.resolve(createMap);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "checkActionCode:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    private void linkWithCredential(String str, String str2, String str3, String str4, final Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            promise.reject("auth/invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "link");
        if (currentUser != null) {
            currentUser.linkWithCredential(credentialForProvider).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                public void onComplete(@Nonnull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d(RNFirebaseAuth.TAG, "link:onComplete:success");
                        RNFirebaseAuth.this.promiseWithAuthResult(task.getResult(), promise);
                        return;
                    }
                    Exception exception = task.getException();
                    Log.e(RNFirebaseAuth.TAG, "link:onComplete:failure", exception);
                    RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    @ReactMethod
    public void unlink(String str, String str2, final Promise promise) {
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        Log.d(TAG, "unlink");
        if (currentUser != null) {
            currentUser.unlink(str2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                public void onComplete(@Nonnull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d(RNFirebaseAuth.TAG, "unlink:onComplete:success");
                        RNFirebaseAuth.this.promiseWithUser(task.getResult().getUser(), promise);
                        return;
                    }
                    Exception exception = task.getException();
                    Log.e(RNFirebaseAuth.TAG, "unlink:onComplete:failure", exception);
                    RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    @ReactMethod
    private void reauthenticateWithCredential(String str, String str2, String str3, String str4, final Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            promise.reject("auth/invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "reauthenticate");
        if (currentUser != null) {
            currentUser.reauthenticateAndRetrieveData(credentialForProvider).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                public void onComplete(@Nonnull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d(RNFirebaseAuth.TAG, "reauthenticate:onComplete:success");
                        RNFirebaseAuth.this.promiseWithAuthResult(task.getResult(), promise);
                        return;
                    }
                    Exception exception = task.getException();
                    Log.e(RNFirebaseAuth.TAG, "reauthenticate:onComplete:failure", exception);
                    RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    private AuthCredential getCredentialForProvider(String str, String str2, String str3) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1830313082:
                if (str.equals("twitter.com")) {
                    c = 0;
                    break;
                }
                break;
            case -1536293812:
                if (str.equals("google.com")) {
                    c = 1;
                    break;
                }
                break;
            case -364826023:
                if (str.equals("facebook.com")) {
                    c = 2;
                    break;
                }
                break;
            case 105516695:
                if (str.equals("oauth")) {
                    c = 3;
                    break;
                }
                break;
            case 106642798:
                if (str.equals("phone")) {
                    c = 4;
                    break;
                }
                break;
            case 1216985755:
                if (str.equals(HintConstants.AUTOFILL_HINT_PASSWORD)) {
                    c = 5;
                    break;
                }
                break;
            case 1985010934:
                if (str.equals("github.com")) {
                    c = 6;
                    break;
                }
                break;
            case 2120171958:
                if (str.equals("emailLink")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return TwitterAuthProvider.getCredential(str2, str3);
            case 1:
                return GoogleAuthProvider.getCredential(str2, str3);
            case 2:
                return FacebookAuthProvider.getCredential(str2);
            case 3:
                return OAuthProvider.getCredential(str, str2, str3);
            case 4:
                return getPhoneAuthCredential(str2, str3);
            case 5:
                return EmailAuthProvider.getCredential(str2, str3);
            case 6:
                return GithubAuthProvider.getCredential(str2);
            case 7:
                return EmailAuthProvider.getCredentialWithLink(str2, str3);
            default:
                return null;
        }
    }

    private PhoneAuthCredential getPhoneAuthCredential(String str, String str2) {
        PhoneAuthCredential phoneAuthCredential;
        if (str == null && (phoneAuthCredential = this.mCredential) != null) {
            this.mCredential = null;
            return phoneAuthCredential;
        } else if (str != null) {
            return PhoneAuthProvider.getCredential(str, str2);
        } else {
            return null;
        }
    }

    @ReactMethod
    public void getIdToken(String str, Boolean bool, final Promise promise) {
        Log.d(TAG, "getIdToken");
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        if (currentUser == null) {
            promiseNoUser(promise, true);
        } else {
            currentUser.getIdToken(bool.booleanValue()).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                public void onComplete(@Nonnull Task<GetTokenResult> task) {
                    if (task.isSuccessful()) {
                        Log.d(RNFirebaseAuth.TAG, "getIdToken:onComplete:success");
                        promise.resolve(task.getResult().getToken());
                        return;
                    }
                    Exception exception = task.getException();
                    Log.e(RNFirebaseAuth.TAG, "getIdToken:onComplete:failure", exception);
                    RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
                }
            });
        }
    }

    @ReactMethod
    public void getIdTokenResult(String str, Boolean bool, final Promise promise) {
        Log.d(TAG, "getIdTokenResult");
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        if (currentUser == null) {
            promiseNoUser(promise, true);
        } else {
            currentUser.getIdToken(bool.booleanValue()).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                public void onComplete(@Nonnull Task<GetTokenResult> task) {
                    if (task.isSuccessful()) {
                        Log.d(RNFirebaseAuth.TAG, "getIdTokenResult:onComplete:success");
                        GetTokenResult result = task.getResult();
                        WritableMap createMap = Arguments.createMap();
                        Utils.mapPutValue("authTime", Utils.timestampToUTC(result.getAuthTimestamp()), createMap);
                        Utils.mapPutValue("expirationTime", Utils.timestampToUTC(result.getExpirationTimestamp()), createMap);
                        Utils.mapPutValue("issuedAtTime", Utils.timestampToUTC(result.getIssuedAtTimestamp()), createMap);
                        Utils.mapPutValue("claims", result.getClaims(), createMap);
                        Utils.mapPutValue("signInProvider", result.getSignInProvider(), createMap);
                        Utils.mapPutValue("token", result.getToken(), createMap);
                        promise.resolve(createMap);
                        return;
                    }
                    Exception exception = task.getException();
                    Log.e(RNFirebaseAuth.TAG, "getIdTokenResult:onComplete:failure", exception);
                    RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
                }
            });
        }
    }

    @ReactMethod
    public void fetchSignInMethodsForEmail(String str, String str2, final Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "fetchProvidersForEmail");
        instance.fetchSignInMethodsForEmail(str2).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
            public void onComplete(@Nonnull Task<SignInMethodQueryResult> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "fetchProvidersForEmail:onComplete:success");
                    List<String> signInMethods = task.getResult().getSignInMethods();
                    WritableArray createArray = Arguments.createArray();
                    if (signInMethods != null) {
                        for (String pushString : signInMethods) {
                            createArray.pushString(pushString);
                        }
                    }
                    promise.resolve(createArray);
                    return;
                }
                Exception exception = task.getException();
                Log.d(RNFirebaseAuth.TAG, "fetchProvidersForEmail:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    @ReactMethod
    public void setLanguageCode(String str, String str2) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).setLanguageCode(str2);
    }

    @ReactMethod
    public void useDeviceLanguage(String str) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).useAppLanguage();
    }

    @ReactMethod
    public void verifyPasswordResetCode(String str, String str2, final Promise promise) {
        Log.d(TAG, "verifyPasswordResetCode");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).verifyPasswordResetCode(str2).addOnCompleteListener(new OnCompleteListener<String>() {
            public void onComplete(@Nonnull Task<String> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseAuth.TAG, "verifyPasswordResetCode:onComplete:success");
                    promise.resolve(task.getResult());
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseAuth.TAG, "verifyPasswordResetCode:onComplete:failure", exception);
                RNFirebaseAuth.this.promiseRejectAuthException(promise, exception);
            }
        });
    }

    /* access modifiers changed from: private */
    public void promiseNoUser(Promise promise, Boolean bool) {
        if (bool.booleanValue()) {
            promise.reject("auth/no-current-user", "No user currently signed in.");
        } else {
            promise.resolve((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void promiseWithUser(FirebaseUser firebaseUser, Promise promise) {
        if (firebaseUser != null) {
            promise.resolve(firebaseUserToMap(firebaseUser));
        } else {
            promiseNoUser(promise, true);
        }
    }

    /* access modifiers changed from: private */
    public void promiseWithAuthResult(AuthResult authResult, Promise promise) {
        if (authResult == null || authResult.getUser() == null) {
            promiseNoUser(promise, true);
            return;
        }
        WritableMap createMap = Arguments.createMap();
        WritableMap firebaseUserToMap = firebaseUserToMap(authResult.getUser());
        if (authResult.getAdditionalUserInfo() != null) {
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putBoolean("isNewUser", authResult.getAdditionalUserInfo().isNewUser());
            if (authResult.getAdditionalUserInfo().getProfile() != null) {
                Utils.mapPutValue(Scopes.PROFILE, authResult.getAdditionalUserInfo().getProfile(), createMap2);
            }
            if (authResult.getAdditionalUserInfo().getProviderId() != null) {
                createMap2.putString("providerId", authResult.getAdditionalUserInfo().getProviderId());
            }
            if (authResult.getAdditionalUserInfo().getUsername() != null) {
                createMap2.putString(HintConstants.AUTOFILL_HINT_USERNAME, authResult.getAdditionalUserInfo().getUsername());
            }
            createMap.putMap("additionalUserInfo", createMap2);
        }
        createMap.putMap("user", firebaseUserToMap);
        promise.resolve(createMap);
    }

    /* access modifiers changed from: private */
    public void promiseRejectAuthException(Promise promise, Exception exc) {
        WritableMap jSError = getJSError(exc);
        promise.reject(jSError.getString(PaymentMethodOptionsParams.Blik.PARAM_CODE), jSError.getString(GraphQLConstants.Keys.MESSAGE), (Throwable) exc);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010b, code lost:
        if (r6.equals("INVALID_CREDENTIAL") == false) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.WritableMap getJSError(java.lang.Exception r11) {
        /*
            r10 = this;
            java.lang.String r0 = "The user's credential is no longer valid. The user must sign in again."
            java.lang.String r1 = "UNKNOWN"
            java.lang.String r2 = "INVALID_EMAIL"
            com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r4 = r11.getMessage()
            java.lang.String r5 = "The email address is badly formatted."
            r6 = r11
            com.google.firebase.auth.FirebaseAuthException r6 = (com.google.firebase.auth.FirebaseAuthException) r6     // Catch:{ Exception -> 0x0024 }
            java.lang.String r7 = r6.getErrorCode()     // Catch:{ Exception -> 0x0024 }
            java.lang.String r8 = "nativeErrorCode"
            r3.putString(r8, r7)     // Catch:{ Exception -> 0x0022 }
            java.lang.String r0 = r6.getMessage()     // Catch:{ Exception -> 0x0022 }
            goto L_0x014d
        L_0x0022:
            goto L_0x0025
        L_0x0024:
            r7 = r1
        L_0x0025:
            java.lang.String r6 = "([A-Z]*_[A-Z]*)"
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)
            java.util.regex.Matcher r6 = r6.matcher(r4)
            boolean r8 = r6.find()
            if (r8 == 0) goto L_0x014c
            r7 = 1
            java.lang.String r6 = r6.group(r7)
            java.lang.String r6 = r6.trim()
            r6.hashCode()
            r8 = -1
            int r9 = r6.hashCode()
            switch(r9) {
                case -2127468245: goto L_0x010f;
                case -1971163201: goto L_0x0105;
                case -1112393964: goto L_0x00fb;
                case -1035666916: goto L_0x00ef;
                case -333672188: goto L_0x00e3;
                case -324930558: goto L_0x00d7;
                case -311841705: goto L_0x00cb;
                case -75433118: goto L_0x00c0;
                case -49749054: goto L_0x00b4;
                case -40686718: goto L_0x00a7;
                case 583750925: goto L_0x009a;
                case 748182870: goto L_0x008d;
                case 864281573: goto L_0x0080;
                case 1072360691: goto L_0x0073;
                case 1388786705: goto L_0x0066;
                case 1433767024: goto L_0x0059;
                case 1563975629: goto L_0x004c;
                default: goto L_0x0049;
            }
        L_0x0049:
            r7 = -1
            goto L_0x011a
        L_0x004c:
            java.lang.String r7 = "INVALID_USER_TOKEN"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0055
            goto L_0x0049
        L_0x0055:
            r7 = 16
            goto L_0x011a
        L_0x0059:
            java.lang.String r7 = "USER_DISABLED"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0062
            goto L_0x0049
        L_0x0062:
            r7 = 15
            goto L_0x011a
        L_0x0066:
            java.lang.String r7 = "INVALID_IDENTIFIER"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x006f
            goto L_0x0049
        L_0x006f:
            r7 = 14
            goto L_0x011a
        L_0x0073:
            java.lang.String r7 = "INVALID_CUSTOM_TOKEN"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x007c
            goto L_0x0049
        L_0x007c:
            r7 = 13
            goto L_0x011a
        L_0x0080:
            java.lang.String r7 = "ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0089
            goto L_0x0049
        L_0x0089:
            r7 = 12
            goto L_0x011a
        L_0x008d:
            java.lang.String r7 = "REQUIRES_RECENT_LOGIN"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0096
            goto L_0x0049
        L_0x0096:
            r7 = 11
            goto L_0x011a
        L_0x009a:
            java.lang.String r7 = "WRONG_PASSWORD"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00a3
            goto L_0x0049
        L_0x00a3:
            r7 = 10
            goto L_0x011a
        L_0x00a7:
            java.lang.String r7 = "WEAK_PASSWORD"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00b0
            goto L_0x0049
        L_0x00b0:
            r7 = 9
            goto L_0x011a
        L_0x00b4:
            java.lang.String r7 = "USER_MISMATCH"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00bd
            goto L_0x0049
        L_0x00bd:
            r7 = 8
            goto L_0x011a
        L_0x00c0:
            java.lang.String r7 = "USER_NOT_FOUND"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00c9
            goto L_0x0049
        L_0x00c9:
            r7 = 7
            goto L_0x011a
        L_0x00cb:
            java.lang.String r7 = "EMAIL_ALREADY_IN_USE"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00d5
            goto L_0x0049
        L_0x00d5:
            r7 = 6
            goto L_0x011a
        L_0x00d7:
            java.lang.String r7 = "CUSTOM_TOKEN_MISMATCH"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00e1
            goto L_0x0049
        L_0x00e1:
            r7 = 5
            goto L_0x011a
        L_0x00e3:
            java.lang.String r7 = "OPERATION_NOT_ALLOWED"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00ed
            goto L_0x0049
        L_0x00ed:
            r7 = 4
            goto L_0x011a
        L_0x00ef:
            java.lang.String r7 = "CREDENTIAL_ALREADY_IN_USE"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00f9
            goto L_0x0049
        L_0x00f9:
            r7 = 3
            goto L_0x011a
        L_0x00fb:
            boolean r7 = r6.equals(r2)
            if (r7 != 0) goto L_0x0103
            goto L_0x0049
        L_0x0103:
            r7 = 2
            goto L_0x011a
        L_0x0105:
            java.lang.String r9 = "INVALID_CREDENTIAL"
            boolean r9 = r6.equals(r9)
            if (r9 != 0) goto L_0x011a
            goto L_0x0049
        L_0x010f:
            java.lang.String r7 = "USER_TOKEN_EXPIRED"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0119
            goto L_0x0049
        L_0x0119:
            r7 = 0
        L_0x011a:
            switch(r7) {
                case 0: goto L_0x011e;
                case 1: goto L_0x0149;
                case 2: goto L_0x0147;
                case 3: goto L_0x0144;
                case 4: goto L_0x0141;
                case 5: goto L_0x013e;
                case 6: goto L_0x013b;
                case 7: goto L_0x0138;
                case 8: goto L_0x0135;
                case 9: goto L_0x0132;
                case 10: goto L_0x012f;
                case 11: goto L_0x012c;
                case 12: goto L_0x0129;
                case 13: goto L_0x0126;
                case 14: goto L_0x0123;
                case 15: goto L_0x0120;
                case 16: goto L_0x011e;
                default: goto L_0x011d;
            }
        L_0x011d:
            r0 = r4
        L_0x011e:
            r7 = r6
            goto L_0x014d
        L_0x0120:
            java.lang.String r0 = "The user account has been disabled by an administrator."
            goto L_0x011e
        L_0x0123:
            r7 = r2
            r0 = r5
            goto L_0x014d
        L_0x0126:
            java.lang.String r0 = "The custom token format is incorrect. Please check the documentation."
            goto L_0x011e
        L_0x0129:
            java.lang.String r0 = "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address."
            goto L_0x011e
        L_0x012c:
            java.lang.String r0 = "This operation is sensitive and requires recent authentication. Log in again before retrying this request."
            goto L_0x011e
        L_0x012f:
            java.lang.String r0 = "The password is invalid or the user does not have a password."
            goto L_0x011e
        L_0x0132:
            java.lang.String r0 = "The given password is invalid."
            goto L_0x011e
        L_0x0135:
            java.lang.String r0 = "The supplied credentials do not correspond to the previously signed in user."
            goto L_0x011e
        L_0x0138:
            java.lang.String r0 = "There is no user record corresponding to this identifier. The user may have been deleted."
            goto L_0x011e
        L_0x013b:
            java.lang.String r0 = "The email address is already in use by another account."
            goto L_0x011e
        L_0x013e:
            java.lang.String r0 = "The custom token corresponds to a different audience."
            goto L_0x011e
        L_0x0141:
            java.lang.String r0 = "This operation is not allowed. You must enable this service in the console."
            goto L_0x011e
        L_0x0144:
            java.lang.String r0 = "This credential is already associated with a different user account."
            goto L_0x011e
        L_0x0147:
            r0 = r5
            goto L_0x011e
        L_0x0149:
            java.lang.String r0 = "The supplied auth credential is malformed or has expired."
            goto L_0x011e
        L_0x014c:
            r0 = r4
        L_0x014d:
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x0158
            boolean r1 = r11 instanceof com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
            if (r1 == 0) goto L_0x0158
            goto L_0x015a
        L_0x0158:
            r5 = r0
            r2 = r7
        L_0x015a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "auth/"
            r0.append(r1)
            java.lang.String r1 = r2.toLowerCase()
            java.lang.String r2 = "error_"
            java.lang.String r4 = ""
            java.lang.String r1 = r1.replace(r2, r4)
            r2 = 95
            r4 = 45
            java.lang.String r1 = r1.replace(r2, r4)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "code"
            r3.putString(r1, r0)
            java.lang.String r0 = "message"
            r3.putString(r0, r5)
            java.lang.String r11 = r11.getMessage()
            java.lang.String r0 = "nativeErrorMessage"
            r3.putString(r0, r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.auth.RNFirebaseAuth.getJSError(java.lang.Exception):com.facebook.react.bridge.WritableMap");
    }

    private WritableArray convertProviderData(List<? extends UserInfo> list, FirebaseUser firebaseUser) {
        WritableArray createArray = Arguments.createArray();
        for (UserInfo next : list) {
            if (!"firebase".equals(next.getProviderId())) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("providerId", next.getProviderId());
                createMap.putString("uid", next.getUid());
                createMap.putString("displayName", next.getDisplayName());
                Uri photoUrl = next.getPhotoUrl();
                if (photoUrl == null || "".equals(photoUrl.toString())) {
                    createMap.putNull("photoURL");
                } else {
                    createMap.putString("photoURL", photoUrl.toString());
                }
                String phoneNumber = next.getPhoneNumber();
                if ("phone".equals(next.getProviderId()) && (next.getPhoneNumber() == null || "".equals(next.getPhoneNumber()))) {
                    createMap.putString("phoneNumber", firebaseUser.getPhoneNumber());
                } else if (phoneNumber == null || "".equals(phoneNumber)) {
                    createMap.putNull("phoneNumber");
                } else {
                    createMap.putString("phoneNumber", phoneNumber);
                }
                if (HintConstants.AUTOFILL_HINT_PASSWORD.equals(next.getProviderId()) && (next.getEmail() == null || "".equals(next.getEmail()))) {
                    createMap.putString("email", next.getUid());
                } else if (next.getEmail() == null || "".equals(next.getEmail())) {
                    createMap.putNull("email");
                } else {
                    createMap.putString("email", next.getEmail());
                }
                createArray.pushMap(createMap);
            }
        }
        return createArray;
    }

    /* access modifiers changed from: private */
    public WritableMap firebaseUserToMap(FirebaseUser firebaseUser) {
        WritableMap createMap = Arguments.createMap();
        String uid = firebaseUser.getUid();
        String email = firebaseUser.getEmail();
        Uri photoUrl = firebaseUser.getPhotoUrl();
        String displayName = firebaseUser.getDisplayName();
        String providerId = firebaseUser.getProviderId();
        Boolean valueOf = Boolean.valueOf(firebaseUser.isEmailVerified());
        String phoneNumber = firebaseUser.getPhoneNumber();
        createMap.putString("uid", uid);
        createMap.putString("providerId", providerId);
        createMap.putBoolean("emailVerified", valueOf.booleanValue());
        createMap.putBoolean("isAnonymous", firebaseUser.isAnonymous());
        if (email == null || "".equals(email)) {
            createMap.putNull("email");
        } else {
            createMap.putString("email", email);
        }
        if (displayName == null || "".equals(displayName)) {
            createMap.putNull("displayName");
        } else {
            createMap.putString("displayName", displayName);
        }
        if (photoUrl == null || "".equals(photoUrl.toString())) {
            createMap.putNull("photoURL");
        } else {
            createMap.putString("photoURL", photoUrl.toString());
        }
        if (phoneNumber == null || "".equals(phoneNumber)) {
            createMap.putNull("phoneNumber");
        } else {
            createMap.putString("phoneNumber", phoneNumber);
        }
        createMap.putArray("providerData", convertProviderData(firebaseUser.getProviderData(), firebaseUser));
        WritableMap createMap2 = Arguments.createMap();
        FirebaseUserMetadata metadata = firebaseUser.getMetadata();
        if (metadata != null) {
            createMap2.putDouble("creationTime", (double) metadata.getCreationTimestamp());
            createMap2.putDouble("lastSignInTime", (double) metadata.getLastSignInTimestamp());
        }
        createMap.putMap(ReactVideoView.EVENT_PROP_METADATA, createMap2);
        return createMap;
    }

    private ActionCodeSettings buildActionCodeSettings(ReadableMap readableMap) {
        ActionCodeSettings.Builder newBuilder = ActionCodeSettings.newBuilder();
        ReadableMap map = readableMap.getMap("android");
        ReadableMap map2 = readableMap.getMap("iOS");
        String string = readableMap.getString("url");
        if (map != null) {
            newBuilder = newBuilder.setAndroidPackageName(map.getString("packageName"), map.hasKey("installApp") && map.getBoolean("installApp"), map.hasKey("minimumVersion") ? map.getString("minimumVersion") : null);
        }
        if (readableMap.hasKey("handleCodeInApp")) {
            newBuilder = newBuilder.setHandleCodeInApp(readableMap.getBoolean("handleCodeInApp"));
        }
        if (map2 != null && map2.hasKey("bundleId")) {
            newBuilder = newBuilder.setIOSBundleId(map2.getString("bundleId"));
        }
        if (string != null) {
            newBuilder = newBuilder.setUrl(string);
        }
        return newBuilder.build();
    }

    /* access modifiers changed from: private */
    public void sendPhoneStateEvent(String str, String str2, String str3, WritableMap writableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("appName", str);
        createMap.putString("requestKey", str2);
        createMap.putString("type", str3);
        createMap.putMap(PostalAddressParser.REGION_KEY, writableMap);
        Utils.sendEvent(this.mReactContext, "phone_auth_state_changed", createMap);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        List<FirebaseApp> apps = FirebaseApp.getApps(getReactApplicationContext());
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (FirebaseApp name : apps) {
            String name2 = name.getName();
            FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(name2));
            FirebaseUser currentUser = instance.getCurrentUser();
            hashMap2.put(name2, instance.getLanguageCode());
            if (currentUser != null) {
                hashMap3.put(name2, firebaseUserToMap(currentUser));
            }
        }
        hashMap.put("APP_LANGUAGE", hashMap2);
        hashMap.put("APP_USER", hashMap3);
        return hashMap;
    }
}
