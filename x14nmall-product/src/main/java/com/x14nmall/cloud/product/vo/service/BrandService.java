package com.x14nmall.cloud.product.vo.service;

import com.x14nmall.cloud.api.product.vo.BrandVO;
import com.x14nmall.cloud.common.database.dto.PageDTO;
import com.x14nmall.cloud.common.database.vo.PageVO;
import com.x14nmall.cloud.product.dto.BrandDTO;

import java.util.List;

public interface BrandService {

    PageVO<BrandVO> page(PageDTO pageDTO , BrandDTO brandDTO);

    List<BrandVO> allBrand();
}
