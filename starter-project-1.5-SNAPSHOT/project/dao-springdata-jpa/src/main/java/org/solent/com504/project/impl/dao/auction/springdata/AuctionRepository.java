/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.auction.springdata;

import java.util.List;
import org.solent.com504.project.model.auction.dto.Auction;
import org.solent.com504.project.model.auction.dto.AuctionState;
import org.solent.com504.project.model.auction.dto.Lot;
import org.solent.com504.project.model.auction.dto.Bid;
import org.solent.com504.project.model.party.dto.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Kevin
 */
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    
    
    @Query("select a from Auction a LEFT JOIN FETCH a.auctions where a.auctionState = :auctionState")
    public List<Auction> findByState(@Param("auction_state") AuctionState auctionState);
    
    @Query("select a from Auction a LEFT JOIN FETCH a.auction")
    public List<Auction> findAll();
    
}