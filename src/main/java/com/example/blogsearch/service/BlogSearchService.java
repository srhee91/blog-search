package com.example.blogsearch.service;

import com.example.blogsearch.apiclient.naver.dto.NaverSortType;
import com.example.blogsearch.controller.dto.BlogSearchResponseDto;
import com.example.blogsearch.controller.dto.PopularSearchListResponseDto;
import com.example.blogsearch.controller.dto.PopularSearchListResponseDto.Search;
import com.example.blogsearch.controller.dto.SortType;
import com.example.blogsearch.entity.KeywordCount;
import com.example.blogsearch.repository.KeywordCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogSearchService {

    private final KakaoSearchService kakaoSearchService;
    private final NaverSearchService naverSearchService;
    private final KeywordCountRepository keywordCountRepository;

    @Transactional
    public BlogSearchResponseDto searchBlog(
            final String keyword,
            final SortType sort,
            final int page,
            final int size
    ) {
        updateKeywordCount(keyword);

        try {
            return BlogSearchResponseDto.fromKakao(
                    kakaoSearchService.searchBlog(
                            keyword,
                            sort.getValue(),
                            page,
                            size
                    )
            );

        } catch (RuntimeException e) {
            return BlogSearchResponseDto.fromNaver(
                    naverSearchService.searchBlog(
                            keyword,
                            NaverSortType.fromSortType(sort),
                            page,
                            size
                    )
            );
        }
    }

    private void updateKeywordCount(String keyword) {
        KeywordCount keywordCount = keywordCountRepository.findByKeywordForUpdate(keyword)
                .orElse(new KeywordCount(keyword));
        keywordCount.setCount(keywordCount.getCount() + 1);
        keywordCountRepository.save(keywordCount);
    }

    public PopularSearchListResponseDto getPopularSearchList() {
        List<Search> searchList = keywordCountRepository.findTop10ByOrderByCountDesc().stream()
                .map(Search::fromEntity)
                .toList();
        return new PopularSearchListResponseDto(searchList);
    }
}
