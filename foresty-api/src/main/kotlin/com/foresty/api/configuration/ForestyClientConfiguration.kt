package com.foresty.api.configuration

import feign.Contract
import feign.RequestInterceptor
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType


@Configuration
@EnableFeignClients(value = ["com.foresty.api"])
class ForestyClientConfiguration {
    @Bean
    fun feignContract(): Contract {
        return feign.Contract.Default()
    }

    @Bean
    fun basicAuthRequestInterceptor(): RequestInterceptor {
        return RequestInterceptor {template ->
            //template.header("x-api-key", "abc")
            template.header("Accept", MediaType.APPLICATION_JSON_VALUE)
        }
    }
}