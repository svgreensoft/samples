package org.sversh.hw.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sversh.hw.data.model.LoanRequest;
import org.sversh.hw.service.api.EntityService;
import org.sversh.hw.service.api.RiskManagementService;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Service
public class RiskManagementServiceImpl implements RiskManagementService {

    private static final int MAX_COUNT = 3;
    private static final Long MAX_AMOUNT = 1000000L;
    @Autowired
    private EntityService entityService;

    @Override
    public boolean isAllowed(LoanRequest loanRequest) {
        
        boolean isBadTimeAndMax = isBadTimeAndMax(loanRequest);
        boolean isMaxCountForSingleIp = isMaxCountForSingleIp(loanRequest);
        return !isBadTimeAndMax && !isMaxCountForSingleIp;
    }

    private boolean isMaxCountForSingleIp(LoanRequest loanRequest) {
        int count = entityService.countAllLoansForPersonAndIpForDay(loanRequest);
        return count > MAX_COUNT;
    }

    private boolean isBadTimeAndMax(LoanRequest lr) {
        Calendar c = Calendar.getInstance();
        c.setTime(lr.getDate());
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        return (timeOfDay >= 0 && timeOfDay < 6) && lr.getAmount() >= MAX_AMOUNT;
    }

}
