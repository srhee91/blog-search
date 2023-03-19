# blog-search

## Requirements

### 기능요구사항

- Open API를 이용해 블로그 검색 서비스를 개발한다.
  - 카카오 API를 활용한다. (https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-blog)
  - fallback으로 네이버 API를 활용한다. (https://developers.naver.com/docs/serviceapi/search/blog/blog.md)
  - 검색 결과는 정확도 or 최신 순으로 검색할 수 있다.
  - 검색 결과는 pagination 형태로 제공한다.
- 검색 내역을 기록하여 인기 검색어 TOP10을 조회할 수 있다.