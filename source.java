package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * generates a `PageInfo` object that contains information about a given pageable and
     * its corresponding page, such as the page number, page size, total pages, and total
     * elements.
     * 
     * @param pageable pageable interface, which provides a way to retrieve and manipulate
     * pages of data.
     * 
     * @param page current page being processed, providing information on its number,
     * size, and the total number of pages and elements in the result set.
     * 
     * @returns a `PageInfo` object containing information about the specified page of elements.
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
