package com.hz.loanBiz.controller;

import com.hz.loanBiz.service.SendSmsService;
import com.hz.loanBiz.vo.Result;
import com.hz.loanBiz.vo.SmsReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 短信相关controller
 */
@Controller
@RequestMapping("/sms")
public class SmsController {

    private static final Logger logger = LoggerFactory.getLogger(SmsController.class);

    @Autowired
    private SendSmsService smsService;

    /**
     * 发送短信
     */
    @ResponseBody
    @RequestMapping("/send")
    public Result sendSms(String mobile,String bizType){
        //1.生成验证码,并入库
        //2.调用短信通道发送
        Result result = smsService.send(mobile,bizType);
        return result;
    }


    /**
     * 查询验证码
     */
    @ResponseBody
    @RequestMapping("/query")
    public Result sendQuery(@RequestParam("mobile") String mobile, @RequestParam("bizType")String bizType){
        logger.info("接受到手机号：{}的查询请求:{}",mobile,bizType);
        Result result = smsService.query(mobile,bizType);
        return result;
    }
}
