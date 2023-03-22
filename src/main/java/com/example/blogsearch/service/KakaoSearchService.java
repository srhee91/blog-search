package com.example.blogsearch.service;

import com.example.blogsearch.apiclient.kakao.KakaoFeignClient;
import com.example.blogsearch.apiclient.kakao.dto.KakaoSearchBlogResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoSearchService {

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    private final KakaoFeignClient kakaoFeignClient;

    public KakaoSearchBlogResponseDto searchBlog(
            String keyword,
            String sort,
            int page,
            int size
    ) {
        return kakaoFeignClient.searchBlog(
                "KakaoAK " + kakaoApiKey,
                keyword,
                sort,
                page,
                size
        );
    }
}
