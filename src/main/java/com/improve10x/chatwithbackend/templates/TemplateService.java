package com.improve10x.chatwithbackend.templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TemplateService {
    @Autowired
    DbManager dbManager;

    public List<Template> getTemplates(){
        return dbManager.getTemplates();
    }
}
