package com.gexingw.mapper;

import com.gexingw.domain.Order;
import com.gexingw.domain.Product;
import com.gexingw.domain.User;
import com.gexingw.vo.OrderVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProductMapper.class, UserMapper.class})
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderVO toVO(Order order);

    @Mapping(target = "id", source = "order.id")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "product", source = "product")
    OrderVO toVO(Order order, User user, Product product);

}
