package cl.json;

import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.ReactApplicationContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ShareFile {
    public static final int BASE_64_DATA_LENGTH = 5;
    public static final int BASE_64_DATA_OFFSET = 8;
    private String filename;
    private final ReactApplicationContext reactContext;
    private String type;
    private Uri uri;
    private String url;

    public ShareFile(String str, String str2, String str3, ReactApplicationContext reactApplicationContext) {
        this(str, str3, reactApplicationContext);
        this.type = str2;
        this.filename = str3;
    }

    public ShareFile(String str, String str2, ReactApplicationContext reactApplicationContext) {
        this.url = str;
        this.uri = Uri.parse(str);
        this.reactContext = reactApplicationContext;
        this.filename = str2;
    }

    private String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public boolean isFile() {
        return isBase64File() || isLocalFile();
    }

    private boolean isBase64File() {
        if (this.uri.getScheme() == null || !this.uri.getScheme().equals("data")) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : this.uri.toString().substring(5).toCharArray()) {
            if (c == ';') {
                break;
            }
            sb.append(c);
        }
        this.type = sb.toString();
        return true;
    }

    private boolean isLocalFile() {
        if (this.uri.getScheme() == null || (!this.uri.getScheme().equals("content") && !this.uri.getScheme().equals(UriUtil.LOCAL_FILE_SCHEME))) {
            return false;
        }
        if (this.type != null) {
            return true;
        }
        String mimeType = getMimeType(this.uri.toString());
        this.type = mimeType;
        if (mimeType == null) {
            String realPathFromURI = getRealPathFromURI(this.uri);
            if (realPathFromURI == null) {
                return false;
            }
            this.type = getMimeType(realPathFromURI);
        }
        if (this.type == null) {
            this.type = "*/*";
        }
        return true;
    }

    public String getType() {
        String str = this.type;
        return str == null ? "*/*" : str;
    }

    private String getRealPathFromURI(Uri uri2) {
        return RNSharePathUtil.getRealPathFromURI(this.reactContext, uri2);
    }

    public Uri getURI() {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(getType());
        if (isBase64File()) {
            String substring = this.uri.toString().substring(this.type.length() + 5 + 8);
            String str = this.filename;
            if (str == null) {
                str = System.nanoTime() + "";
            }
            try {
                File file = new File(this.reactContext.getExternalCacheDir(), Environment.DIRECTORY_DOWNLOADS);
                if (!file.exists()) {
                    if (!file.mkdirs()) {
                        throw new IOException("mkdirs failed on " + file.getAbsolutePath());
                    }
                }
                File file2 = new File(file, str + "." + extensionFromMimeType);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(Base64.decode(substring, 0));
                fileOutputStream.flush();
                fileOutputStream.close();
                return RNSharePathUtil.compatUriFromFile(this.reactContext, file2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (isLocalFile()) {
                Uri parse = Uri.parse(this.url);
                if (parse.getPath() == null) {
                    return null;
                }
                return RNSharePathUtil.compatUriFromFile(this.reactContext, new File(parse.getPath()));
            }
            return null;
        }
    }
}
