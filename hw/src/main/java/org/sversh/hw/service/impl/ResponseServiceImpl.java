package org.sversh.hw.service.impl;

import org.springframework.stereotype.Service;
import org.sversh.hw.data.model.LoanRequest;
import org.sversh.hw.service.api.ResponseService;
import org.sversh.hw.service.web.LoanResponse;
import org.sversh.hw.utils.JsonUtils;

/**
 * 
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Service
public class ResponseServiceImpl implements ResponseService {

    public String allow(LoanRequest loanRequest) {
        LoanResponse loanResp = new LoanResponse();
        populate(loanResp, loanRequest);
        loanResp.setAmountGranted(loanRequest.getAmount());
        loanResp.setTermGranted(loanRequest.getTerm());
        loanResp.setToken(loanRequest.getToken());
        loanResp.setGranted(true);
        String resp = JsonUtils.serialize(loanResp);
        return resp;
    }

    public String reject(LoanRequest loanRequest) {
        LoanResponse loanResp = new LoanResponse();
        populate(loanResp, loanRequest);
        loanResp.setGranted(false);
        String resp = JsonUtils.serialize(loanResp);
        return resp;
    }
    
    private void populate(LoanResponse resp, LoanRequest req) {
        resp.setFirstName(req.getFirstName());
        resp.setLastName(req.getLastName());
    }

}
