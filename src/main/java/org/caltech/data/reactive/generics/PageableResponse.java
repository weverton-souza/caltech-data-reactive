package org.caltech.data.reactive.generics;

import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Weverton Souza.
 * Created on 25/01/2020
 */
public class PageableResponse<CONTENT> extends Response<List<CONTENT>> {
    public static final String FIRST_PAGE_NUM = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalElements;

    public PageableResponse() { }

    public int getPageNumber() {
        return pageNumber;
    }

    public PageableResponse<CONTENT> setPageNumber(final Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageableResponse<CONTENT> setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public PageableResponse<CONTENT> setTotalElements(final Integer totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public Builder<CONTENT> Builder() {
        return new Builder<>();
    }

    public static final class Builder<CONTENT> {
        private List<CONTENT> content;
        private Integer code;
        private HttpStatus status;
        private String description;
        private Integer pageNumber;
        private Integer pageSize;
        private Integer totalElements;

        public Builder<CONTENT> content(final Object content) {
            this.content = (List<CONTENT>) content;
            return this;
        }

        public Builder<CONTENT> code(final Integer code) {
            this.code = code;
            return this;
        }

        public Builder<CONTENT> status(final HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder<CONTENT> Description(final String Description) {
            this.description = Description;
            return this;
        }

        public Builder<CONTENT> pageNumber(final Integer pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public Builder<CONTENT> pageSize(final Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder<CONTENT> totalElements(final Integer totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public Mono<PageableResponse<CONTENT>> build() {
            PageableResponse<CONTENT> pageableResponse = new PageableResponse<>();
            pageableResponse.content = content;
            pageableResponse.code = code;
            pageableResponse.status = status;
            pageableResponse.description = description;
            pageableResponse.pageNumber = pageNumber;
            pageableResponse.pageSize = pageSize;
            pageableResponse.totalElements = totalElements;
            return Mono.just(pageableResponse);
        }
    }
}
