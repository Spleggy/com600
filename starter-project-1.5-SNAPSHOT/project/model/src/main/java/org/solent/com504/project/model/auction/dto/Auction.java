/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.model.auction.dto;

import org.solent.com504.project.model.party.dto.Party;


import java.util.HashSet;
import java.util.List;
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
import org.solent.com504.project.model.user.dto.User;

/**
 *
 * @author Kevin
 */
public class Auction {
    private Long auction_id;
    private User auctioneer;
    private List<Party> buyers;
    private AuctionType auction_type;
    private List<Lot> lots;
    private String startTime;
    private String endTime;
    private String timePerLot;
    private AuctionState auctionState;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(Long auction_id) {
        this.auction_id = auction_id;
    }

    public User getAuctioneer() {
        return auctioneer;
    }

    public void setAuctioneer(User auctioneer) {
        this.auctioneer = auctioneer;
    }

    public List<Party> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Party> buyers) {
        this.buyers = buyers;
    }

    public AuctionType getAuction_type() {
        return auction_type;
    }

    public void setAuction_type(AuctionType auction_type) {
        this.auction_type = auction_type;
    }

    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTimePerLot() {
        return timePerLot;
    }

    public void setTimePerLot(String timePerLot) {
        this.timePerLot = timePerLot;
    }

    public AuctionState getAuctionState() {
        return auctionState;
    }

    public void setAuctionState(AuctionState auctionState) {
        this.auctionState = auctionState;
    }

   
    
    
    
}
