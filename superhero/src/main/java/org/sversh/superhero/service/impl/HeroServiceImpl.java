package org.sversh.superhero.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sversh.superhero.data.dao.HeroDao;
import org.sversh.superhero.data.model.Superhero;
import org.sversh.superhero.service.api.HeroService;
import org.sversh.superhero.utils.JsonUtils;
import org.sversh.superhero.web.presentation.ErrorResult;
import org.sversh.superhero.web.presentation.HeroView;
import org.sversh.superhero.web.presentation.SuccessfulResult;
import org.sversh.superhero.web.presentation.api.Transformer;

/**
 * 
 * @author Sergey Vershinin
 *
 */
@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroDao heroDao;
    
    @Autowired
    private Transformer transformer;


    @Transactional
    @Override
    public String create(String json) throws ParseException {
        HeroView heroView = JsonUtils.deSerialize(json, HeroView.class);
        Superhero hero = transformer.fromView(heroView);
        heroDao.save(hero);
        SuccessfulResult result = new SuccessfulResult(hero);
        return JsonUtils.serialize(result);
    }

    @Transactional
    @Override
    public String getByPseudonym(String pseudonym) {
        Superhero hero = heroDao.findByPseudonym(pseudonym);
        HeroView heroView = transformer.toView(hero);
        return JsonUtils.serialize(heroView);
    }

    @Transactional
    @Override
    public String getAll() {
        List<Superhero> heros = heroDao.findAll();
        @SuppressWarnings("unchecked")
        List<HeroView> heroViews 
            = (List<HeroView>) heros.stream().map(h -> transformer.toView(h));
        return JsonUtils.serialize(heroViews);
    }

    @Override
    public String exception(Exception ex) {
        ErrorResult error = new ErrorResult(ex);
        return JsonUtils.serialize(error);
    }

}
