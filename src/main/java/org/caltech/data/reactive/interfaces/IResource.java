package org.caltech.data.reactive.interfaces;

import org.caltech.data.reactive.abstracts.AbstractDomain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public interface IResource<DOMAIN extends AbstractDomain, K extends Serializable> {
        Mono<DOMAIN> save(final DOMAIN resource);
        Mono<DOMAIN> update(final DOMAIN resource);
        Mono<DOMAIN> findById(final K id);
        Flux<DOMAIN> findAll(final int page, final int size);
        void delete(K id);
}
