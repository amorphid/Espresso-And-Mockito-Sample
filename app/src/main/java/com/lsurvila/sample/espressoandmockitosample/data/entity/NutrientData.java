package com.lsurvila.sample.espressoandmockitosample.data.entity;

import org.joda.time.LocalDate;

/**
 *  Contains the nutrient values and information about the values, including expanded statistical information.
 */
public class NutrientData extends Entity {

    private String foodId;
    private String nutrientId;
    private double amountIn100g;
    private int numberOfAnalyses;
    private double errorOfMean;
    private String dataTypeCode;
    private String dataDerivationCode;
    private String ndbNumber;
    private String enrichedVitaminOrMineral;
    private int numberOfStudies;
    private double minValue;
    private double maxValue;
    private int degreesOfFreedom;
    private double lowerErrorBound;
    private double upperErrorBound;
    private String statisticalComments;
    private LocalDate lastModifiedDate;
    private int confidenceCode;

    public NutrientData(String data) {
        super(data);
        foodId = getString(0);
        nutrientId = getString(1);
        amountIn100g = getDouble(2);
        numberOfAnalyses = getInteger(3);
        errorOfMean = getDouble(4);
        dataTypeCode = getString(5);
        dataDerivationCode = getString(6);
        ndbNumber = getString(7);
        enrichedVitaminOrMineral = getString(8);
        numberOfStudies = getInteger(9);
        minValue = getDouble(10);
        maxValue = getDouble(11);
        degreesOfFreedom = getInteger(12);
        lowerErrorBound = getDouble(13);
        upperErrorBound = getDouble(14);
        statisticalComments = getString(15);
        lastModifiedDate = getDate(16);
        confidenceCode = getInteger(17);
    }

    public String getFoodId() {
        return foodId;
    }

    public String getNutrientId() {
        return nutrientId;
    }

    public double getAmountIn100g() {
        return amountIn100g;
    }

    public int getNumberOfAnalyses() {
        return numberOfAnalyses;
    }

    public double getErrorOfMean() {
        return errorOfMean;
    }

    public String getDataTypeCode() {
        return dataTypeCode;
    }

    public String getDataDerivationCode() {
        return dataDerivationCode;
    }

    public String getNdbNumber() {
        return ndbNumber;
    }

    public String getEnrichedVitaminOrMineral() {
        return enrichedVitaminOrMineral;
    }

    public int getNumberOfStudies() {
        return numberOfStudies;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public int getDegreesOfFreedom() {
        return degreesOfFreedom;
    }

    public double getLowerErrorBound() {
        return lowerErrorBound;
    }

    public double getUpperErrorBound() {
        return upperErrorBound;
    }

    public String getStatisticalComments() {
        return statisticalComments;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public int getConfidenceCode() {
        return confidenceCode;
    }
}
