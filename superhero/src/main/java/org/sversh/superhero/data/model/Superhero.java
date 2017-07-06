package org.sversh.superhero.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Sergey Vershinin
 *
 */
@Entity
@Table(name = "superhero")
@NamedQueries({
    @NamedQuery(name = "findAllHeros",
        query = "select o from Superhero o"),
    @NamedQuery(name = "findByPseudonym",
        query = "select o from Superhero o where o.pseudonym = :pseudonym")
})
public class Superhero extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;
    
    private String pseudonym;
    private String name;
    private String publisher;
    private Date startDate;
    private List<HeroSkill> skills = new ArrayList<>();
    private List<HeroAlly> allies = new ArrayList<>();
    
    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<HeroSkill> getSkills() {
        return skills;
    }
    
    public void addSkill(Skill skill) {
        HeroSkill heroSkill = new HeroSkill(this, skill);
        skills.add(heroSkill);
        skill.getOwners().add(heroSkill);
    }

    public void removeSkill(Skill skill) {
        HeroSkill heroSkill = new HeroSkill(this, skill);
        skill.getOwners().remove(heroSkill);
        skills.remove(heroSkill);
        heroSkill.setSkill(null );
        heroSkill.setHero(null);
    }

    public void addAlly(Ally ally) {
        HeroAlly heroAlly = new HeroAlly(this, ally);
        allies.add(heroAlly);
        ally.getOwners().add(heroAlly);
    }

    public void removeAlly(Ally ally) {
        HeroAlly heroAlly = new HeroAlly(this, ally);
        ally.getOwners().remove(heroAlly);
        allies.remove(heroAlly);
        heroAlly.setAlly(null );
        heroAlly.setHero(null);
    }

    
    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<HeroAlly> getAllies() {
        return allies;
    }
    
    @Column(name = "pseudonym", nullable = false, unique = true, length = 255)
    public String getPseudonym() {
        return pseudonym;
    }
    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "publisher", nullable = false, length = 255)
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    @Column(name = "startDate", nullable = false)
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date dateOfFirstAppearance) {
        this.startDate = dateOfFirstAppearance;
    }

    public void setSkills(List<HeroSkill> skills) {
        this.skills = skills;
    }

    public void setAllies(List<HeroAlly> allies) {
        this.allies = allies;
    }
    

}
