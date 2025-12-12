package com.gexingw;

import com.gexingw.domain.User;
import com.gexingw.dto.UserUpdateDTO;
import com.gexingw.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class MappingTargetTest {

    @Test
    public void test() {
        // 1. 准备目标对象 (PO)，预设一些初始值
        User user = new User().setId(10001L).setUsername("oldName").setCreateTime(LocalDateTime.now());
        System.out.println(user);

        // 2. 准备来源对象 (DTO)
        // 场景：只想修改 username，email 和 age 传 null
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO().setId(10001L).setUsername("newName").setCreateTime(null);

        // 3. 执行映射
        UserMapper.INSTANCE.updateFromDto(userUpdateDTO, user);
        System.out.println(user);

        // 4. 验证结果
        // 验证 username 是否已更新
        Assertions.assertEquals("newName", user.getUsername(), "Username 应该被更新为 newName");

        // 验证 email 是否保持原值 (验证 IGNORE 策略生效)
        //noinspection EqualsWithItself
        Assertions.assertEquals(user.getCreateTime(), user.getCreateTime(), "CreateTime 应该保持原值，不被 null 覆盖");

    }

}
