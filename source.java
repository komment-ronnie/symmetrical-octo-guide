package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * is a data structure that encapsulates information about a page of results from a
 * larger dataset. It provides the current page number, page limit, total pages, and
 * total elements for the page. This class is useful for pagination in Spring Data
 * applications, allowing for efficient navigation between pages and management of
 * large datasets.
 */
@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PageInfo {
  private final int currentPage;
  private final int pageLimit;
  private final int totalPages;
  private final long totalElements;
    /**
     * generates a `PageInfo` object containing information about the number of pages,
     * page size, total pages, and total elements of a given `Pageable` and `Page`.
     * 
     * @param pageable page number and size for which the total pages and elements are calculated.
     * 
     * 	- `getPageNumber()` returns the page number of the result set.
     * 	- `getPageSize()` returns the number of elements in each page of the result set.
     * 	- `getTotalPages()` returns the total number of pages in the result set.
     * 	- `getTotalElements()` returns the total number of elements in the result set.
     * 
     * @param page current page of data being processed, providing the page number and
     * total elements for calculation of the pagination metadata.
     * 
     * 	- `pageable`: The Pageable object containing information about the pagination.
     * 	- `page`: The Page object representing the current page being processed.
     * 	- `pageNumber`: The number of the current page.
     * 	- `pageSize`: The size of each page.
     * 	- `totalPages`: The total number of pages in the dataset.
     * 	- `totalElements`: The total number of elements in the dataset.
     * 
     * @returns a `PageInfo` object containing information about the page number, size,
     * total pages, and total elements of the given `Pageable` and `Page`.
     * 
     * 	- The first argument is `pageable`, which represents the pagination settings for
     * the current page of data.
     * 	- The second argument is `page`, which represents the specific page of data being
     * processed.
     * 	- The return value is a `PageInfo` object, which encapsulates various properties
     * related to the pagination and content of the page. These properties include the
     * page number, page size, total pages, and total elements.
     */
    public static PageInfo of(Pageable pageable, Page<?> page) {
    return new PageInfo(
        pageable.getPageNumber(),
        pageable.getPageSize(),
        page.getTotalPages(),
        page.getTotalElements()
    );
  }
}
