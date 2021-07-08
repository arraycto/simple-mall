package com.yqf.mall.pms.controller.app;

import com.yqf.common.constant.GlobalConstants;
import com.yqf.common.result.Result;
import com.yqf.mall.pms.pojo.entity.PmsCategory;
import com.yqf.mall.pms.pojo.vo.CategoryVO;
import com.yqf.mall.pms.service.IPmsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "【移动端】商品分类")
@RestController("APPCategoryController")
@RequestMapping("/app-api/v1/categories")
@Slf4j
@AllArgsConstructor
public class CategoryController {

    private IPmsCategoryService iPmsCategoryService;

    @ApiOperation(value = "分类列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", paramType = "query", dataType = "Long")
    })
    @GetMapping
    public Result list(Long parentId) {
        PmsCategory category = new PmsCategory();
        category.setParentId(parentId);
        category.setStatus(GlobalConstants.STATUS_YES);
        List<CategoryVO> list = iPmsCategoryService.listForTree(category);
        return Result.success(list);
    }
}
