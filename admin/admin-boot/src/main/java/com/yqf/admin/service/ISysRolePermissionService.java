package com.yqf.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yqf.admin.pojo.dto.RolePermissionDTO;
import com.yqf.admin.pojo.entity.SysRolePermission;

import java.util.List;

public interface ISysRolePermissionService extends IService<SysRolePermission> {

    List<Long> listPermissionId(Long moduleId,Long roleId);
    List<Long> listPermissionId(Long roleId);
    boolean update(RolePermissionDTO rolePermission);


}
