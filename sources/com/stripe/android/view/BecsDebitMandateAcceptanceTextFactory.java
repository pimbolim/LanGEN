package com.stripe.android.view;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import com.stripe.android.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/BecsDebitMandateAcceptanceTextFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "create", "", "companyName", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BecsDebitMandateAcceptanceTextFactory.kt */
public final class BecsDebitMandateAcceptanceTextFactory {
    public static final int $stable = 8;
    private final Context context;

    public BecsDebitMandateAcceptanceTextFactory(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final CharSequence create(String str) {
        Intrinsics.checkNotNullParameter(str, "companyName");
        String string = this.context.getString(R.string.becs_mandate_acceptance, new Object[]{str});
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …    companyName\n        )");
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(string, 0);
            Intrinsics.checkNotNullExpressionValue(fromHtml, "{\n            Html.fromH…ML_MODE_LEGACY)\n        }");
            return fromHtml;
        }
        Spanned fromHtml2 = Html.fromHtml(string);
        Intrinsics.checkNotNullExpressionValue(fromHtml2, "{\n            Html.fromH…AcceptanceText)\n        }");
        return fromHtml2;
    }
}
