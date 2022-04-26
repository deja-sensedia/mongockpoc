package com.sensedia.mongockpoc.changelogs;

import io.mongock.api.annotations.*;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id = "myMigrationChangeUnitId", order = "1", author = "mongock_test", systemVersion = "1")
public class MyMigrationChangeUnit {
    private final MongoTemplate template;

    public MyMigrationChangeUnit(MongoTemplate template) {
        this.template = template;
    }

    @Execution
    public void migrationMethod() {
        template.createCollection("clients");
    }

    @RollbackExecution
    public void rollback() {
        template.dropCollection("clients");
    }
}