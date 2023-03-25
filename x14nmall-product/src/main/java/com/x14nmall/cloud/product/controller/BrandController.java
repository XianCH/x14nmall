package com.x14nmall.cloud.product.controller;


import com.x14nmall.cloud.api.product.vo.BrandVO;
import com.x14nmall.cloud.common.database.dto.PageDTO;
import com.x14nmall.cloud.common.database.vo.PageVO;
<<<<<<< HEAD
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import com.x14nmall.cloud.product.dto.BrandDTO;
import com.x14nmall.cloud.product.vo.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
=======
import com.x14nmall.cloud.common.response.ServerResponseEntity;
import com.x14nmall.cloud.product.dto.BrandDTO;
import com.x14nmall.cloud.product.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> develop
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> develop

@RestController("appBrandController")
@RequestMapping("/brand")
@Api(tags = "app-品牌信息")
public class BrandController {


    @Autowired
    private BrandService brandService;

    @GetMapping("/page")
    @ApiOperation(value = "获取品牌信息列表",notes = "分页获取品牌信息列表")
    public ServerResponseEntity<PageVO<BrandVO>> page(@Valid PageDTO pageDTO, BrandDTO brandDTO){
        PageVO<BrandVO> brandPage = brandService.page(pageDTO, brandDTO);
            return ServerResponseEntity.success(brandPage);
    }

<<<<<<< HEAD
    @GetMapping("/allBrand")
    @ApiModelProperty(value = "获取所有品牌列表")
    public ServerResponseEntity<List<BrandVO>> AllBrand(){
        return ServerResponseEntity.success(brandService.allBrand());
    }



=======
>>>>>>> develop
}
