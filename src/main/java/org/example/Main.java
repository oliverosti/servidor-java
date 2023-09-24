package org.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static int port = 8080;

    public static void main(String[] args) {
        try {
            HttpServer servidor = HttpServer.create(new InetSocketAddress(port), 0);
            servidor.createContext("/", new Root());
            servidor.createContext("/stats", new Stats());
            servidor.start();
            System.out.println("Server running at port " + port);
            System.out.println("http://localhost:"+port);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}