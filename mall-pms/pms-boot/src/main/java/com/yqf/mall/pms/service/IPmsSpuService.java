package com.yqf.mall.pms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yqf.mall.pms.pojo.dto.app.ProductFormDTO;
import com.yqf.mall.pms.pojo.entity.PmsSpu;
import java.util.List;


public interface IPmsSpuService extends IService<PmsSpu> {

    IPage<PmsSpu> list(Page<PmsSpu> page, PmsSpu spu);

    boolean add(com.yqf.mall.pms.pojo.dto.admin.ProductFormDTO productFormDTO);

    com.yqf.mall.pms.pojo.dto.admin.ProductFormDTO getBySpuId(Long id);

    boolean removeBySpuIds(List<Long> spuIds);

    boolean updateById(com.yqf.mall.pms.pojo.dto.admin.ProductFormDTO productFormDTO);

    ProductFormDTO getProductByIdForApp(Long id);
}
