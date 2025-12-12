package com.gexingw.dto;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

import java.util.IdentityHashMap;
import java.util.Map;

public class CycleAvoidanceContext {

    private final Map<Object, Object> knownInstances = new IdentityHashMap<>();

    /**
     * 在映射开始前调用：如果未映射过，记录当前对象
     * 注意：MapStruct 会自动判断何时调用
     */
    @BeforeMapping
    public void storeMappedInstance(Object source, @MappingTarget Object target) {
        knownInstances.put(source, target);
    }

    /**
     * 在映射开始前调用：检查是否已经映射过该对象
     */
    @BeforeMapping
    @SuppressWarnings("unchecked")
    public <T> T getMappedInstance(Object source, @TargetType Class<T> targetType) {
        return (T) knownInstances.get(source);
    }

}
