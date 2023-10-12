package net.time4j.tz;

import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.facebook.imageutils.JfifUtil;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.StreamCorruptedException;
import kotlin.UByte;

final class SPX implements Externalizable {
    static final int FALLBACK_TIMEZONE_TYPE = 12;
    static final int HISTORIZED_TIMEZONE_TYPE = 14;
    static final int TRANSITION_RESOLVER_TYPE = 13;
    static final int ZONAL_OFFSET_TYPE = 15;
    private static final long serialVersionUID = -1000776907354520172L;
    private transient Object obj;
    private transient int type;

    public SPX() {
    }

    SPX(Object obj2, int i) {
        this.obj = obj2;
        this.type = i;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        switch (this.type) {
            case 12:
                writeFallback(objectOutput);
                return;
            case 13:
                writeStrategy(objectOutput);
                return;
            case 14:
                writeZone(objectOutput);
                return;
            case 15:
                writeOffset(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type.");
        }
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte readByte = objectInput.readByte();
        switch ((readByte & UByte.MAX_VALUE) >> 4) {
            case 12:
                this.obj = readFallback(objectInput, readByte);
                return;
            case 13:
                this.obj = readStrategy(readByte);
                return;
            case 14:
                this.obj = readZone(objectInput, readByte);
                return;
            case 15:
                this.obj = readOffset(objectInput, readByte);
                return;
            default:
                throw new StreamCorruptedException("Unknown serialized type.");
        }
    }

    private Object readResolve() throws ObjectStreamException {
        return this.obj;
    }

    private void writeFallback(ObjectOutput objectOutput) throws IOException {
        FallbackTimezone fallbackTimezone = (FallbackTimezone) this.obj;
        objectOutput.writeByte(192);
        objectOutput.writeObject(fallbackTimezone.getID());
        objectOutput.writeObject(fallbackTimezone.getFallback());
    }

    private Object readFallback(ObjectInput objectInput, byte b) throws IOException, ClassNotFoundException {
        return new FallbackTimezone((TZID) objectInput.readObject(), (Timezone) objectInput.readObject());
    }

    private void writeStrategy(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(((TransitionResolver) this.obj).getKey() | 208);
    }

    private Object readStrategy(byte b) {
        byte b2 = b & 15;
        return TransitionResolver.of(GapResolver.values()[b2 / 2], OverlapResolver.values()[b2 % 2]);
    }

    private void writeZone(ObjectOutput objectOutput) throws IOException {
        HistorizedTimezone historizedTimezone = (HistorizedTimezone) this.obj;
        boolean z = historizedTimezone.getStrategy() != Timezone.DEFAULT_CONFLICT_STRATEGY;
        objectOutput.writeByte(z ? JfifUtil.MARKER_APP1 : CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY);
        objectOutput.writeObject(historizedTimezone.getID());
        objectOutput.writeObject(historizedTimezone.getHistory());
        if (z) {
            objectOutput.writeObject(historizedTimezone.getStrategy());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: net.time4j.tz.TransitionStrategy} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object readZone(java.io.ObjectInput r5, byte r6) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            r4 = this;
            java.lang.Object r0 = r5.readObject()
            net.time4j.tz.TZID r0 = (net.time4j.tz.TZID) r0
            java.lang.Object r1 = r5.readObject()
            net.time4j.tz.TransitionHistory r1 = (net.time4j.tz.TransitionHistory) r1
            net.time4j.tz.TransitionStrategy r2 = net.time4j.tz.Timezone.DEFAULT_CONFLICT_STRATEGY
            r6 = r6 & 15
            r3 = 1
            if (r6 != r3) goto L_0x001a
            java.lang.Object r5 = r5.readObject()
            r2 = r5
            net.time4j.tz.TransitionStrategy r2 = (net.time4j.tz.TransitionStrategy) r2
        L_0x001a:
            net.time4j.tz.HistorizedTimezone r5 = new net.time4j.tz.HistorizedTimezone
            r5.<init>(r0, r1, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.SPX.readZone(java.io.ObjectInput, byte):java.lang.Object");
    }

    private void writeOffset(ObjectOutput objectOutput) throws IOException {
        ZonalOffset zonalOffset = (ZonalOffset) this.obj;
        boolean z = zonalOffset.getFractionalAmount() != 0;
        int i = 240;
        if (z) {
            i = 241;
        }
        objectOutput.writeByte(i);
        objectOutput.writeInt(zonalOffset.getIntegralAmount());
        if (z) {
            objectOutput.writeInt(zonalOffset.getFractionalAmount());
        }
    }

    private Object readOffset(ObjectInput objectInput, byte b) throws IOException {
        return ZonalOffset.ofTotalSeconds(objectInput.readInt(), (b & 15) == 1 ? objectInput.readInt() : 0);
    }
}
