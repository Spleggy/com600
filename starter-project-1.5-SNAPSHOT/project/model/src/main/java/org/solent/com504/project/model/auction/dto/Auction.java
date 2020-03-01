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
import javax.persistence.ManyToMany;
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

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@Entity
public class Auction {
    private Long id;
    private String startTime;
    private String endTime;
    private String timePerLot;
    private AuctionState auctionState=AuctionState.PLANNING;
    private AuctionType auction_type=AuctionType.ENGLISH;
    
    @XmlElementWrapper(name = "parties")
    @XmlElement(name = "party")
    private List<Party> buyers;
    
    @XmlElementWrapper(name = "lots")
    @XmlElement(name = "lot")
    private List<Lot> lots;


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "auction_buyers", joinColumns = @JoinColumn(name = "auction_id"), inverseJoinColumns = @JoinColumn(name = "party_id"))
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
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "auction_lots", joinColumns = @JoinColumn(name = "auction_id"), inverseJoinColumns = @JoinColumn(name = "lot_id"))
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
