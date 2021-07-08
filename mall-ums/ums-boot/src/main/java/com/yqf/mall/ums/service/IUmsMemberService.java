package com.yqf.mall.ums.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
;

public interface IUmsMemberService extends IService<UmsMember> {

    IPage<UmsMember> list(Page<UmsMember> page, UmsMember user);
}
