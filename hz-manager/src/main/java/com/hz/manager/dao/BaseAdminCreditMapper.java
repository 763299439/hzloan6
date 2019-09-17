package com.hz.manager.dao;


import com.hz.manager.dto.LoanCreditDto;
import com.hz.manager.pojo.BaseAdminCredit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseAdminCreditMapper {

    List<BaseAdminCredit> getCreditList(LoanCreditDto loanCreditDto);
}
