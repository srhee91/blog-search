package com.example.blogsearch.apiclient.kakao;

import com.example.blogsearch.apiclient.kakao.dto.KakaoSearchBlogResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakao-open-api", url = "https://dapi.kakao.com")
public interface KakaoFeignClient {
    @GetMapping("/v2/search/blog")
    KakaoSearchBlogResponseDto searchBlog(
            @RequestHeader("Authorization") String apiKey,
            @RequestParam String query,
            @RequestParam String sort,
            @RequestParam int page,
            @RequestParam int size
    );
}
