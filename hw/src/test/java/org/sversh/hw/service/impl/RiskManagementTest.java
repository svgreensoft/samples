package org.sversh.hw.service.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.sversh.hw.data.model.LoanRequest;
import org.sversh.hw.service.api.Const;
import org.sversh.hw.service.impl.RiskManagementServiceImpl;

/**
 * 
 * @author Sergey Vershinin</a>
 * @since Apr 8, 2015
 *
 */
public class RiskManagementTest {

    @Test
    public void testMorningIsNotAllowed() throws Exception {
        RiskManagementServiceImpl riskAssessment = new RiskManagementServiceImpl();
        LoanRequest lr = new LoanRequest();

        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 1);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        
        lr.setDate(cal.getTime());
        lr.setAmount(Const.MAX_AMOUNT);
        
        boolean isBadTime = riskAssessment.isBadTimeAndMax(lr);
        Assert.assertTrue("Time " + cal.getTime() + " is bad.", 
                isBadTime);
    }
    
    @Test
    public void testMorningIsAllowedIfLessThanMax() throws Exception {
        RiskManagementServiceImpl riskAssessment = new RiskManagementServiceImpl();
        LoanRequest lr = new LoanRequest();

        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 1);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        
        lr.setDate(cal.getTime());
        lr.setAmount(Const.MAX_AMOUNT - 1);
        
        boolean isBadTime = riskAssessment.isBadTimeAndMax(lr);
        Assert.assertTrue("Time " + cal.getTime() + " is good, since max value is not exceed", 
                !isBadTime);
    }


}
