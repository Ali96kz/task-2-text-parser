package com.epam.az.parser.entity;

public abstract class BaseEntity {
    private String value;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) obj;
            return baseEntity.getValue().equals(value);        }
        return super.equals(obj);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
