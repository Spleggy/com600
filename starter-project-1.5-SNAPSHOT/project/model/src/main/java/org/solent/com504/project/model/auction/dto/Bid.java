/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.model.auction.dto;

import org.solent.com504.project.model.party.dto.Party;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anton
 */
public class Bid {
    private Long bid_id;
    private Double amount;
    private Long lot_id;
    private Party buyer;
    private String bid_time;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getBid_id() {
        return bid_id;
    }

    public void setBid_id(Long bid_id) {
        this.bid_id = bid_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getLot_id() {
        return lot_id;
    }

    public void setLot_id(Long lot_id) {
        this.lot_id = lot_id;
    }
    //connection ManyToOne
    public Party getBuyer() {
        return buyer;
    }

    public void setBuyer(Party buyer) {
        this.buyer = buyer;
    }

    public String getBid_time() {
        return bid_time;
    }

    public void setBid_time(String bid_time) {
        this.bid_time = bid_time;
    }
    
    
    
}
