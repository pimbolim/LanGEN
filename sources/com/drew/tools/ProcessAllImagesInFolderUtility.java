package com.drew.tools;

import androidx.compose.animation.core.AnimationKt;
import com.braintreepayments.api.models.BinData;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.lang.StringUtil;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.ExifThumbnailDirectory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProcessAllImagesInFolderUtility {

    interface FileHandler {
        void onBeforeExtraction(File file, PrintStream printStream, String str);

        void onExtractionError(File file, Throwable th, PrintStream printStream);

        void onExtractionSuccess(File file, Metadata metadata, String str, PrintStream printStream);

        void onScanCompleted(PrintStream printStream);

        void onStartingDirectory(File file);

        boolean shouldProcess(File file);
    }

    public static void main(String[] strArr) throws IOException, JpegProcessingException {
        ArrayList<String> arrayList = new ArrayList<>();
        PrintStream printStream = System.out;
        FileHandler fileHandler = null;
        int i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            if (str.equalsIgnoreCase("--text")) {
                fileHandler = new TextFileOutputHandler();
            } else if (str.equalsIgnoreCase("--markdown")) {
                fileHandler = new MarkdownTableOutputHandler();
            } else if (str.equalsIgnoreCase("--unknown")) {
                fileHandler = new UnknownTagHandler();
            } else if (str.equalsIgnoreCase("--log-file")) {
                if (i == strArr.length - 1) {
                    printUsage();
                    System.exit(1);
                }
                i++;
                printStream = new PrintStream(new FileOutputStream(strArr[i], false), true);
            } else {
                arrayList.add(str);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            System.err.println("Expects one or more directories as arguments.");
            printUsage();
            System.exit(1);
        }
        if (fileHandler == null) {
            fileHandler = new BasicFileHandler();
        }
        long nanoTime = System.nanoTime();
        for (String file : arrayList) {
            processDirectory(new File(file), fileHandler, "", printStream);
        }
        fileHandler.onScanCompleted(printStream);
        System.out.println(String.format("Completed in %d ms", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / AnimationKt.MillisToNanos)}));
        if (printStream != System.out) {
            printStream.close();
        }
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println();
        System.out.println("  java com.drew.tools.ProcessAllImagesInFolderUtility [--text|--markdown|--unknown] [--log-file <file-name>]");
    }

    private static void processDirectory(File file, FileHandler fileHandler, String str, PrintStream printStream) {
        fileHandler.onStartingDirectory(file);
        String[] list = file.list();
        if (list != null) {
            Arrays.sort(list);
            for (String str2 : list) {
                File file2 = new File(file, str2);
                if (file2.isDirectory()) {
                    if (str.length() != 0) {
                        str2 = str + "/" + str2;
                    }
                    processDirectory(file2, fileHandler, str2, printStream);
                } else if (fileHandler.shouldProcess(file2)) {
                    fileHandler.onBeforeExtraction(file2, printStream, str);
                    try {
                        fileHandler.onExtractionSuccess(file2, ImageMetadataReader.readMetadata(file2), str, printStream);
                    } catch (Throwable th) {
                        fileHandler.onExtractionError(file2, th, printStream);
                    }
                }
            }
        }
    }

    static abstract class FileHandlerBase implements FileHandler {
        private int _errorCount = 0;
        private int _exceptionCount = 0;
        private long _processedByteCount = 0;
        private int _processedFileCount = 0;
        private final Set<String> _supportedExtensions = new HashSet(Arrays.asList(new String[]{"jpg", "jpeg", "png", "gif", "bmp", "ico", "webp", "pcx", "ai", "eps", "nef", "crw", "cr2", "orf", "arw", "raf", "srw", "x3f", "rw2", "rwl", "tif", "tiff", "psd", "dng", "3g2", "3gp", "m4v", "mov", "mp4", "pbm", "pnm", "pgm"}));

        public void onStartingDirectory(File file) {
        }

        FileHandlerBase() {
        }

        public boolean shouldProcess(File file) {
            String extension = getExtension(file);
            return extension != null && this._supportedExtensions.contains(extension.toLowerCase());
        }

        public void onBeforeExtraction(File file, PrintStream printStream, String str) {
            this._processedFileCount++;
            this._processedByteCount += file.length();
        }

        public void onExtractionError(File file, Throwable th, PrintStream printStream) {
            this._exceptionCount++;
            printStream.printf("\t[%s] %s\n", new Object[]{th.getClass().getName(), th.getMessage()});
        }

        public void onExtractionSuccess(File file, Metadata metadata, String str, PrintStream printStream) {
            if (metadata.hasErrors()) {
                printStream.print(file);
                printStream.print(10);
                for (Directory next : metadata.getDirectories()) {
                    if (next.hasErrors()) {
                        for (String str2 : next.getErrors()) {
                            printStream.printf("\t[%s] %s\n", new Object[]{next.getName(), str2});
                            this._errorCount++;
                        }
                    }
                }
            }
        }

        public void onScanCompleted(PrintStream printStream) {
            int i = this._processedFileCount;
            if (i > 0) {
                printStream.print(String.format("Processed %,d files (%,d bytes) with %,d exceptions and %,d file errors\n", new Object[]{Integer.valueOf(i), Long.valueOf(this._processedByteCount), Integer.valueOf(this._exceptionCount), Integer.valueOf(this._errorCount)}));
            }
        }

        /* access modifiers changed from: protected */
        public String getExtension(File file) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf == -1 || lastIndexOf == name.length() - 1) {
                return null;
            }
            return name.substring(lastIndexOf + 1);
        }
    }

    static class TextFileOutputHandler extends FileHandlerBase {
        private static final String NEW_LINE = "\n";

        TextFileOutputHandler() {
        }

        public void onStartingDirectory(File file) {
            super.onStartingDirectory(file);
            File file2 = new File(file + "/metadata");
            if (file2.exists()) {
                deleteRecursively(file2);
            }
        }

        private static void deleteRecursively(File file) {
            String[] list;
            if (file.isDirectory()) {
                if (file.exists() && (list = file.list()) != null) {
                    for (String file2 : list) {
                        File file3 = new File(file2);
                        if (file3.isDirectory()) {
                            deleteRecursively(file3);
                        } else {
                            file3.delete();
                        }
                    }
                }
                file.delete();
                return;
            }
            throw new IllegalArgumentException("Must be a directory.");
        }

        public void onBeforeExtraction(File file, PrintStream printStream, String str) {
            super.onBeforeExtraction(file, printStream, str);
            printStream.print(file.getAbsoluteFile());
            printStream.print("\n");
        }

        /* JADX WARNING: Removed duplicated region for block: B:73:0x0131 A[Catch:{ all -> 0x0146 }] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0136 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onExtractionSuccess(java.io.File r17, com.drew.metadata.Metadata r18, java.lang.String r19, java.io.PrintStream r20) {
            /*
                r16 = this;
                super.onExtractionSuccess(r17, r18, r19, r20)
                java.io.PrintWriter r2 = openWriter(r17)     // Catch:{ all -> 0x0149 }
                boolean r0 = r18.hasErrors()     // Catch:{ all -> 0x0146 }
                r3 = 2
                r4 = 3
                r5 = 1
                java.lang.String r6 = "\n"
                r7 = 0
                if (r0 == 0) goto L_0x0057
                java.lang.Iterable r0 = r18.getDirectories()     // Catch:{ all -> 0x0146 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0146 }
            L_0x001b:
                boolean r8 = r0.hasNext()     // Catch:{ all -> 0x0146 }
                if (r8 == 0) goto L_0x0054
                java.lang.Object r8 = r0.next()     // Catch:{ all -> 0x0146 }
                com.drew.metadata.Directory r8 = (com.drew.metadata.Directory) r8     // Catch:{ all -> 0x0146 }
                boolean r9 = r8.hasErrors()     // Catch:{ all -> 0x0146 }
                if (r9 != 0) goto L_0x002e
                goto L_0x001b
            L_0x002e:
                java.lang.Iterable r9 = r8.getErrors()     // Catch:{ all -> 0x0146 }
                java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0146 }
            L_0x0036:
                boolean r10 = r9.hasNext()     // Catch:{ all -> 0x0146 }
                if (r10 == 0) goto L_0x001b
                java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x0146 }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0146 }
                java.lang.String r11 = "[ERROR: %s] %s%s"
                java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch:{ all -> 0x0146 }
                java.lang.String r13 = r8.getName()     // Catch:{ all -> 0x0146 }
                r12[r7] = r13     // Catch:{ all -> 0x0146 }
                r12[r5] = r10     // Catch:{ all -> 0x0146 }
                r12[r3] = r6     // Catch:{ all -> 0x0146 }
                r2.format(r11, r12)     // Catch:{ all -> 0x0146 }
                goto L_0x0036
            L_0x0054:
                r2.write(r6)     // Catch:{ all -> 0x0146 }
            L_0x0057:
                java.lang.Iterable r0 = r18.getDirectories()     // Catch:{ all -> 0x0146 }
                java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x0146 }
            L_0x005f:
                boolean r0 = r8.hasNext()     // Catch:{ all -> 0x0146 }
                if (r0 == 0) goto L_0x0139
                java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x0146 }
                com.drew.metadata.Directory r0 = (com.drew.metadata.Directory) r0     // Catch:{ all -> 0x0146 }
                java.lang.String r9 = r0.getName()     // Catch:{ all -> 0x0146 }
                java.util.Collection r10 = r0.getTags()     // Catch:{ all -> 0x0146 }
                java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0146 }
            L_0x0077:
                boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0146 }
                r12 = 4
                java.lang.String r13 = ""
                if (r11 == 0) goto L_0x00b5
                java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0146 }
                com.drew.metadata.Tag r11 = (com.drew.metadata.Tag) r11     // Catch:{ all -> 0x0146 }
                java.lang.String r14 = r11.getTagName()     // Catch:{ all -> 0x0146 }
                java.lang.String r15 = r11.getDescription()     // Catch:{ all -> 0x0146 }
                if (r15 != 0) goto L_0x0091
                goto L_0x0092
            L_0x0091:
                r13 = r15
            L_0x0092:
                boolean r15 = r0 instanceof com.drew.metadata.file.FileSystemDirectory     // Catch:{ all -> 0x0146 }
                if (r15 == 0) goto L_0x009e
                int r15 = r11.getTagType()     // Catch:{ all -> 0x0146 }
                if (r15 != r4) goto L_0x009e
                java.lang.String r13 = "<omitted for regression testing as checkout dependent>"
            L_0x009e:
                java.lang.String r15 = "[%s - %s] %s = %s%s"
                r1 = 5
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0146 }
                r1[r7] = r9     // Catch:{ all -> 0x0146 }
                java.lang.String r11 = r11.getTagTypeHex()     // Catch:{ all -> 0x0146 }
                r1[r5] = r11     // Catch:{ all -> 0x0146 }
                r1[r3] = r14     // Catch:{ all -> 0x0146 }
                r1[r4] = r13     // Catch:{ all -> 0x0146 }
                r1[r12] = r6     // Catch:{ all -> 0x0146 }
                r2.format(r15, r1)     // Catch:{ all -> 0x0146 }
                goto L_0x0077
            L_0x00b5:
                int r1 = r0.getTagCount()     // Catch:{ all -> 0x0146 }
                if (r1 == 0) goto L_0x00be
                r2.write(r6)     // Catch:{ all -> 0x0146 }
            L_0x00be:
                boolean r1 = r0 instanceof com.drew.metadata.xmp.XmpDirectory     // Catch:{ all -> 0x0146 }
                if (r1 == 0) goto L_0x0135
                com.drew.metadata.xmp.XmpDirectory r0 = (com.drew.metadata.xmp.XmpDirectory) r0     // Catch:{ all -> 0x0146 }
                com.adobe.xmp.XMPMeta r0 = r0.getXMPMeta()     // Catch:{ all -> 0x0146 }
                com.adobe.xmp.XMPIterator r0 = r0.iterator()     // Catch:{ XMPException -> 0x0129 }
                r1 = 0
            L_0x00cd:
                boolean r9 = r0.hasNext()     // Catch:{ XMPException -> 0x0126 }
                if (r9 == 0) goto L_0x0124
                java.lang.Object r9 = r0.next()     // Catch:{ XMPException -> 0x0126 }
                com.adobe.xmp.properties.XMPPropertyInfo r9 = (com.adobe.xmp.properties.XMPPropertyInfo) r9     // Catch:{ XMPException -> 0x0126 }
                java.lang.String r10 = r9.getNamespace()     // Catch:{ XMPException -> 0x0126 }
                java.lang.String r11 = r9.getPath()     // Catch:{ XMPException -> 0x0126 }
                java.lang.String r9 = r9.getValue()     // Catch:{ XMPException -> 0x0126 }
                if (r10 != 0) goto L_0x00e8
                r10 = r13
            L_0x00e8:
                if (r11 != 0) goto L_0x00eb
                r11 = r13
            L_0x00eb:
                if (r9 != 0) goto L_0x00ef
                r9 = r13
                goto L_0x010f
            L_0x00ef:
                int r14 = r9.length()     // Catch:{ XMPException -> 0x0126 }
                r15 = 512(0x200, float:7.175E-43)
                if (r14 <= r15) goto L_0x010f
                java.lang.String r14 = "%s <truncated from %d characters>"
                java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ XMPException -> 0x0126 }
                java.lang.String r15 = r9.substring(r7, r15)     // Catch:{ XMPException -> 0x0126 }
                r4[r7] = r15     // Catch:{ XMPException -> 0x0126 }
                int r9 = r9.length()     // Catch:{ XMPException -> 0x0126 }
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ XMPException -> 0x0126 }
                r4[r5] = r9     // Catch:{ XMPException -> 0x0126 }
                java.lang.String r9 = java.lang.String.format(r14, r4)     // Catch:{ XMPException -> 0x0126 }
            L_0x010f:
                java.lang.String r4 = "[XMPMeta - %s] %s = %s%s"
                java.lang.Object[] r14 = new java.lang.Object[r12]     // Catch:{ XMPException -> 0x0126 }
                r14[r7] = r10     // Catch:{ XMPException -> 0x0126 }
                r14[r5] = r11     // Catch:{ XMPException -> 0x0126 }
                r14[r3] = r9     // Catch:{ XMPException -> 0x0126 }
                r9 = 3
                r14[r9] = r6     // Catch:{ XMPException -> 0x0122 }
                r2.format(r4, r14)     // Catch:{ XMPException -> 0x0122 }
                r1 = 1
                r4 = 3
                goto L_0x00cd
            L_0x0122:
                r0 = move-exception
                goto L_0x012c
            L_0x0124:
                r9 = 3
                goto L_0x012f
            L_0x0126:
                r0 = move-exception
                r9 = 3
                goto L_0x012c
            L_0x0129:
                r0 = move-exception
                r9 = 3
                r1 = 0
            L_0x012c:
                r0.printStackTrace()     // Catch:{ all -> 0x0146 }
            L_0x012f:
                if (r1 == 0) goto L_0x0136
                r2.write(r6)     // Catch:{ all -> 0x0146 }
                goto L_0x0136
            L_0x0135:
                r9 = 3
            L_0x0136:
                r4 = 3
                goto L_0x005f
            L_0x0139:
                r1 = r18
                r3 = 0
                writeHierarchyLevel(r1, r2, r3, r7)     // Catch:{ all -> 0x0146 }
                r2.write(r6)     // Catch:{ all -> 0x0146 }
                closeWriter(r2)     // Catch:{ IOException -> 0x0150 }
                goto L_0x0154
            L_0x0146:
                r0 = move-exception
                r1 = r2
                goto L_0x014c
            L_0x0149:
                r0 = move-exception
                r3 = 0
                r1 = r3
            L_0x014c:
                closeWriter(r1)     // Catch:{ IOException -> 0x0150 }
                throw r0     // Catch:{ IOException -> 0x0150 }
            L_0x0150:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0154:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.drew.tools.ProcessAllImagesInFolderUtility.TextFileOutputHandler.onExtractionSuccess(java.io.File, com.drew.metadata.Metadata, java.lang.String, java.io.PrintStream):void");
        }

        private static void writeHierarchyLevel(Metadata metadata, PrintWriter printWriter, Directory directory, int i) {
            for (Directory next : metadata.getDirectories()) {
                if (directory == null) {
                    if (next.getParent() != null) {
                    }
                } else if (!directory.equals(next.getParent())) {
                }
                for (int i2 = 0; i2 < i * 4; i2++) {
                    printWriter.write(32);
                }
                printWriter.write("- ");
                printWriter.write(next.getName());
                printWriter.write("\n");
                writeHierarchyLevel(metadata, printWriter, next, i + 1);
            }
        }

        public void onExtractionError(File file, Throwable th, PrintStream printStream) {
            PrintWriter printWriter;
            super.onExtractionError(file, th, printStream);
            try {
                printWriter = openWriter(file);
                try {
                    printWriter.write("EXCEPTION: " + th.getMessage() + "\n");
                    printWriter.write("\n");
                    try {
                        closeWriter(printWriter);
                    } catch (IOException e) {
                        printStream.printf("IO exception writing metadata file: %s%s", new Object[]{e.getMessage(), "\n"});
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeWriter(printWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                printWriter = null;
                closeWriter(printWriter);
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0092  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.io.PrintWriter openWriter(java.io.File r7) throws java.io.IOException {
            /*
                java.io.File r0 = new java.io.File
                r1 = 1
                java.lang.Object[] r2 = new java.lang.Object[r1]
                java.lang.String r3 = r7.getParent()
                r4 = 0
                r2[r4] = r3
                java.lang.String r3 = "%s/metadata"
                java.lang.String r2 = java.lang.String.format(r3, r2)
                r0.<init>(r2)
                boolean r2 = r0.exists()
                if (r2 != 0) goto L_0x001e
                r0.mkdir()
            L_0x001e:
                r0 = 2
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.String r2 = r7.getParent()
                r0[r4] = r2
                java.lang.String r2 = r7.getName()
                r0[r1] = r2
                java.lang.String r2 = "%s/metadata/%s.txt"
                java.lang.String r0 = java.lang.String.format(r2, r0)
                java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter
                java.io.FileOutputStream r3 = new java.io.FileOutputStream
                r3.<init>(r0)
                java.lang.String r0 = "UTF-8"
                r2.<init>(r3, r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r3 = "FILE: "
                r0.append(r3)
                java.lang.String r3 = r7.getName()
                r0.append(r3)
                java.lang.String r3 = "\n"
                r0.append(r3)
                java.lang.String r0 = r0.toString()
                r2.write(r0)
                r0 = 0
                java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ all -> 0x008f }
                java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x008f }
                r6.<init>(r7)     // Catch:{ all -> 0x008f }
                r5.<init>(r6)     // Catch:{ all -> 0x008f }
                com.drew.imaging.FileType r7 = com.drew.imaging.FileTypeDetector.detectFileType(r5)     // Catch:{ all -> 0x008c }
                java.lang.String r0 = "TYPE: %s\n"
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x008c }
                java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008c }
                java.lang.String r7 = r7.toUpperCase()     // Catch:{ all -> 0x008c }
                r1[r4] = r7     // Catch:{ all -> 0x008c }
                java.lang.String r7 = java.lang.String.format(r0, r1)     // Catch:{ all -> 0x008c }
                r2.write(r7)     // Catch:{ all -> 0x008c }
                r2.write(r3)     // Catch:{ all -> 0x008c }
                r5.close()
                java.io.PrintWriter r7 = new java.io.PrintWriter
                r7.<init>(r2)
                return r7
            L_0x008c:
                r7 = move-exception
                r0 = r5
                goto L_0x0090
            L_0x008f:
                r7 = move-exception
            L_0x0090:
                if (r0 == 0) goto L_0x0095
                r0.close()
            L_0x0095:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.drew.tools.ProcessAllImagesInFolderUtility.TextFileOutputHandler.openWriter(java.io.File):java.io.PrintWriter");
        }

        private static void closeWriter(Writer writer) throws IOException {
            if (writer != null) {
                writer.write("Generated using metadata-extractor\n");
                writer.write("https://drewnoakes.com/code/exif/\n");
                writer.flush();
                writer.close();
            }
        }
    }

    static class MarkdownTableOutputHandler extends FileHandlerBase {
        private final Map<String, String> _extensionEquivalence;
        private final Map<String, List<Row>> _rowListByExtension = new HashMap();

        static class Row {
            /* access modifiers changed from: private */
            public String exifVersion;
            final File file;
            /* access modifiers changed from: private */
            public String makernote;
            /* access modifiers changed from: private */
            public String manufacturer;
            final Metadata metadata;
            /* access modifiers changed from: private */
            public String model;
            final String relativePath;
            /* access modifiers changed from: private */
            public String thumbnail;

            Row(File file2, Metadata metadata2, String str) {
                boolean z;
                this.file = file2;
                this.metadata = metadata2;
                this.relativePath = str;
                ExifIFD0Directory exifIFD0Directory = (ExifIFD0Directory) metadata2.getFirstDirectoryOfType(ExifIFD0Directory.class);
                ExifSubIFDDirectory exifSubIFDDirectory = (ExifSubIFDDirectory) metadata2.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
                ExifThumbnailDirectory exifThumbnailDirectory = (ExifThumbnailDirectory) metadata2.getFirstDirectoryOfType(ExifThumbnailDirectory.class);
                if (exifIFD0Directory != null) {
                    this.manufacturer = exifIFD0Directory.getDescription(271);
                    this.model = exifIFD0Directory.getDescription(272);
                }
                if (exifSubIFDDirectory != null) {
                    this.exifVersion = exifSubIFDDirectory.getDescription(ExifDirectoryBase.TAG_EXIF_VERSION);
                    z = exifSubIFDDirectory.containsTag(ExifDirectoryBase.TAG_MAKERNOTE);
                } else {
                    z = false;
                }
                if (exifThumbnailDirectory != null) {
                    Integer integer = exifThumbnailDirectory.getInteger(256);
                    Integer integer2 = exifThumbnailDirectory.getInteger(257);
                    this.thumbnail = (integer == null || integer2 == null) ? BinData.YES : String.format("Yes (%s x %s)", new Object[]{integer, integer2});
                }
                Iterator<Directory> it = metadata2.getDirectories().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Directory next = it.next();
                    if (next.getClass().getName().contains("Makernote")) {
                        this.makernote = next.getName().replace("Makernote", "").trim();
                        break;
                    }
                }
                if (this.makernote == null) {
                    this.makernote = z ? "(Unknown)" : "N/A";
                }
            }
        }

        public MarkdownTableOutputHandler() {
            HashMap hashMap = new HashMap();
            this._extensionEquivalence = hashMap;
            hashMap.put("jpeg", "jpg");
        }

        public void onExtractionSuccess(File file, Metadata metadata, String str, PrintStream printStream) {
            super.onExtractionSuccess(file, metadata, str, printStream);
            String extension = getExtension(file);
            if (extension != null) {
                String lowerCase = extension.toLowerCase();
                if (this._extensionEquivalence.containsKey(lowerCase)) {
                    lowerCase = this._extensionEquivalence.get(lowerCase);
                }
                List list = this._rowListByExtension.get(lowerCase);
                if (list == null) {
                    list = new ArrayList();
                    this._rowListByExtension.put(lowerCase, list);
                }
                list.add(new Row(file, metadata, str));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC, Splitter:B:24:0x003d] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x004e A[SYNTHETIC, Splitter:B:32:0x004e] */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onScanCompleted(java.io.PrintStream r5) {
            /*
                r4 = this;
                super.onScanCompleted(r5)
                r5 = 0
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002f, all -> 0x002a }
                java.lang.String r1 = "../wiki/ImageDatabaseSummary.md"
                r2 = 0
                r0.<init>(r1, r2)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
                java.io.PrintStream r1 = new java.io.PrintStream     // Catch:{ IOException -> 0x0025, all -> 0x0020 }
                r1.<init>(r0, r2)     // Catch:{ IOException -> 0x0025, all -> 0x0020 }
                r4.writeOutput(r1)     // Catch:{ IOException -> 0x001e }
                r1.flush()     // Catch:{ IOException -> 0x001e }
                r1.close()
                r0.close()     // Catch:{ IOException -> 0x0041 }
                goto L_0x0045
            L_0x001e:
                r5 = move-exception
                goto L_0x0033
            L_0x0020:
                r1 = move-exception
                r3 = r1
                r1 = r5
                r5 = r3
                goto L_0x0047
            L_0x0025:
                r1 = move-exception
                r3 = r1
                r1 = r5
                r5 = r3
                goto L_0x0033
            L_0x002a:
                r0 = move-exception
                r1 = r5
                r5 = r0
                r0 = r1
                goto L_0x0047
            L_0x002f:
                r0 = move-exception
                r1 = r5
                r5 = r0
                r0 = r1
            L_0x0033:
                r5.printStackTrace()     // Catch:{ all -> 0x0046 }
                if (r1 == 0) goto L_0x003b
                r1.close()
            L_0x003b:
                if (r0 == 0) goto L_0x0045
                r0.close()     // Catch:{ IOException -> 0x0041 }
                goto L_0x0045
            L_0x0041:
                r5 = move-exception
                r5.printStackTrace()
            L_0x0045:
                return
            L_0x0046:
                r5 = move-exception
            L_0x0047:
                if (r1 == 0) goto L_0x004c
                r1.close()
            L_0x004c:
                if (r0 == 0) goto L_0x0056
                r0.close()     // Catch:{ IOException -> 0x0052 }
                goto L_0x0056
            L_0x0052:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0056:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.drew.tools.ProcessAllImagesInFolderUtility.MarkdownTableOutputHandler.onScanCompleted(java.io.PrintStream):void");
        }

        private void writeOutput(PrintStream printStream) throws IOException {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(printStream);
            outputStreamWriter.write("# Image Database Summary\n\n");
            for (Map.Entry next : this._rowListByExtension.entrySet()) {
                outputStreamWriter.write("## " + ((String) next.getKey()).toUpperCase() + " Files\n\n");
                outputStreamWriter.write("File|Manufacturer|Model|Dir Count|Exif?|Makernote|Thumbnail|All Data\n");
                outputStreamWriter.write("----|------------|-----|---------|-----|---------|---------|--------\n");
                List<Row> list = (List) next.getValue();
                Collections.sort(list, new Comparator<Row>() {
                    public int compare(Row row, Row row2) {
                        int compare = StringUtil.compare(row.manufacturer, row2.manufacturer);
                        return compare != 0 ? compare : StringUtil.compare(row.model, row2.model);
                    }
                });
                for (Row row : list) {
                    Object[] objArr = new Object[11];
                    objArr[0] = row.file.getName();
                    objArr[1] = row.relativePath;
                    objArr[2] = StringUtil.urlEncode(row.file.getName());
                    String str = "";
                    objArr[3] = row.manufacturer == null ? str : row.manufacturer;
                    objArr[4] = row.model == null ? str : row.model;
                    objArr[5] = Integer.valueOf(row.metadata.getDirectoryCount());
                    objArr[6] = row.exifVersion == null ? str : row.exifVersion;
                    objArr[7] = row.makernote == null ? str : row.makernote;
                    if (row.thumbnail != null) {
                        str = row.thumbnail;
                    }
                    objArr[8] = str;
                    objArr[9] = row.relativePath;
                    objArr[10] = StringUtil.urlEncode(row.file.getName()).toLowerCase();
                    outputStreamWriter.write(String.format("[%s](https://raw.githubusercontent.com/drewnoakes/metadata-extractor-images/master/%s/%s)|%s|%s|%d|%s|%s|%s|[metadata](https://raw.githubusercontent.com/drewnoakes/metadata-extractor-images/master/%s/metadata/%s.txt)\n", objArr));
                }
                outputStreamWriter.write(10);
            }
            outputStreamWriter.flush();
        }
    }

    static class UnknownTagHandler extends FileHandlerBase {
        private HashMap<String, HashMap<Integer, Integer>> _occurrenceCountByTagByDirectory = new HashMap<>();

        UnknownTagHandler() {
        }

        public void onExtractionSuccess(File file, Metadata metadata, String str, PrintStream printStream) {
            super.onExtractionSuccess(file, metadata, str, printStream);
            for (Directory next : metadata.getDirectories()) {
                for (Tag next2 : next.getTags()) {
                    if (!next2.hasTagName()) {
                        HashMap hashMap = this._occurrenceCountByTagByDirectory.get(next.getName());
                        if (hashMap == null) {
                            hashMap = new HashMap();
                            this._occurrenceCountByTagByDirectory.put(next.getName(), hashMap);
                        }
                        Integer num = (Integer) hashMap.get(Integer.valueOf(next2.getTagType()));
                        if (num == null) {
                            hashMap.put(Integer.valueOf(next2.getTagType()), 0);
                            num = 0;
                        }
                        hashMap.put(Integer.valueOf(next2.getTagType()), Integer.valueOf(num.intValue() + 1));
                    }
                }
            }
        }

        public void onScanCompleted(PrintStream printStream) {
            super.onScanCompleted(printStream);
            for (Map.Entry next : this._occurrenceCountByTagByDirectory.entrySet()) {
                String str = (String) next.getKey();
                ArrayList<Map.Entry> arrayList = new ArrayList<>(((HashMap) next.getValue()).entrySet());
                Collections.sort(arrayList, new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> entry, Map.Entry<Integer, Integer> entry2) {
                        return entry2.getValue().compareTo(entry.getValue());
                    }
                });
                for (Map.Entry entry : arrayList) {
                    printStream.format("%s, 0x%04X, %d\n", new Object[]{str, (Integer) entry.getKey(), (Integer) entry.getValue()});
                }
            }
        }
    }

    static class BasicFileHandler extends FileHandlerBase {
        BasicFileHandler() {
        }

        public void onExtractionSuccess(File file, Metadata metadata, String str, PrintStream printStream) {
            super.onExtractionSuccess(file, metadata, str, printStream);
            for (Directory next : metadata.getDirectories()) {
                next.getName();
                for (Tag next2 : next.getTags()) {
                    next2.getTagName();
                    next2.getDescription();
                }
            }
        }
    }
}
