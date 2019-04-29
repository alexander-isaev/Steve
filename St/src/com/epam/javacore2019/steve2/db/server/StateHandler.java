package com.epam.javacore2019.steve2.db.server;

import com.epam.javacore2019.steve2.db.server_old.DBApplication;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class StateHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String state = DBApplication.INSTANCE.getStateName();
        httpExchange.sendResponseHeaders(200, state.length());
        httpExchange.getRequestHeaders().put("Content-Type:", Arrays.asList(new String[] {"application/xml"}));
        OutputStream os = httpExchange.getResponseBody();
        os.write(state.getBytes());
        os.close();
    }
}
