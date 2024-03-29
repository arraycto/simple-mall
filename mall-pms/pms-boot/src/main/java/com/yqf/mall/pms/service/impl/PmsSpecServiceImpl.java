package com.yqf.mall.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yqf.mall.pms.mapper.PmsSpecMapper;
import com.yqf.mall.pms.pojo.entity.PmsSpec;
import com.yqf.mall.pms.service.IPmsSpecService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haoxr
 * @date 2020-11-06
 */
@Service
public class PmsSpecServiceImpl extends ServiceImpl<PmsSpecMapper, PmsSpec> implements IPmsSpecService {

    @Override
    public List<PmsSpec> listBySpuId(Long spuId) {
        List<PmsSpec> list = this.baseMapper.listBySpuId(spuId);
        return list;
    }
}
