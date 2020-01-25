package org.caltech.data.reactive.abstracts;

import org.caltech.data.reactive.generics.PageableResponse;
import org.caltech.data.reactive.interfaces.IResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author Weverton Souza.
 * Created on 25/01/2020
 */
public abstract class AbstractResource<DOMAIN extends AbstractDomain, KEY extends Serializable>
        implements IResource<DOMAIN, KEY> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected final AbstractService<DOMAIN, KEY> service;

    protected AbstractResource(AbstractService<DOMAIN, KEY> abstractService) {
        this.service = abstractService;
    }

    @Override
    @PostMapping
    public Mono<DOMAIN> save(@Valid @RequestBody DOMAIN resource) {
        return this.service.saveOrUpdate(resource);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<DOMAIN> update(@Valid @RequestBody DOMAIN resource) {
        return this.service.saveOrUpdate(resource);
    }

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DOMAIN> findById(@PathVariable KEY id) {
        return this.service.findById(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<DOMAIN> findAll(
            @RequestParam(name = "page", defaultValue = PageableResponse.FIRST_PAGE_NUM) final int page,
            @RequestParam(name = "size", defaultValue = PageableResponse.DEFAULT_PAGE_SIZE) final int size
    ) {
        return service.findAll(PageRequest.of(page, size));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable KEY id) {
        this.service.delete(id);
    }
}
