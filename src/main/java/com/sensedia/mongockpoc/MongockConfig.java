package com.sensedia.mongockpoc;

import io.mongock.driver.mongodb.springdata.v3.SpringDataMongoV3Driver;
import io.mongock.runner.springboot.MongockSpringboot;
import io.mongock.runner.springboot.base.MongockApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongockConfig {

    @Bean
    public MongockApplicationRunner mongockApplicationRunner(
            ApplicationContext applicationContext,
            MongoTemplate mongoTemplate) {

        SpringDataMongoV3Driver driver = SpringDataMongoV3Driver.withDefaultLock(mongoTemplate);

        return MongockSpringboot.builder()
                .setSpringContext(applicationContext)
                .setDriver(driver)
                .addMigrationScanPackage("com.sensedia.mongockpoc.changelogs")
                .setEnabled(false)
                .buildApplicationRunner();
    }
}
