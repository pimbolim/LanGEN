package com.drew.imaging.tiff;

import com.drew.lang.RandomAccessFileReader;
import com.drew.lang.RandomAccessReader;
import com.drew.lang.RandomAccessStreamReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifTiffHandler;
import com.drew.metadata.file.FileSystemMetadataReader;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class TiffMetadataReader {
    /* JADX INFO: finally extract failed */
    public static Metadata readMetadata(File file) throws IOException, TiffProcessingException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR);
        try {
            Metadata readMetadata = readMetadata((RandomAccessReader) new RandomAccessFileReader(randomAccessFile));
            randomAccessFile.close();
            new FileSystemMetadataReader().read(file, readMetadata);
            return readMetadata;
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public static Metadata readMetadata(InputStream inputStream) throws IOException, TiffProcessingException {
        return readMetadata((RandomAccessReader) new RandomAccessStreamReader(inputStream));
    }

    public static Metadata readMetadata(RandomAccessReader randomAccessReader) throws IOException, TiffProcessingException {
        Metadata metadata = new Metadata();
        new TiffReader().processTiff(randomAccessReader, new ExifTiffHandler(metadata, (Directory) null), 0);
        return metadata;
    }
}
