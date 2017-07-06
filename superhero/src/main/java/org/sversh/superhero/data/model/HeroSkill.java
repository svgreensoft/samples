package org.sversh.superhero.data.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Sergey Vershinin</a>
 *
 */
@Entity
@Table(name = "hero_skill")
public class HeroSkill implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "hero")
    private Superhero hero;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill")
    private Skill skill;

    public HeroSkill() {
    }

    public HeroSkill(Superhero hero, Skill skill) {
        this.hero = hero;
        this.skill = skill;
    }

    public Superhero getHero() {
        return hero;
    }

    public void setHero(Superhero hero) {
        this.hero = hero;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }


}
