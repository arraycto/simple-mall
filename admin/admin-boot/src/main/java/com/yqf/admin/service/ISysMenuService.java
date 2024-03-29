package com.yqf.admin.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yqf.admin.pojo.entity.SysMenu;
import com.yqf.admin.pojo.vo.MenuVO;
import com.yqf.admin.pojo.vo.RouteVO;
import com.yqf.admin.pojo.vo.TreeVO;

import java.util.List;
/**
 * @author haoxr
 * @date 2020-11-06
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<MenuVO> listMenuVO(LambdaQueryWrapper<SysMenu> baseQuery);

    List<TreeVO> listTreeVO(LambdaQueryWrapper<SysMenu> baseQuery);

    List<RouteVO> listRoute();
}
