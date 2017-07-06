package org.sversh.superhero.service.api;

import java.text.ParseException;

/**
 * 
 * @author Sergey Vershinin
 *
 */
public interface HeroService {

    String create(String json) throws ParseException;
    
    String getByPseudonym(String pseudonym);
    
    String getAll();

    String exception(Exception ex);

}
