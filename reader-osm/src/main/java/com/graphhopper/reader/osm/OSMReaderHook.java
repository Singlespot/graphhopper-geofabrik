package com.graphhopper.reader.osm;

import com.graphhopper.reader.ReaderNode;

/**
 * Class with some callback methods called by OSMReader at certain points.
 *
 * This class allows you to extend OSMReader.
 *
 * @author Michael Reichert
 */
public interface OSMReaderHook {
    public void processNode(ReaderNode node);    
}
