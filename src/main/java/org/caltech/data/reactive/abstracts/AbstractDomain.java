package org.caltech.data.reactive.abstracts;

import org.caltech.data.reactive.interfaces.IDomain;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Weverton Souza.
 * Created on 25/01/2020
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractDomain implements IDomain {
    protected String id;
    private Date createdDate;
    private Date lastModifiedDate;

    public AbstractDomain() {
        this.createId();
    }

    private void createId() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public IDomain setId(final String id) {
        this.id = id;
        return this;
    };

    @Override
    public String getId() {
        return id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IDomain that = (IDomain) o;
        return Objects.equals(id, that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
