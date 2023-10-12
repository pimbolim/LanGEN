package net.time4j.format.expert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.tz.TZID;

class ZoneLabels {
    private final Node root;

    ZoneLabels(Node node) {
        this.root = node;
    }

    public String toString() {
        ArrayList<String> arrayList = new ArrayList<>();
        collect(this.root, new StringBuilder(), arrayList);
        StringBuilder sb = new StringBuilder();
        sb.append("count=");
        sb.append(arrayList.size());
        sb.append(",labels={");
        for (String str : arrayList) {
            sb.append(str);
            sb.append("=>");
            sb.append(find(str));
            sb.append(AbstractJsonLexerKt.COMMA);
        }
        sb.deleteCharAt(sb.length() - 1).append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    static Node insert(Node node, String str, TZID tzid) {
        if (!str.isEmpty()) {
            Objects.requireNonNull(tzid, "Missing timezone id.");
            return insert(node, str, tzid, 0);
        }
        throw new IllegalArgumentException("Empty key cannot be inserted.");
    }

    /* access modifiers changed from: package-private */
    public String longestPrefixOf(CharSequence charSequence, int i) {
        Node node = this.root;
        int length = charSequence.length();
        int i2 = i;
        int i3 = i2;
        while (node != null && i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < node.c) {
                node = node.left;
            } else if (charAt > node.c) {
                node = node.right;
            } else {
                i2++;
                if (node.zoneIDs != null) {
                    i3 = i2;
                }
                node = node.mid;
            }
        }
        if (i >= i3) {
            return "";
        }
        return charSequence.subSequence(i, i3).toString();
    }

    /* access modifiers changed from: package-private */
    public List<TZID> find(String str) {
        if (str.isEmpty()) {
            return Collections.emptyList();
        }
        Node find = find(this.root, str, 0);
        if (find == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(find.zoneIDs);
    }

    private static Node find(Node node, String str, int i) {
        if (node == null) {
            return null;
        }
        char charAt = str.charAt(i);
        if (charAt < node.c) {
            return find(node.left, str, i);
        }
        if (charAt > node.c) {
            return find(node.right, str, i);
        }
        return i < str.length() + -1 ? find(node.mid, str, i + 1) : node;
    }

    private static Node insert(Node node, String str, TZID tzid, int i) {
        char charAt = str.charAt(i);
        if (node == null) {
            node = new Node(charAt);
        }
        if (charAt < node.c) {
            return node.withLeft(insert(node.left, str, tzid, i));
        }
        if (charAt > node.c) {
            return node.withRight(insert(node.right, str, tzid, i));
        }
        if (i < str.length() - 1) {
            return node.withMid(insert(node.mid, str, tzid, i + 1));
        }
        return node.with(tzid);
    }

    private void collect(Node node, StringBuilder sb, List<String> list) {
        if (node != null) {
            collect(node.left, sb, list);
            if (node.zoneIDs != null) {
                list.add(sb.toString() + node.c);
            }
            Node access$400 = node.mid;
            sb.append(node.c);
            collect(access$400, sb, list);
            sb.deleteCharAt(sb.length() - 1);
            collect(node.right, sb, list);
        }
    }

    static class Node {
        /* access modifiers changed from: private */
        public final char c;
        /* access modifiers changed from: private */
        public final Node left;
        /* access modifiers changed from: private */
        public final Node mid;
        /* access modifiers changed from: private */
        public final Node right;
        /* access modifiers changed from: private */
        public final List<TZID> zoneIDs;

        private Node(char c2) {
            this(c2, (Node) null, (Node) null, (Node) null, (List<TZID>) null);
        }

        private Node(char c2, Node node, Node node2, Node node3, List<TZID> list) {
            this.c = c2;
            this.left = node;
            this.mid = node2;
            this.right = node3;
            this.zoneIDs = list;
        }

        /* access modifiers changed from: private */
        public Node withLeft(Node node) {
            return new Node(this.c, node, this.mid, this.right, this.zoneIDs);
        }

        /* access modifiers changed from: private */
        public Node withMid(Node node) {
            return new Node(this.c, this.left, node, this.right, this.zoneIDs);
        }

        /* access modifiers changed from: private */
        public Node withRight(Node node) {
            return new Node(this.c, this.left, this.mid, node, this.zoneIDs);
        }

        /* access modifiers changed from: private */
        public Node with(TZID tzid) {
            ArrayList arrayList = new ArrayList();
            List<TZID> list = this.zoneIDs;
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(tzid);
            return new Node(this.c, this.left, this.mid, this.right, arrayList);
        }
    }
}
