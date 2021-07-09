package com.yqf.admin.pojo.entity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SysRolePermission {
    private Long roleId;
    private Long permissionId;
}
