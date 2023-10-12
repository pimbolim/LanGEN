package com.nimbusds.jwt.proc;

import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimNames;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.util.DateUtils;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class DefaultJWTClaimsVerifier<C extends SecurityContext> implements JWTClaimsSetVerifier<C>, ClockSkewAware {
    public static final int DEFAULT_MAX_CLOCK_SKEW_SECONDS = 60;
    private final Set<String> acceptedAudienceValues;
    private final JWTClaimsSet exactMatchClaims;
    private int maxClockSkew;
    private final Set<String> prohibitedClaims;
    private final Set<String> requiredClaims;

    @Deprecated
    public DefaultJWTClaimsVerifier() {
        this((Set<String>) null, (JWTClaimsSet) null, (Set<String>) null, (Set<String>) null);
    }

    public DefaultJWTClaimsVerifier(JWTClaimsSet jWTClaimsSet, Set<String> set) {
        this((Set<String>) null, jWTClaimsSet, set, (Set<String>) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultJWTClaimsVerifier(String str, JWTClaimsSet jWTClaimsSet, Set<String> set) {
        this(str != null ? Collections.singleton(str) : null, jWTClaimsSet, set, (Set<String>) null);
    }

    public DefaultJWTClaimsVerifier(Set<String> set, JWTClaimsSet jWTClaimsSet, Set<String> set2, Set<String> set3) {
        this.maxClockSkew = 60;
        Set<String> unmodifiableSet = set != null ? Collections.unmodifiableSet(set) : null;
        this.acceptedAudienceValues = unmodifiableSet;
        jWTClaimsSet = jWTClaimsSet == null ? new JWTClaimsSet.Builder().build() : jWTClaimsSet;
        this.exactMatchClaims = jWTClaimsSet;
        HashSet hashSet = new HashSet(jWTClaimsSet.getClaims().keySet());
        if (unmodifiableSet != null && !unmodifiableSet.contains((Object) null)) {
            hashSet.add(JWTClaimNames.AUDIENCE);
        }
        if (set2 != null) {
            hashSet.addAll(set2);
        }
        this.requiredClaims = Collections.unmodifiableSet(hashSet);
        this.prohibitedClaims = set3 != null ? Collections.unmodifiableSet(set3) : Collections.emptySet();
    }

    public Set<String> getAcceptedAudienceValues() {
        return this.acceptedAudienceValues;
    }

    public JWTClaimsSet getExactMatchClaims() {
        return this.exactMatchClaims;
    }

    public Set<String> getRequiredClaims() {
        return this.requiredClaims;
    }

    public Set<String> getProhibitedClaims() {
        return this.prohibitedClaims;
    }

    public int getMaxClockSkew() {
        return this.maxClockSkew;
    }

    public void setMaxClockSkew(int i) {
        this.maxClockSkew = i;
    }

    public void verify(JWTClaimsSet jWTClaimsSet, C c) throws BadJWTException {
        if (this.acceptedAudienceValues != null) {
            List<String> audience = jWTClaimsSet.getAudience();
            if (audience != null && !audience.isEmpty()) {
                boolean z = false;
                Iterator<String> it = audience.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (this.acceptedAudienceValues.contains(it.next())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    throw new BadJWTException("JWT audience rejected: " + audience);
                }
            } else if (!this.acceptedAudienceValues.contains((Object) null)) {
                throw new BadJWTException("JWT missing required audience");
            }
        }
        if (jWTClaimsSet.getClaims().keySet().containsAll(this.requiredClaims)) {
            TreeSet treeSet = new TreeSet();
            for (String next : this.prohibitedClaims) {
                if (jWTClaimsSet.getClaims().containsKey(next)) {
                    treeSet.add(next);
                }
            }
            if (treeSet.isEmpty()) {
                for (String next2 : this.exactMatchClaims.getClaims().keySet()) {
                    Object claim = jWTClaimsSet.getClaim(next2);
                    Object claim2 = this.exactMatchClaims.getClaim(next2);
                    if (!claim.equals(claim2)) {
                        throw new BadJWTException("JWT " + next2 + " claim has value " + claim + ", must be " + claim2);
                    }
                }
                Date currentTime = currentTime();
                if (currentTime != null) {
                    Date expirationTime = jWTClaimsSet.getExpirationTime();
                    if (expirationTime == null || DateUtils.isAfter(expirationTime, currentTime, (long) this.maxClockSkew)) {
                        Date notBeforeTime = jWTClaimsSet.getNotBeforeTime();
                        if (notBeforeTime != null && !DateUtils.isBefore(notBeforeTime, currentTime, (long) this.maxClockSkew)) {
                            throw new BadJWTException("JWT before use time");
                        }
                        return;
                    }
                    throw new BadJWTException("Expired JWT");
                }
                return;
            }
            throw new BadJWTException("JWT has prohibited claims: " + treeSet);
        }
        TreeSet treeSet2 = new TreeSet(this.requiredClaims);
        treeSet2.removeAll(jWTClaimsSet.getClaims().keySet());
        throw new BadJWTException("JWT missing required claims: " + treeSet2);
    }

    /* access modifiers changed from: protected */
    public Date currentTime() {
        return new Date();
    }
}
