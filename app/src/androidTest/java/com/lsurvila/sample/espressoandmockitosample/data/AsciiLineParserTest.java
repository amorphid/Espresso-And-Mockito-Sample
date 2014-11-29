package com.lsurvila.sample.espressoandmockitosample.data;

import junit.framework.TestCase;

import org.joda.time.LocalDate;

import static com.lsurvila.sample.espressoandmockitosample.util.TestUtils.*;

public class AsciiLineParserTest extends TestCase {

    private AsciiLineParser asciiLineParser;

    public void setUp() {
        asciiLineParser = new AsciiLineParser();
    }

    public void testParseIntegers() {
        String data = "10^35^31^35^3";

        parse(data);

        assertEquals(5, getSize());
        assertIntegerEquals(10, getInteger(0));
        assertIntegerEquals(35, getInteger(1));
        assertIntegerEquals(31, getInteger(2));
        assertIntegerEquals(35, getInteger(3));
        assertIntegerEquals(3, getInteger(4));
    }

    public void testParseEmptyInteger() {
        String data = "10^^3^3^53";

        parse(data);

        assertEquals(5, getSize());
        assertIntegerEquals(10, getInteger(0));
        assertEquals(null, getInteger(1));
        assertIntegerEquals(3, getInteger(2));
        assertIntegerEquals(3, getInteger(3));
        assertIntegerEquals(53, getInteger(4));
    }

    public void testParseEmptyIntegerAtBeginning() {
        String data = "^23^34^2^8";

        parse(data);

        assertEquals(5, getSize());
        assertEquals(null, getInteger(0));
        assertIntegerEquals(23, getInteger(1));
        assertIntegerEquals(34, getInteger(2));
        assertIntegerEquals(2, getInteger(3));
        assertIntegerEquals(8, getInteger(4));
    }

    public void testParseEmptyIntegerAtEnd() {
        String data = "23^34^2^8^";

        parse(data);

        assertEquals(5, getSize());
        assertIntegerEquals(23, getInteger(0));
        assertIntegerEquals(34, getInteger(1));
        assertIntegerEquals(2, getInteger(2));
        assertIntegerEquals(8, getInteger(3));
        assertEquals(null, getInteger(4));
    }

    public void testParseDoubles() {
        String data = "13.34^23.23^21.0212^8.33212214";

        parse(data);

        assertEquals(4, getSize());
        assertEquals(13.34, getDouble(0));
        assertEquals(23.23, getDouble(1));
        assertEquals(21.0212, getDouble(2));
        assertEquals(8.33212214, getDouble(3));
    }

    public void testParseEmptyDouble() {
        String data = "34.23^^23.2^34.222";

        parse(data);

        assertEquals(4, getSize());
        assertEquals(34.23, getDouble(0));
        assertEquals(null, getDouble(1));
        assertEquals(23.2, getDouble(2));
        assertEquals(34.222, getDouble(3));
    }

    public void testParseStrings() {
        String data = "~text~^~some another text~^~text text text~";

        parse(data);

        assertEquals(3, getSize());
        assertEquals("text", getString(0));
        assertEquals("some another text", getString(1));
        assertEquals("text text text", getString(2));
    }

    public void testParseEmptyString() {
        String data = "~text~^~~^~some another text~";

        parse(data);

        assertEquals(3, getSize());
        assertEquals("text", getString(0));
        assertEquals(null, getString(1));
        assertEquals("some another text", getString(2));
    }

    public void testParseTrueBoolean() {
        String data = "~23~^~Y~^~YY~";

        parse(data);

        assertEquals(3, getSize());
        assertEquals("23", getString(0));
        assertBooleanEquals(true, getBoolean(1));
        assertEquals("YY", getString(2));
    }

    public void testParseFalseBoolean() {
        String data = "~23~^~N~^~NN~";

        parse(data);

        assertEquals(3, getSize());
        assertEquals("23", getString(0));
        assertBooleanEquals(false, getBoolean(1));
        assertEquals("NN", getString(2));
    }

    public void testParseVariousTypes() {
        String data = "~01001~^~0100~^~Butter, salted~^~BUTTER,WITH SALT~^~~^~~^~Y~^~~^0^~~^6.38^4.27^8.79^3.87";

        parse(data);

        assertEquals(14, getSize());
        assertEquals("01001", getString(0));
        assertEquals("0100", getString(1));
        assertEquals("Butter, salted", getString(2));
        assertEquals("BUTTER,WITH SALT", getString(3));
        assertEquals(null, getString(4));
        assertEquals(null, getString(5));
        assertBooleanEquals(true, getBoolean(6));
        assertEquals(null, getString(7));
        assertIntegerEquals(0, getInteger(8));
        assertEquals(null, getString(9));
        assertEquals(6.38, getDouble(10));
        assertEquals(4.27, getDouble(11));
        assertEquals(8.79, getDouble(12));
        assertEquals(3.87, getDouble(13));
    }

    public void testParseDate() {
        String data = "03/2014^10/2015";

        parse(data);

        assertEquals(2, getSize());
        assertEquals(3, getDate(0).getMonthOfYear());
        assertEquals(2014, getDate(0).getYear());
        assertEquals(10, getDate(1).getMonthOfYear());
        assertEquals(2015, getDate(1).getYear());
    }

    private void parse(String data) {
        asciiLineParser.parse(data);
    }

    private int getSize() {
        return asciiLineParser.getSize();
    }

    private Integer getInteger(int position) {
        return asciiLineParser.getInt(position);
    }

    private Double getDouble(int position) {
        return asciiLineParser.getDouble(position);
    }

    private String getString(int position) {
        return asciiLineParser.getString(position);
    }

    private Boolean getBoolean(int position) {
        return asciiLineParser.getBoolean(position);
    }

    private LocalDate getDate(int position) {
        return asciiLineParser.getDate(position);
    }

}
