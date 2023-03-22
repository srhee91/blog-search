package com.example.blogsearch.controller;

import com.example.blogsearch.controller.dto.BlogSearchResponseDto;
import com.example.blogsearch.controller.dto.PopularSearchListResponseDto;
import com.example.blogsearch.controller.dto.SortType;
import com.example.blogsearch.service.BlogSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlogSearchController {

    private final BlogSearchService blogSearchService;

    @GetMapping("/search/blog")
    BlogSearchResponseDto searchBlog(
            @RequestParam(required = true) String keyword,
            @RequestParam(required = false, defaultValue = "accuracy") SortType sort,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return blogSearchService.searchBlog(keyword, sort, page, size);
    }

    @GetMapping("/search/blog/popular")
    PopularSearchListResponseDto getPopularSearchList() {
        return blogSearchService.getPopularSearchList();
    }
}
