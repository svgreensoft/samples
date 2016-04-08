package org.sversh.hw.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sversh.hw.data.model.LoanRequest;
import org.sversh.hw.service.api.IpFinder;
import org.sversh.hw.service.api.LoanService;


/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Controller
public class HwController {
    
    @Autowired
    private LoanService loanService;
    
    @Autowired
    private IpFinder ipFinder;
    
    @RequestMapping(method = RequestMethod.GET, value = "/firstname/{firstname}/lastname/{lastname}/amount/{amount}/term/{term}",
            produces = {"application/json"})
    @ResponseBody
    public String getLoan(HttpServletRequest request, HttpServletResponse resp,
                                 @PathVariable String firstname,
                                 @PathVariable String lastname,
                                 @PathVariable String amount,
                                 @PathVariable String term) throws IOException {
        String ip = ipFinder.find(request);
        LoanRequest loanRequest = LoanRequest
                .create(new Date(), ip, firstname, lastname, amount, term);
        String response = loanService.process(loanRequest);
        return response;
    }

}
