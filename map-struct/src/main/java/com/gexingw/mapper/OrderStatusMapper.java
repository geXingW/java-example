package com.gexingw.mapper;

import com.gexingw.domain.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;

@Mapper
public interface OrderStatusMapper {

    OrderStatusMapper INSTANCE = Mappers.getMapper(OrderStatusMapper.class);

    default Integer toCode(OrderStatus status) {
        return status == null ? null : status.getCode();
    }

    default OrderStatus toEnum(Integer code) {
        if (code == null) return null;
        return Arrays.stream(OrderStatus.values())
                .filter(s -> s.getCode().equals(code)).findFirst().orElse(null);
    }

    default String toDesc(OrderStatus status) {
        return status == null ? null : status.getDesc();
    }
}
