package com.lzh.moon;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(FdfsClientConfig.class)
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.lzh.moon.mapper")
public class MoonApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MoonApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MoonApplication.class, args);
    }

}
