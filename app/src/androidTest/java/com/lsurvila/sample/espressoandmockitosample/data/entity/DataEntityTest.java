package com.lsurvila.sample.espressoandmockitosample.data.entity;

import junit.framework.TestCase;

public class DataEntityTest extends TestCase {

    public void testMakeFoodDescriptionFromAsciiString() {
        String data = "~01169~^~0100~^~Cheese, low-sodium, cheddar or colby~^~CHEESE,LOW-SODIUM,CHEDDAR OR COLBY~^~Cheese~^~Cheese (Manufacturer Name)~^~Y~^~Refuse~^0^~Cheese (Scientific Name)~^6.38^4.27^8.79^3.87";

        FoodDescription foodDescription = new FoodDescription(data);

        assertEquals("01169", foodDescription.getFoodId());
        assertEquals("0100", foodDescription.getFoodGroupId());
        assertEquals("Cheese, low-sodium, cheddar or colby", foodDescription.getLongDescription());
        assertEquals("CHEESE,LOW-SODIUM,CHEDDAR OR COLBY", foodDescription.getShortDescription());
        assertEquals("Cheese", foodDescription.getCommonName());
        assertEquals("Cheese (Manufacturer Name)", foodDescription.getManufacturerName());
        assertEquals(true, foodDescription.isUsdaStudied());
        assertEquals("Refuse", foodDescription.getRefuseDescription());
        assertEquals(0, foodDescription.getRefusePercentage());
        assertEquals("Cheese (Scientific Name)", foodDescription.getScientificName());
        assertEquals(6.38, foodDescription.getNitrogenFactor());
        assertEquals(4.27, foodDescription.getProteinFactor());
        assertEquals(8.79, foodDescription.getFatFactor());
        assertEquals(3.87, foodDescription.getCarbohydrateFactor());
    }

    public void testMakeNutrientDataFromAsciiString() {
        String data = "~21395~^~672~^0.005^9^0.000^~1~^~A~^~NDB~^~C~^1^0.005^0.006^2^0.004^0.006^~4~^07/2012^2";

        NutrientData nutrientData = new NutrientData(data);

        assertEquals("21395", nutrientData.getFoodId());
        assertEquals("672", nutrientData.getNutrientId());
        assertEquals(0.005, nutrientData.getAmountIn100g());
        assertEquals(9, nutrientData.getNumberOfAnalyses());
        assertEquals(0.000, nutrientData.getErrorOfMean());
        assertEquals("1", nutrientData.getDataTypeCode());
        assertEquals("A", nutrientData.getDataDerivationCode());
        assertEquals("NDB", nutrientData.getNdbNumber());
        assertEquals("C", nutrientData.getEnrichedVitaminOrMineral());
        assertEquals(1, nutrientData.getNumberOfStudies());
        assertEquals(0.005, nutrientData.getMinValue());
        assertEquals(0.006, nutrientData.getMaxValue());
        assertEquals(2, nutrientData.getDegreesOfFreedom());
        assertEquals(0.004, nutrientData.getLowerErrorBound());
        assertEquals(0.006, nutrientData.getUpperErrorBound());
        assertEquals("4", nutrientData.getStatisticalComments());
        assertEquals(7, nutrientData.getLastModifiedDate().getMonthOfYear());
        assertEquals(2012, nutrientData.getLastModifiedDate().getYear());
        assertEquals(2, nutrientData.getConfidenceCode());
    }

    public void testMakeNutrientDefinitionFromAsciiString() {
        String data = "~203~^~g~^~PROCNT~^~Protein~^~2~^~600~";

        NutrientDefinition nutrientDefinition = new NutrientDefinition(data);

        assertEquals("203", nutrientDefinition.getNutrientId());
        assertEquals("g", nutrientDefinition.getUnits());
        assertEquals("PROCNT", nutrientDefinition.getAbbreviation());
        assertEquals("Protein", nutrientDefinition.getNutrientName());
        assertEquals("2", nutrientDefinition.getDecimalPlaces());
        assertEquals("600", nutrientDefinition.getSortOrder());
    }

}
