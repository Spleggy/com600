/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.model.auction.dto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import org.solent.com504.project.model.user.dto.User;


/**
 *
 * @author anton
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@Entity
@Table(name = "auction")
public class Auction {
    private Long id;
    private AuctionState aucState;
    private User auctioner;
    
    @XmlElementWrapper(name = "lots")
    @XmlElement(name = "lot")
    private Set<Lot> lots = new HashSet<Lot>();
    private String startTime;
    private String endTime;
    private String timePerLot;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuctionState getAucState() {
        return aucState;
    }

    public void setAucState(AuctionState aucState) {
        this.aucState = aucState;
    }
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="user_id")
    public User getAuctioner() {
        return auctioner;
    }

    public void setAuctioner(User auctioner) {
        this.auctioner = auctioner;
    }
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "auc_lots", joinColumns = @JoinColumn(name = "auc_id"), inverseJoinColumns = @JoinColumn(name = "lot_id"))
    public Set<Lot> getLots() {
        return lots;
    }

    public void setLots(Set<Lot> lots) {
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


    
    
}
