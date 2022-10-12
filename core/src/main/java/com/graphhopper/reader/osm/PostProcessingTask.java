package com.graphhopper.reader.osm;

/**
 * Task to be run after graph is read but before any internal mappings are cleared.
 */
public interface PostProcessingTask {

    public void run();

}
