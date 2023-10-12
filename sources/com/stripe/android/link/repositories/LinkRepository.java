package com.stripe.android.link.repositories;

import com.stripe.android.model.ConsumerPaymentDetails;
import com.stripe.android.model.ConsumerSession;
import com.stripe.android.model.ConsumerSessionLookup;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJD\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017J4\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001a\u0010\u0017J4\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001c\u0010\u0017\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/link/repositories/LinkRepository;", "", "confirmVerification", "Lkotlin/Result;", "Lcom/stripe/android/model/ConsumerSession;", "consumerSessionClientSecret", "", "verificationCode", "authSessionCookie", "confirmVerification-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumerSignUp", "email", "phone", "country", "consumerSignUp-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listPaymentDetails", "Lcom/stripe/android/model/ConsumerPaymentDetails;", "listPaymentDetails-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "logout-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookupConsumer", "Lcom/stripe/android/model/ConsumerSessionLookup;", "lookupConsumer-0E7RQCE", "startVerification", "startVerification-0E7RQCE", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkRepository.kt */
public interface LinkRepository {
    /* renamed from: confirmVerification-BWLJW6A  reason: not valid java name */
    Object m4318confirmVerificationBWLJW6A(String str, String str2, String str3, Continuation<? super Result<ConsumerSession>> continuation);

    /* renamed from: consumerSignUp-yxL6bBk  reason: not valid java name */
    Object m4319consumerSignUpyxL6bBk(String str, String str2, String str3, String str4, Continuation<? super Result<ConsumerSession>> continuation);

    /* renamed from: listPaymentDetails-gIAlu-s  reason: not valid java name */
    Object m4320listPaymentDetailsgIAlus(String str, Continuation<? super Result<ConsumerPaymentDetails>> continuation);

    /* renamed from: logout-0E7RQCE  reason: not valid java name */
    Object m4321logout0E7RQCE(String str, String str2, Continuation<? super Result<ConsumerSession>> continuation);

    /* renamed from: lookupConsumer-0E7RQCE  reason: not valid java name */
    Object m4322lookupConsumer0E7RQCE(String str, String str2, Continuation<? super Result<ConsumerSessionLookup>> continuation);

    /* renamed from: startVerification-0E7RQCE  reason: not valid java name */
    Object m4323startVerification0E7RQCE(String str, String str2, Continuation<? super Result<ConsumerSession>> continuation);
}
