package com.example.blogsearch.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SortType {

    ACCURACY("accuracy", "정확도순"),
    RECENCY("recency", "최신순"),
    ;

    private final String value;
    private final String description;

    public static SortType from(String value) {
        return Arrays.stream(SortType.values())
                .filter(sortType -> sortType.getValue().equals(value))
                .findAny()
                .get();
    }

    public static class SortTypeConverter implements Converter<String, SortType> {
        @Override
        public SortType convert(String value) {
            return SortType.from(value);
        }
    }
}
