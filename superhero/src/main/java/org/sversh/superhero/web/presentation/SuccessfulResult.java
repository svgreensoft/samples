package org.sversh.superhero.web.presentation;

import java.io.Serializable;

import org.sversh.superhero.data.model.Superhero;

/**
 * 
 * @author Sergey Vershinin
 *
 */
public class SuccessfulResult implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String pseudonym;
    
    public SuccessfulResult() {
     }
    
    public SuccessfulResult(Superhero hero) {
        pseudonym = hero.getPseudonym();
    }
    public String getPseudonym() {
        return pseudonym;
    }
    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

}
