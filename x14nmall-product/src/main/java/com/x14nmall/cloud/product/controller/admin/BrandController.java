package com.x14nmall.cloud.product.controller.admin;


import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import com.x14nmall.cloud.product.dto.BrandDTO;
import com.x14nmall.cloud.product.service.BrandService;
import com.x14nmall.cloud.product.vo.BrandVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("adminBrandController")
@RequestMapping("/admin/brand")
@Api(tags = "admin-品牌信息管理")
public class BrandController {

    @Autowired
    BrandService brandService;

    /**
     * 获取所有的品牌
     */
//    @GetMapping("/getBrandByCategoryId")
//    @ApiImplicitParam(name = "categoryId",value = "分类id")
//    public ServerResponseEntity<List>

    /**
     * 添加品牌信息
     */
    @PostMapping("/addNewBrand")
    public ServerResponseEntity<Void> addNewBrand(@RequestBody BrandDTO brandDTO){
        return brandService.addNewBrand(brandDTO);
    }
    /**
     * 修改品牌信息
     */
    @PutMapping("/changeBrandInfo")
    public ServerResponseEntity<BrandVO> changeBrandInfo(@RequestBody BrandDTO brandDTO){
        return brandService.changeBrandInfo(brandDTO);
    }

    /**
     * 删除品牌
     */
    @DeleteMapping("/deleteBrand")
    public ServerResponseEntity<Void> deleteBrand(@RequestParam("branId") Long brandId){
        return brandService.deleteBrandById(brandId);
    }
}
