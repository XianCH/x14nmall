package com.x14nmall.cloud.product.mapper;


import com.x14nmall.cloud.product.ProductApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ProductApplication.class)
public class MapperTest {
    @Autowired
    BrandMapper brandMapper;

    @Test
    public void allBrand(){
        brandMapper.allBrand();
    }
}
