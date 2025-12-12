package com.gexingw;

import com.gexingw.domain.Product;
import com.gexingw.mapper.ProductMapper;
import com.gexingw.vo.ProductVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;

@ExtendWith(MockitoExtension.class)
public class CustomerMethodAndExpressionTest {

    @Test
    public void test() {
        // 准备数据
        BigDecimal price = new BigDecimal("100");
        BigDecimal discountPrice = new BigDecimal("80");
        Product product = new Product()
                .setId(100L).setName("Product-1")
                .setPrice(price).setDiscountPrice(discountPrice)
                .setImageUrl("test.jpg")
                .setStatus(1);

        // 执行转换
        ProductVO productVO = ProductMapper.INSTANCE.toVO(product);
        System.out.println(productVO);

        // 验证
        Assertions.assertNotNull(productVO);
        Assertions.assertEquals(100L, productVO.getId());
        Assertions.assertEquals("Product-1", productVO.getName());
        Assertions.assertEquals(new BigDecimal("80"), productVO.getDiscountPrice());
        Assertions.assertEquals("ON_SALE", productVO.getStatusDesc());
        Assertions.assertEquals("https://gexingw.top/test.jpg", productVO.getImageUrl());
        // 验证折扣率
        Assertions.assertEquals(discountPrice.divide(price, 2, RoundingMode.HALF_UP), productVO.getDiscountRate());

    }

}
