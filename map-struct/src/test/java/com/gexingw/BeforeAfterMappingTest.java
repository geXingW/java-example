package com.gexingw;

import com.gexingw.domain.User;
import com.gexingw.mapper.UserBeforeAfterMapper;
import com.gexingw.vo.UserVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BeforeAfterMappingTest {

    @Test
    public void test() {
        User user = new User().setId(1L);
        UserVO userVO = UserBeforeAfterMapper.INSTANCE.toVO(user);
        System.out.println(userVO);

        Assertions.assertNotNull(userVO);
        Assertions.assertNotNull(userVO.getRegisterTime());
        Assertions.assertNotNull(userVO.getUsername());
    }

}
