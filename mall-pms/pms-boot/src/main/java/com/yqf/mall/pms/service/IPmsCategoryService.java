package com.yqf.mall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yqf.common.web.vo.CascaderVO;
import com.yqf.mall.pms.pojo.entity.PmsCategory;
import com.yqf.mall.pms.pojo.vo.CategoryVO;

import java.util.List;

public interface IPmsCategoryService extends IService<PmsCategory> {

    List<CategoryVO> listForTree(PmsCategory category);

    List<CascaderVO> listForCascader(PmsCategory category);
}
