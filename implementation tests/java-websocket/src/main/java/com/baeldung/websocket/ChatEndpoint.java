package com.baeldung.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.baeldung.model.Message;
import com.baeldung.model.Auction;

@ServerEndpoint(value = "/chat/{username}", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class ChatEndpoint {

    private Session session;
    private Auction auction;
    private static final Set<ChatEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException, EncodeException {

        this.session = session;
        chatEndpoints.add(this);
        users.put(session.getId(), username);

        Message message = new Message();
        message.setFrom(username);
        message.setContent("Connected!");
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException, EncodeException {
        if(message.getType().equals("start")){
            if(message.getAuc_name().equals(auction.getName())){
                if(auction.getStatus().equals("planned")){
                    auction.setStatus("started");
                    Message msg1=new Message();
                    msg1.setFrom(users.get(session.getId()));
                    msg1.setContent("Auction "+auction.getName()+" have started. Minimum bid: "+auction.getHighestBid());
                    broadcast(msg1);
                }
            }
        }
        if(message.getType().equals("bid")){
            if(message.getAuc_name().equals(auction.getName())){
                double curBid= Double.parseDouble(message.getContent());
                if(curBid>auction.getHighestBid()){
                    auction.setHighestBid(curBid);
                    auction.setBidder(users.get(session.getId()));
                    Message msg1=new Message();
                    msg1.setFrom(users.get(session.getId()));
                    msg1.setContent("Auction "+auction.getName()+" has new highest bid: "+auction.getHighestBid());
                    broadcast(msg1);
                    
                }
            }
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        chatEndpoints.remove(this);
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("Disconnected!");
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    private static void broadcast(Message message) throws IOException, EncodeException {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote()
                            .sendObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (EncodeException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
