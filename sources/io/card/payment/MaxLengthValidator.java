package io.card.payment;

class MaxLengthValidator extends NonEmptyValidator implements Validator {
    private int maxLength;

    MaxLengthValidator(int i) {
        this.maxLength = i;
    }

    public boolean isValid() {
        return super.isValid() && getValue().length() <= this.maxLength;
    }
}
