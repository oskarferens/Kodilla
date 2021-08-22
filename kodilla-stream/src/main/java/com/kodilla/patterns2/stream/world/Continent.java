package com.kodilla.patterns2.stream.world;

import java.util.List;

public final class Continent {
    private final String continentName;
    final List<Country> countries;

    public Continent(final String continentName, final List<Country> countries) {
        this.continentName = continentName;
        this.countries=countries;
    }
    public String getContinentName() {
        return continentName;
    }
    public List<Country> getCountries() {
        return countries;
    }
}