package com.gexingw.mapper;

import lombok.Data;
import lombok.experimental.Accessors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BasicProductMapper {

    BasicProductMapper INSTANCE = Mappers.getMapper(BasicProductMapper.class);

    // Long 转 String
    @Mapping(target = "id", source = "id")
    // status 转 productStatus
    @Mapping(target = "productStatus", source = "status")
    ProductVO toVO(Product product);

    @Data
    @Accessors(chain = true)
    class Product {

        private Long id;

        /**
         * 商品名称
         */
        private String name;

        /**
         * 状态
         */
        private Integer status;

    }

    // 目标对象
    @Data
    class ProductVO {

        private String id;

        /**
         * 商品名称
         */
        private String name;

        /**
         * 状态
         */
        private Integer productStatus;

    }

}
