package com.hz.manager.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Data
public class BaseAdminCredit {

    private Integer loanID;

    private String loanName;

    private String loanApplicationDate;

    private String loanPhone;

    private String loanQuota;

    private String loanRepayment;

    private String loanTerm;

    private String loanType;

    private String loanState;

    private String loanFirstTime;

    private String loanFirstPersonnel;


}
