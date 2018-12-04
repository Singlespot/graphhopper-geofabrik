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
package com.graphhopper.routing.util;

import org.junit.Test;

import com.graphhopper.reader.ReaderWay;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter Karich
 */
public class AbstractFlagEncoderTest {
    @Test
    public void testAcceptsCar() {
        CarFlagEncoder encoder = new CarFlagEncoder(5, 5, 0);
        assertEquals(40, encoder.parseSpeed("40 km/h"), 1e-3);
        assertEquals(40, encoder.parseSpeed("40km/h"), 1e-3);
        assertEquals(40, encoder.parseSpeed("40kmh"), 1e-3);
        assertEquals(64.374, encoder.parseSpeed("40mph"), 1e-3);
        assertEquals(48.28, encoder.parseSpeed("30 mph"), 1e-3);
        assertEquals(-1, encoder.parseSpeed(null), 1e-3);
        assertEquals(18.52, encoder.parseSpeed("10 knots"), 1e-3);
        assertEquals(19, encoder.parseSpeed("19 kph"), 1e-3);
        assertEquals(19, encoder.parseSpeed("19kph"), 1e-3);

        assertEquals(50, encoder.parseSpeed("RO:urban"), 1e-3);

        assertEquals(80, encoder.parseSpeed("RU:rural"), 1e-3);

        assertEquals(6, encoder.parseSpeed("walk"), 1e-3);
    }

    @Test
    public void testSurface() {
        BikeFlagEncoder encoder = new BikeFlagEncoder(5, 5, 0);
        ArrayList<String> surfaces = new ArrayList<String>() {{
            add("asphalt");
            add("unpaved");
            add("paved");
            add("gravel");
            add("ground");
            add("dirt");
            add("grass");
            add("concrete");
            add("paving_stones");
            add("sand");
            add("compacted");
            add("cobblestone");
            add("mud");
            add("ice");
        }};
        for (String s : surfaces) {
            assertEquals(s, encoder.getSurfaceName(encoder.getSurfaceIndex(s)));
        }
    }

    @Test
    public void testRoadEnvironment() {
        BikeFlagEncoder encoder = new BikeFlagEncoder(5, 5, 0);
        ReaderWay bridgeWay = new ReaderWay(1);
        bridgeWay.setTag("bridge", "yes");
        ReaderWay tunnelWay = new ReaderWay(2);
        tunnelWay.setTag("tunnel", "yes");
        ReaderWay fordWay = new ReaderWay(3);
        fordWay.setTag("ford", "yes");
        ReaderWay way = new ReaderWay(4);
        assertEquals("bridge", encoder.getRoadEnvironmentName(encoder.getRoadEnvironmentIndex(bridgeWay)));
        assertEquals("tunnel", encoder.getRoadEnvironmentName(encoder.getRoadEnvironmentIndex(tunnelWay)));
        assertEquals("ford", encoder.getRoadEnvironmentName(encoder.getRoadEnvironmentIndex(fordWay)));
        assertEquals("_default", encoder.getRoadEnvironmentName(encoder.getRoadEnvironmentIndex(way)));
    }

}
