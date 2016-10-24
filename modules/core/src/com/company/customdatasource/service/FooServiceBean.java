package com.company.customdatasource.service;

import com.company.customdatasource.entity.Foo;
import com.haulmont.bali.db.ArrayHandler;
import com.haulmont.bali.db.QueryRunner;
import com.haulmont.bali.db.ResultSetHandler;
import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service(FooService.NAME)
public class FooServiceBean implements FooService {

    @Inject
    private Persistence persistence;

    @Override
    public List<Foo> getFooList(int maxResults, int firstResult) {
        String sql = String.format("select NUM, NAME from FOO order by NUM limit %d offset %d", maxResults, firstResult);

        QueryRunner runner = new QueryRunner(persistence.getDataSource());
        try {
            return runner.query(sql, new ResultSetHandler<List<Foo>>() {
                @Override
                public List<Foo> handle(ResultSet rs) throws SQLException {
                    ArrayList<Foo> list = new ArrayList<>();
                    while (rs.next()) {
                        Foo foo = new Foo();
                        foo.setNum(rs.getInt("NUM"));
                        foo.setName(rs.getString("NAME"));
                        list.add(foo);
                    }
                    return list;
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getFooCount() {
        QueryRunner runner = new QueryRunner(persistence.getDataSource());
        try {
            Object[] row = runner.query("select count(*) as _count from FOO", new ArrayHandler());
            return ((Number) row[0]).intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}