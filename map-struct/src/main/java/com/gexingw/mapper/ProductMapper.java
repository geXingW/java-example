package com.gexingw.mapper;

import com.gexingw.domain.Product;
import com.gexingw.vo.ProductVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "statusDesc", source = "status")
    @Mapping(target = "discountRate", expression = "java(product.getDiscountPrice().divide(product.getPrice(), 2, java.math.RoundingMode.HALF_UP))")
    @Mapping(target = "imageUrl", source = "imageUrl", qualifiedByName = "ossImageUrl")
    ProductVO toVO(Product product);

    /**
     * Map-Struct自动根据类型匹配转换
     *
     * @param status 状态码
     * @return 状态描述
     */
    default String getStatusDesc(Integer status) {
        switch (status) {
            case 1:
                return "ON_SALE";
            case 2:
                return "OFF_SALE";
            default:
                return "UNKNOWN";
        }
    }

    /**
     * 图片转为完整OSS连接
     *
     * @param imageUrl 不带OSS域名的图片链接
     * @return 完整OSS连接
     */
    @Named("ossImageUrl")
    default String ossImageUrl(String imageUrl) {
        return "https://gexingw.top/" + imageUrl;
    }

}
