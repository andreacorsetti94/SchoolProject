package com.it.demo.service;

import com.it.demo.mapper.OrikaMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {

    @Autowired
    private OrikaMapper mapper;

    public AbstractService() {
    }

    public OrikaMapper getMapper() {
        return mapper;
    }
}
