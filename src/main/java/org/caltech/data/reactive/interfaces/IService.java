package org.caltech.data.reactive.interfaces;

import org.caltech.data.reactive.abstracts.AbstractDomain;
import org.caltech.data.reactive.generics.PageableResponse;
import org.caltech.data.reactive.generics.RegularResponse;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

import java.io.Serializable;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public interface IService<DOMAIN extends AbstractDomain, KEY extends Serializable> {
    Mono<RegularResponse<DOMAIN>> saveOrUpdate(final DOMAIN resource);
    Mono<RegularResponse<DOMAIN>> findById(final KEY id);
    Mono<PageableResponse<DOMAIN>> findAll(final Pageable pageable);
    void delete(KEY id);
}
