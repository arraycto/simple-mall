package com.yqf.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yqf.admin.pojo.entity.SysMenu;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author haoxr
 * @date 2020-11-06
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> listRoute();

}
