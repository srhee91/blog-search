package com.example.blogsearch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "keyword_count", indexes = {
        @Index(name = "idx_keywordcount_keyword_unq", columnList = "keyword", unique = true),
        @Index(name = "idx_keywordcount_count", columnList = "count")
})
public class KeywordCount {
    @Id
    @Column(name = "keyword", nullable = false)
    private String keyword;

    @Setter
    @Column(nullable = false)
    private Long count;

    public KeywordCount(String keyword) {
        this.keyword = keyword;
        this.count = 0L;
    }
}