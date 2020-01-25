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

    public PageableResponse() { }

    public Builder<CONTENT> Builder() {
        return new Builder<>();
    }

    public static final class Builder<CONTENT> {
        private List<CONTENT> content;
        private Integer code;
        private HttpStatus status;
        private String description;

        private Builder() {}

        public Builder<CONTENT> content(Object content) {
            this.content = (List<CONTENT>) content;
            return this;
        }

        public Builder<CONTENT> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<CONTENT> status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder<CONTENT> Description(String Description) {
            this.description = Description;
            return this;
        }

        public Mono<PageableResponse<CONTENT>> build() {
            PageableResponse<CONTENT> pageableResponse = new PageableResponse<>();
            pageableResponse.content = (content);
            pageableResponse.code = (code);
            pageableResponse.status = (status);
            pageableResponse.description = (description);
            return Mono.just(pageableResponse);
        }
    }
}
