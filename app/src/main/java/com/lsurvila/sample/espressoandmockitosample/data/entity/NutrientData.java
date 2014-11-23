package com.lsurvila.sample.espressoandmockitosample.data.entity;

import com.lsurvila.sample.espressoandmockitosample.data.AsciiLineParser;

import org.joda.time.LocalDate;

/**
 *  Contains the nutrient values and information about the values, including expanded statistical information.
 */
public class NutrientData {

    private String databankId;
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
        AsciiLineParser parser = new AsciiLineParser();
        parser.parse(data);
        databankId = parser.getString(0);
        nutrientId = parser.getString(1);
        amountIn100g = parser.getDouble(2);
        numberOfAnalyses = parser.getInt(3);
        errorOfMean = parser.getDouble(4);
        dataTypeCode = parser.getString(5);
        dataDerivationCode = parser.getString(6);
        ndbNumber = parser.getString(7);
        enrichedVitaminOrMineral = parser.getString(8);
        numberOfStudies = parser.getInt(9);
        minValue = parser.getDouble(10);
        maxValue = parser.getDouble(11);
        degreesOfFreedom = parser.getInt(12);
        lowerErrorBound = parser.getDouble(13);
        upperErrorBound = parser.getDouble(14);
        statisticalComments = parser.getString(15);
        lastModifiedDate = parser.getDate(16);
        confidenceCode = parser.getInt(17);
    }

    public String getDatabankId() {
        return databankId;
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
