package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * is a data structure used to represent pagination information, including the current
 * page, page limit, total pages, and total elements. The class provides a convenient
 * way to create instances of PageInfo from Pageable objects and their corresponding
 * pages.
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
     * converts a `Pageable` object and a `Page` object into a `PageInfo` object, providing
     * information about the page number, size, total pages, and total elements.
     * 
     * @param pageable pagination state for the page being processed, providing the current
     * page number, page size, total pages, and total elements.
     * 
     * 	- `getPageNumber()` returns the page number of the current page being processed.
     * 	- `getPageSize()` returns the size of each page in the result set.
     * 	- `getTotalPages()` returns the total number of pages in the result set.
     * 	- `getTotalElements()` returns the total number of elements in the result set.
     * 
     * @param page current page being processed, providing information on its position,
     * size, total pages, and total elements in the PageInfo object returned by the function.
     * 
     * 1/ PageNumber - The number of the page being processed.
     * 2/ PageSize - The number of elements in each page.
     * 3/ TotalPages - The total number of pages in the result set.
     * 4/ TotalElements - The total number of elements in the result set.
     * 
     * @returns a `PageInfo` object containing information about the page number, size,
     * total pages, and total elements of a `Pageable` instance.
     * 
     * 	- `pageNumber`: The number of the current page being displayed.
     * 	- `pageSize`: The number of elements in each page of the result set.
     * 	- `totalPages`: The total number of pages in the result set.
     * 	- `totalElements`: The total number of elements in the result set.
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
