package com.x14nmall.cloud.biz.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;

import com.x14nmall.cloud.biz.config.MinioTemplate;
import com.x14nmall.cloud.biz.config.OssConfig;
import com.x14nmall.cloud.biz.vo.OssVO;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/oss")
@RestController
@Api(tags = "文件管理")
public class OssController {

    private static final Logger log = LoggerFactory.getLogger(OssController.class);

    /**
     * 上传的文件夹(根据时间确定)
     */
    public static final String NORM_DAY_PATTERN = "yyyy/MM/dd";

    @Autowired
    private OssConfig ossConfig;
    @Autowired
    private MinioTemplate minioTemplate;

    private OssVO loadOssVO(OssVO ossVo) {
        String dir = DateUtil.format(new Date(), NORM_DAY_PATTERN)+ "/";
        String fileName = IdUtil.simpleUUID();
        ossVo.setDir(dir);
        ossVo.setFileName(fileName);
        return ossVo;
    }


    @PostMapping("/upload_minio")
    @ApiOperation(value = "文件上传接口", notes = "上传文件，返回文件路径与域名")
    public ServerResponseEntity<OssVO> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ServerResponseEntity.success();
        }
        OssVO oss = loadOssVO(new OssVO());
        minioTemplate.uploadMinio(file.getBytes(), oss.getDir() + oss.getFileName(), file.getContentType());
        return ServerResponseEntity.success(oss);
    }


}
