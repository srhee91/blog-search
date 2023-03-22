package com.example.blogsearch.service;

import com.example.blogsearch.apiclient.naver.NaverFeignClient;
import com.example.blogsearch.apiclient.naver.dto.NaverSearchBlogResponseDto;
import com.example.blogsearch.apiclient.naver.dto.NaverSortType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverSearchService {

    @Value("${naver.api.client.id}")
    private String naverApiClientId;

    @Value("${naver.api.client.secret}")
    private String naverApiClientSecret;

    private final NaverFeignClient naverFeignClient;

    public NaverSearchBlogResponseDto searchBlog(
            final String keyword,
            final NaverSortType sort,
            final int page,
            final int size
    ) {
        return naverFeignClient.searchBlog(
                naverApiClientId,
                naverApiClientSecret,
                keyword,
                sort.getValue(),
                page,
                size
        );
    }
}
