package com.nimbusds.jose;

import com.facebook.react.uimanager.ViewProps;
import com.nimbusds.jose.util.JSONStringUtils;
import java.io.Serializable;
import net.jcip.annotations.Immutable;

@Immutable
public class Algorithm implements Serializable {
    public static final Algorithm NONE = new Algorithm(ViewProps.NONE, Requirement.REQUIRED);
    private static final long serialVersionUID = 1;
    private final String name;
    private final Requirement requirement;

    public Algorithm(String str, Requirement requirement2) {
        if (str != null) {
            this.name = str;
            this.requirement = requirement2;
            return;
        }
        throw new IllegalArgumentException("The algorithm name must not be null");
    }

    public Algorithm(String str) {
        this(str, (Requirement) null);
    }

    public final String getName() {
        return this.name;
    }

    public final Requirement getRequirement() {
        return this.requirement;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Algorithm) && toString().equals(obj.toString());
    }

    public final String toString() {
        return this.name;
    }

    public final String toJSONString() {
        return JSONStringUtils.toJSONString(this.name);
    }

    public static Algorithm parse(String str) {
        if (str == null) {
            return null;
        }
        return new Algorithm(str);
    }
}
