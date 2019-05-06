package com.epam.javacore2019.steve2.webservice;

import java.util.Map;

public class Template {

    public String templateFileName; // html page
    public Map<String, String> values;

    public Template(String fileName, Map<String, String> values) {
        this.values = values;
        this.templateFileName = fileName;
    }

    public String compile() {
        String templateText = Utils.readFile(templateFileName); // Non existing method for now but it's the idea.
        for (String key : values.keySet()) {
            templateText = templateText.replace("({" + key + "})", values.get(key));
        }
        return templateText;
    }
    //values.put("fistName", "Vasya");
    //values.put("lastName", "Petrov");
}
