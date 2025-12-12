package com.gexingw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatus {

    OFF_SALE(0, "下架"),

    ON_SALE(1, "在售"),

    ;

    private final Integer code;

    private final String desc;

}
