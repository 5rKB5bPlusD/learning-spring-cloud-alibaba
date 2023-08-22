package com.zxk.springcloud;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@RibbonClients(value = {
        @RibbonClient(name = "provider-nacos", configuration = NacosRule.class),
        @RibbonClient(name = "provider2-nacos", configuration = RoundRobinRule.class)
})
@EnableFeignClients(basePackages = {"com.zxk.springcloud.provider.service"})
public class ConsumerNacosFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosFeignApplication.class, args);
    }
}
