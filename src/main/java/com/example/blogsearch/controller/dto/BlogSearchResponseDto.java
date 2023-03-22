package com.example.blogsearch.controller.dto;

import com.example.blogsearch.apiclient.kakao.dto.KakaoSearchBlogResponseDto;
import com.example.blogsearch.apiclient.naver.dto.NaverSearchBlogResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BlogSearchResponseDto {
    private int totalCount;
    private List<Document> documents;

    @Getter
    @Builder
    public static class Document {
        private String title;
        private String contents;
        private String url;
        private String blogName;

        public static Document fromKakao(KakaoSearchBlogResponseDto.Document kakao) {
            return Document.builder()
                    .title(kakao.getTitle())
                    .contents(kakao.getContents())
                    .url(kakao.getUrl())
                    .blogName(kakao.getBlogname())
                    .build();
        }

        public static Document fromNaver(NaverSearchBlogResponseDto.Item naver) {
            return Document.builder()
                    .title(naver.getTitle())
                    .contents(naver.getDescription())
                    .url(naver.getLink())
                    .blogName(naver.getBloggername())
                    .build();
        }
    }

    public static BlogSearchResponseDto fromKakao(KakaoSearchBlogResponseDto dto) {
        return BlogSearchResponseDto.builder()
                .totalCount(dto.getMeta().getTotalCount())
                .documents(dto.getDocuments().stream()
                        .map(Document::fromKakao)
                        .toList())
                .build();
    }

    public static BlogSearchResponseDto fromNaver(NaverSearchBlogResponseDto dto) {
        return BlogSearchResponseDto.builder()
                .totalCount(dto.getTotal())
                .documents(dto.getItems().stream()
                        .map(Document::fromNaver)
                        .toList())
                .build();
    }
}
