package com.gexingw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    PENDING(1, "待处理"),
    PAID(2, "已支付");

    private final Integer code;
    private final String desc;

}
