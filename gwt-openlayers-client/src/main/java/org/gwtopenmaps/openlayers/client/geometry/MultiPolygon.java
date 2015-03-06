/**
 *
 *   Copyright 2015 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

public class MultiPolygon extends Collection {

    public static MultiPolygon narrowToMultiPolygon(JSObject multiPolygon) {
        return (multiPolygon == null) ? null : new MultiPolygon(multiPolygon);
    }

    protected MultiPolygon(JSObject element) {
        super(element);
    }

    public MultiPolygon(Polygon[] polygons) {
        this(MultiPolygonImpl.create((new JObjectArray(polygons)).getJSObject()));
    }

    /**
     * MultiPolygons are collections of Polygons.
     *
     * @return Array of LinearRing Objects
     */
    public Polygon[] getComponents() {
        int max = getNumberOfComponents();
        Polygon[] components = new Polygon[max];
        for (int i = 0; i < max; i++) {
            components[i] = Polygon.narrowToPolygon(getComponent(i));
        }

        return components;
    }

}
