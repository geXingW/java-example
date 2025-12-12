package com.gexingw.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class ProductVO {

    private Long id;

    private String name;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private BigDecimal discountRate;

    private String imageUrl;

    private Integer status;

    private String statusDesc;

}
