package com.thenullproject.designpatterns.prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Polygon registry to return commonly used, pre-built prototypes.
 */
public final class PolygonRegistry {

    private final Map<String, Polygon> polygonMap;

    public PolygonRegistry() {
        polygonMap = new HashMap<>();
    }

    public void addPolygon(String name, Polygon polygon) {
        polygonMap.put(name, polygon);
    }

    public Polygon getPolygonByName(String name) {
        Polygon p = Optional.ofNullable(polygonMap.get(name))
                .orElseThrow(() -> new IllegalStateException("No polygon exists in registry with name " + name));
        return p.clone();
    }
}
