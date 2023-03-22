package com.example.blogsearch.apiclient.naver;

import com.example.blogsearch.apiclient.naver.dto.NaverSearchBlogResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "naver-open-api", url = "https://openapi.naver.com")

public interface NaverFeignClient {
    @GetMapping("/v1/search/blog")
    NaverSearchBlogResponseDto searchBlog(
            @RequestHeader("X-Naver-Client-Id") String clientId,
            @RequestHeader("X-Naver-Client-Secret") String clientSecret,
            @RequestParam String query,
            @RequestParam String sort,
            @RequestParam int start,
            @RequestParam int display
    );
}