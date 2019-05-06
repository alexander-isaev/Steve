package com.epam.javacore2019.steve2.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class CssHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path = httpExchange.getRequestURI().getPath();
        String responce = "";

        File file = new File("webclient/static" + path);
        responce += "\nFile Exists: " + file.exists();
        byte[] fileBytes = null;
        if (file.exists()) {
            fileBytes = Utils.readByte("webclient/static" + path);
        }

        httpExchange.getRequestHeaders().put("Context-Type", Arrays.asList(new String[]{"text/css"}));
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody();
        os.write(("Html Handler " + responce).getBytes());
        if (fileBytes != null) {
            os.write(fileBytes);
        }
        os.close();
    }

}
