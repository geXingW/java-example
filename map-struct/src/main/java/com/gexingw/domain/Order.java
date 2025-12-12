package com.gexingw.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Order {

    /**
     * 订单ID
     */
    private Long id;

    /**
     * 商品信息
     */
    private Product product;

    /**
     * 用户信息
     */
    private User user;

}
