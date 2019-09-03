package com.talkingdata;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.talkingdata.tds.filter.CrossOriginFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.text.SimpleDateFormat;
import java.util.Properties;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableAsync
@EnableTransactionManagement(proxyTargetClass = false)
@MapperScan(basePackages = {"com.talkingdata.dg.mapper","com.talkingdata.tds.dao"})
public class HainaWbApplication {

    @Bean
    public CharacterEncodingFilter initializeCharacterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return objectMapper;
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");   //设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
        properties.setProperty("rowBoundsWithCount","true"); //使用RowBounds分页会进行count查询
        properties.setProperty("reasonable","true");    //分页参数合理化
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        properties.setProperty("pageSizeZero","false");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    //注册解决跨域问题拦截器
    @Bean
    public FilterRegistrationBean crossFilterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CrossOriginFilter crossOriginFilter = new CrossOriginFilter();
        registrationBean.setFilter(crossOriginFilter);
        registrationBean.setOrder(1); //从小到大执行
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }



    public static void main(String[] args) {
        SpringApplication.run(HainaWbApplication.class, args);
    }
}
