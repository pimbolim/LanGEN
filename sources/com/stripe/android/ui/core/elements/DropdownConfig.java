package com.stripe.android.ui.core.elements;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003H&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/ui/core/elements/DropdownConfig;", "", "debugLabel", "", "getDebugLabel", "()Ljava/lang/String;", "label", "", "getLabel", "()I", "convertFromRaw", "rawValue", "convertToRaw", "displayName", "getDisplayItems", "", "Lcom/stripe/android/ui/core/elements/CountryConfig;", "Lcom/stripe/android/ui/core/elements/SimpleDropdownConfig;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DropdownConfig.kt */
public interface DropdownConfig {
    String convertFromRaw(String str);

    String convertToRaw(String str);

    String getDebugLabel();

    List<String> getDisplayItems();

    int getLabel();
}
