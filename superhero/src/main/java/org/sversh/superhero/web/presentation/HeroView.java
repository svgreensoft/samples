package org.sversh.superhero.web.presentation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.sversh.superhero.data.model.HeroAlly;
import org.sversh.superhero.data.model.HeroSkill;

/**
 * 
 * @author <a >Sergey Vershinin</a>
 * @since Jun 11, 2016
 *
 */
public class HeroView implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String pseudonym;
    private String name;
    private String publisher;
    private String startDate;
    private List<String> skills;
    private List<String> allies;
    
    public String getPseudonym() {
        return pseudonym;
    }
    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public List<String> getSkills() {
        return skills;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
    public List<String> getAllies() {
        return allies;
    }
    public void setAllies(List<String> allies) {
        this.allies = allies;
    }


}
