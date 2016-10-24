package com.company.customdatasource.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;

/**
 * Entity used for paging custom datasource demonstration
 */

@MetaClass(name = "customdatasource$Foo")
public class Foo extends AbstractNotPersistentEntity {
    private static final long serialVersionUID = 7219450601293959128L;

    @MetaProperty
    protected Integer num;

    @MetaProperty
    protected String name;

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}