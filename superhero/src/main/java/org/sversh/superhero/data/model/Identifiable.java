package org.sversh.superhero.data.model;

import java.io.Serializable;

/**
 * 
 * @author Sergey Vershinin
 *
 */
public interface Identifiable<PK> extends Serializable {
    PK getId();

    boolean isNew();
}