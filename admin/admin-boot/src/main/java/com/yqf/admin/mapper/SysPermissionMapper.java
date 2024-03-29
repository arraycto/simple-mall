package com.yqf.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yqf.admin.pojo.entity.SysPermission;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {


    List<SysPermission> listPermRoles();


    List<SysPermission> list(Page<SysPermission> page, SysPermission permission);



    List<String> listBtnPermByRoles(List<String> roles);
}
