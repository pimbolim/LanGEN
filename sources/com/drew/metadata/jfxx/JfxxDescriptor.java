package com.drew.metadata.jfxx;

import com.drew.metadata.TagDescriptor;

public class JfxxDescriptor extends TagDescriptor<JfxxDirectory> {
    public JfxxDescriptor(JfxxDirectory jfxxDirectory) {
        super(jfxxDirectory);
    }

    public String getDescription(int i) {
        if (i != 5) {
            return super.getDescription(i);
        }
        return getExtensionCodeDescription();
    }

    public String getExtensionCodeDescription() {
        Integer integer = ((JfxxDirectory) this._directory).getInteger(5);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 16) {
            return "Thumbnail coded using JPEG";
        }
        if (intValue == 17) {
            return "Thumbnail stored using 1 byte/pixel";
        }
        if (intValue == 19) {
            return "Thumbnail stored using 3 bytes/pixel";
        }
        return "Unknown extension code " + integer;
    }
}
