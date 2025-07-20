package com.smp.client.config;

import com.smp.client.integration.CardClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(clients = {CardClient.class })
public class FeignConfig {

}
