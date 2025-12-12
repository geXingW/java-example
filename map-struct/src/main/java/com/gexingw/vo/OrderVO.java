package com.gexingw.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderVO {

    private Long id;

    /**
     * 商品信息
     */
    private ProductVO product;

    /**
     * 用户信息
     */
    private UserVO user;

}
