package com.x14nmall.cloud.common.database.util;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.x14nmall.cloud.common.database.dto.PageDTO;
import com.x14nmall.cloud.common.database.vo.PageVO;

public class PageUtil {


    public static <T> PageVO<T> doPage(PageDTO pageDTO, ISelect iSelect) {
        PageSerializable<T> simplePageInfo = PageHelper.startPage(pageDTO).doSelectPageSerializable(iSelect);

        PageVO<T> pageVO = new PageVO<>();

        pageVO.setList(simplePageInfo.getList());

        pageVO.setTotal(simplePageInfo.getTotal());

        pageVO.setPages(getPages(simplePageInfo.getTotal(),pageDTO.getPageSize()));

        return pageVO;
    }

    public static Integer getPages(long total, Integer pageSize) {
        if (total == 0 || pageSize == 0) {
            return 0;
        }
        if (total == -1){
            return 1;
        }
        return (int) Math.ceil((double) total / (double) pageSize);
    }
}
