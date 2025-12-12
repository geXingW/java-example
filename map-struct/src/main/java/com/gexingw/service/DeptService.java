package com.gexingw.service;

import org.mapstruct.Named;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

    /**
     * 根据部门ID获取部门名称
     *
     * @param deptId 部门ID
     * @return 部门名称
     */
    @Named("idToName")
    public String getDeptName(Long deptId) {
        // 查库逻辑...
        return "部门-" + deptId;
    }

}
