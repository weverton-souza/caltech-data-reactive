package org.caltech.data.reactive.generics;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
abstract public class Response<CONTENT> {
    protected CONTENT content;
    protected Integer code;
    protected HttpStatus status;
    protected String description;

    public Response() {}

    public Response(@Nullable final CONTENT content, final Integer code, final HttpStatus status,
                    final String Description) {
        this.content = content;
        this.code = code;
        this.status = status;
        this.description = Description;
    }

    public CONTENT getContent() {
        return content;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status.name();
    }

    public String getDescription() {
        return description;
    }
}
