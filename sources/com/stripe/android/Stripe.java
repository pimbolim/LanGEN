package com.stripe.android;

import android.content.Context;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.stripe.android.core.ApiKeyValidator;
import com.stripe.android.core.ApiVersion;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.exception.APIConnectionException;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.core.exception.AuthenticationException;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.model.StripeFile;
import com.stripe.android.core.model.StripeFileParams;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.exception.CardException;
import com.stripe.android.model.AccountParams;
import com.stripe.android.model.BankAccountTokenParams;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.CvcTokenParams;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.PersonTokenParams;
import com.stripe.android.model.PiiTokenParams;
import com.stripe.android.model.RadarSession;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.model.Source;
import com.stripe.android.model.SourceParams;
import com.stripe.android.model.Token;
import com.stripe.android.model.TokenParams;
import com.stripe.android.model.WeChatPayNextAction;
import com.stripe.android.networking.StripeRepository;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fB1\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000fB)\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012B5\b\u0000\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J2\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0007J$\u0010-\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010-\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001e\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005H\u0007J$\u00101\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00102\u001a\u0002032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J$\u00101\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u00102\u001a\u0002032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001e\u00104\u001a\u0004\u0018\u0001052\u0006\u00102\u001a\u0002032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005H\u0007J*\u00106\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u0002070+H\u0007J6\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020;0+H\u0007J*\u0010<\u001a\u0004\u0018\u00010;2\u0006\u00109\u001a\u00020:2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J6\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020?2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020;0+H\u0007J*\u0010@\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J6\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020C2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020;0+H\u0007J*\u0010D\u001a\u0004\u0018\u00010;2\u0006\u0010B\u001a\u00020C2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J8\u0010E\u001a\u00020\u001e2\b\b\u0001\u0010F\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020;0+H\u0007J*\u0010G\u001a\u0004\u0018\u00010;2\u0006\u0010F\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J6\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020J2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020K0+H\u0007J(\u0010L\u001a\u00020K2\u0006\u0010I\u001a\u00020J2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J6\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020O2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020P0+H\u0007J*\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010N\u001a\u00020O2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J6\u0010R\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020T2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020;0+H\u0007J*\u0010U\u001a\u0004\u0018\u00010;2\u0006\u0010S\u001a\u00020T2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J6\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020;0+H\u0007J*\u0010X\u001a\u0004\u0018\u00010;2\u0006\u0010W\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010Y\u001a\u00020\u001e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020Z0+H\u0007J6\u0010[\u001a\u00020\u001e2\u0006\u0010\\\u001a\u00020]2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0+H\u0007J*\u0010^\u001a\u0004\u0018\u00010\"2\u0006\u0010S\u001a\u00020]2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J4\u0010_\u001a\u00020\u001e2\u0006\u0010`\u001a\u00020a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020;0+H\u0002J:\u0010b\u001a\u00020\u001e\"\b\b\u0000\u0010c*\u00020d2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hc0f2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002Hc0+H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010gJH\u0010h\u001a\u00020\u001e\"\b\b\u0000\u0010c*\u00020d2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002Hc0+2\u001e\u0010i\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001Hc0k\u0012\u0006\u0012\u0004\u0018\u00010\u00010jH\u0002ø\u0001\u0000¢\u0006\u0002\u0010lJ$\u0010m\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010n\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010m\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010n\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010o\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010n\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010o\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010n\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010p\u001a\u00020\b2\u0006\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010tJ\u0018\u0010u\u001a\u00020\b2\u0006\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010tJ\u0018\u0010v\u001a\u00020\b2\u0006\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010tJ\u001c\u0010w\u001a\u00020\u001e2\u0006\u0010s\u001a\u00020t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0+J(\u0010x\u001a\u00020\b2\u0006\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0007J(\u0010y\u001a\u00020\b2\u0006\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020z0+H\u0007J*\u0010{\u001a\u00020\u001e2\u0006\u0010n\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020/0+H\u0007J\u001e\u0010|\u001a\u0004\u0018\u00010/2\u0006\u0010n\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J*\u0010}\u001a\u00020\u001e2\u0006\u0010n\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u0002050+H\u0007J\u001e\u0010~\u001a\u0004\u0018\u0001052\u0006\u0010n\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J7\u0010\u001a\u00020\u001e2\t\b\u0001\u0010\u0001\u001a\u00020\u00052\b\b\u0001\u0010n\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0+H\u0007J,\u0010\u0001\u001a\u0004\u0018\u00010\"2\t\b\u0001\u0010\u0001\u001a\u00020\u00052\b\b\u0001\u0010n\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J1\u0010\u0001\u001a\u00020\u001e2\u0006\u0010n\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020r2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020/0+H\u0007J(\u0010\u0001\u001a\u00020\u001e2\u0006\u0010n\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020/0+H\u0007J1\u0010\u0001\u001a\u00020\u001e2\u0006\u0010n\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020r2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002050+H\u0007J(\u0010\u0001\u001a\u00020\u001e2\u0006\u0010n\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u0002050+H\u0007R\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/stripe/android/Stripe;", "", "context", "Landroid/content/Context;", "publishableKey", "", "stripeAccountId", "enableLogging", "", "betas", "", "Lcom/stripe/android/StripeApiBeta;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Set;)V", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "(Landroid/content/Context;Lcom/stripe/android/networking/StripeRepository;Ljava/lang/String;Ljava/lang/String;Z)V", "paymentController", "Lcom/stripe/android/PaymentController;", "(Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/PaymentController;Ljava/lang/String;Ljava/lang/String;)V", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/PaymentController;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/CoroutineContext;)V", "getPaymentController$payments_core_release", "()Lcom/stripe/android/PaymentController;", "getPublishableKey$payments_core_release", "()Ljava/lang/String;", "getStripeAccountId$payments_core_release", "getStripeRepository$payments_core_release", "()Lcom/stripe/android/networking/StripeRepository;", "authenticateSource", "", "activity", "Landroidx/activity/ComponentActivity;", "source", "Lcom/stripe/android/model/Source;", "fragment", "Landroidx/fragment/app/Fragment;", "confirmAlipayPayment", "confirmPaymentIntentParams", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "authenticator", "Lcom/stripe/android/AlipayAuthenticator;", "callback", "Lcom/stripe/android/ApiResultCallback;", "Lcom/stripe/android/PaymentIntentResult;", "confirmPayment", "confirmPaymentIntentSynchronous", "Lcom/stripe/android/model/PaymentIntent;", "idempotencyKey", "confirmSetupIntent", "confirmSetupIntentParams", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "confirmSetupIntentSynchronous", "Lcom/stripe/android/model/SetupIntent;", "confirmWeChatPayPayment", "Lcom/stripe/android/model/WeChatPayNextAction;", "createAccountToken", "accountParams", "Lcom/stripe/android/model/AccountParams;", "Lcom/stripe/android/model/Token;", "createAccountTokenSynchronous", "createBankAccountToken", "bankAccountTokenParams", "Lcom/stripe/android/model/BankAccountTokenParams;", "createBankAccountTokenSynchronous", "createCardToken", "cardParams", "Lcom/stripe/android/model/CardParams;", "createCardTokenSynchronous", "createCvcUpdateToken", "cvc", "createCvcUpdateTokenSynchronous", "createFile", "fileParams", "Lcom/stripe/android/core/model/StripeFileParams;", "Lcom/stripe/android/core/model/StripeFile;", "createFileSynchronous", "createPaymentMethod", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "Lcom/stripe/android/model/PaymentMethod;", "createPaymentMethodSynchronous", "createPersonToken", "params", "Lcom/stripe/android/model/PersonTokenParams;", "createPersonTokenSynchronous", "createPiiToken", "personalId", "createPiiTokenSynchronous", "createRadarSession", "Lcom/stripe/android/model/RadarSession;", "createSource", "sourceParams", "Lcom/stripe/android/model/SourceParams;", "createSourceSynchronous", "createToken", "tokenParams", "Lcom/stripe/android/model/TokenParams;", "dispatchResult", "T", "Lcom/stripe/android/core/model/StripeModel;", "result", "Lkotlin/Result;", "(Ljava/lang/Object;Lcom/stripe/android/ApiResultCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeAsync", "apiMethod", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lcom/stripe/android/ApiResultCallback;Lkotlin/jvm/functions/Function1;)V", "handleNextActionForPayment", "clientSecret", "handleNextActionForSetupIntent", "isAuthenticateSourceResult", "requestCode", "", "data", "Landroid/content/Intent;", "isPaymentResult", "isSetupResult", "onAuthenticateSourceResult", "onPaymentResult", "onSetupResult", "Lcom/stripe/android/SetupIntentResult;", "retrievePaymentIntent", "retrievePaymentIntentSynchronous", "retrieveSetupIntent", "retrieveSetupIntentSynchronous", "retrieveSource", "sourceId", "retrieveSourceSynchronous", "verifyPaymentIntentWithMicrodeposits", "firstAmount", "secondAmount", "descriptorCode", "verifySetupIntentWithMicrodeposits", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe.kt */
public final class Stripe {
    public static final int $stable = 8;
    public static final String API_VERSION = ApiVersion.Companion.get().getCode();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String VERSION = "AndroidBindings/20.1.0";
    public static final String VERSION_NAME = "20.1.0";
    /* access modifiers changed from: private */
    public static boolean advancedFraudSignalsEnabled = true;
    /* access modifiers changed from: private */
    public static AppInfo appInfo;
    private final PaymentController paymentController;
    private final String publishableKey;
    private final String stripeAccountId;
    private final StripeRepository stripeRepository;
    private final CoroutineContext workContext;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Stripe(Context context, String str) {
        this(context, str, (String) null, false, (Set) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Stripe(Context context, String str, String str2) {
        this(context, str, str2, false, (Set) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Stripe(Context context, String str, String str2, boolean z) {
        this(context, str, str2, z, (Set) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
    }

    public static final boolean getAdvancedFraudSignalsEnabled() {
        return Companion.getAdvancedFraudSignalsEnabled();
    }

    public static final AppInfo getAppInfo() {
        return Companion.getAppInfo();
    }

    public static final void setAdvancedFraudSignalsEnabled(boolean z) {
        Companion.setAdvancedFraudSignalsEnabled(z);
    }

    public static final void setAppInfo(AppInfo appInfo2) {
        Companion.setAppInfo(appInfo2);
    }

    public final void authenticateSource(ComponentActivity componentActivity, Source source) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(source, "source");
        authenticateSource$default(this, componentActivity, source, (String) null, 4, (Object) null);
    }

    public final void authenticateSource(Fragment fragment, Source source) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(source, "source");
        authenticateSource$default(this, fragment, source, (String) null, 4, (Object) null);
    }

    public final void confirmAlipayPayment(ConfirmPaymentIntentParams confirmPaymentIntentParams, AlipayAuthenticator alipayAuthenticator, ApiResultCallback<? super PaymentIntentResult> apiResultCallback) {
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "confirmPaymentIntentParams");
        Intrinsics.checkNotNullParameter(alipayAuthenticator, "authenticator");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        confirmAlipayPayment$default(this, confirmPaymentIntentParams, alipayAuthenticator, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final void confirmPayment(ComponentActivity componentActivity, ConfirmPaymentIntentParams confirmPaymentIntentParams) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "confirmPaymentIntentParams");
        confirmPayment$default(this, componentActivity, confirmPaymentIntentParams, (String) null, 4, (Object) null);
    }

    public final void confirmPayment(Fragment fragment, ConfirmPaymentIntentParams confirmPaymentIntentParams) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "confirmPaymentIntentParams");
        confirmPayment$default(this, fragment, confirmPaymentIntentParams, (String) null, 4, (Object) null);
    }

    @Deprecated(message = "use {@link #confirmPayment(Activity, ConfirmPaymentIntentParams)}")
    public final PaymentIntent confirmPaymentIntentSynchronous(ConfirmPaymentIntentParams confirmPaymentIntentParams) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "confirmPaymentIntentParams");
        return confirmPaymentIntentSynchronous$default(this, confirmPaymentIntentParams, (String) null, 2, (Object) null);
    }

    public final void confirmSetupIntent(ComponentActivity componentActivity, ConfirmSetupIntentParams confirmSetupIntentParams) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(confirmSetupIntentParams, "confirmSetupIntentParams");
        confirmSetupIntent$default(this, componentActivity, confirmSetupIntentParams, (String) null, 4, (Object) null);
    }

    public final void confirmSetupIntent(Fragment fragment, ConfirmSetupIntentParams confirmSetupIntentParams) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(confirmSetupIntentParams, "confirmSetupIntentParams");
        confirmSetupIntent$default(this, fragment, confirmSetupIntentParams, (String) null, 4, (Object) null);
    }

    @Deprecated(message = "use {@link #confirmSetupIntent(Activity, ConfirmSetupIntentParams)}")
    public final SetupIntent confirmSetupIntentSynchronous(ConfirmSetupIntentParams confirmSetupIntentParams) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(confirmSetupIntentParams, "confirmSetupIntentParams");
        return confirmSetupIntentSynchronous$default(this, confirmSetupIntentParams, (String) null, 2, (Object) null);
    }

    @Deprecated(message = "Use the WeChat Pay module instead.")
    public final void confirmWeChatPayPayment(ConfirmPaymentIntentParams confirmPaymentIntentParams, ApiResultCallback<? super WeChatPayNextAction> apiResultCallback) {
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "confirmPaymentIntentParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        confirmWeChatPayPayment$default(this, confirmPaymentIntentParams, (String) null, apiResultCallback, 2, (Object) null);
    }

    public final void createAccountToken(AccountParams accountParams, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(accountParams, "accountParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createAccountToken$default(this, accountParams, (String) null, (String) null, apiResultCallback, 6, (Object) null);
    }

    public final void createAccountToken(AccountParams accountParams, String str, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(accountParams, "accountParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createAccountToken$default(this, accountParams, str, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final Token createAccountTokenSynchronous(AccountParams accountParams) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(accountParams, "accountParams");
        return createAccountTokenSynchronous$default(this, accountParams, (String) null, (String) null, 6, (Object) null);
    }

    public final Token createAccountTokenSynchronous(AccountParams accountParams, String str) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(accountParams, "accountParams");
        return createAccountTokenSynchronous$default(this, accountParams, str, (String) null, 4, (Object) null);
    }

    public final void createBankAccountToken(BankAccountTokenParams bankAccountTokenParams, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(bankAccountTokenParams, "bankAccountTokenParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createBankAccountToken$default(this, bankAccountTokenParams, (String) null, (String) null, apiResultCallback, 6, (Object) null);
    }

    public final void createBankAccountToken(BankAccountTokenParams bankAccountTokenParams, String str, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(bankAccountTokenParams, "bankAccountTokenParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createBankAccountToken$default(this, bankAccountTokenParams, str, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final Token createBankAccountTokenSynchronous(BankAccountTokenParams bankAccountTokenParams) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(bankAccountTokenParams, "bankAccountTokenParams");
        return createBankAccountTokenSynchronous$default(this, bankAccountTokenParams, (String) null, (String) null, 6, (Object) null);
    }

    public final Token createBankAccountTokenSynchronous(BankAccountTokenParams bankAccountTokenParams, String str) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(bankAccountTokenParams, "bankAccountTokenParams");
        return createBankAccountTokenSynchronous$default(this, bankAccountTokenParams, str, (String) null, 4, (Object) null);
    }

    public final void createCardToken(CardParams cardParams, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(cardParams, "cardParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createCardToken$default(this, cardParams, (String) null, (String) null, apiResultCallback, 6, (Object) null);
    }

    public final void createCardToken(CardParams cardParams, String str, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(cardParams, "cardParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createCardToken$default(this, cardParams, str, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final Token createCardTokenSynchronous(CardParams cardParams) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(cardParams, "cardParams");
        return createCardTokenSynchronous$default(this, cardParams, (String) null, (String) null, 6, (Object) null);
    }

    public final Token createCardTokenSynchronous(CardParams cardParams, String str) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(cardParams, "cardParams");
        return createCardTokenSynchronous$default(this, cardParams, str, (String) null, 4, (Object) null);
    }

    public final void createCvcUpdateToken(String str, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "cvc");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createCvcUpdateToken$default(this, str, (String) null, (String) null, apiResultCallback, 6, (Object) null);
    }

    public final void createCvcUpdateToken(String str, String str2, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "cvc");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createCvcUpdateToken$default(this, str, str2, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final Token createCvcUpdateTokenSynchronous(String str) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(str, "cvc");
        return createCvcUpdateTokenSynchronous$default(this, str, (String) null, (String) null, 6, (Object) null);
    }

    public final Token createCvcUpdateTokenSynchronous(String str, String str2) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(str, "cvc");
        return createCvcUpdateTokenSynchronous$default(this, str, str2, (String) null, 4, (Object) null);
    }

    public final void createFile(StripeFileParams stripeFileParams, ApiResultCallback<? super StripeFile> apiResultCallback) {
        Intrinsics.checkNotNullParameter(stripeFileParams, "fileParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createFile$default(this, stripeFileParams, (String) null, (String) null, apiResultCallback, 6, (Object) null);
    }

    public final void createFile(StripeFileParams stripeFileParams, String str, ApiResultCallback<? super StripeFile> apiResultCallback) {
        Intrinsics.checkNotNullParameter(stripeFileParams, "fileParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createFile$default(this, stripeFileParams, str, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final StripeFile createFileSynchronous(StripeFileParams stripeFileParams) {
        Intrinsics.checkNotNullParameter(stripeFileParams, "fileParams");
        return createFileSynchronous$default(this, stripeFileParams, (String) null, (String) null, 6, (Object) null);
    }

    public final StripeFile createFileSynchronous(StripeFileParams stripeFileParams, String str) {
        Intrinsics.checkNotNullParameter(stripeFileParams, "fileParams");
        return createFileSynchronous$default(this, stripeFileParams, str, (String) null, 4, (Object) null);
    }

    public final void createPaymentMethod(PaymentMethodCreateParams paymentMethodCreateParams, ApiResultCallback<? super PaymentMethod> apiResultCallback) {
        Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createPaymentMethod$default(this, paymentMethodCreateParams, (String) null, (String) null, apiResultCallback, 6, (Object) null);
    }

    public final void createPaymentMethod(PaymentMethodCreateParams paymentMethodCreateParams, String str, ApiResultCallback<? super PaymentMethod> apiResultCallback) {
        Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createPaymentMethod$default(this, paymentMethodCreateParams, str, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final PaymentMethod createPaymentMethodSynchronous(PaymentMethodCreateParams paymentMethodCreateParams) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
        return createPaymentMethodSynchronous$default(this, paymentMethodCreateParams, (String) null, (String) null, 6, (Object) null);
    }

    public final PaymentMethod createPaymentMethodSynchronous(PaymentMethodCreateParams paymentMethodCreateParams, String str) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
        return createPaymentMethodSynchronous$default(this, paymentMethodCreateParams, str, (String) null, 4, (Object) null);
    }

    public final void createPersonToken(PersonTokenParams personTokenParams, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(personTokenParams, "params");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createPersonToken$default(this, personTokenParams, (String) null, (String) null, apiResultCallback, 6, (Object) null);
    }

    public final void createPersonToken(PersonTokenParams personTokenParams, String str, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(personTokenParams, "params");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createPersonToken$default(this, personTokenParams, str, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final Token createPersonTokenSynchronous(PersonTokenParams personTokenParams) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(personTokenParams, "params");
        return createPersonTokenSynchronous$default(this, personTokenParams, (String) null, (String) null, 6, (Object) null);
    }

    public final Token createPersonTokenSynchronous(PersonTokenParams personTokenParams, String str) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(personTokenParams, "params");
        return createPersonTokenSynchronous$default(this, personTokenParams, str, (String) null, 4, (Object) null);
    }

    public final void createPiiToken(String str, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "personalId");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createPiiToken$default(this, str, (String) null, (String) null, apiResultCallback, 6, (Object) null);
    }

    public final void createPiiToken(String str, String str2, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "personalId");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createPiiToken$default(this, str, str2, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final Token createPiiTokenSynchronous(String str) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(str, "personalId");
        return createPiiTokenSynchronous$default(this, str, (String) null, (String) null, 6, (Object) null);
    }

    public final Token createPiiTokenSynchronous(String str, String str2) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(str, "personalId");
        return createPiiTokenSynchronous$default(this, str, str2, (String) null, 4, (Object) null);
    }

    public final void createRadarSession(ApiResultCallback<? super RadarSession> apiResultCallback) {
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createRadarSession$default(this, (String) null, apiResultCallback, 1, (Object) null);
    }

    public final void createSource(SourceParams sourceParams, ApiResultCallback<? super Source> apiResultCallback) {
        Intrinsics.checkNotNullParameter(sourceParams, "sourceParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createSource$default(this, sourceParams, (String) null, (String) null, apiResultCallback, 6, (Object) null);
    }

    public final void createSource(SourceParams sourceParams, String str, ApiResultCallback<? super Source> apiResultCallback) {
        Intrinsics.checkNotNullParameter(sourceParams, "sourceParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createSource$default(this, sourceParams, str, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final Source createSourceSynchronous(SourceParams sourceParams) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(sourceParams, "params");
        return createSourceSynchronous$default(this, sourceParams, (String) null, (String) null, 6, (Object) null);
    }

    public final Source createSourceSynchronous(SourceParams sourceParams, String str) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(sourceParams, "params");
        return createSourceSynchronous$default(this, sourceParams, str, (String) null, 4, (Object) null);
    }

    public final void handleNextActionForPayment(ComponentActivity componentActivity, String str) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        handleNextActionForPayment$default(this, componentActivity, str, (String) null, 4, (Object) null);
    }

    public final void handleNextActionForPayment(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        handleNextActionForPayment$default(this, fragment, str, (String) null, 4, (Object) null);
    }

    public final void handleNextActionForSetupIntent(ComponentActivity componentActivity, String str) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        handleNextActionForSetupIntent$default(this, componentActivity, str, (String) null, 4, (Object) null);
    }

    public final void handleNextActionForSetupIntent(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        handleNextActionForSetupIntent$default(this, fragment, str, (String) null, 4, (Object) null);
    }

    public final void retrievePaymentIntent(String str, ApiResultCallback<? super PaymentIntent> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        retrievePaymentIntent$default(this, str, (String) null, apiResultCallback, 2, (Object) null);
    }

    public final PaymentIntent retrievePaymentIntentSynchronous(String str) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        return retrievePaymentIntentSynchronous$default(this, str, (String) null, 2, (Object) null);
    }

    public final void retrieveSetupIntent(String str, ApiResultCallback<? super SetupIntent> apiResultCallback) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        retrieveSetupIntent$default(this, str, (String) null, apiResultCallback, 2, (Object) null);
    }

    public final SetupIntent retrieveSetupIntentSynchronous(String str) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        return retrieveSetupIntentSynchronous$default(this, str, (String) null, 2, (Object) null);
    }

    public final void retrieveSource(String str, String str2, ApiResultCallback<? super Source> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(str2, "clientSecret");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        retrieveSource$default(this, str, str2, (String) null, apiResultCallback, 4, (Object) null);
    }

    public final Source retrieveSourceSynchronous(String str, String str2) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(str2, "clientSecret");
        return retrieveSourceSynchronous$default(this, str, str2, (String) null, 4, (Object) null);
    }

    public Stripe(StripeRepository stripeRepository2, PaymentController paymentController2, String str, String str2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(paymentController2, "paymentController");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.stripeRepository = stripeRepository2;
        this.paymentController = paymentController2;
        this.stripeAccountId = str2;
        this.workContext = coroutineContext;
        this.publishableKey = new ApiKeyValidator().requireValid(str);
    }

    public final StripeRepository getStripeRepository$payments_core_release() {
        return this.stripeRepository;
    }

    public final PaymentController getPaymentController$payments_core_release() {
        return this.paymentController;
    }

    public final String getStripeAccountId$payments_core_release() {
        return this.stripeAccountId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Stripe(StripeRepository stripeRepository2, PaymentController paymentController2, String str, String str2, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stripeRepository2, paymentController2, str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? Dispatchers.getIO() : coroutineContext);
    }

    public final String getPublishableKey$payments_core_release() {
        return this.publishableKey;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Stripe(Context context, String str, String str2, boolean z, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z, (Set<? extends StripeApiBeta>) (i & 16) != 0 ? SetsKt.emptySet() : set);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Stripe(android.content.Context r21, java.lang.String r22, java.lang.String r23, boolean r24, java.util.Set<? extends com.stripe.android.StripeApiBeta> r25) {
        /*
            r20 = this;
            r0 = r22
            r13 = r25
            java.lang.String r1 = "context"
            r2 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "publishableKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "betas"
            r3 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            android.content.Context r15 = r21.getApplicationContext()
            java.lang.String r3 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r3)
            com.stripe.android.networking.StripeApiRepository r18 = new com.stripe.android.networking.StripeApiRepository
            r1 = r18
            android.content.Context r4 = r21.getApplicationContext()
            r2 = r4
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            com.stripe.android.Stripe$1 r3 = new com.stripe.android.Stripe$1
            r3.<init>(r0)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            com.stripe.android.core.AppInfo r4 = appInfo
            com.stripe.android.core.Logger$Companion r5 = com.stripe.android.core.Logger.Companion
            r14 = r24
            com.stripe.android.core.Logger r5 = r5.getInstance(r14)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r14 = r16
            r19 = r15
            r15 = r16
            r16 = 14320(0x37f0, float:2.0067E-41)
            r17 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r4 = r18
            com.stripe.android.networking.StripeRepository r4 = (com.stripe.android.networking.StripeRepository) r4
            com.stripe.android.core.ApiKeyValidator$Companion r1 = com.stripe.android.core.ApiKeyValidator.Companion
            com.stripe.android.core.ApiKeyValidator r1 = r1.get()
            java.lang.String r5 = r1.requireValid(r0)
            r2 = r20
            r3 = r19
            r6 = r23
            r7 = r24
            r2.<init>((android.content.Context) r3, (com.stripe.android.networking.StripeRepository) r4, (java.lang.String) r5, (java.lang.String) r6, (boolean) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.Stripe.<init>(android.content.Context, java.lang.String, java.lang.String, boolean, java.util.Set):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Stripe(android.content.Context r15, com.stripe.android.networking.StripeRepository r16, java.lang.String r17, java.lang.String r18, boolean r19) {
        /*
            r14 = this;
            r0 = r17
            com.stripe.android.StripePaymentController r13 = new com.stripe.android.StripePaymentController
            android.content.Context r2 = r15.getApplicationContext()
            java.lang.String r1 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            com.stripe.android.Stripe$2 r1 = new com.stripe.android.Stripe$2
            r1.<init>(r0)
            r3 = r1
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 496(0x1f0, float:6.95E-43)
            r12 = 0
            r1 = r13
            r4 = r16
            r5 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.stripe.android.PaymentController r13 = (com.stripe.android.PaymentController) r13
            r1 = r14
            r2 = r16
            r3 = r18
            r14.<init>((com.stripe.android.networking.StripeRepository) r2, (com.stripe.android.PaymentController) r13, (java.lang.String) r0, (java.lang.String) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.Stripe.<init>(android.content.Context, com.stripe.android.networking.StripeRepository, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Stripe(StripeRepository stripeRepository2, PaymentController paymentController2, String str, String str2) {
        this(stripeRepository2, paymentController2, str, str2, (CoroutineContext) Dispatchers.getIO());
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(paymentController2, "paymentController");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
    }

    public static /* synthetic */ void confirmPayment$default(Stripe stripe, ComponentActivity componentActivity, ConfirmPaymentIntentParams confirmPaymentIntentParams, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = stripe.stripeAccountId;
        }
        stripe.confirmPayment(componentActivity, confirmPaymentIntentParams, str);
    }

    public final void confirmPayment(ComponentActivity componentActivity, ConfirmPaymentIntentParams confirmPaymentIntentParams, String str) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "confirmPaymentIntentParams");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(componentActivity), (CoroutineContext) null, (CoroutineStart) null, new Stripe$confirmPayment$1(this, componentActivity, confirmPaymentIntentParams, str, (Continuation<? super Stripe$confirmPayment$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void confirmAlipayPayment$default(Stripe stripe, ConfirmPaymentIntentParams confirmPaymentIntentParams, AlipayAuthenticator alipayAuthenticator, String str, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            str = stripe.stripeAccountId;
        }
        stripe.confirmAlipayPayment(confirmPaymentIntentParams, alipayAuthenticator, str, apiResultCallback);
    }

    public final void confirmAlipayPayment(ConfirmPaymentIntentParams confirmPaymentIntentParams, AlipayAuthenticator alipayAuthenticator, String str, ApiResultCallback<? super PaymentIntentResult> apiResultCallback) {
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "confirmPaymentIntentParams");
        Intrinsics.checkNotNullParameter(alipayAuthenticator, "authenticator");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$confirmAlipayPayment$1(this, confirmPaymentIntentParams, alipayAuthenticator, str, (Continuation<? super Stripe$confirmAlipayPayment$1>) null));
    }

    public static /* synthetic */ void confirmWeChatPayPayment$default(Stripe stripe, ConfirmPaymentIntentParams confirmPaymentIntentParams, String str, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = stripe.stripeAccountId;
        }
        stripe.confirmWeChatPayPayment(confirmPaymentIntentParams, str, apiResultCallback);
    }

    @Deprecated(message = "Use the WeChat Pay module instead.")
    public final void confirmWeChatPayPayment(ConfirmPaymentIntentParams confirmPaymentIntentParams, String str, ApiResultCallback<? super WeChatPayNextAction> apiResultCallback) {
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "confirmPaymentIntentParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$confirmWeChatPayPayment$1(this, confirmPaymentIntentParams, str, (Continuation<? super Stripe$confirmWeChatPayPayment$1>) null));
    }

    public static /* synthetic */ void confirmPayment$default(Stripe stripe, Fragment fragment, ConfirmPaymentIntentParams confirmPaymentIntentParams, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = stripe.stripeAccountId;
        }
        stripe.confirmPayment(fragment, confirmPaymentIntentParams, str);
    }

    public final void confirmPayment(Fragment fragment, ConfirmPaymentIntentParams confirmPaymentIntentParams, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "confirmPaymentIntentParams");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(fragment), (CoroutineContext) null, (CoroutineStart) null, new Stripe$confirmPayment$2(this, fragment, confirmPaymentIntentParams, str, (Continuation<? super Stripe$confirmPayment$2>) null), 3, (Object) null);
    }

    public static /* synthetic */ void handleNextActionForPayment$default(Stripe stripe, ComponentActivity componentActivity, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.handleNextActionForPayment(componentActivity, str, str2);
    }

    public final void handleNextActionForPayment(ComponentActivity componentActivity, String str, String str2) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(componentActivity), (CoroutineContext) null, (CoroutineStart) null, new Stripe$handleNextActionForPayment$1(this, componentActivity, str, str2, (Continuation<? super Stripe$handleNextActionForPayment$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void handleNextActionForPayment$default(Stripe stripe, Fragment fragment, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.handleNextActionForPayment(fragment, str, str2);
    }

    public final void handleNextActionForPayment(Fragment fragment, String str, String str2) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(fragment), (CoroutineContext) null, (CoroutineStart) null, new Stripe$handleNextActionForPayment$2(this, fragment, str, str2, (Continuation<? super Stripe$handleNextActionForPayment$2>) null), 3, (Object) null);
    }

    public final boolean isPaymentResult(int i, Intent intent) {
        return intent != null && this.paymentController.shouldHandlePaymentResult(i, intent);
    }

    public final boolean onPaymentResult(int i, Intent intent, ApiResultCallback<? super PaymentIntentResult> apiResultCallback) {
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        if (intent == null || !isPaymentResult(i, intent)) {
            return false;
        }
        executeAsync(apiResultCallback, new Stripe$onPaymentResult$1(this, intent, (Continuation<? super Stripe$onPaymentResult$1>) null));
        return true;
    }

    public static /* synthetic */ void retrievePaymentIntent$default(Stripe stripe, String str, String str2, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.retrievePaymentIntent(str, str2, apiResultCallback);
    }

    public final void retrievePaymentIntent(String str, String str2, ApiResultCallback<? super PaymentIntent> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$retrievePaymentIntent$1(this, str, str2, (Continuation<? super Stripe$retrievePaymentIntent$1>) null));
    }

    public static /* synthetic */ PaymentIntent retrievePaymentIntentSynchronous$default(Stripe stripe, String str, String str2, int i, Object obj) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        if ((i & 2) != 0) {
            str2 = stripe.stripeAccountId;
        }
        return stripe.retrievePaymentIntentSynchronous(str, str2);
    }

    public final PaymentIntent retrievePaymentIntentSynchronous(String str, String str2) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        return (PaymentIntent) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$retrievePaymentIntentSynchronous$1(this, str, str2, (Continuation<? super Stripe$retrievePaymentIntentSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ PaymentIntent confirmPaymentIntentSynchronous$default(Stripe stripe, ConfirmPaymentIntentParams confirmPaymentIntentParams, String str, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        return stripe.confirmPaymentIntentSynchronous(confirmPaymentIntentParams, str);
    }

    @Deprecated(message = "use {@link #confirmPayment(Activity, ConfirmPaymentIntentParams)}")
    public final PaymentIntent confirmPaymentIntentSynchronous(ConfirmPaymentIntentParams confirmPaymentIntentParams, String str) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "confirmPaymentIntentParams");
        return (PaymentIntent) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$confirmPaymentIntentSynchronous$1(this, confirmPaymentIntentParams, str, (Continuation<? super Stripe$confirmPaymentIntentSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ void confirmSetupIntent$default(Stripe stripe, ComponentActivity componentActivity, ConfirmSetupIntentParams confirmSetupIntentParams, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = stripe.stripeAccountId;
        }
        stripe.confirmSetupIntent(componentActivity, confirmSetupIntentParams, str);
    }

    public final void confirmSetupIntent(ComponentActivity componentActivity, ConfirmSetupIntentParams confirmSetupIntentParams, String str) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(confirmSetupIntentParams, "confirmSetupIntentParams");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(componentActivity), (CoroutineContext) null, (CoroutineStart) null, new Stripe$confirmSetupIntent$1(this, componentActivity, confirmSetupIntentParams, str, (Continuation<? super Stripe$confirmSetupIntent$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void confirmSetupIntent$default(Stripe stripe, Fragment fragment, ConfirmSetupIntentParams confirmSetupIntentParams, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = stripe.stripeAccountId;
        }
        stripe.confirmSetupIntent(fragment, confirmSetupIntentParams, str);
    }

    public final void confirmSetupIntent(Fragment fragment, ConfirmSetupIntentParams confirmSetupIntentParams, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(confirmSetupIntentParams, "confirmSetupIntentParams");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(fragment), (CoroutineContext) null, (CoroutineStart) null, new Stripe$confirmSetupIntent$2(this, fragment, confirmSetupIntentParams, str, (Continuation<? super Stripe$confirmSetupIntent$2>) null), 3, (Object) null);
    }

    public static /* synthetic */ void handleNextActionForSetupIntent$default(Stripe stripe, ComponentActivity componentActivity, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.handleNextActionForSetupIntent(componentActivity, str, str2);
    }

    public final void handleNextActionForSetupIntent(ComponentActivity componentActivity, String str, String str2) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(componentActivity), (CoroutineContext) null, (CoroutineStart) null, new Stripe$handleNextActionForSetupIntent$1(this, componentActivity, str, str2, (Continuation<? super Stripe$handleNextActionForSetupIntent$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void handleNextActionForSetupIntent$default(Stripe stripe, Fragment fragment, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.handleNextActionForSetupIntent(fragment, str, str2);
    }

    public final void handleNextActionForSetupIntent(Fragment fragment, String str, String str2) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(fragment), (CoroutineContext) null, (CoroutineStart) null, new Stripe$handleNextActionForSetupIntent$2(this, fragment, str, str2, (Continuation<? super Stripe$handleNextActionForSetupIntent$2>) null), 3, (Object) null);
    }

    public final boolean isSetupResult(int i, Intent intent) {
        return intent != null && this.paymentController.shouldHandleSetupResult(i, intent);
    }

    public final boolean onSetupResult(int i, Intent intent, ApiResultCallback<? super SetupIntentResult> apiResultCallback) {
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        if (intent == null || !isSetupResult(i, intent)) {
            return false;
        }
        executeAsync(apiResultCallback, new Stripe$onSetupResult$1(this, intent, (Continuation<? super Stripe$onSetupResult$1>) null));
        return true;
    }

    public static /* synthetic */ void retrieveSetupIntent$default(Stripe stripe, String str, String str2, ApiResultCallback apiResultCallback, int i, Object obj) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        if ((i & 2) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.retrieveSetupIntent(str, str2, apiResultCallback);
    }

    public final void retrieveSetupIntent(String str, String str2, ApiResultCallback<? super SetupIntent> apiResultCallback) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$retrieveSetupIntent$1(this, str, str2, (Continuation<? super Stripe$retrieveSetupIntent$1>) null));
    }

    public static /* synthetic */ SetupIntent retrieveSetupIntentSynchronous$default(Stripe stripe, String str, String str2, int i, Object obj) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        if ((i & 2) != 0) {
            str2 = stripe.stripeAccountId;
        }
        return stripe.retrieveSetupIntentSynchronous(str, str2);
    }

    public final SetupIntent retrieveSetupIntentSynchronous(String str, String str2) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        return (SetupIntent) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$retrieveSetupIntentSynchronous$1(this, str, str2, (Continuation<? super Stripe$retrieveSetupIntentSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ SetupIntent confirmSetupIntentSynchronous$default(Stripe stripe, ConfirmSetupIntentParams confirmSetupIntentParams, String str, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        return stripe.confirmSetupIntentSynchronous(confirmSetupIntentParams, str);
    }

    @Deprecated(message = "use {@link #confirmSetupIntent(Activity, ConfirmSetupIntentParams)}")
    public final SetupIntent confirmSetupIntentSynchronous(ConfirmSetupIntentParams confirmSetupIntentParams, String str) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(confirmSetupIntentParams, "confirmSetupIntentParams");
        return (SetupIntent) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$confirmSetupIntentSynchronous$1(this, confirmSetupIntentParams, str, (Continuation<? super Stripe$confirmSetupIntentSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ void createPaymentMethod$default(Stripe stripe, PaymentMethodCreateParams paymentMethodCreateParams, String str, String str2, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.createPaymentMethod(paymentMethodCreateParams, str, str2, apiResultCallback);
    }

    public final void createPaymentMethod(PaymentMethodCreateParams paymentMethodCreateParams, String str, String str2, ApiResultCallback<? super PaymentMethod> apiResultCallback) {
        Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$createPaymentMethod$1(this, paymentMethodCreateParams, str2, str, (Continuation<? super Stripe$createPaymentMethod$1>) null));
    }

    public static /* synthetic */ PaymentMethod createPaymentMethodSynchronous$default(Stripe stripe, PaymentMethodCreateParams paymentMethodCreateParams, String str, String str2, int i, Object obj) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        return stripe.createPaymentMethodSynchronous(paymentMethodCreateParams, str, str2);
    }

    public final PaymentMethod createPaymentMethodSynchronous(PaymentMethodCreateParams paymentMethodCreateParams, String str, String str2) throws APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
        return (PaymentMethod) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$createPaymentMethodSynchronous$1(this, paymentMethodCreateParams, str2, str, (Continuation<? super Stripe$createPaymentMethodSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ void authenticateSource$default(Stripe stripe, ComponentActivity componentActivity, Source source, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = stripe.stripeAccountId;
        }
        stripe.authenticateSource(componentActivity, source, str);
    }

    public final void authenticateSource(ComponentActivity componentActivity, Source source, String str) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(source, "source");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(componentActivity), (CoroutineContext) null, (CoroutineStart) null, new Stripe$authenticateSource$1(this, componentActivity, source, str, (Continuation<? super Stripe$authenticateSource$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void authenticateSource$default(Stripe stripe, Fragment fragment, Source source, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = stripe.stripeAccountId;
        }
        stripe.authenticateSource(fragment, source, str);
    }

    public final void authenticateSource(Fragment fragment, Source source, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(source, "source");
        LifecycleOwnerKt.getLifecycleScope(fragment).launchWhenCreated(new Stripe$authenticateSource$2(this, fragment, source, str, (Continuation<? super Stripe$authenticateSource$2>) null));
    }

    public final boolean isAuthenticateSourceResult(int i, Intent intent) {
        return intent != null && this.paymentController.shouldHandleSourceResult(i, intent);
    }

    public final void onAuthenticateSourceResult(Intent intent, ApiResultCallback<? super Source> apiResultCallback) {
        Intrinsics.checkNotNullParameter(intent, "data");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$onAuthenticateSourceResult$1(this, intent, (Continuation<? super Stripe$onAuthenticateSourceResult$1>) null));
    }

    public static /* synthetic */ void createSource$default(Stripe stripe, SourceParams sourceParams, String str, String str2, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.createSource(sourceParams, str, str2, apiResultCallback);
    }

    public final void createSource(SourceParams sourceParams, String str, String str2, ApiResultCallback<? super Source> apiResultCallback) {
        Intrinsics.checkNotNullParameter(sourceParams, "sourceParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$createSource$1(this, sourceParams, str2, str, (Continuation<? super Stripe$createSource$1>) null));
    }

    public static /* synthetic */ Source createSourceSynchronous$default(Stripe stripe, SourceParams sourceParams, String str, String str2, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        return stripe.createSourceSynchronous(sourceParams, str, str2);
    }

    public final Source createSourceSynchronous(SourceParams sourceParams, String str, String str2) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(sourceParams, "params");
        return (Source) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$createSourceSynchronous$1(this, sourceParams, str2, str, (Continuation<? super Stripe$createSourceSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ void retrieveSource$default(Stripe stripe, String str, String str2, String str3, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = stripe.stripeAccountId;
        }
        stripe.retrieveSource(str, str2, str3, apiResultCallback);
    }

    public final void retrieveSource(String str, String str2, String str3, ApiResultCallback<? super Source> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(str2, "clientSecret");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$retrieveSource$1(this, str, str2, str3, (Continuation<? super Stripe$retrieveSource$1>) null));
    }

    public static /* synthetic */ Source retrieveSourceSynchronous$default(Stripe stripe, String str, String str2, String str3, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 4) != 0) {
            str3 = stripe.stripeAccountId;
        }
        return stripe.retrieveSourceSynchronous(str, str2, str3);
    }

    public final Source retrieveSourceSynchronous(String str, String str2, String str3) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(str2, "clientSecret");
        return (Source) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$retrieveSourceSynchronous$1(this, str, str2, str3, (Continuation<? super Stripe$retrieveSourceSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ void createAccountToken$default(Stripe stripe, AccountParams accountParams, String str, String str2, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.createAccountToken(accountParams, str, str2, apiResultCallback);
    }

    public final void createAccountToken(AccountParams accountParams, String str, String str2, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(accountParams, "accountParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createToken(accountParams, str2, str, apiResultCallback);
    }

    public static /* synthetic */ Token createAccountTokenSynchronous$default(Stripe stripe, AccountParams accountParams, String str, String str2, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        return stripe.createAccountTokenSynchronous(accountParams, str, str2);
    }

    public final Token createAccountTokenSynchronous(AccountParams accountParams, String str, String str2) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Intrinsics.checkNotNullParameter(accountParams, "accountParams");
        try {
            return (Token) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$createAccountTokenSynchronous$1(this, accountParams, str2, str, (Continuation<? super Stripe$createAccountTokenSynchronous$1>) null), 1, (Object) null);
        } catch (CardException unused) {
            return null;
        }
    }

    public static /* synthetic */ void createBankAccountToken$default(Stripe stripe, BankAccountTokenParams bankAccountTokenParams, String str, String str2, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.createBankAccountToken(bankAccountTokenParams, str, str2, apiResultCallback);
    }

    public final void createBankAccountToken(BankAccountTokenParams bankAccountTokenParams, String str, String str2, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(bankAccountTokenParams, "bankAccountTokenParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createToken(bankAccountTokenParams, str2, str, apiResultCallback);
    }

    public static /* synthetic */ Token createBankAccountTokenSynchronous$default(Stripe stripe, BankAccountTokenParams bankAccountTokenParams, String str, String str2, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        return stripe.createBankAccountTokenSynchronous(bankAccountTokenParams, str, str2);
    }

    public final Token createBankAccountTokenSynchronous(BankAccountTokenParams bankAccountTokenParams, String str, String str2) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(bankAccountTokenParams, "bankAccountTokenParams");
        return (Token) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$createBankAccountTokenSynchronous$1(this, bankAccountTokenParams, str2, str, (Continuation<? super Stripe$createBankAccountTokenSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ void createPiiToken$default(Stripe stripe, String str, String str2, String str3, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = stripe.stripeAccountId;
        }
        stripe.createPiiToken(str, str2, str3, apiResultCallback);
    }

    public final void createPiiToken(String str, String str2, String str3, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "personalId");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createToken(new PiiTokenParams(str), str3, str2, apiResultCallback);
    }

    public static /* synthetic */ Token createPiiTokenSynchronous$default(Stripe stripe, String str, String str2, String str3, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = stripe.stripeAccountId;
        }
        return stripe.createPiiTokenSynchronous(str, str2, str3);
    }

    public final Token createPiiTokenSynchronous(String str, String str2, String str3) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(str, "personalId");
        return (Token) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$createPiiTokenSynchronous$1(this, str, str3, str2, (Continuation<? super Stripe$createPiiTokenSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ void createCardToken$default(Stripe stripe, CardParams cardParams, String str, String str2, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.createCardToken(cardParams, str, str2, apiResultCallback);
    }

    public final void createCardToken(CardParams cardParams, String str, String str2, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(cardParams, "cardParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createToken(cardParams, str2, str, apiResultCallback);
    }

    public static /* synthetic */ Token createCardTokenSynchronous$default(Stripe stripe, CardParams cardParams, String str, String str2, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        return stripe.createCardTokenSynchronous(cardParams, str, str2);
    }

    public final Token createCardTokenSynchronous(CardParams cardParams, String str, String str2) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(cardParams, "cardParams");
        return (Token) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$createCardTokenSynchronous$1(this, cardParams, str2, str, (Continuation<? super Stripe$createCardTokenSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ void createCvcUpdateToken$default(Stripe stripe, String str, String str2, String str3, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = stripe.stripeAccountId;
        }
        stripe.createCvcUpdateToken(str, str2, str3, apiResultCallback);
    }

    public final void createCvcUpdateToken(String str, String str2, String str3, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "cvc");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createToken(new CvcTokenParams(str), str3, str2, apiResultCallback);
    }

    public static /* synthetic */ Token createCvcUpdateTokenSynchronous$default(Stripe stripe, String str, String str2, String str3, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = stripe.stripeAccountId;
        }
        return stripe.createCvcUpdateTokenSynchronous(str, str2, str3);
    }

    public final Token createCvcUpdateTokenSynchronous(String str, String str2, String str3) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(str, "cvc");
        return (Token) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$createCvcUpdateTokenSynchronous$1(this, str, str3, str2, (Continuation<? super Stripe$createCvcUpdateTokenSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ void createPersonToken$default(Stripe stripe, PersonTokenParams personTokenParams, String str, String str2, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.createPersonToken(personTokenParams, str, str2, apiResultCallback);
    }

    public final void createPersonToken(PersonTokenParams personTokenParams, String str, String str2, ApiResultCallback<? super Token> apiResultCallback) {
        Intrinsics.checkNotNullParameter(personTokenParams, "params");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        createToken(personTokenParams, str2, str, apiResultCallback);
    }

    public static /* synthetic */ Token createPersonTokenSynchronous$default(Stripe stripe, PersonTokenParams personTokenParams, String str, String str2, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        return stripe.createPersonTokenSynchronous(personTokenParams, str, str2);
    }

    public final Token createPersonTokenSynchronous(PersonTokenParams personTokenParams, String str, String str2) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Intrinsics.checkNotNullParameter(personTokenParams, "params");
        return (Token) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$createPersonTokenSynchronous$1(this, personTokenParams, str2, str, (Continuation<? super Stripe$createPersonTokenSynchronous$1>) null), 1, (Object) null);
    }

    static /* synthetic */ void createToken$default(Stripe stripe, TokenParams tokenParams, String str, String str2, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        stripe.createToken(tokenParams, str, str2, apiResultCallback);
    }

    private final void createToken(TokenParams tokenParams, String str, String str2, ApiResultCallback<? super Token> apiResultCallback) {
        executeAsync(apiResultCallback, new Stripe$createToken$1(this, tokenParams, str, str2, (Continuation<? super Stripe$createToken$1>) null));
    }

    public static /* synthetic */ void createFile$default(Stripe stripe, StripeFileParams stripeFileParams, String str, String str2, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        stripe.createFile(stripeFileParams, str, str2, apiResultCallback);
    }

    public final void createFile(StripeFileParams stripeFileParams, String str, String str2, ApiResultCallback<? super StripeFile> apiResultCallback) {
        Intrinsics.checkNotNullParameter(stripeFileParams, "fileParams");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$createFile$1(this, stripeFileParams, str2, str, (Continuation<? super Stripe$createFile$1>) null));
    }

    public static /* synthetic */ StripeFile createFileSynchronous$default(Stripe stripe, StripeFileParams stripeFileParams, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.stripeAccountId;
        }
        return stripe.createFileSynchronous(stripeFileParams, str, str2);
    }

    public final StripeFile createFileSynchronous(StripeFileParams stripeFileParams, String str, String str2) {
        Intrinsics.checkNotNullParameter(stripeFileParams, "fileParams");
        return (StripeFile) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new Stripe$createFileSynchronous$1(this, stripeFileParams, str2, str, (Continuation<? super Stripe$createFileSynchronous$1>) null), 1, (Object) null);
    }

    public static /* synthetic */ void createRadarSession$default(Stripe stripe, String str, ApiResultCallback apiResultCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stripe.stripeAccountId;
        }
        stripe.createRadarSession(str, apiResultCallback);
    }

    public final void createRadarSession(String str, ApiResultCallback<? super RadarSession> apiResultCallback) {
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$createRadarSession$1(this, str, (Continuation<? super Stripe$createRadarSession$1>) null));
    }

    public final void verifyPaymentIntentWithMicrodeposits(String str, int i, int i2, ApiResultCallback<? super PaymentIntent> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$verifyPaymentIntentWithMicrodeposits$1(this, str, i, i2, (Continuation<? super Stripe$verifyPaymentIntentWithMicrodeposits$1>) null));
    }

    public final void verifyPaymentIntentWithMicrodeposits(String str, String str2, ApiResultCallback<? super PaymentIntent> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(str2, "descriptorCode");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$verifyPaymentIntentWithMicrodeposits$2(this, str, str2, (Continuation<? super Stripe$verifyPaymentIntentWithMicrodeposits$2>) null));
    }

    public final void verifySetupIntentWithMicrodeposits(String str, int i, int i2, ApiResultCallback<? super SetupIntent> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$verifySetupIntentWithMicrodeposits$1(this, str, i, i2, (Continuation<? super Stripe$verifySetupIntentWithMicrodeposits$1>) null));
    }

    public final void verifySetupIntentWithMicrodeposits(String str, String str2, ApiResultCallback<? super SetupIntent> apiResultCallback) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(str2, "descriptorCode");
        Intrinsics.checkNotNullParameter(apiResultCallback, "callback");
        executeAsync(apiResultCallback, new Stripe$verifySetupIntentWithMicrodeposits$2(this, str, str2, (Continuation<? super Stripe$verifySetupIntentWithMicrodeposits$2>) null));
    }

    private final <T extends StripeModel> void executeAsync(ApiResultCallback<? super T> apiResultCallback, Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new Stripe$executeAsync$1(this, apiResultCallback, function1, (Continuation<? super Stripe$executeAsync$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final <T extends StripeModel> Object dispatchResult(Object obj, ApiResultCallback<? super T> apiResultCallback, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new Stripe$dispatchResult$2(obj, apiResultCallback, (Continuation<? super Stripe$dispatchResult$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R$\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/Stripe$Companion;", "", "()V", "API_VERSION", "", "VERSION", "getVERSION$annotations", "VERSION_NAME", "getVERSION_NAME$annotations", "advancedFraudSignalsEnabled", "", "getAdvancedFraudSignalsEnabled$annotations", "getAdvancedFraudSignalsEnabled", "()Z", "setAdvancedFraudSignalsEnabled", "(Z)V", "appInfo", "Lcom/stripe/android/core/AppInfo;", "getAppInfo$annotations", "getAppInfo", "()Lcom/stripe/android/core/AppInfo;", "setAppInfo", "(Lcom/stripe/android/core/AppInfo;)V", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getAdvancedFraudSignalsEnabled$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getAppInfo$annotations() {
        }

        @Deprecated(message = "Use StripeSdkVersion.VERSION instead", replaceWith = @ReplaceWith(expression = "StripeSdkVersion.VERSION", imports = {"com.stripe.android.core.version.StripeSdkVersion"}))
        public static /* synthetic */ void getVERSION$annotations() {
        }

        @Deprecated(message = "Use StripeSdkVersion.VERSION_NAME instead", replaceWith = @ReplaceWith(expression = "StripeSdkVersion.VERSION_NAME", imports = {"com.stripe.android.core.version.StripeSdkVersion"}))
        public static /* synthetic */ void getVERSION_NAME$annotations() {
        }

        private Companion() {
        }

        public final AppInfo getAppInfo() {
            return Stripe.appInfo;
        }

        public final void setAppInfo(AppInfo appInfo) {
            Stripe.appInfo = appInfo;
        }

        public final boolean getAdvancedFraudSignalsEnabled() {
            return Stripe.advancedFraudSignalsEnabled;
        }

        public final void setAdvancedFraudSignalsEnabled(boolean z) {
            Stripe.advancedFraudSignalsEnabled = z;
        }
    }
}
