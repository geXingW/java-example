package com.gexingw;

import com.gexingw.domain.User;
import com.gexingw.dto.CycleAvoidanceContext;
import com.gexingw.mapper.ContextMapper;
import com.gexingw.vo.UserVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContextMappingTest {

    @Test
    public void test() {
        // 1. 构造循环引用数据
        User userA = new User(1L, "User A");
        User userB = new User(2L, "User B");

        userA.setBestFriend(userB);
        userB.setBestFriend(userA); // A -> B -> A 形成闭环

        // 2. 执行转换
        // 必须传入一个新的 Context 实例来记录本次调用的对象图
        UserVO resultA = ContextMapper.INSTANCE.toVO(userA, new CycleAvoidanceContext());

        // 3. 验证结果
        Assertions.assertNotNull(resultA);
        Assertions.assertEquals("User A", resultA.getUsername());

        // 验证 B 是否转换成功
        UserVO resultB = resultA.getBestFriend();
        Assertions.assertNotNull(resultB);
        Assertions.assertEquals("User B", resultB.getUsername());

        // 核心验证：验证 B 的朋友是否指回了 A (内存地址相同，说明复用了对象，未发生递归死锁)
        Assertions.assertSame(resultA, resultB.getBestFriend());

        System.out.println("循环依赖测试通过：A -> B -> A");


        // 异常情况
//        UserVO userA2 = ContextMapper.INSTANCE.toVO(userA);
    }

}
