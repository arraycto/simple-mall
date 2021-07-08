package com.yqf.mall.sms.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import com.yqf.common.web.exception.BizException;
import com.yqf.common.web.util.BeanMapperUtils;
import com.yqf.mall.sms.pojo.domain.SmsCouponTemplate;
import com.yqf.mall.sms.pojo.vo.CouponTemplateVO;
import com.yqf.mall.sms.service.ISmsCouponTemplateService;
import com.yqf.mall.sms.service.ITemplateBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author xinyi
 * @desc：优惠券模板基础业务实现类
 * @date 2021/7/3
 */
@Service
public class TemplateBaseServiceImpl implements ITemplateBaseService {

    @Autowired
    private ISmsCouponTemplateService couponTemplateService;

    @Override
    public CouponTemplateVO queryTemplateInfo(Long id) {
        SmsCouponTemplate template = couponTemplateService.getById(id);
        if (null == template) {
            throw new BizException("Template Is Not Exist: " + id);
        }
        return BeanMapperUtils.map(template,CouponTemplateVO.class);
    }

    @Override
    public List<SmsCouponTemplate> findAllUsableTemplate() {
        return couponTemplateService.findAllUsableTemplate(true, false);
    }

    @Override
    public Map<Long, SmsCouponTemplate> findAllTemplateByIds(Collection<Long> ids) {
        List<SmsCouponTemplate> templates = couponTemplateService.listByIds(ids);
        if (CollUtil.isEmpty(templates)) {
            return MapUtil.empty();
        }
        return templates.stream()
                .collect(Collectors.toMap(SmsCouponTemplate::getId, Function.identity()));
    }
}
