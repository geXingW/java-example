package com.gexingw.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Product {

    private Long id;

    private String name;

    /**
     * 原价
     */
    private BigDecimal price;

    /**
     * 折扣价
     */
    private BigDecimal discountPrice;

    /**
     * 折扣率
     */
    private BigDecimal discountRate;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 状态
     */
    private Integer status;

    public Product(Long id, String name, BigDecimal price, BigDecimal discountPrice, BigDecimal discountRate, String imageUrl, Integer status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.discountRate = discountRate;
        this.imageUrl = imageUrl;
        this.status = status;
    }
}
