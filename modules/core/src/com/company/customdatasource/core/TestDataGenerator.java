package com.company.customdatasource.core;

import com.haulmont.bali.db.ArrayHandler;
import com.haulmont.bali.db.QueryRunner;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.sys.AppContext;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.sql.SQLException;

/**
 * Class generates test data on application start
 * Test data is used for paging datasource feature demonstration
 */
@Component
public class TestDataGenerator implements AppContext.Listener {

    @Inject
    private Persistence persistence;

    @PostConstruct
    public void init() {
        AppContext.addListener(this);
    }

    @Override
    public void applicationStarted() {
        QueryRunner runner = new QueryRunner(persistence.getDataSource());
        try {
            Object[] row = runner.query("select count(*) as _count from FOO", new ArrayHandler());
            Number count = (Number) row[0];
            if (count.intValue() == 0) {
                for (int i = 1; i < 230; i++) {
                    runner.update(String.format("insert into FOO (NUM, NAME) values (%d, '%s')", i, RandomStringUtils.randomAlphanumeric(50)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void applicationStopped() {
    }
}
