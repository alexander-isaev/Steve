package com.epam.javacore2019.steve2.db.server;

import com.epam.javacore2019.steve2.db.server_old.DBApplication;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;

public enum DBServer {
    INSTANCE;

    public static final int PORT = 6701;

    /*public static final String BAD_HTML =
            "<html>" +
                    "<head></head>" +
                    "<body><div style=\"background-color: #AAAA00; width:100; height:100%; border: 1px solid black; color:white;\">({state})</body>" +
                    "</html>";
    */

    public void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);

        /*server.createContext("/db/state", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                String state = BAD_HTML.replace("({state})", DBApplication.INSTANCE.getStateName()); //DBApplication.INSTANCE.getStateName();
                //state = String.format(BAD_HTML, state);
                httpExchange.sendResponseHeaders(200, state.length());
                httpExchange.getRequestHeaders().put("Content-Type:", Arrays.asList(new String[] {"text/html"}));
                OutputStream os = httpExchange.getResponseBody();
                os.write(state.getBytes());
                os.close();
            }
        });*/

        server.createContext("db/structure", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                System.out.println("Test");
            }
        });
        server.createContext("db/state", new StateHandler());
        server.createContext("db/query", new QueryHandler());

        server.start();
        String message = String.format("Server is running on port: %d", server.getAddress().getPort());
        System.out.println(message);
    }


}
