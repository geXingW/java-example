package com.gexingw;

import com.gexingw.domain.User;
import com.gexingw.mapper.UserMapper;
import com.gexingw.vo.UserVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class InverseMappingTest {

    @Test
    public void test() {
        // 准备数据
        User user = new User().setId(1L).setUsername("user1").setCreateTime(LocalDateTime.now());
        // PO -> VO
        UserVO userVO = UserMapper.INSTANCE.toVO(user);
        System.out.println(userVO);

        Assertions.assertThat(userVO).isNotNull();
        Assertions.assertThat(userVO.getRegisterTime()).isEqualTo(user.getCreateTime());

        // VO -> PO
        User inverseUser = UserMapper.INSTANCE.toDomain(userVO);
        System.out.println(inverseUser);

        Assertions.assertThat(inverseUser).isNotNull();
        Assertions.assertThat(inverseUser.getCreateTime()).isEqualTo(userVO.getRegisterTime());
    }

}
