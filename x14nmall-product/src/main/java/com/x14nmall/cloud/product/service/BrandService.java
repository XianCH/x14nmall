package com.x14nmall.cloud.product.service;


import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import com.x14nmall.cloud.common.database.dto.PageDTO;
import com.x14nmall.cloud.common.database.vo.PageVO;
import com.x14nmall.cloud.product.dto.BrandDTO;
import com.x14nmall.cloud.product.vo.BrandVO;

public interface BrandService {

    PageVO<BrandVO> page(PageDTO pageDTO , BrandDTO brandDTO);

    ServerResponseEntity<Void> addNewBrand(BrandDTO brandDTO);

    ServerResponseEntity<BrandVO> changeBrandInfo(BrandDTO brandDTO);

    ServerResponseEntity<Void> deleteBrandById(Long brandId);
}
