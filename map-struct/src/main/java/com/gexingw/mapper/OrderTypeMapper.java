package com.gexingw.mapper;

import com.gexingw.domain.ExternalOrderType;
import com.gexingw.domain.InternalOrderType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderTypeMapper {

        OrderTypeMapper INSTANCE = Mappers.getMapper(OrderTypeMapper.class);

        @ValueMapping(source = "B2B", target = "BUSINESS")
        @ValueMapping(source = "B2C", target = "CUSTOMER")
        @ValueMapping(source = "C2C", target = MappingConstants.NULL)
        @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = "OTHER")
        ExternalOrderType toExternal(InternalOrderType type);

}
