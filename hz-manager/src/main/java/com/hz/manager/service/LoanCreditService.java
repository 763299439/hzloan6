package com.hz.manager.service;

import com.hz.manager.dto.LoanCreditDto;
import com.hz.manager.response.CreditResult;

public interface LoanCreditService {

    CreditResult getCreditList(LoanCreditDto loanCreditDto,Integer pageNum, Integer pageSize);
}
