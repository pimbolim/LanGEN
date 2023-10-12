package io.card.payment;

class DetectionInfo {
    public boolean bottomEdge;
    public boolean complete = false;
    public CreditCard detectedCard;
    public int expiry_month;
    public int expiry_year;
    public float focusScore;
    public boolean leftEdge;
    public int[] prediction;
    public boolean rightEdge;
    public boolean topEdge;

    public DetectionInfo() {
        int[] iArr = new int[16];
        this.prediction = iArr;
        iArr[0] = -1;
        iArr[15] = -1;
        this.detectedCard = new CreditCard();
    }

    /* access modifiers changed from: package-private */
    public boolean sameEdgesAs(DetectionInfo detectionInfo) {
        return detectionInfo.topEdge == this.topEdge && detectionInfo.bottomEdge == this.bottomEdge && detectionInfo.leftEdge == this.leftEdge && detectionInfo.rightEdge == this.rightEdge;
    }

    /* access modifiers changed from: package-private */
    public boolean detected() {
        return this.topEdge && this.bottomEdge && this.rightEdge && this.leftEdge;
    }

    /* access modifiers changed from: package-private */
    public boolean predicted() {
        return this.complete;
    }

    /* access modifiers changed from: package-private */
    public CreditCard creditCard() {
        String str = new String();
        for (int i = 0; i < 16; i++) {
            int[] iArr = this.prediction;
            if (iArr[i] < 0 || iArr[i] >= 10) {
                break;
            }
            str = str + String.valueOf(this.prediction[i]);
        }
        this.detectedCard.cardNumber = str;
        this.detectedCard.expiryMonth = this.expiry_month;
        this.detectedCard.expiryYear = this.expiry_year;
        return this.detectedCard;
    }

    /* access modifiers changed from: package-private */
    public int numVisibleEdges() {
        return (this.topEdge ? 1 : 0) + (this.bottomEdge ? 1 : 0) + (this.leftEdge ? 1 : 0) + (this.rightEdge ? 1 : 0);
    }
}
