package org.caltech.data.reactive.interfaces;

import org.caltech.data.reactive.abstracts.AbstractDomain;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.io.Serializable;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
@Repository
public interface IRepository<DOMAIN extends AbstractDomain, KEY extends Serializable>
        extends ReactiveMongoRepository<DOMAIN, KEY> {

    @Query("{ id: { $exists: true }}")
    Flux<DOMAIN> findAllPaged(final Pageable page);
}
