package lib.android.paypal.com.magnessdk.network;

import androidx.browser.trusted.sharing.ShareTarget;
import lib.android.paypal.com.magnessdk.network.httpclient.MagnesNetworking;
import lib.android.paypal.com.magnessdk.network.httpclient.MagnesNetworkingFactory;

public final class MagnesNetworkingFactoryImpl implements MagnesNetworkingFactory {
    public MagnesNetworking createHttpClient(String str) throws Exception {
        str.hashCode();
        return !str.equals(ShareTarget.METHOD_GET) ? !str.equals(ShareTarget.METHOD_POST) ? new g() : new g() : new f();
    }
}
