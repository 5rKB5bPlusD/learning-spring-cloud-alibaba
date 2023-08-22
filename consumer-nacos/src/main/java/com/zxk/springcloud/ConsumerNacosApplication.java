package com.zxk.springcloud;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClients(value = {
        @RibbonClient(name = "provider-nacos", configuration = NacosRule.class),
        @RibbonClient(name = "provider2-nacos", configuration = RoundRobinRule.class)
})
public class ConsumerNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
