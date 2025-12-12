package com.gexingw;

import com.gexingw.domain.ExternalOrderType;
import com.gexingw.domain.InternalOrderType;
import com.gexingw.domain.OrderStatus;
import com.gexingw.mapper.OrderStatusMapper;
import com.gexingw.mapper.OrderTypeMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnumMappingTest {

    @Test
    public void typeMapperTest() {
        // B2B 转换成 BUSINESS
        ExternalOrderType businessType = OrderTypeMapper.INSTANCE.toExternal(InternalOrderType.B2B);
        Assertions.assertThat(businessType).isEqualTo(ExternalOrderType.BUSINESS);
        System.out.println(businessType);

        //  B2C 转换成 CUSTOMER
        ExternalOrderType customerType = OrderTypeMapper.INSTANCE.toExternal(InternalOrderType.B2C);
        Assertions.assertThat(customerType).isEqualTo(ExternalOrderType.CUSTOMER);
        System.out.println(customerType);

        // 不存在的枚举值 转换成 OTHER
        ExternalOrderType otherType = OrderTypeMapper.INSTANCE.toExternal(InternalOrderType.NEW_TYPE);
        Assertions.assertThat(otherType).isEqualTo(ExternalOrderType.OTHER);
        System.out.println(otherType);

    }

    /**
     * code转枚举对象
     */
    @Test
    public void codeToEnumMapperTest() {
        // code -> 枚举，正常场景
        Assertions.assertThat(OrderStatusMapper.INSTANCE.toEnum(1)).isEqualTo(OrderStatus.PENDING);
        Assertions.assertThat(OrderStatusMapper.INSTANCE.toEnum(2)).isEqualTo(OrderStatus.PAID);
        // code -> 枚举，不存在的 code
        Assertions.assertThat(OrderStatusMapper.INSTANCE.toEnum(99)).isNull();
        // code -> 枚举，异常场景：null 输入
        Assertions.assertThat(OrderStatusMapper.INSTANCE.toEnum(null)).isNull();


        // 枚举 -> code
        Assertions.assertThat(OrderStatusMapper.INSTANCE.toCode(OrderStatus.PENDING)).isEqualTo(1);
        Assertions.assertThat(OrderStatusMapper.INSTANCE.toCode(OrderStatus.PAID)).isEqualTo(2);
        // 枚举 -> code，异常场景：null 输入
        Assertions.assertThat(OrderStatusMapper.INSTANCE.toCode(null)).isNull();


        // 枚举 -> 文本
        Assertions.assertThat(OrderStatusMapper.INSTANCE.toDesc(OrderStatus.PENDING)).isEqualTo("待处理");
        Assertions.assertThat(OrderStatusMapper.INSTANCE.toDesc(OrderStatus.PAID)).isEqualTo("已支付");
        // 枚举 -> 文本，异常场景：null 输入
        Assertions.assertThat(OrderStatusMapper.INSTANCE.toDesc(null)).isNull();
    }

}
