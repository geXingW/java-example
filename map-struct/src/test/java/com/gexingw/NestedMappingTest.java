package com.gexingw;

import com.gexingw.domain.Order;
import com.gexingw.domain.Product;
import com.gexingw.domain.User;
import com.gexingw.mapper.OrderMapper;
import com.gexingw.vo.OrderVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class NestedMappingTest {

    @Test
    public void test() {
        BigDecimal price = new BigDecimal(100);
        BigDecimal discountPrice = new BigDecimal("80");

        // 准备数据
        Product product = new Product().setId(1L).setName("product1").setPrice(price).setStatus(1).setDiscountPrice(discountPrice);
        User user = new User().setId(1L).setUsername("user1");
        Order order = new Order().setId(1L).setProduct(product).setUser(user);

        // 转换
        OrderVO orderVO = OrderMapper.INSTANCE.toVO(order);
        System.out.println(orderVO);

        // 校验
        Assertions.assertThat(orderVO).isNotNull();
        Assertions.assertThat(orderVO.getProduct().getName()).isEqualTo("product1");
        Assertions.assertThat(orderVO.getUser().getUsername()).isEqualTo("user1");
    }

}
