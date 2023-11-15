package com.improve10x.chatwithbackend.templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemplateController {
    @Autowired
    TemplateService templateService;

    @GetMapping(value = "templates", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Template> getTemplates() {
        return templateService.getTemplates();
    }
}
