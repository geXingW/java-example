package com.gexingw;

import com.gexingw.domain.User;
import com.gexingw.mapper.SpringBeanUserMapper;
import com.gexingw.vo.UserWithDeptVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MapStructApplication.class)
public class SpringBeanMappingTest {

    @Autowired
    private SpringBeanUserMapper springBeanUserMapper;


    @Test
    public void test() {
        User user = new User(1L, "test").setDeptId(2L);
        UserWithDeptVO userWithDeptVO = springBeanUserMapper.toVO(user);
        System.out.println(userWithDeptVO);
        System.out.println(springBeanUserMapper);
    }

}
