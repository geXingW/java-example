package com.gexingw;

import com.gexingw.domain.User;
import com.gexingw.mapper.UserMapper;
import com.gexingw.vo.UserVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class CollectionMappingTest {

    @Test
    public void testList() {
        // 组装数据
        List<User> poList = Arrays.asList(
                new User(1L, "user1", LocalDateTime.now()),
                new User(2L, "user2", LocalDateTime.now())
        );

        // 转换
        List<UserVO> userVOList = UserMapper.INSTANCE.toVOList(poList);
        System.out.println(userVOList);

        // 验证
        Assertions.assertThat(userVOList).hasSize(2);
        Assertions.assertThat(userVOList).extracting("username")
                .containsExactly("user1", "user2");
    }

    @Test
    public void testMap() {
        // 组装数据
        Map<String, User> poMap = new HashMap<>();
        poMap.put("key1", new User(100L, "vip_user", LocalDateTime.now()));
        poMap.put("key2", new User(200L, "normal_user", LocalDateTime.now()));

        // 转换
        Map<String, UserVO> userVOMap = UserMapper.INSTANCE.toVoMap(poMap);
        System.out.println(userVOMap);

        // 验证
        Assertions.assertThat(userVOMap).hasSize(2);
        Assertions.assertThat(userVOMap.get("key1").getUsername()).isEqualTo("vip_user");
        Assertions.assertThat(userVOMap.get("key2").getId()).isEqualTo(200L);
    }

}
