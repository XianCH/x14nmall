package com.x14nmall.cloud.product.mapper;


import com.x14nmall.cloud.api.product.vo.BrandVO;
import com.x14nmall.cloud.product.dto.BrandDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface BrandMapper {

    List<BrandVO> list(@Param("brandDTO") BrandDTO brandDTO);

    List<BrandVO> allBrand();
}
