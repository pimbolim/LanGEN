package com.nimbusds.jose.shaded.ow2asm.signature;

import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.ClassUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public class SignatureWriter extends SignatureVisitor {
    private int argumentStack;
    private boolean hasFormals;
    private boolean hasParameters;
    private final StringBuilder stringBuilder = new StringBuilder();

    public SignatureVisitor visitClassBound() {
        return this;
    }

    public SignatureVisitor visitInterface() {
        return this;
    }

    public SignatureWriter() {
        super(Opcodes.ASM9);
    }

    public void visitFormalTypeParameter(String str) {
        if (!this.hasFormals) {
            this.hasFormals = true;
            this.stringBuilder.append(Typography.less);
        }
        this.stringBuilder.append(str);
        this.stringBuilder.append(AbstractJsonLexerKt.COLON);
    }

    public SignatureVisitor visitInterfaceBound() {
        this.stringBuilder.append(AbstractJsonLexerKt.COLON);
        return this;
    }

    public SignatureVisitor visitSuperclass() {
        endFormals();
        return this;
    }

    public SignatureVisitor visitParameterType() {
        endFormals();
        if (!this.hasParameters) {
            this.hasParameters = true;
            this.stringBuilder.append('(');
        }
        return this;
    }

    public SignatureVisitor visitReturnType() {
        endFormals();
        if (!this.hasParameters) {
            this.stringBuilder.append('(');
        }
        this.stringBuilder.append(')');
        return this;
    }

    public SignatureVisitor visitExceptionType() {
        this.stringBuilder.append('^');
        return this;
    }

    public void visitBaseType(char c) {
        this.stringBuilder.append(c);
    }

    public void visitTypeVariable(String str) {
        this.stringBuilder.append('T');
        this.stringBuilder.append(str);
        this.stringBuilder.append(';');
    }

    public SignatureVisitor visitArrayType() {
        this.stringBuilder.append(AbstractJsonLexerKt.BEGIN_LIST);
        return this;
    }

    public void visitClassType(String str) {
        this.stringBuilder.append(Matrix.MATRIX_TYPE_RANDOM_LT);
        this.stringBuilder.append(str);
        this.argumentStack *= 2;
    }

    public void visitInnerClassType(String str) {
        endArguments();
        this.stringBuilder.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        this.stringBuilder.append(str);
        this.argumentStack *= 2;
    }

    public void visitTypeArgument() {
        int i = this.argumentStack;
        if (i % 2 == 0) {
            this.argumentStack = i | 1;
            this.stringBuilder.append(Typography.less);
        }
        this.stringBuilder.append('*');
    }

    public SignatureVisitor visitTypeArgument(char c) {
        int i = this.argumentStack;
        if (i % 2 == 0) {
            this.argumentStack = i | 1;
            this.stringBuilder.append(Typography.less);
        }
        if (c != '=') {
            this.stringBuilder.append(c);
        }
        return this;
    }

    public void visitEnd() {
        endArguments();
        this.stringBuilder.append(';');
    }

    public String toString() {
        return this.stringBuilder.toString();
    }

    private void endFormals() {
        if (this.hasFormals) {
            this.hasFormals = false;
            this.stringBuilder.append(Typography.greater);
        }
    }

    private void endArguments() {
        if (this.argumentStack % 2 == 1) {
            this.stringBuilder.append(Typography.greater);
        }
        this.argumentStack /= 2;
    }
}
