package com.example.template.service;

import com.example.template.common.ServiceResponse;
import org.springframework.stereotype.Service;

@Service
public interface TemplateService {
    ServiceResponse getBalance();
}
