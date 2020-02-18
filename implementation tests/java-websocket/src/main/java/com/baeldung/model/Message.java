package com.baeldung.model;

public class Message {
    private String from;
    private String to;
    private String content;
    private String type;
    private String auc_name;
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuc_name() {
        return auc_name;
    }

    public void setAuc_name(String auc_name) {
        this.auc_name = auc_name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
