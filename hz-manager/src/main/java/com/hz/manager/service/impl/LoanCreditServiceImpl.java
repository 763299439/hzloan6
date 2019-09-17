package com.hz.manager.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hz.manager.dao.BaseAdminCreditMapper;
import com.hz.manager.dto.LoanCreditDto;
import com.hz.manager.pojo.BaseAdminCredit;
import com.hz.manager.response.CreditResult;
import com.hz.manager.service.LoanCreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanCreditServiceImpl implements LoanCreditService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseAdminCreditMapper baseAdminCreditMapper;

    @Override
    public CreditResult getCreditList(LoanCreditDto loanCreditDto, Integer pageNum, Integer pageSize) {

        CreditResult creditResult = new CreditResult();
        List<BaseAdminCredit> baseAdminLoan = baseAdminCreditMapper.getCreditList(loanCreditDto);

        PageHelper.startPage(pageNum, pageSize);

        if (baseAdminLoan.size()!= 0){
            PageInfo<BaseAdminCredit> pageInfo = new PageInfo<>(baseAdminLoan);
            creditResult.setList(baseAdminLoan);
            creditResult.setTotals((int) pageInfo.getTotal());
        }
        return creditResult;
    }
}
