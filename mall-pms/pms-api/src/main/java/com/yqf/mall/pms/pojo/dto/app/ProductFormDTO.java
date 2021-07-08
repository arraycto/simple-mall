package com.yqf.mall.pms.pojo.dto.app;

import com.yqf.mall.pms.pojo.entity.PmsSku;
import com.yqf.mall.pms.pojo.entity.PmsSpuAttributeValue;
import com.yqf.mall.pms.pojo.entity.PmsSpec;
import com.yqf.mall.pms.pojo.dto.SpuDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFormDTO {

    private SpuDTO spu;

    private List<PmsSpuAttributeValue> attrs;

    private List<PmsSpec> specs;

    private List<PmsSku> skus;

}
