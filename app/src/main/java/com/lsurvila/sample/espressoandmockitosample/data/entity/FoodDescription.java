package com.lsurvila.sample.espressoandmockitosample.data.entity;

import com.lsurvila.sample.espressoandmockitosample.data.AsciiLineParser;

/**
 * Contains long and short descriptions and food group designators for all food items, along with common
 * names, manufacturer name, scientific name, percentage and description of refuse, and
 * factors used for calculating protein and kilocalories, if applicable. Shows if items used in the
 * FNDDS studies.
 */
public class FoodDescription {

    private String foodId;
    private String foodGroupId;
    private String longDescription;
    private String shortDescription;
    private String commonName;
    private String manufacturerName;
    private boolean isUsdaStudied;
    private String refuseDescription;
    private int refusePercentage;
    private String scientificName;
    private double nitrogenFactor;
    private double proteinFactor;
    private double fatFactor;
    private double carbohydrateFactor;

    public FoodDescription(String data) {
        AsciiLineParser parser = new AsciiLineParser();
        parser.parse(data);
        foodId = parser.getString(0);
        foodGroupId = parser.getString(1);
        longDescription = parser.getString(2);
        shortDescription = parser.getString(3);
        commonName = parser.getString(4);
        manufacturerName = parser.getString(5);
        isUsdaStudied = parser.getBoolean(6);
        refuseDescription = parser.getString(7);
        refusePercentage = parser.getInt(8);
        scientificName = parser.getString(9);
        nitrogenFactor = parser.getDouble(10);
        proteinFactor = parser.getDouble(11);
        fatFactor = parser.getDouble(12);
        carbohydrateFactor = parser.getDouble(13);
    }

    public String getFoodId() {
        return foodId;
    }

    public String getFoodGroupId() {
        return foodGroupId;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public boolean isUsdaStudied() {
        return isUsdaStudied;
    }

    public String getRefuseDescription() {
        return refuseDescription;
    }

    public int getRefusePercentage() {
        return refusePercentage;
    }

    public String getScientificName() {
        return scientificName;
    }

    public double getNitrogenFactor() {
        return nitrogenFactor;
    }

    public double getProteinFactor() {
        return proteinFactor;
    }

    public double getFatFactor() {
        return fatFactor;
    }

    public double getCarbohydrateFactor() {
        return carbohydrateFactor;
    }
}
