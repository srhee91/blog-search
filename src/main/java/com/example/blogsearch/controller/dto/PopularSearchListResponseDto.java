package com.example.blogsearch.controller.dto;

import com.example.blogsearch.entity.KeywordCount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PopularSearchListResponseDto {
    private List<Search> searchList;

    @Getter
    @Builder
    public static class Search {
        private String keyword;
        private long count;

        public static Search fromEntity(KeywordCount entity) {
            return Search.builder()
                    .keyword(entity.getKeyword())
                    .count(entity.getCount())
                    .build();
        }
    }
}
