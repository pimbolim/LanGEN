package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLString;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001J\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00072\u0006\u0010\u000f\u001a\u00020\u0005J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eJ6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\fJ&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00052\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0006j\b\u0012\u0004\u0012\u00020\u0005`\u0007J\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000eRJ\u0010\u0003\u001a>\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0006j\b\u0012\u0004\u0012\u00020\u0005`\u00070\u0004j\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0006j\b\u0012\u0004\u0012\u00020\u0005`\u0007`\bX\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n`\bX\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/constraintlayout/compose/LayoutVariables;", "", "()V", "arrayIds", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "generators", "Landroidx/constraintlayout/compose/GeneratedValue;", "margins", "", "get", "", "elementName", "getList", "put", "", "start", "incrementBy", "from", "to", "step", "prefix", "postfix", "element", "elements", "putOverride", "value", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintSetParser.kt */
public final class LayoutVariables {
    private final HashMap<String, ArrayList<String>> arrayIds = new HashMap<>();
    private final HashMap<String, GeneratedValue> generators = new HashMap<>();
    private final HashMap<String, Integer> margins = new HashMap<>();

    public final void put(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "elementName");
        this.margins.put(str, Integer.valueOf(i));
    }

    public final void put(String str, float f, float f2) {
        Intrinsics.checkNotNullParameter(str, "elementName");
        if (!this.generators.containsKey(str) || !(this.generators.get(str) instanceof OverrideValue)) {
            this.generators.put(str, new Generator(f, f2));
        }
    }

    public final void put(String str, float f, float f2, float f3, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "elementName");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        Intrinsics.checkNotNullParameter(str3, "postfix");
        if (!this.generators.containsKey(str) || !(this.generators.get(str) instanceof OverrideValue)) {
            FiniteGenerator finiteGenerator = new FiniteGenerator(f, f2, f3, str2, str3);
            this.generators.put(str, finiteGenerator);
            this.arrayIds.put(str, finiteGenerator.array());
        }
    }

    public final void putOverride(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "elementName");
        this.generators.put(str, new OverrideValue(f));
    }

    public final float get(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "elementName");
        if (obj instanceof CLString) {
            String content = ((CLString) obj).content();
            if (this.generators.containsKey(content)) {
                GeneratedValue generatedValue = this.generators.get(content);
                Intrinsics.checkNotNull(generatedValue);
                return generatedValue.value();
            } else if (!this.margins.containsKey(content)) {
                return 0.0f;
            } else {
                Integer num = this.margins.get(content);
                Intrinsics.checkNotNull(num);
                return (float) num.intValue();
            }
        } else if (obj instanceof CLNumber) {
            return ((CLNumber) obj).getFloat();
        } else {
            return 0.0f;
        }
    }

    public final ArrayList<String> getList(String str) {
        Intrinsics.checkNotNullParameter(str, "elementName");
        if (this.arrayIds.containsKey(str)) {
            return this.arrayIds.get(str);
        }
        return null;
    }

    public final void put(String str, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(str, "elementName");
        Intrinsics.checkNotNullParameter(arrayList, "elements");
        this.arrayIds.put(str, arrayList);
    }
}
