package com.stripe.android.view;

import com.stripe.android.view.CardInputWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\bZ\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 w2\u00020\u0001:\u0001wB¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013J\u000e\u0010<\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b=J\u000e\u0010>\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b?J\u000e\u0010@\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bAJ\u000e\u0010B\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bCJ\u000e\u0010D\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bEJ\u000e\u0010F\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bGJ\u000e\u0010H\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bIJ\u000e\u0010J\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bKJ\u000e\u0010L\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bMJ\u000e\u0010N\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bOJ\u000e\u0010P\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bQJ\u000e\u0010R\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bSJ\u000e\u0010T\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bUJ\u000e\u0010V\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bWJ\u000e\u0010X\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bYJ\u000e\u0010Z\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b[J©\u0001\u0010\\\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0015\u0010`\u001a\u00020\u00032\u0006\u0010a\u001a\u00020^H\u0000¢\u0006\u0002\bbJ\u0015\u0010c\u001a\u00020\u00032\u0006\u0010a\u001a\u00020^H\u0000¢\u0006\u0002\bdJ/\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010g\u001a\u00020\u00032\u0006\u0010h\u001a\u00020\u00032\u0006\u0010i\u001a\u00020^2\u0006\u0010j\u001a\u00020^H\u0000¢\u0006\u0002\bkJ\u0015\u0010l\u001a\u00020\u00032\u0006\u0010a\u001a\u00020^H\u0000¢\u0006\u0002\bmJ\t\u0010n\u001a\u00020\u0003HÖ\u0001J\u0010\u0010o\u001a\u00020\u00032\u0006\u0010p\u001a\u00020\u0003H\u0002J\b\u0010q\u001a\u00020rH\u0016J-\u0010s\u001a\u00020t2\u0006\u0010i\u001a\u00020^2\u0006\u0010j\u001a\u00020^2\u0006\u0010h\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\u0003H\u0000¢\u0006\u0002\bvR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017¨\u0006x"}, d2 = {"Lcom/stripe/android/view/CardInputWidgetPlacement;", "", "totalLengthInPixels", "", "cardWidth", "hiddenCardWidth", "peekCardWidth", "cardDateSeparation", "dateWidth", "dateCvcSeparation", "cvcWidth", "cvcPostalCodeSeparation", "postalCodeWidth", "cardTouchBufferLimit", "dateStartPosition", "dateEndTouchBufferLimit", "cvcStartPosition", "cvcEndTouchBufferLimit", "postalCodeStartPosition", "(IIIIIIIIIIIIIIII)V", "getCardDateSeparation$payments_core_release", "()I", "setCardDateSeparation$payments_core_release", "(I)V", "cardPeekCvcStartMargin", "getCardPeekCvcStartMargin", "cardPeekDateStartMargin", "getCardPeekDateStartMargin", "cardPeekPostalCodeStartMargin", "getCardPeekPostalCodeStartMargin", "getCardTouchBufferLimit$payments_core_release", "setCardTouchBufferLimit$payments_core_release", "getCardWidth$payments_core_release", "setCardWidth$payments_core_release", "getCvcEndTouchBufferLimit$payments_core_release", "setCvcEndTouchBufferLimit$payments_core_release", "getCvcPostalCodeSeparation$payments_core_release", "setCvcPostalCodeSeparation$payments_core_release", "getCvcStartPosition$payments_core_release", "setCvcStartPosition$payments_core_release", "getCvcWidth$payments_core_release", "setCvcWidth$payments_core_release", "getDateCvcSeparation$payments_core_release", "setDateCvcSeparation$payments_core_release", "getDateEndTouchBufferLimit$payments_core_release", "setDateEndTouchBufferLimit$payments_core_release", "getDateStartPosition$payments_core_release", "setDateStartPosition$payments_core_release", "getDateWidth$payments_core_release", "setDateWidth$payments_core_release", "getHiddenCardWidth$payments_core_release", "setHiddenCardWidth$payments_core_release", "getPeekCardWidth$payments_core_release", "setPeekCardWidth$payments_core_release", "getPostalCodeStartPosition$payments_core_release", "setPostalCodeStartPosition$payments_core_release", "getPostalCodeWidth$payments_core_release", "setPostalCodeWidth$payments_core_release", "getTotalLengthInPixels$payments_core_release", "setTotalLengthInPixels$payments_core_release", "component1", "component1$payments_core_release", "component10", "component10$payments_core_release", "component11", "component11$payments_core_release", "component12", "component12$payments_core_release", "component13", "component13$payments_core_release", "component14", "component14$payments_core_release", "component15", "component15$payments_core_release", "component16", "component16$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "component6", "component6$payments_core_release", "component7", "component7$payments_core_release", "component8", "component8$payments_core_release", "component9", "component9$payments_core_release", "copy", "equals", "", "other", "getCvcStartMargin", "isFullCard", "getCvcStartMargin$payments_core_release", "getDateStartMargin", "getDateStartMargin$payments_core_release", "getFocusField", "Lcom/stripe/android/view/CardInputWidget$Field;", "touchX", "frameStart", "isShowingFullCard", "postalCodeEnabled", "getFocusField$payments_core_release", "getPostalCodeStartMargin", "getPostalCodeStartMargin$payments_core_release", "hashCode", "toMinimalValueIfNegative", "value", "toString", "", "updateSpacing", "", "frameWidth", "updateSpacing$payments_core_release", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardInputWidgetPlacement.kt */
public final class CardInputWidgetPlacement {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int MIN_SEPARATION_IN_PX = 10;
    private int cardDateSeparation;
    private int cardTouchBufferLimit;
    private int cardWidth;
    private int cvcEndTouchBufferLimit;
    private int cvcPostalCodeSeparation;
    private int cvcStartPosition;
    private int cvcWidth;
    private int dateCvcSeparation;
    private int dateEndTouchBufferLimit;
    private int dateStartPosition;
    private int dateWidth;
    private int hiddenCardWidth;
    private int peekCardWidth;
    private int postalCodeStartPosition;
    private int postalCodeWidth;
    private int totalLengthInPixels;

    public CardInputWidgetPlacement() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65535, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CardInputWidgetPlacement copy$default(CardInputWidgetPlacement cardInputWidgetPlacement, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, Object obj) {
        CardInputWidgetPlacement cardInputWidgetPlacement2 = cardInputWidgetPlacement;
        int i18 = i17;
        return cardInputWidgetPlacement.copy((i18 & 1) != 0 ? cardInputWidgetPlacement2.totalLengthInPixels : i, (i18 & 2) != 0 ? cardInputWidgetPlacement2.cardWidth : i2, (i18 & 4) != 0 ? cardInputWidgetPlacement2.hiddenCardWidth : i3, (i18 & 8) != 0 ? cardInputWidgetPlacement2.peekCardWidth : i4, (i18 & 16) != 0 ? cardInputWidgetPlacement2.cardDateSeparation : i5, (i18 & 32) != 0 ? cardInputWidgetPlacement2.dateWidth : i6, (i18 & 64) != 0 ? cardInputWidgetPlacement2.dateCvcSeparation : i7, (i18 & 128) != 0 ? cardInputWidgetPlacement2.cvcWidth : i8, (i18 & 256) != 0 ? cardInputWidgetPlacement2.cvcPostalCodeSeparation : i9, (i18 & 512) != 0 ? cardInputWidgetPlacement2.postalCodeWidth : i10, (i18 & 1024) != 0 ? cardInputWidgetPlacement2.cardTouchBufferLimit : i11, (i18 & 2048) != 0 ? cardInputWidgetPlacement2.dateStartPosition : i12, (i18 & 4096) != 0 ? cardInputWidgetPlacement2.dateEndTouchBufferLimit : i13, (i18 & 8192) != 0 ? cardInputWidgetPlacement2.cvcStartPosition : i14, (i18 & 16384) != 0 ? cardInputWidgetPlacement2.cvcEndTouchBufferLimit : i15, (i18 & 32768) != 0 ? cardInputWidgetPlacement2.postalCodeStartPosition : i16);
    }

    private final int toMinimalValueIfNegative(int i) {
        if (i >= 0) {
            return i;
        }
        return 10;
    }

    public final int component1$payments_core_release() {
        return this.totalLengthInPixels;
    }

    public final int component10$payments_core_release() {
        return this.postalCodeWidth;
    }

    public final int component11$payments_core_release() {
        return this.cardTouchBufferLimit;
    }

    public final int component12$payments_core_release() {
        return this.dateStartPosition;
    }

    public final int component13$payments_core_release() {
        return this.dateEndTouchBufferLimit;
    }

    public final int component14$payments_core_release() {
        return this.cvcStartPosition;
    }

    public final int component15$payments_core_release() {
        return this.cvcEndTouchBufferLimit;
    }

    public final int component16$payments_core_release() {
        return this.postalCodeStartPosition;
    }

    public final int component2$payments_core_release() {
        return this.cardWidth;
    }

    public final int component3$payments_core_release() {
        return this.hiddenCardWidth;
    }

    public final int component4$payments_core_release() {
        return this.peekCardWidth;
    }

    public final int component5$payments_core_release() {
        return this.cardDateSeparation;
    }

    public final int component6$payments_core_release() {
        return this.dateWidth;
    }

    public final int component7$payments_core_release() {
        return this.dateCvcSeparation;
    }

    public final int component8$payments_core_release() {
        return this.cvcWidth;
    }

    public final int component9$payments_core_release() {
        return this.cvcPostalCodeSeparation;
    }

    public final CardInputWidgetPlacement copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        return new CardInputWidgetPlacement(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardInputWidgetPlacement)) {
            return false;
        }
        CardInputWidgetPlacement cardInputWidgetPlacement = (CardInputWidgetPlacement) obj;
        return this.totalLengthInPixels == cardInputWidgetPlacement.totalLengthInPixels && this.cardWidth == cardInputWidgetPlacement.cardWidth && this.hiddenCardWidth == cardInputWidgetPlacement.hiddenCardWidth && this.peekCardWidth == cardInputWidgetPlacement.peekCardWidth && this.cardDateSeparation == cardInputWidgetPlacement.cardDateSeparation && this.dateWidth == cardInputWidgetPlacement.dateWidth && this.dateCvcSeparation == cardInputWidgetPlacement.dateCvcSeparation && this.cvcWidth == cardInputWidgetPlacement.cvcWidth && this.cvcPostalCodeSeparation == cardInputWidgetPlacement.cvcPostalCodeSeparation && this.postalCodeWidth == cardInputWidgetPlacement.postalCodeWidth && this.cardTouchBufferLimit == cardInputWidgetPlacement.cardTouchBufferLimit && this.dateStartPosition == cardInputWidgetPlacement.dateStartPosition && this.dateEndTouchBufferLimit == cardInputWidgetPlacement.dateEndTouchBufferLimit && this.cvcStartPosition == cardInputWidgetPlacement.cvcStartPosition && this.cvcEndTouchBufferLimit == cardInputWidgetPlacement.cvcEndTouchBufferLimit && this.postalCodeStartPosition == cardInputWidgetPlacement.postalCodeStartPosition;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.totalLengthInPixels * 31) + this.cardWidth) * 31) + this.hiddenCardWidth) * 31) + this.peekCardWidth) * 31) + this.cardDateSeparation) * 31) + this.dateWidth) * 31) + this.dateCvcSeparation) * 31) + this.cvcWidth) * 31) + this.cvcPostalCodeSeparation) * 31) + this.postalCodeWidth) * 31) + this.cardTouchBufferLimit) * 31) + this.dateStartPosition) * 31) + this.dateEndTouchBufferLimit) * 31) + this.cvcStartPosition) * 31) + this.cvcEndTouchBufferLimit) * 31) + this.postalCodeStartPosition;
    }

    public CardInputWidgetPlacement(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.totalLengthInPixels = i;
        this.cardWidth = i2;
        this.hiddenCardWidth = i3;
        this.peekCardWidth = i4;
        this.cardDateSeparation = i5;
        this.dateWidth = i6;
        this.dateCvcSeparation = i7;
        this.cvcWidth = i8;
        this.cvcPostalCodeSeparation = i9;
        this.postalCodeWidth = i10;
        this.cardTouchBufferLimit = i11;
        this.dateStartPosition = i12;
        this.dateEndTouchBufferLimit = i13;
        this.cvcStartPosition = i14;
        this.cvcEndTouchBufferLimit = i15;
        this.postalCodeStartPosition = i16;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardInputWidgetPlacement(int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r18
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r19
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r20
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r21
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r22
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r23
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r24
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r25
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r26
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r27
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r28
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r29
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r30
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r31
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r32
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0083
            r0 = 0
            goto L_0x0085
        L_0x0083:
            r0 = r33
        L_0x0085:
            r18 = r17
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r2
            r34 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.CardInputWidgetPlacement.<init>(int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getTotalLengthInPixels$payments_core_release() {
        return this.totalLengthInPixels;
    }

    public final void setTotalLengthInPixels$payments_core_release(int i) {
        this.totalLengthInPixels = i;
    }

    public final int getCardWidth$payments_core_release() {
        return this.cardWidth;
    }

    public final void setCardWidth$payments_core_release(int i) {
        this.cardWidth = i;
    }

    public final int getHiddenCardWidth$payments_core_release() {
        return this.hiddenCardWidth;
    }

    public final void setHiddenCardWidth$payments_core_release(int i) {
        this.hiddenCardWidth = i;
    }

    public final int getPeekCardWidth$payments_core_release() {
        return this.peekCardWidth;
    }

    public final void setPeekCardWidth$payments_core_release(int i) {
        this.peekCardWidth = i;
    }

    public final int getCardDateSeparation$payments_core_release() {
        return this.cardDateSeparation;
    }

    public final void setCardDateSeparation$payments_core_release(int i) {
        this.cardDateSeparation = i;
    }

    public final int getDateWidth$payments_core_release() {
        return this.dateWidth;
    }

    public final void setDateWidth$payments_core_release(int i) {
        this.dateWidth = i;
    }

    public final int getDateCvcSeparation$payments_core_release() {
        return this.dateCvcSeparation;
    }

    public final void setDateCvcSeparation$payments_core_release(int i) {
        this.dateCvcSeparation = i;
    }

    public final int getCvcWidth$payments_core_release() {
        return this.cvcWidth;
    }

    public final void setCvcWidth$payments_core_release(int i) {
        this.cvcWidth = i;
    }

    public final int getCvcPostalCodeSeparation$payments_core_release() {
        return this.cvcPostalCodeSeparation;
    }

    public final void setCvcPostalCodeSeparation$payments_core_release(int i) {
        this.cvcPostalCodeSeparation = i;
    }

    public final int getPostalCodeWidth$payments_core_release() {
        return this.postalCodeWidth;
    }

    public final void setPostalCodeWidth$payments_core_release(int i) {
        this.postalCodeWidth = i;
    }

    public final int getCardTouchBufferLimit$payments_core_release() {
        return this.cardTouchBufferLimit;
    }

    public final void setCardTouchBufferLimit$payments_core_release(int i) {
        this.cardTouchBufferLimit = i;
    }

    public final int getDateStartPosition$payments_core_release() {
        return this.dateStartPosition;
    }

    public final void setDateStartPosition$payments_core_release(int i) {
        this.dateStartPosition = i;
    }

    public final int getDateEndTouchBufferLimit$payments_core_release() {
        return this.dateEndTouchBufferLimit;
    }

    public final void setDateEndTouchBufferLimit$payments_core_release(int i) {
        this.dateEndTouchBufferLimit = i;
    }

    public final int getCvcStartPosition$payments_core_release() {
        return this.cvcStartPosition;
    }

    public final void setCvcStartPosition$payments_core_release(int i) {
        this.cvcStartPosition = i;
    }

    public final int getCvcEndTouchBufferLimit$payments_core_release() {
        return this.cvcEndTouchBufferLimit;
    }

    public final void setCvcEndTouchBufferLimit$payments_core_release(int i) {
        this.cvcEndTouchBufferLimit = i;
    }

    public final int getPostalCodeStartPosition$payments_core_release() {
        return this.postalCodeStartPosition;
    }

    public final void setPostalCodeStartPosition$payments_core_release(int i) {
        this.postalCodeStartPosition = i;
    }

    private final /* synthetic */ int getCardPeekDateStartMargin() {
        return this.peekCardWidth + this.cardDateSeparation;
    }

    private final /* synthetic */ int getCardPeekCvcStartMargin() {
        return getCardPeekDateStartMargin() + this.dateWidth + this.dateCvcSeparation;
    }

    private final /* synthetic */ int getCardPeekPostalCodeStartMargin() {
        return getCardPeekCvcStartMargin() + this.cvcWidth + this.cvcPostalCodeSeparation;
    }

    public final /* synthetic */ int getDateStartMargin$payments_core_release(boolean z) {
        if (z) {
            return this.cardWidth + this.cardDateSeparation;
        }
        return getCardPeekDateStartMargin();
    }

    public final /* synthetic */ int getCvcStartMargin$payments_core_release(boolean z) {
        if (z) {
            return this.totalLengthInPixels;
        }
        return getCardPeekCvcStartMargin();
    }

    public final /* synthetic */ int getPostalCodeStartMargin$payments_core_release(boolean z) {
        if (z) {
            return this.totalLengthInPixels;
        }
        return getCardPeekPostalCodeStartMargin();
    }

    public final /* synthetic */ void updateSpacing$payments_core_release(boolean z, boolean z2, int i, int i2) {
        if (z) {
            int minimalValueIfNegative = toMinimalValueIfNegative((i2 - this.cardWidth) - this.dateWidth);
            this.cardDateSeparation = minimalValueIfNegative;
            int i3 = this.cardWidth;
            this.cardTouchBufferLimit = i + i3 + (minimalValueIfNegative / 2);
            this.dateStartPosition = i + i3 + minimalValueIfNegative;
        } else if (z2) {
            int i4 = i2 * 3;
            int minimalValueIfNegative2 = toMinimalValueIfNegative(((i4 / 10) - this.peekCardWidth) - (this.dateWidth / 4));
            this.cardDateSeparation = minimalValueIfNegative2;
            int minimalValueIfNegative3 = toMinimalValueIfNegative(((((i4 / 5) - this.peekCardWidth) - minimalValueIfNegative2) - this.dateWidth) - this.cvcWidth);
            this.dateCvcSeparation = minimalValueIfNegative3;
            int minimalValueIfNegative4 = toMinimalValueIfNegative((((((i2 - this.peekCardWidth) - this.cardDateSeparation) - this.dateWidth) - this.cvcWidth) - minimalValueIfNegative3) - this.postalCodeWidth);
            this.cvcPostalCodeSeparation = minimalValueIfNegative4;
            int i5 = i + this.peekCardWidth + this.cardDateSeparation;
            this.cardTouchBufferLimit = i5 / 3;
            this.dateStartPosition = i5;
            int i6 = i5 + this.dateWidth + this.dateCvcSeparation;
            this.dateEndTouchBufferLimit = i6 / 3;
            this.cvcStartPosition = i6;
            int i7 = i6 + this.cvcWidth + minimalValueIfNegative4;
            this.cvcEndTouchBufferLimit = i7 / 3;
            this.postalCodeStartPosition = i7;
        } else {
            int minimalValueIfNegative5 = toMinimalValueIfNegative(((i2 / 2) - this.peekCardWidth) - (this.dateWidth / 2));
            this.cardDateSeparation = minimalValueIfNegative5;
            int minimalValueIfNegative6 = toMinimalValueIfNegative((((i2 - this.peekCardWidth) - minimalValueIfNegative5) - this.dateWidth) - this.cvcWidth);
            this.dateCvcSeparation = minimalValueIfNegative6;
            int i8 = this.peekCardWidth;
            int i9 = this.cardDateSeparation;
            this.cardTouchBufferLimit = i + i8 + (i9 / 2);
            int i10 = i + i8 + i9;
            this.dateStartPosition = i10;
            int i11 = this.dateWidth;
            this.dateEndTouchBufferLimit = i10 + i11 + (minimalValueIfNegative6 / 2);
            this.cvcStartPosition = i10 + i11 + minimalValueIfNegative6;
        }
    }

    public final CardInputWidget.Field getFocusField$payments_core_release(int i, int i2, boolean z, boolean z2) {
        if (z) {
            if (i < i2 + this.cardWidth) {
                return null;
            }
            if (i < this.cardTouchBufferLimit) {
                return CardInputWidget.Field.Number;
            }
            if (i < this.dateStartPosition) {
                return CardInputWidget.Field.Expiry;
            }
            return null;
        } else if (z2) {
            if (i < i2 + this.peekCardWidth) {
                return null;
            }
            if (i < this.cardTouchBufferLimit) {
                return CardInputWidget.Field.Number;
            }
            int i3 = this.dateStartPosition;
            if (i < i3) {
                return CardInputWidget.Field.Expiry;
            }
            if (i < i3 + this.dateWidth) {
                return null;
            }
            if (i < this.dateEndTouchBufferLimit) {
                return CardInputWidget.Field.Expiry;
            }
            int i4 = this.cvcStartPosition;
            if (i < i4) {
                return CardInputWidget.Field.Cvc;
            }
            if (i < i4 + this.cvcWidth) {
                return null;
            }
            if (i < this.cvcEndTouchBufferLimit) {
                return CardInputWidget.Field.Cvc;
            }
            if (i < this.postalCodeStartPosition) {
                return CardInputWidget.Field.PostalCode;
            }
            return null;
        } else if (i < i2 + this.peekCardWidth) {
            return null;
        } else {
            if (i < this.cardTouchBufferLimit) {
                return CardInputWidget.Field.Number;
            }
            int i5 = this.dateStartPosition;
            if (i < i5) {
                return CardInputWidget.Field.Expiry;
            }
            if (i < i5 + this.dateWidth) {
                return null;
            }
            if (i < this.dateEndTouchBufferLimit) {
                return CardInputWidget.Field.Expiry;
            }
            if (i < this.cvcStartPosition) {
                return CardInputWidget.Field.Cvc;
            }
            return null;
        }
    }

    public String toString() {
        return Intrinsics.stringPlus("\n            TotalLengthInPixels = " + this.totalLengthInPixels + "\n            CardWidth = " + this.cardWidth + "\n            HiddenCardWidth = " + this.hiddenCardWidth + "\n            PeekCardWidth = " + this.peekCardWidth + "\n            CardDateSeparation = " + this.cardDateSeparation + "\n            DateWidth = " + this.dateWidth + "\n            DateCvcSeparation = " + this.dateCvcSeparation + "\n            CvcWidth = " + this.cvcWidth + "\n            CvcPostalCodeSeparation = " + this.cvcPostalCodeSeparation + "\n            PostalCodeWidth: " + this.postalCodeWidth + "\n            ", "\n            Touch Buffer Data:\n            CardTouchBufferLimit = " + this.cardTouchBufferLimit + "\n            DateStartPosition = " + this.dateStartPosition + "\n            DateEndTouchBufferLimit = " + this.dateEndTouchBufferLimit + "\n            CvcStartPosition = " + this.cvcStartPosition + "\n            CvcEndTouchBufferLimit = " + this.cvcEndTouchBufferLimit + "\n            PostalCodeStartPosition = " + this.postalCodeStartPosition + "\n            ");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/view/CardInputWidgetPlacement$Companion;", "", "()V", "MIN_SEPARATION_IN_PX", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardInputWidgetPlacement.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
