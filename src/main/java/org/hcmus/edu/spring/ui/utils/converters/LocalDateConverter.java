package org.hcmus.edu.spring.ui.utils.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.vaadin.flow.templatemodel.ModelEncoder;

public class LocalDateConverter implements ModelEncoder<LocalDate, String> {

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String encode(LocalDate value) {
        return value.format(dateFormatter);
    }

    @Override
    public LocalDate decode(String value) {
        return LocalDate.parse(value, dateFormatter);
    }
}
