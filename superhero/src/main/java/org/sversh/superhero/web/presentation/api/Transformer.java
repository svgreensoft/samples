package org.sversh.superhero.web.presentation.api;

import java.text.ParseException;

import org.sversh.superhero.data.model.Superhero;
import org.sversh.superhero.web.presentation.HeroView;
import org.sversh.superhero.web.presentation.SuccessfulResult;

/**
 * 
 * @author Sergey Vershinin</a>
 *
 */
public interface Transformer {

    Superhero fromView(HeroView heroView) throws ParseException;

    HeroView toView(Superhero hero);

}
