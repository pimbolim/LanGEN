package net.time4j.android;

import java.io.IOException;
import java.io.InputStream;

public interface AssetLocation {
    InputStream open(String str) throws IOException;
}
