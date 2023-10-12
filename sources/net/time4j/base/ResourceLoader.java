package net.time4j.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ServiceLoader;

public abstract class ResourceLoader {
    /* access modifiers changed from: private */
    public static final boolean ANDROID;
    /* access modifiers changed from: private */
    public static final boolean ENFORCE_USE_OF_CLASSLOADER;
    public static final String EXTERNAL_RESOURCE_LOADER = "net.time4j.base.ResourceLoader";
    private static final ResourceLoader INSTANCE;
    public static final String USE_OF_CLASSLOADER_ONLY = "net.time4j.base.useClassloaderOnly";

    public abstract InputStream load(URI uri, boolean z);

    public abstract URI locate(String str, Class<?> cls, String str2);

    public abstract <S> Iterable<S> services(Class<S> cls);

    static {
        boolean equalsIgnoreCase = "Dalvik".equalsIgnoreCase(System.getProperty("java.vm.name"));
        ANDROID = equalsIgnoreCase;
        ENFORCE_USE_OF_CLASSLOADER = !equalsIgnoreCase && Boolean.getBoolean(USE_OF_CLASSLOADER_ONLY);
        String property = System.getProperty(EXTERNAL_RESOURCE_LOADER);
        if (property == null) {
            INSTANCE = new StdResourceLoader();
            return;
        }
        try {
            INSTANCE = (ResourceLoader) Class.forName(property).newInstance();
        } catch (Exception e) {
            throw new AssertionError("Wrong configuration of external resource loader: " + e.getMessage());
        }
    }

    protected ResourceLoader() {
    }

    public static ResourceLoader getInstance() {
        return INSTANCE;
    }

    public final InputStream load(Class<?> cls, String str, boolean z) throws IOException {
        if (!ANDROID) {
            URL resource = cls.getClassLoader().getResource(str);
            if (resource == null) {
                throw new FileNotFoundException(str);
            } else if (!z) {
                return resource.openStream();
            } else {
                URLConnection openConnection = resource.openConnection();
                openConnection.setUseCaches(false);
                openConnection.connect();
                return openConnection.getInputStream();
            }
        } else {
            throw new FileNotFoundException(str);
        }
    }

    private static class StdResourceLoader extends ResourceLoader {
        StdResourceLoader() {
            if (ResourceLoader.ANDROID) {
                throw new IllegalStateException("The module time4j-android is not active. Check your configuration.");
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:20:? A[ExcHandler: SecurityException (unused java.lang.SecurityException), SYNTHETIC, Splitter:B:1:0x0001] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.net.URI locate(java.lang.String r3, java.lang.Class<?> r4, java.lang.String r5) {
            /*
                r2 = this;
                r3 = 0
                java.security.ProtectionDomain r4 = r4.getProtectionDomain()     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004a }
                if (r4 != 0) goto L_0x0009
                r4 = r3
                goto L_0x000d
            L_0x0009:
                java.security.CodeSource r4 = r4.getCodeSource()     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004a }
            L_0x000d:
                if (r4 == 0) goto L_0x0061
                java.net.URL r4 = r4.getLocation()     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004a }
                java.lang.String r4 = r4.toExternalForm()     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004a }
                java.lang.String r0 = ".jar"
                boolean r0 = r4.endsWith(r0)     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                if (r0 == 0) goto L_0x0035
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                r0.<init>()     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                java.lang.String r1 = "jar:"
                r0.append(r1)     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                r0.append(r4)     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                java.lang.String r1 = "!/"
                r0.append(r1)     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                java.lang.String r4 = r0.toString()     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
            L_0x0035:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                r0.<init>()     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                r0.append(r4)     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                r0.append(r5)     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                java.lang.String r4 = r0.toString()     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                java.net.URI r5 = new java.net.URI     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                r5.<init>(r4)     // Catch:{ SecurityException -> 0x0061, URISyntaxException -> 0x004b }
                return r5
            L_0x004a:
                r4 = r3
            L_0x004b:
                java.io.PrintStream r5 = java.lang.System.err
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Warning: malformed resource path = "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.println(r4)
            L_0x0061:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.base.ResourceLoader.StdResourceLoader.locate(java.lang.String, java.lang.Class, java.lang.String):java.net.URI");
        }

        public InputStream load(URI uri, boolean z) {
            if (uri != null && !ResourceLoader.ENFORCE_USE_OF_CLASSLOADER) {
                try {
                    URL url = uri.toURL();
                    if (!z) {
                        return url.openStream();
                    }
                    URLConnection openConnection = url.openConnection();
                    openConnection.setUseCaches(false);
                    openConnection.connect();
                    return openConnection.getInputStream();
                } catch (IOException e) {
                    if (uri.toString().contains(".repository")) {
                        PrintStream printStream = System.err;
                        printStream.println("Warning: Loading of resource " + uri + " failed (" + e.getMessage() + "). " + "Consider setting the system property \"" + ResourceLoader.USE_OF_CLASSLOADER_ONLY + "\" for reducing overhead.");
                        e.printStackTrace(System.err);
                    }
                }
            }
            return null;
        }

        public <S> Iterable<S> services(Class<S> cls) {
            return ServiceLoader.load(cls, cls.getClassLoader());
        }
    }
}
