package com.itheima.controller;


import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Slf4j
@RestController
public class UploadController {


    /**
     * 上传文件
     *
     * @return
     */
    /*@PostMapping("/upload")
    public Result upload(String username, Integer id, MultipartFile image) throws IOException {
        log.info("上传文件，username={},id={},image={}", username, id, image);
        //构造唯一的文件名,UUID
        String originalFilename = image.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名: {}", newFileName);

        //将文件存储到磁盘目录
        image.transferTo(new File("D:\\JavaCode\\itheima_web_project\\tlias-web-managerment\\src\\main\\resources\\static\\upload\\" + newFileName));

        return Result.success();
    }*/


    @Autowired
    private AliOSSUtils ossOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("上传文件，文件名={}", image.getOriginalFilename());

        //调用阿里云OSS上传文件
        String url = ossOSSUtils.upload(image);
        log.info("上传文件完成，url={}", url);

        return Result.success(url);
    }
}
