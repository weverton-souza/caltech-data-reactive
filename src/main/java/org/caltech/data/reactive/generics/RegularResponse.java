package org.caltech.data.reactive.generics;

import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public class RegularResponse<CONTENT> extends Response<CONTENT> {

    public RegularResponse() {}

    public Builder<?> Builder() {
        return new Builder<CONTENT>();
    }

    public static final class Builder<CONTENT> {
        private CONTENT content;
        private Integer code;
        private HttpStatus status;
        private String description;

        private Builder() {}

        public Builder<?> content(Object content) {
            this.content = (CONTENT) content;
            return this;
        }

        public Builder<?> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<?> status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder<?> Description(String Description) {
            this.description = Description;
            return this;
        }

        public Mono<RegularResponse<CONTENT>> build() {
            RegularResponse<CONTENT> regularResponse = new RegularResponse<>();
            regularResponse.content = (content);
            regularResponse.code = (code);
            regularResponse.status = (status);
            regularResponse.description = (description);
            return Mono.just(regularResponse);
        }

    }
}
