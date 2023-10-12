package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsPT implements SupportedLocale<StringKey> {
    private static Map<String, String> mAdapted = new HashMap();
    private static Map<StringKey, String> mDisplay = new HashMap();

    public String getName() {
        return "pt";
    }

    public String getAdaptedDisplay(StringKey stringKey, String str) {
        String str2 = stringKey.toString() + "|" + str;
        if (mAdapted.containsKey(str2)) {
            return mAdapted.get(str2);
        }
        return mDisplay.get(stringKey);
    }

    public LocalizedStringsPT() {
        mDisplay.put(StringKey.CANCEL, "Cancelar");
        mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
        mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
        mDisplay.put(StringKey.DONE, "Concluir");
        mDisplay.put(StringKey.ENTRY_CVV, "CSC");
        mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "Código postal");
        mDisplay.put(StringKey.ENTRY_CARDHOLDER_NAME, "Nome do titular do cartão");
        mDisplay.put(StringKey.ENTRY_EXPIRES, "Validade");
        mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/AA");
        mDisplay.put(StringKey.SCAN_GUIDE, "Segure o cartão aqui.\nSerá lido automaticamente.");
        mDisplay.put(StringKey.KEYBOARD, "Teclado…");
        mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Número do cartão");
        mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Detalhes do cartão");
        mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Este dispositivo não pode utilizar a câmara para ler números de cartões.");
        mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "A câmara do dispositivo não está disponível.");
        mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Ocorreu um erro inesperado no dispositivo ao abrir a câmara.");
    }
}
