package com.yqf.admin.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yqf.admin.pojo.entity.SysDept;
import com.yqf.admin.pojo.vo.DeptVO;
import com.yqf.admin.pojo.vo.TreeVO;

import java.util.List;

public interface ISysDeptService extends IService<SysDept> {

    List<DeptVO> listDeptVO(LambdaQueryWrapper<SysDept> baseQuery);

    List<TreeVO> listTreeVO(LambdaQueryWrapper<SysDept> baseQuery);
}
