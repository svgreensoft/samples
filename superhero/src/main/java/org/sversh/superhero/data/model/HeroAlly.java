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
@Table(name = "hero_ally")
public class HeroAlly implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "hero")
    private Superhero hero;

    @Id
    @ManyToOne
    @JoinColumn(name = "ally")
    private Ally ally;
    

    public HeroAlly() {
    }

    public HeroAlly(Superhero hero, Ally ally) {
        this.hero = hero;
        this.ally = ally;
    }

    public Superhero getHero() {
        return hero;
    }

    public void setHero(Superhero hero) {
        this.hero = hero;
    }

    public Ally getAlly() {
        return ally;
    }

    public void setAlly(Ally ally) {
        this.ally = ally;
    }



}
