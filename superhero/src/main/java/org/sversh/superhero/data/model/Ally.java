package org.sversh.superhero.data.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Sergey Vershinin
 *
 */
@Entity
@Table(name = "ally")
public class Ally extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;
    
    private String allyName;

    private List<HeroAlly> allies = new ArrayList<>();

    public Ally() {
    }
    
    public Ally(String name) {
        this.allyName = name;
    }

    @Column(name = "name", length = 255, nullable = false, unique = true)
    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    @OneToMany(mappedBy = "ally", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<HeroAlly> getOwners() {
        return allies;
    }

    public void setOwners(List<HeroAlly> allies) {
        this.allies = allies;
    }

}
