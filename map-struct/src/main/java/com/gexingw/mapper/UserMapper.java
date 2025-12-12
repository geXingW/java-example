package com.gexingw.mapper;

import com.gexingw.domain.User;
import com.gexingw.dto.UserUpdateDTO;
import com.gexingw.vo.UserVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "registerTime", source = "createTime")
    UserVO toVO(User user);

    @InheritInverseConfiguration(name = "toVO")
    User toDomain(UserVO userVO);

    List<UserVO> toVOList(List<User> userList);

    Map<String, UserVO> toVoMap(Map<String, User> userMap);


    @Mapping(target = "deptId", ignore = true)
    @Mapping(target = "bestFriend", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // 忽略 null 值，不覆盖原值
    void updateFromDto(UserUpdateDTO dto, @MappingTarget User user);

}
