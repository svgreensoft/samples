package org.sversh.hw.service.api;

import java.util.List;

import org.sversh.hw.data.model.LoanRequest;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
public interface EntityService {

    void save(LoanRequest loanRequest);

    int countAllLoansForPersonAndIpForDay(LoanRequest loanRequest);

}
