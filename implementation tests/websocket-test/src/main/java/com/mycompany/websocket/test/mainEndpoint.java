/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.websocket.test;
import java.net.URI;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
/**
 *
 * @author anton
 */
public class mainEndpoint {
    public static void main(String[] args) {
     
        try {
 
            String dest = "ws://localhost:8080/jsr356toUpper";
            client356 socket = new client356();
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(socket, new URI(dest));
 
            socket.getLatch().await();
            socket.sendMessage("echo356");
            socket.sendMessage("test356");
            Thread.sleep(10000l);
 
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
