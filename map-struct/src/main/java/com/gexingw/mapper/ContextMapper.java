package com.gexingw.mapper;

import com.gexingw.domain.User;
import com.gexingw.dto.CycleAvoidanceContext;
import com.gexingw.vo.UserVO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContextMapper {

    ContextMapper INSTANCE = Mappers.getMapper(ContextMapper.class);

    // 传入 Context，MapStruct 会自动调用其中的 @BeforeMapping 方法
    UserVO toVO(User user, @Context CycleAvoidanceContext context);


}
