package androidx.profileinstaller;

import java.util.TreeMap;

class DexProfileData {
    final String apkName;
    int classSetSize;
    int[] classes;
    final long dexChecksum;
    final String dexName;
    final int hotMethodRegionSize;
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    DexProfileData(String str, String str2, long j, int i, int i2, int i3, int[] iArr, TreeMap<Integer, Integer> treeMap) {
        this.apkName = str;
        this.dexName = str2;
        this.dexChecksum = j;
        this.classSetSize = i;
        this.hotMethodRegionSize = i2;
        this.numMethodIds = i3;
        this.classes = iArr;
        this.methods = treeMap;
    }
}
