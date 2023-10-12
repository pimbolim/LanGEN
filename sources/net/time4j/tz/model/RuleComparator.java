package net.time4j.tz.model;

import java.util.Comparator;

enum RuleComparator implements Comparator<DaylightSavingRule> {
    INSTANCE;

    public int compare(DaylightSavingRule daylightSavingRule, DaylightSavingRule daylightSavingRule2) {
        int compareTo = daylightSavingRule.getDate(2000).compareTo(daylightSavingRule2.getDate(2000));
        return compareTo == 0 ? daylightSavingRule.getTimeOfDay().compareTo(daylightSavingRule2.getTimeOfDay()) : compareTo;
    }
}
