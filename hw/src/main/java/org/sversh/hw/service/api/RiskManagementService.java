package org.sversh.hw.service.api;

import org.sversh.hw.data.model.LoanRequest;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
public interface RiskManagementService {

    boolean isAllowed(LoanRequest loanRequest);

}
