package com.gexingw.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class OrderPO {

    /**
     * 商品数量
     */
    private Integer productCount;

    /**
     * 下单日期
     */
    private LocalDateTime createTime;

}
