package com.test.mongo.mongotest.configuration;

import com.test.mongo.mongotest.security.jwt.OperationJwt;
import com.test.mongo.mongotest.security.jwt.OperationJwtImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    public OperationJwt generationToken(){
        return new OperationJwtImpl();
    }
}
