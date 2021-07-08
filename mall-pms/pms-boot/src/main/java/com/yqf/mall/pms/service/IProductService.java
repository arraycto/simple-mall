package com.yqf.mall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yqf.mall.pms.pojo.dto.app.ProductFormDTO;
import com.yqf.mall.pms.pojo.entity.PmsSpu;


public interface IProductService extends IService<PmsSpu> {

    ProductFormDTO getProductById(Long id);
}
