package com.epam.javacore2019.steve2.webservice;

import com.epam.javacore2019.steve2.dbservice.server.QueryHandler;
import com.epam.javacore2019.steve2.dbservice.server.StateHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public enum WebClientApplication {
    INSTANCE;

    public static final int PORT = 6703;
    public static final String APP_NAME = "Web Client Service";

    public void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);
        server.createContext("/pages", new HtmlHandler());
        server.createContext("/css", new CssHandler());
        server.start();
        String message = String.format("%s is running on port: %d", APP_NAME, server.getAddress().getPort());
        System.out.println(message);

    }
}
