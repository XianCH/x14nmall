package com.x14nmall.cloud.product.vo.service.impl;

import com.x14nmall.cloud.api.product.vo.BrandVO;
import com.x14nmall.cloud.common.database.dto.PageDTO;
import com.x14nmall.cloud.common.database.util.PageUtil;
import com.x14nmall.cloud.common.database.vo.PageVO;
import com.x14nmall.cloud.product.dto.BrandDTO;
import com.x14nmall.cloud.product.mapper.BrandMapper;
import com.x14nmall.cloud.product.vo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandServiceImpl implements BrandService {


    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageVO<BrandVO> page(PageDTO pageDTO, BrandDTO brandDTO) {
        return PageUtil.doPage(pageDTO, () ->brandMapper.list(brandDTO));
    }

    @Override
    public List<BrandVO> allBrand() {
        return brandMapper.allBrand();
    }


}
