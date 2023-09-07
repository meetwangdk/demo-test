package com.example.template.service.impl;

import com.example.template.common.CodeType;
import com.example.template.common.ServiceResponse;
import com.example.template.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {
    private static Logger log = LoggerFactory.getLogger(TemplateServiceImpl.class);


    @Override
    public ServiceResponse getBalance() {
        return ServiceResponse.resp(CodeType.SUCCESS, "pong");
    }
}
