package org.sversh.test.wildfly.people.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.sversh.test.wildfly.people.model.Person;
import org.sversh.test.wildfly.people.store.api.WpStore;

/**
 * 
 * @author Sergey Vershinin 
 * @since Jun 17, 2015
 *
 */
@Stateless
public class WpService {

    @Inject
    private WpStore store;
    
     
    public boolean save(Person person) {
        if (store.exist(person)) {
            return false;
        } else {
            store.save(person);
            return true;
        }
    }
    
}
