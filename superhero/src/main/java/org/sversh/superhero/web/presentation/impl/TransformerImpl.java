package org.sversh.superhero.web.presentation.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.sversh.superhero.data.model.Ally;
import org.sversh.superhero.data.model.Skill;
import org.sversh.superhero.data.model.Superhero;
import org.sversh.superhero.web.presentation.HeroView;
import org.sversh.superhero.web.presentation.SuccessfulResult;
import org.sversh.superhero.web.presentation.api.Transformer;

/**
 * 
 * @author Sergey Vershinin</a>
 *
 */
@Service
public class TransformerImpl implements Transformer {

    @Override
    public Superhero fromView(HeroView heroView) throws ParseException {
        Superhero hero = new Superhero();
        hero.setName(heroView.getName());
        hero.setPseudonym(heroView.getPseudonym());
        hero.setPublisher(heroView.getPublisher());
        hero.setStartDate(convert(heroView.getStartDate()));
        List<String> skills = heroView.getSkills();
        if (skills != null) {
            populateSkills(hero, skills);
        }
        List<String> allies = heroView.getAllies();
        if (allies != null) {
            populateAllies(hero, allies);
        }
        return hero ;
    }


    private void populateAllies(Superhero hero, List<String> allies) {
        for (String allyName : allies) {
            Ally ally = new Ally(allyName);
            hero.addAlly(ally );
        }
    }

    private void populateSkills(Superhero hero, List<String> skills) {
        for (String skillName : skills) {
            Skill skill = new Skill(skillName);
            hero.addSkill(skill );
        }
    }
    
    @Override
    public HeroView toView(Superhero hero) {
        HeroView result = new HeroView();
        result.setName(hero.getName());
        result.setPseudonym(hero.getPseudonym());
        result.setPublisher(hero.getPublisher());
        result.setStartDate(convert(hero.getStartDate()));
        return result ;
    }

    // Date of first appearance (in the format YYYY-MM-DD)
    private Date convert(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD"); 
        Date result = df.parse(date);
        return result;
    }

    private String convert(Date date) {
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD"); 
        String result = df.format(date);
        return result;
    }

}
