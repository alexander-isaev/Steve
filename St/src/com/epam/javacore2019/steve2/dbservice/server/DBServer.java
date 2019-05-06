package com.epam.javacore2019.steve2.dbservice.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

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

        /*server.createContext("/dbservice/state", new HttpHandler() {
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

        server.createContext("dbservice/structure", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                System.out.println("Test");
            }
        });
        server.createContext("dbservice/state", new StateHandler());
        server.createContext("dbservice/query", new QueryHandler());

        server.start();
        String message = String.format("Server is running on port: %d", server.getAddress().getPort());
        System.out.println(message);
    }


}
