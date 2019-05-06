package com.epam.javacore2019.steve2.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class HtmlHandler implements HttpHandler {

    public static final String HTML_FORMAT = "^/pages/(([a-zA-Z]+\\.)(html))&";

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path = httpExchange.getRequestURI().getPath();
        String responce = "";
        if (path.matches(HTML_FORMAT)) {
            responce = path;
        } else {
            responce = "INVALID URL: " + path;
        }

        File file = new File("webclient" + path);
        responce += "\nFile Exists: " + file.exists();
        byte[] fileBytes = null;
        if (file.exists()) {
            fileBytes = Utils.readByte("webclient" + path);
        }

        httpExchange.getRequestHeaders().put("Context-Type", Arrays.asList(new String[]{"text/html"}));
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody();
        //os.write(("Html Handler " + responce).getBytes());
        if (fileBytes != null) {
            os.write(fileBytes);
        }
        os.close();

        // TODO: make css handler (?)... Green color.
    }
}
