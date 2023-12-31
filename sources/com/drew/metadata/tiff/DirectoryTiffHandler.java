package com.drew.metadata.tiff;

import com.drew.imaging.tiff.TiffHandler;
import com.drew.lang.Rational;
import com.drew.metadata.Directory;
import com.drew.metadata.ErrorDirectory;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import java.util.Stack;

public abstract class DirectoryTiffHandler implements TiffHandler {
    protected Directory _currentDirectory;
    private final Stack<Directory> _directoryStack = new Stack<>();
    protected final Metadata _metadata;
    private Directory _rootParentDirectory;

    protected DirectoryTiffHandler(Metadata metadata, Directory directory) {
        this._metadata = metadata;
        this._rootParentDirectory = directory;
    }

    public void endingIFD() {
        this._currentDirectory = this._directoryStack.empty() ? null : this._directoryStack.pop();
    }

    /* access modifiers changed from: protected */
    public void pushDirectory(Class<? extends Directory> cls) {
        try {
            Directory directory = (Directory) cls.newInstance();
            Directory directory2 = this._currentDirectory;
            if (directory2 == null) {
                Directory directory3 = this._rootParentDirectory;
                if (directory3 != null) {
                    directory.setParent(directory3);
                    this._rootParentDirectory = null;
                }
            } else {
                this._directoryStack.push(directory2);
                directory.setParent(this._currentDirectory);
            }
            this._currentDirectory = directory;
            this._metadata.addDirectory(directory);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void warn(String str) {
        getCurrentOrErrorDirectory().addError(str);
    }

    public void error(String str) {
        getCurrentOrErrorDirectory().addError(str);
    }

    private Directory getCurrentOrErrorDirectory() {
        Directory directory = this._currentDirectory;
        if (directory != null) {
            return directory;
        }
        ErrorDirectory errorDirectory = (ErrorDirectory) this._metadata.getFirstDirectoryOfType(ErrorDirectory.class);
        if (errorDirectory != null) {
            return errorDirectory;
        }
        pushDirectory(ErrorDirectory.class);
        return this._currentDirectory;
    }

    public void setByteArray(int i, byte[] bArr) {
        this._currentDirectory.setByteArray(i, bArr);
    }

    public void setString(int i, StringValue stringValue) {
        this._currentDirectory.setStringValue(i, stringValue);
    }

    public void setRational(int i, Rational rational) {
        this._currentDirectory.setRational(i, rational);
    }

    public void setRationalArray(int i, Rational[] rationalArr) {
        this._currentDirectory.setRationalArray(i, rationalArr);
    }

    public void setFloat(int i, float f) {
        this._currentDirectory.setFloat(i, f);
    }

    public void setFloatArray(int i, float[] fArr) {
        this._currentDirectory.setFloatArray(i, fArr);
    }

    public void setDouble(int i, double d) {
        this._currentDirectory.setDouble(i, d);
    }

    public void setDoubleArray(int i, double[] dArr) {
        this._currentDirectory.setDoubleArray(i, dArr);
    }

    public void setInt8s(int i, byte b) {
        this._currentDirectory.setInt(i, b);
    }

    public void setInt8sArray(int i, byte[] bArr) {
        this._currentDirectory.setByteArray(i, bArr);
    }

    public void setInt8u(int i, short s) {
        this._currentDirectory.setInt(i, s);
    }

    public void setInt8uArray(int i, short[] sArr) {
        this._currentDirectory.setObjectArray(i, sArr);
    }

    public void setInt16s(int i, int i2) {
        this._currentDirectory.setInt(i, i2);
    }

    public void setInt16sArray(int i, short[] sArr) {
        this._currentDirectory.setObjectArray(i, sArr);
    }

    public void setInt16u(int i, int i2) {
        this._currentDirectory.setInt(i, i2);
    }

    public void setInt16uArray(int i, int[] iArr) {
        this._currentDirectory.setObjectArray(i, iArr);
    }

    public void setInt32s(int i, int i2) {
        this._currentDirectory.setInt(i, i2);
    }

    public void setInt32sArray(int i, int[] iArr) {
        this._currentDirectory.setIntArray(i, iArr);
    }

    public void setInt32u(int i, long j) {
        this._currentDirectory.setLong(i, j);
    }

    public void setInt32uArray(int i, long[] jArr) {
        this._currentDirectory.setObjectArray(i, jArr);
    }
}
