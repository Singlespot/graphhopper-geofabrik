package com.graphhopper.reader.osm;

import com.graphhopper.reader.ReaderNode;
import com.graphhopper.reader.ReaderWay;

/**
 * Class with some callback methods called by OSMReader at certain points.
 *
 * This class allows you to extend OSMReader.
 *
 * @author Michael Reichert
 */
public abstract class OSMReaderHook {

    /**
     * Called for each node processed in OSMReader.processNode
     *
     * This callback is called after the processing of the node happens by GraphHopper.
     * It is only called for nodes which are required to build up the graph (as tower or pillars).
     */
    public void processNode(ReaderNode node) {
    }

    /**
     * Called for each node in the input file before OSMReader.processNode is called.
     */
    public void beforeProcessNode(ReaderNode node) {
    }

    /**
     * Called for each way processed in OSMReader.preProcess
     *
     * This callback is called before any filtering by tags happens by GraphHopper.
     * It is called for all ways.
     */
    public void preProcessWay(ReaderWay way) {
    }

    /**
     * Called at the beginning of OSMReader.processWay.
     *
     * @returns whether OSMReader should continue with processing or not.
     */
    public boolean beforeProcessWay(ReaderWay way, boolean continueWithProcessing) {
        return continueWithProcessing;
    }

    /**
     * Called at the end of OSMReader.addTowerNode
     */
    public void addTowerNode(long osmId, double lat, double lon, double ele, int towerId) {
    }
}
