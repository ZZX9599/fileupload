package com.zzx.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

/**
 * @author: 周志雄
 * @Description: 文件上传配置类
 * @date: 2022-08-24 10:02
 * @ClassName: MultiConfig
 */

@Configuration
public class MultiConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        //创建工厂对象
        MultipartConfigFactory factory=new MultipartConfigFactory();
        //配置文件上传大小
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
        //配置总的上传文件大小
        factory.setMaxRequestSize(DataSize.of(10, DataUnit.MEGABYTES));
        //返回
        return factory.createMultipartConfig();
    }
}
