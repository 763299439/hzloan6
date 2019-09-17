package com.hz.manager.controller.system;


import com.hz.manager.dto.LoanCreditDto;
import com.hz.manager.response.CreditResult;
import com.hz.manager.response.PageDataResult;
import com.hz.manager.service.LoanCreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 贷前管理
 */
@RequestMapping("/loan")
@Controller
public class LoanCreditController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoanCreditService loanCreditService;

    /**
     * 跳转准入授信管理
     * @return
     */
    @RequestMapping("/creditManage")
    public String loadnCredit(){
        return "/preloan/creditManage";
    }

    /**
     *
     * 功能描述: 分页查询用户列表
     *
     * @param:
     * @return:
     * @auther: youqing
     * @date: 2018/11/21 11:10
     */
    @RequestMapping(value = "/getCreditList", method = RequestMethod.POST)
    @ResponseBody
    public CreditResult getUserList(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize,/*@Valid PageRequest page,*/ LoanCreditDto loanCreditDto) {
        logger.info("pageNum:{},pageSize{},LoanCreditDto:{}",pageNum,pageSize,loanCreditDto);

        CreditResult cr = new CreditResult();
        try {
            if(null == pageNum) {
                pageNum = 1;
            }
            if(null == pageSize) {
                pageSize = 10;
            }
            // 获取用户列表
            cr = loanCreditService.getCreditList(loanCreditDto, pageNum ,pageSize);
            logger.info("用户列表查询=pdr:" + cr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表查询异常！", e);
        }
        return cr;
    }
}
