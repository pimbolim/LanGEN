package net.time4j.history;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.StreamCorruptedException;
import kotlin.UByte;
import net.time4j.PlainDate;
import net.time4j.engine.EpochDays;
import net.time4j.history.internal.HistoricVariant;

final class SPX implements Externalizable {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    static final int VERSION_1 = 1;
    static final int VERSION_2 = 2;
    static final int VERSION_3 = 3;
    private static final long serialVersionUID = 1;
    private transient Object obj;
    private transient int type;

    public SPX() {
    }

    SPX(Object obj2, int i) {
        this.obj = obj2;
        this.type = i;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        int i = this.type;
        if (i == 1 || i == 2 || i == 3) {
            writeHistory(objectOutput);
            return;
        }
        throw new InvalidClassException("Unknown serialized type.");
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        ChronoHistory chronoHistory;
        byte readByte = objectInput.readByte();
        int i = (readByte & UByte.MAX_VALUE) >> 4;
        if (i == 1) {
            chronoHistory = readHistory(objectInput, readByte);
        } else if (i == 2) {
            ChronoHistory readHistory = readHistory(objectInput, readByte);
            AncientJulianLeapYears readTriennalState = readTriennalState(objectInput);
            chronoHistory = readTriennalState != null ? readHistory.with(readTriennalState) : readHistory;
        } else if (i == 3) {
            ChronoHistory readHistory2 = readHistory(objectInput, readByte);
            AncientJulianLeapYears readTriennalState2 = readTriennalState(objectInput);
            if (readTriennalState2 != null) {
                readHistory2 = readHistory2.with(readTriennalState2);
            }
            chronoHistory = readHistory2.with(NewYearStrategy.readFromStream(objectInput)).with(EraPreference.readFromStream(objectInput));
        } else {
            throw new StreamCorruptedException("Unknown serialized type.");
        }
        this.obj = chronoHistory;
    }

    private Object readResolve() throws ObjectStreamException {
        return this.obj;
    }

    private void writeHistory(DataOutput dataOutput) throws IOException {
        ChronoHistory chronoHistory = (ChronoHistory) this.obj;
        dataOutput.writeByte(chronoHistory.getHistoricVariant().getSerialValue() | (this.type << 4));
        if (chronoHistory.getHistoricVariant() == HistoricVariant.SINGLE_CUTOVER_DATE) {
            dataOutput.writeLong(chronoHistory.getEvents().get(0).start);
        }
        int[] pattern = chronoHistory.hasAncientJulianLeapYears() ? chronoHistory.getAncientJulianLeapYears().getPattern() : EMPTY_INT_ARRAY;
        dataOutput.writeInt(pattern.length);
        for (int writeInt : pattern) {
            dataOutput.writeInt(writeInt);
        }
        chronoHistory.getNewYearStrategy().writeToStream(dataOutput);
        chronoHistory.getEraPreference().writeToStream(dataOutput);
    }

    private ChronoHistory readHistory(DataInput dataInput, byte b) throws IOException, ClassNotFoundException {
        int i = AnonymousClass1.$SwitchMap$net$time4j$history$internal$HistoricVariant[getEnum(b & 15).ordinal()];
        if (i == 1) {
            return ChronoHistory.PROLEPTIC_GREGORIAN;
        }
        if (i == 2) {
            return ChronoHistory.PROLEPTIC_JULIAN;
        }
        if (i == 3) {
            return ChronoHistory.PROLEPTIC_BYZANTINE;
        }
        if (i == 4) {
            return ChronoHistory.ofSweden();
        }
        if (i != 5) {
            return ChronoHistory.ofGregorianReform(PlainDate.of(dataInput.readLong(), EpochDays.MODIFIED_JULIAN_DATE));
        }
        return ChronoHistory.ofFirstGregorianReform();
    }

    /* renamed from: net.time4j.history.SPX$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$history$internal$HistoricVariant;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                net.time4j.history.internal.HistoricVariant[] r0 = net.time4j.history.internal.HistoricVariant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$history$internal$HistoricVariant = r0
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.PROLEPTIC_GREGORIAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.PROLEPTIC_JULIAN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.PROLEPTIC_BYZANTINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.SWEDEN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.INTRODUCTION_ON_1582_10_15     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.history.SPX.AnonymousClass1.<clinit>():void");
        }
    }

    private static HistoricVariant getEnum(int i) throws StreamCorruptedException {
        for (HistoricVariant historicVariant : HistoricVariant.values()) {
            if (historicVariant.getSerialValue() == i) {
                return historicVariant;
            }
        }
        throw new StreamCorruptedException("Unknown variant of chronological history.");
    }

    private static AncientJulianLeapYears readTriennalState(DataInput dataInput) throws IOException {
        int readInt = dataInput.readInt();
        if (readInt <= 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i = 0; i < readInt; i++) {
            iArr[i] = 1 - dataInput.readInt();
        }
        return AncientJulianLeapYears.of(iArr);
    }
}
