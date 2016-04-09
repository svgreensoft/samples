package org.sversh.hw.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sversh.hw.data.model.LoanRequest;
import org.sversh.hw.service.api.Const;
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

    @Autowired
    private EntityService entityService;

    @Override
    public boolean isAllowed(LoanRequest loanRequest) {
        
        boolean isBadTimeAndMax = isBadTimeAndMax(loanRequest);
        boolean isMaxCountForSingleIp = isMaxCountForSingleIp(loanRequest);
        return !isBadTimeAndMax && !isMaxCountForSingleIp 
                && (loanRequest.getAmount() <= Const.MAX_AMOUNT);
    }

    private boolean isMaxCountForSingleIp(LoanRequest loanRequest) {
        long count = entityService.countAllLoansForPersonAndIpForDay(loanRequest);
        return count > Const.MAX_COUNT;
    }

    boolean isBadTimeAndMax(LoanRequest lr) {
        Calendar c = Calendar.getInstance();
        c.setTime(lr.getDate());
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        return (timeOfDay >= 0 && timeOfDay < 6) && lr.getAmount() >= Const.MAX_AMOUNT;
    }

}
