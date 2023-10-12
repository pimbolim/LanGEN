package com.stripe.android.ui.core.address;

import androidx.compose.ui.text.input.KeyboardType;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.RowController;
import com.stripe.android.ui.core.elements.RowElement;
import com.stripe.android.ui.core.elements.SectionFieldElement;
import com.stripe.android.ui.core.elements.SectionSingleFieldElement;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0002\u001a\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002\u001a\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002\u001a\u001a\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000\u001a\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\b\u0012\u0004\u0012\u00020\u00180\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"format", "Lkotlinx/serialization/json/Json;", "combineCityAndPostal", "", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "countryAddressElements", "Lcom/stripe/android/ui/core/elements/SectionSingleFieldElement;", "getJsonStringFromInputStream", "", "inputStream", "Ljava/io/InputStream;", "getKeyboard", "Landroidx/compose/ui/text/input/KeyboardType;", "fieldSchema", "Lcom/stripe/android/ui/core/address/FieldSchema;", "(Lcom/stripe/android/ui/core/address/FieldSchema;)I", "isCityOrPostal", "", "identifierSpec", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "isPostalNextToCity", "element1", "element2", "parseAddressesSchema", "Lcom/stripe/android/ui/core/address/CountryAddressSchema;", "transformToElementList", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransformAddressToElement.kt */
public final class TransformAddressToElementKt {
    private static final Json format = JsonKt.Json$default((Json) null, TransformAddressToElementKt$format$1.INSTANCE, 1, (Object) null);

    public static final List<CountryAddressSchema> parseAddressesSchema(InputStream inputStream) {
        String jsonStringFromInputStream = getJsonStringFromInputStream(inputStream);
        if (jsonStringFromInputStream == null) {
            return null;
        }
        StringFormat stringFormat = format;
        return (List) stringFormat.decodeFromString(SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CountryAddressSchema.class)))), jsonStringFromInputStream);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String getJsonStringFromInputStream(java.io.InputStream r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0005
            r2 = r0
            goto L_0x001d
        L_0x0005:
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            r2.<init>(r3, r1)
            java.io.Reader r2 = (java.io.Reader) r2
            r3 = 8192(0x2000, float:1.14794E-41)
            boolean r1 = r2 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0017
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2
            goto L_0x001d
        L_0x0017:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r1.<init>(r2, r3)
            r2 = r1
        L_0x001d:
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ all -> 0x0030 }
            if (r3 != 0) goto L_0x0026
            r3 = r0
            goto L_0x002c
        L_0x0026:
            java.io.Reader r3 = (java.io.Reader) r3     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = kotlin.io.TextStreamsKt.readText(r3)     // Catch:{ all -> 0x0030 }
        L_0x002c:
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r3
        L_0x0030:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.address.TransformAddressToElementKt.getJsonStringFromInputStream(java.io.InputStream):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.stripe.android.ui.core.elements.SimpleTextSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.stripe.android.ui.core.elements.SectionFieldElement> transformToElementList(java.util.List<com.stripe.android.ui.core.address.CountryAddressSchema> r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r13 = r13.iterator()
        L_0x0012:
            boolean r1 = r13.hasNext()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0072
            java.lang.Object r1 = r13.next()
            com.stripe.android.ui.core.address.CountryAddressSchema r1 = (com.stripe.android.ui.core.address.CountryAddressSchema) r1
            com.stripe.android.ui.core.address.FieldType r4 = r1.getType()
            if (r4 != 0) goto L_0x0027
            goto L_0x006b
        L_0x0027:
            com.stripe.android.ui.core.elements.SimpleTextSpec r12 = new com.stripe.android.ui.core.elements.SimpleTextSpec
            com.stripe.android.ui.core.address.FieldType r5 = r1.getType()
            com.stripe.android.ui.core.elements.IdentifierSpec r6 = r5.getIdentifierSpec()
            com.stripe.android.ui.core.address.FieldSchema r5 = r1.getSchema()
            if (r5 != 0) goto L_0x0038
            goto L_0x0047
        L_0x0038:
            com.stripe.android.ui.core.address.NameType r5 = r5.getNameType()
            if (r5 != 0) goto L_0x003f
            goto L_0x0047
        L_0x003f:
            int r3 = r5.getStringResId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0047:
            if (r3 != 0) goto L_0x004e
            int r3 = r4.getDefaultLabel()
            goto L_0x0052
        L_0x004e:
            int r3 = r3.intValue()
        L_0x0052:
            r7 = r3
            int r8 = r4.m4549getCapitalizationIUNYP9k()
            com.stripe.android.ui.core.address.FieldSchema r3 = r1.getSchema()
            int r9 = getKeyboard(r3)
            boolean r1 = r1.getRequired()
            r10 = r1 ^ 1
            r11 = 0
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r3 = r12
        L_0x006b:
            if (r3 != 0) goto L_0x006e
            goto L_0x0012
        L_0x006e:
            r0.add(r3)
            goto L_0x0012
        L_0x0072:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r13 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r1)
            r13.<init>(r1)
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.Iterator r0 = r0.iterator()
        L_0x0087:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x009b
            java.lang.Object r1 = r0.next()
            com.stripe.android.ui.core.elements.SimpleTextSpec r1 = (com.stripe.android.ui.core.elements.SimpleTextSpec) r1
            com.stripe.android.ui.core.elements.SectionSingleFieldElement r1 = com.stripe.android.ui.core.elements.SimpleTextSpec.transform$default(r1, r3, r2, r3)
            r13.add(r1)
            goto L_0x0087
        L_0x009b:
            java.util.List r13 = (java.util.List) r13
            java.util.List r13 = combineCityAndPostal(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.address.TransformAddressToElementKt.transformToElementList(java.util.List):java.util.List");
    }

    private static final List<SectionFieldElement> combineCityAndPostal(List<? extends SectionSingleFieldElement> list) {
        List emptyList = CollectionsKt.emptyList();
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SectionSingleFieldElement sectionSingleFieldElement = (SectionSingleFieldElement) next;
            if (i2 < list.size() && isPostalNextToCity((SectionSingleFieldElement) list.get(i), (SectionSingleFieldElement) list.get(i2))) {
                List listOf = CollectionsKt.listOf((SectionSingleFieldElement) list.get(i), (SectionSingleFieldElement) list.get(i2));
                emptyList = CollectionsKt.plus(emptyList, new RowElement(new IdentifierSpec.Generic(Intrinsics.stringPlus("row_", Long.valueOf(UUID.randomUUID().getLeastSignificantBits()))), listOf, new RowController(listOf)));
            } else if (CollectionsKt.lastOrNull(emptyList) instanceof RowElement) {
                emptyList = CollectionsKt.plus(emptyList, null);
            } else {
                emptyList = CollectionsKt.plus(emptyList, sectionSingleFieldElement);
            }
            i = i2;
        }
        return CollectionsKt.filterNotNull(emptyList);
    }

    private static final boolean isPostalNextToCity(SectionSingleFieldElement sectionSingleFieldElement, SectionSingleFieldElement sectionSingleFieldElement2) {
        return isCityOrPostal(sectionSingleFieldElement.getIdentifier()) && isCityOrPostal(sectionSingleFieldElement2.getIdentifier());
    }

    private static final boolean isCityOrPostal(IdentifierSpec identifierSpec) {
        return Intrinsics.areEqual((Object) identifierSpec, (Object) IdentifierSpec.PostalCode.INSTANCE) || Intrinsics.areEqual((Object) identifierSpec, (Object) IdentifierSpec.City.INSTANCE);
    }

    private static final int getKeyboard(FieldSchema fieldSchema) {
        boolean z = false;
        if (fieldSchema != null && fieldSchema.isNumeric()) {
            z = true;
        }
        if (z) {
            return KeyboardType.Companion.m3678getNumberPasswordPjHm6EE();
        }
        return KeyboardType.Companion.m3681getTextPjHm6EE();
    }
}
