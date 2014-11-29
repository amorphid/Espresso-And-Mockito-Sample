package com.lsurvila.sample.espressoandmockitosample.data.entity;

import com.lsurvila.sample.espressoandmockitosample.data.AsciiLineParser;

/**
 * Contains long and short descriptions and food group designators for all food items, along with common
 * names, manufacturer name, scientific name, percentage and description of refuse, and
 * factors used for calculating protein and kilocalories, if applicable. Shows if items used in the
 * FNDDS studies.
 */
public class FoodDescription extends Entity {

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
        super(data);
        foodId = getString(0);
        foodGroupId = getString(1);
        longDescription = getString(2);
        shortDescription = getString(3);
        commonName = getString(4);
        manufacturerName = getString(5);
        isUsdaStudied = getBoolean(6);
        refuseDescription = getString(7);
        refusePercentage = getInteger(8);
        scientificName = getString(9);
        nitrogenFactor = getDouble(10);
        proteinFactor = getDouble(11);
        fatFactor = getDouble(12);
        carbohydrateFactor = getDouble(13);
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
