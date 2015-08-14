package org.sversh.test.wildfly.people.store.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Singleton;

import org.sversh.test.wildfly.people.model.Person;


/** * 
 * 
 * Actually not only one person can have the same names and birthday, but 
 * the provided information is limited and does not allow to distinguish 
 * them. So we consider, all people with the same names and birthday as the 
 * same person.
 * 
 * 
 * @author Sergey Vershinin
 * @since Jun 17, 2015
 *
 */
@Singleton
public class WpStoreImpl implements WpStore {

    private Set<Person> people;
    
    
    public WpStoreImpl() {
        people = Collections.synchronizedSet(new HashSet<Person>());
    }
    
    @Override
    public void save(Person person) {
        people.add(person);
    }

    @Override
    public boolean exist(Person person) {
        return people.contains(person);
    }

}
