package com.gexingw.mapper;

import com.gexingw.domain.User;
import com.gexingw.service.DeptService;
import com.gexingw.vo.UserWithDeptVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DeptService.class})
public interface SpringBeanUserMapper {

    @Mapping(target = "deptName", source = "deptId", qualifiedByName = "idToName")
    UserWithDeptVO toVO(User user);

}
