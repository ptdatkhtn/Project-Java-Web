package org.hcmus.edu.spring.ui.utils.converters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.vaadin.flow.templatemodel.ModelEncoder;

public class LocalTimeConverter implements ModelEncoder<LocalTime, String> {

    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String encode(LocalTime value) {
        return value.format(timeFormatter);
    }

    @Override
    public LocalTime decode(String value) {
        return LocalTime.parse(value, timeFormatter);
    }

    public LocalTime decode(String value, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalTime.parse(value, formatter);
    }
}
