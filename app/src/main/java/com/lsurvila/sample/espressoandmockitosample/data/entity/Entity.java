package com.lsurvila.sample.espressoandmockitosample.data.entity;

import com.lsurvila.sample.espressoandmockitosample.data.AsciiLineParser;

import org.joda.time.LocalDate;

public class Entity {

    private AsciiLineParser parser;

    public Entity(String data) {
        parser = new AsciiLineParser();
        parser.parse(data);
    }

    protected Integer getInteger(int position) {
        return parser.getInt(position);
    }

    protected Double getDouble(int position) {
        return parser.getDouble(position);
    }

    protected String getString(int position) {
        return parser.getString(position);
    }

    protected Boolean getBoolean(int position) {
        return parser.getBoolean(position);
    }

    protected LocalDate getDate(int position) {
        return parser.getDate(position);
    }

}
