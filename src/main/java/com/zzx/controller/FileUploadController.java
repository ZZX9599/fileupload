package com.zzx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: 周志雄
 * @Description: 文件上传
 * @date: 2022-08-24 10:11
 * @ClassName: FileUploadController
 */

@Slf4j
@RestController
public class FileUploadController {

    @PostMapping("/upload.do")
    public Object upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        // 获取上传文件的原始文件名
        String originalFilename = file.getOriginalFilename();

        // 获取拓展名
        int suffix = originalFilename.lastIndexOf(".");
        String suffixName = originalFilename.substring(suffix);

        // 随机生成文件名
        String fileName = UUID.randomUUID().toString();

        // 拼接文件名
        String realFileName = fileName + suffixName;

        // 定义上传位置
        String projectLocation = System.getProperty("user.dir");

        File dir = new File(projectLocation, "file");

        //目录不存在就创建
        if (!dir.exists()) {
            dir.mkdir();
        }

        file.transferTo(new File(dir,realFileName));

        return "文件上传成功";
    }

}
