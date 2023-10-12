package com.swmansion.reanimated.nodes;

import com.braintreepayments.api.internal.GraphQLConstants;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.Utils;

public class ConcatNode extends Node {
    private final int[] mInputIDs;

    public ConcatNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputIDs = Utils.processIntArray(readableMap.getArray(GraphQLConstants.Keys.INPUT));
    }

    /* access modifiers changed from: protected */
    public String evaluate() {
        StringBuilder sb = new StringBuilder();
        for (int findNodeById : this.mInputIDs) {
            sb.append(this.mNodesManager.findNodeById(findNodeById, Node.class).value());
        }
        return sb.toString();
    }
}
