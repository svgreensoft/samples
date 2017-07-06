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
@Table(name = "skill")
public class Skill extends BaseEntity<Long> {
    
    private static final long serialVersionUID = 1L;

    private String name;
    
    private List<HeroSkill> skills = new ArrayList<>();

    public Skill() {
    }
    
    public Skill(String skillName) {
        this.name = skillName;
    }

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<HeroSkill> getOwners() {
        return skills;
    }

    @Column(name = "name", length = 255, nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwners(List<HeroSkill> skills) {
        this.skills = skills;
    }

    
}
