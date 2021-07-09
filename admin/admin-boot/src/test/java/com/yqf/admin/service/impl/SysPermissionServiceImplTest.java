package com.yqf.admin.service.impl;

import com.yqf.admin.mapper.SysPermissionMapper;
import com.yqf.admin.pojo.entity.SysPermission;
import com.yqf.admin.service.ISysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author haoxr
 * @description TODO
 * @createTime 2021/5/30 23:19
 */
@SpringBootTest
@Slf4j
class SysPermissionServiceImplTest {

    @Autowired
    SysPermissionMapper sysPermissionMapper;

    ISysPermissionService iSysPermissionService;

    @Test
    void listPermissionRoles() {
        List<SysPermission> sysPermissions = sysPermissionMapper.listPermRoles();
        log.info(sysPermissions.toString());
    }

    @Test
    void refreshPermRolesRules(){

    }
}
