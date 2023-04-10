package com.x14nmall.cloud.product.service.impl;

import com.x14nmall.cloud.common.core.exception.X14nmallException;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import com.x14nmall.cloud.common.database.dto.PageDTO;
import com.x14nmall.cloud.common.database.util.PageUtil;
import com.x14nmall.cloud.common.database.vo.PageVO;
import com.x14nmall.cloud.product.dto.BrandDTO;
import com.x14nmall.cloud.product.mapper.BrandMapper;
import com.x14nmall.cloud.product.service.BrandService;
import com.x14nmall.cloud.product.vo.BrandVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrandServiceImpl implements BrandService {

    private static final Logger log = LoggerFactory.getLogger(BrandService.class);

    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageVO<BrandVO> page(PageDTO pageDTO, BrandDTO brandDTO) {
        return PageUtil.doPage(pageDTO, () ->brandMapper.list(brandDTO));
    }

    @Override
    public ServerResponseEntity<Void> addNewBrand(BrandDTO brandDTO) {
            brandMapper.addNewBrand(brandDTO);
            return ServerResponseEntity.success();
    }

    @Override
    public ServerResponseEntity<BrandVO> changeBrandInfo(BrandDTO brandDTO) {

            brandMapper.changeBranInfoByBradId(brandDTO.getBrandId(), brandDTO);
            BrandVO brandVO = brandMapper.selectBrandById(brandDTO.getBrandId());
            if (brandVO == null) {
               throw new X14nmallException("修改失败");
            }
            return ServerResponseEntity.success(brandVO);
    }

    @Override
    public ServerResponseEntity<Void> deleteBrandById(Long brandId) {

            brandMapper.deleteBrandById(brandId);
            return ServerResponseEntity.success();
    }
}
