package com.epam.javacore2019.steve2.db.server;

import com.epam.javacore2019.steve2.db.misc.Utils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class QueryHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "\nNEW REQUEST RECEIVED!";
        response += String.format("METHOD: %s", httpExchange.getRequestMethod());
        for (Map.Entry<String, List<String>> header : httpExchange.getRequestHeaders().entrySet()) {
            response += String.format("\n %s $s", header.getKey(), header.getValue());
        }
        InputStream is = httpExchange.getRequestBody();
        Utils.

    }
}
