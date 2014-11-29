package com.lsurvila.sample.espressoandmockitosample.data.entity;

/**
 *  Provides the 3-digit nutrient code, unit of measure, INFOODS
 *  tagname, and description.
 */
public class NutrientDefinition extends Entity {

    private String nutrientId;
    private String units;
    private String abbreviation;
    private String nutrientName;
    private String decimalPlaces;
    private String sortOrder;

    public NutrientDefinition(String data) {
        super(data);
        nutrientId = getString(0);
        units = getString(1);
        abbreviation = getString(2);
        nutrientName = getString(3);
        decimalPlaces = getString(4);
        sortOrder = getString(5);
    }

    public String getNutrientId() {
        return nutrientId;
    }

    public String getUnits() {
        return units;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public String getDecimalPlaces() {
        return decimalPlaces;
    }

    public String getSortOrder() {
        return sortOrder;
    }
}
