package org.sversh.test.wildfly.people.store.api;

import org.sversh.test.wildfly.people.model.Person;

/**
 * 
 * @author Sergey Vershinin 
 * @since Jun 17, 2015
 *
 */
public interface WpStore {

    void save(Person person);
    
    boolean exist(Person person);

}
