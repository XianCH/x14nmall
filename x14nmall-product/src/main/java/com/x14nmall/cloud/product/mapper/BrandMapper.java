package com.x14nmall.cloud.product.mapper;


import com.x14nmall.cloud.product.dto.BrandDTO;
import com.x14nmall.cloud.product.vo.BrandVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface BrandMapper {

    List<BrandVO> list(@Param("brandDTO") BrandDTO brandDTO);

    List<BrandVO> allBrand();

    void addNewBrand(@Param("brandDTO") BrandDTO brandDTO);

    void changeBranInfoByBradId(@Param("brandId") Long brandId,@Param("brandDTO") BrandDTO brandDTO);

    BrandVO selectBrandById(@Param("brandId") Long brandId);

    void deleteBrandById(@Param("brandId") Long brandId);
}
