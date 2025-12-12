package com.gexingw.mapper;

import com.gexingw.domain.User;
import com.gexingw.vo.UserVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public interface UserBeforeAfterMapper {

    UserBeforeAfterMapper INSTANCE = Mappers.getMapper(UserBeforeAfterMapper.class);

    @Mapping(target = "registerTime", ignore = true)
    UserVO toVO(User user);

    // 转换前执行
    @BeforeMapping
    default void beforeMapping(@MappingTarget UserVO userVO, User user) {
        user.setUsername("User-" + user.getId());
        System.out.println("Before mapping...");
    }

    // 转换后执行
    @AfterMapping
    default void afterMapping(@MappingTarget UserVO userVO, User user) {
        userVO.setRegisterTime(LocalDateTime.now());
        System.out.println("After mapping...");
    }

}
