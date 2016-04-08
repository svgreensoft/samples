package org.sversh.hw.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sversh.hw.data.dao.JpaDao;
import org.sversh.hw.data.model.LoanRequest;
import org.sversh.hw.service.api.EntityService;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Service
public class EntityServiceImpl implements EntityService {
    
    private static final long DAY = 24L*60L*60L*1000L;
    @Autowired
    private JpaDao dao;

    @Override
    @Transactional
    public void save(LoanRequest loanRequest) {
        dao.save(loanRequest);
    }

    @Override
    @Transactional
    public long countAllLoansForPersonAndIpForDay(LoanRequest lr) {
        return dao.findAllLoansForPersonAndIp(lr.getFirstName(), lr.getLastName(),
                lr.getIp(), new Date(lr.getDate().getTime() - DAY));
    }

    @Override
    @Transactional
    public void update(LoanRequest loanRequest) {
        dao.update(loanRequest);
    }

}
