package com.hz.manager.response;

import lombok.Data;

import java.util.List;

@Data
public class CreditResult {

    private Integer code=200;

    //总记录数量
    private Integer totals;

    private List<?> list;
}
