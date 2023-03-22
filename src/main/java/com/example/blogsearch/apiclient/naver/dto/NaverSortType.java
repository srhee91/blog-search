package com.example.blogsearch.apiclient.naver.dto;

import com.example.blogsearch.controller.dto.SortType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum NaverSortType {

    ACCURACY("sim", "정확도순"),
    RECENCY("date", "최신순"),
    ;

    private final String value;
    private final String description;

    public static NaverSortType fromSortType(SortType sort) {
        return Arrays.stream(NaverSortType.values())
                .filter(sortType -> sortType.name().equals(sort.name()))
                .findAny()
                .get();
    }
}
