package com.example.blogsearch.repository;

import com.example.blogsearch.entity.KeywordCount;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface KeywordCountRepository extends JpaRepository<KeywordCount, String> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select keywordCount from KeywordCount keywordCount where keywordCount.keyword = :keyword")
    Optional<KeywordCount> findByKeywordForUpdate(@Param("keyword") String keyword);

    List<KeywordCount> findTop10ByOrderByCountDesc();
}