package com.epam.az.parser.parser;

import com.epam.az.parser.entity.BaseEntity;

import java.util.List;

public interface Parser {
    public List<BaseEntity> parse(BaseEntity list);
}
