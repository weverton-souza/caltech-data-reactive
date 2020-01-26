package org.caltech.data.reactive.abstracts;

import org.caltech.data.reactive.generics.PageableResponse;
import org.caltech.data.reactive.generics.RegularResponse;
import org.caltech.data.reactive.interfaces.IRepository;
import org.caltech.data.reactive.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Weverton Souza.
 * Created on 25/01/2020
 */
@SuppressWarnings("ALL")
public abstract class AbstractService<DOMAIN extends AbstractDomain, KEY extends Serializable>
        implements IService<DOMAIN, KEY> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected IRepository repository;

    protected AbstractService(final IRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<RegularResponse<DOMAIN>> saveOrUpdate(DOMAIN domain) {
        if (null == domain.id) {
            domain.id = UUID.randomUUID().toString();
        }
        return this.repository.save(domain);
    }

    @Override
    public Mono<RegularResponse<DOMAIN>> findById(KEY id) {
        return this.repository.findById(id);
    }

    @Override
    public Mono<PageableResponse<DOMAIN>> findAll(Pageable page) {
        return this.repository.findAllPaged(page)
                .collectList()
                .flatMap(resources -> new PageableResponse<DOMAIN>()
                .Builder()
                        .content(resources)
                        .pageNumber(page.getPageNumber())
                        .pageSize(page.getPageSize())
                        .totalElements(page.getPageNumber() * page.getPageSize())
                        .Description(HttpStatus.OK.getReasonPhrase())
                        .code(HttpStatus.OK.value())
                        .status(HttpStatus.OK)
                .build());
    }

    @Override
    public void delete(KEY id) {
        Mono optionalResource = this.repository.findById(id);
        optionalResource.subscribe(this.repository::delete);
    }
}
