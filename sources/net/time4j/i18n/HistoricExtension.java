package net.time4j.i18n;

import java.util.Locale;
import java.util.Set;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.history.ChronoHistory;
import net.time4j.history.internal.HistoricAttribute;
import net.time4j.history.internal.StdHistoricalElement;

public class HistoricExtension implements ChronoExtension {
    public boolean accept(Class<?> cls) {
        return cls == PlainDate.class;
    }

    public Set<ChronoElement<?>> getElements(Locale locale, AttributeQuery attributeQuery) {
        return getHistory(locale, attributeQuery).getElements();
    }

    public ChronoEntity<?> resolve(ChronoEntity<?> chronoEntity, Locale locale, AttributeQuery attributeQuery) {
        return resolve(chronoEntity, getHistory(locale, attributeQuery), attributeQuery);
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [net.time4j.engine.ChronoEntity<?>, net.time4j.engine.ChronoEntity] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.engine.ChronoEntity<?> resolve(net.time4j.engine.ChronoEntity<?> r9, net.time4j.history.ChronoHistory r10, net.time4j.engine.AttributeQuery r11) {
        /*
            r8 = this;
            net.time4j.engine.ChronoElement r0 = r10.era()
            boolean r0 = r9.contains(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0017
            net.time4j.engine.ChronoElement r0 = r10.era()
            java.lang.Object r0 = r9.get(r0)
            net.time4j.history.HistoricEra r0 = (net.time4j.history.HistoricEra) r0
        L_0x0015:
            r2 = r0
            goto L_0x002b
        L_0x0017:
            net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r0 = net.time4j.format.Attributes.LENIENCY
            net.time4j.format.Leniency r2 = net.time4j.format.Leniency.SMART
            java.lang.Object r0 = r11.get(r0, r2)
            net.time4j.format.Leniency r0 = (net.time4j.format.Leniency) r0
            boolean r0 = r0.isLax()
            if (r0 == 0) goto L_0x002a
            net.time4j.history.HistoricEra r0 = net.time4j.history.HistoricEra.AD
            goto L_0x0015
        L_0x002a:
            r2 = r1
        L_0x002b:
            if (r2 == 0) goto L_0x00d5
            net.time4j.format.TextElement r0 = r10.yearOfEra()
            boolean r0 = r9.contains(r0)
            if (r0 == 0) goto L_0x00d5
            net.time4j.format.TextElement r0 = r10.yearOfEra()
            int r3 = r9.getInt(r0)
            net.time4j.format.TextElement r0 = r10.month()
            boolean r0 = r9.contains(r0)
            if (r0 == 0) goto L_0x009d
            net.time4j.engine.ChronoElement r0 = r10.dayOfMonth()
            boolean r0 = r9.contains(r0)
            if (r0 == 0) goto L_0x009d
            net.time4j.engine.AttributeKey<net.time4j.history.YearDefinition> r0 = net.time4j.history.ChronoHistory.YEAR_DEFINITION
            net.time4j.history.YearDefinition r4 = net.time4j.history.YearDefinition.DUAL_DATING
            java.lang.Object r11 = r11.get(r0, r4)
            r6 = r11
            net.time4j.history.YearDefinition r6 = (net.time4j.history.YearDefinition) r6
            net.time4j.format.TextElement r11 = r10.month()
            int r4 = r9.getInt(r11)
            net.time4j.engine.ChronoElement r11 = r10.dayOfMonth()
            int r5 = r9.getInt(r11)
            net.time4j.history.NewYearStrategy r7 = r10.getNewYearStrategy()
            net.time4j.history.HistoricDate r11 = net.time4j.history.HistoricDate.of(r2, r3, r4, r5, r6, r7)
            net.time4j.PlainDate r11 = r10.convert((net.time4j.history.HistoricDate) r11)
            net.time4j.engine.ChronoElement r0 = r10.era()
            r9.with(r0, r1)
            net.time4j.format.TextElement r0 = r10.yearOfEra()
            r9.with(r0, r1)
            net.time4j.format.TextElement r0 = r10.month()
            r9.with(r0, r1)
            net.time4j.engine.ChronoElement r10 = r10.dayOfMonth()
            r9.with(r10, r1)
            net.time4j.CalendarDateElement r10 = net.time4j.PlainDate.COMPONENT
            net.time4j.engine.ChronoEntity r9 = r9.with(r10, r11)
            return r9
        L_0x009d:
            net.time4j.engine.ChronoElement r11 = r10.dayOfYear()
            boolean r11 = r9.contains(r11)
            if (r11 == 0) goto L_0x00d5
            net.time4j.engine.ChronoElement r11 = r10.dayOfYear()
            int r11 = r9.getInt(r11)
            net.time4j.engine.ChronoElement<java.lang.Integer> r0 = net.time4j.history.internal.StdHistoricalElement.YEAR_OF_DISPLAY
            boolean r0 = r9.contains(r0)
            if (r0 == 0) goto L_0x00bd
            net.time4j.engine.ChronoElement<java.lang.Integer> r0 = net.time4j.history.internal.StdHistoricalElement.YEAR_OF_DISPLAY
            int r3 = r9.getInt(r0)
        L_0x00bd:
            net.time4j.history.HistoricDate r0 = r10.getBeginOfYear(r2, r3)
            net.time4j.PlainDate r0 = r10.convert((net.time4j.history.HistoricDate) r0)
            net.time4j.engine.ChronoElement r10 = r10.dayOfYear()
            net.time4j.engine.ChronoEntity r10 = r0.with((net.time4j.engine.ChronoElement<java.lang.Integer>) r10, (int) r11)
            net.time4j.PlainDate r10 = (net.time4j.PlainDate) r10
            net.time4j.CalendarDateElement r11 = net.time4j.PlainDate.COMPONENT
            net.time4j.engine.ChronoEntity r9 = r9.with(r11, r10)
        L_0x00d5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.i18n.HistoricExtension.resolve(net.time4j.engine.ChronoEntity, net.time4j.history.ChronoHistory, net.time4j.engine.AttributeQuery):net.time4j.engine.ChronoEntity");
    }

    public boolean canResolve(ChronoElement<?> chronoElement) {
        return chronoElement instanceof StdHistoricalElement;
    }

    private static ChronoHistory getHistory(Locale locale, AttributeQuery attributeQuery) {
        if (((String) attributeQuery.get(Attributes.CALENDAR_TYPE, CalendarText.ISO_CALENDAR_TYPE)).equals("julian")) {
            return ChronoHistory.PROLEPTIC_JULIAN;
        }
        if (attributeQuery.contains(HistoricAttribute.CALENDAR_HISTORY)) {
            return (ChronoHistory) attributeQuery.get(HistoricAttribute.CALENDAR_HISTORY);
        }
        if (!((String) attributeQuery.get(Attributes.CALENDAR_TYPE, CalendarText.ISO_CALENDAR_TYPE)).equals("historic") || !attributeQuery.contains(Attributes.CALENDAR_VARIANT)) {
            return ChronoHistory.of(locale);
        }
        return ChronoHistory.from((String) attributeQuery.get(Attributes.CALENDAR_VARIANT));
    }
}
