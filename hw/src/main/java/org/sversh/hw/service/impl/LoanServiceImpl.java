package org.sversh.hw.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sversh.hw.data.model.LoanRequest;
import org.sversh.hw.service.api.EntityService;
import org.sversh.hw.service.api.LoanService;
import org.sversh.hw.service.api.RiskManagementService;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private RiskManagementService riskManagementService;
    
    @Autowired
    private ResponseServiceImpl responseService;

    @Autowired
    private EntityService entityService;
    
    @Override
    public String process(LoanRequest loanRequest) {
        entityService.save(loanRequest);
        boolean isLoanAllowed = riskManagementService.isAllowed(loanRequest);
        String response;
        if (isLoanAllowed) {
            issueLoan(loanRequest);
            response = responseService.allow(loanRequest);
        } else {
            response = responseService.reject(loanRequest);
        }
        return response;
    }

    private void issueLoan(LoanRequest lr) {
        UUID token = UUID.nameUUIDFromBytes((lr.getFirstName() + lr.getLastName()
                + lr.getIp() + lr.getAmount().longValue() + lr.getDate()).getBytes());
        lr.setToken(token);
        entityService.update(lr);
    }

}
