package com.yqf.admin.component.security;

import com.yqf.admin.service.ISysPermissionService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 容器启动完成时加载角色权限规则至Redis缓存
 */
@Component
@AllArgsConstructor
public class InitPermissionRoles implements CommandLineRunner {

    private ISysPermissionService iSysPermissionService;

    @Override
    public void run(String... args) {
        iSysPermissionService.refreshPermRolesRules();
    }
}
