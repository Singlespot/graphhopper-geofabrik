/*
 *  Licensed to GraphHopper GmbH under one or more contributor
 *  license agreements. See the NOTICE file distributed with this work for
 *  additional information regarding copyright ownership.
 *
 *  GraphHopper GmbH licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except in
 *  compliance with the License. You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.graphhopper.util.details;

import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.util.EdgeIteratorState;

import static com.graphhopper.util.Parameters.DETAILS.SURFACE;

/**
 * Get surface of for a Path
 *
 * @author Michael Reichert
 */
public class SurfaceDetails extends AbstractPathDetailsBuilder {

    private final FlagEncoder encoder;

    private int edgeId = -1;
    private String surface = "";

    public SurfaceDetails(FlagEncoder encoder) {
        super(SURFACE);
        this.encoder = encoder;
    }

    @Override
    public boolean isEdgeDifferentToLastEdge(EdgeIteratorState edge) {
        if (edge.getEdge() != edgeId) {
            edgeId = edge.getEdge();
	    surface = encoder.getSurfaceAsString(edge.getFlags());
            return true;
        }
        return false;
    }

    @Override
    public Object getCurrentValue() {
        return this.surface;
    }
}
