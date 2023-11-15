package com.improve10x.chatwithbackend.templates;

import com.improve10x.chatwithbackend.common.DatabaseManager;
import com.improve10x.chatwithbackend.templates.Template;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DbManager extends DatabaseManager {

    public List<Template> getTemplates() {
        try {
            ResultSet resultSet = runQuery("SELECT * FROM Template");
            List<Template> templates = convertToTemplate(resultSet);
            return templates;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private List<Template> convertToTemplate(ResultSet resultSet) throws SQLException {
        List<Template> templates = new ArrayList<>();
        while (resultSet.next()) {
            Template template = new Template();
            template.templateId = resultSet.getInt(1);
            template.name = resultSet.getString(2);
            template.messageText = resultSet.getString(3);
            templates.add(template);
        }
        return templates;
    }
}
