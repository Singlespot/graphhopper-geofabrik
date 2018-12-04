package com.graphhopper.reader.osm.conditional;

import com.graphhopper.reader.ConditionalTagInspector;
import com.graphhopper.reader.ReaderWay;

public class DummyConditionalTagInspector implements ConditionalTagInspector {

    public boolean isRestrictedWayConditionallyPermitted(ReaderWay way) {
        return false;
    }

    public boolean isPermittedWayConditionallyRestricted(ReaderWay way) {
        return false;
    }
}
