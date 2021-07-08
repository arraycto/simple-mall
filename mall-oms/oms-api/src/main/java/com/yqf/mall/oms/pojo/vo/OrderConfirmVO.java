package com.yqf.mall.oms.pojo.vo;

import com.youlai.common.base.BaseVO;
import com.yqf.mall.oms.pojo.dto.OrderItemDTO;
import com.youlai.mall.ums.pojo.entity.UmsAddress;
import lombok.Data;

import java.util.List;


@Data
public class OrderConfirmVO extends BaseVO {

    private String orderToken;

    private List<OrderItemDTO> orderItems;

    private List<UmsAddress> addresses;

}
