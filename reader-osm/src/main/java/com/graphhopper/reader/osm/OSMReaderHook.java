package com.graphhopper.reader.osm;

import com.graphhopper.reader.ReaderNode;

/**
 * Class with some callback methods called by OSMReader at certain points.
 *
 * This class allows you to extend OSMReader.
 *
 * @author Michael Reichert
 */
public abstract class OSMReaderHook {
    public void processNode(ReaderNode node) {
    }

    /**
     * Called at the end of OSMReader.addTowerNode
     */
    public void addTowerNode(long osmId, double lat, double lon, double ele, int towerId) {
    }
}
