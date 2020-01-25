package org.caltech.data.reactive.abstracts;

import org.caltech.data.reactive.interfaces.IRepository;
import org.caltech.data.reactive.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Weverton Souza.
 * Created on 25/01/2020
 */
@SuppressWarnings("ALL")
public abstract class AbstractService<DOMAIN extends AbstractDomain, KEY extends Serializable> implements IService<DOMAIN, KEY> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected IRepository repository;

    protected AbstractService(final IRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<DOMAIN> saveOrUpdate(DOMAIN domain) {
        if (null == domain.id) {
            domain.id = UUID.randomUUID().toString();
        }
        return this.repository.save(domain);
    }

    @Override
    public Mono<DOMAIN> findById(KEY id) {
        return this.repository.findById(id);
    }

    @Override
    public Flux<DOMAIN> findAll(Pageable page) {
        return this.repository.findAllPaged(page);
    }

    @Override
    public void delete(KEY id) {
        Mono optionalResource = this.repository.findById(id);
        optionalResource.subscribe(this.repository::delete);
    }
}
