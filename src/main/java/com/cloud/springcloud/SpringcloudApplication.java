package com.cloud.springcloud;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudApplication  implements ApplicationContextAware {
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudApplication.class, args);
    }
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        try {
            context = applicationContext;
            // ===== 在项目初始化bean后检验数据库连接是否
            DataSource dataSource = (DataSource) context.getBean("dataSource");
            dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            // ===== 当检测数据库连接失败时, 停止项目启动
            System.exit(-1);
        }
    }
    public ApplicationContext getApplicationContext() {
        return context;
    }

}
