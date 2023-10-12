package com.facebook.imagepipeline.systrace;

import android.os.Build;
import android.os.Trace;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class DefaultFrescoSystrace implements FrescoSystrace.Systrace {
    public void beginSection(String str) {
    }

    public void endSection() {
    }

    public boolean isTracing() {
        return false;
    }

    public FrescoSystrace.ArgsBuilder beginSectionWithArgs(String str) {
        return FrescoSystrace.NO_OP_ARGS_BUILDER;
    }

    private static final class DefaultArgsBuilder implements FrescoSystrace.ArgsBuilder {
        private final StringBuilder mStringBuilder;

        public DefaultArgsBuilder(String str) {
            this.mStringBuilder = new StringBuilder(str);
        }

        public void flush() {
            if (this.mStringBuilder.length() > 127) {
                this.mStringBuilder.setLength(127);
            }
            if (Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection(this.mStringBuilder.toString());
            }
        }

        public FrescoSystrace.ArgsBuilder arg(String str, Object obj) {
            String str2;
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append(SignatureVisitor.INSTANCEOF);
            if (obj == null) {
                str2 = AbstractJsonLexerKt.NULL;
            } else {
                str2 = obj.toString();
            }
            sb.append(str2);
            return this;
        }

        public FrescoSystrace.ArgsBuilder arg(String str, int i) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append(SignatureVisitor.INSTANCEOF);
            sb.append(Integer.toString(i));
            return this;
        }

        public FrescoSystrace.ArgsBuilder arg(String str, long j) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append(SignatureVisitor.INSTANCEOF);
            sb.append(Long.toString(j));
            return this;
        }

        public FrescoSystrace.ArgsBuilder arg(String str, double d) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append(SignatureVisitor.INSTANCEOF);
            sb.append(Double.toString(d));
            return this;
        }
    }
}
