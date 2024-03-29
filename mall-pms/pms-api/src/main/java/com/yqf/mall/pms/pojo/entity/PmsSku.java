package com.yqf.mall.pms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yqf.common.base.BaseEntity;
import lombok.Data;

@Data
public class PmsSku extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long spuId;
    private String name;
    private String code;
    private String pic;
    private Long originPrice;
    private Long price;
    private Integer stock;
    private Integer lockedStock;
    private String specValueIds;
}
