package com.lsurvila.sample.espressoandmockitosample.data;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Parses values from ASCII file line in NSDA format. All fields are separated by carets (^)
 * and text fields are surrounded by tildes (~). A double caret (^^) or two carets and
 * two tildes (~~) appear when a field is null or blank. Boolean values are represented
 * as string "Y" for true and "N" for false. Dates as non string (no tildes) in US format
 * as "MM/yyyy".
 */
public class AsciiLineParser {

    private static final char VALUE_SEPARATOR = '^';
    private static final String VALUE_STRING_MARKER = "~";
    private static final String VALUE_BOOLEAN_TRUE = "Y";
    private static final String VALUE_BOOLEAN_FALSE = "N";

    private static final int EMPTY_INTEGER = -1;
    private static final double EMPTY_DOUBLE = -1.0;

    private String[] values;

    public void parse(String data) {
        values = data.split("\\" + VALUE_SEPARATOR, -1);
    }

    public int getSize() {
        return values.length;
    }

    public int getInt(int position) {
        if (!isEmpty(position)) {
            return Integer.valueOf(values[position]);
        }
        return EMPTY_INTEGER;
    }

    public double getDouble(int position) {
        if (!isEmpty(position)) {
            return Double.valueOf(values[position]);
        }
        return EMPTY_DOUBLE;
    }

    public String getString(int position) {
        if (!isEmpty(position) && isValidString(position)) {
            return values[position].substring(1, values[position].length() - 1);
        }
        return null;
    }

    public boolean getBoolean(int position) {
        String string = getString(position);
        if (string != null) {
            if (string.equals(VALUE_BOOLEAN_TRUE)) {
                return true;
            } else if (string.equals(VALUE_BOOLEAN_FALSE)) {
                return false;
            }
        }
        throw new NumberFormatException("Value is not a valid boolean");
    }

    public LocalDate getDate(int position) {
        if (!isEmpty(position)) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/yyyy");
            return formatter.parseLocalDate(values[position]);
        }
        return null;
    }

    private boolean isEmpty(int position) {
        return values[position].isEmpty();
    }

    private boolean isValidString(int position) {
        String string = values[position];
        return string.length() > 2 && string.startsWith(VALUE_STRING_MARKER) && string.endsWith(VALUE_STRING_MARKER);
    }

}
