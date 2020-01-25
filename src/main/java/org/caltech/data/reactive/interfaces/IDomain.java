package org.caltech.data.reactive.interfaces;

import java.io.Serializable;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public interface IDomain extends Serializable {
    Object setId(final String id);
    String getId();
}

