package com.lsurvila.sample.espressoandmockitosample.data;

import junit.framework.TestCase;

public class AsciiLineParserTest extends TestCase {

    private AsciiLineParser asciiLineParser;

    public void setUp() {
        asciiLineParser = new AsciiLineParser();
    }

    public void testParseIntegers() {
        String data = "10^35^31^35^3";
        asciiLineParser.parse(data);
        assertEquals(5, asciiLineParser.getSize());
        assertEquals(10, asciiLineParser.getInt(0));
        assertEquals(35, asciiLineParser.getInt(1));
        assertEquals(31, asciiLineParser.getInt(2));
        assertEquals(35, asciiLineParser.getInt(3));
        assertEquals(3, asciiLineParser.getInt(4));
    }

    public void testParseEmptyInteger() {
        String data = "10^^3^3^53";
        asciiLineParser.parse(data);
        assertEquals(5, asciiLineParser.getSize());
        assertEquals(10, asciiLineParser.getInt(0));
        assertEquals(-1, asciiLineParser.getInt(1));
        assertEquals(3, asciiLineParser.getInt(2));
        assertEquals(3, asciiLineParser.getInt(3));
        assertEquals(53, asciiLineParser.getInt(4));
    }

    public void testParseEmptyIntegerAtBeginning() {
        String data = "^23^34^2^8";
        asciiLineParser.parse(data);
        assertEquals(5, asciiLineParser.getSize());
        assertEquals(-1, asciiLineParser.getInt(0));
        assertEquals(23, asciiLineParser.getInt(1));
        assertEquals(34, asciiLineParser.getInt(2));
        assertEquals(2, asciiLineParser.getInt(3));
        assertEquals(8, asciiLineParser.getInt(4));
    }

    public void testParseEmptyIntegerAtEnd() {
        String data = "23^34^2^8^";
        asciiLineParser.parse(data);
        assertEquals(5, asciiLineParser.getSize());
        assertEquals(23, asciiLineParser.getInt(0));
        assertEquals(34, asciiLineParser.getInt(1));
        assertEquals(2, asciiLineParser.getInt(2));
        assertEquals(8, asciiLineParser.getInt(3));
        assertEquals(-1, asciiLineParser.getInt(4));
    }

    public void testParseDoubles() {
        String data = "13.34^23.23^21.0212^8.33212214";
        asciiLineParser.parse(data);
        assertEquals(4, asciiLineParser.getSize());
        assertEquals(13.34, asciiLineParser.getDouble(0));
        assertEquals(23.23, asciiLineParser.getDouble(1));
        assertEquals(21.0212, asciiLineParser.getDouble(2));
        assertEquals(8.33212214, asciiLineParser.getDouble(3));
    }

    public void testParseEmptyDouble() {
        String data = "34.23^^23.2^34.222";
        asciiLineParser.parse(data);
        assertEquals(4, asciiLineParser.getSize());
        assertEquals(34.23, asciiLineParser.getDouble(0));
        assertEquals(-1.0, asciiLineParser.getDouble(1));
        assertEquals(23.2, asciiLineParser.getDouble(2));
        assertEquals(34.222, asciiLineParser.getDouble(3));
    }

    public void testParseStrings() {
        String data = "~text~^~some another text~^~text text text~";
        asciiLineParser.parse(data);
        assertEquals(3, asciiLineParser.getSize());
        assertEquals("text", asciiLineParser.getString(0));
        assertEquals("some another text", asciiLineParser.getString(1));
        assertEquals("text text text", asciiLineParser.getString(2));
    }

    public void testParseEmptyString() {
        String data = "~text~^~~^~some another text~";
        asciiLineParser.parse(data);
        assertEquals(3, asciiLineParser.getSize());
        assertEquals("text", asciiLineParser.getString(0));
        assertEquals(null, asciiLineParser.getString(1));
        assertEquals("some another text", asciiLineParser.getString(2));
    }

    public void testParseTrueBoolean() {
        String data = "~23~^~Y~^~YY~";
        asciiLineParser.parse(data);
        assertEquals(3, asciiLineParser.getSize());
        assertEquals("23",asciiLineParser.getString(0));
        assertEquals(true, asciiLineParser.getBoolean(1));
        assertEquals("YY", asciiLineParser.getString(2));
    }

    public void testParseFalseBoolean() {
        String data = "~23~^~N~^~NN~";
        asciiLineParser.parse(data);
        assertEquals(3, asciiLineParser.getSize());
        assertEquals("23",asciiLineParser.getString(0));
        assertEquals(false, asciiLineParser.getBoolean(1));
        assertEquals("NN", asciiLineParser.getString(2));
    }

    public void testParseInvalidBoolean() {
        String data = "~23~^~T~^~NN~";
        asciiLineParser.parse(data);
        assertEquals(3, asciiLineParser.getSize());
        assertEquals("23",asciiLineParser.getString(0));
        try {
            assertEquals(true, asciiLineParser.getBoolean(1));
        } catch (NumberFormatException ex) {
            assertEquals("Value is not a valid boolean", ex.getMessage());
        }
        assertEquals("NN", asciiLineParser.getString(2));
    }

    public void testParseVariousTypes() {
        String data = "~01001~^~0100~^~Butter, salted~^~BUTTER,WITH SALT~^~~^~~^~Y~^~~^0^~~^6.38^4.27^8.79^3.87";
        asciiLineParser.parse(data);
        assertEquals(14, asciiLineParser.getSize());
        assertEquals("01001", asciiLineParser.getString(0));
        assertEquals("0100", asciiLineParser.getString(1));
        assertEquals("Butter, salted", asciiLineParser.getString(2));
        assertEquals("BUTTER,WITH SALT", asciiLineParser.getString(3));
        assertEquals(null, asciiLineParser.getString(4));
        assertEquals(null, asciiLineParser.getString(5));
        assertEquals(true, asciiLineParser.getBoolean(6));
        assertEquals(null, asciiLineParser.getString(7));
        assertEquals(0, asciiLineParser.getInt(8));
        assertEquals(null, asciiLineParser.getString(9));
        assertEquals(6.38, asciiLineParser.getDouble(10));
        assertEquals(4.27, asciiLineParser.getDouble(11));
        assertEquals(8.79, asciiLineParser.getDouble(12));
        assertEquals(3.87, asciiLineParser.getDouble(13));
    }

    public void testParseDate() {
        String data = "03/2014^10/2015";
        asciiLineParser.parse(data);
        assertEquals(2, asciiLineParser.getSize());
        assertEquals(3, asciiLineParser.getDate(0).getMonthOfYear());
        assertEquals(2014, asciiLineParser.getDate(0).getYear());
        assertEquals(10, asciiLineParser.getDate(1).getMonthOfYear());
        assertEquals(2015, asciiLineParser.getDate(1).getYear());
    }

}
