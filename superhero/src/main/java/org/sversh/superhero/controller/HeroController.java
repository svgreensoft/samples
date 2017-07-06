package org.sversh.superhero.controller;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sversh.superhero.service.api.HeroService;


/**
 * 
 * @author Sergey Vershinin
 *
 */
@Controller
public class HeroController {
    
    @Autowired
    private HeroService heroService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/get/{pseudonym}",
            produces = {"application/json"})
    @ResponseBody
    public String getHero(@PathVariable String pseudonym) throws Exception {
        return heroService.getByPseudonym(pseudonym);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/getall",
            produces = {"application/json"})
    @ResponseBody
    public String getAllHeros() throws Exception {
        return heroService.getAll();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/create",
            produces = {"application/json"})
    @ResponseBody
    public String create(HttpServletRequest req) throws Exception {
        InputStream is = req.getInputStream();
        String body = IOUtils.toString(is, StandardCharsets.UTF_8.name());
        return heroService.create(body);
    }
    
    @ExceptionHandler
    @ResponseBody
    public String handleException(HttpServletResponse resp, Exception ex) {
        resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return heroService.exception(ex);
    }



}
