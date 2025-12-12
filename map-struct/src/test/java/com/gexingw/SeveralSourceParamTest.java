package com.gexingw;

import com.gexingw.domain.Order;
import com.gexingw.domain.Product;
import com.gexingw.domain.User;
import com.gexingw.mapper.OrderMapper;
import com.gexingw.vo.OrderVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

/**
 * 多源参数映射
 */
@ExtendWith(MockitoExtension.class)
public class SeveralSourceParamTest {

    @Test
    public void test() {
        // 1. 准备数据
        // 用户信息
        User user = new User(10001L, "User-1", LocalDateTime.now());
        // 商品信息
        BigDecimal discountPrice = new BigDecimal(80);
        BigDecimal price = new BigDecimal(100);
        BigDecimal discountRate = price.divide(discountPrice, 2, RoundingMode.HALF_UP);
        Product product = new Product(10001L, "Product-1", price, discountPrice, discountRate, "test.jpg", 1);
        // 订单信息
        Order order = new Order().setId(1L);

        // 2. 执行转换
        OrderVO orderVO = OrderMapper.INSTANCE.toVO(order, user, product);

        // 3. 验证结果 (Assert)
        Assertions.assertNotNull(orderVO, "转换结果不应为空");
        Assertions.assertEquals("User-1", orderVO.getUser().getUsername(), "用户名映射错误");
        Assertions.assertEquals("Product-1", orderVO.getProduct().getName(), "商品名映射错误");

    }

}
