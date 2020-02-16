/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.websocket.test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
 
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
/**
 *
 * @author anton
 */
@ClientEndpoint
public class client356 {
   
    CountDownLatch latch = new CountDownLatch(1);
    private Session session;
 
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to server");
        this.session = session;
        latch.countDown();
    }
 
    @OnMessage
    public void onText(String message, Session session) {
        System.out.println("Message received from server:" + message);
    }
 
    @OnClose
    public void onClose(CloseReason reason, Session session) {
        System.out.println("Closing a WebSocket due to " + reason.getReasonPhrase());
    }
 
    public CountDownLatch getLatch() {
        return latch;
    }
 
    public void sendMessage(String str) {
        try {
            session.getBasicRemote().sendText(str);
        } catch (IOException e) {
 
            e.printStackTrace();
        }
    } 
}
