package com.gexingw;

import com.gexingw.domain.User;
import com.gexingw.mapper.BasicProductMapper;
import com.gexingw.mapper.UserMapper;
import com.gexingw.vo.UserVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class BasicTest {

    /**
     * 基本用法
     */
    @Test
    public void basicUsage() {
        User user = new User(10001L, "User-1", LocalDateTime.now());
        UserVO userVO = UserMapper.INSTANCE.toVO(user);
        System.out.println(userVO);

        Assertions.assertThat(userVO).isNotNull();
        Assertions.assertThat(userVO.getUsername()).isEqualTo("User-1");
    }

    /**
     * 字段映射
     */
    @Test
    public void fieldsMapping() {
        com.gexingw.mapper.BasicProductMapper.Product product = new com.gexingw.mapper.BasicProductMapper.Product().setId(10001L).setName("Product-1").setStatus(1);
        com.gexingw.mapper.BasicProductMapper.ProductVO productVO = BasicProductMapper.INSTANCE.toVO(product);
        System.out.println(productVO);

        Assertions.assertThat(productVO).isNotNull();
        Assertions.assertThat(productVO.getName()).isEqualTo("Product-1");
    }

}
